package androidx.work;

import android.util.Log;

public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f5447a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final int f5448b = 20;

    public static class a extends j {

        /* renamed from: a  reason: collision with root package name */
        private int f5449a;

        public a(int i2) {
            super(i2);
            this.f5449a = i2;
        }

        public void a(String str, String str2, Throwable... thArr) {
            if (this.f5449a > 2) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, thArr[0]);
            }
        }

        public void b(String str, String str2, Throwable... thArr) {
            if (this.f5449a > 3) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, thArr[0]);
            }
        }

        public void c(String str, String str2, Throwable... thArr) {
            if (this.f5449a > 4) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, thArr[0]);
            }
        }

        public void d(String str, String str2, Throwable... thArr) {
            if (this.f5449a > 5) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, thArr[0]);
            }
        }

        public void e(String str, String str2, Throwable... thArr) {
            if (this.f5449a > 6) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }
    }

    public j(int i2) {
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f5447a == null) {
                f5447a = new a(3);
            }
            jVar = f5447a;
        }
        return jVar;
    }

    public static String a(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i2 = f5448b;
        if (length >= i2) {
            str = str.substring(0, i2);
        }
        sb.append(str);
        return sb.toString();
    }

    public static synchronized void a(j jVar) {
        synchronized (j.class) {
            f5447a = jVar;
        }
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void c(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void e(String str, String str2, Throwable... thArr);
}
