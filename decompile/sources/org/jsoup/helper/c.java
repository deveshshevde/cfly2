package org.jsoup.helper;

public final class c {
    public static void a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    public static void a(String str, String str2) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static void a(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(Object[] objArr) {
        a(objArr, "Array must not contain any null objects");
    }

    public static void a(Object[] objArr, String str) {
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (objArr[i2] != null) {
                i2++;
            } else {
                throw new IllegalArgumentException(str);
            }
        }
    }

    public static void b(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void b(boolean z2) {
        if (z2) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static void b(boolean z2, String str) {
        if (z2) {
            throw new IllegalArgumentException(str);
        }
    }
}
