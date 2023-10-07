package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import nb.c;
import ng.f;
import okhttp3.e;
import okhttp3.g;
import okhttp3.p;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;
import okio.s;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f32043b = true;

    /* renamed from: a  reason: collision with root package name */
    public e f32044a;

    /* renamed from: c  reason: collision with root package name */
    private final x f32045c;

    /* renamed from: d  reason: collision with root package name */
    private final f f32046d;

    /* renamed from: e  reason: collision with root package name */
    private final e f32047e;

    /* renamed from: f  reason: collision with root package name */
    private final p f32048f;

    /* renamed from: g  reason: collision with root package name */
    private final okio.a f32049g;

    /* renamed from: h  reason: collision with root package name */
    private Object f32050h;

    /* renamed from: i  reason: collision with root package name */
    private z f32051i;

    /* renamed from: j  reason: collision with root package name */
    private d f32052j;

    /* renamed from: k  reason: collision with root package name */
    private c f32053k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f32054l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f32055m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f32056n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f32057o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f32058p;

    static final class a extends WeakReference<i> {

        /* renamed from: a  reason: collision with root package name */
        final Object f32060a;

        a(i iVar, Object obj) {
            super(iVar);
            this.f32060a = obj;
        }
    }

    public i(x xVar, e eVar) {
        AnonymousClass1 r0 = new okio.a() {
            /* access modifiers changed from: protected */
            public void a() {
                i.this.i();
            }
        };
        this.f32049g = r0;
        this.f32045c = xVar;
        this.f32046d = nb.a.f31311a.a(xVar.q());
        this.f32047e = eVar;
        this.f32048f = xVar.z().create(eVar);
        r0.a((long) xVar.a(), TimeUnit.MILLISECONDS);
    }

    private IOException a(IOException iOException, boolean z2) {
        e eVar;
        Socket e2;
        boolean z3;
        boolean z4;
        synchronized (this.f32046d) {
            if (z2) {
                if (this.f32053k != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            eVar = this.f32044a;
            e2 = (eVar == null || this.f32053k != null || (!z2 && !this.f32058p)) ? null : e();
            if (this.f32044a != null) {
                eVar = null;
            }
            z3 = true;
            z4 = this.f32058p && this.f32053k == null;
        }
        c.a(e2);
        if (eVar != null) {
            this.f32048f.b(this.f32047e, (okhttp3.i) eVar);
        }
        if (z4) {
            if (iOException == null) {
                z3 = false;
            }
            iOException = b(iOException);
            p pVar = this.f32048f;
            e eVar2 = this.f32047e;
            if (z3) {
                pVar.c(eVar2, iOException);
            } else {
                pVar.g(eVar2);
            }
        }
        return iOException;
    }

    private okhttp3.a a(t tVar) {
        g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (tVar.c()) {
            SSLSocketFactory l2 = this.f32045c.l();
            hostnameVerifier = this.f32045c.m();
            sSLSocketFactory = l2;
            gVar = this.f32045c.n();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new okhttp3.a(tVar.f(), tVar.g(), this.f32045c.j(), this.f32045c.k(), sSLSocketFactory, hostnameVerifier, gVar, this.f32045c.p(), this.f32045c.f(), this.f32045c.v(), this.f32045c.w(), this.f32045c.g());
    }

    private IOException b(IOException iOException) {
        if (this.f32057o || !this.f32049g.A_()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public IOException a(IOException iOException) {
        synchronized (this.f32046d) {
            this.f32058p = true;
        }
        return a(iOException, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (r2 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return a(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.IOException a(okhttp3.internal.connection.c r4, boolean r5, boolean r6, java.io.IOException r7) {
        /*
            r3 = this;
            okhttp3.internal.connection.f r0 = r3.f32046d
            monitor-enter(r0)
            okhttp3.internal.connection.c r1 = r3.f32053k     // Catch:{ all -> 0x003d }
            if (r4 == r1) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return r7
        L_0x0009:
            r4 = 0
            r2 = 1
            if (r5 == 0) goto L_0x0013
            boolean r5 = r3.f32054l     // Catch:{ all -> 0x003d }
            r5 = r5 ^ r2
            r3.f32054l = r2     // Catch:{ all -> 0x003d }
            goto L_0x0014
        L_0x0013:
            r5 = 0
        L_0x0014:
            if (r6 == 0) goto L_0x001d
            boolean r6 = r3.f32055m     // Catch:{ all -> 0x003d }
            if (r6 != 0) goto L_0x001b
            r5 = 1
        L_0x001b:
            r3.f32055m = r2     // Catch:{ all -> 0x003d }
        L_0x001d:
            boolean r6 = r3.f32054l     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0034
            boolean r6 = r3.f32055m     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0034
            if (r5 == 0) goto L_0x0034
            okhttp3.internal.connection.e r5 = r1.a()     // Catch:{ all -> 0x003d }
            int r6 = r5.f32011d     // Catch:{ all -> 0x003d }
            int r6 = r6 + r2
            r5.f32011d = r6     // Catch:{ all -> 0x003d }
            r5 = 0
            r3.f32053k = r5     // Catch:{ all -> 0x003d }
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x003c
            java.io.IOException r7 = r3.a((java.io.IOException) r7, (boolean) r4)
        L_0x003c:
            return r7
        L_0x003d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.i.a(okhttp3.internal.connection.c, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    /* access modifiers changed from: package-private */
    public c a(u.a aVar, boolean z2) {
        synchronized (this.f32046d) {
            if (this.f32058p) {
                throw new IllegalStateException("released");
            } else if (this.f32053k != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        c cVar = new c(this, this.f32047e, this.f32048f, this.f32052j, this.f32052j.a(this.f32045c, aVar, z2));
        synchronized (this.f32046d) {
            this.f32053k = cVar;
            this.f32054l = false;
            this.f32055m = false;
        }
        return cVar;
    }

    public s a() {
        return this.f32049g;
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        if (!f32043b && !Thread.holdsLock(this.f32046d)) {
            throw new AssertionError();
        } else if (this.f32044a == null) {
            this.f32044a = eVar;
            eVar.f32012e.add(new a(this, this.f32050h));
        } else {
            throw new IllegalStateException();
        }
    }

    public void a(z zVar) {
        z zVar2 = this.f32051i;
        if (zVar2 != null) {
            if (c.a(zVar2.a(), zVar.a()) && this.f32052j.d()) {
                return;
            }
            if (this.f32053k != null) {
                throw new IllegalStateException();
            } else if (this.f32052j != null) {
                a((IOException) null, true);
                this.f32052j = null;
            }
        }
        this.f32051i = zVar;
        this.f32052j = new d(this, this.f32046d, a(zVar.a()), this.f32047e, this.f32048f);
    }

    public void b() {
        this.f32049g.c();
    }

    public void c() {
        if (!this.f32057o) {
            this.f32057o = true;
            this.f32049g.A_();
            return;
        }
        throw new IllegalStateException();
    }

    public void d() {
        this.f32050h = f.e().a("response.body().close()");
        this.f32048f.a(this.f32047e);
    }

    /* access modifiers changed from: package-private */
    public Socket e() {
        if (f32043b || Thread.holdsLock(this.f32046d)) {
            int i2 = 0;
            int size = this.f32044a.f32012e.size();
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.f32044a.f32012e.get(i2).get() == this) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                e eVar = this.f32044a;
                eVar.f32012e.remove(i2);
                this.f32044a = null;
                if (!eVar.f32012e.isEmpty()) {
                    return null;
                }
                eVar.f32013f = System.nanoTime();
                if (this.f32046d.b(eVar)) {
                    return eVar.d();
                }
                return null;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public void f() {
        synchronized (this.f32046d) {
            if (!this.f32058p) {
                this.f32053k = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public boolean g() {
        return this.f32052j.c() && this.f32052j.d();
    }

    public boolean h() {
        boolean z2;
        synchronized (this.f32046d) {
            z2 = this.f32053k != null;
        }
        return z2;
    }

    public void i() {
        c cVar;
        e a2;
        synchronized (this.f32046d) {
            this.f32056n = true;
            cVar = this.f32053k;
            d dVar = this.f32052j;
            a2 = (dVar == null || dVar.a() == null) ? this.f32044a : this.f32052j.a();
        }
        if (cVar != null) {
            cVar.g();
        } else if (a2 != null) {
            a2.c();
        }
    }

    public boolean j() {
        boolean z2;
        synchronized (this.f32046d) {
            z2 = this.f32056n;
        }
        return z2;
    }
}
