package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.solver.widgets.g;
import java.util.List;

public class k extends WidgetRun {

    /* renamed from: a  reason: collision with root package name */
    private static int[] f2367a = new int[2];

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.k$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2368a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2368a = r0
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2368a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2368a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.k.AnonymousClass1.<clinit>():void");
        }
    }

    public k(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f2329j.f2305e = DependencyNode.Type.LEFT;
        this.f2330k.f2305e = DependencyNode.Type.RIGHT;
        this.f2327h = 0;
    }

    private void a(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 == -1) {
            int i9 = (int) ((((float) i8) * f2) + 0.5f);
            int i10 = (int) ((((float) i7) / f2) + 0.5f);
            if (i9 <= i7 && i8 <= i8) {
                iArr[0] = i9;
                iArr[1] = i8;
            } else if (i7 <= i7 && i10 <= i8) {
                iArr[0] = i7;
                iArr[1] = i10;
            }
        } else if (i6 == 0) {
            iArr[0] = (int) ((((float) i8) * f2) + 0.5f);
            iArr[1] = i8;
        } else if (i6 == 1) {
            iArr[0] = i7;
            iArr[1] = (int) ((((float) i7) * f2) + 0.5f);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02bf, code lost:
        if (r14 != 1) goto L_0x031d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.solver.widgets.analyzer.d r17) {
        /*
            r16 = this;
            r8 = r16
            int[] r0 = androidx.constraintlayout.solver.widgets.analyzer.k.AnonymousClass1.f2368a
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r1 = r8.f2331l
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 3
            r9 = 1
            r10 = 0
            if (r0 == r9) goto L_0x002b
            if (r0 == r1) goto L_0x0025
            if (r0 == r2) goto L_0x0017
            goto L_0x0030
        L_0x0017:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2289y
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.A
            r3 = r17
            r8.a((androidx.constraintlayout.solver.widgets.analyzer.d) r3, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r1, (int) r10)
            return
        L_0x0025:
            r3 = r17
            r16.c(r17)
            goto L_0x0030
        L_0x002b:
            r3 = r17
            r16.b(r17)
        L_0x0030:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            boolean r0 = r0.f2310j
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r0 != 0) goto L_0x031d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x031d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            int r0 = r0.f2276l
            if (r0 == r1) goto L_0x02f9
            if (r0 == r2) goto L_0x0048
            goto L_0x031d
        L_0x0048:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            int r0 = r0.f2277m
            r1 = -1
            if (r0 == 0) goto L_0x008a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            int r0 = r0.f2277m
            if (r0 != r2) goto L_0x0056
            goto L_0x008a
        L_0x0056:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            int r0 = r0.O()
            if (r0 == r1) goto L_0x0077
            if (r0 == 0) goto L_0x0065
            if (r0 == r9) goto L_0x0077
            r0 = 0
            goto L_0x0318
        L_0x0065:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            int r0 = r0.f2307g
            float r0 = (float) r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.f2323d
            float r1 = r1.N()
            float r0 = r0 / r1
            goto L_0x0316
        L_0x0077:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            int r0 = r0.f2307g
            float r0 = (float) r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.f2323d
            float r1 = r1.N()
            float r0 = r0 * r1
            goto L_0x0316
        L_0x008a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r12 = r0.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r13 = r0.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2289y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x00a0
            r0 = 1
            goto L_0x00a1
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r8.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2290z
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 == 0) goto L_0x00ab
            r2 = 1
            goto L_0x00ac
        L_0x00ab:
            r2 = 0
        L_0x00ac:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r8.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.A
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 == 0) goto L_0x00b6
            r3 = 1
            goto L_0x00b7
        L_0x00b6:
            r3 = 0
        L_0x00b7:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.B
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2221c
            if (r4 == 0) goto L_0x00c1
            r4 = 1
            goto L_0x00c2
        L_0x00c1:
            r4 = 0
        L_0x00c2:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r8.f2323d
            int r14 = r5.O()
            if (r0 == 0) goto L_0x0215
            if (r2 == 0) goto L_0x0215
            if (r3 == 0) goto L_0x0215
            if (r4 == 0) goto L_0x0215
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            float r15 = r0.N()
            boolean r0 = r12.f2310j
            if (r0 == 0) goto L_0x013b
            boolean r0 = r13.f2310j
            if (r0 == 0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            boolean r0 = r0.f2303c
            if (r0 == 0) goto L_0x013a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            boolean r0 = r0.f2303c
            if (r0 != 0) goto L_0x00eb
            goto L_0x013a
        L_0x00eb:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2329j
            int r1 = r1.f2306f
            int r2 = r0 + r1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2330k
            int r1 = r1.f2306f
            int r3 = r0 - r1
            int r0 = r12.f2307g
            int r1 = r12.f2306f
            int r4 = r0 + r1
            int r0 = r13.f2307g
            int r1 = r13.f2306f
            int r5 = r0 - r1
            int[] r1 = f2367a
            r0 = r16
            r6 = r15
            r7 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            int[] r1 = f2367a
            r1 = r1[r10]
            r0.a(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            int[] r1 = f2367a
            r1 = r1[r9]
            r0.a(r1)
        L_0x013a:
            return
        L_0x013b:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x01a1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x01a1
            boolean r0 = r12.f2303c
            if (r0 == 0) goto L_0x01a0
            boolean r0 = r13.f2303c
            if (r0 != 0) goto L_0x0150
            goto L_0x01a0
        L_0x0150:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2329j
            int r1 = r1.f2306f
            int r2 = r0 + r1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2330k
            int r1 = r1.f2306f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r12.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            int r1 = r12.f2306f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r13.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            int r1 = r13.f2306f
            int r5 = r0 - r1
            int[] r1 = f2367a
            r0 = r16
            r6 = r15
            r7 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            int[] r1 = f2367a
            r1 = r1[r10]
            r0.a(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            int[] r1 = f2367a
            r1 = r1[r9]
            r0.a(r1)
            goto L_0x01a1
        L_0x01a0:
            return
        L_0x01a1:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            boolean r0 = r0.f2303c
            if (r0 == 0) goto L_0x0214
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            boolean r0 = r0.f2303c
            if (r0 == 0) goto L_0x0214
            boolean r0 = r12.f2303c
            if (r0 == 0) goto L_0x0214
            boolean r0 = r13.f2303c
            if (r0 != 0) goto L_0x01b6
            goto L_0x0214
        L_0x01b6:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2329j
            int r1 = r1.f2306f
            int r2 = r0 + r1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2330k
            int r1 = r1.f2306f
            int r3 = r0 - r1
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r12.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            int r1 = r12.f2306f
            int r4 = r0 + r1
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r13.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            int r0 = r0.f2307g
            int r1 = r13.f2306f
            int r5 = r0 - r1
            int[] r1 = f2367a
            r0 = r16
            r6 = r15
            r7 = r14
            r0.a(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            int[] r1 = f2367a
            r1 = r1[r10]
            r0.a(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            int[] r1 = f2367a
            r1 = r1[r9]
            goto L_0x02f4
        L_0x0214:
            return
        L_0x0215:
            if (r0 == 0) goto L_0x028e
            if (r3 == 0) goto L_0x028e
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            boolean r0 = r0.f2303c
            if (r0 == 0) goto L_0x028d
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            boolean r0 = r0.f2303c
            if (r0 != 0) goto L_0x0226
            goto L_0x028d
        L_0x0226:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            float r0 = r0.N()
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r8.f2329j
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r2 = r2.f2312l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r8.f2329j
            int r3 = r3.f2306f
            int r2 = r2 + r3
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r8.f2330k
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r3 = r3.f2312l
            java.lang.Object r3 = r3.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r3
            int r3 = r3.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r8.f2330k
            int r4 = r4.f2306f
            int r3 = r3 - r4
            if (r14 == r1) goto L_0x0269
            if (r14 == 0) goto L_0x0269
            if (r14 == r9) goto L_0x0256
            goto L_0x031d
        L_0x0256:
            int r3 = r3 - r2
            int r1 = r8.a((int) r3, (int) r10)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.a((int) r2, (int) r9)
            if (r2 == r3) goto L_0x027d
            float r1 = (float) r3
            float r1 = r1 * r0
            goto L_0x027b
        L_0x0269:
            int r3 = r3 - r2
            int r1 = r8.a((int) r3, (int) r10)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.a((int) r2, (int) r9)
            if (r2 == r3) goto L_0x027d
            float r1 = (float) r3
            float r1 = r1 / r0
        L_0x027b:
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x027d:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            r0.a(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            r0.a(r3)
            goto L_0x031d
        L_0x028d:
            return
        L_0x028e:
            if (r2 == 0) goto L_0x031d
            if (r4 == 0) goto L_0x031d
            boolean r0 = r12.f2303c
            if (r0 == 0) goto L_0x02f8
            boolean r0 = r13.f2303c
            if (r0 != 0) goto L_0x029b
            goto L_0x02f8
        L_0x029b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            float r0 = r0.N()
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r2 = r12.f2312l
            java.lang.Object r2 = r2.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r2
            int r2 = r2.f2307g
            int r3 = r12.f2306f
            int r2 = r2 + r3
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r3 = r13.f2312l
            java.lang.Object r3 = r3.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r3
            int r3 = r3.f2307g
            int r4 = r13.f2306f
            int r3 = r3 - r4
            if (r14 == r1) goto L_0x02d5
            if (r14 == 0) goto L_0x02c2
            if (r14 == r9) goto L_0x02d5
            goto L_0x031d
        L_0x02c2:
            int r3 = r3 - r2
            int r1 = r8.a((int) r3, (int) r9)
            float r2 = (float) r1
            float r2 = r2 * r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.a((int) r2, (int) r10)
            if (r2 == r3) goto L_0x02e9
            float r1 = (float) r3
            float r1 = r1 / r0
            goto L_0x02e7
        L_0x02d5:
            int r3 = r3 - r2
            int r1 = r8.a((int) r3, (int) r9)
            float r2 = (float) r1
            float r2 = r2 / r0
            float r2 = r2 + r11
            int r2 = (int) r2
            int r3 = r8.a((int) r2, (int) r10)
            if (r2 == r3) goto L_0x02e9
            float r1 = (float) r3
            float r1 = r1 * r0
        L_0x02e7:
            float r1 = r1 + r11
            int r1 = (int) r1
        L_0x02e9:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            r0.a(r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
        L_0x02f4:
            r0.a(r1)
            goto L_0x031d
        L_0x02f8:
            return
        L_0x02f9:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            if (r0 == 0) goto L_0x031d
            androidx.constraintlayout.solver.widgets.analyzer.k r1 = r0.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r1 = r1.f2326g
            boolean r1 = r1.f2310j
            if (r1 == 0) goto L_0x031d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.f2323d
            float r1 = r1.f2281q
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r0.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            int r0 = r0.f2307g
            float r0 = (float) r0
            float r0 = r0 * r1
        L_0x0316:
            float r0 = r0 + r11
            int r0 = (int) r0
        L_0x0318:
            androidx.constraintlayout.solver.widgets.analyzer.f r1 = r8.f2326g
            r1.a(r0)
        L_0x031d:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            boolean r0 = r0.f2303c
            if (r0 == 0) goto L_0x0449
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            boolean r0 = r0.f2303c
            if (r0 != 0) goto L_0x032b
            goto L_0x0449
        L_0x032b:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x033e
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x033e
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x033e
            return
        L_0x033e:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            boolean r0 = r0.f2310j
            if (r0 != 0) goto L_0x038c
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x038c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            int r0 = r0.f2276l
            if (r0 != 0) goto L_0x038c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r8.f2323d
            boolean r0 = r0.U()
            if (r0 != 0) goto L_0x038c
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2330k
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r1 = r1.f2312l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r8.f2329j
            int r2 = r2.f2306f
            int r0 = r0 + r2
            int r1 = r1.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r8.f2330k
            int r2 = r2.f2306f
            int r1 = r1 + r2
            int r2 = r1 - r0
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r8.f2329j
            r3.a((int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            r0.a((int) r1)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            r0.a(r2)
            return
        L_0x038c:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            boolean r0 = r0.f2310j
            if (r0 != 0) goto L_0x03f2
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r8.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x03f2
            int r0 = r8.f2322c
            if (r0 != r9) goto L_0x03f2
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03f2
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x03f2
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2330k
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r1 = r1.f2312l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1
            int r0 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r8.f2329j
            int r2 = r2.f2306f
            int r0 = r0 + r2
            int r1 = r1.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r8.f2330k
            int r2 = r2.f2306f
            int r1 = r1 + r2
            int r1 = r1 - r0
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            int r0 = r0.f2365m
            int r0 = java.lang.Math.min(r1, r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r8.f2323d
            int r1 = r1.f2280p
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r8.f2323d
            int r2 = r2.f2279o
            int r0 = java.lang.Math.max(r2, r0)
            if (r1 <= 0) goto L_0x03ed
            int r0 = java.lang.Math.min(r1, r0)
        L_0x03ed:
            androidx.constraintlayout.solver.widgets.analyzer.f r1 = r8.f2326g
            r1.a(r0)
        L_0x03f2:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            boolean r0 = r0.f2310j
            if (r0 != 0) goto L_0x03f9
            return
        L_0x03f9:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r0 = r0.f2312l
            java.lang.Object r0 = r0.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2330k
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.DependencyNode> r1 = r1.f2312l
            java.lang.Object r1 = r1.get(r10)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1
            int r2 = r0.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r8.f2329j
            int r3 = r3.f2306f
            int r2 = r2 + r3
            int r3 = r1.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r8.f2330k
            int r4 = r4.f2306f
            int r3 = r3 + r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r8.f2323d
            float r4 = r4.I()
            if (r0 != r1) goto L_0x0429
            int r2 = r0.f2307g
            int r3 = r1.f2307g
            r4 = 1056964608(0x3f000000, float:0.5)
        L_0x0429:
            int r3 = r3 - r2
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r8.f2326g
            int r0 = r0.f2307g
            int r3 = r3 - r0
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2329j
            float r1 = (float) r2
            float r1 = r1 + r11
            float r2 = (float) r3
            float r2 = r2 * r4
            float r1 = r1 + r2
            int r1 = (int) r1
            r0.a((int) r1)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r8.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r8.f2329j
            int r1 = r1.f2307g
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r8.f2326g
            int r2 = r2.f2307g
            int r1 = r1 + r2
            r0.a((int) r1)
        L_0x0449:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.k.a(androidx.constraintlayout.solver.widgets.analyzer.d):void");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f2325f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f2323d.f2276l == 0;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f2324e = null;
        this.f2329j.a();
        this.f2330k.a();
        this.f2326g.a();
        this.f2328i = false;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f2328i = false;
        this.f2329j.a();
        this.f2329j.f2310j = false;
        this.f2330k.a();
        this.f2330k.f2310j = false;
        this.f2326g.f2310j = false;
    }

    public void e() {
        if (this.f2329j.f2310j) {
            this.f2323d.m(this.f2329j.f2307g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ConstraintAnchor constraintAnchor;
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        DependencyNode dependencyNode3;
        Object obj;
        List list;
        int i2;
        DependencyNode dependencyNode4;
        DependencyNode dependencyNode5;
        ConstraintWidget v2;
        ConstraintWidget v3;
        if (this.f2323d.f2266b) {
            this.f2326g.a(this.f2323d.A());
        }
        if (!this.f2326g.f2310j) {
            this.f2325f = this.f2323d.S();
            if (this.f2325f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.f2325f == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((v3 = this.f2323d.v()) != null && v3.S() == ConstraintWidget.DimensionBehaviour.FIXED) || v3.S() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    int A = (v3.A() - this.f2323d.f2289y.j()) - this.f2323d.A.j();
                    a(this.f2329j, v3.f2270f.f2329j, this.f2323d.f2289y.j());
                    a(this.f2330k, v3.f2270f.f2330k, -this.f2323d.A.j());
                    this.f2326g.a(A);
                    return;
                } else if (this.f2325f == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f2326g.a(this.f2323d.A());
                }
            }
        } else if (this.f2325f == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (((v2 = this.f2323d.v()) != null && v2.S() == ConstraintWidget.DimensionBehaviour.FIXED) || v2.S() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            a(this.f2329j, v2.f2270f.f2329j, this.f2323d.f2289y.j());
            a(this.f2330k, v2.f2270f.f2330k, -this.f2323d.A.j());
            return;
        }
        int i3 = 1;
        if (!this.f2326g.f2310j || !this.f2323d.f2266b) {
            if (this.f2325f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int i4 = this.f2323d.f2276l;
                if (i4 == 2) {
                    ConstraintWidget v4 = this.f2323d.v();
                    if (v4 != null) {
                        f fVar = v4.f2271g.f2326g;
                        this.f2326g.f2312l.add(fVar);
                        fVar.f2311k.add(this.f2326g);
                        this.f2326g.f2302b = true;
                        this.f2326g.f2311k.add(this.f2329j);
                        list = this.f2326g.f2311k;
                        obj = this.f2330k;
                    }
                } else if (i4 == 3) {
                    if (this.f2323d.f2277m == 3) {
                        this.f2329j.f2301a = this;
                        this.f2330k.f2301a = this;
                        this.f2323d.f2271g.f2329j.f2301a = this;
                        this.f2323d.f2271g.f2330k.f2301a = this;
                        this.f2326g.f2301a = this;
                        if (this.f2323d.V()) {
                            this.f2326g.f2312l.add(this.f2323d.f2271g.f2326g);
                            this.f2323d.f2271g.f2326g.f2311k.add(this.f2326g);
                            this.f2323d.f2271g.f2326g.f2301a = this;
                            this.f2326g.f2312l.add(this.f2323d.f2271g.f2329j);
                            this.f2326g.f2312l.add(this.f2323d.f2271g.f2330k);
                            this.f2323d.f2271g.f2329j.f2311k.add(this.f2326g);
                            list = this.f2323d.f2271g.f2330k.f2311k;
                        } else if (this.f2323d.U()) {
                            this.f2323d.f2271g.f2326g.f2312l.add(this.f2326g);
                            list = this.f2326g.f2311k;
                            obj = this.f2323d.f2271g.f2326g;
                        } else {
                            list = this.f2323d.f2271g.f2326g.f2312l;
                        }
                    } else {
                        f fVar2 = this.f2323d.f2271g.f2326g;
                        this.f2326g.f2312l.add(fVar2);
                        fVar2.f2311k.add(this.f2326g);
                        this.f2323d.f2271g.f2329j.f2311k.add(this.f2326g);
                        this.f2323d.f2271g.f2330k.f2311k.add(this.f2326g);
                        this.f2326g.f2302b = true;
                        this.f2326g.f2311k.add(this.f2329j);
                        this.f2326g.f2311k.add(this.f2330k);
                        this.f2329j.f2312l.add(this.f2326g);
                        list = this.f2330k.f2312l;
                    }
                    obj = this.f2326g;
                }
                list.add(obj);
            }
            if (this.f2323d.G[0].f2221c == null || this.f2323d.G[1].f2221c == null) {
                if (this.f2323d.G[0].f2221c != null) {
                    DependencyNode a2 = a(this.f2323d.G[0]);
                    if (a2 != null) {
                        a(this.f2329j, a2, this.f2323d.G[0].j());
                    } else {
                        return;
                    }
                } else if (this.f2323d.G[1].f2221c != null) {
                    DependencyNode a3 = a(this.f2323d.G[1]);
                    if (a3 != null) {
                        a(this.f2330k, a3, -this.f2323d.G[1].j());
                        dependencyNode3 = this.f2329j;
                        dependencyNode2 = this.f2330k;
                        i3 = -1;
                        a(dependencyNode3, dependencyNode2, i3, this.f2326g);
                        return;
                    }
                    return;
                } else if (!(this.f2323d instanceof g) && this.f2323d.v() != null) {
                    a(this.f2329j, this.f2323d.v().f2270f.f2329j, this.f2323d.y());
                } else {
                    return;
                }
                dependencyNode3 = this.f2330k;
                dependencyNode2 = this.f2329j;
                a(dependencyNode3, dependencyNode2, i3, this.f2326g);
                return;
            } else if (this.f2323d.U()) {
                this.f2329j.f2306f = this.f2323d.G[0].j();
                dependencyNode = this.f2330k;
                constraintAnchor = this.f2323d.G[1];
            } else {
                DependencyNode a4 = a(this.f2323d.G[0]);
                DependencyNode a5 = a(this.f2323d.G[1]);
                a4.b(this);
                a5.b(this);
                this.f2331l = WidgetRun.RunType.CENTER;
                return;
            }
        } else if (this.f2323d.G[0].f2221c == null || this.f2323d.G[1].f2221c == null) {
            if (this.f2323d.G[0].f2221c != null) {
                DependencyNode a6 = a(this.f2323d.G[0]);
                if (a6 != null) {
                    a(this.f2329j, a6, this.f2323d.G[0].j());
                } else {
                    return;
                }
            } else if (this.f2323d.G[1].f2221c != null) {
                DependencyNode a7 = a(this.f2323d.G[1]);
                if (a7 != null) {
                    a(this.f2330k, a7, -this.f2323d.G[1].j());
                    dependencyNode5 = this.f2329j;
                    dependencyNode4 = this.f2330k;
                    i2 = -this.f2326g.f2307g;
                    a(dependencyNode5, dependencyNode4, i2);
                    return;
                }
                return;
            } else if (!(this.f2323d instanceof g) && this.f2323d.v() != null && this.f2323d.a(ConstraintAnchor.Type.CENTER).f2221c == null) {
                a(this.f2329j, this.f2323d.v().f2270f.f2329j, this.f2323d.y());
            } else {
                return;
            }
            dependencyNode5 = this.f2330k;
            dependencyNode4 = this.f2329j;
            i2 = this.f2326g.f2307g;
            a(dependencyNode5, dependencyNode4, i2);
            return;
        } else if (this.f2323d.U()) {
            this.f2329j.f2306f = this.f2323d.G[0].j();
            dependencyNode = this.f2330k;
            constraintAnchor = this.f2323d.G[1];
        } else {
            DependencyNode a8 = a(this.f2323d.G[0]);
            if (a8 != null) {
                a(this.f2329j, a8, this.f2323d.G[0].j());
            }
            DependencyNode a9 = a(this.f2323d.G[1]);
            if (a9 != null) {
                a(this.f2330k, a9, -this.f2323d.G[1].j());
            }
            this.f2329j.f2302b = true;
            this.f2330k.f2302b = true;
            return;
        }
        dependencyNode.f2306f = -constraintAnchor.j();
    }

    public String toString() {
        return "HorizontalRun " + this.f2323d.x();
    }
}
