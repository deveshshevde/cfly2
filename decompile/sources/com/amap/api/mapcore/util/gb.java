package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;

public final class gb {

    /* renamed from: a  reason: collision with root package name */
    static byte[] f8910a;

    /* renamed from: b  reason: collision with root package name */
    static byte[] f8911b;

    /* renamed from: c  reason: collision with root package name */
    private String f8912c;

    public gb(String str) {
        this.f8912c = fd.b(TextUtils.isDigitsOnly(str) ? "SPUtil" : str);
    }

    public static int a(Context context, String str, String str2, int i2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i2);
        } catch (Throwable th) {
            fz.c(th, "csp", "giv");
            return i2;
        }
    }

    public static SharedPreferences.Editor a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return context.getSharedPreferences(str, 0).edit();
                }
            } catch (Throwable th) {
                fw.a(th, "sp", "ge");
            }
        }
        return null;
    }

    public static String a(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        try {
            return fg.a(b(context, fg.e(context.getSharedPreferences(str, 0).getString(str2, ""))));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putString(str2, fg.g(a(context, fg.a(str3))));
                a(edit);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor != null) {
            try {
                editor.apply();
            } catch (Throwable th) {
                fw.a(th, "sp", "cm");
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str) {
        if (editor != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    editor.remove(str);
                }
            } catch (Throwable th) {
                fw.a(th, "sp", "rk");
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, int i2) {
        try {
            editor.putInt(str, i2);
        } catch (Throwable th) {
            fz.c(th, "csp", "putPrefsInt");
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, long j2) {
        if (editor != null && !TextUtils.isEmpty(str)) {
            try {
                editor.putLong(str, j2);
            } catch (Throwable th) {
                fz.c(th, "csp", "plv");
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, String str2) {
        if (editor != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    editor.putString(str, str2);
                }
            } catch (Throwable th) {
                fw.a(th, "sp", "ps");
            }
        }
    }

    public static void a(SharedPreferences.Editor editor, String str, boolean z2) {
        try {
            editor.putBoolean(str, z2);
        } catch (Throwable th) {
            fz.c(th, "csp", "setPrefsStr");
        }
    }

    public static boolean a(Context context, String str, String str2, boolean z2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z2);
        } catch (Throwable th) {
            fz.c(th, "csp", "gbv");
            return z2;
        }
    }

    private static byte[] a(Context context) {
        if (context == null) {
            return new byte[0];
        }
        byte[] bArr = f8910a;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        byte[] bytes = ev.f(context).getBytes();
        f8910a = bytes;
        return bytes;
    }

    private static byte[] a(Context context, byte[] bArr) {
        try {
            return fa.b(a(context), bArr, b(context));
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public static String b(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            fz.c(th, "csp", "gsv");
            return str3;
        }
    }

    private static byte[] b(Context context) {
        byte[] bArr = f8911b;
        if (bArr != null && bArr.length > 0) {
            return bArr;
        }
        int i2 = 0;
        if (Build.VERSION.SDK_INT < 9) {
            f8911b = new byte[(a(context).length / 2)];
            while (true) {
                byte[] bArr2 = f8911b;
                if (i2 >= bArr2.length) {
                    break;
                }
                bArr2[i2] = a(context)[i2];
                i2++;
            }
        } else {
            f8911b = Arrays.copyOfRange(a(context), 0, a(context).length / 2);
        }
        return f8911b;
    }

    private static byte[] b(Context context, byte[] bArr) {
        try {
            return fa.a(a(context), bArr, b(context));
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
