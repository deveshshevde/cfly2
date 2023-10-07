package com.xeagle.android.widgets.TextViewMatch;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

public class a extends Animation {

    /* renamed from: a  reason: collision with root package name */
    public PointF f25663a;

    /* renamed from: b  reason: collision with root package name */
    public float f25664b;

    /* renamed from: c  reason: collision with root package name */
    public int f25665c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f25666d;

    /* renamed from: e  reason: collision with root package name */
    private float f25667e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f25668f = 0.4f;

    /* renamed from: g  reason: collision with root package name */
    private PointF f25669g;

    /* renamed from: h  reason: collision with root package name */
    private PointF f25670h;

    public a(int i2, PointF pointF, PointF pointF2, int i3, int i4) {
        Paint paint = new Paint();
        this.f25666d = paint;
        this.f25665c = i2;
        this.f25663a = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        this.f25669g = new PointF(pointF.x - this.f25663a.x, pointF.y - this.f25663a.y);
        this.f25670h = new PointF(pointF2.x - this.f25663a.x, pointF2.y - this.f25663a.y);
        b(i3);
        a(i4);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(float f2) {
        this.f25666d.setAlpha((int) (f2 * 255.0f));
    }

    public void a(float f2, float f3) {
        this.f25667e = f2;
        this.f25668f = f3;
        super.start();
    }

    public void a(int i2) {
        this.f25666d.setStrokeWidth((float) i2);
    }

    public void a(Canvas canvas) {
        canvas.drawLine(this.f25669g.x, this.f25669g.y, this.f25670h.x, this.f25670h.y, this.f25666d);
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        float f3 = this.f25667e;
        a(f3 + ((this.f25668f - f3) * f2));
    }

    public void b(int i2) {
        this.f25666d.setColor(i2);
    }

    public void c(int i2) {
        this.f25664b = (float) ((-new Random().nextInt(i2)) + i2);
    }
}
