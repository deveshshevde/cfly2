package org.jsoup.parser;

import com.amap.api.mapcore.util.dt;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.d;
import org.jsoup.nodes.e;
import org.jsoup.nodes.h;
import org.jsoup.nodes.j;
import org.jsoup.nodes.m;
import org.jsoup.parser.Token;

public class b extends i {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f33807a = {"applet", "caption", "html", "marquee", "object", "table", "td", "th"};

    /* renamed from: b  reason: collision with root package name */
    static final String[] f33808b = {"ol", "ul"};

    /* renamed from: c  reason: collision with root package name */
    static final String[] f33809c = {"button"};

    /* renamed from: d  reason: collision with root package name */
    static final String[] f33810d = {"html", "table"};

    /* renamed from: e  reason: collision with root package name */
    static final String[] f33811e = {"optgroup", "option"};

    /* renamed from: f  reason: collision with root package name */
    static final String[] f33812f = {"dd", dt.f8292a, "li", "optgroup", "option", "p", "rp", "rt"};

    /* renamed from: g  reason: collision with root package name */
    static final String[] f33813g = {"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", dt.f8292a, "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};

    /* renamed from: h  reason: collision with root package name */
    static final /* synthetic */ boolean f33814h = true;
    private boolean A;
    private boolean B;
    private String[] C = {null};

    /* renamed from: q  reason: collision with root package name */
    private HtmlTreeBuilderState f33815q;

    /* renamed from: r  reason: collision with root package name */
    private HtmlTreeBuilderState f33816r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f33817s;

    /* renamed from: t  reason: collision with root package name */
    private Element f33818t;

    /* renamed from: u  reason: collision with root package name */
    private h f33819u;

    /* renamed from: v  reason: collision with root package name */
    private Element f33820v;

    /* renamed from: w  reason: collision with root package name */
    private ArrayList<Element> f33821w;

    /* renamed from: x  reason: collision with root package name */
    private List<String> f33822x;

    /* renamed from: y  reason: collision with root package name */
    private Token.f f33823y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f33824z;

    private void a(ArrayList<Element> arrayList, Element element, Element element2) {
        int lastIndexOf = arrayList.lastIndexOf(element);
        c.a(lastIndexOf != -1);
        arrayList.set(lastIndexOf, element2);
    }

    private boolean a(String str, String[] strArr, String[] strArr2) {
        String[] strArr3 = this.C;
        strArr3[0] = str;
        return a(strArr3, strArr, strArr2);
    }

    private boolean a(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.f33878m.size() - 1;
        int i2 = size > 100 ? size - 100 : 0;
        while (size >= i2) {
            String r2 = ((Element) this.f33878m.get(size)).r();
            if (oh.c.b(r2, strArr)) {
                return true;
            }
            if (oh.c.b(r2, strArr2)) {
                return false;
            }
            if (strArr3 != null && oh.c.b(r2, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    private void b(j jVar) {
        h hVar;
        if (this.f33878m.isEmpty()) {
            this.f33877l.a(jVar);
        } else if (p()) {
            a(jVar);
        } else {
            A().a(jVar);
        }
        if (jVar instanceof Element) {
            Element element = (Element) jVar;
            if (element.s().j() && (hVar = this.f33819u) != null) {
                hVar.b(element);
            }
        }
    }

    private void c(String... strArr) {
        int size = this.f33878m.size() - 1;
        while (size >= 0) {
            Element element = (Element) this.f33878m.get(size);
            if (!oh.c.a(element.r(), strArr) && !element.r().equals("html")) {
                this.f33878m.remove(size);
                size--;
            } else {
                return;
            }
        }
    }

    private boolean d(Element element, Element element2) {
        return element.r().equals(element2.r()) && element.p().equals(element2.p());
    }

    /* access modifiers changed from: package-private */
    public Element a(String str) {
        Element element = new Element(f.a(str, this.f33881p), (String) null);
        b(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public Element a(Token.g gVar) {
        if (gVar.f33745e != null && !gVar.f33745e.b() && gVar.f33745e.a(this.f33881p) > 0) {
            n("Duplicate attribute");
        }
        if (gVar.t()) {
            Element b2 = b(gVar);
            this.f33878m.add(b2);
            this.f33876k.a(TokeniserState.Data);
            this.f33876k.a((Token) this.f33823y.b().a(b2.q()));
            return b2;
        }
        Element element = new Element(f.a(gVar.r(), this.f33881p), (String) null, this.f33881p.a(gVar.f33745e));
        b(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    public h a(Token.g gVar, boolean z2) {
        h hVar = new h(f.a(gVar.r(), this.f33881p), (String) null, this.f33881p.a(gVar.f33745e));
        a(hVar);
        b((j) hVar);
        if (z2) {
            this.f33878m.add(hVar);
        }
        return hVar;
    }

    /* access modifiers changed from: package-private */
    public d a() {
        return d.f33827a;
    }

    /* access modifiers changed from: protected */
    public void a(Reader reader, String str, e eVar) {
        super.a(reader, str, eVar);
        this.f33815q = HtmlTreeBuilderState.Initial;
        this.f33816r = null;
        this.f33817s = false;
        this.f33818t = null;
        this.f33819u = null;
        this.f33820v = null;
        this.f33821w = new ArrayList<>();
        this.f33822x = new ArrayList();
        this.f33823y = new Token.f();
        this.f33824z = true;
        this.A = false;
        this.B = false;
    }

    /* access modifiers changed from: package-private */
    public void a(Element element) {
        if (!this.f33817s) {
            String a2 = element.a("href");
            if (a2.length() != 0) {
                this.f33879n = a2;
                this.f33817s = true;
                this.f33877l.i(a2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Element element, Element element2) {
        int lastIndexOf = this.f33878m.lastIndexOf(element);
        c.a(lastIndexOf != -1);
        this.f33878m.add(lastIndexOf + 1, element2);
    }

    /* access modifiers changed from: package-private */
    public void a(h hVar) {
        this.f33819u = hVar;
    }

    /* access modifiers changed from: package-private */
    public void a(j jVar) {
        Element element;
        Element b2 = b("table");
        boolean z2 = false;
        if (b2 == null) {
            element = (Element) this.f33878m.get(0);
        } else if (b2.K() != null) {
            element = b2.K();
            z2 = true;
        } else {
            element = f(b2);
        }
        if (z2) {
            c.a((Object) b2);
            b2.g(jVar);
            return;
        }
        element.a(jVar);
    }

    /* access modifiers changed from: package-private */
    public void a(HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f33815q = htmlTreeBuilderState;
    }

    /* access modifiers changed from: package-private */
    public void a(Token.b bVar) {
        Element A2 = A();
        if (A2 == null) {
            A2 = this.f33877l;
        }
        String r2 = A2.r();
        String o2 = bVar.o();
        A2.a(bVar.l() ? new org.jsoup.nodes.c(o2) : (r2.equals("script") || r2.equals("style")) ? new e(o2) : new m(o2));
    }

    /* access modifiers changed from: package-private */
    public void a(Token.c cVar) {
        b((j) new d(cVar.o()));
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f33824z = z2;
    }

    /* access modifiers changed from: package-private */
    public void a(String... strArr) {
        int size = this.f33878m.size() - 1;
        while (size >= 0) {
            this.f33878m.remove(size);
            if (!oh.c.b(((Element) this.f33878m.get(size)).r(), strArr)) {
                size--;
            } else {
                return;
            }
        }
    }

    public /* bridge */ /* synthetic */ boolean a(String str, org.jsoup.nodes.b bVar) {
        return super.a(str, bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, String[] strArr) {
        return a(str, f33807a, strArr);
    }

    /* access modifiers changed from: protected */
    public boolean a(Token token) {
        this.f33880o = token;
        return this.f33815q.a(token, this);
    }

    /* access modifiers changed from: package-private */
    public boolean a(Token token, HtmlTreeBuilderState htmlTreeBuilderState) {
        this.f33880o = token;
        return htmlTreeBuilderState.a(token, this);
    }

    /* access modifiers changed from: package-private */
    public Element b(String str) {
        for (int size = this.f33878m.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f33878m.get(size);
            if (element.r().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Element b(Token.g gVar) {
        f a2 = f.a(gVar.r(), this.f33881p);
        Element element = new Element(a2, (String) null, this.f33881p.a(gVar.f33745e));
        b((j) element);
        if (gVar.t()) {
            if (!a2.h()) {
                a2.k();
            } else if (!a2.f()) {
                this.f33876k.b("Tag cannot be self closing; not a void tag");
            }
        }
        return element;
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState b() {
        return this.f33815q;
    }

    /* access modifiers changed from: package-private */
    public void b(Element element) {
        b((j) element);
        this.f33878m.add(element);
    }

    /* access modifiers changed from: package-private */
    public void b(Element element, Element element2) {
        a((ArrayList<Element>) this.f33878m, element, element2);
    }

    /* access modifiers changed from: package-private */
    public void b(HtmlTreeBuilderState htmlTreeBuilderState) {
        if (this.f33874i.a().a()) {
            this.f33874i.a().add(new c(this.f33875j.b(), "Unexpected token [%s] when in state [%s]", this.f33880o.a(), htmlTreeBuilderState));
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.A = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean b(String[] strArr) {
        return a(strArr, f33807a, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public Element c(String str) {
        for (int size = this.f33878m.size() - 1; size >= 0; size--) {
            Element element = (Element) this.f33878m.get(size);
            this.f33878m.remove(size);
            if (element.r().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f33816r = this.f33815q;
    }

    /* access modifiers changed from: package-private */
    public void c(Element element) {
        this.f33878m.add(element);
    }

    /* access modifiers changed from: package-private */
    public void c(Element element, Element element2) {
        a(this.f33821w, element, element2);
    }

    /* access modifiers changed from: package-private */
    public HtmlTreeBuilderState d() {
        return this.f33816r;
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        int size = this.f33878m.size() - 1;
        while (size >= 0 && !((Element) this.f33878m.get(size)).r().equals(str)) {
            this.f33878m.remove(size);
            size--;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d(Element element) {
        return a((ArrayList<Element>) this.f33878m, element);
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f33824z;
    }

    /* access modifiers changed from: package-private */
    public boolean e(String str) {
        return a(str, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean e(Element element) {
        for (int size = this.f33878m.size() - 1; size >= 0; size--) {
            if (((Element) this.f33878m.get(size)) == element) {
                this.f33878m.remove(size);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Document f() {
        return this.f33877l;
    }

    /* access modifiers changed from: package-private */
    public Element f(Element element) {
        if (f33814h || d(element)) {
            for (int size = this.f33878m.size() - 1; size >= 0; size--) {
                if (((Element) this.f33878m.get(size)) == element) {
                    return (Element) this.f33878m.get(size - 1);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean f(String str) {
        return a(str, f33808b);
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return this.f33879n;
    }

    /* access modifiers changed from: package-private */
    public void g(Element element) {
        this.f33818t = element;
    }

    /* access modifiers changed from: package-private */
    public boolean g(String str) {
        return a(str, f33809c);
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.B;
    }

    /* access modifiers changed from: package-private */
    public boolean h(String str) {
        return a(str, f33810d, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean h(Element element) {
        return oh.c.b(element.r(), f33813g);
    }

    /* access modifiers changed from: package-private */
    public Element i() {
        return (Element) this.f33878m.remove(this.f33878m.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public void i(Element element) {
        int size = this.f33821w.size() - 1;
        int i2 = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.f33821w.get(size);
                if (element2 == null) {
                    break;
                }
                if (d(element, element2)) {
                    i2++;
                }
                if (i2 == 3) {
                    this.f33821w.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.f33821w.add(element);
    }

    /* access modifiers changed from: package-private */
    public boolean i(String str) {
        for (int size = this.f33878m.size() - 1; size >= 0; size--) {
            String r2 = ((Element) this.f33878m.get(size)).r();
            if (r2.equals(str)) {
                return true;
            }
            if (!oh.c.b(r2, f33811e)) {
                return false;
            }
        }
        c.b("Should not be reachable");
        return false;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Element> j() {
        return this.f33878m;
    }

    /* access modifiers changed from: package-private */
    public void j(String str) {
        while (str != null && !A().r().equals(str) && oh.c.b(A().r(), f33812f)) {
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void j(Element element) {
        for (int size = this.f33821w.size() - 1; size >= 0; size--) {
            if (this.f33821w.get(size) == element) {
                this.f33821w.remove(size);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Element k(String str) {
        for (int size = this.f33821w.size() - 1; size >= 0; size--) {
            Element element = this.f33821w.get(size);
            if (element == null) {
                return null;
            }
            if (element.r().equals(str)) {
                return element;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        c("table");
    }

    /* access modifiers changed from: package-private */
    public boolean k(Element element) {
        return a(this.f33821w, element);
    }

    /* access modifiers changed from: package-private */
    public void l() {
        c("tbody", "tfoot", "thead", "template");
    }

    /* access modifiers changed from: package-private */
    public void m() {
        c("tr", "template");
    }

    /* access modifiers changed from: package-private */
    public void n() {
        HtmlTreeBuilderState htmlTreeBuilderState;
        int size = this.f33878m.size() - 1;
        boolean z2 = false;
        while (size >= 0) {
            Element element = (Element) this.f33878m.get(size);
            if (size == 0) {
                element = this.f33820v;
                z2 = true;
            }
            String r2 = element.r();
            if ("select".equals(r2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InSelect;
            } else if ("td".equals(r2) || ("th".equals(r2) && !z2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCell;
            } else if ("tr".equals(r2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InRow;
            } else if ("tbody".equals(r2) || "thead".equals(r2) || "tfoot".equals(r2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTableBody;
            } else if ("caption".equals(r2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InCaption;
            } else if ("colgroup".equals(r2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InColumnGroup;
            } else if ("table".equals(r2)) {
                htmlTreeBuilderState = HtmlTreeBuilderState.InTable;
            } else {
                if (!"head".equals(r2) && !"body".equals(r2)) {
                    if ("frameset".equals(r2)) {
                        htmlTreeBuilderState = HtmlTreeBuilderState.InFrameset;
                    } else if ("html".equals(r2)) {
                        htmlTreeBuilderState = HtmlTreeBuilderState.BeforeHead;
                    } else if (!z2) {
                        size--;
                    }
                }
                htmlTreeBuilderState = HtmlTreeBuilderState.InBody;
            }
            a(htmlTreeBuilderState);
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public Element o() {
        return this.f33818t;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public h q() {
        return this.f33819u;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.f33822x = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public List<String> s() {
        return this.f33822x;
    }

    /* access modifiers changed from: package-private */
    public void t() {
        j((String) null);
    }

    public String toString() {
        return "TreeBuilder{currentToken=" + this.f33880o + ", state=" + this.f33815q + ", currentElement=" + A() + '}';
    }

    /* access modifiers changed from: package-private */
    public Element u() {
        if (this.f33821w.size() <= 0) {
            return null;
        }
        ArrayList<Element> arrayList = this.f33821w;
        return arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public Element v() {
        int size = this.f33821w.size();
        if (size > 0) {
            return this.f33821w.remove(size - 1);
        }
        return null;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    void w() {
        /*
            r7 = this;
            org.jsoup.nodes.Element r0 = r7.u()
            if (r0 == 0) goto L_0x0056
            boolean r1 = r7.d((org.jsoup.nodes.Element) r0)
            if (r1 == 0) goto L_0x000d
            goto L_0x0056
        L_0x000d:
            java.util.ArrayList<org.jsoup.nodes.Element> r1 = r7.f33821w
            int r1 = r1.size()
            r2 = 1
            int r1 = r1 - r2
            r3 = r1
        L_0x0016:
            r4 = 0
            if (r3 != 0) goto L_0x001a
            goto L_0x002d
        L_0x001a:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.f33821w
            int r3 = r3 + -1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            if (r0 == 0) goto L_0x002c
            boolean r5 = r7.d((org.jsoup.nodes.Element) r0)
            if (r5 == 0) goto L_0x0016
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 != 0) goto L_0x0039
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r7.f33821w
            int r3 = r3 + 1
            java.lang.Object r0 = r0.get(r3)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
        L_0x0039:
            org.jsoup.helper.c.a((java.lang.Object) r0)
            java.lang.String r2 = r0.r()
            org.jsoup.nodes.Element r2 = r7.a((java.lang.String) r2)
            org.jsoup.nodes.b r5 = r2.p()
            org.jsoup.nodes.b r6 = r0.p()
            r5.a((org.jsoup.nodes.b) r6)
            java.util.ArrayList<org.jsoup.nodes.Element> r5 = r7.f33821w
            r5.set(r3, r2)
            if (r3 != r1) goto L_0x002c
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.b.w():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000c, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void x() {
        /*
            r1 = this;
        L_0x0000:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r1.f33821w
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x000e
            org.jsoup.nodes.Element r0 = r1.v()
            if (r0 != 0) goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.b.x():void");
    }

    /* access modifiers changed from: package-private */
    public void y() {
        this.f33821w.add((Object) null);
    }
}
