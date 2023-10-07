package bs;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import cc.k;
import com.bumptech.glide.load.engine.o;
import com.bumptech.glide.load.engine.s;

public abstract class c<T extends Drawable> implements o, s<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f5987a;

    public c(T t2) {
        this.f5987a = (Drawable) k.a(t2);
    }

    public void a() {
        Bitmap b2;
        T t2 = this.f5987a;
        if (t2 instanceof BitmapDrawable) {
            b2 = ((BitmapDrawable) t2).getBitmap();
        } else if (t2 instanceof bu.c) {
            b2 = ((bu.c) t2).b();
        } else {
            return;
        }
        b2.prepareToDraw();
    }

    /* renamed from: b */
    public final T d() {
        Drawable.ConstantState constantState = this.f5987a.getConstantState();
        return constantState == null ? this.f5987a : constantState.newDrawable();
    }
}
