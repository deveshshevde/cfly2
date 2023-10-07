package com.afollestad.viewpagerdots;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import kotlin.jvm.internal.h;

public final class DotsIndicator extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7629a = new a((f) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f7630b;

    /* renamed from: c  reason: collision with root package name */
    private int f7631c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f7632d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f7633e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f7634f;

    /* renamed from: g  reason: collision with root package name */
    private int f7635g;

    /* renamed from: h  reason: collision with root package name */
    private Animator f7636h;

    /* renamed from: i  reason: collision with root package name */
    private Animator f7637i;

    /* renamed from: j  reason: collision with root package name */
    private Animator f7638j;

    /* renamed from: k  reason: collision with root package name */
    private Animator f7639k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f7640l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f7641m;

    /* renamed from: n  reason: collision with root package name */
    private int f7642n;

    /* renamed from: o  reason: collision with root package name */
    private int f7643o;

    /* renamed from: p  reason: collision with root package name */
    private int f7644p;

    /* renamed from: q  reason: collision with root package name */
    private int f7645q;

    /* renamed from: r  reason: collision with root package name */
    private final c f7646r;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final class b implements Interpolator {
        public b() {
        }

        public float getInterpolation(float f2) {
            return Math.abs(1.0f - f2);
        }
    }

    public static final class c implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DotsIndicator f7648a;

        c(DotsIndicator dotsIndicator) {
            this.f7648a = dotsIndicator;
        }

        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f2, int i3) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r0.getAdapter();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPageSelected(int r2) {
            /*
                r1 = this;
                com.afollestad.viewpagerdots.DotsIndicator r0 = r1.f7648a
                androidx.viewpager.widget.ViewPager r0 = r0.f7630b
                if (r0 == 0) goto L_0x0013
                androidx.viewpager.widget.a r0 = r0.getAdapter()
                if (r0 == 0) goto L_0x0013
                int r0 = r0.getCount()
                goto L_0x0014
            L_0x0013:
                r0 = 0
            L_0x0014:
                if (r0 > 0) goto L_0x0017
                return
            L_0x0017:
                com.afollestad.viewpagerdots.DotsIndicator r0 = r1.f7648a
                r0.a((int) r2)
                com.afollestad.viewpagerdots.DotsIndicator r0 = r1.f7648a
                r0.f7640l = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.viewpagerdots.DotsIndicator.c.onPageSelected(int):void");
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DotsIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DotsIndicator);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DotsIndicator_dot_width, -1);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DotsIndicator_dot_height, -1);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DotsIndicator_dot_margin, -1);
            int i2 = obtainStyledAttributes.getInt(R.styleable.DotsIndicator_dots_orientation, -1);
            int i3 = obtainStyledAttributes.getInt(R.styleable.DotsIndicator_dots_gravity, -1);
            this.f7641m = obtainStyledAttributes.getResourceId(R.styleable.DotsIndicator_dots_animator, R.animator.scale_with_alpha);
            int i4 = 0;
            this.f7642n = obtainStyledAttributes.getResourceId(R.styleable.DotsIndicator_dots_animator_reverse, 0);
            this.f7643o = obtainStyledAttributes.getResourceId(R.styleable.DotsIndicator_dot_drawable, R.drawable.black_dot);
            this.f7644p = obtainStyledAttributes.getResourceId(R.styleable.DotsIndicator_dot_drawable_unselected, this.f7643o);
            this.f7645q = obtainStyledAttributes.getColor(R.styleable.DotsIndicator_dot_tint, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            h.a((Object) resources, "resources");
            int applyDimension = (int) (TypedValue.applyDimension(1, (float) 5, resources.getDisplayMetrics()) + 0.5f);
            this.f7632d = dimensionPixelSize < 0 ? applyDimension : dimensionPixelSize;
            this.f7633e = dimensionPixelSize2 < 0 ? applyDimension : dimensionPixelSize2;
            this.f7631c = dimensionPixelSize3 < 0 ? applyDimension : dimensionPixelSize3;
            Animator b2 = b();
            h.a((Object) b2, "createAnimatorOut()");
            this.f7636h = b2;
            Animator b3 = b();
            h.a((Object) b3, "createAnimatorOut()");
            this.f7638j = b3;
            b3.setDuration(0);
            this.f7637i = c();
            Animator c2 = c();
            this.f7639k = c2;
            c2.setDuration(0);
            int i5 = this.f7643o;
            this.f7634f = i5 == 0 ? R.drawable.black_dot : i5;
            int i6 = this.f7644p;
            this.f7635g = i6 == 0 ? this.f7643o : i6;
            setOrientation(i2 == 1 ? 1 : i4);
            setGravity(i3 < 0 ? 17 : i3);
            this.f7646r = new c(this);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final void a() {
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            Drawable a2 = androidx.core.content.b.a(getContext(), d() == i2 ? this.f7634f : this.f7635g);
            int i3 = this.f7645q;
            if (i3 != 0) {
                a2 = a2 != null ? a.a(a2, i3) : null;
            }
            h.a((Object) childAt, "indicator");
            childAt.setBackground(a2);
            i2++;
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2) {
        if (this.f7637i.isRunning()) {
            this.f7637i.end();
            this.f7637i.cancel();
        }
        if (this.f7636h.isRunning()) {
            this.f7636h.end();
            this.f7636h.cancel();
        }
        int i3 = this.f7640l;
        View childAt = i3 >= 0 ? getChildAt(i3) : null;
        if (childAt != null) {
            childAt.setBackgroundResource(this.f7635g);
            this.f7637i.setTarget(childAt);
            this.f7637i.start();
        }
        View childAt2 = getChildAt(i2);
        if (childAt2 != null) {
            childAt2.setBackgroundResource(this.f7634f);
            this.f7636h.setTarget(childAt2);
            this.f7636h.start();
        }
    }

    private final Animator b() {
        return AnimatorInflater.loadAnimator(getContext(), this.f7641m);
    }

    private final Animator c() {
        if (this.f7642n == 0) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(getContext(), this.f7641m);
            h.a((Object) loadAnimator, "loadAnimator(context, this.animatorResId)");
            loadAnimator.setInterpolator(new b());
            return loadAnimator;
        }
        Animator loadAnimator2 = AnimatorInflater.loadAnimator(getContext(), this.f7642n);
        h.a((Object) loadAnimator2, "loadAnimator(context, this.animatorReverseResId)");
        return loadAnimator2;
    }

    private final int d() {
        ViewPager viewPager = this.f7630b;
        if (viewPager != null) {
            return viewPager.getCurrentItem();
        }
        return -1;
    }

    public final void setDotTint(int i2) {
        this.f7645q = i2;
        a();
    }

    public final void setDotTintRes(int i2) {
        setDotTint(androidx.core.content.b.c(getContext(), i2));
    }
}
