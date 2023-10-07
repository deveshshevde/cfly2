package com.ctoo.mediaedit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class SViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f11026a = false;

    public SViewPager(Context context) {
        super(context);
    }

    public SViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f11026a) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f11026a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCanScroll(boolean z2) {
        this.f11026a = z2;
    }

    public void setCurrentItem(int i2) {
        super.setCurrentItem(i2, false);
    }

    public void setCurrentItem(int i2, boolean z2) {
        super.setCurrentItem(i2, z2);
    }
}
