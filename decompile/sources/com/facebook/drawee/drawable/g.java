package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class g extends Drawable implements Drawable.Callback, c, o, p {

    /* renamed from: d  reason: collision with root package name */
    private static final Matrix f11183d = new Matrix();

    /* renamed from: a  reason: collision with root package name */
    private Drawable f11184a;

    /* renamed from: b  reason: collision with root package name */
    protected p f11185b;

    /* renamed from: c  reason: collision with root package name */
    private final d f11186c = new d();

    public g(Drawable drawable) {
        this.f11184a = drawable;
        e.a(drawable, this, this);
    }

    public Drawable a() {
        return getCurrent();
    }

    public Drawable a(Drawable drawable) {
        return b(drawable);
    }

    public void a(Matrix matrix) {
        b(matrix);
    }

    public void a(RectF rectF) {
        p pVar = this.f11185b;
        if (pVar != null) {
            pVar.a(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public void a(p pVar) {
        this.f11185b = pVar;
    }

    public Drawable b(Drawable drawable) {
        Drawable c2 = c(drawable);
        invalidateSelf();
        return c2;
    }

    /* access modifiers changed from: protected */
    public void b(Matrix matrix) {
        p pVar = this.f11185b;
        if (pVar != null) {
            pVar.a(matrix);
        } else {
            matrix.reset();
        }
    }

    /* access modifiers changed from: protected */
    public Drawable c(Drawable drawable) {
        Drawable drawable2 = this.f11184a;
        e.a(drawable2, (Drawable.Callback) null, (p) null);
        e.a(drawable, (Drawable.Callback) null, (p) null);
        e.a(drawable, this.f11186c);
        e.a(drawable, (Drawable) this);
        e.a(drawable, this, this);
        this.f11184a = drawable;
        return drawable2;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f11184a;
        return drawable == null ? super.getConstantState() : drawable.getConstantState();
    }

    public Drawable getCurrent() {
        return this.f11184a;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f11184a;
        return drawable == null ? super.getIntrinsicHeight() : drawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f11184a;
        return drawable == null ? super.getIntrinsicWidth() : drawable.getIntrinsicWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f11184a;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f11184a;
        return drawable == null ? super.getPadding(rect) : drawable.getPadding(rect);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        Drawable drawable = this.f11184a;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    public Drawable mutate() {
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f11184a;
        return drawable == null ? super.onLevelChange(i2) : drawable.setLevel(i2);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f11184a;
        return drawable == null ? super.onStateChange(iArr) : drawable.setState(iArr);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f11186c.a(i2);
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11186c.a(colorFilter);
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    public void setDither(boolean z2) {
        this.f11186c.a(z2);
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.setDither(z2);
        }
    }

    public void setFilterBitmap(boolean z2) {
        this.f11186c.b(z2);
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.setFilterBitmap(z2);
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f11184a;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f11184a;
        return drawable == null ? visible : drawable.setVisible(z2, z3);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
