package com.huantansheng.easyphotos.models.puzzle;

import android.content.Context;
import android.util.AttributeSet;

public class SquarePuzzleView extends PuzzleView {
    public SquarePuzzleView(Context context) {
        super(context);
    }

    public SquarePuzzleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquarePuzzleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight;
        }
        setMeasuredDimension(measuredWidth, measuredWidth);
    }
}
