package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import nb.c;
import ng.f;
import ni.d;
import okhttp3.ab;
import okhttp3.e;
import okhttp3.p;
import okhttp3.s;

public class x implements Cloneable, e.a {

    /* renamed from: a  reason: collision with root package name */
    static final List<Protocol> f32343a = c.a((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});

    /* renamed from: b  reason: collision with root package name */
    static final List<k> f32344b = c.a((T[]) new k[]{k.f32252b, k.f32254d});
    final int A;
    final int B;
    final int C;
    final int D;

    /* renamed from: c  reason: collision with root package name */
    final n f32345c;

    /* renamed from: d  reason: collision with root package name */
    final Proxy f32346d;

    /* renamed from: e  reason: collision with root package name */
    final List<Protocol> f32347e;

    /* renamed from: f  reason: collision with root package name */
    final List<k> f32348f;

    /* renamed from: g  reason: collision with root package name */
    final List<u> f32349g;

    /* renamed from: h  reason: collision with root package name */
    final List<u> f32350h;

    /* renamed from: i  reason: collision with root package name */
    final p.a f32351i;

    /* renamed from: j  reason: collision with root package name */
    final ProxySelector f32352j;

    /* renamed from: k  reason: collision with root package name */
    final m f32353k;

    /* renamed from: l  reason: collision with root package name */
    final c f32354l;

    /* renamed from: m  reason: collision with root package name */
    final nc.e f32355m;

    /* renamed from: n  reason: collision with root package name */
    final SocketFactory f32356n;

    /* renamed from: o  reason: collision with root package name */
    final SSLSocketFactory f32357o;

    /* renamed from: p  reason: collision with root package name */
    final ni.c f32358p;

    /* renamed from: q  reason: collision with root package name */
    final HostnameVerifier f32359q;

    /* renamed from: r  reason: collision with root package name */
    final g f32360r;

    /* renamed from: s  reason: collision with root package name */
    final b f32361s;

    /* renamed from: t  reason: collision with root package name */
    final b f32362t;

    /* renamed from: u  reason: collision with root package name */
    final j f32363u;

    /* renamed from: v  reason: collision with root package name */
    final o f32364v;

    /* renamed from: w  reason: collision with root package name */
    final boolean f32365w;

    /* renamed from: x  reason: collision with root package name */
    final boolean f32366x;

    /* renamed from: y  reason: collision with root package name */
    final boolean f32367y;

    /* renamed from: z  reason: collision with root package name */
    final int f32368z;

    public static final class a {
        int A;
        int B;

        /* renamed from: a  reason: collision with root package name */
        n f32369a;

        /* renamed from: b  reason: collision with root package name */
        Proxy f32370b;

        /* renamed from: c  reason: collision with root package name */
        List<Protocol> f32371c;

        /* renamed from: d  reason: collision with root package name */
        List<k> f32372d;

        /* renamed from: e  reason: collision with root package name */
        final List<u> f32373e;

        /* renamed from: f  reason: collision with root package name */
        final List<u> f32374f;

        /* renamed from: g  reason: collision with root package name */
        p.a f32375g;

        /* renamed from: h  reason: collision with root package name */
        ProxySelector f32376h;

        /* renamed from: i  reason: collision with root package name */
        m f32377i;

        /* renamed from: j  reason: collision with root package name */
        c f32378j;

        /* renamed from: k  reason: collision with root package name */
        nc.e f32379k;

        /* renamed from: l  reason: collision with root package name */
        SocketFactory f32380l;

        /* renamed from: m  reason: collision with root package name */
        SSLSocketFactory f32381m;

        /* renamed from: n  reason: collision with root package name */
        ni.c f32382n;

        /* renamed from: o  reason: collision with root package name */
        HostnameVerifier f32383o;

        /* renamed from: p  reason: collision with root package name */
        g f32384p;

        /* renamed from: q  reason: collision with root package name */
        b f32385q;

        /* renamed from: r  reason: collision with root package name */
        b f32386r;

        /* renamed from: s  reason: collision with root package name */
        j f32387s;

        /* renamed from: t  reason: collision with root package name */
        o f32388t;

        /* renamed from: u  reason: collision with root package name */
        boolean f32389u;

