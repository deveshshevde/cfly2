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
import kotlinx.coroutines.ap;
import kotlinx.coroutines.e;
import mm.m;

@d(b = "ImageCompoundUtil.kt", c = {449}, d = "invokeSuspend", e = "com.xeagle.android.utils.ImageCompoundUtil$saveVideo$3$onEnd$1")
final class ImageCompoundUtil$saveVideo$3$onEnd$1 extends SuspendLambda implements m<af, c<? super kotlin.l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f24347a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l.h f24348b;

    @d(b = "ImageCompoundUtil.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.utils.ImageCompoundUtil$saveVideo$3$onEnd$1$1")
    /* renamed from: com.xeagle.android.utils.ImageCompoundUtil$saveVideo$3$onEnd$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super kotlin.l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24349a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImageCompoundUtil$saveVideo$3$onEnd$1 f24350b;

        {
            this.f24350b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(kotlin.l.f30254a);
        }

        public final c<kotlin.l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f24350b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            a.a();
            if (this.f24349a == 0) {
                i.a(obj);
                this.f24350b.f24348b.f24474a.a((ArrayList<lc.a>) this.f24350b.f24348b.f24476c, this.f24350b.f24348b.f24477d, this.f24350b.f24348b.f24478e, this.f24350b.f24348b.f24479f, this.f24350b.f24348b.f24480g, this.f24350b.f24348b.f24481h, this.f24350b.f24348b.f24482i);
                return kotlin.l.f30254a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageCompoundUtil$saveVideo$3$onEnd$1(l.h hVar, c cVar) {
        super(2, cVar);
        this.f24348b = hVar;
    }

    public final Object a(Object obj, Object obj2) {
        return ((ImageCompoundUtil$saveVideo$3$onEnd$1) create(obj, (c) obj2)).invokeSuspend(kotlin.l.f30254a);
    }

    public final c<kotlin.l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new ImageCompoundUtil$saveVideo$3$onEnd$1(this.f24348b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object a2 = a.a();
        int i2 = this.f24347a;
        if (i2 == 0) {
            i.a(obj);
            this.f24347a = 1;
            if (e.a(ap.b(), new AnonymousClass1(this, (c) null), this) == a2) {
                return a2;
            }
        } else if (i2 == 1) {
            i.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return kotlin.l.f30254a;
    }
}
