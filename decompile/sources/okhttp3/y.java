package okhttp3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import nb.b;
import okhttp3.internal.connection.i;
import okio.s;

final class y implements e {

    /* renamed from: a  reason: collision with root package name */
    final x f32395a;

    /* renamed from: b  reason: collision with root package name */
    final z f32396b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f32397c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public i f32398d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32399e;

    final class a extends b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f32400a = true;

        /* renamed from: d  reason: collision with root package name */
        private final f f32402d;

        /* renamed from: e  reason: collision with root package name */
        private volatile AtomicInteger f32403e = new AtomicInteger(0);

        static {
            Class<y> cls = y.class;
        }

        a(f fVar) {
            super("OkHttp %s", y.this.h());
            this.f32402d = fVar;
        }

        /* access modifiers changed from: package-private */
        public AtomicInteger a() {
            return this.f32403e;
        }

        /* access modifiers changed from: package-private */
        public void a(ExecutorService executorService) {
            if (f32400a || !Thread.holdsLock(y.this.f32395a.u())) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e2) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e2);
                    y.this.f32398d.a((IOException) interruptedIOException);
                    this.f32402d.onFailure(y.this, interruptedIOException);
                    y.this.f32395a.u().b(this);
                } catch (Throwable th) {
                    y.this.f32395a.u().b(this);
                    throw th;
                }
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            this.f32403e = aVar.f32403e;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return y.this.f32396b.a().f();
        }

        /* access modifiers changed from: package-private */
        public y c() {
            return y.this;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[Catch:{ IOException -> 0x0055, all -> 0x0028, all -> 0x0053 }] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[Catch:{ IOException -> 0x0055, all -> 0x0028, all -> 0x0053 }] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A[Catch:{ IOException -> 0x0055, all -> 0x0028, all -> 0x0053 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void d() {
            /*
                r5 = this;
                okhttp3.y r0 = okhttp3.y.this
                okhttp3.internal.connection.i r0 = r0.f32398d
                r0.b()
                r0 = 0
                okhttp3.y r1 = okhttp3.y.this     // Catch:{ IOException -> 0x0055, all -> 0x0028 }
                okhttp3.ab r0 = r1.i()     // Catch:{ IOException -> 0x0055, all -> 0x0028 }
                r1 = 1
                okhttp3.f r2 = r5.f32402d     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
                okhttp3.y r3 = okhttp3.y.this     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
                r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x0026, all -> 0x0024 }
            L_0x0018:
                okhttp3.y r0 = okhttp3.y.this
                okhttp3.x r0 = r0.f32395a
                okhttp3.n r0 = r0.u()
                r0.b((okhttp3.y.a) r5)
                goto L_0x0082
            L_0x0024:
                r0 = move-exception
                goto L_0x002b
            L_0x0026:
                r0 = move-exception
                goto L_0x0058
            L_0x0028:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x002b:
                okhttp3.y r2 = okhttp3.y.this     // Catch:{ all -> 0x0053 }
                r2.c()     // Catch:{ all -> 0x0053 }
                if (r1 != 0) goto L_0x0052
                java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0053 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
                r2.<init>()     // Catch:{ all -> 0x0053 }
                java.lang.String r3 = "canceled due to "
                r2.append(r3)     // Catch:{ all -> 0x0053 }
                r2.append(r0)     // Catch:{ all -> 0x0053 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0053 }
                r1.<init>(r2)     // Catch:{ all -> 0x0053 }
                r1.addSuppressed(r0)     // Catch:{ all -> 0x0053 }
                okhttp3.f r2 = r5.f32402d     // Catch:{ all -> 0x0053 }
                okhttp3.y r3 = okhttp3.y.this     // Catch:{ all -> 0x0053 }
                r2.onFailure(r3, r1)     // Catch:{ all -> 0x0053 }
            L_0x0052:
                throw r0     // Catch:{ all -> 0x0053 }
            L_0x0053:
                r0 = move-exception
                goto L_0x0083
            L_0x0055:
                r1 = move-exception
                r0 = r1
                r1 = 0
            L_0x0058:
                if (r1 == 0) goto L_0x007a
                ng.f r1 = ng.f.e()     // Catch:{ all -> 0x0053 }
                r2 = 4
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
                r3.<init>()     // Catch:{ all -> 0x0053 }
                java.lang.String r4 = "Callback failure for "
                r3.append(r4)     // Catch:{ all -> 0x0053 }
                okhttp3.y r4 = okhttp3.y.this     // Catch:{ all -> 0x0053 }
                java.lang.String r4 = r4.g()     // Catch:{ all -> 0x0053 }
                r3.append(r4)     // Catch:{ all -> 0x0053 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0053 }
                r1.a((int) r2, (java.lang.String) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0053 }
                goto L_0x0018
            L_0x007a:
                okhttp3.f r1 = r5.f32402d     // Catch:{ all -> 0x0053 }
                okhttp3.y r2 = okhttp3.y.this     // Catch:{ all -> 0x0053 }
                r1.onFailure(r2, r0)     // Catch:{ all -> 0x0053 }
                goto L_0x0018
            L_0x0082:
                return
            L_0x0083:
                okhttp3.y r1 = okhttp3.y.this
                okhttp3.x r1 = r1.f32395a
                okhttp3.n r1 = r1.u()
                r1.b((okhttp3.y.a) r5)
                goto L_0x0090
            L_0x008f:
                throw r0
            L_0x0090:
                goto L_0x008f
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.y.a.d():void");
        }
    }

    private y(x xVar, z zVar, boolean z2) {
        this.f32395a = xVar;
        this.f32396b = zVar;
        this.f32397c = z2;
    }

    static y a(x xVar, z zVar, boolean z2) {
        y yVar = new y(xVar, zVar, z2);
        yVar.f32398d = new i(xVar, yVar);
        return yVar;
    }

    public z a() {
        return this.f32396b;
    }

    public void a(f fVar) {
        synchronized (this) {
            if (!this.f32399e) {
                this.f32399e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f32398d.d();
        this.f32395a.u().a(new a(fVar));
    }

    public ab b() throws IOException {
        synchronized (this) {
            if (!this.f32399e) {
                this.f32399e = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        this.f32398d.b();
        this.f32398d.d();
        try {
            this.f32395a.u().a(this);
            return i();
        } finally {
            this.f32395a.u().b(this);
        }
    }

    public void c() {
        this.f32398d.i();
    }

    public boolean d() {
        return this.f32398d.j();
    }

    public s e() {
        return this.f32398d.a();
    }

    /* renamed from: f */
    public y clone() {
        return a(this.f32395a, this.f32396b, this.f32397c);
    }

    /* access modifiers changed from: package-private */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.f32397c ? "web socket" : "call");
        sb.append(" to ");
        sb.append(h());
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public String h() {
        return this.f32396b.a().n();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.ab i() throws java.io.IOException {
        /*
            r11 = this;
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            okhttp3.x r0 = r11.f32395a
            java.util.List r0 = r0.x()
            r1.addAll(r0)
            nd.j r0 = new nd.j
            okhttp3.x r2 = r11.f32395a
            r0.<init>(r2)
            r1.add(r0)
            nd.a r0 = new nd.a
            okhttp3.x r2 = r11.f32395a
            okhttp3.m r2 = r2.h()
            r0.<init>(r2)
            r1.add(r0)
            nc.a r0 = new nc.a
            okhttp3.x r2 = r11.f32395a
            nc.e r2 = r2.i()
            r0.<init>(r2)
            r1.add(r0)
            okhttp3.internal.connection.a r0 = new okhttp3.internal.connection.a
            okhttp3.x r2 = r11.f32395a
            r0.<init>(r2)
            r1.add(r0)
            boolean r0 = r11.f32397c
            if (r0 != 0) goto L_0x004b
            okhttp3.x r0 = r11.f32395a
            java.util.List r0 = r0.y()
            r1.addAll(r0)
        L_0x004b:
            nd.b r0 = new nd.b
            boolean r2 = r11.f32397c
            r0.<init>(r2)
            r1.add(r0)
            nd.g r10 = new nd.g
            okhttp3.internal.connection.i r2 = r11.f32398d
            r3 = 0
            r4 = 0
            okhttp3.z r5 = r11.f32396b
            okhttp3.x r0 = r11.f32395a
            int r7 = r0.b()
            okhttp3.x r0 = r11.f32395a
            int r8 = r0.c()
            okhttp3.x r0 = r11.f32395a
            int r9 = r0.d()
            r0 = r10
            r6 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = 0
            r1 = 0
            okhttp3.z r2 = r11.f32396b     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            okhttp3.ab r2 = r10.a(r2)     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            okhttp3.internal.connection.i r3 = r11.f32398d     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            boolean r3 = r3.j()     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            if (r3 != 0) goto L_0x008a
            okhttp3.internal.connection.i r0 = r11.f32398d
            r0.a((java.io.IOException) r1)
            return r2
        L_0x008a:
            nb.c.a((java.io.Closeable) r2)     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
            throw r2     // Catch:{ IOException -> 0x0097, all -> 0x0095 }
        L_0x0095:
            r2 = move-exception
            goto L_0x00a3
        L_0x0097:
            r0 = move-exception
            r2 = 1
            okhttp3.internal.connection.i r3 = r11.f32398d     // Catch:{ all -> 0x00a0 }
            java.io.IOException r0 = r3.a((java.io.IOException) r0)     // Catch:{ all -> 0x00a0 }
            throw r0     // Catch:{ all -> 0x00a0 }
        L_0x00a0:
            r0 = move-exception
            r2 = r0
            r0 = 1
        L_0x00a3:
            if (r0 != 0) goto L_0x00aa
            okhttp3.internal.connection.i r0 = r11.f32398d
            r0.a((java.io.IOException) r1)
        L_0x00aa:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.y.i():okhttp3.ab");
    }
}
