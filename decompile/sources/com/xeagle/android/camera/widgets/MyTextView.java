package com.xeagle.android.camera.widgets;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView {
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setTypeface(Typeface typeface, int i2) {
        String str;
        AssetManager assetManager;
        if (i2 == 1) {
            assetManager = getContext().getAssets();
            str = "fonts/STKaiti.ttf";
        } else {
            assetManager = getContext().getAssets();
            str = "fonts/FZJingLei.ttf";
        }
        super.setTypeface(Typeface.createFromAsset(assetManager, str));
    }
}
