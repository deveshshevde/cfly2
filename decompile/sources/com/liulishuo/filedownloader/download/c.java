package com.liulishuo.filedownloader.download;

import com.liulishuo.filedownloader.services.i;
import im.b;
import iq.c;
import java.io.File;
import java.io.IOException;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private com.liulishuo.filedownloader.services.c f21263a;

    /* renamed from: b  reason: collision with root package name */
    private c.a f21264b;

    /* renamed from: c  reason: collision with root package name */
    private c.b f21265c;

    /* renamed from: d  reason: collision with root package name */
    private c.e f21266d;

    /* renamed from: e  reason: collision with root package name */
    private in.a f21267e;

    /* renamed from: f  reason: collision with root package name */
    private c.d f21268f;

    /* renamed from: g  reason: collision with root package name */
    private i f21269g;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f21270a = new c();
    }

    public static c a() {
        return a.f21270a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dd, code lost:
        if (r7.g() <= 0) goto L_0x00df;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d5 A[Catch:{ all -> 0x00c1, all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e1 A[Catch:{ all -> 0x00c1, all -> 0x0148 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(in.a.C0100a r25) {
        /*
            r1 = r25
            java.lang.String r2 = "refreshed data count: %d , delete data count: %d, reset id count: %d. consume %d"
            java.util.Iterator r0 = r25.iterator()
            com.liulishuo.filedownloader.download.c r3 = a()
            iq.c$d r3 = r3.b()
            long r4 = java.lang.System.currentTimeMillis()
            r8 = 0
            r10 = 0
            r12 = 0
        L_0x001a:
            r15 = 3
            r16 = 0
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x018c }
            if (r7 == 0) goto L_0x014c
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x018c }
            com.liulishuo.filedownloader.model.FileDownloadModel r7 = (com.liulishuo.filedownloader.model.FileDownloadModel) r7     // Catch:{ all -> 0x018c }
            byte r6 = r7.f()     // Catch:{ all -> 0x018c }
            r14 = -2
            if (r6 == r15) goto L_0x004f
            byte r6 = r7.f()     // Catch:{ all -> 0x018c }
            r15 = 2
            if (r6 == r15) goto L_0x004f
            byte r6 = r7.f()     // Catch:{ all -> 0x018c }
            r15 = -1
            if (r6 == r15) goto L_0x004f
            byte r6 = r7.f()     // Catch:{ all -> 0x018c }
            r15 = 1
            if (r6 != r15) goto L_0x0052
            long r20 = r7.g()     // Catch:{ all -> 0x018c }
            r17 = 0
            int r6 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r6 <= 0) goto L_0x0052
        L_0x004f:
            r7.a((byte) r14)     // Catch:{ all -> 0x018c }
        L_0x0052:
            java.lang.String r6 = r7.d()     // Catch:{ all -> 0x018c }
            if (r6 != 0) goto L_0x0063
            r20 = r2
            r21 = r4
            r23 = r8
            r2 = 1
            r8 = 0
            goto L_0x00f6
        L_0x0063:
            java.io.File r15 = new java.io.File     // Catch:{ all -> 0x018c }
            r15.<init>(r6)     // Catch:{ all -> 0x018c }
            byte r6 = r7.f()     // Catch:{ all -> 0x018c }
            if (r6 != r14) goto L_0x00c8
            int r6 = r7.a()     // Catch:{ all -> 0x018c }
            java.lang.String r14 = r7.c()     // Catch:{ all -> 0x018c }
            r20 = r2
            r2 = 0
            boolean r2 = iq.f.a(r6, r7, r14, r2)     // Catch:{ all -> 0x00c1 }
            if (r2 == 0) goto L_0x00ca
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = r7.e()     // Catch:{ all -> 0x00c1 }
            r2.<init>(r6)     // Catch:{ all -> 0x00c1 }
            boolean r6 = r2.exists()     // Catch:{ all -> 0x00c1 }
            if (r6 != 0) goto L_0x00ca
            boolean r6 = r15.exists()     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x00ca
            boolean r6 = r15.renameTo(r2)     // Catch:{ all -> 0x00c1 }
            boolean r14 = iq.d.f29057a     // Catch:{ all -> 0x00c1 }
            if (r14 == 0) goto L_0x00ca
            java.lang.Class<in.a> r14 = in.a.class
            r21 = r4
            java.lang.String r4 = "resume from the old no-temp-file architecture [%B], [%s]->[%s]"
            r23 = r8
            r5 = 3
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0148 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x0148 }
            r8[r16] = r5     // Catch:{ all -> 0x0148 }
            java.lang.String r5 = r15.getPath()     // Catch:{ all -> 0x0148 }
            r6 = 1
            r8[r6] = r5     // Catch:{ all -> 0x0148 }
            java.lang.String r2 = r2.getPath()     // Catch:{ all -> 0x0148 }
            r5 = 2
            r8[r5] = r2     // Catch:{ all -> 0x0148 }
            iq.d.c(r14, r4, r8)     // Catch:{ all -> 0x0148 }
            goto L_0x00ce
        L_0x00bf:
            r0 = move-exception
            goto L_0x00c4
        L_0x00c1:
            r0 = move-exception
            r21 = r4
        L_0x00c4:
            r23 = r8
            goto L_0x0149
        L_0x00c8:
            r20 = r2
        L_0x00ca:
            r21 = r4
            r23 = r8
        L_0x00ce:
            byte r2 = r7.f()     // Catch:{ all -> 0x0148 }
            r4 = 1
            if (r2 != r4) goto L_0x00e1
            long r4 = r7.g()     // Catch:{ all -> 0x0148 }
            r8 = 0
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 > 0) goto L_0x00e3
        L_0x00df:
            r2 = 1
            goto L_0x00f6
        L_0x00e1:
            r8 = 0
        L_0x00e3:
            int r2 = r7.a()     // Catch:{ all -> 0x0148 }
            boolean r2 = iq.f.a((int) r2, (com.liulishuo.filedownloader.model.FileDownloadModel) r7)     // Catch:{ all -> 0x0148 }
            if (r2 != 0) goto L_0x00ee
            goto L_0x00df
        L_0x00ee:
            boolean r2 = r15.exists()     // Catch:{ all -> 0x0148 }
            if (r2 == 0) goto L_0x00f5
            goto L_0x00df
        L_0x00f5:
            r2 = 0
        L_0x00f6:
            r4 = 1
            if (r2 == 0) goto L_0x0104
            r0.remove()     // Catch:{ all -> 0x0148 }
            r1.a(r7)     // Catch:{ all -> 0x0148 }
            long r10 = r10 + r4
            r8 = r23
            goto L_0x0142
        L_0x0104:
            int r2 = r7.a()     // Catch:{ all -> 0x0148 }
            java.lang.String r6 = r7.b()     // Catch:{ all -> 0x0148 }
            java.lang.String r14 = r7.c()     // Catch:{ all -> 0x0148 }
            boolean r15 = r7.l()     // Catch:{ all -> 0x0148 }
            int r6 = r3.a(r2, r6, r14, r15)     // Catch:{ all -> 0x0148 }
            if (r6 == r2) goto L_0x013d
            boolean r14 = iq.d.f29057a     // Catch:{ all -> 0x0148 }
            if (r14 == 0) goto L_0x0136
            java.lang.Class<in.a> r14 = in.a.class
            java.lang.String r15 = "the id is changed on restoring from db: old[%d] -> new[%d]"
            r8 = 2
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x0148 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0148 }
            r9[r16] = r8     // Catch:{ all -> 0x0148 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0148 }
            r19 = 1
            r9[r19] = r8     // Catch:{ all -> 0x0148 }
            iq.d.c(r14, r15, r9)     // Catch:{ all -> 0x0148 }
        L_0x0136:
            r7.a((int) r6)     // Catch:{ all -> 0x0148 }
            r1.a(r2, r7)     // Catch:{ all -> 0x0148 }
            long r12 = r12 + r4
        L_0x013d:
            r1.b(r7)     // Catch:{ all -> 0x0148 }
            long r8 = r23 + r4
        L_0x0142:
            r2 = r20
            r4 = r21
            goto L_0x001a
        L_0x0148:
            r0 = move-exception
        L_0x0149:
            r2 = r20
            goto L_0x0191
        L_0x014c:
            r20 = r2
            r21 = r4
            r23 = r8
            android.content.Context r0 = iq.c.a()
            iq.f.b((android.content.Context) r0)
            r25.a()
            boolean r0 = iq.d.f29057a
            if (r0 == 0) goto L_0x018b
            java.lang.Class<in.a> r0 = in.a.class
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Long r2 = java.lang.Long.valueOf(r23)
            r1[r16] = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r3 = 1
            r1[r3] = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r12)
            r3 = 2
            r1[r3] = r2
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r21
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r3 = 3
            r1[r3] = r2
            r2 = r20
            iq.d.c(r0, r2, r1)
        L_0x018b:
            return
        L_0x018c:
            r0 = move-exception
            r21 = r4
            r23 = r8
        L_0x0191:
            android.content.Context r3 = iq.c.a()
            iq.f.b((android.content.Context) r3)
            r25.a()
            boolean r1 = iq.d.f29057a
            if (r1 == 0) goto L_0x01c8
            java.lang.Class<in.a> r1 = in.a.class
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Long r4 = java.lang.Long.valueOf(r23)
            r3[r16] = r4
            java.lang.Long r4 = java.lang.Long.valueOf(r10)
            r5 = 1
            r3[r5] = r4
            java.lang.Long r4 = java.lang.Long.valueOf(r12)
            r5 = 2
            r3[r5] = r4
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r21
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r5 = 3
            r3[r5] = r4
            iq.d.c(r1, r2, r3)
        L_0x01c8:
            goto L_0x01ca
        L_0x01c9:
            throw r0
        L_0x01ca:
            goto L_0x01c9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.c.a(in.a$a):void");
    }

    private c.a g() {
        c.a aVar = this.f21264b;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f21264b == null) {
                this.f21264b = j().e();
            }
        }
        return this.f21264b;
    }

    private c.b h() {
        c.b bVar = this.f21265c;
        if (bVar != null) {
            return bVar;
        }
        synchronized (this) {
            if (this.f21265c == null) {
                this.f21265c = j().d();
            }
        }
        return this.f21265c;
    }

    private c.e i() {
        c.e eVar = this.f21266d;
        if (eVar != null) {
            return eVar;
        }
        synchronized (this) {
            if (this.f21266d == null) {
                this.f21266d = j().c();
            }
        }
        return this.f21266d;
    }

    private com.liulishuo.filedownloader.services.c j() {
        com.liulishuo.filedownloader.services.c cVar = this.f21263a;
        if (cVar != null) {
            return cVar;
        }
        synchronized (this) {
            if (this.f21263a == null) {
                this.f21263a = new com.liulishuo.filedownloader.services.c();
            }
        }
        return this.f21263a;
    }

    public int a(int i2, String str, String str2, long j2) {
        return g().a(i2, str, str2, j2);
    }

    public b a(String str) throws IOException {
        return h().a(str);
    }

    public ip.a a(File file) throws IOException {
        return i().a(file);
    }

    public c.d b() {
        c.d dVar = this.f21268f;
        if (dVar != null) {
            return dVar;
        }
        synchronized (this) {
            if (this.f21268f == null) {
                this.f21268f = j().f();
            }
        }
        return this.f21268f;
    }

    public in.a c() {
        in.a aVar = this.f21267e;
        if (aVar != null) {
            return aVar;
        }
        synchronized (this) {
            if (this.f21267e == null) {
                in.a b2 = j().b();
                this.f21267e = b2;
                a(b2.b());
            }
        }
        return this.f21267e;
    }

    public i d() {
        i iVar = this.f21269g;
        if (iVar != null) {
            return iVar;
        }
        synchronized (this) {
            if (this.f21269g == null) {
                this.f21269g = j().g();
            }
        }
        return this.f21269g;
    }

    public int e() {
        return j().a();
    }

    public boolean f() {
        return i().a();
    }
}
