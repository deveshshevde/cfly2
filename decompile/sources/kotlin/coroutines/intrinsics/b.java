package kotlin.coroutines.intrinsics;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.h;

class b {
    public static final <T> c<T> a(c<? super T> cVar) {
        c<Object> intercepted;
        h.d(cVar, "$this$intercepted");
        ContinuationImpl continuationImpl = (ContinuationImpl) (!(cVar instanceof ContinuationImpl) ? null : cVar);
        return (continuationImpl == null || (intercepted = continuationImpl.intercepted()) == null) ? cVar : intercepted;
    }

    /* JADX WARNING: type inference failed for: r10v6, types: [kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R, T> kotlin.coroutines.c<kotlin.l> a(mm.m<? super R, ? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r8, R r9, kotlin.coroutines.c<? super T> r10) {
        /*
            java.lang.String r0 = "$this$createCoroutineUnintercepted"
            kotlin.jvm.internal.h.d(r8, r0)
            java.lang.String r0 = "completion"
            kotlin.jvm.internal.h.d(r10, r0)
            kotlin.coroutines.c r4 = kotlin.coroutines.jvm.internal.f.a(r10)
            boolean r10 = r8 instanceof kotlin.coroutines.jvm.internal.BaseContinuationImpl
            if (r10 == 0) goto L_0x0019
            kotlin.coroutines.jvm.internal.BaseContinuationImpl r8 = (kotlin.coroutines.jvm.internal.BaseContinuationImpl) r8
            kotlin.coroutines.c r8 = r8.create(r9, r4)
            goto L_0x003e
        L_0x0019:
            kotlin.coroutines.f r5 = r4.getContext()
            kotlin.coroutines.EmptyCoroutineContext r10 = kotlin.coroutines.EmptyCoroutineContext.f30194a
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>"
            if (r5 != r10) goto L_0x002c
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3 r10 = new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3
            java.util.Objects.requireNonNull(r4, r0)
            r10.<init>(r4, r4, r8, r9)
            goto L_0x0039
        L_0x002c:
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4 r10 = new kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4
            java.util.Objects.requireNonNull(r4, r0)
            r1 = r10
            r2 = r4
            r3 = r5
            r6 = r8
            r7 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
        L_0x0039:
            kotlin.coroutines.jvm.internal.BaseContinuationImpl r10 = (kotlin.coroutines.jvm.internal.BaseContinuationImpl) r10
            r8 = r10
            kotlin.coroutines.c r8 = (kotlin.coroutines.c) r8
        L_0x003e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.coroutines.intrinsics.b.a(mm.m, java.lang.Object, kotlin.coroutines.c):kotlin.coroutines.c");
    }
}
