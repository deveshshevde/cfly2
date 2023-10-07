package androidx.transition;

import android.view.View;

class ak extends ap {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4798a = true;

    ak() {
    }

    public float a(View view) {
        if (f4798a) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f4798a = false;
            }
        }
        return view.getAlpha();
    }

    public void a(View view, float f2) {
        if (f4798a) {
            try {
                view.setTransitionAlpha(f2);
                return;
            } catch (NoSuchMethodError unused) {
                f4798a = false;
            }
        }
        view.setAlpha(f2);
    }

    public void b(View view) {
    }

    public void c(View view) {
    }
}
