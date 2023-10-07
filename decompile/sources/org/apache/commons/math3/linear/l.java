package org.apache.commons.math3.linear;

import fg.i;

public class l {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final double[] f32734a;

    /* renamed from: b  reason: collision with root package name */
    private final int f32735b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32736c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32737d;

    /* renamed from: e  reason: collision with root package name */
    private final h f32738e;

    /* renamed from: f  reason: collision with root package name */
    private h f32739f;

    /* renamed from: g  reason: collision with root package name */
    private final h f32740g;

    /* renamed from: h  reason: collision with root package name */
    private final double f32741h;

    /* renamed from: org.apache.commons.math3.linear.l$1  reason: invalid class name */
    class AnonymousClass1 extends d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double[][] f32742a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f32743b;

        public void a(int i2, int i3, double d2) {
            this.f32742a[i2][i3] = d2 / this.f32743b.f32734a[i2];
        }
    }

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final h f32744a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f32745b;

        private a(double[] dArr, h hVar, h hVar2, boolean z2, double d2) {
            double[][] a2 = hVar.a();
            for (int i2 = 0; i2 < dArr.length; i2++) {
                double d3 = dArr[i2] > d2 ? 1.0d / dArr[i2] : i.f27244a;
                double[] dArr2 = a2[i2];
                for (int i3 = 0; i3 < dArr2.length; i3++) {
                    dArr2[i3] = dArr2[i3] * d3;
                }
            }
            this.f32744a = hVar2.a((h) new Array2DRowRealMatrix(a2, false));
            this.f32745b = z2;
        }

        /* synthetic */ a(double[] dArr, h hVar, h hVar2, boolean z2, double d2, AnonymousClass1 r7) {
            this(dArr, hVar, hVar2, z2, d2);
        }

        public h a() {
            return this.f32744a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v1, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v10, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v8, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v9, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v8, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v9, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v10, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v18, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v11, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v13, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v23, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v24, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v14, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v32, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v18, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v33, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v27, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v28, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v29, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v30, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v3, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r28v4, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v13, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v2, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v31, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v8, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v5, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r30v6, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v15, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v16, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v24, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v31, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v34, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v35, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v36, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v37, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v38, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v39, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v45, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v47, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v23, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v9, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v17, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v24, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v25, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v19, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v42, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v48, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v36, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v41, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v38, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v42, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v26, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v43, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v28, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v44, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v22, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v40, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v46, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v57, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v37, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v51, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v49, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v41, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v73, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v50, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v40, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v74, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v41, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v23, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v18, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v52, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v25, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v53, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v20, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v90, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v54, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v45, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v93, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v95, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v55, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v10, resolved type: double[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v98, resolved type: double} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: double[][]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: double[][]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public l(org.apache.commons.math3.linear.h r35) {
        /*
            r34 = this;
            r0 = r34
            java.lang.Class<double> r1 = double.class
            r34.<init>()
            int r2 = r35.d()
            int r3 = r35.e()
            r4 = 0
            r5 = 1
            if (r2 >= r3) goto L_0x0028
            r0.f32737d = r5
            org.apache.commons.math3.linear.h r2 = r35.b()
            double[][] r2 = r2.a()
            int r3 = r35.e()
            r0.f32735b = r3
            int r3 = r35.d()
            goto L_0x0038
        L_0x0028:
            r0.f32737d = r4
            double[][] r2 = r35.a()
            int r3 = r35.d()
            r0.f32735b = r3
            int r3 = r35.e()
        L_0x0038:
            r0.f32736c = r3
            int r3 = r0.f32736c
            double[] r6 = new double[r3]
            r0.f32734a = r6
            int r6 = r0.f32735b
            r7 = 2
            int[] r8 = new int[r7]
            r8[r5] = r3
            r8[r4] = r6
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r1, r8)
            double[][] r3 = (double[][]) r3
            int r6 = r0.f32736c
            int[] r8 = new int[r7]
            r8[r5] = r6
            r8[r4] = r6
            java.lang.Object r1 = java.lang.reflect.Array.newInstance(r1, r8)
            double[][] r1 = (double[][]) r1
            int r6 = r0.f32736c
            double[] r8 = new double[r6]
            int r9 = r0.f32735b
            double[] r10 = new double[r9]
            int r9 = r9 - r5
            int r6 = nl.b.a((int) r9, (int) r6)
            int r9 = r0.f32736c
            int r9 = r9 - r7
            int r9 = nl.b.b((int) r4, (int) r9)
            r11 = 0
        L_0x0072:
            int r12 = nl.b.b((int) r6, (int) r9)
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r15 = 0
            if (r11 >= r12) goto L_0x01f2
            if (r11 >= r6) goto L_0x00de
            double[] r12 = r0.f32734a
            r12[r11] = r15
            r12 = r11
        L_0x0083:
            int r4 = r0.f32735b
            if (r12 >= r4) goto L_0x00a2
            double[] r4 = r0.f32734a
            r17 = r8
            r7 = r4[r11]
            r18 = r2[r12]
            r20 = r6
            r5 = r18[r11]
            double r5 = nl.b.b((double) r7, (double) r5)
            r4[r11] = r5
            int r12 = r12 + 1
            r8 = r17
            r6 = r20
            r5 = 1
            r7 = 2
            goto L_0x0083
        L_0x00a2:
            r20 = r6
            r17 = r8
            double[] r4 = r0.f32734a
            r5 = r4[r11]
            int r7 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r7 == 0) goto L_0x00d6
            r5 = r2[r11]
            r6 = r5[r11]
            int r5 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r5 >= 0) goto L_0x00bb
            r5 = r4[r11]
            double r5 = -r5
            r4[r11] = r5
        L_0x00bb:
            r4 = r11
        L_0x00bc:
            int r5 = r0.f32735b
            if (r4 >= r5) goto L_0x00cf
            r5 = r2[r4]
            r6 = r5[r11]
            double[] r8 = r0.f32734a
            r21 = r8[r11]
            double r6 = r6 / r21
            r5[r11] = r6
            int r4 = r4 + 1
            goto L_0x00bc
        L_0x00cf:
            r4 = r2[r11]
            r5 = r4[r11]
            double r5 = r5 + r13
            r4[r11] = r5
        L_0x00d6:
            double[] r4 = r0.f32734a
            r5 = r4[r11]
            double r5 = -r5
            r4[r11] = r5
            goto L_0x00e2
        L_0x00de:
            r20 = r6
            r17 = r8
        L_0x00e2:
            int r4 = r11 + 1
            r5 = r4
        L_0x00e5:
            int r6 = r0.f32736c
            if (r5 >= r6) goto L_0x0133
            r6 = r20
            if (r11 >= r6) goto L_0x0126
            double[] r7 = r0.f32734a
            r20 = r7[r11]
            int r7 = (r20 > r15 ? 1 : (r20 == r15 ? 0 : -1))
            if (r7 == 0) goto L_0x0126
            r7 = r11
            r13 = r15
        L_0x00f7:
            int r8 = r0.f32735b
            if (r7 >= r8) goto L_0x010a
            r8 = r2[r7]
            r22 = r8[r11]
            r8 = r2[r7]
            r24 = r8[r5]
            double r22 = r22 * r24
            double r13 = r13 + r22
            int r7 = r7 + 1
            goto L_0x00f7
        L_0x010a:
            double r7 = -r13
            r12 = r2[r11]
            r13 = r12[r11]
            double r7 = r7 / r13
            r12 = r11
        L_0x0111:
            int r13 = r0.f32735b
            if (r12 >= r13) goto L_0x0126
            r13 = r2[r12]
            r22 = r13[r5]
            r14 = r2[r12]
            r24 = r14[r11]
            double r24 = r24 * r7
            double r22 = r22 + r24
            r13[r5] = r22
            int r12 = r12 + 1
            goto L_0x0111
        L_0x0126:
            r7 = r2[r11]
            r12 = r7[r5]
            r17[r5] = r12
            int r5 = r5 + 1
            r20 = r6
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x00e5
        L_0x0133:
            r6 = r20
            if (r11 >= r6) goto L_0x0147
            r5 = r11
        L_0x0138:
            int r7 = r0.f32735b
            if (r5 >= r7) goto L_0x0147
            r7 = r3[r5]
            r8 = r2[r5]
            r12 = r8[r11]
            r7[r11] = r12
            int r5 = r5 + 1
            goto L_0x0138
        L_0x0147:
            if (r11 >= r9) goto L_0x01ea
            r17[r11] = r15
            r5 = r4
        L_0x014c:
            int r7 = r0.f32736c
            if (r5 >= r7) goto L_0x015d
            r7 = r17[r11]
            r12 = r17[r5]
            double r7 = nl.b.b((double) r7, (double) r12)
            r17[r11] = r7
            int r5 = r5 + 1
            goto L_0x014c
        L_0x015d:
            r7 = r17[r11]
            int r5 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r5 == 0) goto L_0x0184
            r7 = r17[r4]
            int r5 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r5 >= 0) goto L_0x016e
            r7 = r17[r11]
            double r7 = -r7
            r17[r11] = r7
        L_0x016e:
            r5 = r4
        L_0x016f:
            int r7 = r0.f32736c
            if (r5 >= r7) goto L_0x017d
            r7 = r17[r5]
            r12 = r17[r11]
            double r7 = r7 / r12
            r17[r5] = r7
            int r5 = r5 + 1
            goto L_0x016f
        L_0x017d:
            r7 = r17[r4]
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r7 = r7 + r12
            r17[r4] = r7
        L_0x0184:
            r7 = r17[r11]
            double r7 = -r7
            r17[r11] = r7
            int r5 = r0.f32735b
            if (r4 >= r5) goto L_0x01dc
            r7 = r17[r11]
            int r5 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r5 == 0) goto L_0x01dc
            r5 = r4
        L_0x0194:
            int r7 = r0.f32735b
            if (r5 >= r7) goto L_0x019d
            r10[r5] = r15
            int r5 = r5 + 1
            goto L_0x0194
        L_0x019d:
            r5 = r4
        L_0x019e:
            int r7 = r0.f32736c
            if (r5 >= r7) goto L_0x01ba
            r7 = r4
        L_0x01a3:
            int r8 = r0.f32735b
            if (r7 >= r8) goto L_0x01b7
            r12 = r10[r7]
            r14 = r17[r5]
            r8 = r2[r7]
            r20 = r8[r5]
            double r14 = r14 * r20
            double r12 = r12 + r14
            r10[r7] = r12
            int r7 = r7 + 1
            goto L_0x01a3
        L_0x01b7:
            int r5 = r5 + 1
            goto L_0x019e
        L_0x01ba:
            r5 = r4
        L_0x01bb:
            int r7 = r0.f32736c
            if (r5 >= r7) goto L_0x01dc
            r7 = r17[r5]
            double r7 = -r7
            r12 = r17[r4]
            double r7 = r7 / r12
            r12 = r4
        L_0x01c6:
            int r13 = r0.f32735b
            if (r12 >= r13) goto L_0x01d9
            r13 = r2[r12]
            r14 = r13[r5]
            r20 = r10[r12]
            double r20 = r20 * r7
            double r14 = r14 + r20
            r13[r5] = r14
            int r12 = r12 + 1
            goto L_0x01c6
        L_0x01d9:
            int r5 = r5 + 1
            goto L_0x01bb
        L_0x01dc:
            r5 = r4
        L_0x01dd:
            int r7 = r0.f32736c
            if (r5 >= r7) goto L_0x01ea
            r7 = r1[r5]
            r12 = r17[r5]
            r7[r11] = r12
            int r5 = r5 + 1
            goto L_0x01dd
        L_0x01ea:
            r11 = r4
            r8 = r17
            r4 = 0
            r5 = 1
            r7 = 2
            goto L_0x0072
        L_0x01f2:
            r17 = r8
            int r4 = r0.f32736c
            if (r6 >= r4) goto L_0x0200
            double[] r5 = r0.f32734a
            r7 = r2[r6]
            r10 = r7[r6]
            r5[r6] = r10
        L_0x0200:
            int r5 = r0.f32735b
            if (r5 >= r4) goto L_0x020a
            double[] r5 = r0.f32734a
            int r7 = r4 + -1
            r5[r7] = r15
        L_0x020a:
            int r5 = r9 + 1
            if (r5 >= r4) goto L_0x0216
            r2 = r2[r9]
            int r5 = r4 + -1
            r7 = r2[r5]
            r17[r9] = r7
        L_0x0216:
            int r2 = r4 + -1
            r17[r2] = r15
            r5 = r6
        L_0x021b:
            int r7 = r0.f32736c
            if (r5 >= r7) goto L_0x0234
            r7 = 0
        L_0x0220:
            int r8 = r0.f32735b
            if (r7 >= r8) goto L_0x022b
            r8 = r3[r7]
            r8[r5] = r15
            int r7 = r7 + 1
            goto L_0x0220
        L_0x022b:
            r7 = r3[r5]
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r7[r5] = r10
            int r5 = r5 + 1
            goto L_0x021b
        L_0x0234:
            r5 = 1
            int r6 = r6 - r5
        L_0x0236:
            if (r6 < 0) goto L_0x02b6
            double[] r5 = r0.f32734a
            r7 = r5[r6]
            int r5 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r5 == 0) goto L_0x02a1
            int r5 = r6 + 1
        L_0x0242:
            int r7 = r0.f32736c
            if (r5 >= r7) goto L_0x0279
            r7 = r6
            r10 = r15
        L_0x0248:
            int r8 = r0.f32735b
            if (r7 >= r8) goto L_0x025a
            r8 = r3[r7]
            r12 = r8[r6]
            r8 = r3[r7]
            r22 = r8[r5]
            double r12 = r12 * r22
            double r10 = r10 + r12
            int r7 = r7 + 1
            goto L_0x0248
        L_0x025a:
            double r7 = -r10
            r10 = r3[r6]
            r11 = r10[r6]
            double r7 = r7 / r11
            r10 = r6
        L_0x0261:
            int r11 = r0.f32735b
            if (r10 >= r11) goto L_0x0276
            r11 = r3[r10]
            r12 = r11[r5]
            r14 = r3[r10]
            r22 = r14[r6]
            double r22 = r22 * r7
            double r12 = r12 + r22
            r11[r5] = r12
            int r10 = r10 + 1
            goto L_0x0261
        L_0x0276:
            int r5 = r5 + 1
            goto L_0x0242
        L_0x0279:
            r5 = r6
        L_0x027a:
            int r7 = r0.f32735b
            if (r5 >= r7) goto L_0x028a
            r7 = r3[r5]
            r8 = r3[r5]
            r10 = r8[r6]
            double r10 = -r10
            r7[r6] = r10
            int r5 = r5 + 1
            goto L_0x027a
        L_0x028a:
            r5 = r3[r6]
            r7 = r3[r6]
            r10 = r7[r6]
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r10 = r10 + r7
            r5[r6] = r10
            r5 = 0
        L_0x0296:
            int r7 = r6 + -1
            if (r5 >= r7) goto L_0x02b3
            r7 = r3[r5]
            r7[r6] = r15
            int r5 = r5 + 1
            goto L_0x0296
        L_0x02a1:
            r5 = 0
        L_0x02a2:
            int r7 = r0.f32735b
            if (r5 >= r7) goto L_0x02ad
            r7 = r3[r5]
            r7[r6] = r15
            int r5 = r5 + 1
            goto L_0x02a2
        L_0x02ad:
            r5 = r3[r6]
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5[r6] = r7
        L_0x02b3:
            int r6 = r6 + -1
            goto L_0x0236
        L_0x02b6:
            int r5 = r0.f32736c
            r6 = 1
            int r5 = r5 - r6
        L_0x02ba:
            if (r5 < 0) goto L_0x0313
            if (r5 >= r9) goto L_0x02fe
            r6 = r17[r5]
            int r8 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r8 == 0) goto L_0x02fe
            int r6 = r5 + 1
            r7 = r6
        L_0x02c7:
            int r8 = r0.f32736c
            if (r7 >= r8) goto L_0x02fe
            r8 = r6
            r10 = r15
        L_0x02cd:
            int r12 = r0.f32736c
            if (r8 >= r12) goto L_0x02df
            r12 = r1[r8]
            r13 = r12[r5]
            r12 = r1[r8]
            r22 = r12[r7]
            double r13 = r13 * r22
            double r10 = r10 + r13
            int r8 = r8 + 1
            goto L_0x02cd
        L_0x02df:
            double r10 = -r10
            r8 = r1[r6]
            r12 = r8[r5]
            double r10 = r10 / r12
            r8 = r6
        L_0x02e6:
            int r12 = r0.f32736c
            if (r8 >= r12) goto L_0x02fb
            r12 = r1[r8]
            r13 = r12[r7]
            r18 = r1[r8]
            r22 = r18[r5]
            double r22 = r22 * r10
            double r13 = r13 + r22
            r12[r7] = r13
            int r8 = r8 + 1
            goto L_0x02e6
        L_0x02fb:
            int r7 = r7 + 1
            goto L_0x02c7
        L_0x02fe:
            r6 = 0
        L_0x02ff:
            int r7 = r0.f32736c
            if (r6 >= r7) goto L_0x030a
            r7 = r1[r6]
            r7[r5] = r15
            int r6 = r6 + 1
            goto L_0x02ff
        L_0x030a:
            r6 = r1[r5]
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r6[r5] = r7
            int r5 = r5 + -1
            goto L_0x02ba
        L_0x0313:
            r5 = 4372995238176751616(0x3cb0000000000000, double:2.220446049250313E-16)
            if (r4 <= 0) goto L_0x066d
            int r7 = r4 + -2
            r8 = r7
        L_0x031a:
            r9 = 256705178760118272(0x390000000000000, double:1.6033346880071782E-291)
            if (r8 < 0) goto L_0x0344
            double[] r11 = r0.f32734a
            r12 = r11[r8]
            double r11 = nl.b.b(r12)
            double[] r13 = r0.f32734a
            int r14 = r8 + 1
            r20 = r13[r14]
            double r13 = nl.b.b(r20)
            double r11 = r11 + r13
            double r11 = r11 * r5
            double r11 = r11 + r9
            r13 = r17[r8]
            double r13 = nl.b.b(r13)
            int r18 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r18 > 0) goto L_0x0341
            r17[r8] = r15
            goto L_0x0344
        L_0x0341:
            int r8 = r8 + -1
            goto L_0x031a
        L_0x0344:
            r11 = 3
            if (r8 != r7) goto L_0x034a
            r5 = 4
        L_0x0348:
            r6 = 1
            goto L_0x0391
        L_0x034a:
            int r12 = r4 + -1
            r13 = r12
        L_0x034d:
            if (r13 < r8) goto L_0x0386
            if (r13 != r8) goto L_0x0352
            goto L_0x0386
        L_0x0352:
            if (r13 == r4) goto L_0x035b
            r20 = r17[r13]
            double r20 = nl.b.b(r20)
            goto L_0x035d
        L_0x035b:
            r20 = r15
        L_0x035d:
            int r14 = r8 + 1
            if (r13 == r14) goto L_0x036a
            int r14 = r13 + -1
            r22 = r17[r14]
            double r22 = nl.b.b(r22)
            goto L_0x036c
        L_0x036a:
            r22 = r15
        L_0x036c:
            double r20 = r20 + r22
            double[] r14 = r0.f32734a
            r22 = r14[r13]
            double r22 = nl.b.b(r22)
            double r20 = r20 * r5
            double r20 = r20 + r9
            int r14 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            if (r14 > 0) goto L_0x0383
            double[] r5 = r0.f32734a
            r5[r13] = r15
            goto L_0x0386
        L_0x0383:
            int r13 = r13 + -1
            goto L_0x034d
        L_0x0386:
            if (r13 != r8) goto L_0x038a
            r5 = 3
            goto L_0x0348
        L_0x038a:
            if (r13 != r12) goto L_0x038e
            r5 = 1
            goto L_0x0348
        L_0x038e:
            r8 = r13
            r5 = 2
            goto L_0x0348
        L_0x0391:
            int r8 = r8 + r6
            if (r5 == r6) goto L_0x05f9
            r9 = 2
            if (r5 == r9) goto L_0x0598
            if (r5 == r11) goto L_0x0418
            double[] r5 = r0.f32734a
            r6 = r5[r8]
            int r10 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r10 > 0) goto L_0x03bd
            r6 = r5[r8]
            int r10 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r10 >= 0) goto L_0x03ab
            r6 = r5[r8]
            double r6 = -r6
            goto L_0x03ac
        L_0x03ab:
            r6 = r15
        L_0x03ac:
            r5[r8] = r6
            r5 = 0
        L_0x03af:
            if (r5 > r2) goto L_0x03bd
            r6 = r1[r5]
            r7 = r1[r5]
            r10 = r7[r8]
            double r10 = -r10
            r6[r8] = r10
            int r5 = r5 + 1
            goto L_0x03af
        L_0x03bd:
            if (r8 >= r2) goto L_0x0412
            double[] r5 = r0.f32734a
            r6 = r5[r8]
            int r10 = r8 + 1
            r11 = r5[r10]
            int r13 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r13 < 0) goto L_0x03cc
            goto L_0x0412
        L_0x03cc:
            r6 = r5[r8]
            r11 = r5[r10]
            r5[r8] = r11
            r5[r10] = r6
            int r5 = r0.f32736c
            r6 = 1
            int r5 = r5 - r6
            if (r8 >= r5) goto L_0x03f2
            r5 = 0
        L_0x03db:
            int r6 = r0.f32736c
            if (r5 >= r6) goto L_0x03f2
            r6 = r1[r5]
            r11 = r6[r10]
            r6 = r1[r5]
            r7 = r1[r5]
            r13 = r7[r8]
            r6[r10] = r13
            r6 = r1[r5]
            r6[r8] = r11
            int r5 = r5 + 1
            goto L_0x03db
        L_0x03f2:
            int r5 = r0.f32735b
            r6 = 1
            int r5 = r5 - r6
            if (r8 >= r5) goto L_0x0410
            r5 = 0
        L_0x03f9:
            int r6 = r0.f32735b
            if (r5 >= r6) goto L_0x0410
            r6 = r3[r5]
            r11 = r6[r10]
            r6 = r3[r5]
            r7 = r3[r5]
            r13 = r7[r8]
            r6[r10] = r13
            r6 = r3[r5]
            r6[r8] = r11
            int r5 = r5 + 1
            goto L_0x03f9
        L_0x0410:
            r8 = r10
            goto L_0x03bd
        L_0x0412:
            int r4 = r4 + -1
            r18 = r2
            goto L_0x0667
        L_0x0418:
            double[] r5 = r0.f32734a
            int r6 = r4 + -1
            r10 = r5[r6]
            double r10 = nl.b.b(r10)
            double[] r5 = r0.f32734a
            r12 = r5[r7]
            double r12 = nl.b.b(r12)
            double r10 = nl.b.a((double) r10, (double) r12)
            r12 = r17[r7]
            double r12 = nl.b.b(r12)
            double r10 = nl.b.a((double) r10, (double) r12)
            double[] r5 = r0.f32734a
            r12 = r5[r8]
            double r12 = nl.b.b(r12)
            double r10 = nl.b.a((double) r10, (double) r12)
            r12 = r17[r8]
            double r12 = nl.b.b(r12)
            double r10 = nl.b.a((double) r10, (double) r12)
            double[] r5 = r0.f32734a
            r12 = r5[r6]
            double r12 = r12 / r10
            r20 = r5[r7]
            double r20 = r20 / r10
            r22 = r17[r7]
            double r22 = r22 / r10
            r24 = r5[r8]
            double r24 = r24 / r10
            r26 = r17[r8]
            double r26 = r26 / r10
            double r10 = r20 + r12
            double r20 = r20 - r12
            double r10 = r10 * r20
            double r20 = r22 * r22
            double r10 = r10 + r20
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r10 = r10 / r20
            double r22 = r22 * r12
            double r22 = r22 * r22
            int r5 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r5 != 0) goto L_0x0483
            int r5 = (r22 > r15 ? 1 : (r22 == r15 ? 0 : -1))
            if (r5 == 0) goto L_0x047e
            goto L_0x0483
        L_0x047e:
            r35 = r4
            r22 = r15
            goto L_0x0495
        L_0x0483:
            double r20 = r10 * r10
            double r20 = r20 + r22
            r35 = r4
            double r4 = nl.b.a(r20)
            int r14 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r14 >= 0) goto L_0x0492
            double r4 = -r4
        L_0x0492:
            double r10 = r10 + r4
            double r22 = r22 / r10
        L_0x0495:
            double r4 = r24 + r12
            double r10 = r24 - r12
            double r4 = r4 * r10
            double r4 = r4 + r22
            double r24 = r24 * r26
            r12 = r8
            r10 = r24
        L_0x04a2:
            if (r12 >= r6) goto L_0x058d
            double r13 = nl.b.b((double) r4, (double) r10)
            double r4 = r4 / r13
            double r10 = r10 / r13
            if (r12 == r8) goto L_0x04b0
            int r18 = r12 + -1
            r17[r18] = r13
        L_0x04b0:
            double[] r13 = r0.f32734a
            r20 = r13[r12]
            double r20 = r20 * r4
            r22 = r17[r12]
            double r22 = r22 * r10
            r24 = r10
            double r9 = r20 + r22
            r20 = r17[r12]
            double r20 = r20 * r4
            r22 = r13[r12]
            double r22 = r22 * r24
            double r20 = r20 - r22
            r17[r12] = r20
            int r11 = r12 + 1
            r20 = r13[r11]
            double r14 = r24 * r20
            r20 = r13[r11]
            double r20 = r20 * r4
            r13[r11] = r20
            r18 = r2
            r13 = 0
        L_0x04d9:
            int r2 = r0.f32736c
            if (r13 >= r2) goto L_0x0519
            r2 = r1[r13]
            r20 = r2[r12]
            double r20 = r20 * r4
            r2 = r1[r13]
            r26 = r2[r11]
            double r26 = r26 * r24
            double r20 = r20 + r26
            r2 = r1[r13]
            r27 = r6
            r26 = r7
            r28 = r9
            r6 = r24
            r24 = r8
            double r8 = -r6
            r10 = r1[r13]
            r30 = r10[r12]
            double r8 = r8 * r30
            r10 = r1[r13]
            r30 = r10[r11]
            double r30 = r30 * r4
            double r8 = r8 + r30
            r2[r11] = r8
            r2 = r1[r13]
            r2[r12] = r20
            int r13 = r13 + 1
            r8 = r24
            r9 = r28
            r24 = r6
            r7 = r26
            r6 = r27
            goto L_0x04d9
        L_0x0519:
            r27 = r6
            r26 = r7
            r24 = r8
            r8 = r9
            double r4 = nl.b.b((double) r8, (double) r14)
            double r9 = r8 / r4
            double r14 = r14 / r4
            double[] r2 = r0.f32734a
            r2[r12] = r4
            r4 = r17[r12]
            double r4 = r4 * r9
            r6 = r2[r11]
            double r6 = r6 * r14
            double r4 = r4 + r6
            double r6 = -r14
            r20 = r17[r12]
            double r20 = r20 * r6
            r28 = r2[r11]
            double r28 = r28 * r9
            double r20 = r20 + r28
            r2[r11] = r20
            r20 = r17[r11]
            double r20 = r20 * r14
            r28 = r17[r11]
            double r28 = r28 * r9
            r17[r11] = r28
            int r2 = r0.f32735b
            r8 = 1
            int r2 = r2 - r8
            if (r12 >= r2) goto L_0x057d
            r2 = 0
        L_0x0552:
            int r13 = r0.f32735b
            if (r2 >= r13) goto L_0x057d
            r13 = r3[r2]
            r28 = r13[r12]
            double r28 = r28 * r9
            r13 = r3[r2]
            r30 = r13[r11]
            double r30 = r30 * r14
            double r28 = r28 + r30
            r13 = r3[r2]
            r19 = r3[r2]
            r30 = r19[r12]
            double r30 = r30 * r6
            r19 = r3[r2]
            r32 = r19[r11]
            double r32 = r32 * r9
            double r30 = r30 + r32
            r13[r11] = r30
            r13 = r3[r2]
            r13[r12] = r28
            int r2 = r2 + 1
            goto L_0x0552
        L_0x057d:
            r12 = r11
            r2 = r18
            r10 = r20
            r8 = r24
            r7 = r26
            r6 = r27
            r9 = 2
            r15 = 0
            goto L_0x04a2
        L_0x058d:
            r18 = r2
            r26 = r7
            r8 = 1
            r17[r26] = r4
            r4 = r35
            goto L_0x0667
        L_0x0598:
            r18 = r2
            r35 = r4
            r24 = r8
            r8 = 1
            int r2 = r24 + -1
            r4 = r17[r2]
            r6 = 0
            r17[r2] = r6
            r7 = r35
            r6 = r24
        L_0x05ab:
            if (r6 >= r7) goto L_0x0666
            double[] r9 = r0.f32734a
            r10 = r9[r6]
            double r9 = nl.b.b((double) r10, (double) r4)
            double[] r11 = r0.f32734a
            r12 = r11[r6]
            double r12 = r12 / r9
            double r4 = r4 / r9
            r11[r6] = r9
            double r9 = -r4
            r14 = r17[r6]
            double r14 = r14 * r9
            r19 = r17[r6]
            double r19 = r19 * r12
            r17[r6] = r19
            r11 = 0
        L_0x05c9:
            int r8 = r0.f32735b
            if (r11 >= r8) goto L_0x05f4
            r8 = r3[r11]
            r20 = r8[r6]
            double r20 = r20 * r12
            r8 = r3[r11]
            r24 = r8[r2]
            double r24 = r24 * r4
            double r20 = r20 + r24
            r8 = r3[r11]
            r24 = r3[r11]
            r25 = r24[r6]
            double r25 = r25 * r9
            r24 = r3[r11]
            r27 = r24[r2]
            double r27 = r27 * r12
            double r25 = r25 + r27
            r8[r2] = r25
            r8 = r3[r11]
            r8[r6] = r20
            int r11 = r11 + 1
            goto L_0x05c9
        L_0x05f4:
            int r6 = r6 + 1
            r4 = r14
            r8 = 1
            goto L_0x05ab
        L_0x05f9:
            r18 = r2
            r26 = r7
            r24 = r8
            r7 = r4
            r4 = r17[r26]
            r8 = 0
            r17[r26] = r8
            r6 = r24
            r2 = r26
        L_0x060a:
            if (r2 < r6) goto L_0x0666
            double[] r10 = r0.f32734a
            r11 = r10[r2]
            double r10 = nl.b.b((double) r11, (double) r4)
            double[] r12 = r0.f32734a
            r13 = r12[r2]
            double r13 = r13 / r10
            double r8 = r4 / r10
            r12[r2] = r10
            if (r2 == r6) goto L_0x062c
            double r4 = -r8
            int r10 = r2 + -1
            r11 = r17[r10]
            double r4 = r4 * r11
            r11 = r17[r10]
            double r11 = r11 * r13
            r17[r10] = r11
        L_0x062c:
            r10 = 0
        L_0x062d:
            int r11 = r0.f32736c
            if (r10 >= r11) goto L_0x065f
            r11 = r1[r10]
            r20 = r11[r2]
            double r20 = r20 * r13
            r11 = r1[r10]
            int r12 = r7 + -1
            r24 = r11[r12]
            double r24 = r24 * r8
            double r20 = r20 + r24
            r11 = r1[r10]
            r24 = r4
            double r4 = -r8
            r15 = r1[r10]
            r26 = r15[r2]
            double r4 = r4 * r26
            r15 = r1[r10]
            r26 = r15[r12]
            double r26 = r26 * r13
            double r4 = r4 + r26
            r11[r12] = r4
            r4 = r1[r10]
            r4[r2] = r20
            int r10 = r10 + 1
            r4 = r24
            goto L_0x062d
        L_0x065f:
            r24 = r4
            int r2 = r2 + -1
            r8 = 0
            goto L_0x060a
        L_0x0666:
            r4 = r7
        L_0x0667:
            r2 = r18
            r15 = 0
            goto L_0x0313
        L_0x066d:
            int r2 = r0.f32735b
            double r7 = (double) r2
            double[] r2 = r0.f32734a
            r4 = 0
            r9 = r2[r4]
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r9
            double r7 = r7 * r5
            r4 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            double r4 = nl.b.a(r4)
            double r4 = nl.b.a((double) r7, (double) r4)
            r0.f32741h = r4
            boolean r2 = r0.f32737d
            if (r2 != 0) goto L_0x0697
            org.apache.commons.math3.linear.h r2 = org.apache.commons.math3.linear.f.a((double[][]) r3)
            r0.f32738e = r2
            org.apache.commons.math3.linear.h r1 = org.apache.commons.math3.linear.f.a((double[][]) r1)
            goto L_0x06a1
        L_0x0697:
            org.apache.commons.math3.linear.h r1 = org.apache.commons.math3.linear.f.a((double[][]) r1)
            r0.f32738e = r1
            org.apache.commons.math3.linear.h r1 = org.apache.commons.math3.linear.f.a((double[][]) r3)
        L_0x06a1:
            r0.f32740g = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.math3.linear.l.<init>(org.apache.commons.math3.linear.h):void");
    }

    public h a() {
        return this.f32738e;
    }

    public h b() {
        if (this.f32739f == null) {
            this.f32739f = a().b();
        }
        return this.f32739f;
    }

    public h c() {
        return this.f32740g;
    }

    public int d() {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            double[] dArr = this.f32734a;
            if (i2 >= dArr.length) {
                return i3;
            }
            if (dArr[i2] > this.f32741h) {
                i3++;
            }
            i2++;
        }
    }

    public c e() {
        return new a(this.f32734a, b(), c(), d() == this.f32735b, this.f32741h, (AnonymousClass1) null);
    }
}
