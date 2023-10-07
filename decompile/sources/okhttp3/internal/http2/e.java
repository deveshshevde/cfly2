package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import nb.a;
import nd.c;
import nd.i;
import nd.k;
import okhttp3.Protocol;
import okhttp3.ab;
import okhttp3.s;
import okhttp3.u;
import okhttp3.x;
import okhttp3.z;
import okio.q;
import okio.r;

public final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f32178a = nb.c.a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority"});

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f32179b = nb.c.a((T[]) new String[]{"connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade"});

    /* renamed from: c  reason: collision with root package name */
    private final u.a f32180c;

    /* renamed from: d  reason: collision with root package name */
    private final okhttp3.internal.connection.e f32181d;

    /* renamed from: e  reason: collision with root package name */
    private final d f32182e;

    /* renamed from: f  reason: collision with root package name */
    private volatile g f32183f;

    /* renamed from: g  reason: collision with root package name */
    private final Protocol f32184g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f32185h;

    public e(x xVar, okhttp3.internal.connection.e eVar, u.a aVar, d dVar) {
        this.f32181d = eVar;
        this.f32180c = aVar;
        this.f32182e = dVar;
        this.f32184g = xVar.v().contains(Protocol.H2_PRIOR_KNOWLEDGE) ? Protocol.H2_PRIOR_KNOWLEDGE : Protocol.HTTP_2;
    }

    public static ab.a a(s sVar, Protocol protocol) throws IOException {
        s.a aVar = new s.a();
        int a2 = sVar.a();
        k kVar = null;
        for (int i2 = 0; i2 < a2; i2++) {
            String a3 = sVar.a(i2);
            String b2 = sVar.b(i2);
            if (a3.equals(":status")) {
                kVar = k.a("HTTP/1.1 " + b2);
            } else if (!f32179b.contains(a3)) {
                a.f31311a.a(aVar, a3, b2);
            }
        }
        if (kVar != null) {
            return new ab.a().a(protocol).a(kVar.f31393b).a(kVar.f31394c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public static List<a> b(z zVar) {
        s c2 = zVar.c();
        ArrayList arrayList = new ArrayList(c2.a() + 4);
        arrayList.add(new a(a.f32077c, zVar.b()));
        arrayList.add(new a(a.f32078d, i.a(zVar.a())));
        String a2 = zVar.a("Host");
        if (a2 != null) {
            arrayList.add(new a(a.f32080f, a2));
        }
        arrayList.add(new a(a.f32079e, zVar.a().b()));
        int a3 = c2.a();
        for (int i2 = 0; i2 < a3; i2++) {
            String lowerCase = c2.a(i2).toLowerCase(Locale.US);
            if (!f32178a.contains(lowerCase) || (lowerCase.equals("te") && c2.b(i2).equals("trailers"))) {
                arrayList.add(new a(lowerCase, c2.b(i2)));
            }
        }
        return arrayList;
    }

    public long a(ab abVar) {
        return nd.e.a(abVar);
    }

    public ab.a a(boolean z2) throws IOException {
        ab.a a2 = a(this.f32183f.d(), this.f32184g);
        if (!z2 || a.f31311a.a(a2) != 100) {
            return a2;
        }
        return null;
    }

    public okhttp3.internal.connection.e a() {
        return this.f32181d;
    }

    public q a(z zVar, long j2) {
        return this.f32183f.h();
    }

    public void a(z zVar) throws IOException {
        if (this.f32183f == null) {
            this.f32183f = this.f32182e.a(b(zVar), zVar.d() != null);
            if (!this.f32185h) {
                this.f32183f.e().a((long) this.f32180c.c(), TimeUnit.MILLISECONDS);
                this.f32183f.f().a((long) this.f32180c.d(), TimeUnit.MILLISECONDS);
                return;
            }
            this.f32183f.a(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
    }

    public r b(ab abVar) {
        return this.f32183f.g();
    }

    public void b() throws IOException {
        this.f32182e.b();
    }

    public void c() throws IOException {
        this.f32183f.h().close();
    }

    public void d() {
        this.f32185h = true;
        if (this.f32183f != null) {
            this.f32183f.a(ErrorCode.CANCEL);
        }
    }
}
