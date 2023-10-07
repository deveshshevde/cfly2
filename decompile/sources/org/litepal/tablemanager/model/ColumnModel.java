package org.litepal.tablemanager.model;

import android.text.TextUtils;

public class ColumnModel {
    private String columnName;
    private String columnType;
    private String defaultValue = "";
    private boolean isNullable = true;
    private boolean isUnique = false;

    public String getColumnName() {
        return this.columnName;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public boolean isIdColumn() {
        return "_id".equalsIgnoreCase(this.columnName) || "id".equalsIgnoreCase(this.columnName);
    }

    public boolean isNullable() {
        return this.isNullable;
    }

    public boolean isUnique() {
        return this.isUnique;
    }

    public void setColumnName(String str) {
        this.columnName = str;
    }

    public void setColumnType(String str) {
        this.columnType = str;
    }

    public void setDefaultValue(String str) {
        if ("text".equalsIgnoreCase(this.columnType)) {
            if (!TextUtils.isEmpty(str)) {
                str = "'" + str + "'";
            } else {
                return;
            }
        }
        this.defaultValue = str;
    }

    public void setNullable(boolean z2) {
        this.isNullable = z2;
    }

    public void setUnique(boolean z2) {
        this.isUnique = z2;
    }
}
