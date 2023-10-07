package gu;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.b;
import gw.h;
import gw.m;
import gw.p;

public class a extends Drawable implements b, p {

    /* renamed from: a  reason: collision with root package name */
    private C0186a f28595a;

    /* renamed from: gu.a$a  reason: collision with other inner class name */
    static final class C0186a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        h f28596a;

        /* renamed from: b  reason: collision with root package name */
        boolean f28597b;

        public C0186a(C0186a aVar) {
            this.f28596a = (h) aVar.f28596a.getConstantState().newDrawable();
            this.f28597b = aVar.f28597b;
        }

        public C0186a(h hVar) {
            this.f28596a = hVar;
            this.f28597b = false;
        }

        /* renamed from: a */
        public a newDrawable() {
            return new a(new C0186a(this));
        }

        public int getChangingConfigurations() {
            return 0;
        }
    }

    private a(C0186a aVar) {
        this.f28595a = aVar;
    }

    public a(m mVar) {
        this(new C0186a(new h(mVar)));
    }

    /* renamed from: a */
    public a mutate() {
        this.f28595a = new C0186a(this.f28595a);
        return this;
    }

    public void draw(Canvas canvas) {
        if (this.f28595a.f28597b) {
            this.f28595a.f28596a.draw(canvas);
        }
    }

    public Drawable.ConstantState getConstantState() {
        return this.f28595a;
    }

    public int getOpacity() {
        return this.f28595a.f28596a.getOpacity();
    }

    public boolean isStateful() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f28595a.f28596a.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f28595a.f28596a.setState(iArr)) {
            onStateChange = true;
        }
        boolean a2 = b.a(iArr);
        if (this.f28595a.f28597b == a2) {
            return onStateChange;
        }
        this.f28595a.f28597b = a2;
        return true;
    }

    public void setAlpha(int i2) {
        this.f28595a.f28596a.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f28595a.f28596a.setColorFilter(colorFilter);
    }

    public void setShapeAppearanceModel(m mVar) {
        this.f28595a.f28596a.setShapeAppearanceModel(mVar);
    }

    public void setTint(int i2) {
        this.f28595a.f28596a.setTint(i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f28595a.f28596a.setTintList(colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f28595a.f28596a.setTintMode(mode);
    }
}
