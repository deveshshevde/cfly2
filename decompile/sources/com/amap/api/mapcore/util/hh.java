package com.amap.api.mapcore.util;

import java.io.File;
import java.util.List;

public final class hh {
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a2 A[SYNTHETIC, Splitter:B:50:0x00a2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(com.amap.api.mapcore.util.hg r10) {
        /*
            java.lang.String r0 = "code"
            r1 = -1
            r2 = 0
            com.amap.api.mapcore.util.ia r3 = r10.f9128f     // Catch:{ all -> 0x0098 }
            boolean r3 = r3.d()     // Catch:{ all -> 0x0098 }
            if (r3 == 0) goto L_0x008d
            com.amap.api.mapcore.util.ia r3 = r10.f9128f     // Catch:{ all -> 0x0098 }
            r4 = 1
            r3.a_((boolean) r4)     // Catch:{ all -> 0x0098 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0098 }
            java.lang.String r5 = r10.f9123a     // Catch:{ all -> 0x0098 }
            r3.<init>(r5)     // Catch:{ all -> 0x0098 }
            long r5 = r10.f9124b     // Catch:{ all -> 0x0098 }
            com.amap.api.mapcore.util.gt r3 = com.amap.api.mapcore.util.gt.a((java.io.File) r3, (long) r5)     // Catch:{ all -> 0x0098 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x008a }
            r5.<init>()     // Catch:{ all -> 0x008a }
            byte[] r6 = a((com.amap.api.mapcore.util.gt) r3, (com.amap.api.mapcore.util.hg) r10, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x008a }
            if (r6 == 0) goto L_0x007f
            int r7 = r6.length     // Catch:{ all -> 0x008a }
            if (r7 != 0) goto L_0x002e
            goto L_0x007f
        L_0x002e:
            com.amap.api.mapcore.util.fy r7 = new com.amap.api.mapcore.util.fy     // Catch:{ all -> 0x008a }
            java.lang.String r8 = r10.f9125c     // Catch:{ all -> 0x008a }
            r7.<init>(r6, r8)     // Catch:{ all -> 0x008a }
            com.amap.api.mapcore.util.gw.a()     // Catch:{ all -> 0x008a }
            com.amap.api.mapcore.util.he r7 = com.amap.api.mapcore.util.gw.b(r7)     // Catch:{ all -> 0x008a }
            byte[] r7 = r7.f9117a     // Catch:{ all -> 0x008a }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x008a }
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x008a }
            r9.<init>(r7)     // Catch:{ all -> 0x008a }
            r8.<init>(r9)     // Catch:{ all -> 0x008a }
            boolean r7 = r8.has(r0)     // Catch:{ all -> 0x008a }
            if (r7 == 0) goto L_0x007d
            int r0 = r8.getInt(r0)     // Catch:{ all -> 0x008a }
            if (r0 != r4) goto L_0x007d
            com.amap.api.mapcore.util.ia r0 = r10.f9128f     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x0060
            if (r6 == 0) goto L_0x0060
            com.amap.api.mapcore.util.ia r0 = r10.f9128f     // Catch:{ all -> 0x008a }
            int r4 = r6.length     // Catch:{ all -> 0x008a }
            r0.a_((int) r4)     // Catch:{ all -> 0x008a }
        L_0x0060:
            com.amap.api.mapcore.util.ia r10 = r10.f9128f     // Catch:{ all -> 0x008a }
            int r10 = r10.a()     // Catch:{ all -> 0x008a }
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r10 >= r0) goto L_0x006f
            a((com.amap.api.mapcore.util.gt) r3, (java.util.List<java.lang.String>) r5)     // Catch:{ all -> 0x008a }
            goto L_0x007b
        L_0x006f:
            r3.d()     // Catch:{ all -> 0x0073 }
            goto L_0x007b
        L_0x0073:
            r10 = move-exception
            java.lang.String r0 = "ofm"
            java.lang.String r4 = "dlo"
            com.amap.api.mapcore.util.fz.c(r10, r0, r4)     // Catch:{ all -> 0x008a }
        L_0x007b:
            int r10 = r6.length     // Catch:{ all -> 0x0098 }
            return r10
        L_0x007d:
            r2 = r3
            goto L_0x008d
        L_0x007f:
            if (r3 == 0) goto L_0x0089
            r3.close()     // Catch:{ all -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0089:
            return r1
        L_0x008a:
            r10 = move-exception
            r2 = r3
            goto L_0x0099
        L_0x008d:
            if (r2 == 0) goto L_0x00a5
            r2.close()     // Catch:{ all -> 0x0093 }
            goto L_0x00a5
        L_0x0093:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x00a5
        L_0x0098:
            r10 = move-exception
        L_0x0099:
            java.lang.String r0 = "leg"
            java.lang.String r3 = "uts"
            com.amap.api.mapcore.util.fz.c(r10, r0, r3)     // Catch:{ all -> 0x00a6 }
            if (r2 == 0) goto L_0x00a5
            r2.close()     // Catch:{ all -> 0x0093 }
        L_0x00a5:
            return r1
        L_0x00a6:
            r10 = move-exception
            if (r2 == 0) goto L_0x00b1
            r2.close()     // Catch:{ all -> 0x00ad }
            goto L_0x00b1
        L_0x00ad:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.hh.a(com.amap.api.mapcore.util.hg):int");
    }

    private static void a(gt gtVar, List<String> list) {
        if (gtVar != null) {
            try {
                for (String c2 : list) {
                    gtVar.c(c2);
                }
                gtVar.close();
            } catch (Throwable th) {
                fz.c(th, "ofm", "dlo");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC, Splitter:B:25:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061 A[SYNTHETIC, Splitter:B:30:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r4, byte[] r5, com.amap.api.mapcore.util.hg r6) throws java.io.IOException, java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, javax.crypto.IllegalBlockSizeException, javax.crypto.BadPaddingException, javax.crypto.NoSuchPaddingException, java.security.InvalidKeyException, java.security.spec.InvalidKeySpecException {
        /*
            r0 = 0
            java.lang.String r1 = r6.f9123a     // Catch:{ all -> 0x0053 }
            boolean r1 = a((java.lang.String) r1, (java.lang.String) r4)     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x000a
            return
        L_0x000a:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = r6.f9123a     // Catch:{ all -> 0x0053 }
            r1.<init>(r2)     // Catch:{ all -> 0x0053 }
            boolean r2 = r1.exists()     // Catch:{ all -> 0x0053 }
            if (r2 != 0) goto L_0x001a
            r1.mkdirs()     // Catch:{ all -> 0x0053 }
        L_0x001a:
            long r2 = r6.f9124b     // Catch:{ all -> 0x0053 }
            com.amap.api.mapcore.util.gt r1 = com.amap.api.mapcore.util.gt.a((java.io.File) r1, (long) r2)     // Catch:{ all -> 0x0053 }
            int r2 = r6.f9126d     // Catch:{ all -> 0x0051 }
            r1.a((int) r2)     // Catch:{ all -> 0x0051 }
            com.amap.api.mapcore.util.gq r6 = r6.f9127e     // Catch:{ all -> 0x0051 }
            byte[] r5 = r6.b(r5)     // Catch:{ all -> 0x0051 }
            com.amap.api.mapcore.util.gt$a r4 = r1.b((java.lang.String) r4)     // Catch:{ all -> 0x0051 }
            java.io.OutputStream r0 = r4.a()     // Catch:{ all -> 0x0051 }
            r0.write(r5)     // Catch:{ all -> 0x0051 }
            r4.b()     // Catch:{ all -> 0x0051 }
            r1.c()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0046
            r0.close()     // Catch:{ all -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0046:
            if (r1 == 0) goto L_0x0050
            r1.close()     // Catch:{ all -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0050:
            return
        L_0x0051:
            r4 = move-exception
            goto L_0x0055
        L_0x0053:
            r4 = move-exception
            r1 = r0
        L_0x0055:
            if (r0 == 0) goto L_0x005f
            r0.close()     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005f:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ all -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0069:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.hh.a(java.lang.String, byte[], com.amap.api.mapcore.util.hg):void");
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            fz.c(th, "leg", "fet");
            return false;
        }
    }

    private static byte[] a(gt gtVar, hg hgVar, List<String> list) {
        try {
            File b2 = gtVar.b();
            if (b2 != null && b2.exists()) {
                int i2 = 0;
                for (String str : b2.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a2 = hn.a(gtVar, str2);
                        i2 += a2.length;
                        list.add(str2);
                        if (i2 > hgVar.f9128f.a()) {
                            break;
                        }
                        hgVar.f9129g.b(a2);
                    }
                }
                if (i2 <= 0) {
                    return null;
                }
                return hgVar.f9129g.a();
            }
        } catch (Throwable th) {
            fz.c(th, "leg", "gCo");
        }
        return new byte[0];
    }
}
