package com.xeagle.android.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class FitsSystemWindowsRelativeLayout extends RelativeLayout {
    public FitsSystemWindowsRelativeLayout(Context context) {
        super(context);
    }

    public FitsSystemWindowsRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsSystemWindowsRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        super.fitSystemWindows(new Rect(rect));
        return false;
    }
}
