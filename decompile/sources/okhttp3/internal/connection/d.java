package okhttp3.internal.connection;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import nb.c;
import okhttp3.a;
import okhttp3.ad;
import okhttp3.e;
import okhttp3.i;
import okhttp3.internal.connection.h;
import okhttp3.p;
import okhttp3.u;
import okhttp3.x;

final class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f31996a = true;

    /* renamed from: b  reason: collision with root package name */
    private final i f31997b;

    /* renamed from: c  reason: collision with root package name */
    private final a f31998c;

    /* renamed from: d  reason: collision with root package name */
    private final f f31999d;

    /* renamed from: e  reason: collision with root package name */
    private final e f32000e;

    /* renamed from: f  reason: collision with root package name */
    private final p f32001f;

    /* renamed from: g  reason: collision with root package name */
    private h.a f32002g;

    /* renamed from: h  reason: collision with root package name */
    private final h f32003h;

    /* renamed from: i  reason: collision with root package name */
    private e f32004i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f32005j;

    /* renamed from: k  reason: collision with root package name */
    private ad f32006k;

    d(i iVar, f fVar, a aVar, e eVar, p pVar) {
        this.f31997b = iVar;
        this.f31999d = fVar;
        this.f31998c = aVar;
        this.f32000e = eVar;
        this.f32001f = pVar;
        this.f32003h = new h(aVar, fVar.f32026a, eVar, pVar);
    }

    private e a(int i2, int i3, int i4, int i5, boolean z2) throws IOException {
        Socket socket;
        Socket e2;
        e eVar;
        e eVar2;
        boolean z3;
        ad adVar;
        boolean z4;
        List<ad> list;
        h.a aVar;
        synchronized (this.f31999d) {
            if (!this.f31997b.j()) {
                this.f32005j = false;
                e eVar3 = this.f31997b.f32044a;
                socket = null;
                e2 = (this.f31997b.f32044a == null || !this.f31997b.f32044a.f32009b) ? null : this.f31997b.e();
                if (this.f31997b.f32044a != null) {
                    eVar2 = this.f31997b.f32044a;
                    eVar = null;
                } else {
                    eVar = eVar3;
                    eVar2 = null;
                }
                if (eVar2 == null) {
                    if (this.f31999d.a(this.f31998c, this.f31997b, (List<ad>) null, false)) {
                        eVar2 = this.f31997b.f32044a;
                        adVar = null;
                        z3 = true;
                    } else {
                        adVar = this.f32006k;
                        if (adVar != null) {
                            this.f32006k = null;
                        } else if (e()) {
                            adVar = this.f31997b.f32044a.b();
                        }
                        z3 = false;
                    }
                }
                adVar = null;
                z3 = false;
            } else {
                throw new IOException("Canceled");
            }
        }
        c.a(e2);
        if (eVar != null) {
            this.f32001f.b(this.f32000e, (i) eVar);
        }
        if (z3) {
            this.f32001f.a(this.f32000e, (i) eVar2);
        }
        if (eVar2 != null) {
            return eVar2;
        }
        if (adVar != null || ((aVar = this.f32002g) != null && aVar.a())) {
            z4 = false;
        } else {
            this.f32002g = this.f32003h.b();
            z4 = true;
        }
        synchronized (this.f31999d) {
            if (!this.f31997b.j()) {
                if (z4) {
                    list = this.f32002g.c();
                    if (this.f31999d.a(this.f31998c, this.f31997b, list, false)) {
                        eVar2 = this.f31997b.f32044a;
                        z3 = true;
                    }
                } else {
                    list = null;
                }
                if (!z3) {
                    if (adVar == null) {
                        adVar = this.f32002g.b();
                    }
                    eVar2 = new e(this.f31999d, adVar);
                    this.f32004i = eVar2;
                }
            } else {
                throw new IOException("Canceled");
            }
        }
        if (!z3) {
            eVar2.a(i2, i3, i4, i5, z2, this.f32000e, this.f32001f);
            this.f31999d.f32026a.b(eVar2.b());
            synchronized (this.f31999d) {
                this.f32004i = null;
                if (this.f31999d.a(this.f31998c, this.f31997b, list, true)) {
                    eVar2.f32009b = true;
                    socket = eVar2.d();
                    eVar2 = this.f31997b.f32044a;
                    this.f32006k = adVar;
                } else {
                    this.f31999d.a(eVar2);
                    this.f31997b.a(eVar2);
                }
            }
            c.a(socket);
        }
        this.f32001f.a(this.f32000e, (i) eVar2);
        return eVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r0.a(r9) != false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.e a(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws java.io.IOException {
        /*
            r3 = this;
        L_0x0000:
            okhttp3.internal.connection.e r0 = r3.a(r4, r5, r6, r7, r8)
            okhttp3.internal.connection.f r1 = r3.f31999d
            monitor-enter(r1)
            int r2 = r0.f32011d     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            boolean r2 = r0.f()     // Catch:{ all -> 0x001f }
            if (r2 != 0) goto L_0x0013
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            return r0
        L_0x0013:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            boolean r1 = r0.a((boolean) r9)
            if (r1 != 0) goto L_0x001e
            r0.a()
            goto L_0x0000
        L_0x001e:
            return r0
        L_0x001f:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x0022:
            throw r4
        L_0x0023:
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.d.a(int, int, int, int, boolean, boolean):okhttp3.internal.connection.e");
    }

    private boolean e() {
        return this.f31997b.f32044a != null && this.f31997b.f32044a.f32010c == 0 && c.a(this.f31997b.f32044a.b().a().a(), this.f31998c.a());
    }

    public nd.c a(x xVar, u.a aVar, boolean z2) {
        try {
            return a(aVar.b(), aVar.c(), aVar.d(), xVar.e(), xVar.t(), z2).a(xVar, aVar);
        } catch (RouteException e2) {
            b();
            throw e2;
        } catch (IOException e3) {
            b();
            throw new RouteException(e3);
        }
    }

    /* access modifiers changed from: package-private */
    public e a() {
        if (f31996a || Thread.holdsLock(this.f31999d)) {
            return this.f32004i;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (f31996a || !Thread.holdsLock(this.f31999d)) {
            synchronized (this.f31999d) {
                this.f32005j = true;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        boolean z2;
        synchronized (this.f31999d) {
            z2 = this.f32005j;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r3 = this;
            okhttp3.internal.connection.f r0 = r3.f31999d
            monitor-enter(r0)
            okhttp3.ad r1 = r3.f32006k     // Catch:{ all -> 0x0032 }
            r2 = 1
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x000a:
            boolean r1 = r3.e()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x001c
            okhttp3.internal.connection.i r1 = r3.f31997b     // Catch:{ all -> 0x0032 }
            okhttp3.internal.connection.e r1 = r1.f32044a     // Catch:{ all -> 0x0032 }
            okhttp3.ad r1 = r1.b()     // Catch:{ all -> 0x0032 }
            r3.f32006k = r1     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x001c:
            okhttp3.internal.connection.h$a r1 = r3.f32002g     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0026
            boolean r1 = r1.a()     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0030
        L_0x0026:
            okhttp3.internal.connection.h r1 = r3.f32003h     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r2 = 0
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x0032:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.d.d():boolean");
    }
}
