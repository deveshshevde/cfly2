package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import okhttp3.s;
import okio.e;
import okio.q;
import okio.r;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class g {

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ boolean f32197j = true;

    /* renamed from: a  reason: collision with root package name */
    long f32198a = 0;

    /* renamed from: b  reason: collision with root package name */
    long f32199b;

    /* renamed from: c  reason: collision with root package name */
    final int f32200c;

    /* renamed from: d  reason: collision with root package name */
    final d f32201d;

    /* renamed from: e  reason: collision with root package name */
    final a f32202e;

    /* renamed from: f  reason: collision with root package name */
    final c f32203f;

    /* renamed from: g  reason: collision with root package name */
    final c f32204g;

    /* renamed from: h  reason: collision with root package name */
    ErrorCode f32205h;

    /* renamed from: i  reason: collision with root package name */
    IOException f32206i;

    /* renamed from: k  reason: collision with root package name */
    private final Deque<s> f32207k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f32208l;

    /* renamed from: m  reason: collision with root package name */
    private final b f32209m;

    final class a implements q {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f32210c = true;

        /* renamed from: a  reason: collision with root package name */
        boolean f32211a;

        /* renamed from: b  reason: collision with root package name */
        boolean f32212b;

        /* renamed from: e  reason: collision with root package name */
        private final okio.c f32214e = new okio.c();

        /* renamed from: f  reason: collision with root package name */
        private s f32215f;

        static {
            Class<g> cls = g.class;
        }

        a() {
        }

        /* JADX INFO: finally extract failed */
        private void a(boolean z2) throws IOException {
            long min;
            boolean z3;
            synchronized (g.this) {
                g.this.f32204g.c();
                while (g.this.f32199b <= 0 && !this.f32212b && !this.f32211a && g.this.f32205h == null) {
                    try {
                        g.this.k();
                    } catch (Throwable th) {
                        g.this.f32204g.b();
                        throw th;
                    }
                }
                g.this.f32204g.b();
                g.this.j();
                min = Math.min(g.this.f32199b, this.f32214e.a());
                g.this.f32199b -= min;
            }
            g.this.f32204g.c();
            if (z2) {
                try {
                    if (min == this.f32214e.a()) {
                        z3 = true;
                        g.this.f32201d.a(g.this.f32200c, z3, this.f32214e, min);
                        g.this.f32204g.b();
                    }
                } catch (Throwable th2) {
                    g.this.f32204g.b();
                    throw th2;
                }
            }
            z3 = false;
            g.this.f32201d.a(g.this.f32200c, z3, this.f32214e, min);
            g.this.f32204g.b();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r8.f32213d.f32202e.f32212b != false) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
            if (r8.f32214e.a() <= 0) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
            r2 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
            if (r8.f32215f == null) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
            if (r3 == false) goto L_0x005f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
            if (r8.f32214e.a() <= 0) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
            a(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
            r8.f32213d.f32201d.a(r8.f32213d.f32200c, true, nb.c.a(r8.f32215f));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
            if (r2 == false) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
            if (r8.f32214e.a() <= 0) goto L_0x007e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
            a(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
            r8.f32213d.f32201d.a(r8.f32213d.f32200c, true, (okio.c) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x007e, code lost:
            r2 = r8.f32213d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            r8.f32211a = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0083, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0084, code lost:
            r8.f32213d.f32201d.b();
            r8.f32213d.i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0090, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                boolean r0 = f32210c
                if (r0 != 0) goto L_0x0013
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                boolean r0 = java.lang.Thread.holdsLock(r0)
                if (r0 != 0) goto L_0x000d
                goto L_0x0013
            L_0x000d:
                java.lang.AssertionError r0 = new java.lang.AssertionError
                r0.<init>()
                throw r0
            L_0x0013:
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                monitor-enter(r0)
                boolean r1 = r8.f32211a     // Catch:{ all -> 0x0094 }
                if (r1 == 0) goto L_0x001c
                monitor-exit(r0)     // Catch:{ all -> 0x0094 }
                return
            L_0x001c:
                monitor-exit(r0)     // Catch:{ all -> 0x0094 }
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                okhttp3.internal.http2.g$a r0 = r0.f32202e
                boolean r0 = r0.f32212b
                r1 = 1
                if (r0 != 0) goto L_0x007e
                okio.c r0 = r8.f32214e
                long r2 = r0.a()
                r0 = 0
                r4 = 0
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x0035
                r2 = 1
                goto L_0x0036
            L_0x0035:
                r2 = 0
            L_0x0036:
                okhttp3.s r3 = r8.f32215f
                if (r3 == 0) goto L_0x003c
                r3 = 1
                goto L_0x003d
            L_0x003c:
                r3 = 0
            L_0x003d:
                if (r3 == 0) goto L_0x005f
            L_0x003f:
                okio.c r2 = r8.f32214e
                long r2 = r2.a()
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x004d
                r8.a(r0)
                goto L_0x003f
            L_0x004d:
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                okhttp3.internal.http2.d r0 = r0.f32201d
                okhttp3.internal.http2.g r2 = okhttp3.internal.http2.g.this
                int r2 = r2.f32200c
                okhttp3.s r3 = r8.f32215f
                java.util.List r3 = nb.c.a((okhttp3.s) r3)
                r0.a((int) r2, (boolean) r1, (java.util.List<okhttp3.internal.http2.a>) r3)
                goto L_0x007e
            L_0x005f:
                if (r2 == 0) goto L_0x006f
            L_0x0061:
                okio.c r0 = r8.f32214e
                long r2 = r0.a()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x007e
                r8.a(r1)
                goto L_0x0061
            L_0x006f:
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                okhttp3.internal.http2.d r2 = r0.f32201d
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                int r3 = r0.f32200c
                r4 = 1
                r5 = 0
                r6 = 0
                r2.a((int) r3, (boolean) r4, (okio.c) r5, (long) r6)
            L_0x007e:
                okhttp3.internal.http2.g r2 = okhttp3.internal.http2.g.this
                monitor-enter(r2)
                r8.f32211a = r1     // Catch:{ all -> 0x0091 }
                monitor-exit(r2)     // Catch:{ all -> 0x0091 }
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                okhttp3.internal.http2.d r0 = r0.f32201d
                r0.b()
                okhttp3.internal.http2.g r0 = okhttp3.internal.http2.g.this
                r0.i()
                return
            L_0x0091:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0091 }
                throw r0
            L_0x0094:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0094 }
                goto L_0x0098
            L_0x0097:
                throw r1
            L_0x0098:
                goto L_0x0097
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.g.a.close():void");
        }

        public void flush() throws IOException {
            if (f32210c || !Thread.holdsLock(g.this)) {
                synchronized (g.this) {
                    g.this.j();
                }
                while (this.f32214e.a() > 0) {
                    a(false);
                    g.this.f32201d.b();
                }
                return;
            }
            throw new AssertionError();
        }

        public okio.s timeout() {
            return g.this.f32204g;
        }

        public void write(okio.c cVar, long j2) throws IOException {
            if (f32210c || !Thread.holdsLock(g.this)) {
                this.f32214e.write(cVar, j2);
                while (this.f32214e.a() >= IjkMediaMeta.AV_CH_TOP_FRONT_RIGHT) {
                    a(false);
                }
                return;
            }
            throw new AssertionError();
        }
    }

    private final class b implements r {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ boolean f32216c = true;

        /* renamed from: a  reason: collision with root package name */
        boolean f32217a;

        /* renamed from: b  reason: collision with root package name */
        boolean f32218b;

        /* renamed from: e  reason: collision with root package name */
        private final okio.c f32220e = new okio.c();

        /* renamed from: f  reason: collision with root package name */
        private final okio.c f32221f = new okio.c();

        /* renamed from: g  reason: collision with root package name */
        private final long f32222g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public s f32223h;

        static {
            Class<g> cls = g.class;
        }

        b(long j2) {
            this.f32222g = j2;
        }

        private void a(long j2) {
            if (f32216c || !Thread.holdsLock(g.this)) {
                g.this.f32201d.a(j2);
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public void a(e eVar, long j2) throws IOException {
            boolean z2;
            boolean z3;
            boolean z4;
            long j3;
            if (f32216c || !Thread.holdsLock(g.this)) {
                while (j2 > 0) {
                    synchronized (g.this) {
                        z2 = this.f32218b;
                        z3 = true;
                        z4 = this.f32221f.a() + j2 > this.f32222g;
                    }
                    if (z4) {
                        eVar.h(j2);
                        g.this.a(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z2) {
                        eVar.h(j2);
                        return;
                    } else {
                        long read = eVar.read(this.f32220e, j2);
                        if (read != -1) {
                            j2 -= read;
                            synchronized (g.this) {
                                if (this.f32217a) {
                                    j3 = this.f32220e.a();
                                    this.f32220e.s();
                                } else {
                                    if (this.f32221f.a() != 0) {
                                        z3 = false;
                                    }
                                    this.f32221f.a((r) this.f32220e);
                                    if (z3) {
                                        g.this.notifyAll();
                                    }
                                    j3 = 0;
                                }
                            }
                            if (j3 > 0) {
                                a(j3);
                            }
                        } else {
                            throw new EOFException();
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public void close() throws IOException {
            long a2;
            synchronized (g.this) {
                this.f32217a = true;
                a2 = this.f32221f.a();
                this.f32221f.s();
                g.this.notifyAll();
            }
            if (a2 > 0) {
                a(a2);
            }
            g.this.i();
        }

        public long read(okio.c cVar, long j2) throws IOException {
            Throwable th;
            long read;
            if (j2 >= 0) {
                while (true) {
                    th = null;
                    synchronized (g.this) {
                        g.this.f32203f.c();
                        try {
                            if (g.this.f32205h != null) {
                                th = g.this.f32206i != null ? g.this.f32206i : new StreamResetException(g.this.f32205h);
                            }
                            if (this.f32217a) {
                                throw new IOException("stream closed");
                            } else if (this.f32221f.a() > 0) {
                                okio.c cVar2 = this.f32221f;
                                read = cVar2.read(cVar, Math.min(j2, cVar2.a()));
                                g.this.f32198a += read;
                                if (th == null && g.this.f32198a >= ((long) (g.this.f32201d.f32119j.d() / 2))) {
                                    g.this.f32201d.a(g.this.f32200c, g.this.f32198a);
                                    g.this.f32198a = 0;
                                }
                            } else if (this.f32218b || th != null) {
                                read = -1;
                            } else {
                                g.this.k();
                            }
                        } finally {
                            g.this.f32203f.b();
                        }
                    }
                }
                read = -1;
                g.this.f32203f.b();
                if (read != -1) {
                    a(read);
                    return read;
                } else if (th == null) {
                    return -1;
                } else {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
        }

        public okio.s timeout() {
            return g.this.f32203f;
        }
    }

    class c extends okio.a {
        c() {
        }

        /* access modifiers changed from: protected */
        public IOException a(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        /* access modifiers changed from: protected */
        public void a() {
            g.this.a(ErrorCode.CANCEL);
            g.this.f32201d.d();
        }

        public void b() throws IOException {
            if (A_()) {
                throw a((IOException) null);
            }
        }
    }

    g(int i2, d dVar, boolean z2, boolean z3, s sVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f32207k = arrayDeque;
        this.f32203f = new c();
        this.f32204g = new c();
        Objects.requireNonNull(dVar, "connection == null");
        this.f32200c = i2;
        this.f32201d = dVar;
        this.f32199b = (long) dVar.f32120k.d();
        b bVar = new b((long) dVar.f32119j.d());
        this.f32209m = bVar;
        a aVar = new a();
        this.f32202e = aVar;
        bVar.f32218b = z3;
        aVar.f32212b = z2;
        if (sVar != null) {
            arrayDeque.add(sVar);
        }
        if (c() && sVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        } else if (!c() && sVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    private boolean b(ErrorCode errorCode, IOException iOException) {
        if (f32197j || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f32205h != null) {
                    return false;
                }
                if (this.f32209m.f32218b && this.f32202e.f32212b) {
                    return false;
                }
                this.f32205h = errorCode;
                this.f32206i = iOException;
                notifyAll();
                this.f32201d.b(this.f32200c);
                return true;
            }
        }
        throw new AssertionError();
    }

    public int a() {
        return this.f32200c;
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.f32199b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public void a(ErrorCode errorCode) {
        if (b(errorCode, (IOException) null)) {
            this.f32201d.a(this.f32200c, errorCode);
        }
    }

    public void a(ErrorCode errorCode, IOException iOException) throws IOException {
        if (b(errorCode, iOException)) {
            this.f32201d.b(this.f32200c, errorCode);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(okhttp3.s r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = f32197j
            if (r0 != 0) goto L_0x0011
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L_0x000b
            goto L_0x0011
        L_0x000b:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L_0x0011:
            monitor-enter(r2)
            boolean r0 = r2.f32208l     // Catch:{ all -> 0x003f }
            r1 = 1
            if (r0 == 0) goto L_0x0020
            if (r4 != 0) goto L_0x001a
            goto L_0x0020
        L_0x001a:
            okhttp3.internal.http2.g$b r0 = r2.f32209m     // Catch:{ all -> 0x003f }
            okhttp3.s unused = r0.f32223h = r3     // Catch:{ all -> 0x003f }
            goto L_0x0027
        L_0x0020:
            r2.f32208l = r1     // Catch:{ all -> 0x003f }
            java.util.Deque<okhttp3.s> r0 = r2.f32207k     // Catch:{ all -> 0x003f }
            r0.add(r3)     // Catch:{ all -> 0x003f }
        L_0x0027:
            if (r4 == 0) goto L_0x002d
            okhttp3.internal.http2.g$b r3 = r2.f32209m     // Catch:{ all -> 0x003f }
            r3.f32218b = r1     // Catch:{ all -> 0x003f }
        L_0x002d:
            boolean r3 = r2.b()     // Catch:{ all -> 0x003f }
            r2.notifyAll()     // Catch:{ all -> 0x003f }
            monitor-exit(r2)     // Catch:{ all -> 0x003f }
            if (r3 != 0) goto L_0x003e
            okhttp3.internal.http2.d r3 = r2.f32201d
            int r4 = r2.f32200c
            r3.b((int) r4)
        L_0x003e:
            return
        L_0x003f:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.g.a(okhttp3.s, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar, int i2) throws IOException {
        if (f32197j || !Thread.holdsLock(this)) {
            this.f32209m.a(eVar, (long) i2);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b(ErrorCode errorCode) {
        if (this.f32205h == null) {
            this.f32205h = errorCode;
            notifyAll();
        }
    }

    public synchronized boolean b() {
        if (this.f32205h != null) {
            return false;
        }
        return (!this.f32209m.f32218b && !this.f32209m.f32217a) || (!this.f32202e.f32212b && !this.f32202e.f32211a) || !this.f32208l;
    }

    public boolean c() {
        return this.f32201d.f32110a == ((this.f32200c & 1) == 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r2.f32203f.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized okhttp3.s d() throws java.io.IOException {
        /*
            r2 = this;
            monitor-enter(r2)
            okhttp3.internal.http2.g$c r0 = r2.f32203f     // Catch:{ all -> 0x0041 }
            r0.c()     // Catch:{ all -> 0x0041 }
        L_0x0006:
            java.util.Deque<okhttp3.s> r0 = r2.f32207k     // Catch:{ all -> 0x003a }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0016
            okhttp3.internal.http2.ErrorCode r0 = r2.f32205h     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0016
            r2.k()     // Catch:{ all -> 0x003a }
            goto L_0x0006
        L_0x0016:
            okhttp3.internal.http2.g$c r0 = r2.f32203f     // Catch:{ all -> 0x0041 }
            r0.b()     // Catch:{ all -> 0x0041 }
            java.util.Deque<okhttp3.s> r0 = r2.f32207k     // Catch:{ all -> 0x0041 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0041 }
            if (r0 != 0) goto L_0x002d
            java.util.Deque<okhttp3.s> r0 = r2.f32207k     // Catch:{ all -> 0x0041 }
            java.lang.Object r0 = r0.removeFirst()     // Catch:{ all -> 0x0041 }
            okhttp3.s r0 = (okhttp3.s) r0     // Catch:{ all -> 0x0041 }
            monitor-exit(r2)
            return r0
        L_0x002d:
            java.io.IOException r0 = r2.f32206i     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0032
            goto L_0x0039
        L_0x0032:
            okhttp3.internal.http2.StreamResetException r0 = new okhttp3.internal.http2.StreamResetException     // Catch:{ all -> 0x0041 }
            okhttp3.internal.http2.ErrorCode r1 = r2.f32205h     // Catch:{ all -> 0x0041 }
            r0.<init>(r1)     // Catch:{ all -> 0x0041 }
        L_0x0039:
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x003a:
            r0 = move-exception
            okhttp3.internal.http2.g$c r1 = r2.f32203f     // Catch:{ all -> 0x0041 }
            r1.b()     // Catch:{ all -> 0x0041 }
            throw r0     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r0 = move-exception
            monitor-exit(r2)
            goto L_0x0045
        L_0x0044:
            throw r0
        L_0x0045:
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.g.d():okhttp3.s");
    }

    public okio.s e() {
        return this.f32203f;
    }

    public okio.s f() {
        return this.f32204g;
    }

    public r g() {
        return this.f32209m;
    }

    public q h() {
        synchronized (this) {
            if (!this.f32208l) {
                if (!c()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.f32202e;
    }

    /* access modifiers changed from: package-private */
    public void i() throws IOException {
        boolean z2;
        boolean b2;
        if (f32197j || !Thread.holdsLock(this)) {
            synchronized (this) {
                z2 = !this.f32209m.f32218b && this.f32209m.f32217a && (this.f32202e.f32212b || this.f32202e.f32211a);
                b2 = b();
            }
            if (z2) {
                a(ErrorCode.CANCEL, (IOException) null);
            } else if (!b2) {
                this.f32201d.b(this.f32200c);
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() throws IOException {
        if (this.f32202e.f32211a) {
            throw new IOException("stream closed");
        } else if (this.f32202e.f32212b) {
            throw new IOException("stream finished");
        } else if (this.f32205h != null) {
            Throwable th = this.f32206i;
            if (th == null) {
                th = new StreamResetException(this.f32205h);
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
