package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

final class f extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f2981a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f2982b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f2983c = null;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f2984d = d.f2973a;

    f(f fVar) {
        if (fVar != null) {
            this.f2981a = fVar.f2981a;
            this.f2982b = fVar.f2982b;
            this.f2983c = fVar.f2983c;
            this.f2984d = fVar.f2984d;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f2982b != null;
    }

    public int getChangingConfigurations() {
        int i2 = this.f2981a;
        Drawable.ConstantState constantState = this.f2982b;
        return i2 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new e(this, resources) : new d(this, resources);
    }
}
