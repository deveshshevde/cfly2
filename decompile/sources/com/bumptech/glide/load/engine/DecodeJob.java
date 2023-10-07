package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import cd.a;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import s.e;

class DecodeJob<R> implements a.c, e.a, Comparable<DecodeJob<?>>, Runnable {
    private DataSource A;
    private com.bumptech.glide.load.data.d<?> B;
    private volatile e C;
    private volatile boolean D;
    private volatile boolean E;
    private boolean F;

    /* renamed from: a  reason: collision with root package name */
    private final f<R> f10194a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f10195b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final cd.c f10196c = cd.c.a();

    /* renamed from: d  reason: collision with root package name */
    private final d f10197d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a<DecodeJob<?>> f10198e;

    /* renamed from: f  reason: collision with root package name */
    private final c<?> f10199f = new c<>();

    /* renamed from: g  reason: collision with root package name */
    private final e f10200g = new e();

    /* renamed from: h  reason: collision with root package name */
    private com.bumptech.glide.e f10201h;

    /* renamed from: i  reason: collision with root package name */
    private com.bumptech.glide.load.c f10202i;

    /* renamed from: j  reason: collision with root package name */
    private Priority f10203j;

    /* renamed from: k  reason: collision with root package name */
    private l f10204k;

    /* renamed from: l  reason: collision with root package name */
    private int f10205l;

    /* renamed from: m  reason: collision with root package name */
    private int f10206m;

    /* renamed from: n  reason: collision with root package name */
    private h f10207n;

    /* renamed from: o  reason: collision with root package name */
    private f f10208o;

    /* renamed from: p  reason: collision with root package name */
    private a<R> f10209p;

    /* renamed from: q  reason: collision with root package name */
    private int f10210q;

    /* renamed from: r  reason: collision with root package name */
    private Stage f10211r;

    /* renamed from: s  reason: collision with root package name */
    private RunReason f10212s;

    /* renamed from: t  reason: collision with root package name */
    private long f10213t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f10214u;

    /* renamed from: v  reason: collision with root package name */
    private Object f10215v;

    /* renamed from: w  reason: collision with root package name */
    private Thread f10216w;

    /* renamed from: x  reason: collision with root package name */
    private com.bumptech.glide.load.c f10217x;

    /* renamed from: y  reason: collision with root package name */
    private com.bumptech.glide.load.c f10218y;

