package oq;

import java.util.Arrays;
import ok.h;
import rx.exceptions.CompositeException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.internal.util.c;

public class a<T> extends h<T> {

    /* renamed from: a  reason: collision with root package name */
    boolean f32514a = false;

    /* renamed from: b  reason: collision with root package name */
    private final h<? super T> f32515b;

    public a(h<? super T> hVar) {
        super(hVar);
        this.f32515b = hVar;
    }

    /* access modifiers changed from: protected */
    public void a(Throwable th) {
        c.a(th);
        try {
            this.f32515b.onError(th);
            try {
                unsubscribe();
            } catch (RuntimeException e2) {
                c.a(e2);
                throw new OnErrorFailedException(e2);
            }
        } catch (Throwable th2) {
            c.a(th2);
            throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(new Throwable[]{th, th, th2})));
        }
    }

    public void onCompleted() {
        if (!this.f32514a) {
            this.f32514a = true;
            try {
                this.f32515b.onCompleted();
                try {
                    unsubscribe();
                } catch (Throwable th) {
                    c.a(th);
                    throw new UnsubscribeFailedException(th.getMessage(), th);
                }
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } catch (Throwable th3) {
                    c.a(th3);
                    throw new UnsubscribeFailedException(th3.getMessage(), th3);
                }
            }
        }
    }

    public void onError(Throwable th) {
        rx.exceptions.a.a(th);
        if (!this.f32514a) {
            this.f32514a = true;
            a(th);
        }
    }

    public void onNext(T t2) {
        try {
            if (!this.f32514a) {
                this.f32515b.onNext(t2);
            }
        } catch (Throwable th) {
            rx.exceptions.a.a(th, (ok.c<?>) this);
        }
    }
}
