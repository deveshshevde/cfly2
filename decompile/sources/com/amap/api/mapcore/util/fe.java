package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

public final class fe {
    private static String a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            fz.c(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static String a(String str) {
        return fg.c(str);
    }

    public static java.net.Proxy a(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? a(context, new URI("http://restsdk.amap.com")) : b(context);
        } catch (Throwable th) {
            fz.c(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy a(Context context, URI uri) {
        java.net.Proxy proxy;
        if (c(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                fz.c(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            fz.c(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == -1) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
        r18 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ab, code lost:
        if (r10 == -1) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x013e A[SYNTHETIC, Splitter:B:106:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x014a A[SYNTHETIC, Splitter:B:112:0x014a] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0159 A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b9 A[SYNTHETIC, Splitter:B:58:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d4 A[SYNTHETIC, Splitter:B:70:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00ef A[Catch:{ all -> 0x016e, all -> 0x0176 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Proxy b(android.content.Context r19) {
        /*
            java.lang.String r1 = "QMTAuMC4wLjE3Mg=="
            java.lang.String r2 = "QMTAuMC4wLjIwMA=="
            java.lang.String r3 = "wap"
            java.lang.String r4 = "ctwap"
            java.lang.String r5 = "null"
            java.lang.String r6 = "gPx2"
            java.lang.String r7 = "pu"
            boolean r0 = c(r19)
            r8 = 0
            if (r0 == 0) goto L_0x017c
            java.lang.String r0 = "content://telephony/carriers/preferapn"
            android.net.Uri r10 = android.net.Uri.parse(r0)
            android.content.ContentResolver r9 = r19.getContentResolver()
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r17 = 1
            r15 = -1
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14)     // Catch:{ SecurityException -> 0x00e0, all -> 0x00c6 }
            if (r9 == 0) goto L_0x00b4
            boolean r0 = r9.moveToFirst()     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = "apn"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            java.lang.String r0 = r9.getString(r0)     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            if (r0 == 0) goto L_0x0046
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            java.lang.String r0 = r0.toLowerCase(r10)     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
        L_0x0046:
            if (r0 == 0) goto L_0x0083
            boolean r10 = r0.contains(r4)     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            if (r10 == 0) goto L_0x0083
            java.lang.String r0 = a()     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            int r10 = b()     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SecurityException -> 0x007f, all -> 0x007c }
            if (r11 != 0) goto L_0x0065
            boolean r11 = r0.equals(r5)     // Catch:{ SecurityException -> 0x007f, all -> 0x007c }
            if (r11 != 0) goto L_0x0065
            r11 = r0
            r0 = 1
            goto L_0x0067
        L_0x0065:
            r11 = r8
            r0 = 0
        L_0x0067:
            if (r0 != 0) goto L_0x0074
            java.lang.String r11 = a((java.lang.String) r2)     // Catch:{ SecurityException -> 0x0071, all -> 0x006e }
            goto L_0x0074
        L_0x006e:
            r0 = move-exception
            goto L_0x00ca
        L_0x0071:
            r0 = move-exception
            goto L_0x00e4
        L_0x0074:
            if (r10 != r15) goto L_0x0079
        L_0x0076:
            r18 = 80
            goto L_0x00b7
        L_0x0079:
            r18 = r10
            goto L_0x00b7
        L_0x007c:
            r0 = move-exception
            r11 = r8
            goto L_0x00ca
        L_0x007f:
            r0 = move-exception
            r11 = r8
            goto L_0x00e4
        L_0x0083:
            if (r0 == 0) goto L_0x00b4
            boolean r0 = r0.contains(r3)     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            if (r0 == 0) goto L_0x00b4
            java.lang.String r0 = a()     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            int r10 = b()     // Catch:{ SecurityException -> 0x00b1, all -> 0x00ae }
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ SecurityException -> 0x007f, all -> 0x007c }
            if (r11 != 0) goto L_0x00a2
            boolean r11 = r0.equals(r5)     // Catch:{ SecurityException -> 0x007f, all -> 0x007c }
            if (r11 != 0) goto L_0x00a2
            r11 = r0
            r0 = 1
            goto L_0x00a4
        L_0x00a2:
            r11 = r8
            r0 = 0
        L_0x00a4:
            if (r0 != 0) goto L_0x00ab
            java.lang.String r0 = a((java.lang.String) r1)     // Catch:{ SecurityException -> 0x0071, all -> 0x006e }
            r11 = r0
        L_0x00ab:
            if (r10 != r15) goto L_0x0079
            goto L_0x0076
        L_0x00ae:
            r0 = move-exception
            r11 = r8
            goto L_0x00c9
        L_0x00b1:
            r0 = move-exception
            r11 = r8
            goto L_0x00e3
        L_0x00b4:
            r11 = r8
            r18 = -1
        L_0x00b7:
            if (r9 == 0) goto L_0x00c2
            r9.close()     // Catch:{ all -> 0x00bd }
            goto L_0x00c2
        L_0x00bd:
            r0 = move-exception
            r1 = r0
            com.amap.api.mapcore.util.fz.c(r1, r7, r6)
        L_0x00c2:
            r10 = r18
            goto L_0x0148
        L_0x00c6:
            r0 = move-exception
            r9 = r8
            r11 = r9
        L_0x00c9:
            r10 = -1
        L_0x00ca:
            java.lang.String r1 = "gPx1"
            com.amap.api.mapcore.util.fz.c(r0, r7, r1)     // Catch:{ all -> 0x016e }
            r0.printStackTrace()     // Catch:{ all -> 0x016e }
            if (r9 == 0) goto L_0x0148
            r9.close()     // Catch:{ all -> 0x00d9 }
            goto L_0x0148
        L_0x00d9:
            r0 = move-exception
            r1 = r0
            com.amap.api.mapcore.util.fz.c(r1, r7, r6)
            goto L_0x0148
        L_0x00e0:
            r0 = move-exception
            r9 = r8
            r11 = r9
        L_0x00e3:
            r10 = -1
        L_0x00e4:
            java.lang.String r12 = "ghp"
            com.amap.api.mapcore.util.fz.c(r0, r7, r12)     // Catch:{ all -> 0x016e }
            java.lang.String r0 = com.amap.api.mapcore.util.ez.q(r19)     // Catch:{ all -> 0x016e }
            if (r0 == 0) goto L_0x013b
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ all -> 0x016e }
            java.lang.String r0 = r0.toLowerCase(r10)     // Catch:{ all -> 0x016e }
            java.lang.String r10 = a()     // Catch:{ all -> 0x016e }
            int r12 = b()     // Catch:{ all -> 0x016e }
            int r4 = r0.indexOf(r4)     // Catch:{ all -> 0x016e }
            if (r4 == r15) goto L_0x011c
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x016e }
            if (r0 != 0) goto L_0x0112
            boolean r0 = r10.equals(r5)     // Catch:{ all -> 0x016e }
            if (r0 != 0) goto L_0x0112
            r11 = r10
            r0 = 1
            goto L_0x0113
        L_0x0112:
            r0 = 0
        L_0x0113:
            if (r0 != 0) goto L_0x0119
            java.lang.String r11 = a((java.lang.String) r2)     // Catch:{ all -> 0x016e }
        L_0x0119:
            if (r12 != r15) goto L_0x013c
            goto L_0x0138
        L_0x011c:
            int r0 = r0.indexOf(r3)     // Catch:{ all -> 0x016e }
            if (r0 == r15) goto L_0x013c
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x016e }
            if (r0 != 0) goto L_0x0131
            boolean r0 = r10.equals(r5)     // Catch:{ all -> 0x016e }
            if (r0 != 0) goto L_0x0131
            r11 = r10
            r0 = 1
            goto L_0x0132
        L_0x0131:
            r0 = 0
        L_0x0132:
            if (r0 != 0) goto L_0x0138
            java.lang.String r11 = a((java.lang.String) r1)     // Catch:{ all -> 0x016e }
        L_0x0138:
            r12 = 80
            goto L_0x013c
        L_0x013b:
            r12 = r10
        L_0x013c:
            if (r9 == 0) goto L_0x0147
            r9.close()     // Catch:{ all -> 0x0142 }
            goto L_0x0147
        L_0x0142:
            r0 = move-exception
            r1 = r0
            com.amap.api.mapcore.util.fz.c(r1, r7, r6)
        L_0x0147:
            r10 = r12
        L_0x0148:
            if (r11 == 0) goto L_0x0157
            int r0 = r11.length()     // Catch:{ all -> 0x0155 }
            if (r0 <= 0) goto L_0x0157
            if (r10 == r15) goto L_0x0157
            r16 = 1
            goto L_0x0157
        L_0x0155:
            r0 = move-exception
            goto L_0x0165
        L_0x0157:
            if (r16 == 0) goto L_0x017c
            java.net.Proxy r0 = new java.net.Proxy     // Catch:{ all -> 0x0155 }
            java.net.Proxy$Type r1 = java.net.Proxy.Type.HTTP     // Catch:{ all -> 0x0155 }
            java.net.InetSocketAddress r2 = java.net.InetSocketAddress.createUnresolved(r11, r10)     // Catch:{ all -> 0x0155 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0155 }
            return r0
        L_0x0165:
            java.lang.String r1 = "gp2"
            com.amap.api.mapcore.util.fw.a((java.lang.Throwable) r0, (java.lang.String) r7, (java.lang.String) r1)
            r0.printStackTrace()
            goto L_0x017c
        L_0x016e:
            r0 = move-exception
            r1 = r0
            if (r9 == 0) goto L_0x017b
            r9.close()     // Catch:{ all -> 0x0176 }
            goto L_0x017b
        L_0x0176:
            r0 = move-exception
            r2 = r0
            com.amap.api.mapcore.util.fz.c(r2, r7, r6)
        L_0x017b:
            throw r1
        L_0x017c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fe.b(android.content.Context):java.net.Proxy");
    }

    private static boolean c(Context context) {
        return ez.p(context) == 0;
    }
}
