package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    TextInputLayout f19844a;

    /* renamed from: b  reason: collision with root package name */
    Context f19845b;

    /* renamed from: c  reason: collision with root package name */
    CheckableImageButton f19846c;

    e(TextInputLayout textInputLayout) {
        this.f19844a = textInputLayout;
        this.f19845b = textInputLayout.getContext();
        this.f19846c = textInputLayout.getEndIconView();
    }

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return false;
    }
}
