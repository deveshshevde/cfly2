package cc;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Objects;

public final class k {
    public static <T> T a(T t2) {
        return a(t2, "Argument must not be null");
    }

    public static <T> T a(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T extends Collection<Y>, Y> T a(T t2) {
        if (!t2.isEmpty()) {
            return t2;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public static void a(boolean z2, String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }
}
