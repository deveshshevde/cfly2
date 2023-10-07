package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.i;
import kotlinx.coroutines.internal.e;

public final class ah {
    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String a(c<?> cVar) {
        Object obj;
        if (cVar instanceof e) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.f30171a;
            obj = Result.e(cVar + '@' + a((Object) cVar));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f30171a;
            obj = Result.e(i.a(th));
        }
        Throwable c2 = Result.c(obj);
        String str = obj;
        if (c2 != null) {
            str = cVar.getClass().getName() + '@' + a((Object) cVar);
        }
        return (String) str;
    }

    public static final String b(Object obj) {
        return obj.getClass().getSimpleName();
    }
}
