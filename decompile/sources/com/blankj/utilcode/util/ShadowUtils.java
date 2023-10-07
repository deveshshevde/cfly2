package com.blankj.utilcode.util;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
import androidx.core.graphics.drawable.a;
import t.ac;

public class ShadowUtils {
    private static final int SHADOW_TAG = -16;

    public static class Config {
        private static final int SHADOW_COLOR_DEFAULT = 1140850688;
        private static final int SHADOW_SIZE = UtilsBridge.dp2px(8.0f);
        private boolean isCircle = false;
        private int mShadowColorNormal = SHADOW_COLOR_DEFAULT;
        private int mShadowColorPressed = SHADOW_COLOR_DEFAULT;
        private float mShadowMaxSizeNormal = -1.0f;
        private float mShadowMaxSizePressed = -1.0f;
        private float mShadowRadius = -1.0f;
        private float mShadowSizeNormal = -1.0f;
        private float mShadowSizePressed = -1.0f;

        private float getShadowMaxSizeNormal() {
            if (this.mShadowMaxSizeNormal == -1.0f) {
                this.mShadowMaxSizeNormal = getShadowSizeNormal();
            }
            return this.mShadowMaxSizeNormal;
        }

        private float getShadowMaxSizePressed() {
            if (this.mShadowMaxSizePressed == -1.0f) {
                this.mShadowMaxSizePressed = getShadowSizePressed();
            }
            return this.mShadowMaxSizePressed;
        }

        private float getShadowRadius() {
            if (this.mShadowRadius < 0.0f) {
                this.mShadowRadius = 0.0f;
            }
            return this.mShadowRadius;
        }

        private float getShadowSizeNormal() {
            if (this.mShadowSizeNormal == -1.0f) {
                this.mShadowSizeNormal = (float) SHADOW_SIZE;
            }
            return this.mShadowSizeNormal;
        }

        private float getShadowSizePressed() {
            if (this.mShadowSizePressed == -1.0f) {
                this.mShadowSizePressed = getShadowSizeNormal();
            }
            return this.mShadowSizePressed;
        }

        /* access modifiers changed from: package-private */
        public Drawable apply(Drawable drawable) {
            if (drawable == null) {
                drawable = new ColorDrawable(0);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = drawable;
            stateListDrawable.addState(new int[]{16842919}, new ShadowDrawable(drawable2, getShadowRadius(), getShadowSizeNormal(), getShadowMaxSizeNormal(), this.mShadowColorPressed, this.isCircle));
            stateListDrawable.addState(StateSet.WILD_CARD, new ShadowDrawable(drawable2, getShadowRadius(), getShadowSizePressed(), getShadowMaxSizePressed(), this.mShadowColorNormal, this.isCircle));
            return stateListDrawable;
        }

        public Config setCircle() {
            this.isCircle = true;
            if (this.mShadowRadius == -1.0f) {
                return this;
            }
            throw new IllegalArgumentException("Set circle needn't set radius.");
        }

        public Config setShadowColor(int i2) {
            return setShadowColor(i2, i2);
        }

        public Config setShadowColor(int i2, int i3) {
            this.mShadowColorNormal = i2;
            this.mShadowColorPressed = i3;
            return this;
        }

        public Config setShadowMaxSize(int i2) {
            return setShadowMaxSize(i2, i2);
        }

        public Config setShadowMaxSize(int i2, int i3) {
            this.mShadowMaxSizeNormal = (float) i2;
            this.mShadowMaxSizePressed = (float) i3;
            return this;
        }

        public Config setShadowRadius(float f2) {
            this.mShadowRadius = f2;
            if (!this.isCircle) {
                return this;
            }
            throw new IllegalArgumentException("Set circle needn't set radius.");
        }

        public Config setShadowSize(int i2) {
            return setShadowSize(i2, i2);
        }

        public Config setShadowSize(int i2, int i3) {
            this.mShadowSizeNormal = (float) i2;
            this.mShadowSizePressed = (float) i3;
            return this;
        }
    }

