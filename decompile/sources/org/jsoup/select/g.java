package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

abstract class g extends c {

    /* renamed from: a  reason: collision with root package name */
    c f33922a;

    static class a extends g {
        public a(c cVar) {
            this.f33922a = cVar;
        }

        public boolean a(Element element, Element element2) {
            Iterator it2 = element2.D().iterator();
            while (it2.hasNext()) {
                Element element3 = (Element) it2.next();
                if (element3 != element2 && this.f33922a.a(element2, element3)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", new Object[]{this.f33922a});
        }
    }

    static class b extends g {
        public b(c cVar) {
            this.f33922a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
            r4 = r4.K();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(org.jsoup.nodes.Element r3, org.jsoup.nodes.Element r4) {
            /*
                r2 = this;
                r0 = 0
                if (r3 != r4) goto L_0x0004
                return r0
            L_0x0004:
                org.jsoup.nodes.Element r4 = r4.K()
                if (r4 == 0) goto L_0x0013
                org.jsoup.select.c r1 = r2.f33922a
                boolean r3 = r1.a(r3, r4)
                if (r3 == 0) goto L_0x0013
                r0 = 1
            L_0x0013:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.g.b.a(org.jsoup.nodes.Element, org.jsoup.nodes.Element):boolean");
        }

        public String toString() {
            return String.format(":ImmediateParent%s", new Object[]{this.f33922a});
        }
    }

    static class c extends g {
        public c(c cVar) {
            this.f33922a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
            r4 = r4.B();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(org.jsoup.nodes.Element r3, org.jsoup.nodes.Element r4) {
            /*
                r2 = this;
                r0 = 0
                if (r3 != r4) goto L_0x0004
                return r0
            L_0x0004:
                org.jsoup.nodes.Element r4 = r4.B()
                if (r4 == 0) goto L_0x0013
                org.jsoup.select.c r1 = r2.f33922a
                boolean r3 = r1.a(r3, r4)
                if (r3 == 0) goto L_0x0013
                r0 = 1
            L_0x0013:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.g.c.a(org.jsoup.nodes.Element, org.jsoup.nodes.Element):boolean");
        }

        public String toString() {
            return String.format(":prev%s", new Object[]{this.f33922a});
        }
    }

    static class d extends g {
        public d(c cVar) {
            this.f33922a = cVar;
        }

        public boolean a(Element element, Element element2) {
            return !this.f33922a.a(element, element2);
        }

        public String toString() {
            return String.format(":not%s", new Object[]{this.f33922a});
        }
    }

    static class e extends g {
        public e(c cVar) {
            this.f33922a = cVar;
        }

        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            do {
                element2 = element2.K();
                if (this.f33922a.a(element, element2)) {
                    return true;
                }
            } while (element2 != element);
            return false;
        }

        public String toString() {
            return String.format(":parent%s", new Object[]{this.f33922a});
        }
    }

    static class f extends g {
        public f(c cVar) {
            this.f33922a = cVar;
        }

        public boolean a(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            do {
                element2 = element2.B();
                if (element2 == null) {
                    return false;
                }
            } while (!this.f33922a.a(element, element2));
            return true;
        }

        public String toString() {
            return String.format(":prev*%s", new Object[]{this.f33922a});
        }
    }

    /* renamed from: org.jsoup.select.g$g  reason: collision with other inner class name */
    static class C0248g extends c {
        C0248g() {
        }

        public boolean a(Element element, Element element2) {
            return element == element2;
        }
    }

    g() {
    }
}
