package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public AnimatorSet f20002a;

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, View view2, boolean z2, boolean z3) {
        AnimatorSet animatorSet = this.f20002a;
        boolean z4 = animatorSet != null;
        if (z4) {
            animatorSet.cancel();
        }
        AnimatorSet b2 = b(view, view2, z2, z4);
        this.f20002a = b2;
        b2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                AnimatorSet unused = ExpandableTransformationBehavior.this.f20002a = null;
            }
        });
        this.f20002a.start();
        if (!z3) {
            this.f20002a.end();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract AnimatorSet b(View view, View view2, boolean z2, boolean z3);
}
