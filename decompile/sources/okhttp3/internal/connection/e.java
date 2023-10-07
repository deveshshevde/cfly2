package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import nb.c;
import ne.a;
import ng.f;
import okhttp3.Protocol;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.http2.d;
import okhttp3.internal.http2.g;
import okhttp3.p;
import okhttp3.r;
import okhttp3.t;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;
import okio.k;

public final class e extends d.c implements i {

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ boolean f32007g = true;

    /* renamed from: a  reason: collision with root package name */
    public final f f32008a;

    /* renamed from: b  reason: collision with root package name */
    boolean f32009b;

    /* renamed from: c  reason: collision with root package name */
    int f32010c;

    /* renamed from: d  reason: collision with root package name */
    int f32011d;

    /* renamed from: e  reason: collision with root package name */
    final List<Reference<i>> f32012e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    long f32013f = Long.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    private final ad f32014i;

    /* renamed from: j  reason: collision with root package name */
    private Socket f32015j;

    /* renamed from: k  reason: collision with root package name */
    private Socket f32016k;

    /* renamed from: l  reason: collision with root package name */
    private r f32017l;

    /* renamed from: m  reason: collision with root package name */
    private Protocol f32018m;

    /* renamed from: n  reason: collision with root package name */
    private d f32019n;

    /* renamed from: o  reason: collision with root package name */
    private okio.e f32020o;

    /* renamed from: p  reason: collision with root package name */
    private okio.d f32021p;

    /* renamed from: q  reason: collision with root package name */
    private int f32022q;

    /* renamed from: r  reason: collision with root package name */
    private int f32023r = 1;

    public e(f fVar, ad adVar) {
        this.f32008a = fVar;
        this.f32014i = adVar;
    }

