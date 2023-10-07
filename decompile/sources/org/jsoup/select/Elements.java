package org.jsoup.select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oh.c;
import org.jsoup.nodes.Element;

public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public Elements(int i2) {
        super(i2);
    }

    public Elements(List<Element> list) {
        super(list);
    }

    public String a(String str) {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element.b(str)) {
                return element.c(str);
            }
        }
        return "";
    }

    /* renamed from: a */
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            elements.add(((Element) it2.next()).d());
        }
        return elements;
    }

    public String b() {
        StringBuilder a2 = c.a();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (a2.length() != 0) {
                a2.append(" ");
            }
            a2.append(element.E());
        }
        return c.a(a2);
    }

    public String c() {
        StringBuilder a2 = c.a();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (a2.length() != 0) {
                a2.append("\n");
            }
            a2.append(element.E_());
        }
        return c.a(a2);
    }

    public Elements d() {
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            ((Element) it2.next()).P();
        }
        return this;
    }

    public Element e() {
        if (isEmpty()) {
            return null;
        }
        return (Element) get(0);
    }

    public String toString() {
        return c();
    }
}
