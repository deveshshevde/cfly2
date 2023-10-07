package com.xeagle.android.login.common;

import android.content.Context;
import android.graphics.Bitmap;

public class PhotoUtil {
    public static void savePhoto(Bitmap bitmap, String str, Context context) {
        savePhoto(bitmap, str, context, 100);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a A[SYNTHETIC, Splitter:B:26:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065 A[SYNTHETIC, Splitter:B:31:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void savePhoto(android.graphics.Bitmap r2, java.lang.String r3, android.content.Context r4, int r5) {
        /*
            if (r2 == 0) goto L_0x006e
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x006e
            if (r4 != 0) goto L_0x000b
            goto L_0x006e
        L_0x000b:
            r0 = 100
            if (r5 <= 0) goto L_0x0011
            if (r5 <= r0) goto L_0x0013
        L_0x0011:
            r5 = 100
        L_0x0013:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0054 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x0054 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r2.compress(r0, r5, r1)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r1.flush()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            android.os.Looper r2 = android.os.Looper.myLooper()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            android.os.Looper r5 = android.os.Looper.getMainLooper()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            if (r2 != r5) goto L_0x0048
            android.content.Context r2 = r4.getApplicationContext()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r4.<init>()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.lang.String r5 = "save success:"
            r4.append(r5)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r4.append(r3)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r4 = 0
            android.widget.Toast r2 = android.widget.Toast.makeText(r2, r3, r4)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            r2.show()     // Catch:{ IOException -> 0x004f, all -> 0x004c }
        L_0x0048:
            r1.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x004c:
            r2 = move-exception
            r0 = r1
            goto L_0x0063
        L_0x004f:
            r2 = move-exception
            r0 = r1
            goto L_0x0055
        L_0x0052:
            r2 = move-exception
            goto L_0x0063
        L_0x0054:
            r2 = move-exception
        L_0x0055:
            r2.printStackTrace()     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0062
            r0.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0062:
            return
        L_0x0063:
            if (r0 == 0) goto L_0x006d
            r0.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r3 = move-exception
            r3.printStackTrace()
        L_0x006d:
            throw r2
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.PhotoUtil.savePhoto(android.graphics.Bitmap, java.lang.String, android.content.Context, int):void");
    }
}
