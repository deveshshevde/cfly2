package org.jsoup.parser;

import java.io.Reader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.b;
import org.jsoup.nodes.c;
import org.jsoup.nodes.f;
import org.jsoup.nodes.m;
import org.jsoup.parser.Token;

public class j extends i {

    /* renamed from: org.jsoup.parser.j$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33882a;

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
                f33882a = r0
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.StartTag     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33882a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EndTag     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33882a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Comment     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f33882a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Character     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f33882a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.Doctype     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f33882a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.jsoup.parser.Token$TokenType r1 = org.jsoup.parser.Token.TokenType.EOF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.j.AnonymousClass1.<clinit>():void");
        }
    }

    private void a(org.jsoup.nodes.j jVar) {
        A().a(jVar);
    }

    private void a(Token.f fVar) {
        Element element;
        String a2 = this.f33881p.a(fVar.f33742b);
        int size = this.f33878m.size() - 1;
        while (true) {
            if (size < 0) {
                element = null;
                break;
            }
            element = (Element) this.f33878m.get(size);
            if (element.a().equals(a2)) {
                break;
            }
            size--;
        }
        if (element != null) {
            int size2 = this.f33878m.size() - 1;
            while (size2 >= 0) {
                Element element2 = (Element) this.f33878m.get(size2);
                this.f33878m.remove(size2);
                if (element2 != element) {
                    size2--;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Element a(Token.g gVar) {
        f a2 = f.a(gVar.r(), this.f33881p);
        if (gVar.f33745e != null) {
            gVar.f33745e.a(this.f33881p);
        }
        Element element = new Element(a2, (String) null, this.f33881p.a(gVar.f33745e));
        a((org.jsoup.nodes.j) element);
        if (!gVar.t()) {
            this.f33878m.add(element);
        } else if (!a2.h()) {
            a2.k();
        }
        return element;
    }

    /* access modifiers changed from: package-private */
    public d a() {
        return d.f33828b;
    }

    /* access modifiers changed from: protected */
    public void a(Reader reader, String str, e eVar) {
        super.a(reader, str, eVar);
        this.f33878m.add(this.f33877l);
        this.f33877l.j().a(Document.OutputSettings.Syntax.xml);
    }

    /* access modifiers changed from: package-private */
    public void a(Token.b bVar) {
        String o2 = bVar.o();
        a(bVar.l() ? new c(o2) : new m(o2));
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [org.jsoup.nodes.n] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.jsoup.parser.Token.c r3) {
        /*
            r2 = this;
            org.jsoup.nodes.d r0 = new org.jsoup.nodes.d
            java.lang.String r1 = r3.o()
            r0.<init>(r1)
            boolean r3 = r3.f33734b
            if (r3 == 0) goto L_0x001a
            boolean r3 = r0.e()
            if (r3 == 0) goto L_0x001a
            org.jsoup.nodes.n r3 = r0.f()
            if (r3 == 0) goto L_0x001a
            r0 = r3
        L_0x001a:
            r2.a((org.jsoup.nodes.j) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.j.a(org.jsoup.parser.Token$c):void");
    }

    /* access modifiers changed from: package-private */
    public void a(Token.d dVar) {
        f fVar = new f(this.f33881p.a(dVar.o()), dVar.q(), dVar.r());
        fVar.a_(dVar.p());
        a((org.jsoup.nodes.j) fVar);
    }

    public /* bridge */ /* synthetic */ boolean a(String str, b bVar) {
        return super.a(str, bVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(Token token) {
        switch (AnonymousClass1.f33882a[token.f33725a.ordinal()]) {
            case 1:
                a(token.f());
                return true;
            case 2:
                a(token.h());
                return true;
            case 3:
                a(token.j());
                return true;
            case 4:
                a(token.m());
                return true;
            case 5:
                a(token.d());
                return true;
            case 6:
                return true;
            default:
                org.jsoup.helper.c.b("Unexpected token type: " + token.f33725a);
                return true;
        }
    }
}
