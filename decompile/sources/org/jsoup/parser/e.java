package org.jsoup.parser;

import java.io.Reader;
import java.io.StringReader;
import org.jsoup.nodes.Document;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private i f33831a;

    /* renamed from: b  reason: collision with root package name */
    private ParseErrorList f33832b = ParseErrorList.b();

    /* renamed from: c  reason: collision with root package name */
    private d f33833c;

    public e(i iVar) {
        this.f33831a = iVar;
        this.f33833c = iVar.a();
    }

    public static Document b(String str, String str2) {
        b bVar = new b();
        return bVar.b(new StringReader(str), str2, new e(bVar));
    }

    public static e c() {
        return new e(new b());
    }

    public static e d() {
        return new e(new j());
    }

    public Document a(Reader reader, String str) {
        return this.f33831a.b(reader, str, this);
    }

    public Document a(String str, String str2) {
        return this.f33831a.b(new StringReader(str), str2, this);
    }

    public ParseErrorList a() {
        return this.f33832b;
    }

    public d b() {
        return this.f33833c;
    }
}
