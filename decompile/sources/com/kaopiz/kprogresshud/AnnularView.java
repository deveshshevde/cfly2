package com.kaopiz.kprogresshud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

class AnnularView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f20975a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f20976b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f20977c;

    /* renamed from: d  reason: collision with root package name */
    private int f20978d = 100;

    /* renamed from: e  reason: collision with root package name */
    private int f20979e = 0;

    public AnnularView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public AnnularView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f20975a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f20975a.setStrokeWidth((float) a.a(3.0f, getContext()));
        this.f20975a.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f20976b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f20976b.setStrokeWidth((float) a.a(3.0f, getContext()));
        this.f20976b.setColor(context.getResources().getColor(R.color.kprogresshud_grey_color));
        this.f20977c = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = (((float) this.f20979e) * 360.0f) / ((float) this.f20978d);
        canvas.drawArc(this.f20977c, 270.0f, f2, false, this.f20975a);
        canvas.drawArc(this.f20977c, f2 + 270.0f, 360.0f - f2, false, this.f20976b);
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
        this.f20977c.set(f2, f2, (float) (i2 - a2), (float) (i3 - a2));
    }
}
