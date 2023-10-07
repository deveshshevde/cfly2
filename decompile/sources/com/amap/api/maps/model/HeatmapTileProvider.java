package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.amap.api.mapcore.util.cu;
import com.amap.api.maps.AMapException;
import fg.i;
import j.d;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 50;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private cu mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    public static class Builder {
        /* access modifiers changed from: private */
        public Collection<WeightedLatLng> data;
        /* access modifiers changed from: private */
        public Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        /* access modifiers changed from: private */
        public double opacity = 0.6d;
        /* access modifiers changed from: private */
        public int radius = 12;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection == null || collection.size() == 0) {
                try {
                    throw new AMapException("No input points.");
                } catch (AMapException e2) {
                    Log.e("amap", e2.getErrorMessage());
                    e2.printStackTrace();
                    return null;
                }
            } else {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.c(collection));
        }

        public Builder gradient(Gradient gradient2) {
            this.gradient = gradient2;
            return this;
        }

        public Builder radius(int i2) {
            this.radius = Math.max(10, Math.min(i2, 50));
            return this;
        }

        public Builder transparency(double d2) {
            this.opacity = Math.max(i.f27244a, Math.min(d2, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }
    }

    static {
        int[] iArr = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient c2 = builder.gradient;
        this.mGradient = c2;
        if (c2 == null || !c2.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i2 = this.mRadius;
        double d2 = (double) i2;
        Double.isNaN(d2);
        this.mKernel = a(i2, d2 / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    /* synthetic */ HeatmapTileProvider(Builder builder, byte b2) {
        this(builder);
    }

    private static double a(Collection<WeightedLatLng> collection, cu cuVar, int i2, int i3) {
        cu cuVar2 = cuVar;
        double d2 = cuVar2.f8208a;
        double d3 = cuVar2.f8210c;
        double d4 = cuVar2.f8209b;
        double d5 = d3 - d2;
        double d6 = cuVar2.f8211d - d4;
        if (d5 <= d6) {
            d5 = d6;
        }
        double d7 = (double) (i3 / (i2 * 2));
        Double.isNaN(d7);
        double d8 = (double) ((int) (d7 + 0.5d));
        Double.isNaN(d8);
        double d9 = d8 / d5;
        d dVar = new d();
        double d10 = i.f27244a;
        for (WeightedLatLng next : collection) {
            double d11 = next.getPoint().f10009x;
            int i4 = (int) ((next.getPoint().f10010y - d4) * d9);
            long j2 = (long) ((int) ((d11 - d2) * d9));
            d dVar2 = (d) dVar.a(j2);
            if (dVar2 == null) {
                dVar2 = new d();
                dVar.b(j2, dVar2);
            }
            long j3 = (long) i4;
            Double d12 = (Double) dVar2.a(j3);
            if (d12 == null) {
                d12 = Double.valueOf(i.f27244a);
            }
            d dVar3 = dVar;
            double d13 = d2;
            Double valueOf = Double.valueOf(d12.doubleValue() + next.intensity);
            dVar2.b(j3, valueOf);
            if (valueOf.doubleValue() > d10) {
                d10 = valueOf.doubleValue();
            }
            dVar = dVar3;
            d2 = d13;
        }
        return d10;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d2) {
        double[][] dArr2 = dArr;
        int[] iArr2 = iArr;
        int i2 = iArr2[iArr2.length - 1];
        double length = (double) (iArr2.length - 1);
        Double.isNaN(length);
        double d3 = length / d2;
        int length2 = dArr2.length;
        int[] iArr3 = new int[(length2 * length2)];
        for (int i3 = 0; i3 < length2; i3++) {
            for (int i4 = 0; i4 < length2; i4++) {
                double d4 = dArr2[i4][i3];
                int i5 = (i3 * length2) + i4;
                int i6 = (int) (d4 * d3);
                if (d4 == i.f27244a) {
                    iArr3[i5] = 0;
                } else if (i6 < iArr2.length) {
                    iArr3[i5] = iArr2[i6];
                } else {
                    iArr3[i5] = i2;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr3, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private double[] a(int i2) {
        int i3;
        double[] dArr = new double[21];
        int i4 = 5;
        while (true) {
            if (i4 >= 11) {
                break;
            }
            dArr[i4] = a(this.mData, this.mBounds, i2, (int) (Math.pow(2.0d, (double) i4) * 1280.0d));
            if (i4 == 5) {
                for (int i5 = 0; i5 < i4; i5++) {
                    dArr[i5] = dArr[i4];
                }
            }
            i4++;
        }
        for (i3 = 11; i3 < 21; i3++) {
            dArr[i3] = dArr[10];
        }
        return dArr;
    }

    private static double[] a(int i2, double d2) {
        double[] dArr = new double[((i2 * 2) + 1)];
        for (int i3 = -i2; i3 <= i2; i3++) {
            double d3 = (double) ((-i3) * i3);
            Double.isNaN(d3);
            dArr[i3 + i2] = Math.exp(d3 / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        double[][] dArr3 = dArr;
        double[] dArr4 = dArr2;
        Class<double> cls = double.class;
        double length = (double) dArr4.length;
        Double.isNaN(length);
        int floor = (int) Math.floor(length / 2.0d);
        int length2 = dArr3.length;
        int i2 = length2 - (floor * 2);
        int i3 = 1;
        int i4 = (floor + i2) - 1;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length2;
        double[][] dArr5 = (double[][]) Array.newInstance(cls, iArr);
        int i5 = 0;
        while (true) {
            double d2 = i.f27244a;
            if (i5 >= length2) {
                break;
            }
            int i6 = 0;
            while (i6 < length2) {
                double d3 = dArr3[i5][i6];
                if (d3 != d2) {
                    int i7 = i5 + floor;
                    if (i4 < i7) {
                        i7 = i4;
                    }
                    int i8 = i7 + 1;
                    int i9 = i5 - floor;
                    for (int i10 = floor > i9 ? floor : i9; i10 < i8; i10++) {
                        double[] dArr6 = dArr5[i10];
                        dArr6[i6] = dArr6[i6] + (dArr4[i10 - i9] * d3);
                    }
                }
                i6++;
                d2 = i.f27244a;
            }
            i5++;
        }
        int[] iArr2 = new int[2];
        iArr2[1] = i2;
        iArr2[0] = i2;
        double[][] dArr7 = (double[][]) Array.newInstance(cls, iArr2);
        int i11 = floor;
        while (i11 < i4 + 1) {
            int i12 = 0;
            while (i12 < length2) {
                double d4 = dArr5[i11][i12];
                if (d4 != i.f27244a) {
                    int i13 = i12 + floor;
                    if (i4 < i13) {
                        i13 = i4;
                    }
                    int i14 = i13 + i3;
                    int i15 = i12 - floor;
                    for (int i16 = floor > i15 ? floor : i15; i16 < i14; i16++) {
                        double[] dArr8 = dArr7[i11 - floor];
                        int i17 = i16 - floor;
                        dArr8[i17] = dArr8[i17] + (dArr4[i16 - i15] * d4);
                    }
                }
                i12++;
                i3 = 1;
            }
            i11++;
            i3 = 1;
        }
        return dArr7;
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng next : collection) {
                if (next.latLng.latitude < 85.0d && next.latLng.latitude > -85.0d) {
                    arrayList.add(next);
                }
            }
            this.mData = arrayList;
            cu d2 = d(arrayList);
            this.mBounds = d2;
            this.mTree = new a(d2);
            for (WeightedLatLng a2 : this.mData) {
                this.mTree.a(a2);
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        for (LatLng weightedLatLng : collection) {
            arrayList.add(new WeightedLatLng(weightedLatLng));
        }
        return arrayList;
    }

    private static cu d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it2 = collection.iterator();
        WeightedLatLng next = it2.next();
        double d2 = next.getPoint().f10009x;
        double d3 = next.getPoint().f10009x;
        double d4 = d2;
        double d5 = d3;
        double d6 = next.getPoint().f10010y;
        double d7 = next.getPoint().f10010y;
        while (it2.hasNext()) {
            WeightedLatLng next2 = it2.next();
            double d8 = next2.getPoint().f10009x;
            double d9 = next2.getPoint().f10010y;
            if (d8 < d4) {
                d4 = d8;
            }
            if (d8 > d5) {
                d5 = d8;
            }
            if (d9 < d6) {
                d6 = d9;
            }
            if (d9 > d7) {
                d7 = d9;
            }
        }
        return new cu(d4, d5, d6, d7);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.maps.model.Tile getTile(int r37, int r38, int r39) {
        /*
            r36 = this;
            r0 = r36
            r1 = r37
            r2 = r38
            r3 = r39
            double r4 = (double) r3
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.pow(r6, r4)
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r8 / r4
            int r10 = r0.mRadius
            double r11 = (double) r10
            java.lang.Double.isNaN(r11)
            double r11 = r11 * r4
            r13 = 4643211215818981376(0x4070000000000000, double:256.0)
            double r11 = r11 / r13
            double r6 = r6 * r11
            double r6 = r6 + r4
            r13 = 2
            int r10 = r10 * 2
            int r10 = r10 + 256
            double r14 = (double) r10
            java.lang.Double.isNaN(r14)
            double r6 = r6 / r14
            double r14 = (double) r1
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r4
            double r14 = r14 - r11
            r10 = 1
            int r1 = r1 + r10
            double r8 = (double) r1
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r4
            double r19 = r8 + r11
            double r8 = (double) r2
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r4
            double r8 = r8 - r11
            int r1 = r2 + 1
            double r1 = (double) r1
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r4
            double r1 = r1 + r11
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r21 = 0
            int r5 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x0073
            com.amap.api.mapcore.util.cu r4 = new com.amap.api.mapcore.util.cu
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r22 = r14 + r16
            r24 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r21 = r4
            r26 = r8
            r28 = r1
            r21.<init>(r22, r24, r26, r28)
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x006a:
            com.amap.api.maps.model.a r5 = r0.mTree
            java.util.Collection r4 = r5.a((com.amap.api.mapcore.util.cu) r4)
            r25 = r16
            goto L_0x008b
        L_0x0073:
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r19 > r16 ? 1 : (r19 == r16 ? 0 : -1))
            if (r5 <= 0) goto L_0x0089
            com.amap.api.mapcore.util.cu r4 = new com.amap.api.mapcore.util.cu
            r22 = 0
            double r24 = r19 - r16
            r21 = r4
            r26 = r8
            r28 = r1
            r21.<init>(r22, r24, r26, r28)
            goto L_0x006a
        L_0x0089:
            r25 = r21
        L_0x008b:
            com.amap.api.mapcore.util.cu r5 = new com.amap.api.mapcore.util.cu
            r16 = r5
            r17 = r14
            r21 = r8
            r23 = r1
            r16.<init>(r17, r19, r21, r23)
            com.amap.api.mapcore.util.cu r1 = new com.amap.api.mapcore.util.cu
            com.amap.api.mapcore.util.cu r2 = r0.mBounds
            double r13 = r2.f8208a
            double r28 = r13 - r11
            com.amap.api.mapcore.util.cu r2 = r0.mBounds
            double r13 = r2.f8210c
            double r30 = r13 + r11
            com.amap.api.mapcore.util.cu r2 = r0.mBounds
            double r13 = r2.f8209b
            double r32 = r13 - r11
            com.amap.api.mapcore.util.cu r2 = r0.mBounds
            double r13 = r2.f8211d
            double r34 = r13 + r11
            r27 = r1
            r27.<init>(r28, r30, r32, r34)
            boolean r1 = r5.a((com.amap.api.mapcore.util.cu) r1)
            if (r1 != 0) goto L_0x00c0
            com.amap.api.maps.model.Tile r1 = com.amap.api.maps.model.TileProvider.NO_TILE
            return r1
        L_0x00c0:
            com.amap.api.maps.model.a r1 = r0.mTree
            java.util.Collection r1 = r1.a((com.amap.api.mapcore.util.cu) r5)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x00cf
            com.amap.api.maps.model.Tile r1 = com.amap.api.maps.model.TileProvider.NO_TILE
            return r1
        L_0x00cf:
            int r2 = r0.mRadius
            int r5 = r2 * 2
            int r5 = r5 + 256
            r11 = 2
            int r2 = r2 * 2
            int r2 = r2 + 256
            int[] r11 = new int[r11]
            r11[r10] = r2
            r2 = 0
            r11[r2] = r5
            java.lang.Class<double> r2 = double.class
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r2, r11)
            double[][] r2 = (double[][]) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x00ed:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0112
            java.lang.Object r5 = r1.next()
            com.amap.api.maps.model.WeightedLatLng r5 = (com.amap.api.maps.model.WeightedLatLng) r5
            com.autonavi.amap.mapcore.DPoint r10 = r5.getPoint()
            double r11 = r10.f10009x
            double r11 = r11 - r17
            double r11 = r11 / r6
            int r11 = (int) r11
            double r12 = r10.f10010y
            double r12 = r12 - r8
            double r12 = r12 / r6
            int r10 = (int) r12
            r11 = r2[r11]
            r12 = r11[r10]
            double r14 = r5.intensity
            double r12 = r12 + r14
            r11[r10] = r12
            goto L_0x00ed
        L_0x0112:
            java.util.Iterator r1 = r4.iterator()
        L_0x0116:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x013d
            java.lang.Object r4 = r1.next()
            com.amap.api.maps.model.WeightedLatLng r4 = (com.amap.api.maps.model.WeightedLatLng) r4
            com.autonavi.amap.mapcore.DPoint r5 = r4.getPoint()
            double r10 = r5.f10009x
            double r10 = r10 + r25
            double r10 = r10 - r17
            double r10 = r10 / r6
            int r10 = (int) r10
            double r11 = r5.f10010y
            double r11 = r11 - r8
            double r11 = r11 / r6
            int r5 = (int) r11
            r10 = r2[r10]
            r11 = r10[r5]
            double r13 = r4.intensity
            double r11 = r11 + r13
            r10[r5] = r11
            goto L_0x0116
        L_0x013d:
            double[] r1 = r0.mKernel
            double[][] r1 = a((double[][]) r2, (double[]) r1)
            int[] r2 = r0.mColorMap
            double[] r4 = r0.mMaxIntensity
            r3 = r4[r3]
            android.graphics.Bitmap r1 = a(r1, r2, r3)
            com.amap.api.maps.model.Tile r1 = a((android.graphics.Bitmap) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.HeatmapTileProvider.getTile(int, int, int):com.amap.api.maps.model.Tile");
    }

    public int getTileHeight() {
        return 256;
    }

    public int getTileWidth() {
        return 256;
    }
}
