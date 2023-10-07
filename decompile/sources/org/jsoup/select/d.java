package org.jsoup.select;

import org.jsoup.nodes.j;
import org.jsoup.select.NodeFilter;

public class d {
    public static NodeFilter.FilterResult a(NodeFilter nodeFilter, j jVar) {
        j jVar2 = jVar;
        int i2 = 0;
        while (jVar2 != null) {
            NodeFilter.FilterResult a2 = nodeFilter.a(jVar2, i2);
            if (a2 == NodeFilter.FilterResult.STOP) {
                return a2;
            }
            if (a2 != NodeFilter.FilterResult.CONTINUE || jVar2.h() <= 0) {
                while (jVar2.R() == null && i2 > 0) {
                    if ((a2 == NodeFilter.FilterResult.CONTINUE || a2 == NodeFilter.FilterResult.SKIP_CHILDREN) && (a2 = nodeFilter.b(jVar2, i2)) == NodeFilter.FilterResult.STOP) {
                        return a2;
                    }
                    j N = jVar2.N();
                    i2--;
                    if (a2 == NodeFilter.FilterResult.REMOVE) {
                        jVar2.P();
                    }
                    a2 = NodeFilter.FilterResult.CONTINUE;
                    jVar2 = N;
                }
                if ((a2 == NodeFilter.FilterResult.CONTINUE || a2 == NodeFilter.FilterResult.SKIP_CHILDREN) && (a2 = nodeFilter.b(jVar2, i2)) == NodeFilter.FilterResult.STOP) {
                    return a2;
                }
                if (jVar2 == jVar) {
                    return a2;
                }
                j R = jVar2.R();
                if (a2 == NodeFilter.FilterResult.REMOVE) {
                    jVar2.P();
                }
                jVar2 = R;
            } else {
                jVar2 = jVar2.b(0);
                i2++;
            }
        }
        return NodeFilter.FilterResult.CONTINUE;
    }

    public static void a(e eVar, j jVar) {
        j jVar2 = jVar;
        int i2 = 0;
        while (jVar2 != null) {
            eVar.a(jVar2, i2);
            if (jVar2.h() > 0) {
                jVar2 = jVar2.b(0);
                i2++;
            } else {
                while (jVar2.R() == null && i2 > 0) {
                    eVar.b(jVar2, i2);
                    jVar2 = jVar2.N();
                    i2--;
                }
                eVar.b(jVar2, i2);
                if (jVar2 != jVar) {
                    jVar2 = jVar2.R();
                } else {
                    return;
                }
            }
        }
    }
}
