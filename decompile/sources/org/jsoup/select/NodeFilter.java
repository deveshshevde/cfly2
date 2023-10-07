package org.jsoup.select;

import org.jsoup.nodes.j;

public interface NodeFilter {

    public enum FilterResult {
        CONTINUE,
        SKIP_CHILDREN,
        SKIP_ENTIRELY,
        REMOVE,
        STOP
    }

    FilterResult a(j jVar, int i2);

    FilterResult b(j jVar, int i2);
}
