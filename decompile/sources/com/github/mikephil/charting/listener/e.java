package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import fg.i;
import java.util.ArrayList;

public class e extends ChartTouchListener<PieRadarChartBase<?>> {

    /* renamed from: f  reason: collision with root package name */
    private fg.e f15070f = fg.e.a(0.0f, 0.0f);

    /* renamed from: g  reason: collision with root package name */
    private float f15071g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<a> f15072h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private long f15073i = 0;

    /* renamed from: j  reason: collision with root package name */
    private float f15074j = 0.0f;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        public long f15075a;

        /* renamed from: b  reason: collision with root package name */
        public float f15076b;

        public a(long j2, float f2) {
            this.f15075a = j2;
            this.f15076b = f2;
        }
    }

    public e(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
    }

    private void c() {
        this.f15072h.clear();
    }

    private void c(float f2, float f3) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f15072h.add(new a(currentAnimationTimeMillis, ((PieRadarChartBase) this.f15044e).b(f2, f3)));
        for (int size = this.f15072h.size(); size - 2 > 0 && currentAnimationTimeMillis - this.f15072h.get(0).f15075a > 1000; size--) {
            this.f15072h.remove(0);
        }
    }

    private float d() {
        if (this.f15072h.isEmpty()) {
            return 0.0f;
        }
        boolean z2 = false;
        a aVar = this.f15072h.get(0);
        ArrayList<a> arrayList = this.f15072h;
        a aVar2 = arrayList.get(arrayList.size() - 1);
        a aVar3 = aVar;
        for (int size = this.f15072h.size() - 1; size >= 0; size--) {
            aVar3 = this.f15072h.get(size);
            if (aVar3.f15076b != aVar2.f15076b) {
                break;
            }
        }
        float f2 = ((float) (aVar2.f15075a - aVar.f15075a)) / 1000.0f;
        if (f2 == 0.0f) {
            f2 = 0.1f;
        }
        if (aVar2.f15076b >= aVar3.f15076b) {
            z2 = true;
        }
        if (((double) Math.abs(aVar2.f15076b - aVar3.f15076b)) > 270.0d) {
            z2 = !z2;
        }
        if (((double) (aVar2.f15076b - aVar.f15076b)) > 180.0d) {
            double d2 = (double) aVar.f15076b;
            Double.isNaN(d2);
            aVar.f15076b = (float) (d2 + 360.0d);
        } else if (((double) (aVar.f15076b - aVar2.f15076b)) > 180.0d) {
            double d3 = (double) aVar2.f15076b;
            Double.isNaN(d3);
            aVar2.f15076b = (float) (d3 + 360.0d);
        }
        float abs = Math.abs((aVar2.f15076b - aVar.f15076b) / f2);
        return !z2 ? -abs : abs;
    }

    public void a() {
        this.f15074j = 0.0f;
    }

    public void a(float f2, float f3) {
        this.f15071g = ((PieRadarChartBase) this.f15044e).b(f2, f3) - ((PieRadarChartBase) this.f15044e).getRawRotationAngle();
    }

    public void b() {
        if (this.f15074j != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f15074j *= ((PieRadarChartBase) this.f15044e).getDragDecelerationFrictionCoef();
            ((PieRadarChartBase) this.f15044e).setRotationAngle(((PieRadarChartBase) this.f15044e).getRotationAngle() + (this.f15074j * (((float) (currentAnimationTimeMillis - this.f15073i)) / 1000.0f)));
            this.f15073i = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f15074j)) >= 0.001d) {
                i.a((View) this.f15044e);
            } else {
                a();
            }
        }
    }

    public void b(float f2, float f3) {
        ((PieRadarChartBase) this.f15044e).setRotationAngle(((PieRadarChartBase) this.f15044e).b(f2, f3) - this.f15071g);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f15040a = ChartTouchListener.ChartGesture.LONG_PRESS;
        b onChartGestureListener = ((PieRadarChartBase) this.f15044e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f15040a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        b onChartGestureListener = ((PieRadarChartBase) this.f15044e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (!((PieRadarChartBase) this.f15044e).w()) {
            return false;
        }
        a(((PieRadarChartBase) this.f15044e).a(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f15043d.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.f15044e).k()) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (((PieRadarChartBase) this.f15044e).y()) {
                        a();
                        c(x2, y2);
                        float d2 = d();
                        this.f15074j = d2;
                        if (d2 != 0.0f) {
                            this.f15073i = AnimationUtils.currentAnimationTimeMillis();
                            i.a((View) this.f15044e);
                        }
                    }
                    ((PieRadarChartBase) this.f15044e).B();
                    this.f15041b = 0;
                } else if (action == 2) {
                    if (((PieRadarChartBase) this.f15044e).y()) {
                        c(x2, y2);
                    }
                    if (this.f15041b == 0 && a(x2, this.f15070f.f27222a, y2, this.f15070f.f27223b) > i.a(8.0f)) {
                        this.f15040a = ChartTouchListener.ChartGesture.ROTATE;
                        this.f15041b = 6;
                        ((PieRadarChartBase) this.f15044e).A();
                    } else if (this.f15041b == 6) {
                        b(x2, y2);
                        ((PieRadarChartBase) this.f15044e).invalidate();
                    }
                }
                b(motionEvent);
            } else {
                a(motionEvent);
                a();
                c();
                if (((PieRadarChartBase) this.f15044e).y()) {
                    c(x2, y2);
                }
                a(x2, y2);
                this.f15070f.f27222a = x2;
                this.f15070f.f27223b = y2;
            }
        }
        return true;
    }
}
