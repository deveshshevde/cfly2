package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class u {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f30512b = AtomicIntegerFieldUpdater.newUpdater(u.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f30513a;

    public u(Throwable th, boolean z2) {
        this.f30513a = th;
        this._handled = z2 ? 1 : 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(Throwable th, boolean z2, int i2, f fVar) {
        this(th, (i2 & 2) != 0 ? false : z2);
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [boolean, int] */
    public final boolean b() {
        return this._handled;
    }

    public final boolean c() {
        return f30512b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return ah.b(this) + '[' + this.f30513a + ']';
    }
}
