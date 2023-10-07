package org.litepal.crud;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.litepal.Operator;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.LitePalSupportException;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public class DeleteHandler extends DataHandler {
    private List<String> foreignKeyTableToDelete;

    public DeleteHandler(SQLiteDatabase sQLiteDatabase) {
        this.mDatabase = sQLiteDatabase;
    }

    private Collection<AssociationsInfo> analyzeAssociations(LitePalSupport litePalSupport) {
        try {
            Collection<AssociationsInfo> associationInfo = getAssociationInfo(litePalSupport.getClassName());
            analyzeAssociatedModels(litePalSupport, associationInfo);
            return associationInfo;
        } catch (Exception e2) {
            throw new LitePalSupportException(e2.getMessage(), e2);
        }
    }

    private void analyzeAssociations(Class<?> cls) {
        for (AssociationsInfo next : getAssociationInfo(cls.getName())) {
            String tableNameByClassName = DBUtility.getTableNameByClassName(next.getAssociatedClassName());
            if (next.getAssociationType() == 2 || next.getAssociationType() == 1) {
                if (!cls.getName().equals(next.getClassHoldsForeignKey())) {
                    getForeignKeyTableToDelete().add(tableNameByClassName);
                }
            } else if (next.getAssociationType() == 3) {
                getForeignKeyTableToDelete().add(BaseUtility.changeCase(DBUtility.getIntermediateTableName(getTableName(cls), tableNameByClassName)));
            }
        }
    }

    private String buildConditionString(String... strArr) {
        int length = strArr.length - 1;
        int i2 = 0;
        String str = strArr[0];
        while (i2 < length) {
            StringBuilder sb = new StringBuilder();
            sb.append("'");
            i2++;
            sb.append(strArr[i2]);
            sb.append("'");
            str = str.replaceFirst("\\?", sb.toString());
        }
        return str;
    }

    private void clearAssociatedModelSaveState(LitePalSupport litePalSupport, Collection<AssociationsInfo> collection) {
        LitePalSupport associatedModel;
        try {
            for (AssociationsInfo next : collection) {
                if (next.getAssociationType() == 2 && !litePalSupport.getClassName().equals(next.getClassHoldsForeignKey())) {
                    Collection<LitePalSupport> associatedModels = getAssociatedModels(litePalSupport, next);
                    if (associatedModels != null && !associatedModels.isEmpty()) {
                        for (LitePalSupport next2 : associatedModels) {
                            if (next2 != null) {
                                next2.clearSavedState();
                            }
                        }
                    }
                } else if (next.getAssociationType() == 1 && (associatedModel = getAssociatedModel(litePalSupport, next)) != null) {
                    associatedModel.clearSavedState();
                }
            }
        } catch (Exception e2) {
            throw new LitePalSupportException(e2.getMessage(), e2);
        }
    }

    private int deleteAllCascade(Class<?> cls, String... strArr) {
        int i2 = 0;
        for (String next : getForeignKeyTableToDelete()) {
            String tableName = getTableName(cls);
            String foreignKeyColumnName = getForeignKeyColumnName(tableName);
            StringBuilder sb = new StringBuilder();
            sb.append(foreignKeyColumnName);
            sb.append(" in (select id from ");
            sb.append(tableName);
            if (strArr != null && strArr.length > 0) {
                sb.append(" where ");
                sb.append(buildConditionString(strArr));
            }
            sb.append(")");
            i2 += this.mDatabase.delete(next, BaseUtility.changeCase(sb.toString()), (String[]) null);
        }
        return i2;
    }

    private int deleteAssociatedForeignKeyRows(LitePalSupport litePalSupport) {
        int i2 = 0;
        for (String delete : litePalSupport.getAssociatedModelsMapWithFK().keySet()) {
            String foreignKeyColumnName = getForeignKeyColumnName(litePalSupport.getTableName());
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            i2 += sQLiteDatabase.delete(delete, foreignKeyColumnName + " = " + litePalSupport.getBaseObjId(), (String[]) null);
        }
        return i2;
    }

    private int deleteAssociatedJoinTableRows(LitePalSupport litePalSupport) {
        int i2 = 0;
        for (String intermediateTableName : litePalSupport.getAssociatedModelsMapForJoinTable().keySet()) {
            String intermediateTableName2 = DBUtility.getIntermediateTableName(litePalSupport.getTableName(), intermediateTableName);
            String foreignKeyColumnName = getForeignKeyColumnName(litePalSupport.getTableName());
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            i2 += sQLiteDatabase.delete(intermediateTableName2, foreignKeyColumnName + " = " + litePalSupport.getBaseObjId(), (String[]) null);
        }
        return i2;
    }

    private int deleteCascade(Class<?> cls, long j2) {
        int i2 = 0;
        for (String delete : getForeignKeyTableToDelete()) {
            String foreignKeyColumnName = getForeignKeyColumnName(getTableName(cls));
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            i2 += sQLiteDatabase.delete(delete, foreignKeyColumnName + " = " + j2, (String[]) null);
        }
        return i2;
    }

    private int deleteCascade(LitePalSupport litePalSupport) {
        return deleteAssociatedForeignKeyRows(litePalSupport) + deleteAssociatedJoinTableRows(litePalSupport);
    }

    private void deleteGenericData(Class<?> cls, List<Field> list, long... jArr) {
        int i2;
        for (Field name : list) {
            String genericTableName = DBUtility.getGenericTableName(cls.getName(), name.getName());
            String genericValueIdColumnName = DBUtility.getGenericValueIdColumnName(cls.getName());
            int length = jArr.length;
            int i3 = (length - 1) / 500;
            int i4 = 0;
            while (i4 <= i3) {
                StringBuilder sb = new StringBuilder();
                int i5 = 500 * i4;
                boolean z2 = false;
                while (true) {
                    i2 = i4 + 1;
                    if (i5 < 500 * i2 && i5 < length) {
                        long j2 = jArr[i5];
                        if (z2) {
                            sb.append(" or ");
                        }
                        sb.append(genericValueIdColumnName);
                        sb.append(" = ");
                        sb.append(j2);
                        i5++;
                        z2 = true;
                    }
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    this.mDatabase.delete(genericTableName, sb.toString(), (String[]) null);
                }
                i4 = i2;
            }
        }
    }

    private List<String> getForeignKeyTableToDelete() {
        if (this.foreignKeyTableToDelete == null) {
            this.foreignKeyTableToDelete = new ArrayList();
        }
        return this.foreignKeyTableToDelete;
    }

    public int onDelete(Class<?> cls, long j2) {
        deleteGenericData(cls, getSupportedGenericFields(cls.getName()), j2);
        analyzeAssociations(cls);
        int deleteCascade = deleteCascade(cls, j2);
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        String tableName = getTableName(cls);
        int delete = deleteCascade + sQLiteDatabase.delete(tableName, "id = " + j2, (String[]) null);
        getForeignKeyTableToDelete().clear();
        return delete;
    }

    /* access modifiers changed from: package-private */
    public int onDelete(LitePalSupport litePalSupport) {
        if (!litePalSupport.isSaved()) {
            return 0;
        }
        List<Field> supportedGenericFields = getSupportedGenericFields(litePalSupport.getClassName());
        deleteGenericData(litePalSupport.getClass(), supportedGenericFields, litePalSupport.getBaseObjId());
        Collection<AssociationsInfo> analyzeAssociations = analyzeAssociations(litePalSupport);
        int deleteCascade = deleteCascade(litePalSupport);
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        String tableName = litePalSupport.getTableName();
        int delete = deleteCascade + sQLiteDatabase.delete(tableName, "id = " + litePalSupport.getBaseObjId(), (String[]) null);
        clearAssociatedModelSaveState(litePalSupport, analyzeAssociations);
        return delete;
    }

    public int onDeleteAll(Class<?> cls, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        List<Field> supportedGenericFields = getSupportedGenericFields(cls.getName());
        if (!supportedGenericFields.isEmpty()) {
            List<?> find = Operator.select("id").where(strArr).find(cls);
            if (find.size() > 0) {
                int size = find.size();
                long[] jArr = new long[size];
                for (int i2 = 0; i2 < size; i2++) {
                    jArr[i2] = ((LitePalSupport) find.get(i2)).getBaseObjId();
                }
                deleteGenericData(cls, supportedGenericFields, jArr);
            }
        }
        analyzeAssociations(cls);
        int deleteAllCascade = deleteAllCascade(cls, strArr) + this.mDatabase.delete(getTableName(cls), getWhereClause(strArr), getWhereArgs(strArr));
        getForeignKeyTableToDelete().clear();
        return deleteAllCascade;
    }

    public int onDeleteAll(String str, String... strArr) {
        BaseUtility.checkConditionsCorrect(strArr);
        if (strArr != null && strArr.length > 0) {
            strArr[0] = DBUtility.convertWhereClauseToColumnName(strArr[0]);
        }
        return this.mDatabase.delete(str, getWhereClause(strArr), getWhereArgs(strArr));
    }
}
