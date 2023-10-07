package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4847a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Field f4848b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4849c;

    private static void a() {
        if (!f4849c) {
            try {
                Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                f4848b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f4849c = true;
        }
    }

    static void a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
            return;
        }
        if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
            } else {
                return;
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            b(imageView, matrix);
            return;
        } else {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                Matrix matrix2 = null;
                a();
                Field field = f4848b;
                if (field != null) {
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                matrix2 = new Matrix();
                                f4848b.set(imageView, matrix2);
                            } catch (IllegalAccessException unused) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException unused2) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
            } else {
                return;
            }
        }
        imageView.invalidate();
    }

    private static void b(ImageView imageView, Matrix matrix) {
        if (f4847a) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused) {
                f4847a = false;
            }
        }
    }
}
