package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.map3d.R;

public class DownloadProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private String f9783a;

    /* renamed from: b  reason: collision with root package name */
    private int f9784b = -65536;

    /* renamed from: c  reason: collision with root package name */
    private int f9785c = -65536;

    /* renamed from: d  reason: collision with root package name */
    private float f9786d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f9787e = 0.6f;

    /* renamed from: f  reason: collision with root package name */
    private TextPaint f9788f;

    /* renamed from: g  reason: collision with root package name */
    private TextPaint f9789g;

    /* renamed from: h  reason: collision with root package name */
    private float f9790h;

    /* renamed from: i  reason: collision with root package name */
    private float f9791i;

    public DownloadProgressView(Context context) {
        super(context);
        a((AttributeSet) null, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public DownloadProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet, i2);
    }

    private void a() {
        this.f9788f.setTextSize(this.f9786d);
        this.f9788f.setColor(this.f9784b);
        this.f9789g.setColor(this.f9785c);
        this.f9790h = this.f9788f.measureText(this.f9783a);
        this.f9791i = this.f9788f.getFontMetrics().bottom;
    }

    private void a(AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f7676a, i2, 0);
        this.f9783a = obtainStyledAttributes.getString(0);
        this.f9784b = obtainStyledAttributes.getColor(3, this.f9784b);
        this.f9786d = obtainStyledAttributes.getDimension(1, this.f9786d);
        this.f9785c = obtainStyledAttributes.getColor(2, this.f9785c);
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f9788f = textPaint;
        textPaint.setFlags(1);
        this.f9788f.setTextAlign(Paint.Align.RIGHT);
        TextPaint textPaint2 = new TextPaint();
        this.f9789g = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        a();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        double d2 = (double) (((float) height) * 0.8f);
        float width = (float) ((getWidth() - paddingLeft) - paddingRight);
        Double.isNaN(d2);
        canvas.drawRect(new Rect(0, (int) d2, (int) (width * this.f9787e), height), this.f9789g);
        canvas.drawText(String.valueOf((int) (this.f9787e * 100.0f)) + "%", (float) ((int) ((double) (this.f9787e * width))), (float) ((int) (d2 - 3.0d)), this.f9788f);
    }

    public void setProgress(int i2) {
        if (i2 <= 100 && i2 >= 0) {
            this.f9787e = ((float) i2) / 100.0f;
            invalidate();
        }
    }
}
