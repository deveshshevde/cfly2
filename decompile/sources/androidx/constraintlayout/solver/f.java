package androidx.constraintlayout.solver;

final class f {

    interface a<T> {
        T a();

        void a(T[] tArr, int i2);

        boolean a(T t2);
    }

    static class b<T> implements a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f2193a;

        /* renamed from: b  reason: collision with root package name */
        private int f2194b;

        b(int i2) {
            if (i2 > 0) {
                this.f2193a = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        public T a() {
            int i2 = this.f2194b;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T[] tArr = this.f2193a;
            T t2 = tArr[i3];
            tArr[i3] = null;
            this.f2194b = i2 - 1;
            return t2;
        }

        public void a(T[] tArr, int i2) {
            if (i2 > tArr.length) {
                i2 = tArr.length;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                T t2 = tArr[i3];
                int i4 = this.f2194b;
                Object[] objArr = this.f2193a;
                if (i4 < objArr.length) {
                    objArr[i4] = t2;
                    this.f2194b = i4 + 1;
                }
            }
        }

        public boolean a(T t2) {
            int i2 = this.f2194b;
            Object[] objArr = this.f2193a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t2;
            this.f2194b = i2 + 1;
            return true;
        }
    }
}
