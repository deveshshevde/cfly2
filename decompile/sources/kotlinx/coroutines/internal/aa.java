package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.bx;
import mm.m;

public final class aa {

    /* renamed from: a  reason: collision with root package name */
    private static final w f30386a = new w("ZERO");

    /* renamed from: b  reason: collision with root package name */
    private static final m<Object, f.b, Object> f30387b = ThreadContextKt$countAll$1.f30379a;

    /* renamed from: c  reason: collision with root package name */
    private static final m<bx<?>, f.b, bx<?>> f30388c = ThreadContextKt$findOne$1.f30380a;

    /* renamed from: d  reason: collision with root package name */
    private static final m<ad, f.b, ad> f30389d = ThreadContextKt$updateState$1.f30382a;

    /* renamed from: e  reason: collision with root package name */
    private static final m<ad, f.b, ad> f30390e = ThreadContextKt$restoreState$1.f30381a;

    public static final Object a(f fVar) {
        Object fold = fVar.fold(0, f30387b);
        h.a(fold);
        return fold;
    }

    public static final Object a(f fVar, Object obj) {
        if (obj == null) {
            obj = a(fVar);
        }
        if (obj == 0) {
            return f30386a;
        }
        if (obj instanceof Integer) {
            return fVar.fold(new ad(fVar, ((Number) obj).intValue()), f30389d);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((bx) obj).b(fVar);
    }

    public static final void b(f fVar, Object obj) {
        if (obj != f30386a) {
            if (obj instanceof ad) {
                ((ad) obj).b();
                fVar.fold(obj, f30390e);
                return;
            }
            Object fold = fVar.fold(null, f30388c);
            Objects.requireNonNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((bx) fold).a(fVar, obj);
        }
    }
}
