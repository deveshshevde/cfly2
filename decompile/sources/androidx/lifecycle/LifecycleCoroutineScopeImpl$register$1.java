package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.af;
import mm.m;

@d(b = "Lifecycle.kt", c = {}, d = "invokeSuspend", e = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1")
final class LifecycleCoroutineScopeImpl$register$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f3565a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LifecycleCoroutineScopeImpl f3566b;

    /* renamed from: c  reason: collision with root package name */
    private af f3567c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, c cVar) {
        super(2, cVar);
        this.f3566b = lifecycleCoroutineScopeImpl;
    }

    public final Object a(Object obj, Object obj2) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.c(cVar, "completion");
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.f3566b, cVar);
        lifecycleCoroutineScopeImpl$register$1.f3567c = (af) obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    public final Object invokeSuspend(Object obj) {
        a.a();
        if (this.f3565a == 0) {
            i.a(obj);
            af afVar = this.f3567c;
            if (this.f3566b.b().a().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                this.f3566b.b().a(this.f3566b);
            } else {
                bk.a(afVar.c(), (CancellationException) null, 1, (Object) null);
            }
            return l.f30254a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
