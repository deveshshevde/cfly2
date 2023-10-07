package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.ie;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.amap.api.mapcore.util.if  reason: invalid class name */
public abstract class Cif {

    /* renamed from: a  reason: collision with root package name */
    protected ThreadPoolExecutor f9223a;

    /* renamed from: b  reason: collision with root package name */
    protected ie.a f9224b = new ie.a() {
        public final void a(ie ieVar) {
            Cif.this.a(ieVar, false);
        }

        public final void b(ie ieVar) {
            Cif.this.a(ieVar, true);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<ie, Future<?>> f9225c = new ConcurrentHashMap<>();

    private synchronized void a(ie ieVar, Future<?> future) {
        try {
            this.f9225c.put(ieVar, future);
        } catch (Throwable th) {
            fz.c(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    private synchronized boolean b(ie ieVar) {
        boolean z2;
        try {
            z2 = this.f9225c.containsKey(ieVar);
        } catch (Throwable th) {
            fz.c(th, "TPool", "contain");
            th.printStackTrace();
            z2 = false;
        }
        return z2;
    }

    public final void a(long j2, TimeUnit timeUnit) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f9223a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j2, timeUnit);
            }
        } catch (InterruptedException unused) {
        }
    }

    public final void a(ie ieVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (!b(ieVar) && (threadPoolExecutor = this.f9223a) != null && !threadPoolExecutor.isShutdown()) {
            ieVar.f9222f = this.f9224b;
            try {
                Future submit = this.f9223a.submit(ieVar);
                if (submit != null) {
                    a(ieVar, (Future<?>) submit);
                }
            } catch (RejectedExecutionException e2) {
                fz.c(e2, "TPool", "addTask");
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void a(ie ieVar, boolean z2) {
        try {
            Future remove = this.f9225c.remove(ieVar);
            if (z2 && remove != null) {
                remove.cancel(true);
            }
        } catch (Throwable th) {
            fz.c(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void c() {
        try {
            for (Map.Entry<ie, Future<?>> key : this.f9225c.entrySet()) {
                Future future = this.f9225c.get((ie) key.getKey());
                if (future != null) {
                    future.cancel(true);
                }
            }
            this.f9225c.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            fz.c(th, "TPool", "destroy");
            th.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.f9223a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }
}
