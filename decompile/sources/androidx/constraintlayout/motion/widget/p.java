package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.b;
import java.util.LinkedHashMap;
import k.c;

class p implements Comparable<p> {

    /* renamed from: a  reason: collision with root package name */
    static String[] f1980a = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: b  reason: collision with root package name */
    c f1981b;

    /* renamed from: c  reason: collision with root package name */
    int f1982c = 0;

    /* renamed from: d  reason: collision with root package name */
    float f1983d;

    /* renamed from: e  reason: collision with root package name */
    float f1984e;

    /* renamed from: f  reason: collision with root package name */
    float f1985f;

    /* renamed from: g  reason: collision with root package name */
    float f1986g;

    /* renamed from: h  reason: collision with root package name */
    float f1987h;

    /* renamed from: i  reason: collision with root package name */
    float f1988i;

    /* renamed from: j  reason: collision with root package name */
    float f1989j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    float f1990k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    int f1991l = c.f1802a;

    /* renamed from: m  reason: collision with root package name */
    LinkedHashMap<String, ConstraintAttribute> f1992m = new LinkedHashMap<>();

    /* renamed from: n  reason: collision with root package name */
    int f1993n = 0;

    /* renamed from: o  reason: collision with root package name */
    double[] f1994o = new double[18];

    /* renamed from: p  reason: collision with root package name */
    double[] f1995p = new double[18];

    public p() {
    }

    public p(int i2, int i3, i iVar, p pVar, p pVar2) {
        int i4 = iVar.f1884p;
        if (i4 == 1) {
            b(iVar, pVar, pVar2);
        } else if (i4 != 2) {
            a(iVar, pVar, pVar2);
        } else {
            a(i2, i3, iVar, pVar, pVar2);
        }
    }

    private static final float a(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (((f6 - f4) * f3) - ((f7 - f5) * f2)) + f4;
    }

