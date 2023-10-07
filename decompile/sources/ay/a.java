package ay;

import android.graphics.Color;
import com.afollestad.materialdialogs.b;
import kotlin.jvm.internal.h;

public final class a {
    public static final int a(int i2, float f2) {
        return Color.argb((int) (((float) 255) * f2), Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public static final int a(b bVar, Integer num, Integer num2, mm.a<Integer> aVar) {
        h.c(bVar, "$this$resolveColor");
        return e.f5573a.a(bVar.d(), num, num2, aVar);
    }

    public static /* synthetic */ int a(b bVar, Integer num, Integer num2, mm.a aVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            num2 = null;
        }
        if ((i2 & 4) != 0) {
            aVar = null;
        }
        return a(bVar, num, num2, aVar);
    }
}
