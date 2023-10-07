package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.bg;

final class LifecycleController$observer$1 implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f3561a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ bg f3562b;

    public final void a(n nVar, Lifecycle.Event event) {
        h.c(nVar, "source");
        h.c(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = nVar.getLifecycle();
        h.a((Object) lifecycle, "source.lifecycle");
        if (lifecycle.a() == Lifecycle.State.DESTROYED) {
            h hVar = this.f3561a;
            bg.a.a(this.f3562b, (CancellationException) null, 1, (Object) null);
            hVar.a();
            return;
        }
        Lifecycle lifecycle2 = nVar.getLifecycle();
        h.a((Object) lifecycle2, "source.lifecycle");
        if (lifecycle2.a().compareTo(this.f3561a.f3619c) < 0) {
            this.f3561a.f3620d.a();
        } else {
            this.f3561a.f3620d.b();
        }
    }
}
