package com.google.android.material.progressindicator;

import aj.b;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import com.google.android.material.R;
import com.google.android.material.internal.l;
import com.google.android.material.progressindicator.b;
import gx.a;
import java.util.Arrays;
import t.ac;

public abstract class BaseProgressIndicator<S extends b> extends ProgressBar {

    /* renamed from: a  reason: collision with root package name */
    static final int f19416a = R.style.Widget_MaterialComponents_ProgressIndicator;

    /* renamed from: b  reason: collision with root package name */
    S f19417b;

    /* renamed from: c  reason: collision with root package name */
    a f19418c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f19419d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f19420e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19421f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19422g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19423h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public long f19424i = -1;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f19425j = false;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f19426k = 4;

    /* renamed from: l  reason: collision with root package name */
    private final Runnable f19427l = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.e();
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private final Runnable f19428m = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.f();
            long unused = BaseProgressIndicator.this.f19424i = -1;
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private final b.a f19429n = new b.a() {
        public void b(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator.this.a(0, false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.a(baseProgressIndicator.f19419d, BaseProgressIndicator.this.f19420e);
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private final b.a f19430o = new b.a() {
        public void b(Drawable drawable) {
            super.b(drawable);
            if (!BaseProgressIndicator.this.f19425j) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.f19426k);
            }
        }
    };

    protected BaseProgressIndicator(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a.a(context, attributeSet, i2, f19416a), attributeSet, i2);
        Context context2 = getContext();
        this.f19417b = a(context2, attributeSet);
        TypedArray a2 = l.a(context2, attributeSet, R.styleable.BaseProgressIndicator, i2, i3, new int[0]);
        this.f19422g = a2.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.f19423h = Math.min(a2.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        a2.recycle();
        this.f19418c = new a();
        this.f19421f = true;
    }

    private void c() {
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().a().a(this.f19429n);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().b(this.f19430o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().b(this.f19430o);
        }
    }

    private void d() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().a(this.f19430o);
            getIndeterminateDrawable().a().e();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().a(this.f19430o);
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f19423h > 0) {
            this.f19424i = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void f() {
        ((f) getCurrentDrawable()).b(false, false, true);
        if (g()) {
            setVisibility(4);
        }
    }

    private boolean g() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private g<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().f();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().a();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract S a(Context context, AttributeSet attributeSet);

    public void a(int i2, boolean z2) {
        if (!isIndeterminate()) {
            super.setProgress(i2);
            if (getProgressDrawable() != null && !z2) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.f19419d = i2;
            this.f19420e = z2;
            this.f19425j = true;
            if (!getIndeterminateDrawable().isVisible() || this.f19418c.a(getContext().getContentResolver()) == 0.0f) {
                this.f19429n.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().a().c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        if (this.f19421f) {
            ((f) getCurrentDrawable()).b(a(), false, z2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return ac.J(this) && getWindowVisibility() == 0 && b();
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f19417b.f19449f;
    }

    public i<S> getIndeterminateDrawable() {
        return (i) super.getIndeterminateDrawable();
    }

    public int[] getIndicatorColor() {
        return this.f19417b.f19446c;
    }

    public e<S> getProgressDrawable() {
        return (e) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.f19417b.f19448e;
    }

    public int getTrackColor() {
        return this.f19417b.f19447d;
    }

    public int getTrackCornerRadius() {
        return this.f19417b.f19445b;
    }

    public int getTrackThickness() {
        return this.f19417b.f19444a;
    }

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        if (a()) {
            e();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.f19428m);
        removeCallbacks(this.f19427l);
        ((f) getCurrentDrawable()).b();
        d();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        g currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            int a2 = currentDrawingDelegate.a();
            int b2 = currentDrawingDelegate.b();
            setMeasuredDimension(a2 < 0 ? getMeasuredWidth() : a2 + getPaddingLeft() + getPaddingRight(), b2 < 0 ? getMeasuredHeight() : b2 + getPaddingTop() + getPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a(i2 == 0);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a(false);
    }

    public void setAnimatorDurationScaleProvider(a aVar) {
        this.f19418c = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f19478c = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f19478c = aVar;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.f19417b.f19449f = i2;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z2) {
        if (z2 != isIndeterminate()) {
            if (a()) {
                if (z2) {
                    throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
                }
            }
            f fVar = (f) getCurrentDrawable();
            if (fVar != null) {
                fVar.b();
            }
            super.setIndeterminate(z2);
            f fVar2 = (f) getCurrentDrawable();
            if (fVar2 != null) {
                fVar2.b(a(), false, false);
            }
            this.f19425j = false;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable((Drawable) null);
        } else if (drawable instanceof i) {
            ((f) drawable).b();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{gn.a.a(getContext(), R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.f19417b.f19446c = iArr;
            getIndeterminateDrawable().a().d();
            invalidate();
        }
    }

    public synchronized void setProgress(int i2) {
        if (!isIndeterminate()) {
            a(i2, false);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable((Drawable) null);
        } else if (drawable instanceof e) {
            e eVar = (e) drawable;
            eVar.b();
            super.setProgressDrawable(eVar);
            eVar.a(((float) getProgress()) / ((float) getMax()));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.f19417b.f19448e = i2;
        invalidate();
    }

    public void setTrackColor(int i2) {
        if (this.f19417b.f19447d != i2) {
            this.f19417b.f19447d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i2) {
        if (this.f19417b.f19445b != i2) {
            S s2 = this.f19417b;
            s2.f19445b = Math.min(i2, s2.f19444a / 2);
        }
    }

    public void setTrackThickness(int i2) {
        if (this.f19417b.f19444a != i2) {
            this.f19417b.f19444a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 == 0 || i2 == 4 || i2 == 8) {
            this.f19426k = i2;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
}
