package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class hn {
    public static hg a(WeakReference<hg> weakReference) {
        if (weakReference == null || weakReference.get() == null) {
            weakReference = new WeakReference<>(new hg());
        }
        return (hg) weakReference.get();
    }

    public static String a() {
        return fg.a(System.currentTimeMillis());
    }

    public static String a(Context context, ff ffVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String f2 = ez.f(context);
            sb.append("\"sim\":\"");
            sb.append(f2);
            sb.append("\",\"sdkversion\":\"");
            sb.append(ffVar.c());
            sb.append("\",\"product\":\"");
            sb.append(ffVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(ffVar.e());
            sb.append("\",\"nt\":\"");
            sb.append(ez.d(context));
            sb.append("\",\"np\":\"");
            sb.append(ez.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(ez.c(context));
            sb.append("\",\"ant\":\"");
            sb.append(ez.e(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, int i2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i2);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(1);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static void a(Context context, hg hgVar, String str, int i2, int i3, String str2) {
        hgVar.f9123a = fx.c(context, str);
        hgVar.f9126d = i2;
        hgVar.f9124b = (long) i3;
        hgVar.f9125c = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x005b A[SYNTHETIC, Splitter:B:44:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0065 A[SYNTHETIC, Splitter:B:49:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] a(com.amap.api.mapcore.util.gt r4, java.lang.String r5) {
        /*
            r0 = 0
            byte[] r0 = new byte[r0]
            r1 = 0
            com.amap.api.mapcore.util.gt$b r4 = r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x0045
            java.io.InputStream r1 = r4.a()     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x0025
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ all -> 0x0016 }
            goto L_0x001a
        L_0x0016:
            r5 = move-exception
            r5.printStackTrace()
        L_0x001a:
            if (r4 == 0) goto L_0x0024
            r4.close()     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0024:
            return r0
        L_0x0025:
            int r5 = r1.available()     // Catch:{ all -> 0x0043 }
            byte[] r0 = new byte[r5]     // Catch:{ all -> 0x0043 }
            r1.read(r0)     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x0038
            r1.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0038:
            if (r4 == 0) goto L_0x0042
            r4.close()     // Catch:{ all -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0042:
            return r0
        L_0x0043:
            r5 = move-exception
            goto L_0x0052
        L_0x0045:
            if (r4 == 0) goto L_0x004f
            r4.close()     // Catch:{ all -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004f:
            return r0
        L_0x0050:
            r5 = move-exception
            r4 = r1
        L_0x0052:
            java.lang.String r2 = "sui"
            java.lang.String r3 = "rdS"
            com.amap.api.mapcore.util.fz.c(r5, r2, r3)     // Catch:{ all -> 0x006e }
            if (r1 == 0) goto L_0x0063
            r1.close()     // Catch:{ all -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0063:
            if (r4 == 0) goto L_0x006d
            r4.close()     // Catch:{ all -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006d:
            return r0
        L_0x006e:
            r5 = move-exception
            if (r1 == 0) goto L_0x0079
            r1.close()     // Catch:{ all -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0079:
            if (r4 == 0) goto L_0x0083
            r4.close()     // Catch:{ all -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0083:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.hn.a(com.amap.api.mapcore.util.gt, java.lang.String):byte[]");
    }
}
