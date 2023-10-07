package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.bx;
import mm.m;

final class ThreadContextKt$findOne$1 extends Lambda implements m<bx<?>, f.b, bx<?>> {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadContextKt$findOne$1 f30380a = new ThreadContextKt$findOne$1();

    ThreadContextKt$findOne$1() {
        super(2);
    }

    public final bx<?> a(bx<?> bxVar, f.b bVar) {
        if (bxVar != null) {
            return bxVar;
        }
        if (!(bVar instanceof bx)) {
            bVar = null;
        }
        return (bx) bVar;
    }
}
