package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.h;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f30261a;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f30262b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f30263c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f30264d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f30265e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f30266f;

    /* renamed from: g  reason: collision with root package name */
    public static final d f30267g = new d();

    static {
        Charset forName = Charset.forName("UTF-8");
        h.b(forName, "Charset.forName(\"UTF-8\")");
        f30261a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        h.b(forName2, "Charset.forName(\"UTF-16\")");
        f30262b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        h.b(forName3, "Charset.forName(\"UTF-16BE\")");
        f30263c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        h.b(forName4, "Charset.forName(\"UTF-16LE\")");
        f30264d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        h.b(forName5, "Charset.forName(\"US-ASCII\")");
        f30265e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        h.b(forName6, "Charset.forName(\"ISO-8859-1\")");
        f30266f = forName6;
    }

    private d() {
    }
}
