package com.amap.api.mapcore.util;

public final class bd {

    public interface a {
        void a();

        void a(float f2);

        void b();
    }

    private static float a(long j2, long j3) {
        return (((float) j2) / ((float) j3)) * 100.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(java.io.File r18, java.io.File r19, long r20, long r22, com.amap.api.mapcore.util.bd.a r24) {
        /*
            r17 = this;
            r0 = r18
            r1 = r19
            r10 = r22
            r12 = r24
            r2 = 0
            int r4 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0014
            if (r12 == 0) goto L_0x0013
            r24.b()
        L_0x0013:
            return r2
        L_0x0014:
            r18.getAbsolutePath()
            r19.getAbsolutePath()
            boolean r2 = r18.isDirectory()     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r3 = "Cannot create dir "
            r4 = 0
            if (r2 == 0) goto L_0x007c
            boolean r2 = r19.exists()     // Catch:{ Exception -> 0x00e5 }
            if (r2 != 0) goto L_0x0046
            boolean r2 = r19.mkdirs()     // Catch:{ Exception -> 0x00e5 }
            if (r2 == 0) goto L_0x0030
            goto L_0x0046
        L_0x0030:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x00e5 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e5 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r1 = r19.getAbsolutePath()     // Catch:{ Exception -> 0x00e5 }
            r2.append(r1)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00e5 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00e5 }
            throw r0     // Catch:{ Exception -> 0x00e5 }
        L_0x0046:
            java.lang.String[] r13 = r18.list()     // Catch:{ Exception -> 0x00e5 }
            r14 = r20
            if (r13 == 0) goto L_0x00f0
            r9 = 0
        L_0x004f:
            int r2 = r13.length     // Catch:{ Exception -> 0x0079 }
            if (r9 >= r2) goto L_0x00f0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0079 }
            r2 = r13[r9]     // Catch:{ Exception -> 0x0079 }
            r3.<init>(r0, r2)     // Catch:{ Exception -> 0x0079 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0079 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0079 }
            java.lang.String r5 = r18.getName()     // Catch:{ Exception -> 0x0079 }
            r2.<init>(r1, r5)     // Catch:{ Exception -> 0x0079 }
            r5 = r13[r9]     // Catch:{ Exception -> 0x0079 }
            r4.<init>(r2, r5)     // Catch:{ Exception -> 0x0079 }
            r2 = r17
            r5 = r14
            r7 = r22
            r16 = r9
            r9 = r24
            long r14 = r2.a(r3, r4, r5, r7, r9)     // Catch:{ Exception -> 0x0079 }
            int r9 = r16 + 1
            goto L_0x004f
        L_0x0079:
            r0 = move-exception
            goto L_0x00e8
        L_0x007c:
            java.io.File r2 = r19.getParentFile()     // Catch:{ Exception -> 0x00e5 }
            if (r2 == 0) goto L_0x00a5
            boolean r5 = r2.exists()     // Catch:{ Exception -> 0x00e5 }
            if (r5 != 0) goto L_0x00a5
            boolean r5 = r2.mkdirs()     // Catch:{ Exception -> 0x00e5 }
            if (r5 == 0) goto L_0x008f
            goto L_0x00a5
        L_0x008f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x00e5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e5 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ Exception -> 0x00e5 }
            r1.append(r2)     // Catch:{ Exception -> 0x00e5 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00e5 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00e5 }
            throw r0     // Catch:{ Exception -> 0x00e5 }
        L_0x00a5:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00e5 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x00e5 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00e5 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00e5 }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x00e5 }
            r5 = r20
        L_0x00b5:
            int r3 = r2.read(r1)     // Catch:{ Exception -> 0x00e2 }
            if (r3 <= 0) goto L_0x00ca
            r0.write(r1, r4, r3)     // Catch:{ Exception -> 0x00e2 }
            long r7 = (long) r3     // Catch:{ Exception -> 0x00e2 }
            long r5 = r5 + r7
            if (r12 == 0) goto L_0x00b5
            float r3 = a(r5, r10)     // Catch:{ Exception -> 0x00e2 }
            r12.a(r3)     // Catch:{ Exception -> 0x00e2 }
            goto L_0x00b5
        L_0x00ca:
            r2.close()     // Catch:{ Exception -> 0x00e2 }
            r0.flush()     // Catch:{ Exception -> 0x00e2 }
            r0.close()     // Catch:{ Exception -> 0x00e2 }
            if (r12 == 0) goto L_0x00e0
            r0 = 1
            long r0 = r10 - r0
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x00e0
            r24.a()     // Catch:{ Exception -> 0x00e2 }
        L_0x00e0:
            r14 = r5
            goto L_0x00f0
        L_0x00e2:
            r0 = move-exception
            r14 = r5
            goto L_0x00e8
        L_0x00e5:
            r0 = move-exception
            r14 = r20
        L_0x00e8:
            r0.printStackTrace()
            if (r12 == 0) goto L_0x00f0
            r24.b()
        L_0x00f0:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bd.a(java.io.File, java.io.File, long, long, com.amap.api.mapcore.util.bd$a):long");
    }
}
