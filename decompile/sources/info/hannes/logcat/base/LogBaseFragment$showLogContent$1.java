package info.hannes.logcat.base;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.af;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.e;
import mm.m;

@d(b = "LogBaseFragment.kt", c = {74}, d = "invokeSuspend", e = "info.hannes.logcat.base.LogBaseFragment$showLogContent$1")
final class LogBaseFragment$showLogContent$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f28633a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f28634b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogBaseFragment$showLogContent$1(b bVar, c cVar) {
        super(2, cVar);
        this.f28634b = bVar;
    }

    public final Object a(Object obj, Object obj2) {
        return ((LogBaseFragment$showLogContent$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new LogBaseFragment$showLogContent$1(this.f28634b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Integer a2;
        Integer a3;
        Object a4 = a.a();
        int i2 = this.f28633a;
        if (i2 == 0) {
            i.a(obj);
            this.f28633a = 1;
            obj = e.a(ap.a(), new LogBaseFragment$showLogContent$1$logEntries$1(this, (c) null), this);
            if (obj == a4) {
                return a4;
            }
        } else if (i2 == 1) {
            i.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ArrayList arrayList = (ArrayList) obj;
        c d2 = this.f28634b.d();
        if (d2 != null) {
            d2.a((List<String>) arrayList);
        }
        b.a(this.f28634b).setAdapter(this.f28634b.d());
        RecyclerView.Adapter adapter = b.a(this.f28634b).getAdapter();
        if (!(adapter == null || (a2 = kotlin.coroutines.jvm.internal.a.a(adapter.getItemCount())) == null || (a3 = kotlin.coroutines.jvm.internal.a.a(a2.intValue() - 1)) == null)) {
            b.a(this.f28634b).a(a3.intValue());
        }
        if (this.f28634b.e()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ LogBaseFragment$showLogContent$1 f28635a;

                {
                    this.f28635a = r1;
                }

                public final void run() {
                    this.f28635a.f28634b.f();
                }
            }, 1000);
        }
        return l.f30254a;
    }
}
