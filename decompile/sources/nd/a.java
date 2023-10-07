package nd;

import java.io.IOException;
import java.util.List;
import nb.c;
import nb.d;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.l;
import okhttp3.m;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
import okio.i;
import okio.k;
import okio.r;

public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    private final m f31371a;

    public a(m mVar) {
        this.f31371a = mVar;
    }

    private String a(List<l> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            l lVar = list.get(i2);
            sb.append(lVar.a());
            sb.append('=');
            sb.append(lVar.b());
        }
        return sb.toString();
    }

    public ab intercept(u.a aVar) throws IOException {
        z a2 = aVar.a();
        z.a e2 = a2.e();
        aa d2 = a2.d();
        if (d2 != null) {
            v contentType = d2.contentType();
            if (contentType != null) {
                e2.a("Content-Type", contentType.toString());
            }
            long contentLength = d2.contentLength();
            if (contentLength != -1) {
                e2.a("Content-Length", Long.toString(contentLength));
                e2.b("Transfer-Encoding");
            } else {
                e2.a("Transfer-Encoding", "chunked");
                e2.b("Content-Length");
            }
        }
        boolean z2 = false;
        if (a2.a("Host") == null) {
            e2.a("Host", c.a(a2.a(), false));
        }
        if (a2.a("Connection") == null) {
            e2.a("Connection", "Keep-Alive");
        }
        if (a2.a("Accept-Encoding") == null && a2.a("Range") == null) {
            z2 = true;
            e2.a("Accept-Encoding", "gzip");
        }
        List<l> a3 = this.f31371a.a(a2.a());
        if (!a3.isEmpty()) {
            e2.a("Cookie", a(a3));
        }
        if (a2.a("User-Agent") == null) {
            e2.a("User-Agent", d.a());
        }
        ab a4 = aVar.a(e2.b());
        e.a(this.f31371a, a2.a(), a4.f());
        ab.a a5 = a4.h().a(a2);
        if (z2 && "gzip".equalsIgnoreCase(a4.a("Content-Encoding")) && e.b(a4)) {
            i iVar = new i(a4.g().source());
            a5.a(a4.f().b().b("Content-Encoding").b("Content-Length").a());
            a5.a((ac) new h(a4.a("Content-Type"), -1, k.a((r) iVar)));
        }
        return a5.a();
    }
}
