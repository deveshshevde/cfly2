package org.jsoup.nodes;

import org.jsoup.nodes.Document;
import org.jsoup.parser.b;
import org.jsoup.parser.e;

final class k {
    static Document.OutputSettings a(j jVar) {
        Document O = jVar.O();
        if (O == null) {
            O = new Document("");
        }
        return O.j();
    }

    static e b(j jVar) {
        Document O = jVar.O();
        return (O == null || O.l() == null) ? new e(new b()) : O.l();
    }
}
