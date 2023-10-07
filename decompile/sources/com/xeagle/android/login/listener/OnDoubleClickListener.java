package com.xeagle.android.login.listener;

import android.view.MotionEvent;
import android.view.View;

public class OnDoubleClickListener implements View.OnTouchListener {
    private static final long DOUBLE_TIME = 500;
    private int clickCount;
    private long firstClick;
    private OnDoubleClick onDoubleClick;
    private long secondClick;

    public interface OnDoubleClick {
        void onDouble();
    }

    public OnDoubleClickListener(OnDoubleClick onDoubleClick2) {
        this.onDoubleClick = onDoubleClick2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            return view.performClick();
        }
        if (motionEvent.getAction() == 0) {
            int i2 = this.clickCount + 1;
            this.clickCount = i2;
            if (i2 == 1) {
                this.firstClick = System.currentTimeMillis();
            } else {
                if (i2 == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.secondClick = currentTimeMillis;
                    if (currentTimeMillis - this.firstClick <= DOUBLE_TIME) {
                        this.firstClick = 0;
                        this.clickCount = 1;
                        OnDoubleClick onDoubleClick2 = this.onDoubleClick;
                        if (onDoubleClick2 != null) {
                            onDoubleClick2.onDouble();
                        }
                    } else {
                        this.firstClick = currentTimeMillis;
                        this.clickCount = 1;
                    }
                } else {
                    this.clickCount = 0;
                    this.firstClick = 0;
                }
                this.secondClick = 0;
            }
        }
        return false;
    }
}
