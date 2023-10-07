package fi;

import com.google.android.exoplayer2.util.a;
import fi.e;
import fi.f;
import java.lang.Exception;
import java.util.ArrayDeque;

public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f27313a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f27314b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<I> f27315c = new ArrayDeque<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayDeque<O> f27316d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    private final I[] f27317e;

    /* renamed from: f  reason: collision with root package name */
    private final O[] f27318f;

    /* renamed from: g  reason: collision with root package name */
    private int f27319g;

    /* renamed from: h  reason: collision with root package name */
    private int f27320h;

    /* renamed from: i  reason: collision with root package name */
    private I f27321i;

    /* renamed from: j  reason: collision with root package name */
    private E f27322j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f27323k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27324l;

    /* renamed from: m  reason: collision with root package name */
    private int f27325m;

    protected g(I[] iArr, O[] oArr) {
        this.f27317e = iArr;
        this.f27319g = iArr.length;
        for (int i2 = 0; i2 < this.f27319g; i2++) {
            this.f27317e[i2] = g();
        }
        this.f27318f = oArr;
        this.f27320h = oArr.length;
        for (int i3 = 0; i3 < this.f27320h; i3++) {
            this.f27318f[i3] = h();
        }
        AnonymousClass1 r4 = new Thread() {
            public void run() {
                g.this.k();
            }
        };
        this.f27313a = r4;
        r4.start();
    }

    private void b(I i2) {
        i2.clear();
        I[] iArr = this.f27317e;
        int i3 = this.f27319g;
        this.f27319g = i3 + 1;
        iArr[i3] = i2;
    }

    private void b(O o2) {
        o2.clear();
        O[] oArr = this.f27318f;
        int i2 = this.f27320h;
        this.f27320h = i2 + 1;
        oArr[i2] = o2;
    }

    private void i() throws Exception {
        E e2 = this.f27322j;
        if (e2 != null) {
            throw e2;
        }
    }

    private void j() {
        if (m()) {
            this.f27314b.notify();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        do {
            try {
            } catch (InterruptedException e2) {
                throw new IllegalStateException(e2);
            }
        } while (l());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r1.isEndOfStream() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        r3.addFlag(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r1.isDecodeOnly() == false) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r3.addFlag(Integer.MIN_VALUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r0 = a(r1, r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r0 = a(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean l() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f27314b
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.f27324l     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r6.m()     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r6.f27314b     // Catch:{ all -> 0x0089 }
            r1.wait()     // Catch:{ all -> 0x0089 }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r6.f27324l     // Catch:{ all -> 0x0089 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r2
        L_0x001a:
            java.util.ArrayDeque<I> r1 = r6.f27315c     // Catch:{ all -> 0x0089 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0089 }
            fi.e r1 = (fi.e) r1     // Catch:{ all -> 0x0089 }
            O[] r3 = r6.f27318f     // Catch:{ all -> 0x0089 }
            int r4 = r6.f27320h     // Catch:{ all -> 0x0089 }
            r5 = 1
            int r4 = r4 - r5
            r6.f27320h = r4     // Catch:{ all -> 0x0089 }
            r3 = r3[r4]     // Catch:{ all -> 0x0089 }
            boolean r4 = r6.f27323k     // Catch:{ all -> 0x0089 }
            r6.f27323k = r2     // Catch:{ all -> 0x0089 }
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            boolean r0 = r1.isEndOfStream()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.addFlag(r0)
            goto L_0x005f
        L_0x003c:
            boolean r0 = r1.isDecodeOnly()
            if (r0 == 0) goto L_0x0047
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlag(r0)
        L_0x0047:
            java.lang.Exception r0 = r6.a(r1, r3, r4)     // Catch:{ RuntimeException -> 0x004e, OutOfMemoryError -> 0x004c }
            goto L_0x0053
        L_0x004c:
            r0 = move-exception
            goto L_0x004f
        L_0x004e:
            r0 = move-exception
        L_0x004f:
            java.lang.Exception r0 = r6.a((java.lang.Throwable) r0)
        L_0x0053:
            if (r0 == 0) goto L_0x005f
            java.lang.Object r4 = r6.f27314b
            monitor-enter(r4)
            r6.f27322j = r0     // Catch:{ all -> 0x005c }
            monitor-exit(r4)     // Catch:{ all -> 0x005c }
            return r2
        L_0x005c:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x005c }
            throw r0
        L_0x005f:
            java.lang.Object r4 = r6.f27314b
            monitor-enter(r4)
            boolean r0 = r6.f27323k     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x006a
        L_0x0066:
            r3.release()     // Catch:{ all -> 0x0086 }
            goto L_0x0081
        L_0x006a:
            boolean r0 = r3.isDecodeOnly()     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x0076
            int r0 = r6.f27325m     // Catch:{ all -> 0x0086 }
            int r0 = r0 + r5
            r6.f27325m = r0     // Catch:{ all -> 0x0086 }
            goto L_0x0066
        L_0x0076:
            int r0 = r6.f27325m     // Catch:{ all -> 0x0086 }
            r3.skippedOutputBufferCount = r0     // Catch:{ all -> 0x0086 }
            r6.f27325m = r2     // Catch:{ all -> 0x0086 }
            java.util.ArrayDeque<O> r0 = r6.f27316d     // Catch:{ all -> 0x0086 }
            r0.addLast(r3)     // Catch:{ all -> 0x0086 }
        L_0x0081:
            r6.b(r1)     // Catch:{ all -> 0x0086 }
            monitor-exit(r4)     // Catch:{ all -> 0x0086 }
            return r5
        L_0x0086:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0086 }
            throw r0
        L_0x0089:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            goto L_0x008d
        L_0x008c:
            throw r1
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: fi.g.l():boolean");
    }

    private boolean m() {
        return !this.f27315c.isEmpty() && this.f27320h > 0;
    }

    /* access modifiers changed from: protected */
    public abstract E a(I i2, O o2, boolean z2);

    /* access modifiers changed from: protected */
    public abstract E a(Throwable th);

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        a.b(this.f27319g == this.f27317e.length);
        for (I b2 : this.f27317e) {
            b2.b(i2);
        }
    }

    public final void a(I i2) throws Exception {
        synchronized (this.f27314b) {
            i();
            a.a(i2 == this.f27321i);
            this.f27315c.addLast(i2);
            j();
            this.f27321i = null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(O o2) {
        synchronized (this.f27314b) {
            b(o2);
            j();
        }
    }

    public final void c() {
        synchronized (this.f27314b) {
            this.f27323k = true;
            this.f27325m = 0;
            I i2 = this.f27321i;
            if (i2 != null) {
                b(i2);
                this.f27321i = null;
            }
            while (!this.f27315c.isEmpty()) {
                b((e) this.f27315c.removeFirst());
            }
            while (!this.f27316d.isEmpty()) {
                ((f) this.f27316d.removeFirst()).release();
            }
            this.f27322j = null;
        }
    }

    public void d() {
        synchronized (this.f27314b) {
            this.f27324l = true;
            this.f27314b.notify();
        }
        try {
            this.f27313a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* renamed from: e */
    public final I a() throws Exception {
        I i2;
        synchronized (this.f27314b) {
            i();
            a.b(this.f27321i == null);
            int i3 = this.f27319g;
            if (i3 == 0) {
                i2 = null;
            } else {
                I[] iArr = this.f27317e;
                int i4 = i3 - 1;
                this.f27319g = i4;
                i2 = iArr[i4];
            }
            this.f27321i = i2;
        }
        return i2;
    }

    /* renamed from: f */
    public final O b() throws Exception {
        synchronized (this.f27314b) {
            i();
            if (this.f27316d.isEmpty()) {
                return null;
            }
            O o2 = (f) this.f27316d.removeFirst();
            return o2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract I g();

    /* access modifiers changed from: protected */
    public abstract O h();
}
