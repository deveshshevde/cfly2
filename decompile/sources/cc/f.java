package cc;

public final class f {

    public interface a<T> {
        T b();
    }

    public static <T> a<T> a(final a<T> aVar) {
        return new a<T>() {

            /* renamed from: b  reason: collision with root package name */
            private volatile T f6182b;

            public T b() {
                if (this.f6182b == null) {
                    synchronized (this) {
                        if (this.f6182b == null) {
                            this.f6182b = k.a(a.this.b());
                        }
                    }
                }
                return this.f6182b;
            }
        };
    }
}
