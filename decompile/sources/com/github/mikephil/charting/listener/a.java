package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.b;
import com.github.mikephil.charting.listener.ChartTouchListener;
import fa.d;
import fg.e;
import fg.i;
import fg.j;

public class a extends ChartTouchListener<BarLineChartBase<? extends b<? extends fc.b<? extends Entry>>>> {

    /* renamed from: f  reason: collision with root package name */
    private Matrix f15056f = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    private Matrix f15057g = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    private e f15058h = e.a(0.0f, 0.0f);

    /* renamed from: i  reason: collision with root package name */
    private e f15059i = e.a(0.0f, 0.0f);

    /* renamed from: j  reason: collision with root package name */
    private float f15060j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f15061k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f15062l = 1.0f;

    /* renamed from: m  reason: collision with root package name */
    private fc.e f15063m;

    /* renamed from: n  reason: collision with root package name */
    private VelocityTracker f15064n;

    /* renamed from: o  reason: collision with root package name */
    private long f15065o = 0;

    /* renamed from: p  reason: collision with root package name */
    private e f15066p = e.a(0.0f, 0.0f);

    /* renamed from: q  reason: collision with root package name */
    private e f15067q = e.a(0.0f, 0.0f);

    /* renamed from: r  reason: collision with root package name */
    private float f15068r;

    /* renamed from: s  reason: collision with root package name */
    private float f15069s;

    public a(BarLineChartBase<? extends b<? extends fc.b<? extends Entry>>> barLineChartBase, Matrix matrix, float f2) {
        super(barLineChartBase);
        this.f15056f = matrix;
        this.f15068r = i.a(f2);
        this.f15069s = i.a(3.5f);
    }

