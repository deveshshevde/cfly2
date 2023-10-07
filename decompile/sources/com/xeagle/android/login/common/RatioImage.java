package com.xeagle.android.login.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.xeagle.R;

public class RatioImage extends AppCompatImageView {
    private static final int sEnumHeight = 1;
    private static final int sEnumWidth = 0;
    private float ratioHeight;
    private float ratioWidth;
    private int standard;

    public RatioImage(Context context) {
        this(context, (AttributeSet) null);
    }

    public RatioImage(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RatioImage(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RatioImage, i2, 0);
        if (obtainStyledAttributes != null) {
            this.ratioWidth = obtainStyledAttributes.getFloat(1, 1.0f);
            this.ratioHeight = obtainStyledAttributes.getFloat(0, 1.0f);
            this.standard = obtainStyledAttributes.getInt(2, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int i4 = this.standard;
        if (i4 == 0) {
            measuredHeight = (int) ((((float) measuredWidth) / this.ratioWidth) * this.ratioHeight);
        } else if (i4 == 1) {
            measuredWidth = (int) ((((float) measuredHeight) / this.ratioHeight) * this.ratioWidth);
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}
