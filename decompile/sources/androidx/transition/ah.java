package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class ah implements ai {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f4794a;

    ah(View view) {
        this.f4794a = view.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f4794a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.f4794a.remove(drawable);
    }
}
