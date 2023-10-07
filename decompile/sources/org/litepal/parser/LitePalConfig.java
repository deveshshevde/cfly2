package org.litepal.parser;

import java.util.ArrayList;
import java.util.List;

public class LitePalConfig {
    private String cases;
    private List<String> classNames;
    private String dbName;
    private String storage;
    private int version;

    public void addClassName(String str) {
        getClassNames().add(str);
    }

    public String getCases() {
        return this.cases;
    }

    public List<String> getClassNames() {
        List list;
        List<String> list2 = this.classNames;
        if (list2 == null) {
            list = new ArrayList();
            this.classNames = list;
        } else {
            if (list2.isEmpty()) {
                list = this.classNames;
            }
            return this.classNames;
        }
        list.add("org.litepal.model.Table_Schema");
        return this.classNames;
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getStorage() {
        return this.storage;
    }

    public int getVersion() {
        return this.version;
    }

    public void setCases(String str) {
        this.cases = str;
    }

    public void setClassNames(List<String> list) {
        this.classNames = list;
    }

    public void setDbName(String str) {
        this.dbName = str;
    }

    public void setStorage(String str) {
        this.storage = str;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }
}