        /* renamed from: v  reason: collision with root package name */
        boolean f32390v;

        /* renamed from: w  reason: collision with root package name */
        boolean f32391w;

        /* renamed from: x  reason: collision with root package name */
        int f32392x;

        /* renamed from: y  reason: collision with root package name */
        int f32393y;

        /* renamed from: z  reason: collision with root package name */
        int f32394z;

        public a() {
            this.f32373e = new ArrayList();
            this.f32374f = new ArrayList();
            this.f32369a = new n();
            this.f32371c = x.f32343a;
            this.f32372d = x.f32344b;
            this.f32375g = p.a(p.f32288a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f32376h = proxySelector;
            if (proxySelector == null) {
                this.f32376h = new nh.a();
            }
            this.f32377i = m.f32278a;
            this.f32380l = SocketFactory.getDefault();
            this.f32383o = d.f31580a;
            this.f32384p = g.f31895a;
            this.f32385q = b.f31869a;
            this.f32386r = b.f31869a;
            this.f32387s = new j();
            this.f32388t = o.f32287a;
            this.f32389u = true;
            this.f32390v = true;
            this.f32391w = true;
            this.f32392x = 0;
            this.f32393y = 10000;
            this.f32394z = 10000;
            this.A = 10000;
            this.B = 0;
        }

        a(x xVar) {
            ArrayList arrayList = new ArrayList();
            this.f32373e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f32374f = arrayList2;
            this.f32369a = xVar.f32345c;
            this.f32370b = xVar.f32346d;
            this.f32371c = xVar.f32347e;
            this.f32372d = xVar.f32348f;
            arrayList.addAll(xVar.f32349g);
            arrayList2.addAll(xVar.f32350h);
            this.f32375g = xVar.f32351i;
            this.f32376h = xVar.f32352j;
            this.f32377i = xVar.f32353k;
            this.f32379k = xVar.f32355m;
            this.f32378j = xVar.f32354l;
            this.f32380l = xVar.f32356n;
            this.f32381m = xVar.f32357o;
            this.f32382n = xVar.f32358p;
            this.f32383o = xVar.f32359q;
            this.f32384p = xVar.f32360r;
            this.f32385q = xVar.f32361s;
            this.f32386r = xVar.f32362t;
            this.f32387s = xVar.f32363u;
            this.f32388t = xVar.f32364v;
            this.f32389u = xVar.f32365w;
            this.f32390v = xVar.f32366x;
            this.f32391w = xVar.f32367y;
            this.f32392x = xVar.f32368z;
            this.f32393y = xVar.A;
            this.f32394z = xVar.B;
            this.A = xVar.C;
            this.B = xVar.D;
        }

        public a a(long j2, TimeUnit timeUnit) {
            this.f32393y = c.a("timeout", j2, timeUnit);
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            Objects.requireNonNull(hostnameVerifier, "hostnameVerifier == null");
            this.f32383o = hostnameVerifier;
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            this.f32381m = sSLSocketFactory;
            this.f32382n = f.e().c(sSLSocketFactory);
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            Objects.requireNonNull(sSLSocketFactory, "sslSocketFactory == null");
            Objects.requireNonNull(x509TrustManager, "trustManager == null");
            this.f32381m = sSLSocketFactory;
            this.f32382n = ni.c.a(x509TrustManager);
            return this;
        }

        public a a(u uVar) {
            if (uVar != null) {
                this.f32373e.add(uVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public a a(boolean z2) {
            this.f32391w = z2;
            return this;
        }

        public x a() {
            return new x(this);
        }

        public a b(long j2, TimeUnit timeUnit) {
            this.f32394z = c.a("timeout", j2, timeUnit);
            return this;
        }

        public a c(long j2, TimeUnit timeUnit) {
            this.A = c.a("timeout", j2, timeUnit);
            return this;
        }
    }

    static {
        nb.a.f31311a = new nb.a() {
            public int a(ab.a aVar) {
                return aVar.f31848c;
            }

            public okhttp3.internal.connection.c a(ab abVar) {
                return abVar.f31844m;
            }

            public okhttp3.internal.connection.f a(j jVar) {
                return jVar.f32250a;
            }

            public void a(ab.a aVar, okhttp3.internal.connection.c cVar) {
                aVar.a(cVar);
            }

            public void a(k kVar, SSLSocket sSLSocket, boolean z2) {
                kVar.a(sSLSocket, z2);
            }

            public void a(s.a aVar, String str) {
                aVar.a(str);
            }

            public void a(s.a aVar, String str, String str2) {
                aVar.c(str, str2);
            }

            public boolean a(a aVar, a aVar2) {
                return aVar.a(aVar2);
            }
        };
    }

    public x() {
        this(new a());
    }

    x(a aVar) {
        boolean z2;
        ni.c cVar;
        this.f32345c = aVar.f32369a;
        this.f32346d = aVar.f32370b;
        this.f32347e = aVar.f32371c;
        List<k> list = aVar.f32372d;
        this.f32348f = list;
        this.f32349g = c.a(aVar.f32373e);
        this.f32350h = c.a(aVar.f32374f);
        this.f32351i = aVar.f32375g;
        this.f32352j = aVar.f32376h;
        this.f32353k = aVar.f32377i;
        this.f32354l = aVar.f32378j;
        this.f32355m = aVar.f32379k;
        this.f32356n = aVar.f32380l;
        Iterator<k> it2 = list.iterator();
        loop0:
        while (true) {
            z2 = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop0;
                }
                k next = it2.next();
                if (z2 || next.a()) {
                    z2 = true;
                }
            }
        }
        if (aVar.f32381m != null || !z2) {
            this.f32357o = aVar.f32381m;
            cVar = aVar.f32382n;
        } else {
            X509TrustManager a2 = c.a();
            this.f32357o = a(a2);
            cVar = ni.c.a(a2);
        }
        this.f32358p = cVar;
        if (this.f32357o != null) {
            f.e().b(this.f32357o);
        }
        this.f32359q = aVar.f32383o;
        this.f32360r = aVar.f32384p.a(this.f32358p);
        this.f32361s = aVar.f32385q;
        this.f32362t = aVar.f32386r;
        this.f32363u = aVar.f32387s;
        this.f32364v = aVar.f32388t;
        this.f32365w = aVar.f32389u;
        this.f32366x = aVar.f32390v;
        this.f32367y = aVar.f32391w;
        this.f32368z = aVar.f32392x;
        this.A = aVar.f32393y;
        this.B = aVar.f32394z;
        this.C = aVar.A;
        this.D = aVar.B;
        if (this.f32349g.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f32349g);
        } else if (this.f32350h.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f32350h);
        }
    }

