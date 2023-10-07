package cj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private final float f6237a;

    public c() {
        this(0.5f);
    }

    public c(float f2) {
        this.f6237a = f2;
    }

    public Animator[] a(View view) {
        return new ObjectAnimator[]{ObjectAnimator.ofFloat(view, "scaleX", new float[]{this.f6237a, 1.0f}), ObjectAnimator.ofFloat(view, "scaleY", new float[]{this.f6237a, 1.0f})};
    }
}
