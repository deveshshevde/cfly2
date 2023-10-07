package org.litepal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.parser.LitePalAttr;
import org.litepal.tablemanager.model.AssociationsModel;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.GenericModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.tablemanager.typechange.BlobOrm;
import org.litepal.tablemanager.typechange.BooleanOrm;
import org.litepal.tablemanager.typechange.DateOrm;
import org.litepal.tablemanager.typechange.DecimalOrm;
import org.litepal.tablemanager.typechange.NumericOrm;
import org.litepal.tablemanager.typechange.OrmChange;
import org.litepal.tablemanager.typechange.TextOrm;
import org.litepal.util.BaseUtility;
import org.litepal.util.DBUtility;

public abstract class LitePalBase {
    private static final int GET_ASSOCIATIONS_ACTION = 1;
    private static final int GET_ASSOCIATION_INFO_ACTION = 2;
    public static final String TAG = "LitePalBase";
    private Map<String, List<Field>> classFieldsMap = new HashMap();
    private Map<String, List<Field>> classGenericFieldsMap = new HashMap();
    private Collection<AssociationsInfo> mAssociationInfos;
    private Collection<AssociationsModel> mAssociationModels;
    private Collection<GenericModel> mGenericModels;
    private OrmChange[] typeChangeRules = {new NumericOrm(), new TextOrm(), new BooleanOrm(), new DecimalOrm(), new DateOrm(), new BlobOrm()};

    private void addIntoAssociationInfoCollection(String str, String str2, String str3, Field field, Field field2, int i2) {
        AssociationsInfo associationsInfo = new AssociationsInfo();
        associationsInfo.setSelfClassName(str);
        associationsInfo.setAssociatedClassName(str2);
        associationsInfo.setClassHoldsForeignKey(str3);
        associationsInfo.setAssociateOtherModelFromSelf(field);
        associationsInfo.setAssociateSelfFromOtherModel(field2);
        associationsInfo.setAssociationType(i2);
        this.mAssociationInfos.add(associationsInfo);
    }

    private void addIntoAssociationModelCollection(String str, String str2, String str3, int i2) {
        AssociationsModel associationsModel = new AssociationsModel();
        associationsModel.setTableName(DBUtility.getTableNameByClassName(str));
        associationsModel.setAssociatedTableName(DBUtility.getTableNameByClassName(str2));
        associationsModel.setTableHoldsForeignKey(DBUtility.getTableNameByClassName(str3));
        associationsModel.setAssociationType(i2);
        this.mAssociationModels.add(associationsModel);
    }

