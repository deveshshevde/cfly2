package com.xeagle.android.vjoystick.IWidgets.wheelView;

import android.view.ViewGroup;

final class d {
    static double a(int i2, float f2) {
        double d2 = (double) i2;
        Double.isNaN(d2);
        double d3 = (double) f2;
        Double.isNaN(d3);
        return (d2 * 180.0d) / (d3 * 3.141592653589793d);
    }

    static ViewGroup.LayoutParams a(int i2, int i3) {
        return i2 == 1 ? new ViewGroup.LayoutParams(-1, i3) : new ViewGroup.LayoutParams(i3, -1);
    }
}
