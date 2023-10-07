package org.opencv.android;

import android.graphics.Bitmap;
import org.opencv.core.Mat;

public class Utils {
    public static void a(Mat mat, Bitmap bitmap) {
        a(mat, bitmap, false);
    }

    public static void a(Mat mat, Bitmap bitmap, boolean z2) {
        if (mat == null) {
            throw new IllegalArgumentException("mat == null");
        } else if (bitmap != null) {
            nMatToBitmap2(mat.f34059a, bitmap, z2);
        } else {
            throw new IllegalArgumentException("bmp == null");
        }
    }

    private static native void nBitmapToMat2(Bitmap bitmap, long j2, boolean z2);

    private static native void nMatToBitmap2(long j2, Bitmap bitmap, boolean z2);
}
