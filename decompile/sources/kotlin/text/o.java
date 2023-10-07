package kotlin.text;

import kotlin.jvm.internal.h;
import mr.d;

class o extends n {
    public static final String a(String str, String str2, String str3, boolean z2) {
        h.d(str, "$this$replace");
        h.d(str2, "oldValue");
        h.d(str3, "newValue");
        CharSequence charSequence = str;
        int i2 = 0;
        int a2 = f.a(charSequence, str2, 0, z2);
        if (a2 < 0) {
            return str;
        }
        int length = str2.length();
        int c2 = d.c(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(charSequence, i2, a2);
                sb.append(str3);
                i2 = a2 + length;
                if (a2 >= str.length() || (a2 = f.a(charSequence, str2, a2 + c2, z2)) <= 0) {
                    sb.append(charSequence, i2, str.length());
                    String sb2 = sb.toString();
                    h.b(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(charSequence, i2, a2);
                sb.append(str3);
                i2 = a2 + length;
                break;
            } while ((a2 = f.a(charSequence, str2, a2 + c2, z2)) <= 0);
            sb.append(charSequence, i2, str.length());
            String sb22 = sb.toString();
            h.b(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return f.a(str, str2, str3, z2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            kotlin.jvm.internal.h.d(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0040
            mr.c r0 = kotlin.text.f.c(r4)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0022
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0022
        L_0x0020:
            r4 = 1
            goto L_0x003e
        L_0x0022:
            java.util.Iterator r0 = r0.iterator()
        L_0x0026:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0020
            r3 = r0
            kotlin.collections.t r3 = (kotlin.collections.t) r3
            int r3 = r3.b()
            char r3 = r4.charAt(r3)
            boolean r3 = kotlin.text.a.a((char) r3)
            if (r3 != 0) goto L_0x0026
            r4 = 0
        L_0x003e:
            if (r4 == 0) goto L_0x0041
        L_0x0040:
            r1 = 1
        L_0x0041:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.o.a(java.lang.CharSequence):boolean");
    }

    public static final boolean a(String str, int i2, String str2, int i3, int i4, boolean z2) {
        h.d(str, "$this$regionMatches");
        h.d(str2, "other");
        return !z2 ? str.regionMatches(i2, str2, i3, i4) : str.regionMatches(z2, i2, str2, i3, i4);
    }

    public static final boolean a(String str, String str2, boolean z2) {
        return str == null ? str2 == null : !z2 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return f.a(str, str2, z2);
    }

    public static final boolean b(String str, String str2, boolean z2) {
        h.d(str, "$this$startsWith");
        h.d(str2, "prefix");
        if (!z2) {
            return str.startsWith(str2);
        }
        return f.a(str, 0, str2, 0, str2.length(), z2);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return f.b(str, str2, z2);
    }

    public static final boolean c(String str, String str2, boolean z2) {
        h.d(str, "$this$endsWith");
        h.d(str2, "suffix");
        if (!z2) {
            return str.endsWith(str2);
        }
        return f.a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean c(String str, String str2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return f.c(str, str2, z2);
    }

    public static final int d(String str, String str2, boolean z2) {
        h.d(str, "$this$compareTo");
        h.d(str2, "other");
        return z2 ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }
}
