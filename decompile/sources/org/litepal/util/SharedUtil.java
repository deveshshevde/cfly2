package org.litepal.util;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.litepal.LitePalApplication;
import org.litepal.util.Const;

public class SharedUtil {
    private static final String LITEPAL_PREPS = "litepal_prefs";
    private static final String VERSION = "litepal_version";

    public static int getLastVersion(String str) {
        String str2;
        SharedPreferences sharedPreferences = LitePalApplication.getContext().getSharedPreferences(LITEPAL_PREPS, 0);
        if (TextUtils.isEmpty(str)) {
            str2 = VERSION;
        } else {
            if (str.endsWith(Const.Config.DB_NAME_SUFFIX)) {
                str = str.replace(Const.Config.DB_NAME_SUFFIX, "");
            }
            str2 = "litepal_version_" + str;
        }
        return sharedPreferences.getInt(str2, 0);
    }

    public static void removeVersion(String str) {
        String str2;
        SharedPreferences.Editor edit = LitePalApplication.getContext().getSharedPreferences(LITEPAL_PREPS, 0).edit();
        if (TextUtils.isEmpty(str)) {
            str2 = VERSION;
        } else {
            if (str.endsWith(Const.Config.DB_NAME_SUFFIX)) {
                str = str.replace(Const.Config.DB_NAME_SUFFIX, "");
            }
            str2 = "litepal_version_" + str;
        }
        edit.remove(str2);
        edit.apply();
    }

    public static void updateVersion(String str, int i2) {
        String str2;
        SharedPreferences.Editor edit = LitePalApplication.getContext().getSharedPreferences(LITEPAL_PREPS, 0).edit();
        if (TextUtils.isEmpty(str)) {
            str2 = VERSION;
        } else {
            if (str.endsWith(Const.Config.DB_NAME_SUFFIX)) {
                str = str.replace(Const.Config.DB_NAME_SUFFIX, "");
            }
            str2 = "litepal_version_" + str;
        }
        edit.putInt(str2, i2);
        edit.apply();
    }
}
