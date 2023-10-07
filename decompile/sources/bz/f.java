package bz;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import ca.b;

public abstract class f<Z> extends k<ImageView, Z> implements b.a {

    /* renamed from: b  reason: collision with root package name */
    private Animatable f6142b;

    public f(ImageView imageView) {
        super(imageView);
    }

    private void b(Z z2) {
        a(z2);
        c(z2);
    }

    private void c(Z z2) {
        if (z2 instanceof Animatable) {
            Animatable animatable = (Animatable) z2;
            this.f6142b = animatable;
            animatable.start();
            return;
        }
        this.f6142b = null;
    }

    public void a(Drawable drawable) {
        super.a(drawable);
        Animatable animatable = this.f6142b;
        if (animatable != null) {
            animatable.stop();
        }
        b((Object) null);
        e(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Z z2);

    public void a(Z z2, b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z2, this)) {
            b(z2);
        } else {
            c(z2);
        }
    }

    public void b(Drawable drawable) {
        super.b(drawable);
        b((Object) null);
        e(drawable);
    }

    public void c(Drawable drawable) {
        super.c(drawable);
        b((Object) null);
        e(drawable);
    }

    public void e() {
        Animatable animatable = this.f6142b;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void e(Drawable drawable) {
        ((ImageView) this.f6147a).setImageDrawable(drawable);
    }

    public void f() {
        Animatable animatable = this.f6142b;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
