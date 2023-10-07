package com.xeagle.android.vjoystick.IWidgets.wheelView;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

class a extends b {

    /* renamed from: k  reason: collision with root package name */
    private final int f24748k;

    /* renamed from: l  reason: collision with root package name */
    private final int f24749l;

    /* renamed from: m  reason: collision with root package name */
    private final float f24750m;

    /* renamed from: n  reason: collision with root package name */
    private final float f24751n;

    /* renamed from: o  reason: collision with root package name */
    private final int f24752o;

    /* renamed from: p  reason: collision with root package name */
    private final float f24753p;

    /* renamed from: q  reason: collision with root package name */
    private final Paint f24754q;

    /* renamed from: r  reason: collision with root package name */
    private final Paint f24755r;

    /* renamed from: s  reason: collision with root package name */
    private final e f24756s;

    a(e eVar, int i2, int i3, float f2, int i4, float f3, int i5, int i6) {
        super(eVar.f24771c, eVar.f24770b, i2);
        this.f24748k = i3;
        this.f24751n = f3;
        this.f24749l = i4;
        this.f24750m = f2;
        this.f24752o = i6;
        this.f24756s = eVar;
        Paint paint = new Paint();
        this.f24754q = paint;
        paint.setAntiAlias(true);
        paint.setTextSize(f3);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.f24753p = (fontMetrics.bottom + fontMetrics.top) / 2.0f;
        Paint paint2 = new Paint();
        this.f24755r = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(i5);
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i2, int i3, boolean z2, boolean z3) {
        String a2 = this.f24756s.a(i2);
        this.f24754q.setColor(z2 ? this.f24749l : this.f24748k);
        this.f24754q.setTextSize(z2 ? this.f24750m : this.f24751n);
        this.f24754q.setAlpha(i3);
        canvas.drawText(a2, rect.exactCenterX(), rect.exactCenterY() - this.f24753p, this.f24754q);
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, boolean z2) {
        Paint paint;
        float f2;
        float f3;
        float f4;
        float f5;
        Canvas canvas2;
        if (z2) {
            float height = ((float) (rect.height() - this.f24752o)) / 2.0f;
            float f6 = ((float) rect.top) + height;
            canvas2 = canvas;
            canvas2.drawLine((float) rect.left, f6, (float) rect.right, f6, this.f24755r);
            f2 = ((float) rect.bottom) - height;
            f5 = (float) rect.left;
            f3 = (float) rect.right;
            paint = this.f24755r;
            f4 = f2;
        } else {
            float width = ((float) (rect.width() - this.f24752o)) / 2.0f;
            float f7 = ((float) rect.left) + width;
            canvas2 = canvas;
            canvas2.drawLine(f7, (float) rect.top, f7, (float) rect.bottom, this.f24755r);
            f3 = ((float) rect.right) - width;
            f4 = (float) rect.top;
            f2 = (float) rect.bottom;
            paint = this.f24755r;
            f5 = f3;
        }
        canvas2.drawLine(f5, f4, f3, f2, paint);
    }
}
