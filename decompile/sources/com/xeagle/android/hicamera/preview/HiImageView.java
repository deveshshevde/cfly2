package com.xeagle.android.hicamera.preview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class HiImageView extends ImageView {
    public HiImageView(Context context) {
        super(context);
    }

    public HiImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Exception unused) {
            Log.d("HiImageView", "trying to use a recycled bitmap");
        }
    }
}
