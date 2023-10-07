package com.xeagle.android.vjoystick.IWidgets.phasedSeekbar;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    protected StateListDrawable[] f24722a;

    public d(Resources resources, int[] iArr) {
        int length = iArr.length;
        this.f24722a = new StateListDrawable[length];
        for (int i2 = 0; i2 < length; i2++) {
            Drawable drawable = resources.getDrawable(iArr[i2]);
            if (drawable instanceof StateListDrawable) {
                this.f24722a[i2] = (StateListDrawable) drawable;
            } else {
                this.f24722a[i2] = new StateListDrawable();
                this.f24722a[i2].addState(new int[0], drawable);
            }
        }
    }

    public int a() {
        return this.f24722a.length;
    }

    public StateListDrawable a(int i2) {
        return this.f24722a[i2];
    }
}
