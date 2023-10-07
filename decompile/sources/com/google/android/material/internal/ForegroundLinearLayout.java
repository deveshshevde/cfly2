package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.R;

public class ForegroundLinearLayout extends LinearLayoutCompat {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f19190a;

    /* renamed from: b  reason: collision with root package name */
    boolean f19191b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f19192c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f19193d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f19194e;

    /* renamed from: f  reason: collision with root package name */
    private int f19195f;

    public ForegroundLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19193d = new Rect();
        this.f19194e = new Rect();
        this.f19195f = 119;
        this.f19190a = true;
        this.f19191b = false;
        TypedArray a2 = l.a(context, attributeSet, R.styleable.ForegroundLinearLayout, i2, 0, new int[0]);
        this.f19195f = a2.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f19195f);
        Drawable drawable = a2.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f19190a = a2.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
        a2.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.f19192c;
        if (drawable != null) {
            if (this.f19191b) {
                this.f19191b = false;
                Rect rect = this.f19193d;
                Rect rect2 = this.f19194e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f19190a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f19195f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.f19192c;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f19192c;
        if (drawable != null && drawable.isStateful()) {
            this.f19192c.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f19192c;
    }

    public int getForegroundGravity() {
        return this.f19195f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f19192c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f19191b = z2 | this.f19191b;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f19191b = true;
    }

    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.f19192c;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
                unscheduleDrawable(this.f19192c);
            }
            this.f19192c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f19195f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i2) {
        if (this.f19195f != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f19195f = i2;
            if (i2 == 119 && this.f19192c != null) {
                this.f19192c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f19192c;
    }
}
