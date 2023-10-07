package com.ctoo.mediaedit.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import java.io.File;

public class b {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[Catch:{ Exception -> 0x0039 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = "mounted"
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0039 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = "C-FLY"
            if (r0 == 0) goto L_0x0022
            java.io.File r0 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0039 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x0039 }
            if (r0 == 0) goto L_0x0022
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0039 }
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0039 }
            r0.<init>(r2, r1)     // Catch:{ Exception -> 0x0039 }
            goto L_0x002b
        L_0x0022:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0039 }
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x0039 }
            r0.<init>(r2, r1)     // Catch:{ Exception -> 0x0039 }
        L_0x002b:
            boolean r1 = r0.exists()     // Catch:{ Exception -> 0x0039 }
            if (r1 != 0) goto L_0x0034
            r0.mkdirs()     // Catch:{ Exception -> 0x0039 }
        L_0x0034:
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x0039 }
            return r0
        L_0x0039:
            java.lang.String r0 = "Exception"
            java.lang.String r1 = "rootDir exception"
            android.util.Log.v(r0, r1)
            java.lang.String r0 = b()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.utils.b.a():java.lang.String");
    }

    public static void a(Context context, String str) {
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("mime_type", "video/mp4");
        contentValues.put("_data", str);
        context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
    }

    public static void a(String str) {
        new File(str).delete();
    }

    public static String b() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    }
}
