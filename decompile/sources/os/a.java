package os;

import ok.e;
import or.d;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    private static final a f34090d = new a();

    /* renamed from: a  reason: collision with root package name */
    private final e f34091a;

    /* renamed from: b  reason: collision with root package name */
    private final e f34092b;

    /* renamed from: c  reason: collision with root package name */
    private final e f34093c;

    private a() {
        or.e e2 = d.a().e();
        e d2 = e2.d();
        this.f34091a = d2 == null ? or.e.a() : d2;
        e e3 = e2.e();
        this.f34092b = e3 == null ? or.e.b() : e3;
        e f2 = e2.f();
        this.f34093c = f2 == null ? or.e.c() : f2;
    }

    public static e a() {
        return f34090d.f34091a;
    }

    public static e b() {
        return f34090d.f34092b;
    }
}
