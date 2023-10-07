package as;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import kotlin.jvm.internal.h;
import mm.a;

public final class c {
    public static final float a(Context context, int i2) {
        h.c(context, "$this$getFloat");
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i2, typedValue, true);
        return typedValue.getFloat();
    }

    public static final int a(Context context, int i2, a<Integer> aVar) {
        h.c(context, "$this$resolveColor");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i2});
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            if (color == 0 && aVar != null) {
                return aVar.e_().intValue();
            }
            obtainStyledAttributes.recycle();
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ int a(Context context, int i2, a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = null;
        }
        return a(context, i2, aVar);
    }
}
