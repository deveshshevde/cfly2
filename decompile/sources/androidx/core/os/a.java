package androidx.core.os;

import android.os.Build;

public class a {
    @Deprecated
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    protected static boolean a(String str, String str2) {
        return !"REL".equals(str2) && str2.compareTo(str) >= 0;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 31 || a("S", Build.VERSION.CODENAME);
    }
}
