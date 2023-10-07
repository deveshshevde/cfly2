package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

class PieView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f20989a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f20990b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f20991c;

    /* renamed from: d  reason: collision with root package name */
    private int f20992d = 100;

    /* renamed from: e  reason: collision with root package name */
    private int f20993e = 0;

    public PieView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PieView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        Paint paint = new Paint(1);
        this.f20989a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f20989a.setStrokeWidth((float) a.a(0.1f, getContext()));
        this.f20989a.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f20990b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f20990b.setStrokeWidth((float) a.a(2.0f, getContext()));
        this.f20990b.setColor(-1);
        this.f20991c = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f20991c, 270.0f, (((float) this.f20993e) * 360.0f) / ((float) this.f20992d), true, this.f20989a);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - a.a(4.0f, getContext())), this.f20990b);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int a2 = a.a(40.0f, getContext());
        setMeasuredDimension(a2, a2);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int a2 = a.a(4.0f, getContext());
        float f2 = (float) a2;
        this.f20991c.set(f2, f2, (float) (i2 - a2), (float) (i3 - a2));
    }
}
