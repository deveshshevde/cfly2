package r;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Locale f34204a = new Locale("", "");

    public static int a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f34204a)) {
            return 0;
        }
        String a2 = b.a(locale);
        return a2 == null ? b(locale) : (a2.equalsIgnoreCase("Arab") || a2.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }

    private static int b(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }
}