    static class DrawableWrapper extends Drawable implements Drawable.Callback {
        private Drawable mDrawable;

        public DrawableWrapper(Drawable drawable) {
            setWrappedDrawable(drawable);
        }

        public void draw(Canvas canvas) {
            this.mDrawable.draw(canvas);
        }

        public int getChangingConfigurations() {
            return this.mDrawable.getChangingConfigurations();
        }

        public Drawable getCurrent() {
            return this.mDrawable.getCurrent();
        }

        public int getIntrinsicHeight() {
            return this.mDrawable.getIntrinsicHeight();
        }

        public int getIntrinsicWidth() {
            return this.mDrawable.getIntrinsicWidth();
        }

        public int getMinimumHeight() {
            return this.mDrawable.getMinimumHeight();
        }

        public int getMinimumWidth() {
            return this.mDrawable.getMinimumWidth();
        }

        public int getOpacity() {
            return this.mDrawable.getOpacity();
        }

        public boolean getPadding(Rect rect) {
            return this.mDrawable.getPadding(rect);
        }

        public int[] getState() {
            return this.mDrawable.getState();
        }

        public Region getTransparentRegion() {
            return this.mDrawable.getTransparentRegion();
        }

        public Drawable getWrappedDrawable() {
            return this.mDrawable;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidateSelf();
        }

        public boolean isAutoMirrored() {
            return a.b(this.mDrawable);
        }

        public boolean isStateful() {
            return this.mDrawable.isStateful();
        }

        public void jumpToCurrentState() {
            a.a(this.mDrawable);
        }

        /* access modifiers changed from: protected */
        public void onBoundsChange(Rect rect) {
            this.mDrawable.setBounds(rect);
        }

        /* access modifiers changed from: protected */
        public boolean onLevelChange(int i2) {
            return this.mDrawable.setLevel(i2);
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            scheduleSelf(runnable, j2);
        }

        public void setAlpha(int i2) {
            this.mDrawable.setAlpha(i2);
        }

        public void setAutoMirrored(boolean z2) {
            a.a(this.mDrawable, z2);
        }

        public void setChangingConfigurations(int i2) {
            this.mDrawable.setChangingConfigurations(i2);
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mDrawable.setColorFilter(colorFilter);
        }

        public void setDither(boolean z2) {
            this.mDrawable.setDither(z2);
        }

        public void setFilterBitmap(boolean z2) {
            this.mDrawable.setFilterBitmap(z2);
        }

        public void setHotspot(float f2, float f3) {
            a.a(this.mDrawable, f2, f3);
        }

        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            a.a(this.mDrawable, i2, i3, i4, i5);
        }

        public boolean setState(int[] iArr) {
            return this.mDrawable.setState(iArr);
        }

        public void setTint(int i2) {
            a.a(this.mDrawable, i2);
        }

        public void setTintList(ColorStateList colorStateList) {
            a.a(this.mDrawable, colorStateList);
        }

        public void setTintMode(PorterDuff.Mode mode) {
            a.a(this.mDrawable, mode);
        }

        public boolean setVisible(boolean z2, boolean z3) {
            return super.setVisible(z2, z3) || this.mDrawable.setVisible(z2, z3);
        }

        public void setWrappedDrawable(Drawable drawable) {
            Drawable drawable2 = this.mDrawable;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            this.mDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            unscheduleSelf(runnable);
        }
    }

    public static class ShadowDrawable extends DrawableWrapper {
        private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
        private boolean isCircle;
        private boolean mAddPaddingForCorners = false;
        private RectF mContentBounds;
        private float mCornerRadius;
        private Paint mCornerShadowPaint;
        private Path mCornerShadowPath;
        private boolean mDirty = true;
        private Paint mEdgeShadowPaint;
        private float mMaxShadowSize;
        private float mRawMaxShadowSize;
        private float mRawShadowSize;
        private float mRotation;
        private float mShadowBottomScale = 1.0f;
        private final int mShadowEndColor;
        private float mShadowHorizScale = 1.0f;
        private float mShadowMultiplier = 1.0f;
        private float mShadowSize;
        private final int mShadowStartColor;
        private float mShadowTopScale = 1.0f;

