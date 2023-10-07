package org.jsoup.parser;

import org.jsoup.parser.Token;

enum TokeniserState {
    Data {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '&') {
                    tokeniserState = CharacterReferenceInData;
                } else if (d2 == '<') {
                    tokeniserState = TagOpen;
                } else if (d2 != 65535) {
                    hVar.a(aVar.k());
                    return;
                } else {
                    hVar.a((Token) new Token.e());
                    return;
                }
                hVar.b(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            hVar.a(aVar.e());
        }
    },
    CharacterReferenceInData {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.b(hVar, Data);
        }
    },
    Rcdata {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '&') {
                    tokeniserState = CharacterReferenceInRcdata;
                } else if (d2 == '<') {
                    tokeniserState = RcdataLessthanSign;
                } else if (d2 != 65535) {
                    hVar.a(aVar.k());
                    return;
                } else {
                    hVar.a((Token) new Token.e());
                    return;
                }
                hVar.b(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            aVar.g();
            hVar.a(65533);
        }
    },
    CharacterReferenceInRcdata {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.b(hVar, Rcdata);
        }
    },
    Rawtext {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.d(hVar, aVar, this, RawtextLessthanSign);
        }
    },
    ScriptData {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.d(hVar, aVar, this, ScriptDataLessthanSign);
        }
    },
    PLAINTEXT {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            char d2 = aVar.d();
            if (d2 == 0) {
                hVar.c((TokeniserState) this);
                aVar.g();
                hVar.a(65533);
            } else if (d2 != 65535) {
                hVar.a(aVar.b(0));
            } else {
                hVar.a((Token) new Token.e());
            }
        }
    },
    TagOpen {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            char d2 = aVar.d();
            if (d2 == '!') {
                tokeniserState = MarkupDeclarationOpen;
            } else if (d2 == '/') {
                tokeniserState = EndTagOpen;
            } else if (d2 != '?') {
                if (aVar.s()) {
                    hVar.a(true);
                    tokeniserState2 = TagName;
                } else {
                    hVar.c((TokeniserState) this);
                    hVar.a('<');
                    tokeniserState2 = Data;
                }
                hVar.a(tokeniserState2);
                return;
            } else {
                hVar.e();
                tokeniserState = BogusComment;
            }
            hVar.b(tokeniserState);
        }
    },
    EndTagOpen {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            if (aVar.c()) {
                hVar.d(this);
                hVar.a("</");
                tokeniserState2 = Data;
            } else if (aVar.s()) {
                hVar.a(false);
                tokeniserState2 = TagName;
            } else {
                boolean c2 = aVar.c('>');
                hVar.c((TokeniserState) this);
                if (c2) {
                    tokeniserState = Data;
                } else {
                    hVar.e();
                    tokeniserState = BogusComment;
                }
                hVar.b(tokeniserState);
                return;
            }
            hVar.a(tokeniserState2);
        }
    },
    TagName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            hVar.f33856c.b(aVar.m());
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != ' ') {
                    if (e2 != '/') {
                        if (e2 == '<') {
                            aVar.f();
                            hVar.c((TokeniserState) this);
                        } else if (e2 != '>') {
                            if (e2 == 65535) {
                                hVar.d(this);
                                tokeniserState = Data;
                            } else if (!(e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13)) {
                                hVar.f33856c.a(e2);
                                return;
                            }
                        }
                        hVar.b();
                        tokeniserState = Data;
                    } else {
                        tokeniserState = SelfClosingStartTag;
                    }
                    hVar.a(tokeniserState);
                    return;
                }
                tokeniserState = BeforeAttributeName;
                hVar.a(tokeniserState);
                return;
            }
            hVar.f33856c.b(TokeniserState.f33771at);
        }
    },
    RcdataLessthanSign {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.c('/')) {
                hVar.h();
                hVar.b(RCDATAEndTagOpen);
                return;
            }
            if (aVar.s() && hVar.j() != null) {
                if (!aVar.f("</" + hVar.j())) {
                    hVar.f33856c = hVar.a(false).a(hVar.j());
                    hVar.b();
                    aVar.f();
                    tokeniserState = Data;
                    hVar.a(tokeniserState);
                }
            }
            hVar.a("<");
            tokeniserState = Rcdata;
            hVar.a(tokeniserState);
        }
    },
    RCDATAEndTagOpen {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            if (aVar.s()) {
                hVar.a(false);
                hVar.f33856c.a(aVar.d());
                hVar.f33855b.append(aVar.d());
                hVar.b(RCDATAEndTagName);
                return;
            }
            hVar.a("</");
            hVar.a(Rcdata);
        }
    },
    RCDATAEndTagName {
        private void b(h hVar, a aVar) {
            hVar.a("</" + hVar.f33855b.toString());
            aVar.f();
            hVar.a(Rcdata);
        }

        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.s()) {
                String o2 = aVar.o();
                hVar.f33856c.b(o2);
                hVar.f33855b.append(o2);
                return;
            }
            char e2 = aVar.e();
            if (e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ') {
                if (hVar.i()) {
                    tokeniserState = BeforeAttributeName;
                    hVar.a(tokeniserState);
                    return;
                }
            } else if (e2 != '/') {
                if (e2 == '>' && hVar.i()) {
                    hVar.b();
                    tokeniserState = Data;
                    hVar.a(tokeniserState);
                    return;
                }
            } else if (hVar.i()) {
                tokeniserState = SelfClosingStartTag;
                hVar.a(tokeniserState);
                return;
            }
            b(hVar, aVar);
        }
    },
    RawtextLessthanSign {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            if (aVar.c('/')) {
                hVar.h();
                hVar.b(RawtextEndTagOpen);
                return;
            }
            hVar.a('<');
            hVar.a(Rawtext);
        }
    },
    RawtextEndTagOpen {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.e(hVar, aVar, RawtextEndTagName, Rawtext);
        }
    },
    RawtextEndTagName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.b(hVar, aVar, Rawtext);
        }
    },
    ScriptDataLessthanSign {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 == '!') {
                hVar.a("<!");
                tokeniserState = ScriptDataEscapeStart;
            } else if (e2 != '/') {
                hVar.a("<");
                if (e2 != 65535) {
                    aVar.f();
                    tokeniserState = ScriptData;
                } else {
                    hVar.d(this);
                    tokeniserState = Data;
                }
            } else {
                hVar.h();
                tokeniserState = ScriptDataEndTagOpen;
            }
            hVar.a(tokeniserState);
        }
    },
    ScriptDataEndTagOpen {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.e(hVar, aVar, ScriptDataEndTagName, ScriptData);
        }
    },
    ScriptDataEndTagName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.b(hVar, aVar, ScriptData);
        }
    },
    ScriptDataEscapeStart {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            if (aVar.c('-')) {
                hVar.a('-');
                hVar.b(ScriptDataEscapeStartDash);
                return;
            }
            hVar.a(ScriptData);
        }
    },
    ScriptDataEscapeStartDash {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            if (aVar.c('-')) {
                hVar.a('-');
                hVar.b(ScriptDataEscapedDashDash);
                return;
            }
            hVar.a(ScriptData);
        }
    },
    ScriptDataEscaped {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.c()) {
                hVar.d(this);
                hVar.a(Data);
                return;
            }
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '-') {
                    hVar.a('-');
                    tokeniserState = ScriptDataEscapedDash;
                } else if (d2 != '<') {
                    hVar.a(aVar.a('-', '<', 0));
                    return;
                } else {
                    tokeniserState = ScriptDataEscapedLessthanSign;
                }
                hVar.b(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            aVar.g();
            hVar.a(65533);
        }
    },
    ScriptDataEscapedDash {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.c()) {
                hVar.d(this);
                hVar.a(Data);
                return;
            }
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 == '-') {
                    hVar.a(e2);
                    tokeniserState = ScriptDataEscapedDashDash;
                } else if (e2 == '<') {
                    tokeniserState = ScriptDataEscapedLessthanSign;
                }
                hVar.a(tokeniserState);
            }
            hVar.c((TokeniserState) this);
            e2 = 65533;
            hVar.a(e2);
            tokeniserState = ScriptDataEscaped;
            hVar.a(tokeniserState);
        }
    },
    ScriptDataEscapedDashDash {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.c()) {
                hVar.d(this);
                hVar.a(Data);
                return;
            }
            char e2 = aVar.e();
            if (e2 == 0) {
                hVar.c((TokeniserState) this);
                hVar.a(65533);
            } else if (e2 != '-') {
                if (e2 != '<') {
                    hVar.a(e2);
                    if (e2 == '>') {
                        tokeniserState = ScriptData;
                    }
                } else {
                    tokeniserState = ScriptDataEscapedLessthanSign;
                }
                hVar.a(tokeniserState);
            } else {
                hVar.a(e2);
                return;
            }
            tokeniserState = ScriptDataEscaped;
            hVar.a(tokeniserState);
        }
    },
    ScriptDataEscapedLessthanSign {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.s()) {
                hVar.h();
                hVar.f33855b.append(aVar.d());
                hVar.a("<" + aVar.d());
                tokeniserState = ScriptDataDoubleEscapeStart;
            } else if (aVar.c('/')) {
                hVar.h();
                tokeniserState = ScriptDataEscapedEndTagOpen;
            } else {
                hVar.a('<');
                hVar.a(ScriptDataEscaped);
                return;
            }
            hVar.b(tokeniserState);
        }
    },
    ScriptDataEscapedEndTagOpen {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            if (aVar.s()) {
                hVar.a(false);
                hVar.f33856c.a(aVar.d());
                hVar.f33855b.append(aVar.d());
                hVar.b(ScriptDataEscapedEndTagName);
                return;
            }
            hVar.a("</");
            hVar.a(ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.b(hVar, aVar, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.f(hVar, aVar, ScriptDataDoubleEscaped, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char d2 = aVar.d();
            if (d2 != 0) {
                if (d2 == '-') {
                    hVar.a(d2);
                    tokeniserState = ScriptDataDoubleEscapedDash;
                } else if (d2 == '<') {
                    hVar.a(d2);
                    tokeniserState = ScriptDataDoubleEscapedLessthanSign;
                } else if (d2 != 65535) {
                    hVar.a(aVar.a('-', '<', 0));
                    return;
                } else {
                    hVar.d(this);
                    hVar.a(Data);
                    return;
                }
                hVar.b(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            aVar.g();
            hVar.a(65533);
        }
    },
    ScriptDataDoubleEscapedDash {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 == '-') {
                    hVar.a(e2);
                    tokeniserState = ScriptDataDoubleEscapedDashDash;
                } else if (e2 == '<') {
                    hVar.a(e2);
                    tokeniserState = ScriptDataDoubleEscapedLessthanSign;
                } else if (e2 == 65535) {
                    hVar.d(this);
                    tokeniserState = Data;
                }
                hVar.a(tokeniserState);
            }
            hVar.c((TokeniserState) this);
            e2 = 65533;
            hVar.a(e2);
            tokeniserState = ScriptDataDoubleEscaped;
            hVar.a(tokeniserState);
        }
    },
    ScriptDataDoubleEscapedDashDash {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 == 0) {
                hVar.c((TokeniserState) this);
                e2 = 65533;
            } else if (e2 != '-') {
                if (e2 == '<') {
                    hVar.a(e2);
                    tokeniserState = ScriptDataDoubleEscapedLessthanSign;
                } else if (e2 == '>') {
                    hVar.a(e2);
                    tokeniserState = ScriptData;
                } else if (e2 == 65535) {
                    hVar.d(this);
                    tokeniserState = Data;
                }
                hVar.a(tokeniserState);
            } else {
                hVar.a(e2);
                return;
            }
            hVar.a(e2);
            tokeniserState = ScriptDataDoubleEscaped;
            hVar.a(tokeniserState);
        }
    },
    ScriptDataDoubleEscapedLessthanSign {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            if (aVar.c('/')) {
                hVar.a('/');
                hVar.h();
                hVar.b(ScriptDataDoubleEscapeEnd);
                return;
            }
            hVar.a(ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState.f(hVar, aVar, ScriptDataEscaped, ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName {
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
            r3.b();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(org.jsoup.parser.h r3, org.jsoup.parser.a r4) {
            /*
                r2 = this;
                char r0 = r4.e()
                if (r0 == 0) goto L_0x005b
                r1 = 32
                if (r0 == r1) goto L_0x0069
                r1 = 34
                if (r0 == r1) goto L_0x004d
                r1 = 39
                if (r0 == r1) goto L_0x004d
                r1 = 47
                if (r0 == r1) goto L_0x004a
                r1 = 65535(0xffff, float:9.1834E-41)
                if (r0 == r1) goto L_0x0046
                r1 = 9
                if (r0 == r1) goto L_0x0069
                r1 = 10
                if (r0 == r1) goto L_0x0069
                r1 = 12
                if (r0 == r1) goto L_0x0069
                r1 = 13
                if (r0 == r1) goto L_0x0069
                switch(r0) {
                    case 60: goto L_0x0037;
                    case 61: goto L_0x004d;
                    case 62: goto L_0x003d;
                    default: goto L_0x002e;
                }
            L_0x002e:
                org.jsoup.parser.Token$h r0 = r3.f33856c
                r0.p()
                r4.f()
                goto L_0x0066
            L_0x0037:
                r4.f()
                r3.c((org.jsoup.parser.TokeniserState) r2)
            L_0x003d:
                r3.b()
            L_0x0040:
                org.jsoup.parser.TokeniserState r4 = Data
            L_0x0042:
                r3.a((org.jsoup.parser.TokeniserState) r4)
                goto L_0x0069
            L_0x0046:
                r3.d(r2)
                goto L_0x0040
            L_0x004a:
                org.jsoup.parser.TokeniserState r4 = SelfClosingStartTag
                goto L_0x0042
            L_0x004d:
                r3.c((org.jsoup.parser.TokeniserState) r2)
                org.jsoup.parser.Token$h r4 = r3.f33856c
                r4.p()
                org.jsoup.parser.Token$h r4 = r3.f33856c
                r4.b((char) r0)
                goto L_0x0066
            L_0x005b:
                r4.f()
                r3.c((org.jsoup.parser.TokeniserState) r2)
                org.jsoup.parser.Token$h r4 = r3.f33856c
                r4.p()
            L_0x0066:
                org.jsoup.parser.TokeniserState r4 = AttributeName
                goto L_0x0042
            L_0x0069:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.TokeniserState.AnonymousClass34.a(org.jsoup.parser.h, org.jsoup.parser.a):void");
        }
    },
    AttributeName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            Token.h hVar2;
            TokeniserState tokeniserState;
            hVar.f33856c.c(aVar.b(f33769ar));
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != ' ') {
                    if (!(e2 == '\"' || e2 == '\'')) {
                        if (e2 != '/') {
                            if (e2 != 65535) {
                                if (!(e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13)) {
                                    switch (e2) {
                                        case '<':
                                            break;
                                        case '=':
                                            tokeniserState = BeforeAttributeValue;
                                            break;
                                        case '>':
                                            hVar.b();
                                            break;
                                    }
                                }
                            } else {
                                hVar.d(this);
                            }
                            tokeniserState = Data;
                        } else {
                            tokeniserState = SelfClosingStartTag;
                        }
                        hVar.a(tokeniserState);
                        return;
                    }
                    hVar.c((TokeniserState) this);
                    hVar2 = hVar.f33856c;
                }
                tokeniserState = AfterAttributeName;
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            hVar2 = hVar.f33856c;
            e2 = 65533;
            hVar2.b(e2);
        }
    },
    AfterAttributeName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            Token.h hVar2;
            char e2 = aVar.e();
            if (e2 == 0) {
                hVar.c((TokeniserState) this);
                hVar2 = hVar.f33856c;
                e2 = 65533;
            } else if (e2 != ' ') {
                if (!(e2 == '\"' || e2 == '\'')) {
                    if (e2 != '/') {
                        if (e2 != 65535) {
                            if (e2 != 9 && e2 != 10 && e2 != 12 && e2 != 13) {
                                switch (e2) {
                                    case '<':
                                        break;
                                    case '=':
                                        tokeniserState = BeforeAttributeValue;
                                        break;
                                    case '>':
                                        hVar.b();
                                        break;
                                    default:
                                        hVar.f33856c.p();
                                        aVar.f();
                                        break;
                                }
                            } else {
                                return;
                            }
                        } else {
                            hVar.d(this);
                        }
                        tokeniserState = Data;
                    } else {
                        tokeniserState = SelfClosingStartTag;
                    }
                    hVar.a(tokeniserState);
                }
                hVar.c((TokeniserState) this);
                hVar.f33856c.p();
                hVar2 = hVar.f33856c;
            } else {
                return;
            }
            hVar2.b(e2);
            tokeniserState = AttributeName;
            hVar.a(tokeniserState);
        }
    },
    BeforeAttributeValue {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            Token.h hVar2;
            char e2 = aVar.e();
            if (e2 == 0) {
                hVar.c((TokeniserState) this);
                hVar2 = hVar.f33856c;
                e2 = 65533;
            } else if (e2 != ' ') {
                if (e2 != '\"') {
                    if (e2 != '`') {
                        if (e2 == 65535) {
                            hVar.d(this);
                        } else if (e2 != 9 && e2 != 10 && e2 != 12 && e2 != 13) {
                            if (e2 != '&') {
                                if (e2 != '\'') {
                                    switch (e2) {
                                        case '<':
                                        case '=':
                                            break;
                                        case '>':
                                            hVar.c((TokeniserState) this);
                                            break;
                                    }
                                } else {
                                    tokeniserState = AttributeValue_singleQuoted;
                                }
                            }
                            aVar.f();
                            tokeniserState = AttributeValue_unquoted;
                        } else {
                            return;
                        }
                        hVar.b();
                        tokeniserState = Data;
                    }
                    hVar.c((TokeniserState) this);
                    hVar2 = hVar.f33856c;
                } else {
                    tokeniserState = AttributeValue_doubleQuoted;
                }
                hVar.a(tokeniserState);
            } else {
                return;
            }
            hVar2.c(e2);
            tokeniserState = AttributeValue_unquoted;
            hVar.a(tokeniserState);
        }
    },
    AttributeValue_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            Token.h hVar2;
            TokeniserState tokeniserState;
            String b2 = aVar.b(f33768aq);
            if (b2.length() > 0) {
                hVar.f33856c.d(b2);
            } else {
                hVar.f33856c.v();
            }
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 == '\"') {
                    tokeniserState = AfterAttributeValue_quoted;
                } else if (e2 == '&') {
                    int[] a2 = hVar.a('\"', true);
                    Token.h hVar3 = hVar.f33856c;
                    if (a2 != null) {
                        hVar3.a(a2);
                        return;
                    } else {
                        hVar3.c('&');
                        return;
                    }
                } else if (e2 != 65535) {
                    hVar2 = hVar.f33856c;
                } else {
                    hVar.d(this);
                    tokeniserState = Data;
                }
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            hVar2 = hVar.f33856c;
            e2 = 65533;
            hVar2.c(e2);
        }
    },
    AttributeValue_singleQuoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            Token.h hVar2;
            TokeniserState tokeniserState;
            String b2 = aVar.b(f33767ap);
            if (b2.length() > 0) {
                hVar.f33856c.d(b2);
            } else {
                hVar.f33856c.v();
            }
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 == 65535) {
                    hVar.d(this);
                    tokeniserState = Data;
                } else if (e2 == '&') {
                    int[] a2 = hVar.a('\'', true);
                    Token.h hVar3 = hVar.f33856c;
                    if (a2 != null) {
                        hVar3.a(a2);
                        return;
                    } else {
                        hVar3.c('&');
                        return;
                    }
                } else if (e2 != '\'') {
                    hVar2 = hVar.f33856c;
                } else {
                    tokeniserState = AfterAttributeValue_quoted;
                }
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            hVar2 = hVar.f33856c;
            e2 = 65533;
            hVar2.c(e2);
        }
    },
    AttributeValue_unquoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            Token.h hVar2;
            TokeniserState tokeniserState;
            String b2 = aVar.b(f33770as);
            if (b2.length() > 0) {
                hVar.f33856c.d(b2);
            }
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != ' ') {
                    if (!(e2 == '\"' || e2 == '`')) {
                        if (e2 == 65535) {
                            hVar.d(this);
                        } else if (!(e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13)) {
                            if (e2 != '&') {
                                if (e2 != '\'') {
                                    switch (e2) {
                                        case '<':
                                        case '=':
                                            break;
                                        case '>':
                                            hVar.b();
                                            break;
                                    }
                                }
                            } else {
                                int[] a2 = hVar.a('>', true);
                                Token.h hVar3 = hVar.f33856c;
                                if (a2 != null) {
                                    hVar3.a(a2);
                                    return;
                                } else {
                                    hVar3.c('&');
                                    return;
                                }
                            }
                        }
                        tokeniserState = Data;
                        hVar.a(tokeniserState);
                        return;
                    }
                    hVar.c((TokeniserState) this);
                    hVar2 = hVar.f33856c;
                }
                tokeniserState = BeforeAttributeName;
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            hVar2 = hVar.f33856c;
            e2 = 65533;
            hVar2.c(e2);
        }
    },
    AfterAttributeValue_quoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (!(e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ')) {
                if (e2 != '/') {
                    if (e2 == '>') {
                        hVar.b();
                    } else if (e2 != 65535) {
                        aVar.f();
                        hVar.c((TokeniserState) this);
                    } else {
                        hVar.d(this);
                    }
                    tokeniserState = Data;
                } else {
                    tokeniserState = SelfClosingStartTag;
                }
                hVar.a(tokeniserState);
            }
            tokeniserState = BeforeAttributeName;
            hVar.a(tokeniserState);
        }
    },
    SelfClosingStartTag {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 == '>') {
                hVar.f33856c.f33744d = true;
                hVar.b();
            } else if (e2 != 65535) {
                aVar.f();
                hVar.c((TokeniserState) this);
                tokeniserState = BeforeAttributeName;
                hVar.a(tokeniserState);
            } else {
                hVar.d(this);
            }
            tokeniserState = Data;
            hVar.a(tokeniserState);
        }
    },
    BogusComment {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            aVar.f();
            hVar.f33861h.a(aVar.b('>'));
            char e2 = aVar.e();
            if (e2 == '>' || e2 == 65535) {
                hVar.d();
                hVar.a(Data);
            }
        }
    },
    MarkupDeclarationOpen {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.d("--")) {
                hVar.c();
                tokeniserState = CommentStart;
            } else if (aVar.e("DOCTYPE")) {
                tokeniserState = Doctype;
            } else if (aVar.d("[CDATA[")) {
                hVar.h();
                tokeniserState = CdataSection;
            } else {
                hVar.c((TokeniserState) this);
                hVar.e();
                hVar.b(BogusComment);
                return;
            }
            hVar.a(tokeniserState);
        }
    },
    CommentStart {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != '-') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        aVar.f();
                    } else {
                        hVar.d(this);
                    }
                    hVar.d();
                    tokeniserState = Data;
                } else {
                    tokeniserState = CommentStartDash;
                }
                hVar.a(tokeniserState);
            }
            hVar.c((TokeniserState) this);
            hVar.f33861h.a(65533);
            tokeniserState = Comment;
            hVar.a(tokeniserState);
        }
    },
    CommentStartDash {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != '-') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        hVar.f33861h.a(e2);
                    } else {
                        hVar.d(this);
                    }
                    hVar.d();
                    tokeniserState = Data;
                } else {
                    tokeniserState = CommentStartDash;
                }
                hVar.a(tokeniserState);
            }
            hVar.c((TokeniserState) this);
            hVar.f33861h.a(65533);
            tokeniserState = Comment;
            hVar.a(tokeniserState);
        }
    },
    Comment {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            char d2 = aVar.d();
            if (d2 == 0) {
                hVar.c((TokeniserState) this);
                aVar.g();
                hVar.f33861h.a(65533);
            } else if (d2 == '-') {
                hVar.b(CommentEndDash);
            } else if (d2 != 65535) {
                hVar.f33861h.a(aVar.a('-', 0));
            } else {
                hVar.d(this);
                hVar.d();
                hVar.a(Data);
            }
        }
    },
    CommentEndDash {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 == '-') {
                    tokeniserState = CommentEnd;
                } else if (e2 != 65535) {
                    hVar.f33861h.a('-').a(e2);
                } else {
                    hVar.d(this);
                    hVar.d();
                    tokeniserState = Data;
                }
                hVar.a(tokeniserState);
            }
            hVar.c((TokeniserState) this);
            hVar.f33861h.a('-').a(65533);
            tokeniserState = Comment;
            hVar.a(tokeniserState);
        }
    },
    CommentEnd {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 == '!') {
                    hVar.c((TokeniserState) this);
                    tokeniserState = CommentEndBang;
                } else if (e2 != '-') {
                    if (e2 != '>') {
                        if (e2 != 65535) {
                            hVar.c((TokeniserState) this);
                            hVar.f33861h.a("--").a(e2);
                        } else {
                            hVar.d(this);
                        }
                    }
                    hVar.d();
                    tokeniserState = Data;
                } else {
                    hVar.c((TokeniserState) this);
                    hVar.f33861h.a('-');
                    return;
                }
                hVar.a(tokeniserState);
            }
            hVar.c((TokeniserState) this);
            hVar.f33861h.a("--").a(65533);
            tokeniserState = Comment;
            hVar.a(tokeniserState);
        }
    },
    CommentEndBang {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != '-') {
                    if (e2 != '>') {
                        if (e2 != 65535) {
                            hVar.f33861h.a("--!").a(e2);
                        } else {
                            hVar.d(this);
                        }
                    }
                    hVar.d();
                    tokeniserState = Data;
                } else {
                    hVar.f33861h.a("--!");
                    tokeniserState = CommentEndDash;
                }
                hVar.a(tokeniserState);
            }
            hVar.c((TokeniserState) this);
            hVar.f33861h.a("--!").a(65533);
            tokeniserState = Comment;
            hVar.a(tokeniserState);
        }
    },
    Doctype {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (!(e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ')) {
                if (e2 != '>') {
                    if (e2 != 65535) {
                        hVar.c((TokeniserState) this);
                    } else {
                        hVar.d(this);
                    }
                }
                hVar.c((TokeniserState) this);
                hVar.f();
                hVar.f33860g.f33741f = true;
                hVar.g();
                tokeniserState = Data;
                hVar.a(tokeniserState);
            }
            tokeniserState = BeforeDoctypeName;
            hVar.a(tokeniserState);
        }
    },
    BeforeDoctypeName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            if (aVar.s()) {
                hVar.f();
                hVar.a(DoctypeName);
                return;
            }
            char e2 = aVar.e();
            if (e2 == 0) {
                hVar.c((TokeniserState) this);
                hVar.f();
                hVar.f33860g.f33737b.append(65533);
            } else if (e2 == ' ') {
                return;
            } else {
                if (e2 == 65535) {
                    hVar.d(this);
                    hVar.f();
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    tokeniserState = Data;
                    hVar.a(tokeniserState);
                } else if (e2 != 9 && e2 != 10 && e2 != 12 && e2 != 13) {
                    hVar.f();
                    hVar.f33860g.f33737b.append(e2);
                } else {
                    return;
                }
            }
            tokeniserState = DoctypeName;
            hVar.a(tokeniserState);
        }
    },
    DoctypeName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            if (aVar.s()) {
                hVar.f33860g.f33737b.append(aVar.o());
                return;
            }
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != ' ') {
                    if (e2 != '>') {
                        if (e2 == 65535) {
                            hVar.d(this);
                            hVar.f33860g.f33741f = true;
                        } else if (!(e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13)) {
                            sb = hVar.f33860g.f33737b;
                        }
                    }
                    hVar.g();
                    tokeniserState = Data;
                    hVar.a(tokeniserState);
                    return;
                }
                tokeniserState = AfterDoctypeName;
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            sb = hVar.f33860g.f33737b;
            e2 = 65533;
            sb.append(e2);
        }
    },
    AfterDoctypeName {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            TokeniserState tokeniserState2;
            if (aVar.c()) {
                hVar.d(this);
                hVar.f33860g.f33741f = true;
                hVar.g();
                hVar.a(Data);
            } else if (aVar.c(9, 10, 13, 12, ' ')) {
                aVar.g();
            } else {
                if (aVar.c('>')) {
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    if (aVar.e("PUBLIC")) {
                        hVar.f33860g.f33738c = "PUBLIC";
                        tokeniserState2 = AfterDoctypePublicKeyword;
                    } else if (aVar.e("SYSTEM")) {
                        hVar.f33860g.f33738c = "SYSTEM";
                        tokeniserState2 = AfterDoctypeSystemKeyword;
                    } else {
                        hVar.c((TokeniserState) this);
                        hVar.f33860g.f33741f = true;
                        tokeniserState = BogusDoctype;
                    }
                    hVar.a(tokeniserState2);
                    return;
                }
                hVar.b(tokeniserState);
            }
        }
    },
    AfterDoctypePublicKeyword {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ') {
                tokeniserState = BeforeDoctypePublicIdentifier;
            } else if (e2 == '\"') {
                hVar.c((TokeniserState) this);
                tokeniserState = DoctypePublicIdentifier_doubleQuoted;
            } else if (e2 != '\'') {
                if (e2 == '>') {
                    hVar.c((TokeniserState) this);
                } else if (e2 != 65535) {
                    hVar.c((TokeniserState) this);
                    hVar.f33860g.f33741f = true;
                    tokeniserState = BogusDoctype;
                } else {
                    hVar.d(this);
                }
                hVar.f33860g.f33741f = true;
                hVar.g();
                tokeniserState = Data;
            } else {
                hVar.c((TokeniserState) this);
                tokeniserState = DoctypePublicIdentifier_singleQuoted;
            }
            hVar.a(tokeniserState);
        }
    },
    BeforeDoctypePublicIdentifier {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 9 && e2 != 10 && e2 != 12 && e2 != 13 && e2 != ' ') {
                if (e2 == '\"') {
                    tokeniserState = DoctypePublicIdentifier_doubleQuoted;
                } else if (e2 != '\'') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        hVar.c((TokeniserState) this);
                        hVar.f33860g.f33741f = true;
                        tokeniserState = BogusDoctype;
                    } else {
                        hVar.d(this);
                    }
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    tokeniserState = DoctypePublicIdentifier_singleQuoted;
                }
                hVar.a(tokeniserState);
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != '\"') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        sb = hVar.f33860g.f33739d;
                    } else {
                        hVar.d(this);
                    }
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    tokeniserState = AfterDoctypePublicIdentifier;
                }
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            sb = hVar.f33860g.f33739d;
            e2 = 65533;
            sb.append(e2);
        }
    },
    DoctypePublicIdentifier_singleQuoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != '\'') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        sb = hVar.f33860g.f33739d;
                    } else {
                        hVar.d(this);
                    }
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    tokeniserState = AfterDoctypePublicIdentifier;
                }
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            sb = hVar.f33860g.f33739d;
            e2 = 65533;
            sb.append(e2);
        }
    },
    AfterDoctypePublicIdentifier {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ') {
                tokeniserState = BetweenDoctypePublicAndSystemIdentifiers;
            } else if (e2 == '\"') {
                hVar.c((TokeniserState) this);
                tokeniserState = DoctypeSystemIdentifier_doubleQuoted;
            } else if (e2 != '\'') {
                if (e2 != '>') {
                    if (e2 != 65535) {
                        hVar.c((TokeniserState) this);
                        hVar.f33860g.f33741f = true;
                        tokeniserState = BogusDoctype;
                    } else {
                        hVar.d(this);
                        hVar.f33860g.f33741f = true;
                    }
                }
                hVar.g();
                tokeniserState = Data;
            } else {
                hVar.c((TokeniserState) this);
                tokeniserState = DoctypeSystemIdentifier_singleQuoted;
            }
            hVar.a(tokeniserState);
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 9 && e2 != 10 && e2 != 12 && e2 != 13 && e2 != ' ') {
                if (e2 == '\"') {
                    hVar.c((TokeniserState) this);
                    tokeniserState = DoctypeSystemIdentifier_doubleQuoted;
                } else if (e2 != '\'') {
                    if (e2 != '>') {
                        if (e2 != 65535) {
                            hVar.c((TokeniserState) this);
                            hVar.f33860g.f33741f = true;
                            tokeniserState = BogusDoctype;
                        } else {
                            hVar.d(this);
                            hVar.f33860g.f33741f = true;
                        }
                    }
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    hVar.c((TokeniserState) this);
                    tokeniserState = DoctypeSystemIdentifier_singleQuoted;
                }
                hVar.a(tokeniserState);
            }
        }
    },
    AfterDoctypeSystemKeyword {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ') {
                tokeniserState = BeforeDoctypeSystemIdentifier;
            } else if (e2 == '\"') {
                hVar.c((TokeniserState) this);
                tokeniserState = DoctypeSystemIdentifier_doubleQuoted;
            } else if (e2 != '\'') {
                if (e2 == '>') {
                    hVar.c((TokeniserState) this);
                } else if (e2 != 65535) {
                    hVar.c((TokeniserState) this);
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    return;
                } else {
                    hVar.d(this);
                }
                hVar.f33860g.f33741f = true;
                hVar.g();
                tokeniserState = Data;
            } else {
                hVar.c((TokeniserState) this);
                tokeniserState = DoctypeSystemIdentifier_singleQuoted;
            }
            hVar.a(tokeniserState);
        }
    },
    BeforeDoctypeSystemIdentifier {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 9 && e2 != 10 && e2 != 12 && e2 != 13 && e2 != ' ') {
                if (e2 == '\"') {
                    tokeniserState = DoctypeSystemIdentifier_doubleQuoted;
                } else if (e2 != '\'') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        hVar.c((TokeniserState) this);
                        hVar.f33860g.f33741f = true;
                        tokeniserState = BogusDoctype;
                    } else {
                        hVar.d(this);
                    }
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    tokeniserState = DoctypeSystemIdentifier_singleQuoted;
                }
                hVar.a(tokeniserState);
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != '\"') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        sb = hVar.f33860g.f33740e;
                    } else {
                        hVar.d(this);
                    }
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    tokeniserState = AfterDoctypeSystemIdentifier;
                }
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            sb = hVar.f33860g.f33740e;
            e2 = 65533;
            sb.append(e2);
        }
    },
    DoctypeSystemIdentifier_singleQuoted {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            StringBuilder sb;
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 0) {
                if (e2 != '\'') {
                    if (e2 == '>') {
                        hVar.c((TokeniserState) this);
                    } else if (e2 != 65535) {
                        sb = hVar.f33860g.f33740e;
                    } else {
                        hVar.d(this);
                    }
                    hVar.f33860g.f33741f = true;
                    hVar.g();
                    tokeniserState = Data;
                } else {
                    tokeniserState = AfterDoctypeSystemIdentifier;
                }
                hVar.a(tokeniserState);
                return;
            }
            hVar.c((TokeniserState) this);
            sb = hVar.f33860g.f33740e;
            e2 = 65533;
            sb.append(e2);
        }
    },
    AfterDoctypeSystemIdentifier {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            TokeniserState tokeniserState;
            char e2 = aVar.e();
            if (e2 != 9 && e2 != 10 && e2 != 12 && e2 != 13 && e2 != ' ') {
                if (e2 != '>') {
                    if (e2 != 65535) {
                        hVar.c((TokeniserState) this);
                        tokeniserState = BogusDoctype;
                        hVar.a(tokeniserState);
                    }
                    hVar.d(this);
                    hVar.f33860g.f33741f = true;
                }
                hVar.g();
                tokeniserState = Data;
                hVar.a(tokeniserState);
            }
        }
    },
    BogusDoctype {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            char e2 = aVar.e();
            if (e2 == '>' || e2 == 65535) {
                hVar.g();
                hVar.a(Data);
            }
        }
    },
    CdataSection {
        /* access modifiers changed from: package-private */
        public void a(h hVar, a aVar) {
            hVar.f33855b.append(aVar.a("]]>"));
            if (aVar.d("]]>") || aVar.c()) {
                hVar.a((Token) new Token.a(hVar.f33855b.toString()));
                hVar.a(Data);
            }
        }
    };
    

    /* renamed from: ap  reason: collision with root package name */
    static final char[] f33767ap = null;

    /* renamed from: aq  reason: collision with root package name */
    static final char[] f33768aq = null;

    /* renamed from: ar  reason: collision with root package name */
    static final char[] f33769ar = null;

    /* renamed from: as  reason: collision with root package name */
    static final char[] f33770as = null;
    /* access modifiers changed from: private */

    /* renamed from: at  reason: collision with root package name */
    public static final String f33771at = null;

    static {
        f33767ap = new char[]{0, '&', '\''};
        f33768aq = new char[]{0, '\"', '&'};
        f33769ar = new char[]{0, 9, 10, 12, 13, ' ', '\"', '\'', '/', '<', '=', '>'};
        f33770as = new char[]{0, 9, 10, 12, 13, ' ', '\"', '&', '\'', '<', '=', '>', '`'};
        f33771at = String.valueOf(65533);
    }

    /* access modifiers changed from: private */
    public static void b(h hVar, TokeniserState tokeniserState) {
        int[] a2 = hVar.a((Character) null, false);
        if (a2 == null) {
            hVar.a('&');
        } else {
            hVar.a(a2);
        }
        hVar.a(tokeniserState);
    }

    /* access modifiers changed from: private */
    public static void b(h hVar, a aVar, TokeniserState tokeniserState) {
        TokeniserState tokeniserState2;
        if (aVar.s()) {
            String o2 = aVar.o();
            hVar.f33856c.b(o2);
            hVar.f33855b.append(o2);
            return;
        }
        boolean z2 = false;
        boolean z3 = true;
        if (hVar.i() && !aVar.c()) {
            char e2 = aVar.e();
            if (e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ') {
                tokeniserState2 = BeforeAttributeName;
            } else if (e2 == '/') {
                tokeniserState2 = SelfClosingStartTag;
            } else if (e2 != '>') {
                hVar.f33855b.append(e2);
                z2 = true;
                z3 = z2;
            } else {
                hVar.b();
                tokeniserState2 = Data;
            }
            hVar.a(tokeniserState2);
            z3 = z2;
        }
        if (z3) {
            hVar.a("</" + hVar.f33855b.toString());
            hVar.a(tokeniserState);
        }
    }

    /* access modifiers changed from: private */
    public static void d(h hVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        char d2 = aVar.d();
        if (d2 == 0) {
            hVar.c(tokeniserState);
            aVar.g();
            hVar.a(65533);
        } else if (d2 == '<') {
            hVar.b(tokeniserState2);
        } else if (d2 != 65535) {
            hVar.a(aVar.l());
        } else {
            hVar.a((Token) new Token.e());
        }
    }

    /* access modifiers changed from: private */
    public static void e(h hVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (aVar.s()) {
            hVar.a(false);
            hVar.a(tokeniserState);
            return;
        }
        hVar.a("</");
        hVar.a(tokeniserState2);
    }

    /* access modifiers changed from: private */
    public static void f(h hVar, a aVar, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (aVar.s()) {
            String o2 = aVar.o();
            hVar.f33855b.append(o2);
            hVar.a(o2);
            return;
        }
        char e2 = aVar.e();
        if (e2 == 9 || e2 == 10 || e2 == 12 || e2 == 13 || e2 == ' ' || e2 == '/' || e2 == '>') {
            if (hVar.f33855b.toString().equals("script")) {
                hVar.a(tokeniserState);
            } else {
                hVar.a(tokeniserState2);
            }
            hVar.a(e2);
            return;
        }
        aVar.f();
        hVar.a(tokeniserState2);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(h hVar, a aVar);
}
