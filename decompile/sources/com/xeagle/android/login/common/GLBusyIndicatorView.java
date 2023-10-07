package com.xeagle.android.login.common;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.b;
import com.cfly.uav_pro.R;

public class GLBusyIndicatorView extends AppCompatImageView {
    private static final TimeInterpolator sInterpolator = new LinearInterpolator();
    private boolean animEnabled = true;
    private ValueAnimator animator;
    private boolean attached;
    private float startRotation;

    public GLBusyIndicatorView(Context context) {
        super(context);
        init();
    }

    public GLBusyIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public GLBusyIndicatorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    private void init() {
        setImageDrawable(b.a(getContext(), (int) R.drawable.icon_loading));
    }

    private void startProgress() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.animator = null;
        }
        if (this.animEnabled) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.animator = ofFloat;
            ofFloat.setRepeatCount(-1);
            this.animator.setDuration(1000);
            this.animator.setInterpolator(sInterpolator);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GLBusyIndicatorView.this.updateRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.animator.start();
        }
    }

    private void stopProgress() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.animator = null;
        }
        updateRotation(0.0f);
    }

    /* access modifiers changed from: private */
    public void updateRotation(float f2) {
        setPivotX((float) (getMeasuredWidth() >> 1));
        setPivotY((float) (getMeasuredHeight() >> 1));
        setRotation((f2 * 360.0f) + this.startRotation);
    }

    public boolean isAnimEnabled() {
        return this.animEnabled;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attached = true;
        startProgress();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attached = false;
        stopProgress();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0) {
            startProgress();
        } else {
            stopProgress();
        }
    }

    public void setAnimEnabled(boolean z2) {
        if (this.animEnabled != z2) {
            this.animEnabled = z2;
            if (!z2 || !this.attached || getVisibility() != 0) {
                stopProgress();
            } else {
                startProgress();
            }
        }
    }

    public void setStartRotation(float f2) {
        this.startRotation = f2;
        updateRotation(0.0f);
    }
}