        public ShadowDrawable(Drawable drawable, float f2, float f3, float f4, int i2, boolean z2) {
            super(drawable);
            this.mShadowStartColor = i2;
            this.mShadowEndColor = i2 & 16777215;
            this.isCircle = z2;
            if (z2) {
                this.mShadowMultiplier = 1.0f;
                this.mShadowTopScale = 1.0f;
                this.mShadowHorizScale = 1.0f;
                this.mShadowBottomScale = 1.0f;
            }
            Paint paint = new Paint(5);
            this.mCornerShadowPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mCornerRadius = (float) Math.round(f2);
            this.mContentBounds = new RectF();
            Paint paint2 = new Paint(this.mCornerShadowPaint);
            this.mEdgeShadowPaint = paint2;
            paint2.setAntiAlias(false);
            setShadowSize(f3, f4);
        }

        private void buildComponents(Rect rect) {
            if (this.isCircle) {
                this.mCornerRadius = (float) (rect.width() / 2);
            }
            float f2 = this.mRawMaxShadowSize * this.mShadowMultiplier;
            this.mContentBounds.set(((float) rect.left) + this.mRawMaxShadowSize, ((float) rect.top) + f2, ((float) rect.right) - this.mRawMaxShadowSize, ((float) rect.bottom) - f2);
            getWrappedDrawable().setBounds((int) this.mContentBounds.left, (int) this.mContentBounds.top, (int) this.mContentBounds.right, (int) this.mContentBounds.bottom);
            buildShadowCorners();
        }

        private void buildShadowCorners() {
            if (this.isCircle) {
                float width = (this.mContentBounds.width() / 2.0f) - 1.0f;
                float f2 = -width;
                RectF rectF = new RectF(f2, f2, width, width);
                RectF rectF2 = new RectF(rectF);
                float f3 = this.mShadowSize;
                rectF2.inset(-f3, -f3);
                Path path = this.mCornerShadowPath;
                if (path == null) {
                    this.mCornerShadowPath = new Path();
                } else {
                    path.reset();
                }
                this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
                this.mCornerShadowPath.moveTo(f2, 0.0f);
                this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
                this.mCornerShadowPath.arcTo(rectF2, 180.0f, 180.0f, false);
                this.mCornerShadowPath.arcTo(rectF2, 0.0f, 180.0f, false);
                this.mCornerShadowPath.arcTo(rectF, 180.0f, 180.0f, false);
                this.mCornerShadowPath.arcTo(rectF, 0.0f, 180.0f, false);
                this.mCornerShadowPath.close();
                float f4 = -rectF2.top;
                if (f4 > 0.0f) {
                    Paint paint = this.mCornerShadowPaint;
                    RadialGradient radialGradient = r9;
                    RadialGradient radialGradient2 = new RadialGradient(0.0f, 0.0f, f4, new int[]{0, this.mShadowStartColor, this.mShadowEndColor}, new float[]{0.0f, width / f4, 1.0f}, Shader.TileMode.CLAMP);
                    paint.setShader(radialGradient);
                    return;
                }
                return;
            }
            float f5 = this.mCornerRadius;
            RectF rectF3 = new RectF(-f5, -f5, f5, f5);
            RectF rectF4 = new RectF(rectF3);
            float f6 = this.mShadowSize;
            rectF4.inset(-f6, -f6);
            Path path2 = this.mCornerShadowPath;
            if (path2 == null) {
                this.mCornerShadowPath = new Path();
            } else {
                path2.reset();
            }
            this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
            this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
            this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
            this.mCornerShadowPath.arcTo(rectF4, 180.0f, 90.0f, false);
            this.mCornerShadowPath.arcTo(rectF3, 270.0f, -90.0f, false);
            this.mCornerShadowPath.close();
            float f7 = -rectF4.top;
            if (f7 > 0.0f) {
                Paint paint2 = this.mCornerShadowPaint;
                int[] iArr = {0, this.mShadowStartColor, this.mShadowEndColor};
                RadialGradient radialGradient3 = r10;
                int[] iArr2 = iArr;
                RadialGradient radialGradient4 = new RadialGradient(0.0f, 0.0f, f7, iArr2, new float[]{0.0f, this.mCornerRadius / f7, 1.0f}, Shader.TileMode.CLAMP);
                paint2.setShader(radialGradient3);
            }
            this.mEdgeShadowPaint.setShader(new LinearGradient(0.0f, rectF3.top, 0.0f, rectF4.top, this.mShadowStartColor, this.mShadowEndColor, Shader.TileMode.CLAMP));
            this.mEdgeShadowPaint.setAntiAlias(false);
        }

