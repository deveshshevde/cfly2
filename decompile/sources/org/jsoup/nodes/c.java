package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;

public class c extends m {
    public c(String str) {
        super(str);
    }

    public String a() {
        return "#cdata";
    }

    /* access modifiers changed from: package-private */
    public void a(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("<![CDATA[").append(e());
    }

    /* renamed from: b */
    public c d() {
        return (c) super.d();
    }

    /* access modifiers changed from: package-private */
    public void b(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
        try {
            appendable.append("]]>");
        } catch (IOException e2) {
            throw new UncheckedIOException(e2);
        }
    }
}
