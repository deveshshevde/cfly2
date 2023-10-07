package ay;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import kotlin.jvm.internal.h;

public final class c {
    public static final float a(View view, int i2) {
        h.c(view, "$this$dp");
        Resources resources = view.getResources();
        h.a((Object) resources, "resources");
        return TypedValue.applyDimension(1, (float) i2, resources.getDisplayMetrics());
    }
}
