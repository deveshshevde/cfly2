package com.amap.api.mapcore.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class fd {
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0058 A[SYNTHETIC, Splitter:B:28:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r7) {
        /*
            java.lang.String r0 = "gfm"
            java.lang.String r1 = "MD5"
            r2 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x000c
            return r2
        L_0x000c:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0051 }
            r3.<init>(r7)     // Catch:{ all -> 0x0051 }
            boolean r7 = r3.isFile()     // Catch:{ all -> 0x0051 }
            if (r7 == 0) goto L_0x0050
            boolean r7 = r3.exists()     // Catch:{ all -> 0x0051 }
            if (r7 != 0) goto L_0x001e
            goto L_0x0050
        L_0x001e:
            r7 = 2048(0x800, float:2.87E-42)
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = "ETUQ1"
            java.lang.String r4 = com.amap.api.mapcore.util.fg.c((java.lang.String) r4)     // Catch:{ all -> 0x0051 }
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ all -> 0x0051 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x0051 }
            r5.<init>(r3)     // Catch:{ all -> 0x0051 }
        L_0x0031:
            int r3 = r5.read(r7)     // Catch:{ all -> 0x004e }
            r6 = -1
            if (r3 == r6) goto L_0x003d
            r6 = 0
            r4.update(r7, r6, r3)     // Catch:{ all -> 0x004e }
            goto L_0x0031
        L_0x003d:
            byte[] r7 = r4.digest()     // Catch:{ all -> 0x004e }
            java.lang.String r7 = com.amap.api.mapcore.util.fg.e((byte[]) r7)     // Catch:{ all -> 0x004e }
            r5.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004d
        L_0x0049:
            r2 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r1, (java.lang.String) r0)
        L_0x004d:
            return r7
        L_0x004e:
            r7 = move-exception
            goto L_0x0053
        L_0x0050:
            return r2
        L_0x0051:
            r7 = move-exception
            r5 = r2
        L_0x0053:
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0060
            r5.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r7 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r0)
        L_0x0060:
            return r2
        L_0x0061:
            r7 = move-exception
            if (r5 == 0) goto L_0x006c
            r5.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x006c
        L_0x0068:
            r2 = move-exception
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r2, (java.lang.String) r1, (java.lang.String) r0)
        L_0x006c:
            goto L_0x006e
        L_0x006d:
            throw r7
        L_0x006e:
            goto L_0x006d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fd.a(java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr) {
        return fg.e(a(bArr, fg.c("ETUQ1")));
    }

    private static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            fw.a(th, "MD5", "gmb");
            return null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return fg.e(d(str));
    }

    public static String c(String str) {
        return fg.f(e(str));
    }

    private static byte[] d(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            fw.a(th, "MD5", "gmb");
            return new byte[0];
        }
    }

    private static byte[] e(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance(fg.c("ETUQ1"));
        instance.update(fg.a(str));
        return instance.digest();
    }
}
