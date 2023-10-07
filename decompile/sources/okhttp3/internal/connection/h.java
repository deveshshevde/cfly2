package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import nb.c;
import okhttp3.ad;
import okhttp3.e;
import okhttp3.p;
import okhttp3.t;

final class h {

    /* renamed from: a  reason: collision with root package name */
    private final okhttp3.a f32033a;

    /* renamed from: b  reason: collision with root package name */
    private final g f32034b;

    /* renamed from: c  reason: collision with root package name */
    private final e f32035c;

    /* renamed from: d  reason: collision with root package name */
    private final p f32036d;

    /* renamed from: e  reason: collision with root package name */
    private List<Proxy> f32037e = Collections.emptyList();

    /* renamed from: f  reason: collision with root package name */
    private int f32038f;

    /* renamed from: g  reason: collision with root package name */
    private List<InetSocketAddress> f32039g = Collections.emptyList();

    /* renamed from: h  reason: collision with root package name */
    private final List<ad> f32040h = new ArrayList();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<ad> f32041a;

        /* renamed from: b  reason: collision with root package name */
        private int f32042b = 0;

        a(List<ad> list) {
            this.f32041a = list;
        }

        public boolean a() {
            return this.f32042b < this.f32041a.size();
        }

        public ad b() {
            if (a()) {
                List<ad> list = this.f32041a;
                int i2 = this.f32042b;
                this.f32042b = i2 + 1;
                return list.get(i2);
            }
            throw new NoSuchElementException();
        }

        public List<ad> c() {
            return new ArrayList(this.f32041a);
        }
    }

    h(okhttp3.a aVar, g gVar, e eVar, p pVar) {
        this.f32033a = aVar;
        this.f32034b = gVar;
        this.f32035c = eVar;
        this.f32036d = pVar;
        a(aVar.a(), aVar.h());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private void a(Proxy proxy) throws IOException {
        String str;
        int i2;
        this.f32039g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f32033a.a().f();
            i2 = this.f32033a.a().g();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = a(inetSocketAddress);
                i2 = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i2 < 1 || i2 > 65535) {
            throw new SocketException("No route to " + str + ":" + i2 + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f32039g.add(InetSocketAddress.createUnresolved(str, i2));
        } else {
            this.f32036d.a(this.f32035c, str);
            List<InetAddress> lookup = this.f32033a.b().lookup(str);
            if (!lookup.isEmpty()) {
                this.f32036d.a(this.f32035c, str, lookup);
                int size = lookup.size();
                for (int i3 = 0; i3 < size; i3++) {
                    this.f32039g.add(new InetSocketAddress(lookup.get(i3), i2));
                }
                return;
            }
            throw new UnknownHostException(this.f32033a.b() + " returned no addresses for " + str);
        }
    }

    private void a(t tVar, Proxy proxy) {
        List<Proxy> a2;
        if (proxy != null) {
            a2 = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f32033a.g().select(tVar.a());
            if (select == null || select.isEmpty()) {
                a2 = c.a((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                a2 = c.a(select);
            }
        }
        this.f32037e = a2;
        this.f32038f = 0;
    }

    private boolean c() {
        return this.f32038f < this.f32037e.size();
    }

    private Proxy d() throws IOException {
        if (c()) {
            List<Proxy> list = this.f32037e;
            int i2 = this.f32038f;
            this.f32038f = i2 + 1;
            Proxy proxy = list.get(i2);
            a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f32033a.a().f() + "; exhausted proxy configurations: " + this.f32037e);
    }

    public boolean a() {
        return c() || !this.f32040h.isEmpty();
    }

    public a b() throws IOException {
        if (a()) {
            ArrayList arrayList = new ArrayList();
            while (c()) {
                Proxy d2 = d();
                int size = this.f32039g.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ad adVar = new ad(this.f32033a, d2, this.f32039g.get(i2));
                    if (this.f32034b.c(adVar)) {
                        this.f32040h.add(adVar);
                    } else {
                        arrayList.add(adVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f32040h);
                this.f32040h.clear();
            }
            return new a(arrayList);
        }
        throw new NoSuchElementException();
    }
}
