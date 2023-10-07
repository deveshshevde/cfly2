package org.jsoup.parser;

import com.amap.api.mapcore.util.dt;
import java.util.ArrayList;
import oh.c;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.f;
import org.jsoup.nodes.j;
import org.jsoup.parser.Token;

enum HtmlTreeBuilderState {
    Initial {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (HtmlTreeBuilderState.b(token)) {
                return true;
            }
            if (token.i()) {
                bVar.a(token.j());
            } else if (token.c()) {
                Token.d d2 = token.d();
                f fVar = new f(bVar.f33881p.a(d2.o()), d2.q(), d2.r());
                fVar.a_(d2.p());
                bVar.f().a((j) fVar);
                if (d2.s()) {
                    bVar.f().a(Document.QuirksMode.quirks);
                }
                bVar.a(BeforeHtml);
            } else {
                bVar.a(BeforeHtml);
                return bVar.a(token);
            }
            return true;
        }
    },
    BeforeHtml {
        private boolean b(Token token, b bVar) {
            bVar.a("html");
            bVar.a(BeforeHead);
            return bVar.a(token);
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.c()) {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            } else if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (HtmlTreeBuilderState.b(token)) {
                bVar.a(token.m());
                return true;
            } else if (token.e() && token.f().s().equals("html")) {
                bVar.a(token.f());
                bVar.a(BeforeHead);
                return true;
            } else if (token.g() && c.b(token.h().s(), a.f33702e)) {
                return b(token, bVar);
            } else {
                if (!token.g()) {
                    return b(token, bVar);
                }
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            }
        }
    },
    BeforeHead {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (HtmlTreeBuilderState.b(token)) {
                bVar.a(token.m());
                return true;
            } else if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (token.c()) {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            } else if (token.e() && token.f().s().equals("html")) {
                return InBody.a(token, bVar);
            } else {
                if (token.e() && token.f().s().equals("head")) {
                    bVar.g(bVar.a(token.f()));
                    bVar.a(InHead);
                    return true;
                } else if (token.g() && c.b(token.h().s(), a.f33702e)) {
                    bVar.l("head");
                    return bVar.a(token);
                } else if (token.g()) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                } else {
                    bVar.l("head");
                    return bVar.a(token);
                }
            }
        }
    },
    InHead {
        private boolean a(Token token, i iVar) {
            iVar.m("head");
            return iVar.a(token);
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.b(token)) {
                bVar.a(token.m());
                return true;
            }
            int i2 = AnonymousClass24.f33697a[token.f33725a.ordinal()];
            if (i2 == 1) {
                bVar.a(token.j());
            } else if (i2 != 2) {
                if (i2 == 3) {
                    Token.g f2 = token.f();
                    String s2 = f2.s();
                    if (s2.equals("html")) {
                        return InBody.a(token, bVar);
                    }
                    if (c.b(s2, a.f33698a)) {
                        Element b2 = bVar.b(f2);
                        if (s2.equals("base") && b2.b("href")) {
                            bVar.a(b2);
                        }
                    } else if (s2.equals("meta")) {
                        bVar.b(f2);
                    } else if (s2.equals("title")) {
                        HtmlTreeBuilderState.c(f2, bVar);
                    } else if (c.b(s2, a.f33699b)) {
                        HtmlTreeBuilderState.d(f2, bVar);
                    } else if (s2.equals("noscript")) {
                        bVar.a(f2);
                        htmlTreeBuilderState = InHeadNoscript;
                    } else if (s2.equals("script")) {
                        bVar.f33876k.a(TokeniserState.ScriptData);
                        bVar.c();
                        bVar.a(Text);
                        bVar.a(f2);
                    } else if (!s2.equals("head")) {
                        return a(token, (i) bVar);
                    } else {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                } else if (i2 != 4) {
                    return a(token, (i) bVar);
                } else {
                    String s3 = token.h().s();
                    if (s3.equals("head")) {
                        bVar.i();
                        htmlTreeBuilderState = AfterHead;
                    } else if (c.b(s3, a.f33700c)) {
                        return a(token, (i) bVar);
                    } else {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                }
                bVar.a(htmlTreeBuilderState);
            } else {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            }
            return true;
        }
    },
    InHeadNoscript {
        private boolean b(Token token, b bVar) {
            bVar.b((HtmlTreeBuilderState) this);
            bVar.a(new Token.b().a(token.toString()));
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.c()) {
                bVar.b((HtmlTreeBuilderState) this);
                return true;
            } else if (token.e() && token.f().s().equals("html")) {
                return bVar.a(token, InBody);
            } else {
                if (token.g() && token.h().s().equals("noscript")) {
                    bVar.i();
                    bVar.a(InHead);
                    return true;
                } else if (HtmlTreeBuilderState.b(token) || token.i() || (token.e() && c.b(token.f().s(), a.f33703f))) {
                    return bVar.a(token, InHead);
                } else {
                    if (token.g() && token.h().s().equals("br")) {
                        return b(token, bVar);
                    }
                    if ((!token.e() || !c.b(token.f().s(), a.K)) && !token.g()) {
                        return b(token, bVar);
                    }
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
            }
        }
    },
    AfterHead {
        private boolean b(Token token, b bVar) {
            bVar.l("body");
            bVar.a(true);
            return bVar.a(token);
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.b(token)) {
                bVar.a(token.m());
                return true;
            } else if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (token.c()) {
                bVar.b((HtmlTreeBuilderState) this);
                return true;
            } else {
                if (token.e()) {
                    Token.g f2 = token.f();
                    String s2 = f2.s();
                    if (s2.equals("html")) {
                        return bVar.a(token, InBody);
                    }
                    if (s2.equals("body")) {
                        bVar.a(f2);
                        bVar.a(false);
                        htmlTreeBuilderState = InBody;
                    } else if (s2.equals("frameset")) {
                        bVar.a(f2);
                        htmlTreeBuilderState = InFrameset;
                    } else if (c.b(s2, a.f33704g)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        Element o2 = bVar.o();
                        bVar.c(o2);
                        bVar.a(token, InHead);
                        bVar.e(o2);
                        return true;
                    } else if (s2.equals("head")) {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                    bVar.a(htmlTreeBuilderState);
                    return true;
                } else if (token.g() && !c.b(token.h().s(), a.f33701d)) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
                b(token, bVar);
                return true;
            }
        }
    },
    InBody {
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x035f, code lost:
            if (r1.b(r2).c("type").equalsIgnoreCase("hidden") == false) goto L_0x0361;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x0361, code lost:
            r1.a(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x0379, code lost:
            r3 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:177:0x037c, code lost:
            r19.w();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x0382, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:234:0x04cd, code lost:
            if (r1.g("p") != false) goto L_0x04cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:235:0x04cf, code lost:
            r1.m("p");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:257:0x054e, code lost:
            if (r1.g("p") != false) goto L_0x04cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:263:0x056d, code lost:
            r19.w();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:264:0x0570, code lost:
            r1.i(r1.a(r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:284:0x05f0, code lost:
            r1.a(false);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:285:0x05f3, code lost:
            org.jsoup.parser.HtmlTreeBuilderState.b(r2, r1);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean c(org.jsoup.parser.Token r18, org.jsoup.parser.b r19) {
            /*
                r17 = this;
                r0 = r17
                r1 = r19
                org.jsoup.parser.Token$g r2 = r18.f()
                java.lang.String r3 = r2.s()
                r3.hashCode()
                int r4 = r3.hashCode()
                java.lang.String r5 = "isindex"
                java.lang.String r6 = "input"
                java.lang.String r7 = "svg"
                java.lang.String r8 = "nobr"
                java.lang.String r9 = "form"
                java.lang.String r10 = "body"
                java.lang.String r11 = "li"
                java.lang.String r12 = "hr"
                java.lang.String r13 = "option"
                java.lang.String r15 = "button"
                r16 = -1
                java.lang.String r14 = "a"
                r0 = 0
                switch(r4) {
                    case -1644953643: goto L_0x01f7;
                    case -1377687758: goto L_0x01ed;
                    case -1191214428: goto L_0x01e1;
                    case -1010136971: goto L_0x01d7;
                    case -1003243718: goto L_0x01cb;
                    case -906021636: goto L_0x01bf;
                    case -80773204: goto L_0x01b3;
                    case 97: goto L_0x01a9;
                    case 3200: goto L_0x019b;
                    case 3216: goto L_0x018d;
                    case 3273: goto L_0x017f;
                    case 3274: goto L_0x0171;
                    case 3275: goto L_0x0163;
                    case 3276: goto L_0x0155;
                    case 3277: goto L_0x0147;
                    case 3278: goto L_0x0139;
                    case 3338: goto L_0x012d;
                    case 3453: goto L_0x0121;
                    case 3646: goto L_0x0113;
                    case 3650: goto L_0x0105;
                    case 111267: goto L_0x00f7;
                    case 114276: goto L_0x00eb;
                    case 118811: goto L_0x00dd;
                    case 3029410: goto L_0x00d1;
                    case 3148996: goto L_0x00c5;
                    case 3213227: goto L_0x00b7;
                    case 3344136: goto L_0x00a9;
                    case 3386833: goto L_0x009d;
                    case 3536714: goto L_0x008f;
                    case 100313435: goto L_0x0081;
                    case 100358090: goto L_0x0075;
                    case 110115790: goto L_0x0067;
                    case 181975684: goto L_0x0059;
                    case 1973234167: goto L_0x004b;
                    case 2091304424: goto L_0x003f;
                    case 2115613112: goto L_0x0031;
                    default: goto L_0x002f;
                }
            L_0x002f:
                goto L_0x0202
            L_0x0031:
                java.lang.String r4 = "noembed"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x003b
                goto L_0x0202
            L_0x003b:
                r16 = 35
                goto L_0x0202
            L_0x003f:
                boolean r4 = r3.equals(r5)
                if (r4 != 0) goto L_0x0047
                goto L_0x0202
            L_0x0047:
                r16 = 34
                goto L_0x0202
            L_0x004b:
                java.lang.String r4 = "plaintext"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0055
                goto L_0x0202
            L_0x0055:
                r16 = 33
                goto L_0x0202
            L_0x0059:
                java.lang.String r4 = "listing"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0063
                goto L_0x0202
            L_0x0063:
                r16 = 32
                goto L_0x0202
            L_0x0067:
                java.lang.String r4 = "table"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0071
                goto L_0x0202
            L_0x0071:
                r16 = 31
                goto L_0x0202
            L_0x0075:
                boolean r4 = r3.equals(r6)
                if (r4 != 0) goto L_0x007d
                goto L_0x0202
            L_0x007d:
                r16 = 30
                goto L_0x0202
            L_0x0081:
                java.lang.String r4 = "image"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x008b
                goto L_0x0202
            L_0x008b:
                r16 = 29
                goto L_0x0202
            L_0x008f:
                java.lang.String r4 = "span"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0099
                goto L_0x0202
            L_0x0099:
                r16 = 28
                goto L_0x0202
            L_0x009d:
                boolean r4 = r3.equals(r8)
                if (r4 != 0) goto L_0x00a5
                goto L_0x0202
            L_0x00a5:
                r16 = 27
                goto L_0x0202
            L_0x00a9:
                java.lang.String r4 = "math"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x00b3
                goto L_0x0202
            L_0x00b3:
                r16 = 26
                goto L_0x0202
            L_0x00b7:
                java.lang.String r4 = "html"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x00c1
                goto L_0x0202
            L_0x00c1:
                r16 = 25
                goto L_0x0202
            L_0x00c5:
                boolean r4 = r3.equals(r9)
                if (r4 != 0) goto L_0x00cd
                goto L_0x0202
            L_0x00cd:
                r16 = 24
                goto L_0x0202
            L_0x00d1:
                boolean r4 = r3.equals(r10)
                if (r4 != 0) goto L_0x00d9
                goto L_0x0202
            L_0x00d9:
                r16 = 23
                goto L_0x0202
            L_0x00dd:
                java.lang.String r4 = "xmp"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x00e7
                goto L_0x0202
            L_0x00e7:
                r16 = 22
                goto L_0x0202
            L_0x00eb:
                boolean r4 = r3.equals(r7)
                if (r4 != 0) goto L_0x00f3
                goto L_0x0202
            L_0x00f3:
                r16 = 21
                goto L_0x0202
            L_0x00f7:
                java.lang.String r4 = "pre"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0101
                goto L_0x0202
            L_0x0101:
                r16 = 20
                goto L_0x0202
            L_0x0105:
                java.lang.String r4 = "rt"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x010f
                goto L_0x0202
            L_0x010f:
                r16 = 19
                goto L_0x0202
            L_0x0113:
                java.lang.String r4 = "rp"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x011d
                goto L_0x0202
            L_0x011d:
                r16 = 18
                goto L_0x0202
            L_0x0121:
                boolean r4 = r3.equals(r11)
                if (r4 != 0) goto L_0x0129
                goto L_0x0202
            L_0x0129:
                r16 = 17
                goto L_0x0202
            L_0x012d:
                boolean r4 = r3.equals(r12)
                if (r4 != 0) goto L_0x0135
                goto L_0x0202
            L_0x0135:
                r16 = 16
                goto L_0x0202
            L_0x0139:
                java.lang.String r4 = "h6"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0143
                goto L_0x0202
            L_0x0143:
                r16 = 15
                goto L_0x0202
            L_0x0147:
                java.lang.String r4 = "h5"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0151
                goto L_0x0202
            L_0x0151:
                r16 = 14
                goto L_0x0202
            L_0x0155:
                java.lang.String r4 = "h4"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x015f
                goto L_0x0202
            L_0x015f:
                r16 = 13
                goto L_0x0202
            L_0x0163:
                java.lang.String r4 = "h3"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x016d
                goto L_0x0202
            L_0x016d:
                r16 = 12
                goto L_0x0202
            L_0x0171:
                java.lang.String r4 = "h2"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x017b
                goto L_0x0202
            L_0x017b:
                r16 = 11
                goto L_0x0202
            L_0x017f:
                java.lang.String r4 = "h1"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0189
                goto L_0x0202
            L_0x0189:
                r16 = 10
                goto L_0x0202
            L_0x018d:
                java.lang.String r4 = "dt"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0197
                goto L_0x0202
            L_0x0197:
                r16 = 9
                goto L_0x0202
            L_0x019b:
                java.lang.String r4 = "dd"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x01a5
                goto L_0x0202
            L_0x01a5:
                r16 = 8
                goto L_0x0202
            L_0x01a9:
                boolean r4 = r3.equals(r14)
                if (r4 != 0) goto L_0x01b0
                goto L_0x0202
            L_0x01b0:
                r16 = 7
                goto L_0x0202
            L_0x01b3:
                java.lang.String r4 = "optgroup"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x01bc
                goto L_0x0202
            L_0x01bc:
                r16 = 6
                goto L_0x0202
            L_0x01bf:
                java.lang.String r4 = "select"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x01c8
                goto L_0x0202
            L_0x01c8:
                r16 = 5
                goto L_0x0202
            L_0x01cb:
                java.lang.String r4 = "textarea"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x01d4
                goto L_0x0202
            L_0x01d4:
                r16 = 4
                goto L_0x0202
            L_0x01d7:
                boolean r4 = r3.equals(r13)
                if (r4 != 0) goto L_0x01de
                goto L_0x0202
            L_0x01de:
                r16 = 3
                goto L_0x0202
            L_0x01e1:
                java.lang.String r4 = "iframe"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x01ea
                goto L_0x0202
            L_0x01ea:
                r16 = 2
                goto L_0x0202
            L_0x01ed:
                boolean r4 = r3.equals(r15)
                if (r4 != 0) goto L_0x01f4
                goto L_0x0202
            L_0x01f4:
                r16 = 1
                goto L_0x0202
            L_0x01f7:
                java.lang.String r4 = "frameset"
                boolean r4 = r3.equals(r4)
                if (r4 != 0) goto L_0x0200
                goto L_0x0202
            L_0x0200:
                r16 = 0
            L_0x0202:
                java.lang.String r4 = "p"
                switch(r16) {
                    case 0: goto L_0x0615;
                    case 1: goto L_0x05f8;
                    case 2: goto L_0x05ed;
                    case 3: goto L_0x05d7;
                    case 4: goto L_0x05ba;
                    case 5: goto L_0x0579;
                    case 6: goto L_0x05d7;
                    case 7: goto L_0x0552;
                    case 8: goto L_0x0509;
                    case 9: goto L_0x0509;
                    case 10: goto L_0x04e5;
                    case 11: goto L_0x04e5;
                    case 12: goto L_0x04e5;
                    case 13: goto L_0x04e5;
                    case 14: goto L_0x04e5;
                    case 15: goto L_0x04e5;
                    case 16: goto L_0x04d4;
                    case 17: goto L_0x048e;
                    case 18: goto L_0x046a;
                    case 19: goto L_0x046a;
                    case 20: goto L_0x0452;
                    case 21: goto L_0x0379;
                    case 22: goto L_0x0441;
                    case 23: goto L_0x03e9;
                    case 24: goto L_0x03cf;
                    case 25: goto L_0x0399;
                    case 26: goto L_0x0379;
                    case 27: goto L_0x0385;
                    case 28: goto L_0x0379;
                    case 29: goto L_0x0365;
                    case 30: goto L_0x0349;
                    case 31: goto L_0x0325;
                    case 32: goto L_0x0452;
                    case 33: goto L_0x030e;
                    case 34: goto L_0x0286;
                    case 35: goto L_0x0281;
                    default: goto L_0x0207;
                }
            L_0x0207:
                java.lang.String[] r5 = org.jsoup.parser.HtmlTreeBuilderState.a.f33711n
                boolean r5 = oh.c.b(r3, r5)
                if (r5 == 0) goto L_0x021c
                r19.w()
                r1.b((org.jsoup.parser.Token.g) r2)
            L_0x0215:
                r1.a((boolean) r0)
            L_0x0218:
                r3 = r17
                goto L_0x0382
            L_0x021c:
                java.lang.String[] r5 = org.jsoup.parser.HtmlTreeBuilderState.a.f33705h
                boolean r5 = oh.c.b(r3, r5)
                if (r5 == 0) goto L_0x0231
                boolean r0 = r1.g((java.lang.String) r4)
                if (r0 == 0) goto L_0x022d
                r1.m(r4)
            L_0x022d:
                r1.a((org.jsoup.parser.Token.g) r2)
                goto L_0x0218
            L_0x0231:
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.a.f33704g
                boolean r4 = oh.c.b(r3, r4)
                if (r4 == 0) goto L_0x0242
                org.jsoup.parser.HtmlTreeBuilderState r0 = InHead
                r2 = r18
                boolean r0 = r1.a((org.jsoup.parser.Token) r2, (org.jsoup.parser.HtmlTreeBuilderState) r0)
                return r0
            L_0x0242:
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.a.f33709l
                boolean r4 = oh.c.b(r3, r4)
                if (r4 == 0) goto L_0x0255
                r19.w()
                org.jsoup.nodes.Element r0 = r1.a((org.jsoup.parser.Token.g) r2)
                r1.i((org.jsoup.nodes.Element) r0)
                goto L_0x0218
            L_0x0255:
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.a.f33710m
                boolean r4 = oh.c.b(r3, r4)
                if (r4 == 0) goto L_0x0267
                r19.w()
                r1.a((org.jsoup.parser.Token.g) r2)
                r19.y()
                goto L_0x0215
            L_0x0267:
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.a.f33712o
                boolean r4 = oh.c.b(r3, r4)
                if (r4 == 0) goto L_0x0273
                r1.b((org.jsoup.parser.Token.g) r2)
                goto L_0x0218
            L_0x0273:
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.a.f33714q
                boolean r3 = oh.c.b(r3, r4)
                if (r3 == 0) goto L_0x0379
                r3 = r17
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                return r0
            L_0x0281:
                r3 = r17
                r15 = 1
                goto L_0x05f3
            L_0x0286:
                r3 = r17
                r15 = 1
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                org.jsoup.nodes.h r4 = r19.q()
                if (r4 == 0) goto L_0x0293
                return r0
            L_0x0293:
                r1.l(r9)
                org.jsoup.nodes.b r0 = r2.f33745e
                java.lang.String r4 = "action"
                boolean r0 = r0.e(r4)
                if (r0 == 0) goto L_0x02ad
                org.jsoup.nodes.h r0 = r19.q()
                org.jsoup.nodes.b r7 = r2.f33745e
                java.lang.String r7 = r7.c(r4)
                r0.a((java.lang.String) r4, (java.lang.String) r7)
            L_0x02ad:
                r1.l(r12)
                java.lang.String r0 = "label"
                r1.l(r0)
                org.jsoup.nodes.b r4 = r2.f33745e
                java.lang.String r7 = "prompt"
                boolean r4 = r4.e(r7)
                if (r4 == 0) goto L_0x02c6
                org.jsoup.nodes.b r4 = r2.f33745e
                java.lang.String r4 = r4.c(r7)
                goto L_0x02c8
            L_0x02c6:
                java.lang.String r4 = "This is a searchable index. Enter search keywords: "
            L_0x02c8:
                org.jsoup.parser.Token$b r7 = new org.jsoup.parser.Token$b
                r7.<init>()
                org.jsoup.parser.Token$b r4 = r7.a(r4)
                r1.a((org.jsoup.parser.Token) r4)
                org.jsoup.nodes.b r4 = new org.jsoup.nodes.b
                r4.<init>()
                org.jsoup.nodes.b r2 = r2.f33745e
                java.util.Iterator r2 = r2.iterator()
            L_0x02df:
                boolean r7 = r2.hasNext()
                if (r7 == 0) goto L_0x02fb
                java.lang.Object r7 = r2.next()
                org.jsoup.nodes.a r7 = (org.jsoup.nodes.a) r7
                java.lang.String r8 = r7.getKey()
                java.lang.String[] r10 = org.jsoup.parser.HtmlTreeBuilderState.a.f33713p
                boolean r8 = oh.c.b(r8, r10)
                if (r8 != 0) goto L_0x02df
                r4.a((org.jsoup.nodes.a) r7)
                goto L_0x02df
            L_0x02fb:
                java.lang.String r2 = "name"
                r4.b(r2, r5)
                r1.a((java.lang.String) r6, (org.jsoup.nodes.b) r4)
                r1.m(r0)
                r1.l(r12)
                r1.m(r9)
                goto L_0x0382
            L_0x030e:
                r3 = r17
                r15 = 1
                boolean r0 = r1.g((java.lang.String) r4)
                if (r0 == 0) goto L_0x031a
                r1.m(r4)
            L_0x031a:
                r1.a((org.jsoup.parser.Token.g) r2)
                org.jsoup.parser.h r0 = r1.f33876k
                org.jsoup.parser.TokeniserState r1 = org.jsoup.parser.TokeniserState.PLAINTEXT
                r0.a((org.jsoup.parser.TokeniserState) r1)
                goto L_0x0382
            L_0x0325:
                r3 = r17
                r15 = 1
                org.jsoup.nodes.Document r5 = r19.f()
                org.jsoup.nodes.Document$QuirksMode r5 = r5.k()
                org.jsoup.nodes.Document$QuirksMode r6 = org.jsoup.nodes.Document.QuirksMode.quirks
                if (r5 == r6) goto L_0x033d
                boolean r5 = r1.g((java.lang.String) r4)
                if (r5 == 0) goto L_0x033d
                r1.m(r4)
            L_0x033d:
                r1.a((org.jsoup.parser.Token.g) r2)
                r1.a((boolean) r0)
                org.jsoup.parser.HtmlTreeBuilderState r0 = InTable
            L_0x0345:
                r1.a((org.jsoup.parser.HtmlTreeBuilderState) r0)
                goto L_0x0382
            L_0x0349:
                r3 = r17
                r15 = 1
                r19.w()
                org.jsoup.nodes.Element r2 = r1.b((org.jsoup.parser.Token.g) r2)
                java.lang.String r4 = "type"
                java.lang.String r2 = r2.c((java.lang.String) r4)
                java.lang.String r4 = "hidden"
                boolean r2 = r2.equalsIgnoreCase(r4)
                if (r2 != 0) goto L_0x0382
            L_0x0361:
                r1.a((boolean) r0)
                goto L_0x0382
            L_0x0365:
                r3 = r17
                r15 = 1
                org.jsoup.nodes.Element r0 = r1.b((java.lang.String) r7)
                if (r0 != 0) goto L_0x037f
                java.lang.String r0 = "img"
                org.jsoup.parser.Token$h r0 = r2.a((java.lang.String) r0)
                boolean r0 = r1.a((org.jsoup.parser.Token) r0)
                return r0
            L_0x0379:
                r3 = r17
                r15 = 1
            L_0x037c:
                r19.w()
            L_0x037f:
                r1.a((org.jsoup.parser.Token.g) r2)
            L_0x0382:
                r4 = 1
                goto L_0x066a
            L_0x0385:
                r3 = r17
                r15 = 1
                r19.w()
                boolean r0 = r1.e((java.lang.String) r8)
                if (r0 == 0) goto L_0x0570
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                r1.m(r8)
                goto L_0x056d
            L_0x0399:
                r3 = r17
                r15 = 1
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                java.util.ArrayList r1 = r19.j()
                java.lang.Object r0 = r1.get(r0)
                org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
                org.jsoup.nodes.b r1 = r2.u()
                java.util.Iterator r1 = r1.iterator()
            L_0x03b1:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0382
                java.lang.Object r2 = r1.next()
                org.jsoup.nodes.a r2 = (org.jsoup.nodes.a) r2
                java.lang.String r4 = r2.getKey()
                boolean r4 = r0.b((java.lang.String) r4)
                if (r4 != 0) goto L_0x03b1
                org.jsoup.nodes.b r4 = r0.p()
                r4.a((org.jsoup.nodes.a) r2)
                goto L_0x03b1
            L_0x03cf:
                r3 = r17
                r15 = 1
                org.jsoup.nodes.h r5 = r19.q()
                if (r5 == 0) goto L_0x03dc
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                return r0
            L_0x03dc:
                boolean r0 = r1.g((java.lang.String) r4)
                if (r0 == 0) goto L_0x03e5
                r1.m(r4)
            L_0x03e5:
                r1.a((org.jsoup.parser.Token.g) r2, (boolean) r15)
                goto L_0x0382
            L_0x03e9:
                r3 = r17
                r15 = 1
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                java.util.ArrayList r4 = r19.j()
                int r5 = r4.size()
                if (r5 == r15) goto L_0x0440
                int r5 = r4.size()
                r6 = 2
                if (r5 <= r6) goto L_0x0411
                java.lang.Object r5 = r4.get(r15)
                org.jsoup.nodes.Element r5 = (org.jsoup.nodes.Element) r5
                java.lang.String r5 = r5.r()
                boolean r5 = r5.equals(r10)
                if (r5 != 0) goto L_0x0411
                goto L_0x0440
            L_0x0411:
                r1.a((boolean) r0)
                java.lang.Object r0 = r4.get(r15)
                org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
                org.jsoup.nodes.b r1 = r2.u()
                java.util.Iterator r1 = r1.iterator()
            L_0x0422:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x0382
                java.lang.Object r2 = r1.next()
                org.jsoup.nodes.a r2 = (org.jsoup.nodes.a) r2
                java.lang.String r4 = r2.getKey()
                boolean r4 = r0.b((java.lang.String) r4)
                if (r4 != 0) goto L_0x0422
                org.jsoup.nodes.b r4 = r0.p()
                r4.a((org.jsoup.nodes.a) r2)
                goto L_0x0422
            L_0x0440:
                return r0
            L_0x0441:
                r3 = r17
                r15 = 1
                boolean r5 = r1.g((java.lang.String) r4)
                if (r5 == 0) goto L_0x044d
                r1.m(r4)
            L_0x044d:
                r19.w()
                goto L_0x05f0
            L_0x0452:
                r3 = r17
                r15 = 1
                boolean r5 = r1.g((java.lang.String) r4)
                if (r5 == 0) goto L_0x045e
                r1.m(r4)
            L_0x045e:
                r1.a((org.jsoup.parser.Token.g) r2)
                org.jsoup.parser.a r2 = r1.f33875j
                java.lang.String r4 = "\n"
                r2.d((java.lang.String) r4)
                goto L_0x0361
            L_0x046a:
                r3 = r17
                r15 = 1
                java.lang.String r0 = "ruby"
                boolean r4 = r1.e((java.lang.String) r0)
                if (r4 == 0) goto L_0x0382
                r19.t()
                org.jsoup.nodes.Element r4 = r19.A()
                java.lang.String r4 = r4.r()
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x037f
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                r1.d((java.lang.String) r0)
                goto L_0x037f
            L_0x048e:
                r3 = r17
                r15 = 1
                r1.a((boolean) r0)
                java.util.ArrayList r0 = r19.j()
                int r5 = r0.size()
                int r5 = r5 - r15
            L_0x049d:
                if (r5 <= 0) goto L_0x04c9
                java.lang.Object r6 = r0.get(r5)
                org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
                java.lang.String r7 = r6.r()
                boolean r7 = r7.equals(r11)
                if (r7 == 0) goto L_0x04b3
                r1.m(r11)
                goto L_0x04c9
            L_0x04b3:
                boolean r7 = r1.h((org.jsoup.nodes.Element) r6)
                if (r7 == 0) goto L_0x04c6
                java.lang.String r6 = r6.r()
                java.lang.String[] r7 = org.jsoup.parser.HtmlTreeBuilderState.a.f33707j
                boolean r6 = oh.c.b(r6, r7)
                if (r6 != 0) goto L_0x04c6
                goto L_0x04c9
            L_0x04c6:
                int r5 = r5 + -1
                goto L_0x049d
            L_0x04c9:
                boolean r0 = r1.g((java.lang.String) r4)
                if (r0 == 0) goto L_0x037f
            L_0x04cf:
                r1.m(r4)
                goto L_0x037f
            L_0x04d4:
                r3 = r17
                r15 = 1
                boolean r5 = r1.g((java.lang.String) r4)
                if (r5 == 0) goto L_0x04e0
                r1.m(r4)
            L_0x04e0:
                r1.b((org.jsoup.parser.Token.g) r2)
                goto L_0x0361
            L_0x04e5:
                r3 = r17
                r15 = 1
                boolean r0 = r1.g((java.lang.String) r4)
                if (r0 == 0) goto L_0x04f1
                r1.m(r4)
            L_0x04f1:
                org.jsoup.nodes.Element r0 = r19.A()
                java.lang.String r0 = r0.r()
                java.lang.String[] r4 = org.jsoup.parser.HtmlTreeBuilderState.a.f33706i
                boolean r0 = oh.c.b(r0, r4)
                if (r0 == 0) goto L_0x037f
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                r19.i()
                goto L_0x037f
            L_0x0509:
                r3 = r17
                r15 = 1
                r1.a((boolean) r0)
                java.util.ArrayList r0 = r19.j()
                int r5 = r0.size()
                int r5 = r5 - r15
            L_0x0518:
                if (r5 <= 0) goto L_0x054a
                java.lang.Object r6 = r0.get(r5)
                org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
                java.lang.String r7 = r6.r()
                java.lang.String[] r8 = org.jsoup.parser.HtmlTreeBuilderState.a.f33708k
                boolean r7 = oh.c.b(r7, r8)
                if (r7 == 0) goto L_0x0534
                java.lang.String r0 = r6.r()
                r1.m(r0)
                goto L_0x054a
            L_0x0534:
                boolean r7 = r1.h((org.jsoup.nodes.Element) r6)
                if (r7 == 0) goto L_0x0547
                java.lang.String r6 = r6.r()
                java.lang.String[] r7 = org.jsoup.parser.HtmlTreeBuilderState.a.f33707j
                boolean r6 = oh.c.b(r6, r7)
                if (r6 != 0) goto L_0x0547
                goto L_0x054a
            L_0x0547:
                int r5 = r5 + -1
                goto L_0x0518
            L_0x054a:
                boolean r0 = r1.g((java.lang.String) r4)
                if (r0 == 0) goto L_0x037f
                goto L_0x04cf
            L_0x0552:
                r3 = r17
                r15 = 1
                org.jsoup.nodes.Element r0 = r1.k((java.lang.String) r14)
                if (r0 == 0) goto L_0x056d
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                r1.m(r14)
                org.jsoup.nodes.Element r0 = r1.b((java.lang.String) r14)
                if (r0 == 0) goto L_0x056d
                r1.j((org.jsoup.nodes.Element) r0)
                r1.e((org.jsoup.nodes.Element) r0)
            L_0x056d:
                r19.w()
            L_0x0570:
                org.jsoup.nodes.Element r0 = r1.a((org.jsoup.parser.Token.g) r2)
                r1.i((org.jsoup.nodes.Element) r0)
                goto L_0x0382
            L_0x0579:
                r3 = r17
                r15 = 1
                r19.w()
                r1.a((org.jsoup.parser.Token.g) r2)
                r1.a((boolean) r0)
                org.jsoup.parser.HtmlTreeBuilderState r0 = r19.b()
                org.jsoup.parser.HtmlTreeBuilderState r2 = InTable
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x05b6
                org.jsoup.parser.HtmlTreeBuilderState r2 = InCaption
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x05b6
                org.jsoup.parser.HtmlTreeBuilderState r2 = InTableBody
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x05b6
                org.jsoup.parser.HtmlTreeBuilderState r2 = InRow
                boolean r2 = r0.equals(r2)
                if (r2 != 0) goto L_0x05b6
                org.jsoup.parser.HtmlTreeBuilderState r2 = InCell
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x05b2
                goto L_0x05b6
            L_0x05b2:
                org.jsoup.parser.HtmlTreeBuilderState r0 = InSelect
                goto L_0x0345
            L_0x05b6:
                org.jsoup.parser.HtmlTreeBuilderState r0 = InSelectInTable
                goto L_0x0345
            L_0x05ba:
                r3 = r17
                r15 = 1
                r1.a((org.jsoup.parser.Token.g) r2)
                boolean r2 = r2.t()
                if (r2 != 0) goto L_0x0382
                org.jsoup.parser.h r2 = r1.f33876k
                org.jsoup.parser.TokeniserState r4 = org.jsoup.parser.TokeniserState.Rcdata
                r2.a((org.jsoup.parser.TokeniserState) r4)
                r19.c()
                r1.a((boolean) r0)
                org.jsoup.parser.HtmlTreeBuilderState r0 = Text
                goto L_0x0345
            L_0x05d7:
                r3 = r17
                r15 = 1
                org.jsoup.nodes.Element r0 = r19.A()
                java.lang.String r0 = r0.r()
                boolean r0 = r0.equals(r13)
                if (r0 == 0) goto L_0x037c
                r1.m(r13)
                goto L_0x037c
            L_0x05ed:
                r3 = r17
                r15 = 1
            L_0x05f0:
                r1.a((boolean) r0)
            L_0x05f3:
                org.jsoup.parser.HtmlTreeBuilderState.d(r2, r1)
                goto L_0x0382
            L_0x05f8:
                r3 = r17
                r4 = 1
                boolean r5 = r1.g((java.lang.String) r15)
                if (r5 == 0) goto L_0x060b
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                r1.m(r15)
                r1.a((org.jsoup.parser.Token) r2)
                goto L_0x066a
            L_0x060b:
                r19.w()
                r1.a((org.jsoup.parser.Token.g) r2)
                r1.a((boolean) r0)
                goto L_0x066a
            L_0x0615:
                r3 = r17
                r4 = 1
                r1.b((org.jsoup.parser.HtmlTreeBuilderState) r3)
                java.util.ArrayList r5 = r19.j()
                int r6 = r5.size()
                if (r6 == r4) goto L_0x066b
                int r6 = r5.size()
                r7 = 2
                if (r6 <= r7) goto L_0x063d
                java.lang.Object r6 = r5.get(r4)
                org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
                java.lang.String r6 = r6.r()
                boolean r6 = r6.equals(r10)
                if (r6 != 0) goto L_0x063d
                goto L_0x066b
            L_0x063d:
                boolean r6 = r19.e()
                if (r6 != 0) goto L_0x0644
                return r0
            L_0x0644:
                java.lang.Object r0 = r5.get(r4)
                org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
                org.jsoup.nodes.Element r6 = r0.K()
                if (r6 == 0) goto L_0x0653
                r0.P()
            L_0x0653:
                int r0 = r5.size()
                if (r0 <= r4) goto L_0x0662
                int r0 = r5.size()
                int r0 = r0 - r4
                r5.remove(r0)
                goto L_0x0653
            L_0x0662:
                r1.a((org.jsoup.parser.Token.g) r2)
                org.jsoup.parser.HtmlTreeBuilderState r0 = InFrameset
                r1.a((org.jsoup.parser.HtmlTreeBuilderState) r0)
            L_0x066a:
                return r4
            L_0x066b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.c(org.jsoup.parser.Token, org.jsoup.parser.b):boolean");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x01b5, code lost:
            if (r10.A().r().equals(r1) == false) goto L_0x01b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x01b7, code lost:
            r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x01ba, code lost:
            r10.c(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x01fd, code lost:
            if (r10.A().r().equals(r1) == false) goto L_0x01b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x0227, code lost:
            if (r10.A().r().equals(r1) == false) goto L_0x01b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x022a, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x010e, code lost:
            if (r10.A().r().equals(r1) == false) goto L_0x01b7;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean d(org.jsoup.parser.Token r9, org.jsoup.parser.b r10) {
            /*
                r8 = this;
                org.jsoup.parser.Token$f r0 = r9.h()
                java.lang.String r1 = r0.s()
                r1.hashCode()
                int r2 = r1.hashCode()
                r3 = 1
                java.lang.String r4 = "br"
                java.lang.String r5 = "body"
                r6 = 0
                r7 = -1
                switch(r2) {
                    case 112: goto L_0x00d3;
                    case 3152: goto L_0x00ca;
                    case 3200: goto L_0x00bf;
                    case 3216: goto L_0x00b4;
                    case 3273: goto L_0x00a9;
                    case 3274: goto L_0x009e;
                    case 3275: goto L_0x0093;
                    case 3276: goto L_0x0088;
                    case 3277: goto L_0x007b;
                    case 3278: goto L_0x006d;
                    case 3453: goto L_0x005f;
                    case 3029410: goto L_0x0053;
                    case 3148996: goto L_0x0045;
                    case 3213227: goto L_0x0037;
                    case 3536714: goto L_0x0029;
                    case 1869063452: goto L_0x001b;
                    default: goto L_0x0019;
                }
            L_0x0019:
                goto L_0x00dd
            L_0x001b:
                java.lang.String r2 = "sarcasm"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0025
                goto L_0x00dd
            L_0x0025:
                r7 = 15
                goto L_0x00dd
            L_0x0029:
                java.lang.String r2 = "span"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0033
                goto L_0x00dd
            L_0x0033:
                r7 = 14
                goto L_0x00dd
            L_0x0037:
                java.lang.String r2 = "html"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0041
                goto L_0x00dd
            L_0x0041:
                r7 = 13
                goto L_0x00dd
            L_0x0045:
                java.lang.String r2 = "form"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x004f
                goto L_0x00dd
            L_0x004f:
                r7 = 12
                goto L_0x00dd
            L_0x0053:
                boolean r2 = r1.equals(r5)
                if (r2 != 0) goto L_0x005b
                goto L_0x00dd
            L_0x005b:
                r7 = 11
                goto L_0x00dd
            L_0x005f:
                java.lang.String r2 = "li"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0069
                goto L_0x00dd
            L_0x0069:
                r7 = 10
                goto L_0x00dd
            L_0x006d:
                java.lang.String r2 = "h6"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0077
                goto L_0x00dd
            L_0x0077:
                r7 = 9
                goto L_0x00dd
            L_0x007b:
                java.lang.String r2 = "h5"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0085
                goto L_0x00dd
            L_0x0085:
                r7 = 8
                goto L_0x00dd
            L_0x0088:
                java.lang.String r2 = "h4"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x0091
                goto L_0x00dd
            L_0x0091:
                r7 = 7
                goto L_0x00dd
            L_0x0093:
                java.lang.String r2 = "h3"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x009c
                goto L_0x00dd
            L_0x009c:
                r7 = 6
                goto L_0x00dd
            L_0x009e:
                java.lang.String r2 = "h2"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x00a7
                goto L_0x00dd
            L_0x00a7:
                r7 = 5
                goto L_0x00dd
            L_0x00a9:
                java.lang.String r2 = "h1"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x00b2
                goto L_0x00dd
            L_0x00b2:
                r7 = 4
                goto L_0x00dd
            L_0x00b4:
                java.lang.String r2 = "dt"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x00bd
                goto L_0x00dd
            L_0x00bd:
                r7 = 3
                goto L_0x00dd
            L_0x00bf:
                java.lang.String r2 = "dd"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x00c8
                goto L_0x00dd
            L_0x00c8:
                r7 = 2
                goto L_0x00dd
            L_0x00ca:
                boolean r2 = r1.equals(r4)
                if (r2 != 0) goto L_0x00d1
                goto L_0x00dd
            L_0x00d1:
                r7 = 1
                goto L_0x00dd
            L_0x00d3:
                java.lang.String r2 = "p"
                boolean r2 = r1.equals(r2)
                if (r2 != 0) goto L_0x00dc
                goto L_0x00dd
            L_0x00dc:
                r7 = 0
            L_0x00dd:
                switch(r7) {
                    case 0: goto L_0x0207;
                    case 1: goto L_0x0200;
                    case 2: goto L_0x01e4;
                    case 3: goto L_0x01e4;
                    case 4: goto L_0x01be;
                    case 5: goto L_0x01be;
                    case 6: goto L_0x01be;
                    case 7: goto L_0x01be;
                    case 8: goto L_0x01be;
                    case 9: goto L_0x01be;
                    case 10: goto L_0x019c;
                    case 11: goto L_0x018b;
                    case 12: goto L_0x015d;
                    case 13: goto L_0x0152;
                    case 14: goto L_0x014d;
                    case 15: goto L_0x014d;
                    default: goto L_0x00e0;
                }
            L_0x00e0:
                java.lang.String[] r0 = org.jsoup.parser.HtmlTreeBuilderState.a.f33716s
                boolean r0 = oh.c.b(r1, r0)
                if (r0 == 0) goto L_0x00ed
                boolean r9 = r8.e(r9, r10)
                return r9
            L_0x00ed:
                java.lang.String[] r0 = org.jsoup.parser.HtmlTreeBuilderState.a.f33715r
                boolean r0 = oh.c.b(r1, r0)
                if (r0 == 0) goto L_0x0112
                boolean r9 = r10.e((java.lang.String) r1)
                if (r9 != 0) goto L_0x00ff
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r6
            L_0x00ff:
                r10.t()
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x01ba
                goto L_0x01b7
            L_0x0112:
                java.lang.String[] r0 = org.jsoup.parser.HtmlTreeBuilderState.a.f33710m
                boolean r0 = oh.c.b(r1, r0)
                if (r0 == 0) goto L_0x0148
                java.lang.String r9 = "name"
                boolean r9 = r10.e((java.lang.String) r9)
                if (r9 != 0) goto L_0x022a
                boolean r9 = r10.e((java.lang.String) r1)
                if (r9 != 0) goto L_0x012c
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r6
            L_0x012c:
                r10.t()
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x0140
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
            L_0x0140:
                r10.c((java.lang.String) r1)
                r10.x()
                goto L_0x022a
            L_0x0148:
                boolean r9 = r8.b(r9, r10)
                return r9
            L_0x014d:
                boolean r9 = r8.b(r9, r10)
                return r9
            L_0x0152:
                boolean r9 = r10.m(r5)
                if (r9 == 0) goto L_0x022a
                boolean r9 = r10.a((org.jsoup.parser.Token) r0)
                return r9
            L_0x015d:
                org.jsoup.nodes.h r9 = r10.q()
                r0 = 0
                r10.a((org.jsoup.nodes.h) r0)
                if (r9 == 0) goto L_0x0187
                boolean r0 = r10.e((java.lang.String) r1)
                if (r0 != 0) goto L_0x016e
                goto L_0x0187
            L_0x016e:
                r10.t()
                org.jsoup.nodes.Element r0 = r10.A()
                java.lang.String r0 = r0.r()
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x0182
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
            L_0x0182:
                r10.e((org.jsoup.nodes.Element) r9)
                goto L_0x022a
            L_0x0187:
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r6
            L_0x018b:
                boolean r9 = r10.e((java.lang.String) r5)
                if (r9 != 0) goto L_0x0195
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r6
            L_0x0195:
                org.jsoup.parser.HtmlTreeBuilderState r9 = AfterBody
                r10.a((org.jsoup.parser.HtmlTreeBuilderState) r9)
                goto L_0x022a
            L_0x019c:
                boolean r9 = r10.f((java.lang.String) r1)
                if (r9 != 0) goto L_0x01a6
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r6
            L_0x01a6:
                r10.j((java.lang.String) r1)
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x01ba
            L_0x01b7:
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
            L_0x01ba:
                r10.c((java.lang.String) r1)
                goto L_0x022a
            L_0x01be:
                java.lang.String[] r9 = org.jsoup.parser.HtmlTreeBuilderState.a.f33706i
                boolean r9 = r10.b((java.lang.String[]) r9)
                if (r9 != 0) goto L_0x01ca
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r6
            L_0x01ca:
                r10.j((java.lang.String) r1)
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x01de
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
            L_0x01de:
                java.lang.String[] r9 = org.jsoup.parser.HtmlTreeBuilderState.a.f33706i
                r10.a((java.lang.String[]) r9)
                goto L_0x022a
            L_0x01e4:
                boolean r9 = r10.e((java.lang.String) r1)
                if (r9 != 0) goto L_0x01ee
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r6
            L_0x01ee:
                r10.j((java.lang.String) r1)
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x01ba
                goto L_0x01b7
            L_0x0200:
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                r10.l(r4)
                return r6
            L_0x0207:
                boolean r9 = r10.g((java.lang.String) r1)
                if (r9 != 0) goto L_0x0218
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                r10.l(r1)
                boolean r9 = r10.a((org.jsoup.parser.Token) r0)
                return r9
            L_0x0218:
                r10.j((java.lang.String) r1)
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r1)
                if (r9 != 0) goto L_0x01ba
                goto L_0x01b7
            L_0x022a:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass7.d(org.jsoup.parser.Token, org.jsoup.parser.b):boolean");
        }

        private boolean e(Token token, b bVar) {
            String s2 = token.h().s();
            ArrayList<Element> j2 = bVar.j();
            int i2 = 0;
            while (i2 < 8) {
                Element k2 = bVar.k(s2);
                if (k2 == null) {
                    return b(token, bVar);
                }
                if (!bVar.d(k2)) {
                    bVar.b((HtmlTreeBuilderState) this);
                } else if (!bVar.e(k2.r())) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                } else {
                    if (bVar.A() != k2) {
                        bVar.b((HtmlTreeBuilderState) this);
                    }
                    int size = j2.size();
                    Element element = null;
                    Element element2 = null;
                    int i3 = 0;
                    boolean z2 = false;
                    while (true) {
                        if (i3 >= size || i3 >= 64) {
                            break;
                        }
                        Element element3 = j2.get(i3);
                        if (element3 != k2) {
                            if (z2 && bVar.h(element3)) {
                                element = element3;
                                break;
                            }
                        } else {
                            element2 = j2.get(i3 - 1);
                            z2 = true;
                        }
                        i3++;
                    }
                    if (element == null) {
                        bVar.c(k2.r());
                    } else {
                        Element element4 = element;
                        Element element5 = element4;
                        for (int i4 = 0; i4 < 3; i4++) {
                            if (bVar.d(element4)) {
                                element4 = bVar.f(element4);
                            }
                            if (!bVar.k(element4)) {
                                bVar.e(element4);
                            } else if (element4 == k2) {
                                break;
                            } else {
                                Element element6 = new Element(f.a(element4.a(), d.f33828b), bVar.g());
                                bVar.c(element4, element6);
                                bVar.b(element4, element6);
                                if (element5.K() != null) {
                                    element5.P();
                                }
                                element6.a((j) element5);
                                element4 = element6;
                                element5 = element4;
                            }
                        }
                        if (c.b(element2.r(), a.f33717t)) {
                            if (element5.K() != null) {
                                element5.P();
                            }
                            bVar.a((j) element5);
                        } else {
                            if (element5.K() != null) {
                                element5.P();
                            }
                            element2.a((j) element5);
                        }
                        Element element7 = new Element(k2.s(), bVar.g());
                        element7.p().a(k2.p());
                        for (j a2 : (j[]) element.M().toArray(new j[0])) {
                            element7.a(a2);
                        }
                        element.a((j) element7);
                        bVar.j(k2);
                        bVar.e(k2);
                        bVar.a(element, element7);
                        i2++;
                    }
                }
                bVar.j(k2);
                return true;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            int i2 = AnonymousClass24.f33697a[token.f33725a.ordinal()];
            if (i2 == 1) {
                bVar.a(token.j());
            } else if (i2 == 2) {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            } else if (i2 == 3) {
                return c(token, bVar);
            } else {
                if (i2 == 4) {
                    return d(token, bVar);
                }
                if (i2 == 5) {
                    Token.b m2 = token.m();
                    if (m2.o().equals(HtmlTreeBuilderState.f33695x)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    } else if (!bVar.e() || !HtmlTreeBuilderState.b((Token) m2)) {
                        bVar.w();
                        bVar.a(m2);
                        bVar.a(false);
                    } else {
                        bVar.w();
                        bVar.a(m2);
                    }
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean b(Token token, b bVar) {
            String str = token.h().f33743c;
            ArrayList<Element> j2 = bVar.j();
            int size = j2.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = j2.get(size);
                if (element.r().equals(str)) {
                    bVar.j(str);
                    if (!str.equals(bVar.A().r())) {
                        bVar.b((HtmlTreeBuilderState) this);
                    }
                    bVar.c(str);
                } else if (bVar.h(element)) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.k()) {
                bVar.a(token.m());
                return true;
            } else if (token.n()) {
                bVar.b((HtmlTreeBuilderState) this);
                bVar.i();
                bVar.a(bVar.d());
                return bVar.a(token);
            } else if (!token.g()) {
                return true;
            } else {
                bVar.i();
                bVar.a(bVar.d());
                return true;
            }
        }
    },
    InTable {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (token.k()) {
                bVar.r();
                bVar.c();
                bVar.a(InTableText);
                return bVar.a(token);
            } else if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (token.c()) {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            } else if (token.e()) {
                Token.g f2 = token.f();
                String s2 = f2.s();
                if (s2.equals("caption")) {
                    bVar.k();
                    bVar.y();
                    bVar.a(f2);
                    htmlTreeBuilderState = InCaption;
                } else if (s2.equals("colgroup")) {
                    bVar.k();
                    bVar.a(f2);
                    htmlTreeBuilderState = InColumnGroup;
                } else if (s2.equals("col")) {
                    bVar.l("colgroup");
                    return bVar.a(token);
                } else if (c.b(s2, a.f33718u)) {
                    bVar.k();
                    bVar.a(f2);
                    htmlTreeBuilderState = InTableBody;
                } else if (c.b(s2, a.f33719v)) {
                    bVar.l("tbody");
                    return bVar.a(token);
                } else {
                    if (s2.equals("table")) {
                        bVar.b((HtmlTreeBuilderState) this);
                        if (bVar.m("table")) {
                            return bVar.a(token);
                        }
                    } else if (c.b(s2, a.f33720w)) {
                        return bVar.a(token, InHead);
                    } else {
                        if (s2.equals("input")) {
                            if (!f2.f33745e.c("type").equalsIgnoreCase("hidden")) {
                                return b(token, bVar);
                            }
                            bVar.b(f2);
                        } else if (!s2.equals("form")) {
                            return b(token, bVar);
                        } else {
                            bVar.b((HtmlTreeBuilderState) this);
                            if (bVar.q() != null) {
                                return false;
                            }
                            bVar.a(f2, false);
                        }
                    }
                    return true;
                }
                bVar.a(htmlTreeBuilderState);
                return true;
            } else if (token.g()) {
                String s3 = token.h().s();
                if (s3.equals("table")) {
                    if (!bVar.h(s3)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                    bVar.c("table");
                    bVar.n();
                    return true;
                } else if (!c.b(s3, a.B)) {
                    return b(token, bVar);
                } else {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
            } else if (!token.n()) {
                return b(token, bVar);
            } else {
                if (bVar.A().r().equals("html")) {
                    bVar.b((HtmlTreeBuilderState) this);
                }
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(Token token, b bVar) {
            bVar.b((HtmlTreeBuilderState) this);
            if (!c.b(bVar.A().r(), a.C)) {
                return bVar.a(token, InBody);
            }
            bVar.b(true);
            boolean a2 = bVar.a(token, InBody);
            bVar.b(false);
            return a2;
        }
    },
    InTableText {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.f33725a == Token.TokenType.Character) {
                Token.b m2 = token.m();
                if (m2.o().equals(HtmlTreeBuilderState.f33695x)) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
                bVar.s().add(m2.o());
                return true;
            }
            if (bVar.s().size() > 0) {
                for (String next : bVar.s()) {
                    if (!HtmlTreeBuilderState.b(next)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        if (c.b(bVar.A().r(), a.C)) {
                            bVar.b(true);
                            bVar.a((Token) new Token.b().a(next), InBody);
                            bVar.b(false);
                        } else {
                            bVar.a((Token) new Token.b().a(next), InBody);
                        }
                    } else {
                        bVar.a(new Token.b().a(next));
                    }
                }
                bVar.r();
            }
            bVar.a(bVar.d());
            return bVar.a(token);
        }
    },
    InCaption {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (!token.g() || !token.h().s().equals("caption")) {
                if ((token.e() && c.b(token.f().s(), a.A)) || (token.g() && token.h().s().equals("table"))) {
                    bVar.b((HtmlTreeBuilderState) this);
                    if (bVar.m("caption")) {
                        return bVar.a(token);
                    }
                    return true;
                } else if (!token.g() || !c.b(token.h().s(), a.L)) {
                    return bVar.a(token, InBody);
                } else {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
            } else if (!bVar.h(token.h().s())) {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            } else {
                bVar.t();
                if (!bVar.A().r().equals("caption")) {
                    bVar.b((HtmlTreeBuilderState) this);
                }
                bVar.c("caption");
                bVar.x();
                bVar.a(InTable);
                return true;
            }
        }
    },
    InColumnGroup {
        private boolean a(Token token, i iVar) {
            if (iVar.m("colgroup")) {
                return iVar.a(token);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (HtmlTreeBuilderState.b(token)) {
                bVar.a(token.m());
                return true;
            }
            int i2 = AnonymousClass24.f33697a[token.f33725a.ordinal()];
            if (i2 == 1) {
                bVar.a(token.j());
            } else if (i2 == 2) {
                bVar.b((HtmlTreeBuilderState) this);
            } else if (i2 == 3) {
                Token.g f2 = token.f();
                String s2 = f2.s();
                s2.hashCode();
                if (!s2.equals("col")) {
                    return !s2.equals("html") ? a(token, (i) bVar) : bVar.a(token, InBody);
                }
                bVar.b(f2);
            } else if (i2 != 4) {
                if (i2 != 6) {
                    return a(token, (i) bVar);
                }
                if (bVar.A().r().equals("html")) {
                    return true;
                }
                return a(token, (i) bVar);
            } else if (!token.h().f33743c.equals("colgroup")) {
                return a(token, (i) bVar);
            } else {
                if (bVar.A().r().equals("html")) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
                bVar.i();
                bVar.a(InTable);
            }
            return true;
        }
    },
    InTableBody {
        private boolean b(Token token, b bVar) {
            if (bVar.h("tbody") || bVar.h("thead") || bVar.e("tfoot")) {
                bVar.l();
                bVar.m(bVar.A().r());
                return bVar.a(token);
            }
            bVar.b((HtmlTreeBuilderState) this);
            return false;
        }

        private boolean c(Token token, b bVar) {
            return bVar.a(token, InTable);
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            int i2 = AnonymousClass24.f33697a[token.f33725a.ordinal()];
            if (i2 == 3) {
                Token.g f2 = token.f();
                String s2 = f2.s();
                if (s2.equals("template")) {
                    bVar.a(f2);
                    return true;
                } else if (s2.equals("tr")) {
                    bVar.l();
                    bVar.a(f2);
                    htmlTreeBuilderState = InRow;
                } else if (!c.b(s2, a.f33721x)) {
                    return c.b(s2, a.D) ? b(token, bVar) : c(token, bVar);
                } else {
                    bVar.b((HtmlTreeBuilderState) this);
                    bVar.l("tr");
                    return bVar.a((Token) f2);
                }
            } else if (i2 != 4) {
                return c(token, bVar);
            } else {
                String s3 = token.h().s();
                if (c.b(s3, a.J)) {
                    if (!bVar.h(s3)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                    bVar.l();
                    bVar.i();
                    htmlTreeBuilderState = InTable;
                } else if (s3.equals("table")) {
                    return b(token, bVar);
                } else {
                    if (!c.b(s3, a.E)) {
                        return c(token, bVar);
                    }
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
            }
            bVar.a(htmlTreeBuilderState);
            return true;
        }
    },
    InRow {
        private boolean a(Token token, i iVar) {
            if (iVar.m("tr")) {
                return iVar.a(token);
            }
            return false;
        }

        private boolean b(Token token, b bVar) {
            return bVar.a(token, InTable);
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.e()) {
                Token.g f2 = token.f();
                String s2 = f2.s();
                if (s2.equals("template")) {
                    bVar.a(f2);
                    return true;
                } else if (!c.b(s2, a.f33721x)) {
                    return c.b(s2, a.F) ? a(token, (i) bVar) : b(token, bVar);
                } else {
                    bVar.m();
                    bVar.a(f2);
                    bVar.a(InCell);
                    bVar.y();
                    return true;
                }
            } else if (!token.g()) {
                return b(token, bVar);
            } else {
                String s3 = token.h().s();
                if (s3.equals("tr")) {
                    if (!bVar.h(s3)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                    bVar.m();
                    bVar.i();
                    bVar.a(InTableBody);
                    return true;
                } else if (s3.equals("table")) {
                    return a(token, (i) bVar);
                } else {
                    if (c.b(s3, a.f33718u)) {
                        if (!bVar.h(s3)) {
                            bVar.b((HtmlTreeBuilderState) this);
                            return false;
                        }
                        bVar.m("tr");
                        return bVar.a(token);
                    } else if (!c.b(s3, a.G)) {
                        return b(token, bVar);
                    } else {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                }
            }
        }
    },
    InCell {
        private void a(b bVar) {
            String str = "td";
            if (!bVar.h(str)) {
                str = "th";
            }
            bVar.m(str);
        }

        private boolean b(Token token, b bVar) {
            return bVar.a(token, InBody);
        }

        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.g()) {
                String s2 = token.h().s();
                if (c.b(s2, a.f33721x)) {
                    if (!bVar.h(s2)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        bVar.a(InRow);
                        return false;
                    }
                    bVar.t();
                    if (!bVar.A().r().equals(s2)) {
                        bVar.b((HtmlTreeBuilderState) this);
                    }
                    bVar.c(s2);
                    bVar.x();
                    bVar.a(InRow);
                    return true;
                } else if (c.b(s2, a.f33722y)) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                } else if (!c.b(s2, a.f33723z)) {
                    return b(token, bVar);
                } else {
                    if (!bVar.h(s2)) {
                        bVar.b((HtmlTreeBuilderState) this);
                        return false;
                    }
                }
            } else if (!token.e() || !c.b(token.f().s(), a.A)) {
                return b(token, bVar);
            } else {
                if (!bVar.h("td") && !bVar.h("th")) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
            }
            a(bVar);
            return bVar.a(token);
        }
    },
    InSelect {
        private boolean b(Token token, b bVar) {
            bVar.b((HtmlTreeBuilderState) this);
            return false;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
            if (r10.A().r().equals("optgroup") != false) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00da, code lost:
            if (r10.A().r().equals("option") != false) goto L_0x00dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00dc, code lost:
            r10.i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
            if (r10.A().r().equals("html") == false) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x002a, code lost:
            r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(org.jsoup.parser.Token r9, org.jsoup.parser.b r10) {
            /*
                r8 = this;
                int[] r0 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.f33697a
                org.jsoup.parser.Token$TokenType r1 = r9.f33725a
                int r1 = r1.ordinal()
                r0 = r0[r1]
                r1 = 1
                java.lang.String r2 = "html"
                java.lang.String r3 = "select"
                r4 = 0
                java.lang.String r5 = "optgroup"
                java.lang.String r6 = "option"
                switch(r0) {
                    case 1: goto L_0x017a;
                    case 2: goto L_0x0176;
                    case 3: goto L_0x00e1;
                    case 4: goto L_0x004a;
                    case 5: goto L_0x002f;
                    case 6: goto L_0x001c;
                    default: goto L_0x0017;
                }
            L_0x0017:
                boolean r9 = r8.b(r9, r10)
                return r9
            L_0x001c:
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r2)
                if (r9 != 0) goto L_0x0181
            L_0x002a:
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                goto L_0x0181
            L_0x002f:
                org.jsoup.parser.Token$b r9 = r9.m()
                java.lang.String r0 = r9.o()
                java.lang.String r2 = org.jsoup.parser.HtmlTreeBuilderState.f33695x
                boolean r0 = r0.equals(r2)
                if (r0 == 0) goto L_0x0045
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r4
            L_0x0045:
                r10.a((org.jsoup.parser.Token.b) r9)
                goto L_0x0181
            L_0x004a:
                org.jsoup.parser.Token$f r0 = r9.h()
                java.lang.String r0 = r0.s()
                r0.hashCode()
                r2 = -1
                int r7 = r0.hashCode()
                switch(r7) {
                    case -1010136971: goto L_0x0070;
                    case -906021636: goto L_0x0067;
                    case -80773204: goto L_0x005e;
                    default: goto L_0x005d;
                }
            L_0x005d:
                goto L_0x0078
            L_0x005e:
                boolean r3 = r0.equals(r5)
                if (r3 != 0) goto L_0x0065
                goto L_0x0078
            L_0x0065:
                r2 = 2
                goto L_0x0078
            L_0x0067:
                boolean r3 = r0.equals(r3)
                if (r3 != 0) goto L_0x006e
                goto L_0x0078
            L_0x006e:
                r2 = 1
                goto L_0x0078
            L_0x0070:
                boolean r3 = r0.equals(r6)
                if (r3 != 0) goto L_0x0077
                goto L_0x0078
            L_0x0077:
                r2 = 0
            L_0x0078:
                switch(r2) {
                    case 0: goto L_0x00ce;
                    case 1: goto L_0x00bc;
                    case 2: goto L_0x0080;
                    default: goto L_0x007b;
                }
            L_0x007b:
                boolean r9 = r8.b(r9, r10)
                return r9
            L_0x0080:
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r6)
                if (r9 == 0) goto L_0x00ad
                org.jsoup.nodes.Element r9 = r10.A()
                org.jsoup.nodes.Element r9 = r10.f((org.jsoup.nodes.Element) r9)
                if (r9 == 0) goto L_0x00ad
                org.jsoup.nodes.Element r9 = r10.A()
                org.jsoup.nodes.Element r9 = r10.f((org.jsoup.nodes.Element) r9)
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r5)
                if (r9 == 0) goto L_0x00ad
                r10.m(r6)
            L_0x00ad:
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r5)
                if (r9 == 0) goto L_0x002a
                goto L_0x00dc
            L_0x00bc:
                boolean r9 = r10.i((java.lang.String) r0)
                if (r9 != 0) goto L_0x00c6
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r4
            L_0x00c6:
                r10.c((java.lang.String) r0)
                r10.n()
                goto L_0x0181
            L_0x00ce:
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r6)
                if (r9 == 0) goto L_0x002a
            L_0x00dc:
                r10.i()
                goto L_0x0181
            L_0x00e1:
                org.jsoup.parser.Token$g r0 = r9.f()
                java.lang.String r7 = r0.s()
                boolean r2 = r7.equals(r2)
                if (r2 == 0) goto L_0x00f6
                org.jsoup.parser.HtmlTreeBuilderState r9 = InBody
                boolean r9 = r10.a((org.jsoup.parser.Token) r0, (org.jsoup.parser.HtmlTreeBuilderState) r9)
                return r9
            L_0x00f6:
                boolean r2 = r7.equals(r6)
                if (r2 == 0) goto L_0x0111
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r6)
                if (r9 == 0) goto L_0x010d
                r10.m(r6)
            L_0x010d:
                r10.a((org.jsoup.parser.Token.g) r0)
                goto L_0x0181
            L_0x0111:
                boolean r2 = r7.equals(r5)
                if (r2 == 0) goto L_0x013a
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r6)
                if (r9 == 0) goto L_0x0128
                r10.m(r6)
            L_0x0128:
                org.jsoup.nodes.Element r9 = r10.A()
                java.lang.String r9 = r9.r()
                boolean r9 = r9.equals(r5)
                if (r9 == 0) goto L_0x010d
                r10.m(r5)
                goto L_0x010d
            L_0x013a:
                boolean r1 = r7.equals(r3)
                if (r1 == 0) goto L_0x0148
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                boolean r9 = r10.m(r3)
                return r9
            L_0x0148:
                java.lang.String[] r1 = org.jsoup.parser.HtmlTreeBuilderState.a.H
                boolean r1 = oh.c.b(r7, r1)
                if (r1 == 0) goto L_0x0162
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                boolean r9 = r10.i((java.lang.String) r3)
                if (r9 != 0) goto L_0x015a
                return r4
            L_0x015a:
                r10.m(r3)
                boolean r9 = r10.a((org.jsoup.parser.Token) r0)
                return r9
            L_0x0162:
                java.lang.String r0 = "script"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x0171
                org.jsoup.parser.HtmlTreeBuilderState r0 = InHead
                boolean r9 = r10.a((org.jsoup.parser.Token) r9, (org.jsoup.parser.HtmlTreeBuilderState) r0)
                return r9
            L_0x0171:
                boolean r9 = r8.b(r9, r10)
                return r9
            L_0x0176:
                r10.b((org.jsoup.parser.HtmlTreeBuilderState) r8)
                return r4
            L_0x017a:
                org.jsoup.parser.Token$c r9 = r9.j()
                r10.a((org.jsoup.parser.Token.c) r9)
            L_0x0181:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass16.a(org.jsoup.parser.Token, org.jsoup.parser.b):boolean");
        }
    },
    InSelectInTable {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.e() && c.b(token.f().s(), a.I)) {
                bVar.b((HtmlTreeBuilderState) this);
                bVar.m("select");
                return bVar.a(token);
            } else if (!token.g() || !c.b(token.h().s(), a.I)) {
                return bVar.a(token, InSelect);
            } else {
                bVar.b((HtmlTreeBuilderState) this);
                if (!bVar.h(token.h().s())) {
                    return false;
                }
                bVar.m("select");
                return bVar.a(token);
            }
        }
    },
    AfterBody {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (HtmlTreeBuilderState.b(token)) {
                bVar.a(token.m());
                return true;
            } else if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (token.c()) {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            } else if (token.e() && token.f().s().equals("html")) {
                return bVar.a(token, InBody);
            } else {
                if (!token.g() || !token.h().s().equals("html")) {
                    if (token.n()) {
                        return true;
                    }
                    bVar.b((HtmlTreeBuilderState) this);
                    bVar.a(InBody);
                    return bVar.a(token);
                } else if (bVar.h()) {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                } else {
                    bVar.a(AfterAfterBody);
                    return true;
                }
            }
        }
    },
    InFrameset {
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x007c, code lost:
            return r9.a((org.jsoup.parser.Token) r8, r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(org.jsoup.parser.Token r8, org.jsoup.parser.b r9) {
            /*
                r7 = this;
                boolean r0 = org.jsoup.parser.HtmlTreeBuilderState.b((org.jsoup.parser.Token) r8)
                r1 = 1
                if (r0 == 0) goto L_0x0010
                org.jsoup.parser.Token$b r8 = r8.m()
                r9.a((org.jsoup.parser.Token.b) r8)
                goto L_0x00e2
            L_0x0010:
                boolean r0 = r8.i()
                if (r0 == 0) goto L_0x001f
                org.jsoup.parser.Token$c r8 = r8.j()
                r9.a((org.jsoup.parser.Token.c) r8)
                goto L_0x00e2
            L_0x001f:
                boolean r0 = r8.c()
                r2 = 0
                if (r0 == 0) goto L_0x002a
                r9.b((org.jsoup.parser.HtmlTreeBuilderState) r7)
                return r2
            L_0x002a:
                boolean r0 = r8.e()
                java.lang.String r3 = "html"
                java.lang.String r4 = "frameset"
                if (r0 == 0) goto L_0x0088
                org.jsoup.parser.Token$g r8 = r8.f()
                java.lang.String r0 = r8.s()
                r0.hashCode()
                r5 = -1
                int r6 = r0.hashCode()
                switch(r6) {
                    case -1644953643: goto L_0x0067;
                    case 3213227: goto L_0x005e;
                    case 97692013: goto L_0x0053;
                    case 1192721831: goto L_0x0048;
                    default: goto L_0x0047;
                }
            L_0x0047:
                goto L_0x006f
            L_0x0048:
                java.lang.String r3 = "noframes"
                boolean r0 = r0.equals(r3)
                if (r0 != 0) goto L_0x0051
                goto L_0x006f
            L_0x0051:
                r5 = 3
                goto L_0x006f
            L_0x0053:
                java.lang.String r3 = "frame"
                boolean r0 = r0.equals(r3)
                if (r0 != 0) goto L_0x005c
                goto L_0x006f
            L_0x005c:
                r5 = 2
                goto L_0x006f
            L_0x005e:
                boolean r0 = r0.equals(r3)
                if (r0 != 0) goto L_0x0065
                goto L_0x006f
            L_0x0065:
                r5 = 1
                goto L_0x006f
            L_0x0067:
                boolean r0 = r0.equals(r4)
                if (r0 != 0) goto L_0x006e
                goto L_0x006f
            L_0x006e:
                r5 = 0
            L_0x006f:
                switch(r5) {
                    case 0: goto L_0x0084;
                    case 1: goto L_0x0081;
                    case 2: goto L_0x007d;
                    case 3: goto L_0x0076;
                    default: goto L_0x0072;
                }
            L_0x0072:
                r9.b((org.jsoup.parser.HtmlTreeBuilderState) r7)
                return r2
            L_0x0076:
                org.jsoup.parser.HtmlTreeBuilderState r0 = InHead
            L_0x0078:
                boolean r8 = r9.a((org.jsoup.parser.Token) r8, (org.jsoup.parser.HtmlTreeBuilderState) r0)
                return r8
            L_0x007d:
                r9.b((org.jsoup.parser.Token.g) r8)
                goto L_0x00e2
            L_0x0081:
                org.jsoup.parser.HtmlTreeBuilderState r0 = InBody
                goto L_0x0078
            L_0x0084:
                r9.a((org.jsoup.parser.Token.g) r8)
                goto L_0x00e2
            L_0x0088:
                boolean r0 = r8.g()
                if (r0 == 0) goto L_0x00cb
                org.jsoup.parser.Token$f r0 = r8.h()
                java.lang.String r0 = r0.s()
                boolean r0 = r0.equals(r4)
                if (r0 == 0) goto L_0x00cb
                org.jsoup.nodes.Element r8 = r9.A()
                java.lang.String r8 = r8.r()
                boolean r8 = r8.equals(r3)
                if (r8 == 0) goto L_0x00ae
                r9.b((org.jsoup.parser.HtmlTreeBuilderState) r7)
                return r2
            L_0x00ae:
                r9.i()
                boolean r8 = r9.h()
                if (r8 != 0) goto L_0x00e2
                org.jsoup.nodes.Element r8 = r9.A()
                java.lang.String r8 = r8.r()
                boolean r8 = r8.equals(r4)
                if (r8 != 0) goto L_0x00e2
                org.jsoup.parser.HtmlTreeBuilderState r8 = AfterFrameset
                r9.a((org.jsoup.parser.HtmlTreeBuilderState) r8)
                goto L_0x00e2
            L_0x00cb:
                boolean r8 = r8.n()
                if (r8 == 0) goto L_0x00e3
                org.jsoup.nodes.Element r8 = r9.A()
                java.lang.String r8 = r8.r()
                boolean r8 = r8.equals(r3)
                if (r8 != 0) goto L_0x00e2
                r9.b((org.jsoup.parser.HtmlTreeBuilderState) r7)
            L_0x00e2:
                return r1
            L_0x00e3:
                r9.b((org.jsoup.parser.HtmlTreeBuilderState) r7)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass19.a(org.jsoup.parser.Token, org.jsoup.parser.b):boolean");
        }
    },
    AfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            HtmlTreeBuilderState htmlTreeBuilderState;
            if (HtmlTreeBuilderState.b(token)) {
                bVar.a(token.m());
                return true;
            } else if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (token.c()) {
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            } else {
                if (token.e() && token.f().s().equals("html")) {
                    htmlTreeBuilderState = InBody;
                } else if (token.g() && token.h().s().equals("html")) {
                    bVar.a(AfterAfterFrameset);
                    return true;
                } else if (token.e() && token.f().s().equals("noframes")) {
                    htmlTreeBuilderState = InHead;
                } else if (token.n()) {
                    return true;
                } else {
                    bVar.b((HtmlTreeBuilderState) this);
                    return false;
                }
                return bVar.a(token, htmlTreeBuilderState);
            }
        }
    },
    AfterAfterBody {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (token.c() || (token.e() && token.f().s().equals("html"))) {
                return bVar.a(token, InBody);
            } else {
                if (HtmlTreeBuilderState.b(token)) {
                    Element c2 = bVar.c("html");
                    bVar.a(token.m());
                    bVar.f33878m.add(c2);
                    bVar.f33878m.add(c2.f("body"));
                    return true;
                } else if (token.n()) {
                    return true;
                } else {
                    bVar.b((HtmlTreeBuilderState) this);
                    bVar.a(InBody);
                    return bVar.a(token);
                }
            }
        }
    },
    AfterAfterFrameset {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            if (token.i()) {
                bVar.a(token.j());
                return true;
            } else if (token.c() || HtmlTreeBuilderState.b(token) || (token.e() && token.f().s().equals("html"))) {
                return bVar.a(token, InBody);
            } else {
                if (token.n()) {
                    return true;
                }
                if (token.e() && token.f().s().equals("noframes")) {
                    return bVar.a(token, InHead);
                }
                bVar.b((HtmlTreeBuilderState) this);
                return false;
            }
        }
    },
    ForeignContent {
        /* access modifiers changed from: package-private */
        public boolean a(Token token, b bVar) {
            return true;
        }
    };
    
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public static final String f33695x = null;

    /* renamed from: org.jsoup.parser.HtmlTreeBuilderState$24  reason: invalid class name */
    static /* synthetic */ class AnonymousClass24 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33697a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.jsoup.parser.Token$TokenType[] r0 = org.jsoup.parser.Token.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33697a = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33697a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33697a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f33697a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f33697a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f33697a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.<clinit>():void");
        }
    }

    static final class a {
        static final String[] A = null;
        static final String[] B = null;
        static final String[] C = null;
        static final String[] D = null;
        static final String[] E = null;
        static final String[] F = null;
        static final String[] G = null;
        static final String[] H = null;
        static final String[] I = null;
        static final String[] J = null;
        static final String[] K = null;
        static final String[] L = null;

        /* renamed from: a  reason: collision with root package name */
        static final String[] f33698a = null;

        /* renamed from: b  reason: collision with root package name */
        static final String[] f33699b = null;

        /* renamed from: c  reason: collision with root package name */
        static final String[] f33700c = null;

        /* renamed from: d  reason: collision with root package name */
        static final String[] f33701d = null;

        /* renamed from: e  reason: collision with root package name */
        static final String[] f33702e = null;

        /* renamed from: f  reason: collision with root package name */
        static final String[] f33703f = null;

        /* renamed from: g  reason: collision with root package name */
        static final String[] f33704g = null;

        /* renamed from: h  reason: collision with root package name */
        static final String[] f33705h = null;

        /* renamed from: i  reason: collision with root package name */
        static final String[] f33706i = null;

        /* renamed from: j  reason: collision with root package name */
        static final String[] f33707j = null;

        /* renamed from: k  reason: collision with root package name */
        static final String[] f33708k = null;

        /* renamed from: l  reason: collision with root package name */
        static final String[] f33709l = null;

        /* renamed from: m  reason: collision with root package name */
        static final String[] f33710m = null;

        /* renamed from: n  reason: collision with root package name */
        static final String[] f33711n = null;

        /* renamed from: o  reason: collision with root package name */
        static final String[] f33712o = null;

        /* renamed from: p  reason: collision with root package name */
        static final String[] f33713p = null;

        /* renamed from: q  reason: collision with root package name */
        static final String[] f33714q = null;

        /* renamed from: r  reason: collision with root package name */
        static final String[] f33715r = null;

        /* renamed from: s  reason: collision with root package name */
        static final String[] f33716s = null;

        /* renamed from: t  reason: collision with root package name */
        static final String[] f33717t = null;

        /* renamed from: u  reason: collision with root package name */
        static final String[] f33718u = null;

        /* renamed from: v  reason: collision with root package name */
        static final String[] f33719v = null;

        /* renamed from: w  reason: collision with root package name */
        static final String[] f33720w = null;

        /* renamed from: x  reason: collision with root package name */
        static final String[] f33721x = null;

        /* renamed from: y  reason: collision with root package name */
        static final String[] f33722y = null;

        /* renamed from: z  reason: collision with root package name */
        static final String[] f33723z = null;

        static {
            f33698a = new String[]{"base", "basefont", "bgsound", "command", "link"};
            f33699b = new String[]{"noframes", "style"};
            f33700c = new String[]{"body", "br", "html"};
            f33701d = new String[]{"body", "html"};
            f33702e = new String[]{"body", "br", "head", "html"};
            f33703f = new String[]{"basefont", "bgsound", "link", "meta", "noframes", "style"};
            f33704g = new String[]{"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};
            f33705h = new String[]{"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul"};
            f33706i = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            f33707j = new String[]{"address", "div", "p"};
            f33708k = new String[]{"dd", dt.f8292a};
            f33709l = new String[]{"b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u"};
            f33710m = new String[]{"applet", "marquee", "object"};
            f33711n = new String[]{"area", "br", "embed", "img", "keygen", "wbr"};
            f33712o = new String[]{"param", "source", "track"};
            f33713p = new String[]{"action", "name", "prompt"};
            f33714q = new String[]{"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            f33715r = new String[]{"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul"};
            f33716s = new String[]{"a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
            f33717t = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            f33718u = new String[]{"tbody", "tfoot", "thead"};
            f33719v = new String[]{"td", "th", "tr"};
            f33720w = new String[]{"script", "style"};
            f33721x = new String[]{"td", "th"};
            f33722y = new String[]{"body", "caption", "col", "colgroup", "html"};
            f33723z = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            A = new String[]{"caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
            B = new String[]{"body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
            C = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
            D = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead"};
            E = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th", "tr"};
            F = new String[]{"caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
            G = new String[]{"body", "caption", "col", "colgroup", "html", "td", "th"};
            H = new String[]{"input", "keygen", "textarea"};
            I = new String[]{"caption", "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
            J = new String[]{"tbody", "tfoot", "thead"};
            K = new String[]{"head", "noscript"};
            L = new String[]{"body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        }
    }

    static {
        f33695x = String.valueOf(0);
    }

    /* access modifiers changed from: private */
    public static boolean b(String str) {
        return c.a(str);
    }

    /* access modifiers changed from: private */
    public static boolean b(Token token) {
        if (token.k()) {
            return c.a(token.m().o());
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void c(Token.g gVar, b bVar) {
        bVar.f33876k.a(TokeniserState.Rcdata);
        bVar.c();
        bVar.a(Text);
        bVar.a(gVar);
    }

    /* access modifiers changed from: private */
    public static void d(Token.g gVar, b bVar) {
        bVar.f33876k.a(TokeniserState.Rawtext);
        bVar.c();
        bVar.a(Text);
        bVar.a(gVar);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(Token token, b bVar);
}
