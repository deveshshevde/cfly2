package info.hannes.logcat.base;

import java.util.ArrayList;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.af;
import mm.m;

@d(b = "LogBaseFragment.kt", c = {}, d = "invokeSuspend", e = "info.hannes.logcat.base.LogBaseFragment$showLogContent$1$logEntries$1")
final class LogBaseFragment$showLogContent$1$logEntries$1 extends SuspendLambda implements m<af, c<? super ArrayList<String>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f28636a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LogBaseFragment$showLogContent$1 f28637b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogBaseFragment$showLogContent$1$logEntries$1(LogBaseFragment$showLogContent$1 logBaseFragment$showLogContent$1, c cVar) {
        super(2, cVar);
        this.f28637b = logBaseFragment$showLogContent$1;
    }

    public final Object a(Object obj, Object obj2) {
        return ((LogBaseFragment$showLogContent$1$logEntries$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new LogBaseFragment$showLogContent$1$logEntries$1(this.f28637b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        a.a();
        if (this.f28636a == 0) {
            i.a(obj);
            return this.f28637b.f28634b.a();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
