package org.jsoup.parser;

import org.jsoup.helper.c;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private String f33851a;

    /* renamed from: b  reason: collision with root package name */
    private int f33852b = 0;

    public g(String str) {
        c.a((Object) str);
        this.f33851a = str;
    }

    public static String f(String str) {
        StringBuilder a2 = oh.c.a();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        char c2 = 0;
        while (i2 < length) {
            char c3 = charArray[i2];
            if (c3 != '\\' || (c2 != 0 && c2 == '\\')) {
                a2.append(c3);
            }
            i2++;
            c2 = c3;
        }
        return oh.c.a(a2);
    }

    private int i() {
        return this.f33851a.length() - this.f33852b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0048 A[EDGE_INSN: B:36:0x0048->B:30:0x0048 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(char r10, char r11) {
        /*
            r9 = this;
            r0 = 0
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L_0x0007:
            boolean r7 = r9.a()
            if (r7 == 0) goto L_0x000e
            goto L_0x0048
        L_0x000e:
            char r7 = r9.d()
            if (r0 == 0) goto L_0x0018
            r8 = 92
            if (r0 == r8) goto L_0x003f
        L_0x0018:
            r8 = 39
            if (r7 != r8) goto L_0x0023
            if (r7 == r10) goto L_0x0023
            if (r2 != 0) goto L_0x0023
            r3 = r3 ^ 1
            goto L_0x002d
        L_0x0023:
            r8 = 34
            if (r7 != r8) goto L_0x002d
            if (r7 == r10) goto L_0x002d
            if (r3 != 0) goto L_0x002d
            r2 = r2 ^ 1
        L_0x002d:
            if (r3 != 0) goto L_0x0046
            if (r2 == 0) goto L_0x0032
            goto L_0x0046
        L_0x0032:
            if (r7 != r10) goto L_0x003b
            int r4 = r4 + 1
            if (r5 != r1) goto L_0x003f
            int r5 = r9.f33852b
            goto L_0x003f
        L_0x003b:
            if (r7 != r11) goto L_0x003f
            int r4 = r4 + -1
        L_0x003f:
            if (r4 <= 0) goto L_0x0045
            if (r0 == 0) goto L_0x0045
            int r6 = r9.f33852b
        L_0x0045:
            r0 = r7
        L_0x0046:
            if (r4 > 0) goto L_0x0007
        L_0x0048:
            if (r6 < 0) goto L_0x0051
            java.lang.String r10 = r9.f33851a
            java.lang.String r10 = r10.substring(r5, r6)
            goto L_0x0053
        L_0x0051:
            java.lang.String r10 = ""
        L_0x0053:
            if (r4 <= 0) goto L_0x006e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "Did not find balanced marker at '"
            r11.append(r0)
            r11.append(r10)
            java.lang.String r0 = "'"
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            org.jsoup.helper.c.b((java.lang.String) r11)
        L_0x006e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.g.a(char, char):java.lang.String");
    }

    public boolean a() {
        return i() == 0;
    }

    public boolean a(String str) {
        return this.f33851a.regionMatches(true, this.f33852b, str, 0, str.length());
    }

    public boolean a(char... cArr) {
        if (a()) {
            return false;
        }
        for (char c2 : cArr) {
            if (this.f33851a.charAt(this.f33852b) == c2) {
                return true;
            }
        }
        return false;
    }

    public boolean a(String... strArr) {
        for (String a2 : strArr) {
            if (a(a2)) {
                return true;
            }
        }
        return false;
    }

    public String b(String... strArr) {
        int i2 = this.f33852b;
        while (!a() && !a(strArr)) {
            this.f33852b++;
        }
        return this.f33851a.substring(i2, this.f33852b);
    }

    public boolean b() {
        return !a() && oh.c.b((int) this.f33851a.charAt(this.f33852b));
    }

    public boolean b(String str) {
        if (!a(str)) {
            return false;
        }
        this.f33852b += str.length();
        return true;
    }

    public void c(String str) {
        if (a(str)) {
            int length = str.length();
            if (length <= i()) {
                this.f33852b += length;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public boolean c() {
        return !a() && Character.isLetterOrDigit(this.f33851a.charAt(this.f33852b));
    }

    public char d() {
        String str = this.f33851a;
        int i2 = this.f33852b;
        this.f33852b = i2 + 1;
        return str.charAt(i2);
    }

    public String d(String str) {
        int indexOf = this.f33851a.indexOf(str, this.f33852b);
        if (indexOf == -1) {
            return h();
        }
        String substring = this.f33851a.substring(this.f33852b, indexOf);
        this.f33852b += substring.length();
        return substring;
    }

    public String e(String str) {
        String d2 = d(str);
        b(str);
        return d2;
    }

    public boolean e() {
        boolean z2 = false;
        while (b()) {
            this.f33852b++;
            z2 = true;
        }
        return z2;
    }

    public String f() {
        int i2 = this.f33852b;
        while (!a() && (c() || a("*|", "|", "_", "-"))) {
            this.f33852b++;
        }
        return this.f33851a.substring(i2, this.f33852b);
    }

    public String g() {
        int i2 = this.f33852b;
        while (!a() && (c() || a('-', '_'))) {
            this.f33852b++;
        }
        return this.f33851a.substring(i2, this.f33852b);
    }

    public String h() {
        String str = this.f33851a;
        String substring = str.substring(this.f33852b, str.length());
        this.f33852b = this.f33851a.length();
        return substring;
    }

    public String toString() {
        return this.f33851a.substring(this.f33852b);
    }
}
