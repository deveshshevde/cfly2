package fg;

import fg.f;

public final class b extends f.a {

    /* renamed from: c  reason: collision with root package name */
    private static f<b> f27214c;

    /* renamed from: a  reason: collision with root package name */
    public float f27215a;

    /* renamed from: b  reason: collision with root package name */
    public float f27216b;

    static {
        f<b> a2 = f.a(256, new b(0.0f, 0.0f));
        f27214c = a2;
        a2.a(0.5f);
    }

    public b() {
    }

    public b(float f2, float f3) {
        this.f27215a = f2;
        this.f27216b = f3;
    }

    public static b a(float f2, float f3) {
        b a2 = f27214c.a();
        a2.f27215a = f2;
        a2.f27216b = f3;
        return a2;
    }

    public static void a(b bVar) {
        f27214c.a(bVar);
    }

    /* access modifiers changed from: protected */
    public f.a a() {
        return new b(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f27215a == bVar.f27215a && this.f27216b == bVar.f27216b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f27215a) ^ Float.floatToIntBits(this.f27216b);
    }

    public String toString() {
        return this.f27215a + "x" + this.f27216b;
    }
}
