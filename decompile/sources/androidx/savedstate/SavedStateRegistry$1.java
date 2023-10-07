package androidx.savedstate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.g;
import androidx.lifecycle.n;

class SavedStateRegistry$1 implements g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4482a;

    SavedStateRegistry$1(a aVar) {
        this.f4482a = aVar;
    }

    public void a(n nVar, Lifecycle.Event event) {
        a aVar;
        boolean z2;
        if (event == Lifecycle.Event.ON_START) {
            aVar = this.f4482a;
            z2 = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            aVar = this.f4482a;
            z2 = false;
        } else {
            return;
        }
        aVar.f4483a = z2;
    }
}
