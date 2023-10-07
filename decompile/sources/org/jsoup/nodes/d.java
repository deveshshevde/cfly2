package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.a;
import org.jsoup.nodes.Document;
import org.jsoup.parser.e;

public class d extends i {
    public d(String str) {
        this.f33666a = str;
    }

    public String a() {
        return "#comment";
    }

    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public /* bridge */ /* synthetic */ j a(String str, String str2) {
        return super.a(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void a(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.f() && ((T() == 0 && (this.f33667b instanceof Element) && ((Element) this.f33667b).s().d()) || outputSettings.g())) {
            c(appendable, i2, outputSettings);
        }
        appendable.append("<!--").append(b()).append("-->");
    }

    public String b() {
        return j();
    }

    /* access modifiers changed from: package-private */
    public void b(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    public /* bridge */ /* synthetic */ boolean b(String str) {
        return super.b(str);
    }

    public /* bridge */ /* synthetic */ String c(String str) {
        return super.c(str);
    }

    /* renamed from: c */
    public d d() {
        return (d) super.clone();
    }

    public boolean e() {
        String b2 = b();
        return b2.length() > 1 && (b2.startsWith("!") || b2.startsWith("?"));
    }

    public n f() {
        String b2 = b();
        Document a2 = a.a("<" + b2.substring(1, b2.length() - 1) + ">", i(), e.d());
        if (a2.w().size() <= 0) {
            return null;
        }
        Element a3 = a2.a(0);
        n nVar = new n(k.b(a2).b().a(a3.q()), b2.startsWith("!"));
        nVar.p().a(a3.p());
        return nVar;
    }

    public /* bridge */ /* synthetic */ j g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ int h() {
        return super.h();
    }

    public /* bridge */ /* synthetic */ String i() {
        return super.i();
    }

    public String toString() {
        return E_();
    }
}
