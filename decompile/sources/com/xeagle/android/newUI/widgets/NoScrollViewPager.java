package com.xeagle.android.newUI.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24114a = true;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f24114a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f24114a) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i2, int i3) {
        super.scrollTo(i2, i3);
    }

    public void setCurrentItem(int i2) {
        super.setCurrentItem(i2, false);
    }

    public void setCurrentItem(int i2, boolean z2) {
        super.setCurrentItem(i2, z2);
    }

    public void setNoScroll(boolean z2) {
        this.f24114a = z2;
    }
}
