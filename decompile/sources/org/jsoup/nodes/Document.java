package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.d;
import org.jsoup.parser.e;
import org.jsoup.parser.f;

public class Document extends Element {

    /* renamed from: d  reason: collision with root package name */
    private OutputSettings f33605d = new OutputSettings();

    /* renamed from: e  reason: collision with root package name */
    private e f33606e;

    /* renamed from: f  reason: collision with root package name */
    private QuirksMode f33607f = QuirksMode.noQuirks;

    /* renamed from: g  reason: collision with root package name */
    private String f33608g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f33609h = false;

    public static class OutputSettings implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        Entities.CoreCharset f33610a;

        /* renamed from: b  reason: collision with root package name */
        private Entities.EscapeMode f33611b = Entities.EscapeMode.base;

        /* renamed from: c  reason: collision with root package name */
        private Charset f33612c;

        /* renamed from: d  reason: collision with root package name */
        private ThreadLocal<CharsetEncoder> f33613d = new ThreadLocal<>();

        /* renamed from: e  reason: collision with root package name */
        private boolean f33614e = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f33615f = false;

        /* renamed from: g  reason: collision with root package name */
        private int f33616g = 1;

        /* renamed from: h  reason: collision with root package name */
        private Syntax f33617h = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            a(Charset.forName("UTF8"));
        }

        public OutputSettings a(String str) {
            a(Charset.forName(str));
            return this;
        }

        public OutputSettings a(Charset charset) {
            this.f33612c = charset;
            return this;
        }

        public OutputSettings a(Syntax syntax) {
            this.f33617h = syntax;
            return this;
        }

        public Entities.EscapeMode a() {
            return this.f33611b;
        }

        public Charset b() {
            return this.f33612c;
        }

        /* access modifiers changed from: package-private */
        public CharsetEncoder c() {
            CharsetEncoder newEncoder = this.f33612c.newEncoder();
            this.f33613d.set(newEncoder);
            this.f33610a = Entities.CoreCharset.a(newEncoder.charset().name());
            return newEncoder;
        }

        /* access modifiers changed from: package-private */
        public CharsetEncoder d() {
            CharsetEncoder charsetEncoder = this.f33613d.get();
            return charsetEncoder != null ? charsetEncoder : c();
        }

        public Syntax e() {
            return this.f33617h;
        }

        public boolean f() {
            return this.f33614e;
        }

        public boolean g() {
            return this.f33615f;
        }

        public int h() {
            return this.f33616g;
        }

        /* renamed from: i */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.a(this.f33612c.name());
                outputSettings.f33611b = Entities.EscapeMode.valueOf(this.f33611b.name());
                return outputSettings;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(f.a("#root", d.f33827a), str);
        this.f33608g = str;
    }

    private void U() {
        n nVar;
        if (this.f33609h) {
            OutputSettings.Syntax e2 = j().e();
            if (e2 == OutputSettings.Syntax.html) {
                Element e3 = e("meta[charset]").e();
                if (e3 == null) {
                    Element b2 = b();
                    if (b2 != null) {
                        e3 = b2.g("meta");
                    }
                    e("meta[name=charset]").d();
                }
                e3.a("charset", e().displayName());
                e("meta[name=charset]").d();
            } else if (e2 == OutputSettings.Syntax.xml) {
                j jVar = M().get(0);
                if (jVar instanceof n) {
                    n nVar2 = (n) jVar;
                    if (nVar2.b().equals("xml")) {
                        nVar2.a("encoding", e().displayName());
                        if (nVar2.c("version") != null) {
                            nVar2.a("version", "1.0");
                            return;
                        }
                        return;
                    }
                    nVar = new n("xml", false);
                } else {
                    nVar = new n("xml", false);
                }
                nVar.a("version", "1.0");
                nVar.a("encoding", e().displayName());
                b((j) nVar);
            }
        }
    }

    private Element a(String str, j jVar) {
        if (jVar.a().equals(str)) {
            return (Element) jVar;
        }
        int h2 = jVar.h();
        for (int i2 = 0; i2 < h2; i2++) {
            Element a2 = a(str, jVar.b(i2));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public String E_() {
        return super.H();
    }

    public String a() {
        return "#document";
    }

    public Document a(QuirksMode quirksMode) {
        this.f33607f = quirksMode;
        return this;
    }

    public Document a(e eVar) {
        this.f33606e = eVar;
        return this;
    }

    public void a(Charset charset) {
        a(true);
        this.f33605d.a(charset);
        U();
    }

    public void a(boolean z2) {
        this.f33609h = z2;
    }

    public Element b() {
        return a("head", this);
    }

    public Charset e() {
        return this.f33605d.b();
    }

    /* renamed from: f */
    public Document m() {
        Document document = (Document) super.d();
        document.f33605d = this.f33605d.clone();
        return document;
    }

    public OutputSettings j() {
        return this.f33605d;
    }

    public QuirksMode k() {
        return this.f33607f;
    }

    public e l() {
        return this.f33606e;
    }
}
