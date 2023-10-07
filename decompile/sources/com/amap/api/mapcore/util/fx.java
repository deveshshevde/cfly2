package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.RejectedExecutionException;

public final class fx {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8860a = "/a/";

    /* renamed from: b  reason: collision with root package name */
    static final String f8861b = "b";

    /* renamed from: c  reason: collision with root package name */
    static final String f8862c = "c";

    /* renamed from: d  reason: collision with root package name */
    static final String f8863d = "d";

    /* renamed from: e  reason: collision with root package name */
    public static String f8864e = "s";

    /* renamed from: f  reason: collision with root package name */
    public static final String f8865f = "g";

    /* renamed from: g  reason: collision with root package name */
    public static final String f8866g = "h";

    /* renamed from: h  reason: collision with root package name */
    public static final String f8867h = "e";

    /* renamed from: i  reason: collision with root package name */
    public static final String f8868i = "f";

    /* renamed from: j  reason: collision with root package name */
    public static final String f8869j = "j";

    /* renamed from: k  reason: collision with root package name */
    public static final String f8870k = "k";

    /* renamed from: l  reason: collision with root package name */
    private static long f8871l;

    /* renamed from: m  reason: collision with root package name */
    private static Vector<ff> f8872m = new Vector<>();

    public static String a(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    static List<ff> a() {
        Vector<ff> vector;
        try {
            synchronized (Looper.getMainLooper()) {
                vector = f8872m;
            }
            return vector;
        } catch (Throwable th) {
            th.printStackTrace();
            return f8872m;
        }
    }

    public static void a(final Context context) {
        try {
            if (System.currentTimeMillis() - f8871l >= 60000) {
                f8871l = System.currentTimeMillis();
                id.a().a(new ie() {
                    public final void runTask() {
                        try {
                            ga.b(context);
                            ga.d(context);
                            ga.c(context);
                            hm.a(context);
                            hk.a(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            fz.c(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            fz.c(th, "Lg", "proL");
        }
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void a(ff ffVar) {
        try {
            synchronized (Looper.getMainLooper()) {
                if (ffVar != null) {
                    if (!f8872m.contains(ffVar)) {
                        f8872m.add(ffVar);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    static boolean a(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                String[] split = str.split("\n");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    boolean z2 = true;
                    if (i2 < length) {
                        String trim = split[i2].trim();
                        if (TextUtils.isEmpty(trim) || !trim.startsWith("at ") || !trim.contains("uncaughtException")) {
                            z2 = false;
                        }
                        if (z2) {
                            return false;
                        }
                        i2++;
                    } else {
                        for (String trim2 : split) {
                            if (b(strArr, trim2.trim())) {
                                return true;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    static boolean b(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String str2 : strArr) {
                    str = str.trim();
                    if (str.startsWith("at ")) {
                        if (str.contains(str2 + ".") && str.endsWith(")") && !str.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f8860a + str;
    }
}
