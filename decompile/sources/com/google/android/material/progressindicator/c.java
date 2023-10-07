package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import gn.a;

final class c extends g<CircularProgressIndicatorSpec> {

    /* renamed from: c  reason: collision with root package name */
    private int f19450c = 1;

    /* renamed from: d  reason: collision with root package name */
    private float f19451d;

    /* renamed from: e  reason: collision with root package name */
    private float f19452e;

    /* renamed from: f  reason: collision with root package name */
    private float f19453f;

    public c(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void a(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z2, RectF rectF) {
        Canvas canvas2 = canvas;
        float f5 = z2 ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        Paint paint2 = paint;
        canvas.drawRect((this.f19453f - f6) + f3, Math.min(0.0f, ((float) this.f19450c) * f7), (this.f19453f + f6) - f3, Math.max(0.0f, f7 * ((float) this.f19450c)), paint2);
        canvas.translate((this.f19453f - f6) + f3, 0.0f);
        RectF rectF2 = rectF;
        canvas.drawArc(rectF2, 180.0f, (-f5) * 90.0f * ((float) this.f19450c), true, paint2);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF2, 0.0f, f5 * 90.0f * ((float) this.f19450c), true, paint2);
        canvas.restore();
    }

    private int c() {
        return ((CircularProgressIndicatorSpec) this.f19492a).f19436g + (((CircularProgressIndicatorSpec) this.f19492a).f19437h * 2);
    }

    public int a() {
        return c();
    }

    public void a(Canvas canvas, float f2) {
        float f3;
        float f4 = (((float) ((CircularProgressIndicatorSpec) this.f19492a).f19436g) / 2.0f) + ((float) ((CircularProgressIndicatorSpec) this.f19492a).f19437h);
        canvas.translate(f4, f4);
        canvas.rotate(-90.0f);
        float f5 = -f4;
        canvas.clipRect(f5, f5, f4, f4);
        this.f19450c = ((CircularProgressIndicatorSpec) this.f19492a).f19438i == 0 ? 1 : -1;
        this.f19451d = ((float) ((CircularProgressIndicatorSpec) this.f19492a).f19444a) * f2;
        this.f19452e = ((float) ((CircularProgressIndicatorSpec) this.f19492a).f19445b) * f2;
        this.f19453f = ((float) (((CircularProgressIndicatorSpec) this.f19492a).f19436g - ((CircularProgressIndicatorSpec) this.f19492a).f19444a)) / 2.0f;
        if ((this.f19493b.d() && ((CircularProgressIndicatorSpec) this.f19492a).f19448e == 2) || (this.f19493b.c() && ((CircularProgressIndicatorSpec) this.f19492a).f19449f == 1)) {
            f3 = this.f19453f + (((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) this.f19492a).f19444a)) / 2.0f);
        } else if ((this.f19493b.d() && ((CircularProgressIndicatorSpec) this.f19492a).f19448e == 1) || (this.f19493b.c() && ((CircularProgressIndicatorSpec) this.f19492a).f19449f == 2)) {
            f3 = this.f19453f - (((1.0f - f2) * ((float) ((CircularProgressIndicatorSpec) this.f19492a).f19444a)) / 2.0f);
        } else {
            return;
        }
        this.f19453f = f3;
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Paint paint) {
        int b2 = a.b(((CircularProgressIndicatorSpec) this.f19492a).f19447d, this.f19493b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(b2);
        paint.setStrokeWidth(this.f19451d);
        float f2 = this.f19453f;
        canvas.drawArc(new RectF(-f2, -f2, f2, f2), 0.0f, 360.0f, false, paint);
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Paint paint, float f2, float f3, int i2) {
        Paint paint2 = paint;
        if (f2 != f3) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i2);
            paint.setStrokeWidth(this.f19451d);
            int i3 = this.f19450c;
            float f4 = f2 * 360.0f * ((float) i3);
            float f5 = (f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2) * 360.0f * ((float) i3);
            float f6 = this.f19453f;
            canvas.drawArc(new RectF(-f6, -f6, f6, f6), f4, f5, false, paint);
            if (this.f19452e > 0.0f && Math.abs(f5) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                float f7 = this.f19452e;
                RectF rectF = new RectF(-f7, -f7, f7, f7);
                Canvas canvas2 = canvas;
                Paint paint3 = paint;
                RectF rectF2 = rectF;
                a(canvas2, paint3, this.f19451d, this.f19452e, f4, true, rectF2);
                a(canvas2, paint3, this.f19451d, this.f19452e, f4 + f5, false, rectF2);
            }
        }
    }

    public int b() {
        return c();
    }
}
