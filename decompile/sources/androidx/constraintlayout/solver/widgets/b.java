package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.d;
import java.util.ArrayList;

public class b {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: androidx.constraintlayout.solver.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: androidx.constraintlayout.solver.widgets.ConstraintWidget} */
    /* JADX WARNING: type inference failed for: r4v11, types: [androidx.constraintlayout.solver.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r2.f2251al == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r2.f2252am == 2) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x038e  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x03a4  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03ab  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x03c5  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03da  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03dd  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0447  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0450  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x045c  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x04b7  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x04ec  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x0518  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x051e  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0523  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0527  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0538  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x053b  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x03c6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(androidx.constraintlayout.solver.widgets.d r36, androidx.constraintlayout.solver.d r37, int r38, int r39, androidx.constraintlayout.solver.widgets.c r40) {
        /*
            r0 = r36
            r9 = r37
            r1 = r40
            androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r1.f2395a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r1.f2397c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r12 = r1.f2396b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = r1.f2398d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r1.f2399e
            float r3 = r1.f2405k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.f2400f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r1.f2401g
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r0.I
            r4 = r4[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = 1
            if (r4 != r5) goto L_0x0021
            r4 = 1
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r38 != 0) goto L_0x0038
            int r8 = r2.f2251al
            if (r8 != 0) goto L_0x002b
            r8 = 1
            goto L_0x002c
        L_0x002b:
            r8 = 0
        L_0x002c:
            int r14 = r2.f2251al
            if (r14 != r7) goto L_0x0032
            r14 = 1
            goto L_0x0033
        L_0x0032:
            r14 = 0
        L_0x0033:
            int r15 = r2.f2251al
            if (r15 != r5) goto L_0x004c
            goto L_0x004a
        L_0x0038:
            int r8 = r2.f2252am
            if (r8 != 0) goto L_0x003e
            r8 = 1
            goto L_0x003f
        L_0x003e:
            r8 = 0
        L_0x003f:
            int r14 = r2.f2252am
            if (r14 != r7) goto L_0x0045
            r14 = 1
            goto L_0x0046
        L_0x0045:
            r14 = 0
        L_0x0046:
            int r15 = r2.f2252am
            if (r15 != r5) goto L_0x004c
        L_0x004a:
            r5 = 1
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            r7 = r10
            r15 = r14
            r14 = r8
            r8 = 0
        L_0x0051:
            r21 = 0
            if (r8 != 0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r7.G
            r6 = r6[r39]
            if (r5 == 0) goto L_0x005e
            r19 = 1
            goto L_0x0060
        L_0x005e:
            r19 = 4
        L_0x0060:
            int r22 = r6.j()
            r23 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r7.I
            r3 = r3[r38]
            r24 = r8
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r8) goto L_0x0078
            int[] r3 = r7.f2278n
            r3 = r3[r38]
            if (r3 != 0) goto L_0x0078
            r3 = 1
            goto L_0x0079
        L_0x0078:
            r3 = 0
        L_0x0079:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r6.f2221c
            if (r8 == 0) goto L_0x0087
            if (r7 == r10) goto L_0x0087
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r6.f2221c
            int r8 = r8.j()
            int r22 = r22 + r8
        L_0x0087:
            r8 = r22
            if (r5 == 0) goto L_0x0094
            if (r7 == r10) goto L_0x0094
            if (r7 == r12) goto L_0x0094
            r22 = r15
            r19 = 8
            goto L_0x0096
        L_0x0094:
            r22 = r15
        L_0x0096:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r6.f2221c
            if (r15 == 0) goto L_0x00cc
            if (r7 != r12) goto L_0x00ab
            androidx.constraintlayout.solver.SolverVariable r15 = r6.f2224f
            r25 = r14
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r6.f2221c
            androidx.constraintlayout.solver.SolverVariable r14 = r14.f2224f
            r26 = r2
            r2 = 6
            r9.a((androidx.constraintlayout.solver.SolverVariable) r15, (androidx.constraintlayout.solver.SolverVariable) r14, (int) r8, (int) r2)
            goto L_0x00ba
        L_0x00ab:
            r26 = r2
            r25 = r14
            androidx.constraintlayout.solver.SolverVariable r2 = r6.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r6.f2221c
            androidx.constraintlayout.solver.SolverVariable r14 = r14.f2224f
            r15 = 8
            r9.a((androidx.constraintlayout.solver.SolverVariable) r2, (androidx.constraintlayout.solver.SolverVariable) r14, (int) r8, (int) r15)
        L_0x00ba:
            if (r3 == 0) goto L_0x00c0
            if (r5 != 0) goto L_0x00c0
            r2 = 5
            goto L_0x00c2
        L_0x00c0:
            r2 = r19
        L_0x00c2:
            androidx.constraintlayout.solver.SolverVariable r3 = r6.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.f2221c
            androidx.constraintlayout.solver.SolverVariable r6 = r6.f2224f
            r9.c(r3, r6, r8, r2)
            goto L_0x00d0
        L_0x00cc:
            r26 = r2
            r25 = r14
        L_0x00d0:
            if (r4 == 0) goto L_0x0108
            int r2 = r7.w()
            r3 = 8
            if (r2 == r3) goto L_0x00f6
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r7.I
            r2 = r2[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 != r3) goto L_0x00f6
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.G
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r7.G
            r3 = r3[r39]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.f2224f
            r6 = 5
            r8 = 0
            r9.a((androidx.constraintlayout.solver.SolverVariable) r2, (androidx.constraintlayout.solver.SolverVariable) r3, (int) r8, (int) r6)
            goto L_0x00f7
        L_0x00f6:
            r8 = 0
        L_0x00f7:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.G
            r2 = r2[r39]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r0.G
            r3 = r3[r39]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.f2224f
            r6 = 8
            r9.a((androidx.constraintlayout.solver.SolverVariable) r2, (androidx.constraintlayout.solver.SolverVariable) r3, (int) r8, (int) r6)
        L_0x0108:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r7.G
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 == 0) goto L_0x0129
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r2.f2219a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.G
            r3 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 == 0) goto L_0x0129
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r2.G
            r3 = r3[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r3.f2219a
            if (r3 == r7) goto L_0x0127
            goto L_0x0129
        L_0x0127:
            r21 = r2
        L_0x0129:
            if (r21 == 0) goto L_0x0130
            r7 = r21
            r8 = r24
            goto L_0x0131
        L_0x0130:
            r8 = 1
        L_0x0131:
            r15 = r22
            r3 = r23
            r14 = r25
            r2 = r26
            goto L_0x0051
        L_0x013b:
            r26 = r2
            r23 = r3
            r25 = r14
            r22 = r15
            if (r13 == 0) goto L_0x01aa
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.G
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 == 0) goto L_0x01aa
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.G
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.I
            r6 = r6[r38]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x0163
            int[] r6 = r13.f2278n
            r6 = r6[r38]
            if (r6 != 0) goto L_0x0163
            r6 = 1
            goto L_0x0164
        L_0x0163:
            r6 = 0
        L_0x0164:
            if (r6 == 0) goto L_0x017e
            if (r5 != 0) goto L_0x017e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.f2221c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.f2219a
            if (r6 != r0) goto L_0x017e
            androidx.constraintlayout.solver.SolverVariable r6 = r2.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r2.f2221c
            androidx.constraintlayout.solver.SolverVariable r7 = r7.f2224f
            int r8 = r2.j()
            int r8 = -r8
            r14 = 5
            r9.c(r6, r7, r8, r14)
            goto L_0x0196
        L_0x017e:
            r14 = 5
            if (r5 == 0) goto L_0x0196
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r2.f2221c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r6.f2219a
            if (r6 != r0) goto L_0x0196
            androidx.constraintlayout.solver.SolverVariable r6 = r2.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r2.f2221c
            androidx.constraintlayout.solver.SolverVariable r7 = r7.f2224f
            int r8 = r2.j()
            int r8 = -r8
            r15 = 4
            r9.c(r6, r7, r8, r15)
        L_0x0196:
            androidx.constraintlayout.solver.SolverVariable r6 = r2.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.G
            r3 = r7[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            androidx.constraintlayout.solver.SolverVariable r3 = r3.f2224f
            int r2 = r2.j()
            int r2 = -r2
            r7 = 6
            r9.b((androidx.constraintlayout.solver.SolverVariable) r6, (androidx.constraintlayout.solver.SolverVariable) r3, (int) r2, (int) r7)
            goto L_0x01ab
        L_0x01aa:
            r14 = 5
        L_0x01ab:
            if (r4 == 0) goto L_0x01c8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            int r2 = r39 + 1
            r0 = r0[r2]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r11.G
            r3 = r3[r2]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.G
            r2 = r4[r2]
            int r2 = r2.j()
            r4 = 8
            r9.a((androidx.constraintlayout.solver.SolverVariable) r0, (androidx.constraintlayout.solver.SolverVariable) r3, (int) r2, (int) r4)
        L_0x01c8:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.ConstraintWidget> r0 = r1.f2402h
            if (r0 == 0) goto L_0x027f
            int r2 = r0.size()
            r3 = 1
            if (r2 <= r3) goto L_0x027f
            boolean r4 = r1.f2410p
            if (r4 == 0) goto L_0x01df
            boolean r4 = r1.f2412r
            if (r4 != 0) goto L_0x01df
            int r4 = r1.f2404j
            float r4 = (float) r4
            goto L_0x01e1
        L_0x01df:
            r4 = r23
        L_0x01e1:
            r6 = 0
            r7 = r21
            r8 = 0
            r28 = 0
        L_0x01e7:
            if (r8 >= r2) goto L_0x027f
            java.lang.Object r15 = r0.get(r8)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r15 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r15
            float[] r3 = r15.f2255ap
            r3 = r3[r38]
            int r18 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r18 >= 0) goto L_0x0215
            boolean r3 = r1.f2412r
            if (r3 == 0) goto L_0x0210
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.G
            int r18 = r39 + 1
            r3 = r3[r18]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r15.G
            r15 = r15[r39]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.f2224f
            r6 = 0
            r14 = 4
            r9.c(r3, r15, r6, r14)
            r14 = 0
            goto L_0x022e
        L_0x0210:
            r14 = 4
            r3 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            goto L_0x0216
        L_0x0215:
            r14 = 4
        L_0x0216:
            int r18 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r18 != 0) goto L_0x0233
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r15.G
            int r18 = r39 + 1
            r3 = r3[r18]
            androidx.constraintlayout.solver.SolverVariable r3 = r3.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r15 = r15.G
            r15 = r15[r39]
            androidx.constraintlayout.solver.SolverVariable r15 = r15.f2224f
            r6 = 8
            r14 = 0
            r9.c(r3, r15, r14, r6)
        L_0x022e:
            r23 = r0
            r17 = r2
            goto L_0x0274
        L_0x0233:
            r14 = 0
            if (r7 == 0) goto L_0x026d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r7.G
            r6 = r6[r39]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r7.G
            int r17 = r39 + 1
            r7 = r7[r17]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r14 = r15.G
            r14 = r14[r39]
            androidx.constraintlayout.solver.SolverVariable r14 = r14.f2224f
            r23 = r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r15.G
            r0 = r0[r17]
            androidx.constraintlayout.solver.SolverVariable r0 = r0.f2224f
            r17 = r2
            androidx.constraintlayout.solver.b r2 = r37.c()
            r27 = r2
            r29 = r4
            r30 = r3
            r31 = r6
            r32 = r7
            r33 = r14
            r34 = r0
            r27.a((float) r28, (float) r29, (float) r30, (androidx.constraintlayout.solver.SolverVariable) r31, (androidx.constraintlayout.solver.SolverVariable) r32, (androidx.constraintlayout.solver.SolverVariable) r33, (androidx.constraintlayout.solver.SolverVariable) r34)
            r9.a((androidx.constraintlayout.solver.b) r2)
            goto L_0x0271
        L_0x026d:
            r23 = r0
            r17 = r2
        L_0x0271:
            r28 = r3
            r7 = r15
        L_0x0274:
            int r8 = r8 + 1
            r2 = r17
            r0 = r23
            r3 = 1
            r6 = 0
            r14 = 5
            goto L_0x01e7
        L_0x027f:
            if (r12 == 0) goto L_0x02d6
            if (r12 == r13) goto L_0x0285
            if (r5 == 0) goto L_0x02d6
        L_0x0285:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r10.G
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r11.G
            int r2 = r39 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.f2221c
            if (r3 == 0) goto L_0x0299
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            androidx.constraintlayout.solver.SolverVariable r0 = r0.f2224f
            r3 = r0
            goto L_0x029b
        L_0x0299:
            r3 = r21
        L_0x029b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r1.f2221c
            if (r0 == 0) goto L_0x02a5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r1.f2221c
            androidx.constraintlayout.solver.SolverVariable r0 = r0.f2224f
            r5 = r0
            goto L_0x02a7
        L_0x02a5:
            r5 = r21
        L_0x02a7:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.G
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.G
            r1 = r1[r2]
            if (r3 == 0) goto L_0x04fd
            if (r5 == 0) goto L_0x04fd
            r2 = r26
            if (r38 != 0) goto L_0x02ba
            float r2 = r2.Y
            goto L_0x02bc
        L_0x02ba:
            float r2 = r2.Z
        L_0x02bc:
            r4 = r2
            int r6 = r0.j()
            int r7 = r1.j()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.f2224f
            androidx.constraintlayout.solver.SolverVariable r8 = r1.f2224f
            r10 = 7
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04fd
        L_0x02d6:
            if (r25 == 0) goto L_0x03ca
            if (r12 == 0) goto L_0x03ca
            int r0 = r1.f2404j
            if (r0 <= 0) goto L_0x02e7
            int r0 = r1.f2403i
            int r1 = r1.f2404j
            if (r0 != r1) goto L_0x02e7
            r16 = 1
            goto L_0x02e9
        L_0x02e7:
            r16 = 0
        L_0x02e9:
            r14 = r12
            r15 = r14
        L_0x02eb:
            if (r14 == 0) goto L_0x04fd
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.f2257ar
            r0 = r0[r38]
            r8 = r0
        L_0x02f2:
            if (r8 == 0) goto L_0x0301
            int r0 = r8.w()
            r6 = 8
            if (r0 != r6) goto L_0x0303
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r8.f2257ar
            r8 = r0[r38]
            goto L_0x02f2
        L_0x0301:
            r6 = 8
        L_0x0303:
            if (r8 != 0) goto L_0x030c
            if (r14 != r13) goto L_0x0308
            goto L_0x030c
        L_0x0308:
            r17 = r8
            goto L_0x03bd
        L_0x030c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.G
            r0 = r0[r39]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.f2221c
            if (r2 == 0) goto L_0x031b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.f2221c
            androidx.constraintlayout.solver.SolverVariable r2 = r2.f2224f
            goto L_0x031d
        L_0x031b:
            r2 = r21
        L_0x031d:
            if (r15 == r14) goto L_0x0328
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.G
            int r3 = r39 + 1
            r2 = r2[r3]
        L_0x0325:
            androidx.constraintlayout.solver.SolverVariable r2 = r2.f2224f
            goto L_0x033d
        L_0x0328:
            if (r14 != r12) goto L_0x033d
            if (r15 != r14) goto L_0x033d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.G
            r2 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 == 0) goto L_0x033b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r10.G
            r2 = r2[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            goto L_0x0325
        L_0x033b:
            r2 = r21
        L_0x033d:
            int r0 = r0.j()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r14.G
            int r4 = r39 + 1
            r3 = r3[r4]
            int r3 = r3.j()
            if (r8 == 0) goto L_0x035f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r8.G
            r5 = r5[r39]
            androidx.constraintlayout.solver.SolverVariable r7 = r5.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r6 = r14.G
            r6 = r6[r4]
            androidx.constraintlayout.solver.SolverVariable r6 = r6.f2224f
            r35 = r7
            r7 = r6
            r6 = r35
            goto L_0x0372
        L_0x035f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r11.G
            r5 = r5[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.f2221c
            if (r5 == 0) goto L_0x036a
            androidx.constraintlayout.solver.SolverVariable r6 = r5.f2224f
            goto L_0x036c
        L_0x036a:
            r6 = r21
        L_0x036c:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r14.G
            r7 = r7[r4]
            androidx.constraintlayout.solver.SolverVariable r7 = r7.f2224f
        L_0x0372:
            if (r5 == 0) goto L_0x0379
            int r5 = r5.j()
            int r3 = r3 + r5
        L_0x0379:
            if (r15 == 0) goto L_0x0384
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r15.G
            r5 = r5[r4]
            int r5 = r5.j()
            int r0 = r0 + r5
        L_0x0384:
            if (r1 == 0) goto L_0x0308
            if (r2 == 0) goto L_0x0308
            if (r6 == 0) goto L_0x0308
            if (r7 == 0) goto L_0x0308
            if (r14 != r12) goto L_0x0396
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.G
            r0 = r0[r39]
            int r0 = r0.j()
        L_0x0396:
            r5 = r0
            if (r14 != r13) goto L_0x03a4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r13.G
            r0 = r0[r4]
            int r0 = r0.j()
            r17 = r0
            goto L_0x03a6
        L_0x03a4:
            r17 = r3
        L_0x03a6:
            if (r16 == 0) goto L_0x03ab
            r18 = 8
            goto L_0x03ad
        L_0x03ab:
            r18 = 5
        L_0x03ad:
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r3 = r5
            r5 = r6
            r6 = r7
            r7 = r17
            r17 = r8
            r8 = r18
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x03bd:
            int r0 = r14.w()
            r8 = 8
            if (r0 == r8) goto L_0x03c6
            r15 = r14
        L_0x03c6:
            r14 = r17
            goto L_0x02eb
        L_0x03ca:
            r8 = 8
            if (r22 == 0) goto L_0x04fd
            if (r12 == 0) goto L_0x04fd
            int r0 = r1.f2404j
            if (r0 <= 0) goto L_0x03dd
            int r0 = r1.f2403i
            int r1 = r1.f2404j
            if (r0 != r1) goto L_0x03dd
            r16 = 1
            goto L_0x03df
        L_0x03dd:
            r16 = 0
        L_0x03df:
            r14 = r12
            r15 = r14
        L_0x03e1:
            if (r14 == 0) goto L_0x049f
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r14.f2257ar
            r0 = r0[r38]
        L_0x03e7:
            if (r0 == 0) goto L_0x03f4
            int r1 = r0.w()
            if (r1 != r8) goto L_0x03f4
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r0 = r0.f2257ar
            r0 = r0[r38]
            goto L_0x03e7
        L_0x03f4:
            if (r14 == r12) goto L_0x048a
            if (r14 == r13) goto L_0x048a
            if (r0 == 0) goto L_0x048a
            if (r0 != r13) goto L_0x03ff
            r7 = r21
            goto L_0x0400
        L_0x03ff:
            r7 = r0
        L_0x0400:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r14.G
            r0 = r0[r39]
            androidx.constraintlayout.solver.SolverVariable r1 = r0.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.f2221c
            if (r2 == 0) goto L_0x040e
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r0.f2221c
            androidx.constraintlayout.solver.SolverVariable r2 = r2.f2224f
        L_0x040e:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r15.G
            int r3 = r39 + 1
            r2 = r2[r3]
            androidx.constraintlayout.solver.SolverVariable r2 = r2.f2224f
            int r0 = r0.j()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r14.G
            r4 = r4[r3]
            int r4 = r4.j()
            if (r7 == 0) goto L_0x0434
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r7.G
            r5 = r5[r39]
            androidx.constraintlayout.solver.SolverVariable r6 = r5.f2224f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.f2221c
            if (r8 == 0) goto L_0x0431
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r8 = r5.f2221c
            goto L_0x0443
        L_0x0431:
            r8 = r21
            goto L_0x0445
        L_0x0434:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r5 = r13.G
            r5 = r5[r39]
            if (r5 == 0) goto L_0x043d
            androidx.constraintlayout.solver.SolverVariable r6 = r5.f2224f
            goto L_0x043f
        L_0x043d:
            r6 = r21
        L_0x043f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r8 = r14.G
            r8 = r8[r3]
        L_0x0443:
            androidx.constraintlayout.solver.SolverVariable r8 = r8.f2224f
        L_0x0445:
            if (r5 == 0) goto L_0x044c
            int r5 = r5.j()
            int r4 = r4 + r5
        L_0x044c:
            r17 = r4
            if (r15 == 0) goto L_0x0459
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r15.G
            r3 = r4[r3]
            int r3 = r3.j()
            int r0 = r0 + r3
        L_0x0459:
            r3 = r0
            if (r16 == 0) goto L_0x045f
            r18 = 8
            goto L_0x0461
        L_0x045f:
            r18 = 4
        L_0x0461:
            if (r1 == 0) goto L_0x047f
            if (r2 == 0) goto L_0x047f
            if (r6 == 0) goto L_0x047f
            if (r8 == 0) goto L_0x047f
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r37
            r5 = r6
            r19 = 4
            r6 = r8
            r20 = r7
            r7 = r17
            r17 = r15
            r15 = 8
            r8 = r18
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x0487
        L_0x047f:
            r20 = r7
            r17 = r15
            r15 = 8
            r19 = 4
        L_0x0487:
            r0 = r20
            goto L_0x0490
        L_0x048a:
            r17 = r15
            r15 = 8
            r19 = 4
        L_0x0490:
            int r1 = r14.w()
            if (r1 == r15) goto L_0x0497
            goto L_0x0499
        L_0x0497:
            r14 = r17
        L_0x0499:
            r15 = r14
            r8 = 8
            r14 = r0
            goto L_0x03e1
        L_0x049f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.G
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r10.G
            r1 = r1[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.f2221c
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r13.G
            int r3 = r39 + 1
            r10 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r11.G
            r2 = r2[r3]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r14 = r2.f2221c
            if (r1 == 0) goto L_0x04ec
            if (r12 == r13) goto L_0x04c6
            androidx.constraintlayout.solver.SolverVariable r2 = r0.f2224f
            androidx.constraintlayout.solver.SolverVariable r1 = r1.f2224f
            int r0 = r0.j()
            r15 = 5
            r9.c(r2, r1, r0, r15)
            goto L_0x04ed
        L_0x04c6:
            r15 = 5
            if (r14 == 0) goto L_0x04ed
            androidx.constraintlayout.solver.SolverVariable r2 = r0.f2224f
            androidx.constraintlayout.solver.SolverVariable r3 = r1.f2224f
            int r4 = r0.j()
            r5 = 1056964608(0x3f000000, float:0.5)
            androidx.constraintlayout.solver.SolverVariable r6 = r10.f2224f
            androidx.constraintlayout.solver.SolverVariable r7 = r14.f2224f
            int r8 = r10.j()
            r16 = 5
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r16
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
            goto L_0x04ed
        L_0x04ec:
            r15 = 5
        L_0x04ed:
            if (r14 == 0) goto L_0x04fd
            if (r12 == r13) goto L_0x04fd
            androidx.constraintlayout.solver.SolverVariable r0 = r10.f2224f
            androidx.constraintlayout.solver.SolverVariable r1 = r14.f2224f
            int r2 = r10.j()
            int r2 = -r2
            r9.c(r0, r1, r2, r15)
        L_0x04fd:
            if (r25 != 0) goto L_0x0501
            if (r22 == 0) goto L_0x0568
        L_0x0501:
            if (r12 == 0) goto L_0x0568
            if (r12 == r13) goto L_0x0568
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.G
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r13.G
            int r2 = r39 + 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.f2221c
            if (r3 == 0) goto L_0x0518
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r0.f2221c
            androidx.constraintlayout.solver.SolverVariable r3 = r3.f2224f
            goto L_0x051a
        L_0x0518:
            r3 = r21
        L_0x051a:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.f2221c
            if (r4 == 0) goto L_0x0523
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.f2221c
            androidx.constraintlayout.solver.SolverVariable r4 = r4.f2224f
            goto L_0x0525
        L_0x0523:
            r4 = r21
        L_0x0525:
            if (r11 == r13) goto L_0x0538
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r4 = r11.G
            r4 = r4[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r4.f2221c
            if (r5 == 0) goto L_0x0535
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2221c
            androidx.constraintlayout.solver.SolverVariable r4 = r4.f2224f
            r21 = r4
        L_0x0535:
            r5 = r21
            goto L_0x0539
        L_0x0538:
            r5 = r4
        L_0x0539:
            if (r12 != r13) goto L_0x0543
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r12.G
            r0 = r0[r39]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r12.G
            r1 = r1[r2]
        L_0x0543:
            if (r3 == 0) goto L_0x0568
            if (r5 == 0) goto L_0x0568
            r4 = 1056964608(0x3f000000, float:0.5)
            int r6 = r0.j()
            if (r13 != 0) goto L_0x0550
            goto L_0x0551
        L_0x0550:
            r11 = r13
        L_0x0551:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r7 = r11.G
            r2 = r7[r2]
            int r7 = r2.j()
            androidx.constraintlayout.solver.SolverVariable r2 = r0.f2224f
            androidx.constraintlayout.solver.SolverVariable r8 = r1.f2224f
            r10 = 5
            r0 = r37
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r8
            r8 = r10
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0568:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.b.a(androidx.constraintlayout.solver.widgets.d, androidx.constraintlayout.solver.d, int, int, androidx.constraintlayout.solver.widgets.c):void");
    }

    public static void a(d dVar, d dVar2, ArrayList<ConstraintWidget> arrayList, int i2) {
        c[] cVarArr;
        int i3;
        int i4;
        if (i2 == 0) {
            i4 = dVar.aE;
            cVarArr = dVar.aH;
            i3 = 0;
        } else {
            int i5 = dVar.aF;
            cVarArr = dVar.aG;
            i4 = i5;
            i3 = 2;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            c cVar = cVarArr[i6];
            cVar.a();
            if (arrayList == null || (arrayList != null && arrayList.contains(cVar.f2395a))) {
                a(dVar, dVar2, i2, i3, cVar);
            }
        }
    }
}
