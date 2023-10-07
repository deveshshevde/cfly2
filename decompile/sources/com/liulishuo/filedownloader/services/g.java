package com.liulishuo.filedownloader.services;

import com.liulishuo.filedownloader.download.c;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.model.b;
import com.liulishuo.filedownloader.y;
import in.a;
import iq.d;
import iq.f;
import java.util.List;

class g implements y {

    /* renamed from: a  reason: collision with root package name */
    private final a f21463a;

    /* renamed from: b  reason: collision with root package name */
    private final h f21464b;

    g() {
        c a2 = c.a();
        this.f21463a = a2.c();
        this.f21464b = new h(a2.e());
    }

    public int a(String str, int i2) {
        return this.f21464b.a(str, i2);
    }

    public void a() {
        List<Integer> b2 = this.f21464b.b();
        if (d.f29057a) {
            d.c(this, "pause all tasks %d", Integer.valueOf(b2.size()));
        }
        for (Integer intValue : b2) {
            b(intValue.intValue());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f7, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r19, java.lang.String r20, boolean r21, int r22, int r23, int r24, boolean r25, com.liulishuo.filedownloader.model.FileDownloadHeader r26, boolean r27) {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r8 = r20
            r9 = r21
            monitor-enter(r18)
            boolean r1 = iq.d.f29057a     // Catch:{ all -> 0x01ce }
            r10 = 2
            r11 = 0
            r12 = 1
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = "request start the task with url(%s) path(%s) isDirectory(%B)"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x01ce }
            r2[r11] = r0     // Catch:{ all -> 0x01ce }
            r2[r12] = r8     // Catch:{ all -> 0x01ce }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r21)     // Catch:{ all -> 0x01ce }
            r2[r10] = r3     // Catch:{ all -> 0x01ce }
            iq.d.c(r7, r1, r2)     // Catch:{ all -> 0x01ce }
        L_0x0022:
            com.liulishuo.filedownloader.ab.b()     // Catch:{ all -> 0x01ce }
            int r13 = iq.f.a((java.lang.String) r19, (java.lang.String) r20, (boolean) r21)     // Catch:{ all -> 0x01ce }
            in.a r1 = r7.f21463a     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r1.b(r13)     // Catch:{ all -> 0x01ce }
            r2 = 0
            if (r9 != 0) goto L_0x0070
            if (r1 != 0) goto L_0x0070
            java.lang.String r1 = iq.f.i(r20)     // Catch:{ all -> 0x01ce }
            int r1 = iq.f.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r12)     // Catch:{ all -> 0x01ce }
            in.a r3 = r7.f21463a     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.model.FileDownloadModel r3 = r3.b(r1)     // Catch:{ all -> 0x01ce }
            if (r3 == 0) goto L_0x006d
            java.lang.String r4 = r3.d()     // Catch:{ all -> 0x01ce }
            boolean r4 = r8.equals(r4)     // Catch:{ all -> 0x01ce }
            if (r4 == 0) goto L_0x006d
            boolean r4 = iq.d.f29057a     // Catch:{ all -> 0x01ce }
            if (r4 == 0) goto L_0x0065
            java.lang.String r4 = "task[%d] find model by dirCaseId[%d]"
            java.lang.Object[] r5 = new java.lang.Object[r10]     // Catch:{ all -> 0x01ce }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01ce }
            r5[r11] = r6     // Catch:{ all -> 0x01ce }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x01ce }
            r5[r12] = r6     // Catch:{ all -> 0x01ce }
            iq.d.c(r7, r4, r5)     // Catch:{ all -> 0x01ce }
        L_0x0065:
            in.a r4 = r7.f21463a     // Catch:{ all -> 0x01ce }
            java.util.List r1 = r4.c(r1)     // Catch:{ all -> 0x01ce }
            r15 = r1
            goto L_0x006e
        L_0x006d:
            r15 = r2
        L_0x006e:
            r14 = r3
            goto L_0x0072
        L_0x0070:
            r14 = r1
            r15 = r2
        L_0x0072:
            boolean r1 = iq.c.a((int) r13, (com.liulishuo.filedownloader.model.FileDownloadModel) r14, (com.liulishuo.filedownloader.y) r7, (boolean) r12)     // Catch:{ all -> 0x01ce }
            if (r1 == 0) goto L_0x008b
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x0089
            java.lang.String r0 = "has already started download %d"
            java.lang.Object[] r1 = new java.lang.Object[r12]     // Catch:{ all -> 0x01ce }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01ce }
            r1[r11] = r2     // Catch:{ all -> 0x01ce }
            iq.d.c(r7, r0, r1)     // Catch:{ all -> 0x01ce }
        L_0x0089:
            monitor-exit(r18)
            return
        L_0x008b:
            if (r14 == 0) goto L_0x0092
            java.lang.String r1 = r14.d()     // Catch:{ all -> 0x01ce }
            goto L_0x0096
        L_0x0092:
            java.lang.String r1 = iq.f.a((java.lang.String) r8, (boolean) r9, (java.lang.String) r2)     // Catch:{ all -> 0x01ce }
        L_0x0096:
            r5 = r25
            r6 = r1
            boolean r1 = iq.c.a((int) r13, (java.lang.String) r6, (boolean) r5, (boolean) r12)     // Catch:{ all -> 0x01ce }
            if (r1 == 0) goto L_0x00b2
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x00b0
            java.lang.String r0 = "has already completed downloading %d"
            java.lang.Object[] r1 = new java.lang.Object[r12]     // Catch:{ all -> 0x01ce }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01ce }
            r1[r11] = r2     // Catch:{ all -> 0x01ce }
            iq.d.c(r7, r0, r1)     // Catch:{ all -> 0x01ce }
        L_0x00b0:
            monitor-exit(r18)
            return
        L_0x00b2:
            r2 = 0
            if (r14 == 0) goto L_0x00bb
            long r16 = r14.g()     // Catch:{ all -> 0x01ce }
            goto L_0x00bd
        L_0x00bb:
            r16 = r2
        L_0x00bd:
            if (r14 == 0) goto L_0x00c4
            java.lang.String r1 = r14.e()     // Catch:{ all -> 0x01ce }
            goto L_0x00c8
        L_0x00c4:
            java.lang.String r1 = iq.f.d((java.lang.String) r6)     // Catch:{ all -> 0x01ce }
        L_0x00c8:
            r4 = r1
            r1 = r13
            r2 = r16
            r5 = r6
            r16 = r6
            r6 = r18
            boolean r1 = iq.c.a(r1, r2, r4, r5, r6)     // Catch:{ all -> 0x01ce }
            if (r1 == 0) goto L_0x00f8
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x01ce }
            if (r0 == 0) goto L_0x00ea
            java.lang.String r0 = "there is an another task with the same target-file-path %d %s"
            java.lang.Object[] r1 = new java.lang.Object[r10]     // Catch:{ all -> 0x01ce }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x01ce }
            r1[r11] = r2     // Catch:{ all -> 0x01ce }
            r1[r12] = r16     // Catch:{ all -> 0x01ce }
            iq.d.c(r7, r0, r1)     // Catch:{ all -> 0x01ce }
        L_0x00ea:
            if (r14 == 0) goto L_0x00f6
            in.a r0 = r7.f21463a     // Catch:{ all -> 0x01ce }
            r0.e(r13)     // Catch:{ all -> 0x01ce }
            in.a r0 = r7.f21463a     // Catch:{ all -> 0x01ce }
            r0.d(r13)     // Catch:{ all -> 0x01ce }
        L_0x00f6:
            monitor-exit(r18)
            return
        L_0x00f8:
            if (r14 == 0) goto L_0x0162
            byte r1 = r14.f()     // Catch:{ all -> 0x01ce }
            r2 = -2
            if (r1 == r2) goto L_0x011b
            byte r1 = r14.f()     // Catch:{ all -> 0x01ce }
            r2 = -1
            if (r1 == r2) goto L_0x011b
            byte r1 = r14.f()     // Catch:{ all -> 0x01ce }
            if (r1 == r12) goto L_0x011b
            byte r1 = r14.f()     // Catch:{ all -> 0x01ce }
            r2 = 6
            if (r1 == r2) goto L_0x011b
            byte r1 = r14.f()     // Catch:{ all -> 0x01ce }
            if (r1 != r10) goto L_0x0162
        L_0x011b:
            int r1 = r14.a()     // Catch:{ all -> 0x01ce }
            if (r1 == r13) goto L_0x0154
            in.a r0 = r7.f21463a     // Catch:{ all -> 0x01ce }
            int r1 = r14.a()     // Catch:{ all -> 0x01ce }
            r0.e(r1)     // Catch:{ all -> 0x01ce }
            in.a r0 = r7.f21463a     // Catch:{ all -> 0x01ce }
            int r1 = r14.a()     // Catch:{ all -> 0x01ce }
            r0.d(r1)     // Catch:{ all -> 0x01ce }
            r14.a((int) r13)     // Catch:{ all -> 0x01ce }
            r14.a(r8, r9)     // Catch:{ all -> 0x01ce }
            if (r15 == 0) goto L_0x0180
            java.util.Iterator r0 = r15.iterator()     // Catch:{ all -> 0x01ce }
        L_0x013f:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x01ce }
            if (r1 == 0) goto L_0x0180
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.model.a r1 = (com.liulishuo.filedownloader.model.a) r1     // Catch:{ all -> 0x01ce }
            r1.a((int) r13)     // Catch:{ all -> 0x01ce }
            in.a r2 = r7.f21463a     // Catch:{ all -> 0x01ce }
            r2.a((com.liulishuo.filedownloader.model.a) r1)     // Catch:{ all -> 0x01ce }
            goto L_0x013f
        L_0x0154:
            java.lang.String r1 = r14.b()     // Catch:{ all -> 0x01ce }
            boolean r1 = android.text.TextUtils.equals(r0, r1)     // Catch:{ all -> 0x01ce }
            if (r1 != 0) goto L_0x0181
            r14.a((java.lang.String) r0)     // Catch:{ all -> 0x01ce }
            goto L_0x0180
        L_0x0162:
            if (r14 != 0) goto L_0x0169
            com.liulishuo.filedownloader.model.FileDownloadModel r14 = new com.liulishuo.filedownloader.model.FileDownloadModel     // Catch:{ all -> 0x01ce }
            r14.<init>()     // Catch:{ all -> 0x01ce }
        L_0x0169:
            r14.a((java.lang.String) r0)     // Catch:{ all -> 0x01ce }
            r14.a(r8, r9)     // Catch:{ all -> 0x01ce }
            r14.a((int) r13)     // Catch:{ all -> 0x01ce }
            r0 = 0
            r14.a((long) r0)     // Catch:{ all -> 0x01ce }
            r14.c((long) r0)     // Catch:{ all -> 0x01ce }
            r14.a((byte) r12)     // Catch:{ all -> 0x01ce }
            r14.b((int) r12)     // Catch:{ all -> 0x01ce }
        L_0x0180:
            r11 = 1
        L_0x0181:
            if (r11 == 0) goto L_0x0188
            in.a r0 = r7.f21463a     // Catch:{ all -> 0x01ce }
            r0.a((com.liulishuo.filedownloader.model.FileDownloadModel) r14)     // Catch:{ all -> 0x01ce }
        L_0x0188:
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = new com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a     // Catch:{ all -> 0x01ce }
            r0.<init>()     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.a((com.liulishuo.filedownloader.model.FileDownloadModel) r14)     // Catch:{ all -> 0x01ce }
            r1 = r26
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.a((com.liulishuo.filedownloader.model.FileDownloadHeader) r1)     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.a((com.liulishuo.filedownloader.y) r7)     // Catch:{ all -> 0x01ce }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r23)     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.a((java.lang.Integer) r1)     // Catch:{ all -> 0x01ce }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r22)     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.b((java.lang.Integer) r1)     // Catch:{ all -> 0x01ce }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r25)     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.a((java.lang.Boolean) r1)     // Catch:{ all -> 0x01ce }
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r27)     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.b((java.lang.Boolean) r1)     // Catch:{ all -> 0x01ce }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r24)     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$a r0 = r0.c(r1)     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable r0 = r0.a()     // Catch:{ all -> 0x01ce }
            com.liulishuo.filedownloader.services.h r1 = r7.f21464b     // Catch:{ all -> 0x01ce }
            r1.a((com.liulishuo.filedownloader.download.DownloadLaunchRunnable) r0)     // Catch:{ all -> 0x01ce }
            monitor-exit(r18)
            return
        L_0x01ce:
            r0 = move-exception
            monitor-exit(r18)
            goto L_0x01d2
        L_0x01d1:
            throw r0
        L_0x01d2:
            goto L_0x01d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.services.g.a(java.lang.String, java.lang.String, boolean, int, int, int, boolean, com.liulishuo.filedownloader.model.FileDownloadHeader, boolean):void");
    }

    public boolean a(int i2) {
        return a(this.f21463a.b(i2));
    }

    public boolean a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            return false;
        }
        boolean c2 = this.f21464b.c(fileDownloadModel.a());
        if (b.a((int) fileDownloadModel.f())) {
            return c2;
        }
        if (!c2) {
            d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(fileDownloadModel.a()), Byte.valueOf(fileDownloadModel.f()));
            return false;
        }
    }

    public boolean a(String str, String str2) {
        return a(f.b(str, str2));
    }

    public boolean b() {
        return this.f21464b.a() <= 0;
    }

    public boolean b(int i2) {
        if (d.f29057a) {
            d.c(this, "request pause the task %d", Integer.valueOf(i2));
        }
        FileDownloadModel b2 = this.f21463a.b(i2);
        if (b2 == null) {
            return false;
        }
        b2.a((byte) -2);
        this.f21464b.b(i2);
        return true;
    }

    public long c(int i2) {
        FileDownloadModel b2 = this.f21463a.b(i2);
        if (b2 == null) {
            return 0;
        }
        int n2 = b2.n();
        if (n2 <= 1) {
            return b2.g();
        }
        List<com.liulishuo.filedownloader.model.a> c2 = this.f21463a.c(i2);
        if (c2 == null || c2.size() != n2) {
            return 0;
        }
        return com.liulishuo.filedownloader.model.a.a(c2);
    }

    public void c() {
        this.f21463a.a();
    }

    public long d(int i2) {
        FileDownloadModel b2 = this.f21463a.b(i2);
        if (b2 == null) {
            return 0;
        }
        return b2.h();
    }

    public byte e(int i2) {
        FileDownloadModel b2 = this.f21463a.b(i2);
        if (b2 == null) {
            return 0;
        }
        return b2.f();
    }

    public synchronized boolean f(int i2) {
        return this.f21464b.a(i2);
    }

    public boolean g(int i2) {
        if (i2 == 0) {
            d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i2));
            return false;
        } else if (a(i2)) {
            d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i2));
            return false;
        } else {
            this.f21463a.e(i2);
            this.f21463a.d(i2);
            return true;
        }
    }
}
