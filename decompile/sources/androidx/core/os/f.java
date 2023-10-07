package androidx.core.os;

import com.amap.api.maps.AMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

final class f implements g {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f2992c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f2993d = new Locale(AMap.ENGLISH, "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f2994e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f2995f = e.a("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f2996a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2997b;

    f(Locale... localeArr) {
        String sb;
        if (localeArr.length == 0) {
            this.f2996a = f2992c;
            sb = "";
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            int i2 = 0;
            while (i2 < localeArr.length) {
                Locale locale = localeArr[i2];
                if (locale != null) {
                    if (!hashSet.contains(locale)) {
                        Locale locale2 = (Locale) locale.clone();
                        arrayList.add(locale2);
                        a(sb2, locale2);
                        if (i2 < localeArr.length - 1) {
                            sb2.append(',');
                        }
                        hashSet.add(locale2);
                    }
                    i2++;
                } else {
                    throw new NullPointerException("list[" + i2 + "] is null");
                }
            }
            this.f2996a = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
            sb = sb2.toString();
        }
        this.f2997b = sb;
    }

    static void a(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country != null && !country.isEmpty()) {
            sb.append('-');
            sb.append(locale.getCountry());
        }
    }

    public Object a() {
        return null;
    }

    public Locale a(int i2) {
        if (i2 >= 0) {
            Locale[] localeArr = this.f2996a;
            if (i2 < localeArr.length) {
                return localeArr[i2];
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        Locale[] localeArr = ((f) obj).f2996a;
        if (this.f2996a.length != localeArr.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Locale[] localeArr2 = this.f2996a;
            if (i2 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i2].equals(localeArr[i2])) {
                return false;
            }
            i2++;
        }
    }

    public int hashCode() {
        int i2 = 1;
        int i3 = 0;
        while (true) {
            Locale[] localeArr = this.f2996a;
            if (i3 >= localeArr.length) {
                return i2;
            }
            i2 = (i2 * 31) + localeArr[i3].hashCode();
            i3++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f2996a;
            if (i2 < localeArr.length) {
                sb.append(localeArr[i2]);
                if (i2 < this.f2996a.length - 1) {
                    sb.append(',');
                }
                i2++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }
}
