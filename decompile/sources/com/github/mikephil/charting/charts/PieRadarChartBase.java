package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.h;
import fc.e;
import fg.i;

public abstract class PieRadarChartBase<T extends h<? extends e<? extends Entry>>> extends Chart<T> {

    /* renamed from: a  reason: collision with root package name */
    private float f14835a = 270.0f;

    /* renamed from: b  reason: collision with root package name */
    private float f14836b = 270.0f;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f14837c = true;

    /* renamed from: d  reason: collision with root package name */
    protected float f14838d = 0.0f;

    /* renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14839a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f14840b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f14841c;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|(2:13|14)|15|17|18|19|20|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r0 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14841c = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendOrientation r2 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f14841c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendOrientation r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f14840b = r2
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r2 = f14840b     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r2 = f14840b     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f14839a = r2
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = f14839a     // Catch:{ NoSuchFieldError -> 0x005e }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x005e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x005e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x005e }
            L_0x005e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass1.<clinit>():void");
        }
    }

    public PieRadarChartBase(Context context) {
        super(context);
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PieRadarChartBase(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public abstract int a(float f2);

    public fg.e a(fg.e eVar, float f2, float f3) {
        fg.e a2 = fg.e.a(0.0f, 0.0f);
        a(eVar, f2, f3, a2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.M = new com.github.mikephil.charting.listener.e(this);
    }

    public void a(fg.e eVar, float f2, float f3, fg.e eVar2) {
        double d2 = (double) eVar.f27222a;
        double d3 = (double) f2;
        double d4 = (double) f3;
        double cos = Math.cos(Math.toRadians(d4));
        Double.isNaN(d3);
        Double.isNaN(d2);
        eVar2.f27222a = (float) (d2 + (cos * d3));
        double d5 = (double) eVar.f27223b;
        double sin = Math.sin(Math.toRadians(d4));
        Double.isNaN(d3);
        Double.isNaN(d5);
        eVar2.f27223b = (float) (d5 + (d3 * sin));
    }

    public float b(float f2, float f3) {
        fg.e centerOffsets = getCenterOffsets();
        double d2 = (double) (f2 - centerOffsets.f27222a);
        double d3 = (double) (f3 - centerOffsets.f27223b);
        Double.isNaN(d2);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d3);
        double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
        Double.isNaN(d3);
        float degrees = (float) Math.toDegrees(Math.acos(d3 / sqrt));
        if (f2 > centerOffsets.f27222a) {
            degrees = 360.0f - degrees;
        }
        float f4 = degrees + 90.0f;
        if (f4 > 360.0f) {
            f4 -= 360.0f;
        }
        fg.e.b(centerOffsets);
        return f4;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void computeScroll() {
        if (this.M instanceof com.github.mikephil.charting.listener.e) {
            ((com.github.mikephil.charting.listener.e) this.M).b();
        }
    }

    public float d(float f2, float f3) {
        fg.e centerOffsets = getCenterOffsets();
        float sqrt = (float) Math.sqrt(Math.pow((double) (f2 > centerOffsets.f27222a ? f2 - centerOffsets.f27222a : centerOffsets.f27222a - f2), 2.0d) + Math.pow((double) (f3 > centerOffsets.f27223b ? f3 - centerOffsets.f27223b : centerOffsets.f27223b - f3), 2.0d));
        fg.e.b(centerOffsets);
        return sqrt;
    }

    public float getDiameter() {
        RectF k2 = this.Q.k();
        k2.left += getExtraLeftOffset();
        k2.top += getExtraTopOffset();
        k2.right -= getExtraRightOffset();
        k2.bottom -= getExtraBottomOffset();
        return Math.min(k2.width(), k2.height());
    }

    public int getMaxVisibleCount() {
        return this.C.i();
    }

    public float getMinOffset() {
        return this.f14838d;
    }

    public abstract float getRadius();

    public float getRawRotationAngle() {
        return this.f14836b;
    }

    /* access modifiers changed from: protected */
    public abstract float getRequiredBaseOffset();

    /* access modifiers changed from: protected */
    public abstract float getRequiredLegendOffset();

    public float getRotationAngle() {
        return this.f14835a;
    }

    public float getYChartMax() {
        return 0.0f;
    }

    public float getYChartMin() {
        return 0.0f;
    }

