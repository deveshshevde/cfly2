package org.jsoup.parser;

import java.io.Reader;
import java.util.ArrayList;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.b;
import org.jsoup.parser.Token;

abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private Token.g f33872a = new Token.g();

    /* renamed from: b  reason: collision with root package name */
    private Token.f f33873b = new Token.f();

    /* renamed from: i  reason: collision with root package name */
    protected e f33874i;

    /* renamed from: j  reason: collision with root package name */
    a f33875j;

    /* renamed from: k  reason: collision with root package name */
    h f33876k;

    /* renamed from: l  reason: collision with root package name */
    protected Document f33877l;

    /* renamed from: m  reason: collision with root package name */
    protected ArrayList<Element> f33878m;

    /* renamed from: n  reason: collision with root package name */
    protected String f33879n;

    /* renamed from: o  reason: collision with root package name */
    protected Token f33880o;

    /* renamed from: p  reason: collision with root package name */
    protected d f33881p;

    i() {
    }

    /* access modifiers changed from: protected */
    public Element A() {
        int size = this.f33878m.size();
        if (size > 0) {
            return this.f33878m.get(size - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract d a();

    /* access modifiers changed from: protected */
    public void a(Reader reader, String str, e eVar) {
        c.a((Object) reader, "String input must not be null");
        c.a((Object) str, "BaseURI must not be null");
        Document document = new Document(str);
        this.f33877l = document;
        document.a(eVar);
        this.f33874i = eVar;
        this.f33881p = eVar.b();
        this.f33875j = new a(reader);
        this.f33880o = null;
        this.f33876k = new h(this.f33875j, eVar.a());
        this.f33878m = new ArrayList<>(32);
        this.f33879n = str;
    }

    public boolean a(String str, b bVar) {
        Token.g gVar = this.f33872a;
        if (this.f33880o == gVar) {
            return a(new Token.g().a(str, bVar));
        }
        gVar.b();
        gVar.a(str, bVar);
        return a(gVar);
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(Token token);

    /* access modifiers changed from: package-private */
    public Document b(Reader reader, String str, e eVar) {
        a(reader, str, eVar);
        z();
        this.f33875j.a();
        this.f33875j = null;
        this.f33876k = null;
        this.f33878m = null;
        return this.f33877l;
    }

    /* access modifiers changed from: protected */
    public boolean l(String str) {
        Token.g gVar = this.f33872a;
        return a(this.f33880o == gVar ? new Token.g().a(str) : gVar.b().a(str));
    }

    /* access modifiers changed from: protected */
    public boolean m(String str) {
        Token token = this.f33880o;
        Token.f fVar = this.f33873b;
        return a(token == fVar ? new Token.f().a(str) : fVar.b().a(str));
    }

    /* access modifiers changed from: protected */
    public void n(String str) {
        ParseErrorList a2 = this.f33874i.a();
        if (a2.a()) {
            a2.add(new c(this.f33875j.b(), str));
        }
    }

    /* access modifiers changed from: protected */
    public void z() {
        Token a2;
        h hVar = this.f33876k;
        Token.TokenType tokenType = Token.TokenType.EOF;
        do {
            a2 = hVar.a();
            a(a2);
            a2.b();
        } while (a2.f33725a != tokenType);
    }
}
