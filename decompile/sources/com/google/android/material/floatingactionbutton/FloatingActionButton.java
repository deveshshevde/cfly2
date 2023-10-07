package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.n;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.d;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import gl.k;
import gw.m;
import gw.p;
import java.util.List;
import t.aa;
import t.ac;

public class FloatingActionButton extends VisibilityAwareImageButton implements CoordinatorLayout.a, n, gr.a, p, aa {

    /* renamed from: c  reason: collision with root package name */
    private static final int f19063c = R.style.Widget_Design_FloatingActionButton;

    /* renamed from: a  reason: collision with root package name */
    boolean f19064a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f19065b;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f19066d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f19067e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f19068f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f19069g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f19070h;

    /* renamed from: i  reason: collision with root package name */
    private int f19071i;

    /* renamed from: j  reason: collision with root package name */
    private int f19072j;

    /* renamed from: k  reason: collision with root package name */
    private int f19073k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f19074l;

    /* renamed from: m  reason: collision with root package name */
    private int f19075m;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f19076n;

    /* renamed from: o  reason: collision with root package name */
    private final h f19077o;

    /* renamed from: p  reason: collision with root package name */
    private final gr.c f19078p;

    /* renamed from: q  reason: collision with root package name */
    private d f19079q;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f19082a;

        /* renamed from: b  reason: collision with root package name */
        private a f19083b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19084c;

