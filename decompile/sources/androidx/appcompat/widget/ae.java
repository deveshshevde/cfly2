package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class ae extends x {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f1404a;

    public ae(Context context, Resources resources) {
        super(resources);
        this.f1404a = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Drawable drawable = super.getDrawable(i2);
        Context context = (Context) this.f1404a.get();
        if (!(drawable == null || context == null)) {
            w.a().a(context, i2, drawable);
        }
        return drawable;
    }
}
