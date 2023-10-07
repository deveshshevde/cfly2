package ne;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import nd.i;
import nd.k;
import okhttp3.ab;
import okhttp3.s;
import okhttp3.t;
import okhttp3.x;
import okhttp3.z;
import okio.h;
import okio.q;
import okio.r;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class a implements nd.c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final x f31395a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final okhttp3.internal.connection.e f31396b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final okio.e f31397c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final okio.d f31398d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f31399e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f31400f = 262144;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public s f31401g;

    /* renamed from: ne.a$a  reason: collision with other inner class name */
    private abstract class C0228a implements r {

        /* renamed from: a  reason: collision with root package name */
        protected final h f31402a;

        /* renamed from: b  reason: collision with root package name */
        protected boolean f31403b;

        private C0228a() {
            this.f31402a = new h(a.this.f31397c.timeout());
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            if (a.this.f31399e != 6) {
                if (a.this.f31399e == 5) {
                    a.this.a(this.f31402a);
                    int unused = a.this.f31399e = 6;
                    return;
                }
                throw new IllegalStateException("state: " + a.this.f31399e);
            }
        }

        public long read(okio.c cVar, long j2) throws IOException {
            try {
                return a.this.f31397c.read(cVar, j2);
            } catch (IOException e2) {
                a.this.f31396b.a();
                a();
                throw e2;
            }
        }

        public okio.s timeout() {
            return this.f31402a;
        }
    }

    private final class b implements q {

        /* renamed from: b  reason: collision with root package name */
        private final h f31406b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31407c;

        b() {
            this.f31406b = new h(a.this.f31398d.timeout());
        }

        public synchronized void close() throws IOException {
            if (!this.f31407c) {
                this.f31407c = true;
                a.this.f31398d.b("0\r\n\r\n");
                a.this.a(this.f31406b);
                int unused = a.this.f31399e = 3;
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.f31407c) {
                a.this.f31398d.flush();
            }
        }

        public okio.s timeout() {
            return this.f31406b;
        }

        public void write(okio.c cVar, long j2) throws IOException {
            if (this.f31407c) {
                throw new IllegalStateException("closed");
            } else if (j2 != 0) {
                a.this.f31398d.k(j2);
                a.this.f31398d.b("\r\n");
                a.this.f31398d.write(cVar, j2);
                a.this.f31398d.b("\r\n");
            }
        }
    }

    private class c extends C0228a {

        /* renamed from: e  reason: collision with root package name */
        private final t f31409e;

        /* renamed from: f  reason: collision with root package name */
        private long f31410f = -1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f31411g = true;

        c(t tVar) {
            super();
            this.f31409e = tVar;
        }

        private void b() throws IOException {
            if (this.f31410f != -1) {
                a.this.f31397c.q();
            }
            try {
                this.f31410f = a.this.f31397c.n();
                String trim = a.this.f31397c.q().trim();
                if (this.f31410f < 0 || (!trim.isEmpty() && !trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f31410f + trim + "\"");
                } else if (this.f31410f == 0) {
                    this.f31411g = false;
                    a aVar = a.this;
                    s unused = aVar.f31401g = aVar.f();
                    nd.e.a(a.this.f31395a.h(), this.f31409e, a.this.f31401g);
                    a();
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.f31403b) {
                if (this.f31411g && !nb.c.a((r) this, 100, TimeUnit.MILLISECONDS)) {
                    a.this.f31396b.a();
                    a();
                }
                this.f31403b = true;
            }
        }

        public long read(okio.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f31403b) {
                throw new IllegalStateException("closed");
            } else if (!this.f31411g) {
                return -1;
            } else {
                long j3 = this.f31410f;
                if (j3 == 0 || j3 == -1) {
                    b();
                    if (!this.f31411g) {
                        return -1;
                    }
                }
                long read = super.read(cVar, Math.min(j2, this.f31410f));
                if (read != -1) {
                    this.f31410f -= read;
                    return read;
                }
                a.this.f31396b.a();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            }
        }
    }

    private class d extends C0228a {

        /* renamed from: e  reason: collision with root package name */
        private long f31413e;

        d(long j2) {
            super();
            this.f31413e = j2;
            if (j2 == 0) {
                a();
            }
        }

        public void close() throws IOException {
            if (!this.f31403b) {
                if (this.f31413e != 0 && !nb.c.a((r) this, 100, TimeUnit.MILLISECONDS)) {
                    a.this.f31396b.a();
                    a();
                }
                this.f31403b = true;
            }
        }

        public long read(okio.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (!this.f31403b) {
                long j3 = this.f31413e;
                if (j3 == 0) {
                    return -1;
                }
                long read = super.read(cVar, Math.min(j3, j2));
                if (read != -1) {
                    long j4 = this.f31413e - read;
                    this.f31413e = j4;
                    if (j4 == 0) {
                        a();
                    }
                    return read;
                }
                a.this.f31396b.a();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                a();
                throw protocolException;
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    private final class e implements q {

        /* renamed from: b  reason: collision with root package name */
        private final h f31415b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f31416c;

        private e() {
            this.f31415b = new h(a.this.f31398d.timeout());
        }

        public void close() throws IOException {
            if (!this.f31416c) {
                this.f31416c = true;
                a.this.a(this.f31415b);
                int unused = a.this.f31399e = 3;
            }
        }

        public void flush() throws IOException {
            if (!this.f31416c) {
                a.this.f31398d.flush();
            }
        }

        public okio.s timeout() {
            return this.f31415b;
        }

        public void write(okio.c cVar, long j2) throws IOException {
            if (!this.f31416c) {
                nb.c.a(cVar.a(), 0, j2);
                a.this.f31398d.write(cVar, j2);
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    private class f extends C0228a {

        /* renamed from: e  reason: collision with root package name */
        private boolean f31418e;

        private f() {
            super();
        }

        public void close() throws IOException {
            if (!this.f31403b) {
                if (!this.f31418e) {
                    a();
                }
                this.f31403b = true;
            }
        }

        public long read(okio.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f31403b) {
                throw new IllegalStateException("closed");
            } else if (this.f31418e) {
                return -1;
            } else {
                long read = super.read(cVar, j2);
                if (read != -1) {
                    return read;
                }
                this.f31418e = true;
                a();
                return -1;
            }
        }
    }

    public a(x xVar, okhttp3.internal.connection.e eVar, okio.e eVar2, okio.d dVar) {
        this.f31395a = xVar;
        this.f31396b = eVar;
        this.f31397c = eVar2;
        this.f31398d = dVar;
    }

    private r a(long j2) {
        if (this.f31399e == 4) {
            this.f31399e = 5;
            return new d(j2);
        }
        throw new IllegalStateException("state: " + this.f31399e);
    }

    private r a(t tVar) {
        if (this.f31399e == 4) {
            this.f31399e = 5;
            return new c(tVar);
        }
        throw new IllegalStateException("state: " + this.f31399e);
    }

    /* access modifiers changed from: private */
    public void a(h hVar) {
        okio.s a2 = hVar.a();
        hVar.a(okio.s.f32474c);
        a2.f();
        a2.C_();
    }

    private String e() throws IOException {
        String e2 = this.f31397c.e(this.f31400f);
        this.f31400f -= (long) e2.length();
        return e2;
    }

    /* access modifiers changed from: private */
    public s f() throws IOException {
        s.a aVar = new s.a();
        while (true) {
            String e2 = e();
            if (e2.length() == 0) {
                return aVar.a();
            }
            nb.a.f31311a.a(aVar, e2);
        }
    }

    private q g() {
        if (this.f31399e == 1) {
            this.f31399e = 2;
            return new b();
        }
        throw new IllegalStateException("state: " + this.f31399e);
    }

    private q h() {
        if (this.f31399e == 1) {
            this.f31399e = 2;
            return new e();
        }
        throw new IllegalStateException("state: " + this.f31399e);
    }

    private r i() {
        if (this.f31399e == 4) {
            this.f31399e = 5;
            this.f31396b.a();
            return new f();
        }
        throw new IllegalStateException("state: " + this.f31399e);
    }

    public long a(ab abVar) {
        if (!nd.e.b(abVar)) {
            return 0;
        }
        if ("chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) {
            return -1;
        }
        return nd.e.a(abVar);
    }

    public ab.a a(boolean z2) throws IOException {
        int i2 = this.f31399e;
        if (i2 == 1 || i2 == 3) {
            try {
                k a2 = k.a(e());
                ab.a a3 = new ab.a().a(a2.f31392a).a(a2.f31393b).a(a2.f31394c).a(f());
                if (z2 && a2.f31393b == 100) {
                    return null;
                }
                if (a2.f31393b == 100) {
                    this.f31399e = 3;
                    return a3;
                }
                this.f31399e = 4;
                return a3;
            } catch (EOFException e2) {
                okhttp3.internal.connection.e eVar = this.f31396b;
                String n2 = eVar != null ? eVar.b().a().a().n() : IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
                throw new IOException("unexpected end of stream on " + n2, e2);
            }
        } else {
            throw new IllegalStateException("state: " + this.f31399e);
        }
    }

    public okhttp3.internal.connection.e a() {
        return this.f31396b;
    }

    public q a(z zVar, long j2) throws IOException {
        if (zVar.d() != null && zVar.d().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if ("chunked".equalsIgnoreCase(zVar.a("Transfer-Encoding"))) {
            return g();
        } else {
            if (j2 != -1) {
                return h();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public void a(s sVar, String str) throws IOException {
        if (this.f31399e == 0) {
            this.f31398d.b(str).b("\r\n");
            int a2 = sVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                this.f31398d.b(sVar.a(i2)).b(": ").b(sVar.b(i2)).b("\r\n");
            }
            this.f31398d.b("\r\n");
            this.f31399e = 1;
            return;
        }
        throw new IllegalStateException("state: " + this.f31399e);
    }

    public void a(z zVar) throws IOException {
        a(zVar.c(), i.a(zVar, this.f31396b.b().b().type()));
    }

    public r b(ab abVar) {
        if (!nd.e.b(abVar)) {
            return a(0);
        }
        if ("chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) {
            return a(abVar.a().a());
        }
        long a2 = nd.e.a(abVar);
        return a2 != -1 ? a(a2) : i();
    }

    public void b() throws IOException {
        this.f31398d.flush();
    }

    public void c() throws IOException {
        this.f31398d.flush();
    }

    public void c(ab abVar) throws IOException {
        long a2 = nd.e.a(abVar);
        if (a2 != -1) {
            r a3 = a(a2);
            nb.c.b(a3, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO, TimeUnit.MILLISECONDS);
            a3.close();
        }
    }

    public void d() {
        okhttp3.internal.connection.e eVar = this.f31396b;
        if (eVar != null) {
            eVar.c();
        }
    }
}
