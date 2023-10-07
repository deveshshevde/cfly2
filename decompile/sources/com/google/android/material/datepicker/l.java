package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

abstract class l<S> extends Fragment {

    /* renamed from: e  reason: collision with root package name */
    protected final LinkedHashSet<k<S>> f19017e = new LinkedHashSet<>();

    l() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(k<S> kVar) {
        return this.f19017e.add(kVar);
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.f19017e.clear();
    }
}
