package com.xeagle.android.editor.widget.indicatorSeekbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CircleBubbleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f23036a;

    /* renamed from: b  reason: collision with root package name */
    private int f23037b;

    /* renamed from: c  reason: collision with root package name */
    private float f23038c;

    /* renamed from: d  reason: collision with root package name */
    private Context f23039d;

    /* renamed from: e  reason: collision with root package name */
    private Path f23040e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f23041f;

    /* renamed from: g  reason: collision with root package name */
    private float f23042g;

    /* renamed from: h  reason: collision with root package name */
    private float f23043h;

    /* renamed from: i  reason: collision with root package name */
    private float f23044i;

    /* renamed from: j  reason: collision with root package name */
    private String f23045j;

    CircleBubbleView(Context context, float f2, int i2, int i3, String str) {
        super(context, (AttributeSet) null, 0);
        this.f23039d = context;
        this.f23038c = f2;
        this.f23036a = i2;
        this.f23037b = i3;
        a(str);
    }

    private void a() {
        this.f23040e = new Path();
        float f2 = this.f23042g;
        this.f23040e.arcTo(new RectF(0.0f, 0.0f, f2, f2), 135.0f, 270.0f);
        this.f23040e.lineTo(this.f23042g / 2.0f, this.f23043h);
        this.f23040e.close();
    }

    private void a(String str) {
        Paint paint = new Paint();
        this.f23041f = paint;
        paint.setAntiAlias(true);
        this.f23041f.setStrokeWidth(1.0f);
        this.f23041f.setTextAlign(Paint.Align.CENTER);
        this.f23041f.setTextSize(this.f23038c);
        Rect rect = new Rect();
        this.f23041f.getTextBounds(str, 0, str.length(), rect);
        this.f23042g = (float) (rect.width() + f.a(this.f23039d, 4.0f));
        float a2 = (float) f.a(this.f23039d, 36.0f);
        if (this.f23042g < a2) {
            this.f23042g = a2;
        }
        this.f23044i = (float) rect.height();
        this.f23043h = this.f23042g * 1.2f;
        a();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f23041f.setColor(this.f23037b);
        canvas.drawPath(this.f23040e, this.f23041f);
        this.f23041f.setColor(this.f23036a);
        canvas.drawText(this.f23045j, this.f23042g / 2.0f, (this.f23043h / 2.0f) + (this.f23044i / 4.0f), this.f23041f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension((int) this.f23042g, (int) this.f23043h);
    }

    /* access modifiers changed from: package-private */
    public void setProgress(String str) {
        this.f23045j = str;
        invalidate();
    }
}
