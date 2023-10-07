package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.e;
import com.google.android.exoplayer2.source.dash.g;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.o;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.upstream.q;
import com.google.android.exoplayer2.upstream.r;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import fu.h;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DashMediaSource extends com.google.android.exoplayer2.source.a {
    private boolean A;
    private long B;
    private long C;
    private long D;
    private int E;
    private long F;
    private int G;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f16028a;

    /* renamed from: b  reason: collision with root package name */
    private final f.a f16029b;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0113a f16030c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.source.d f16031d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<?> f16032e;

    /* renamed from: f  reason: collision with root package name */
    private final p f16033f;

    /* renamed from: g  reason: collision with root package name */
    private final long f16034g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f16035h;

    /* renamed from: i  reason: collision with root package name */
    private final j.a f16036i;

    /* renamed from: j  reason: collision with root package name */
    private final r.a<? extends fu.b> f16037j;

    /* renamed from: k  reason: collision with root package name */
    private final c f16038k;

    /* renamed from: l  reason: collision with root package name */
    private final Object f16039l;

    /* renamed from: m  reason: collision with root package name */
    private final SparseArray<b> f16040m;

    /* renamed from: n  reason: collision with root package name */
    private final Runnable f16041n;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f16042o;

    /* renamed from: p  reason: collision with root package name */
    private final g.b f16043p;

    /* renamed from: q  reason: collision with root package name */
    private final q f16044q;

    /* renamed from: r  reason: collision with root package name */
    private final Object f16045r;

    /* renamed from: s  reason: collision with root package name */
    private com.google.android.exoplayer2.upstream.f f16046s;

    /* renamed from: t  reason: collision with root package name */
    private Loader f16047t;

    /* renamed from: u  reason: collision with root package name */
    private t f16048u;

    /* renamed from: v  reason: collision with root package name */
    private IOException f16049v;

    /* renamed from: w  reason: collision with root package name */
    private Handler f16050w;

    /* renamed from: x  reason: collision with root package name */
    private Uri f16051x;

    /* renamed from: y  reason: collision with root package name */
    private Uri f16052y;

    /* renamed from: z  reason: collision with root package name */
    private fu.b f16053z;

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0113a f16054a;

        /* renamed from: b  reason: collision with root package name */
        private final f.a f16055b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.exoplayer2.drm.b<?> f16056c;

        /* renamed from: d  reason: collision with root package name */
        private com.google.android.exoplayer2.source.d f16057d;

        /* renamed from: e  reason: collision with root package name */
        private p f16058e;

        /* renamed from: f  reason: collision with root package name */
        private long f16059f;

        public Factory(a.C0113a aVar, f.a aVar2) {
            this.f16054a = (a.C0113a) com.google.android.exoplayer2.util.a.b(aVar);
            this.f16055b = aVar2;
            this.f16056c = b.CC.c();
            this.f16058e = new o();
            this.f16059f = 30000;
            this.f16057d = new com.google.android.exoplayer2.source.e();
        }

        public Factory(f.a aVar) {
            this(new e.a(aVar), aVar);
        }
    }

    private static final class a extends af {

        /* renamed from: b  reason: collision with root package name */
        private final long f16060b;

        /* renamed from: c  reason: collision with root package name */
        private final long f16061c;

        /* renamed from: d  reason: collision with root package name */
        private final int f16062d;

        /* renamed from: e  reason: collision with root package name */
        private final long f16063e;

        /* renamed from: f  reason: collision with root package name */
        private final long f16064f;

        /* renamed from: g  reason: collision with root package name */
        private final long f16065g;

        /* renamed from: h  reason: collision with root package name */
        private final fu.b f16066h;

        /* renamed from: i  reason: collision with root package name */
        private final Object f16067i;

        public a(long j2, long j3, int i2, long j4, long j5, long j6, fu.b bVar, Object obj) {
            this.f16060b = j2;
            this.f16061c = j3;
            this.f16062d = i2;
            this.f16063e = j4;
            this.f16064f = j5;
            this.f16065g = j6;
            this.f16066h = bVar;
            this.f16067i = obj;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
            r2 = r2.f28139c.get(r6).f28116c.get(0).c();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long a(long r9) {
            /*
                r8 = this;
                long r0 = r8.f16065g
                fu.b r2 = r8.f16066h
                boolean r2 = a((fu.b) r2)
                if (r2 != 0) goto L_0x000b
                return r0
            L_0x000b:
                r2 = 0
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                long r0 = r0 + r9
                long r9 = r8.f16064f
                int r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
                if (r2 <= 0) goto L_0x001e
                r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                return r9
            L_0x001e:
                long r9 = r8.f16063e
                long r9 = r9 + r0
                fu.b r2 = r8.f16066h
                r3 = 0
                long r4 = r2.c(r3)
                r2 = 0
            L_0x0029:
                fu.b r6 = r8.f16066h
                int r6 = r6.a()
                int r6 = r6 + -1
                if (r2 >= r6) goto L_0x0041
                int r6 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x0041
                long r9 = r9 - r4
                int r2 = r2 + 1
                fu.b r4 = r8.f16066h
                long r4 = r4.c(r2)
                goto L_0x0029
            L_0x0041:
                fu.b r6 = r8.f16066h
                fu.e r2 = r6.a(r2)
                r6 = 2
                int r6 = r2.a(r6)
                r7 = -1
                if (r6 != r7) goto L_0x0050
                return r0
            L_0x0050:
                java.util.List<fu.a> r2 = r2.f28139c
                java.lang.Object r2 = r2.get(r6)
                fu.a r2 = (fu.a) r2
                java.util.List<fu.g> r2 = r2.f28116c
                java.lang.Object r2 = r2.get(r3)
                fu.g r2 = (fu.g) r2
                com.google.android.exoplayer2.source.dash.c r2 = r2.c()
                if (r2 == 0) goto L_0x0077
                int r3 = r2.c(r4)
                if (r3 != 0) goto L_0x006d
                goto L_0x0077
            L_0x006d:
                long r3 = r2.a(r9, r4)
                long r2 = r2.a(r3)
                long r0 = r0 + r2
                long r0 = r0 - r9
            L_0x0077:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.a.a(long):long");
        }

        private static boolean a(fu.b bVar) {
            return bVar.f28122c && bVar.f28123d != -9223372036854775807L && bVar.f28121b == -9223372036854775807L;
        }

        public int a(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f16062d) >= 0 && intValue < c()) {
                return intValue;
            }
            return -1;
        }

        public af.a a(int i2, af.a aVar, boolean z2) {
            com.google.android.exoplayer2.util.a.a(i2, 0, c());
            Integer num = null;
            String str = z2 ? this.f16066h.a(i2).f28137a : null;
            if (z2) {
                num = Integer.valueOf(this.f16062d + i2);
            }
            return aVar.a(str, num, 0, this.f16066h.c(i2), com.google.android.exoplayer2.e.b(this.f16066h.a(i2).f28138b - this.f16066h.a(0).f28138b) - this.f16063e);
        }

        public af.b a(int i2, af.b bVar, long j2) {
            af.b bVar2 = bVar;
            com.google.android.exoplayer2.util.a.a(i2, 0, 1);
            long a2 = a(j2);
            Object obj = af.b.f15172a;
            Object obj2 = this.f16067i;
            fu.b bVar3 = this.f16066h;
            return bVar.a(obj, obj2, bVar3, this.f16060b, this.f16061c, true, a(bVar3), this.f16066h.f28122c, a2, this.f16064f, 0, c() - 1, this.f16063e);
        }

        public Object a(int i2) {
            com.google.android.exoplayer2.util.a.a(i2, 0, c());
            return Integer.valueOf(this.f16062d + i2);
        }

        public int b() {
            return 1;
        }

        public int c() {
            return this.f16066h.a();
        }
    }

    static final class b implements r.a<Long> {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f16068a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        b() {
        }

        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8"))).readLine();
            try {
                Matcher matcher = f16068a.matcher(readLine);
                if (!matcher.matches()) {
                    String valueOf = String.valueOf(readLine);
                    throw new ParserException(valueOf.length() != 0 ? "Couldn't parse timestamp: ".concat(valueOf) : new String("Couldn't parse timestamp: "));
                }
                String group = matcher.group(1);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                long time = simpleDateFormat.parse(group).getTime();
                if (!"Z".equals(matcher.group(2))) {
                    long j2 = "+".equals(matcher.group(4)) ? 1 : -1;
                    long parseLong = Long.parseLong(matcher.group(5));
                    String group2 = matcher.group(7);
                    time -= j2 * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0 : Long.parseLong(group2))) * 60) * 1000);
                }
                return Long.valueOf(time);
            } catch (ParseException e2) {
                throw new ParserException((Throwable) e2);
            }
        }
    }

    private final class c implements Loader.a<r<fu.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DashMediaSource f16069a;

        public Loader.b a(r<fu.b> rVar, long j2, long j3, IOException iOException, int i2) {
            return this.f16069a.a(rVar, j2, j3, iOException, i2);
        }

        public void a(r<fu.b> rVar, long j2, long j3) {
            this.f16069a.a(rVar, j2, j3);
        }

        public void a(r<fu.b> rVar, long j2, long j3, boolean z2) {
            this.f16069a.c(rVar, j2, j3);
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f16070a;

        /* renamed from: b  reason: collision with root package name */
        public final long f16071b;

        /* renamed from: c  reason: collision with root package name */
        public final long f16072c;

        private d(boolean z2, long j2, long j3) {
            this.f16070a = z2;
            this.f16071b = j2;
            this.f16072c = j3;
        }

        public static d a(fu.e eVar, long j2) {
            boolean z2;
            boolean z3;
            long j3;
            fu.e eVar2 = eVar;
            long j4 = j2;
            int size = eVar2.f28139c.size();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z2 = false;
                    break;
                }
                int i4 = eVar2.f28139c.get(i3).f28115b;
                if (i4 == 1 || i4 == 2) {
                    z2 = true;
                } else {
                    i3++;
                }
            }
            long j5 = Long.MAX_VALUE;
            int i5 = 0;
            boolean z4 = false;
            long j6 = 0;
            boolean z5 = false;
            while (i5 < size) {
                fu.a aVar = eVar2.f28139c.get(i5);
                if (!z2 || aVar.f28115b != 3) {
                    c c2 = aVar.f28116c.get(i2).c();
                    if (c2 == null) {
                        return new d(true, 0, j2);
                    }
                    z4 |= c2.b();
                    int c3 = c2.c(j4);
                    if (c3 == 0) {
                        z3 = z2;
                        j3 = 0;
                        j6 = 0;
                        z5 = true;
                    } else if (!z5) {
                        z3 = z2;
                        long a2 = c2.a();
                        long j7 = j5;
                        j6 = Math.max(j6, c2.a(a2));
                        if (c3 != -1) {
                            long j8 = (a2 + ((long) c3)) - 1;
                            j3 = Math.min(j7, c2.a(j8) + c2.b(j8, j4));
                        } else {
                            j3 = j7;
                        }
                    }
                    i5++;
                    j5 = j3;
                    z2 = z3;
                    i2 = 0;
                }
                z3 = z2;
                j3 = j5;
                i5++;
                j5 = j3;
                z2 = z3;
                i2 = 0;
            }
            return new d(z4, j6, j5);
        }
    }

    private final class e implements Loader.a<r<Long>> {
        private e() {
        }

        public Loader.b a(r<Long> rVar, long j2, long j3, IOException iOException, int i2) {
            return DashMediaSource.this.a(rVar, j2, j3, iOException);
        }

        public void a(r<Long> rVar, long j2, long j3) {
            DashMediaSource.this.b(rVar, j2, j3);
        }

        public void a(r<Long> rVar, long j2, long j3, boolean z2) {
            DashMediaSource.this.c(rVar, j2, j3);
        }
    }

    private static final class f implements r.a<Long> {
        private f() {
        }

        /* renamed from: a */
        public Long b(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(ad.f(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        n.a("goog.exo.dash");
    }

    private void a(long j2) {
        this.D = j2;
        a(true);
    }

    private <T> void a(r<T> rVar, Loader.a<r<T>> aVar, int i2) {
        this.f16036i.a(rVar.f17079a, rVar.f17080b, this.f16047t.a(rVar, aVar, i2));
    }

    private void a(h hVar) {
        r.a aVar;
        String str = hVar.f28150a;
        if (ad.a((Object) str, (Object) "urn:mpeg:dash:utc:direct:2014") || ad.a((Object) str, (Object) "urn:mpeg:dash:utc:direct:2012")) {
            b(hVar);
            return;
        }
        if (ad.a((Object) str, (Object) "urn:mpeg:dash:utc:http-iso:2014") || ad.a((Object) str, (Object) "urn:mpeg:dash:utc:http-iso:2012")) {
            aVar = new b();
        } else if (ad.a((Object) str, (Object) "urn:mpeg:dash:utc:http-xsdate:2014") || ad.a((Object) str, (Object) "urn:mpeg:dash:utc:http-xsdate:2012")) {
            aVar = new f();
        } else {
            a(new IOException("Unsupported UTC timing scheme"));
            return;
        }
        a(hVar, aVar);
    }

    private void a(h hVar, r.a<Long> aVar) {
        a(new r(this.f16046s, Uri.parse(hVar.f28151b), 5, aVar), new e(), 1);
    }

    private void a(IOException iOException) {
        k.b("DashMediaSource", "Failed to resolve UtcTiming element.", iOException);
        a(true);
    }

    private void a(boolean z2) {
        long j2;
        boolean z3;
        long j3;
        for (int i2 = 0; i2 < this.f16040m.size(); i2++) {
            int keyAt = this.f16040m.keyAt(i2);
            if (keyAt >= this.G) {
                this.f16040m.valueAt(i2).a(this.f16053z, keyAt - this.G);
            }
        }
        int a2 = this.f16053z.a() - 1;
        d a3 = d.a(this.f16053z.a(0), this.f16053z.c(0));
        d a4 = d.a(this.f16053z.a(a2), this.f16053z.c(a2));
        long j4 = a3.f16071b;
        long j5 = a4.f16072c;
        if (!this.f16053z.f28122c || a4.f16070a) {
            j2 = j4;
            z3 = false;
        } else {
            j5 = Math.min((g() - com.google.android.exoplayer2.e.b(this.f16053z.f28120a)) - com.google.android.exoplayer2.e.b(this.f16053z.a(a2).f28138b), j5);
            if (this.f16053z.f28124e != -9223372036854775807L) {
                long b2 = j5 - com.google.android.exoplayer2.e.b(this.f16053z.f28124e);
                while (b2 < 0 && a2 > 0) {
                    a2--;
                    b2 += this.f16053z.c(a2);
                }
                j4 = a2 == 0 ? Math.max(j4, b2) : this.f16053z.c(0);
            }
            j2 = j4;
            z3 = true;
        }
        long j6 = j5 - j2;
        for (int i3 = 0; i3 < this.f16053z.a() - 1; i3++) {
            j6 += this.f16053z.c(i3);
        }
        if (this.f16053z.f28122c) {
            long j7 = this.f16034g;
            if (!this.f16035h && this.f16053z.f28125f != -9223372036854775807L) {
                j7 = this.f16053z.f28125f;
            }
            long b3 = j6 - com.google.android.exoplayer2.e.b(j7);
            if (b3 < 5000000) {
                b3 = Math.min(5000000, j6 / 2);
            }
            j3 = b3;
        } else {
            j3 = 0;
        }
        a((af) new a(this.f16053z.f28120a, this.f16053z.f28120a != -9223372036854775807L ? this.f16053z.f28120a + this.f16053z.a(0).f28138b + com.google.android.exoplayer2.e.a(j2) : -9223372036854775807L, this.G, j2, j6, j3, this.f16053z, this.f16045r));
        if (!this.f16028a) {
            this.f16050w.removeCallbacks(this.f16042o);
            long j8 = 5000;
            if (z3) {
                this.f16050w.postDelayed(this.f16042o, 5000);
            }
            if (this.A) {
                e();
            } else if (z2 && this.f16053z.f28122c && this.f16053z.f28123d != -9223372036854775807L) {
                long j9 = this.f16053z.f28123d;
                if (j9 != 0) {
                    j8 = j9;
                }
                b(Math.max(0, (this.B + j8) - SystemClock.elapsedRealtime()));
            }
        }
    }

    private void b(long j2) {
        this.f16050w.postDelayed(this.f16041n, j2);
    }

    private void b(h hVar) {
        try {
            a(ad.f(hVar.f28151b) - this.C);
        } catch (ParserException e2) {
            a((IOException) e2);
        }
    }

    private void e() {
        Uri uri;
        this.f16050w.removeCallbacks(this.f16041n);
        if (!this.f16047t.a()) {
            if (this.f16047t.c()) {
                this.A = true;
                return;
            }
            synchronized (this.f16039l) {
                uri = this.f16052y;
            }
            this.A = false;
            a(new r(this.f16046s, uri, 4, this.f16037j), this.f16038k, this.f16033f.a(4));
        }
    }

    private long f() {
        return (long) Math.min((this.E - 1) * 1000, 5000);
    }

    private long g() {
        return com.google.android.exoplayer2.e.b(this.D != 0 ? SystemClock.elapsedRealtime() + this.D : System.currentTimeMillis());
    }

    public com.google.android.exoplayer2.source.h a(i.a aVar, com.google.android.exoplayer2.upstream.b bVar, long j2) {
        i.a aVar2 = aVar;
        int intValue = ((Integer) aVar2.f16367a).intValue() - this.G;
        j.a a2 = a(aVar2, this.f16053z.a(intValue).f28138b);
        b bVar2 = new b(this.G + intValue, this.f16053z, intValue, this.f16030c, this.f16048u, this.f16032e, this.f16033f, a2, this.D, this.f16044q, bVar, this.f16031d, this.f16043p);
        this.f16040m.put(bVar2.f16075a, bVar2);
        return bVar2;
    }

    /* access modifiers changed from: package-private */
    public Loader.b a(r<Long> rVar, long j2, long j3, IOException iOException) {
        r<Long> rVar2 = rVar;
        j.a aVar = this.f16036i;
        com.google.android.exoplayer2.upstream.h hVar = rVar2.f17079a;
        Uri e2 = rVar.e();
        Map<String, List<String>> f2 = rVar.f();
        int i2 = rVar2.f17080b;
        aVar.a(hVar, e2, f2, i2, j2, j3, rVar.d(), iOException, true);
        a(iOException);
        return Loader.f16945c;
    }

    /* access modifiers changed from: package-private */
    public Loader.b a(r<fu.b> rVar, long j2, long j3, IOException iOException, int i2) {
        r<fu.b> rVar2 = rVar;
        long b2 = this.f16033f.b(4, j3, iOException, i2);
        Loader.b a2 = b2 == -9223372036854775807L ? Loader.f16946d : Loader.a(false, b2);
        this.f16036i.a(rVar2.f17079a, rVar.e(), rVar.f(), rVar2.f17080b, j2, j3, rVar.d(), iOException, !a2.a());
        return a2;
    }

    public void a(com.google.android.exoplayer2.source.h hVar) {
        b bVar = (b) hVar;
        bVar.g();
        this.f16040m.remove(bVar.f16075a);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.android.exoplayer2.upstream.r<fu.b> r17, long r18, long r20) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r13 = r18
            com.google.android.exoplayer2.source.j$a r2 = r1.f16036i
            com.google.android.exoplayer2.upstream.h r3 = r0.f17079a
            android.net.Uri r4 = r17.e()
            java.util.Map r5 = r17.f()
            int r6 = r0.f17080b
            long r11 = r17.d()
            r7 = r18
            r9 = r20
            r2.a(r3, r4, r5, r6, r7, r9, r11)
            java.lang.Object r2 = r17.c()
            fu.b r2 = (fu.b) r2
            fu.b r3 = r1.f16053z
            r4 = 0
            if (r3 != 0) goto L_0x002c
            r3 = 0
            goto L_0x0030
        L_0x002c:
            int r3 = r3.a()
        L_0x0030:
            fu.e r5 = r2.a(r4)
            long r5 = r5.f28138b
            r7 = 0
        L_0x0037:
            if (r7 >= r3) goto L_0x0048
            fu.b r8 = r1.f16053z
            fu.e r8 = r8.a(r7)
            long r8 = r8.f28138b
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 >= 0) goto L_0x0048
            int r7 = r7 + 1
            goto L_0x0037
        L_0x0048:
            boolean r5 = r2.f28122c
            r6 = 1
            if (r5 == 0) goto L_0x00bc
            int r5 = r3 - r7
            int r8 = r2.a()
            if (r5 <= r8) goto L_0x005e
            java.lang.String r5 = "DashMediaSource"
            java.lang.String r8 = "Loaded out of sync manifest"
        L_0x0059:
            com.google.android.exoplayer2.util.k.c(r5, r8)
            r5 = 1
            goto L_0x0098
        L_0x005e:
            long r8 = r1.F
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0097
            long r8 = r2.f28126g
            r10 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r10
            long r10 = r1.F
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 > 0) goto L_0x0097
            java.lang.String r5 = "DashMediaSource"
            long r8 = r2.f28126g
            long r10 = r1.F
            r12 = 73
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r12)
            java.lang.String r12 = "Loaded stale dynamic manifest: "
            r15.append(r12)
            r15.append(r8)
            java.lang.String r8 = ", "
            r15.append(r8)
            r15.append(r10)
            java.lang.String r8 = r15.toString()
            goto L_0x0059
        L_0x0097:
            r5 = 0
        L_0x0098:
            if (r5 == 0) goto L_0x00ba
            int r2 = r1.E
            int r3 = r2 + 1
            r1.E = r3
            com.google.android.exoplayer2.upstream.p r3 = r1.f16033f
            int r0 = r0.f17080b
            int r0 = r3.a(r0)
            if (r2 >= r0) goto L_0x00b2
            long r2 = r16.f()
            r1.b((long) r2)
            goto L_0x00b9
        L_0x00b2:
            com.google.android.exoplayer2.source.dash.DashManifestStaleException r0 = new com.google.android.exoplayer2.source.dash.DashManifestStaleException
            r0.<init>()
            r1.f16049v = r0
        L_0x00b9:
            return
        L_0x00ba:
            r1.E = r4
        L_0x00bc:
            r1.f16053z = r2
            boolean r5 = r1.A
            boolean r2 = r2.f28122c
            r2 = r2 & r5
            r1.A = r2
            long r8 = r13 - r20
            r1.B = r8
            r1.C = r13
            java.lang.Object r2 = r1.f16039l
            monitor-enter(r2)
            com.google.android.exoplayer2.upstream.h r5 = r0.f17079a     // Catch:{ all -> 0x010a }
            android.net.Uri r5 = r5.f16995a     // Catch:{ all -> 0x010a }
            android.net.Uri r8 = r1.f16052y     // Catch:{ all -> 0x010a }
            if (r5 != r8) goto L_0x00d7
            r4 = 1
        L_0x00d7:
            if (r4 == 0) goto L_0x00ea
            fu.b r4 = r1.f16053z     // Catch:{ all -> 0x010a }
            android.net.Uri r4 = r4.f28128i     // Catch:{ all -> 0x010a }
            if (r4 == 0) goto L_0x00e4
            fu.b r0 = r1.f16053z     // Catch:{ all -> 0x010a }
            android.net.Uri r0 = r0.f28128i     // Catch:{ all -> 0x010a }
            goto L_0x00e8
        L_0x00e4:
            android.net.Uri r0 = r17.e()     // Catch:{ all -> 0x010a }
        L_0x00e8:
            r1.f16052y = r0     // Catch:{ all -> 0x010a }
        L_0x00ea:
            monitor-exit(r2)     // Catch:{ all -> 0x010a }
            if (r3 != 0) goto L_0x0101
            fu.b r0 = r1.f16053z
            boolean r0 = r0.f28122c
            if (r0 == 0) goto L_0x0106
            fu.b r0 = r1.f16053z
            fu.h r0 = r0.f28127h
            if (r0 == 0) goto L_0x0106
            fu.b r0 = r1.f16053z
            fu.h r0 = r0.f28127h
            r1.a((fu.h) r0)
            goto L_0x0109
        L_0x0101:
            int r0 = r1.G
            int r0 = r0 + r7
            r1.G = r0
        L_0x0106:
            r1.a((boolean) r6)
        L_0x0109:
            return
        L_0x010a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x010a }
            goto L_0x010e
        L_0x010d:
            throw r0
        L_0x010e:
            goto L_0x010d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.a(com.google.android.exoplayer2.upstream.r, long, long):void");
    }

    /* access modifiers changed from: protected */
    public void a(t tVar) {
        this.f16048u = tVar;
        this.f16032e.a();
        if (this.f16028a) {
            a(false);
            return;
        }
        this.f16046s = this.f16029b.a();
        this.f16047t = new Loader("Loader:DashMediaSource");
        this.f16050w = new Handler();
        e();
    }

    /* access modifiers changed from: package-private */
    public void b(r<Long> rVar, long j2, long j3) {
        r<Long> rVar2 = rVar;
        this.f16036i.a(rVar2.f17079a, rVar.e(), rVar.f(), rVar2.f17080b, j2, j3, rVar.d());
        a(rVar.c().longValue() - j2);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.A = false;
        this.f16046s = null;
        Loader loader = this.f16047t;
        if (loader != null) {
            loader.e();
            this.f16047t = null;
        }
        this.B = 0;
        this.C = 0;
        this.f16053z = this.f16028a ? this.f16053z : null;
        this.f16052y = this.f16051x;
        this.f16049v = null;
        Handler handler = this.f16050w;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f16050w = null;
        }
        this.D = 0;
        this.E = 0;
        this.F = -9223372036854775807L;
        this.G = 0;
        this.f16040m.clear();
        this.f16032e.b();
    }

    /* access modifiers changed from: package-private */
    public void c(r<?> rVar, long j2, long j3) {
        r<?> rVar2 = rVar;
        this.f16036i.b(rVar2.f17079a, rVar.e(), rVar.f(), rVar2.f17080b, j2, j3, rVar.d());
    }

    public void d() throws IOException {
        this.f16044q.f();
    }
}
