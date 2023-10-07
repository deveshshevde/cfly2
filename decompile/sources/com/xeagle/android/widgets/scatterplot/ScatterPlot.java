package com.xeagle.android.widgets.scatterplot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

public class ScatterPlot extends View {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f25977a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private float f25978b;

    /* renamed from: c  reason: collision with root package name */
    private float f25979c;

    /* renamed from: d  reason: collision with root package name */
    private float f25980d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<Float> f25981e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private Paint f25982f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f25983g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f25984h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f25985i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f25986j;

    /* renamed from: k  reason: collision with root package name */
    private String f25987k = "";

    /* renamed from: l  reason: collision with root package name */
    private int[] f25988l;

    public ScatterPlot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.f25983g = paint;
        paint.setColor(-7829368);
        Paint paint2 = new Paint();
        this.f25984h = paint2;
        paint2.setColor(-1);
        this.f25984h.setStrokeWidth(3.0f);
        Paint paint3 = new Paint(this.f25984h);
        this.f25985i = paint3;
        paint3.setColor(-65536);
        Paint paint4 = new Paint(this.f25984h);
        this.f25986j = paint4;
        paint4.setStyle(Paint.Style.STROKE);
        this.f25986j.setColor(-16776961);
        Paint paint5 = new Paint(1);
        this.f25982f = paint5;
        paint5.setTextSize(20.0f);
        this.f25982f.setColor(-1);
    }

    private int b(float f2) {
        return (int) (d(f2) + this.f25978b);
    }

    private int c(float f2) {
        return (int) ((-d(f2)) + this.f25979c);
    }

    private float d(float f2) {
        return this.f25980d * 0.001f * f2;
    }

    public void a() {
        this.f25981e.clear();
        this.f25988l = null;
        invalidate();
    }

    public void a(float f2) {
        this.f25981e.add(Float.valueOf(f2));
    }

    public void a(int[] iArr) {
        this.f25988l = iArr;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = 0.0f;
        canvas.drawText(this.f25987k, 0.0f, this.f25982f.getTextSize(), this.f25982f);
        float f3 = this.f25978b;
        canvas.drawLine(f3, 0.0f, f3, this.f25979c * 2.0f, this.f25983g);
        float f4 = this.f25979c;
        canvas.drawLine(0.0f, f4, this.f25978b * 2.0f, f4, this.f25983g);
        int size = this.f25981e.size();
        float f5 = 0.0f;
        for (int i2 = 0; i2 < size; i2 += 2) {
            f2 = (float) b(this.f25981e.get(i2 + 0).floatValue());
            f5 = (float) c(this.f25981e.get(i2 + 1).floatValue());
            canvas.drawPoint(f2, f5, this.f25984h);
        }
        canvas.drawCircle(f2, f5, 10.0f, this.f25985i);
        int[] iArr = this.f25988l;
        if (iArr != null) {
            float b2 = (float) b((float) iArr[0]);
            float c2 = (float) c((float) this.f25988l[1]);
            float d2 = (float) ((int) d((float) this.f25988l[2]));
            float d3 = (float) ((int) d((float) this.f25988l[3]));
            this.f25977a.set(b2 - d2, c2 - d3, b2 + d2, c2 + d3);
            canvas.drawOval(this.f25977a, this.f25986j);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = ((float) i2) / 2.0f;
        this.f25978b = f2;
        float f3 = ((float) i3) / 2.0f;
        this.f25979c = f3;
        if (f3 <= f2) {
            f2 = f3;
        }
        this.f25980d = f2;
    }

    public void setTitle(String str) {
        this.f25987k = str;
        invalidate();
    }
}
