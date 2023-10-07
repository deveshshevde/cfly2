package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

class d extends Drawable implements Drawable.Callback, b, c {

    /* renamed from: a  reason: collision with root package name */
    static final PorterDuff.Mode f2973a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    f f2974b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f2975c;

    /* renamed from: d  reason: collision with root package name */
    private int f2976d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f2977e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2978f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2979g;

    d(Drawable drawable) {
        this.f2974b = c();
        a(drawable);
    }

    d(f fVar, Resources resources) {
        this.f2974b = fVar;
        a(resources);
    }

    private void a(Resources resources) {
        f fVar = this.f2974b;
        if (fVar != null && fVar.f2982b != null) {
            a(this.f2974b.f2982b.newDrawable(resources));
        }
    }

    private boolean a(int[] iArr) {
        if (!b()) {
            return false;
        }
        ColorStateList colorStateList = this.f2974b.f2983c;
        PorterDuff.Mode mode = this.f2974b.f2984d;
        if (colorStateList == null || mode == null) {
            this.f2978f = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.f2978f && colorForState == this.f2976d && mode == this.f2977e)) {
                setColorFilter(colorForState, mode);
                this.f2976d = colorForState;
                this.f2977e = mode;
                this.f2978f = true;
                return true;
            }
        }
        return false;
    }

    private f c() {
        return new f(this.f2974b);
    }

    public final Drawable a() {
        return this.f2975c;
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.f2975c;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f2975c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            f fVar = this.f2974b;
            if (fVar != null) {
                fVar.f2982b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f2975c.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        f fVar = this.f2974b;
        return changingConfigurations | (fVar != null ? fVar.getChangingConfigurations() : 0) | this.f2975c.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        f fVar = this.f2974b;
        if (fVar == null || !fVar.a()) {
            return null;
        }
        this.f2974b.f2981a = getChangingConfigurations();
        return this.f2974b;
    }

    public Drawable getCurrent() {
        return this.f2975c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2975c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2975c.getIntrinsicWidth();
    }

    public int getLayoutDirection() {
        return a.i(this.f2975c);
    }

    public int getMinimumHeight() {
        return this.f2975c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f2975c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2975c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f2975c.getPadding(rect);
    }

    public int[] getState() {
        return this.f2975c.getState();
    }

    public Region getTransparentRegion() {
        return this.f2975c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.b(this.f2975c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.f2974b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.b()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.f r0 = r1.f2974b
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f2983c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.f2975c
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.d.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.f2975c.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (!this.f2979g && super.mutate() == this) {
            this.f2974b = c();
            Drawable drawable = this.f2975c;
            if (drawable != null) {
                drawable.mutate();
            }
            f fVar = this.f2974b;
            if (fVar != null) {
                Drawable drawable2 = this.f2975c;
                fVar.f2982b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f2979g = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2975c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return a.b(this.f2975c, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f2975c.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f2975c.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z2) {
        a.a(this.f2975c, z2);
    }

    public void setChangingConfigurations(int i2) {
        this.f2975c.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2975c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z2) {
        this.f2975c.setDither(z2);
    }

    public void setFilterBitmap(boolean z2) {
        this.f2975c.setFilterBitmap(z2);
    }

    public boolean setState(int[] iArr) {
        return a(iArr) || this.f2975c.setState(iArr);
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f2974b.f2983c = colorStateList;
        a(getState());
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f2974b.f2984d = mode;
        a(getState());
    }

    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f2975c.setVisible(z2, z3);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
