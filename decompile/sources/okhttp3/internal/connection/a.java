package okhttp3.internal.connection;

import java.io.IOException;
import nd.g;
import okhttp3.ab;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;

public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    public final x f31975a;

    public a(x xVar) {
        this.f31975a = xVar;
    }

    public ab intercept(u.a aVar) throws IOException {
        g gVar = (g) aVar;
        z a2 = gVar.a();
        i e2 = gVar.e();
        return gVar.a(a2, e2, e2.a(aVar, !a2.b().equals("GET")));
    }
}
