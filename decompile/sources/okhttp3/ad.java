package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    final a f31866a;

    /* renamed from: b  reason: collision with root package name */
    final Proxy f31867b;

    /* renamed from: c  reason: collision with root package name */
    final InetSocketAddress f31868c;

    public ad(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(aVar, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f31866a = aVar;
        this.f31867b = proxy;
        this.f31868c = inetSocketAddress;
    }

    public a a() {
        return this.f31866a;
    }

    public Proxy b() {
        return this.f31867b;
    }

    public InetSocketAddress c() {
        return this.f31868c;
    }

    public boolean d() {
        return this.f31866a.f31821i != null && this.f31867b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ad) {
            ad adVar = (ad) obj;
            return adVar.f31866a.equals(this.f31866a) && adVar.f31867b.equals(this.f31867b) && adVar.f31868c.equals(this.f31868c);
        }
    }

    public int hashCode() {
        return ((((527 + this.f31866a.hashCode()) * 31) + this.f31867b.hashCode()) * 31) + this.f31868c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f31868c + "}";
    }
}
