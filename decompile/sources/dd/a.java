package dd;

import android.content.Context;
import android.content.res.Resources;
import com.xeagle.android.XEagleApp;
import kotlin.jvm.internal.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26693a = new a();

    private a() {
    }

    public final float a(Context context) {
        h.d(context, "context");
        Resources resources = context.getResources();
        h.b(resources, "context.resources");
        return resources.getDisplayMetrics().density;
    }

    public final int a(float f2) {
        Context context = XEagleApp.f12203a;
        h.b(context, "XEagleApp.context");
        return (int) ((a(context) * f2) + 0.5f);
    }
}
