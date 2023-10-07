package ly;

import io.reactivex.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.f;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import lv.d;
import lv.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile d<? super Throwable> f31022a;

    /* renamed from: b  reason: collision with root package name */
    static volatile e<? super Runnable, ? extends Runnable> f31023b;

    /* renamed from: c  reason: collision with root package name */
    static volatile e<? super Callable<i>, ? extends i> f31024c;

    /* renamed from: d  reason: collision with root package name */
    static volatile e<? super Callable<i>, ? extends i> f31025d;

    /* renamed from: e  reason: collision with root package name */
    static volatile e<? super Callable<i>, ? extends i> f31026e;

    /* renamed from: f  reason: collision with root package name */
    static volatile e<? super Callable<i>, ? extends i> f31027f;

    /* renamed from: g  reason: collision with root package name */
    static volatile e<? super i, ? extends i> f31028g;

    /* renamed from: h  reason: collision with root package name */
    static volatile e<? super i, ? extends i> f31029h;

    /* renamed from: i  reason: collision with root package name */
    static volatile e<? super b, ? extends b> f31030i;

    /* renamed from: j  reason: collision with root package name */
    static volatile e<? super f, ? extends f> f31031j;

    /* renamed from: k  reason: collision with root package name */
    static volatile lv.b<? super b, ? super oj.b, ? extends oj.b> f31032k;

    /* renamed from: l  reason: collision with root package name */
    static volatile lv.b<? super f, ? super h, ? extends h> f31033l;

    public static <T> b<T> a(b<T> bVar) {
        e<? super b, ? extends b> eVar = f31030i;
        return eVar != null ? (b) a(eVar, bVar) : bVar;
    }

    public static <T> f<T> a(f<T> fVar) {
        e<? super f, ? extends f> eVar = f31031j;
        return eVar != null ? (f) a(eVar, fVar) : fVar;
    }

    public static <T> h<? super T> a(f<T> fVar, h<? super T> hVar) {
        lv.b<? super f, ? super h, ? extends h> bVar = f31033l;
        return bVar != null ? (h) a(bVar, fVar, hVar) : hVar;
    }

    public static i a(i iVar) {
        e<? super i, ? extends i> eVar = f31028g;
        return eVar == null ? iVar : (i) a(eVar, iVar);
    }

    public static i a(Callable<i> callable) {
        lw.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f31024c;
        return eVar == null ? e(callable) : a(eVar, callable);
    }

    static i a(e<? super Callable<i>, ? extends i> eVar, Callable<i> callable) {
        return (i) lw.b.a(a(eVar, callable), "Scheduler Callable result can't be null");
    }

    static <T, U, R> R a(lv.b<T, U, R> bVar, T t2, U u2) {
        try {
            return bVar.a(t2, u2);
        } catch (Throwable th) {
            throw ExceptionHelper.a(th);
        }
    }

    static <T, R> R a(e<T, R> eVar, T t2) {
        try {
            return eVar.a(t2);
        } catch (Throwable th) {
            throw ExceptionHelper.a(th);
        }
    }

    public static Runnable a(Runnable runnable) {
        lw.b.a(runnable, "run is null");
        e<? super Runnable, ? extends Runnable> eVar = f31023b;
        return eVar == null ? runnable : (Runnable) a(eVar, runnable);
    }

    public static <T> oj.b<? super T> a(b<T> bVar, oj.b<? super T> bVar2) {
        lv.b<? super b, ? super oj.b, ? extends oj.b> bVar3 = f31032k;
        return bVar3 != null ? (oj.b) a(bVar3, bVar, bVar2) : bVar2;
    }

    public static void a(Throwable th) {
        d<? super Throwable> dVar = f31022a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!b(th)) {
            th = new UndeliverableException(th);
        }
        if (dVar != null) {
            try {
                dVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    public static i b(i iVar) {
        e<? super i, ? extends i> eVar = f31029h;
        return eVar == null ? iVar : (i) a(eVar, iVar);
    }

    public static i b(Callable<i> callable) {
        lw.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f31026e;
        return eVar == null ? e(callable) : a(eVar, callable);
    }

    static boolean b(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static i c(Callable<i> callable) {
        lw.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f31027f;
        return eVar == null ? e(callable) : a(eVar, callable);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static i d(Callable<i> callable) {
        lw.b.a(callable, "Scheduler Callable can't be null");
        e<? super Callable<i>, ? extends i> eVar = f31025d;
        return eVar == null ? e(callable) : a(eVar, callable);
    }

    static i e(Callable<i> callable) {
        try {
            return (i) lw.b.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.a(th);
        }
    }
}
