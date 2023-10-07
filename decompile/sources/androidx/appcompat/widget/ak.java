package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

public class ak extends Resources {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1450a = false;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1451b;

    public ak(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1451b = new WeakReference<>(context);
    }

    public static boolean a() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    public static boolean b() {
        return f1450a;
    }

    /* access modifiers changed from: package-private */
    public final Drawable a(int i2) {
        return super.getDrawable(i2);
    }

    public Drawable getDrawable(int i2) throws Resources.NotFoundException {
        Context context = (Context) this.f1451b.get();
        return context != null ? w.a().a(context, this, i2) : super.getDrawable(i2);
    }
}
