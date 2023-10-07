package net.lucode.hackware.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;
import my.b;

public class CircleNavigator extends View implements mx.a {

    /* renamed from: a  reason: collision with root package name */
    private int f31430a;

    /* renamed from: b  reason: collision with root package name */
    private int f31431b;

    /* renamed from: c  reason: collision with root package name */
    private int f31432c;

    /* renamed from: d  reason: collision with root package name */
    private int f31433d;

    /* renamed from: e  reason: collision with root package name */
    private int f31434e;

    /* renamed from: f  reason: collision with root package name */
    private int f31435f;

    /* renamed from: g  reason: collision with root package name */
    private Interpolator f31436g = new LinearInterpolator();

    /* renamed from: h  reason: collision with root package name */
    private Paint f31437h = new Paint(1);

    /* renamed from: i  reason: collision with root package name */
    private List<PointF> f31438i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private float f31439j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31440k;

    /* renamed from: l  reason: collision with root package name */
    private a f31441l;

    /* renamed from: m  reason: collision with root package name */
    private float f31442m;

    /* renamed from: n  reason: collision with root package name */
    private float f31443n;

    /* renamed from: o  reason: collision with root package name */
    private int f31444o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f31445p = true;

    public interface a {
        void a(int i2);
    }

    public CircleNavigator(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f31444o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f31430a = b.a(context, 3.0d);
        this.f31433d = b.a(context, 8.0d);
        this.f31432c = b.a(context, 1.0d);
    }

    private void a(Canvas canvas) {
        this.f31437h.setStyle(Paint.Style.STROKE);
        this.f31437h.setStrokeWidth((float) this.f31432c);
        int size = this.f31438i.size();
        for (int i2 = 0; i2 < size; i2++) {
            PointF pointF = this.f31438i.get(i2);
            canvas.drawCircle(pointF.x, pointF.y, (float) this.f31430a, this.f31437h);
        }
    }

    private void b(Canvas canvas) {
        this.f31437h.setStyle(Paint.Style.FILL);
        if (this.f31438i.size() > 0) {
            canvas.drawCircle(this.f31439j, (float) ((int) ((((float) getHeight()) / 2.0f) + 0.5f)), (float) this.f31430a, this.f31437h);
        }
    }

    private int c(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.f31435f;
            return (this.f31432c * 2) + (this.f31430a * i3 * 2) + ((i3 - 1) * this.f31433d) + getPaddingLeft() + getPaddingRight();
        } else if (mode != 1073741824) {
            return 0;
        } else {
            return size;
        }
    }

    private void c() {
        this.f31438i.clear();
        if (this.f31435f > 0) {
            int height = (int) ((((float) getHeight()) / 2.0f) + 0.5f);
            int i2 = this.f31430a;
            int i3 = (i2 * 2) + this.f31433d;
            int paddingLeft = i2 + ((int) ((((float) this.f31432c) / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i4 = 0; i4 < this.f31435f; i4++) {
                this.f31438i.add(new PointF((float) paddingLeft, (float) height));
                paddingLeft += i3;
            }
            this.f31439j = this.f31438i.get(this.f31434e).x;
        }
    }

    private int d(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.f31430a * 2) + (this.f31432c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    public void a() {
    }

    public void a(int i2) {
        this.f31434e = i2;
        if (!this.f31445p) {
            this.f31439j = this.f31438i.get(i2).x;
            invalidate();
        }
    }

    public void a(int i2, float f2, int i3) {
        if (this.f31445p && !this.f31438i.isEmpty()) {
            int min = Math.min(this.f31438i.size() - 1, i2);
            int min2 = Math.min(this.f31438i.size() - 1, i2 + 1);
            PointF pointF = this.f31438i.get(min);
            this.f31439j = pointF.x + ((this.f31438i.get(min2).x - pointF.x) * this.f31436g.getInterpolation(f2));
            invalidate();
        }
    }

    public void b() {
    }

    public void b(int i2) {
    }

    public a getCircleClickListener() {
        return this.f31441l;
    }

    public int getCircleColor() {
        return this.f31431b;
    }

    public int getCircleCount() {
        return this.f31435f;
    }

    public int getCircleSpacing() {
        return this.f31433d;
    }

    public int getRadius() {
        return this.f31430a;
    }

    public Interpolator getStartInterpolator() {
        return this.f31436g;
    }

    public int getStrokeWidth() {
        return this.f31432c;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f31437h.setColor(this.f31431b);
        a(canvas);
        b(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(c(i2), d(i3));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f31441l != null && Math.abs(x2 - this.f31442m) <= ((float) this.f31444o) && Math.abs(y2 - this.f31443n) <= ((float) this.f31444o)) {
                float f2 = Float.MAX_VALUE;
                int i2 = 0;
                for (int i3 = 0; i3 < this.f31438i.size(); i3++) {
                    float abs = Math.abs(this.f31438i.get(i3).x - x2);
                    if (abs < f2) {
                        i2 = i3;
                        f2 = abs;
                    }
                }
                this.f31441l.a(i2);
            }
        } else if (this.f31440k) {
            this.f31442m = x2;
            this.f31443n = y2;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCircleClickListener(a aVar) {
        if (!this.f31440k) {
            this.f31440k = true;
        }
        this.f31441l = aVar;
    }

    public void setCircleColor(int i2) {
        this.f31431b = i2;
        invalidate();
    }

    public void setCircleCount(int i2) {
        this.f31435f = i2;
    }

    public void setCircleSpacing(int i2) {
        this.f31433d = i2;
        c();
        invalidate();
    }

    public void setFollowTouch(boolean z2) {
        this.f31445p = z2;
    }

    public void setRadius(int i2) {
        this.f31430a = i2;
        c();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f31436g = interpolator;
        if (interpolator == null) {
            this.f31436g = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i2) {
        this.f31432c = i2;
        invalidate();
    }

    public void setTouchable(boolean z2) {
        this.f31440k = z2;
    }
}
