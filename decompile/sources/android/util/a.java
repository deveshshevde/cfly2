package android.util;

public abstract class a<T> extends Property<T, Integer> {
    public a(String str) {
        super(Integer.class, str);
    }

    /* renamed from: a */
    public abstract Integer get(T t2);

    public abstract void a(T t2, int i2);

    /* renamed from: a */
    public final void set(T t2, Integer num) {
        a(t2, num.intValue());
    }
}
