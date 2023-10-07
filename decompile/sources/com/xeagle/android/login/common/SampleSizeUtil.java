package com.xeagle.android.login.common;

import android.opengl.GLES10;

public class SampleSizeUtil {
    private static int textureSize;

    public static final int adjustSampleSizeWithTexture(int i2, int i3, int i4) {
        int textureSize2 = getTextureSize();
        if (textureSize2 <= 0) {
            return i2;
        }
        if (i3 <= i2 && i4 <= i2) {
            return i2;
        }
        while (true) {
            float f2 = (float) i2;
            float f3 = (float) textureSize2;
            if (((float) i3) / f2 <= f3 && ((float) i4) / f2 <= f3) {
                return roundup2n(i2);
            }
            i2++;
        }
    }

    public static int calculateSampleSize(int i2, int i3, int i4) {
        int sqrt;
        if (i2 <= 0 || i3 <= 0 || (sqrt = (int) Math.sqrt((double) (((float) (i2 * i3)) / ((float) i4)))) < 1) {
            return 1;
        }
        return sqrt;
    }

    public static int calculateSampleSize(int i2, int i3, int i4, int i5) {
        int i6 = 1;
        if (i2 > 0 && i3 > 0) {
            if (i4 <= 0 && i5 <= 0) {
                return 1;
            }
            if (i4 <= 0) {
                i4 = (int) ((((float) (i2 * i5)) / ((float) i3)) + 0.5f);
            } else if (i5 <= 0) {
                i5 = (int) ((((float) (i3 * i4)) / ((float) i2)) + 0.5f);
            }
            if (i3 > i5 || i2 > i4) {
                int round = Math.round(((float) i3) / ((float) i5));
                int round2 = Math.round(((float) i2) / ((float) i4));
                if (round >= round2) {
                    round = round2;
                }
                if (round != 0) {
                    i6 = round;
                }
                float f2 = (float) (i2 * i3);
                while (f2 / ((float) (i6 * i6)) > ((float) (i4 * i5 * 2))) {
                    i6++;
                }
            }
        }
        return i6;
    }

    public static int calculateSampleSize(String str, int i2) {
        int[] decodeBound = BitmapDecoder.decodeBound(str);
        return calculateSampleSize(decodeBound[0], decodeBound[1], i2);
    }

    public static final int getTextureSize() {
        int i2 = textureSize;
        if (i2 > 0) {
            return i2;
        }
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int i3 = iArr[0];
        textureSize = i3;
        return i3;
    }

    private static final int roundup2n(int i2) {
        if (((i2 - 1) & i2) == 0) {
            return i2;
        }
        int i3 = 0;
        while (i2 > 0) {
            i2 >>= 1;
            i3++;
        }
        return 1 << i3;
    }
}
