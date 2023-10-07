package org.jsoup.nodes;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;
import org.jsoup.parser.f;
import org.jsoup.select.Elements;
import org.jsoup.select.Selector;
import org.jsoup.select.a;
import org.jsoup.select.c;
import org.jsoup.select.d;
import org.jsoup.select.e;

public class Element extends j {

    /* renamed from: d  reason: collision with root package name */
    private static final List<j> f33625d = Collections.emptyList();

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f33626e = Pattern.compile("\\s+");

    /* renamed from: f  reason: collision with root package name */
    private static final String f33627f = b.g("baseUri");

    /* renamed from: a  reason: collision with root package name */
    List<j> f33628a;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public f f33629g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<List<Element>> f33630h;

    /* renamed from: i  reason: collision with root package name */
    private b f33631i;

    private static final class NodeList extends ChangeNotifyingArrayList<j> {

        /* renamed from: a  reason: collision with root package name */
        private final Element f33634a;

        NodeList(Element element, int i2) {
            super(i2);
            this.f33634a = element;
        }

        public void a() {
            this.f33634a.x();
        }
    }

    public Element(f fVar, String str) {
        this(fVar, str, (b) null);
    }

    public Element(f fVar, String str, b bVar) {
        c.a((Object) fVar);
        this.f33628a = f33625d;
        this.f33631i = bVar;
        this.f33629g = fVar;
        if (str != null) {
            i(str);
        }
    }

