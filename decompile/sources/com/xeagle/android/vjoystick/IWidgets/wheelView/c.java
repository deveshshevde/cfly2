package com.xeagle.android.vjoystick.IWidgets.wheelView;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import t.e;

public abstract class c extends RecyclerView.q {

    /* renamed from: a  reason: collision with root package name */
    private e f24767a;

    public c(Context context) {
        e eVar = new e(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }
        });
        this.f24767a = eVar;
        eVar.a(false);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(int i2);

    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        View a2 = recyclerView.a(motionEvent.getX(), motionEvent.getY());
        if (a2 == null || !this.f24767a.a(motionEvent)) {
            return false;
        }
        a(recyclerView.f(a2));
        return true;
    }
}
