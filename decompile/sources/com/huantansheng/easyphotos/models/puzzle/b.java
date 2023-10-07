package com.huantansheng.easyphotos.models.puzzle;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import java.util.Arrays;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f20381a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private static final Matrix f20382b = new Matrix();

    public static float a(Matrix matrix) {
        return (float) Math.sqrt(Math.pow((double) a(matrix, 0), 2.0d) + Math.pow((double) a(matrix, 3), 2.0d));
    }

    public static float a(Matrix matrix, int i2) {
        float[] fArr = f20381a;
        matrix.getValues(fArr);
        return fArr[i2];
    }

    public static float a(d dVar) {
        if (dVar == null) {
            return 1.0f;
        }
        Matrix matrix = f20382b;
        matrix.reset();
        matrix.setRotate(-dVar.e());
        float[] a2 = a(dVar.a().i());
        matrix.mapPoints(a2);
        RectF a3 = a(a2);
        return Math.max(a3.width() / ((float) dVar.c()), a3.height() / ((float) dVar.d()));
    }

    private static Matrix a(a aVar, int i2, int i3, float f2) {
        RectF i4 = aVar.i();
        Matrix matrix = new Matrix();
        matrix.postTranslate(i4.centerX() - ((float) (i2 / 2)), i4.centerY() - ((float) (i3 / 2)));
        float f3 = (float) i2;
        float f4 = (float) i3;
        float height = i4.height() * f3 > i4.width() * f4 ? (i4.height() + f2) / f4 : (i4.width() + f2) / f3;
        matrix.postScale(height, height, i4.centerX(), i4.centerY());
        return matrix;
    }

    public static Matrix a(a aVar, Drawable drawable, float f2) {
        return a(aVar, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f2);
    }

    public static RectF a(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        int length = fArr.length;
        for (int i2 = 1; i2 < length; i2 += 2) {
            float round = ((float) Math.round(fArr[i2 - 1] * 10.0f)) / 10.0f;
            float round2 = ((float) Math.round(fArr[i2] * 10.0f)) / 10.0f;
            rectF.left = round < rectF.left ? round : rectF.left;
            rectF.top = round2 < rectF.top ? round2 : rectF.top;
            if (round <= rectF.right) {
                round = rectF.right;
            }
            rectF.right = round;
            if (round2 <= rectF.bottom) {
                round2 = rectF.bottom;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }

    static boolean a(d dVar, float f2) {
        Matrix matrix = f20382b;
        matrix.reset();
        matrix.setRotate(-f2);
        float[] fArr = new float[8];
        float[] fArr2 = new float[8];
        matrix.mapPoints(fArr, dVar.f());
        matrix.mapPoints(fArr2, a(dVar.a().i()));
        return a(fArr).contains(a(fArr2));
    }

    public static float[] a(RectF rectF) {
        return new float[]{rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom};
    }

    public static float b(Matrix matrix) {
        return (float) (-(Math.atan2((double) a(matrix, 1), (double) a(matrix, 0)) * 57.29577951308232d));
    }

    public static Matrix b(d dVar, float f2) {
        return a(dVar.a(), dVar.b(), f2);
    }

    static float[] b(d dVar) {
        if (dVar == null) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        }
        Matrix matrix = f20382b;
        matrix.reset();
        matrix.setRotate(-dVar.e());
        float[] f2 = dVar.f();
        float[] copyOf = Arrays.copyOf(f2, f2.length);
        float[] a2 = a(dVar.a().i());
        matrix.mapPoints(copyOf);
        matrix.mapPoints(a2);
        RectF a3 = a(copyOf);
        RectF a4 = a(a2);
        float f3 = a3.left - a4.left;
        float f4 = a3.top - a4.top;
        float f5 = a3.right - a4.right;
        float f6 = a3.bottom - a4.bottom;
        float[] fArr = new float[4];
        if (f3 <= 0.0f) {
            f3 = 0.0f;
        }
        fArr[0] = f3;
        if (f4 <= 0.0f) {
            f4 = 0.0f;
        }
        fArr[1] = f4;
        if (f5 >= 0.0f) {
            f5 = 0.0f;
        }
        fArr[2] = f5;
        if (f6 >= 0.0f) {
            f6 = 0.0f;
        }
        fArr[3] = f6;
        matrix.reset();
        matrix.setRotate(dVar.e());
        matrix.mapPoints(fArr);
        return fArr;
    }
}
