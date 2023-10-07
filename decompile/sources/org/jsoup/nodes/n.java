package org.jsoup.nodes;

import java.io.IOException;
import java.util.Iterator;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;

public class n extends i {

    /* renamed from: d  reason: collision with root package name */
    private final boolean f33671d;

    public n(String str, boolean z2) {
        c.a((Object) str);
        this.f33666a = str;
        this.f33671d = z2;
    }

    private void a(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        Iterator<a> it2 = p().iterator();
        while (it2.hasNext()) {
            a next = it2.next();
            if (!next.getKey().equals(a())) {
                appendable.append(' ');
                next.a(appendable, outputSettings);
            }
        }
    }

    public String a() {
        return "#declaration";
    }

    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public /* bridge */ /* synthetic */ j a(String str, String str2) {
        return super.a(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void a(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        String str = "!";
        appendable.append("<").append(this.f33671d ? str : "?").append(j());
        a(appendable, outputSettings);
        if (!this.f33671d) {
            str = "?";
        }
        appendable.append(str).append(">");
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

    /* renamed from: e */
    public n d() {
        return (n) super.clone();
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
