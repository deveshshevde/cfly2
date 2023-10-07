package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import nb.c;

public final class s {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f32299a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final List<String> f32300a = new ArrayList(20);

        /* access modifiers changed from: package-private */
        public a a(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? c(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? c("", str.substring(1)) : c("", str);
        }

        public a a(String str, String str2) {
            s.c(str);
            s.a(str2, str);
            return c(str, str2);
        }

        public a a(s sVar) {
            int a2 = sVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                c(sVar.a(i2), sVar.b(i2));
            }
            return this;
        }

        public s a() {
            return new s(this);
        }

        public a b(String str) {
            int i2 = 0;
            while (i2 < this.f32300a.size()) {
                if (str.equalsIgnoreCase(this.f32300a.get(i2))) {
                    this.f32300a.remove(i2);
                    this.f32300a.remove(i2);
                    i2 -= 2;
                }
                i2 += 2;
            }
            return this;
        }

        public a b(String str, String str2) {
            s.c(str);
            return c(str, str2);
        }

        /* access modifiers changed from: package-private */
        public a c(String str, String str2) {
            this.f32300a.add(str);
            this.f32300a.add(str2.trim());
            return this;
        }

        public a d(String str, String str2) {
            s.c(str);
            s.a(str2, str);
            b(str);
            c(str, str2);
            return this;
        }
    }

    s(a aVar) {
        this.f32299a = (String[]) aVar.f32300a.toArray(new String[aVar.f32300a.size()]);
    }

    private s(String[] strArr) {
        this.f32299a = strArr;
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static s a(String... strArr) {
        Objects.requireNonNull(strArr, "namesAndValues == null");
        if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) strArr.clone();
            int i2 = 0;
            while (i2 < strArr2.length) {
                if (strArr2[i2] != null) {
                    strArr2[i2] = strArr2[i2].trim();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
            }
            for (int i3 = 0; i3 < strArr2.length; i3 += 2) {
                String str = strArr2[i3];
                String str2 = strArr2[i3 + 1];
                c(str);
                a(str2, str);
            }
            return new s(strArr2);
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    static void a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if ((charAt > 31 || charAt == 9) && charAt < 127) {
                    i2++;
                } else {
                    throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }

    static void c(String str) {
        Objects.requireNonNull(str, "name == null");
        if (!str.isEmpty()) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt <= ' ' || charAt >= 127) {
                    throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i2), str));
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty");
    }

    public int a() {
        return this.f32299a.length / 2;
    }

    public String a(int i2) {
        return this.f32299a[i2 * 2];
    }

    public String a(String str) {
        return a(this.f32299a, str);
    }

    public String b(int i2) {
        return this.f32299a[(i2 * 2) + 1];
    }

    public List<String> b(String str) {
        int a2 = a();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < a2; i2++) {
            if (str.equalsIgnoreCase(a(i2))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i2));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public a b() {
        a aVar = new a();
        Collections.addAll(aVar.f32300a, this.f32299a);
        return aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && Arrays.equals(((s) obj).f32299a, this.f32299a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f32299a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int a2 = a();
        for (int i2 = 0; i2 < a2; i2++) {
            sb.append(a(i2));
            sb.append(": ");
            sb.append(b(i2));
            sb.append("\n");
        }
        return sb.toString();
    }
}
