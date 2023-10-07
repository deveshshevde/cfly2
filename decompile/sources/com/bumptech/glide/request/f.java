package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import bz.i;
import bz.j;
import ca.b;
import cc.l;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class f<R> implements d<R>, g<R> {

    /* renamed from: a  reason: collision with root package name */
    private static final a f10599a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final int f10600b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10601c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10602d;

    /* renamed from: e  reason: collision with root package name */
    private final a f10603e;

    /* renamed from: f  reason: collision with root package name */
    private R f10604f;

    /* renamed from: g  reason: collision with root package name */
    private e f10605g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10606h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10607i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10608j;

    /* renamed from: k  reason: collision with root package name */
    private GlideException f10609k;

    static class a {
        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            obj.notifyAll();
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }
    }

    public f(int i2, int i3) {
        this(i2, i3, true, f10599a);
    }

    f(int i2, int i3, boolean z2, a aVar) {
        this.f10600b = i2;
        this.f10601c = i3;
        this.f10602d = z2;
        this.f10603e = aVar;
    }

    private synchronized R a(Long l2) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f10602d && !isDone()) {
            l.b();
        }
        if (this.f10606h) {
            throw new CancellationException();
        } else if (this.f10608j) {
            throw new ExecutionException(this.f10609k);
        } else if (this.f10607i) {
            return this.f10604f;
        } else {
            if (l2 == null) {
                this.f10603e.a(this, 0);
            } else if (l2.longValue() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long longValue = l2.longValue() + currentTimeMillis;
                while (!isDone() && currentTimeMillis < longValue) {
                    this.f10603e.a(this, longValue - currentTimeMillis);
                    currentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.f10608j) {
                throw new ExecutionException(this.f10609k);
            } else if (this.f10606h) {
                throw new CancellationException();
            } else if (this.f10607i) {
                return this.f10604f;
            } else {
                throw new TimeoutException();
            }
        }
    }

    public synchronized e a() {
        return this.f10605g;
    }

    public void a(Drawable drawable) {
    }

    public void a(i iVar) {
        iVar.a(this.f10600b, this.f10601c);
    }

    public synchronized void a(e eVar) {
        this.f10605g = eVar;
    }

    public synchronized void a(R r2, b<? super R> bVar) {
    }

    public synchronized void b(Drawable drawable) {
    }

    public void b(i iVar) {
    }

    public void c(Drawable drawable) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        if (r1 == null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r1.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x000a
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            return r3
        L_0x000a:
            r0 = 1
            r2.f10606h = r0     // Catch:{ all -> 0x0021 }
            com.bumptech.glide.request.f$a r1 = r2.f10603e     // Catch:{ all -> 0x0021 }
            r1.a(r2)     // Catch:{ all -> 0x0021 }
            r1 = 0
            if (r3 == 0) goto L_0x001a
            com.bumptech.glide.request.e r3 = r2.f10605g     // Catch:{ all -> 0x0021 }
            r2.f10605g = r1     // Catch:{ all -> 0x0021 }
            r1 = r3
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0020
            r1.b()
        L_0x0020:
            return r0
        L_0x0021:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0021 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.f.cancel(boolean):boolean");
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public R get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }

    public synchronized boolean isCancelled() {
        return this.f10606h;
    }

    public synchronized boolean isDone() {
        return this.f10606h || this.f10607i || this.f10608j;
    }

    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, j<R> jVar, boolean z2) {
        this.f10608j = true;
        this.f10609k = glideException;
        this.f10603e.a(this);
        return false;
    }

    public synchronized boolean onResourceReady(R r2, Object obj, j<R> jVar, DataSource dataSource, boolean z2) {
        this.f10607i = true;
        this.f10604f = r2;
        this.f10603e.a(this);
        return false;
    }

    public String toString() {
        e eVar;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            eVar = null;
            if (this.f10606h) {
                str = "CANCELLED";
            } else if (this.f10608j) {
                str = "FAILURE";
            } else if (this.f10607i) {
                str = "SUCCESS";
            } else {
                str = "PENDING";
                eVar = this.f10605g;
            }
        }
        if (eVar != null) {
            return str2 + str + ", request=[" + eVar + "]]";
        }
        return str2 + str + "]";
    }
}
