package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.litepal.crud.model.AssociationsInfo;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;
import org.litepal.util.LitePalLog;

public class Upgrader extends AssociationUpdater {
    private boolean hasConstraintChanged;
    protected TableModel mTableModel;
    protected TableModel mTableModelDB;

    private void addColumns(List<ColumnModel> list) {
        LitePalLog.d(AssociationUpdater.TAG, "do addColumn");
        execute(getAddColumnSQLs(list), this.mDb);
        for (ColumnModel addColumnModel : list) {
            this.mTableModelDB.addColumnModel(addColumnModel);
        }
    }

    private void changeColumnsConstraints() {
        if (this.hasConstraintChanged) {
            LitePalLog.d(AssociationUpdater.TAG, "do changeColumnsConstraints");
            execute(getChangeColumnsConstraintsSQL(), this.mDb);
        }
    }

    private void changeColumnsType(List<ColumnModel> list) {
        LitePalLog.d(AssociationUpdater.TAG, "do changeColumnsType");
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ColumnModel columnName : list) {
                arrayList.add(columnName.getColumnName());
            }
        }
        removeColumns(arrayList);
        addColumns(list);
    }

    private List<ColumnModel> findColumnTypesToChange() {
        ArrayList arrayList = new ArrayList();
        for (ColumnModel next : this.mTableModelDB.getColumnModels()) {
            for (ColumnModel next2 : this.mTableModel.getColumnModels()) {
                if (next.getColumnName().equalsIgnoreCase(next2.getColumnName())) {
                    if (!next.getColumnType().equalsIgnoreCase(next2.getColumnType()) && (!next2.getColumnType().equalsIgnoreCase("blob") || !TextUtils.isEmpty(next.getColumnType()))) {
                        arrayList.add(next2);
                    }
                    if (!this.hasConstraintChanged) {
                        LitePalLog.d(AssociationUpdater.TAG, "default value db is:" + next.getDefaultValue() + ", default value is:" + next2.getDefaultValue());
                        if (next.isNullable() != next2.isNullable() || !next.getDefaultValue().equalsIgnoreCase(next2.getDefaultValue()) || (next.isUnique() && !next2.isUnique())) {
                            this.hasConstraintChanged = true;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private List<ColumnModel> findColumnsToAdd() {
        ArrayList arrayList = new ArrayList();
        for (ColumnModel next : this.mTableModel.getColumnModels()) {
            if (!this.mTableModelDB.containsColumn(next.getColumnName())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private List<String> findColumnsToRemove() {
        String tableName = this.mTableModel.getTableName();
        ArrayList arrayList = new ArrayList();
        for (ColumnModel columnName : this.mTableModelDB.getColumnModels()) {
            String columnName2 = columnName.getColumnName();
            if (isNeedToRemove(columnName2)) {
                arrayList.add(columnName2);
            }
        }
        LitePalLog.d(AssociationUpdater.TAG, "remove columns from " + tableName + " >> " + arrayList);
        return arrayList;
    }

    private String generateAddColumnSQL(ColumnModel columnModel) {
        return generateAddColumnSQL(this.mTableModel.getTableName(), columnModel);
    }

    private List<String> generateAddForeignKeySQL() {
        ArrayList arrayList = new ArrayList();
        for (String next : getForeignKeyColumns(this.mTableModel)) {
            if (!this.mTableModel.containsColumn(next)) {
                ColumnModel columnModel = new ColumnModel();
                columnModel.setColumnName(next);
                columnModel.setColumnType("integer");
                arrayList.add(generateAddColumnSQL(this.mTableModel.getTableName(), columnModel));
            }
        }
        return arrayList;
    }

    private List<String> getAddColumnSQLs(List<ColumnModel> list) {
        ArrayList arrayList = new ArrayList();
        for (ColumnModel generateAddColumnSQL : list) {
            arrayList.add(generateAddColumnSQL(generateAddColumnSQL));
        }
        return arrayList;
    }

    private List<String> getChangeColumnsConstraintsSQL() {
        String generateAlterToTempTableSQL = generateAlterToTempTableSQL(this.mTableModel.getTableName());
        String generateCreateTableSQL = generateCreateTableSQL(this.mTableModel);
        List<String> generateAddForeignKeySQL = generateAddForeignKeySQL();
        String generateDataMigrationSQL = generateDataMigrationSQL(this.mTableModelDB);
        String generateDropTempTableSQL = generateDropTempTableSQL(this.mTableModel.getTableName());
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(generateAlterToTempTableSQL);
        arrayList.add(generateCreateTableSQL);
        arrayList.addAll(generateAddForeignKeySQL);
        arrayList.add(generateDataMigrationSQL);
        arrayList.add(generateDropTempTableSQL);
        LitePalLog.d(AssociationUpdater.TAG, "generateChangeConstraintSQL >> ");
        for (String d2 : arrayList) {
            LitePalLog.d(AssociationUpdater.TAG, d2);
        }
        LitePalLog.d(AssociationUpdater.TAG, "<< generateChangeConstraintSQL");
        return arrayList;
    }

    private boolean hasNewUniqueOrNotNullColumn() {
        for (ColumnModel next : this.mTableModel.getColumnModels()) {
            ColumnModel columnModelByName = this.mTableModelDB.getColumnModelByName(next.getColumnName());
            if (next.isUnique() && (columnModelByName == null || !columnModelByName.isUnique())) {
                return true;
            }
            if (columnModelByName != null && !next.isNullable() && columnModelByName.isNullable()) {
                return true;
            }
        }
        return false;
    }

    private boolean isNeedToRemove(String str) {
        return isRemovedFromClass(str) && !isIdColumn(str) && !isForeignKeyColumn(this.mTableModel, str);
    }

    private boolean isRemovedFromClass(String str) {
        return !this.mTableModel.containsColumn(str);
    }

    private void removeColumns(List<String> list) {
        LitePalLog.d(AssociationUpdater.TAG, "do removeColumns " + list);
        removeColumns(list, this.mTableModel.getTableName());
        for (String removeColumnModelByName : list) {
            this.mTableModelDB.removeColumnModelByName(removeColumnModelByName);
        }
    }

    private void upgradeTable() {
        if (hasNewUniqueOrNotNullColumn()) {
            createOrUpgradeTable(this.mTableModel, this.mDb, true);
            for (AssociationsInfo next : getAssociationInfo(this.mTableModel.getClassName())) {
                if ((next.getAssociationType() == 2 || next.getAssociationType() == 1) && next.getClassHoldsForeignKey().equalsIgnoreCase(this.mTableModel.getClassName())) {
                    addForeignKeyColumn(this.mTableModel.getTableName(), DBUtility.getTableNameByClassName(next.getAssociatedClassName()), this.mTableModel.getTableName(), this.mDb);
                }
            }
            return;
        }
        this.hasConstraintChanged = false;
        removeColumns(findColumnsToRemove());
        addColumns(findColumnsToAdd());
        changeColumnsType(findColumnTypesToChange());
        changeColumnsConstraints();
    }

    /* access modifiers changed from: protected */
    public void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z2) {
        this.mDb = sQLiteDatabase;
        for (TableModel next : getAllTableModels()) {
            this.mTableModel = next;
            this.mTableModelDB = getTableModelFromDB(next.getTableName());
            LitePalLog.d(AssociationUpdater.TAG, "createOrUpgradeTable: model is " + this.mTableModel.getTableName());
            upgradeTable();
        }
    }
}
