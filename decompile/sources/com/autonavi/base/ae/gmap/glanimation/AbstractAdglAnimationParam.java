package com.autonavi.base.ae.gmap.glanimation;

public abstract class AbstractAdglAnimationParam {
    protected float factor;
    protected boolean hasCheckedParam;
    protected boolean hasFromValue;
    protected boolean hasToValue;
    protected int interpolationType;
    protected float mult;
    protected boolean needToCaculate;
    protected float normalizedTime;

    public AbstractAdglAnimationParam() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    static float bounce(float f2) {
        return f2 * f2 * 8.0f;
    }

    public abstract void checkParam();

    public float getCurMult() {
        return this.mult;
    }

    public int getInterpolatorType() {
        return this.interpolationType;
    }

    public boolean needToCaculate() {
        if (!this.hasCheckedParam) {
            checkParam();
        }
        return this.hasCheckedParam && this.needToCaculate;
    }

    public void reset() {
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.interpolationType = 0;
        this.factor = 1.0f;
        this.hasCheckedParam = false;
        this.needToCaculate = false;
        this.hasFromValue = false;
        this.hasToValue = false;
    }

    public void setInterpolatorType(int i2, float f2) {
        this.interpolationType = i2;
        this.factor = f2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setNormalizedTime(float r9) {
        /*
            r8 = this;
            r8.normalizedTime = r9
            int r0 = r8.interpolationType
            r1 = 0
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 1065353216(0x3f800000, float:1.0)
            switch(r0) {
                case 0: goto L_0x00d1;
                case 1: goto L_0x00c6;
                case 2: goto L_0x00ab;
                case 3: goto L_0x0094;
                case 4: goto L_0x004f;
                case 5: goto L_0x0041;
                case 6: goto L_0x000f;
                default: goto L_0x000c;
            }
        L_0x000c:
            r9 = 0
            goto L_0x00d1
        L_0x000f:
            int r0 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x000c
        L_0x0014:
            r0 = 1048576000(0x3e800000, float:0.25)
            r4 = 1082130432(0x40800000, float:4.0)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0020
            float r9 = r9 * r4
            goto L_0x00d1
        L_0x0020:
            r0 = 1056964608(0x3f000000, float:0.5)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x002c
            float r9 = r9 * r4
            float r9 = r2 - r9
            goto L_0x00d1
        L_0x002c:
            r0 = 1061158912(0x3f400000, float:0.75)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0037
            float r9 = r9 * r4
            float r9 = r9 - r2
            goto L_0x00d1
        L_0x0037:
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x000c
            float r9 = r9 * r4
            float r9 = r4 - r9
            goto L_0x00d1
        L_0x0041:
            float r9 = r9 - r3
            float r0 = r9 * r9
            r1 = 1077936128(0x40400000, float:3.0)
            float r9 = r9 * r1
            float r9 = r9 + r2
            float r0 = r0 * r9
            float r9 = r0 + r3
            goto L_0x00d1
        L_0x004f:
            r0 = 1066381659(0x3f8fb15b, float:1.1226)
            float r9 = r9 * r0
            r0 = 1052048884(0x3eb4fdf4, float:0.3535)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0061
            float r9 = bounce(r9)
            goto L_0x00d1
        L_0x0061:
            r0 = 1061004562(0x3f3da512, float:0.7408)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
            r0 = 1057756325(0x3f0c14a5, float:0.54719)
            float r9 = r9 - r0
            float r9 = bounce(r9)
            r0 = 1060320051(0x3f333333, float:0.7)
        L_0x0073:
            float r9 = r9 + r0
            goto L_0x00d1
        L_0x0075:
            r0 = 1064755947(0x3f76e2eb, float:0.9644)
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0088
            r0 = 1062880254(0x3f5a43fe, float:0.8526)
            float r9 = r9 - r0
            float r9 = bounce(r9)
            r0 = 1063675494(0x3f666666, float:0.9)
            goto L_0x0073
        L_0x0088:
            r0 = 1065718120(0x3f859168, float:1.0435)
            float r9 = r9 - r0
            float r9 = bounce(r9)
            r0 = 1064514355(0x3f733333, float:0.95)
            goto L_0x0073
        L_0x0094:
            float r9 = r9 + r3
            double r0 = (double) r9
            r2 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            java.lang.Double.isNaN(r0)
            double r0 = r0 * r2
            double r0 = java.lang.Math.cos(r0)
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 / r2
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r0 + r2
            goto L_0x00d0
        L_0x00ab:
            float r0 = r8.factor
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x00b8
            float r9 = r3 - r9
            float r9 = r9 * r9
            float r9 = r3 - r9
            goto L_0x00d1
        L_0x00b8:
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            float r3 = r3 - r9
            double r6 = (double) r3
            float r0 = r0 * r2
            double r0 = (double) r0
            double r0 = java.lang.Math.pow(r6, r0)
            double r4 = r4 - r0
            float r9 = (float) r4
            goto L_0x00d1
        L_0x00c6:
            double r0 = (double) r9
            float r9 = r8.factor
            float r9 = r9 * r2
            double r2 = (double) r9
            double r0 = java.lang.Math.pow(r0, r2)
        L_0x00d0:
            float r9 = (float) r0
        L_0x00d1:
            r8.mult = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimationParam.setNormalizedTime(float):void");
    }
}
