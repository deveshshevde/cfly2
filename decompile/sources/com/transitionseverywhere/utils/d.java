package com.transitionseverywhere.utils;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.reflect.Field;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Matrix f21951a = new Matrix() {
        /* access modifiers changed from: package-private */
        public void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean postRotate(float f2) {
            a();
            return false;
        }

        public boolean postRotate(float f2, float f3, float f4) {
            a();
            return false;
        }

        public boolean postScale(float f2, float f3) {
            a();
            return false;
        }

        public boolean postScale(float f2, float f3, float f4, float f5) {
            a();
            return false;
        }

        public boolean postSkew(float f2, float f3) {
            a();
            return false;
        }

        public boolean postSkew(float f2, float f3, float f4, float f5) {
            a();
            return false;
        }

        public boolean postTranslate(float f2, float f3) {
            a();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean preRotate(float f2) {
            a();
            return false;
        }

        public boolean preRotate(float f2, float f3, float f4) {
            a();
            return false;
        }

        public boolean preScale(float f2, float f3) {
            a();
            return false;
        }

        public boolean preScale(float f2, float f3, float f4, float f5) {
            a();
            return false;
        }

        public boolean preSkew(float f2, float f3) {
            a();
            return false;
        }

        public boolean preSkew(float f2, float f3, float f4, float f5) {
            a();
            return false;
        }

        public boolean preTranslate(float f2, float f3) {
            a();
            return false;
        }

        public void reset() {
            a();
        }

        public void set(Matrix matrix) {
            a();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            a();
            return false;
        }

        public boolean setPolyToPoly(float[] fArr, int i2, float[] fArr2, int i3, int i4) {
            a();
            return false;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            a();
            return false;
        }

        public void setRotate(float f2) {
            a();
        }

        public void setRotate(float f2, float f3, float f4) {
            a();
        }

        public void setScale(float f2, float f3) {
            a();
        }

        public void setScale(float f2, float f3, float f4, float f5) {
            a();
        }

        public void setSinCos(float f2, float f3) {
            a();
        }

        public void setSinCos(float f2, float f3, float f4, float f5) {
            a();
        }

        public void setSkew(float f2, float f3) {
            a();
        }

        public void setSkew(float f2, float f3, float f4, float f5) {
            a();
        }

        public void setTranslate(float f2, float f3) {
            a();
        }

        public void setValues(float[] fArr) {
            a();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final Field f21952b = i.a(ImageView.class, "mDrawMatrix");

    public static class a implements TypeEvaluator<Matrix> {

        /* renamed from: a  reason: collision with root package name */
        float[] f21953a = new float[9];

        /* renamed from: b  reason: collision with root package name */
        float[] f21954b = new float[9];

        /* renamed from: c  reason: collision with root package name */
        Matrix f21955c = new Matrix();

        /* renamed from: a */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f21953a);
            matrix2.getValues(this.f21954b);
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.f21954b;
                float f3 = fArr[i2];
                float[] fArr2 = this.f21953a;
                fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
            }
            this.f21955c.setValues(this.f21954b);
            return this.f21955c;
        }
    }

    public static class b implements TypeEvaluator<Matrix> {
        /* renamed from: a */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    public static void a(ImageView imageView, Matrix matrix) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            if (matrix == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
                drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
            } else {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                Matrix imageMatrix = imageView.getImageMatrix();
                if (imageMatrix.isIdentity()) {
                    imageMatrix = new Matrix();
                    i.a((Object) imageView, f21952b, (Object) imageMatrix);
                }
                imageMatrix.set(matrix);
            }
            imageView.invalidate();
        }
    }
}
