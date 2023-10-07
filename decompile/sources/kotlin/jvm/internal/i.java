package kotlin.jvm.internal;

public final class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f30248a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30249b;

    public i(Class<?> cls, String str) {
        h.d(cls, "jClass");
        h.d(str, "moduleName");
        this.f30248a = cls;
        this.f30249b = str;
    }

    public Class<?> a() {
        return this.f30248a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && h.a((Object) a(), (Object) ((i) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
