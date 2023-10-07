package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.blankj.utilcode.util.Utils;
import java.util.Locale;
import java.util.Objects;

public class LanguageUtils {
    private static final String KEY_LOCALE = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private LanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    static void applyLanguage(Activity activity) {
        String string = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
        if (!TextUtils.isEmpty(string)) {
            Locale local = VALUE_FOLLOW_SYSTEM.equals(string) ? getLocal(Resources.getSystem().getConfiguration()) : string2Locale(string);
            if (local != null) {
                updateConfiguration(activity, local);
                updateConfiguration(Utils.getApp(), local);
            }
        }
    }

    public static void applyLanguage(Locale locale) {
        Objects.requireNonNull(locale, "Argument 'locale' of type Locale (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        applyLanguage(locale, false);
    }

    public static void applyLanguage(Locale locale, boolean z2) {
        Objects.requireNonNull(locale, "Argument 'locale' of type Locale (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        applyLanguageReal(locale, z2);
    }

    private static void applyLanguageReal(Locale locale, final boolean z2) {
        UtilsBridge.getSpUtils4Utils().put(KEY_LOCALE, locale == null ? VALUE_FOLLOW_SYSTEM : locale2String(locale), true);
        if (locale == null) {
            locale = getLocal(Resources.getSystem().getConfiguration());
        }
        updateAppContextLanguage(locale, new Utils.Consumer<Boolean>() {
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    LanguageUtils.restart(z2);
                } else {
                    UtilsBridge.relaunchApp();
                }
            }
        });
    }

    public static void applySystemLanguage() {
        applySystemLanguage(false);
    }

    public static void applySystemLanguage(boolean z2) {
        applyLanguageReal((Locale) null, z2);
    }

    public static Context attachBaseContext(Context context) {
        Locale string2Locale;
        String string = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
        if (TextUtils.isEmpty(string) || VALUE_FOLLOW_SYSTEM.equals(string) || (string2Locale = string2Locale(string)) == null) {
            return context;
        }
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        setLocal(configuration, string2Locale);
        if (Build.VERSION.SDK_INT >= 17) {
            return context.createConfigurationContext(configuration);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }

    public static Locale getAppContextLanguage() {
        return getContextLanguage(Utils.getApp());
    }

    public static Locale getAppliedLanguage() {
        String string = UtilsBridge.getSpUtils4Utils().getString(KEY_LOCALE);
        if (TextUtils.isEmpty(string) || VALUE_FOLLOW_SYSTEM.equals(string)) {
            return null;
        }
        return string2Locale(string);
    }

    public static Locale getContextLanguage(Context context) {
        return getLocal(context.getResources().getConfiguration());
    }

    private static Locale getLocal(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
    }

    public static Locale getSystemLanguage() {
        return getLocal(Resources.getSystem().getConfiguration());
    }

    public static boolean isAppliedLanguage() {
        return getAppliedLanguage() != null;
    }

    public static boolean isAppliedLanguage(Locale locale) {
        Objects.requireNonNull(locale, "Argument 'locale' of type Locale (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Locale appliedLanguage = getAppliedLanguage();
        if (appliedLanguage == null) {
            return false;
        }
        return isSameLocale(locale, appliedLanguage);
    }

    private static boolean isRightFormatLocalStr(String str) {
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            if (c2 == '$') {
                if (i2 >= 1) {
                    return false;
                }
                i2++;
            }
        }
        return i2 == 1;
    }

    private static boolean isSameLocale(Locale locale, Locale locale2) {
        return UtilsBridge.equals(locale2.getLanguage(), locale.getLanguage()) && UtilsBridge.equals(locale2.getCountry(), locale.getCountry());
    }

    private static String locale2String(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        return language + "$" + country;
    }

    static void pollCheckAppContextLocal(final Locale locale, final int i2, final Utils.Consumer<Boolean> consumer) {
        boolean z2;
        Resources resources = Utils.getApp().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale local = getLocal(configuration);
        setLocal(configuration, locale);
        Utils.getApp().getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        if (consumer != null) {
            if (isSameLocale(local, locale)) {
                z2 = true;
            } else if (i2 < 20) {
                UtilsBridge.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        LanguageUtils.pollCheckAppContextLocal(locale, i2 + 1, consumer);
                    }
                }, 16);
                return;
            } else {
                Log.e("LanguageUtils", "appLocal didn't update.");
                z2 = false;
            }
            consumer.accept(Boolean.valueOf(z2));
        }
    }

    /* access modifiers changed from: private */
    public static void restart(boolean z2) {
        if (z2) {
            UtilsBridge.relaunchApp();
            return;
        }
        for (Activity recreate : UtilsBridge.getActivityList()) {
            recreate.recreate();
        }
    }

    private static void setLocal(Configuration configuration, Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
    }

    private static Locale string2Locale(String str) {
        Locale string2LocaleReal = string2LocaleReal(str);
        if (string2LocaleReal == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            UtilsBridge.getSpUtils4Utils().remove(KEY_LOCALE);
        }
        return string2LocaleReal;
    }

    private static Locale string2LocaleReal(String str) {
        if (!isRightFormatLocalStr(str)) {
            return null;
        }
        try {
            int indexOf = str.indexOf("$");
            return new Locale(str.substring(0, indexOf), str.substring(indexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void updateAppContextLanguage(Locale locale, Utils.Consumer<Boolean> consumer) {
        Objects.requireNonNull(locale, "Argument 'destLocale' of type Locale (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        pollCheckAppContextLocal(locale, 0, consumer);
    }

    private static void updateConfiguration(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        setLocal(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