    private static <E extends Element> int a(Element element, List<E> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) == element) {
                return i2;
            }
        }
        return 0;
    }

    private static String a(Element element, String str) {
        while (element != null) {
            if (element.o() && element.f33631i.e(str)) {
                return element.f33631i.c(str);
            }
            element = element.K();
        }
        return "";
    }

    private void a(StringBuilder sb) {
        for (j next : this.f33628a) {
            if (next instanceof m) {
                b(sb, (m) next);
            } else if (next instanceof Element) {
                a((Element) next, sb);
            }
        }
    }

    private static void a(Element element, StringBuilder sb) {
        if (element.f33629g.a().equals("br") && !m.a(sb)) {
            sb.append(" ");
        }
    }

    private boolean a(Document.OutputSettings outputSettings) {
        return this.f33629g.d() || (K() != null && K().s().d()) || outputSettings.g();
    }

    private List<Element> b() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.f33630h;
        if (weakReference != null && (list = (List) weakReference.get()) != null) {
            return list;
        }
        int size = this.f33628a.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = this.f33628a.get(i2);
            if (jVar instanceof Element) {
                arrayList.add((Element) jVar);
            }
        }
        this.f33630h = new WeakReference<>(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static void b(StringBuilder sb, m mVar) {
        String e2 = mVar.e();
        if (d(mVar.f33667b) || (mVar instanceof c)) {
            sb.append(e2);
        } else {
            oh.c.a(sb, e2, m.a(sb));
        }
    }

    private boolean b(Document.OutputSettings outputSettings) {
        return s().e() && !s().f() && K().t() && S() != null && !outputSettings.g();
    }

    static boolean d(j jVar) {
        if (jVar instanceof Element) {
            Element element = (Element) jVar;
            int i2 = 0;
            while (!element.f33629g.i()) {
                element = element.K();
                i2++;
                if (i2 < 6) {
                    if (element == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public Elements A() {
        if (this.f33667b == null) {
            return new Elements(0);
        }
        List<Element> b2 = K().b();
        Elements elements = new Elements(b2.size() - 1);
        for (Element next : b2) {
            if (next != this) {
                elements.add(next);
            }
        }
        return elements;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = v().b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.jsoup.nodes.Element B() {
        /*
            r3 = this;
            org.jsoup.nodes.j r0 = r3.f33667b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            org.jsoup.nodes.Element r0 = r3.K()
            java.util.List r0 = r0.b()
            int r2 = a((org.jsoup.nodes.Element) r3, r0)
            if (r2 <= 0) goto L_0x001d
            int r2 = r2 + -1
            java.lang.Object r0 = r0.get(r2)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            return r0
        L_0x001d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Element.B():org.jsoup.nodes.Element");
    }

    public int C() {
        if (K() == null) {
            return 0;
        }
        return a(this, K().b());
    }

    public Elements D() {
        return a.a(new c.a(), this);
    }

    public String E() {
        final StringBuilder a2 = oh.c.a();
        d.a((e) new e() {
            public void a(j jVar, int i2) {
                if (jVar instanceof m) {
                    Element.b(a2, (m) jVar);
                } else if (jVar instanceof Element) {
                    Element element = (Element) jVar;
                    if (a2.length() <= 0) {
                        return;
                    }
                    if ((element.t() || element.f33629g.a().equals("br")) && !m.a(a2)) {
                        a2.append(' ');
                    }
                }
            }

            public void b(j jVar, int i2) {
                if ((jVar instanceof Element) && ((Element) jVar).t() && (jVar.R() instanceof m) && !m.a(a2)) {
                    a2.append(' ');
                }
            }
        }, (j) this);
        return oh.c.a(a2).trim();
    }

    public String F() {
        StringBuilder a2 = oh.c.a();
        a(a2);
        return oh.c.a(a2).trim();
    }

    public String G() {
        String e2;
        StringBuilder a2 = oh.c.a();
        for (j next : this.f33628a) {
            if (next instanceof e) {
                e2 = ((e) next).b();
            } else if (next instanceof d) {
                e2 = ((d) next).b();
            } else if (next instanceof Element) {
                e2 = ((Element) next).G();
            } else if (next instanceof c) {
                e2 = ((c) next).e();
            }
            a2.append(e2);
        }
        return oh.c.a(a2);
    }

    public String H() {
        StringBuilder a2 = oh.c.a();
        a(a2);
        String a3 = oh.c.a(a2);
        return k.a(this).f() ? a3.trim() : a3;
    }

    /* renamed from: I */
    public Element J() {
        return (Element) super.J();
    }

    public <T extends Appendable> T a(T t2) {
        int size = this.f33628a.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f33628a.get(i2).b((Appendable) t2);
        }
        return t2;
    }

    public String a() {
        return this.f33629g.a();
    }

    public Element a(int i2) {
        return b().get(i2);
    }

    public Element a(j jVar) {
        org.jsoup.helper.c.a((Object) jVar);
        k(jVar);
        n();
        this.f33628a.add(jVar);
        jVar.c(this.f33628a.size() - 1);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void a(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.f() && a(outputSettings) && !b(outputSettings) && (!(appendable instanceof StringBuilder) || ((StringBuilder) appendable).length() > 0)) {
            c(appendable, i2, outputSettings);
        }
        appendable.append('<').append(q());
        b bVar = this.f33631i;
        if (bVar != null) {
            bVar.a(appendable, outputSettings);
        }
        if (!this.f33628a.isEmpty() || !this.f33629g.g() || (outputSettings.e() == Document.OutputSettings.Syntax.html && this.f33629g.f())) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    /* renamed from: b */
    public Element a(String str, String str2) {
        super.a(str, str2);
        return this;
    }

    public Element b(j jVar) {
        org.jsoup.helper.c.a((Object) jVar);
        a(0, jVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (!this.f33628a.isEmpty() || !this.f33629g.g()) {
            if (outputSettings.f() && !this.f33628a.isEmpty() && (this.f33629g.d() || (outputSettings.g() && (this.f33628a.size() > 1 || (this.f33628a.size() == 1 && !(this.f33628a.get(0) instanceof m)))))) {
                c(appendable, i2, outputSettings);
            }
            appendable.append("</").append(q()).append('>');
        }
    }

    /* renamed from: c */
    public Element g(j jVar) {
        return (Element) super.g(jVar);
    }

    /* access modifiers changed from: protected */
    public void d(String str) {
        p().b(f33627f, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Element f(j jVar) {
        Element element = (Element) super.f(jVar);
        b bVar = this.f33631i;
        element.f33631i = bVar != null ? bVar.clone() : null;
        NodeList nodeList = new NodeList(element, this.f33628a.size());
        element.f33628a = nodeList;
        nodeList.addAll(this.f33628a);
        element.i(i());
        return element;
    }

    public Elements e(String str) {
        return Selector.a(str, this);
    }

    public Element f(String str) {
        return Selector.b(str, this);
    }

    public Element g(String str) {
        Element element = new Element(f.a(str, k.b(this).b()), i());
        a((j) element);
        return element;
    }

    public int h() {
        return this.f33628a.size();
    }

    public boolean h(String str) {
        if (!o()) {
            return false;
        }
        String d2 = this.f33631i.d("class");
        int length = d2.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(d2);
            }
            boolean z2 = false;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Character.isWhitespace(d2.charAt(i3))) {
                    if (!z2) {
                        continue;
                    } else if (i3 - i2 == length2 && d2.regionMatches(true, i2, str, 0, length2)) {
                        return true;
                    } else {
                        z2 = false;
                    }
                } else if (!z2) {
                    i2 = i3;
                    z2 = true;
                }
            }
            if (z2 && length - i2 == length2) {
                return d2.regionMatches(true, i2, str, 0, length2);
            }
        }
        return false;
    }

    public String i() {
        return a(this, f33627f);
    }

    /* renamed from: m */
    public Element d() {
        return (Element) super.clone();
    }

    /* access modifiers changed from: protected */
    public List<j> n() {
        if (this.f33628a == f33625d) {
            this.f33628a = new NodeList(this, 4);
        }
        return this.f33628a;
    }

    /* access modifiers changed from: protected */
    public boolean o() {
        return this.f33631i != null;
    }

    public b p() {
        if (!o()) {
            this.f33631i = new b();
        }
        return this.f33631i;
    }

    public String q() {
        return this.f33629g.a();
    }

    public String r() {
        return this.f33629g.b();
    }

    public f s() {
        return this.f33629g;
    }

    public boolean t() {
        return this.f33629g.c();
    }

    public String u() {
        return o() ? this.f33631i.d("id") : "";
    }

    /* renamed from: v */
    public final Element K() {
        return (Element) this.f33667b;
    }

    public Elements w() {
        return new Elements(b());
    }

    /* access modifiers changed from: package-private */
    public void x() {
        super.x();
        this.f33630h = null;
    }

    public List<m> y() {
        ArrayList arrayList = new ArrayList();
        for (j next : this.f33628a) {
            if (next instanceof m) {
                arrayList.add((m) next);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* renamed from: z */
    public Element g() {
        this.f33628a.clear();
        return this;
    }
}