    private boolean a(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    private static final float b(float f2, float f3, float f4, float f5, float f6, float f7) {
        return ((f6 - f4) * f2) + ((f7 - f5) * f3) + f5;
    }

    /* renamed from: a */
    public int compareTo(p pVar) {
        return Float.compare(this.f1984e, pVar.f1984e);
    }

    /* access modifiers changed from: package-private */
    public int a(String str, double[] dArr, int i2) {
        ConstraintAttribute constraintAttribute = this.f1992m.get(str);
        if (constraintAttribute.b() == 1) {
            dArr[i2] = (double) constraintAttribute.c();
            return 1;
        }
        int b2 = constraintAttribute.b();
        float[] fArr = new float[b2];
        constraintAttribute.a(fArr);
        int i3 = 0;
        while (i3 < b2) {
            dArr[i2] = (double) fArr[i3];
            i3++;
            i2++;
        }
        return b2;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float f4, float f5) {
        this.f1985f = f2;
        this.f1986g = f3;
        this.f1987h = f4;
        this.f1988i = f5;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f8 = (float) dArr[i2];
            double d2 = dArr2[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f4 = f8;
            } else if (i3 == 2) {
                f6 = f8;
            } else if (i3 == 3) {
                f5 = f8;
            } else if (i3 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (f9 * (1.0f - f2)) + (((f5 * 1.0f) + f9) * f2) + 0.0f;
        fArr[1] = (f10 * (1.0f - f3)) + (((f7 * 1.0f) + f10) * f3) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, i iVar, p pVar, p pVar2) {
        i iVar2 = iVar;
        p pVar3 = pVar;
        p pVar4 = pVar2;
        float f2 = ((float) iVar2.f1803b) / 100.0f;
        this.f1983d = f2;
        this.f1982c = iVar2.f1877i;
        float f3 = Float.isNaN(iVar2.f1878j) ? f2 : iVar2.f1878j;
        float f4 = Float.isNaN(iVar2.f1879k) ? f2 : iVar2.f1879k;
        float f5 = pVar4.f1987h;
        float f6 = pVar3.f1987h;
        float f7 = pVar4.f1988i;
        float f8 = pVar3.f1988i;
        this.f1984e = this.f1983d;
        float f9 = pVar3.f1985f;
        float f10 = pVar3.f1986g;
        float f11 = pVar4.f1985f + (f5 / 2.0f);
        float f12 = pVar4.f1986g + (f7 / 2.0f);
        float f13 = (f5 - f6) * f3;
        this.f1985f = (float) ((int) ((f9 + ((f11 - ((f6 / 2.0f) + f9)) * f2)) - (f13 / 2.0f)));
        float f14 = (f7 - f8) * f4;
        this.f1986g = (float) ((int) ((f10 + ((f12 - (f10 + (f8 / 2.0f))) * f2)) - (f14 / 2.0f)));
        this.f1987h = (float) ((int) (f6 + f13));
        this.f1988i = (float) ((int) (f8 + f14));
        this.f1993n = 3;
        i iVar3 = iVar;
        if (!Float.isNaN(iVar3.f1880l)) {
            this.f1985f = (float) ((int) (iVar3.f1880l * ((float) ((int) (((float) i2) - this.f1987h)))));
        }
        if (!Float.isNaN(iVar3.f1881m)) {
            this.f1986g = (float) ((int) (iVar3.f1881m * ((float) ((int) (((float) i3) - this.f1988i)))));
        }
        this.f1981b = c.a(iVar3.f1875g);
        this.f1991l = iVar3.f1876h;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bb, code lost:
        if (java.lang.Float.isNaN(Float.NaN) == false) goto L_0x00bd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.View r22, int[] r23, double[] r24, double[] r25, double[] r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            float r3 = r0.f1985f
            float r4 = r0.f1986g
            float r5 = r0.f1987h
            float r6 = r0.f1988i
            int r7 = r2.length
            r8 = 1
            if (r7 == 0) goto L_0x0028
            double[] r7 = r0.f1994o
            int r7 = r7.length
            int r9 = r2.length
            int r9 = r9 - r8
            r9 = r2[r9]
            if (r7 > r9) goto L_0x0028
            int r7 = r2.length
            int r7 = r7 - r8
            r7 = r2[r7]
            int r7 = r7 + r8
            double[] r9 = new double[r7]
            r0.f1994o = r9
            double[] r7 = new double[r7]
            r0.f1995p = r7
        L_0x0028:
            double[] r7 = r0.f1994o
            r9 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            java.util.Arrays.fill(r7, r9)
            r9 = 0
        L_0x0030:
            int r10 = r2.length
            if (r9 >= r10) goto L_0x0046
            double[] r10 = r0.f1994o
            r11 = r2[r9]
            r12 = r24[r9]
            r10[r11] = r12
            double[] r10 = r0.f1995p
            r11 = r2[r9]
            r12 = r25[r9]
            r10[r11] = r12
            int r9 = r9 + 1
            goto L_0x0030
        L_0x0046:
            r10 = 0
            r11 = 2143289344(0x7fc00000, float:NaN)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x004d:
            double[] r7 = r0.f1994o
            int r9 = r7.length
            if (r10 >= r9) goto L_0x00ac
            r17 = r7[r10]
            boolean r7 = java.lang.Double.isNaN(r17)
            r17 = 0
            if (r7 == 0) goto L_0x0068
            if (r26 == 0) goto L_0x0064
            r19 = r26[r10]
            int r7 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
            if (r7 != 0) goto L_0x0068
        L_0x0064:
            r25 = r3
            r7 = 1
            goto L_0x0096
        L_0x0068:
            if (r26 == 0) goto L_0x006c
            r17 = r26[r10]
        L_0x006c:
            double[] r7 = r0.f1994o
            r19 = r7[r10]
            boolean r7 = java.lang.Double.isNaN(r19)
            if (r7 == 0) goto L_0x0077
            goto L_0x007d
        L_0x0077:
            double[] r7 = r0.f1994o
            r19 = r7[r10]
            double r17 = r19 + r17
        L_0x007d:
            r25 = r3
            r2 = r17
            float r2 = (float) r2
            double[] r3 = r0.f1995p
            r8 = r3[r10]
            float r3 = (float) r8
            r7 = 1
            if (r10 == r7) goto L_0x00a6
            r8 = 2
            if (r10 == r8) goto L_0x00a3
            r8 = 3
            if (r10 == r8) goto L_0x00a0
            r8 = 4
            if (r10 == r8) goto L_0x009d
            r3 = 5
            if (r10 == r3) goto L_0x0099
        L_0x0096:
            r3 = r25
            goto L_0x00a8
        L_0x0099:
            r3 = r25
            r11 = r2
            goto L_0x00a8
        L_0x009d:
            r6 = r2
            r15 = r3
            goto L_0x0096
        L_0x00a0:
            r5 = r2
            r13 = r3
            goto L_0x0096
        L_0x00a3:
            r4 = r2
            r14 = r3
            goto L_0x0096
        L_0x00a6:
            r12 = r3
            r3 = r2
        L_0x00a8:
            int r10 = r10 + 1
            r8 = 1
            goto L_0x004d
        L_0x00ac:
            r25 = r3
            r7 = 1
            boolean r2 = java.lang.Float.isNaN(r11)
            if (r2 == 0) goto L_0x00c1
            r2 = 2143289344(0x7fc00000, float:NaN)
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 != 0) goto L_0x00e6
        L_0x00bd:
            r1.setRotation(r2)
            goto L_0x00e6
        L_0x00c1:
            r2 = 2143289344(0x7fc00000, float:NaN)
            boolean r3 = java.lang.Float.isNaN(r2)
            if (r3 == 0) goto L_0x00ca
            r2 = 0
        L_0x00ca:
            r3 = 1073741824(0x40000000, float:2.0)
            float r13 = r13 / r3
            float r12 = r12 + r13
            float r15 = r15 / r3
            float r14 = r14 + r15
            double r2 = (double) r2
            double r8 = (double) r11
            double r10 = (double) r14
            double r12 = (double) r12
            double r10 = java.lang.Math.atan2(r10, r12)
            double r10 = java.lang.Math.toDegrees(r10)
            java.lang.Double.isNaN(r8)
            double r8 = r8 + r10
            java.lang.Double.isNaN(r2)
            double r2 = r2 + r8
            float r2 = (float) r2
            goto L_0x00bd
        L_0x00e6:
            r2 = 1056964608(0x3f000000, float:0.5)
            float r3 = r25 + r2
            int r8 = (int) r3
            float r4 = r4 + r2
            int r2 = (int) r4
            float r3 = r3 + r5
            int r3 = (int) r3
            float r4 = r4 + r6
            int r4 = (int) r4
            int r5 = r3 - r8
            int r6 = r4 - r2
            int r9 = r22.getMeasuredWidth()
            if (r5 != r9) goto L_0x0105
            int r9 = r22.getMeasuredHeight()
            if (r6 == r9) goto L_0x0102
            goto L_0x0105
        L_0x0102:
            r16 = 0
            goto L_0x0107
        L_0x0105:
            r16 = 1
        L_0x0107:
            if (r16 == 0) goto L_0x0116
            r7 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r7)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r7)
            r1.measure(r5, r6)
        L_0x0116:
            r1.layout(r8, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.p.a(android.view.View, int[], double[], double[], double[]):void");
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar, p pVar, p pVar2) {
        i iVar2 = iVar;
        p pVar3 = pVar;
        p pVar4 = pVar2;
        float f2 = ((float) iVar2.f1803b) / 100.0f;
        this.f1983d = f2;
        this.f1982c = iVar2.f1877i;
        float f3 = Float.isNaN(iVar2.f1878j) ? f2 : iVar2.f1878j;
        float f4 = Float.isNaN(iVar2.f1879k) ? f2 : iVar2.f1879k;
        float f5 = pVar4.f1987h;
        float f6 = pVar3.f1987h;
        float f7 = pVar4.f1988i;
        float f8 = pVar3.f1988i;
        this.f1984e = this.f1983d;
        float f9 = pVar3.f1985f;
        float f10 = pVar3.f1986g;
        float f11 = (pVar4.f1985f + (f5 / 2.0f)) - ((f6 / 2.0f) + f9);
        float f12 = (pVar4.f1986g + (f7 / 2.0f)) - (f10 + (f8 / 2.0f));
        float f13 = (f5 - f6) * f3;
        float f14 = f13 / 2.0f;
        this.f1985f = (float) ((int) ((f9 + (f11 * f2)) - f14));
        float f15 = (f7 - f8) * f4;
        float f16 = f15 / 2.0f;
        this.f1986g = (float) ((int) ((f10 + (f12 * f2)) - f16));
        this.f1987h = (float) ((int) (f6 + f13));
        this.f1988i = (float) ((int) (f8 + f15));
        i iVar3 = iVar;
        float f17 = Float.isNaN(iVar3.f1880l) ? f2 : iVar3.f1880l;
        float f18 = 0.0f;
        float f19 = Float.isNaN(iVar3.f1883o) ? 0.0f : iVar3.f1883o;
        if (!Float.isNaN(iVar3.f1881m)) {
            f2 = iVar3.f1881m;
        }
        if (!Float.isNaN(iVar3.f1882n)) {
            f18 = iVar3.f1882n;
        }
        this.f1993n = 2;
        p pVar5 = pVar;
        this.f1985f = (float) ((int) (((pVar5.f1985f + (f17 * f11)) + (f18 * f12)) - f14));
        this.f1986g = (float) ((int) (((pVar5.f1986g + (f11 * f19)) + (f12 * f2)) - f16));
        this.f1981b = c.a(iVar3.f1875g);
        this.f1991l = iVar3.f1876h;
    }

