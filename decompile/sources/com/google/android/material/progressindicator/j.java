package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import gn.a;

final class j extends g<LinearProgressIndicatorSpec> {

    /* renamed from: c  reason: collision with root package name */
    private float f19499c = 300.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f19500d;

    /* renamed from: e  reason: collision with root package name */
    private float f19501e;

    public j(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
    }

    private static void a(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z2, RectF rectF) {
        Canvas canvas2 = canvas;
        float f5 = f2;
        float f6 = f3;
        canvas.save();
        float f7 = f4;
        canvas.translate(f4, 0.0f);
        if (!z2) {
            canvas.rotate(180.0f);
        }
        float f8 = ((-f5) / 2.0f) + f6;
        float f9 = (f5 / 2.0f) - f6;
        Canvas canvas3 = canvas;
        Paint paint2 = paint;
        canvas3.drawRect(-f6, f8, 0.0f, f9, paint2);
        canvas.save();
        canvas.translate(0.0f, f8);
        RectF rectF2 = rectF;
        canvas3.drawArc(rectF2, 180.0f, 90.0f, true, paint2);
        canvas.restore();
        canvas.translate(0.0f, f9);
        canvas3.drawArc(rectF2, 180.0f, -90.0f, true, paint2);
        canvas.restore();
    }

    public int a() {
        return -1;
    }

    public void a(Canvas canvas, float f2) {
        Rect clipBounds = canvas.getClipBounds();
        this.f19499c = (float) clipBounds.width();
        float f3 = (float) ((LinearProgressIndicatorSpec) this.f19492a).f19444a;
        canvas.translate(((float) clipBounds.left) + (((float) clipBounds.width()) / 2.0f), ((float) clipBounds.top) + (((float) clipBounds.height()) / 2.0f) + Math.max(0.0f, ((float) (clipBounds.height() - ((LinearProgressIndicatorSpec) this.f19492a).f19444a)) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.f19492a).f19442i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f19493b.d() && ((LinearProgressIndicatorSpec) this.f19492a).f19448e == 1) || (this.f19493b.c() && ((LinearProgressIndicatorSpec) this.f19492a).f19449f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f19493b.d() || this.f19493b.c()) {
            canvas.translate(0.0f, (((float) ((LinearProgressIndicatorSpec) this.f19492a).f19444a) * (f2 - 1.0f)) / 2.0f);
        }
        float f4 = this.f19499c;
        canvas.clipRect((-f4) / 2.0f, (-f3) / 2.0f, f4 / 2.0f, f3 / 2.0f);
        this.f19500d = ((float) ((LinearProgressIndicatorSpec) this.f19492a).f19444a) * f2;
        this.f19501e = ((float) ((LinearProgressIndicatorSpec) this.f19492a).f19445b) * f2;
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Paint paint) {
        int b2 = a.b(((LinearProgressIndicatorSpec) this.f19492a).f19447d, this.f19493b.getAlpha());
        float f2 = ((-this.f19499c) / 2.0f) + this.f19501e;
        float f3 = -f2;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(b2);
        float f4 = this.f19500d;
        canvas.drawRect(f2, (-f4) / 2.0f, f3, f4 / 2.0f, paint);
        float f5 = this.f19501e;
        RectF rectF = new RectF(-f5, -f5, f5, f5);
        a(canvas, paint, this.f19500d, this.f19501e, f2, true, rectF);
        a(canvas, paint, this.f19500d, this.f19501e, f3, false, rectF);
    }

    public void a(Canvas canvas, Paint paint, float f2, float f3, int i2) {
        Paint paint2 = paint;
        if (f2 != f3) {
            float f4 = this.f19499c;
            float f5 = this.f19501e;
            float f6 = ((-f4) / 2.0f) + f5 + ((f4 - (f5 * 2.0f)) * f2);
            float f7 = ((-f4) / 2.0f) + f5 + ((f4 - (f5 * 2.0f)) * f3);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setColor(i2);
            float f8 = this.f19500d;
            canvas.drawRect(f6, (-f8) / 2.0f, f7, f8 / 2.0f, paint);
            float f9 = this.f19501e;
            RectF rectF = new RectF(-f9, -f9, f9, f9);
            Canvas canvas2 = canvas;
            Paint paint3 = paint;
            float f10 = f6;
            RectF rectF2 = rectF;
            a(canvas2, paint3, this.f19500d, this.f19501e, f10, true, rectF2);
            a(canvas2, paint3, this.f19500d, this.f19501e, f7, false, rectF2);
        }
    }

    public int b() {
        return ((LinearProgressIndicatorSpec) this.f19492a).f19444a;
    }
}