        public BaseBehavior() {
            this.f19084c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f19084c = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.f19065b;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) floatingActionButton.getLayoutParams();
                int i2 = 0;
                int i3 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin ? rect.right : floatingActionButton.getLeft() <= dVar.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - dVar.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    ac.e((View) floatingActionButton, i2);
                }
                if (i3 != 0) {
                    ac.f((View) floatingActionButton, i3);
                }
            }
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.f19084c && ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f19082a == null) {
                this.f19082a = new Rect();
            }
            Rect rect = this.f19082a;
            com.google.android.material.internal.c.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.f19083b, false);
                return true;
            }
            floatingActionButton.a(this.f19083b, false);
            return true;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.d) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.b(this.f19083b, false);
                return true;
            }
            floatingActionButton.a(this.f19083b, false);
            return true;
        }

        public void a(CoordinatorLayout.d dVar) {
            if (dVar.f2760h == 0) {
                dVar.f2760h = 80;
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List<View> c2 = coordinatorLayout.c((View) floatingActionButton);
            int size = c2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = c2.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.b((View) floatingActionButton, i2);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f19065b;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!a(view)) {
                return false;
            } else {
                b(view, floatingActionButton);
                return false;
            }
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout.d dVar) {
            super.a(dVar);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.a(coordinatorLayout, floatingActionButton, i2);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.b(coordinatorLayout, floatingActionButton, view);
        }
    }

    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class b implements gv.b {
        b() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.f19065b.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f19074l, i3 + FloatingActionButton.this.f19074l, i4 + FloatingActionButton.this.f19074l, i5 + FloatingActionButton.this.f19074l);
        }

        public void a(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        public boolean a() {
            return FloatingActionButton.this.f19064a;
        }
    }

    class c<T extends FloatingActionButton> implements d.C0129d {

        /* renamed from: b  reason: collision with root package name */
        private final k<T> f19087b;

        c(k<T> kVar) {
            this.f19087b = kVar;
        }

        public void a() {
            this.f19087b.a(FloatingActionButton.this);
        }

        public void b() {
            this.f19087b.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).f19087b.equals(this.f19087b);
        }

        public int hashCode() {
            return this.f19087b.hashCode();
        }
    }

    public FloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FloatingActionButton(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = f19063c
            android.content.Context r11 = gx.a.a(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r10.f19065b = r11
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r10.f19076n = r11
            android.content.Context r11 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.FloatingActionButton
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r11
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.FloatingActionButton_backgroundTint
            android.content.res.ColorStateList r1 = gt.c.a((android.content.Context) r11, (android.content.res.TypedArray) r0, (int) r1)
            r10.f19066d = r1
            int r1 = com.google.android.material.R.styleable.FloatingActionButton_backgroundTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            r3 = 0
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.s.a((int) r1, (android.graphics.PorterDuff.Mode) r3)
            r10.f19067e = r1
            int r1 = com.google.android.material.R.styleable.FloatingActionButton_rippleColor
            android.content.res.ColorStateList r1 = gt.c.a((android.content.Context) r11, (android.content.res.TypedArray) r0, (int) r1)
            r10.f19070h = r1
            int r1 = com.google.android.material.R.styleable.FloatingActionButton_fabSize
            int r1 = r0.getInt(r1, r2)
            r10.f19072j = r1
            int r1 = com.google.android.material.R.styleable.FloatingActionButton_fabCustomSize
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r10.f19073k = r1
            int r1 = com.google.android.material.R.styleable.FloatingActionButton_borderWidth
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r10.f19071i = r1
            int r1 = com.google.android.material.R.styleable.FloatingActionButton_elevation
            r2 = 0
            float r1 = r0.getDimension(r1, r2)
            int r3 = com.google.android.material.R.styleable.FloatingActionButton_hoveredFocusedTranslationZ
            float r3 = r0.getDimension(r3, r2)
            int r4 = com.google.android.material.R.styleable.FloatingActionButton_pressedTranslationZ
            float r2 = r0.getDimension(r4, r2)
            int r4 = com.google.android.material.R.styleable.FloatingActionButton_useCompatPadding
            boolean r4 = r0.getBoolean(r4, r7)
            r10.f19064a = r4
            android.content.res.Resources r4 = r10.getResources()
            int r5 = com.google.android.material.R.dimen.mtrl_fab_min_touch_target
            int r4 = r4.getDimensionPixelSize(r5)
            int r5 = com.google.android.material.R.styleable.FloatingActionButton_maxImageSize
            int r5 = r0.getDimensionPixelSize(r5, r7)
            r10.f19075m = r5
            int r5 = com.google.android.material.R.styleable.FloatingActionButton_showMotionSpec
            gl.h r5 = gl.h.a((android.content.Context) r11, (android.content.res.TypedArray) r0, (int) r5)
            int r8 = com.google.android.material.R.styleable.FloatingActionButton_hideMotionSpec
            gl.h r8 = gl.h.a((android.content.Context) r11, (android.content.res.TypedArray) r0, (int) r8)
            gw.c r9 = gw.m.f13193a
            gw.m$a r11 = gw.m.a((android.content.Context) r11, (android.util.AttributeSet) r12, (int) r13, (int) r6, (gw.c) r9)
            gw.m r11 = r11.a()
            int r6 = com.google.android.material.R.styleable.FloatingActionButton_ensureMinTouchTargetSize
            boolean r6 = r0.getBoolean(r6, r7)
            int r7 = com.google.android.material.R.styleable.FloatingActionButton_android_enabled
            r9 = 1
            boolean r7 = r0.getBoolean(r7, r9)
            r10.setEnabled(r7)
            r0.recycle()
            androidx.appcompat.widget.h r0 = new androidx.appcompat.widget.h
            r0.<init>(r10)
            r10.f19077o = r0
            r0.a(r12, r13)
            gr.c r12 = new gr.c
            r12.<init>(r10)
            r10.f19078p = r12
            com.google.android.material.floatingactionbutton.d r12 = r10.getImpl()
            r12.a((gw.m) r11)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            android.content.res.ColorStateList r12 = r10.f19066d
            android.graphics.PorterDuff$Mode r13 = r10.f19067e
            android.content.res.ColorStateList r0 = r10.f19070h
            int r7 = r10.f19071i
            r11.a((android.content.res.ColorStateList) r12, (android.graphics.PorterDuff.Mode) r13, (android.content.res.ColorStateList) r0, (int) r7)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            r11.a((int) r4)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            r11.a((float) r1)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            r11.b((float) r3)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            r11.c(r2)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            int r12 = r10.f19075m
            r11.b((int) r12)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            r11.a((gl.h) r5)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            r11.b((gl.h) r8)
            com.google.android.material.floatingactionbutton.d r11 = r10.getImpl()
            r11.a((boolean) r6)
            android.widget.ImageView$ScaleType r11 = android.widget.ImageView.ScaleType.MATRIX
            r10.setScaleType(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private int a(int i2) {
        int i3 = this.f19073k;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? a(1) : a(0);
        }
        return resources.getDimensionPixelSize(i2 != 1 ? R.dimen.design_fab_size_normal : R.dimen.design_fab_size_mini);
    }

    private static int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private d.e c(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new d.e() {
            public void a() {
                aVar.b(FloatingActionButton.this);
            }

            public void b() {
                aVar.a(FloatingActionButton.this);
            }
        };
    }

    private void c(Rect rect) {
        rect.left += this.f19065b.left;
        rect.top += this.f19065b.top;
        rect.right -= this.f19065b.right;
        rect.bottom -= this.f19065b.bottom;
    }

    private void d() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f19068f;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.f(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f19069g;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(f.a(colorForState, mode));
        }
    }

    private d e() {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, new b()) : new d(this, new b());
    }

    private d getImpl() {
        if (this.f19079q == null) {
            this.f19079q = e();
        }
        return this.f19079q;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void a(a aVar) {
        a(aVar, true);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, boolean z2) {
        getImpl().b(c(aVar), z2);
    }

    public void a(k<? extends FloatingActionButton> kVar) {
        getImpl().a((d.C0129d) new c(kVar));
    }

    public boolean a() {
        return this.f19078p.a();
    }

    @Deprecated
    public boolean a(Rect rect) {
        if (!ac.G(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        c(rect);
        return true;
    }

    public void b(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public void b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        c(rect);
    }

    public void b(a aVar) {
        b(aVar, true);
    }

    /* access modifiers changed from: package-private */
    public void b(a aVar, boolean z2) {
        getImpl().a(c(aVar), z2);
    }

    public boolean b() {
        return getImpl().w();
    }

    public boolean c() {
        return getImpl().v();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    public ColorStateList getBackgroundTintList() {
        return this.f19066d;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f19067e;
    }

    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().b();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().c();
    }

    public Drawable getContentBackground() {
        return getImpl().m();
    }

    public int getCustomSize() {
        return this.f19073k;
    }

    public int getExpandedComponentIdHint() {
        return this.f19078p.c();
    }

    public gl.h getHideMotionSpec() {
        return getImpl().g();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f19070h;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f19070h;
    }

    public m getShapeAppearanceModel() {
        return (m) s.f.a(getImpl().e());
    }

    public gl.h getShowMotionSpec() {
        return getImpl().f();
    }

    public int getSize() {
        return this.f19072j;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return a(this.f19072j);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f19068f;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f19069g;
    }

    public boolean getUseCompatPadding() {
        return this.f19064a;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().j();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().q();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().r();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f19074l = (sizeDimension - this.f19075m) / 2;
        getImpl().o();
        int min = Math.min(a(sizeDimension, i2), a(sizeDimension, i3));
        setMeasuredDimension(this.f19065b.left + min + this.f19065b.right, min + this.f19065b.top + this.f19065b.bottom);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.f19078p.a((Bundle) s.f.a(extendableSavedState.f19650a.get("expandableWidgetHelper")));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f19650a.put("expandableWidgetHelper", this.f19078p.b());
        return extendableSavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !a(this.f19076n) || this.f19076n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f19066d != colorStateList) {
            this.f19066d = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f19067e != mode) {
            this.f19067e = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().a(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().b(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().c(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.f19073k) {
            this.f19073k = i2;
            requestLayout();
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().e(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        if (z2 != getImpl().i()) {
            getImpl().a(z2);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i2) {
        this.f19078p.a(i2);
    }

    public void setHideMotionSpec(gl.h hVar) {
        getImpl().b(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(gl.h.a(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().d();
            if (this.f19068f != null) {
                d();
            }
        }
    }

    public void setImageResource(int i2) {
        this.f19077o.a(i2);
        d();
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f19070h != colorStateList) {
            this.f19070h = colorStateList;
            getImpl().b(this.f19070h);
        }
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().l();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().l();
    }

    public void setShadowPaddingEnabled(boolean z2) {
        getImpl().b(z2);
    }

    public void setShapeAppearanceModel(m mVar) {
        getImpl().a(mVar);
    }

    public void setShowMotionSpec(gl.h hVar) {
        getImpl().a(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(gl.h.a(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f19073k = 0;
        if (i2 != this.f19072j) {
            this.f19072j = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f19068f != colorStateList) {
            this.f19068f = colorStateList;
            d();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f19069g != mode) {
            this.f19069g = mode;
            d();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().k();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().k();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().k();
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f19064a != z2) {
            this.f19064a = z2;
            getImpl().n();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }
}
