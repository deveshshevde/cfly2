package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;
import my.b;
import mz.c;
import na.a;

public class LinePagerIndicator extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f31478a;

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f31479b = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f31480c = new LinearInterpolator();

    /* renamed from: d  reason: collision with root package name */
    private float f31481d;

    /* renamed from: e  reason: collision with root package name */
    private float f31482e;

    /* renamed from: f  reason: collision with root package name */
    private float f31483f;

    /* renamed from: g  reason: collision with root package name */
    private float f31484g;

    /* renamed from: h  reason: collision with root package name */
    private float f31485h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f31486i;

    /* renamed from: j  reason: collision with root package name */
    private List<a> f31487j;

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f31488k;

    /* renamed from: l  reason: collision with root package name */
    private RectF f31489l = new RectF();

    public LinePagerIndicator(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f31486i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f31482e = (float) b.a(context, 3.0d);
        this.f31484g = (float) b.a(context, 10.0d);
    }

    public void a(int i2) {
    }

    public void a(int i2, float f2, int i3) {
        float f3;
        float f4;
        float f5;
        float f6;
        int i4;
        List<a> list = this.f31487j;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.f31488k;
            if (list2 != null && list2.size() > 0) {
                this.f31486i.setColor(my.a.a(f2, this.f31488k.get(Math.abs(i2) % this.f31488k.size()).intValue(), this.f31488k.get(Math.abs(i2 + 1) % this.f31488k.size()).intValue()));
            }
            a a2 = net.lucode.hackware.magicindicator.a.a(this.f31487j, i2);
            a a3 = net.lucode.hackware.magicindicator.a.a(this.f31487j, i2 + 1);
            int i5 = this.f31478a;
            if (i5 == 0) {
                f6 = ((float) a2.f31303a) + this.f31483f;
                f5 = ((float) a3.f31303a) + this.f31483f;
                f3 = ((float) a2.f31305c) - this.f31483f;
                i4 = a3.f31305c;
            } else if (i5 == 1) {
                f6 = ((float) a2.f31307e) + this.f31483f;
                f5 = ((float) a3.f31307e) + this.f31483f;
                f3 = ((float) a2.f31309g) - this.f31483f;
                i4 = a3.f31309g;
            } else {
                f6 = ((float) a2.f31303a) + ((((float) a2.a()) - this.f31484g) / 2.0f);
                f5 = ((float) a3.f31303a) + ((((float) a3.a()) - this.f31484g) / 2.0f);
                f3 = ((((float) a2.a()) + this.f31484g) / 2.0f) + ((float) a2.f31303a);
                f4 = ((((float) a3.a()) + this.f31484g) / 2.0f) + ((float) a3.f31303a);
                this.f31489l.left = f6 + ((f5 - f6) * this.f31479b.getInterpolation(f2));
                this.f31489l.right = f3 + ((f4 - f3) * this.f31480c.getInterpolation(f2));
                this.f31489l.top = (((float) getHeight()) - this.f31482e) - this.f31481d;
                this.f31489l.bottom = ((float) getHeight()) - this.f31481d;
                invalidate();
            }
            f4 = ((float) i4) - this.f31483f;
            this.f31489l.left = f6 + ((f5 - f6) * this.f31479b.getInterpolation(f2));
            this.f31489l.right = f3 + ((f4 - f3) * this.f31480c.getInterpolation(f2));
            this.f31489l.top = (((float) getHeight()) - this.f31482e) - this.f31481d;
            this.f31489l.bottom = ((float) getHeight()) - this.f31481d;
            invalidate();
        }
    }

    public void a(List<a> list) {
        this.f31487j = list;
    }

    public void b(int i2) {
    }

    public List<Integer> getColors() {
        return this.f31488k;
    }

    public Interpolator getEndInterpolator() {
        return this.f31480c;
    }

    public float getLineHeight() {
        return this.f31482e;
    }

    public float getLineWidth() {
        return this.f31484g;
    }

    public int getMode() {
        return this.f31478a;
    }

    public Paint getPaint() {
        return this.f31486i;
    }

    public float getRoundRadius() {
        return this.f31485h;
    }

    public Interpolator getStartInterpolator() {
        return this.f31479b;
    }

    public float getXOffset() {
        return this.f31483f;
    }

    public float getYOffset() {
        return this.f31481d;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f31489l;
        float f2 = this.f31485h;
        canvas.drawRoundRect(rectF, f2, f2, this.f31486i);
    }

    public void setColors(Integer... numArr) {
        this.f31488k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f31480c = interpolator;
        if (interpolator == null) {
            this.f31480c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f2) {
        this.f31482e = f2;
    }

    public void setLineWidth(float f2) {
        this.f31484g = f2;
    }

    public void setMode(int i2) {
        if (i2 == 2 || i2 == 0 || i2 == 1) {
            this.f31478a = i2;
            return;
        }
        throw new IllegalArgumentException("mode " + i2 + " not supported.");
    }

    public void setRoundRadius(float f2) {
        this.f31485h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f31479b = interpolator;
        if (interpolator == null) {
            this.f31479b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f2) {
        this.f31483f = f2;
    }

    public void setYOffset(float f2) {
        this.f31481d = f2;
    }
}