    private static SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext c2 = f.e().c();
            c2.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return c2.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS", e2);
        }
    }

    public a A() {
        return new a(this);
    }

    public int a() {
        return this.f32368z;
    }

    public e a(z zVar) {
        return y.a(this, zVar, false);
    }

    public int b() {
        return this.A;
    }

    public int c() {
        return this.B;
    }

    public int d() {
        return this.C;
    }

    public int e() {
        return this.D;
    }

    public Proxy f() {
        return this.f32346d;
    }

    public ProxySelector g() {
        return this.f32352j;
    }

    public m h() {
        return this.f32353k;
    }

    /* access modifiers changed from: package-private */
    public nc.e i() {
        c cVar = this.f32354l;
        return cVar != null ? cVar.f31870a : this.f32355m;
    }

    public o j() {
        return this.f32364v;
    }

    public SocketFactory k() {
        return this.f32356n;
    }

    public SSLSocketFactory l() {
        return this.f32357o;
    }

    public HostnameVerifier m() {
        return this.f32359q;
    }

    public g n() {
        return this.f32360r;
    }

    public b o() {
        return this.f32362t;
    }

    public b p() {
        return this.f32361s;
    }

    public j q() {
        return this.f32363u;
    }

    public boolean r() {
        return this.f32365w;
    }

    public boolean s() {
        return this.f32366x;
    }

    public boolean t() {
        return this.f32367y;
    }

    public n u() {
        return this.f32345c;
    }

    public List<Protocol> v() {
        return this.f32347e;
    }

    public List<k> w() {
        return this.f32348f;
    }

    public List<u> x() {
        return this.f32349g;
    }

    public List<u> y() {
        return this.f32350h;
    }

    public p.a z() {
        return this.f32351i;
    }
}
