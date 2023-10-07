package com.bumptech.glide.load.engine;

import cc.k;
import cd.a;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.request.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import s.e;

class j<R> implements a.c, DecodeJob.a<R> {

    /* renamed from: e  reason: collision with root package name */
    private static final c f10332e = new c();

    /* renamed from: a  reason: collision with root package name */
    final e f10333a;

    /* renamed from: b  reason: collision with root package name */
    DataSource f10334b;

    /* renamed from: c  reason: collision with root package name */
    GlideException f10335c;

    /* renamed from: d  reason: collision with root package name */
    n<?> f10336d;

    /* renamed from: f  reason: collision with root package name */
    private final cd.c f10337f;

    /* renamed from: g  reason: collision with root package name */
    private final n.a f10338g;

    /* renamed from: h  reason: collision with root package name */
    private final e.a<j<?>> f10339h;

    /* renamed from: i  reason: collision with root package name */
    private final c f10340i;

    /* renamed from: j  reason: collision with root package name */
    private final k f10341j;

    /* renamed from: k  reason: collision with root package name */
    private final bn.a f10342k;

    /* renamed from: l  reason: collision with root package name */
    private final bn.a f10343l;

    /* renamed from: m  reason: collision with root package name */
    private final bn.a f10344m;

    /* renamed from: n  reason: collision with root package name */
    private final bn.a f10345n;

    /* renamed from: o  reason: collision with root package name */
    private final AtomicInteger f10346o;

    /* renamed from: p  reason: collision with root package name */
    private com.bumptech.glide.load.c f10347p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10348q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10349r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10350s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f10351t;

    /* renamed from: u  reason: collision with root package name */
    private s<?> f10352u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f10353v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10354w;

    /* renamed from: x  reason: collision with root package name */
    private DecodeJob<R> f10355x;

    /* renamed from: y  reason: collision with root package name */
    private volatile boolean f10356y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f10357z;

    private class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final i f10359b;

        a(i iVar) {
            this.f10359b = iVar;
        }

        public void run() {
            synchronized (this.f10359b.h()) {
                synchronized (j.this) {
                    if (j.this.f10333a.b(this.f10359b)) {
                        j.this.b(this.f10359b);
                    }
                    j.this.e();
                }
            }
        }
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final i f10361b;

        b(i iVar) {
            this.f10361b = iVar;
        }

