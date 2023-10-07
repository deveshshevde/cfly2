package okhttp3.internal.http2;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.f;
import okio.ByteString;

public final class d implements Closeable {

    /* renamed from: p  reason: collision with root package name */
    static final /* synthetic */ boolean f32108p = true;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final ExecutorService f32109q = new ThreadPoolExecutor(0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 60, TimeUnit.SECONDS, new SynchronousQueue(), nb.c.a("OkHttp Http2Connection", true));
    private long A = 0;

    /* renamed from: a  reason: collision with root package name */
    final boolean f32110a;

    /* renamed from: b  reason: collision with root package name */
    final c f32111b;

    /* renamed from: c  reason: collision with root package name */
    final Map<Integer, g> f32112c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    final String f32113d;

    /* renamed from: e  reason: collision with root package name */
    int f32114e;

    /* renamed from: f  reason: collision with root package name */
    int f32115f;

    /* renamed from: g  reason: collision with root package name */
    final j f32116g;

    /* renamed from: h  reason: collision with root package name */
    long f32117h = 0;

    /* renamed from: i  reason: collision with root package name */
    long f32118i;

    /* renamed from: j  reason: collision with root package name */
    k f32119j = new k();

    /* renamed from: k  reason: collision with root package name */
    final k f32120k;

    /* renamed from: l  reason: collision with root package name */
    final Socket f32121l;

    /* renamed from: m  reason: collision with root package name */
    final h f32122m;

    /* renamed from: n  reason: collision with root package name */
    final e f32123n;

    /* renamed from: o  reason: collision with root package name */
    final Set<Integer> f32124o;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f32125r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final ScheduledExecutorService f32126s;

    /* renamed from: t  reason: collision with root package name */
    private final ExecutorService f32127t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public long f32128u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public long f32129v = 0;

    /* renamed from: w  reason: collision with root package name */
    private long f32130w = 0;

    /* renamed from: x  reason: collision with root package name */
    private long f32131x = 0;

    /* renamed from: y  reason: collision with root package name */
    private long f32132y = 0;

    /* renamed from: z  reason: collision with root package name */
    private long f32133z = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Socket f32156a;

        /* renamed from: b  reason: collision with root package name */
        String f32157b;

        /* renamed from: c  reason: collision with root package name */
        okio.e f32158c;

        /* renamed from: d  reason: collision with root package name */
        okio.d f32159d;

        /* renamed from: e  reason: collision with root package name */
        c f32160e = c.f32165h;

        /* renamed from: f  reason: collision with root package name */
        j f32161f = j.f32239a;

        /* renamed from: g  reason: collision with root package name */
        boolean f32162g;

        /* renamed from: h  reason: collision with root package name */
        int f32163h;

        public a(boolean z2) {
            this.f32162g = z2;
        }

        public a a(int i2) {
            this.f32163h = i2;
            return this;
        }

        public a a(Socket socket, String str, okio.e eVar, okio.d dVar) {
            this.f32156a = socket;
            this.f32157b = str;
            this.f32158c = eVar;
            this.f32159d = dVar;
            return this;
        }

