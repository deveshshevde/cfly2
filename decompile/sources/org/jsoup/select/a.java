package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.j;
import org.jsoup.select.NodeFilter;

public class a {

    /* renamed from: org.jsoup.select.a$a  reason: collision with other inner class name */
    private static class C0245a implements e {

        /* renamed from: a  reason: collision with root package name */
        private final Element f33889a;

        /* renamed from: b  reason: collision with root package name */
        private final Elements f33890b;

        /* renamed from: c  reason: collision with root package name */
        private final c f33891c;

        C0245a(Element element, Elements elements, c cVar) {
            this.f33889a = element;
            this.f33890b = elements;
            this.f33891c = cVar;
        }

        public void a(j jVar, int i2) {
            if (jVar instanceof Element) {
                Element element = (Element) jVar;
                if (this.f33891c.a(this.f33889a, element)) {
                    this.f33890b.add(element);
                }
            }
        }

        public void b(j jVar, int i2) {
        }
    }

    private static class b implements NodeFilter {

        /* renamed from: a  reason: collision with root package name */
        private final Element f33892a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Element f33893b = null;

        /* renamed from: c  reason: collision with root package name */
        private final c f33894c;

        b(Element element, c cVar) {
            this.f33892a = element;
            this.f33894c = cVar;
        }

        public NodeFilter.FilterResult a(j jVar, int i2) {
            if (jVar instanceof Element) {
                Element element = (Element) jVar;
                if (this.f33894c.a(this.f33892a, element)) {
                    this.f33893b = element;
                    return NodeFilter.FilterResult.STOP;
                }
            }
            return NodeFilter.FilterResult.CONTINUE;
        }

        public NodeFilter.FilterResult b(j jVar, int i2) {
            return NodeFilter.FilterResult.CONTINUE;
        }
    }

    public static Elements a(c cVar, Element element) {
        Elements elements = new Elements();
        d.a((e) new C0245a(element, elements, cVar), (j) element);
        return elements;
    }

    public static Element b(c cVar, Element element) {
        b bVar = new b(element, cVar);
        d.a((NodeFilter) bVar, (j) element);
        return bVar.f33893b;
    }
}
