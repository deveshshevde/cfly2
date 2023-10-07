package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static int f17127a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f17128b = true;

    private static String a(String str, Throwable th) {
        String a2 = a(th);
        if (TextUtils.isEmpty(a2)) {
            return str;
        }
        String valueOf = String.valueOf(str);
        String replace = a2.replace("\n", "\n  ");
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(replace).length());
        sb.append(valueOf);
        sb.append("\n  ");
        sb.append(replace);
        sb.append(10);
        return sb.toString();
    }

    public static String a(Throwable th) {
        if (th == null) {
            return null;
        }
        return b(th) ? "UnknownHostException (no network)" : !f17128b ? th.getMessage() : Log.getStackTraceString(th).trim().replace("\t", "    ");
    }

    public static void a(String str, String str2) {
        if (f17127a == 0) {
            Log.d(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        c(str, a(str2, th));
    }

    public static void b(String str, String str2) {
        if (f17127a <= 1) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        d(str, a(str2, th));
    }

    private static boolean b(Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void c(String str, String str2) {
        if (f17127a <= 2) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f17127a <= 3) {
            Log.e(str, str2);
        }
    }
}
