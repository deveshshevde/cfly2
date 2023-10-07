package com.xeagle.android.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ZJTextView extends TextView {
    public ZJTextView(Context context) {
        super(context);
    }

    public ZJTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ZJTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        try {
            super.onMeasure(i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            setText(getText().toString());
            super.onMeasure(i2, i3);
        }
    }

    public void setGravity(int i2) {
        try {
            super.setGravity(i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            setText(getText().toString());
            super.setGravity(i2);
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (ArrayIndexOutOfBoundsException unused) {
            setText(charSequence.toString());
        }
    }
}
