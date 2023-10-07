package kotlin.coroutines.intrinsics;

import java.util.Objects;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.i;
import mm.m;

public final class IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 extends ContinuationImpl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f30207a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f30208b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ m f30209c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Object f30210d;

    /* renamed from: e  reason: collision with root package name */
    private int f30211e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(c cVar, f fVar, c cVar2, f fVar2, m mVar, Object obj) {
        super(cVar2, fVar2);
        this.f30207a = cVar;
        this.f30208b = fVar;
        this.f30209c = mVar;
        this.f30210d = obj;
    }

    /* access modifiers changed from: protected */
    public Object invokeSuspend(Object obj) {
        int i2 = this.f30211e;
        if (i2 == 0) {
            this.f30211e = 1;
            i.a(obj);
            m mVar = this.f30209c;
            Objects.requireNonNull(mVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((m) kotlin.jvm.internal.m.b(mVar, 2)).a(this.f30210d, this);
        } else if (i2 == 1) {
            this.f30211e = 2;
            i.a(obj);
            return obj;
        } else {
            throw new IllegalStateException("This coroutine had already completed".toString());
        }
    }
}
