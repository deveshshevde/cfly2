package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final c f4488a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4489b = new a();

    private b(c cVar) {
        this.f4488a = cVar;
    }

    public static b a(c cVar) {
        return new b(cVar);
    }

    public a a() {
        return this.f4489b;
    }

    public void a(Bundle bundle) {
        Lifecycle lifecycle = this.f4488a.getLifecycle();
        if (lifecycle.a() == Lifecycle.State.INITIALIZED) {
            lifecycle.a(new Recreator(this.f4488a));
            this.f4489b.a(lifecycle, bundle);
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        this.f4489b.a(bundle);
    }
}
