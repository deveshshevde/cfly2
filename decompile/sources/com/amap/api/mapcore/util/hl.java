package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.AMapException;

public final class hl {

    /* renamed from: a  reason: collision with root package name */
    private Context f9147a;

    /* renamed from: b  reason: collision with root package name */
    private String f9148b;

    /* renamed from: c  reason: collision with root package name */
    private String f9149c;

    /* renamed from: d  reason: collision with root package name */
    private String f9150d;

    /* renamed from: e  reason: collision with root package name */
    private String f9151e;

    public hl(Context context, String str, String str2, String str3) throws eu {
        if (TextUtils.isEmpty(str3) || str3.length() > 256) {
            throw new eu(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.f9147a = context.getApplicationContext();
        this.f9149c = str;
        this.f9150d = str2;
        this.f9148b = str3;
    }

    private static byte[] a(int i2) {
        return new byte[]{(byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
    }

    private byte[] b(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[]{0, 0};
        }
        byte[] a2 = fg.a(this.f9151e);
        return a2 == null ? new byte[]{0, 0} : fg.a(a2.length);
    }

    public final void a(String str) throws eu {
        if (TextUtils.isEmpty(str) || str.length() > 65536) {
            throw new eu(AMapException.ERROR_INVALID_PARAMETER);
        }
        this.f9151e = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:3|4|5|6|7|8|9|(2:10|11)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[SYNTHETIC, Splitter:B:21:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a() {
        /*
            r8 = this;
            r0 = 0
            byte[] r1 = new byte[r0]
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0056 }
            r3.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r2 = r8.f9149c     // Catch:{ all -> 0x0053 }
            com.amap.api.mapcore.util.fg.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = r8.f9150d     // Catch:{ all -> 0x0053 }
            com.amap.api.mapcore.util.fg.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = r8.f9148b     // Catch:{ all -> 0x0053 }
            com.amap.api.mapcore.util.fg.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0053 }
            android.content.Context r2 = r8.f9147a     // Catch:{ all -> 0x0053 }
            int r2 = com.amap.api.mapcore.util.ez.p(r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0053 }
            com.amap.api.mapcore.util.fg.a((java.io.ByteArrayOutputStream) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0053 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002d }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 / r6
            int r0 = (int) r4
        L_0x002d:
            byte[] r0 = a((int) r0)     // Catch:{ all -> 0x0053 }
            r3.write(r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = r8.f9151e     // Catch:{ all -> 0x0053 }
            byte[] r0 = r8.b(r0)     // Catch:{ all -> 0x0053 }
            r3.write(r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = r8.f9151e     // Catch:{ all -> 0x0053 }
            byte[] r0 = com.amap.api.mapcore.util.fg.a((java.lang.String) r0)     // Catch:{ all -> 0x0053 }
            r3.write(r0)     // Catch:{ all -> 0x0053 }
            byte[] r1 = r3.toByteArray()     // Catch:{ all -> 0x0053 }
            r3.close()     // Catch:{ all -> 0x004e }
            goto L_0x0063
        L_0x004e:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0063
        L_0x0053:
            r0 = move-exception
            r2 = r3
            goto L_0x0057
        L_0x0056:
            r0 = move-exception
        L_0x0057:
            java.lang.String r3 = "se"
            java.lang.String r4 = "tds"
            com.amap.api.mapcore.util.fz.c(r0, r3, r4)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ all -> 0x004e }
        L_0x0063:
            return r1
        L_0x0064:
            r0 = move-exception
            if (r2 == 0) goto L_0x006f
            r2.close()     // Catch:{ all -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x006f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.hl.a():byte[]");
    }
}
