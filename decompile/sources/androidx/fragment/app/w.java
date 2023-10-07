package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ac;
import androidx.lifecycle.ad;
import androidx.lifecycle.o;
import androidx.savedstate.a;
import androidx.savedstate.b;
import androidx.savedstate.c;

class w implements ad, c {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f3523a;

    /* renamed from: b  reason: collision with root package name */
    private final ac f3524b;

    /* renamed from: c  reason: collision with root package name */
    private o f3525c = null;

    /* renamed from: d  reason: collision with root package name */
    private b f3526d = null;

    w(Fragment fragment, ac acVar) {
        this.f3523a = fragment;
        this.f3524b = acVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f3525c == null) {
            this.f3525c = new o(this);
            this.f3526d = b.a((c) this);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Bundle bundle) {
        this.f3526d.a(bundle);
    }

    /* access modifiers changed from: package-private */
    public void a(Lifecycle.Event event) {
        this.f3525c.a(event);
    }

    /* access modifiers changed from: package-private */
    public void a(Lifecycle.State state) {
        this.f3525c.b(state);
    }

    /* access modifiers changed from: package-private */
    public void b(Bundle bundle) {
        this.f3526d.b(bundle);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f3525c != null;
    }

    public Lifecycle getLifecycle() {
        a();
        return this.f3525c;
    }

    public a getSavedStateRegistry() {
        a();
        return this.f3526d.a();
    }

    public ac getViewModelStore() {
        a();
        return this.f3524b;
    }
}
