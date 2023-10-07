package bs;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.s;

final class d extends c<Drawable> {
    private d(Drawable drawable) {
        super(drawable);
    }

    static s<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    public Class<Drawable> c() {
        return this.f5987a.getClass();
    }

    public int e() {
        return Math.max(1, this.f5987a.getIntrinsicWidth() * this.f5987a.getIntrinsicHeight() * 4);
    }

    public void f() {
    }
}