    private void a(MotionEvent motionEvent, float f2, float f3) {
        this.f15040a = ChartTouchListener.ChartGesture.DRAG;
        this.f15056f.set(this.f15057g);
        b onChartGestureListener = ((BarLineChartBase) this.f15044e).getOnChartGestureListener();
        if (c()) {
            if (this.f15044e instanceof HorizontalBarChart) {
                f2 = -f2;
            } else {
                f3 = -f3;
            }
        }
        this.f15056f.postTranslate(f2, f3);
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, f2, f3);
        }
    }

    private static void a(e eVar, MotionEvent motionEvent) {
        eVar.f27222a = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        eVar.f27223b = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    private void c(MotionEvent motionEvent) {
        this.f15057g.set(this.f15056f);
        this.f15058h.f27222a = motionEvent.getX();
        this.f15058h.f27223b = motionEvent.getY();
        this.f15063m = ((BarLineChartBase) this.f15044e).b(motionEvent.getX(), motionEvent.getY());
    }

    private boolean c() {
        return (this.f15063m == null && ((BarLineChartBase) this.f15044e).v()) || (this.f15063m != null && ((BarLineChartBase) this.f15044e).c(this.f15063m.t()));
    }

    private void d(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            b onChartGestureListener = ((BarLineChartBase) this.f15044e).getOnChartGestureListener();
            float f2 = f(motionEvent);
            if (f2 > this.f15069s) {
                e a2 = a(this.f15059i.f27222a, this.f15059i.f27223b);
                j viewPortHandler = ((BarLineChartBase) this.f15044e).getViewPortHandler();
                boolean z2 = true;
                float f3 = 1.0f;
                if (this.f15041b == 4) {
                    this.f15040a = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f4 = f2 / this.f15062l;
                    if (f4 >= 1.0f) {
                        z2 = false;
                    }
                    boolean w2 = z2 ? viewPortHandler.w() : viewPortHandler.x();
                    boolean y2 = z2 ? viewPortHandler.y() : viewPortHandler.z();
                    float f5 = ((BarLineChartBase) this.f15044e).o() ? f4 : 1.0f;
                    if (((BarLineChartBase) this.f15044e).p()) {
                        f3 = f4;
                    }
                    if (y2 || w2) {
                        this.f15056f.set(this.f15057g);
                        this.f15056f.postScale(f5, f3, a2.f27222a, a2.f27223b);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, f5, f3);
                        }
                    }
                } else if (this.f15041b == 2 && ((BarLineChartBase) this.f15044e).o()) {
                    this.f15040a = ChartTouchListener.ChartGesture.X_ZOOM;
                    float g2 = g(motionEvent) / this.f15060j;
                    if (g2 >= 1.0f) {
                        z2 = false;
                    }
                    if (z2 ? viewPortHandler.w() : viewPortHandler.x()) {
                        this.f15056f.set(this.f15057g);
                        this.f15056f.postScale(g2, 1.0f, a2.f27222a, a2.f27223b);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, g2, 1.0f);
                        }
                    }
                } else if (this.f15041b == 3 && ((BarLineChartBase) this.f15044e).p()) {
                    this.f15040a = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float h2 = h(motionEvent) / this.f15061k;
                    if (h2 >= 1.0f) {
                        z2 = false;
                    }
                    if (z2 ? viewPortHandler.y() : viewPortHandler.z()) {
                        this.f15056f.set(this.f15057g);
                        this.f15056f.postScale(1.0f, h2, a2.f27222a, a2.f27223b);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.a(motionEvent, 1.0f, h2);
                        }
                    }
                }
                e.b(a2);
            }
        }
    }

    private void e(MotionEvent motionEvent) {
        d a2 = ((BarLineChartBase) this.f15044e).a(motionEvent.getX(), motionEvent.getY());
        if (a2 != null && !a2.a(this.f15042c)) {
            this.f15042c = a2;
            ((BarLineChartBase) this.f15044e).a(a2, true);
        }
    }

    private static float f(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        float y2 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x2 * x2) + (y2 * y2)));
    }

    private static float g(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public e a(float f2, float f3) {
        j viewPortHandler = ((BarLineChartBase) this.f15044e).getViewPortHandler();
        return e.a(f2 - viewPortHandler.a(), c() ? -(f3 - viewPortHandler.c()) : -((((float) ((BarLineChartBase) this.f15044e).getMeasuredHeight()) - f3) - viewPortHandler.d()));
    }

    public void a() {
        this.f15067q.f27222a = 0.0f;
        this.f15067q.f27223b = 0.0f;
    }

    public void b() {
        float f2 = 0.0f;
        if (this.f15067q.f27222a != 0.0f || this.f15067q.f27223b != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f15067q.f27222a *= ((BarLineChartBase) this.f15044e).getDragDecelerationFrictionCoef();
            this.f15067q.f27223b *= ((BarLineChartBase) this.f15044e).getDragDecelerationFrictionCoef();
            float f3 = ((float) (currentAnimationTimeMillis - this.f15065o)) / 1000.0f;
            float f4 = this.f15067q.f27222a * f3;
            float f5 = this.f15067q.f27223b * f3;
            this.f15066p.f27222a += f4;
            this.f15066p.f27223b += f5;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, this.f15066p.f27222a, this.f15066p.f27223b, 0);
            float f6 = ((BarLineChartBase) this.f15044e).m() ? this.f15066p.f27222a - this.f15058h.f27222a : 0.0f;
            if (((BarLineChartBase) this.f15044e).n()) {
                f2 = this.f15066p.f27223b - this.f15058h.f27223b;
            }
            a(obtain, f6, f2);
            obtain.recycle();
            this.f15056f = ((BarLineChartBase) this.f15044e).getViewPortHandler().a(this.f15056f, this.f15044e, false);
            this.f15065o = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f15067q.f27222a)) >= 0.01d || ((double) Math.abs(this.f15067q.f27223b)) >= 0.01d) {
                i.a((View) this.f15044e);
                return;
            }
            ((BarLineChartBase) this.f15044e).j();
            ((BarLineChartBase) this.f15044e).postInvalidate();
            a();
        }
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f15040a = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        b onChartGestureListener = ((BarLineChartBase) this.f15044e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent);
        }
        if (((BarLineChartBase) this.f15044e).q() && ((b) ((BarLineChartBase) this.f15044e).getData()).i() > 0) {
            e a2 = a(motionEvent.getX(), motionEvent.getY());
            BarLineChartBase barLineChartBase = (BarLineChartBase) this.f15044e;
            float f2 = 1.4f;
            float f3 = ((BarLineChartBase) this.f15044e).o() ? 1.4f : 1.0f;
            if (!((BarLineChartBase) this.f15044e).p()) {
                f2 = 1.0f;
            }
            barLineChartBase.a(f3, f2, a2.f27222a, a2.f27223b);
            if (((BarLineChartBase) this.f15044e).z()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + a2.f27222a + ", y: " + a2.f27223b);
            }
            e.b(a2);
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f15040a = ChartTouchListener.ChartGesture.FLING;
        b onChartGestureListener = ((BarLineChartBase) this.f15044e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, motionEvent2, f2, f3);
        }
        return super.onFling(motionEvent, motionEvent2, f2, f3);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f15040a = ChartTouchListener.ChartGesture.LONG_PRESS;
        b onChartGestureListener = ((BarLineChartBase) this.f15044e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f15040a = ChartTouchListener.ChartGesture.SINGLE_TAP;
        b onChartGestureListener = ((BarLineChartBase) this.f15044e).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
        if (!((BarLineChartBase) this.f15044e).w()) {
            return false;
        }
        a(((BarLineChartBase) this.f15044e).a(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.f15064n == null) {
            this.f15064n = VelocityTracker.obtain();
        }
        this.f15064n.addMovement(motionEvent);
        int i2 = 3;
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.f15064n) != null) {
            velocityTracker.recycle();
            this.f15064n = null;
        }
        if (this.f15041b == 0) {
            this.f15043d.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.f15044e).l() && !((BarLineChartBase) this.f15044e).o() && !((BarLineChartBase) this.f15044e).p()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            boolean z2 = false;
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.f15064n;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, (float) i.c());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > ((float) i.b()) || Math.abs(yVelocity) > ((float) i.b())) && this.f15041b == 1 && ((BarLineChartBase) this.f15044e).y()) {
                    a();
                    this.f15065o = AnimationUtils.currentAnimationTimeMillis();
                    this.f15066p.f27222a = motionEvent.getX();
                    this.f15066p.f27223b = motionEvent.getY();
                    this.f15067q.f27222a = xVelocity;
                    this.f15067q.f27223b = yVelocity;
                    i.a((View) this.f15044e);
                }
                if (this.f15041b == 2 || this.f15041b == 3 || this.f15041b == 4 || this.f15041b == 5) {
                    ((BarLineChartBase) this.f15044e).j();
                    ((BarLineChartBase) this.f15044e).postInvalidate();
                }
                this.f15041b = 0;
                ((BarLineChartBase) this.f15044e).B();
                VelocityTracker velocityTracker3 = this.f15064n;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f15064n = null;
                }
            } else if (action != 2) {
                if (action == 3) {
                    this.f15041b = 0;
                } else if (action != 5) {
                    if (action == 6) {
                        i.a(motionEvent, this.f15064n);
                        this.f15041b = 5;
                    }
                } else if (motionEvent.getPointerCount() >= 2) {
                    ((BarLineChartBase) this.f15044e).A();
                    c(motionEvent);
                    this.f15060j = g(motionEvent);
                    this.f15061k = h(motionEvent);
                    float f2 = f(motionEvent);
                    this.f15062l = f2;
                    if (f2 > 10.0f) {
                        if (((BarLineChartBase) this.f15044e).t()) {
                            this.f15041b = 4;
                        } else {
                            if (((BarLineChartBase) this.f15044e).o() == ((BarLineChartBase) this.f15044e).p() ? this.f15060j > this.f15061k : ((BarLineChartBase) this.f15044e).o()) {
                                i2 = 2;
                            }
                            this.f15041b = i2;
                        }
                    }
                    a(this.f15059i, motionEvent);
                }
            } else if (this.f15041b == 1) {
                ((BarLineChartBase) this.f15044e).A();
                float f3 = 0.0f;
                float x2 = ((BarLineChartBase) this.f15044e).m() ? motionEvent.getX() - this.f15058h.f27222a : 0.0f;
                if (((BarLineChartBase) this.f15044e).n()) {
                    f3 = motionEvent.getY() - this.f15058h.f27223b;
                }
                a(motionEvent, x2, f3);
            } else if (this.f15041b == 2 || this.f15041b == 3 || this.f15041b == 4) {
                ((BarLineChartBase) this.f15044e).A();
                if (((BarLineChartBase) this.f15044e).o() || ((BarLineChartBase) this.f15044e).p()) {
                    d(motionEvent);
                }
            } else if (this.f15041b == 0 && Math.abs(a(motionEvent.getX(), this.f15058h.f27222a, motionEvent.getY(), this.f15058h.f27223b)) > this.f15068r && ((BarLineChartBase) this.f15044e).l()) {
                if (!((BarLineChartBase) this.f15044e).s() || !((BarLineChartBase) this.f15044e).u()) {
                    z2 = true;
                }
                if (z2) {
                    float abs = Math.abs(motionEvent.getX() - this.f15058h.f27222a);
                    float abs2 = Math.abs(motionEvent.getY() - this.f15058h.f27223b);
                    if ((((BarLineChartBase) this.f15044e).m() || abs2 >= abs) && (((BarLineChartBase) this.f15044e).n() || abs2 <= abs)) {
                        this.f15040a = ChartTouchListener.ChartGesture.DRAG;
                        this.f15041b = 1;
                    }
                } else if (((BarLineChartBase) this.f15044e).k()) {
                    this.f15040a = ChartTouchListener.ChartGesture.DRAG;
                    if (((BarLineChartBase) this.f15044e).k()) {
                        e(motionEvent);
                    }
                }
            }
            b(motionEvent);
        } else {
            a(motionEvent);
            a();
            c(motionEvent);
        }
        this.f15056f = ((BarLineChartBase) this.f15044e).getViewPortHandler().a(this.f15056f, this.f15044e, true);
        return true;
    }
}
