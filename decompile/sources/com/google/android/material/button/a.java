package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import gt.c;
import gu.b;
import gw.h;
import gw.m;
import gw.p;
import t.ac;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f18713a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    private final MaterialButton f18714b;

    /* renamed from: c  reason: collision with root package name */
    private m f18715c;

    /* renamed from: d  reason: collision with root package name */
    private int f18716d;

    /* renamed from: e  reason: collision with root package name */
    private int f18717e;

    /* renamed from: f  reason: collision with root package name */
    private int f18718f;

    /* renamed from: g  reason: collision with root package name */
    private int f18719g;

    /* renamed from: h  reason: collision with root package name */
    private int f18720h;

    /* renamed from: i  reason: collision with root package name */
    private int f18721i;

    /* renamed from: j  reason: collision with root package name */
    private PorterDuff.Mode f18722j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f18723k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f18724l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f18725m;

    /* renamed from: n  reason: collision with root package name */
    private Drawable f18726n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f18727o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f18728p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f18729q = false;

    /* renamed from: r  reason: collision with root package name */
    private boolean f18730r;

    /* renamed from: s  reason: collision with root package name */
    private LayerDrawable f18731s;

    /* renamed from: t  reason: collision with root package name */
    private int f18732t;

    a(MaterialButton materialButton, m mVar) {
        this.f18714b = materialButton;
        this.f18715c = mVar;
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f18716d, this.f18718f, this.f18717e, this.f18719g);
    }

    private void b(int i2, int i3) {
        int l2 = ac.l(this.f18714b);
        int paddingTop = this.f18714b.getPaddingTop();
        int m2 = ac.m(this.f18714b);
        int paddingBottom = this.f18714b.getPaddingBottom();
        int i4 = this.f18718f;
        int i5 = this.f18719g;
        this.f18719g = i3;
        this.f18718f = i2;
        if (!this.f18728p) {
            o();
        }
        ac.b(this.f18714b, l2, (paddingTop + i2) - i4, m2, (paddingBottom + i3) - i5);
    }

    private void b(m mVar) {
        if (i() != null) {
            i().setShapeAppearanceModel(mVar);
        }
        if (r() != null) {
            r().setShapeAppearanceModel(mVar);
        }
        if (k() != null) {
            k().setShapeAppearanceModel(mVar);
        }
    }

    private h c(boolean z2) {
        LayerDrawable layerDrawable = this.f18731s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (h) (f18713a ? (LayerDrawable) ((InsetDrawable) this.f18731s.getDrawable(0)).getDrawable() : this.f18731s).getDrawable(z2 ^ true ? 1 : 0);
    }

    private void o() {
        this.f18714b.setInternalBackground(p());
        h i2 = i();
        if (i2 != null) {
            i2.r((float) this.f18732t);
        }
    }

    private Drawable p() {
        h hVar = new h(this.f18715c);
        hVar.a(this.f18714b.getContext());
        androidx.core.graphics.drawable.a.a((Drawable) hVar, this.f18723k);
        PorterDuff.Mode mode = this.f18722j;
        if (mode != null) {
            androidx.core.graphics.drawable.a.a((Drawable) hVar, mode);
        }
        hVar.a((float) this.f18721i, this.f18724l);
        h hVar2 = new h(this.f18715c);
        hVar2.setTint(0);
        hVar2.a((float) this.f18721i, this.f18727o ? gn.a.a((View) this.f18714b, R.attr.colorSurface) : 0);
        if (f18713a) {
            h hVar3 = new h(this.f18715c);
            this.f18726n = hVar3;
            androidx.core.graphics.drawable.a.a((Drawable) hVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(b.b(this.f18725m), a((Drawable) new LayerDrawable(new Drawable[]{hVar2, hVar})), this.f18726n);
            this.f18731s = rippleDrawable;
            return rippleDrawable;
        }
        gu.a aVar = new gu.a(this.f18715c);
        this.f18726n = aVar;
        androidx.core.graphics.drawable.a.a((Drawable) aVar, b.b(this.f18725m));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{hVar2, hVar, this.f18726n});
        this.f18731s = layerDrawable;
        return a((Drawable) layerDrawable);
    }

    private void q() {
        h i2 = i();
        h r2 = r();
        if (i2 != null) {
            i2.a((float) this.f18721i, this.f18724l);
            if (r2 != null) {
                r2.a((float) this.f18721i, this.f18727o ? gn.a.a((View) this.f18714b, R.attr.colorSurface) : 0);
            }
        }
    }

    private h r() {
        return c(true);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f18728p = true;
        this.f18714b.setSupportBackgroundTintList(this.f18723k);
        this.f18714b.setSupportBackgroundTintMode(this.f18722j);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (i() != null) {
            i().setTint(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3) {
        Drawable drawable = this.f18726n;
        if (drawable != null) {
            drawable.setBounds(this.f18716d, this.f18718f, i3 - this.f18717e, i2 - this.f18719g);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f18723k != colorStateList) {
            this.f18723k = colorStateList;
            if (i() != null) {
                androidx.core.graphics.drawable.a.a((Drawable) i(), this.f18723k);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TypedArray typedArray) {
        this.f18716d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f18717e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f18718f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f18719g = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R.styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
            this.f18720h = dimensionPixelSize;
            a(this.f18715c.a((float) dimensionPixelSize));
            this.f18729q = true;
        }
        this.f18721i = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f18722j = s.a(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f18723k = c.a(this.f18714b.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f18724l = c.a(this.f18714b.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f18725m = c.a(this.f18714b.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.f18730r = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        this.f18732t = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int l2 = ac.l(this.f18714b);
        int paddingTop = this.f18714b.getPaddingTop();
        int m2 = ac.m(this.f18714b);
        int paddingBottom = this.f18714b.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.MaterialButton_android_background)) {
            a();
        } else {
            o();
        }
        ac.b(this.f18714b, l2 + this.f18716d, paddingTop + this.f18718f, m2 + this.f18717e, paddingBottom + this.f18719g);
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f18722j != mode) {
            this.f18722j = mode;
            if (i() != null && this.f18722j != null) {
                androidx.core.graphics.drawable.a.a((Drawable) i(), this.f18722j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(m mVar) {
        this.f18715c = mVar;
        b(mVar);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f18727o = z2;
        q();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (this.f18721i != i2) {
            this.f18721i = i2;
            q();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.f18725m != colorStateList) {
            this.f18725m = colorStateList;
            boolean z2 = f18713a;
            if (z2 && (this.f18714b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f18714b.getBackground()).setColor(b.b(colorStateList));
            } else if (!z2 && (this.f18714b.getBackground() instanceof gu.a)) {
                ((gu.a) this.f18714b.getBackground()).setTintList(b.b(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.f18730r = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f18728p;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        return this.f18723k;
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        if (!this.f18729q || this.f18720h != i2) {
            this.f18720h = i2;
            this.f18729q = true;
            a(this.f18715c.a((float) i2));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (this.f18724l != colorStateList) {
            this.f18724l = colorStateList;
            q();
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        return this.f18722j;
    }

    public void d(int i2) {
        b(this.f18718f, i2);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.f18725m;
    }

    public void e(int i2) {
        b(i2, this.f18719g);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList f() {
        return this.f18724l;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f18721i;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f18720h;
    }

    /* access modifiers changed from: package-private */
    public h i() {
        return c(false);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.f18730r;
    }

    public p k() {
        LayerDrawable layerDrawable = this.f18731s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (p) (this.f18731s.getNumberOfLayers() > 2 ? this.f18731s.getDrawable(2) : this.f18731s.getDrawable(1));
    }

    /* access modifiers changed from: package-private */
    public m l() {
        return this.f18715c;
    }

    public int m() {
        return this.f18719g;
    }

    public int n() {
        return this.f18718f;
    }
}