    public void h() {
        if (this.C != null) {
            b();
            if (this.K != null) {
                this.N.a((h<?>) this.C);
            }
            j();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007f, code lost:
        if (r2 != 2) goto L_0x0081;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r11 = this;
            com.github.mikephil.charting.components.Legend r0 = r11.K
            r1 = 0
            if (r0 == 0) goto L_0x0198
            com.github.mikephil.charting.components.Legend r0 = r11.K
            boolean r0 = r0.y()
            if (r0 == 0) goto L_0x0198
            com.github.mikephil.charting.components.Legend r0 = r11.K
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0198
            com.github.mikephil.charting.components.Legend r0 = r11.K
            float r0 = r0.f14852a
            fg.j r2 = r11.Q
            float r2 = r2.n()
            com.github.mikephil.charting.components.Legend r3 = r11.K
            float r3 = r3.q()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass1.f14841c
            com.github.mikephil.charting.components.Legend r3 = r11.K
            com.github.mikephil.charting.components.Legend$LegendOrientation r3 = r3.f()
            int r3 = r3.ordinal()
            r2 = r2[r3]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x008e
            if (r2 == r3) goto L_0x0040
            goto L_0x0081
        L_0x0040:
            com.github.mikephil.charting.components.Legend r0 = r11.K
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r0 = r0.e()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP
            if (r0 == r2) goto L_0x0054
            com.github.mikephil.charting.components.Legend r0 = r11.K
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r0 = r0.e()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM
            if (r0 != r2) goto L_0x0081
        L_0x0054:
            float r0 = r11.getRequiredLegendOffset()
            com.github.mikephil.charting.components.Legend r2 = r11.K
            float r2 = r2.f14853b
            float r2 = r2 + r0
            fg.j r0 = r11.Q
            float r0 = r0.m()
            com.github.mikephil.charting.components.Legend r5 = r11.K
            float r5 = r5.q()
            float r0 = r0 * r5
            float r0 = java.lang.Math.min(r2, r0)
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass1.f14839a
            com.github.mikephil.charting.components.Legend r5 = r11.K
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r5 = r5.e()
            int r5 = r5.ordinal()
            r2 = r2[r5]
            if (r2 == r4) goto L_0x0089
            if (r2 == r3) goto L_0x0086
        L_0x0081:
            r0 = 0
        L_0x0082:
            r2 = 0
        L_0x0083:
            r3 = 0
            goto L_0x0183
        L_0x0086:
            r2 = r0
            r0 = 0
            goto L_0x0083
        L_0x0089:
            r3 = r0
            r0 = 0
            r2 = 0
            goto L_0x0183
        L_0x008e:
            com.github.mikephil.charting.components.Legend r2 = r11.K
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r2 = r2.d()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT
            if (r2 == r5) goto L_0x00a6
            com.github.mikephil.charting.components.Legend r2 = r11.K
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r2 = r2.d()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT
            if (r2 != r5) goto L_0x00a3
            goto L_0x00a6
        L_0x00a3:
            r0 = 0
            goto L_0x0126
        L_0x00a6:
            com.github.mikephil.charting.components.Legend r2 = r11.K
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = r2.e()
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r5 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.CENTER
            if (r2 != r5) goto L_0x00b8
            r2 = 1095761920(0x41500000, float:13.0)
            float r2 = fg.i.a((float) r2)
            float r0 = r0 + r2
            goto L_0x0126
        L_0x00b8:
            r2 = 1090519040(0x41000000, float:8.0)
            float r2 = fg.i.a((float) r2)
            float r0 = r0 + r2
            com.github.mikephil.charting.components.Legend r2 = r11.K
            float r2 = r2.f14853b
            com.github.mikephil.charting.components.Legend r5 = r11.K
            float r5 = r5.f14854c
            float r2 = r2 + r5
            fg.e r5 = r11.getCenter()
            com.github.mikephil.charting.components.Legend r6 = r11.K
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r6 = r6.d()
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r7 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT
            r8 = 1097859072(0x41700000, float:15.0)
            if (r6 != r7) goto L_0x00e0
            int r6 = r11.getWidth()
            float r6 = (float) r6
            float r6 = r6 - r0
            float r6 = r6 + r8
            goto L_0x00e2
        L_0x00e0:
            float r6 = r0 - r8
        L_0x00e2:
            float r2 = r2 + r8
            float r7 = r11.d(r6, r2)
            float r8 = r11.getRadius()
            float r6 = r11.b(r6, r2)
            fg.e r6 = r11.a(r5, r8, r6)
            float r8 = r6.f27222a
            float r9 = r6.f27223b
            float r8 = r11.d(r8, r9)
            r9 = 1084227584(0x40a00000, float:5.0)
            float r9 = fg.i.a((float) r9)
            float r10 = r5.f27223b
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 < 0) goto L_0x0117
            int r2 = r11.getHeight()
            float r2 = (float) r2
            float r2 = r2 - r0
            int r10 = r11.getWidth()
            float r10 = (float) r10
            int r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0117
            goto L_0x0120
        L_0x0117:
            int r0 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x011f
            float r8 = r8 - r7
            float r9 = r9 + r8
            r0 = r9
            goto L_0x0120
        L_0x011f:
            r0 = 0
        L_0x0120:
            fg.e.b(r5)
            fg.e.b(r6)
        L_0x0126:
            int[] r2 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass1.f14840b
            com.github.mikephil.charting.components.Legend r5 = r11.K
            com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r5 = r5.d()
            int r5 = r5.ordinal()
            r2 = r2[r5]
            if (r2 == r4) goto L_0x0180
            if (r2 == r3) goto L_0x0082
            r0 = 3
            if (r2 == r0) goto L_0x013c
            goto L_0x014e
        L_0x013c:
            int[] r0 = com.github.mikephil.charting.charts.PieRadarChartBase.AnonymousClass1.f14839a
            com.github.mikephil.charting.components.Legend r2 = r11.K
            com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r2 = r2.e()
            int r2 = r2.ordinal()
            r0 = r0[r2]
            if (r0 == r4) goto L_0x0168
            if (r0 == r3) goto L_0x0150
        L_0x014e:
            goto L_0x0081
        L_0x0150:
            com.github.mikephil.charting.components.Legend r0 = r11.K
            float r0 = r0.f14853b
            fg.j r2 = r11.Q
            float r2 = r2.m()
            com.github.mikephil.charting.components.Legend r3 = r11.K
            float r3 = r3.q()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            goto L_0x0086
        L_0x0168:
            com.github.mikephil.charting.components.Legend r0 = r11.K
            float r0 = r0.f14853b
            fg.j r2 = r11.Q
            float r2 = r2.m()
            com.github.mikephil.charting.components.Legend r3 = r11.K
            float r3 = r3.q()
            float r2 = r2 * r3
            float r0 = java.lang.Math.min(r0, r2)
            goto L_0x0089
        L_0x0180:
            r1 = r0
            goto L_0x0081
        L_0x0183:
            float r4 = r11.getRequiredBaseOffset()
            float r1 = r1 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r0 = r0 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r3 = r3 + r4
            float r4 = r11.getRequiredBaseOffset()
            float r2 = r2 + r4
            goto L_0x019b
        L_0x0198:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x019b:
            float r4 = r11.f14838d
            float r4 = fg.i.a((float) r4)
            boolean r5 = r11 instanceof com.github.mikephil.charting.charts.RadarChart
            if (r5 == 0) goto L_0x01bc
            com.github.mikephil.charting.components.XAxis r5 = r11.getXAxis()
            boolean r6 = r5.y()
            if (r6 == 0) goto L_0x01bc
            boolean r6 = r5.h()
            if (r6 == 0) goto L_0x01bc
            int r5 = r5.E
            float r5 = (float) r5
            float r4 = java.lang.Math.max(r4, r5)
        L_0x01bc:
            float r5 = r11.getExtraTopOffset()
            float r3 = r3 + r5
            float r5 = r11.getExtraRightOffset()
            float r0 = r0 + r5
            float r5 = r11.getExtraBottomOffset()
            float r2 = r2 + r5
            float r5 = r11.getExtraLeftOffset()
            float r1 = r1 + r5
            float r1 = java.lang.Math.max(r4, r1)
            float r3 = java.lang.Math.max(r4, r3)
            float r0 = java.lang.Math.max(r4, r0)
            float r5 = r11.getRequiredBaseOffset()
            float r2 = java.lang.Math.max(r5, r2)
            float r2 = java.lang.Math.max(r4, r2)
            fg.j r4 = r11.Q
            r4.a(r1, r3, r0, r2)
            boolean r4 = r11.B
            if (r4 == 0) goto L_0x021f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "offsetLeft: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = ", offsetTop: "
            r4.append(r1)
            r4.append(r3)
            java.lang.String r1 = ", offsetRight: "
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = ", offsetBottom: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = "MPAndroidChart"
            android.util.Log.i(r1, r0)
        L_0x021f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.charts.PieRadarChartBase.j():void");
    }

    public boolean k() {
        return this.f14837c;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (!this.I || this.M == null) ? super.onTouchEvent(motionEvent) : this.M.onTouch(this, motionEvent);
    }

    public void setMinOffset(float f2) {
        this.f14838d = f2;
    }

    public void setRotationAngle(float f2) {
        this.f14836b = f2;
        this.f14835a = i.c(f2);
    }

    public void setRotationEnabled(boolean z2) {
        this.f14837c = z2;
    }
}
