package kotlinx.coroutines.android;

import kotlin.jvm.internal.Lambda;
import kotlin.l;
import mm.b;

final class HandlerContext$scheduleResumeAfterDelay$1 extends Lambda implements b<Throwable, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f30306a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f30307b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandlerContext$scheduleResumeAfterDelay$1(a aVar, Runnable runnable) {
        super(1);
        this.f30306a = aVar;
        this.f30307b = runnable;
    }

    public final void a(Throwable th) {
        this.f30306a.f30309d.removeCallbacks(this.f30307b);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return l.f30254a;
    }
}
