package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

class BackgroundLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f20980a;

    public BackgroundLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BackgroundLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        a(getContext().getResources().getColor(R.color.kprogresshud_default_color), this.f20980a);
    }

    private void a(int i2, float f2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius(f2);
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(gradientDrawable);
        } else {
            setBackgroundDrawable(gradientDrawable);
        }
    }
}
