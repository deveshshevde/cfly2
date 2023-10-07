package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import gw.m;
import gw.n;

class c extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    float f19096a;

    /* renamed from: b  reason: collision with root package name */
    private final n f19097b = n.a();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f19098c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f19099d = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f19100e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f19101f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final RectF f19102g = new RectF();

    /* renamed from: h  reason: collision with root package name */
    private final a f19103h = new a();

    /* renamed from: i  reason: collision with root package name */
    private int f19104i;

    /* renamed from: j  reason: collision with root package name */
    private int f19105j;

    /* renamed from: k  reason: collision with root package name */
    private int f19106k;

    /* renamed from: l  reason: collision with root package name */
    private int f19107l;

    /* renamed from: m  reason: collision with root package name */
    private int f19108m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19109n = true;

    /* renamed from: o  reason: collision with root package name */
    private m f19110o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f19111p;

    private class a extends Drawable.ConstantState {
        private a() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return c.this;
        }
    }

    c(m mVar) {
        this.f19110o = mVar;
        Paint paint = new Paint(1);
        this.f19098c = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader b() {
        Rect rect = this.f19100e;
        copyBounds(rect);
        float height = this.f19096a / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{m.a.a(this.f19104i, this.f19108m), m.a.a(this.f19105j, this.f19108m), m.a.a(m.a.b(this.f19105j, 0), this.f19108m), m.a.a(m.a.b(this.f19107l, 0), this.f19108m), m.a.a(this.f19107l, this.f19108m), m.a.a(this.f19106k, this.f19108m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    public RectF a() {
        this.f19102g.set(getBounds());
        return this.f19102g;
    }

    public void a(float f2) {
        if (this.f19096a != f2) {
            this.f19096a = f2;
            this.f19098c.setStrokeWidth(f2 * 1.3333f);
            this.f19109n = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) {
        this.f19104i = i2;
        this.f19105j = i3;
        this.f19106k = i4;
        this.f19107l = i5;
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f19108m = colorStateList.getColorForState(getState(), this.f19108m);
        }
        this.f19111p = colorStateList;
        this.f19109n = true;
        invalidateSelf();
    }

    public void a(m mVar) {
        this.f19110o = mVar;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (this.f19109n) {
            this.f19098c.setShader(b());
            this.f19109n = false;
        }
        float strokeWidth = this.f19098c.getStrokeWidth() / 2.0f;
        copyBounds(this.f19100e);
        this.f19101f.set(this.f19100e);
        float min = Math.min(this.f19110o.f().a(a()), this.f19101f.width() / 2.0f);
        if (this.f19110o.a(a())) {
            this.f19101f.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f19101f, min, min, this.f19098c);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f19103h;
    }

    public int getOpacity() {
        return this.f19096a > 0.0f ? -3 : -2;
    }

    public void getOutline(Outline outline) {
        if (this.f19110o.a(a())) {
            outline.setRoundRect(getBounds(), this.f19110o.f().a(a()));
            return;
        }
        copyBounds(this.f19100e);
        this.f19101f.set(this.f19100e);
        this.f19097b.a(this.f19110o, 1.0f, this.f19101f, this.f19099d);
        if (this.f19099d.isConvex()) {
            outline.setConvexPath(this.f19099d);
        }
    }

    public boolean getPadding(Rect rect) {
        if (!this.f19110o.a(a())) {
            return true;
        }
        int round = Math.round(this.f19096a);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.f19111p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f19109n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f19111p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.f19108m)) == this.f19108m)) {
            this.f19109n = true;
            this.f19108m = colorForState;
        }
        if (this.f19109n) {
            invalidateSelf();
        }
        return this.f19109n;
    }

    public void setAlpha(int i2) {
        this.f19098c.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19098c.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
