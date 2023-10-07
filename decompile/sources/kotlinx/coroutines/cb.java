package kotlinx.coroutines;

import kotlin.coroutines.f;

public final class cb extends aa {

    /* renamed from: b  reason: collision with root package name */
    public static final cb f30368b = new cb();

    private cb() {
    }

    public void a(f fVar, Runnable runnable) {
        cd cdVar = (cd) fVar.get(cd.f30369b);
        if (cdVar != null) {
            cdVar.f30370a = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    public boolean a(f fVar) {
        return false;
    }

    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
