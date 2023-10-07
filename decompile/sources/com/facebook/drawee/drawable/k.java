package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import df.c;
import ds.b;
import java.util.Arrays;

public abstract class k extends Drawable implements h, o {
    private boolean A = false;
    private boolean B = true;
    private p C;

    /* renamed from: a  reason: collision with root package name */
    protected boolean f11206a = false;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f11207b = false;

    /* renamed from: c  reason: collision with root package name */
    protected float f11208c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    protected final Path f11209d = new Path();

    /* renamed from: e  reason: collision with root package name */
    protected boolean f11210e = true;

    /* renamed from: f  reason: collision with root package name */
    protected int f11211f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected final Path f11212g = new Path();

    /* renamed from: h  reason: collision with root package name */
    final float[] f11213h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    float[] f11214i;

    /* renamed from: j  reason: collision with root package name */
    final RectF f11215j = new RectF();

    /* renamed from: k  reason: collision with root package name */
    final RectF f11216k = new RectF();

    /* renamed from: l  reason: collision with root package name */
    final RectF f11217l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    final RectF f11218m = new RectF();

    /* renamed from: n  reason: collision with root package name */
    RectF f11219n;

    /* renamed from: o  reason: collision with root package name */
    final Matrix f11220o = new Matrix();

    /* renamed from: p  reason: collision with root package name */
    final Matrix f11221p = new Matrix();

    /* renamed from: q  reason: collision with root package name */
    final Matrix f11222q = new Matrix();

    /* renamed from: r  reason: collision with root package name */
    final Matrix f11223r = new Matrix();

    /* renamed from: s  reason: collision with root package name */
    final Matrix f11224s = new Matrix();

    /* renamed from: t  reason: collision with root package name */
    Matrix f11225t;

    /* renamed from: u  reason: collision with root package name */
    Matrix f11226u;

    /* renamed from: v  reason: collision with root package name */
    final Matrix f11227v = new Matrix();

    /* renamed from: w  reason: collision with root package name */
    private final Drawable f11228w;

    /* renamed from: x  reason: collision with root package name */
    private final float[] f11229x = new float[8];

    /* renamed from: y  reason: collision with root package name */
    private float f11230y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    private boolean f11231z = false;

    k(Drawable drawable) {
        this.f11228w = drawable;
    }

    public void a(float f2) {
        if (this.f11230y != f2) {
            this.f11230y = f2;
            this.B = true;
            invalidateSelf();
        }
    }

    public void a(int i2, float f2) {
        if (this.f11211f != i2 || this.f11208c != f2) {
            this.f11211f = i2;
            this.f11208c = f2;
            this.B = true;
            invalidateSelf();
        }
    }

    public void a(p pVar) {
        this.C = pVar;
    }

    public void a(boolean z2) {
        this.f11206a = z2;
        this.B = true;
        invalidateSelf();
    }

    public void a(float[] fArr) {
        if (fArr == null) {
            Arrays.fill(this.f11229x, 0.0f);
            this.f11207b = false;
        } else {
            c.a(fArr.length == 8, (Object) "radii should have exactly 8 values");
            System.arraycopy(fArr, 0, this.f11229x, 0, 8);
            this.f11207b = false;
            for (int i2 = 0; i2 < 8; i2++) {
                this.f11207b |= fArr[i2] > 0.0f;
            }
        }
        this.B = true;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f11206a || this.f11207b || this.f11208c > 0.0f;
    }

    public void b(boolean z2) {
        if (this.f11231z != z2) {
            this.f11231z = z2;
            this.B = true;
            invalidateSelf();
        }
    }

    public boolean b() {
        return this.A;
    }

