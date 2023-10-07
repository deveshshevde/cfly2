package bk;

import android.net.Uri;

public final class b {
    public static boolean a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return a(uri) && d(uri);
    }

    public static boolean c(Uri uri) {
        return a(uri) && !d(uri);
    }

    private static boolean d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
