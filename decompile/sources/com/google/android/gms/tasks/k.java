package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.m;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

final class k<TResult> extends b<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f18376a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final h<TResult> f18377b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f18378c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f18379d;

    /* renamed from: e  reason: collision with root package name */
    private TResult f18380e;

    /* renamed from: f  reason: collision with root package name */
    private Exception f18381f;

    k() {
    }

    private final void f() {
        m.b(this.f18378c, "Task is not yet complete");
    }

    private final void g() {
        if (this.f18379d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void h() {
        if (this.f18378c) {
            throw DuplicateTaskCompletionException.a(this);
        }
    }

    private final void i() {
        synchronized (this.f18376a) {
            if (this.f18378c) {
                this.f18377b.a(this);
            }
        }
    }

    public final b<TResult> a(a<TResult> aVar) {
        this.f18377b.a(new f(d.f18365a, aVar));
        i();
        return this;
    }

    public final b<TResult> a(Executor executor, a<TResult> aVar) {
        this.f18377b.a(new f(executor, aVar));
        i();
        return this;
    }

    public final Exception a() {
        Exception exc;
        synchronized (this.f18376a) {
            exc = this.f18381f;
        }
        return exc;
    }

    public final void a(Exception exc) {
        m.a(exc, (Object) "Exception must not be null");
        synchronized (this.f18376a) {
            h();
            this.f18378c = true;
            this.f18381f = exc;
        }
        this.f18377b.a(this);
    }

    public final void a(TResult tresult) {
        synchronized (this.f18376a) {
            h();
            this.f18378c = true;
            this.f18380e = tresult;
        }
        this.f18377b.a(this);
    }

    public final TResult b() {
        TResult tresult;
        synchronized (this.f18376a) {
            f();
            g();
            Exception exc = this.f18381f;
            if (exc == null) {
                tresult = this.f18380e;
            } else {
                throw new RuntimeExecutionException(exc);
            }
        }
        return tresult;
    }

    public final boolean b(Exception exc) {
        m.a(exc, (Object) "Exception must not be null");
        synchronized (this.f18376a) {
            if (this.f18378c) {
                return false;
            }
            this.f18378c = true;
            this.f18381f = exc;
            this.f18377b.a(this);
            return true;
        }
    }

    public final boolean b(TResult tresult) {
        synchronized (this.f18376a) {
            if (this.f18378c) {
                return false;
            }
            this.f18378c = true;
            this.f18380e = tresult;
            this.f18377b.a(this);
            return true;
        }
    }

    public final boolean c() {
        return this.f18379d;
    }

    public final boolean d() {
        boolean z2;
        synchronized (this.f18376a) {
            z2 = this.f18378c;
        }
        return z2;
    }

    public final boolean e() {
        boolean z2;
        synchronized (this.f18376a) {
            z2 = false;
            if (this.f18378c && !this.f18379d && this.f18381f == null) {
                z2 = true;
            }
        }
        return z2;
    }
}
