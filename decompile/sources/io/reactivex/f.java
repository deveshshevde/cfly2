package io.reactivex;

import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableTimer;
import java.util.concurrent.TimeUnit;
import lv.d;
import lw.b;
import lz.a;

public abstract class f<T> implements g<T> {
    public static int a() {
        return b.a();
    }

    public static f<Long> a(long j2, long j3, TimeUnit timeUnit) {
        return a(j2, j3, timeUnit, a.a());
    }

    public static f<Long> a(long j2, long j3, TimeUnit timeUnit, i iVar) {
        b.a(timeUnit, "unit is null");
        b.a(iVar, "scheduler is null");
        return ly.a.a(new ObservableInterval(Math.max(0, j2), Math.max(0, j3), timeUnit, iVar));
    }

    public static f<Long> a(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, a.a());
    }

    public static f<Long> a(long j2, TimeUnit timeUnit, i iVar) {
        b.a(timeUnit, "unit is null");
        b.a(iVar, "scheduler is null");
        return ly.a.a(new ObservableTimer(Math.max(j2, 0), timeUnit, iVar));
    }

    public final io.reactivex.disposables.b a(d<? super T> dVar) {
        return a(dVar, (d<? super Throwable>) lw.a.f31014f, lw.a.f31011c, (d<? super io.reactivex.disposables.b>) lw.a.a());
    }

    public final io.reactivex.disposables.b a(d<? super T> dVar, d<? super Throwable> dVar2, lv.a aVar, d<? super io.reactivex.disposables.b> dVar3) {
        b.a(dVar, "onNext is null");
        b.a(dVar2, "onError is null");
        b.a(aVar, "onComplete is null");
        b.a(dVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(dVar, dVar2, aVar, dVar3);
        a(lambdaObserver);
        return lambdaObserver;
    }

    public final f<T> a(i iVar) {
        return a(iVar, false, a());
    }

    public final f<T> a(i iVar, boolean z2, int i2) {
        b.a(iVar, "scheduler is null");
        b.a(i2, "bufferSize");
        return ly.a.a(new ObservableObserveOn(this, iVar, z2, i2));
    }

    public final void a(h<? super T> hVar) {
        b.a(hVar, "observer is null");
        try {
            h<? super Object> a2 = ly.a.a(this, hVar);
            b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            ly.a.a(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final f<T> b(i iVar) {
        b.a(iVar, "scheduler is null");
        return ly.a.a(new ObservableSubscribeOn(this, iVar));
    }

    /* access modifiers changed from: protected */
    public abstract void b(h<? super T> hVar);
}
