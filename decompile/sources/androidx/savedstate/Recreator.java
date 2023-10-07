package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.g;
import androidx.lifecycle.n;
import androidx.savedstate.a;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class Recreator implements g {

    /* renamed from: a  reason: collision with root package name */
    private final c f4480a;

    static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final Set<String> f4481a = new HashSet();

        a(a aVar) {
            aVar.a("androidx.savedstate.Restarter", (a.b) this);
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList(this.f4481a));
            return bundle;
        }

        /* access modifiers changed from: package-private */
        public void a(String str) {
            this.f4481a.add(str);
        }
    }

    Recreator(c cVar) {
        this.f4480a = cVar;
    }

    private void a(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(a.C0039a.class);
            try {
                Constructor<? extends U> declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((a.C0039a) declaredConstructor.newInstance(new Object[0])).a(this.f4480a);
                } catch (Exception e2) {
                    throw new RuntimeException("Failed to instantiate " + str, e2);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("Class " + str + " wasn't found", e4);
        }
    }

    public void a(n nVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            nVar.getLifecycle().b(this);
            Bundle a2 = this.f4480a.getSavedStateRegistry().a("androidx.savedstate.Restarter");
            if (a2 != null) {
                ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it2 = stringArrayList.iterator();
                    while (it2.hasNext()) {
                        a(it2.next());
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            return;
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
