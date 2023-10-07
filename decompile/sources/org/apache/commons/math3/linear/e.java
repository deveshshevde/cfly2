package org.apache.commons.math3.linear;

import nl.b;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private byte f32710a = 30;

    /* renamed from: b  reason: collision with root package name */
    private double[] f32711b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f32712c;

    /* renamed from: d  reason: collision with root package name */
    private m f32713d;

    /* renamed from: e  reason: collision with root package name */
    private double[] f32714e;

    /* renamed from: f  reason: collision with root package name */
    private double[] f32715f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayRealVector[] f32716g;

    public e(h hVar, double d2) {
        if (a(hVar, true)) {
            a(hVar);
            a(this.f32713d.a().a());
        }
    }

    private void a(h hVar) {
        m mVar = new m(hVar);
        this.f32713d = mVar;
        this.f32711b = mVar.c();
        this.f32712c = this.f32713d.d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d2, code lost:
        r5 = r5 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(double[][] r40) {
        /*
            r39 = this;
            r0 = r39
            java.lang.Object r1 = r40.clone()
            double[][] r1 = (double[][]) r1
            double[] r2 = r0.f32711b
            int r2 = r2.length
            double[] r3 = new double[r2]
            r0.f32714e = r3
            double[] r3 = new double[r2]
            r0.f32715f = r3
            double[] r3 = new double[r2]
            r5 = 0
        L_0x0016:
            int r6 = r2 + -1
            if (r5 >= r6) goto L_0x002b
            double[] r6 = r0.f32714e
            double[] r7 = r0.f32711b
            r8 = r7[r5]
            r6[r5] = r8
            double[] r6 = r0.f32712c
            r7 = r6[r5]
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x0016
        L_0x002b:
            double[] r5 = r0.f32714e
            double[] r7 = r0.f32711b
            r8 = r7[r6]
            r5[r6] = r8
            r7 = 0
            r3[r6] = r7
            r9 = r7
            r5 = 0
        L_0x0039:
            if (r5 >= r2) goto L_0x0062
            double[] r11 = r0.f32714e
            r12 = r11[r5]
            double r11 = nl.b.b(r12)
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 <= 0) goto L_0x004f
            double[] r9 = r0.f32714e
            r10 = r9[r5]
            double r9 = nl.b.b(r10)
        L_0x004f:
            r11 = r3[r5]
            double r11 = nl.b.b(r11)
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 <= 0) goto L_0x005f
            r9 = r3[r5]
            double r9 = nl.b.b(r9)
        L_0x005f:
            int r5 = r5 + 1
            goto L_0x0039
        L_0x0062:
            r11 = 4368491638549381120(0x3ca0000000000000, double:1.1102230246251565E-16)
            int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x008c
            r5 = 0
        L_0x0069:
            if (r5 >= r2) goto L_0x008c
            double[] r13 = r0.f32714e
            r14 = r13[r5]
            double r13 = nl.b.b(r14)
            double r15 = r9 * r11
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 > 0) goto L_0x007d
            double[] r13 = r0.f32714e
            r13[r5] = r7
        L_0x007d:
            r13 = r3[r5]
            double r13 = nl.b.b(r13)
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 > 0) goto L_0x0089
            r3[r5] = r7
        L_0x0089:
            int r5 = r5 + 1
            goto L_0x0069
        L_0x008c:
            r5 = 0
        L_0x008d:
            if (r5 >= r2) goto L_0x01dc
            r9 = 0
        L_0x0090:
            r10 = r5
        L_0x0091:
            if (r10 >= r6) goto L_0x00b7
            double[] r13 = r0.f32714e
            r14 = r13[r10]
            double r13 = nl.b.b(r14)
            double[] r15 = r0.f32714e
            int r16 = r10 + 1
            r17 = r15[r16]
            double r17 = nl.b.b(r17)
            double r13 = r13 + r17
            r17 = r3[r10]
            double r17 = nl.b.b(r17)
            double r17 = r17 + r13
            int r15 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x00b4
            goto L_0x00b7
        L_0x00b4:
            r10 = r16
            goto L_0x0091
        L_0x00b7:
            if (r10 == r5) goto L_0x01cf
            byte r13 = r0.f32710a
            if (r9 == r13) goto L_0x01be
            int r9 = r9 + 1
            double[] r13 = r0.f32714e
            int r14 = r5 + 1
            r14 = r13[r14]
            r16 = r13[r5]
            double r14 = r14 - r16
            r16 = r3[r5]
            r18 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r16 = r16 * r18
            double r14 = r14 / r16
            double r16 = r14 * r14
            r20 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r16 = r16 + r20
            double r16 = nl.b.a(r16)
            int r13 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r13 >= 0) goto L_0x00ec
            double[] r13 = r0.f32714e
            r22 = r13[r10]
            r24 = r13[r5]
            double r22 = r22 - r24
            r24 = r3[r5]
            double r14 = r14 - r16
            goto L_0x00f8
        L_0x00ec:
            double[] r13 = r0.f32714e
            r22 = r13[r10]
            r24 = r13[r5]
            double r22 = r22 - r24
            r24 = r3[r5]
            double r14 = r14 + r16
        L_0x00f8:
            double r24 = r24 / r14
            double r22 = r22 + r24
            int r13 = r10 + -1
            r26 = r7
            r14 = r20
            r24 = r14
        L_0x0104:
            if (r13 < r5) goto L_0x01aa
            r16 = r3[r13]
            double r14 = r14 * r16
            r16 = r3[r13]
            double r24 = r24 * r16
            double r16 = nl.b.b(r14)
            double r28 = nl.b.b(r22)
            int r30 = (r16 > r28 ? 1 : (r16 == r28 ? 0 : -1))
            if (r30 < 0) goto L_0x0135
            double r16 = r22 / r14
            double r28 = r16 * r16
            double r28 = r28 + r20
            double r28 = nl.b.a(r28)
            int r30 = r13 + 1
            double r14 = r14 * r28
            r3[r30] = r14
            double r14 = r20 / r28
            double r16 = r16 * r14
            r37 = r16
            r16 = r28
            r28 = r37
            goto L_0x0149
        L_0x0135:
            double r14 = r14 / r22
            double r16 = r14 * r14
            double r16 = r16 + r20
            double r16 = nl.b.a(r16)
            int r28 = r13 + 1
            double r29 = r22 * r16
            r3[r28] = r29
            double r28 = r20 / r16
            double r14 = r14 * r28
        L_0x0149:
            int r30 = r13 + 1
            r31 = r3[r30]
            int r33 = (r31 > r7 ? 1 : (r31 == r7 ? 0 : -1))
            if (r33 != 0) goto L_0x015c
            double[] r14 = r0.f32714e
            r18 = r14[r30]
            double r18 = r18 - r26
            r14[r30] = r18
            r3[r10] = r7
            goto L_0x01aa
        L_0x015c:
            double[] r11 = r0.f32714e
            r16 = r11[r30]
            double r16 = r16 - r26
            r22 = r11[r13]
            double r22 = r22 - r16
            double r22 = r22 * r14
            double r26 = r28 * r18
            double r26 = r26 * r24
            double r22 = r22 + r26
            double r26 = r14 * r22
            double r16 = r16 + r26
            r11[r30] = r16
            double r11 = r28 * r22
            double r11 = r11 - r24
            r4 = 0
        L_0x0179:
            if (r4 >= r2) goto L_0x019e
            r16 = r1[r4]
            r24 = r16[r30]
            r16 = r1[r4]
            r17 = r1[r4]
            r33 = r17[r13]
            double r33 = r33 * r14
            double r35 = r28 * r24
            double r33 = r33 + r35
            r16[r30] = r33
            r16 = r1[r4]
            r17 = r1[r4]
            r33 = r17[r13]
            double r33 = r33 * r28
            double r24 = r24 * r14
            double r33 = r33 - r24
            r16[r13] = r33
            int r4 = r4 + 1
            goto L_0x0179
        L_0x019e:
            int r13 = r13 + -1
            r16 = r22
            r24 = r28
            r22 = r11
            r11 = 4368491638549381120(0x3ca0000000000000, double:1.1102230246251565E-16)
            goto L_0x0104
        L_0x01aa:
            int r4 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x01b1
            if (r13 < r5) goto L_0x01b1
            goto L_0x01cf
        L_0x01b1:
            double[] r4 = r0.f32714e
            r11 = r4[r5]
            double r11 = r11 - r26
            r4[r5] = r11
            r3[r5] = r22
            r3[r10] = r7
            goto L_0x01cf
        L_0x01be:
            org.apache.commons.math3.exception.MaxCountExceededException r1 = new org.apache.commons.math3.exception.MaxCountExceededException
            org.apache.commons.math3.exception.util.LocalizedFormats r2 = org.apache.commons.math3.exception.util.LocalizedFormats.CONVERGENCE_FAILED
            byte r3 = r0.f32710a
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r1.<init>(r2, r3, r4)
            throw r1
        L_0x01cf:
            r4 = 0
            if (r10 != r5) goto L_0x01d8
            int r5 = r5 + 1
            r11 = 4368491638549381120(0x3ca0000000000000, double:1.1102230246251565E-16)
            goto L_0x008d
        L_0x01d8:
            r11 = 4368491638549381120(0x3ca0000000000000, double:1.1102230246251565E-16)
            goto L_0x0090
        L_0x01dc:
            r4 = 0
            r3 = 0
        L_0x01de:
            if (r3 >= r2) goto L_0x021a
            double[] r5 = r0.f32714e
            r9 = r5[r3]
            int r5 = r3 + 1
            r11 = r3
            r6 = r5
        L_0x01e8:
            if (r6 >= r2) goto L_0x01f8
            double[] r12 = r0.f32714e
            r13 = r12[r6]
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 <= 0) goto L_0x01f5
            r9 = r12[r6]
            r11 = r6
        L_0x01f5:
            int r6 = r6 + 1
            goto L_0x01e8
        L_0x01f8:
            if (r11 == r3) goto L_0x0218
            double[] r6 = r0.f32714e
            r12 = r6[r3]
            r6[r11] = r12
            r6[r3] = r9
            r6 = 0
        L_0x0203:
            if (r6 >= r2) goto L_0x0218
            r9 = r1[r6]
            r12 = r9[r3]
            r9 = r1[r6]
            r10 = r1[r6]
            r14 = r10[r11]
            r9[r3] = r14
            r9 = r1[r6]
            r9[r11] = r12
            int r6 = r6 + 1
            goto L_0x0203
        L_0x0218:
            r3 = r5
            goto L_0x01de
        L_0x021a:
            r5 = r7
            r3 = 0
        L_0x021c:
            if (r3 >= r2) goto L_0x0235
            double[] r9 = r0.f32714e
            r10 = r9[r3]
            double r9 = nl.b.b(r10)
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 <= 0) goto L_0x0232
            double[] r5 = r0.f32714e
            r9 = r5[r3]
            double r5 = nl.b.b(r9)
        L_0x0232:
            int r3 = r3 + 1
            goto L_0x021c
        L_0x0235:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0253
            r3 = 0
        L_0x023a:
            if (r3 >= r2) goto L_0x0253
            double[] r9 = r0.f32714e
            r10 = r9[r3]
            double r9 = nl.b.b(r10)
            r11 = 4368491638549381120(0x3ca0000000000000, double:1.1102230246251565E-16)
            double r13 = r5 * r11
            int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x0250
            double[] r9 = r0.f32714e
            r9[r3] = r7
        L_0x0250:
            int r3 = r3 + 1
            goto L_0x023a
        L_0x0253:
            org.apache.commons.math3.linear.ArrayRealVector[] r3 = new org.apache.commons.math3.linear.ArrayRealVector[r2]
            r0.f32716g = r3
            double[] r3 = new double[r2]
            r5 = 0
        L_0x025a:
            if (r5 >= r2) goto L_0x0274
            r6 = 0
        L_0x025d:
            if (r6 >= r2) goto L_0x0268
            r7 = r1[r6]
            r8 = r7[r5]
            r3[r6] = r8
            int r6 = r6 + 1
            goto L_0x025d
        L_0x0268:
            org.apache.commons.math3.linear.ArrayRealVector[] r6 = r0.f32716g
            org.apache.commons.math3.linear.ArrayRealVector r7 = new org.apache.commons.math3.linear.ArrayRealVector
            r7.<init>((double[]) r3)
            r6[r5] = r7
            int r5 = r5 + 1
            goto L_0x025a
        L_0x0274:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.math3.linear.e.a(double[][]):void");
    }

    private boolean a(h hVar, boolean z2) {
        h hVar2 = hVar;
        int d2 = hVar.d();
        int e2 = hVar.e();
        double d3 = (double) (d2 * 10 * e2);
        Double.isNaN(d3);
        double d4 = d3 * 1.1102230246251565E-16d;
        int i2 = 0;
        while (i2 < d2) {
            int i3 = i2 + 1;
            int i4 = i3;
            while (i4 < e2) {
                double b2 = hVar2.b(i2, i4);
                double b3 = hVar2.b(i4, i2);
                if (b.b(b2 - b3) <= b.a(b.b(b2), b.b(b3)) * d4) {
                    i4++;
                } else if (!z2) {
                    return false;
                } else {
                    throw new NonSymmetricMatrixException(i2, i4, d4);
                }
            }
            i2 = i3;
        }
        return true;
    }

    public j a(int i2) {
        return this.f32716g[i2].a();
    }

    public double[] a() {
        return (double[]) this.f32714e.clone();
    }
}
