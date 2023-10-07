package com.autonavi.ae.gmap.maploader;

public final class Pools {

    public interface Pool<T> {
        T acquire();

        void destory();

        boolean release(T t2);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i2) {
            if (i2 > 0) {
                this.mPool = new Object[i2];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(T t2) {
            for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                if (this.mPool[i2] == t2) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i2 = this.mPoolSize;
            if (i2 <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            T[] tArr = this.mPool;
            T t2 = tArr[i3];
            tArr[i3] = null;
            this.mPoolSize = i2 - 1;
            return t2;
        }

        public void destory() {
            int i2 = 0;
            while (true) {
                Object[] objArr = this.mPool;
                if (i2 < objArr.length) {
                    objArr[i2] = null;
                    i2++;
                } else {
                    return;
                }
            }
        }

        public boolean release(T t2) {
            if (!isInPool(t2)) {
                int i2 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i2 >= objArr.length) {
                    return false;
                }
                objArr[i2] = t2;
                this.mPoolSize = i2 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock = new Object();

        public SynchronizedPool(int i2) {
            super(i2);
        }

        public T acquire() {
            T acquire;
            synchronized (this.mLock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(T t2) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t2);
            }
            return release;
        }
    }

    private Pools() {
    }
}
