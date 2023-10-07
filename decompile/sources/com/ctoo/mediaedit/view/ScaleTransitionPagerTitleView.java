package com.ctoo.mediaedit.view;

import android.content.Context;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

public class ScaleTransitionPagerTitleView extends ColorTransitionPagerTitleView {

    /* renamed from: c  reason: collision with root package name */
    private float f11022c = 0.9f;

    public ScaleTransitionPagerTitleView(Context context) {
        super(context);
    }

    public void a(int i2, int i3, float f2, boolean z2) {
        super.a(i2, i3, f2, z2);
        float f3 = this.f11022c;
        setScaleX(f3 + ((1.0f - f3) * f2));
        float f4 = this.f11022c;
        setScaleY(f4 + ((1.0f - f4) * f2));
    }

    public void b(int i2, int i3, float f2, boolean z2) {
        super.b(i2, i3, f2, z2);
        setScaleX(((this.f11022c - 1.0f) * f2) + 1.0f);
        setScaleY(((this.f11022c - 1.0f) * f2) + 1.0f);
    }

    public float getMinScale() {
        return this.f11022c;
    }

    public void setMinScale(float f2) {
        this.f11022c = f2;
    }
}
