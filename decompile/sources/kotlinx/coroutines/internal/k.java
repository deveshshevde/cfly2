package kotlinx.coroutines.internal;

import java.util.Objects;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f30412a = new w("CONDITION_FALSE");

    /* renamed from: b  reason: collision with root package name */
    private static final Object f30413b = new w("LIST_EMPTY");

    public static final Object a() {
        return f30412a;
    }

    public static final l a(Object obj) {
        l a2;
        s sVar = (s) (!(obj instanceof s) ? null : obj);
        if (sVar != null && (a2 = sVar.a()) != null) {
            return a2;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (l) obj;
    }
}
