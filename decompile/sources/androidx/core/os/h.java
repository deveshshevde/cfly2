package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

final class h implements g {

    /* renamed from: a  reason: collision with root package name */
    private final LocaleList f2998a;

    h(LocaleList localeList) {
        this.f2998a = localeList;
    }

    public Object a() {
        return this.f2998a;
    }

    public Locale a(int i2) {
        return this.f2998a.get(i2);
    }

    public boolean equals(Object obj) {
        return this.f2998a.equals(((g) obj).a());
    }

    public int hashCode() {
        return this.f2998a.hashCode();
    }

    public String toString() {
        return this.f2998a.toString();
    }
}
