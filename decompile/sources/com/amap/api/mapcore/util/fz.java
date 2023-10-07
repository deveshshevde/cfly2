package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Looper;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class fz extends fw implements Thread.UncaughtExceptionHandler {

    /* renamed from: e  reason: collision with root package name */
    private static ExecutorService f8876e;

    /* renamed from: f  reason: collision with root package name */
    private static Set<Integer> f8877f = Collections.synchronizedSet(new HashSet());

    /* renamed from: g  reason: collision with root package name */
    private static WeakReference<Context> f8878g;

    /* renamed from: h  reason: collision with root package name */
    private static final ThreadFactory f8879h = new ThreadFactory() {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f8884a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pama#" + this.f8884a.getAndIncrement()) {
                public final void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                    }
                }
            };
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f8880d;

    private fz(Context context) {
        this.f8880d = context;
        try {
            this.f8858b = Thread.getDefaultUncaughtExceptionHandler();
            if (this.f8858b == null) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f8859c = true;
                return;
            }
            String obj = this.f8858b.toString();
            if (obj.startsWith("com.amap.apis.utils.core.dynamiccore") || (obj.indexOf("com.amap.api") == -1 && obj.indexOf("com.loc") == -1)) {
                Thread.setDefaultUncaughtExceptionHandler(this);
                this.f8859c = true;
                return;
            }
            this.f8859c = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized fz a(Context context, ff ffVar) throws eu {
        synchronized (fz.class) {
            if (ffVar != null) {
                try {
                    if (ffVar.a() == null || "".equals(ffVar.a())) {
                        throw new eu("sdk name is invalid");
                    } else if (!f8877f.add(Integer.valueOf(ffVar.hashCode()))) {
                        fz fzVar = (fz) fw.f8857a;
                        return fzVar;
                    } else {
                        if (fw.f8857a == null) {
                            fw.f8857a = new fz(context);
                        } else {
                            fw.f8857a.f8859c = false;
                        }
                        fw.f8857a.a(ffVar, fw.f8857a.f8859c);
                        fz fzVar2 = (fz) fw.f8857a;
                        return fzVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new eu("sdk info is null");
            }
        }
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                f8878g = new WeakReference<>(context.getApplicationContext());
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, ff ffVar, String str, String str2, String str3) {
        ga.a(context, ffVar, str, 0, str2, str3);
    }

    public static void a(ff ffVar, String str, eu euVar) {
        a(ffVar, str, euVar.c(), euVar.d(), euVar.e(), euVar.b());
    }

    public static void a(ff ffVar, String str, String str2, String str3, String str4, String str5) {
        try {
            if (fw.f8857a != null) {
                fw.f8857a.a(ffVar, "path:" + str + ",type:" + str2 + ",gsid:" + str3 + ",csid:" + str4 + ",code:" + str5, "networkError");
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized void b() {
        synchronized (fz.class) {
            try {
                ExecutorService executorService = f8876e;
                if (executorService != null) {
                    executorService.shutdown();
                }
                gt.a();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (!(fw.f8857a == null || Thread.getDefaultUncaughtExceptionHandler() != fw.f8857a || fw.f8857a.f8858b == null)) {
                    Thread.setDefaultUncaughtExceptionHandler(fw.f8857a.f8858b);
                }
                fw.f8857a = null;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        return;
    }

    public static void b(Context context, ff ffVar, String str, String str2, String str3) {
        ga.a(context, ffVar, str, 1, str2, str3);
    }

    public static void b(ff ffVar, String str, String str2) {
        try {
            if (fw.f8857a != null) {
                fw.f8857a.a(ffVar, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        WeakReference<Context> weakReference = f8878g;
        if (weakReference != null && weakReference.get() != null) {
            fx.a((Context) f8878g.get());
        } else if (fw.f8857a != null) {
            fw.f8857a.a();
        }
    }

    public static void c(Throwable th, String str, String str2) {
        try {
            if (fw.f8857a != null) {
                fw.f8857a.a(th, 1, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0024 */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.util.concurrent.ExecutorService d() {
        /*
            java.lang.Class<com.amap.api.mapcore.util.fz> r0 = com.amap.api.mapcore.util.fz.class
            monitor-enter(r0)
            java.util.concurrent.ExecutorService r1 = f8876e     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x000d
            boolean r1 = r1.isShutdown()     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x0024
        L_0x000d:
            java.util.concurrent.ThreadPoolExecutor r1 = new java.util.concurrent.ThreadPoolExecutor     // Catch:{ all -> 0x0024 }
            r3 = 1
            r4 = 1
            r5 = 0
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0024 }
            java.util.concurrent.LinkedBlockingQueue r8 = new java.util.concurrent.LinkedBlockingQueue     // Catch:{ all -> 0x0024 }
            r2 = 256(0x100, float:3.59E-43)
            r8.<init>(r2)     // Catch:{ all -> 0x0024 }
            java.util.concurrent.ThreadFactory r9 = f8879h     // Catch:{ all -> 0x0024 }
            r2 = r1
            r2.<init>(r3, r4, r5, r7, r8, r9)     // Catch:{ all -> 0x0024 }
            f8876e = r1     // Catch:{ all -> 0x0024 }
        L_0x0024:
            java.util.concurrent.ExecutorService r1 = f8876e     // Catch:{ all -> 0x0028 }
            monitor-exit(r0)
            return r1
        L_0x0028:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.fz.d():java.util.concurrent.ExecutorService");
    }

    public static synchronized fz e() {
        fz fzVar;
        synchronized (fz.class) {
            fzVar = (fz) fw.f8857a;
        }
        return fzVar;
    }

    /* access modifiers changed from: protected */
    public final void a() {
        fx.a(this.f8880d);
    }

    /* access modifiers changed from: protected */
    public final void a(ff ffVar, String str, String str2) {
        ga.a(ffVar, this.f8880d, str2, str);
    }

    /* access modifiers changed from: protected */
    public final void a(final ff ffVar, final boolean z2) {
        try {
            id.a().a(new ie() {
                public final void runTask() {
                    try {
                        synchronized (Looper.getMainLooper()) {
                            fx.a(ffVar);
                        }
                        if (z2) {
                            ga.a(fz.this.f8880d);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th, int i2, String str, String str2) {
        ga.a(this.f8880d, th, i2, str, str2);
    }

    public final void b(Throwable th, String str, String str2) {
        try {
            a(th, 1, str, str2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            a(th, 0, (String) null, (String) null);
            if (this.f8858b != null) {
                try {
                    Thread.setDefaultUncaughtExceptionHandler(this.f8858b);
                } catch (Throwable unused) {
                }
                this.f8858b.uncaughtException(thread, th);
            }
        }
    }
}
