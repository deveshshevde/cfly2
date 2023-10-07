package ok;

import rx.internal.util.e;

public abstract class g<T> implements i {

    /* renamed from: a  reason: collision with root package name */
    private final e f31797a = new e();

    public abstract void a(T t2);

    public abstract void a(Throwable th);

    public final void a(i iVar) {
        this.f31797a.a(iVar);
    }

    public final boolean isUnsubscribed() {
        return this.f31797a.isUnsubscribed();
    }

    public final void unsubscribe() {
        this.f31797a.unsubscribe();
    }
}
