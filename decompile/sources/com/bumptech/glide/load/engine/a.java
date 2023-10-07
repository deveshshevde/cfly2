package com.bumptech.glide.load.engine;

import android.os.Process;
import cc.k;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.n;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final Map<c, b> f10251a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10252b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f10253c;

    /* renamed from: d  reason: collision with root package name */
    private final ReferenceQueue<n<?>> f10254d;

    /* renamed from: e  reason: collision with root package name */
    private n.a f10255e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f10256f;

    /* renamed from: g  reason: collision with root package name */
    private volatile C0081a f10257g;

    /* renamed from: com.bumptech.glide.load.engine.a$a  reason: collision with other inner class name */
    interface C0081a {
        void a();
    }

    static final class b extends WeakReference<n<?>> {

        /* renamed from: a  reason: collision with root package name */
        final c f10261a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f10262b;

        /* renamed from: c  reason: collision with root package name */
        s<?> f10263c;

        b(c cVar, n<?> nVar, ReferenceQueue<? super n<?>> referenceQueue, boolean z2) {
            super(nVar, referenceQueue);
            this.f10261a = (c) k.a(cVar);
            this.f10263c = (!nVar.b() || !z2) ? null : (s) k.a(nVar.a());
            this.f10262b = nVar.b();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f10263c = null;
            clear();
        }
    }

    a(boolean z2) {
        this(z2, Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    a(boolean z2, Executor executor) {
        this.f10251a = new HashMap();
        this.f10254d = new ReferenceQueue<>();
        this.f10252b = z2;
        this.f10253c = executor;
        executor.execute(new Runnable() {
            public void run() {
                a.this.a();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void a() {
        while (!this.f10256f) {
            try {
                a((b) this.f10254d.remove());
                C0081a aVar = this.f10257g;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(c cVar) {
        b remove = this.f10251a.remove(cVar);
        if (remove != null) {
            remove.a();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(c cVar, n<?> nVar) {
        b put = this.f10251a.put(cVar, new b(cVar, nVar, this.f10254d, this.f10252b));
        if (put != null) {
            put.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        synchronized (this) {
            this.f10251a.remove(bVar.f10261a);
            if (bVar.f10262b) {
                if (bVar.f10263c != null) {
                    this.f10255e.a(bVar.f10261a, new n(bVar.f10263c, true, false, bVar.f10261a, this.f10255e));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(n.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f10255e = aVar;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.n<?> b(com.bumptech.glide.load.c r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<com.bumptech.glide.load.c, com.bumptech.glide.load.engine.a$b> r0 = r1.f10251a     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.a$b r2 = (com.bumptech.glide.load.engine.a.b) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.n r0 = (com.bumptech.glide.load.engine.n) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.a((com.bumptech.glide.load.engine.a.b) r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.a.b(com.bumptech.glide.load.c):com.bumptech.glide.load.engine.n");
    }
}
