package com.xeagle.android.newUI.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.xeagle.R;

public class RoundProgressBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f24124a;

    /* renamed from: b  reason: collision with root package name */
    private int f24125b;

    /* renamed from: c  reason: collision with root package name */
    private int f24126c;

    /* renamed from: d  reason: collision with root package name */
    private int f24127d;

    /* renamed from: e  reason: collision with root package name */
    private float f24128e;

    /* renamed from: f  reason: collision with root package name */
    private float f24129f;

    /* renamed from: g  reason: collision with root package name */
    private int f24130g;

    /* renamed from: h  reason: collision with root package name */
    private int f24131h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24132i;

    /* renamed from: j  reason: collision with root package name */
    private int f24133j;

    public RoundProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24124a = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundProgressBar);
        this.f24125b = obtainStyledAttributes.getColor(0, -65536);
        this.f24126c = obtainStyledAttributes.getColor(1, -16711936);
        this.f24127d = obtainStyledAttributes.getColor(5, -16711936);
        this.f24128e = obtainStyledAttributes.getDimension(6, 15.0f);
        this.f24129f = obtainStyledAttributes.getDimension(2, 5.0f);
        this.f24130g = obtainStyledAttributes.getInteger(3, 100);
        this.f24132i = obtainStyledAttributes.getBoolean(7, true);
        this.f24133j = obtainStyledAttributes.getInt(4, 0);
        obtainStyledAttributes.recycle();
    }

    public int getCricleColor() {
        return this.f24125b;
    }

    public int getCricleProgressColor() {
        return this.f24126c;
    }

    public synchronized int getMax() {
        return this.f24130g;
    }

    public synchronized int getProgress() {
        return this.f24131h;
    }

    public float getRoundWidth() {
        return this.f24129f;
    }

    public int getTextColor() {
        return this.f24127d;
    }

    public float getTextSize() {
        return this.f24128e;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z2;
        float f2;
        float f3;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f4 = (float) width;
        int i2 = (int) (f4 - (this.f24129f / 2.0f));
        this.f24124a.setColor(this.f24125b);
        this.f24124a.setStyle(Paint.Style.STROKE);
        this.f24124a.setStrokeWidth(this.f24129f);
        this.f24124a.setAntiAlias(true);
        canvas.drawCircle(f4, f4, (float) i2, this.f24124a);
        Log.e("log", width + "");
        this.f24124a.setStrokeWidth(0.0f);
        this.f24124a.setColor(this.f24127d);
        this.f24124a.setTextSize(this.f24128e);
        this.f24124a.setTypeface(Typeface.DEFAULT_BOLD);
        int i3 = (int) ((((float) this.f24131h) / ((float) this.f24130g)) * 100.0f);
        Paint paint = this.f24124a;
        float measureText = paint.measureText(i3 + "%");
        if (this.f24132i && i3 != 0 && this.f24133j == 0) {
            canvas.drawText(i3 + "%", f4 - (measureText / 2.0f), f4 + (this.f24128e / 2.0f), this.f24124a);
        }
        this.f24124a.setStrokeWidth(this.f24129f);
        this.f24124a.setColor(this.f24126c);
        float f5 = (float) (width - i2);
        float f6 = (float) (width + i2);
        RectF rectF = new RectF(f5, f5, f6, f6);
        int i4 = this.f24133j;
        if (i4 == 0) {
            this.f24124a.setStyle(Paint.Style.STROKE);
            f3 = 0.0f;
            f2 = (float) ((this.f24131h * SpatialRelationUtil.A_CIRCLE_DEGREE) / this.f24130g);
            z2 = false;
        } else if (i4 == 1) {
            this.f24124a.setStyle(Paint.Style.FILL_AND_STROKE);
            int i5 = this.f24131h;
            if (i5 != 0) {
                f3 = 0.0f;
                f2 = (float) ((i5 * SpatialRelationUtil.A_CIRCLE_DEGREE) / this.f24130g);
                z2 = true;
            } else {
                return;
            }
        } else {
            return;
        }
        canvas.drawArc(rectF, f3, f2, z2, this.f24124a);
    }

    public void setCricleColor(int i2) {
        this.f24125b = i2;
    }

    public void setCricleProgressColor(int i2) {
        this.f24126c = i2;
    }

    public synchronized void setMax(int i2) {
        if (i2 >= 0) {
            this.f24130g = i2;
        } else {
            throw new IllegalArgumentException("max not less than 0");
        }
    }

    public synchronized void setProgress(int i2) {
        if (i2 >= 0) {
            int i3 = this.f24130g;
            if (i2 > i3) {
                i2 = i3;
            }
            if (i2 <= i3) {
                this.f24131h = i2;
                postInvalidate();
            }
        } else {
            throw new IllegalArgumentException("progress not less than 0");
        }
    }

    public void setRoundWidth(float f2) {
        this.f24129f = f2;
    }

    public void setTextColor(int i2) {
        this.f24127d = i2;
    }

    public void setTextSize(float f2) {
        this.f24128e = f2;
    }
}
