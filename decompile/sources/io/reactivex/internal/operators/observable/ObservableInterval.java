package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.b;
import io.reactivex.f;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableInterval extends f<Long> {

    /* renamed from: a  reason: collision with root package name */
    final i f28765a;

    /* renamed from: b  reason: collision with root package name */
    final long f28766b;

    /* renamed from: c  reason: collision with root package name */
    final long f28767c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f28768d;

    static final class IntervalObserver extends AtomicReference<b> implements b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;

        /* renamed from: a  reason: collision with root package name */
        final h<? super Long> f28769a;

        /* renamed from: b  reason: collision with root package name */
        long f28770b;

        IntervalObserver(h<? super Long> hVar) {
            this.f28769a = hVar;
        }

        public void a(b bVar) {
            DisposableHelper.a((AtomicReference<b>) this, bVar);
        }

        public void dispose() {
            DisposableHelper.a((AtomicReference<b>) this);
        }

        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        public void run() {
            if (get() != DisposableHelper.DISPOSED) {
                h<? super Long> hVar = this.f28769a;
                long j2 = this.f28770b;
                this.f28770b = 1 + j2;
                hVar.a_(Long.valueOf(j2));
            }
        }
    }

    public ObservableInterval(long j2, long j3, TimeUnit timeUnit, i iVar) {
        this.f28766b = j2;
        this.f28767c = j3;
        this.f28768d = timeUnit;
        this.f28765a = iVar;
    }

    public void b(h<? super Long> hVar) {
        IntervalObserver intervalObserver = new IntervalObserver(hVar);
        hVar.a((b) intervalObserver);
        i iVar = this.f28765a;
        if (iVar instanceof io.reactivex.internal.schedulers.h) {
            i.c a2 = iVar.a();
            intervalObserver.a(a2);
            a2.a(intervalObserver, this.f28766b, this.f28767c, this.f28768d);
            return;
        }
        intervalObserver.a(iVar.a(intervalObserver, this.f28766b, this.f28767c, this.f28768d));
    }
}
