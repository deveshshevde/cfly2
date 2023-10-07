package b;

import android.content.Context;
import android.content.Intent;

public abstract class a<I, O> {

    /* renamed from: b.a$a  reason: collision with other inner class name */
    public static final class C0047a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final T f5585a;

        public C0047a(T t2) {
            this.f5585a = t2;
        }

        public T a() {
            return this.f5585a;
        }
    }

    public abstract Intent a(Context context, I i2);

    public abstract O a(int i2, Intent intent);

    public C0047a<O> b(Context context, I i2) {
        return null;
    }
}
