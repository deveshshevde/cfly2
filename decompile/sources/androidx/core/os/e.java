package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f2990a = a(new Locale[0]);

    /* renamed from: b  reason: collision with root package name */
    private g f2991b;

    private e(g gVar) {
        this.f2991b = gVar;
    }

    public static e a(LocaleList localeList) {
        return new e(new h(localeList));
    }

    public static e a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? a(new LocaleList(localeArr)) : new e(new f(localeArr));
    }

    static Locale a(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public Locale a(int i2) {
        return this.f2991b.a(i2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && this.f2991b.equals(((e) obj).f2991b);
    }

    public int hashCode() {
        return this.f2991b.hashCode();
    }

    public String toString() {
        return this.f2991b.toString();
    }
}
