package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.ui.spherical.a;

class e extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, a.C0117a {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f16910a = new PointF();

    /* renamed from: b  reason: collision with root package name */
    private final PointF f16911b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private final a f16912c;

    /* renamed from: d  reason: collision with root package name */
    private final float f16913d;

    /* renamed from: e  reason: collision with root package name */
    private final GestureDetector f16914e;

    /* renamed from: f  reason: collision with root package name */
    private volatile float f16915f;

    /* renamed from: g  reason: collision with root package name */
    private d f16916g;

    interface a {
        void a(PointF pointF);
    }

    public e(Context context, a aVar, float f2) {
        this.f16912c = aVar;
        this.f16913d = f2;
        this.f16914e = new GestureDetector(context, this);
        this.f16915f = 3.1415927f;
    }

    public void a(d dVar) {
        this.f16916g = dVar;
    }

    public void a(float[] fArr, float f2) {
        this.f16915f = -f2;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f16910a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float x2 = (motionEvent2.getX() - this.f16910a.x) / this.f16913d;
        float y2 = (motionEvent2.getY() - this.f16910a.y) / this.f16913d;
        this.f16910a.set(motionEvent2.getX(), motionEvent2.getY());
        double d2 = (double) this.f16915f;
        float cos = (float) Math.cos(d2);
        float sin = (float) Math.sin(d2);
        this.f16911b.x -= (cos * x2) - (sin * y2);
        this.f16911b.y += (sin * x2) + (cos * y2);
        PointF pointF = this.f16911b;
        pointF.y = Math.max(-45.0f, Math.min(45.0f, pointF.y));
        this.f16912c.a(this.f16911b);
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        d dVar = this.f16916g;
        if (dVar != null) {
            return dVar.a(motionEvent);
        }
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f16914e.onTouchEvent(motionEvent);
    }
}
