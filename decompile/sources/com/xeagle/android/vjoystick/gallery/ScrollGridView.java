package com.xeagle.android.vjoystick.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

public class ScrollGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private a f25294a;

    public interface a {
        boolean a(int i2);
    }

    public ScrollGridView(Context context) {
        super(context);
    }

    public ScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f25294a != null) {
            if (!isEnabled()) {
                return isClickable() || isLongClickable();
            }
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (motionEvent.getAction() == 1 && pointToPosition == -1) {
                super.onTouchEvent(motionEvent);
                return this.f25294a.a(pointToPosition);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnTouchInvalidPositionListener(a aVar) {
        this.f25294a = aVar;
    }
}
