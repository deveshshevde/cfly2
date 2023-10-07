package okhttp3;

import java.io.Closeable;
import okhttp3.internal.connection.c;
import okhttp3.s;

public final class ab implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final z f31832a;

    /* renamed from: b  reason: collision with root package name */
    final Protocol f31833b;

    /* renamed from: c  reason: collision with root package name */
    final int f31834c;

    /* renamed from: d  reason: collision with root package name */
    final String f31835d;

    /* renamed from: e  reason: collision with root package name */
    final r f31836e;

    /* renamed from: f  reason: collision with root package name */
    final s f31837f;

    /* renamed from: g  reason: collision with root package name */
    final ac f31838g;

    /* renamed from: h  reason: collision with root package name */
    final ab f31839h;

    /* renamed from: i  reason: collision with root package name */
    final ab f31840i;

    /* renamed from: j  reason: collision with root package name */
    final ab f31841j;

    /* renamed from: k  reason: collision with root package name */
    final long f31842k;

    /* renamed from: l  reason: collision with root package name */
    final long f31843l;

    /* renamed from: m  reason: collision with root package name */
    final c f31844m;

    /* renamed from: n  reason: collision with root package name */
    private volatile d f31845n;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        z f31846a;

        /* renamed from: b  reason: collision with root package name */
        Protocol f31847b;

        /* renamed from: c  reason: collision with root package name */
        int f31848c;

        /* renamed from: d  reason: collision with root package name */
        String f31849d;

        /* renamed from: e  reason: collision with root package name */
        r f31850e;

        /* renamed from: f  reason: collision with root package name */
        s.a f31851f;

        /* renamed from: g  reason: collision with root package name */
        ac f31852g;

        /* renamed from: h  reason: collision with root package name */
        ab f31853h;

        /* renamed from: i  reason: collision with root package name */
        ab f31854i;

        /* renamed from: j  reason: collision with root package name */
        ab f31855j;

        /* renamed from: k  reason: collision with root package name */
        long f31856k;

        /* renamed from: l  reason: collision with root package name */
        long f31857l;

        /* renamed from: m  reason: collision with root package name */
        c f31858m;

        public a() {
            this.f31848c = -1;
            this.f31851f = new s.a();
        }

        a(ab abVar) {
            this.f31848c = -1;
            this.f31846a = abVar.f31832a;
            this.f31847b = abVar.f31833b;
            this.f31848c = abVar.f31834c;
            this.f31849d = abVar.f31835d;
            this.f31850e = abVar.f31836e;
            this.f31851f = abVar.f31837f.b();
            this.f31852g = abVar.f31838g;
            this.f31853h = abVar.f31839h;
            this.f31854i = abVar.f31840i;
            this.f31855j = abVar.f31841j;
            this.f31856k = abVar.f31842k;
            this.f31857l = abVar.f31843l;
            this.f31858m = abVar.f31844m;
        }

        private void a(String str, ab abVar) {
            if (abVar.f31838g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (abVar.f31839h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (abVar.f31840i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (abVar.f31841j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private void d(ab abVar) {
            if (abVar.f31838g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int i2) {
            this.f31848c = i2;
            return this;
        }

        public a a(long j2) {
            this.f31856k = j2;
            return this;
        }

        public a a(String str) {
            this.f31849d = str;
            return this;
        }

        public a a(String str, String str2) {
            this.f31851f.d(str, str2);
            return this;
        }

        public a a(Protocol protocol) {
            this.f31847b = protocol;
            return this;
        }

        public a a(ab abVar) {
            if (abVar != null) {
                a("networkResponse", abVar);
            }
            this.f31853h = abVar;
            return this;
        }

        public a a(ac acVar) {
            this.f31852g = acVar;
            return this;
        }

        public a a(r rVar) {
            this.f31850e = rVar;
            return this;
        }

        public a a(s sVar) {
            this.f31851f = sVar.b();
            return this;
        }

        public a a(z zVar) {
            this.f31846a = zVar;
            return this;
        }

        public ab a() {
            if (this.f31846a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f31847b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f31848c < 0) {
                throw new IllegalStateException("code < 0: " + this.f31848c);
            } else if (this.f31849d != null) {
                return new ab(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        /* access modifiers changed from: package-private */
        public void a(c cVar) {
            this.f31858m = cVar;
        }

        public a b(long j2) {
            this.f31857l = j2;
            return this;
        }

        public a b(String str, String str2) {
            this.f31851f.a(str, str2);
            return this;
        }

        public a b(ab abVar) {
            if (abVar != null) {
                a("cacheResponse", abVar);
            }
            this.f31854i = abVar;
            return this;
        }

        public a c(ab abVar) {
            if (abVar != null) {
                d(abVar);
            }
            this.f31855j = abVar;
            return this;
        }
    }

    ab(a aVar) {
        this.f31832a = aVar.f31846a;
        this.f31833b = aVar.f31847b;
        this.f31834c = aVar.f31848c;
        this.f31835d = aVar.f31849d;
        this.f31836e = aVar.f31850e;
        this.f31837f = aVar.f31851f.a();
        this.f31838g = aVar.f31852g;
        this.f31839h = aVar.f31853h;
        this.f31840i = aVar.f31854i;
        this.f31841j = aVar.f31855j;
        this.f31842k = aVar.f31856k;
        this.f31843l = aVar.f31857l;
        this.f31844m = aVar.f31858m;
    }

    public String a(String str) {
        return a(str, (String) null);
    }

    public String a(String str, String str2) {
        String a2 = this.f31837f.a(str);
        return a2 != null ? a2 : str2;
    }

    public z a() {
        return this.f31832a;
    }

    public int b() {
        return this.f31834c;
    }

    public boolean c() {
        int i2 = this.f31834c;
        return i2 >= 200 && i2 < 300;
    }

    public void close() {
        ac acVar = this.f31838g;
        if (acVar != null) {
            acVar.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public String d() {
        return this.f31835d;
    }

    public r e() {
        return this.f31836e;
    }

    public s f() {
        return this.f31837f;
    }

    public ac g() {
        return this.f31838g;
    }

    public a h() {
        return new a(this);
    }

    public ab i() {
        return this.f31841j;
    }

    public d j() {
        d dVar = this.f31845n;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f31837f);
        this.f31845n = a2;
        return a2;
    }

    public long k() {
        return this.f31842k;
    }

    public long l() {
        return this.f31843l;
    }

    public String toString() {
        return "Response{protocol=" + this.f31833b + ", code=" + this.f31834c + ", message=" + this.f31835d + ", url=" + this.f31832a.a() + '}';
    }
}