    /* access modifiers changed from: package-private */
    public void a(p pVar, boolean[] zArr, String[] strArr, boolean z2) {
        zArr[0] = zArr[0] | a(this.f1984e, pVar.f1984e);
        zArr[1] = zArr[1] | a(this.f1985f, pVar.f1985f) | z2;
        zArr[2] = z2 | a(this.f1986g, pVar.f1986g) | zArr[2];
        zArr[3] = zArr[3] | a(this.f1987h, pVar.f1987h);
        zArr[4] = a(this.f1988i, pVar.f1988i) | zArr[4];
    }

    public void a(b.a aVar) {
        this.f1981b = c.a(aVar.f2640c.f2684c);
        this.f1991l = aVar.f2640c.f2685d;
        this.f1989j = aVar.f2640c.f2688g;
        this.f1982c = aVar.f2640c.f2686e;
        this.f1990k = aVar.f2639b.f2693e;
        for (String next : aVar.f2643f.keySet()) {
            ConstraintAttribute constraintAttribute = aVar.f2643f.get(next);
            if (constraintAttribute.a() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.f1992m.put(next, constraintAttribute);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(double[] dArr, int[] iArr) {
        float[] fArr = {this.f1984e, this.f1985f, this.f1986g, this.f1987h, this.f1988i, this.f1989j};
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] < 6) {
                dArr[i2] = (double) fArr[iArr[i3]];
                i2++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.f1985f;
        float f3 = this.f1986g;
        float f4 = this.f1987h;
        float f5 = this.f1988i;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        fArr[i2] = f2 + (f4 / 2.0f) + 0.0f;
        fArr[i2 + 1] = f3 + (f5 / 2.0f) + 0.0f;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        return this.f1992m.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public int b(String str) {
        return this.f1992m.get(str).b();
    }

    /* access modifiers changed from: package-private */
    public void b(i iVar, p pVar, p pVar2) {
        i iVar2 = iVar;
        p pVar3 = pVar;
        p pVar4 = pVar2;
        float f2 = ((float) iVar2.f1803b) / 100.0f;
        this.f1983d = f2;
        this.f1982c = iVar2.f1877i;
        float f3 = Float.isNaN(iVar2.f1878j) ? f2 : iVar2.f1878j;
        float f4 = Float.isNaN(iVar2.f1879k) ? f2 : iVar2.f1879k;
        float f5 = pVar4.f1987h - pVar3.f1987h;
        float f6 = pVar4.f1988i - pVar3.f1988i;
        this.f1984e = this.f1983d;
        if (!Float.isNaN(iVar2.f1880l)) {
            f2 = iVar2.f1880l;
        }
        float f7 = pVar3.f1985f;
        float f8 = pVar3.f1987h;
        float f9 = pVar3.f1986g;
        float f10 = pVar3.f1988i;
        float f11 = (pVar4.f1985f + (pVar4.f1987h / 2.0f)) - ((f8 / 2.0f) + f7);
        float f12 = (pVar4.f1986g + (pVar4.f1988i / 2.0f)) - ((f10 / 2.0f) + f9);
        float f13 = f11 * f2;
        float f14 = f5 * f3;
        float f15 = f14 / 2.0f;
        this.f1985f = (float) ((int) ((f7 + f13) - f15));
        float f16 = f2 * f12;
        float f17 = f6 * f4;
        float f18 = f17 / 2.0f;
        this.f1986g = (float) ((int) ((f9 + f16) - f18));
        this.f1987h = (float) ((int) (f8 + f14));
        this.f1988i = (float) ((int) (f10 + f17));
        i iVar3 = iVar;
        float f19 = Float.isNaN(iVar3.f1881m) ? 0.0f : iVar3.f1881m;
        float f20 = (-f12) * f19;
        float f21 = f11 * f19;
        this.f1993n = 1;
        p pVar5 = pVar;
        float f22 = (float) ((int) ((pVar5.f1985f + f13) - f15));
        this.f1985f = f22;
        float f23 = (float) ((int) ((pVar5.f1986g + f16) - f18));
        this.f1986g = f23;
        this.f1985f = f22 + f20;
        this.f1986g = f23 + f21;
        this.f1981b = c.a(iVar3.f1875g);
        this.f1991l = iVar3.f1876h;
    }

    /* access modifiers changed from: package-private */
    public void b(int[] iArr, double[] dArr, float[] fArr, int i2) {
        float f2 = this.f1985f;
        float f3 = this.f1986g;
        float f4 = this.f1987h;
        float f5 = this.f1988i;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f6 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f2 = f6;
            } else if (i4 == 2) {
                f3 = f6;
            } else if (i4 == 3) {
                f4 = f6;
            } else if (i4 == 4) {
                f5 = f6;
            }
        }
        float f7 = f4 + f2;
        float f8 = f5 + f3;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i5 = i2 + 1;
        fArr[i2] = f2 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f3 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f7 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f3 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f7 + 0.0f;
        int i10 = i9 + 1;
        fArr[i9] = f8 + 0.0f;
        fArr[i10] = f2 + 0.0f;
        fArr[i10 + 1] = f8 + 0.0f;
    }
}
