package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.b;
import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final i f28785b;

    static final class SubscribeOnObserver<T> extends AtomicReference<b> implements b, h<T> {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f28786a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<b> f28787b = new AtomicReference<>();

        SubscribeOnObserver(h<? super T> hVar) {
            this.f28786a = hVar;
        }

        public void a() {
            this.f28786a.a();
        }

        public void a(b bVar) {
            DisposableHelper.a(this.f28787b, bVar);
        }

        public void a(Throwable th) {
            this.f28786a.a(th);
        }

        public void a_(T t2) {
            this.f28786a.a_(t2);
        }

        /* access modifiers changed from: package-private */
        public void b(b bVar) {
            DisposableHelper.a((AtomicReference<b>) this, bVar);
        }

        public void dispose() {
            DisposableHelper.a(this.f28787b);
            DisposableHelper.a((AtomicReference<b>) this);
        }

        public boolean isDisposed() {
            return DisposableHelper.a((b) get());
        }
    }

    final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final SubscribeOnObserver<T> f28789b;

        a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f28789b = subscribeOnObserver;
        }

        public void run() {
            ObservableSubscribeOn.this.f28794a.a(this.f28789b);
        }
    }

    public ObservableSubscribeOn(g<T> gVar, i iVar) {
        super(gVar);
        this.f28785b = iVar;
    }

    public void b(h<? super T> hVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(hVar);
        hVar.a((b) subscribeOnObserver);
        subscribeOnObserver.b(this.f28785b.a(new a(subscribeOnObserver)));
    }
}
