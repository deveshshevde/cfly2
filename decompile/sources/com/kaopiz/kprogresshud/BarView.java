package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

class BarView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f20981a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f20982b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f20983c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f20984d;

    /* renamed from: e  reason: collision with root package name */
    private int f20985e = 100;

    /* renamed from: f  reason: collision with root package name */
    private int f20986f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f20987g;

    /* renamed from: h  reason: collision with root package name */
    private float f20988h;

    public BarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BarView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.f20981a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f20981a.setStrokeWidth((float) a.a(2.0f, getContext()));
        this.f20981a.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f20982b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f20982b.setColor(-1);
        this.f20988h = (float) a.a(5.0f, getContext());
        float f2 = this.f20988h;
        this.f20984d = new RectF(f2, f2, ((((float) getWidth()) - this.f20988h) * ((float) this.f20986f)) / ((float) this.f20985e), ((float) getHeight()) - this.f20988h);
        this.f20987g = (float) a.a(10.0f, getContext());
        this.f20983c = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f20983c;
        float f2 = this.f20987g;
        canvas.drawRoundRect(rectF, f2, f2, this.f20981a);
        RectF rectF2 = this.f20984d;
        float f3 = this.f20987g;
        canvas.drawRoundRect(rectF2, f3, f3, this.f20982b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(a.a(100.0f, getContext()), a.a(20.0f, getContext()));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int a2 = a.a(2.0f, getContext());
        float f2 = (float) a2;
        this.f20983c.set(f2, f2, (float) (i2 - a2), (float) (i3 - a2));
    }
}
