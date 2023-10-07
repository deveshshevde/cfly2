package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;

public class f extends i {
    public f(String str, String str2, String str3) {
        c.a((Object) str);
        c.a((Object) str2);
        c.a((Object) str3);
        a("name", str);
        a("publicId", str2);
        a("systemId", str3);
        b();
    }

    private void b() {
        String str;
        if (e("publicId")) {
            str = "PUBLIC";
        } else if (e("systemId")) {
            str = "SYSTEM";
        } else {
            return;
        }
        a("pubSysKey", str);
    }

    private boolean e(String str) {
        return !oh.c.a(c(str));
    }

    public String a() {
        return "#doctype";
    }

    public /* bridge */ /* synthetic */ String a(String str) {
        return super.a(str);
    }

    public /* bridge */ /* synthetic */ j a(String str, String str2) {
        return super.a(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void a(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append((outputSettings.e() != Document.OutputSettings.Syntax.html || e("publicId") || e("systemId")) ? "<!DOCTYPE" : "<!doctype");
        if (e("name")) {
            appendable.append(" ").append(c("name"));
        }
        if (e("pubSysKey")) {
            appendable.append(" ").append(c("pubSysKey"));
        }
        if (e("publicId")) {
            appendable.append(" \"").append(c("publicId")).append('\"');
        }
        if (e("systemId")) {
            appendable.append(" \"").append(c("systemId")).append('\"');
        }
        appendable.append('>');
    }

    public void a_(String str) {
        if (str != null) {
            a("pubSysKey", str);
        }
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

    public /* bridge */ /* synthetic */ j g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ int h() {
        return super.h();
    }

    public /* bridge */ /* synthetic */ String i() {
        return super.i();
    }
}
