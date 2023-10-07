package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.core.widget.e;
import c.a;
import t.ac;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1497a;

    /* renamed from: b  reason: collision with root package name */
    private ad f1498b;

    /* renamed from: c  reason: collision with root package name */
    private ad f1499c;

    /* renamed from: d  reason: collision with root package name */
    private ad f1500d;

    public h(ImageView imageView) {
        this.f1497a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1500d == null) {
            this.f1500d = new ad();
        }
        ad adVar = this.f1500d;
        adVar.a();
        ColorStateList a2 = e.a(this.f1497a);
        if (a2 != null) {
            adVar.f1403d = true;
            adVar.f1400a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f1497a);
        if (b2 != null) {
            adVar.f1402c = true;
            adVar.f1401b = b2;
        }
        if (!adVar.f1403d && !adVar.f1402c) {
            return false;
        }
        f.a(drawable, adVar, this.f1497a.getDrawableState());
        return true;
    }

    private boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1498b != null : i2 == 21;
    }

    public void a(int i2) {
        if (i2 != 0) {
            Drawable b2 = a.b(this.f1497a.getContext(), i2);
            if (b2 != null) {
                q.b(b2);
            }
            this.f1497a.setImageDrawable(b2);
        } else {
            this.f1497a.setImageDrawable((Drawable) null);
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1499c == null) {
            this.f1499c = new ad();
        }
        this.f1499c.f1400a = colorStateList;
        this.f1499c.f1403d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1499c == null) {
            this.f1499c = new ad();
        }
        this.f1499c.f1401b = mode;
        this.f1499c.f1402c = true;
        d();
    }

    public void a(AttributeSet attributeSet, int i2) {
        int g2;
        af a2 = af.a(this.f1497a.getContext(), attributeSet, R.styleable.AppCompatImageView, i2, 0);
        ImageView imageView = this.f1497a;
        ac.a(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, a2.a(), i2, 0);
        try {
            Drawable drawable = this.f1497a.getDrawable();
            if (!(drawable != null || (g2 = a2.g(R.styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f1497a.getContext(), g2)) == null)) {
                this.f1497a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                q.b(drawable);
            }
            if (a2.g(R.styleable.AppCompatImageView_tint)) {
                e.a(this.f1497a, a2.e(R.styleable.AppCompatImageView_tint));
            }
            if (a2.g(R.styleable.AppCompatImageView_tintMode)) {
                e.a(this.f1497a, q.a(a2.a(R.styleable.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1497a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        ad adVar = this.f1499c;
        if (adVar != null) {
            return adVar.f1400a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        ad adVar = this.f1499c;
        if (adVar != null) {
            return adVar.f1401b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Drawable drawable = this.f1497a.getDrawable();
        if (drawable != null) {
            q.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            ad adVar = this.f1499c;
            if (adVar != null) {
                f.a(drawable, adVar, this.f1497a.getDrawableState());
                return;
            }
            ad adVar2 = this.f1498b;
            if (adVar2 != null) {
                f.a(drawable, adVar2, this.f1497a.getDrawableState());
            }
        }
    }
}
