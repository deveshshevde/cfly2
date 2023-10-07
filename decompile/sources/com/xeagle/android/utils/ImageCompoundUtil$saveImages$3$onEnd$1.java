package com.xeagle.android.utils;

import com.xeagle.android.utils.l;
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

@d(b = "ImageCompoundUtil.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.utils.ImageCompoundUtil$saveImages$3$onEnd$1")
final class ImageCompoundUtil$saveImages$3$onEnd$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f24345a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l.g f24346b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageCompoundUtil$saveImages$3$onEnd$1(l.g gVar, c cVar) {
        super(2, cVar);
        this.f24346b = gVar;
    }

    public final Object a(Object obj, Object obj2) {
        return ((ImageCompoundUtil$saveImages$3$onEnd$1) create(obj, (c) obj2)).invokeSuspend(kotlin.l.f30254a);
    }

    public final c<kotlin.l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new ImageCompoundUtil$saveImages$3$onEnd$1(this.f24346b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        a.a();
        if (this.f24345a == 0) {
            i.a(obj);
            this.f24346b.f24463a.a((ArrayList<lc.a>) this.f24346b.f24465c, this.f24346b.f24466d, this.f24346b.f24467e, this.f24346b.f24468f, this.f24346b.f24469g, this.f24346b.f24470h, this.f24346b.f24471i);
            return kotlin.l.f30254a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
