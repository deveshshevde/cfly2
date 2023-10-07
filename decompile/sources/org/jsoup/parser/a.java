package org.jsoup.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Locale;
import org.jsoup.UncheckedIOException;
import org.jsoup.helper.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private char[] f33798a;

    /* renamed from: b  reason: collision with root package name */
    private Reader f33799b;

    /* renamed from: c  reason: collision with root package name */
    private int f33800c;

    /* renamed from: d  reason: collision with root package name */
    private int f33801d;

    /* renamed from: e  reason: collision with root package name */
    private int f33802e;

    /* renamed from: f  reason: collision with root package name */
    private int f33803f;

    /* renamed from: g  reason: collision with root package name */
    private int f33804g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f33805h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f33806i;

    public a(Reader reader) {
        this(reader, 32768);
    }

    public a(Reader reader, int i2) {
        this.f33804g = -1;
        this.f33805h = new String[512];
        c.a((Object) reader);
        c.a(reader.markSupported());
        this.f33799b = reader;
        this.f33798a = new char[(i2 > 32768 ? 32768 : i2)];
        u();
    }

    public a(String str) {
        this(new StringReader(str), str.length());
    }

    private static String a(char[] cArr, String[] strArr, int i2, int i3) {
        if (i3 > 12) {
            return new String(cArr, i2, i3);
        }
        if (i3 < 1) {
            return "";
        }
        int i4 = i3 * 31;
        int i5 = 0;
        int i6 = i2;
        while (i5 < i3) {
            i4 = (i4 * 31) + cArr[i6];
            i5++;
            i6++;
        }
        int i7 = i4 & 511;
        String str = strArr[i7];
        if (str == null) {
            String str2 = new String(cArr, i2, i3);
            strArr[i7] = str2;
            return str2;
        } else if (a(cArr, i2, i3, str)) {
            return str;
        } else {
            String str3 = new String(cArr, i2, i3);
            strArr[i7] = str3;
            return str3;
        }
    }

    static boolean a(char[] cArr, int i2, int i3, String str) {
        if (i3 != str.length()) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 == 0) {
                return true;
            }
            int i6 = i2 + 1;
            int i7 = i4 + 1;
            if (cArr[i2] != str.charAt(i4)) {
                return false;
            }
            i2 = i6;
            i3 = i5;
            i4 = i7;
        }
    }

    private void u() {
        int i2;
        int i3;
        boolean z2;
        if (!this.f33806i && (i2 = this.f33802e) >= this.f33801d) {
            int i4 = this.f33804g;
            if (i4 != -1) {
                int i5 = i4;
                i3 = i2 - i4;
                i2 = i5;
            } else {
                i3 = 0;
            }
            try {
                long j2 = (long) i2;
                long skip = this.f33799b.skip(j2);
                this.f33799b.mark(32768);
                int i6 = 0;
                while (true) {
                    z2 = true;
                    if (i6 > 1024) {
                        break;
                    }
                    Reader reader = this.f33799b;
                    char[] cArr = this.f33798a;
                    int read = reader.read(cArr, i6, cArr.length - i6);
                    if (read == -1) {
                        this.f33806i = true;
                    }
                    if (read <= 0) {
                        break;
                    }
                    i6 += read;
                }
                this.f33799b.reset();
                if (i6 > 0) {
                    if (skip != j2) {
                        z2 = false;
                    }
                    c.a(z2);
                    this.f33800c = i6;
                    this.f33803f += i2;
                    this.f33802e = i3;
                    if (this.f33804g != -1) {
                        this.f33804g = 0;
                    }
                    if (i6 > 24576) {
                        i6 = 24576;
                    }
                    this.f33801d = i6;
                }
            } catch (IOException e2) {
                throw new UncheckedIOException(e2);
            }
        }
    }

    private boolean v() {
        return this.f33802e >= this.f33800c;
    }

    /* access modifiers changed from: package-private */
    public int a(char c2) {
        u();
        for (int i2 = this.f33802e; i2 < this.f33800c; i2++) {
            if (c2 == this.f33798a[i2]) {
                return i2 - this.f33802e;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int a(CharSequence charSequence) {
        u();
        char charAt = charSequence.charAt(0);
        int i2 = this.f33802e;
        while (i2 < this.f33800c) {
            int i3 = 1;
            if (charAt != this.f33798a[i2]) {
                do {
                    i2++;
                    if (i2 >= this.f33800c) {
                        break;
                    }
                } while (charAt == this.f33798a[i2]);
            }
            int i4 = i2 + 1;
            int length = (charSequence.length() + i4) - 1;
            int i5 = this.f33800c;
            if (i2 < i5 && length <= i5) {
                int i6 = i4;
                while (i6 < length && charSequence.charAt(i3) == this.f33798a[i6]) {
                    i6++;
                    i3++;
                }
                if (i6 == length) {
                    return i2 - this.f33802e;
                }
            }
            i2 = i4;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        int a2 = a((CharSequence) str);
        if (a2 != -1) {
            String a3 = a(this.f33798a, this.f33805h, this.f33802e, a2);
            this.f33802e += a2;
            return a3;
        } else if (this.f33800c - this.f33802e < str.length()) {
            return n();
        } else {
            int length = (this.f33800c - str.length()) + 1;
            char[] cArr = this.f33798a;
            String[] strArr = this.f33805h;
            int i2 = this.f33802e;
            String a4 = a(cArr, strArr, i2, length - i2);
            this.f33802e = length;
            return a4;
        }
    }

    public String a(char... cArr) {
        u();
        int i2 = this.f33802e;
        int i3 = this.f33800c;
        char[] cArr2 = this.f33798a;
        int i4 = i2;
        loop0:
        while (i4 < i3) {
            for (char c2 : cArr) {
                if (cArr2[i4] == c2) {
                    break loop0;
                }
            }
            i4++;
        }
        this.f33802e = i4;
        return i4 > i2 ? a(this.f33798a, this.f33805h, i2, i4 - i2) : "";
    }

    public void a() {
        Reader reader = this.f33799b;
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.f33799b = null;
                this.f33798a = null;
                this.f33805h = null;
                throw th;
            }
            this.f33799b = null;
            this.f33798a = null;
            this.f33805h = null;
        }
    }

    public int b() {
        return this.f33803f + this.f33802e;
    }

    public String b(char c2) {
        int a2 = a(c2);
        if (a2 == -1) {
            return n();
        }
        String a3 = a(this.f33798a, this.f33805h, this.f33802e, a2);
        this.f33802e += a2;
        return a3;
    }

    /* access modifiers changed from: package-private */
    public String b(char... cArr) {
        u();
        int i2 = this.f33802e;
        int i3 = this.f33800c;
        char[] cArr2 = this.f33798a;
        int i4 = i2;
        while (i4 < i3 && Arrays.binarySearch(cArr, cArr2[i4]) < 0) {
            i4++;
        }
        this.f33802e = i4;
        return i4 > i2 ? a(this.f33798a, this.f33805h, i2, i4 - i2) : "";
    }

    /* access modifiers changed from: package-private */
    public boolean b(String str) {
        u();
        int length = str.length();
        if (length > this.f33800c - this.f33802e) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != this.f33798a[this.f33802e + i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean c() {
        u();
        return this.f33802e >= this.f33800c;
    }

    /* access modifiers changed from: package-private */
    public boolean c(char c2) {
        return !c() && this.f33798a[this.f33802e] == c2;
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        u();
        int length = str.length();
        if (length > this.f33800c - this.f33802e) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (Character.toUpperCase(str.charAt(i2)) != Character.toUpperCase(this.f33798a[this.f33802e + i2])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean c(char... cArr) {
        if (c()) {
            return false;
        }
        u();
        char c2 = this.f33798a[this.f33802e];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public char d() {
        u();
        if (v()) {
            return 65535;
        }
        return this.f33798a[this.f33802e];
    }

    /* access modifiers changed from: package-private */
    public boolean d(String str) {
        u();
        if (!b(str)) {
            return false;
        }
        this.f33802e += str.length();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean d(char[] cArr) {
        u();
        return !c() && Arrays.binarySearch(cArr, this.f33798a[this.f33802e]) >= 0;
    }

    /* access modifiers changed from: package-private */
    public char e() {
        u();
        char c2 = v() ? 65535 : this.f33798a[this.f33802e];
        this.f33802e++;
        return c2;
    }

    /* access modifiers changed from: package-private */
    public boolean e(String str) {
        if (!c(str)) {
            return false;
        }
        this.f33802e += str.length();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        int i2 = this.f33802e;
        if (i2 >= 1) {
            this.f33802e = i2 - 1;
            return;
        }
        throw new UncheckedIOException(new IOException("No buffer left to unconsume"));
    }

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        return a((CharSequence) str.toLowerCase(Locale.ENGLISH)) > -1 || a((CharSequence) str.toUpperCase(Locale.ENGLISH)) > -1;
    }

    public void g() {
        this.f33802e++;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (this.f33800c - this.f33802e < 1024) {
            this.f33801d = 0;
        }
        u();
        this.f33804g = this.f33802e;
    }

    /* access modifiers changed from: package-private */
    public void i() {
        this.f33804g = -1;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        int i2 = this.f33804g;
        if (i2 != -1) {
            this.f33802e = i2;
            i();
            return;
        }
        throw new UncheckedIOException(new IOException("Mark invalid"));
    }

    /* access modifiers changed from: package-private */
    public String k() {
        int i2 = this.f33802e;
        int i3 = this.f33800c;
        char[] cArr = this.f33798a;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == '&' || c2 == '<') {
                break;
            }
            i4++;
        }
        this.f33802e = i4;
        return i4 > i2 ? a(this.f33798a, this.f33805h, i2, i4 - i2) : "";
    }

    /* access modifiers changed from: package-private */
    public String l() {
        int i2 = this.f33802e;
        int i3 = this.f33800c;
        char[] cArr = this.f33798a;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == '<') {
                break;
            }
            i4++;
        }
        this.f33802e = i4;
        return i4 > i2 ? a(this.f33798a, this.f33805h, i2, i4 - i2) : "";
    }

    /* access modifiers changed from: package-private */
    public String m() {
        u();
        int i2 = this.f33802e;
        int i3 = this.f33800c;
        char[] cArr = this.f33798a;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == ' ' || c2 == '/' || c2 == '<' || c2 == '>' || c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13) {
                break;
            }
            i4++;
        }
        this.f33802e = i4;
        return i4 > i2 ? a(this.f33798a, this.f33805h, i2, i4 - i2) : "";
    }

    /* access modifiers changed from: package-private */
    public String n() {
        u();
        char[] cArr = this.f33798a;
        String[] strArr = this.f33805h;
        int i2 = this.f33802e;
        String a2 = a(cArr, strArr, i2, this.f33800c - i2);
        this.f33802e = this.f33800c;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public String o() {
        char c2;
        u();
        int i2 = this.f33802e;
        while (true) {
            int i3 = this.f33802e;
            if (i3 < this.f33800c && (((c2 = this.f33798a[i3]) >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2)))) {
                this.f33802e++;
            }
        }
        return a(this.f33798a, this.f33805h, i2, this.f33802e - i2);
    }

    /* access modifiers changed from: package-private */
    public String p() {
        char c2;
        u();
        int i2 = this.f33802e;
        while (true) {
            int i3 = this.f33802e;
            if (i3 < this.f33800c && (((c2 = this.f33798a[i3]) >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2)))) {
                this.f33802e++;
            }
        }
        while (!v() && (r1 = this.f33798a[r2]) >= '0' && r1 <= '9') {
            this.f33802e = (r2 = this.f33802e) + 1;
        }
        return a(this.f33798a, this.f33805h, i2, this.f33802e - i2);
    }

    /* access modifiers changed from: package-private */
    public String q() {
        int i2;
        char c2;
        u();
        int i3 = this.f33802e;
        while (true) {
            i2 = this.f33802e;
            if (i2 < this.f33800c && (((c2 = this.f33798a[i2]) >= '0' && c2 <= '9') || ((c2 >= 'A' && c2 <= 'F') || (c2 >= 'a' && c2 <= 'f')))) {
                this.f33802e = i2 + 1;
            }
        }
        return a(this.f33798a, this.f33805h, i3, i2 - i3);
    }

    /* access modifiers changed from: package-private */
    public String r() {
        int i2;
        char c2;
        u();
        int i3 = this.f33802e;
        while (true) {
            i2 = this.f33802e;
            if (i2 < this.f33800c && (c2 = this.f33798a[i2]) >= '0' && c2 <= '9') {
                this.f33802e = i2 + 1;
            }
        }
        return a(this.f33798a, this.f33805h, i3, i2 - i3);
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        if (c()) {
            return false;
        }
        char c2 = this.f33798a[this.f33802e];
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r3.f33798a[r3.f33802e];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean t() {
        /*
            r3 = this;
            boolean r0 = r3.c()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            char[] r0 = r3.f33798a
            int r2 = r3.f33802e
            char r0 = r0[r2]
            r2 = 48
            if (r0 < r2) goto L_0x0017
            r2 = 57
            if (r0 > r2) goto L_0x0017
            r1 = 1
        L_0x0017:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.a.t():boolean");
    }

    public String toString() {
        if (this.f33800c - this.f33802e < 0) {
            return "";
        }
        char[] cArr = this.f33798a;
        int i2 = this.f33802e;
        return new String(cArr, i2, this.f33800c - i2);
    }
}
