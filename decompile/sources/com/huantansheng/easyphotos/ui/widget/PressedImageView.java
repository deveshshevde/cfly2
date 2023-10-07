package com.huantansheng.easyphotos.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class PressedImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private float f20658a = 0.97f;

    public PressedImageView(Context context) {
        super(context);
    }

    public PressedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PressedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setPressed(boolean z2) {
        float f2;
        super.setPressed(z2);
        if (isPressed()) {
            setScaleX(this.f20658a);
            f2 = this.f20658a;
        } else {
            f2 = 1.0f;
            setScaleX(1.0f);
        }
        setScaleY(f2);
    }

    public void setScaleSize(float f2) {
        this.f20658a = f2;
    }
}
