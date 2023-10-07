package org.litepal;

import java.util.ArrayList;
import java.util.List;
import org.litepal.parser.LitePalConfig;
import org.litepal.parser.LitePalParser;

public class LitePalDB {
    private List<String> classNames;
    private String dbName;
    private boolean isExternalStorage = false;
    private String storage;
    private int version;

    public LitePalDB(String str, int i2) {
        this.dbName = str;
        this.version = i2;
    }

    public static LitePalDB fromDefault(String str) {
        LitePalConfig parseLitePalConfiguration = LitePalParser.parseLitePalConfiguration();
        LitePalDB litePalDB = new LitePalDB(str, parseLitePalConfiguration.getVersion());
        litePalDB.setStorage(parseLitePalConfiguration.getStorage());
        litePalDB.setClassNames(parseLitePalConfiguration.getClassNames());
        return litePalDB;
    }

    public void addClassName(String str) {
        getClassNames().add(str);
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

    public boolean isExternalStorage() {
        return this.isExternalStorage;
    }

    /* access modifiers changed from: package-private */
    public void setClassNames(List<String> list) {
        this.classNames = list;
    }

    public void setExternalStorage(boolean z2) {
        this.isExternalStorage = z2;
    }

    public void setStorage(String str) {
        this.storage = str;
    }
}
