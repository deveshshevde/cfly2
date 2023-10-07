package com.huantansheng.easyphotos.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class PressedTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private float f20659a = 1.1f;

    /* renamed from: b  reason: collision with root package name */
    private AnimatorSet f20660b;

    /* renamed from: c  reason: collision with root package name */
    private int f20661c = 1;

    public PressedTextView(Context context) {
        super(context);
    }

    public PressedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PressedTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setPressed(boolean z2) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        super.setPressed(z2);
        if (isPressed()) {
            this.f20661c = 1;
            if (this.f20660b == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f20660b = animatorSet;
                animatorSet.setDuration(5);
            }
            if (this.f20660b.isRunning()) {
                this.f20660b.cancel();
            }
            ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, this.f20659a});
            ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, this.f20659a});
        } else if (this.f20661c == 1) {
            this.f20661c = 2;
            if (this.f20660b == null) {
                AnimatorSet animatorSet2 = new AnimatorSet();
                this.f20660b = animatorSet2;
                animatorSet2.setDuration(5);
            }
            if (this.f20660b.isRunning()) {
                this.f20660b.cancel();
            }
            ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{this.f20659a, 1.0f});
            ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{this.f20659a, 1.0f});
        } else {
            return;
        }
        this.f20660b.play(ofFloat).with(ofFloat2);
        this.f20660b.start();
    }

    public void setPressedScale(float f2) {
        this.f20659a = f2;
    }
}
