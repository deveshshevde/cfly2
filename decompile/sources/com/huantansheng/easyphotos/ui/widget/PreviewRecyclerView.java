package com.huantansheng.easyphotos.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

public class PreviewRecyclerView extends RecyclerView {
    private boolean N;

    public PreviewRecyclerView(Context context) {
        super(context);
    }

    public PreviewRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            this.N = false;
        } else if (actionMasked == 5) {
            this.N = true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            this.N = false;
        } else if (actionMasked == 5) {
            this.N = true;
        }
        if (this.N) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
