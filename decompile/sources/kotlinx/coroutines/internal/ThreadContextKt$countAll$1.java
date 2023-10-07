package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.bx;
import mm.m;

final class ThreadContextKt$countAll$1 extends Lambda implements m<Object, f.b, Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadContextKt$countAll$1 f30379a = new ThreadContextKt$countAll$1();

    ThreadContextKt$countAll$1() {
        super(2);
    }

    public final Object a(Object obj, f.b bVar) {
        if (!(bVar instanceof bx)) {
            return obj;
        }
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        int intValue = num != null ? num.intValue() : 1;
        return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
    }
}