    /* access modifiers changed from: protected */
    public void c() {
        Matrix matrix;
        p pVar = this.C;
        if (pVar != null) {
            pVar.a(this.f11222q);
            this.C.a(this.f11215j);
        } else {
            this.f11222q.reset();
            this.f11215j.set(getBounds());
        }
        this.f11217l.set(0.0f, 0.0f, (float) getIntrinsicWidth(), (float) getIntrinsicHeight());
        this.f11218m.set(this.f11228w.getBounds());
        this.f11220o.setRectToRect(this.f11217l, this.f11218m, Matrix.ScaleToFit.FILL);
        if (this.f11231z) {
            RectF rectF = this.f11219n;
            if (rectF == null) {
                this.f11219n = new RectF(this.f11215j);
            } else {
                rectF.set(this.f11215j);
            }
            RectF rectF2 = this.f11219n;
            float f2 = this.f11208c;
            rectF2.inset(f2, f2);
            if (this.f11225t == null) {
                this.f11225t = new Matrix();
            }
            this.f11225t.setRectToRect(this.f11215j, this.f11219n, Matrix.ScaleToFit.FILL);
        } else {
            Matrix matrix2 = this.f11225t;
            if (matrix2 != null) {
                matrix2.reset();
            }
        }
        if (!this.f11222q.equals(this.f11223r) || !this.f11220o.equals(this.f11221p) || ((matrix = this.f11225t) != null && !matrix.equals(this.f11226u))) {
            this.f11210e = true;
            this.f11222q.invert(this.f11224s);
            this.f11227v.set(this.f11222q);
            if (this.f11231z) {
                this.f11227v.postConcat(this.f11225t);
            }
            this.f11227v.preConcat(this.f11220o);
            this.f11223r.set(this.f11222q);
            this.f11221p.set(this.f11220o);
            if (this.f11231z) {
                Matrix matrix3 = this.f11226u;
                if (matrix3 == null) {
                    this.f11226u = new Matrix(this.f11225t);
                } else {
                    matrix3.set(this.f11225t);
                }
            } else {
                Matrix matrix4 = this.f11226u;
                if (matrix4 != null) {
                    matrix4.reset();
                }
            }
        }
        if (!this.f11215j.equals(this.f11216k)) {
            this.B = true;
            this.f11216k.set(this.f11215j);
        }
    }

    public void c(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            invalidateSelf();
        }
    }

    public void clearColorFilter() {
        this.f11228w.clearColorFilter();
    }

    /* access modifiers changed from: protected */
    public void d() {
        float[] fArr;
        if (this.B) {
            this.f11212g.reset();
            RectF rectF = this.f11215j;
            float f2 = this.f11208c;
            rectF.inset(f2 / 2.0f, f2 / 2.0f);
            if (this.f11206a) {
                this.f11212g.addCircle(this.f11215j.centerX(), this.f11215j.centerY(), Math.min(this.f11215j.width(), this.f11215j.height()) / 2.0f, Path.Direction.CW);
            } else {
                int i2 = 0;
                while (true) {
                    fArr = this.f11213h;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    fArr[i2] = (this.f11229x[i2] + this.f11230y) - (this.f11208c / 2.0f);
                    i2++;
                }
                this.f11212g.addRoundRect(this.f11215j, fArr, Path.Direction.CW);
            }
            RectF rectF2 = this.f11215j;
            float f3 = this.f11208c;
            rectF2.inset((-f3) / 2.0f, (-f3) / 2.0f);
            this.f11209d.reset();
            float f4 = this.f11230y + (this.f11231z ? this.f11208c : 0.0f);
            this.f11215j.inset(f4, f4);
            if (this.f11206a) {
                this.f11209d.addCircle(this.f11215j.centerX(), this.f11215j.centerY(), Math.min(this.f11215j.width(), this.f11215j.height()) / 2.0f, Path.Direction.CW);
            } else if (this.f11231z) {
                if (this.f11214i == null) {
                    this.f11214i = new float[8];
                }
                for (int i3 = 0; i3 < this.f11213h.length; i3++) {
                    this.f11214i[i3] = this.f11229x[i3] - this.f11208c;
                }
                this.f11209d.addRoundRect(this.f11215j, this.f11214i, Path.Direction.CW);
            } else {
                this.f11209d.addRoundRect(this.f11215j, this.f11229x, Path.Direction.CW);
            }
            float f5 = -f4;
            this.f11215j.inset(f5, f5);
            this.f11209d.setFillType(Path.FillType.WINDING);
            this.B = false;
        }
    }

    public void draw(Canvas canvas) {
        if (b.b()) {
            b.a("RoundedDrawable#draw");
        }
        this.f11228w.draw(canvas);
        if (b.b()) {
            b.a();
        }
    }

    public int getAlpha() {
        return this.f11228w.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.f11228w.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.f11228w.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f11228w.getIntrinsicWidth();
    }

    public int getOpacity() {
        return this.f11228w.getOpacity();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f11228w.setBounds(rect);
    }

    public void setAlpha(int i2) {
        this.f11228w.setAlpha(i2);
    }

    public void setColorFilter(int i2, PorterDuff.Mode mode) {
        this.f11228w.setColorFilter(i2, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11228w.setColorFilter(colorFilter);
    }
}
