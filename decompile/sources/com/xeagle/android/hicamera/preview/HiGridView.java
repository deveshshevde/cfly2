package com.xeagle.android.hicamera.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

public class HiGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private int f23636a = 1;

    /* renamed from: b  reason: collision with root package name */
    private a f23637b;

    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    public HiGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(MotionEvent motionEvent) {
        a aVar;
        a aVar2;
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.f23636a == 0 && ((getChildAt(0) == null || getChildAt(0).getTop() >= 0) && (aVar2 = this.f23637b) != null && true == aVar2.a(motionEvent))) {
                    return true;
                }
            } else if (this.f23636a == 0 && (aVar = this.f23637b) != null) {
                return aVar.a(motionEvent);
            } else {
                this.f23636a = 1;
            }
        } else if (getFirstVisiblePosition() == 0) {
            this.f23636a = 0;
            a aVar3 = this.f23637b;
            if (aVar3 != null) {
                return aVar3.a(motionEvent);
            }
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (true == a(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void setOnToulisten(a aVar) {
        this.f23637b = aVar;
    }
}
