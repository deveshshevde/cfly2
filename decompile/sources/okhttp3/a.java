package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import nb.c;
import okhttp3.t;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final t f31813a;

    /* renamed from: b  reason: collision with root package name */
    final o f31814b;

    /* renamed from: c  reason: collision with root package name */
    final SocketFactory f31815c;

    /* renamed from: d  reason: collision with root package name */
    final b f31816d;

    /* renamed from: e  reason: collision with root package name */
    final List<Protocol> f31817e;

    /* renamed from: f  reason: collision with root package name */
    final List<k> f31818f;

    /* renamed from: g  reason: collision with root package name */
    final ProxySelector f31819g;

    /* renamed from: h  reason: collision with root package name */
    final Proxy f31820h;

    /* renamed from: i  reason: collision with root package name */
    final SSLSocketFactory f31821i;

    /* renamed from: j  reason: collision with root package name */
    final HostnameVerifier f31822j;

    /* renamed from: k  reason: collision with root package name */
    final g f31823k;

    public a(String str, int i2, o oVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b bVar, Proxy proxy, List<Protocol> list, List<k> list2, ProxySelector proxySelector) {
        this.f31813a = new t.a().a(sSLSocketFactory != null ? "https" : "http").d(str).a(i2).c();
        Objects.requireNonNull(oVar, "dns == null");
        this.f31814b = oVar;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f31815c = socketFactory;
        Objects.requireNonNull(bVar, "proxyAuthenticator == null");
        this.f31816d = bVar;
        Objects.requireNonNull(list, "protocols == null");
        this.f31817e = c.a(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f31818f = c.a(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f31819g = proxySelector;
        this.f31820h = proxy;
        this.f31821i = sSLSocketFactory;
        this.f31822j = hostnameVerifier;
        this.f31823k = gVar;
    }

    public t a() {
        return this.f31813a;
    }

    /* access modifiers changed from: package-private */
    public boolean a(a aVar) {
        return this.f31814b.equals(aVar.f31814b) && this.f31816d.equals(aVar.f31816d) && this.f31817e.equals(aVar.f31817e) && this.f31818f.equals(aVar.f31818f) && this.f31819g.equals(aVar.f31819g) && Objects.equals(this.f31820h, aVar.f31820h) && Objects.equals(this.f31821i, aVar.f31821i) && Objects.equals(this.f31822j, aVar.f31822j) && Objects.equals(this.f31823k, aVar.f31823k) && a().g() == aVar.a().g();
    }

    public o b() {
        return this.f31814b;
    }

    public SocketFactory c() {
        return this.f31815c;
    }

    public b d() {
        return this.f31816d;
    }

    public List<Protocol> e() {
        return this.f31817e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f31813a.equals(aVar.f31813a) && a(aVar);
        }
    }

    public List<k> f() {
        return this.f31818f;
    }

    public ProxySelector g() {
        return this.f31819g;
    }

    public Proxy h() {
        return this.f31820h;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f31813a.hashCode()) * 31) + this.f31814b.hashCode()) * 31) + this.f31816d.hashCode()) * 31) + this.f31817e.hashCode()) * 31) + this.f31818f.hashCode()) * 31) + this.f31819g.hashCode()) * 31) + Objects.hashCode(this.f31820h)) * 31) + Objects.hashCode(this.f31821i)) * 31) + Objects.hashCode(this.f31822j)) * 31) + Objects.hashCode(this.f31823k);
    }

    public SSLSocketFactory i() {
        return this.f31821i;
    }

    public HostnameVerifier j() {
        return this.f31822j;
    }

    public g k() {
        return this.f31823k;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f31813a.f());
        sb.append(":");
        sb.append(this.f31813a.g());
        if (this.f31820h != null) {
            sb.append(", proxy=");
            obj = this.f31820h;
        } else {
            sb.append(", proxySelector=");
            obj = this.f31819g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
