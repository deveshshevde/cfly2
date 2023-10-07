package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import fa.d;

public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    protected ChartGesture f15040a = ChartGesture.NONE;

    /* renamed from: b  reason: collision with root package name */
    protected int f15041b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected d f15042c;

    /* renamed from: d  reason: collision with root package name */
    protected GestureDetector f15043d;

    /* renamed from: e  reason: collision with root package name */
    protected T f15044e;

    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t2) {
        this.f15044e = t2;
        this.f15043d = new GestureDetector(t2.getContext(), this);
    }

    protected static float a(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    public void a(MotionEvent motionEvent) {
        b onChartGestureListener = this.f15044e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.f15040a);
        }
    }

    public void a(d dVar) {
        this.f15042c = dVar;
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, MotionEvent motionEvent) {
        if (dVar == null || dVar.a(this.f15042c)) {
            this.f15044e.a((d) null, true);
            this.f15042c = null;
            return;
        }
        this.f15044e.a(dVar, true);
        this.f15042c = dVar;
    }

    public void b(MotionEvent motionEvent) {
        b onChartGestureListener = this.f15044e.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, this.f15040a);
        }
    }
}
