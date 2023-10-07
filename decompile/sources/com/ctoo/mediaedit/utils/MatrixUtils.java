package com.ctoo.mediaedit.utils;

import android.opengl.Matrix;

public enum MatrixUtils {
    ;

    public static float[] a() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public static float[] a(float[] fArr, boolean z2, boolean z3) {
        if (z2 || z3) {
            float f2 = -1.0f;
            float f3 = z2 ? -1.0f : 1.0f;
            if (!z3) {
                f2 = 1.0f;
            }
            Matrix.scaleM(fArr, 0, f3, f2, 1.0f);
        }
        return fArr;
    }
}
