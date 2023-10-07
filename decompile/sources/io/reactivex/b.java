package io.reactivex;

import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import java.util.concurrent.TimeUnit;
import lv.d;
import oj.a;
import oj.c;

public abstract class b<T> implements a<T> {

    /* renamed from: a  reason: collision with root package name */
    static final int f28675a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int a() {
        return f28675a;
    }

    public static b<Long> a(long j2, long j3, TimeUnit timeUnit, i iVar) {
        lw.b.a(timeUnit, "unit is null");
        lw.b.a(iVar, "scheduler is null");
        return ly.a.a(new FlowableInterval(Math.max(0, j2), Math.max(0, j3), timeUnit, iVar));
    }

    public static b<Long> a(long j2, TimeUnit timeUnit) {
        return a(j2, j2, timeUnit, lz.a.a());
    }

    public static b<Long> a(long j2, TimeUnit timeUnit, i iVar) {
        lw.b.a(timeUnit, "unit is null");
        lw.b.a(iVar, "scheduler is null");
        return ly.a.a(new FlowableTimer(Math.max(0, j2), timeUnit, iVar));
    }

    public static <T> b<T> a(d<T> dVar, BackpressureStrategy backpressureStrategy) {
        lw.b.a(dVar, "source is null");
        lw.b.a(backpressureStrategy, "mode is null");
        return ly.a.a(new FlowableCreate(dVar, backpressureStrategy));
    }

    public static b<Long> b(long j2, TimeUnit timeUnit) {
        return a(j2, timeUnit, lz.a.a());
    }

    public final b<T> a(i iVar) {
        return a(iVar, false, a());
    }

    public final b<T> a(i iVar, boolean z2) {
        lw.b.a(iVar, "scheduler is null");
        return ly.a.a(new FlowableSubscribeOn(this, iVar, z2));
    }

    public final b<T> a(i iVar, boolean z2, int i2) {
        lw.b.a(iVar, "scheduler is null");
        lw.b.a(i2, "bufferSize");
        return ly.a.a(new FlowableObserveOn(this, iVar, z2, i2));
    }

    public final io.reactivex.disposables.b a(d<? super T> dVar) {
        return a(dVar, (d<? super Throwable>) lw.a.f31014f, lw.a.f31011c, (d<? super c>) FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(d<? super T> dVar, d<? super Throwable> dVar2, lv.a aVar, d<? super c> dVar3) {
        lw.b.a(dVar, "onNext is null");
        lw.b.a(dVar2, "onError is null");
        lw.b.a(aVar, "onComplete is null");
        lw.b.a(dVar3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(dVar, dVar2, aVar, dVar3);
        a(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final void a(e<? super T> eVar) {
        lw.b.a(eVar, "s is null");
        try {
            oj.b<? super Object> a2 = ly.a.a(this, eVar);
            lw.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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

    public final void a(oj.b<? super T> bVar) {
        if (bVar instanceof e) {
            a((e) bVar);
            return;
        }
        lw.b.a(bVar, "s is null");
        a(new StrictSubscriber(bVar));
    }

    public final b<T> b(i iVar) {
        lw.b.a(iVar, "scheduler is null");
        return a(iVar, !(this instanceof FlowableCreate));
    }

    /* access modifiers changed from: protected */
    public abstract void b(oj.b<? super T> bVar);
}
