package com.xeagle.android.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class AttitudeIndicator extends View {

    /* renamed from: a  reason: collision with root package name */
    private float f25449a;

    /* renamed from: b  reason: collision with root package name */
    private float f25450b;

    /* renamed from: c  reason: collision with root package name */
    private float f25451c;

    /* renamed from: d  reason: collision with root package name */
    private float f25452d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f25453e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f25454f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f25455g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f25456h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f25457i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f25458j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f25459k;

    /* renamed from: l  reason: collision with root package name */
    private Path f25460l = new Path();

    /* renamed from: m  reason: collision with root package name */
    private Path f25461m = new Path();

    /* renamed from: n  reason: collision with root package name */
    private float f25462n;

    /* renamed from: o  reason: collision with root package name */
    private float f25463o;

    /* renamed from: p  reason: collision with root package name */
    private float f25464p;

    /* renamed from: q  reason: collision with root package name */
    private Paint f25465q;

    public AttitudeIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        a(-30.0f, 20.0f, 0.0f);
    }

    private void a() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(paint);
        this.f25454f = paint2;
        paint2.setColor(-1);
        this.f25455g = new Paint(paint);
        this.f25456h = new Paint(paint);
        Paint paint3 = new Paint(paint);
        this.f25457i = paint3;
        paint3.setColor(-1);
        this.f25457i.setStrokeWidth(5.0f);
        this.f25457i.setStrokeCap(Paint.Cap.ROUND);
        Paint paint4 = new Paint(this.f25457i);
        this.f25459k = paint4;
        paint4.setColor(-65536);
        Paint paint5 = new Paint(this.f25457i);
        this.f25458j = paint5;
        paint5.setStrokeWidth(2.5f);
        Paint paint6 = new Paint(paint);
        this.f25465q = paint6;
        paint6.setColor(Color.parseColor("#44ffffff"));
        this.f25465q.setStrokeWidth(2.0f);
    }

    private void a(Canvas canvas) {
        canvas.drawCircle(0.0f, 0.0f, this.f25451c, this.f25454f);
        float radians = (float) Math.toRadians((double) (180.0f - this.f25462n));
        this.f25460l.reset();
        this.f25460l.moveTo(0.0f, 0.0f);
        a(this.f25460l, radians + 4.5f, this.f25451c);
        a(this.f25460l, radians, this.f25451c * 1.2f);
        a(this.f25460l, radians - 4.5f, this.f25451c);
        canvas.drawPath(this.f25460l, this.f25454f);
    }

    private void a(Path path, float f2, float f3) {
        double d2 = (double) f2;
        path.lineTo(((float) Math.sin(d2)) * f3, ((float) Math.cos(d2)) * f3);
    }

    private void b(Canvas canvas) {
        canvas.drawCircle(0.0f, 0.0f, this.f25452d, this.f25455g);
        this.f25461m.reset();
        float degrees = (float) Math.toDegrees(Math.acos((double) (this.f25464p / 45.0f)));
        this.f25461m.addArc(this.f25453e, (90.0f - degrees) - this.f25463o, degrees * 2.0f);
        canvas.drawPath(this.f25461m, this.f25456h);
    }

    private void c(Canvas canvas) {
        double cos = Math.cos(Math.toRadians((double) (-this.f25463o)));
        double d2 = (double) this.f25452d;
        Double.isNaN(d2);
        float f2 = ((float) (cos * d2)) * 0.4f;
        double sin = Math.sin(Math.toRadians((double) (-this.f25463o)));
        double d3 = (double) this.f25452d;
        Double.isNaN(d3);
        float f3 = ((float) (sin * d3)) * 0.4f;
        double cos2 = Math.cos(Math.toRadians((double) ((-this.f25463o) - 90.0f)));
        double d4 = (double) this.f25452d;
        Double.isNaN(d4);
        float f4 = (float) ((cos2 * d4) / 45.0d);
        double sin2 = Math.sin(Math.toRadians((double) ((-this.f25463o) - 90.0f)));
        double d5 = (double) this.f25452d;
        Double.isNaN(d5);
        float f5 = (float) ((sin2 * d5) / 45.0d);
        float f6 = this.f25464p;
        int i2 = (int) (((f6 + 45.0f) - 2.0f) / 15.0f);
        for (int i3 = (int) (((-45.0f + f6) + 2.0f) / 15.0f); i3 <= i2; i3++) {
            float f7 = (-this.f25464p) + ((float) (i3 * 15));
            float f8 = f4 * f7;
            float f9 = f7 * f5;
            canvas.drawLine(f2 + f8, f3 + f9, (-f2) + f8, (-f3) + f9, this.f25465q);
        }
    }

    private void d(Canvas canvas) {
        float f2 = this.f25452d;
        canvas.drawLine(f2 * 0.8f, 0.0f, (-f2) * 0.8f, 0.0f, this.f25457i);
        canvas.drawLine(0.0f, 0.0f, 0.0f, (((-this.f25452d) * 0.8f) * 5.0f) / 12.0f, this.f25458j);
        canvas.drawCircle(0.0f, 0.0f, this.f25452d * 0.8f * 0.2f, this.f25457i);
        canvas.drawCircle(0.0f, 0.0f, ((this.f25452d * 0.8f) * 0.2f) / 2.0f, this.f25459k);
    }

    public void a(float f2, float f3, float f4) {
        this.f25463o = f2;
        this.f25464p = f3;
        this.f25462n = f4;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(this.f25449a, this.f25450b);
        a(canvas);
        b(canvas);
        c(canvas);
        d(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = ((float) i3) / 2.0f;
        this.f25450b = f2;
        float f3 = ((float) i2) / 2.0f;
        this.f25449a = f3;
        float min = Math.min(f2, f3) / 1.2f;
        this.f25451c = min;
        this.f25452d = min * 0.85f;
        float f4 = this.f25452d;
        this.f25453e = new RectF(-f4, -f4, f4, f4);
        Paint paint = this.f25455g;
        float f5 = this.f25452d;
        paint.setShader(new LinearGradient(0.0f, -f5, 0.0f, f5, Color.parseColor("#0082d6"), Color.parseColor("#2cb1e1"), Shader.TileMode.CLAMP));
        Paint paint2 = this.f25456h;
        float f6 = this.f25452d;
        paint2.setShader(new LinearGradient(0.0f, f6, 0.0f, f6, Color.parseColor("#4bbba1"), Color.parseColor("#008f63"), Shader.TileMode.CLAMP));
    }
}