        public a a(c cVar) {
            this.f32160e = cVar;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    final class b extends nb.b {
        b() {
            super("OkHttp %s ping", d.this.f32113d);
        }

        public void d() {
            boolean z2;
            synchronized (d.this) {
                if (d.this.f32129v < d.this.f32128u) {
                    z2 = true;
                } else {
                    d.c(d.this);
                    z2 = false;
                }
            }
            d dVar = d.this;
            if (z2) {
                dVar.a((IOException) null);
            } else {
                dVar.a(false, 1, 0);
            }
        }
    }

    public static abstract class c {

        /* renamed from: h  reason: collision with root package name */
        public static final c f32165h = new c() {
            public void a(g gVar) throws IOException {
                gVar.a(ErrorCode.REFUSED_STREAM, (IOException) null);
            }
        };

        public void a(d dVar) {
        }

        public abstract void a(g gVar) throws IOException;
    }

    /* renamed from: okhttp3.internal.http2.d$d  reason: collision with other inner class name */
    final class C0237d extends nb.b {

        /* renamed from: a  reason: collision with root package name */
        final boolean f32166a;

        /* renamed from: b  reason: collision with root package name */
        final int f32167b;

        /* renamed from: d  reason: collision with root package name */
        final int f32168d;

        C0237d(boolean z2, int i2, int i3) {
            super("OkHttp %s ping %08x%08x", d.this.f32113d, Integer.valueOf(i2), Integer.valueOf(i3));
            this.f32166a = z2;
            this.f32167b = i2;
            this.f32168d = i3;
        }

        public void d() {
            d.this.a(this.f32166a, this.f32167b, this.f32168d);
        }
    }

    class e extends nb.b implements f.b {

        /* renamed from: a  reason: collision with root package name */
        final f f32170a;

        e(f fVar) {
            super("OkHttp %s", d.this.f32113d);
            this.f32170a = fVar;
        }

        public void a() {
        }

        public void a(int i2, int i3, int i4, boolean z2) {
        }

        public void a(int i2, int i3, List<a> list) {
            d.this.a(i3, list);
        }

        public void a(int i2, long j2) {
            d dVar = d.this;
            if (i2 == 0) {
                synchronized (dVar) {
                    d.this.f32118i += j2;
                    d.this.notifyAll();
                }
                return;
            }
            g a2 = dVar.a(i2);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j2);
                }
            }
        }

        public void a(int i2, ErrorCode errorCode) {
            if (d.this.c(i2)) {
                d.this.c(i2, errorCode);
                return;
            }
            g b2 = d.this.b(i2);
            if (b2 != null) {
                b2.b(errorCode);
            }
        }

        public void a(int i2, ErrorCode errorCode, ByteString byteString) {
            g[] gVarArr;
            byteString.g();
            synchronized (d.this) {
                gVarArr = (g[]) d.this.f32112c.values().toArray(new g[d.this.f32112c.size()]);
                boolean unused = d.this.f32125r = true;
            }
            for (g gVar : gVarArr) {
                if (gVar.a() > i2 && gVar.c()) {
                    gVar.b(ErrorCode.REFUSED_STREAM);
                    d.this.b(gVar.a());
                }
            }
        }

        public void a(boolean z2, int i2, int i3) {
            if (z2) {
                synchronized (d.this) {
                    if (i2 == 1) {
                        try {
                            d.f(d.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (i2 == 2) {
                        d.g(d.this);
                    } else if (i2 == 3) {
                        d.h(d.this);
                        d.this.notifyAll();
                    }
                }
                return;
            }
            try {
                d.this.f32126s.execute(new C0237d(true, i2, i3));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void a(boolean z2, int i2, int i3, List<a> list) {
            if (d.this.c(i2)) {
                d.this.a(i2, list, z2);
                return;
            }
            synchronized (d.this) {
                g a2 = d.this.a(i2);
                if (a2 != null) {
                    a2.a(nb.c.b(list), z2);
                } else if (!d.this.f32125r) {
                    if (i2 > d.this.f32114e) {
                        if (i2 % 2 != d.this.f32115f % 2) {
                            int i4 = i2;
                            final g gVar = new g(i4, d.this, false, z2, nb.c.b(list));
                            d.this.f32114e = i2;
                            d.this.f32112c.put(Integer.valueOf(i2), gVar);
                            d.f32109q.execute(new nb.b("OkHttp %s stream %d", new Object[]{d.this.f32113d, Integer.valueOf(i2)}) {
                                public void d() {
                                    try {
                                        d.this.f32111b.a(gVar);
                                    } catch (IOException e2) {
                                        ng.f e3 = ng.f.e();
                                        e3.a(4, "Http2Connection.Listener failure for " + d.this.f32113d, (Throwable) e2);
                                        try {
                                            gVar.a(ErrorCode.PROTOCOL_ERROR, e2);
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            });
                        }
                    }
                }
            }
        }

        public void a(boolean z2, int i2, okio.e eVar, int i3) throws IOException {
            if (d.this.c(i2)) {
                d.this.a(i2, eVar, i3, z2);
                return;
            }
            g a2 = d.this.a(i2);
            if (a2 == null) {
                d.this.a(i2, ErrorCode.PROTOCOL_ERROR);
                long j2 = (long) i3;
                d.this.a(j2);
                eVar.h(j2);
                return;
            }
            a2.a(eVar, i3);
            if (z2) {
                a2.a(nb.c.f31315c, true);
            }
        }

        public void a(boolean z2, k kVar) {
            try {
                final boolean z3 = z2;
                final k kVar2 = kVar;
                d.this.f32126s.execute(new nb.b("OkHttp %s ACK Settings", new Object[]{d.this.f32113d}) {
                    public void d() {
                        e.this.b(z3, kVar2);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z2, k kVar) {
            g[] gVarArr;
            long j2;
            synchronized (d.this.f32122m) {
                synchronized (d.this) {
                    int d2 = d.this.f32120k.d();
                    if (z2) {
                        d.this.f32120k.a();
                    }
                    d.this.f32120k.a(kVar);
                    int d3 = d.this.f32120k.d();
                    gVarArr = null;
                    if (d3 == -1 || d3 == d2) {
                        j2 = 0;
                    } else {
                        j2 = (long) (d3 - d2);
                        if (!d.this.f32112c.isEmpty()) {
                            gVarArr = (g[]) d.this.f32112c.values().toArray(new g[d.this.f32112c.size()]);
                        }
                    }
                }
                try {
                    d.this.f32122m.a(d.this.f32120k);
                } catch (IOException e2) {
                    d.this.a(e2);
                }
            }
            if (gVarArr != null) {
                for (g gVar : gVarArr) {
                    synchronized (gVar) {
                        gVar.a(j2);
                    }
                }
            }
            d.f32109q.execute(new nb.b("OkHttp %s settings", d.this.f32113d) {
                public void d() {
                    d.this.f32111b.a(d.this);
                }
            });
        }

        /* access modifiers changed from: protected */
        public void d() {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            IOException e2 = null;
            try {
                this.f32170a.a((f.b) this);
                while (this.f32170a.a(false, (f.b) this)) {
                }
                errorCode2 = ErrorCode.NO_ERROR;
                errorCode = ErrorCode.CANCEL;
            } catch (IOException e3) {
                e2 = e3;
                errorCode2 = ErrorCode.PROTOCOL_ERROR;
                errorCode = ErrorCode.PROTOCOL_ERROR;
            } catch (Throwable th) {
                d.this.a(errorCode2, errorCode3, e2);
                nb.c.a((Closeable) this.f32170a);
                throw th;
            }
            d.this.a(errorCode2, errorCode, e2);
            nb.c.a((Closeable) this.f32170a);
        }
    }

    d(a aVar) {
        a aVar2 = aVar;
        k kVar = new k();
        this.f32120k = kVar;
        this.f32124o = new LinkedHashSet();
        this.f32116g = aVar2.f32161f;
        boolean z2 = aVar2.f32162g;
        this.f32110a = z2;
        this.f32111b = aVar2.f32160e;
        this.f32115f = aVar2.f32162g ? 1 : 2;
        if (aVar2.f32162g) {
            this.f32115f += 2;
        }
        if (aVar2.f32162g) {
            this.f32119j.a(7, 16777216);
        }
        String str = aVar2.f32157b;
        this.f32113d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, nb.c.a(nb.c.a("OkHttp %s Writer", str), false));
        this.f32126s = scheduledThreadPoolExecutor;
        if (aVar2.f32163h != 0) {
            scheduledThreadPoolExecutor.scheduleAtFixedRate(new b(), (long) aVar2.f32163h, (long) aVar2.f32163h, TimeUnit.MILLISECONDS);
        }
        this.f32127t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), nb.c.a(nb.c.a("OkHttp %s Push Observer", str), true));
        kVar.a(7, 65535);
        kVar.a(5, 16384);
        this.f32118i = (long) kVar.d();
        this.f32121l = aVar2.f32156a;
        this.f32122m = new h(aVar2.f32159d, z2);
        this.f32123n = new e(new f(aVar2.f32158c, z2));
    }

    /* access modifiers changed from: private */
    public void a(IOException iOException) {
        a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, iOException);
    }

    private synchronized void a(nb.b bVar) {
        if (!this.f32125r) {
            this.f32127t.execute(bVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.http2.g b(int r11, java.util.List<okhttp3.internal.http2.a> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.h r7 = r10.f32122m
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0076 }
            int r0 = r10.f32115f     // Catch:{ all -> 0x0073 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0073 }
            r10.a((okhttp3.internal.http2.ErrorCode) r0)     // Catch:{ all -> 0x0073 }
        L_0x0013:
            boolean r0 = r10.f32125r     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x006d
            int r8 = r10.f32115f     // Catch:{ all -> 0x0073 }
            int r0 = r8 + 2
            r10.f32115f = r0     // Catch:{ all -> 0x0073 }
            okhttp3.internal.http2.g r9 = new okhttp3.internal.http2.g     // Catch:{ all -> 0x0073 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0073 }
            if (r13 == 0) goto L_0x003a
            long r0 = r10.f32118i     // Catch:{ all -> 0x0073 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x003a
            long r0 = r9.f32199b     // Catch:{ all -> 0x0073 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r13 = 0
            goto L_0x003b
        L_0x003a:
            r13 = 1
        L_0x003b:
            boolean r0 = r9.b()     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x004a
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r10.f32112c     // Catch:{ all -> 0x0073 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0073 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0073 }
        L_0x004a:
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            if (r11 != 0) goto L_0x0053
            okhttp3.internal.http2.h r11 = r10.f32122m     // Catch:{ all -> 0x0076 }
            r11.a((boolean) r6, (int) r8, (java.util.List<okhttp3.internal.http2.a>) r12)     // Catch:{ all -> 0x0076 }
            goto L_0x005c
        L_0x0053:
            boolean r0 = r10.f32110a     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0065
            okhttp3.internal.http2.h r0 = r10.f32122m     // Catch:{ all -> 0x0076 }
            r0.a((int) r11, (int) r8, (java.util.List<okhttp3.internal.http2.a>) r12)     // Catch:{ all -> 0x0076 }
        L_0x005c:
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            if (r13 == 0) goto L_0x0064
            okhttp3.internal.http2.h r11 = r10.f32122m
            r11.b()
        L_0x0064:
            return r9
        L_0x0065:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0076 }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x0076 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x006d:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0073 }
            r11.<init>()     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0073 }
            throw r11     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0076 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.d.b(int, java.util.List, boolean):okhttp3.internal.http2.g");
    }

    static /* synthetic */ long c(d dVar) {
        long j2 = dVar.f32128u;
        dVar.f32128u = 1 + j2;
        return j2;
    }

    static /* synthetic */ long f(d dVar) {
        long j2 = dVar.f32129v;
        dVar.f32129v = 1 + j2;
        return j2;
    }

    static /* synthetic */ long g(d dVar) {
        long j2 = dVar.f32131x;
        dVar.f32131x = 1 + j2;
        return j2;
    }

    static /* synthetic */ long h(d dVar) {
        long j2 = dVar.f32133z;
        dVar.f32133z = 1 + j2;
        return j2;
    }

    public synchronized int a() {
        return this.f32120k.c(SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    /* access modifiers changed from: package-private */
    public synchronized g a(int i2) {
        return this.f32112c.get(Integer.valueOf(i2));
    }

    public g a(List<a> list, boolean z2) throws IOException {
        return b(0, list, z2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        try {
            final int i3 = i2;
            final long j3 = j2;
            this.f32126s.execute(new nb.b("OkHttp Window Update %s stream %d", new Object[]{this.f32113d, Integer.valueOf(i2)}) {
                public void d() {
                    try {
                        d.this.f32122m.a(i3, j3);
                    } catch (IOException e2) {
                        d.this.a(e2);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, List<a> list) {
        synchronized (this) {
            if (this.f32124o.contains(Integer.valueOf(i2))) {
                a(i2, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f32124o.add(Integer.valueOf(i2));
            try {
                final int i3 = i2;
                final List<a> list2 = list;
                a((nb.b) new nb.b("OkHttp %s Push Request[%s]", new Object[]{this.f32113d, Integer.valueOf(i2)}) {
                    public void d() {
                        if (d.this.f32116g.a(i3, (List<a>) list2)) {
                            try {
                                d.this.f32122m.a(i3, ErrorCode.CANCEL);
                                synchronized (d.this) {
                                    d.this.f32124o.remove(Integer.valueOf(i3));
                                }
                            } catch (IOException unused) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, List<a> list, boolean z2) {
        try {
            final int i3 = i2;
            final List<a> list2 = list;
            final boolean z3 = z2;
            a((nb.b) new nb.b("OkHttp %s Push Headers[%s]", new Object[]{this.f32113d, Integer.valueOf(i2)}) {
                public void d() {
                    boolean a2 = d.this.f32116g.a(i3, list2, z3);
                    if (a2) {
                        try {
                            d.this.f32122m.a(i3, ErrorCode.CANCEL);
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (a2 || z3) {
                        synchronized (d.this) {
                            d.this.f32124o.remove(Integer.valueOf(i3));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, ErrorCode errorCode) {
        try {
            final int i3 = i2;
            final ErrorCode errorCode2 = errorCode;
            this.f32126s.execute(new nb.b("OkHttp %s stream %d", new Object[]{this.f32113d, Integer.valueOf(i2)}) {
                public void d() {
                    try {
                        d.this.b(i3, errorCode2);
                    } catch (IOException e2) {
                        d.this.a(e2);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, okio.e eVar, int i3, boolean z2) throws IOException {
        final okio.c cVar = new okio.c();
        long j2 = (long) i3;
        eVar.a(j2);
        eVar.read(cVar, j2);
        if (cVar.a() == j2) {
            final int i4 = i2;
            final int i5 = i3;
            final boolean z3 = z2;
            a((nb.b) new nb.b("OkHttp %s Push Data[%s]", new Object[]{this.f32113d, Integer.valueOf(i2)}) {
                public void d() {
                    try {
                        boolean a2 = d.this.f32116g.a(i4, cVar, i5, z3);
                        if (a2) {
                            d.this.f32122m.a(i4, ErrorCode.CANCEL);
                        }
                        if (a2 || z3) {
                            synchronized (d.this) {
                                d.this.f32124o.remove(Integer.valueOf(i4));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(cVar.a() + " != " + i3);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2, List<a> list) throws IOException {
        this.f32122m.a(z2, i2, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.f32122m.c());
        r6 = (long) r3;
        r8.f32118i -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r9, boolean r10, okio.c r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            okhttp3.internal.http2.h r12 = r8.f32122m
            r12.a((boolean) r10, (int) r9, (okio.c) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f32118i     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r3 = r8.f32112c     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0030:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0056 }
            int r4 = (int) r3     // Catch:{ all -> 0x0056 }
            okhttp3.internal.http2.h r3 = r8.f32122m     // Catch:{ all -> 0x0056 }
            int r3 = r3.c()     // Catch:{ all -> 0x0056 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0056 }
            long r4 = r8.f32118i     // Catch:{ all -> 0x0056 }
            long r6 = (long) r3     // Catch:{ all -> 0x0056 }
            long r4 = r4 - r6
            r8.f32118i = r4     // Catch:{ all -> 0x0056 }
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            long r12 = r12 - r6
            okhttp3.internal.http2.h r4 = r8.f32122m
            if (r10 == 0) goto L_0x0051
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0051
            r5 = 1
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            r4.a((boolean) r5, (int) r9, (okio.c) r11, (int) r3)
            goto L_0x000d
        L_0x0056:
            r9 = move-exception
            goto L_0x0065
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0056 }
            r9.interrupt()     // Catch:{ all -> 0x0056 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0056 }
            r9.<init>()     // Catch:{ all -> 0x0056 }
            throw r9     // Catch:{ all -> 0x0056 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0056 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.d.a(int, boolean, okio.c, long):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(long j2) {
        long j3 = this.f32117h + j2;
        this.f32117h = j3;
        if (j3 >= ((long) (this.f32119j.d() / 2))) {
            a(0, this.f32117h);
            this.f32117h = 0;
        }
    }

    public void a(ErrorCode errorCode) throws IOException {
        synchronized (this.f32122m) {
            synchronized (this) {
                if (!this.f32125r) {
                    this.f32125r = true;
                    int i2 = this.f32114e;
                    this.f32122m.a(i2, errorCode, nb.c.f31313a);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x004b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(okhttp3.internal.http2.ErrorCode r4, okhttp3.internal.http2.ErrorCode r5, java.io.IOException r6) {
        /*
            r3 = this;
            boolean r0 = f32108p
            if (r0 != 0) goto L_0x0011
            boolean r0 = java.lang.Thread.holdsLock(r3)
            if (r0 != 0) goto L_0x000b
            goto L_0x0011
        L_0x000b:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x0011:
            r3.a((okhttp3.internal.http2.ErrorCode) r4)     // Catch:{ IOException -> 0x0014 }
        L_0x0014:
            r4 = 0
            monitor-enter(r3)
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r3.f32112c     // Catch:{ all -> 0x005b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0037
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r4 = r3.f32112c     // Catch:{ all -> 0x005b }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x005b }
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r3.f32112c     // Catch:{ all -> 0x005b }
            int r0 = r0.size()     // Catch:{ all -> 0x005b }
            okhttp3.internal.http2.g[] r0 = new okhttp3.internal.http2.g[r0]     // Catch:{ all -> 0x005b }
            java.lang.Object[] r4 = r4.toArray(r0)     // Catch:{ all -> 0x005b }
            okhttp3.internal.http2.g[] r4 = (okhttp3.internal.http2.g[]) r4     // Catch:{ all -> 0x005b }
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.g> r0 = r3.f32112c     // Catch:{ all -> 0x005b }
            r0.clear()     // Catch:{ all -> 0x005b }
        L_0x0037:
            monitor-exit(r3)     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x0046
            int r0 = r4.length
            r1 = 0
        L_0x003c:
            if (r1 >= r0) goto L_0x0046
            r2 = r4[r1]
            r2.a((okhttp3.internal.http2.ErrorCode) r5, (java.io.IOException) r6)     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            int r1 = r1 + 1
            goto L_0x003c
        L_0x0046:
            okhttp3.internal.http2.h r4 = r3.f32122m     // Catch:{ IOException -> 0x004b }
            r4.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            java.net.Socket r4 = r3.f32121l     // Catch:{ IOException -> 0x0050 }
            r4.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0050:
            java.util.concurrent.ScheduledExecutorService r4 = r3.f32126s
            r4.shutdown()
            java.util.concurrent.ExecutorService r4 = r3.f32127t
            r4.shutdown()
            return
        L_0x005b:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005e:
            throw r4
        L_0x005f:
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.d.a(okhttp3.internal.http2.ErrorCode, okhttp3.internal.http2.ErrorCode, java.io.IOException):void");
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) throws IOException {
        if (z2) {
            this.f32122m.a();
            this.f32122m.b(this.f32119j);
            int d2 = this.f32119j.d();
            if (d2 != 65535) {
                this.f32122m.a(0, (long) (d2 - 65535));
            }
        }
        new Thread(this.f32123n).start();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2, int i2, int i3) {
        try {
            this.f32122m.a(z2, i2, i3);
        } catch (IOException e2) {
            a(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized g b(int i2) {
        g remove;
        remove = this.f32112c.remove(Integer.valueOf(i2));
        notifyAll();
        return remove;
    }

    public void b() throws IOException {
        this.f32122m.b();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, ErrorCode errorCode) throws IOException {
        this.f32122m.a(i2, errorCode);
    }

    public synchronized boolean b(long j2) {
        if (this.f32125r) {
            return false;
        }
        return this.f32131x >= this.f32130w || j2 < this.A;
    }

    public void c() throws IOException {
        a(true);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, ErrorCode errorCode) {
        final int i3 = i2;
        final ErrorCode errorCode2 = errorCode;
        a((nb.b) new nb.b("OkHttp %s Push Reset[%s]", new Object[]{this.f32113d, Integer.valueOf(i2)}) {
            public void d() {
                d.this.f32116g.a(i3, errorCode2);
                synchronized (d.this) {
                    d.this.f32124o.remove(Integer.valueOf(i3));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public void close() {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL, (IOException) null);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        synchronized (this) {
            long j2 = this.f32131x;
            long j3 = this.f32130w;
            if (j2 >= j3) {
                this.f32130w = j3 + 1;
                this.A = System.nanoTime() + 1000000000;
                try {
                    this.f32126s.execute(new nb.b("OkHttp %s ping", this.f32113d) {
                        public void d() {
                            d.this.a(false, 2, 0);
                        }
                    });
                } catch (RejectedExecutionException unused) {
                }
            }
        }
    }
}