        private static float calculateHorizontalPadding(float f2, float f3, boolean z2) {
            if (!z2) {
                return f2;
            }
            double d2 = (double) f2;
            double d3 = (double) f3;
            Double.isNaN(d3);
            Double.isNaN(d2);
            return (float) (d2 + ((1.0d - COS_45) * d3));
        }

        private float calculateVerticalPadding(float f2, float f3, boolean z2) {
            if (!z2) {
                return f2 * this.mShadowMultiplier;
            }
            double d2 = (double) (f2 * this.mShadowMultiplier);
            double d3 = (double) f3;
            Double.isNaN(d3);
            Double.isNaN(d2);
            return (float) (d2 + ((1.0d - COS_45) * d3));
        }

        private void drawShadow(Canvas canvas) {
            float f2;
            int i2;
            int i3;
            float f3;
            float f4;
            float f5;
            int i4;
            Canvas canvas2 = canvas;
            if (this.isCircle) {
                i4 = canvas.save();
                canvas2.translate(this.mContentBounds.centerX(), this.mContentBounds.centerY());
                canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            } else {
                int save = canvas.save();
                canvas2.rotate(this.mRotation, this.mContentBounds.centerX(), this.mContentBounds.centerY());
                float f6 = this.mCornerRadius;
                float f7 = (-f6) - this.mShadowSize;
                float f8 = f6 * 2.0f;
                boolean z2 = this.mContentBounds.width() - f8 > 0.0f;
                boolean z3 = this.mContentBounds.height() - f8 > 0.0f;
                float f9 = this.mRawShadowSize;
                float f10 = f9 - (this.mShadowTopScale * f9);
                float f11 = f9 - (this.mShadowHorizScale * f9);
                float f12 = f9 - (this.mShadowBottomScale * f9);
                float f13 = f6 == 0.0f ? 1.0f : f6 / (f11 + f6);
                float f14 = f6 == 0.0f ? 1.0f : f6 / (f10 + f6);
                float f15 = f6 == 0.0f ? 1.0f : f6 / (f12 + f6);
                int save2 = canvas.save();
                canvas2.translate(this.mContentBounds.left + f6, this.mContentBounds.top + f6);
                canvas2.scale(f13, f14);
                canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
                if (z2) {
                    canvas2.scale(1.0f / f13, 1.0f);
                    i3 = save2;
                    f2 = f15;
                    i2 = save;
                    f3 = f14;
                    canvas.drawRect(0.0f, f7, this.mContentBounds.width() - f8, -this.mCornerRadius, this.mEdgeShadowPaint);
                } else {
                    i3 = save2;
                    f2 = f15;
                    i2 = save;
                    f3 = f14;
                }
                canvas2.restoreToCount(i3);
                int save3 = canvas.save();
                canvas2.translate(this.mContentBounds.right - f6, this.mContentBounds.bottom - f6);
                float f16 = f2;
                canvas2.scale(f13, f16);
                canvas2.rotate(180.0f);
                canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
                if (z2) {
                    canvas2.scale(1.0f / f13, 1.0f);
                    f4 = f3;
                    f5 = f16;
                    canvas.drawRect(0.0f, f7, this.mContentBounds.width() - f8, -this.mCornerRadius, this.mEdgeShadowPaint);
                } else {
                    f4 = f3;
                    f5 = f16;
                }
                canvas2.restoreToCount(save3);
                int save4 = canvas.save();
                canvas2.translate(this.mContentBounds.left + f6, this.mContentBounds.bottom - f6);
                canvas2.scale(f13, f5);
                canvas2.rotate(270.0f);
                canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
                if (z3) {
                    canvas2.scale(1.0f / f5, 1.0f);
                    canvas.drawRect(0.0f, f7, this.mContentBounds.height() - f8, -this.mCornerRadius, this.mEdgeShadowPaint);
                }
                canvas2.restoreToCount(save4);
                int save5 = canvas.save();
                canvas2.translate(this.mContentBounds.right - f6, this.mContentBounds.top + f6);
                float f17 = f4;
                canvas2.scale(f13, f17);
                canvas2.rotate(90.0f);
                canvas2.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
                if (z3) {
                    canvas2.scale(1.0f / f17, 1.0f);
                    canvas.drawRect(0.0f, f7, this.mContentBounds.height() - f8, -this.mCornerRadius, this.mEdgeShadowPaint);
                }
                canvas2.restoreToCount(save5);
                i4 = i2;
            }
            canvas2.restoreToCount(i4);
        }

