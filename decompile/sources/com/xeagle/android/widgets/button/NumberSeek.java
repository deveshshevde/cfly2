package com.xeagle.android.widgets.button;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.cfly.uav_pro.R;

public class NumberSeek extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    private int f25781a;

    /* renamed from: b  reason: collision with root package name */
    private int f25782b;

    /* renamed from: c  reason: collision with root package name */
    private int f25783c;

    /* renamed from: d  reason: collision with root package name */
    private int f25784d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25785e = true;

    /* renamed from: f  reason: collision with root package name */
    private String f25786f = "Timer: 00:00";

    /* renamed from: g  reason: collision with root package name */
    private float f25787g;

    /* renamed from: h  reason: collision with root package name */
    private float f25788h;

    /* renamed from: i  reason: collision with root package name */
    private float f25789i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f25790j;

    /* renamed from: k  reason: collision with root package name */
    private Resources f25791k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f25792l;

    /* renamed from: m  reason: collision with root package name */
    private int f25793m = 13;

    /* renamed from: n  reason: collision with root package name */
    private int f25794n;

    /* renamed from: o  reason: collision with root package name */
    private int f25795o;

    /* renamed from: p  reason: collision with root package name */
    private int f25796p;

    /* renamed from: q  reason: collision with root package name */
    private int f25797q;

    public NumberSeek(Context context) {
        super(context);
        a();
    }

    public NumberSeek(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public NumberSeek(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        this.f25791k = getResources();
        d();
        c();
        b();
    }

    private void b() {
        int bitmapHeight = getBitmapHeight() + this.f25781a;
        int bitmapWidth = (getBitmapWidth() / 2) + this.f25782b;
        int bitmapWidth2 = (getBitmapWidth() / 2) + this.f25783c;
        int i2 = this.f25784d;
        this.f25785e = true;
        setPadding(bitmapWidth, bitmapHeight, bitmapWidth2, i2);
        this.f25785e = false;
    }

    private void c() {
        Paint paint = new Paint(1);
        this.f25790j = paint;
        paint.setTypeface(Typeface.DEFAULT);
        this.f25790j.setTextSize((float) this.f25793m);
        this.f25790j.setColor(-14418865);
    }

    private void d() {
        float f2;
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f25791k, R.drawable.info_time_frame);
        this.f25792l = decodeResource;
        if (decodeResource != null) {
            this.f25788h = (float) decodeResource.getWidth();
            f2 = (float) this.f25792l.getHeight();
        } else {
            f2 = 0.0f;
            this.f25788h = 0.0f;
        }
        this.f25789i = f2;
    }

    private int getBitmapHeight() {
        return (int) Math.ceil((double) this.f25789i);
    }

    private int getBitmapWidth() {
        return (int) Math.ceil((double) this.f25788h);
    }

    private float getTextHei() {
        Paint.FontMetrics fontMetrics = this.f25790j.getFontMetrics();
        return ((float) Math.ceil((double) (fontMetrics.descent - fontMetrics.top))) + 2.0f;
    }

    public int getImagePaddingLeft() {
        return this.f25796p;
    }

    public int getImagePaddingTop() {
        return this.f25797q;
    }

    public int getTextPaddingLeft() {
        return this.f25794n;
    }

    public int getTextPaddingTop() {
        return this.f25795o;
    }

    public int getTextSize() {
        return this.f25793m;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            this.f25787g = this.f25790j.measureText(this.f25786f);
            Rect bounds = getProgressDrawable().getBounds();
            float f2 = (float) (this.f25797q + this.f25781a + 12);
            canvas.drawBitmap(this.f25792l, (float) (((bounds.width() * getProgress()) / getMax()) + this.f25796p + this.f25782b + 8), f2, this.f25790j);
            canvas.drawText(this.f25786f, ((((float) ((bounds.width() * getProgress()) / getMax())) + (this.f25788h / 2.0f)) - (this.f25787g / 2.0f)) + ((float) this.f25794n) + ((float) this.f25782b), (((((float) this.f25795o) + f2) + (this.f25789i / 2.0f)) + (getTextHei() / 4.0f)) - 15.0f, this.f25790j);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setBitmap(int i2) {
        float f2;
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f25791k, i2);
        this.f25792l = decodeResource;
        if (decodeResource != null) {
            this.f25788h = (float) decodeResource.getWidth();
            f2 = (float) this.f25792l.getHeight();
        } else {
            f2 = 0.0f;
            this.f25788h = 0.0f;
        }
        this.f25789i = f2;
        b();
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        if (this.f25785e) {
            super.setPadding(i2, i3, i4, i5);
        }
    }

    public void setText(String str) {
        this.f25786f = str;
    }

    public void setTextColor(int i2) {
        this.f25790j.setColor(i2);
    }

    public void setTextSize(int i2) {
        this.f25793m = i2;
        this.f25790j.setTextSize((float) i2);
    }
}