        public void run() {
            synchronized (this.f10361b.h()) {
                synchronized (j.this) {
                    if (j.this.f10333a.b(this.f10361b)) {
                        j.this.f10336d.g();
                        j.this.a(this.f10361b);
                        j.this.c(this.f10361b);
                    }
                    j.this.e();
                }
            }
        }
    }

    static class c {
        c() {
        }

        public <R> n<R> a(s<R> sVar, boolean z2, com.bumptech.glide.load.c cVar, n.a aVar) {
            return new n(sVar, z2, true, cVar, aVar);
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        final i f10362a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f10363b;

        d(i iVar, Executor executor) {
            this.f10362a = iVar;
            this.f10363b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f10362a.equals(((d) obj).f10362a);
            }
            return false;
        }

        public int hashCode() {
            return this.f10362a.hashCode();
        }
    }

    static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        private final List<d> f10364a;

        e() {
            this(new ArrayList(2));
        }

        e(List<d> list) {
            this.f10364a = list;
        }

        private static d c(i iVar) {
            return new d(iVar, cc.e.b());
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar) {
            this.f10364a.remove(c(iVar));
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar, Executor executor) {
            this.f10364a.add(new d(iVar, executor));
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f10364a.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f10364a.size();
        }

        /* access modifiers changed from: package-private */
        public boolean b(i iVar) {
            return this.f10364a.contains(c(iVar));
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f10364a.clear();
        }

        /* access modifiers changed from: package-private */
        public e d() {
            return new e(new ArrayList(this.f10364a));
        }

        public Iterator<d> iterator() {
            return this.f10364a.iterator();
        }
    }

    j(bn.a aVar, bn.a aVar2, bn.a aVar3, bn.a aVar4, k kVar, n.a aVar5, e.a<j<?>> aVar6) {
        this(aVar, aVar2, aVar3, aVar4, kVar, aVar5, aVar6, f10332e);
    }

    j(bn.a aVar, bn.a aVar2, bn.a aVar3, bn.a aVar4, k kVar, n.a aVar5, e.a<j<?>> aVar6, c cVar) {
        this.f10333a = new e();
        this.f10337f = cd.c.a();
        this.f10346o = new AtomicInteger();
        this.f10342k = aVar;
        this.f10343l = aVar2;
        this.f10344m = aVar3;
        this.f10345n = aVar4;
        this.f10341j = kVar;
        this.f10338g = aVar5;
        this.f10339h = aVar6;
        this.f10340i = cVar;
    }

    private bn.a g() {
        return this.f10349r ? this.f10344m : this.f10350s ? this.f10345n : this.f10343l;
    }

    private boolean h() {
        return this.f10354w || this.f10353v || this.f10356y;
    }

    private synchronized void i() {
        if (this.f10347p != null) {
            this.f10333a.c();
            this.f10347p = null;
            this.f10336d = null;
            this.f10352u = null;
            this.f10354w = false;
            this.f10356y = false;
            this.f10353v = false;
            this.f10357z = false;
            this.f10355x.a(false);
            this.f10355x = null;
            this.f10335c = null;
            this.f10334b = null;
            this.f10339h.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized j<R> a(com.bumptech.glide.load.c cVar, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f10347p = cVar;
        this.f10348q = z2;
        this.f10349r = z3;
        this.f10350s = z4;
        this.f10351t = z5;
        return this;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(int i2) {
        n<?> nVar;
        k.a(h(), "Not yet complete!");
        if (this.f10346o.getAndAdd(i2) == 0 && (nVar = this.f10336d) != null) {
            nVar.g();
        }
    }

    public void a(DecodeJob<?> decodeJob) {
        g().execute(decodeJob);
    }

    public void a(GlideException glideException) {
        synchronized (this) {
            this.f10335c = glideException;
        }
        f();
    }

    public void a(s<R> sVar, DataSource dataSource, boolean z2) {
        synchronized (this) {
            this.f10352u = sVar;
            this.f10334b = dataSource;
            this.f10357z = z2;
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        try {
            iVar.a(this.f10336d, this.f10334b, this.f10357z);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(i iVar, Executor executor) {
        Runnable aVar;
        this.f10337f.b();
        this.f10333a.a(iVar, executor);
        boolean z2 = true;
        if (this.f10353v) {
            a(1);
            aVar = new b(iVar);
        } else if (this.f10354w) {
            a(1);
            aVar = new a(iVar);
        } else {
            if (this.f10356y) {
                z2 = false;
            }
            k.a(z2, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(aVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f10351t;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!h()) {
            this.f10356y = true;
            this.f10355x.b();
            this.f10341j.a(this, this.f10347p);
        }
    }

    public synchronized void b(DecodeJob<R> decodeJob) {
        this.f10355x = decodeJob;
        (decodeJob.a() ? this.f10342k : g()).execute(decodeJob);
    }

    /* access modifiers changed from: package-private */
    public void b(i iVar) {
        try {
            iVar.a(this.f10335c);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r5.f10341j.a(r5, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (r0.hasNext() == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
        r1 = r0.next();
        r1.f10363b.execute(new com.bumptech.glide.load.engine.j.b(r5, r1.f10362a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0068, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c() {
        /*
            r5 = this;
            monitor-enter(r5)
            cd.c r0 = r5.f10337f     // Catch:{ all -> 0x007c }
            r0.b()     // Catch:{ all -> 0x007c }
            boolean r0 = r5.f10356y     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0014
            com.bumptech.glide.load.engine.s<?> r0 = r5.f10352u     // Catch:{ all -> 0x007c }
            r0.f()     // Catch:{ all -> 0x007c }
            r5.i()     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            return
        L_0x0014:
            com.bumptech.glide.load.engine.j$e r0 = r5.f10333a     // Catch:{ all -> 0x007c }
            boolean r0 = r0.a()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x0074
            boolean r0 = r5.f10353v     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x006c
            com.bumptech.glide.load.engine.j$c r0 = r5.f10340i     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.s<?> r1 = r5.f10352u     // Catch:{ all -> 0x007c }
            boolean r2 = r5.f10348q     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.c r3 = r5.f10347p     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.n$a r4 = r5.f10338g     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.n r0 = r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x007c }
            r5.f10336d = r0     // Catch:{ all -> 0x007c }
            r0 = 1
            r5.f10353v = r0     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.j$e r1 = r5.f10333a     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.j$e r1 = r1.d()     // Catch:{ all -> 0x007c }
            int r2 = r1.b()     // Catch:{ all -> 0x007c }
            int r2 = r2 + r0
            r5.a((int) r2)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.c r0 = r5.f10347p     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.n<?> r2 = r5.f10336d     // Catch:{ all -> 0x007c }
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            com.bumptech.glide.load.engine.k r3 = r5.f10341j
            r3.a(r5, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x004f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.j$d r1 = (com.bumptech.glide.load.engine.j.d) r1
            java.util.concurrent.Executor r2 = r1.f10363b
            com.bumptech.glide.load.engine.j$b r3 = new com.bumptech.glide.load.engine.j$b
            com.bumptech.glide.request.i r1 = r1.f10362a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x004f
        L_0x0068:
            r5.e()
            return
        L_0x006c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x0074:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x007c }
        L_0x007c:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x007c }
            goto L_0x0080
        L_0x007f:
            throw r0
        L_0x0080:
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.j.c():void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void c(i iVar) {
        boolean z2;
        this.f10337f.b();
        this.f10333a.a(iVar);
        if (this.f10333a.a()) {
            b();
            if (!this.f10353v) {
                if (!this.f10354w) {
                    z2 = false;
                    if (z2 && this.f10346o.get() == 0) {
                        i();
                    }
                }
            }
            z2 = true;
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        n<?> nVar;
        synchronized (this) {
            this.f10337f.b();
            k.a(h(), "Not yet complete!");
            int decrementAndGet = this.f10346o.decrementAndGet();
            k.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                nVar = this.f10336d;
                i();
            } else {
                nVar = null;
            }
        }
        if (nVar != null) {
            nVar.h();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.f10341j.a(r4, r1, (com.bumptech.glide.load.engine.n<?>) null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = r0.next();
        r1.f10363b.execute(new com.bumptech.glide.load.engine.j.a(r4, r1.f10362a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r4 = this;
            monitor-enter(r4)
            cd.c r0 = r4.f10337f     // Catch:{ all -> 0x0066 }
            r0.b()     // Catch:{ all -> 0x0066 }
            boolean r0 = r4.f10356y     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000f
            r4.i()     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return
        L_0x000f:
            com.bumptech.glide.load.engine.j$e r0 = r4.f10333a     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x005e
            boolean r0 = r4.f10354w     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0056
            r0 = 1
            r4.f10354w = r0     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.c r1 = r4.f10347p     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.j$e r2 = r4.f10333a     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.j$e r2 = r2.d()     // Catch:{ all -> 0x0066 }
            int r3 = r2.b()     // Catch:{ all -> 0x0066 }
            int r3 = r3 + r0
            r4.a((int) r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.k r0 = r4.f10341j
            r3 = 0
            r0.a(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x0039:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.j$d r1 = (com.bumptech.glide.load.engine.j.d) r1
            java.util.concurrent.Executor r2 = r1.f10363b
            com.bumptech.glide.load.engine.j$a r3 = new com.bumptech.glide.load.engine.j$a
            com.bumptech.glide.request.i r1 = r1.f10362a
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0039
        L_0x0052:
            r4.e()
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            goto L_0x006a
        L_0x0069:
            throw r0
        L_0x006a:
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.j.f():void");
    }

    public cd.c f_() {
        return this.f10337f;
    }
}
