package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import gl.h;
import java.util.List;
import t.ac;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.a {

    /* renamed from: b  reason: collision with root package name */
    static final Property<View, Float> f19027b = new Property<View, Float>(Float.class, "width") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().width);
        }

        /* renamed from: a */
        public void set(View view, Float f2) {
            view.getLayoutParams().width = f2.intValue();
            view.requestLayout();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static final Property<View, Float> f19028c = new Property<View, Float>(Float.class, "height") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) view.getLayoutParams().height);
        }

        /* renamed from: a */
        public void set(View view, Float f2) {
            view.getLayoutParams().height = f2.intValue();
            view.requestLayout();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    static final Property<View, Float> f19029e = new Property<View, Float>(Float.class, "paddingStart") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) ac.l(view));
        }

        /* renamed from: a */
        public void set(View view, Float f2) {
            ac.b(view, f2.intValue(), view.getPaddingTop(), ac.m(view), view.getPaddingBottom());
        }
    };

    /* renamed from: f  reason: collision with root package name */
    static final Property<View, Float> f19030f = new Property<View, Float>(Float.class, "paddingEnd") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf((float) ac.m(view));
        }

        /* renamed from: a */
        public void set(View view, Float f2) {
            ac.b(view, ac.l(view), view.getPaddingTop(), f2.intValue(), view.getPaddingBottom());
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private static final int f19031g = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;

    /* renamed from: a  reason: collision with root package name */
    protected ColorStateList f19032a;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f19033h;

    /* renamed from: i  reason: collision with root package name */
    private final a f19034i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final f f19035j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final f f19036k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final f f19037l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final f f19038m;

    /* renamed from: n  reason: collision with root package name */
    private final int f19039n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f19040o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f19041p;

    /* renamed from: q  reason: collision with root package name */
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> f19042q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f19043r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f19044s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f19045t;

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f19052a;

        /* renamed from: b  reason: collision with root package name */
        private c f19053b;

        /* renamed from: c  reason: collision with root package name */
        private c f19054c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19055d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f19056e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f19055d = false;
            this.f19056e = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.f19055d = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.f19056e = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                return ((CoordinatorLayout.d) layoutParams).b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f19055d || this.f19056e) && ((CoordinatorLayout.d) extendedFloatingActionButton.getLayoutParams()).a() == view.getId();
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f19052a == null) {
                this.f19052a = new Rect();
            }
            Rect rect = this.f19052a;
            com.google.android.material.internal.c.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                a(extendedFloatingActionButton);
                return true;
            }
            b(extendedFloatingActionButton);
            return true;
        }

        private boolean b(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!a(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.d) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                a(extendedFloatingActionButton);
                return true;
            }
            b(extendedFloatingActionButton);
            return true;
        }

        public void a(CoordinatorLayout.d dVar) {
            if (dVar.f2760h == 0) {
                dVar.f2760h = 80;
            }
        }

        /* access modifiers changed from: protected */
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.f19056e;
            extendedFloatingActionButton.a(z2 ? extendedFloatingActionButton.f19035j : extendedFloatingActionButton.f19038m, z2 ? this.f19054c : this.f19053b);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> c2 = coordinatorLayout.c((View) extendedFloatingActionButton);
            int size = c2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = c2.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.b((View) extendedFloatingActionButton, i2);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.a(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!a(view)) {
                return false;
            } else {
                b(view, extendedFloatingActionButton);
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z2 = this.f19056e;
            extendedFloatingActionButton.a(z2 ? extendedFloatingActionButton.f19036k : extendedFloatingActionButton.f19037l, z2 ? this.f19054c : this.f19053b);
        }
    }

    class a extends b {

        /* renamed from: b  reason: collision with root package name */
        private final e f19058b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f19059c;

        a(a aVar, e eVar, boolean z2) {
            super(ExtendedFloatingActionButton.this, aVar);
            this.f19058b = eVar;
            this.f19059c = z2;
        }

        public void a(Animator animator) {
            super.a(animator);
            boolean unused = ExtendedFloatingActionButton.this.f19043r = this.f19059c;
            boolean unused2 = ExtendedFloatingActionButton.this.f19044s = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }

        public void a(c cVar) {
            if (cVar != null) {
                if (this.f19059c) {
                    cVar.c(ExtendedFloatingActionButton.this);
                } else {
                    cVar.d(ExtendedFloatingActionButton.this);
                }
            }
        }

        public void d() {
            super.d();
            boolean unused = ExtendedFloatingActionButton.this.f19044s = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.f19058b.e().width;
                layoutParams.height = this.f19058b.e().height;
            }
        }

        public AnimatorSet f() {
            h a2 = a();
            if (a2.c("width")) {
                PropertyValuesHolder[] d2 = a2.d("width");
                d2[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getWidth(), (float) this.f19058b.a()});
                a2.a("width", d2);
            }
            if (a2.c("height")) {
                PropertyValuesHolder[] d3 = a2.d("height");
                d3[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getHeight(), (float) this.f19058b.b()});
                a2.a("height", d3);
            }
            if (a2.c("paddingStart")) {
                PropertyValuesHolder[] d4 = a2.d("paddingStart");
                d4[0].setFloatValues(new float[]{(float) ac.l(ExtendedFloatingActionButton.this), (float) this.f19058b.c()});
                a2.a("paddingStart", d4);
            }
            if (a2.c("paddingEnd")) {
                PropertyValuesHolder[] d5 = a2.d("paddingEnd");
                d5[0].setFloatValues(new float[]{(float) ac.m(ExtendedFloatingActionButton.this), (float) this.f19058b.d()});
                a2.a("paddingEnd", d5);
            }
            if (a2.c("labelOpacity")) {
                PropertyValuesHolder[] d6 = a2.d("labelOpacity");
                boolean z2 = this.f19059c;
                float f2 = 0.0f;
                float f3 = z2 ? 0.0f : 1.0f;
                if (z2) {
                    f2 = 1.0f;
                }
                d6[0].setFloatValues(new float[]{f3, f2});
                a2.a("labelOpacity", d6);
            }
            return super.b(a2);
        }

        public void g() {
            boolean unused = ExtendedFloatingActionButton.this.f19043r = this.f19059c;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.f19058b.e().width;
                layoutParams.height = this.f19058b.e().height;
                ac.b(ExtendedFloatingActionButton.this, this.f19058b.c(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f19058b.d(), ExtendedFloatingActionButton.this.getPaddingBottom());
                ExtendedFloatingActionButton.this.requestLayout();
            }
        }

        public int h() {
            return this.f19059c ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        public boolean i() {
            return this.f19059c == ExtendedFloatingActionButton.this.f19043r || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }
    }

    class b extends b {

        /* renamed from: b  reason: collision with root package name */
        private boolean f19061b;

        public b(a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        public void a(Animator animator) {
            super.a(animator);
            this.f19061b = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.f19033h = 1;
        }

        public void a(c cVar) {
            if (cVar != null) {
                cVar.b(ExtendedFloatingActionButton.this);
            }
        }

        public void d() {
            super.d();
            int unused = ExtendedFloatingActionButton.this.f19033h = 0;
            if (!this.f19061b) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        public void e() {
            super.e();
            this.f19061b = true;
        }

        public void g() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        public int h() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        public boolean i() {
            return ExtendedFloatingActionButton.this.d();
        }
    }

    public static abstract class c {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    class d extends b {
        public d(a aVar) {
            super(ExtendedFloatingActionButton.this, aVar);
        }

        public void a(Animator animator) {
            super.a(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.f19033h = 2;
        }

        public void a(c cVar) {
            if (cVar != null) {
                cVar.a(ExtendedFloatingActionButton.this);
            }
        }

        public void d() {
            super.d();
            int unused = ExtendedFloatingActionButton.this.f19033h = 0;
        }

        public void g() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        public int h() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        public boolean i() {
            return ExtendedFloatingActionButton.this.c();
        }
    }

    interface e {
        int a();

        int b();

        int c();

        int d();

        ViewGroup.LayoutParams e();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExtendedFloatingActionButton(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = f19031g
            r1 = r17
            android.content.Context r1 = gx.a.a(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.f19033h = r10
            com.google.android.material.floatingactionbutton.a r1 = new com.google.android.material.floatingactionbutton.a
            r1.<init>()
            r0.f19034i = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$d r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$d
            r11.<init>(r1)
            r0.f19037l = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$b
            r12.<init>(r1)
            r0.f19038m = r12
            r13 = 1
            r0.f19043r = r13
            r0.f19044s = r10
            r0.f19045t = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.f19042q = r1
            int[] r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.l.a(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_showMotionSpec
            gl.h r2 = gl.h.a((android.content.Context) r14, (android.content.res.TypedArray) r1, (int) r2)
            int r3 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_hideMotionSpec
            gl.h r3 = gl.h.a((android.content.Context) r14, (android.content.res.TypedArray) r1, (int) r3)
            int r4 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_extendMotionSpec
            gl.h r4 = gl.h.a((android.content.Context) r14, (android.content.res.TypedArray) r1, (int) r4)
            int r5 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec
            gl.h r5 = gl.h.a((android.content.Context) r14, (android.content.res.TypedArray) r1, (int) r5)
            int r6 = com.google.android.material.R.styleable.ExtendedFloatingActionButton_collapsedSize
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.f19039n = r6
            int r6 = t.ac.l(r16)
            r0.f19040o = r6
            int r6 = t.ac.m(r16)
            r0.f19041p = r6
            com.google.android.material.floatingactionbutton.a r6 = new com.google.android.material.floatingactionbutton.a
            r6.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r15 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1 r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1
            r10.<init>()
            r15.<init>(r6, r10, r13)
            r0.f19036k = r15
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$a
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2 r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2
            r13.<init>()
            r7 = 0
            r10.<init>(r6, r13, r7)
            r0.f19035j = r10
            r11.a((gl.h) r2)
            r12.a((gl.h) r3)
            r15.a((gl.h) r4)
            r10.a((gl.h) r5)
            r1.recycle()
            gw.c r1 = gw.m.f13193a
            r2 = r18
            gw.m$a r1 = gw.m.a((android.content.Context) r14, (android.util.AttributeSet) r2, (int) r8, (int) r9, (gw.c) r1)
            gw.m r1 = r1.a()
            r0.setShapeAppearanceModel(r1)
            r16.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public void a(final f fVar, final c cVar) {
        if (!fVar.i()) {
            if (!e()) {
                fVar.g();
                fVar.a(cVar);
                return;
            }
            measure(0, 0);
            AnimatorSet f2 = fVar.f();
            f2.addListener(new AnimatorListenerAdapter() {

                /* renamed from: d  reason: collision with root package name */
                private boolean f19051d;

                public void onAnimationCancel(Animator animator) {
                    this.f19051d = true;
                    fVar.e();
                }

                public void onAnimationEnd(Animator animator) {
                    fVar.d();
                    if (!this.f19051d) {
                        fVar.a(cVar);
                    }
                }

                public void onAnimationStart(Animator animator) {
                    fVar.a(animator);
                    this.f19051d = false;
                }
            });
            for (Animator.AnimatorListener addListener : fVar.b()) {
                f2.addListener(addListener);
            }
            f2.start();
        }
    }

    private void b() {
        this.f19032a = getTextColors();
    }

    /* access modifiers changed from: private */
    public boolean c() {
        return getVisibility() != 0 ? this.f19033h == 2 : this.f19033h != 1;
    }

    /* access modifiers changed from: private */
    public boolean d() {
        return getVisibility() == 0 ? this.f19033h == 1 : this.f19033h != 2;
    }

    private boolean e() {
        return (ac.G(this) || (!c() && this.f19045t)) && !isInEditMode();
    }

    /* access modifiers changed from: protected */
    public void a(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.f19042q;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedSize() {
        int i2 = this.f19039n;
        return i2 < 0 ? (Math.min(ac.l(this), ac.m(this)) * 2) + getIconSize() : i2;
    }

    public h getExtendMotionSpec() {
        return this.f19036k.c();
    }

    public h getHideMotionSpec() {
        return this.f19038m.c();
    }

    public h getShowMotionSpec() {
        return this.f19037l.c();
    }

    public h getShrinkMotionSpec() {
        return this.f19035j.c();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f19043r && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.f19043r = false;
            this.f19035j.g();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.f19045t = z2;
    }

    public void setExtendMotionSpec(h hVar) {
        this.f19036k.a(hVar);
    }

    public void setExtendMotionSpecResource(int i2) {
        setExtendMotionSpec(h.a(getContext(), i2));
    }

    public void setExtended(boolean z2) {
        if (this.f19043r != z2) {
            f fVar = z2 ? this.f19036k : this.f19035j;
            if (!fVar.i()) {
                fVar.g();
            }
        }
    }

    public void setHideMotionSpec(h hVar) {
        this.f19038m.a(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(h.a(getContext(), i2));
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (this.f19043r && !this.f19044s) {
            this.f19040o = ac.l(this);
            this.f19041p = ac.m(this);
        }
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (this.f19043r && !this.f19044s) {
            this.f19040o = i2;
            this.f19041p = i4;
        }
    }

    public void setShowMotionSpec(h hVar) {
        this.f19037l.a(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(h.a(getContext(), i2));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.f19035j.a(hVar);
    }

    public void setShrinkMotionSpecResource(int i2) {
        setShrinkMotionSpec(h.a(getContext(), i2));
    }

    public void setTextColor(int i2) {
        super.setTextColor(i2);
        b();
    }

    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        b();
    }
}
