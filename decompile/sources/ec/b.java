package ec;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class b {

    /* renamed from: a  reason: collision with root package name */
    final a f26855a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler.Callback f26856b = null;

    /* renamed from: c  reason: collision with root package name */
    private final C0169b f26857c = new C0169b();

    /* renamed from: d  reason: collision with root package name */
    private Lock f26858d;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        a f26859a;

        /* renamed from: b  reason: collision with root package name */
        a f26860b;

        /* renamed from: c  reason: collision with root package name */
        final Runnable f26861c;

        /* renamed from: d  reason: collision with root package name */
        final c f26862d;

        /* renamed from: e  reason: collision with root package name */
        Lock f26863e;

        public a(Lock lock, Runnable runnable) {
            this.f26861c = runnable;
            this.f26863e = lock;
            this.f26862d = new c(new WeakReference(runnable), new WeakReference(this));
        }

        /* JADX INFO: finally extract failed */
        public c a() {
            this.f26863e.lock();
            try {
                a aVar = this.f26860b;
                if (aVar != null) {
                    aVar.f26859a = this.f26859a;
                }
                a aVar2 = this.f26859a;
                if (aVar2 != null) {
                    aVar2.f26860b = aVar;
                }
                this.f26860b = null;
                this.f26859a = null;
                this.f26863e.unlock();
                return this.f26862d;
            } catch (Throwable th) {
                this.f26863e.unlock();
                throw th;
            }
        }

        public void a(a aVar) {
            this.f26863e.lock();
            try {
                a aVar2 = this.f26859a;
                if (aVar2 != null) {
                    aVar2.f26860b = aVar;
                }
                aVar.f26859a = aVar2;
                this.f26859a = aVar;
                aVar.f26860b = this;
            } finally {
                this.f26863e.unlock();
            }
        }
    }

    /* renamed from: ec.b$b  reason: collision with other inner class name */
    private static class C0169b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Handler.Callback> f26864a = null;

        C0169b() {
        }

        public void handleMessage(Message message) {
            Handler.Callback callback;
            WeakReference<Handler.Callback> weakReference = this.f26864a;
            if (weakReference != null && (callback = (Handler.Callback) weakReference.get()) != null) {
                callback.handleMessage(message);
            }
        }
    }

    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Runnable> f26865a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<a> f26866b;

        c(WeakReference<Runnable> weakReference, WeakReference<a> weakReference2) {
            this.f26865a = weakReference;
            this.f26866b = weakReference2;
        }

        public void run() {
            Runnable runnable = (Runnable) this.f26865a.get();
            a aVar = (a) this.f26866b.get();
            if (aVar != null) {
                aVar.a();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public b() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f26858d = reentrantLock;
        this.f26855a = new a(reentrantLock, (Runnable) null);
    }

    private c a(Runnable runnable) {
        Objects.requireNonNull(runnable, "Runnable can't be null");
        a aVar = new a(this.f26858d, runnable);
        this.f26855a.a(aVar);
        return aVar.f26862d;
    }

    public final boolean a(Runnable runnable, long j2) {
        return this.f26857c.postDelayed(a(runnable), j2);
    }
}
