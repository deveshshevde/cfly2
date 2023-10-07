package com.liulishuo.filedownloader.download;

import com.liulishuo.filedownloader.download.a;
import com.liulishuo.filedownloader.download.b;
import com.liulishuo.filedownloader.download.d;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadHttpException;
import com.liulishuo.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.liulishuo.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.y;
import iq.b;
import iq.c;
import iq.d;
import iq.e;
import iq.f;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public class DownloadLaunchRunnable implements g, Runnable {

    /* renamed from: p  reason: collision with root package name */
    private static final ThreadPoolExecutor f21209p = b.a("ConnectionBlock");
    private long A;
    private long B;

    /* renamed from: a  reason: collision with root package name */
    int f21210a;

    /* renamed from: b  reason: collision with root package name */
    private final e f21211b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21212c;

    /* renamed from: d  reason: collision with root package name */
    private final FileDownloadModel f21213d;

    /* renamed from: e  reason: collision with root package name */
    private final FileDownloadHeader f21214e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f21215f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f21216g;

    /* renamed from: h  reason: collision with root package name */
    private final in.a f21217h;

    /* renamed from: i  reason: collision with root package name */
    private final y f21218i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f21219j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21220k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f21221l;

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList<d> f21222m;

    /* renamed from: n  reason: collision with root package name */
    private d f21223n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f21224o;

    /* renamed from: q  reason: collision with root package name */
    private boolean f21225q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f21226r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f21227s;

    /* renamed from: t  reason: collision with root package name */
    private final AtomicBoolean f21228t;

    /* renamed from: u  reason: collision with root package name */
    private volatile boolean f21229u;

    /* renamed from: v  reason: collision with root package name */
    private volatile boolean f21230v;

    /* renamed from: w  reason: collision with root package name */
    private volatile Exception f21231w;

    /* renamed from: x  reason: collision with root package name */
    private String f21232x;

    /* renamed from: y  reason: collision with root package name */
    private long f21233y;

    /* renamed from: z  reason: collision with root package name */
    private long f21234z;

    class DiscardSafely extends Throwable {
        DiscardSafely() {
        }
    }

    class RetryDirectly extends Throwable {
        RetryDirectly() {
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private FileDownloadModel f21237a;

        /* renamed from: b  reason: collision with root package name */
        private FileDownloadHeader f21238b;

        /* renamed from: c  reason: collision with root package name */
        private y f21239c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f21240d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f21241e;

        /* renamed from: f  reason: collision with root package name */
        private Boolean f21242f;

        /* renamed from: g  reason: collision with root package name */
        private Boolean f21243g;

        /* renamed from: h  reason: collision with root package name */
        private Integer f21244h;

        public a a(FileDownloadHeader fileDownloadHeader) {
            this.f21238b = fileDownloadHeader;
            return this;
        }

        public a a(FileDownloadModel fileDownloadModel) {
            this.f21237a = fileDownloadModel;
            return this;
        }

        public a a(y yVar) {
            this.f21239c = yVar;
            return this;
        }

        public a a(Boolean bool) {
            this.f21242f = bool;
            return this;
        }

        public a a(Integer num) {
            this.f21240d = num;
            return this;
        }

        public DownloadLaunchRunnable a() {
            if (this.f21237a != null && this.f21239c != null && this.f21240d != null && this.f21241e != null && this.f21242f != null && this.f21243g != null && this.f21244h != null) {
                return new DownloadLaunchRunnable(this.f21237a, this.f21238b, this.f21239c, this.f21240d.intValue(), this.f21241e.intValue(), this.f21242f.booleanValue(), this.f21243g.booleanValue(), this.f21244h.intValue());
            }
            throw new IllegalArgumentException();
        }

        public a b(Boolean bool) {
            this.f21243g = bool;
            return this;
        }

        public a b(Integer num) {
            this.f21241e = num;
            return this;
        }

        public a c(Integer num) {
            this.f21244h = num;
            return this;
        }
    }

    private DownloadLaunchRunnable(FileDownloadModel fileDownloadModel, FileDownloadHeader fileDownloadHeader, y yVar, int i2, int i3, boolean z2, boolean z3, int i4) {
        this.f21212c = 5;
        this.f21220k = false;
        this.f21222m = new ArrayList<>(5);
        this.f21233y = 0;
        this.f21234z = 0;
        this.A = 0;
        this.B = 0;
        this.f21228t = new AtomicBoolean(true);
        this.f21229u = false;
        this.f21219j = false;
        this.f21213d = fileDownloadModel;
        this.f21214e = fileDownloadHeader;
        this.f21215f = z2;
        this.f21216g = z3;
        this.f21217h = c.a().c();
        this.f21221l = c.a().f();
        this.f21218i = yVar;
        this.f21210a = i4;
        this.f21211b = new e(fileDownloadModel, i4, i2, i3);
    }

    private void a(int i2, List<com.liulishuo.filedownloader.model.a> list) throws InterruptedException {
        if (i2 <= 1 || list.size() != i2) {
            throw new IllegalArgumentException();
        }
        a(list, this.f21213d.h());
    }

    private void a(long j2, int i2) throws InterruptedException {
        long j3 = j2 / ((long) i2);
        int a2 = this.f21213d.a();
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        int i3 = 0;
        while (i3 < i2) {
            long j5 = i3 == i2 + -1 ? -1 : (j4 + j3) - 1;
            com.liulishuo.filedownloader.model.a aVar = new com.liulishuo.filedownloader.model.a();
            aVar.a(a2);
            aVar.b(i3);
            aVar.a(j4);
            aVar.b(j4);
            aVar.c(j5);
            arrayList.add(aVar);
            this.f21217h.a(aVar);
            j4 += j3;
            i3++;
        }
        this.f21213d.b(i2);
        this.f21217h.a(a2, i2);
        a((List<com.liulishuo.filedownloader.model.a>) arrayList, j2);
    }

    private void a(long j2, String str) throws IOException, IllegalAccessException {
        ip.a aVar = null;
        if (j2 != -1) {
            try {
                aVar = f.n(this.f21213d.e());
                long length = new File(str).length();
                long j3 = j2 - length;
                long f2 = f.f(str);
                if (f2 < j3) {
                    throw new FileDownloadOutOfSpaceException(f2, j3, length);
                } else if (!e.a().f29063f) {
                    aVar.b(j2);
                }
            } catch (Throwable th) {
                if (aVar != null) {
                    aVar.b();
                }
                throw th;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
    }

    private void a(List<com.liulishuo.filedownloader.model.a> list, long j2) throws InterruptedException {
        int a2 = this.f21213d.a();
        String j3 = this.f21213d.j();
        String str = this.f21232x;
        if (str == null) {
            str = this.f21213d.b();
        }
        String e2 = this.f21213d.e();
        if (d.f29057a) {
            d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(a2), Long.valueOf(j2));
        }
        boolean z2 = this.f21225q;
        long j4 = 0;
        long j5 = 0;
        for (com.liulishuo.filedownloader.model.a next : list) {
            long d2 = next.e() == -1 ? j2 - next.d() : (next.e() - next.d()) + 1;
            j5 += next.d() - next.c();
            if (d2 != j4) {
                d a3 = new d.a().a(a2).a(Integer.valueOf(next.b())).a((g) this).a(str).b(z2 ? j3 : null).a(this.f21214e).a(this.f21216g).a(b.a.a(next.c(), next.d(), next.e(), d2)).c(e2).a();
                if (iq.d.f29057a) {
                    iq.d.c(this, "enable multiple connection: %s", next);
                }
                if (a3 != null) {
                    this.f21222m.add(a3);
                } else {
                    throw new IllegalArgumentException("the download runnable must not be null!");
                }
            } else if (iq.d.f29057a) {
                iq.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(next.a()), Integer.valueOf(next.b()));
            }
            j4 = 0;
        }
        if (j5 != this.f21213d.g()) {
            iq.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.f21213d.g()), Long.valueOf(j5));
            this.f21213d.a(j5);
        }
        ArrayList arrayList = new ArrayList(this.f21222m.size());
        Iterator<d> it2 = this.f21222m.iterator();
        while (it2.hasNext()) {
            d next2 = it2.next();
            if (this.f21229u) {
                next2.a();
            } else {
                arrayList.add(Executors.callable(next2));
            }
        }
        if (this.f21229u) {
            this.f21213d.a((byte) -2);
            return;
        }
        List<Future> invokeAll = f21209p.invokeAll(arrayList);
        if (iq.d.f29057a) {
            for (Future future : invokeAll) {
                iq.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(a2), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r18, com.liulishuo.filedownloader.download.a r19, im.b r20) throws java.io.IOException, com.liulishuo.filedownloader.download.DownloadLaunchRunnable.RetryDirectly, java.lang.IllegalArgumentException, com.liulishuo.filedownloader.exception.FileDownloadSecurityException {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            com.liulishuo.filedownloader.model.FileDownloadModel r2 = r0.f21213d
            int r4 = r2.a()
            int r2 = r20.e()
            boolean r3 = iq.f.b((int) r2, (im.b) r1)
            r0.f21226r = r3
            r3 = 201(0xc9, float:2.82E-43)
            r5 = 0
            r6 = 1
            r7 = 200(0xc8, float:2.8E-43)
            if (r2 == r7) goto L_0x0023
            if (r2 == r3) goto L_0x0023
            if (r2 != 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r7 = 0
            goto L_0x0024
        L_0x0023:
            r7 = 1
        L_0x0024:
            long r10 = iq.f.a((im.b) r20)
            com.liulishuo.filedownloader.model.FileDownloadModel r8 = r0.f21213d
            java.lang.String r8 = r8.j()
            java.lang.String r12 = iq.f.a((int) r4, (im.b) r1)
            r9 = 412(0x19c, float:5.77E-43)
            r13 = 0
            if (r2 != r9) goto L_0x003a
        L_0x0038:
            r3 = 1
            goto L_0x0087
        L_0x003a:
            if (r8 == 0) goto L_0x0049
            boolean r9 = r8.equals(r12)
            if (r9 != 0) goto L_0x0049
            if (r7 != 0) goto L_0x0038
            boolean r9 = r0.f21226r
            if (r9 == 0) goto L_0x0049
            goto L_0x0038
        L_0x0049:
            if (r2 != r3) goto L_0x0052
            boolean r3 = r19.b()
            if (r3 == 0) goto L_0x0052
            goto L_0x0038
        L_0x0052:
            r3 = 416(0x1a0, float:5.83E-43)
            if (r2 != r3) goto L_0x0086
            boolean r3 = r0.f21226r
            if (r3 == 0) goto L_0x0066
            int r3 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r3 < 0) goto L_0x0066
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r9 = "get 416 but the Content-Range is returned, no need to retry"
            iq.d.d(r0, r9, r3)
            goto L_0x0086
        L_0x0066:
            com.liulishuo.filedownloader.model.FileDownloadModel r3 = r0.f21213d
            long r15 = r3.g()
            int r3 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x0078
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r9 = "get 416, precondition failed and just retry"
            iq.d.d(r0, r9, r3)
            goto L_0x0038
        L_0x0078:
            boolean r3 = r0.f21220k
            if (r3 != 0) goto L_0x0086
            r0.f21220k = r6
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r9 = "get 416, precondition failed and need to retry with discarding range"
            iq.d.d(r0, r9, r3)
            goto L_0x0038
        L_0x0086:
            r3 = 0
        L_0x0087:
            r9 = 0
            if (r3 == 0) goto L_0x011b
            boolean r1 = r0.f21225q
            r3 = 3
            r7 = 2
            r10 = 4
            if (r1 == 0) goto L_0x00a8
            java.lang.Object[] r1 = new java.lang.Object[r10]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            r1[r5] = r11
            r1[r6] = r8
            r1[r7] = r12
            java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
            r1[r3] = r11
            java.lang.String r11 = "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response code is %d"
            iq.d.d(r0, r11, r1)
        L_0x00a8:
            in.a r1 = r0.f21217h
            com.liulishuo.filedownloader.model.FileDownloadModel r11 = r0.f21213d
            int r11 = r11.a()
            r1.d(r11)
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            java.lang.String r1 = r1.d()
            com.liulishuo.filedownloader.model.FileDownloadModel r11 = r0.f21213d
            java.lang.String r11 = r11.e()
            iq.f.c((java.lang.String) r1, (java.lang.String) r11)
            r0.f21225q = r5
            if (r8 == 0) goto L_0x00e4
            boolean r1 = r8.equals(r12)
            if (r1 == 0) goto L_0x00e4
            java.lang.Object[] r1 = new java.lang.Object[r10]
            r1[r5] = r8
            r1[r6] = r12
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1[r7] = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r1[r3] = r2
            java.lang.String r2 = "the old etag[%s] is the same to the new etag[%s], but the response status code is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!"
            iq.d.d(r0, r2, r1)
            r12 = r9
        L_0x00e4:
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            r1.a((long) r13)
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            r1.c((long) r13)
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            r1.b((java.lang.String) r12)
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            r1.o()
            in.a r3 = r0.f21217h
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            java.lang.String r5 = r1.j()
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            long r6 = r1.g()
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            long r8 = r1.h()
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r0.f21213d
            int r10 = r1.n()
            r3.a(r4, r5, r6, r8, r10)
            com.liulishuo.filedownloader.download.DownloadLaunchRunnable$RetryDirectly r1 = new com.liulishuo.filedownloader.download.DownloadLaunchRunnable$RetryDirectly
            r1.<init>()
            throw r1
        L_0x011b:
            java.lang.String r3 = r19.c()
            r0.f21232x = r3
            boolean r3 = r0.f21226r
            if (r3 != 0) goto L_0x0134
            if (r7 == 0) goto L_0x0128
            goto L_0x0134
        L_0x0128:
            com.liulishuo.filedownloader.exception.FileDownloadHttpException r3 = new com.liulishuo.filedownloader.exception.FileDownloadHttpException
            java.util.Map r1 = r20.c()
            r4 = r18
            r3.<init>(r2, r4, r1)
            throw r3
        L_0x0134:
            com.liulishuo.filedownloader.model.FileDownloadModel r2 = r0.f21213d
            boolean r2 = r2.l()
            if (r2 == 0) goto L_0x0148
            com.liulishuo.filedownloader.model.FileDownloadModel r2 = r0.f21213d
            java.lang.String r2 = r2.b()
            java.lang.String r1 = iq.f.a((im.b) r1, (java.lang.String) r2)
            r13 = r1
            goto L_0x0149
        L_0x0148:
            r13 = r9
        L_0x0149:
            r1 = -1
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0151
            r1 = 1
            goto L_0x0152
        L_0x0151:
            r1 = 0
        L_0x0152:
            r0.f21227s = r1
            com.liulishuo.filedownloader.download.e r8 = r0.f21211b
            boolean r1 = r0.f21225q
            if (r1 == 0) goto L_0x0160
            boolean r1 = r0.f21226r
            if (r1 == 0) goto L_0x0160
            r9 = 1
            goto L_0x0161
        L_0x0160:
            r9 = 0
        L_0x0161:
            r8.a(r9, r10, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.DownloadLaunchRunnable.a(java.util.Map, com.liulishuo.filedownloader.download.a, im.b):void");
    }

    private int b(long j2) {
        if (h()) {
            return this.f21225q ? this.f21213d.n() : c.a().a(this.f21213d.a(), this.f21213d.b(), this.f21213d.c(), j2);
        }
        return 1;
    }

    private void c(long j2) throws IOException, IllegalAccessException {
        b bVar;
        if (!this.f21226r) {
            this.f21213d.a(0);
            bVar = b.a.a(j2);
        } else {
            bVar = b.a.a(this.f21213d.g(), this.f21213d.g(), j2 - this.f21213d.g());
        }
        this.f21223n = new d.a().a(this.f21213d.a()).a((Integer) -1).a((g) this).a(this.f21213d.b()).b(this.f21213d.j()).a(this.f21214e).a(this.f21216g).a(bVar).c(this.f21213d.e()).a();
        this.f21213d.b(1);
        this.f21217h.a(this.f21213d.a(), 1);
        if (this.f21229u) {
            this.f21213d.a((byte) -2);
            this.f21223n.a();
            return;
        }
        this.f21223n.run();
    }

    private void g() throws IOException, RetryDirectly, IllegalAccessException, FileDownloadSecurityException {
        im.b bVar = null;
        try {
            a a2 = new a.C0140a().a(this.f21213d.a()).a(this.f21213d.b()).b(this.f21213d.j()).a(this.f21214e).a(this.f21220k ? b.a.b() : b.a.a()).a();
            bVar = a2.a();
            a(a2.d(), a2, bVar);
        } finally {
            if (bVar != null) {
                bVar.f();
            }
        }
    }

    private boolean h() {
        return (!this.f21225q || this.f21213d.n() > 1) && this.f21226r && this.f21221l && !this.f21227s;
    }

    private void i() throws FileDownloadGiveUpRetryException {
        if (this.f21216g && !f.k("android.permission.ACCESS_NETWORK_STATE")) {
            throw new FileDownloadGiveUpRetryException(f.a("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.f21213d.a()), "android.permission.ACCESS_NETWORK_STATE"));
        } else if (this.f21216g && f.d()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void j() throws RetryDirectly, DiscardSafely {
        int a2 = this.f21213d.a();
        if (this.f21213d.l()) {
            String d2 = this.f21213d.d();
            int b2 = f.b(this.f21213d.b(), d2);
            if (!c.a(a2, d2, this.f21215f, false)) {
                FileDownloadModel b3 = this.f21217h.b(b2);
                if (b3 != null) {
                    if (!c.a(a2, b3, this.f21218i, false)) {
                        List<com.liulishuo.filedownloader.model.a> c2 = this.f21217h.c(b2);
                        this.f21217h.e(b2);
                        this.f21217h.d(b2);
                        f.p(this.f21213d.d());
                        if (f.a(b2, b3)) {
                            this.f21213d.a(b3.g());
                            this.f21213d.c(b3.h());
                            this.f21213d.b(b3.j());
                            this.f21213d.b(b3.n());
                            this.f21217h.a(this.f21213d);
                            if (c2 != null) {
                                for (com.liulishuo.filedownloader.model.a next : c2) {
                                    next.a(a2);
                                    this.f21217h.a(next);
                                }
                            }
                            throw new RetryDirectly();
                        }
                    } else {
                        this.f21217h.e(a2);
                        this.f21217h.d(a2);
                        throw new DiscardSafely();
                    }
                }
                if (c.a(a2, this.f21213d.g(), this.f21213d.e(), d2, this.f21218i)) {
                    this.f21217h.e(a2);
                    this.f21217h.d(a2);
                    throw new DiscardSafely();
                }
                return;
            }
            this.f21217h.e(a2);
            this.f21217h.d(a2);
            throw new DiscardSafely();
        }
    }

    public void a() {
        this.f21229u = true;
        d dVar = this.f21223n;
        if (dVar != null) {
            dVar.a();
        }
        Iterator it2 = ((ArrayList) this.f21222m.clone()).iterator();
        while (it2.hasNext()) {
            d dVar2 = (d) it2.next();
            if (dVar2 != null) {
                dVar2.a();
            }
        }
    }

    public void a(long j2) {
        if (!this.f21229u) {
            this.f21211b.a(j2);
        }
    }

    public void a(d dVar, long j2, long j3) {
        if (!this.f21229u) {
            int i2 = dVar.f21271a;
            if (iq.d.f29057a) {
                iq.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f21213d.h()));
            }
            if (!this.f21224o) {
                synchronized (this.f21222m) {
                    this.f21222m.remove(dVar);
                }
            } else if (j2 != 0 && j3 != this.f21213d.h()) {
                iq.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(this.f21213d.h()), Integer.valueOf(this.f21213d.a()));
            }
        } else if (iq.d.f29057a) {
            iq.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.f21213d.a()));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<com.liulishuo.filedownloader.model.a> r11) {
        /*
            r10 = this;
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r10.f21213d
            int r0 = r0.n()
            com.liulishuo.filedownloader.model.FileDownloadModel r1 = r10.f21213d
            java.lang.String r1 = r1.e()
            com.liulishuo.filedownloader.model.FileDownloadModel r2 = r10.f21213d
            java.lang.String r2 = r2.d()
            r3 = 0
            r4 = 1
            if (r0 <= r4) goto L_0x0018
            r5 = 1
            goto L_0x0019
        L_0x0018:
            r5 = 0
        L_0x0019:
            boolean r6 = r10.f21220k
            r7 = 0
            if (r6 == 0) goto L_0x0021
        L_0x001f:
            r5 = r7
            goto L_0x0058
        L_0x0021:
            if (r5 == 0) goto L_0x0028
            boolean r6 = r10.f21221l
            if (r6 != 0) goto L_0x0028
            goto L_0x001f
        L_0x0028:
            com.liulishuo.filedownloader.model.FileDownloadModel r6 = r10.f21213d
            int r6 = r6.a()
            com.liulishuo.filedownloader.model.FileDownloadModel r9 = r10.f21213d
            boolean r6 = iq.f.a((int) r6, (com.liulishuo.filedownloader.model.FileDownloadModel) r9)
            if (r6 == 0) goto L_0x001f
            boolean r6 = r10.f21221l
            if (r6 != 0) goto L_0x0044
            java.io.File r11 = new java.io.File
            r11.<init>(r1)
            long r5 = r11.length()
            goto L_0x0058
        L_0x0044:
            if (r5 == 0) goto L_0x0052
            int r5 = r11.size()
            if (r0 == r5) goto L_0x004d
            goto L_0x001f
        L_0x004d:
            long r5 = com.liulishuo.filedownloader.model.a.a((java.util.List<com.liulishuo.filedownloader.model.a>) r11)
            goto L_0x0058
        L_0x0052:
            com.liulishuo.filedownloader.model.FileDownloadModel r11 = r10.f21213d
            long r5 = r11.g()
        L_0x0058:
            com.liulishuo.filedownloader.model.FileDownloadModel r11 = r10.f21213d
            r11.a((long) r5)
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 <= 0) goto L_0x0062
            r3 = 1
        L_0x0062:
            r10.f21225q = r3
            if (r3 != 0) goto L_0x0074
            in.a r11 = r10.f21217h
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r10.f21213d
            int r0 = r0.a()
            r11.d(r0)
            iq.f.c((java.lang.String) r2, (java.lang.String) r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.DownloadLaunchRunnable.a(java.util.List):void");
    }

    public boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int a2 = ((FileDownloadHttpException) exc).a();
            if (this.f21224o && a2 == 416 && !this.f21219j) {
                f.c(this.f21213d.d(), this.f21213d.e());
                this.f21219j = true;
                return true;
            }
        }
        return this.f21210a > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    public void b() {
        a(this.f21217h.c(this.f21213d.a()));
        this.f21211b.c();
    }

    public void b(Exception exc) {
        this.f21230v = true;
        this.f21231w = exc;
        if (!this.f21229u) {
            Iterator it2 = ((ArrayList) this.f21222m.clone()).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (dVar != null) {
                    dVar.b();
                }
            }
        } else if (iq.d.f29057a) {
            iq.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.f21213d.a()));
        }
    }

    public void c() {
        this.f21217h.a(this.f21213d.a(), this.f21213d.g());
    }

    public void c(Exception exc) {
        if (!this.f21229u) {
            int i2 = this.f21210a;
            int i3 = i2 - 1;
            this.f21210a = i3;
            if (i2 < 0) {
                iq.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i3), Integer.valueOf(this.f21213d.a()));
            }
            this.f21211b.a(exc, this.f21210a);
        } else if (iq.d.f29057a) {
            iq.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.f21213d.a()));
        }
    }

    public int d() {
        return this.f21213d.a();
    }

    public boolean e() {
        return this.f21228t.get() || this.f21211b.a();
    }

    public String f() {
        return this.f21213d.e();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x018c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r11 = this;
            r0 = 10
            r1 = 0
            android.os.Process.setThreadPriority(r0)     // Catch:{ all -> 0x01f6 }
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r11.f21213d     // Catch:{ all -> 0x01f6 }
            byte r0 = r0.f()     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = "High concurrent cause, start runnable but already paused %d"
            r3 = -2
            r4 = 1
            if (r0 == r4) goto L_0x008d
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r11.f21213d     // Catch:{ all -> 0x01f6 }
            byte r0 = r0.f()     // Catch:{ all -> 0x01f6 }
            if (r0 != r3) goto L_0x0030
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x01f6 }
            if (r0 == 0) goto L_0x0060
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x01f6 }
            com.liulishuo.filedownloader.model.FileDownloadModel r3 = r11.f21213d     // Catch:{ all -> 0x01f6 }
            int r3 = r3.a()     // Catch:{ all -> 0x01f6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01f6 }
            r0[r1] = r3     // Catch:{ all -> 0x01f6 }
            iq.d.c(r11, r2, r0)     // Catch:{ all -> 0x01f6 }
            goto L_0x0060
        L_0x0030:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = "Task[%d] can't start the download runnable, because its status is %d not %d"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x01f6 }
            com.liulishuo.filedownloader.model.FileDownloadModel r5 = r11.f21213d     // Catch:{ all -> 0x01f6 }
            int r5 = r5.a()     // Catch:{ all -> 0x01f6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01f6 }
            r3[r1] = r5     // Catch:{ all -> 0x01f6 }
            com.liulishuo.filedownloader.model.FileDownloadModel r5 = r11.f21213d     // Catch:{ all -> 0x01f6 }
            byte r5 = r5.f()     // Catch:{ all -> 0x01f6 }
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)     // Catch:{ all -> 0x01f6 }
            r3[r4] = r5     // Catch:{ all -> 0x01f6 }
            r5 = 2
            java.lang.Byte r4 = java.lang.Byte.valueOf(r4)     // Catch:{ all -> 0x01f6 }
            r3[r5] = r4     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = iq.f.a((java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ all -> 0x01f6 }
            r0.<init>(r2)     // Catch:{ all -> 0x01f6 }
            r11.b((java.lang.Exception) r0)     // Catch:{ all -> 0x01f6 }
        L_0x0060:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.b()
            boolean r0 = r11.f21229u
            if (r0 == 0) goto L_0x006f
        L_0x0069:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.f()
            goto L_0x0087
        L_0x006f:
            boolean r0 = r11.f21230v
            if (r0 == 0) goto L_0x007b
        L_0x0073:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            java.lang.Exception r2 = r11.f21231w
            r0.a((java.lang.Exception) r2)
            goto L_0x0087
        L_0x007b:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ IOException -> 0x0081 }
            r0.g()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0087
        L_0x0081:
            r0 = move-exception
        L_0x0082:
            com.liulishuo.filedownloader.download.e r2 = r11.f21211b
            r2.a((java.lang.Exception) r0)
        L_0x0087:
            java.util.concurrent.atomic.AtomicBoolean r0 = r11.f21228t
            r0.set(r1)
            return
        L_0x008d:
            boolean r0 = r11.f21229u     // Catch:{ all -> 0x01f6 }
            if (r0 != 0) goto L_0x0096
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ all -> 0x01f6 }
            r0.d()     // Catch:{ all -> 0x01f6 }
        L_0x0096:
            boolean r0 = r11.f21229u     // Catch:{ all -> 0x01f6 }
            if (r0 == 0) goto L_0x00c6
            boolean r0 = iq.d.f29057a     // Catch:{ all -> 0x01f6 }
            if (r0 == 0) goto L_0x00af
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x01f6 }
            com.liulishuo.filedownloader.model.FileDownloadModel r3 = r11.f21213d     // Catch:{ all -> 0x01f6 }
            int r3 = r3.a()     // Catch:{ all -> 0x01f6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01f6 }
            r0[r1] = r3     // Catch:{ all -> 0x01f6 }
            iq.d.c(r11, r2, r0)     // Catch:{ all -> 0x01f6 }
        L_0x00af:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.b()
            boolean r0 = r11.f21229u
            if (r0 == 0) goto L_0x00b9
            goto L_0x0069
        L_0x00b9:
            boolean r0 = r11.f21230v
            if (r0 == 0) goto L_0x00be
            goto L_0x0073
        L_0x00be:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ IOException -> 0x00c4 }
            r0.g()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x0087
        L_0x00c4:
            r0 = move-exception
            goto L_0x0082
        L_0x00c6:
            r11.i()     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r11.g()     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r11.j()     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            in.a r0 = r11.f21217h     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            com.liulishuo.filedownloader.model.FileDownloadModel r5 = r11.f21213d     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            int r5 = r5.a()     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            java.util.List r0 = r0.c(r5)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r11.a((java.util.List<com.liulishuo.filedownloader.model.a>) r0)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            boolean r5 = r11.f21229u     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            if (r5 == 0) goto L_0x0100
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r11.f21213d     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r0.a((byte) r3)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.b()
            boolean r0 = r11.f21229u
            if (r0 == 0) goto L_0x00f2
            goto L_0x0069
        L_0x00f2:
            boolean r0 = r11.f21230v
            if (r0 == 0) goto L_0x00f8
            goto L_0x0073
        L_0x00f8:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ IOException -> 0x00fe }
            r0.g()     // Catch:{ IOException -> 0x00fe }
            goto L_0x0087
        L_0x00fe:
            r0 = move-exception
            goto L_0x0082
        L_0x0100:
            com.liulishuo.filedownloader.model.FileDownloadModel r5 = r11.f21213d     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            long r5 = r5.h()     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            com.liulishuo.filedownloader.model.FileDownloadModel r7 = r11.f21213d     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            java.lang.String r7 = r7.e()     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r11.a((long) r5, (java.lang.String) r7)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            int r7 = r11.b((long) r5)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            if (r7 <= 0) goto L_0x0178
            r8 = 0
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x0136
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.b()
            boolean r0 = r11.f21229u
            if (r0 == 0) goto L_0x0126
            goto L_0x0069
        L_0x0126:
            boolean r0 = r11.f21230v
            if (r0 == 0) goto L_0x012c
            goto L_0x0073
        L_0x012c:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ IOException -> 0x0133 }
            r0.g()     // Catch:{ IOException -> 0x0133 }
            goto L_0x0087
        L_0x0133:
            r0 = move-exception
            goto L_0x0082
        L_0x0136:
            boolean r8 = r11.f21229u     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            if (r8 == 0) goto L_0x015a
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r11.f21213d     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r0.a((byte) r3)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.b()
            boolean r0 = r11.f21229u
            if (r0 == 0) goto L_0x014a
            goto L_0x0069
        L_0x014a:
            boolean r0 = r11.f21230v
            if (r0 == 0) goto L_0x0150
            goto L_0x0073
        L_0x0150:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ IOException -> 0x0157 }
            r0.g()     // Catch:{ IOException -> 0x0157 }
            goto L_0x0087
        L_0x0157:
            r0 = move-exception
            goto L_0x0082
        L_0x015a:
            if (r7 != r4) goto L_0x015e
            r8 = 1
            goto L_0x015f
        L_0x015e:
            r8 = 0
        L_0x015f:
            r11.f21224o = r8     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            if (r8 == 0) goto L_0x0167
            r11.c((long) r5)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            goto L_0x01c9
        L_0x0167:
            com.liulishuo.filedownloader.download.e r8 = r11.f21211b     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r8.e()     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            boolean r8 = r11.f21225q     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            if (r8 == 0) goto L_0x0174
            r11.a((int) r7, (java.util.List<com.liulishuo.filedownloader.model.a>) r0)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            goto L_0x01c9
        L_0x0174:
            r11.a((long) r5, (int) r7)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            goto L_0x01c9
        L_0x0178:
            java.lang.IllegalAccessException r0 = new java.lang.IllegalAccessException     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            java.lang.String r5 = "invalid connection count %d, the connection count must be larger than 0"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r6[r1] = r7     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            java.lang.String r5 = iq.f.a((java.lang.String) r5, (java.lang.Object[]) r6)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            r0.<init>(r5)     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
            throw r0     // Catch:{ IOException -> 0x01ba, IllegalAccessException -> 0x01b8, InterruptedException -> 0x01b6, IllegalArgumentException -> 0x01b4, FileDownloadSecurityException -> 0x01b2, FileDownloadGiveUpRetryException -> 0x01b0, DiscardSafely -> 0x0194, RetryDirectly -> 0x018c }
        L_0x018c:
            com.liulishuo.filedownloader.model.FileDownloadModel r0 = r11.f21213d     // Catch:{ all -> 0x01f6 }
            r5 = 5
            r0.a((byte) r5)     // Catch:{ all -> 0x01f6 }
            goto L_0x0096
        L_0x0194:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.b()
            boolean r0 = r11.f21229u
            if (r0 == 0) goto L_0x01a0
            goto L_0x0069
        L_0x01a0:
            boolean r0 = r11.f21230v
            if (r0 == 0) goto L_0x01a6
            goto L_0x0073
        L_0x01a6:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ IOException -> 0x01ad }
            r0.g()     // Catch:{ IOException -> 0x01ad }
            goto L_0x0087
        L_0x01ad:
            r0 = move-exception
            goto L_0x0082
        L_0x01b0:
            r0 = move-exception
            goto L_0x01bb
        L_0x01b2:
            r0 = move-exception
            goto L_0x01bb
        L_0x01b4:
            r0 = move-exception
            goto L_0x01bb
        L_0x01b6:
            r0 = move-exception
            goto L_0x01bb
        L_0x01b8:
            r0 = move-exception
            goto L_0x01bb
        L_0x01ba:
            r0 = move-exception
        L_0x01bb:
            boolean r5 = r11.a((java.lang.Exception) r0)     // Catch:{ all -> 0x01f6 }
            if (r5 == 0) goto L_0x01c6
            r11.c((java.lang.Exception) r0)     // Catch:{ all -> 0x01f6 }
            goto L_0x0096
        L_0x01c6:
            r11.b((java.lang.Exception) r0)     // Catch:{ all -> 0x01f6 }
        L_0x01c9:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.b()
            boolean r0 = r11.f21229u
            if (r0 == 0) goto L_0x01d8
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            r0.f()
            goto L_0x01f0
        L_0x01d8:
            boolean r0 = r11.f21230v
            if (r0 == 0) goto L_0x01e4
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b
            java.lang.Exception r2 = r11.f21231w
            r0.a((java.lang.Exception) r2)
            goto L_0x01f0
        L_0x01e4:
            com.liulishuo.filedownloader.download.e r0 = r11.f21211b     // Catch:{ IOException -> 0x01ea }
            r0.g()     // Catch:{ IOException -> 0x01ea }
            goto L_0x01f0
        L_0x01ea:
            r0 = move-exception
            com.liulishuo.filedownloader.download.e r2 = r11.f21211b
            r2.a((java.lang.Exception) r0)
        L_0x01f0:
            java.util.concurrent.atomic.AtomicBoolean r0 = r11.f21228t
            r0.set(r1)
            return
        L_0x01f6:
            r0 = move-exception
            com.liulishuo.filedownloader.download.e r2 = r11.f21211b
            r2.b()
            boolean r2 = r11.f21229u
            if (r2 != 0) goto L_0x0219
            boolean r2 = r11.f21230v
            if (r2 == 0) goto L_0x020c
            com.liulishuo.filedownloader.download.e r2 = r11.f21211b
            java.lang.Exception r3 = r11.f21231w
            r2.a((java.lang.Exception) r3)
            goto L_0x021e
        L_0x020c:
            com.liulishuo.filedownloader.download.e r2 = r11.f21211b     // Catch:{ IOException -> 0x0212 }
            r2.g()     // Catch:{ IOException -> 0x0212 }
            goto L_0x021e
        L_0x0212:
            r2 = move-exception
            com.liulishuo.filedownloader.download.e r3 = r11.f21211b
            r3.a((java.lang.Exception) r2)
            goto L_0x021e
        L_0x0219:
            com.liulishuo.filedownloader.download.e r2 = r11.f21211b
            r2.f()
        L_0x021e:
            java.util.concurrent.atomic.AtomicBoolean r2 = r11.f21228t
            r2.set(r1)
            goto L_0x0225
        L_0x0224:
            throw r0
        L_0x0225:
            goto L_0x0224
        */
        throw new UnsupportedOperationException("Method not decompiled: com.liulishuo.filedownloader.download.DownloadLaunchRunnable.run():void");
    }
}
