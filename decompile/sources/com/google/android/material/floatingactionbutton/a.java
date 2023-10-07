package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

class a {

    /* renamed from: a  reason: collision with root package name */
    private Animator f19088a;

    a() {
    }

    public void a() {
        Animator animator = this.f19088a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void a(Animator animator) {
        a();
        this.f19088a = animator;
    }

    public void b() {
        this.f19088a = null;
    }
}
