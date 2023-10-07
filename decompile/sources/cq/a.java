package cq;

import org.greenrobot.eventbus.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26246a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static c f26247b;

    private a() {
    }

    private final synchronized c a() {
        if (f26247b == null) {
            f26247b = c.b().d();
        }
        return f26247b;
    }

    public final <T> void a(T t2) {
        c a2;
        c a3 = a();
        if (a3 != null && !a3.b(t2) && (a2 = a()) != null) {
            a2.a((Object) t2);
        }
    }

    public final <T> void b(T t2) {
        c a2;
        c a3 = a();
        if (a3 != null && true == a3.b(t2) && (a2 = a()) != null) {
            a2.c(t2);
        }
    }
}
