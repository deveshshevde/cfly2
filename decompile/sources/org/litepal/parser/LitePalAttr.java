package org.litepal.parser;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.litepal.exceptions.InvalidAttributesException;
import org.litepal.util.BaseUtility;
import org.litepal.util.Const;
import org.litepal.util.SharedUtil;

public final class LitePalAttr {
    private static LitePalAttr litePalAttr;
    private String cases;
    private List<String> classNames;
    private String dbName;
    private String extraKeyName;
    private String storage;
    private int version;

    private LitePalAttr() {
    }

    public static void clearInstance() {
        litePalAttr = null;
    }

    public static LitePalAttr getInstance() {
        if (litePalAttr == null) {
            synchronized (LitePalAttr.class) {
                if (litePalAttr == null) {
                    litePalAttr = new LitePalAttr();
                    loadLitePalXMLConfiguration();
                }
            }
        }
        return litePalAttr;
    }

    private static void loadLitePalXMLConfiguration() {
        if (BaseUtility.isLitePalXMLExists()) {
            LitePalConfig parseLitePalConfiguration = LitePalParser.parseLitePalConfiguration();
            litePalAttr.setDbName(parseLitePalConfiguration.getDbName());
            litePalAttr.setVersion(parseLitePalConfiguration.getVersion());
            litePalAttr.setClassNames(parseLitePalConfiguration.getClassNames());
            litePalAttr.setCases(parseLitePalConfiguration.getCases());
            litePalAttr.setStorage(parseLitePalConfiguration.getStorage());
        }
    }

    public void addClassName(String str) {
        getClassNames().add(str);
    }

    public void checkSelfValid() {
        if (TextUtils.isEmpty(this.dbName)) {
            loadLitePalXMLConfiguration();
            if (TextUtils.isEmpty(this.dbName)) {
                throw new InvalidAttributesException(InvalidAttributesException.DBNAME_IS_EMPTY_OR_NOT_DEFINED);
            }
        }
        if (!this.dbName.endsWith(Const.Config.DB_NAME_SUFFIX)) {
            this.dbName += Const.Config.DB_NAME_SUFFIX;
        }
        int i2 = this.version;
        if (i2 < 1) {
            throw new InvalidAttributesException(InvalidAttributesException.VERSION_OF_DATABASE_LESS_THAN_ONE);
        } else if (i2 < SharedUtil.getLastVersion(this.extraKeyName)) {
            throw new InvalidAttributesException(InvalidAttributesException.VERSION_IS_EARLIER_THAN_CURRENT);
        } else if (TextUtils.isEmpty(this.cases)) {
            this.cases = Const.Config.CASES_LOWER;
        } else if (!this.cases.equals(Const.Config.CASES_UPPER) && !this.cases.equals(Const.Config.CASES_LOWER) && !this.cases.equals(Const.Config.CASES_KEEP)) {
            throw new InvalidAttributesException(this.cases + InvalidAttributesException.CASES_VALUE_IS_INVALID);
        }
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

    public String getExtraKeyName() {
        return this.extraKeyName;
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

    public void setExtraKeyName(String str) {
        this.extraKeyName = str;
    }

    public void setStorage(String str) {
        this.storage = str;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }
}
