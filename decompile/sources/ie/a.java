package ie;

import android.util.Log;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f13543a = true;

    /* renamed from: b  reason: collision with root package name */
    private static int f13544b = 2;

    public static int a(String str, String str2) {
        if (!f13543a || 3 < f13544b) {
            return -1;
        }
        return Log.d("DLNA_SDK_" + str, str2);
    }

    public static int a(String str, String str2, Throwable th) {
        if (!f13543a || 6 < f13544b) {
            return -1;
        }
        return Log.e("DLNA_SDK_" + str, str2, th);
    }

    public static void a(int i2) {
        f13544b = i2;
    }

    public static int b(String str, String str2) {
        if (!f13543a || 4 < f13544b) {
            return -1;
        }
        return Log.i("DLNA_SDK_" + str, str2);
    }

    public static int c(String str, String str2) {
        if (!f13543a || 5 < f13544b) {
            return -1;
        }
        return Log.w("DLNA_SDK_" + str, str2);
    }

    public static int d(String str, String str2) {
        if (!f13543a || 6 < f13544b) {
            return -1;
        }
        return Log.e("DLNA_SDK_" + str, str2);
    }
}
