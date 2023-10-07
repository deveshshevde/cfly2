package r;

import android.text.SpannableStringBuilder;
import com.xeagle.android.login.common.NetworkUtil;
import java.util.Locale;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final d f34159a;

    /* renamed from: b  reason: collision with root package name */
    static final a f34160b;

    /* renamed from: c  reason: collision with root package name */
    static final a f34161c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f34162d = Character.toString(8206);

    /* renamed from: e  reason: collision with root package name */
    private static final String f34163e = Character.toString(8207);

    /* renamed from: f  reason: collision with root package name */
    private final boolean f34164f;

    /* renamed from: g  reason: collision with root package name */
    private final int f34165g;

    /* renamed from: h  reason: collision with root package name */
    private final d f34166h;

    /* renamed from: r.a$a  reason: collision with other inner class name */
    public static final class C0251a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f34167a;

        /* renamed from: b  reason: collision with root package name */
        private int f34168b;

        /* renamed from: c  reason: collision with root package name */
        private d f34169c;

        public C0251a() {
            a(a.a(Locale.getDefault()));
        }

        private void a(boolean z2) {
            this.f34167a = z2;
            this.f34169c = a.f34159a;
            this.f34168b = 2;
        }

        private static a b(boolean z2) {
            return z2 ? a.f34161c : a.f34160b;
        }

        public a a() {
            return (this.f34168b == 2 && this.f34169c == a.f34159a) ? b(this.f34167a) : new a(this.f34167a, this.f34168b, this.f34169c);
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f34170a = new byte[1792];

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f34171b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f34172c;

        /* renamed from: d  reason: collision with root package name */
        private final int f34173d;

        /* renamed from: e  reason: collision with root package name */
        private int f34174e;

        /* renamed from: f  reason: collision with root package name */
        private char f34175f;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f34170a[i2] = Character.getDirectionality(i2);
            }
        }

        b(CharSequence charSequence, boolean z2) {
            this.f34171b = charSequence;
            this.f34172c = z2;
            this.f34173d = charSequence.length();
        }

        private static byte a(char c2) {
            return c2 < 1792 ? f34170a[c2] : Character.getDirectionality(c2);
        }

        private byte e() {
            char charAt;
            int i2 = this.f34174e;
            while (true) {
                int i3 = this.f34174e;
                if (i3 < this.f34173d) {
                    CharSequence charSequence = this.f34171b;
                    this.f34174e = i3 + 1;
                    char charAt2 = charSequence.charAt(i3);
                    this.f34175f = charAt2;
                    if (charAt2 == '>') {
                        return NetworkUtil.CURRENT_NETWORK_TYPE_CM;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i4 = this.f34174e;
                            if (i4 >= this.f34173d) {
                                break;
                            }
                            CharSequence charSequence2 = this.f34171b;
                            this.f34174e = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f34175f = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f34174e = i2;
                    this.f34175f = '<';
                    return 13;
                }
            }
        }

        private byte f() {
            char charAt;
            int i2 = this.f34174e;
            while (true) {
                int i3 = this.f34174e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f34171b;
                int i4 = i3 - 1;
                this.f34174e = i4;
                char charAt2 = charSequence.charAt(i4);
                this.f34175f = charAt2;
                if (charAt2 == '<') {
                    return NetworkUtil.CURRENT_NETWORK_TYPE_CM;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i5 = this.f34174e;
                        if (i5 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f34171b;
                        int i6 = i5 - 1;
                        this.f34174e = i6;
                        charAt = charSequence2.charAt(i6);
                        this.f34175f = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f34174e = i2;
            this.f34175f = '>';
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i2 = this.f34174e;
                if (i2 >= this.f34173d) {
                    return NetworkUtil.CURRENT_NETWORK_TYPE_CM;
                }
                CharSequence charSequence = this.f34171b;
                this.f34174e = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f34175f = charAt;
            } while (charAt != ';');
            return NetworkUtil.CURRENT_NETWORK_TYPE_CM;
        }

        private byte h() {
            char charAt;
            int i2 = this.f34174e;
            do {
                int i3 = this.f34174e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f34171b;
                int i4 = i3 - 1;
                this.f34174e = i4;
                charAt = charSequence.charAt(i4);
                this.f34175f = charAt;
                if (charAt == '&') {
                    return NetworkUtil.CURRENT_NETWORK_TYPE_CM;
                }
            } while (charAt != ';');
            this.f34174e = i2;
            this.f34175f = ';';
            return 13;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            this.f34174e = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f34174e < this.f34173d && i2 == 0) {
                byte c2 = c();
                if (c2 != 0) {
                    if (c2 == 1 || c2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (c2 != 9) {
                        switch (c2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f34174e > 0) {
                switch (d()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r1 = r1 - 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int b() {
            /*
                r7 = this;
                int r0 = r7.f34173d
                r7.f34174e = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r7.f34174e
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.d()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x0028;
                    case 15: goto L_0x0028;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0025:
                if (r2 != r1) goto L_0x002b
                return r5
            L_0x0028:
                if (r2 != r1) goto L_0x002b
                return r4
            L_0x002b:
                int r1 = r1 + -1
                goto L_0x0007
            L_0x002e:
                if (r1 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r1 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r2 != 0) goto L_0x0007
            L_0x0039:
                r2 = r1
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: r.a.b.b():int");
        }

        /* access modifiers changed from: package-private */
        public byte c() {
            char charAt = this.f34171b.charAt(this.f34174e);
            this.f34175f = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f34171b, this.f34174e);
                this.f34174e += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f34174e++;
            byte a2 = a(this.f34175f);
            if (!this.f34172c) {
                return a2;
            }
            char c2 = this.f34175f;
            return c2 == '<' ? e() : c2 == '&' ? g() : a2;
        }

        /* access modifiers changed from: package-private */
        public byte d() {
            char charAt = this.f34171b.charAt(this.f34174e - 1);
            this.f34175f = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f34171b, this.f34174e);
                this.f34174e -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f34174e--;
            byte a2 = a(this.f34175f);
            if (!this.f34172c) {
                return a2;
            }
            char c2 = this.f34175f;
            return c2 == '>' ? f() : c2 == ';' ? h() : a2;
        }
    }

    static {
        d dVar = e.f34194c;
        f34159a = dVar;
        f34160b = new a(false, 2, dVar);
        f34161c = new a(true, 2, dVar);
    }

    a(boolean z2, int i2, d dVar) {
        this.f34164f = z2;
        this.f34165g = i2;
        this.f34166h = dVar;
    }

    private String a(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f34164f || (!a2 && b(charSequence) != 1)) ? this.f34164f ? (!a2 || b(charSequence) == -1) ? f34163e : "" : "" : f34162d;
    }

    public static a a() {
        return new C0251a().a();
    }

    static boolean a(Locale locale) {
        return f.a(locale) == 1;
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).b();
    }

    private String b(CharSequence charSequence, d dVar) {
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        return (this.f34164f || (!a2 && c(charSequence) != 1)) ? this.f34164f ? (!a2 || c(charSequence) == -1) ? f34163e : "" : "" : f34162d;
    }

    private static int c(CharSequence charSequence) {
        return new b(charSequence, false).a();
    }

    public CharSequence a(CharSequence charSequence) {
        return a(charSequence, this.f34166h, true);
    }

    public CharSequence a(CharSequence charSequence, d dVar, boolean z2) {
        if (charSequence == null) {
            return null;
        }
        boolean a2 = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (b() && z2) {
            spannableStringBuilder.append(b(charSequence, a2 ? e.f34193b : e.f34192a));
        }
        if (a2 != this.f34164f) {
            spannableStringBuilder.append(a2 ? (char) 8235 : 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z2) {
            spannableStringBuilder.append(a(charSequence, a2 ? e.f34193b : e.f34192a));
        }
        return spannableStringBuilder;
    }

    public String a(String str) {
        return a(str, this.f34166h, true);
    }

    public String a(String str, d dVar, boolean z2) {
        if (str == null) {
            return null;
        }
        return a((CharSequence) str, dVar, z2).toString();
    }

    public boolean b() {
        return (this.f34165g & 2) != 0;
    }
}
