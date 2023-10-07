package d;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.a;

public class c extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f26669a;

    public c(Drawable drawable) {
        a(drawable);
    }

    public Drawable a() {
        return this.f26669a;
    }

    public void a(Drawable drawable) {
        Drawable drawable2 = this.f26669a;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f26669a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(Canvas canvas) {
        this.f26669a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f26669a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f26669a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f26669a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f26669a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f26669a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f26669a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f26669a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f26669a.getPadding(rect);
    }

    public int[] getState() {
        return this.f26669a.getState();
    }

    public Region getTransparentRegion() {
        return this.f26669a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return a.b(this.f26669a);
    }

    public boolean isStateful() {
        return this.f26669a.isStateful();
    }

    public void jumpToCurrentState() {
        this.f26669a.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f26669a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.f26669a.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f26669a.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z2) {
        a.a(this.f26669a, z2);
    }

    public void setChangingConfigurations(int i2) {
        this.f26669a.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f26669a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z2) {
        this.f26669a.setDither(z2);
    }

    public void setFilterBitmap(boolean z2) {
        this.f26669a.setFilterBitmap(z2);
    }

    public void setHotspot(float f2, float f3) {
        a.a(this.f26669a, f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        a.a(this.f26669a, i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        return this.f26669a.setState(iArr);
    }

    public void setTint(int i2) {
        a.a(this.f26669a, i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        a.a(this.f26669a, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        a.a(this.f26669a, mode);
    }

    public boolean setVisible(boolean z2, boolean z3) {
        return super.setVisible(z2, z3) || this.f26669a.setVisible(z2, z3);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
