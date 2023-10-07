package org.litepal.tablemanager;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.DBUtility;

class Creator extends AssociationCreator {
    public static final String TAG = "Creator";

    Creator() {
    }

    private String generateDropTableSQL(TableModel tableModel) {
        return generateDropTableSQL(tableModel.getTableName());
    }

    /* access modifiers changed from: protected */
    public void createOrUpgradeTable(SQLiteDatabase sQLiteDatabase, boolean z2) {
        for (TableModel createOrUpgradeTable : getAllTableModels()) {
            createOrUpgradeTable(createOrUpgradeTable, sQLiteDatabase, z2);
        }
    }

    /* access modifiers changed from: protected */
    public void createOrUpgradeTable(TableModel tableModel, SQLiteDatabase sQLiteDatabase, boolean z2) {
        execute(getCreateTableSQLs(tableModel, sQLiteDatabase, z2), sQLiteDatabase);
        giveTableSchemaACopy(tableModel.getTableName(), 0, sQLiteDatabase);
    }

    /* access modifiers changed from: package-private */
    public String generateCreateTableSQL(TableModel tableModel) {
        return generateCreateTableSQL(tableModel.getTableName(), tableModel.getColumnModels(), true);
    }

    /* access modifiers changed from: protected */
    public List<String> getCreateTableSQLs(TableModel tableModel, SQLiteDatabase sQLiteDatabase, boolean z2) {
        ArrayList arrayList = new ArrayList();
        if (z2) {
            arrayList.add(generateDropTableSQL(tableModel));
        } else if (DBUtility.isTableExists(tableModel.getTableName(), sQLiteDatabase)) {
            return null;
        }
        arrayList.add(generateCreateTableSQL(tableModel));
        return arrayList;
    }
}
