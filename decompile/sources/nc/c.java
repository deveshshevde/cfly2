package nc;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import nd.d;
import nd.e;
import okhttp3.ab;
import okhttp3.s;
import okhttp3.z;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final z f31331a;

    /* renamed from: b  reason: collision with root package name */
    public final ab f31332b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final long f31333a;

        /* renamed from: b  reason: collision with root package name */
        final z f31334b;

        /* renamed from: c  reason: collision with root package name */
        final ab f31335c;

        /* renamed from: d  reason: collision with root package name */
        private Date f31336d;

        /* renamed from: e  reason: collision with root package name */
        private String f31337e;

        /* renamed from: f  reason: collision with root package name */
        private Date f31338f;

        /* renamed from: g  reason: collision with root package name */
        private String f31339g;

        /* renamed from: h  reason: collision with root package name */
        private Date f31340h;

        /* renamed from: i  reason: collision with root package name */
        private long f31341i;

        /* renamed from: j  reason: collision with root package name */
        private long f31342j;

        /* renamed from: k  reason: collision with root package name */
        private String f31343k;

        /* renamed from: l  reason: collision with root package name */
        private int f31344l = -1;

        public a(long j2, z zVar, ab abVar) {
            this.f31333a = j2;
            this.f31334b = zVar;
            this.f31335c = abVar;
            if (abVar != null) {
                this.f31341i = abVar.k();
                this.f31342j = abVar.l();
                s f2 = abVar.f();
                int a2 = f2.a();
                for (int i2 = 0; i2 < a2; i2++) {
                    String a3 = f2.a(i2);
                    String b2 = f2.b(i2);
                    if ("Date".equalsIgnoreCase(a3)) {
                        this.f31336d = d.a(b2);
                        this.f31337e = b2;
                    } else if ("Expires".equalsIgnoreCase(a3)) {
                        this.f31340h = d.a(b2);
                    } else if ("Last-Modified".equalsIgnoreCase(a3)) {
                        this.f31338f = d.a(b2);
                        this.f31339g = b2;
                    } else if ("ETag".equalsIgnoreCase(a3)) {
                        this.f31343k = b2;
                    } else if ("Age".equalsIgnoreCase(a3)) {
                        this.f31344l = e.b(b2, -1);
                    }
                }
            }
        }

        private static boolean a(z zVar) {
            return (zVar.a("If-Modified-Since") == null && zVar.a("If-None-Match") == null) ? false : true;
        }

        private c b() {
            if (this.f31335c == null) {
                return new c(this.f31334b, (ab) null);
            }
            if (this.f31334b.g() && this.f31335c.e() == null) {
                return new c(this.f31334b, (ab) null);
            }
            if (!c.a(this.f31335c, this.f31334b)) {
                return new c(this.f31334b, (ab) null);
            }
            okhttp3.d f2 = this.f31334b.f();
            if (f2.a() || a(this.f31334b)) {
                return new c(this.f31334b, (ab) null);
            }
            okhttp3.d j2 = this.f31335c.j();
            long d2 = d();
            long c2 = c();
            if (f2.c() != -1) {
                c2 = Math.min(c2, TimeUnit.SECONDS.toMillis((long) f2.c()));
            }
            long j3 = 0;
            long millis = f2.h() != -1 ? TimeUnit.SECONDS.toMillis((long) f2.h()) : 0;
            if (!j2.f() && f2.g() != -1) {
                j3 = TimeUnit.SECONDS.toMillis((long) f2.g());
            }
            if (!j2.a()) {
                long j4 = millis + d2;
                if (j4 < j3 + c2) {
                    ab.a h2 = this.f31335c.h();
                    if (j4 >= c2) {
                        h2.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (d2 > 86400000 && e()) {
                        h2.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c((z) null, h2.a());
                }
            }
            String str = this.f31343k;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f31338f != null) {
                str = this.f31339g;
            } else if (this.f31336d == null) {
                return new c(this.f31334b, (ab) null);
            } else {
                str = this.f31337e;
            }
            s.a b2 = this.f31334b.c().b();
            nb.a.f31311a.a(b2, str2, str);
            return new c(this.f31334b.e().a(b2.a()).b(), this.f31335c);
        }

        private long c() {
            okhttp3.d j2 = this.f31335c.j();
            if (j2.c() != -1) {
                return TimeUnit.SECONDS.toMillis((long) j2.c());
            }
            if (this.f31340h != null) {
                Date date = this.f31336d;
                long time = this.f31340h.getTime() - (date != null ? date.getTime() : this.f31342j);
                if (time > 0) {
                    return time;
                }
                return 0;
            } else if (this.f31338f == null || this.f31335c.a().a().l() != null) {
                return 0;
            } else {
                Date date2 = this.f31336d;
                long time2 = (date2 != null ? date2.getTime() : this.f31341i) - this.f31338f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
                return 0;
            }
        }

        private long d() {
            Date date = this.f31336d;
            long j2 = 0;
            if (date != null) {
                j2 = Math.max(0, this.f31342j - date.getTime());
            }
            if (this.f31344l != -1) {
                j2 = Math.max(j2, TimeUnit.SECONDS.toMillis((long) this.f31344l));
            }
            long j3 = this.f31342j;
            return j2 + (j3 - this.f31341i) + (this.f31333a - j3);
        }

        private boolean e() {
            return this.f31335c.j().c() == -1 && this.f31340h == null;
        }

        public c a() {
            c b2 = b();
            return (b2.f31331a == null || !this.f31334b.f().i()) ? b2 : new c((z) null, (ab) null);
        }
    }

    c(z zVar, ab abVar) {
        this.f31331a = zVar;
        this.f31332b = abVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0056, code lost:
        if (r3.j().d() == false) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(okhttp3.ab r3, okhttp3.z r4) {
        /*
            int r0 = r3.b()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L_0x005a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L_0x0031
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L_0x005a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L_0x005a
            switch(r0) {
                case 300: goto L_0x005a;
                case 301: goto L_0x005a;
                case 302: goto L_0x0031;
                default: goto L_0x0030;
            }
        L_0x0030:
            goto L_0x0059
        L_0x0031:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.a(r0)
            if (r0 != 0) goto L_0x005a
            okhttp3.d r0 = r3.j()
            int r0 = r0.c()
            r1 = -1
            if (r0 != r1) goto L_0x005a
            okhttp3.d r0 = r3.j()
            boolean r0 = r0.e()
            if (r0 != 0) goto L_0x005a
            okhttp3.d r0 = r3.j()
            boolean r0 = r0.d()
            if (r0 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            return r2
        L_0x005a:
            okhttp3.d r3 = r3.j()
            boolean r3 = r3.b()
            if (r3 != 0) goto L_0x006f
            okhttp3.d r3 = r4.f()
            boolean r3 = r3.b()
            if (r3 != 0) goto L_0x006f
            r2 = 1
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.c.a(okhttp3.ab, okhttp3.z):boolean");
    }
}