    private void analyzeClassFields(String str, int i2) {
        try {
            for (Field field : Class.forName(str).getDeclaredFields()) {
                if (isNonPrimitive(field)) {
                    Column column = (Column) field.getAnnotation(Column.class);
                    if (column == null || !column.ignore()) {
                        oneToAnyConditions(str, field, i2);
                        manyToAnyConditions(str, field, i2);
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + str);
        }
    }

    private ColumnModel convertFieldToColumnModel(Field field) {
        boolean z2;
        boolean z3;
        String str;
        String columnType = getColumnType(field.getType().getName());
        Column column = (Column) field.getAnnotation(Column.class);
        if (column != null) {
            z3 = column.nullable();
            z2 = column.unique();
            str = column.defaultValue();
        } else {
            z3 = true;
            z2 = false;
            str = "";
        }
        ColumnModel columnModel = new ColumnModel();
        columnModel.setColumnName(DBUtility.convertToValidColumnName(field.getName()));
        columnModel.setColumnType(columnType);
        columnModel.setNullable(z3);
        columnModel.setUnique(z2);
        columnModel.setDefaultValue(str);
        return columnModel;
    }

    private boolean isNonPrimitive(Field field) {
        return !field.getType().isPrimitive();
    }

    private boolean isPrivate(Field field) {
        return Modifier.isPrivate(field.getModifiers());
    }

    private void manyToAnyConditions(String str, Field field, int i2) throws ClassNotFoundException {
        String str2;
        int i3;
        LitePalBase litePalBase;
        String str3;
        String str4;
        if (isCollection(field.getType())) {
            String genericTypeName = getGenericTypeName(field);
            if (LitePalAttr.getInstance().getClassNames().contains(genericTypeName)) {
                boolean z2 = false;
                for (Field field2 : Class.forName(genericTypeName).getDeclaredFields()) {
                    if (!Modifier.isStatic(field2.getModifiers())) {
                        Class<?> type = field2.getType();
                        if (str.equals(type.getName())) {
                            if (i2 == 1) {
                                addIntoAssociationModelCollection(str, genericTypeName, genericTypeName, 2);
                            } else if (i2 == 2) {
                                i3 = 2;
                                litePalBase = this;
                                str3 = str;
                                str4 = genericTypeName;
                                str2 = genericTypeName;
                            }
                            z2 = true;
                        } else if (isCollection(type) && str.equals(getGenericTypeName(field2))) {
                            if (i2 == 1) {
                                if (str.equalsIgnoreCase(genericTypeName)) {
                                    GenericModel genericModel = new GenericModel();
                                    genericModel.setTableName(DBUtility.getGenericTableName(str, field.getName()));
                                    genericModel.setValueColumnName(DBUtility.getM2MSelfRefColumnName(field));
                                    genericModel.setValueColumnType("integer");
                                    genericModel.setValueIdColumnName(DBUtility.getGenericValueIdColumnName(str));
                                    this.mGenericModels.add(genericModel);
                                } else {
                                    addIntoAssociationModelCollection(str, genericTypeName, (String) null, 3);
                                }
                            } else if (i2 == 2 && !str.equalsIgnoreCase(genericTypeName)) {
                                str2 = null;
                                i3 = 3;
                                litePalBase = this;
                                str3 = str;
                                str4 = genericTypeName;
                            }
                            z2 = true;
                        }
                        litePalBase.addIntoAssociationInfoCollection(str3, str4, str2, field, field2, i3);
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (i2 == 1) {
                    addIntoAssociationModelCollection(str, genericTypeName, genericTypeName, 2);
                } else if (i2 == 2) {
                    addIntoAssociationInfoCollection(str, genericTypeName, genericTypeName, field, (Field) null, 2);
                }
            } else if (BaseUtility.isGenericTypeSupported(genericTypeName) && i2 == 1) {
                GenericModel genericModel2 = new GenericModel();
                genericModel2.setTableName(DBUtility.getGenericTableName(str, field.getName()));
                genericModel2.setValueColumnName(DBUtility.convertToValidColumnName(field.getName()));
                genericModel2.setValueColumnType(getColumnType(genericTypeName));
                genericModel2.setValueIdColumnName(DBUtility.getGenericValueIdColumnName(str));
                this.mGenericModels.add(genericModel2);
            }
        }
    }

    private void oneToAnyConditions(String str, Field field, int i2) throws ClassNotFoundException {
        String name;
        int i3;
        LitePalBase litePalBase;
        String str2;
        String str3;
        String str4 = str;
        int i4 = i2;
        Class<?> type = field.getType();
        if (LitePalAttr.getInstance().getClassNames().contains(type.getName())) {
            boolean z2 = false;
            for (Field field2 : Class.forName(type.getName()).getDeclaredFields()) {
                if (!Modifier.isStatic(field2.getModifiers())) {
                    Class<?> type2 = field2.getType();
                    if (str4.equals(type2.getName())) {
                        if (i4 == 1) {
                            addIntoAssociationModelCollection(str4, type.getName(), type.getName(), 1);
                        } else if (i4 == 2) {
                            name = type.getName();
                            str3 = type.getName();
                            i3 = 1;
                            litePalBase = this;
                            str2 = str;
                        }
                        z2 = true;
                    } else if (isCollection(type2) && str4.equals(getGenericTypeName(field2))) {
                        if (i4 == 1) {
                            addIntoAssociationModelCollection(str4, type.getName(), str4, 2);
                        } else if (i4 == 2) {
                            name = type.getName();
                            i3 = 2;
                            litePalBase = this;
                            str2 = str;
                            str3 = str;
                        }
                        z2 = true;
                    }
                    litePalBase.addIntoAssociationInfoCollection(str2, name, str3, field, field2, i3);
                    z2 = true;
                }
            }
            if (z2) {
                return;
            }
            if (i4 == 1) {
                addIntoAssociationModelCollection(str4, type.getName(), type.getName(), 1);
            } else if (i4 == 2) {
                addIntoAssociationInfoCollection(str, type.getName(), type.getName(), field, (Field) null, 1);
            }
        }
    }

    private void recursiveSupportedFields(Class<?> cls, List<Field> list) {
        if (cls != LitePalSupport.class && cls != Object.class) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    Column column = (Column) field.getAnnotation(Column.class);
                    if ((column == null || !column.ignore()) && !Modifier.isStatic(field.getModifiers()) && BaseUtility.isFieldTypeSupported(field.getType().getName())) {
                        list.add(field);
                    }
                }
            }
            recursiveSupportedFields(cls.getSuperclass(), list);
        }
    }

    private void recursiveSupportedGenericFields(Class<?> cls, List<Field> list) {
        if (cls != LitePalSupport.class && cls != Object.class) {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields != null && declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    Column column = (Column) field.getAnnotation(Column.class);
                    if ((column == null || !column.ignore()) && !Modifier.isStatic(field.getModifiers()) && isCollection(field.getType())) {
                        String genericTypeName = getGenericTypeName(field);
                        if (BaseUtility.isGenericTypeSupported(genericTypeName) || cls.getName().equalsIgnoreCase(genericTypeName)) {
                            list.add(field);
                        }
                    }
                }
            }
            recursiveSupportedGenericFields(cls.getSuperclass(), list);
        }
    }

    /* access modifiers changed from: protected */
    public Collection<AssociationsInfo> getAssociationInfo(String str) {
        if (this.mAssociationInfos == null) {
            this.mAssociationInfos = new HashSet();
        }
        this.mAssociationInfos.clear();
        analyzeClassFields(str, 2);
        return this.mAssociationInfos;
    }

    /* access modifiers changed from: protected */
    public Collection<AssociationsModel> getAssociations(List<String> list) {
        if (this.mAssociationModels == null) {
            this.mAssociationModels = new HashSet();
        }
        if (this.mGenericModels == null) {
            this.mGenericModels = new HashSet();
        }
        this.mAssociationModels.clear();
        this.mGenericModels.clear();
        for (String analyzeClassFields : list) {
            analyzeClassFields(analyzeClassFields, 1);
        }
        return this.mAssociationModels;
    }

    /* access modifiers changed from: protected */
    public String getColumnType(String str) {
        for (OrmChange object2Relation : this.typeChangeRules) {
            String object2Relation2 = object2Relation.object2Relation(str);
            if (object2Relation2 != null) {
                return object2Relation2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public String getForeignKeyColumnName(String str) {
        return BaseUtility.changeCase(str + "_id");
    }

    /* access modifiers changed from: protected */
    public Collection<GenericModel> getGenericModels() {
        return this.mGenericModels;
    }

    /* access modifiers changed from: protected */
    public Class<?> getGenericTypeClass(Field field) {
        Type genericType = field.getGenericType();
        if (genericType == null || !(genericType instanceof ParameterizedType)) {
            return null;
        }
        return (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
    }

    /* access modifiers changed from: protected */
    public String getGenericTypeName(Field field) {
        Class<?> genericTypeClass = getGenericTypeClass(field);
        if (genericTypeClass != null) {
            return genericTypeClass.getName();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public List<Field> getSupportedFields(String str) {
        List<Field> list = this.classFieldsMap.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        try {
            recursiveSupportedFields(Class.forName(str), arrayList);
            this.classFieldsMap.put(str, arrayList);
            return arrayList;
        } catch (ClassNotFoundException unused) {
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + str);
        }
    }

    /* access modifiers changed from: protected */
    public List<Field> getSupportedGenericFields(String str) {
        List<Field> list = this.classGenericFieldsMap.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        try {
            recursiveSupportedGenericFields(Class.forName(str), arrayList);
            this.classGenericFieldsMap.put(str, arrayList);
            return arrayList;
        } catch (ClassNotFoundException unused) {
            throw new DatabaseGenerateException(DatabaseGenerateException.CLASS_NOT_FOUND + str);
        }
    }

    /* access modifiers changed from: protected */
    public TableModel getTableModel(String str) {
        String tableNameByClassName = DBUtility.getTableNameByClassName(str);
        TableModel tableModel = new TableModel();
        tableModel.setTableName(tableNameByClassName);
        tableModel.setClassName(str);
        for (Field convertFieldToColumnModel : getSupportedFields(str)) {
            tableModel.addColumnModel(convertFieldToColumnModel(convertFieldToColumnModel));
        }
        return tableModel;
    }

    /* access modifiers changed from: protected */
    public boolean isCollection(Class<?> cls) {
        return isList(cls) || isSet(cls);
    }

    /* access modifiers changed from: protected */
    public boolean isIdColumn(String str) {
        return "_id".equalsIgnoreCase(str) || "id".equalsIgnoreCase(str);
    }

    /* access modifiers changed from: protected */
    public boolean isList(Class<?> cls) {
        return List.class.isAssignableFrom(cls);
    }

    /* access modifiers changed from: protected */
    public boolean isSet(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
