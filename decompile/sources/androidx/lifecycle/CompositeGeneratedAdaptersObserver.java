package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

class CompositeGeneratedAdaptersObserver implements k {

    /* renamed from: a  reason: collision with root package name */
    private final f[] f3548a;

    CompositeGeneratedAdaptersObserver(f[] fVarArr) {
        this.f3548a = fVarArr;
    }

    public void a(n nVar, Lifecycle.Event event) {
        r rVar = new r();
        for (f a2 : this.f3548a) {
            a2.a(nVar, event, false, rVar);
        }
        for (f a3 : this.f3548a) {
            a3.a(nVar, event, true, rVar);
        }
    }
}
