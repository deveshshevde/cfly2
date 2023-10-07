package is;

public abstract class a<T> extends c<T, Float> {
    public a(String str) {
        super(Float.class, str);
    }

    public abstract void a(T t2, float f2);

    public final void a(T t2, Float f2) {
        a(t2, f2.floatValue());
    }
}
