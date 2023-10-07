package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f9737a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f9738b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final float f9739c;

        private a(int i2, int i3, float f2) {
            this.f9737a = i2;
            this.f9738b = i3;
            this.f9739c = f2;
        }

        /* synthetic */ a(int i2, int i3, float f2, byte b2) {
            this(i2, i3, f2);
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, (byte) 0);
    }

    private Gradient(int[] iArr, float[] fArr, byte b2) {
        this.isAvailable = true;
        if (iArr == null || fArr == null) {
            throw new AMapException("colors and startPoints should not be null");
        }
        try {
            if (iArr.length != fArr.length) {
                throw new AMapException("colors and startPoints should be same length");
            } else if (iArr.length != 0) {
                int i2 = 1;
                while (i2 < fArr.length) {
                    if (fArr[i2] >= fArr[i2 - 1]) {
                        i2++;
                    } else {
                        throw new AMapException("startPoints should be in increasing order");
                    }
                }
                this.mColorMapSize = 1000;
                int[] iArr2 = new int[iArr.length];
                this.mColors = iArr2;
                this.mStartPoints = new float[fArr.length];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
                this.isAvailable = true;
            } else {
                throw new AMapException("No colors have been defined");
            }
        } catch (AMapException e2) {
            this.isAvailable = false;
            Log.e("amap", e2.getErrorMessage());
            e2.printStackTrace();
        }
    }

    private static int a(int i2, int i3, float f2) {
        int alpha = (int) ((((float) (Color.alpha(i3) - Color.alpha(i2))) * f2) + ((float) Color.alpha(i2)));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i3), Color.green(i3), Color.blue(i3), fArr2);
        if (fArr[0] - fArr2[0] > 180.0f) {
            fArr2[0] = fArr2[0] + 360.0f;
        } else if (fArr2[0] - fArr[0] > 180.0f) {
            fArr[0] = fArr[0] + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i4 = 0; i4 < 3; i4++) {
            fArr3[i4] = ((fArr2[i4] - fArr[i4]) * f2) + fArr[i4];
        }
        return Color.HSVToColor(alpha, fArr3);
    }

    private HashMap<Integer, a> a() {
        HashMap<Integer, a> hashMap = new HashMap<>(32);
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], ((float) this.mColorMapSize) * this.mStartPoints[0], (byte) 0));
        }
        for (int i2 = 1; i2 < this.mColors.length; i2++) {
            int i3 = i2 - 1;
            Integer valueOf = Integer.valueOf((int) (((float) this.mColorMapSize) * this.mStartPoints[i3]));
            int[] iArr = this.mColors;
            int i4 = iArr[i3];
            int i5 = iArr[i2];
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new a(i4, i5, ((float) this.mColorMapSize) * (fArr[i2] - fArr[i3]), (byte) 0));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (((float) this.mColorMapSize) * fArr2[length]));
            int[] iArr2 = this.mColors;
            hashMap.put(valueOf2, new a(iArr2[length], iArr2[length], ((float) this.mColorMapSize) * (1.0f - this.mStartPoints[length]), (byte) 0));
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public int[] generateColorMap(double d2) {
        HashMap<Integer, a> a2 = a();
        int[] iArr = new int[this.mColorMapSize];
        a aVar = a2.get(0);
        int i2 = 0;
        for (int i3 = 0; i3 < this.mColorMapSize; i3++) {
            if (a2.containsKey(Integer.valueOf(i3))) {
                aVar = a2.get(Integer.valueOf(i3));
                i2 = i3;
            }
            iArr[i3] = a(aVar.f9737a, aVar.f9738b, ((float) (i3 - i2)) / aVar.f9739c);
        }
        if (d2 != 1.0d) {
            for (int i4 = 0; i4 < this.mColorMapSize; i4++) {
                int i5 = iArr[i4];
                double alpha = (double) Color.alpha(i5);
                Double.isNaN(alpha);
                iArr[i4] = Color.argb((int) (alpha * d2), Color.red(i5), Color.green(i5), Color.blue(i5));
            }
        }
        return iArr;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    /* access modifiers changed from: protected */
    public boolean isAvailable() {
        return this.isAvailable;
    }
}
