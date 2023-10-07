package is;

public abstract class c<T, V> {

    /* renamed from: a  reason: collision with root package name */
    private final String f29182a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<V> f29183b;

    public c(Class<V> cls, String str) {
        this.f29182a = str;
        this.f29183b = cls;
    }

    public abstract V a(T t2);

    public String a() {
        return this.f29182a;
    }

    public void a(T t2, V v2) {
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }
}
