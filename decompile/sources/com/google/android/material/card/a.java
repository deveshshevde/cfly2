package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R;
import gt.c;
import gu.b;
import gw.d;
import gw.e;
import gw.h;
import gw.l;
import gw.m;
import t.ac;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f18742a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final double f18743b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: c  reason: collision with root package name */
    private final MaterialCardView f18744c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f18745d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final h f18746e;

    /* renamed from: f  reason: collision with root package name */
    private final h f18747f;

    /* renamed from: g  reason: collision with root package name */
    private int f18748g;

    /* renamed from: h  reason: collision with root package name */
    private int f18749h;

    /* renamed from: i  reason: collision with root package name */
    private int f18750i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f18751j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f18752k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f18753l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f18754m;

    /* renamed from: n  reason: collision with root package name */
    private m f18755n;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f18756o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f18757p;

    /* renamed from: q  reason: collision with root package name */
    private LayerDrawable f18758q;

    /* renamed from: r  reason: collision with root package name */
    private h f18759r;

    /* renamed from: s  reason: collision with root package name */
    private h f18760s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f18761t = false;

    /* renamed from: u  reason: collision with root package name */
    private boolean f18762u;

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i2, int i3) {
        this.f18744c = materialCardView;
        h hVar = new h(materialCardView.getContext(), attributeSet, i2, i3);
        this.f18746e = hVar;
        hVar.a(materialCardView.getContext());
        hVar.G(-12303292);
        m.a n2 = hVar.M().n();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardCornerRadius)) {
            n2.a(obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f18747f = new h();
        a(n2.a());
        obtainStyledAttributes.recycle();
    }

    private float A() {
        if (!this.f18744c.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT >= 21 && !this.f18744c.getUseCompatPadding()) {
            return 0.0f;
        }
        double d2 = 1.0d - f18743b;
        double cardViewRadius = (double) this.f18744c.getCardViewRadius();
        Double.isNaN(cardViewRadius);
        return (float) (d2 * cardViewRadius);
    }

    private boolean B() {
        return this.f18744c.getPreventCornerOverlap() && !z();
    }

    private boolean C() {
        return this.f18744c.getPreventCornerOverlap() && z() && this.f18744c.getUseCompatPadding();
    }

    private float D() {
        return Math.max(Math.max(a(this.f18755n.b(), this.f18746e.ac()), a(this.f18755n.c(), this.f18746e.ad())), Math.max(a(this.f18755n.d(), this.f18746e.af()), a(this.f18755n.e(), this.f18746e.ae())));
    }

    private Drawable E() {
        if (this.f18757p == null) {
            this.f18757p = F();
        }
        if (this.f18758q == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f18757p, this.f18747f, I()});
            this.f18758q = layerDrawable;
            layerDrawable.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.f18758q;
    }

    private Drawable F() {
        if (!b.f28598a) {
            return G();
        }
        this.f18760s = J();
        return new RippleDrawable(this.f18753l, (Drawable) null, this.f18760s);
    }

    private Drawable G() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        h J = J();
        this.f18759r = J;
        J.g(this.f18753l);
        stateListDrawable.addState(new int[]{16842919}, this.f18759r);
        return stateListDrawable;
    }

    private void H() {
        Drawable drawable;
        if (!b.f28598a || (drawable = this.f18757p) == null) {
            h hVar = this.f18759r;
            if (hVar != null) {
                hVar.g(this.f18753l);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.f18753l);
    }

    private Drawable I() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f18752k;
        if (drawable != null) {
            stateListDrawable.addState(f18742a, drawable);
        }
        return stateListDrawable;
    }

    private h J() {
        return new h(this.f18755n);
    }

    private float a(d dVar, float f2) {
        if (dVar instanceof l) {
            double d2 = (double) f2;
            Double.isNaN(d2);
            return (float) ((1.0d - f18743b) * d2);
        } else if (dVar instanceof e) {
            return f2 / 2.0f;
        } else {
            return 0.0f;
        }
    }

    private void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.f18744c.getForeground() instanceof InsetDrawable)) {
            this.f18744c.setForeground(c(drawable));
        } else {
            ((InsetDrawable) this.f18744c.getForeground()).setDrawable(drawable);
        }
    }

    private Drawable c(Drawable drawable) {
        int i2;
        int i3;
        if ((Build.VERSION.SDK_INT < 21) || this.f18744c.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((double) x());
            i3 = (int) Math.ceil((double) y());
            i2 = ceil;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new InsetDrawable(drawable, i3, i2, i3, i2) {
            public int getMinimumHeight() {
                return -1;
            }

            public int getMinimumWidth() {
                return -1;
            }

            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private float x() {
        return (this.f18744c.getMaxCardElevation() * 1.5f) + (C() ? D() : 0.0f);
    }

    private float y() {
        return this.f18744c.getMaxCardElevation() + (C() ? D() : 0.0f);
    }

    private boolean z() {
        return Build.VERSION.SDK_INT >= 21 && this.f18746e.ag();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        a(this.f18755n.a(f2));
        this.f18751j.invalidateSelf();
        if (C() || B()) {
            o();
        }
        if (C()) {
            m();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (i2 != this.f18750i) {
            this.f18750i = i2;
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        int i4;
        int i5;
        if (this.f18758q != null) {
            int i6 = this.f18748g;
            int i7 = this.f18749h;
            int i8 = (i2 - i6) - i7;
            int i9 = (i3 - i6) - i7;
            if ((Build.VERSION.SDK_INT < 21) || this.f18744c.getUseCompatPadding()) {
                i9 -= (int) Math.ceil((double) (x() * 2.0f));
                i8 -= (int) Math.ceil((double) (y() * 2.0f));
            }
            int i10 = i9;
            int i11 = this.f18748g;
            if (ac.i(this.f18744c) == 1) {
                i4 = i8;
                i5 = i11;
            } else {
                i5 = i8;
                i4 = i11;
            }
            this.f18758q.setLayerInset(2, i5, this.f18748g, i4, i10);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) {
        this.f18745d.set(i2, i3, i4, i5);
        o();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f18756o != colorStateList) {
            this.f18756o = colorStateList;
            n();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TypedArray typedArray) {
        ColorStateList a2 = c.a(this.f18744c.getContext(), typedArray, R.styleable.MaterialCardView_strokeColor);
        this.f18756o = a2;
        if (a2 == null) {
            this.f18756o = ColorStateList.valueOf(-1);
        }
        this.f18750i = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z2 = typedArray.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        this.f18762u = z2;
        this.f18744c.setLongClickable(z2);
        this.f18754m = c.a(this.f18744c.getContext(), typedArray, R.styleable.MaterialCardView_checkedIconTint);
        a(c.b(this.f18744c.getContext(), typedArray, R.styleable.MaterialCardView_checkedIcon));
        b(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconSize, 0));
        c(typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList a3 = c.a(this.f18744c.getContext(), typedArray, R.styleable.MaterialCardView_rippleColor);
        this.f18753l = a3;
        if (a3 == null) {
            this.f18753l = ColorStateList.valueOf(gn.a.a((View) this.f18744c, R.attr.colorControlHighlight));
        }
        c(c.a(this.f18744c.getContext(), typedArray, R.styleable.MaterialCardView_cardForegroundColor));
        H();
        l();
        n();
        this.f18744c.setBackgroundInternal(c((Drawable) this.f18746e));
        Drawable E = this.f18744c.isClickable() ? E() : this.f18747f;
        this.f18751j = E;
        this.f18744c.setForeground(c(E));
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.f18752k = drawable;
        if (drawable != null) {
            Drawable g2 = androidx.core.graphics.drawable.a.g(drawable.mutate());
            this.f18752k = g2;
            androidx.core.graphics.drawable.a.a(g2, this.f18754m);
        }
        if (this.f18758q != null) {
            this.f18758q.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, I());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(m mVar) {
        this.f18755n = mVar;
        this.f18746e.setShapeAppearanceModel(mVar);
        h hVar = this.f18746e;
        hVar.g(!hVar.ag());
        h hVar2 = this.f18747f;
        if (hVar2 != null) {
            hVar2.setShapeAppearanceModel(mVar);
        }
        h hVar3 = this.f18760s;
        if (hVar3 != null) {
            hVar3.setShapeAppearanceModel(mVar);
        }
        h hVar4 = this.f18759r;
        if (hVar4 != null) {
            hVar4.setShapeAppearanceModel(mVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f18761t = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f18761t;
    }

    /* access modifiers changed from: package-private */
    public int b() {
        ColorStateList colorStateList = this.f18756o;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        this.f18746e.p(f2);
        h hVar = this.f18747f;
        if (hVar != null) {
            hVar.p(f2);
        }
        h hVar2 = this.f18760s;
        if (hVar2 != null) {
            hVar2.p(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.f18749h = i2;
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        this.f18746e.g(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.f18762u = z2;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f18756o;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.f18748g = i2;
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        h hVar = this.f18747f;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        hVar.g(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.f18750i;
    }

    /* access modifiers changed from: package-private */
    public void d(ColorStateList colorStateList) {
        this.f18753l = colorStateList;
        H();
    }

    /* access modifiers changed from: package-private */
    public h e() {
        return this.f18746e;
    }

    /* access modifiers changed from: package-private */
    public void e(ColorStateList colorStateList) {
        this.f18754m = colorStateList;
        Drawable drawable = this.f18752k;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f18746e.N();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList g() {
        return this.f18747f.N();
    }

    /* access modifiers changed from: package-private */
    public Rect h() {
        return this.f18745d;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f18751j;
        Drawable E = this.f18744c.isClickable() ? E() : this.f18747f;
        this.f18751j = E;
        if (drawable != E) {
            b(E);
        }
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f18746e.ac();
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f18746e.T();
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f18746e.r(this.f18744c.getCardElevation());
    }

    /* access modifiers changed from: package-private */
    public void m() {
        if (!a()) {
            this.f18744c.setBackgroundInternal(c((Drawable) this.f18746e));
        }
        this.f18744c.setForeground(c(this.f18751j));
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f18747f.a((float) this.f18750i, this.f18756o);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        int D = (int) ((B() || C() ? D() : 0.0f) - A());
        this.f18744c.b(this.f18745d.left + D, this.f18745d.top + D, this.f18745d.right + D, this.f18745d.bottom + D);
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.f18762u;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList q() {
        return this.f18754m;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList r() {
        return this.f18753l;
    }

    /* access modifiers changed from: package-private */
    public Drawable s() {
        return this.f18752k;
    }

    /* access modifiers changed from: package-private */
    public int t() {
        return this.f18749h;
    }

    /* access modifiers changed from: package-private */
    public int u() {
        return this.f18748g;
    }

    /* access modifiers changed from: package-private */
    public void v() {
        Drawable drawable = this.f18757p;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.f18757p.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.f18757p.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public m w() {
        return this.f18755n;
    }
}
