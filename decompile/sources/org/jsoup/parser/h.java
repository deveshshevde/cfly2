package org.jsoup.parser;

import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.util.Arrays;
import org.jsoup.helper.c;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Token;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

final class h {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f33853a = {8364, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f33854i;

    /* renamed from: b  reason: collision with root package name */
    StringBuilder f33855b = new StringBuilder(1024);

    /* renamed from: c  reason: collision with root package name */
    Token.h f33856c;

    /* renamed from: d  reason: collision with root package name */
    Token.g f33857d = new Token.g();

    /* renamed from: e  reason: collision with root package name */
    Token.f f33858e = new Token.f();

    /* renamed from: f  reason: collision with root package name */
    Token.b f33859f = new Token.b();

    /* renamed from: g  reason: collision with root package name */
    Token.d f33860g = new Token.d();

    /* renamed from: h  reason: collision with root package name */
    Token.c f33861h = new Token.c();

    /* renamed from: j  reason: collision with root package name */
    private final a f33862j;

    /* renamed from: k  reason: collision with root package name */
    private final ParseErrorList f33863k;

    /* renamed from: l  reason: collision with root package name */
    private TokeniserState f33864l = TokeniserState.Data;

    /* renamed from: m  reason: collision with root package name */
    private Token f33865m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f33866n = false;

    /* renamed from: o  reason: collision with root package name */
    private String f33867o = null;

    /* renamed from: p  reason: collision with root package name */
    private StringBuilder f33868p = new StringBuilder(1024);

    /* renamed from: q  reason: collision with root package name */
    private String f33869q;

    /* renamed from: r  reason: collision with root package name */
    private final int[] f33870r = new int[1];

    /* renamed from: s  reason: collision with root package name */
    private final int[] f33871s = new int[2];

    static {
        char[] cArr = {9, 10, 13, 12, ' ', '<', '&'};
        f33854i = cArr;
        Arrays.sort(cArr);
    }

    h(a aVar, ParseErrorList parseErrorList) {
        this.f33862j = aVar;
        this.f33863k = parseErrorList;
    }

    private void c(String str) {
        if (this.f33863k.a()) {
            this.f33863k.add(new c(this.f33862j.b(), "Invalid character reference: %s", str));
        }
    }

    /* access modifiers changed from: package-private */
    public Token.h a(boolean z2) {
        Token.h o2 = z2 ? this.f33857d.b() : this.f33858e.b();
        this.f33856c = o2;
        return o2;
    }

    /* access modifiers changed from: package-private */
    public Token a() {
        while (!this.f33866n) {
            this.f33864l.a(this, this.f33862j);
        }
        StringBuilder sb = this.f33868p;
        if (sb.length() != 0) {
            String sb2 = sb.toString();
            sb.delete(0, sb.length());
            this.f33867o = null;
            return this.f33859f.a(sb2);
        }
        String str = this.f33867o;
        if (str != null) {
            Token.b a2 = this.f33859f.a(str);
            this.f33867o = null;
            return a2;
        }
        this.f33866n = false;
        return this.f33865m;
    }

    /* access modifiers changed from: package-private */
    public void a(char c2) {
        a(String.valueOf(c2));
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (this.f33867o == null) {
            this.f33867o = str;
            return;
        }
        if (this.f33868p.length() == 0) {
            this.f33868p.append(this.f33867o);
        }
        this.f33868p.append(str);
    }

    /* access modifiers changed from: package-private */
    public void a(Token token) {
        c.b(this.f33866n);
        this.f33865m = token;
        this.f33866n = true;
        if (token.f33725a == Token.TokenType.StartTag) {
            this.f33869q = ((Token.g) token).f33742b;
        } else if (token.f33725a == Token.TokenType.EndTag && ((Token.f) token).f33745e != null) {
            b("Attributes incorrectly present on end tag");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TokeniserState tokeniserState) {
        this.f33864l = tokeniserState;
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr) {
        a(new String(iArr, 0, iArr.length));
    }

    /* access modifiers changed from: package-private */
    public int[] a(Character ch2, boolean z2) {
        int i2;
        if (this.f33862j.c()) {
            return null;
        }
        if ((ch2 != null && ch2.charValue() == this.f33862j.d()) || this.f33862j.d(f33854i)) {
            return null;
        }
        int[] iArr = this.f33870r;
        this.f33862j.h();
        if (this.f33862j.d("#")) {
            boolean e2 = this.f33862j.e("X");
            a aVar = this.f33862j;
            String q2 = e2 ? aVar.q() : aVar.r();
            if (q2.length() == 0) {
                c("numeric reference with no numerals");
            } else {
                this.f33862j.i();
                if (!this.f33862j.d(";")) {
                    c("missing semicolon");
                }
                try {
                    i2 = Integer.valueOf(q2, e2 ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i2 = -1;
                }
                if (i2 == -1 || ((i2 >= 55296 && i2 <= 57343) || i2 > 1114111)) {
                    c("character outside of valid range");
                    iArr[0] = 65533;
                    return iArr;
                }
                if (i2 >= 128) {
                    int[] iArr2 = f33853a;
                    if (i2 < iArr2.length + 128) {
                        c("character is not a valid unicode code point");
                        i2 = iArr2[i2 - 128];
                    }
                }
                iArr[0] = i2;
                return iArr;
            }
        } else {
            String p2 = this.f33862j.p();
            boolean c2 = this.f33862j.c(';');
            if (!(Entities.b(p2) || (Entities.a(p2) && c2))) {
                this.f33862j.j();
                if (c2) {
                    c("invalid named reference");
                }
                return null;
            } else if (!z2 || (!this.f33862j.s() && !this.f33862j.t() && !this.f33862j.c('=', '-', '_'))) {
                this.f33862j.i();
                if (!this.f33862j.d(";")) {
                    c("missing semicolon");
                }
                int a2 = Entities.a(p2, this.f33871s);
                if (a2 == 1) {
                    iArr[0] = this.f33871s[0];
                    return iArr;
                } else if (a2 == 2) {
                    return this.f33871s;
                } else {
                    c.b("Unexpected characters returned for " + p2);
                    return this.f33871s;
                }
            }
        }
        this.f33862j.j();
        return null;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f33856c.q();
        a((Token) this.f33856c);
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        if (this.f33863k.a()) {
            this.f33863k.add(new c(this.f33862j.b(), str));
        }
    }

    /* access modifiers changed from: package-private */
    public void b(TokeniserState tokeniserState) {
        this.f33862j.g();
        this.f33864l = tokeniserState;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f33861h.b();
    }

    /* access modifiers changed from: package-private */
    public void c(TokeniserState tokeniserState) {
        if (this.f33863k.a()) {
            this.f33863k.add(new c(this.f33862j.b(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f33862j.d()), tokeniserState));
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        a((Token) this.f33861h);
    }

    /* access modifiers changed from: package-private */
    public void d(TokeniserState tokeniserState) {
        if (this.f33863k.a()) {
            this.f33863k.add(new c(this.f33862j.b(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f33861h.b();
        this.f33861h.f33734b = true;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f33860g.b();
    }

    /* access modifiers changed from: package-private */
    public void g() {
        a((Token) this.f33860g);
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Token.a(this.f33855b);
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f33869q != null && this.f33856c.r().equalsIgnoreCase(this.f33869q);
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return this.f33869q;
    }
}
