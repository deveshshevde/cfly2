package com.xeagle.android.widgets.marquee;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class MarqueeMustView extends AppCompatTextView {
    public MarqueeMustView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MarqueeMustView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
        setFocusable(true);
        setMarqueeRepeatLimit(-1);
        setFocusableInTouchMode(true);
    }

    public boolean isFocused() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        if (z2) {
            super.onFocusChanged(z2, i2, rect);
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        if (z2) {
            super.onWindowFocusChanged(z2);
        }
    }
}
