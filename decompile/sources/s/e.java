package s;

public final class e {

    public interface a<T> {
        T a();

        boolean a(T t2);
    }

    public static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f34396a;

        /* renamed from: b  reason: collision with root package name */
        private int f34397b;

        public b(int i2) {
            if (i2 > 0) {
                this.f34396a = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean b(T t2) {
            for (int i2 = 0; i2 < this.f34397b; i2++) {
                if (this.f34396a[i2] == t2) {
                    return true;
                }
            }
            return false;
        }

        public T a() {
            int i2 = this.f34397b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T[] tArr = this.f34396a;
            T t2 = tArr[i3];
            tArr[i3] = null;
            this.f34397b = i2 - 1;
            return t2;
        }

        public boolean a(T t2) {
            if (!b(t2)) {
                int i2 = this.f34397b;
                Object[] objArr = this.f34396a;
                if (i2 >= objArr.length) {
                    return false;
                }
                objArr[i2] = t2;
                this.f34397b = i2 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class c<T> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f34398a = new Object();

        public c(int i2) {
            super(i2);
        }

        public T a() {
            T a2;
            synchronized (this.f34398a) {
                a2 = super.a();
            }
            return a2;
        }

        public boolean a(T t2) {
            boolean a2;
            synchronized (this.f34398a) {
                a2 = super.a(t2);
            }
            return a2;
        }
    }
}
