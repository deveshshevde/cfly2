package com.nanchen.compresshelper;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class c {
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r8 == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r8 != null) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r8.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String a(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0042
            android.content.ContentResolver r2 = r8.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)
            if (r8 == 0) goto L_0x003d
            boolean r0 = r8.moveToFirst()     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x003d
            java.lang.String r0 = "_display_name"
            int r0 = r8.getColumnIndex(r0)     // Catch:{ Exception -> 0x0030 }
            java.lang.String r0 = r8.getString(r0)     // Catch:{ Exception -> 0x0030 }
            r1 = r0
            goto L_0x003d
        L_0x002e:
            r9 = move-exception
            goto L_0x0037
        L_0x0030:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x002e }
            if (r8 == 0) goto L_0x0042
            goto L_0x003f
        L_0x0037:
            if (r8 == 0) goto L_0x003c
            r8.close()
        L_0x003c:
            throw r9
        L_0x003d:
            if (r8 == 0) goto L_0x0042
        L_0x003f:
            r8.close()
        L_0x0042:
            if (r1 != 0) goto L_0x0057
            java.lang.String r1 = r9.getPath()
            java.lang.String r8 = java.io.File.separator
            int r8 = r1.lastIndexOf(r8)
            r9 = -1
            if (r8 == r9) goto L_0x0057
            int r8 = r8 + 1
            java.lang.String r1 = r1.substring(r8)
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nanchen.compresshelper.c.a(android.content.Context, android.net.Uri):java.lang.String");
    }

    static String[] a(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
            str = substring;
        } else {
            str2 = "";
        }
        return new String[]{str, str2};
    }

    static String b(Context context, Uri uri) {
        Cursor query = context.getContentResolver().query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }
}
