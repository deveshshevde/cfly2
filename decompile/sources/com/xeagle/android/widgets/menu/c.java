package com.xeagle.android.widgets.menu;

import android.view.animation.Interpolator;

public class c implements Interpolator {
    public float getInterpolation(float f2) {
        float f3 = (f2 * 2.0f) - 1.0f;
        return ((f3 * f3 * f3) + 1.0f) * 0.5f;
    }
}
