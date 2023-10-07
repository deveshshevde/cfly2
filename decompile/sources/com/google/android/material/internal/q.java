package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class q implements r {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f19330a;

    q(View view) {
        this.f19330a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f19330a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f19330a.remove(drawable);
    }
}
