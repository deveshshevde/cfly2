package com.xeagle.android.vjoystick.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class e {

    /* renamed from: a  reason: collision with root package name */
    final a f25370a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler.Callback f25371b;

    /* renamed from: c  reason: collision with root package name */
    private final b f25372c;

    /* renamed from: d  reason: collision with root package name */
    private Lock f25373d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        a f25374a;

        /* renamed from: b  reason: collision with root package name */
        a f25375b;

        /* renamed from: c  reason: collision with root package name */
        final Runnable f25376c;

        /* renamed from: d  reason: collision with root package name */
        final c f25377d;

        /* renamed from: e  reason: collision with root package name */
        Lock f25378e;

        public a(Lock lock, Runnable runnable) {
            this.f25376c = runnable;
            this.f25378e = lock;
            this.f25377d = new c(new WeakReference(runnable), new WeakReference(this));
        }

        /* JADX INFO: finally extract failed */
        public c a() {
            this.f25378e.lock();
            try {
                a aVar = this.f25375b;
                if (aVar != null) {
                    aVar.f25374a = this.f25374a;
                }
                a aVar2 = this.f25374a;
                if (aVar2 != null) {
                    aVar2.f25375b = aVar;
                }
                this.f25375b = null;
                this.f25374a = null;
                this.f25378e.unlock();
                return this.f25377d;
            } catch (Throwable th) {
                this.f25378e.unlock();
                throw th;
            }
        }

        public c a(Runnable runnable) {
            this.f25378e.lock();
            try {
                for (a aVar = this.f25374a; aVar != null; aVar = aVar.f25374a) {
                    if (aVar.f25376c == runnable) {
                        return aVar.a();
                    }
                }
                this.f25378e.unlock();
                return null;
            } finally {
                this.f25378e.unlock();
            }
        }

        public void a(a aVar) {
            this.f25378e.lock();
            try {
                a aVar2 = this.f25374a;
                if (aVar2 != null) {
                    aVar2.f25375b = aVar;
                }
                aVar.f25374a = aVar2;
                this.f25374a = aVar;
                aVar.f25375b = this;
            } finally {
                this.f25378e.unlock();
            }
        }
    }

    private static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Handler.Callback> f25379a;

        b() {
            this.f25379a = null;
        }

        b(Looper looper) {
            super(looper);
            this.f25379a = null;
        }

        b(Looper looper, WeakReference<Handler.Callback> weakReference) {
            super(looper);
            this.f25379a = weakReference;
        }

        public void handleMessage(Message message) {
            Handler.Callback callback;
            WeakReference<Handler.Callback> weakReference = this.f25379a;
            if (weakReference != null && (callback = (Handler.Callback) weakReference.get()) != null) {
                callback.handleMessage(message);
            }
        }
    }

    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Runnable> f25380a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<a> f25381b;

        c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.f25380a = weakReference;
            this.f25381b = weakReference2;
        }

        public void run() {
            Runnable runnable = (Runnable) this.f25380a.get();
            a aVar = (a) this.f25381b.get();
            if (aVar != null) {
                aVar.a();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public e() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f25373d = reentrantLock;
        this.f25370a = new a(reentrantLock, (Runnable) null);
        this.f25371b = null;
        this.f25372c = new b();
    }

    public e(Looper looper) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f25373d = reentrantLock;
        this.f25370a = new a(reentrantLock, (Runnable) null);
        this.f25371b = null;
        this.f25372c = new b(looper);
    }

    public e(Looper looper, Handler.Callback callback) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f25373d = reentrantLock;
        this.f25370a = new a(reentrantLock, (Runnable) null);
        this.f25371b = callback;
        this.f25372c = new b(looper, new WeakReference(callback));
    }

    private c c(Runnable runnable) {
        Objects.requireNonNull(runnable, "Runnable can't be null");
        a aVar = new a(this.f25373d, runnable);
        this.f25370a.a(aVar);
        return aVar.f25377d;
    }

    public final void a(Object obj) {
        this.f25372c.removeCallbacksAndMessages(obj);
    }

    public final boolean a(int i2) {
        return this.f25372c.sendEmptyMessage(i2);
    }

    public final boolean a(Message message) {
        return this.f25372c.sendMessage(message);
    }

    public final boolean a(Runnable runnable) {
        return this.f25372c.post(c(runnable));
    }

    public final boolean a(Runnable runnable, long j2) {
        return this.f25372c.postDelayed(c(runnable), j2);
    }

    public final void b(Runnable runnable) {
        c a2 = this.f25370a.a(runnable);
        if (a2 != null) {
            this.f25372c.removeCallbacks(a2);
        }
    }
}
