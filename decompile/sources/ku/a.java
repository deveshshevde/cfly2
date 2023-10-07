package ku;

public class a {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0042 A[SYNTHETIC, Splitter:B:34:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x004c A[SYNTHETIC, Splitter:B:39:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0058 A[SYNTHETIC, Splitter:B:45:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0062 A[SYNTHETIC, Splitter:B:50:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r2, java.lang.String r3, java.io.File r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            java.io.InputStream r2 = r2.open(r3)     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0034, all -> 0x0030 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0034, all -> 0x0030 }
            r4 = 1048576(0x100000, float:1.469368E-39)
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x002e, all -> 0x002c }
        L_0x0012:
            int r0 = r2.read(r4)     // Catch:{ IOException -> 0x002e, all -> 0x002c }
            if (r0 <= 0) goto L_0x001c
            r1 = 0
            r3.write(r4, r1, r0)     // Catch:{ IOException -> 0x002e, all -> 0x002c }
        L_0x001c:
            if (r0 > 0) goto L_0x0012
            if (r2 == 0) goto L_0x0028
            r2.close()     // Catch:{ IOException -> 0x0024 }
            goto L_0x0028
        L_0x0024:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0028:
            r3.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x002c:
            r4 = move-exception
            goto L_0x0032
        L_0x002e:
            r4 = move-exception
            goto L_0x0036
        L_0x0030:
            r4 = move-exception
            r3 = r0
        L_0x0032:
            r0 = r2
            goto L_0x0056
        L_0x0034:
            r4 = move-exception
            r3 = r0
        L_0x0036:
            r0 = r2
            goto L_0x003d
        L_0x0038:
            r4 = move-exception
            r3 = r0
            goto L_0x0056
        L_0x003b:
            r4 = move-exception
            r3 = r0
        L_0x003d:
            r4.printStackTrace()     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x004a
            r0.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r2 = move-exception
            r2.printStackTrace()
        L_0x004a:
            if (r3 == 0) goto L_0x0054
            r3.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0054:
            return
        L_0x0055:
            r4 = move-exception
        L_0x0056:
            if (r0 == 0) goto L_0x0060
            r0.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0060:
            if (r3 == 0) goto L_0x006a
            r3.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r2 = move-exception
            r2.printStackTrace()
        L_0x006a:
            goto L_0x006c
        L_0x006b:
            throw r4
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: ku.a.a(android.content.Context, java.lang.String, java.io.File):void");
    }
}
