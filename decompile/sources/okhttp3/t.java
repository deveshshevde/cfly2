package okhttp3;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import nb.c;

public final class t {

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f32301d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    final String f32302a;

    /* renamed from: b  reason: collision with root package name */
    final String f32303b;

    /* renamed from: c  reason: collision with root package name */
    final int f32304c;

    /* renamed from: e  reason: collision with root package name */
    private final String f32305e;

    /* renamed from: f  reason: collision with root package name */
    private final String f32306f;

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f32307g;

    /* renamed from: h  reason: collision with root package name */
    private final List<String> f32308h;

    /* renamed from: i  reason: collision with root package name */
    private final String f32309i;

    /* renamed from: j  reason: collision with root package name */
    private final String f32310j;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        String f32311a;

        /* renamed from: b  reason: collision with root package name */
        String f32312b = "";

        /* renamed from: c  reason: collision with root package name */
        String f32313c = "";

        /* renamed from: d  reason: collision with root package name */
        String f32314d;

        /* renamed from: e  reason: collision with root package name */
        int f32315e = -1;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f32316f;

        /* renamed from: g  reason: collision with root package name */
        List<String> f32317g;

        /* renamed from: h  reason: collision with root package name */
        String f32318h;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f32316f = arrayList;
            arrayList.add("");
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void a(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f32316f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f32316f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f32316f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = nb.c.a((java.lang.String) r11, (int) r6, (int) r13, (java.lang.String) r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.t.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i2, int i3, boolean z2, boolean z3) {
            String a2 = t.a(str, i2, i3, " \"<>^`{}|/\\?#", z3, false, false, true, (Charset) null);
            if (!f(a2)) {
                if (g(a2)) {
                    d();
                    return;
                }
                List<String> list = this.f32316f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f32316f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f32316f.add(a2);
                }
                if (z2) {
                    this.f32316f.add("");
                }
            }
        }

