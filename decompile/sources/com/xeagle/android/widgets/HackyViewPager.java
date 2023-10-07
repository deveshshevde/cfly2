package com.xeagle.android.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class HackyViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f25596a = false;

    public HackyViewPager(Context context) {
        super(context);
    }

    public HackyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        this.f25596a = !this.f25596a;
    }

    public boolean b() {
        return this.f25596a;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f25596a) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f25596a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setLocked(boolean z2) {
        this.f25596a = z2;
    }
}
