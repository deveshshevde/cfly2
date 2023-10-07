package com.xeagle.android.vjoystick.shimmerFrameLayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

public class SlideButton extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f25362a;

    public SlideButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || this.f25362a.getBounds().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setThumb(Drawable drawable) {
        super.setThumb(drawable);
        this.f25362a = drawable;
    }
}
