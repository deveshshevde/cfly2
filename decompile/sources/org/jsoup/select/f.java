package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oh.b;
import org.jsoup.helper.c;
import org.jsoup.parser.g;
import org.jsoup.select.Selector;
import org.jsoup.select.b;
import org.jsoup.select.c;
import org.jsoup.select.g;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f33915a = {",", ">", "+", "~", " "};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f33916b = {"=", "!=", "^=", "$=", "*=", "~="};

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f33917f = Pattern.compile("(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f33918g = Pattern.compile("([+-])?(\\d+)");

    /* renamed from: c  reason: collision with root package name */
    private g f33919c;

    /* renamed from: d  reason: collision with root package name */
    private String f33920d;

    /* renamed from: e  reason: collision with root package name */
    private List<c> f33921e = new ArrayList();

    private f(String str) {
        c.a(str);
        String trim = str.trim();
        this.f33920d = trim;
        this.f33919c = new g(trim);
    }

    public static c a(String str) {
        try {
            return new f(str).a();
        } catch (IllegalArgumentException e2) {
            throw new Selector.SelectorParseException(e2.getMessage(), new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(char r11) {
        /*
            r10 = this;
            org.jsoup.parser.g r0 = r10.f33919c
            r0.e()
            java.lang.String r0 = r10.b()
            org.jsoup.select.c r0 = a((java.lang.String) r0)
            java.util.List<org.jsoup.select.c> r1 = r10.f33921e
            int r1 = r1.size()
            r2 = 44
            r3 = 1
            r4 = 0
            if (r1 != r3) goto L_0x0033
            java.util.List<org.jsoup.select.c> r1 = r10.f33921e
            java.lang.Object r1 = r1.get(r4)
            org.jsoup.select.c r1 = (org.jsoup.select.c) r1
            boolean r5 = r1 instanceof org.jsoup.select.b.C0246b
            if (r5 == 0) goto L_0x003a
            if (r11 == r2) goto L_0x003a
            r5 = r1
            org.jsoup.select.b$b r5 = (org.jsoup.select.b.C0246b) r5
            org.jsoup.select.c r5 = r5.a()
            r6 = 1
            r9 = r5
            r5 = r1
            r1 = r9
            goto L_0x003c
        L_0x0033:
            org.jsoup.select.b$a r1 = new org.jsoup.select.b$a
            java.util.List<org.jsoup.select.c> r5 = r10.f33921e
            r1.<init>((java.util.Collection<org.jsoup.select.c>) r5)
        L_0x003a:
            r5 = r1
            r6 = 0
        L_0x003c:
            java.util.List<org.jsoup.select.c> r7 = r10.f33921e
            r7.clear()
            r7 = 62
            r8 = 2
            if (r11 != r7) goto L_0x0057
            org.jsoup.select.b$a r11 = new org.jsoup.select.b$a
            org.jsoup.select.c[] r2 = new org.jsoup.select.c[r8]
            r2[r4] = r0
            org.jsoup.select.g$b r0 = new org.jsoup.select.g$b
            r0.<init>(r1)
            r2[r3] = r0
            r11.<init>((org.jsoup.select.c[]) r2)
            goto L_0x00ae
        L_0x0057:
            r7 = 32
            if (r11 != r7) goto L_0x006c
            org.jsoup.select.b$a r11 = new org.jsoup.select.b$a
            org.jsoup.select.c[] r2 = new org.jsoup.select.c[r8]
            r2[r4] = r0
            org.jsoup.select.g$e r0 = new org.jsoup.select.g$e
            r0.<init>(r1)
            r2[r3] = r0
            r11.<init>((org.jsoup.select.c[]) r2)
            goto L_0x00ae
        L_0x006c:
            r7 = 43
            if (r11 != r7) goto L_0x0081
            org.jsoup.select.b$a r11 = new org.jsoup.select.b$a
            org.jsoup.select.c[] r2 = new org.jsoup.select.c[r8]
            r2[r4] = r0
            org.jsoup.select.g$c r0 = new org.jsoup.select.g$c
            r0.<init>(r1)
            r2[r3] = r0
            r11.<init>((org.jsoup.select.c[]) r2)
            goto L_0x00ae
        L_0x0081:
            r7 = 126(0x7e, float:1.77E-43)
            if (r11 != r7) goto L_0x0096
            org.jsoup.select.b$a r11 = new org.jsoup.select.b$a
            org.jsoup.select.c[] r2 = new org.jsoup.select.c[r8]
            r2[r4] = r0
            org.jsoup.select.g$f r0 = new org.jsoup.select.g$f
            r0.<init>(r1)
            r2[r3] = r0
            r11.<init>((org.jsoup.select.c[]) r2)
            goto L_0x00ae
        L_0x0096:
            if (r11 != r2) goto L_0x00be
            boolean r11 = r1 instanceof org.jsoup.select.b.C0246b
            if (r11 == 0) goto L_0x00a3
            org.jsoup.select.b$b r1 = (org.jsoup.select.b.C0246b) r1
            r1.b(r0)
            r11 = r1
            goto L_0x00ae
        L_0x00a3:
            org.jsoup.select.b$b r11 = new org.jsoup.select.b$b
            r11.<init>()
            r11.b(r1)
            r11.b(r0)
        L_0x00ae:
            if (r6 == 0) goto L_0x00b7
            r0 = r5
            org.jsoup.select.b$b r0 = (org.jsoup.select.b.C0246b) r0
            r0.a(r11)
            goto L_0x00b8
        L_0x00b7:
            r5 = r11
        L_0x00b8:
            java.util.List<org.jsoup.select.c> r11 = r10.f33921e
            r11.add(r5)
            return
        L_0x00be:
            org.jsoup.select.Selector$SelectorParseException r0 = new org.jsoup.select.Selector$SelectorParseException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown combinator: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r0.<init>(r11, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.f.a(char):void");
    }

    private void a(boolean z2) {
        List<c> list;
        Object obj;
        this.f33919c.c(z2 ? ":containsOwn" : ":contains");
        String f2 = g.f(this.f33919c.a('(', ')'));
        c.a(f2, ":contains(text) query must not be empty");
        if (z2) {
            list = this.f33921e;
            obj = new c.m(f2);
        } else {
            list = this.f33921e;
            obj = new c.n(f2);
        }
        list.add(obj);
    }

    private void a(boolean z2, boolean z3) {
        Object obj;
        List<c> list;
        String b2 = b.b(this.f33919c.e(")"));
        Matcher matcher = f33917f.matcher(b2);
        Matcher matcher2 = f33918g.matcher(b2);
        int i2 = 2;
        int i3 = 0;
        if ("odd".equals(b2)) {
            i3 = 1;
        } else if (!"even".equals(b2)) {
            if (matcher.matches()) {
                int parseInt = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                if (matcher.group(4) != null) {
                    i3 = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                }
                i2 = parseInt;
            } else if (matcher2.matches()) {
                i3 = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i2 = 0;
            } else {
                throw new Selector.SelectorParseException("Could not parse nth-index '%s': unexpected format", b2);
            }
        }
        if (z3) {
            if (z2) {
                list = this.f33921e;
                obj = new c.ab(i2, i3);
            } else {
                list = this.f33921e;
                obj = new c.ac(i2, i3);
            }
        } else if (z2) {
            list = this.f33921e;
            obj = new c.aa(i2, i3);
        } else {
            list = this.f33921e;
            obj = new c.z(i2, i3);
        }
        list.add(obj);
    }

    private String b() {
        String str;
        StringBuilder a2 = oh.c.a();
        while (!this.f33919c.a()) {
            if (this.f33919c.a("(")) {
                a2.append("(");
                a2.append(this.f33919c.a('(', ')'));
                str = ")";
            } else if (this.f33919c.a("[")) {
                a2.append("[");
                a2.append(this.f33919c.a('[', ']'));
                str = "]";
            } else if (this.f33919c.a(f33915a)) {
                break;
            } else {
                a2.append(this.f33919c.d());
            }
            a2.append(str);
        }
        return oh.c.a(a2);
    }

    private void b(boolean z2) {
        List<c> list;
        Object obj;
        this.f33919c.c(z2 ? ":matchesOwn" : ":matches");
        String a2 = this.f33919c.a('(', ')');
        org.jsoup.helper.c.a(a2, ":matches(regex) query must not be empty");
        if (z2) {
            list = this.f33921e;
            obj = new c.ai(Pattern.compile(a2));
        } else {
            list = this.f33921e;
            obj = new c.ah(Pattern.compile(a2));
        }
        list.add(obj);
    }

    private void c() {
        List<c> list;
        Object agVar;
        if (this.f33919c.b("#")) {
            d();
        } else if (this.f33919c.b(".")) {
            e();
        } else if (this.f33919c.c() || this.f33919c.a("*|")) {
            f();
        } else if (this.f33919c.a("[")) {
            g();
        } else if (this.f33919c.b("*")) {
            h();
        } else if (this.f33919c.b(":lt(")) {
            i();
        } else if (this.f33919c.b(":gt(")) {
            j();
        } else if (this.f33919c.b(":eq(")) {
            k();
        } else if (this.f33919c.a(":has(")) {
            m();
        } else if (this.f33919c.a(":contains(")) {
            a(false);
        } else if (this.f33919c.a(":containsOwn(")) {
            a(true);
        } else if (this.f33919c.a(":containsData(")) {
            n();
        } else if (this.f33919c.a(":matches(")) {
            b(false);
        } else if (this.f33919c.a(":matchesOwn(")) {
            b(true);
        } else if (this.f33919c.a(":not(")) {
            o();
        } else if (this.f33919c.b(":nth-child(")) {
            a(false, false);
        } else if (this.f33919c.b(":nth-last-child(")) {
            a(true, false);
        } else if (this.f33919c.b(":nth-of-type(")) {
            a(false, true);
        } else if (this.f33919c.b(":nth-last-of-type(")) {
            a(true, true);
        } else {
            if (this.f33919c.b(":first-child")) {
                list = this.f33921e;
                agVar = new c.v();
            } else if (this.f33919c.b(":last-child")) {
                list = this.f33921e;
                agVar = new c.x();
            } else if (this.f33919c.b(":first-of-type")) {
                list = this.f33921e;
                agVar = new c.w();
            } else if (this.f33919c.b(":last-of-type")) {
                list = this.f33921e;
                agVar = new c.y();
            } else if (this.f33919c.b(":only-child")) {
                list = this.f33921e;
                agVar = new c.ad();
            } else if (this.f33919c.b(":only-of-type")) {
                list = this.f33921e;
                agVar = new c.ae();
            } else if (this.f33919c.b(":empty")) {
                list = this.f33921e;
                agVar = new c.u();
            } else if (this.f33919c.b(":root")) {
                list = this.f33921e;
                agVar = new c.af();
            } else if (this.f33919c.b(":matchText")) {
                list = this.f33921e;
                agVar = new c.ag();
            } else {
                throw new Selector.SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.f33920d, this.f33919c.h());
            }
            list.add(agVar);
        }
    }

    private void d() {
        String g2 = this.f33919c.g();
        org.jsoup.helper.c.a(g2);
        this.f33921e.add(new c.p(g2));
    }

    private void e() {
        String g2 = this.f33919c.g();
        org.jsoup.helper.c.a(g2);
        this.f33921e.add(new c.k(g2.trim()));
    }

    private void f() {
        String b2 = b.b(this.f33919c.f());
        org.jsoup.helper.c.a(b2);
        if (b2.startsWith("*|")) {
            this.f33921e.add(new b.C0246b(new c.aj(b2), new c.ak(b2.replace("*|", ":"))));
            return;
        }
        if (b2.contains("|")) {
            b2 = b2.replace("|", ":");
        }
        this.f33921e.add(new c.aj(b2));
    }

    private void g() {
        List<c> list;
        Object hVar;
        Object obj;
        List<c> list2;
        g gVar = new g(this.f33919c.a('[', ']'));
        String b2 = gVar.b(f33916b);
        org.jsoup.helper.c.a(b2);
        gVar.e();
        if (gVar.a()) {
            if (b2.startsWith("^")) {
                list2 = this.f33921e;
                obj = new c.d(b2.substring(1));
            } else {
                list2 = this.f33921e;
                obj = new c.b(b2);
            }
            list2.add(obj);
            return;
        }
        if (gVar.b("=")) {
            list = this.f33921e;
            hVar = new c.e(b2, gVar.h());
        } else if (gVar.b("!=")) {
            list = this.f33921e;
            hVar = new c.i(b2, gVar.h());
        } else if (gVar.b("^=")) {
            list = this.f33921e;
            hVar = new c.j(b2, gVar.h());
        } else if (gVar.b("$=")) {
            list = this.f33921e;
            hVar = new c.g(b2, gVar.h());
        } else if (gVar.b("*=")) {
            list = this.f33921e;
            hVar = new c.f(b2, gVar.h());
        } else if (gVar.b("~=")) {
            list = this.f33921e;
            hVar = new c.h(b2, Pattern.compile(gVar.h()));
        } else {
            throw new Selector.SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.f33920d, gVar.h());
        }
        list.add(hVar);
    }

    private void h() {
        this.f33921e.add(new c.a());
    }

    private void i() {
        this.f33921e.add(new c.t(l()));
    }

    private void j() {
        this.f33921e.add(new c.s(l()));
    }

    private void k() {
        this.f33921e.add(new c.q(l()));
    }

    private int l() {
        String trim = this.f33919c.e(")").trim();
        org.jsoup.helper.c.a(oh.c.b(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private void m() {
        this.f33919c.c(":has");
        String a2 = this.f33919c.a('(', ')');
        org.jsoup.helper.c.a(a2, ":has(el) subselect must not be empty");
        this.f33921e.add(new g.a(a(a2)));
    }

    private void n() {
        this.f33919c.c(":containsData");
        String f2 = org.jsoup.parser.g.f(this.f33919c.a('(', ')'));
        org.jsoup.helper.c.a(f2, ":containsData(text) query must not be empty");
        this.f33921e.add(new c.l(f2));
    }

    private void o() {
        this.f33919c.c(":not");
        String a2 = this.f33919c.a('(', ')');
        org.jsoup.helper.c.a(a2, ":not(selector) subselect must not be empty");
        this.f33921e.add(new g.d(a(a2)));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jsoup.select.c a() {
        /*
            r3 = this;
            org.jsoup.parser.g r0 = r3.f33919c
            r0.e()
            org.jsoup.parser.g r0 = r3.f33919c
            java.lang.String[] r1 = f33915a
            boolean r0 = r0.a((java.lang.String[]) r1)
            if (r0 == 0) goto L_0x0023
            java.util.List<org.jsoup.select.c> r0 = r3.f33921e
            org.jsoup.select.g$g r1 = new org.jsoup.select.g$g
            r1.<init>()
            r0.add(r1)
        L_0x0019:
            org.jsoup.parser.g r0 = r3.f33919c
            char r0 = r0.d()
        L_0x001f:
            r3.a((char) r0)
            goto L_0x0026
        L_0x0023:
            r3.c()
        L_0x0026:
            org.jsoup.parser.g r0 = r3.f33919c
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0044
            org.jsoup.parser.g r0 = r3.f33919c
            boolean r0 = r0.e()
            org.jsoup.parser.g r1 = r3.f33919c
            java.lang.String[] r2 = f33915a
            boolean r1 = r1.a((java.lang.String[]) r2)
            if (r1 == 0) goto L_0x003f
            goto L_0x0019
        L_0x003f:
            if (r0 == 0) goto L_0x0023
            r0 = 32
            goto L_0x001f
        L_0x0044:
            java.util.List<org.jsoup.select.c> r0 = r3.f33921e
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L_0x0057
            java.util.List<org.jsoup.select.c> r0 = r3.f33921e
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            org.jsoup.select.c r0 = (org.jsoup.select.c) r0
            return r0
        L_0x0057:
            org.jsoup.select.b$a r0 = new org.jsoup.select.b$a
            java.util.List<org.jsoup.select.c> r1 = r3.f33921e
            r0.<init>((java.util.Collection<org.jsoup.select.c>) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.f.a():org.jsoup.select.c");
    }
}
