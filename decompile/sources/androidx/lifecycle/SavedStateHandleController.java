package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.a;
import androidx.savedstate.c;

final class SavedStateHandleController implements k {

    /* renamed from: a  reason: collision with root package name */
    private final String f3591a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3592b = false;

    /* renamed from: c  reason: collision with root package name */
    private final x f3593c;

    static final class a implements a.C0039a {
        a() {
        }

        public void a(c cVar) {
            if (cVar instanceof ad) {
                ac viewModelStore = ((ad) cVar).getViewModelStore();
                androidx.savedstate.a savedStateRegistry = cVar.getSavedStateRegistry();
                for (String a2 : viewModelStore.a()) {
                    SavedStateHandleController.a(viewModelStore.a(a2), savedStateRegistry, cVar.getLifecycle());
                }
                if (!viewModelStore.a().isEmpty()) {
                    savedStateRegistry.a((Class<? extends a.C0039a>) a.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    SavedStateHandleController(String str, x xVar) {
        this.f3591a = str;
        this.f3593c = xVar;
    }

    static SavedStateHandleController a(androidx.savedstate.a aVar, Lifecycle lifecycle, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, x.a(aVar.a(str), bundle));
        savedStateHandleController.a(aVar, lifecycle);
        b(aVar, lifecycle);
        return savedStateHandleController;
    }

    static void a(aa aaVar, androidx.savedstate.a aVar, Lifecycle lifecycle) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) aaVar.b("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.a()) {
            savedStateHandleController.a(aVar, lifecycle);
            b(aVar, lifecycle);
        }
    }

    private static void b(final androidx.savedstate.a aVar, final Lifecycle lifecycle) {
        Lifecycle.State a2 = lifecycle.a();
        if (a2 == Lifecycle.State.INITIALIZED || a2.a(Lifecycle.State.STARTED)) {
            aVar.a((Class<? extends a.C0039a>) a.class);
        } else {
            lifecycle.a(new k() {
                public void a(n nVar, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_START) {
                        Lifecycle.this.b(this);
                        aVar.a((Class<? extends a.C0039a>) a.class);
                    }
                }
            });
        }
    }

    public void a(n nVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f3592b = false;
            nVar.getLifecycle().b(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(androidx.savedstate.a aVar, Lifecycle lifecycle) {
        if (!this.f3592b) {
            this.f3592b = true;
            lifecycle.a(this);
            aVar.a(this.f3591a, this.f3593c.a());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f3592b;
    }

    /* access modifiers changed from: package-private */
    public x b() {
        return this.f3593c;
    }
}
