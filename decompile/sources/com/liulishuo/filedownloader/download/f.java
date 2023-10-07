package com.liulishuo.filedownloader.download;

import android.os.SystemClock;
import im.b;
import iq.d;
import java.io.IOException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    long f21303a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21304b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21305c;

    /* renamed from: d  reason: collision with root package name */
    private final int f21306d;

    /* renamed from: e  reason: collision with root package name */
    private final d f21307e;

    /* renamed from: f  reason: collision with root package name */
    private final b f21308f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21309g;

    /* renamed from: h  reason: collision with root package name */
    private final long f21310h;

    /* renamed from: i  reason: collision with root package name */
    private final long f21311i;

    /* renamed from: j  reason: collision with root package name */
    private final long f21312j;

    /* renamed from: k  reason: collision with root package name */
    private final String f21313k;

    /* renamed from: l  reason: collision with root package name */
    private ip.a f21314l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f21315m;

    /* renamed from: n  reason: collision with root package name */
    private final in.a f21316n;

    /* renamed from: o  reason: collision with root package name */
    private volatile long f21317o;

    /* renamed from: p  reason: collision with root package name */
    private volatile long f21318p;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        d f21319a;

        /* renamed from: b  reason: collision with root package name */
        b f21320b;

        /* renamed from: c  reason: collision with root package name */
        b f21321c;

        /* renamed from: d  reason: collision with root package name */
        g f21322d;

        /* renamed from: e  reason: collision with root package name */
        String f21323e;

        /* renamed from: f  reason: collision with root package name */
        Boolean f21324f;

        /* renamed from: g  reason: collision with root package name */
        Integer f21325g;

        /* renamed from: h  reason: collision with root package name */
        Integer f21326h;

        public a a(int i2) {
            this.f21325g = Integer.valueOf(i2);
            return this;
        }

        public a a(b bVar) {
            this.f21321c = bVar;
            return this;
        }

        public a a(d dVar) {
            this.f21319a = dVar;
            return this;
        }

        public a a(g gVar) {
            this.f21322d = gVar;
            return this;
        }

        public a a(b bVar) {
            this.f21320b = bVar;
            return this;
        }

        public a a(String str) {
            this.f21323e = str;
            return this;
        }

        public a a(boolean z2) {
            this.f21324f = Boolean.valueOf(z2);
            return this;
        }

        public f a() throws IllegalArgumentException {
            b bVar;
            b bVar2;
            Integer num;
            if (this.f21324f != null && (bVar = this.f21320b) != null && (bVar2 = this.f21321c) != null && this.f21322d != null && this.f21323e != null && (num = this.f21326h) != null && this.f21325g != null) {
                return new f(bVar, bVar2, this.f21319a, num.intValue(), this.f21325g.intValue(), this.f21324f.booleanValue(), this.f21322d, this.f21323e);
            }
            throw new IllegalArgumentException();
        }

        public a b(int i2) {
            this.f21326h = Integer.valueOf(i2);
            return this;
        }
    }

    private f(b bVar, b bVar2, d dVar, int i2, int i3, boolean z2, g gVar, String str) {
        this.f21317o = 0;
        this.f21318p = 0;
        this.f21304b = gVar;
        this.f21313k = str;
        this.f21308f = bVar;
        this.f21309g = z2;
        this.f21307e = dVar;
        this.f21306d = i3;
        this.f21305c = i2;
        this.f21316n = c.a().c();
        this.f21310h = bVar2.f21257a;
        this.f21311i = bVar2.f21259c;
        this.f21303a = bVar2.f21258b;
        this.f21312j = bVar2.f21260d;
    }

    private void c() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (iq.f.a(this.f21303a - this.f21317o, elapsedRealtime - this.f21318p)) {
            d();
            this.f21317o = this.f21303a;
            this.f21318p = elapsedRealtime;
        }
    }

    private void d() {
        boolean z2;
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            this.f21314l.a();
            z2 = true;
        } catch (IOException e2) {
            if (d.f29057a) {
                d.c(this, "Because of the system cannot guarantee that all the buffers have been synchronized with physical media, or write to filefailed, we just not flushAndSync process to database too %s", e2);
            }
            z2 = false;
        }
        if (z2) {
            int i2 = this.f21306d;
            if (i2 >= 0) {
                this.f21316n.a(this.f21305c, i2, this.f21303a);
            } else {
                this.f21304b.c();
            }
            if (d.f29057a) {
                d.c(this, "require flushAndSync id[%d] index[%d] offset[%d], consume[%d]", Integer.valueOf(this.f21305c), Integer.valueOf(this.f21306d), Long.valueOf(this.f21303a), Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
        }
    }

    public void a() {
        this.f21315m = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0206 A[SYNTHETIC, Splitter:B:129:0x0206] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0211 A[SYNTHETIC, Splitter:B:134:0x0211] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0225 A[SYNTHETIC, Splitter:B:145:0x0225] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() throws java.io.IOException, java.lang.IllegalAccessException, java.lang.IllegalArgumentException, com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException {
        /*
            r19 = this;
            r1 = r19
            boolean r0 = r1.f21315m
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            int r0 = r1.f21306d
            im.b r2 = r1.f21308f
            long r2 = iq.f.c((int) r0, (im.b) r2)
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x001b
            im.b r0 = r1.f21308f
            long r2 = iq.f.c((im.b) r0)
        L_0x001b:
            r6 = 0
            r8 = 2
            r9 = 1
            r10 = 0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x022f
            long r11 = r1.f21312j
            r13 = 5
            r14 = 4
            r15 = 3
            int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x008e
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x008e
            long r6 = r1.f21311i
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0048
            java.lang.Object[] r0 = new java.lang.Object[r9]
            long r4 = r1.f21303a
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r0[r10] = r4
            java.lang.String r4 = "range[%d-)"
            java.lang.String r0 = iq.f.a((java.lang.String) r4, (java.lang.Object[]) r0)
            goto L_0x0060
        L_0x0048:
            java.lang.Object[] r0 = new java.lang.Object[r8]
            long r4 = r1.f21303a
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r0[r10] = r4
            long r4 = r1.f21311i
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r0[r9] = r4
            java.lang.String r4 = "range[%d-%d)"
            java.lang.String r0 = iq.f.a((java.lang.String) r4, (java.lang.Object[]) r0)
        L_0x0060:
            com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException r4 = new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException
            java.lang.Object[] r5 = new java.lang.Object[r13]
            r5[r10] = r0
            long r6 = r1.f21312j
            java.lang.Long r0 = java.lang.Long.valueOf(r6)
            r5[r9] = r0
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            r5[r8] = r0
            int r0 = r1.f21305c
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r15] = r0
            int r0 = r1.f21306d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r14] = r0
            java.lang.String r0 = "require %s with contentLength(%d), but the backend response contentLength is %d on downloadId[%d]-connectionIndex[%d], please ask your backend dev to fix such problem."
            java.lang.String r0 = iq.f.a((java.lang.String) r0, (java.lang.Object[]) r5)
            r4.<init>(r0)
            throw r4
        L_0x008e:
            long r6 = r1.f21303a
            r11 = 0
            com.liulishuo.filedownloader.download.c r0 = com.liulishuo.filedownloader.download.c.a()     // Catch:{ all -> 0x0201 }
            boolean r0 = r0.f()     // Catch:{ all -> 0x0201 }
            com.liulishuo.filedownloader.download.d r12 = r1.f21307e     // Catch:{ all -> 0x0201 }
            if (r12 == 0) goto L_0x00a8
            if (r0 == 0) goto L_0x00a0
            goto L_0x00a8
        L_0x00a0:
            java.lang.IllegalAccessException r0 = new java.lang.IllegalAccessException     // Catch:{ all -> 0x0201 }
            java.lang.String r2 = "can't using multi-download when the output stream can't support seek"
            r0.<init>(r2)     // Catch:{ all -> 0x0201 }
            throw r0     // Catch:{ all -> 0x0201 }
        L_0x00a8:
            java.lang.String r12 = r1.f21313k     // Catch:{ all -> 0x0201 }
            ip.a r12 = iq.f.n(r12)     // Catch:{ all -> 0x0201 }
            r1.f21314l = r12     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x00b7
            long r4 = r1.f21303a     // Catch:{ all -> 0x01fe }
            r12.a(r4)     // Catch:{ all -> 0x01fe }
        L_0x00b7:
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x00e2
            java.lang.String r0 = "start fetch(%d): range [%d, %d), seek to[%d]"
            java.lang.Object[] r4 = new java.lang.Object[r14]     // Catch:{ all -> 0x01fe }
            int r5 = r1.f21306d     // Catch:{ all -> 0x01fe }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01fe }
            r4[r10] = r5     // Catch:{ all -> 0x01fe }
            long r13 = r1.f21310h     // Catch:{ all -> 0x01fe }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x01fe }
            r4[r9] = r13     // Catch:{ all -> 0x01fe }
            long r13 = r1.f21311i     // Catch:{ all -> 0x01fe }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x01fe }
            r4[r8] = r13     // Catch:{ all -> 0x01fe }
            long r13 = r1.f21303a     // Catch:{ all -> 0x01fe }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x01fe }
            r4[r15] = r13     // Catch:{ all -> 0x01fe }
            iq.d.c(r1, r0, r4)     // Catch:{ all -> 0x01fe }
        L_0x00e2:
            im.b r0 = r1.f21308f     // Catch:{ all -> 0x01fe }
            java.io.InputStream r11 = r0.a()     // Catch:{ all -> 0x01fe }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x01fe }
            boolean r4 = r1.f21315m     // Catch:{ all -> 0x01fe }
            if (r4 == 0) goto L_0x011b
            if (r11 == 0) goto L_0x00fb
            r11.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00fb
        L_0x00f6:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x00fb:
            if (r12 == 0) goto L_0x010f
            r19.d()     // Catch:{ all -> 0x0101 }
            goto L_0x010f
        L_0x0101:
            r0 = move-exception
            r2 = r0
            if (r12 == 0) goto L_0x010e
            r12.b()     // Catch:{ IOException -> 0x0109 }
            goto L_0x010e
        L_0x0109:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x010e:
            throw r2
        L_0x010f:
            if (r12 == 0) goto L_0x011a
            r12.b()     // Catch:{ IOException -> 0x0115 }
            goto L_0x011a
        L_0x0115:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x011a:
            return
        L_0x011b:
            int r4 = r11.read(r0)     // Catch:{ all -> 0x01fe }
            r13 = -1
            if (r4 != r13) goto L_0x01a2
            if (r11 == 0) goto L_0x012d
            r11.close()     // Catch:{ IOException -> 0x0128 }
            goto L_0x012d
        L_0x0128:
            r0 = move-exception
            r4 = r0
            r4.printStackTrace()
        L_0x012d:
            if (r12 == 0) goto L_0x0141
            r19.d()     // Catch:{ all -> 0x0133 }
            goto L_0x0141
        L_0x0133:
            r0 = move-exception
            r2 = r0
            if (r12 == 0) goto L_0x0140
            r12.b()     // Catch:{ IOException -> 0x013b }
            goto L_0x0140
        L_0x013b:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x0140:
            throw r2
        L_0x0141:
            if (r12 == 0) goto L_0x014c
            r12.b()     // Catch:{ IOException -> 0x0147 }
            goto L_0x014c
        L_0x0147:
            r0 = move-exception
            r4 = r0
            r4.printStackTrace()
        L_0x014c:
            long r11 = r1.f21303a
            long r11 = r11 - r6
            r13 = -1
            int r0 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x0196
            int r0 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x015a
            goto L_0x0196
        L_0x015a:
            com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException r0 = new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException
            r4 = 6
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r4[r10] = r11
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4[r9] = r2
            long r2 = r1.f21310h
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4[r8] = r2
            long r2 = r1.f21311i
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4[r15] = r2
            long r2 = r1.f21303a
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r16 = 4
            r4[r16] = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            r5 = 5
            r4[r5] = r2
            java.lang.String r2 = "fetched length[%d] != content length[%d], range[%d, %d) offset[%d] fetch begin offset[%d]"
            java.lang.String r2 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r4)
            r0.<init>(r2)
            throw r0
        L_0x0196:
            com.liulishuo.filedownloader.download.g r3 = r1.f21304b
            com.liulishuo.filedownloader.download.d r4 = r1.f21307e
            long r5 = r1.f21310h
            long r7 = r1.f21311i
            r3.a(r4, r5, r7)
            return
        L_0x01a2:
            r5 = 5
            r13 = -1
            r16 = 4
            r12.a(r0, r10, r4)     // Catch:{ all -> 0x01fe }
            r17 = r6
            long r5 = r1.f21303a     // Catch:{ all -> 0x01fe }
            long r13 = (long) r4     // Catch:{ all -> 0x01fe }
            long r5 = r5 + r13
            r1.f21303a = r5     // Catch:{ all -> 0x01fe }
            com.liulishuo.filedownloader.download.g r4 = r1.f21304b     // Catch:{ all -> 0x01fe }
            r4.a((long) r13)     // Catch:{ all -> 0x01fe }
            r19.c()     // Catch:{ all -> 0x01fe }
            boolean r4 = r1.f21315m     // Catch:{ all -> 0x01fe }
            if (r4 == 0) goto L_0x01e9
            if (r11 == 0) goto L_0x01c9
            r11.close()     // Catch:{ IOException -> 0x01c4 }
            goto L_0x01c9
        L_0x01c4:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x01c9:
            if (r12 == 0) goto L_0x01dd
            r19.d()     // Catch:{ all -> 0x01cf }
            goto L_0x01dd
        L_0x01cf:
            r0 = move-exception
            r2 = r0
            if (r12 == 0) goto L_0x01dc
            r12.b()     // Catch:{ IOException -> 0x01d7 }
            goto L_0x01dc
        L_0x01d7:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x01dc:
            throw r2
        L_0x01dd:
            if (r12 == 0) goto L_0x01e8
            r12.b()     // Catch:{ IOException -> 0x01e3 }
            goto L_0x01e8
        L_0x01e3:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
        L_0x01e8:
            return
        L_0x01e9:
            boolean r4 = r1.f21309g     // Catch:{ all -> 0x01fe }
            if (r4 == 0) goto L_0x01fa
            boolean r4 = iq.f.d()     // Catch:{ all -> 0x01fe }
            if (r4 != 0) goto L_0x01f4
            goto L_0x01fa
        L_0x01f4:
            com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException r0 = new com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException     // Catch:{ all -> 0x01fe }
            r0.<init>()     // Catch:{ all -> 0x01fe }
            throw r0     // Catch:{ all -> 0x01fe }
        L_0x01fa:
            r6 = r17
            goto L_0x011b
        L_0x01fe:
            r0 = move-exception
            r2 = r0
            goto L_0x0204
        L_0x0201:
            r0 = move-exception
            r2 = r0
            r12 = r11
        L_0x0204:
            if (r11 == 0) goto L_0x020f
            r11.close()     // Catch:{ IOException -> 0x020a }
            goto L_0x020f
        L_0x020a:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x020f:
            if (r12 == 0) goto L_0x0223
            r19.d()     // Catch:{ all -> 0x0215 }
            goto L_0x0223
        L_0x0215:
            r0 = move-exception
            r2 = r0
            if (r12 == 0) goto L_0x0222
            r12.b()     // Catch:{ IOException -> 0x021d }
            goto L_0x0222
        L_0x021d:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x0222:
            throw r2
        L_0x0223:
            if (r12 == 0) goto L_0x022e
            r12.b()     // Catch:{ IOException -> 0x0229 }
            goto L_0x022e
        L_0x0229:
            r0 = move-exception
            r3 = r0
            r3.printStackTrace()
        L_0x022e:
            throw r2
        L_0x022f:
            com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException r0 = new com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException
            java.lang.Object[] r2 = new java.lang.Object[r8]
            int r3 = r1.f21305c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r10] = r3
            int r3 = r1.f21306d
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r9] = r3
            java.lang.String r3 = "there isn't any content need to download on %d-%d with the content-length is 0"
            java.lang.String r2 = iq.f.a((java.lang.String) r3, (java.lang.Object[]) r2)
            r0.<init>(r2)
            goto L_0x024e
        L_0x024d:
            throw r0
        L_0x024e:
            goto L_0x024d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.f.b():void");
    }
}