    private z a(int i2, int i3, z zVar, t tVar) throws IOException {
        String str = "CONNECT " + c.a(tVar, true) + " HTTP/1.1";
        while (true) {
            a aVar = new a((x) null, (e) null, this.f32020o, this.f32021p);
            this.f32020o.timeout().a((long) i2, TimeUnit.MILLISECONDS);
            this.f32021p.timeout().a((long) i3, TimeUnit.MILLISECONDS);
            aVar.a(zVar.c(), str);
            aVar.c();
            ab a2 = aVar.a(false).a(zVar).a();
            aVar.c(a2);
            int b2 = a2.b();
            if (b2 != 200) {
                if (b2 == 407) {
                    z authenticate = this.f32014i.a().d().authenticate(this.f32014i, a2);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(a2.a("Connection"))) {
                        return authenticate;
                    } else {
                        zVar = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + a2.b());
                }
            } else if (this.f32020o.c().f() && this.f32021p.b().f()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private void a(int i2) throws IOException {
        this.f32016k.setSoTimeout(0);
        d a2 = new d.a(true).a(this.f32016k, this.f32014i.a().a().f(), this.f32020o, this.f32021p).a((d.c) this).a(i2).a();
        this.f32019n = a2;
        a2.c();
    }

    private void a(int i2, int i3, int i4, okhttp3.e eVar, p pVar) throws IOException {
        z g2 = g();
        t a2 = g2.a();
        int i5 = 0;
        while (i5 < 21) {
            a(i2, i3, eVar, pVar);
            g2 = a(i3, i4, g2, a2);
            if (g2 != null) {
                c.a(this.f32015j);
                this.f32015j = null;
                this.f32021p = null;
                this.f32020o = null;
                pVar.a(eVar, this.f32014i.c(), this.f32014i.b(), (Protocol) null);
                i5++;
            } else {
                return;
            }
        }
    }

    private void a(int i2, int i3, okhttp3.e eVar, p pVar) throws IOException {
        Proxy b2 = this.f32014i.b();
        this.f32015j = (b2.type() == Proxy.Type.DIRECT || b2.type() == Proxy.Type.HTTP) ? this.f32014i.a().c().createSocket() : new Socket(b2);
        pVar.a(eVar, this.f32014i.c(), b2);
        this.f32015j.setSoTimeout(i3);
        try {
            f.e().a(this.f32015j, this.f32014i.c(), i2);
            try {
                this.f32020o = k.a(k.b(this.f32015j));
                this.f32021p = k.a(k.a(this.f32015j));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f32014i.c());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0137 A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x013d A[Catch:{ all -> 0x012e }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0140  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(okhttp3.internal.connection.b r8) throws java.io.IOException {
        /*
            r7 = this;
            okhttp3.ad r0 = r7.f32014i
            okhttp3.a r0 = r0.a()
            javax.net.ssl.SSLSocketFactory r1 = r0.i()
            r2 = 0
            java.net.Socket r3 = r7.f32015j     // Catch:{ AssertionError -> 0x0130 }
            okhttp3.t r4 = r0.a()     // Catch:{ AssertionError -> 0x0130 }
            java.lang.String r4 = r4.f()     // Catch:{ AssertionError -> 0x0130 }
            okhttp3.t r5 = r0.a()     // Catch:{ AssertionError -> 0x0130 }
            int r5 = r5.g()     // Catch:{ AssertionError -> 0x0130 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0130 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0130 }
            okhttp3.k r8 = r8.a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r3 = r8.d()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r3 == 0) goto L_0x0041
            ng.f r3 = ng.f.e()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okhttp3.t r4 = r0.a()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r4 = r4.f()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.util.List r5 = r0.e()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r3.a((javax.net.ssl.SSLSocket) r1, (java.lang.String) r4, (java.util.List<okhttp3.Protocol>) r5)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okhttp3.r r4 = okhttp3.r.a((javax.net.ssl.SSLSession) r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            javax.net.ssl.HostnameVerifier r5 = r0.j()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okhttp3.t r6 = r0.a()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r6 = r6.f()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r3 != 0) goto L_0x00d8
            java.util.List r8 = r4.b()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r2 = r8.isEmpty()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r3 = "Hostname "
            if (r2 != 0) goto L_0x00b6
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.<init>()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okhttp3.t r0 = r0.a()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.f()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = okhttp3.g.a((java.security.cert.Certificate) r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = "\n    DN: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.util.List r8 = ni.d.a(r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r4.append(r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r8 = r4.toString()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            throw r2     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x00b6:
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.<init>()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.append(r3)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okhttp3.t r0 = r0.a()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.f()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r2.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r2.toString()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            throw r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x00d8:
            okhttp3.g r3 = r0.k()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okhttp3.t r0 = r0.a()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r0 = r0.f()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.util.List r5 = r4.b()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r3.a(r0, r5)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            boolean r8 = r8.d()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r8 == 0) goto L_0x00f9
            ng.f r8 = ng.f.e()     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.lang.String r2 = r8.a((javax.net.ssl.SSLSocket) r1)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x00f9:
            r7.f32016k = r1     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.r r8 = okio.k.b(r1)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.e r8 = okio.k.a((okio.r) r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r7.f32020o = r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            java.net.Socket r8 = r7.f32016k     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.q r8 = okio.k.a((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            okio.d r8 = okio.k.a((okio.q) r8)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r7.f32021p = r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            r7.f32017l = r4     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r2 == 0) goto L_0x011a
            okhttp3.Protocol r8 = okhttp3.Protocol.a(r2)     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            goto L_0x011c
        L_0x011a:
            okhttp3.Protocol r8 = okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
        L_0x011c:
            r7.f32018m = r8     // Catch:{ AssertionError -> 0x012b, all -> 0x0128 }
            if (r1 == 0) goto L_0x0127
            ng.f r8 = ng.f.e()
            r8.b((javax.net.ssl.SSLSocket) r1)
        L_0x0127:
            return
        L_0x0128:
            r8 = move-exception
            r2 = r1
            goto L_0x013e
        L_0x012b:
            r8 = move-exception
            r2 = r1
            goto L_0x0131
        L_0x012e:
            r8 = move-exception
            goto L_0x013e
        L_0x0130:
            r8 = move-exception
        L_0x0131:
            boolean r0 = nb.c.a((java.lang.AssertionError) r8)     // Catch:{ all -> 0x012e }
            if (r0 == 0) goto L_0x013d
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012e }
            r0.<init>(r8)     // Catch:{ all -> 0x012e }
            throw r0     // Catch:{ all -> 0x012e }
        L_0x013d:
            throw r8     // Catch:{ all -> 0x012e }
        L_0x013e:
            if (r2 == 0) goto L_0x0147
            ng.f r0 = ng.f.e()
            r0.b((javax.net.ssl.SSLSocket) r2)
        L_0x0147:
            nb.c.a((java.net.Socket) r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.a(okhttp3.internal.connection.b):void");
    }

    private void a(b bVar, int i2, okhttp3.e eVar, p pVar) throws IOException {
        if (this.f32014i.a().i() != null) {
            pVar.b(eVar);
            a(bVar);
            pVar.a(eVar, this.f32017l);
            if (this.f32018m == Protocol.HTTP_2) {
                a(i2);
            }
        } else if (this.f32014i.a().e().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.f32016k = this.f32015j;
            this.f32018m = Protocol.H2_PRIOR_KNOWLEDGE;
            a(i2);
        } else {
            this.f32016k = this.f32015j;
            this.f32018m = Protocol.HTTP_1_1;
        }
    }

    private boolean a(List<ad> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ad adVar = list.get(i2);
            if (adVar.b().type() == Proxy.Type.DIRECT && this.f32014i.b().type() == Proxy.Type.DIRECT && this.f32014i.c().equals(adVar.c())) {
                return true;
            }
        }
        return false;
    }

    private z g() throws IOException {
        z b2 = new z.a().a(this.f32014i.a().a()).a("CONNECT", (aa) null).a("Host", c.a(this.f32014i.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", nb.d.a()).b();
        z authenticate = this.f32014i.a().d().authenticate(this.f32014i, new ab.a().a(b2).a(Protocol.HTTP_1_1).a(407).a("Preemptive Authenticate").a(c.f31316d).a(-1).b(-1).a("Proxy-Authenticate", "OkHttp-Preemptive").a());
        return authenticate != null ? authenticate : b2;
    }

    /* access modifiers changed from: package-private */
    public nd.c a(x xVar, u.a aVar) throws SocketException {
        if (this.f32019n != null) {
            return new okhttp3.internal.http2.e(xVar, this, aVar, this.f32019n);
        }
        this.f32016k.setSoTimeout(aVar.c());
        this.f32020o.timeout().a((long) aVar.c(), TimeUnit.MILLISECONDS);
        this.f32021p.timeout().a((long) aVar.d(), TimeUnit.MILLISECONDS);
        return new a(xVar, this, this.f32020o, this.f32021p);
    }

    public void a() {
        if (f32007g || !Thread.holdsLock(this.f32008a)) {
            synchronized (this.f32008a) {
                this.f32009b = true;
            }
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r17, int r18, int r19, int r20, boolean r21, okhttp3.e r22, okhttp3.p r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            okhttp3.Protocol r0 = r7.f32018m
            if (r0 != 0) goto L_0x0150
            okhttp3.ad r0 = r7.f32014i
            okhttp3.a r0 = r0.a()
            java.util.List r0 = r0.f()
            okhttp3.internal.connection.b r10 = new okhttp3.internal.connection.b
            r10.<init>(r0)
            okhttp3.ad r1 = r7.f32014i
            okhttp3.a r1 = r1.a()
            javax.net.ssl.SSLSocketFactory r1 = r1.i()
            if (r1 != 0) goto L_0x0074
            okhttp3.k r1 = okhttp3.k.f32254d
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            okhttp3.ad r0 = r7.f32014i
            okhttp3.a r0 = r0.a()
            okhttp3.t r0 = r0.a()
            java.lang.String r0 = r0.f()
            ng.f r1 = ng.f.e()
            boolean r1 = r1.b((java.lang.String) r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0086
        L_0x0046:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            okhttp3.ad r0 = r7.f32014i
            okhttp3.a r0 = r0.a()
            java.util.List r0 = r0.e()
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0143
        L_0x0086:
            r11 = 0
            r12 = r11
        L_0x0088:
            okhttp3.ad r0 = r7.f32014i     // Catch:{ IOException -> 0x00f9 }
            boolean r0 = r0.d()     // Catch:{ IOException -> 0x00f9 }
            if (r0 == 0) goto L_0x00a9
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f9 }
            java.net.Socket r0 = r7.f32015j     // Catch:{ IOException -> 0x00f9 }
            if (r0 != 0) goto L_0x00a4
            goto L_0x00c6
        L_0x00a4:
            r13 = r17
            r14 = r18
            goto L_0x00b0
        L_0x00a9:
            r13 = r17
            r14 = r18
            r7.a((int) r13, (int) r14, (okhttp3.e) r8, (okhttp3.p) r9)     // Catch:{ IOException -> 0x00f7 }
        L_0x00b0:
            r15 = r20
            r7.a((okhttp3.internal.connection.b) r10, (int) r15, (okhttp3.e) r8, (okhttp3.p) r9)     // Catch:{ IOException -> 0x00f5 }
            okhttp3.ad r0 = r7.f32014i     // Catch:{ IOException -> 0x00f5 }
            java.net.InetSocketAddress r0 = r0.c()     // Catch:{ IOException -> 0x00f5 }
            okhttp3.ad r1 = r7.f32014i     // Catch:{ IOException -> 0x00f5 }
            java.net.Proxy r1 = r1.b()     // Catch:{ IOException -> 0x00f5 }
            okhttp3.Protocol r2 = r7.f32018m     // Catch:{ IOException -> 0x00f5 }
            r9.a(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f5 }
        L_0x00c6:
            okhttp3.ad r0 = r7.f32014i
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x00e0
            java.net.Socket r0 = r7.f32015j
            if (r0 == 0) goto L_0x00d3
            goto L_0x00e0
        L_0x00d3:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00e0:
            okhttp3.internal.http2.d r0 = r7.f32019n
            if (r0 == 0) goto L_0x00f4
            okhttp3.internal.connection.f r1 = r7.f32008a
            monitor-enter(r1)
            okhttp3.internal.http2.d r0 = r7.f32019n     // Catch:{ all -> 0x00f1 }
            int r0 = r0.a()     // Catch:{ all -> 0x00f1 }
            r7.f32023r = r0     // Catch:{ all -> 0x00f1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            throw r0
        L_0x00f4:
            return
        L_0x00f5:
            r0 = move-exception
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00fe:
            r15 = r20
        L_0x0100:
            java.net.Socket r1 = r7.f32016k
            nb.c.a((java.net.Socket) r1)
            java.net.Socket r1 = r7.f32015j
            nb.c.a((java.net.Socket) r1)
            r7.f32016k = r11
            r7.f32015j = r11
            r7.f32020o = r11
            r7.f32021p = r11
            r7.f32017l = r11
            r7.f32018m = r11
            r7.f32019n = r11
            okhttp3.ad r1 = r7.f32014i
            java.net.InetSocketAddress r3 = r1.c()
            okhttp3.ad r1 = r7.f32014i
            java.net.Proxy r4 = r1.b()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.a(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0135
            okhttp3.internal.connection.RouteException r12 = new okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x0138
        L_0x0135:
            r12.a(r0)
        L_0x0138:
            if (r21 == 0) goto L_0x0142
            boolean r0 = r10.a((java.io.IOException) r0)
            if (r0 == 0) goto L_0x0142
            goto L_0x0088
        L_0x0142:
            throw r12
        L_0x0143:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            goto L_0x0159
        L_0x0158:
            throw r0
        L_0x0159:
            goto L_0x0158
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.a(int, int, int, int, boolean, okhttp3.e, okhttp3.p):void");
    }

    /* access modifiers changed from: package-private */
    public void a(IOException iOException) {
        int i2;
        if (f32007g || !Thread.holdsLock(this.f32008a)) {
            synchronized (this.f32008a) {
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).f32074a;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i3 = this.f32022q + 1;
                        this.f32022q = i3;
                        if (i3 > 1) {
                            this.f32009b = true;
                            i2 = this.f32010c;
                        }
                    } else if (errorCode != ErrorCode.CANCEL) {
                        this.f32009b = true;
                        i2 = this.f32010c;
                    }
                } else if (!f() || (iOException instanceof ConnectionShutdownException)) {
                    this.f32009b = true;
                    if (this.f32011d == 0) {
                        if (iOException != null) {
                            this.f32008a.a(this.f32014i, iOException);
                        }
                        i2 = this.f32010c;
                    }
                }
                this.f32010c = i2 + 1;
            }
            return;
        }
        throw new AssertionError();
    }

    public void a(d dVar) {
        synchronized (this.f32008a) {
            this.f32023r = dVar.a();
        }
    }

    public void a(g gVar) throws IOException {
        gVar.a(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    /* access modifiers changed from: package-private */
    public boolean a(okhttp3.a aVar, List<ad> list) {
        if (this.f32012e.size() >= this.f32023r || this.f32009b || !nb.a.f31311a.a(this.f32014i.a(), aVar)) {
            return false;
        }
        if (aVar.a().f().equals(b().a().a().f())) {
            return true;
        }
        if (this.f32019n == null || list == null || !a(list) || aVar.j() != ni.d.f31580a || !a(aVar.a())) {
            return false;
        }
        try {
            aVar.k().a(aVar.a().f(), e().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(t tVar) {
        if (tVar.g() != this.f32014i.a().a().g()) {
            return false;
        }
        if (!tVar.f().equals(this.f32014i.a().a().f())) {
            return this.f32017l != null && ni.d.f31580a.a(tVar.f(), (X509Certificate) this.f32017l.b().get(0));
        }
        return true;
    }

    public boolean a(boolean z2) {
        int soTimeout;
        if (this.f32016k.isClosed() || this.f32016k.isInputShutdown() || this.f32016k.isOutputShutdown()) {
            return false;
        }
        d dVar = this.f32019n;
        if (dVar != null) {
            return dVar.b(System.nanoTime());
        }
        if (z2) {
            try {
                soTimeout = this.f32016k.getSoTimeout();
                this.f32016k.setSoTimeout(1);
                if (this.f32020o.f()) {
                    this.f32016k.setSoTimeout(soTimeout);
                    return false;
                }
                this.f32016k.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f32016k.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public ad b() {
        return this.f32014i;
    }

    public void c() {
        c.a(this.f32015j);
    }

    public Socket d() {
        return this.f32016k;
    }

    public r e() {
        return this.f32017l;
    }

    public boolean f() {
        return this.f32019n != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f32014i.a().a().f());
        sb.append(":");
        sb.append(this.f32014i.a().a().g());
        sb.append(", proxy=");
        sb.append(this.f32014i.b());
        sb.append(" hostAddress=");
        sb.append(this.f32014i.c());
        sb.append(" cipherSuite=");
        r rVar = this.f32017l;
        sb.append(rVar != null ? rVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f32018m);
        sb.append('}');
        return sb.toString();
    }
}
