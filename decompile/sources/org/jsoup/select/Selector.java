package org.jsoup.select;

import org.jsoup.helper.c;
import org.jsoup.nodes.Element;

public class Selector {

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    public static Elements a(String str, Element element) {
        c.a(str);
        return a(f.a(str), element);
    }

    public static Elements a(c cVar, Element element) {
        c.a((Object) cVar);
        c.a((Object) element);
        return a.a(cVar, element);
    }

    public static Element b(String str, Element element) {
        c.a(str);
        return a.b(f.a(str), element);
    }
}
