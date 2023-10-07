package retrofit2;

import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k;

public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, c<? super T> cVar) {
        k kVar = new k(a.a(cVar), 1);
        j jVar = kVar;
        jVar.a(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$await$2$2(jVar));
        Object g2 = kVar.g();
        if (g2 == a.a()) {
            f.c(cVar);
        }
        return g2;
    }

    public static final <T> Object awaitNullable(Call<T> call, c<? super T> cVar) {
        k kVar = new k(a.a(cVar), 1);
        j jVar = kVar;
        jVar.a(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new KotlinExtensions$await$4$2(jVar));
        Object g2 = kVar.g();
        if (g2 == a.a()) {
            f.c(cVar);
        }
        return g2;
    }

    public static final <T> Object awaitResponse(Call<T> call, c<? super Response<T>> cVar) {
        k kVar = new k(a.a(cVar), 1);
        j jVar = kVar;
        jVar.a(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new KotlinExtensions$awaitResponse$2$2(jVar));
        Object g2 = kVar.g();
        if (g2 == a.a()) {
            f.c(cVar);
        }
        return g2;
    }

    public static final /* synthetic */ <T> T create(Retrofit retrofit3) {
        h.c(retrofit3, "$this$create");
        h.a(4, "T");
        return retrofit3.create(Object.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object suspendAndThrow(java.lang.Exception r4, kotlin.coroutines.c<?> r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.a()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.i.a((java.lang.Object) r5)
            goto L_0x0061
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.i.a((java.lang.Object) r5)
            r0.L$0 = r4
            r0.label = r3
            kotlin.coroutines.c r0 = (kotlin.coroutines.c) r0
            kotlinx.coroutines.aa r5 = kotlinx.coroutines.ap.a()
            kotlin.coroutines.f r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>(r0, r4)
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r5.a(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.a.a()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.a.a()
            if (r4 != r5) goto L_0x005e
            kotlin.coroutines.jvm.internal.f.c(r0)
        L_0x005e:
            if (r4 != r1) goto L_0x0061
            return r1
        L_0x0061:
            kotlin.l r4 = kotlin.l.f30254a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, kotlin.coroutines.c):java.lang.Object");
    }
}
