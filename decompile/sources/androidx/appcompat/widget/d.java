package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import t.ac;

class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f1476a;

    /* renamed from: b  reason: collision with root package name */
    private final f f1477b;

    /* renamed from: c  reason: collision with root package name */
    private int f1478c = -1;

    /* renamed from: d  reason: collision with root package name */
    private ad f1479d;

    /* renamed from: e  reason: collision with root package name */
    private ad f1480e;

    /* renamed from: f  reason: collision with root package name */
    private ad f1481f;

    d(View view) {
        this.f1476a = view;
        this.f1477b = f.b();
    }

    private boolean b(Drawable drawable) {
        if (this.f1481f == null) {
            this.f1481f = new ad();
        }
        ad adVar = this.f1481f;
        adVar.a();
        ColorStateList C = ac.C(this.f1476a);
        if (C != null) {
            adVar.f1403d = true;
            adVar.f1400a = C;
        }
        PorterDuff.Mode D = ac.D(this.f1476a);
        if (D != null) {
            adVar.f1402c = true;
            adVar.f1401b = D;
        }
        if (!adVar.f1403d && !adVar.f1402c) {
            return false;
        }
        f.a(drawable, adVar, this.f1476a.getDrawableState());
        return true;
    }

    private boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1479d != null : i2 == 21;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList a() {
        ad adVar = this.f1480e;
        if (adVar != null) {
            return adVar.f1400a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f1478c = i2;
        f fVar = this.f1477b;
        b(fVar != null ? fVar.b(this.f1476a.getContext(), i2) : null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1480e == null) {
            this.f1480e = new ad();
        }
        this.f1480e.f1400a = colorStateList;
        this.f1480e.f1403d = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1480e == null) {
            this.f1480e = new ad();
        }
        this.f1480e.f1401b = mode;
        this.f1480e.f1402c = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(Drawable drawable) {
        this.f1478c = -1;
        b((ColorStateList) null);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i2) {
        af a2 = af.a(this.f1476a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i2, 0);
        View view = this.f1476a;
        ac.a(view, view.getContext(), R.styleable.ViewBackgroundHelper, attributeSet, a2.a(), i2, 0);
        try {
            if (a2.g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f1478c = a2.g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList b2 = this.f1477b.b(this.f1476a.getContext(), this.f1478c);
                if (b2 != null) {
                    b(b2);
                }
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ac.a(this.f1476a, a2.e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ac.a(this.f1476a, q.a(a2.a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.b();
        }
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        ad adVar = this.f1480e;
        if (adVar != null) {
            return adVar.f1401b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1479d == null) {
                this.f1479d = new ad();
            }
            this.f1479d.f1400a = colorStateList;
            this.f1479d.f1403d = true;
        } else {
            this.f1479d = null;
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable background = this.f1476a.getBackground();
        if (background == null) {
            return;
        }
        if (!d() || !b(background)) {
            ad adVar = this.f1480e;
            if (adVar != null) {
                f.a(background, adVar, this.f1476a.getDrawableState());
                return;
            }
            ad adVar2 = this.f1479d;
            if (adVar2 != null) {
                f.a(background, adVar2, this.f1476a.getDrawableState());
            }
        }
    }
}
