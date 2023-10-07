package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;

public final class c {
    public static e a(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.a(configuration.getLocales());
        }
        return e.a(configuration.locale);
    }
}
