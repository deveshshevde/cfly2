package nd;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.internal.connection.c;
import okhttp3.u;
import okhttp3.z;
import okio.d;
import okio.k;

public final class b implements u {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31372a;

    public b(boolean z2) {
        this.f31372a = z2;
    }

    public ab intercept(u.a aVar) throws IOException {
        boolean z2;
        ab.a aVar2;
        ac acVar;
        g gVar = (g) aVar;
        c f2 = gVar.f();
        z a2 = gVar.a();
        long currentTimeMillis = System.currentTimeMillis();
        f2.a(a2);
        ab.a aVar3 = null;
        if (!f.c(a2.b()) || a2.d() == null) {
            f2.i();
            z2 = false;
        } else {
            if ("100-continue".equalsIgnoreCase(a2.a("Expect"))) {
                f2.c();
                f2.e();
                aVar3 = f2.a(true);
                z2 = true;
            } else {
                z2 = false;
            }
            if (aVar3 != null) {
                f2.i();
                if (!f2.a().f()) {
                    f2.f();
                }
            } else if (a2.d().isDuplex()) {
                f2.c();
                a2.d().writeTo(k.a(f2.a(a2, true)));
            } else {
                d a3 = k.a(f2.a(a2, false));
                a2.d().writeTo(a3);
                a3.close();
            }
        }
        if (a2.d() == null || !a2.d().isDuplex()) {
            f2.d();
        }
        if (!z2) {
            f2.e();
        }
        if (aVar3 == null) {
            aVar3 = f2.a(false);
        }
        ab a4 = aVar3.a(a2).a(f2.a().e()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
        int b2 = a4.b();
        if (b2 == 100) {
            a4 = f2.a(false).a(a2).a(f2.a().e()).a(currentTimeMillis).b(System.currentTimeMillis()).a();
            b2 = a4.b();
        }
        f2.a(a4);
        if (!this.f31372a || b2 != 101) {
            aVar2 = a4.h();
            acVar = f2.b(a4);
        } else {
            aVar2 = a4.h();
            acVar = nb.c.f31316d;
        }
        ab a5 = aVar2.a(acVar).a();
        if ("close".equalsIgnoreCase(a5.a().a("Connection")) || "close".equalsIgnoreCase(a5.a("Connection"))) {
            f2.f();
        }
        if ((b2 != 204 && b2 != 205) || a5.g().contentLength() <= 0) {
            return a5;
        }
        throw new ProtocolException("HTTP " + b2 + " had non-zero Content-Length: " + a5.g().contentLength());
    }
}
