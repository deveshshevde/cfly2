package rx.internal.operators;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final b f34223a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f34224b = new NotificationLite$1();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f34225c = new NotificationLite$2();

    private b() {
    }

    public static <T> b<T> a() {
        return f34223a;
    }

    public Object a(T t2) {
        return t2 == null ? f34225c : t2;
    }

    public T b(Object obj) {
        if (obj == f34225c) {
            return null;
        }
        return obj;
    }
}
