package com.lidroid.xutils.task;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class b<Params, Progress, Result> {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f21141a = new c();

    /* renamed from: b  reason: collision with root package name */
    private static final C0138b f21142b = new C0138b((C0138b) null);

    /* renamed from: c  reason: collision with root package name */
    private final c<Params, Result> f21143c;

    /* renamed from: d  reason: collision with root package name */
    private final FutureTask<Result> f21144d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f21145e = false;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f21146f = new AtomicBoolean();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f21147g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    private Priority f21148h;

    private static class a<Data> {

        /* renamed from: a  reason: collision with root package name */
        final b f21151a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f21152b;

        a(b bVar, Data... dataArr) {
            this.f21151a = bVar;
            this.f21152b = dataArr;
        }
    }

    /* renamed from: com.lidroid.xutils.task.b$b  reason: collision with other inner class name */
    private static class C0138b extends Handler {
        private C0138b() {
            super(Looper.getMainLooper());
        }

        /* synthetic */ C0138b(C0138b bVar) {
            this();
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.f21151a.e(aVar.f21152b[0]);
            } else if (i2 == 2) {
                aVar.f21151a.b((Progress[]) aVar.f21152b);
            }
        }
    }

    private static abstract class c<Params, Result> implements Callable<Result> {

        /* renamed from: b  reason: collision with root package name */
        Params[] f21153b;

        private c() {
        }

        /* synthetic */ c(c cVar) {
            this();
        }
    }

    public b() {
        AnonymousClass1 r0 = new c<Params, Result>() {
            public Result call() throws Exception {
                b.this.f21147g.set(true);
                Process.setThreadPriority(10);
                b bVar = b.this;
                return bVar.d(bVar.c((Params[]) this.f21153b));
            }
        };
        this.f21143c = r0;
        this.f21144d = new FutureTask<Result>(r0) {
            /* access modifiers changed from: protected */
            public void done() {
                try {
                    b.this.c(get());
                } catch (InterruptedException e2) {
                    il.c.a(e2.getMessage());
                } catch (ExecutionException e3) {
                    throw new RuntimeException("An error occured while executing doInBackground()", e3.getCause());
                } catch (CancellationException unused) {
                    b.this.c(null);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void c(Result result) {
        if (!this.f21147g.get()) {
            d(result);
        }
    }

    /* access modifiers changed from: private */
    public Result d(Result result) {
        f21142b.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    /* access modifiers changed from: private */
    public void e(Result result) {
        if (c()) {
            b(result);
        } else {
            a(result);
        }
    }

    public final b<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (!this.f21145e) {
            this.f21145e = true;
            a();
            this.f21143c.f21153b = paramsArr;
            executor.execute(new e(this.f21148h, this.f21144d));
            return this;
        }
        throw new IllegalStateException("Cannot execute task: the task is already executed.");
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public void a(Priority priority) {
        this.f21148h = priority;
    }

    /* access modifiers changed from: protected */
    public void a(Result result) {
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void b(Result result) {
        b();
    }

    /* access modifiers changed from: protected */
    public void b(Progress... progressArr) {
    }

    /* access modifiers changed from: protected */
    public abstract Result c(Params... paramsArr);

    public final boolean c() {
        return this.f21146f.get();
    }

    /* access modifiers changed from: protected */
    public final void d(Progress... progressArr) {
        if (!c()) {
            f21142b.obtainMessage(2, new a(this, progressArr)).sendToTarget();
        }
    }
}
