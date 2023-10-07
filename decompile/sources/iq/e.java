package iq;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f29058a;

    /* renamed from: b  reason: collision with root package name */
    public final long f29059b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f29060c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f29061d;

    /* renamed from: e  reason: collision with root package name */
    public final int f29062e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f29063f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f29064g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f29065h;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final e f29066a = new e();
    }

    /* JADX WARNING: type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v2, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: type inference failed for: r10v3 */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0294 A[SYNTHETIC, Splitter:B:126:0x0294] */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ad A[Catch:{ all -> 0x0290 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bf A[Catch:{ all -> 0x0290 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c6 A[SYNTHETIC, Splitter:B:58:0x00c6] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private e() {
        /*
            r26 = this;
            r1 = r26
            java.lang.String r2 = "download.max-network-thread-count"
            java.lang.String r3 = "download.min-progress-time"
            java.lang.String r4 = "download.min-progress-step"
            java.lang.Class<iq.e> r5 = iq.e.class
            java.lang.String r6 = "download.trial-connection-head-method"
            java.lang.String r7 = "broadcast.completed"
            java.lang.String r8 = "file.non-pre-allocation"
            java.lang.String r9 = "process.non-separate"
            java.lang.String r10 = "http.lenient"
            r26.<init>()
            android.content.Context r0 = iq.c.a()
            if (r0 == 0) goto L_0x029e
            long r11 = java.lang.System.currentTimeMillis()
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            android.content.Context r15 = iq.c.a()     // Catch:{ IOException -> 0x009a, all -> 0x0095 }
            android.content.res.AssetManager r15 = r15.getAssets()     // Catch:{ IOException -> 0x009a, all -> 0x0095 }
            java.lang.String r13 = "filedownloader.properties"
            java.io.InputStream r13 = r15.open(r13)     // Catch:{ IOException -> 0x009a, all -> 0x0095 }
            if (r13 == 0) goto L_0x006e
            r0.load(r13)     // Catch:{ IOException -> 0x006c }
            java.lang.String r15 = r0.getProperty(r10)     // Catch:{ IOException -> 0x006c }
            java.lang.String r17 = r0.getProperty(r9)     // Catch:{ IOException -> 0x006a }
            java.lang.String r18 = r0.getProperty(r4)     // Catch:{ IOException -> 0x0068 }
            java.lang.String r19 = r0.getProperty(r3)     // Catch:{ IOException -> 0x0066 }
            java.lang.String r20 = r0.getProperty(r2)     // Catch:{ IOException -> 0x0064 }
            java.lang.String r21 = r0.getProperty(r8)     // Catch:{ IOException -> 0x0062 }
            java.lang.String r22 = r0.getProperty(r7)     // Catch:{ IOException -> 0x0060 }
            java.lang.String r0 = r0.getProperty(r6)     // Catch:{ IOException -> 0x005e }
            r16 = r17
            r17 = r0
            goto L_0x007d
        L_0x005e:
            r0 = move-exception
            goto L_0x00a9
        L_0x0060:
            r0 = move-exception
            goto L_0x00a7
        L_0x0062:
            r0 = move-exception
            goto L_0x00a5
        L_0x0064:
            r0 = move-exception
            goto L_0x00a3
        L_0x0066:
            r0 = move-exception
            goto L_0x00a1
        L_0x0068:
            r0 = move-exception
            goto L_0x009f
        L_0x006a:
            r0 = move-exception
            goto L_0x009d
        L_0x006c:
            r0 = move-exception
            goto L_0x009c
        L_0x006e:
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
        L_0x007d:
            if (r13 == 0) goto L_0x0088
            r13.close()     // Catch:{ IOException -> 0x0083 }
            goto L_0x0088
        L_0x0083:
            r0 = move-exception
            r13 = r0
            r13.printStackTrace()
        L_0x0088:
            r0 = r16
            r13 = r17
            r14 = r21
            r17 = r2
            r16 = r5
            r5 = r22
            goto L_0x00dc
        L_0x0095:
            r0 = move-exception
            r2 = r0
            r13 = 0
            goto L_0x0292
        L_0x009a:
            r0 = move-exception
            r13 = 0
        L_0x009c:
            r15 = 0
        L_0x009d:
            r17 = 0
        L_0x009f:
            r18 = 0
        L_0x00a1:
            r19 = 0
        L_0x00a3:
            r20 = 0
        L_0x00a5:
            r21 = 0
        L_0x00a7:
            r22 = 0
        L_0x00a9:
            boolean r14 = r0 instanceof java.io.FileNotFoundException     // Catch:{ all -> 0x0290 }
            if (r14 == 0) goto L_0x00bf
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x0290 }
            if (r0 == 0) goto L_0x00bc
            java.lang.String r0 = "not found filedownloader.properties"
            r23 = r15
            r14 = 0
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ all -> 0x0290 }
            iq.d.c(r5, r0, r15)     // Catch:{ all -> 0x0290 }
            goto L_0x00c4
        L_0x00bc:
            r23 = r15
            goto L_0x00c4
        L_0x00bf:
            r23 = r15
            r0.printStackTrace()     // Catch:{ all -> 0x0290 }
        L_0x00c4:
            if (r13 == 0) goto L_0x00cf
            r13.close()     // Catch:{ IOException -> 0x00ca }
            goto L_0x00cf
        L_0x00ca:
            r0 = move-exception
            r13 = r0
            r13.printStackTrace()
        L_0x00cf:
            r16 = r5
            r0 = r17
            r14 = r21
            r5 = r22
            r15 = r23
            r13 = 0
            r17 = r2
        L_0x00dc:
            java.lang.String r2 = "the value of '%s' must be '%s' or '%s'"
            r21 = 2
            r22 = 1
            r23 = r3
            java.lang.String r3 = "false"
            r24 = r4
            java.lang.String r4 = "true"
            if (r15 == 0) goto L_0x0117
            boolean r25 = r15.equals(r4)
            if (r25 != 0) goto L_0x010d
            boolean r25 = r15.equals(r3)
            if (r25 == 0) goto L_0x00f9
            goto L_0x010d
        L_0x00f9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 0
            r5[r6] = r10
            r5[r22] = r4
            r5[r21] = r3
            java.lang.String r2 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r5)
            r0.<init>(r2)
            throw r0
        L_0x010d:
            r25 = r10
            r10 = 0
            boolean r15 = r15.equals(r4)
            r1.f29060c = r15
            goto L_0x011c
        L_0x0117:
            r25 = r10
            r10 = 0
            r1.f29060c = r10
        L_0x011c:
            if (r0 == 0) goto L_0x0145
            boolean r15 = r0.equals(r4)
            if (r15 != 0) goto L_0x013e
            boolean r15 = r0.equals(r3)
            if (r15 == 0) goto L_0x012b
            goto L_0x013e
        L_0x012b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r10] = r9
            r5[r22] = r4
            r5[r21] = r3
            java.lang.String r2 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r5)
            r0.<init>(r2)
            throw r0
        L_0x013e:
            boolean r0 = r0.equals(r4)
            r1.f29061d = r0
            goto L_0x0147
        L_0x0145:
            r1.f29061d = r10
        L_0x0147:
            if (r18 == 0) goto L_0x0156
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            int r0 = r0.intValue()
            int r0 = java.lang.Math.max(r10, r0)
            goto L_0x0158
        L_0x0156:
            r0 = 65536(0x10000, float:9.18355E-41)
        L_0x0158:
            r1.f29058a = r0
            if (r19 == 0) goto L_0x016e
            java.lang.Long r0 = java.lang.Long.valueOf(r19)
            r15 = r9
            long r9 = r0.longValue()
            r18 = r11
            r11 = 0
            long r9 = java.lang.Math.max(r11, r9)
            goto L_0x0173
        L_0x016e:
            r15 = r9
            r18 = r11
            r9 = 2000(0x7d0, double:9.88E-321)
        L_0x0173:
            r1.f29059b = r9
            if (r20 == 0) goto L_0x0187
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            int r0 = r0.intValue()
            int r0 = a(r0)
            r1.f29062e = r0
            r0 = 3
            goto L_0x018a
        L_0x0187:
            r0 = 3
            r1.f29062e = r0
        L_0x018a:
            if (r14 == 0) goto L_0x01b4
            boolean r9 = r14.equals(r4)
            if (r9 != 0) goto L_0x01ac
            boolean r9 = r14.equals(r3)
            if (r9 == 0) goto L_0x0199
            goto L_0x01ac
        L_0x0199:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r9 = 0
            r0[r9] = r8
            r0[r22] = r4
            r0[r21] = r3
            java.lang.String r0 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r0)
            r5.<init>(r0)
            throw r5
        L_0x01ac:
            r9 = 0
            boolean r0 = r14.equals(r4)
            r1.f29063f = r0
            goto L_0x01b7
        L_0x01b4:
            r9 = 0
            r1.f29063f = r9
        L_0x01b7:
            if (r5 == 0) goto L_0x01e0
            boolean r0 = r5.equals(r4)
            if (r0 != 0) goto L_0x01d9
            boolean r0 = r5.equals(r3)
            if (r0 == 0) goto L_0x01c6
            goto L_0x01d9
        L_0x01c6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r9] = r7
            r5[r22] = r4
            r5[r21] = r3
            java.lang.String r2 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r5)
            r0.<init>(r2)
            throw r0
        L_0x01d9:
            boolean r0 = r5.equals(r4)
            r1.f29064g = r0
            goto L_0x01e2
        L_0x01e0:
            r1.f29064g = r9
        L_0x01e2:
            if (r13 == 0) goto L_0x020b
            boolean r0 = r13.equals(r4)
            if (r0 != 0) goto L_0x0204
            boolean r0 = r13.equals(r3)
            if (r0 == 0) goto L_0x01f1
            goto L_0x0204
        L_0x01f1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r9] = r6
            r5[r22] = r4
            r5[r21] = r3
            java.lang.String r2 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r5)
            r0.<init>(r2)
            throw r0
        L_0x0204:
            boolean r0 = r13.equals(r4)
            r1.f29065h = r0
            goto L_0x020d
        L_0x020b:
            r1.f29065h = r9
        L_0x020d:
            boolean r0 = iq.d.f29057a
            if (r0 == 0) goto L_0x028f
            r0 = 17
            java.lang.Object[] r0 = new java.lang.Object[r0]
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r18
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0[r9] = r2
            r0[r22] = r25
            boolean r2 = r1.f29060c
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0[r21] = r2
            r2 = 3
            r0[r2] = r15
            r2 = 4
            boolean r3 = r1.f29061d
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r0[r2] = r3
            r2 = 5
            r0[r2] = r24
            r2 = 6
            int r3 = r1.f29058a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0[r2] = r3
            r2 = 7
            r0[r2] = r23
            r2 = 8
            long r3 = r1.f29059b
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r0[r2] = r3
            r2 = 9
            r0[r2] = r17
            r2 = 10
            int r3 = r1.f29062e
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0[r2] = r3
            r2 = 11
            r0[r2] = r8
            r2 = 12
            boolean r3 = r1.f29063f
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r0[r2] = r3
            r2 = 13
            r0[r2] = r7
            r2 = 14
            boolean r3 = r1.f29064g
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r0[r2] = r3
            r2 = 15
            r0[r2] = r6
            r2 = 16
            boolean r3 = r1.f29065h
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r0[r2] = r3
            java.lang.String r2 = "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B"
            r3 = r16
            iq.d.b(r3, r2, r0)
        L_0x028f:
            return
        L_0x0290:
            r0 = move-exception
            r2 = r0
        L_0x0292:
            if (r13 == 0) goto L_0x029d
            r13.close()     // Catch:{ IOException -> 0x0298 }
            goto L_0x029d
        L_0x0298:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x029d:
            throw r2
        L_0x029e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: iq.e.<init>():void");
    }

    public static int a(int i2) {
        Class<e> cls = e.class;
        if (i2 > 12) {
            d.d(cls, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 12, 12);
            return 12;
        } else if (i2 >= 1) {
            return i2;
        } else {
            d.d(cls, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i2), 1, 1);
            return 1;
        }
    }

    public static e a() {
        return a.f29066a;
    }
}
