package com.xeagle.android.vjoystick.fragment.http_fragment;

import java.util.ArrayList;
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

@d(b = "DelayVideoFragment.kt", c = {337}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_fragment.DelayVideoFragment$parseAmbaHtml$1")
final class DelayVideoFragment$parseAmbaHtml$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25189a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f25190b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f25191c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelayVideoFragment$parseAmbaHtml$1(a aVar, String str, c cVar) {
        super(2, cVar);
        this.f25190b = aVar;
        this.f25191c = str;
    }

    public final Object a(Object obj, Object obj2) {
        return ((DelayVideoFragment$parseAmbaHtml$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new DelayVideoFragment$parseAmbaHtml$1(this.f25190b, this.f25191c, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f25189a;
        if (i2 == 0) {
            i.a(obj);
            this.f25189a = 1;
            obj = e.a(ap.c(), new DelayVideoFragment$parseAmbaHtml$1$folder$1(this, (c) null), this);
            if (obj == a2) {
                return a2;
            }
        } else if (i2 == 1) {
            i.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f25190b.b((ArrayList<lc.a>) (ArrayList) obj);
        return l.f30254a;
    }
}
