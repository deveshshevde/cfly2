package com.xeagle.android.widgets.spinnerWheel;

import android.content.Context;
import android.view.MotionEvent;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.xeagle.android.widgets.spinnerWheel.g;

public class e extends g {
    public e(Context context, g.a aVar) {
        super(context, aVar);
    }

    /* access modifiers changed from: protected */
    public float a(MotionEvent motionEvent, float f2, float f3) {
        float x2 = motionEvent.getX() - f2;
        if (Math.abs(x2) > Math.abs(motionEvent.getY() - f3)) {
            return x2;
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public int a() {
        return this.f26074a.getCurrX();
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        this.f26074a.startScroll(0, 0, i2, 0, i3);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, int i4) {
        this.f26074a.fling(i2, 0, -i3, 0, -2147483647, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0, 0);
    }

    /* access modifiers changed from: protected */
    public int b() {
        return this.f26074a.getFinalX();
    }
}
