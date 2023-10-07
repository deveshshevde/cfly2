package com.liulishuo.filedownloader.download;

import com.liulishuo.filedownloader.download.a;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import iq.f;

public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final int f21271a;

    /* renamed from: b  reason: collision with root package name */
    private final a f21272b;

    /* renamed from: c  reason: collision with root package name */
    private final g f21273c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21274d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f21275e;

    /* renamed from: f  reason: collision with root package name */
    private f f21276f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f21277g;

    /* renamed from: h  reason: collision with root package name */
    private final int f21278h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0140a f21279a = new a.C0140a();

        /* renamed from: b  reason: collision with root package name */
        private g f21280b;

        /* renamed from: c  reason: collision with root package name */
        private String f21281c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f21282d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f21283e;

        public a a(int i2) {
            this.f21279a.a(i2);
            return this;
        }

        public a a(b bVar) {
            this.f21279a.a(bVar);
            return this;
        }

        public a a(g gVar) {
            this.f21280b = gVar;
            return this;
        }

        public a a(FileDownloadHeader fileDownloadHeader) {
            this.f21279a.a(fileDownloadHeader);
            return this;
        }

        public a a(Integer num) {
            this.f21283e = num;
            return this;
        }

        public a a(String str) {
            this.f21279a.a(str);
            return this;
        }

        public a a(boolean z2) {
            this.f21282d = Boolean.valueOf(z2);
            return this;
        }

        public d a() {
            if (this.f21280b == null || this.f21281c == null || this.f21282d == null || this.f21283e == null) {
                throw new IllegalArgumentException(f.a("%s %s %B", this.f21280b, this.f21281c, this.f21282d));
            }
            a a2 = this.f21279a.a();
            return new d(a2.f21245a, this.f21283e.intValue(), a2, this.f21280b, this.f21282d.booleanValue(), this.f21281c);
        }

        public a b(String str) {
            this.f21279a.b(str);
            return this;
        }

        public a c(String str) {
            this.f21281c = str;
            return this;
        }
    }

    private d(int i2, int i3, a aVar, g gVar, boolean z2, String str) {
        this.f21278h = i2;
        this.f21271a = i3;
        this.f21277g = false;
        this.f21273c = gVar;
        this.f21274d = str;
        this.f21272b = aVar;
        this.f21275e = z2;
    }

    private long c() {
        in.a c2 = c.a().c();
        if (this.f21271a >= 0) {
            for (com.liulishuo.filedownloader.model.a next : c2.c(this.f21278h)) {
                if (next.b() == this.f21271a) {
                    return next.d();
                }
            }
            return 0;
        }
        FileDownloadModel b2 = c2.b(this.f21278h);
        if (b2 != null) {
            return b2.g();
        }
        return 0;
    }

    public void a() {
        this.f21277g = true;
        f fVar = this.f21276f;
        if (fVar != null) {
            fVar.a();
        }
    }

    public void b() {
        a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0108 A[Catch:{ all -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x013f A[SYNTHETIC, Splitter:B:53:0x013f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.liulishuo.filedownloader.download.a r0 = r12.f21272b
            com.liulishuo.filedownloader.download.b r0 = r0.e()
            long r0 = r0.f21258b
            r0 = 0
            r1 = 0
            r2 = 0
        L_0x0010:
            r3 = 1
            boolean r2 = r12.f21277g     // Catch:{ IllegalAccessException -> 0x00fc, IOException -> 0x00fa, FileDownloadGiveUpRetryException -> 0x00f8, IllegalArgumentException -> 0x00f6 }
            if (r2 == 0) goto L_0x001b
            if (r1 == 0) goto L_0x001a
            r1.f()
        L_0x001a:
            return
        L_0x001b:
            com.liulishuo.filedownloader.download.a r2 = r12.f21272b     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            im.b r1 = r2.a()     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            int r2 = r1.e()     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            boolean r4 = iq.d.f29057a     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r5 = 3
            r6 = 2
            r7 = 4
            if (r4 == 0) goto L_0x0051
            java.lang.String r4 = "the connection[%d] for %d, is connected %s with code[%d]"
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            int r9 = r12.f21271a     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r8[r0] = r9     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            int r9 = r12.f21278h     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r8[r3] = r9     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            com.liulishuo.filedownloader.download.a r9 = r12.f21272b     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            com.liulishuo.filedownloader.download.b r9 = r9.e()     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r8[r6] = r9     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r8[r5] = r9     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            iq.d.c(r12, r4, r8)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
        L_0x0051:
            r4 = 206(0xce, float:2.89E-43)
            if (r2 == r4) goto L_0x008d
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 != r4) goto L_0x005a
            goto L_0x008d
        L_0x005a:
            java.net.SocketException r4 = new java.net.SocketException     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.String r8 = "Connection failed with request[%s] response[%s] http-state[%d] on task[%d-%d], which is changed after verify connection, so please try again."
            r9 = 5
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            com.liulishuo.filedownloader.download.a r10 = r12.f21272b     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.util.Map r10 = r10.d()     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r9[r0] = r10     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.util.Map r10 = r1.c()     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r9[r3] = r10     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r9[r6] = r2     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            int r2 = r12.f21278h     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r9[r5] = r2     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            int r2 = r12.f21271a     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r9[r7] = r2     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            java.lang.String r2 = iq.f.a((java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            r4.<init>(r2)     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
            throw r4     // Catch:{ IllegalAccessException -> 0x00f1, IOException -> 0x00ef, FileDownloadGiveUpRetryException -> 0x00ed, IllegalArgumentException -> 0x00eb }
        L_0x008d:
            com.liulishuo.filedownloader.download.f$a r2 = new com.liulishuo.filedownloader.download.f$a     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            r2.<init>()     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            boolean r4 = r12.f21277g     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            if (r4 == 0) goto L_0x009c
            if (r1 == 0) goto L_0x009b
            r1.f()
        L_0x009b:
            return
        L_0x009c:
            int r4 = r12.f21278h     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.b(r4)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            int r4 = r12.f21271a     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.a((int) r4)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.g r4 = r12.f21273c     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.a((com.liulishuo.filedownloader.download.g) r4)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.a((com.liulishuo.filedownloader.download.d) r12)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            boolean r4 = r12.f21275e     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.a((boolean) r4)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.a((im.b) r1)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.a r4 = r12.f21272b     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.b r4 = r4.e()     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.a((com.liulishuo.filedownloader.download.b) r4)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            java.lang.String r4 = r12.f21274d     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f$a r2 = r2.a((java.lang.String) r4)     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            com.liulishuo.filedownloader.download.f r2 = r2.a()     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            r12.f21276f = r2     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            r2.b()     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            boolean r2 = r12.f21277g     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            if (r2 == 0) goto L_0x00de
            com.liulishuo.filedownloader.download.f r2 = r12.f21276f     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
            r2.a()     // Catch:{ IllegalAccessException -> 0x00e8, IOException -> 0x00e6, FileDownloadGiveUpRetryException -> 0x00e4, IllegalArgumentException -> 0x00e2 }
        L_0x00de:
            if (r1 == 0) goto L_0x0149
            goto L_0x0146
        L_0x00e2:
            r2 = move-exception
            goto L_0x00e9
        L_0x00e4:
            r2 = move-exception
            goto L_0x00e9
        L_0x00e6:
            r2 = move-exception
            goto L_0x00e9
        L_0x00e8:
            r2 = move-exception
        L_0x00e9:
            r4 = 1
            goto L_0x0100
        L_0x00eb:
            r2 = move-exception
            goto L_0x00f2
        L_0x00ed:
            r2 = move-exception
            goto L_0x00f2
        L_0x00ef:
            r2 = move-exception
            goto L_0x00f2
        L_0x00f1:
            r2 = move-exception
        L_0x00f2:
            r4 = 0
            goto L_0x0100
        L_0x00f4:
            r0 = move-exception
            goto L_0x014a
        L_0x00f6:
            r4 = move-exception
            goto L_0x00fd
        L_0x00f8:
            r4 = move-exception
            goto L_0x00fd
        L_0x00fa:
            r4 = move-exception
            goto L_0x00fd
        L_0x00fc:
            r4 = move-exception
        L_0x00fd:
            r11 = r4
            r4 = r2
            r2 = r11
        L_0x0100:
            com.liulishuo.filedownloader.download.g r5 = r12.f21273c     // Catch:{ all -> 0x00f4 }
            boolean r5 = r5.a((java.lang.Exception) r2)     // Catch:{ all -> 0x00f4 }
            if (r5 == 0) goto L_0x013f
            if (r4 == 0) goto L_0x011f
            com.liulishuo.filedownloader.download.f r5 = r12.f21276f     // Catch:{ all -> 0x00f4 }
            if (r5 != 0) goto L_0x011f
            java.lang.String r4 = "it is valid to retry and connection is valid but create fetch-data-task failed, so give up directly with %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x00f4 }
            r3[r0] = r2     // Catch:{ all -> 0x00f4 }
            iq.d.d(r12, r4, r3)     // Catch:{ all -> 0x00f4 }
            com.liulishuo.filedownloader.download.g r0 = r12.f21273c     // Catch:{ all -> 0x00f4 }
            r0.b(r2)     // Catch:{ all -> 0x00f4 }
            if (r1 == 0) goto L_0x0149
            goto L_0x0146
        L_0x011f:
            com.liulishuo.filedownloader.download.f r3 = r12.f21276f     // Catch:{ all -> 0x00f4 }
            if (r3 == 0) goto L_0x0132
            long r5 = r12.c()     // Catch:{ all -> 0x00f4 }
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L_0x0132
            com.liulishuo.filedownloader.download.a r3 = r12.f21272b     // Catch:{ all -> 0x00f4 }
            r3.a((long) r5)     // Catch:{ all -> 0x00f4 }
        L_0x0132:
            com.liulishuo.filedownloader.download.g r3 = r12.f21273c     // Catch:{ all -> 0x00f4 }
            r3.c(r2)     // Catch:{ all -> 0x00f4 }
            if (r1 == 0) goto L_0x013c
            r1.f()
        L_0x013c:
            r2 = r4
            goto L_0x0010
        L_0x013f:
            com.liulishuo.filedownloader.download.g r0 = r12.f21273c     // Catch:{ all -> 0x00f4 }
            r0.b(r2)     // Catch:{ all -> 0x00f4 }
            if (r1 == 0) goto L_0x0149
        L_0x0146:
            r1.f()
        L_0x0149:
            return
        L_0x014a:
            if (r1 == 0) goto L_0x014f
            r1.f()
        L_0x014f:
            goto L_0x0151
        L_0x0150:
            throw r0
        L_0x0151:
            goto L_0x0150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.d.run():void");
    }
}
