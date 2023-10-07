package md;

import android.os.Build;
import android.util.Log;
import android.view.View;

public class a {

    /* renamed from: md.a$a  reason: collision with other inner class name */
    public static abstract class C0224a {

        /* renamed from: a  reason: collision with root package name */
        protected View f31090a;

        protected C0224a(View view) {
            this.f31090a = view;
            Log.i("ViewHelper", getClass().getSimpleName());
        }

        public abstract void a(int i2);

        public abstract void a(Runnable runnable);

        public abstract boolean a();
    }

    public static class b extends C0224a {
        public b(View view) {
            super(view);
        }

        public void a(int i2) {
            Log.d("ViewHelper", "setScrollX: " + i2);
            this.f31090a.scrollTo(i2, this.f31090a.getScrollY());
        }

        public void a(Runnable runnable) {
            this.f31090a.post(runnable);
        }

        public boolean a() {
            return false;
        }
    }

    public static final C0224a a(View view) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 16 ? new mg.a(view) : i2 >= 14 ? new mf.a(view) : new b(view);
    }
}
