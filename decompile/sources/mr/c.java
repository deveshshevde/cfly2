package mr;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f31284b = new a((f) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c f31285c = new c(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c a() {
            return c.f31285c;
        }
    }

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    public boolean e() {
        return a() > b();
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!e() || !((c) obj).e()) {
                c cVar = (c) obj;
                if (!(a() == cVar.a() && b() == cVar.b())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Integer f() {
        return Integer.valueOf(a());
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public int hashCode() {
        if (e()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    public String toString() {
        return a() + ".." + b();
    }
}
