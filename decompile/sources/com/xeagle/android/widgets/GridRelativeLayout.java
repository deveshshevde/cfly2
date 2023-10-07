package com.xeagle.android.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GridRelativeLayout extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f25590a;

    /* renamed from: b  reason: collision with root package name */
    private int f25591b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25592c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f25593d;

    /* renamed from: e  reason: collision with root package name */
    private int f25594e = 0;

    /* renamed from: f  reason: collision with root package name */
    private Paint f25595f;

    public GridRelativeLayout(Context context) {
        super(context);
        b();
    }

    public GridRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public GridRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.f25595f = paint;
        paint.setColor(-1);
        this.f25595f.setStrokeWidth(1.0f);
    }

    public void a() {
        this.f25592c = false;
        postInvalidate();
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        if (this.f25593d != i2 || this.f25590a != i3 || this.f25591b != i4 || this.f25594e != i5) {
            this.f25590a = i3;
            this.f25591b = i4;
            this.f25594e = i5;
            this.f25593d = i2;
            this.f25592c = true;
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f25592c) {
            int i2 = this.f25593d;
            if (i2 == 0) {
                a();
                return;
            }
            if (i2 == 1) {
                int i3 = this.f25594e;
                int i4 = this.f25591b;
                canvas.drawLine((float) i3, (float) (i4 / 3), (float) (this.f25590a + i3), (float) (i4 / 3), this.f25595f);
                int i5 = this.f25594e;
                int i6 = this.f25591b;
                canvas.drawLine((float) i5, (float) ((i6 * 2) / 3), (float) (this.f25590a + i5), (float) ((i6 * 2) / 3), this.f25595f);
                int i7 = this.f25590a;
                int i8 = this.f25594e;
                Canvas canvas2 = canvas;
                canvas2.drawLine(((float) (i7 / 3)) + ((float) i8), 0.0f, ((float) (i7 / 3)) + ((float) i8), (float) this.f25591b, this.f25595f);
                int i9 = this.f25590a;
                int i10 = this.f25594e;
                canvas2.drawLine(((float) ((i9 * 2) / 3)) + ((float) i10), 0.0f, ((float) ((i9 * 2) / 3)) + ((float) i10), (float) this.f25591b, this.f25595f);
            } else if (i2 == 2) {
                int i11 = this.f25594e;
                int i12 = this.f25591b;
                double d2 = (double) i12;
                Double.isNaN(d2);
                double d3 = (double) i12;
                Double.isNaN(d3);
                canvas.drawLine((float) i11, (float) (d2 * 0.382d), (float) (this.f25590a + i11), (float) (d3 * 0.382d), this.f25595f);
                int i13 = this.f25594e;
                int i14 = this.f25591b;
                double d4 = (double) i14;
                Double.isNaN(d4);
                double d5 = (double) i14;
                Double.isNaN(d5);
                canvas.drawLine((float) i13, (float) (d4 * 0.618d), (float) (this.f25590a + i13), (float) (d5 * 0.618d), this.f25595f);
                int i15 = this.f25590a;
                double d6 = (double) i15;
                Double.isNaN(d6);
                int i16 = this.f25594e;
                double d7 = (double) i15;
                Double.isNaN(d7);
                Canvas canvas3 = canvas;
                canvas3.drawLine(((float) (d6 * 0.382d)) + ((float) i16), 0.0f, ((float) (d7 * 0.382d)) + ((float) i16), (float) this.f25591b, this.f25595f);
                int i17 = this.f25590a;
                double d8 = (double) i17;
                Double.isNaN(d8);
                int i18 = this.f25594e;
                double d9 = (double) i17;
                Double.isNaN(d9);
                canvas3.drawLine(((float) (d8 * 0.618d)) + ((float) i18), 0.0f, ((float) (d9 * 0.618d)) + ((float) i18), (float) this.f25591b, this.f25595f);
            } else {
                return;
            }
            int i19 = this.f25594e;
            canvas.drawLine((float) i19, (float) this.f25591b, (float) (this.f25590a + i19), 0.0f, this.f25595f);
            int i20 = this.f25594e;
            canvas.drawLine((float) i20, 0.0f, (float) (this.f25590a + i20), (float) this.f25591b, this.f25595f);
        }
    }
}
