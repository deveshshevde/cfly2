package lu;

import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.c;
import io.reactivex.i;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

final class b extends i {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f31001b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f31002c;

    private static final class a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f31003a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f31004b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f31005c;

        a(Handler handler, boolean z2) {
            this.f31003a = handler;
            this.f31004b = z2;
        }

        public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f31005c) {
                return c.a();
            }
            C0221b bVar = new C0221b(this.f31003a, ly.a.a(runnable));
            Message obtain = Message.obtain(this.f31003a, bVar);
            obtain.obj = this;
            if (this.f31004b) {
                obtain.setAsynchronous(true);
            }
            this.f31003a.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
            if (!this.f31005c) {
                return bVar;
            }
            this.f31003a.removeCallbacks(bVar);
            return c.a();
        }

        public void dispose() {
            this.f31005c = true;
            this.f31003a.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.f31005c;
        }
    }

    /* renamed from: lu.b$b  reason: collision with other inner class name */
    private static final class C0221b implements io.reactivex.disposables.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f31006a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f31007b;

        /* renamed from: c  reason: collision with root package name */
        private volatile boolean f31008c;

        C0221b(Handler handler, Runnable runnable) {
            this.f31006a = handler;
            this.f31007b = runnable;
        }

        public void dispose() {
            this.f31006a.removeCallbacks(this);
            this.f31008c = true;
        }

        public boolean isDisposed() {
            return this.f31008c;
        }

        public void run() {
            try {
                this.f31007b.run();
            } catch (Throwable th) {
                ly.a.a(th);
            }
        }
    }

    b(Handler handler, boolean z2) {
        this.f31001b = handler;
        this.f31002c = z2;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        C0221b bVar = new C0221b(this.f31001b, ly.a.a(runnable));
        this.f31001b.postDelayed(bVar, timeUnit.toMillis(j2));
        return bVar;
    }

    public i.c a() {
        return new a(this.f31001b, this.f31002c);
    }
}
