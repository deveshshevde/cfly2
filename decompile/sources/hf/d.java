package hf;

import iv.f;
import kotlin.jvm.internal.h;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f13322a = new d();

    private d() {
    }

    public static final void a(String str) {
        h.a((Object) str);
        f.b(str, new Object[0]);
    }

    public static final void a(String str, String str2) {
        h.d(str, "tag");
        h.d(str2, "str");
        f.a(str);
        f.a(str + str2, new Object[0]);
    }

    public static final void b(String str, String str2) {
        f.a(str);
        h.a((Object) str2);
        f.b(str2, str);
    }
}
