package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.bg;

public final class LifecycleCoroutineScopeImpl extends i implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Lifecycle f3563a;

    /* renamed from: b  reason: collision with root package name */
    private final f f3564b;

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, f fVar) {
        h.c(lifecycle, "lifecycle");
        h.c(fVar, "coroutineContext");
        this.f3563a = lifecycle;
        this.f3564b = fVar;
        if (b().a() == Lifecycle.State.DESTROYED) {
            bk.a(c(), (CancellationException) null, 1, (Object) null);
        }
    }

    public final void a() {
        bg unused = g.a(this, ap.b().a(), (CoroutineStart) null, new LifecycleCoroutineScopeImpl$register$1(this, (c) null), 2, (Object) null);
    }

    public void a(n nVar, Lifecycle.Event event) {
        h.c(nVar, "source");
        h.c(event, "event");
        if (b().a().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            b().b(this);
            bk.a(c(), (CancellationException) null, 1, (Object) null);
        }
    }

    public Lifecycle b() {
        return this.f3563a;
    }

    public f c() {
        return this.f3564b;
    }
}
