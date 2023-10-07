package com.xeagle.android.widgets.spinnerWheel;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xeagle.R;

public abstract class AbstractWheelView extends AbstractWheel {

    /* renamed from: y  reason: collision with root package name */
    private static int f26043y = -1;

    /* renamed from: m  reason: collision with root package name */
    protected int f26044m;

    /* renamed from: n  reason: collision with root package name */
    protected int f26045n;

    /* renamed from: o  reason: collision with root package name */
    protected int f26046o;

    /* renamed from: p  reason: collision with root package name */
    protected int f26047p;

    /* renamed from: q  reason: collision with root package name */
    protected int f26048q;

    /* renamed from: r  reason: collision with root package name */
    protected Drawable f26049r;

    /* renamed from: s  reason: collision with root package name */
    protected Paint f26050s;

    /* renamed from: t  reason: collision with root package name */
    protected Paint f26051t;

    /* renamed from: u  reason: collision with root package name */
    protected Animator f26052u;

    /* renamed from: v  reason: collision with root package name */
    protected Animator f26053v;

    /* renamed from: w  reason: collision with root package name */
    protected Bitmap f26054w;

    /* renamed from: x  reason: collision with root package name */
    protected Bitmap f26055x;

    /* renamed from: z  reason: collision with root package name */
    private final String f26056z;

    public AbstractWheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractWheelView.class.getName());
        sb.append(" #");
        int i3 = f26043y + 1;
        f26043y = i3;
        sb.append(i3);
        this.f26056z = sb.toString();
    }

    private void a(long j2) {
        this.f26052u.setDuration(j2);
        this.f26052u.start();
    }

    private void b(long j2) {
        this.f26053v.setDuration(j2);
        this.f26053v.start();
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            this.f26054w = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            this.f26055x = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        }
        setSelectorPaintCoeff(0.0f);
    }

    /* access modifiers changed from: protected */
    public void a(Context context) {
        super.a(context);
        this.f26052u = ObjectAnimator.ofFloat(this, "selectorPaintCoeff", new float[]{1.0f, 0.0f});
        this.f26053v = ObjectAnimator.ofInt(this, "separatorsPaintAlpha", new int[]{this.f26045n, this.f26046o});
        Paint paint = new Paint();
        this.f26051t = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f26051t.setAlpha(this.f26046o);
        Paint paint2 = new Paint();
        this.f26050s = paint2;
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    /* access modifiers changed from: protected */
    public abstract void a(Canvas canvas);

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.AbstractWheelView, i2, 0);
        this.f26044m = obtainStyledAttributes.getInt(3, 50);
        this.f26045n = obtainStyledAttributes.getInt(6, 70);
        this.f26046o = obtainStyledAttributes.getInt(7, 70);
        this.f26047p = obtainStyledAttributes.getInt(2, 10);
        this.f26048q = obtainStyledAttributes.getDimensionPixelSize(4, 10);
        this.f26049r = obtainStyledAttributes.getDrawable(5);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f26052u.cancel();
        this.f26053v.cancel();
        setSelectorPaintCoeff(1.0f);
        setSeparatorsPaintAlpha(this.f26045n);
    }

    /* access modifiers changed from: protected */
    public void c() {
        super.c();
        a(750);
        b(750);
    }

    /* access modifiers changed from: protected */
    public void d() {
        a(500);
        b(500);
    }

    /* access modifiers changed from: protected */
    public abstract void k();

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f26030j != null && this.f26030j.a() > 0) {
            if (j()) {
                k();
            }
            f();
            a(canvas);
        }
    }

    public void setSelectionDivider(Drawable drawable) {
        this.f26049r = drawable;
    }

    public abstract void setSelectorPaintCoeff(float f2);

    public void setSeparatorsPaintAlpha(int i2) {
        this.f26051t.setAlpha(i2);
        invalidate();
    }
}
