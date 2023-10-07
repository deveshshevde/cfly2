package com.xeagle.android.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitsSystemWindowsFrameLayout extends FrameLayout {
    public FitsSystemWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitsSystemWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsSystemWindowsFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(new Rect(rect));
        return false;
    }
}
