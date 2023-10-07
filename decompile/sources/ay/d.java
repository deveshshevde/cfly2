package ay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import com.afollestad.materialdialogs.b;
import kotlin.jvm.internal.h;
import l.f;

public final class d {
    private static final Typeface a(Context context, int i2) {
        try {
            return f.a(context, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static final Typeface a(b bVar, Integer num, Integer num2) {
        h.c(bVar, "$this$font");
        e.f5573a.a("font", (Object) num2, num);
        if (num != null) {
            return a(bVar.d(), num.intValue());
        }
        if (num2 != null) {
            TypedArray obtainStyledAttributes = bVar.d().getTheme().obtainStyledAttributes(new int[]{num2.intValue()});
            try {
                int resourceId = obtainStyledAttributes.getResourceId(0, 0);
                if (resourceId == 0) {
                    return null;
                }
                Typeface a2 = a(bVar.d(), resourceId);
                obtainStyledAttributes.recycle();
                return a2;
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static /* synthetic */ Typeface a(b bVar, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            num2 = null;
        }
        return a(bVar, num, num2);
    }
}
