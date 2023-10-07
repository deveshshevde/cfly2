package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.c;
import t.ac;
import t.ak;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: f  reason: collision with root package name */
    private static final int f18429f = R.style.Widget_Design_CollapsingToolbar;
    private int A;
    private boolean B;
    private int C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    final com.google.android.material.internal.a f18430a;

    /* renamed from: b  reason: collision with root package name */
    final gq.a f18431b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f18432c;

    /* renamed from: d  reason: collision with root package name */
    int f18433d;

    /* renamed from: e  reason: collision with root package name */
    ak f18434e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18435g;

    /* renamed from: h  reason: collision with root package name */
    private int f18436h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f18437i;

    /* renamed from: j  reason: collision with root package name */
    private View f18438j;

    /* renamed from: k  reason: collision with root package name */
    private View f18439k;

    /* renamed from: l  reason: collision with root package name */
    private int f18440l;

    /* renamed from: m  reason: collision with root package name */
    private int f18441m;

    /* renamed from: n  reason: collision with root package name */
    private int f18442n;

    /* renamed from: o  reason: collision with root package name */
    private int f18443o;

    /* renamed from: p  reason: collision with root package name */
    private final Rect f18444p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f18445q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f18446r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f18447s;

    /* renamed from: t  reason: collision with root package name */
    private int f18448t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f18449u;

    /* renamed from: v  reason: collision with root package name */
    private ValueAnimator f18450v;

    /* renamed from: w  reason: collision with root package name */
    private long f18451w;

    /* renamed from: x  reason: collision with root package name */
    private int f18452x;

    /* renamed from: y  reason: collision with root package name */
    private AppBarLayout.b f18453y;

    /* renamed from: z  reason: collision with root package name */
    private int f18454z;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f18457a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f18458b = 0.5f;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f18457a = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void a(float f2) {
            this.f18458b = f2;
        }
    }

    private class a implements AppBarLayout.b {
        a() {
        }

        public void a(AppBarLayout appBarLayout, int i2) {
            int i3;
            CollapsingToolbarLayout.this.f18433d = i2;
            int b2 = CollapsingToolbarLayout.this.f18434e != null ? CollapsingToolbarLayout.this.f18434e.b() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                a a2 = CollapsingToolbarLayout.a(childAt);
                int i5 = layoutParams.f18457a;
                if (i5 == 1) {
                    i3 = o.a.a(-i2, 0, CollapsingToolbarLayout.this.b(childAt));
                } else if (i5 != 2) {
                } else {
                    i3 = Math.round(((float) (-i2)) * layoutParams.f18458b);
                }
                a2.a(i3);
            }
            CollapsingToolbarLayout.this.b();
            if (CollapsingToolbarLayout.this.f18432c != null && b2 > 0) {
                ac.e(CollapsingToolbarLayout.this);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int q2 = (height - ac.q(CollapsingToolbarLayout.this)) - b2;
            float f2 = (float) q2;
            CollapsingToolbarLayout.this.f18430a.b(Math.min(1.0f, ((float) (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger())) / f2));
            CollapsingToolbarLayout.this.f18430a.a(CollapsingToolbarLayout.this.f18433d + q2);
            CollapsingToolbarLayout.this.f18430a.c(((float) Math.abs(i2)) / f2);
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = f18429f
            android.content.Context r10 = gx.a.a(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = 1
            r9.f18435g = r10
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r9.f18444p = r0
            r6 = -1
            r9.f18452x = r6
            r7 = 0
            r9.A = r7
            r9.C = r7
            android.content.Context r0 = r9.getContext()
            com.google.android.material.internal.a r8 = new com.google.android.material.internal.a
            r8.<init>(r9)
            r9.f18430a = r8
            android.animation.TimeInterpolator r1 = gl.a.f28539e
            r8.a((android.animation.TimeInterpolator) r1)
            r8.b((boolean) r7)
            gq.a r1 = new gq.a
            r1.<init>(r0)
            r9.f18431b = r1
            int[] r2 = com.google.android.material.R.styleable.CollapsingToolbarLayout
            int[] r5 = new int[r7]
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleGravity
            r0 = 8388691(0x800053, float:1.175506E-38)
            int r12 = r11.getInt(r12, r0)
            r8.b((int) r12)
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleGravity
            r0 = 8388627(0x800013, float:1.175497E-38)
            int r12 = r11.getInt(r12, r0)
            r8.c((int) r12)
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMargin
            int r12 = r11.getDimensionPixelSize(r12, r7)
            r9.f18443o = r12
            r9.f18442n = r12
            r9.f18441m = r12
            r9.f18440l = r12
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x0075
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart
            int r12 = r11.getDimensionPixelSize(r12, r7)
            r9.f18440l = r12
        L_0x0075:
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x0085
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd
            int r12 = r11.getDimensionPixelSize(r12, r7)
            r9.f18442n = r12
        L_0x0085:
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x0095
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop
            int r12 = r11.getDimensionPixelSize(r12, r7)
            r9.f18441m = r12
        L_0x0095:
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x00a5
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom
            int r12 = r11.getDimensionPixelSize(r12, r7)
            r9.f18443o = r12
        L_0x00a5:
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleEnabled
            boolean r12 = r11.getBoolean(r12, r10)
            r9.f18445q = r12
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_title
            java.lang.CharSequence r12 = r11.getText(r12)
            r9.setTitle(r12)
            int r12 = com.google.android.material.R.style.TextAppearance_Design_CollapsingToolbar_Expanded
            r8.e((int) r12)
            int r12 = androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title
            r8.d((int) r12)
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x00d1
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance
            int r12 = r11.getResourceId(r12, r7)
            r8.e((int) r12)
        L_0x00d1:
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x00e2
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance
            int r12 = r11.getResourceId(r12, r7)
            r8.d((int) r12)
        L_0x00e2:
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger
            int r12 = r11.getDimensionPixelSize(r12, r6)
            r9.f18452x = r12
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_maxLines
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x00fb
            int r12 = com.google.android.material.R.styleable.CollapsingToolbarLayout_maxLines
            int r10 = r11.getInt(r12, r10)
            r8.f((int) r10)
        L_0x00fb:
            int r10 = com.google.android.material.R.styleable.CollapsingToolbarLayout_scrimAnimationDuration
            r12 = 600(0x258, float:8.41E-43)
            int r10 = r11.getInt(r10, r12)
            long r0 = (long) r10
            r9.f18451w = r0
            int r10 = com.google.android.material.R.styleable.CollapsingToolbarLayout_contentScrim
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setContentScrim(r10)
            int r10 = com.google.android.material.R.styleable.CollapsingToolbarLayout_statusBarScrim
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setStatusBarScrim(r10)
            int r10 = com.google.android.material.R.styleable.CollapsingToolbarLayout_titleCollapseMode
            int r10 = r11.getInt(r10, r7)
            r9.setTitleCollapseMode(r10)
            int r10 = com.google.android.material.R.styleable.CollapsingToolbarLayout_toolbarId
            int r10 = r11.getResourceId(r10, r6)
            r9.f18436h = r10
            int r10 = com.google.android.material.R.styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop
            boolean r10 = r11.getBoolean(r10, r7)
            r9.B = r10
            int r10 = com.google.android.material.R.styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled
            boolean r10 = r11.getBoolean(r10, r7)
            r9.D = r10
            r11.recycle()
            r9.setWillNotDraw(r7)
            com.google.android.material.appbar.CollapsingToolbarLayout$1 r10 = new com.google.android.material.appbar.CollapsingToolbarLayout$1
            r10.<init>()
            t.ac.a((android.view.View) r9, (t.u) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    static a a(View view) {
        a aVar = (a) view.getTag(R.id.view_offset_helper);
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(view);
        view.setTag(R.id.view_offset_helper, aVar2);
        return aVar2;
    }

    private void a(int i2) {
        d();
        ValueAnimator valueAnimator = this.f18450v;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f18450v = valueAnimator2;
            valueAnimator2.setDuration(this.f18451w);
            this.f18450v.setInterpolator(i2 > this.f18448t ? gl.a.f28537c : gl.a.f28538d);
            this.f18450v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.f18450v.cancel();
        }
        this.f18450v.setIntValues(new int[]{this.f18448t, i2});
        this.f18450v.start();
    }

    private void a(int i2, int i3, int i4, int i5, boolean z2) {
        View view;
        if (this.f18445q && (view = this.f18439k) != null) {
            boolean z3 = false;
            boolean z4 = ac.J(view) && this.f18439k.getVisibility() == 0;
            this.f18446r = z4;
            if (z4 || z2) {
                if (ac.i(this) == 1) {
                    z3 = true;
                }
                a(z3);
                this.f18430a.a(z3 ? this.f18442n : this.f18440l, this.f18444p.top + this.f18441m, (i4 - i2) - (z3 ? this.f18440l : this.f18442n), (i5 - i3) - this.f18443o);
                this.f18430a.c(z2);
            }
        }
    }

    private void a(Drawable drawable, int i2, int i3) {
        a(drawable, this.f18437i, i2, i3);
    }

    private void a(Drawable drawable, View view, int i2, int i3) {
        if (c() && view != null && this.f18445q) {
            i3 = view.getBottom();
        }
        drawable.setBounds(0, 0, i2, i3);
    }

    private void a(AppBarLayout appBarLayout) {
        if (c()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void a(boolean z2) {
        int i2;
        int i3;
        int i4;
        View view = this.f18438j;
        if (view == null) {
            view = this.f18437i;
        }
        int b2 = b(view);
        c.b(this, this.f18439k, this.f18444p);
        ViewGroup viewGroup = this.f18437i;
        int i5 = 0;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i5 = toolbar.getTitleMarginStart();
            i3 = toolbar.getTitleMarginEnd();
            i2 = toolbar.getTitleMarginTop();
            i4 = toolbar.getTitleMarginBottom();
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                ViewGroup viewGroup2 = this.f18437i;
                if (viewGroup2 instanceof android.widget.Toolbar) {
                    android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup2;
                    i5 = toolbar2.getTitleMarginStart();
                    i3 = toolbar2.getTitleMarginEnd();
                    i2 = toolbar2.getTitleMarginTop();
                    i4 = toolbar2.getTitleMarginBottom();
                }
            }
            i4 = 0;
            i3 = 0;
            i2 = 0;
        }
        com.google.android.material.internal.a aVar = this.f18430a;
        int i6 = this.f18444p.left + (z2 ? i3 : i5);
        int i7 = this.f18444p.top + b2 + i2;
        int i8 = this.f18444p.right;
        if (!z2) {
            i5 = i3;
        }
        aVar.b(i6, i7, i8 - i5, (this.f18444p.bottom + b2) - i4);
    }

    private boolean c() {
        return this.f18454z == 1;
    }

    private static boolean c(View view) {
        return (view instanceof Toolbar) || (Build.VERSION.SDK_INT >= 21 && (view instanceof android.widget.Toolbar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
            r6 = this;
            boolean r0 = r6.f18435g
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f18437i = r0
            r6.f18438j = r0
            int r1 = r6.f18436h
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.f18437i = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.e(r1)
            r6.f18438j = r1
        L_0x001f:
            android.view.ViewGroup r1 = r6.f18437i
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = c(r4)
            if (r5 == 0) goto L_0x0039
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003c:
            r6.f18437i = r0
        L_0x003e:
            r6.e()
            r6.f18435g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.d():void");
    }

    private boolean d(View view) {
        View view2 = this.f18438j;
        if (view2 == null || view2 == this) {
            if (view == this.f18437i) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private View e(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private void e() {
        View view;
        if (!this.f18445q && (view = this.f18439k) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f18439k);
            }
        }
        if (this.f18445q && this.f18437i != null) {
            if (this.f18439k == null) {
                this.f18439k = new View(getContext());
            }
            if (this.f18439k.getParent() == null) {
                this.f18437i.addView(this.f18439k, -1, -1);
            }
        }
    }

    private static CharSequence f(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (Build.VERSION.SDK_INT < 21 || !(view instanceof android.widget.Toolbar)) {
            return null;
        }
        return ((android.widget.Toolbar) view).getTitle();
    }

    private void f() {
        if (this.f18437i != null && this.f18445q && TextUtils.isEmpty(this.f18430a.o())) {
            setTitle(f(this.f18437i));
        }
    }

    private static int g(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private void g() {
        setContentDescription(getTitle());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: package-private */
    public ak a(ak akVar) {
        ak akVar2 = ac.x(this) ? akVar : null;
        if (!s.c.a((Object) this.f18434e, (Object) akVar2)) {
            this.f18434e = akVar2;
            requestLayout();
        }
        return akVar.g();
    }

    public void a(boolean z2, boolean z3) {
        if (this.f18449u != z2) {
            int i2 = 255;
            if (z3) {
                if (!z2) {
                    i2 = 0;
                }
                a(i2);
            } else {
                if (!z2) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.f18449u = z2;
        }
    }

    /* access modifiers changed from: package-private */
    public final int b(View view) {
        return ((getHeight() - a(view).d()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (this.f18447s != null || this.f18432c != null) {
            setScrimsShown(getHeight() + this.f18433d < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.f18437i == null && (drawable = this.f18447s) != null && this.f18448t > 0) {
            drawable.mutate().setAlpha(this.f18448t);
            this.f18447s.draw(canvas);
        }
        if (this.f18445q && this.f18446r) {
            if (this.f18437i == null || this.f18447s == null || this.f18448t <= 0 || !c() || this.f18430a.l() >= this.f18430a.k()) {
                this.f18430a.a(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.f18447s.getBounds(), Region.Op.DIFFERENCE);
                this.f18430a.a(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.f18432c != null && this.f18448t > 0) {
            ak akVar = this.f18434e;
            int b2 = akVar != null ? akVar.b() : 0;
            if (b2 > 0) {
                this.f18432c.setBounds(0, -this.f18433d, getWidth(), b2 - this.f18433d);
                this.f18432c.mutate().setAlpha(this.f18448t);
                this.f18432c.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z2;
        if (this.f18447s == null || this.f18448t <= 0 || !d(view)) {
            z2 = false;
        } else {
            a(this.f18447s, view, getWidth(), getHeight());
            this.f18447s.mutate().setAlpha(this.f18448t);
            this.f18447s.draw(canvas);
            z2 = true;
        }
        return super.drawChild(canvas, view, j2) || z2;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f18432c;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f18447s;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.f18430a;
        if (aVar != null) {
            z2 |= aVar.a(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.f18430a.g();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f18430a.h();
    }

    public Drawable getContentScrim() {
        return this.f18447s;
    }

    public int getExpandedTitleGravity() {
        return this.f18430a.f();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f18443o;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f18442n;
    }

    public int getExpandedTitleMarginStart() {
        return this.f18440l;
    }

    public int getExpandedTitleMarginTop() {
        return this.f18441m;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f18430a.i();
    }

    public int getHyphenationFrequency() {
        return this.f18430a.t();
    }

    public int getLineCount() {
        return this.f18430a.q();
    }

    public float getLineSpacingAdd() {
        return this.f18430a.r();
    }

    public float getLineSpacingMultiplier() {
        return this.f18430a.s();
    }

    public int getMaxLines() {
        return this.f18430a.p();
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.f18448t;
    }

    public long getScrimAnimationDuration() {
        return this.f18451w;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.f18452x;
        if (i2 >= 0) {
            return i2 + this.A + this.C;
        }
        ak akVar = this.f18434e;
        int b2 = akVar != null ? akVar.b() : 0;
        int q2 = ac.q(this);
        return q2 > 0 ? Math.min((q2 * 2) + b2, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f18432c;
    }

    public CharSequence getTitle() {
        if (this.f18445q) {
            return this.f18430a.o();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f18454z;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            a(appBarLayout);
            ac.b((View) this, ac.x(appBarLayout));
            if (this.f18453y == null) {
                this.f18453y = new a();
            }
            appBarLayout.a(this.f18453y);
            ac.w(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.b bVar = this.f18453y;
        if (bVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(bVar);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        ak akVar = this.f18434e;
        if (akVar != null) {
            int b2 = akVar.b();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ac.x(childAt) && childAt.getTop() < b2) {
                    ac.e(childAt, b2);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            a(getChildAt(i7)).a();
        }
        a(i2, i3, i4, i5, false);
        f();
        b();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            a(getChildAt(i8)).b();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        d();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        ak akVar = this.f18434e;
        int b2 = akVar != null ? akVar.b() : 0;
        if ((mode == 0 || this.B) && b2 > 0) {
            this.A = b2;
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + b2, MemoryConstants.GB));
        }
        if (this.D && this.f18430a.p() > 1) {
            f();
            a(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int q2 = this.f18430a.q();
            if (q2 > 1) {
                this.C = Math.round(this.f18430a.c()) * (q2 - 1);
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.C, MemoryConstants.GB));
            }
        }
        ViewGroup viewGroup = this.f18437i;
        if (viewGroup != null) {
            View view = this.f18438j;
            setMinimumHeight((view == null || view == this) ? g(viewGroup) : g(view));
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.f18447s;
        if (drawable != null) {
            a(drawable, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f18430a.c(i2);
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.f18430a.d(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f18430a.a(colorStateList);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f18430a.a(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f18447s;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f18447s = drawable3;
            if (drawable3 != null) {
                a(drawable3, getWidth(), getHeight());
                this.f18447s.setCallback(this);
                this.f18447s.setAlpha(this.f18448t);
            }
            ac.e(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(b.a(getContext(), i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.f18430a.b(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f18443o = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f18442n = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f18440l = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f18441m = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.f18430a.e(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f18430a.b(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f18430a.b(typeface);
    }

    public void setExtraMultilineHeightEnabled(boolean z2) {
        this.D = z2;
    }

    public void setForceApplySystemWindowInsetTop(boolean z2) {
        this.B = z2;
    }

    public void setHyphenationFrequency(int i2) {
        this.f18430a.g(i2);
    }

    public void setLineSpacingAdd(float f2) {
        this.f18430a.d(f2);
    }

    public void setLineSpacingMultiplier(float f2) {
        this.f18430a.e(f2);
    }

    public void setMaxLines(int i2) {
        this.f18430a.f(i2);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z2) {
        this.f18430a.b(z2);
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.f18448t) {
            if (!(this.f18447s == null || (viewGroup = this.f18437i) == null)) {
                ac.e(viewGroup);
            }
            this.f18448t = i2;
            ac.e(this);
        }
    }

    public void setScrimAnimationDuration(long j2) {
        this.f18451w = j2;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.f18452x != i2) {
            this.f18452x = i2;
            b();
        }
    }

    public void setScrimsShown(boolean z2) {
        a(z2, ac.G(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f18432c;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f18432c = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f18432c.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.f18432c, ac.i(this));
                this.f18432c.setVisible(getVisibility() == 0, false);
                this.f18432c.setCallback(this);
                this.f18432c.setAlpha(this.f18448t);
            }
            ac.e(this);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(b.a(getContext(), i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.f18430a.a(charSequence);
        g();
    }

    public void setTitleCollapseMode(int i2) {
        this.f18454z = i2;
        boolean c2 = c();
        this.f18430a.a(c2);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            a((AppBarLayout) parent);
        }
        if (c2 && this.f18447s == null) {
            setContentScrimColor(this.f18431b.a(getResources().getDimension(R.dimen.design_appbar_elevation)));
        }
    }

    public void setTitleEnabled(boolean z2) {
        if (z2 != this.f18445q) {
            this.f18445q = z2;
            g();
            e();
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f18432c;
        if (!(drawable == null || drawable.isVisible() == z2)) {
            this.f18432c.setVisible(z2, false);
        }
        Drawable drawable2 = this.f18447s;
        if (drawable2 != null && drawable2.isVisible() != z2) {
            this.f18447s.setVisible(z2, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f18447s || drawable == this.f18432c;
    }
}