        private static int b(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i2;
                        }
                    }
                }
            }
            return -1;
        }

        private static int c(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private static int d(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                    } while (str.charAt(i2) == ']');
                }
                i2++;
            }
            return i3;
        }

        private void d() {
            List<String> list = this.f32316f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f32316f.isEmpty()) {
                this.f32316f.add("");
                return;
            }
            List<String> list2 = this.f32316f;
            list2.set(list2.size() - 1, "");
        }

        private static String e(String str, int i2, int i3) {
            return c.a(t.a(str, i2, i3, false));
        }

        private static int f(String str, int i2, int i3) {
            try {
                int parseInt = Integer.parseInt(t.a(str, i2, i3, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        /* access modifiers changed from: package-private */
        public int a() {
            int i2 = this.f32315e;
            return i2 != -1 ? i2 : t.a(this.f32311a);
        }

        public a a(int i2) {
            if (i2 <= 0 || i2 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i2);
            }
            this.f32315e = i2;
            return this;
        }

        public a a(String str) {
            Objects.requireNonNull(str, "scheme == null");
            String str2 = "http";
            if (!str.equalsIgnoreCase(str2)) {
                str2 = "https";
                if (!str.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.f32311a = str2;
            return this;
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            if (this.f32317g == null) {
                this.f32317g = new ArrayList();
            }
            this.f32317g.add(t.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.f32317g.add(str2 != null ? t.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a(t tVar, String str) {
            int a2;
            int i2;
            t tVar2 = tVar;
            String str2 = str;
            int a3 = c.a(str2, 0, str.length());
            int b2 = c.b(str2, a3, str.length());
            int b3 = b(str2, a3, b2);
            if (b3 != -1) {
                if (str.regionMatches(true, a3, "https:", 0, 6)) {
                    this.f32311a = "https";
                    a3 += 6;
                } else if (str.regionMatches(true, a3, "http:", 0, 5)) {
                    this.f32311a = "http";
                    a3 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, b3) + "'");
                }
            } else if (tVar2 != null) {
                this.f32311a = tVar2.f32302a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int c2 = c(str2, a3, b2);
            char c3 = '?';
            char c4 = '#';
            if (c2 >= 2 || tVar2 == null || !tVar2.f32302a.equals(this.f32311a)) {
                int i3 = a3 + c2;
                boolean z2 = false;
                boolean z3 = false;
                while (true) {
                    a2 = c.a(str2, i3, b2, "@/\\?#");
                    char charAt = a2 != b2 ? str2.charAt(a2) : 65535;
                    if (charAt == 65535 || charAt == c4 || charAt == '/' || charAt == '\\' || charAt == c3) {
                        int i4 = a2;
                        int d2 = d(str2, i3, i4);
                        int i5 = d2 + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z2) {
                                int a4 = c.a(str2, i3, a2, ':');
                                int i6 = a4;
                                String str3 = "%40";
                                i2 = a2;
                                String a5 = t.a(str, i3, a4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z3) {
                                    a5 = this.f32312b + str3 + a5;
                                }
                                this.f32312b = a5;
                                if (i6 != i2) {
                                    this.f32313c = t.a(str, i6 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z2 = true;
                                }
                                z3 = true;
                            } else {
                                i2 = a2;
                                this.f32313c += "%40" + t.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            i3 = i2 + 1;
                        }
                        c3 = '?';
                        c4 = '#';
                    }
                }
                int i42 = a2;
                int d22 = d(str2, i3, i42);
                int i52 = d22 + 1;
                if (i52 < i42) {
                    this.f32314d = e(str2, i3, d22);
                    int f2 = f(str2, i52, i42);
                    this.f32315e = f2;
                    if (f2 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i52, i42) + '\"');
                    }
                } else {
                    this.f32314d = e(str2, i3, d22);
                    this.f32315e = t.a(this.f32311a);
                }
                if (this.f32314d != null) {
                    a3 = i42;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i3, d22) + '\"');
                }
            } else {
                this.f32312b = tVar.d();
                this.f32313c = tVar.e();
                this.f32314d = tVar2.f32303b;
                this.f32315e = tVar2.f32304c;
                this.f32316f.clear();
                this.f32316f.addAll(tVar.i());
                if (a3 == b2 || str2.charAt(a3) == '#') {
                    e(tVar.k());
                }
            }
            int a6 = c.a(str2, a3, b2, "?#");
            a(str2, a3, a6);
            if (a6 < b2 && str2.charAt(a6) == '?') {
                int a7 = c.a(str2, a6, b2, '#');
                this.f32317g = t.b(t.a(str, a6 + 1, a7, " \"'<>#", true, false, true, true, (Charset) null));
                a6 = a7;
            }
            if (a6 < b2 && str2.charAt(a6) == '#') {
                this.f32318h = t.a(str, 1 + a6, b2, "", true, false, false, false, (Charset) null);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public a b() {
            int size = this.f32316f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f32316f.set(i2, t.a(this.f32316f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f32317g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f32317g.get(i3);
                    if (str != null) {
                        this.f32317g.set(i3, t.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f32318h;
            if (str2 != null) {
                this.f32318h = t.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a b(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f32312b = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a b(String str, String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f32317g == null) {
                this.f32317g = new ArrayList();
            }
            this.f32317g.add(t.a(str, " \"'<>#&=", true, false, true, true));
            this.f32317g.add(str2 != null ? t.a(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public a c(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f32313c = t.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public t c() {
            if (this.f32311a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f32314d != null) {
                return new t(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public a d(String str) {
            Objects.requireNonNull(str, "host == null");
            String e2 = e(str, 0, str.length());
            if (e2 != null) {
                this.f32314d = e2;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a e(String str) {
            this.f32317g = str != null ? t.b(t.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.f32311a;
            if (str2 != null) {
                sb.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            if (!this.f32312b.isEmpty() || !this.f32313c.isEmpty()) {
                sb.append(this.f32312b);
                if (!this.f32313c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f32313c);
                }
                sb.append('@');
            }
            String str3 = this.f32314d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f32314d);
                    sb.append(']');
                } else {
                    sb.append(this.f32314d);
                }
            }
            if (!(this.f32315e == -1 && this.f32311a == null)) {
                int a2 = a();
                String str4 = this.f32311a;
                if (str4 == null || a2 != t.a(str4)) {
                    sb.append(':');
                    sb.append(a2);
                }
            }
            t.a(sb, this.f32316f);
            if (this.f32317g != null) {
                sb.append('?');
                t.b(sb, this.f32317g);
            }
            if (this.f32318h != null) {
                sb.append('#');
                sb.append(this.f32318h);
            }
            return sb.toString();
        }
    }

    t(a aVar) {
        this.f32302a = aVar.f32311a;
        this.f32305e = a(aVar.f32312b, false);
        this.f32306f = a(aVar.f32313c, false);
        this.f32303b = aVar.f32314d;
        this.f32304c = aVar.a();
        this.f32307g = a(aVar.f32316f, false);
        String str = null;
        this.f32308h = aVar.f32317g != null ? a(aVar.f32317g, true) : null;
        this.f32309i = aVar.f32318h != null ? a(aVar.f32318h, false) : str;
        this.f32310j = aVar.toString();
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static String a(String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
        String str3 = str;
        int i4 = i3;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z5)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z2 && (!z3 || a(str, i5, i3)))) && (codePointAt != 43 || !z4))) {
                    i5 += Character.charCount(codePointAt);
                }
            }
            okio.c cVar = new okio.c();
            int i6 = i2;
            cVar.a(str, i2, i5);
            a(cVar, str, i5, i3, str2, z2, z3, z4, z5, charset);
            return cVar.p();
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    static String a(String str, int i2, int i3, boolean z2) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z2)) {
                okio.c cVar = new okio.c();
                cVar.a(str, i2, i4);
                a(cVar, str, i4, i3, z2);
                return cVar.p();
            }
        }
        return str.substring(i2, i3);
    }

    static String a(String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5) {
        return a(str, 0, str.length(), str2, z2, z3, z4, z5, (Charset) null);
    }

    static String a(String str, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
        return a(str, 0, str.length(), str2, z2, z3, z4, z5, charset);
    }

    static String a(String str, boolean z2) {
        return a(str, 0, str.length(), z2);
    }

    private List<String> a(List<String> list, boolean z2) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? a(str, z2) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    static void a(okio.c cVar, String str, int i2, int i3, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset) {
        okio.c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z2 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z4) {
                    cVar.b(z2 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z5) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z2 || (z3 && !a(str, i2, i3)))))) {
                    if (cVar2 == null) {
                        cVar2 = new okio.c();
                    }
                    if (charset == null || charset.equals(StandardCharsets.UTF_8)) {
                        cVar2.a(codePointAt);
                    } else {
                        cVar2.a(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!cVar2.f()) {
                        byte i4 = cVar2.i() & 255;
                        cVar.i(37);
                        char[] cArr = f32301d;
                        cVar.i((int) cArr[(i4 >> 4) & 15]);
                        cVar.i((int) cArr[i4 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    static void a(okio.c cVar, String str, int i2, int i3, boolean z2) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int a2 = c.a(str.charAt(i2 + 1));
                int a3 = c.a(str.charAt(i4));
                if (!(a2 == -1 || a3 == -1)) {
                    cVar.i((a2 << 4) + a3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z2) {
                cVar.i(32);
                i2 += Character.charCount(codePointAt);
            }
            cVar.a(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean a(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && c.a(str.charAt(i2 + 1)) != -1 && c.a(str.charAt(i4)) != -1;
    }

    static List<String> b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static t e(String str) {
        return new a().a((t) null, str).c();
    }

    public URI a() {
        String aVar = o().b().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.f32302a;
    }

    public t c(String str) {
        a d2 = d(str);
        if (d2 != null) {
            return d2.c();
        }
        return null;
    }

    public boolean c() {
        return this.f32302a.equals("https");
    }

    public String d() {
        if (this.f32305e.isEmpty()) {
            return "";
        }
        int length = this.f32302a.length() + 3;
        String str = this.f32310j;
        return this.f32310j.substring(length, c.a(str, length, str.length(), ":@"));
    }

    public a d(String str) {
        try {
            return new a().a(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String e() {
        if (this.f32306f.isEmpty()) {
            return "";
        }
        int indexOf = this.f32310j.indexOf(64);
        return this.f32310j.substring(this.f32310j.indexOf(58, this.f32302a.length() + 3) + 1, indexOf);
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && ((t) obj).f32310j.equals(this.f32310j);
    }

    public String f() {
        return this.f32303b;
    }

    public int g() {
        return this.f32304c;
    }

    public String h() {
        int indexOf = this.f32310j.indexOf(47, this.f32302a.length() + 3);
        String str = this.f32310j;
        return this.f32310j.substring(indexOf, c.a(str, indexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.f32310j.hashCode();
    }

    public List<String> i() {
        int indexOf = this.f32310j.indexOf(47, this.f32302a.length() + 3);
        String str = this.f32310j;
        int a2 = c.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i2 = indexOf + 1;
            int a3 = c.a(this.f32310j, i2, a2, '/');
            arrayList.add(this.f32310j.substring(i2, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public List<String> j() {
        return this.f32307g;
    }

    public String k() {
        if (this.f32308h == null) {
            return null;
        }
        int indexOf = this.f32310j.indexOf(63) + 1;
        String str = this.f32310j;
        return this.f32310j.substring(indexOf, c.a(str, indexOf, str.length(), '#'));
    }

    public String l() {
        if (this.f32308h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.f32308h);
        return sb.toString();
    }

    public String m() {
        if (this.f32309i == null) {
            return null;
        }
        return this.f32310j.substring(this.f32310j.indexOf(35) + 1);
    }

    public String n() {
        return d("/...").b("").c("").c().toString();
    }

    public a o() {
        a aVar = new a();
        aVar.f32311a = this.f32302a;
        aVar.f32312b = d();
        aVar.f32313c = e();
        aVar.f32314d = this.f32303b;
        aVar.f32315e = this.f32304c != a(this.f32302a) ? this.f32304c : -1;
        aVar.f32316f.clear();
        aVar.f32316f.addAll(i());
        aVar.e(k());
        aVar.f32318h = m();
        return aVar;
    }

    public String toString() {
        return this.f32310j;
    }
}
