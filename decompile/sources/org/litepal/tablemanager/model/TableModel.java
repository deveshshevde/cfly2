package org.litepal.tablemanager.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class TableModel {
    private String className;
    private List<ColumnModel> columnModels = new ArrayList();
    private String tableName;

    public void addColumnModel(ColumnModel columnModel) {
        this.columnModels.add(columnModel);
    }

    public boolean containsColumn(String str) {
        for (int i2 = 0; i2 < this.columnModels.size(); i2++) {
            if (str.equalsIgnoreCase(this.columnModels.get(i2).getColumnName())) {
                return true;
            }
        }
        return false;
    }

    public String getClassName() {
        return this.className;
    }

    public ColumnModel getColumnModelByName(String str) {
        for (ColumnModel next : this.columnModels) {
            if (next.getColumnName().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public List<ColumnModel> getColumnModels() {
        return this.columnModels;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void removeColumnModelByName(String str) {
        if (!TextUtils.isEmpty(str)) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.columnModels.size()) {
                    i2 = -1;
                    break;
                } else if (str.equalsIgnoreCase(this.columnModels.get(i2).getColumnName())) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.columnModels.remove(i2);
            }
        }
    }

    public void setClassName(String str) {
        this.className = str;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }
}
