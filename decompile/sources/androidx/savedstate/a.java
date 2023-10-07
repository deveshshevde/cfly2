package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    boolean f4483a = true;

    /* renamed from: b  reason: collision with root package name */
    private h.b<String, b> f4484b = new h.b<>();

    /* renamed from: c  reason: collision with root package name */
    private Bundle f4485c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4486d;

    /* renamed from: e  reason: collision with root package name */
    private Recreator.a f4487e;

    /* renamed from: androidx.savedstate.a$a  reason: collision with other inner class name */
    public interface C0039a {
        void a(c cVar);
    }

    public interface b {
        Bundle a();
    }

    a() {
    }

    public Bundle a(String str) {
        if (this.f4486d) {
            Bundle bundle = this.f4485c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f4485c.remove(str);
            if (this.f4485c.isEmpty()) {
                this.f4485c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f4485c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        h.b<K, V>.d c2 = this.f4484b.c();
        while (c2.hasNext()) {
            Map.Entry entry = (Map.Entry) c2.next();
            bundle2.putBundle((String) entry.getKey(), ((b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    /* access modifiers changed from: package-private */
    public void a(Lifecycle lifecycle, Bundle bundle) {
        if (!this.f4486d) {
            if (bundle != null) {
                this.f4485c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            lifecycle.a(new SavedStateRegistry$1(this));
            this.f4486d = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    public void a(Class<? extends C0039a> cls) {
        if (this.f4483a) {
            if (this.f4487e == null) {
                this.f4487e = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                this.f4487e.a(cls.getName());
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public void a(String str, b bVar) {
        if (this.f4484b.a(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }
}
