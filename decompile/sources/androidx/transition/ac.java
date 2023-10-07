package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ac implements ad {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f4778a;

    ac(ViewGroup viewGroup) {
        this.f4778a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.f4778a.add(drawable);
    }

    public void a(View view) {
        this.f4778a.add(view);
    }

    public void b(Drawable drawable) {
        this.f4778a.remove(drawable);
    }

    public void b(View view) {
        this.f4778a.remove(view);
    }
}
