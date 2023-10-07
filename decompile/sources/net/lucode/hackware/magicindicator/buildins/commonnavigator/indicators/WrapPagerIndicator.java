package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import my.b;
import mz.c;
import na.a;

public class WrapPagerIndicator extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    private int f31507a;

    /* renamed from: b  reason: collision with root package name */
    private int f31508b;

    /* renamed from: c  reason: collision with root package name */
    private int f31509c;

    /* renamed from: d  reason: collision with root package name */
    private float f31510d;

    /* renamed from: e  reason: collision with root package name */
    private Interpolator f31511e = new LinearInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private Interpolator f31512f = new LinearInterpolator();

    /* renamed from: g  reason: collision with root package name */
    private List<a> f31513g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f31514h;

    /* renamed from: i  reason: collision with root package name */
    private RectF f31515i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private boolean f31516j;

    public WrapPagerIndicator(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f31514h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f31507a = b.a(context, 6.0d);
        this.f31508b = b.a(context, 10.0d);
    }

    public void a(int i2) {
    }

    public void a(int i2, float f2, int i3) {
        List<a> list = this.f31513g;
        if (list != null && !list.isEmpty()) {
            a a2 = net.lucode.hackware.magicindicator.a.a(this.f31513g, i2);
            a a3 = net.lucode.hackware.magicindicator.a.a(this.f31513g, i2 + 1);
            this.f31515i.left = ((float) (a2.f31307e - this.f31508b)) + (((float) (a3.f31307e - a2.f31307e)) * this.f31512f.getInterpolation(f2));
            this.f31515i.top = (float) (a2.f31308f - this.f31507a);
            this.f31515i.right = ((float) (a2.f31309g + this.f31508b)) + (((float) (a3.f31309g - a2.f31309g)) * this.f31511e.getInterpolation(f2));
            this.f31515i.bottom = (float) (a2.f31310h + this.f31507a);
            if (!this.f31516j) {
                this.f31510d = this.f31515i.height() / 2.0f;
            }
            invalidate();
        }
    }

    public void a(List<a> list) {
        this.f31513g = list;
    }

    public void b(int i2) {
    }

    public Interpolator getEndInterpolator() {
        return this.f31512f;
    }

    public int getFillColor() {
        return this.f31509c;
    }

    public int getHorizontalPadding() {
        return this.f31508b;
    }

    public Paint getPaint() {
        return this.f31514h;
    }

    public float getRoundRadius() {
        return this.f31510d;
    }

    public Interpolator getStartInterpolator() {
        return this.f31511e;
    }

    public int getVerticalPadding() {
        return this.f31507a;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f31514h.setColor(this.f31509c);
        RectF rectF = this.f31515i;
        float f2 = this.f31510d;
        canvas.drawRoundRect(rectF, f2, f2, this.f31514h);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f31512f = interpolator;
        if (interpolator == null) {
            this.f31512f = new LinearInterpolator();
        }
    }

    public void setFillColor(int i2) {
        this.f31509c = i2;
    }

    public void setHorizontalPadding(int i2) {
        this.f31508b = i2;
    }

    public void setRoundRadius(float f2) {
        this.f31510d = f2;
        this.f31516j = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f31511e = interpolator;
        if (interpolator == null) {
            this.f31511e = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i2) {
        this.f31507a = i2;
    }
}
