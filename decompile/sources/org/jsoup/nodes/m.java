package org.jsoup.nodes;

import java.io.IOException;
import oh.c;
import org.jsoup.nodes.Document;

public class m extends i {
    public m(String str) {
        this.f33666a = str;
    }

    static boolean a(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    public String a() {
        return "#text";
    }

    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public /* bridge */ /* synthetic */ j a(String str, String str2) {
        return super.a(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void a(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        boolean f2 = outputSettings.f();
        if (f2 && ((T() == 0 && (this.f33667b instanceof Element) && ((Element) this.f33667b).s().d() && !f()) || (outputSettings.g() && Q().size() > 0 && !f()))) {
            c(appendable, i2, outputSettings);
        }
        Entities.a(appendable, j(), outputSettings, false, f2 && !Element.d(this.f33667b), f2 && (this.f33667b instanceof Document));
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
    public m d() {
        return (m) super.clone();
    }

    public String e() {
        return j();
    }

    public boolean f() {
        return c.a(j());
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
