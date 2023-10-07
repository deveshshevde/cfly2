package nc;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import nb.c;
import nc.c;
import nd.f;
import nd.h;
import okhttp3.Protocol;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.s;
import okhttp3.u;
import okhttp3.z;
import okio.d;
import okio.e;
import okio.k;
import okio.q;
import okio.r;
import okio.s;

public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    final e f31325a;

    public a(e eVar) {
        this.f31325a = eVar;
    }

    private ab a(final b bVar, ab abVar) throws IOException {
        q a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return abVar;
        }
        final e source = abVar.g().source();
        final d a3 = k.a(a2);
        AnonymousClass1 r2 = new r() {

            /* renamed from: a  reason: collision with root package name */
            boolean f31326a;

            public void close() throws IOException {
                if (!this.f31326a && !c.a((r) this, 100, TimeUnit.MILLISECONDS)) {
                    this.f31326a = true;
                    bVar.b();
                }
                source.close();
            }

            public long read(okio.c cVar, long j2) throws IOException {
                try {
                    long read = source.read(cVar, j2);
                    if (read == -1) {
                        if (!this.f31326a) {
                            this.f31326a = true;
                            a3.close();
                        }
                        return -1;
                    }
                    cVar.a(a3.b(), cVar.a() - read, read);
                    a3.v();
                    return read;
                } catch (IOException e2) {
                    if (!this.f31326a) {
                        this.f31326a = true;
                        bVar.b();
                    }
                    throw e2;
                }
            }

            public s timeout() {
                return source.timeout();
            }
        };
        return abVar.h().a((ac) new h(abVar.a("Content-Type"), abVar.g().contentLength(), k.a((r) r2))).a();
    }

    private static ab a(ab abVar) {
        return (abVar == null || abVar.g() == null) ? abVar : abVar.h().a((ac) null).a();
    }

    private static okhttp3.s a(okhttp3.s sVar, okhttp3.s sVar2) {
        s.a aVar = new s.a();
        int a2 = sVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            String a3 = sVar.a(i2);
            String b2 = sVar.b(i2);
            if ((!"Warning".equalsIgnoreCase(a3) || !b2.startsWith("1")) && (b(a3) || !a(a3) || sVar2.a(a3) == null)) {
                nb.a.f31311a.a(aVar, a3, b2);
            }
        }
        int a4 = sVar2.a();
        for (int i3 = 0; i3 < a4; i3++) {
            String a5 = sVar2.a(i3);
            if (!b(a5) && a(a5)) {
                nb.a.f31311a.a(aVar, a5, sVar2.b(i3));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return !"Connection".equalsIgnoreCase(str) && !"Keep-Alive".equalsIgnoreCase(str) && !"Proxy-Authenticate".equalsIgnoreCase(str) && !"Proxy-Authorization".equalsIgnoreCase(str) && !"TE".equalsIgnoreCase(str) && !"Trailers".equalsIgnoreCase(str) && !"Transfer-Encoding".equalsIgnoreCase(str) && !"Upgrade".equalsIgnoreCase(str);
    }

    static boolean b(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    public ab intercept(u.a aVar) throws IOException {
        e eVar = this.f31325a;
        ab a2 = eVar != null ? eVar.a(aVar.a()) : null;
        c a3 = new c.a(System.currentTimeMillis(), aVar.a(), a2).a();
        z zVar = a3.f31331a;
        ab abVar = a3.f31332b;
        e eVar2 = this.f31325a;
        if (eVar2 != null) {
            eVar2.a(a3);
        }
        if (a2 != null && abVar == null) {
            nb.c.a((Closeable) a2.g());
        }
        if (zVar == null && abVar == null) {
            return new ab.a().a(aVar.a()).a(Protocol.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(nb.c.f31316d).a(-1).b(System.currentTimeMillis()).a();
        }
        if (zVar == null) {
            return abVar.h().b(a(abVar)).a();
        }
        try {
            ab a4 = aVar.a(zVar);
            if (a4 == null && a2 != null) {
            }
            if (abVar != null) {
                if (a4.b() == 304) {
                    ab a5 = abVar.h().a(a(abVar.f(), a4.f())).a(a4.k()).b(a4.l()).b(a(abVar)).a(a(a4)).a();
                    a4.g().close();
                    this.f31325a.a();
                    this.f31325a.a(abVar, a5);
                    return a5;
                }
                nb.c.a((Closeable) abVar.g());
            }
            ab a6 = a4.h().b(a(abVar)).a(a(a4)).a();
            if (this.f31325a != null) {
                if (nd.e.b(a6) && c.a(a6, zVar)) {
                    return a(this.f31325a.a(a6), a6);
                }
                if (f.a(zVar.b())) {
                    try {
                        this.f31325a.b(zVar);
                    } catch (IOException unused) {
                    }
                }
            }
            return a6;
        } finally {
            if (a2 != null) {
                nb.c.a((Closeable) a2.g());
            }
        }
    }
}
