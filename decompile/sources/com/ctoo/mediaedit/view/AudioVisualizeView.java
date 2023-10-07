package com.ctoo.mediaedit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.ctoo.mediaedit.R;

public abstract class AudioVisualizeView extends View implements a {

    /* renamed from: a  reason: collision with root package name */
    protected int f10964a;

    /* renamed from: b  reason: collision with root package name */
    protected float f10965b;

    /* renamed from: c  reason: collision with root package name */
    protected float f10966c;

    /* renamed from: d  reason: collision with root package name */
    protected float f10967d;

    /* renamed from: e  reason: collision with root package name */
    protected int f10968e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f10969f;

    /* renamed from: g  reason: collision with root package name */
    protected byte[] f10970g;

    /* renamed from: h  reason: collision with root package name */
    protected RectF f10971h;

    /* renamed from: i  reason: collision with root package name */
    protected Paint f10972i;

    /* renamed from: j  reason: collision with root package name */
    protected Path f10973j;

    /* renamed from: k  reason: collision with root package name */
    protected float f10974k;

    /* renamed from: l  reason: collision with root package name */
    protected float f10975l;

    /* renamed from: m  reason: collision with root package name */
    public b f10976m;

    public AudioVisualizeView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AudioVisualizeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioVisualizeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f10969f = true;
        a(context, attributeSet, i2);
        a();
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AudioVisualizeView, i2, 0);
        try {
            this.f10968e = obtainStyledAttributes.getColor(R.styleable.AudioVisualizeView_visualize_color, -1);
            this.f10964a = obtainStyledAttributes.getInteger(R.styleable.AudioVisualizeView_visualize_count, 60);
            this.f10966c = obtainStyledAttributes.getFloat(R.styleable.AudioVisualizeView_visualize_ratio, 1.0f);
            this.f10965b = obtainStyledAttributes.getDimension(R.styleable.AudioVisualizeView_visualize_item_margin, 12.0f);
            a(obtainStyledAttributes);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f10967d = 5.0f;
        Paint paint = new Paint();
        this.f10972i = paint;
        paint.setStrokeWidth(this.f10967d);
        this.f10972i.setColor(this.f10968e);
        this.f10972i.setStrokeCap(Paint.Cap.ROUND);
        this.f10972i.setAntiAlias(true);
        this.f10972i.setMaskFilter(new BlurMaskFilter(5.0f, BlurMaskFilter.Blur.SOLID));
        this.f10971h = new RectF();
        this.f10973j = new Path();
        b bVar = new b();
        this.f10976m = bVar;
        bVar.a((a) this);
        this.f10976m.a(this.f10964a);
    }

    /* access modifiers changed from: protected */
    public abstract void a(TypedArray typedArray);

    /* access modifiers changed from: protected */
    public abstract void a(Canvas canvas);

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10970g != null) {
            a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f10971h.set(0.0f, 0.0f, (float) getWidth(), (float) (getHeight() - 50));
        this.f10974k = this.f10971h.width() / 2.0f;
        this.f10975l = this.f10971h.height() / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            size = 500;
        }
        if (mode2 != 1073741824) {
            size2 = 500;
        }
        setMeasuredDimension(size, size2);
    }

    public void setColor(int i2) {
        this.f10968e = i2;
        this.f10972i.setColor(i2);
    }
}
