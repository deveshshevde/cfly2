package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.b;

class ReflectiveGenericLifecycleObserver implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Object f3589a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a f3590b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3589a = obj;
        this.f3590b = b.f3605a.b(obj.getClass());
    }

    public void a(n nVar, Lifecycle.Event event) {
        this.f3590b.a(nVar, event, this.f3589a);
    }
}
