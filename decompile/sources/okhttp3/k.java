package okhttp3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import nb.c;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f32251a;

    /* renamed from: b  reason: collision with root package name */
    public static final k f32252b;

    /* renamed from: c  reason: collision with root package name */
    public static final k f32253c;

    /* renamed from: d  reason: collision with root package name */
    public static final k f32254d = new a(false).a();

    /* renamed from: i  reason: collision with root package name */
    private static final h[] f32255i;

    /* renamed from: j  reason: collision with root package name */
    private static final h[] f32256j;

    /* renamed from: e  reason: collision with root package name */
    final boolean f32257e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f32258f;

    /* renamed from: g  reason: collision with root package name */
    final String[] f32259g;

    /* renamed from: h  reason: collision with root package name */
    final String[] f32260h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f32261a;

        /* renamed from: b  reason: collision with root package name */
        String[] f32262b;

        /* renamed from: c  reason: collision with root package name */
        String[] f32263c;

        /* renamed from: d  reason: collision with root package name */
        boolean f32264d;

        public a(k kVar) {
            this.f32261a = kVar.f32257e;
            this.f32262b = kVar.f32259g;
            this.f32263c = kVar.f32260h;
            this.f32264d = kVar.f32258f;
        }

        a(boolean z2) {
            this.f32261a = z2;
        }

        public a a(boolean z2) {
            if (this.f32261a) {
                this.f32264d = z2;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a a(String... strArr) {
            if (!this.f32261a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f32262b = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public a a(TlsVersion... tlsVersionArr) {
            if (this.f32261a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i2 = 0; i2 < tlsVersionArr.length; i2++) {
                    strArr[i2] = tlsVersionArr[i2].f31812f;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(h... hVarArr) {
            if (this.f32261a) {
                String[] strArr = new String[hVarArr.length];
                for (int i2 = 0; i2 < hVarArr.length; i2++) {
                    strArr[i2] = hVarArr[i2].f31972bq;
                }
                return a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public k a() {
            return new k(this);
        }

        public a b(String... strArr) {
            if (!this.f32261a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f32263c = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }
    }

    static {
        h[] hVarArr = {h.f31942bl, h.f31943bm, h.f31944bn, h.aX, h.f31932bb, h.aY, h.f31933bc, h.f31939bi, h.f31938bh};
        f32255i = hVarArr;
        h[] hVarArr2 = {h.f31942bl, h.f31943bm, h.f31944bn, h.aX, h.f31932bb, h.aY, h.f31933bc, h.f31939bi, h.f31938bh, h.aI, h.aJ, h.f31910ag, h.f31911ah, h.E, h.I, h.f31954i};
        f32256j = hVarArr2;
        f32251a = new a(true).a(hVarArr).a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).a(true).a();
        f32252b = new a(true).a(hVarArr2).a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).a(true).a();
        f32253c = new a(true).a(hVarArr2).a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).a(true).a();
    }

    k(a aVar) {
        this.f32257e = aVar.f32261a;
        this.f32259g = aVar.f32262b;
        this.f32260h = aVar.f32263c;
        this.f32258f = aVar.f32264d;
    }

    private k b(SSLSocket sSLSocket, boolean z2) {
        String[] a2 = this.f32259g != null ? c.a((Comparator<? super String>) h.f31903a, sSLSocket.getEnabledCipherSuites(), this.f32259g) : sSLSocket.getEnabledCipherSuites();
        String[] a3 = this.f32260h != null ? c.a((Comparator<? super String>) c.f31319g, sSLSocket.getEnabledProtocols(), this.f32260h) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a4 = c.a(h.f31903a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z2 && a4 != -1) {
            a2 = c.a(a2, supportedCipherSuites[a4]);
        }
        return new a(this).a(a2).b(a3).a();
    }

    /* access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z2) {
        k b2 = b(sSLSocket, z2);
        String[] strArr = b2.f32260h;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b2.f32259g;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a() {
        return this.f32257e;
    }

    public boolean a(SSLSocket sSLSocket) {
        if (!this.f32257e) {
            return false;
        }
        if (this.f32260h == null || c.b(c.f31319g, this.f32260h, sSLSocket.getEnabledProtocols())) {
            return this.f32259g == null || c.b(h.f31903a, this.f32259g, sSLSocket.getEnabledCipherSuites());
        }
        return false;
    }

    public List<h> b() {
        String[] strArr = this.f32259g;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public List<TlsVersion> c() {
        String[] strArr = this.f32260h;
        if (strArr != null) {
            return TlsVersion.a(strArr);
        }
        return null;
    }

    public boolean d() {
        return this.f32258f;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        boolean z2 = this.f32257e;
        if (z2 != kVar.f32257e) {
            return false;
        }
        return !z2 || (Arrays.equals(this.f32259g, kVar.f32259g) && Arrays.equals(this.f32260h, kVar.f32260h) && this.f32258f == kVar.f32258f);
    }

    public int hashCode() {
        if (this.f32257e) {
            return ((((527 + Arrays.hashCode(this.f32259g)) * 31) + Arrays.hashCode(this.f32260h)) * 31) + (this.f32258f ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f32257e) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(b(), "[all enabled]") + ", tlsVersions=" + Objects.toString(c(), "[all enabled]") + ", supportsTlsExtensions=" + this.f32258f + ")";
    }
}
