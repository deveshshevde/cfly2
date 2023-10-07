package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.d;
import java.util.ArrayList;
import java.util.Iterator;

public class c extends WidgetRun {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<WidgetRun> f2354a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private int f2355b;

    public c(ConstraintWidget constraintWidget, int i2) {
        super(constraintWidget);
        this.f2327h = i2;
        h();
    }

    private void h() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.f2323d;
        do {
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget2.w(this.f2327h);
        } while (constraintWidget2 != null);
        this.f2323d = constraintWidget;
        this.f2354a.add(constraintWidget.c(this.f2327h));
        ConstraintWidget x2 = constraintWidget.x(this.f2327h);
        while (x2 != null) {
            this.f2354a.add(x2.c(this.f2327h));
            x2 = x2.x(this.f2327h);
        }
        Iterator<WidgetRun> it2 = this.f2354a.iterator();
        while (it2.hasNext()) {
            WidgetRun next = it2.next();
            if (this.f2327h == 0) {
                next.f2323d.f2268d = this;
            } else if (this.f2327h == 1) {
                next.f2323d.f2269e = this;
            }
        }
        if ((this.f2327h == 0 && ((d) this.f2323d.v()).Y()) && this.f2354a.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f2354a;
            this.f2323d = arrayList.get(arrayList.size() - 1).f2323d;
        }
        this.f2355b = this.f2327h == 0 ? this.f2323d.P() : this.f2323d.Q();
    }

    private ConstraintWidget i() {
        for (int i2 = 0; i2 < this.f2354a.size(); i2++) {
            WidgetRun widgetRun = this.f2354a.get(i2);
            if (widgetRun.f2323d.w() != 8) {
                return widgetRun.f2323d;
            }
        }
        return null;
    }

    private ConstraintWidget j() {
        for (int size = this.f2354a.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.f2354a.get(size);
            if (widgetRun.f2323d.w() != 8) {
                return widgetRun.f2323d;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00cf, code lost:
        if (r2.f2326g.f2310j != false) goto L_0x00d1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.solver.widgets.analyzer.d r23) {
        /*
            r22 = this;
            r0 = r22
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.f2329j
            boolean r1 = r1.f2310j
            if (r1 == 0) goto L_0x0401
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r0.f2330k
            boolean r1 = r1.f2310j
            if (r1 != 0) goto L_0x0010
            goto L_0x0401
        L_0x0010:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.v()
            if (r1 == 0) goto L_0x0023
            boolean r3 = r1 instanceof androidx.constraintlayout.solver.widgets.d
            if (r3 == 0) goto L_0x0023
            androidx.constraintlayout.solver.widgets.d r1 = (androidx.constraintlayout.solver.widgets.d) r1
            boolean r1 = r1.Y()
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r0.f2330k
            int r3 = r3.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r0.f2329j
            int r4 = r4.f2307g
            int r3 = r3 - r4
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r4 = r0.f2354a
            int r4 = r4.size()
            r5 = 0
        L_0x0034:
            r6 = -1
            r7 = 8
            if (r5 >= r4) goto L_0x004c
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r8 = r0.f2354a
            java.lang.Object r8 = r8.get(r5)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r8 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r8 = r8.f2323d
            int r8 = r8.w()
            if (r8 != r7) goto L_0x004d
            int r5 = r5 + 1
            goto L_0x0034
        L_0x004c:
            r5 = -1
        L_0x004d:
            int r8 = r4 + -1
            r9 = r8
        L_0x0050:
            if (r9 < 0) goto L_0x0066
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r10 = r0.f2354a
            java.lang.Object r10 = r10.get(r9)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r10.f2323d
            int r10 = r10.w()
            if (r10 != r7) goto L_0x0065
            int r9 = r9 + -1
            goto L_0x0050
        L_0x0065:
            r6 = r9
        L_0x0066:
            r9 = 0
        L_0x0067:
            r11 = 2
            r12 = 1
            if (r9 >= r11) goto L_0x0106
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0072:
            if (r13 >= r4) goto L_0x00f8
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r2 = r0.f2354a
            java.lang.Object r2 = r2.get(r13)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r2 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r2.f2323d
            int r11 = r11.w()
            if (r11 != r7) goto L_0x0086
            goto L_0x00f1
        L_0x0086:
            int r16 = r16 + 1
            if (r13 <= 0) goto L_0x0091
            if (r13 < r5) goto L_0x0091
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r11 = r2.f2329j
            int r11 = r11.f2306f
            int r14 = r14 + r11
        L_0x0091:
            androidx.constraintlayout.solver.widgets.analyzer.f r11 = r2.f2326g
            int r11 = r11.f2307g
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r2.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 == r10) goto L_0x009d
            r7 = 1
            goto L_0x009e
        L_0x009d:
            r7 = 0
        L_0x009e:
            if (r7 == 0) goto L_0x00be
            int r10 = r0.f2327h
            if (r10 != 0) goto L_0x00af
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r2.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.k r10 = r10.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r10.f2326g
            boolean r10 = r10.f2310j
            if (r10 != 0) goto L_0x00af
            return
        L_0x00af:
            int r10 = r0.f2327h
            if (r10 != r12) goto L_0x00d2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r2.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r10 = r10.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r10.f2326g
            boolean r10 = r10.f2310j
            if (r10 != 0) goto L_0x00d2
            return
        L_0x00be:
            int r10 = r2.f2322c
            if (r10 != r12) goto L_0x00cb
            if (r9 != 0) goto L_0x00cb
            androidx.constraintlayout.solver.widgets.analyzer.f r7 = r2.f2326g
            int r11 = r7.f2365m
            int r15 = r15 + 1
            goto L_0x00d1
        L_0x00cb:
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r2.f2326g
            boolean r10 = r10.f2310j
            if (r10 == 0) goto L_0x00d2
        L_0x00d1:
            r7 = 1
        L_0x00d2:
            if (r7 != 0) goto L_0x00e6
            int r15 = r15 + 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r2.f2323d
            float[] r7 = r7.f2255ap
            int r10 = r0.f2327h
            r7 = r7[r10]
            r10 = 0
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 < 0) goto L_0x00e7
            float r17 = r17 + r7
            goto L_0x00e7
        L_0x00e6:
            int r14 = r14 + r11
        L_0x00e7:
            if (r13 >= r8) goto L_0x00f1
            if (r13 >= r6) goto L_0x00f1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.f2330k
            int r2 = r2.f2306f
            int r2 = -r2
            int r14 = r14 + r2
        L_0x00f1:
            int r13 = r13 + 1
            r7 = 8
            r11 = 2
            goto L_0x0072
        L_0x00f8:
            if (r14 < r3) goto L_0x0103
            if (r15 != 0) goto L_0x00fd
            goto L_0x0103
        L_0x00fd:
            int r9 = r9 + 1
            r7 = 8
            goto L_0x0067
        L_0x0103:
            r2 = r16
            goto L_0x010b
        L_0x0106:
            r2 = 0
            r14 = 0
            r15 = 0
            r17 = 0
        L_0x010b:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r0.f2329j
            int r7 = r7.f2307g
            if (r1 == 0) goto L_0x0115
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r0.f2330k
            int r7 = r7.f2307g
        L_0x0115:
            r9 = 1056964608(0x3f000000, float:0.5)
            if (r14 <= r3) goto L_0x0126
            r10 = 1073741824(0x40000000, float:2.0)
            int r11 = r14 - r3
            float r11 = (float) r11
            float r11 = r11 / r10
            float r11 = r11 + r9
            int r10 = (int) r11
            if (r1 == 0) goto L_0x0125
            int r7 = r7 + r10
            goto L_0x0126
        L_0x0125:
            int r7 = r7 - r10
        L_0x0126:
            if (r15 <= 0) goto L_0x0232
            int r10 = r3 - r14
            float r10 = (float) r10
            float r11 = (float) r15
            float r11 = r10 / r11
            float r11 = r11 + r9
            int r11 = (int) r11
            r13 = 0
            r16 = 0
        L_0x0133:
            if (r13 >= r4) goto L_0x01e7
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r12 = r0.f2354a
            java.lang.Object r12 = r12.get(r13)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r12 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r12
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r12.f2323d
            int r9 = r9.w()
            r18 = r11
            r11 = 8
            if (r9 != r11) goto L_0x014b
            goto L_0x01d2
        L_0x014b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r12.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r9 != r11) goto L_0x01d2
            androidx.constraintlayout.solver.widgets.analyzer.f r9 = r12.f2326g
            boolean r9 = r9.f2310j
            if (r9 != 0) goto L_0x01d2
            r9 = 0
            int r11 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x016d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r12.f2323d
            float[] r11 = r11.f2255ap
            int r9 = r0.f2327h
            r9 = r11[r9]
            float r9 = r9 * r10
            float r9 = r9 / r17
            r11 = 1056964608(0x3f000000, float:0.5)
            float r9 = r9 + r11
            int r9 = (int) r9
            goto L_0x016f
        L_0x016d:
            r9 = r18
        L_0x016f:
            int r11 = r0.f2327h
            if (r11 != 0) goto L_0x01a0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r12.f2323d
            int r11 = r11.f2280p
            r19 = r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r12.f2323d
            int r10 = r10.f2279o
            r20 = r14
            int r14 = r12.f2322c
            r21 = r7
            r7 = 1
            if (r14 != r7) goto L_0x018f
            androidx.constraintlayout.solver.widgets.analyzer.f r7 = r12.f2326g
            int r7 = r7.f2365m
            int r7 = java.lang.Math.min(r9, r7)
            goto L_0x0190
        L_0x018f:
            r7 = r9
        L_0x0190:
            int r7 = java.lang.Math.max(r10, r7)
            if (r11 <= 0) goto L_0x019a
            int r7 = java.lang.Math.min(r11, r7)
        L_0x019a:
            if (r7 == r9) goto L_0x01cc
            int r16 = r16 + 1
            r9 = r7
            goto L_0x01cc
        L_0x01a0:
            r21 = r7
            r19 = r10
            r20 = r14
            androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r12.f2323d
            int r7 = r7.f2283s
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r12.f2323d
            int r10 = r10.f2282r
            int r11 = r12.f2322c
            r14 = 1
            if (r11 != r14) goto L_0x01bc
            androidx.constraintlayout.solver.widgets.analyzer.f r11 = r12.f2326g
            int r11 = r11.f2365m
            int r11 = java.lang.Math.min(r9, r11)
            goto L_0x01bd
        L_0x01bc:
            r11 = r9
        L_0x01bd:
            int r10 = java.lang.Math.max(r10, r11)
            if (r7 <= 0) goto L_0x01c7
            int r10 = java.lang.Math.min(r7, r10)
        L_0x01c7:
            if (r10 == r9) goto L_0x01cc
            int r16 = r16 + 1
            r9 = r10
        L_0x01cc:
            androidx.constraintlayout.solver.widgets.analyzer.f r7 = r12.f2326g
            r7.a(r9)
            goto L_0x01d8
        L_0x01d2:
            r21 = r7
            r19 = r10
            r20 = r14
        L_0x01d8:
            int r13 = r13 + 1
            r11 = r18
            r10 = r19
            r14 = r20
            r7 = r21
            r9 = 1056964608(0x3f000000, float:0.5)
            r12 = 1
            goto L_0x0133
        L_0x01e7:
            r21 = r7
            r20 = r14
            if (r16 <= 0) goto L_0x0223
            int r15 = r15 - r16
            r7 = 0
            r9 = 0
        L_0x01f1:
            if (r7 >= r4) goto L_0x0221
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r10 = r0.f2354a
            java.lang.Object r10 = r10.get(r7)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r10 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r10
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r10.f2323d
            int r11 = r11.w()
            r12 = 8
            if (r11 != r12) goto L_0x0206
            goto L_0x021e
        L_0x0206:
            if (r7 <= 0) goto L_0x020f
            if (r7 < r5) goto L_0x020f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r11 = r10.f2329j
            int r11 = r11.f2306f
            int r9 = r9 + r11
        L_0x020f:
            androidx.constraintlayout.solver.widgets.analyzer.f r11 = r10.f2326g
            int r11 = r11.f2307g
            int r9 = r9 + r11
            if (r7 >= r8) goto L_0x021e
            if (r7 >= r6) goto L_0x021e
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r10.f2330k
            int r10 = r10.f2306f
            int r10 = -r10
            int r9 = r9 + r10
        L_0x021e:
            int r7 = r7 + 1
            goto L_0x01f1
        L_0x0221:
            r14 = r9
            goto L_0x0225
        L_0x0223:
            r14 = r20
        L_0x0225:
            int r7 = r0.f2355b
            r9 = 2
            if (r7 != r9) goto L_0x0230
            if (r16 != 0) goto L_0x0230
            r7 = 0
            r0.f2355b = r7
            goto L_0x0238
        L_0x0230:
            r7 = 0
            goto L_0x0238
        L_0x0232:
            r21 = r7
            r20 = r14
            r7 = 0
            r9 = 2
        L_0x0238:
            if (r14 <= r3) goto L_0x023c
            r0.f2355b = r9
        L_0x023c:
            if (r2 <= 0) goto L_0x0244
            if (r15 != 0) goto L_0x0244
            if (r5 != r6) goto L_0x0244
            r0.f2355b = r9
        L_0x0244:
            int r9 = r0.f2355b
            r10 = 1
            if (r9 != r10) goto L_0x02d7
            if (r2 <= r10) goto L_0x024f
            int r3 = r3 - r14
            int r2 = r2 - r10
            int r3 = r3 / r2
            goto L_0x0256
        L_0x024f:
            if (r2 != r10) goto L_0x0255
            int r3 = r3 - r14
            r2 = 2
            int r3 = r3 / r2
            goto L_0x0256
        L_0x0255:
            r3 = 0
        L_0x0256:
            if (r15 <= 0) goto L_0x0259
            r3 = 0
        L_0x0259:
            r7 = r21
            r2 = 0
        L_0x025c:
            if (r2 >= r4) goto L_0x0401
            if (r1 == 0) goto L_0x0265
            int r9 = r2 + 1
            int r9 = r4 - r9
            goto L_0x0266
        L_0x0265:
            r9 = r2
        L_0x0266:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r10 = r0.f2354a
            java.lang.Object r9 = r10.get(r9)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r9
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r9.f2323d
            int r10 = r10.w()
            r11 = 8
            if (r10 != r11) goto L_0x0283
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
            r10.a((int) r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r9.f2330k
            r9.a((int) r7)
            goto L_0x02d4
        L_0x0283:
            if (r2 <= 0) goto L_0x028a
            if (r1 == 0) goto L_0x0289
            int r7 = r7 - r3
            goto L_0x028a
        L_0x0289:
            int r7 = r7 + r3
        L_0x028a:
            if (r2 <= 0) goto L_0x0297
            if (r2 < r5) goto L_0x0297
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
            int r10 = r10.f2306f
            if (r1 == 0) goto L_0x0296
            int r7 = r7 - r10
            goto L_0x0297
        L_0x0296:
            int r7 = r7 + r10
        L_0x0297:
            if (r1 == 0) goto L_0x029c
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2330k
            goto L_0x029e
        L_0x029c:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
        L_0x029e:
            r10.a((int) r7)
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r9.f2326g
            int r10 = r10.f2307g
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x02b4
            int r11 = r9.f2322c
            r12 = 1
            if (r11 != r12) goto L_0x02b4
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r9.f2326g
            int r10 = r10.f2365m
        L_0x02b4:
            if (r1 == 0) goto L_0x02b8
            int r7 = r7 - r10
            goto L_0x02b9
        L_0x02b8:
            int r7 = r7 + r10
        L_0x02b9:
            if (r1 == 0) goto L_0x02be
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
            goto L_0x02c0
        L_0x02be:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2330k
        L_0x02c0:
            r10.a((int) r7)
            r10 = 1
            r9.f2328i = r10
            if (r2 >= r8) goto L_0x02d4
            if (r2 >= r6) goto L_0x02d4
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r9.f2330k
            int r9 = r9.f2306f
            int r9 = -r9
            if (r1 == 0) goto L_0x02d3
            int r7 = r7 - r9
            goto L_0x02d4
        L_0x02d3:
            int r7 = r7 + r9
        L_0x02d4:
            int r2 = r2 + 1
            goto L_0x025c
        L_0x02d7:
            if (r9 != 0) goto L_0x035d
            int r3 = r3 - r14
            r9 = 1
            int r2 = r2 + r9
            int r3 = r3 / r2
            if (r15 <= 0) goto L_0x02e0
            r3 = 0
        L_0x02e0:
            r7 = r21
            r2 = 0
        L_0x02e3:
            if (r2 >= r4) goto L_0x0401
            if (r1 == 0) goto L_0x02ec
            int r9 = r2 + 1
            int r9 = r4 - r9
            goto L_0x02ed
        L_0x02ec:
            r9 = r2
        L_0x02ed:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r10 = r0.f2354a
            java.lang.Object r9 = r10.get(r9)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r9 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r9
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r9.f2323d
            int r10 = r10.w()
            r11 = 8
            if (r10 != r11) goto L_0x030a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
            r10.a((int) r7)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r9.f2330k
            r9.a((int) r7)
            goto L_0x035a
        L_0x030a:
            if (r1 == 0) goto L_0x030e
            int r7 = r7 - r3
            goto L_0x030f
        L_0x030e:
            int r7 = r7 + r3
        L_0x030f:
            if (r2 <= 0) goto L_0x031c
            if (r2 < r5) goto L_0x031c
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
            int r10 = r10.f2306f
            if (r1 == 0) goto L_0x031b
            int r7 = r7 - r10
            goto L_0x031c
        L_0x031b:
            int r7 = r7 + r10
        L_0x031c:
            if (r1 == 0) goto L_0x0321
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2330k
            goto L_0x0323
        L_0x0321:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
        L_0x0323:
            r10.a((int) r7)
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r9.f2326g
            int r10 = r10.f2307g
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r9.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x033d
            int r11 = r9.f2322c
            r12 = 1
            if (r11 != r12) goto L_0x033d
            androidx.constraintlayout.solver.widgets.analyzer.f r11 = r9.f2326g
            int r11 = r11.f2365m
            int r10 = java.lang.Math.min(r10, r11)
        L_0x033d:
            if (r1 == 0) goto L_0x0341
            int r7 = r7 - r10
            goto L_0x0342
        L_0x0341:
            int r7 = r7 + r10
        L_0x0342:
            if (r1 == 0) goto L_0x0347
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2329j
            goto L_0x0349
        L_0x0347:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r10 = r9.f2330k
        L_0x0349:
            r10.a((int) r7)
            if (r2 >= r8) goto L_0x035a
            if (r2 >= r6) goto L_0x035a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r9.f2330k
            int r9 = r9.f2306f
            int r9 = -r9
            if (r1 == 0) goto L_0x0359
            int r7 = r7 - r9
            goto L_0x035a
        L_0x0359:
            int r7 = r7 + r9
        L_0x035a:
            int r2 = r2 + 1
            goto L_0x02e3
        L_0x035d:
            r2 = 2
            if (r9 != r2) goto L_0x0401
            int r2 = r0.f2327h
            if (r2 != 0) goto L_0x036b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.f2323d
            float r2 = r2.I()
            goto L_0x0371
        L_0x036b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r0.f2323d
            float r2 = r2.J()
        L_0x0371:
            if (r1 == 0) goto L_0x0377
            r9 = 1065353216(0x3f800000, float:1.0)
            float r2 = r9 - r2
        L_0x0377:
            int r3 = r3 - r14
            float r3 = (float) r3
            float r3 = r3 * r2
            r2 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r2
            int r2 = (int) r3
            if (r2 < 0) goto L_0x0383
            if (r15 <= 0) goto L_0x0384
        L_0x0383:
            r2 = 0
        L_0x0384:
            if (r1 == 0) goto L_0x0389
            int r2 = r21 - r2
            goto L_0x038b
        L_0x0389:
            int r2 = r21 + r2
        L_0x038b:
            r3 = r2
            r2 = 0
        L_0x038d:
            if (r2 >= r4) goto L_0x0401
            if (r1 == 0) goto L_0x0396
            int r7 = r2 + 1
            int r7 = r4 - r7
            goto L_0x0397
        L_0x0396:
            r7 = r2
        L_0x0397:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r9 = r0.f2354a
            java.lang.Object r7 = r9.get(r7)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r7
            androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r7.f2323d
            int r9 = r9.w()
            r10 = 8
            if (r9 != r10) goto L_0x03b5
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r7.f2329j
            r9.a((int) r3)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.f2330k
            r7.a((int) r3)
            r12 = 1
            goto L_0x03fe
        L_0x03b5:
            if (r2 <= 0) goto L_0x03c2
            if (r2 < r5) goto L_0x03c2
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r7.f2329j
            int r9 = r9.f2306f
            if (r1 == 0) goto L_0x03c1
            int r3 = r3 - r9
            goto L_0x03c2
        L_0x03c1:
            int r3 = r3 + r9
        L_0x03c2:
            if (r1 == 0) goto L_0x03c7
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r7.f2330k
            goto L_0x03c9
        L_0x03c7:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r7.f2329j
        L_0x03c9:
            r9.a((int) r3)
            androidx.constraintlayout.solver.widgets.analyzer.f r9 = r7.f2326g
            int r9 = r9.f2307g
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r11 != r12) goto L_0x03e0
            int r11 = r7.f2322c
            r12 = 1
            if (r11 != r12) goto L_0x03e1
            androidx.constraintlayout.solver.widgets.analyzer.f r9 = r7.f2326g
            int r9 = r9.f2365m
            goto L_0x03e1
        L_0x03e0:
            r12 = 1
        L_0x03e1:
            if (r1 == 0) goto L_0x03e5
            int r3 = r3 - r9
            goto L_0x03e6
        L_0x03e5:
            int r3 = r3 + r9
        L_0x03e6:
            if (r1 == 0) goto L_0x03eb
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r7.f2329j
            goto L_0x03ed
        L_0x03eb:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r9 = r7.f2330k
        L_0x03ed:
            r9.a((int) r3)
            if (r2 >= r8) goto L_0x03fe
            if (r2 >= r6) goto L_0x03fe
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r7 = r7.f2330k
            int r7 = r7.f2306f
            int r7 = -r7
            if (r1 == 0) goto L_0x03fd
            int r3 = r3 - r7
            goto L_0x03fe
        L_0x03fd:
            int r3 = r3 + r7
        L_0x03fe:
            int r2 = r2 + 1
            goto L_0x038d
        L_0x0401:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.c.a(androidx.constraintlayout.solver.widgets.analyzer.d):void");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        int size = this.f2354a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f2354a.get(i2).a()) {
                return false;
            }
        }
        return true;
    }

    public long b() {
        int size = this.f2354a.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            WidgetRun widgetRun = this.f2354a.get(i2);
            j2 = j2 + ((long) widgetRun.f2329j.f2306f) + widgetRun.b() + ((long) widgetRun.f2330k.f2306f);
        }
        return j2;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f2324e = null;
        Iterator<WidgetRun> it2 = this.f2354a.iterator();
        while (it2.hasNext()) {
            it2.next().c();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f2329j.f2310j = false;
        this.f2330k.f2310j = false;
    }

    public void e() {
        for (int i2 = 0; i2 < this.f2354a.size(); i2++) {
            this.f2354a.get(i2).e();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        if (r1 != null) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
        if (r1 != null) goto L_0x00a5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r5 = this;
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r0 = r5.f2354a
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0016
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r1 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r1
            r1.f()
            goto L_0x0006
        L_0x0016:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r0 = r5.f2354a
            int r0 = r0.size()
            r1 = 1
            if (r0 >= r1) goto L_0x0020
            return
        L_0x0020:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r2 = r5.f2354a
            r3 = 0
            java.lang.Object r2 = r2.get(r3)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r2 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.f2323d
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r4 = r5.f2354a
            int r0 = r0 - r1
            java.lang.Object r0 = r4.get(r0)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r0 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.f2323d
            int r4 = r5.f2327h
            if (r4 != 0) goto L_0x0070
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r2.f2289y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.A
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r1, (int) r3)
            int r1 = r1.j()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r5.i()
            if (r4 == 0) goto L_0x0052
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r4.f2289y
            int r1 = r1.j()
        L_0x0052:
            if (r2 == 0) goto L_0x0059
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r5.f2329j
            r5.a(r4, r2, r1)
        L_0x0059:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0, (int) r3)
            int r0 = r0.j()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r5.j()
            if (r2 == 0) goto L_0x006d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r2.A
            int r0 = r0.j()
        L_0x006d:
            if (r1 == 0) goto L_0x00ab
            goto L_0x00a5
        L_0x0070:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2290z
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.B
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r2, (int) r1)
            int r2 = r2.j()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r5.i()
            if (r4 == 0) goto L_0x0088
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r4.f2290z
            int r2 = r2.j()
        L_0x0088:
            if (r3 == 0) goto L_0x008f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r5.f2329j
            r5.a(r4, r3, r2)
        L_0x008f:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0, (int) r1)
            int r0 = r0.j()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r5.j()
            if (r2 == 0) goto L_0x00a3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r2.B
            int r0 = r0.j()
        L_0x00a3:
            if (r1 == 0) goto L_0x00ab
        L_0x00a5:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r5.f2330k
            int r0 = -r0
            r5.a(r2, r1, r0)
        L_0x00ab:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r5.f2329j
            r0.f2301a = r5
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r5.f2330k
            r0.f2301a = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.c.f():void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f2327h == 0 ? "horizontal : " : "vertical : ");
        String sb2 = sb.toString();
        Iterator<WidgetRun> it2 = this.f2354a.iterator();
        while (it2.hasNext()) {
            sb2 = ((sb2 + "<") + it2.next()) + "> ";
        }
        return sb2;
    }
}
