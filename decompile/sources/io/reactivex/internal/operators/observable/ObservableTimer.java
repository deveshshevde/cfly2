package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.b;
import io.reactivex.f;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableTimer extends f<Long> {

    /* renamed from: a  reason: collision with root package name */
    final i f28790a;

    /* renamed from: b  reason: collision with root package name */
    final long f28791b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f28792c;

    static final class TimerObserver extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;

        /* renamed from: a  reason: collision with root package name */
        final h<? super Long> f28793a;

        TimerObserver(h<? super Long> hVar) {
            this.f28793a = hVar;
        }

        public void a(b bVar) {
            DisposableHelper.c(this, bVar);
        }

        public void dispose() {
            DisposableHelper.a((AtomicReference<b>) this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (!isDisposed()) {
                this.f28793a.a_(0L);
                lazySet(EmptyDisposable.INSTANCE);
                this.f28793a.a();
            }
        }
    }

    public ObservableTimer(long j2, TimeUnit timeUnit, i iVar) {
        this.f28791b = j2;
        this.f28792c = timeUnit;
        this.f28790a = iVar;
    }

    public void b(h<? super Long> hVar) {
        TimerObserver timerObserver = new TimerObserver(hVar);
        hVar.a((b) timerObserver);
        timerObserver.a(this.f28790a.a(timerObserver, this.f28791b, this.f28792c));
    }
}
