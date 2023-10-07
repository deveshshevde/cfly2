package kotlin.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import mm.m;

final class CombinedContext$toString$1 extends Lambda implements m<String, f.b, String> {

    /* renamed from: a  reason: collision with root package name */
    public static final CombinedContext$toString$1 f30192a = new CombinedContext$toString$1();

    CombinedContext$toString$1() {
        super(2);
    }

    public final String a(String str, f.b bVar) {
        h.d(str, "acc");
        h.d(bVar, "element");
        if (str.length() == 0) {
            return bVar.toString();
        }
        return str + ", " + bVar;
    }
}
