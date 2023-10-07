package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;
import my.b;
import mz.c;
import na.a;

public class BezierPagerIndicator extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f31465a;

    /* renamed from: b  reason: collision with root package name */
    private float f31466b;

    /* renamed from: c  reason: collision with root package name */
    private float f31467c;

    /* renamed from: d  reason: collision with root package name */
    private float f31468d;

    /* renamed from: e  reason: collision with root package name */
    private float f31469e;

    /* renamed from: f  reason: collision with root package name */
    private float f31470f;

    /* renamed from: g  reason: collision with root package name */
    private float f31471g;

    /* renamed from: h  reason: collision with root package name */
    private float f31472h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f31473i;

    /* renamed from: j  reason: collision with root package name */
    private Path f31474j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f31475k;

    /* renamed from: l  reason: collision with root package name */
    private Interpolator f31476l = new AccelerateInterpolator();

    /* renamed from: m  reason: collision with root package name */
    private Interpolator f31477m = new DecelerateInterpolator();

    public BezierPagerIndicator(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f31473i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f31471g = (float) b.a(context, 3.5d);
        this.f31472h = (float) b.a(context, 2.0d);
        this.f31470f = (float) b.a(context, 1.5d);
    }

    private void a(Canvas canvas) {
        this.f31474j.reset();
        float height = (((float) getHeight()) - this.f31470f) - this.f31471g;
        this.f31474j.moveTo(this.f31469e, height);
        this.f31474j.lineTo(this.f31469e, height - this.f31468d);
        Path path = this.f31474j;
        float f2 = this.f31469e;
        float f3 = this.f31467c;
        path.quadTo(f2 + ((f3 - f2) / 2.0f), height, f3, height - this.f31466b);
        this.f31474j.lineTo(this.f31467c, this.f31466b + height);
        Path path2 = this.f31474j;
        float f4 = this.f31469e;
        path2.quadTo(((this.f31467c - f4) / 2.0f) + f4, height, f4, this.f31468d + height);
        this.f31474j.close();
        canvas.drawPath(this.f31474j, this.f31473i);
    }

    public void a(int i2) {
    }

    public void a(int i2, float f2, int i3) {
        List<a> list = this.f31465a;
        if (list != null && !list.isEmpty()) {
            List<Integer> list2 = this.f31475k;
            if (list2 != null && list2.size() > 0) {
                this.f31473i.setColor(my.a.a(f2, this.f31475k.get(Math.abs(i2) % this.f31475k.size()).intValue(), this.f31475k.get(Math.abs(i2 + 1) % this.f31475k.size()).intValue()));
            }
            a a2 = net.lucode.hackware.magicindicator.a.a(this.f31465a, i2);
            a a3 = net.lucode.hackware.magicindicator.a.a(this.f31465a, i2 + 1);
            float f3 = (float) (a2.f31303a + ((a2.f31305c - a2.f31303a) / 2));
            float f4 = ((float) (a3.f31303a + ((a3.f31305c - a3.f31303a) / 2))) - f3;
            this.f31467c = (this.f31476l.getInterpolation(f2) * f4) + f3;
            this.f31469e = f3 + (f4 * this.f31477m.getInterpolation(f2));
            float f5 = this.f31471g;
            this.f31466b = f5 + ((this.f31472h - f5) * this.f31477m.getInterpolation(f2));
            float f6 = this.f31472h;
            this.f31468d = f6 + ((this.f31471g - f6) * this.f31476l.getInterpolation(f2));
            invalidate();
        }
    }

    public void a(List<a> list) {
        this.f31465a = list;
    }

    public void b(int i2) {
    }

    public float getMaxCircleRadius() {
        return this.f31471g;
    }

    public float getMinCircleRadius() {
        return this.f31472h;
    }

    public float getYOffset() {
        return this.f31470f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f31467c, (((float) getHeight()) - this.f31470f) - this.f31471g, this.f31466b, this.f31473i);
        canvas.drawCircle(this.f31469e, (((float) getHeight()) - this.f31470f) - this.f31471g, this.f31468d, this.f31473i);
        a(canvas);
    }

    public void setColors(Integer... numArr) {
        this.f31475k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f31477m = interpolator;
        if (interpolator == null) {
            this.f31477m = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f2) {
        this.f31471g = f2;
    }

    public void setMinCircleRadius(float f2) {
        this.f31472h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f31476l = interpolator;
        if (interpolator == null) {
            this.f31476l = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f2) {
        this.f31470f = f2;
    }
}