        private static int toEven(float f2) {
            int round = Math.round(f2);
            return round % 2 == 1 ? round - 1 : round;
        }

        public void draw(Canvas canvas) {
            if (this.mDirty) {
                buildComponents(getBounds());
                this.mDirty = false;
            }
            drawShadow(canvas);
            super.draw(canvas);
        }

        public /* bridge */ /* synthetic */ int getChangingConfigurations() {
            return super.getChangingConfigurations();
        }

        public float getCornerRadius() {
            return this.mCornerRadius;
        }

        public /* bridge */ /* synthetic */ Drawable getCurrent() {
            return super.getCurrent();
        }

        public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
            return super.getIntrinsicHeight();
        }

        public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
            return super.getIntrinsicWidth();
        }

        public float getMaxShadowSize() {
            return this.mRawMaxShadowSize;
        }

        public float getMinHeight() {
            float f2 = this.mRawMaxShadowSize;
            return (Math.max(f2, this.mCornerRadius + ((this.mShadowMultiplier * f2) / 2.0f)) * 2.0f) + (this.mRawMaxShadowSize * this.mShadowMultiplier * 2.0f);
        }

        public float getMinWidth() {
            float f2 = this.mRawMaxShadowSize;
            return (Math.max(f2, this.mCornerRadius + (f2 / 2.0f)) * 2.0f) + (this.mRawMaxShadowSize * 2.0f);
        }

        public /* bridge */ /* synthetic */ int getMinimumHeight() {
            return super.getMinimumHeight();
        }

        public /* bridge */ /* synthetic */ int getMinimumWidth() {
            return super.getMinimumWidth();
        }

        public int getOpacity() {
            return -3;
        }

        public boolean getPadding(Rect rect) {
            int ceil = (int) Math.ceil((double) calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
            int ceil2 = (int) Math.ceil((double) calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
            rect.set(ceil2, ceil, ceil2, ceil);
            return true;
        }

        public float getShadowSize() {
            return this.mRawShadowSize;
        }

        public /* bridge */ /* synthetic */ int[] getState() {
            return super.getState();
        }

        public /* bridge */ /* synthetic */ Region getTransparentRegion() {
            return super.getTransparentRegion();
        }

        public /* bridge */ /* synthetic */ Drawable getWrappedDrawable() {
            return super.getWrappedDrawable();
        }

        public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
            super.invalidateDrawable(drawable);
        }

        public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
            return super.isAutoMirrored();
        }

        public /* bridge */ /* synthetic */ boolean isStateful() {
            return super.isStateful();
        }

        public /* bridge */ /* synthetic */ void jumpToCurrentState() {
            super.jumpToCurrentState();
        }

        /* access modifiers changed from: protected */
        public void onBoundsChange(Rect rect) {
            this.mDirty = true;
        }

        public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            super.scheduleDrawable(drawable, runnable, j2);
        }

        public void setAddPaddingForCorners(boolean z2) {
            this.mAddPaddingForCorners = z2;
            invalidateSelf();
        }

        public void setAlpha(int i2) {
            super.setAlpha(i2);
            this.mCornerShadowPaint.setAlpha(i2);
            this.mEdgeShadowPaint.setAlpha(i2);
        }

        public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z2) {
            super.setAutoMirrored(z2);
        }

        public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
            super.setChangingConfigurations(i2);
        }

        public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
            super.setColorFilter(colorFilter);
        }

        public void setCornerRadius(float f2) {
            float round = (float) Math.round(f2);
            if (this.mCornerRadius != round) {
                this.mCornerRadius = round;
                this.mDirty = true;
                invalidateSelf();
            }
        }

        public /* bridge */ /* synthetic */ void setDither(boolean z2) {
            super.setDither(z2);
        }

        public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
            super.setFilterBitmap(z2);
        }

        public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
            super.setHotspot(f2, f3);
        }

        public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
            super.setHotspotBounds(i2, i3, i4, i5);
        }

        public void setMaxShadowSize(float f2) {
            setShadowSize(this.mRawShadowSize, f2);
        }

        /* access modifiers changed from: package-private */
        public final void setRotation(float f2) {
            if (this.mRotation != f2) {
                this.mRotation = f2;
                invalidateSelf();
            }
        }

        public void setShadowSize(float f2) {
            setShadowSize(f2, this.mRawMaxShadowSize);
        }

        /* access modifiers changed from: package-private */
        public void setShadowSize(float f2, float f3) {
            if (f2 < 0.0f || f3 < 0.0f) {
                throw new IllegalArgumentException("invalid shadow size");
            }
            float even = (float) toEven(f2);
            float even2 = (float) toEven(f3);
            if (even > even2) {
                even = even2;
            }
            if (this.mRawShadowSize != even || this.mRawMaxShadowSize != even2) {
                this.mRawShadowSize = even;
                this.mRawMaxShadowSize = even2;
                this.mShadowSize = (float) Math.round(even * this.mShadowMultiplier);
                this.mMaxShadowSize = even2;
                this.mDirty = true;
                invalidateSelf();
            }
        }

        public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
            return super.setState(iArr);
        }

        public /* bridge */ /* synthetic */ void setTint(int i2) {
            super.setTint(i2);
        }

        public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
            super.setTintList(colorStateList);
        }

        public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
            super.setTintMode(mode);
        }

        public /* bridge */ /* synthetic */ boolean setVisible(boolean z2, boolean z3) {
            return super.setVisible(z2, z3);
        }

        public /* bridge */ /* synthetic */ void setWrappedDrawable(Drawable drawable) {
            super.setWrappedDrawable(drawable);
        }

        public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            super.unscheduleDrawable(drawable, runnable);
        }
    }

    public static void apply(View view, Config config) {
        if (view != null && config != null) {
            Drawable background = view.getBackground();
            Object tag = view.getTag(SHADOW_TAG);
            if (tag instanceof Drawable) {
                ac.a(view, (Drawable) tag);
                return;
            }
            Drawable apply = config.apply(background);
            ac.a(view, apply);
            view.setTag(SHADOW_TAG, apply);
        }
    }

    public static void apply(View... viewArr) {
        if (viewArr != null) {
            for (View apply : viewArr) {
                apply(apply, new Config());
            }
        }
    }
}
