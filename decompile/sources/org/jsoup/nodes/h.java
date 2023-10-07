package org.jsoup.nodes;

import org.jsoup.parser.f;
import org.jsoup.select.Elements;

public class h extends Element {

    /* renamed from: d  reason: collision with root package name */
    private final Elements f33664d = new Elements();

    public h(f fVar, String str, b bVar) {
        super(fVar, str, bVar);
    }

    /* renamed from: b */
    public h m() {
        return (h) super.d();
    }

    public h b(Element element) {
        this.f33664d.add(element);
        return this;
    }

    /* access modifiers changed from: protected */
    public void h(j jVar) {
        super.h(jVar);
        this.f33664d.remove(jVar);
    }
}
