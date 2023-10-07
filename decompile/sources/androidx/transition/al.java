package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

class al extends ak {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4799a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f4800b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4801c = true;

    al() {
    }

    public void a(View view, Matrix matrix) {
        if (f4800b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f4800b = false;
            }
        }
    }

    public void b(View view, Matrix matrix) {
        if (f4801c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f4801c = false;
            }
        }
    }

    public void c(View view, Matrix matrix) {
        if (f4799a) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f4799a = false;
            }
        }
    }
}
