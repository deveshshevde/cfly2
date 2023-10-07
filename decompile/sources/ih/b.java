package ih;

public class b {
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r17.a(r11, r9, true) == false) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File a(org.apache.http.HttpEntity r16, ih.e r17, java.lang.String r18, boolean r19, java.lang.String r20) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r18
            r7 = r20
            r1 = 0
            if (r16 == 0) goto L_0x00ee
            boolean r2 = android.text.TextUtils.isEmpty(r18)
            if (r2 == 0) goto L_0x000f
            goto L_0x00ee
        L_0x000f:
            java.io.File r8 = new java.io.File
            r8.<init>(r0)
            boolean r2 = r8.exists()
            if (r2 != 0) goto L_0x002d
            java.io.File r2 = r8.getParentFile()
            boolean r3 = r2.exists()
            if (r3 != 0) goto L_0x002a
            boolean r2 = r2.mkdirs()
            if (r2 == 0) goto L_0x002d
        L_0x002a:
            r8.createNewFile()
        L_0x002d:
            r2 = 0
            if (r19 == 0) goto L_0x003c
            long r2 = r8.length()     // Catch:{ all -> 0x00e5 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x00e5 }
            r5 = 1
            r4.<init>(r0, r5)     // Catch:{ all -> 0x00e5 }
            goto L_0x0041
        L_0x003c:
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x00e5 }
            r4.<init>(r0)     // Catch:{ all -> 0x00e5 }
        L_0x0041:
            r9 = r2
            long r2 = r16.getContentLength()     // Catch:{ all -> 0x00e5 }
            long r11 = r2 + r9
            java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ all -> 0x00e5 }
            java.io.InputStream r0 = r16.getContent()     // Catch:{ all -> 0x00e5 }
            r13.<init>(r0)     // Catch:{ all -> 0x00e5 }
            java.io.BufferedOutputStream r14 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x00e1 }
            r14.<init>(r4)     // Catch:{ all -> 0x00e1 }
            if (r17 == 0) goto L_0x006a
            r6 = 1
            r1 = r17
            r2 = r11
            r4 = r9
            boolean r0 = r1.a(r2, r4, r6)     // Catch:{ all -> 0x00df }
            if (r0 != 0) goto L_0x006a
        L_0x0063:
            il.b.a(r13)
            il.b.a(r14)
            return r8
        L_0x006a:
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00df }
        L_0x006e:
            r4 = r9
            int r1 = r13.read(r0)     // Catch:{ all -> 0x00df }
            r2 = -1
            if (r1 != r2) goto L_0x00ca
            r14.flush()     // Catch:{ all -> 0x00df }
            if (r17 == 0) goto L_0x0082
            r6 = 1
            r1 = r17
            r2 = r11
            r1.a(r2, r4, r6)     // Catch:{ all -> 0x00df }
        L_0x0082:
            il.b.a(r13)
            il.b.a(r14)
            boolean r0 = r8.exists()
            if (r0 == 0) goto L_0x00c9
            boolean r0 = android.text.TextUtils.isEmpty(r20)
            if (r0 != 0) goto L_0x00c9
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r8.getParent()
            r0.<init>(r1, r7)
        L_0x009d:
            boolean r1 = r0.exists()
            if (r1 != 0) goto L_0x00ab
            boolean r1 = r8.renameTo(r0)
            if (r1 == 0) goto L_0x00aa
            r8 = r0
        L_0x00aa:
            return r8
        L_0x00ab:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r8.getParent()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            goto L_0x009d
        L_0x00c9:
            return r8
        L_0x00ca:
            r2 = 0
            r14.write(r0, r2, r1)     // Catch:{ all -> 0x00df }
            long r1 = (long) r1     // Catch:{ all -> 0x00df }
            long r9 = r4 + r1
            if (r17 == 0) goto L_0x006e
            r6 = 0
            r1 = r17
            r2 = r11
            r4 = r9
            boolean r1 = r1.a(r2, r4, r6)     // Catch:{ all -> 0x00df }
            if (r1 != 0) goto L_0x006e
            goto L_0x0063
        L_0x00df:
            r0 = move-exception
            goto L_0x00e3
        L_0x00e1:
            r0 = move-exception
            r14 = r1
        L_0x00e3:
            r1 = r13
            goto L_0x00e7
        L_0x00e5:
            r0 = move-exception
            r14 = r1
        L_0x00e7:
            il.b.a(r1)
            il.b.a(r14)
            throw r0
        L_0x00ee:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ih.b.a(org.apache.http.HttpEntity, ih.e, java.lang.String, boolean, java.lang.String):java.io.File");
    }
}
