package ep;

import android.content.Context;
import android.os.Build;

public final class f {
    public static d a(Context context, e eVar) {
        int i2 = Build.VERSION.SDK_INT;
        d aVar = i2 < 5 ? new a(context) : i2 < 8 ? new b(context) : new c(context);
        aVar.a(eVar);
        return aVar;
    }
}
