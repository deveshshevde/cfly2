package cj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final float f6236a;

    public a() {
        this(0.0f);
    }

    public a(float f2) {
        this.f6236a = f2;
    }

    public Animator[] a(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "alpha", new float[]{this.f6236a, 1.0f})};
    }
}