    /* renamed from: z  reason: collision with root package name */
    private Object f10219z;

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10220a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10221b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f10222c;

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10222c = r0
                r1 = 1
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f10222c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f10221b = r2
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f10221b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                r2 = 3
                int[] r3 = f10221b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r3 = f10221b     // Catch:{ NoSuchFieldError -> 0x004e }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r3 = f10221b     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f10220a = r3
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x006a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x006a }
            L_0x006a:
                int[] r1 = f10220a     // Catch:{ NoSuchFieldError -> 0x0074 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x0074 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0074 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0074 }
            L_0x0074:
                int[] r0 = f10220a     // Catch:{ NoSuchFieldError -> 0x007e }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x007e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.<clinit>():void");
        }
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    interface a<R> {
        void a(DecodeJob<?> decodeJob);

        void a(GlideException glideException);

        void a(s<R> sVar, DataSource dataSource, boolean z2);
    }

    private final class b<Z> implements g.a<Z> {

        /* renamed from: b  reason: collision with root package name */
        private final DataSource f10235b;

        b(DataSource dataSource) {
            this.f10235b = dataSource;
        }

        public s<Z> a(s<Z> sVar) {
            return DecodeJob.this.a(this.f10235b, sVar);
        }
    }

    private static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        private com.bumptech.glide.load.c f10236a;

        /* renamed from: b  reason: collision with root package name */
        private h<Z> f10237b;

        /* renamed from: c  reason: collision with root package name */
        private r<Z> f10238c;

        c() {
        }

        /* access modifiers changed from: package-private */
        public <X> void a(com.bumptech.glide.load.c cVar, h<X> hVar, r<X> rVar) {
            this.f10236a = cVar;
            this.f10237b = hVar;
            this.f10238c = rVar;
        }

        /* access modifiers changed from: package-private */
        public void a(d dVar, f fVar) {
            cd.b.a("DecodeJob.encode");
            try {
                dVar.a().a(this.f10236a, new d(this.f10237b, this.f10238c, fVar));
            } finally {
                this.f10238c.a();
                cd.b.a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f10238c != null;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f10236a = null;
            this.f10237b = null;
            this.f10238c = null;
        }
    }

    interface d {
        bm.a a();
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10239a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10240b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10241c;

        e() {
        }

        private boolean b(boolean z2) {
            return (this.f10241c || z2 || this.f10240b) && this.f10239a;
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a() {
            this.f10240b = true;
            return b(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean a(boolean z2) {
            this.f10239a = true;
            return b(z2);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean b() {
            this.f10241c = true;
            return b(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized void c() {
            this.f10240b = false;
            this.f10239a = false;
            this.f10241c = false;
        }
    }

    DecodeJob(d dVar, e.a<DecodeJob<?>> aVar) {
        this.f10197d = dVar;
        this.f10198e = aVar;
    }

    private Stage a(Stage stage) {
        int i2 = AnonymousClass1.f10221b[stage.ordinal()];
        if (i2 == 1) {
            return this.f10207n.b() ? Stage.DATA_CACHE : a(Stage.DATA_CACHE);
        }
        if (i2 == 2) {
            return this.f10214u ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i2 == 3 || i2 == 4) {
            return Stage.FINISHED;
        }
        if (i2 == 5) {
            return this.f10207n.a() ? Stage.RESOURCE_CACHE : a(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    private <Data> s<R> a(com.bumptech.glide.load.data.d<?> dVar, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long a2 = cc.g.a();
            s<R> a3 = a(data, dataSource);
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result " + a3, a2);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    private <Data> s<R> a(Data data, DataSource dataSource) throws GlideException {
        return a(data, dataSource, this.f10194a.b(data.getClass()));
    }

    private <Data, ResourceType> s<R> a(Data data, DataSource dataSource, q<Data, ResourceType, R> qVar) throws GlideException {
        f a2 = a(dataSource);
        com.bumptech.glide.load.data.e b2 = this.f10201h.d().b(data);
        try {
            return qVar.a(b2, a2, this.f10205l, this.f10206m, new b(dataSource));
        } finally {
            b2.b();
        }
    }

    private f a(DataSource dataSource) {
        f fVar = this.f10208o;
        if (Build.VERSION.SDK_INT < 26) {
            return fVar;
        }
        boolean z2 = dataSource == DataSource.RESOURCE_DISK_CACHE || this.f10194a.m();
        Boolean bool = (Boolean) fVar.a(k.f10474e);
        if (bool != null && (!bool.booleanValue() || z2)) {
            return fVar;
        }
        f fVar2 = new f();
        fVar2.a(this.f10208o);
        fVar2.a(k.f10474e, Boolean.valueOf(z2));
        return fVar2;
    }

    private void a(s<R> sVar, DataSource dataSource, boolean z2) {
        m();
        this.f10209p.a(sVar, dataSource, z2);
    }

    private void a(String str, long j2) {
        a(str, j2, (String) null);
    }

    private void a(String str, long j2, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(cc.g.a(j2));
        sb.append(", load key: ");
        sb.append(this.f10204k);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    private void b(s<R> sVar, DataSource dataSource, boolean z2) {
        r<R> rVar;
        cd.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (sVar instanceof o) {
                ((o) sVar).a();
            }
            rVar = null;
            r<R> rVar2 = sVar;
            if (this.f10199f.a()) {
                r<R> a2 = r.a(sVar);
                rVar = a2;
                rVar2 = a2;
            }
            a(rVar2, dataSource, z2);
            this.f10211r = Stage.ENCODE;
            if (this.f10199f.a()) {
                this.f10199f.a(this.f10197d, this.f10208o);
            }
            if (rVar != null) {
                rVar.a();
            }
            e();
            cd.b.a();
        } catch (Throwable th) {
            cd.b.a();
            throw th;
        }
    }

    private void e() {
        if (this.f10200g.a()) {
            g();
        }
    }

    private void f() {
        if (this.f10200g.b()) {
            g();
        }
    }

    private void g() {
        this.f10200g.c();
        this.f10199f.b();
        this.f10194a.a();
        this.D = false;
        this.f10201h = null;
        this.f10202i = null;
        this.f10208o = null;
        this.f10203j = null;
        this.f10204k = null;
        this.f10209p = null;
        this.f10211r = null;
        this.C = null;
        this.f10216w = null;
        this.f10217x = null;
        this.f10219z = null;
        this.A = null;
        this.B = null;
        this.f10213t = 0;
        this.E = false;
        this.f10215v = null;
        this.f10195b.clear();
        this.f10198e.a(this);
    }

    private int h() {
        return this.f10203j.ordinal();
    }

    private void i() {
        int i2 = AnonymousClass1.f10220a[this.f10212s.ordinal()];
        if (i2 == 1) {
            this.f10211r = a(Stage.INITIALIZE);
            this.C = j();
        } else if (i2 != 2) {
            if (i2 == 3) {
                n();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.f10212s);
        }
        k();
    }

    private e j() {
        int i2 = AnonymousClass1.f10221b[this.f10211r.ordinal()];
        if (i2 == 1) {
            return new t(this.f10194a, this);
        }
        if (i2 == 2) {
            return new b(this.f10194a, this);
        }
        if (i2 == 3) {
            return new w(this.f10194a, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.f10211r);
    }

    private void k() {
        this.f10216w = Thread.currentThread();
        this.f10213t = cc.g.a();
        boolean z2 = false;
        while (!this.E && this.C != null && !(z2 = this.C.a())) {
            this.f10211r = a(this.f10211r);
            this.C = j();
            if (this.f10211r == Stage.SOURCE) {
                c();
                return;
            }
        }
        if ((this.f10211r == Stage.FINISHED || this.E) && !z2) {
            l();
        }
    }

    private void l() {
        m();
        this.f10209p.a(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.f10195b)));
        f();
    }

    private void m() {
        Throwable th;
        this.f10196c.b();
        if (this.D) {
            if (this.f10195b.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.f10195b;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.D = true;
    }

    private void n() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.f10213t;
            a("Retrieved data", j2, "data: " + this.f10219z + ", cache key: " + this.f10217x + ", fetcher: " + this.B);
        }
        s<R> sVar = null;
        try {
            sVar = a(this.B, this.f10219z, this.A);
        } catch (GlideException e2) {
            e2.a(this.f10218y, this.A);
            this.f10195b.add(e2);
        }
        if (sVar != null) {
            b(sVar, this.A, this.F);
        } else {
            k();
        }
    }

    /* renamed from: a */
    public int compareTo(DecodeJob<?> decodeJob) {
        int h2 = h() - decodeJob.h();
        return h2 == 0 ? this.f10210q - decodeJob.f10210q : h2;
    }

    /* access modifiers changed from: package-private */
    public DecodeJob<R> a(com.bumptech.glide.e eVar, Object obj, l lVar, com.bumptech.glide.load.c cVar, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, h hVar, Map<Class<?>, i<?>> map, boolean z2, boolean z3, boolean z4, f fVar, a<R> aVar, int i4) {
        this.f10194a.a(eVar, obj, cVar, i2, i3, hVar, cls, cls2, priority, fVar, map, z2, z3, this.f10197d);
        this.f10201h = eVar;
        this.f10202i = cVar;
        this.f10203j = priority;
        this.f10204k = lVar;
        this.f10205l = i2;
        this.f10206m = i3;
        this.f10207n = hVar;
        this.f10214u = z4;
        this.f10208o = fVar;
        this.f10209p = aVar;
        this.f10210q = i4;
        this.f10212s = RunReason.INITIALIZE;
        this.f10215v = obj;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: com.bumptech.glide.load.engine.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.bumptech.glide.load.engine.u} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.bumptech.glide.load.engine.u} */
    /* JADX WARNING: type inference failed for: r12v5, types: [com.bumptech.glide.load.c] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> com.bumptech.glide.load.engine.s<Z> a(com.bumptech.glide.load.DataSource r12, com.bumptech.glide.load.engine.s<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.d()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.f<R> r0 = r11.f10194a
            com.bumptech.glide.load.i r0 = r0.c(r8)
            com.bumptech.glide.e r2 = r11.f10201h
            int r3 = r11.f10205l
            int r4 = r11.f10206m
            com.bumptech.glide.load.engine.s r2 = r0.a(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.f()
        L_0x002b:
            com.bumptech.glide.load.engine.f<R> r13 = r11.f10194a
            boolean r13 = r13.a((com.bumptech.glide.load.engine.s<?>) r0)
            if (r13 == 0) goto L_0x0040
            com.bumptech.glide.load.engine.f<R> r13 = r11.f10194a
            com.bumptech.glide.load.h r1 = r13.b(r0)
            com.bumptech.glide.load.f r13 = r11.f10208o
            com.bumptech.glide.load.EncodeStrategy r13 = r1.a(r13)
            goto L_0x0042
        L_0x0040:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
        L_0x0042:
            r10 = r1
            com.bumptech.glide.load.engine.f<R> r1 = r11.f10194a
            com.bumptech.glide.load.c r2 = r11.f10217x
            boolean r1 = r1.a((com.bumptech.glide.load.c) r2)
            r2 = 1
            r1 = r1 ^ r2
            com.bumptech.glide.load.engine.h r3 = r11.f10207n
            boolean r12 = r3.a(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.f10222c
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            com.bumptech.glide.load.engine.u r12 = new com.bumptech.glide.load.engine.u
            com.bumptech.glide.load.engine.f<R> r13 = r11.f10194a
            bl.b r2 = r13.i()
            com.bumptech.glide.load.c r3 = r11.f10217x
            com.bumptech.glide.load.c r4 = r11.f10202i
            int r5 = r11.f10205l
            int r6 = r11.f10206m
            com.bumptech.glide.load.f r9 = r11.f10208o
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            com.bumptech.glide.load.engine.c r12 = new com.bumptech.glide.load.engine.c
            com.bumptech.glide.load.c r13 = r11.f10217x
            com.bumptech.glide.load.c r1 = r11.f10202i
            r12.<init>(r13, r1)
        L_0x009b:
            com.bumptech.glide.load.engine.r r0 = com.bumptech.glide.load.engine.r.a(r0)
            com.bumptech.glide.load.engine.DecodeJob$c<?> r13 = r11.f10199f
            r13.a(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.d()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.a(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.s):com.bumptech.glide.load.engine.s");
    }

    public void a(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        dVar.b();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.a(cVar, dataSource, dVar.a());
        this.f10195b.add(glideException);
        if (Thread.currentThread() != this.f10216w) {
            this.f10212s = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.f10209p.a((DecodeJob<?>) this);
            return;
        }
        k();
    }

    public void a(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f10217x = cVar;
        this.f10219z = obj;
        this.B = dVar;
        this.A = dataSource;
        this.f10218y = cVar2;
        boolean z2 = false;
        if (cVar != this.f10194a.o().get(0)) {
            z2 = true;
        }
        this.F = z2;
        if (Thread.currentThread() != this.f10216w) {
            this.f10212s = RunReason.DECODE_DATA;
            this.f10209p.a((DecodeJob<?>) this);
            return;
        }
        cd.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            n();
        } finally {
            cd.b.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.f10200g.a(z2)) {
            g();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        Stage a2 = a(Stage.INITIALIZE);
        return a2 == Stage.RESOURCE_CACHE || a2 == Stage.DATA_CACHE;
    }

    public void b() {
        this.E = true;
        e eVar = this.C;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void c() {
        this.f10212s = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.f10209p.a((DecodeJob<?>) this);
    }

    public cd.c f_() {
        return this.f10196c;
    }

    public void run() {
        cd.b.a("DecodeJob#run(reason=%s, model=%s)", this.f10212s, this.f10215v);
        com.bumptech.glide.load.data.d<?> dVar = this.B;
        try {
            if (this.E) {
                l();
                if (dVar != null) {
                    dVar.b();
                }
                cd.b.a();
                return;
            }
            i();
            if (dVar != null) {
                dVar.b();
            }
            cd.b.a();
        } catch (CallbackException e2) {
            throw e2;
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.b();
            }
            cd.b.a();
            throw th;
        }
    }
}
