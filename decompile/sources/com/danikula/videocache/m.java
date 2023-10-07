package com.danikula.videocache;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;

class m {

    /* renamed from: a  reason: collision with root package name */
    private final o f11082a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11083b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f11084c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f11085d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f11086e;

    /* renamed from: f  reason: collision with root package name */
    private volatile Thread f11087f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f11088g;

    /* renamed from: h  reason: collision with root package name */
    private volatile int f11089h = -1;

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            m.this.e();
        }
    }

    public m(o oVar, a aVar) {
        this.f11082a = (o) l.a(oVar);
        this.f11083b = (a) l.a(aVar);
        this.f11086e = new AtomicInteger();
    }

    private void b() throws ProxyCacheException {
        int i2 = this.f11086e.get();
        if (i2 >= 1) {
            this.f11086e.set(0);
            throw new ProxyCacheException("Error reading source " + i2 + " times");
        }
    }

    private void b(long j2, long j3) {
        a(j2, j3);
        synchronized (this.f11084c) {
            this.f11084c.notifyAll();
        }
    }

    private synchronized void c() throws ProxyCacheException {
        boolean z2 = (this.f11087f == null || this.f11087f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.f11088g && !this.f11083b.d() && !z2) {
            a aVar = new a();
            this.f11087f = new Thread(aVar, "Source reader for " + this.f11082a);
            this.f11087f.start();
        }
    }

    private void d() throws ProxyCacheException {
        synchronized (this.f11084c) {
            try {
                this.f11084c.wait(1000);
            } catch (InterruptedException e2) {
                throw new ProxyCacheException("Waiting source data is interrupted!", e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        r2 = r2 + ((long) r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r8 = this;
            r0 = -1
            r2 = 0
            com.danikula.videocache.a r4 = r8.f11083b     // Catch:{ all -> 0x0049 }
            long r2 = r4.a()     // Catch:{ all -> 0x0049 }
            com.danikula.videocache.o r4 = r8.f11082a     // Catch:{ all -> 0x0049 }
            r4.a((long) r2)     // Catch:{ all -> 0x0049 }
            com.danikula.videocache.o r4 = r8.f11082a     // Catch:{ all -> 0x0049 }
            long r0 = r4.a()     // Catch:{ all -> 0x0049 }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0049 }
        L_0x0019:
            com.danikula.videocache.o r5 = r8.f11082a     // Catch:{ all -> 0x0049 }
            int r5 = r5.a((byte[]) r4)     // Catch:{ all -> 0x0049 }
            r6 = -1
            if (r5 == r6) goto L_0x0042
            java.lang.Object r6 = r8.f11085d     // Catch:{ all -> 0x0049 }
            monitor-enter(r6)     // Catch:{ all -> 0x0049 }
            boolean r7 = r8.h()     // Catch:{ all -> 0x003f }
            if (r7 == 0) goto L_0x0033
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            r8.i()
            r8.b(r2, r0)
            return
        L_0x0033:
            com.danikula.videocache.a r7 = r8.f11083b     // Catch:{ all -> 0x003f }
            r7.a(r4, r5)     // Catch:{ all -> 0x003f }
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            long r5 = (long) r5
            long r2 = r2 + r5
            r8.b(r2, r0)     // Catch:{ all -> 0x0049 }
            goto L_0x0019
        L_0x003f:
            r4 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x003f }
            throw r4     // Catch:{ all -> 0x0049 }
        L_0x0042:
            r8.g()     // Catch:{ all -> 0x0049 }
            r8.f()     // Catch:{ all -> 0x0049 }
            goto L_0x0052
        L_0x0049:
            r4 = move-exception
            java.util.concurrent.atomic.AtomicInteger r5 = r8.f11086e     // Catch:{ all -> 0x0059 }
            r5.incrementAndGet()     // Catch:{ all -> 0x0059 }
            r8.a((java.lang.Throwable) r4)     // Catch:{ all -> 0x0059 }
        L_0x0052:
            r8.i()
            r8.b(r2, r0)
            return
        L_0x0059:
            r4 = move-exception
            r8.i()
            r8.b(r2, r0)
            goto L_0x0062
        L_0x0061:
            throw r4
        L_0x0062:
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danikula.videocache.m.e():void");
    }

    private void f() {
        this.f11089h = 100;
        a(this.f11089h);
    }

    private void g() throws ProxyCacheException {
        synchronized (this.f11085d) {
            if (!h() && this.f11083b.a() == this.f11082a.a()) {
                this.f11083b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.f11088g;
    }

    private void i() {
        try {
            this.f11082a.b();
        } catch (ProxyCacheException e2) {
            a((Throwable) new ProxyCacheException("Error closing source " + this.f11082a, e2));
        }
    }

    public int a(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        n.a(bArr, j2, i2);
        while (!this.f11083b.d() && this.f11083b.a() < ((long) i2) + j2 && !this.f11088g) {
            c();
            d();
            b();
        }
        int a2 = this.f11083b.a(bArr, j2, i2);
        if (this.f11083b.d() && this.f11089h != 100) {
            this.f11089h = 100;
            a(100);
        }
        return a2;
    }

    public void a() {
        synchronized (this.f11085d) {
            try {
                this.f11088g = true;
                if (this.f11087f != null) {
                    this.f11087f.interrupt();
                }
                this.f11083b.b();
            } catch (ProxyCacheException e2) {
                a((Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
    }

    /* access modifiers changed from: protected */
    public void a(long j2, long j3) {
        boolean z2 = true;
        int i2 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1)) == 0 ? 100 : (int) ((((float) j2) / ((float) j3)) * 100.0f);
        boolean z3 = i2 != this.f11089h;
        if (j3 < 0) {
            z2 = false;
        }
        if (z2 && z3) {
            a(i2);
        }
        this.f11089h = i2;
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        if (th instanceof InterruptedProxyCacheException) {
            f.a("ProxyCache is interrupted");
        } else {
            f.c("ProxyCache error", th.getMessage());
        }
    }
}
