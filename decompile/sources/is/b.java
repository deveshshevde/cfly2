package is;

public abstract class b<T> extends c<T, Integer> {
    public b(String str) {
        super(Integer.class, str);
    }

    public final void a(T t2, Integer num) {
        a(t2, Integer.valueOf(num.intValue()));
    }
}
