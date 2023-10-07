package net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import my.b;
import mz.c;
import na.a;

public class TriangularPagerIndicator extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f31496a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f31497b;

    /* renamed from: c  reason: collision with root package name */
    private int f31498c;

    /* renamed from: d  reason: collision with root package name */
    private int f31499d;

    /* renamed from: e  reason: collision with root package name */
    private int f31500e;

    /* renamed from: f  reason: collision with root package name */
    private int f31501f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31502g;

    /* renamed from: h  reason: collision with root package name */
    private float f31503h;

    /* renamed from: i  reason: collision with root package name */
    private Path f31504i = new Path();

    /* renamed from: j  reason: collision with root package name */
    private Interpolator f31505j = new LinearInterpolator();

    /* renamed from: k  reason: collision with root package name */
    private float f31506k;

    public TriangularPagerIndicator(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f31497b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f31498c = b.a(context, 3.0d);
        this.f31501f = b.a(context, 14.0d);
        this.f31500e = b.a(context, 8.0d);
    }

    public void a(int i2) {
    }

    public void a(int i2, float f2, int i3) {
        List<a> list = this.f31496a;
        if (list != null && !list.isEmpty()) {
            a a2 = net.lucode.hackware.magicindicator.a.a(this.f31496a, i2);
            a a3 = net.lucode.hackware.magicindicator.a.a(this.f31496a, i2 + 1);
            float f3 = (float) (a2.f31303a + ((a2.f31305c - a2.f31303a) / 2));
            this.f31506k = f3 + ((((float) (a3.f31303a + ((a3.f31305c - a3.f31303a) / 2))) - f3) * this.f31505j.getInterpolation(f2));
            invalidate();
        }
    }

    public void a(List<a> list) {
        this.f31496a = list;
    }

    public void b(int i2) {
    }

    public int getLineColor() {
        return this.f31499d;
    }

    public int getLineHeight() {
        return this.f31498c;
    }

    public Interpolator getStartInterpolator() {
        return this.f31505j;
    }

    public int getTriangleHeight() {
        return this.f31500e;
    }

    public int getTriangleWidth() {
        return this.f31501f;
    }

    public float getYOffset() {
        return this.f31503h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        Path path;
        this.f31497b.setColor(this.f31499d);
        if (this.f31502g) {
            canvas.drawRect(0.0f, (((float) getHeight()) - this.f31503h) - ((float) this.f31500e), (float) getWidth(), ((((float) getHeight()) - this.f31503h) - ((float) this.f31500e)) + ((float) this.f31498c), this.f31497b);
        } else {
            canvas.drawRect(0.0f, ((float) (getHeight() - this.f31498c)) - this.f31503h, (float) getWidth(), ((float) getHeight()) - this.f31503h, this.f31497b);
        }
        this.f31504i.reset();
        if (this.f31502g) {
            this.f31504i.moveTo(this.f31506k - ((float) (this.f31501f / 2)), (((float) getHeight()) - this.f31503h) - ((float) this.f31500e));
            this.f31504i.lineTo(this.f31506k, ((float) getHeight()) - this.f31503h);
            path = this.f31504i;
            f4 = this.f31506k + ((float) (this.f31501f / 2));
            f3 = ((float) getHeight()) - this.f31503h;
            f2 = (float) this.f31500e;
        } else {
            this.f31504i.moveTo(this.f31506k - ((float) (this.f31501f / 2)), ((float) getHeight()) - this.f31503h);
            this.f31504i.lineTo(this.f31506k, ((float) (getHeight() - this.f31500e)) - this.f31503h);
            path = this.f31504i;
            f4 = this.f31506k + ((float) (this.f31501f / 2));
            f3 = (float) getHeight();
            f2 = this.f31503h;
        }
        path.lineTo(f4, f3 - f2);
        this.f31504i.close();
        canvas.drawPath(this.f31504i, this.f31497b);
    }

    public void setLineColor(int i2) {
        this.f31499d = i2;
    }

    public void setLineHeight(int i2) {
        this.f31498c = i2;
    }

    public void setReverse(boolean z2) {
        this.f31502g = z2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f31505j = interpolator;
        if (interpolator == null) {
            this.f31505j = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i2) {
        this.f31500e = i2;
    }

    public void setTriangleWidth(int i2) {
        this.f31501f = i2;
    }

    public void setYOffset(float f2) {
        this.f31503h = f2;
    }
}
