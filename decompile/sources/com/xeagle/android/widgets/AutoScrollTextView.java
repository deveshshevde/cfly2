package com.xeagle.android.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoScrollTextView extends TextView {
    public AutoScrollTextView(Context context) {
        super(context);
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoScrollTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean isFocused() {
        return true;
    }
}
