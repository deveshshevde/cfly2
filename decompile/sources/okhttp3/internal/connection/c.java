package okhttp3.internal.connection;

import java.io.IOException;
import java.net.ProtocolException;
import nd.h;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.p;
import okhttp3.z;
import okio.f;
import okio.g;
import okio.k;
import okio.q;
import okio.r;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    final i f31980a;

    /* renamed from: b  reason: collision with root package name */
    final e f31981b;

    /* renamed from: c  reason: collision with root package name */
    final p f31982c;

    /* renamed from: d  reason: collision with root package name */
    final d f31983d;

    /* renamed from: e  reason: collision with root package name */
    final nd.c f31984e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31985f;

    private final class a extends f {

        /* renamed from: b  reason: collision with root package name */
        private boolean f31987b;

        /* renamed from: c  reason: collision with root package name */
        private long f31988c;

        /* renamed from: d  reason: collision with root package name */
        private long f31989d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f31990e;

        a(q qVar, long j2) {
            super(qVar);
            this.f31988c = j2;
        }

        private IOException a(IOException iOException) {
            if (this.f31987b) {
                return iOException;
            }
            this.f31987b = true;
            return c.this.a(this.f31989d, false, true, iOException);
        }

        public void close() throws IOException {
            if (!this.f31990e) {
                this.f31990e = true;
                long j2 = this.f31988c;
                if (j2 == -1 || this.f31989d == j2) {
                    try {
                        super.close();
                        a((IOException) null);
                    } catch (IOException e2) {
                        throw a(e2);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                throw a(e2);
            }
        }

        public void write(okio.c cVar, long j2) throws IOException {
            if (!this.f31990e) {
                long j3 = this.f31988c;
                if (j3 == -1 || this.f31989d + j2 <= j3) {
                    try {
                        super.write(cVar, j2);
                        this.f31989d += j2;
                    } catch (IOException e2) {
                        throw a(e2);
                    }
                } else {
                    throw new ProtocolException("expected " + this.f31988c + " bytes but received " + (this.f31989d + j2));
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    final class b extends g {

        /* renamed from: b  reason: collision with root package name */
        private final long f31992b;

        /* renamed from: c  reason: collision with root package name */
        private long f31993c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31994d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f31995e;

        b(r rVar, long j2) {
            super(rVar);
            this.f31992b = j2;
            if (j2 == 0) {
                a((IOException) null);
            }
        }

        /* access modifiers changed from: package-private */
        public IOException a(IOException iOException) {
            if (this.f31994d) {
                return iOException;
            }
            this.f31994d = true;
            return c.this.a(this.f31993c, true, false, iOException);
        }

        public void close() throws IOException {
            if (!this.f31995e) {
                this.f31995e = true;
                try {
                    super.close();
                    a((IOException) null);
                } catch (IOException e2) {
                    throw a(e2);
                }
            }
        }

        public long read(okio.c cVar, long j2) throws IOException {
            if (!this.f31995e) {
                try {
                    long read = delegate().read(cVar, j2);
                    if (read == -1) {
                        a((IOException) null);
                        return -1;
                    }
                    long j3 = this.f31993c + read;
                    long j4 = this.f31992b;
                    if (j4 != -1) {
                        if (j3 > j4) {
                            throw new ProtocolException("expected " + this.f31992b + " bytes but received " + j3);
                        }
                    }
                    this.f31993c = j3;
                    if (j3 == j4) {
                        a((IOException) null);
                    }
                    return read;
                } catch (IOException e2) {
                    throw a(e2);
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }
    }

    public c(i iVar, e eVar, p pVar, d dVar, nd.c cVar) {
        this.f31980a = iVar;
        this.f31981b = eVar;
        this.f31982c = pVar;
        this.f31983d = dVar;
        this.f31984e = cVar;
    }

    /* access modifiers changed from: package-private */
    public IOException a(long j2, boolean z2, boolean z3, IOException iOException) {
        if (iOException != null) {
            a(iOException);
        }
        if (z3) {
            p pVar = this.f31982c;
            e eVar = this.f31981b;
            if (iOException != null) {
                pVar.a(eVar, iOException);
            } else {
                pVar.a(eVar, j2);
            }
        }
        if (z2) {
            if (iOException != null) {
                this.f31982c.b(this.f31981b, iOException);
            } else {
                this.f31982c.b(this.f31981b, j2);
            }
        }
        return this.f31980a.a(this, z3, z2, iOException);
    }

    public ab.a a(boolean z2) throws IOException {
        try {
            ab.a a2 = this.f31984e.a(z2);
            if (a2 != null) {
                nb.a.f31311a.a(a2, this);
            }
            return a2;
        } catch (IOException e2) {
            this.f31982c.b(this.f31981b, e2);
            a(e2);
            throw e2;
        }
    }

    public e a() {
        return this.f31984e.a();
    }

    public q a(z zVar, boolean z2) throws IOException {
        this.f31985f = z2;
        long contentLength = zVar.d().contentLength();
        this.f31982c.d(this.f31981b);
        return new a(this.f31984e.a(zVar, contentLength), contentLength);
    }

    /* access modifiers changed from: package-private */
    public void a(IOException iOException) {
        this.f31983d.b();
        this.f31984e.a().a(iOException);
    }

    public void a(ab abVar) {
        this.f31982c.a(this.f31981b, abVar);
    }

    public void a(z zVar) throws IOException {
        try {
            this.f31982c.c(this.f31981b);
            this.f31984e.a(zVar);
            this.f31982c.a(this.f31981b, zVar);
        } catch (IOException e2) {
            this.f31982c.a(this.f31981b, e2);
            a(e2);
            throw e2;
        }
    }

    public ac b(ab abVar) throws IOException {
        try {
            this.f31982c.f(this.f31981b);
            String a2 = abVar.a("Content-Type");
            long a3 = this.f31984e.a(abVar);
            return new h(a2, a3, k.a((r) new b(this.f31984e.b(abVar), a3)));
        } catch (IOException e2) {
            this.f31982c.b(this.f31981b, e2);
            a(e2);
            throw e2;
        }
    }

    public boolean b() {
        return this.f31985f;
    }

    public void c() throws IOException {
        try {
            this.f31984e.b();
        } catch (IOException e2) {
            this.f31982c.a(this.f31981b, e2);
            a(e2);
            throw e2;
        }
    }

    public void d() throws IOException {
        try {
            this.f31984e.c();
        } catch (IOException e2) {
            this.f31982c.a(this.f31981b, e2);
            a(e2);
            throw e2;
        }
    }

    public void e() {
        this.f31982c.e(this.f31981b);
    }

    public void f() {
        this.f31984e.a().a();
    }

    public void g() {
        this.f31984e.d();
    }

    public void h() {
        this.f31984e.d();
        this.f31980a.a(this, true, true, (IOException) null);
    }

    public void i() {
        this.f31980a.a(this, true, false, (IOException) null);
    }
}
