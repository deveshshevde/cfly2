package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.f;
import java.util.ArrayList;

public class h {
    public static n a(ConstraintWidget constraintWidget, int i2, ArrayList<n> arrayList, n nVar) {
        ConstraintAnchor constraintAnchor;
        int J;
        int i3 = i2 == 0 ? constraintWidget.f2260au : constraintWidget.f2261av;
        int i4 = 0;
        if (i3 != -1 && (nVar == null || i3 != nVar.f2382c)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                n nVar2 = arrayList.get(i5);
                if (nVar2.b() == i3) {
                    if (nVar != null) {
                        nVar.a(i2, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i5++;
                }
            }
        } else if (i3 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if ((constraintWidget instanceof androidx.constraintlayout.solver.widgets.h) && (J = ((androidx.constraintlayout.solver.widgets.h) constraintWidget).J(i2)) != -1) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    n nVar3 = arrayList.get(i6);
                    if (nVar3.b() == J) {
                        nVar = nVar3;
                        break;
                    }
                    i6++;
                }
            }
            if (nVar == null) {
                nVar = new n(i2);
            }
            arrayList.add(nVar);
        }
        if (nVar.a(constraintWidget)) {
            if (constraintWidget instanceof f) {
                f fVar = (f) constraintWidget;
                ConstraintAnchor b2 = fVar.b();
                if (fVar.c() == 0) {
                    i4 = 1;
                }
                b2.a(i4, arrayList, nVar);
            }
            int b3 = nVar.b();
            if (i2 == 0) {
                constraintWidget.f2260au = b3;
                constraintWidget.f2289y.a(i2, arrayList, nVar);
                constraintAnchor = constraintWidget.A;
            } else {
                constraintWidget.f2261av = b3;
                constraintWidget.f2290z.a(i2, arrayList, nVar);
                constraintWidget.C.a(i2, arrayList, nVar);
                constraintAnchor = constraintWidget.B;
            }
            constraintAnchor.a(i2, arrayList, nVar);
            constraintWidget.F.a(i2, arrayList, nVar);
        }
        return nVar;
    }

    private static n a(ArrayList<n> arrayList, int i2) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = arrayList.get(i3);
            if (i2 == nVar.f2382c) {
                return nVar;
            }
        }
        return null;
    }

    public static boolean a(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        return (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT));
    }

    /* JADX WARNING: Removed duplicated region for block: B:177:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x038e A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(androidx.constraintlayout.solver.widgets.d r16, androidx.constraintlayout.solver.widgets.analyzer.b.C0022b r17) {
        /*
            r0 = r16
            java.util.ArrayList r1 = r16.ac()
            int r2 = r1.size()
            r3 = 0
            r4 = 0
        L_0x000c:
            if (r4 >= r2) goto L_0x0033
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = r16.S()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = r16.T()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.S()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = r5.T()
            boolean r6 = a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r6, (androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r7, (androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r8, (androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r9)
            if (r6 != 0) goto L_0x002b
            return r3
        L_0x002b:
            boolean r5 = r5 instanceof androidx.constraintlayout.solver.widgets.e
            if (r5 == 0) goto L_0x0030
            return r3
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0033:
            androidx.constraintlayout.solver.e r4 = r0.f2420ay
            if (r4 == 0) goto L_0x0040
            androidx.constraintlayout.solver.e r4 = r0.f2420ay
            long r5 = r4.E
            r7 = 1
            long r5 = r5 + r7
            r4.E = r5
        L_0x0040:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0047:
            r12 = 1
            if (r5 >= r2) goto L_0x011d
            java.lang.Object r13 = r1.get(r5)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r13 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r13
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r14 = r16.S()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r15 = r16.T()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r13.S()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r13.T()
            boolean r3 = a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r14, (androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r15, (androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r3, (androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r4)
            if (r3 != 0) goto L_0x0070
            androidx.constraintlayout.solver.widgets.analyzer.b$a r3 = r0.aP
            int r4 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2341a
            r14 = r17
            androidx.constraintlayout.solver.widgets.d.a(r13, r14, r3, r4)
            goto L_0x0072
        L_0x0070:
            r14 = r17
        L_0x0072:
            boolean r3 = r13 instanceof androidx.constraintlayout.solver.widgets.f
            if (r3 == 0) goto L_0x0099
            r4 = r13
            androidx.constraintlayout.solver.widgets.f r4 = (androidx.constraintlayout.solver.widgets.f) r4
            int r15 = r4.c()
            if (r15 != 0) goto L_0x0089
            if (r8 != 0) goto L_0x0086
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0086:
            r8.add(r4)
        L_0x0089:
            int r15 = r4.c()
            if (r15 != r12) goto L_0x0099
            if (r6 != 0) goto L_0x0096
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0096:
            r6.add(r4)
        L_0x0099:
            boolean r4 = r13 instanceof androidx.constraintlayout.solver.widgets.h
            if (r4 == 0) goto L_0x00d9
            boolean r4 = r13 instanceof androidx.constraintlayout.solver.widgets.a
            if (r4 == 0) goto L_0x00c2
            r4 = r13
            androidx.constraintlayout.solver.widgets.a r4 = (androidx.constraintlayout.solver.widgets.a) r4
            int r15 = r4.h()
            if (r15 != 0) goto L_0x00b4
            if (r7 != 0) goto L_0x00b1
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00b1:
            r7.add(r4)
        L_0x00b4:
            int r15 = r4.h()
            if (r15 != r12) goto L_0x00d9
            if (r9 != 0) goto L_0x00d6
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            goto L_0x00d6
        L_0x00c2:
            r4 = r13
            androidx.constraintlayout.solver.widgets.h r4 = (androidx.constraintlayout.solver.widgets.h) r4
            if (r7 != 0) goto L_0x00cc
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x00cc:
            r7.add(r4)
            if (r9 != 0) goto L_0x00d6
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
        L_0x00d6:
            r9.add(r4)
        L_0x00d9:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r13.f2289y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2221c
            if (r4 != 0) goto L_0x00f5
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r13.A
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2221c
            if (r4 != 0) goto L_0x00f5
            if (r3 != 0) goto L_0x00f5
            boolean r4 = r13 instanceof androidx.constraintlayout.solver.widgets.a
            if (r4 != 0) goto L_0x00f5
            if (r10 != 0) goto L_0x00f2
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
        L_0x00f2:
            r10.add(r13)
        L_0x00f5:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r13.f2290z
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2221c
            if (r4 != 0) goto L_0x0118
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r13.B
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2221c
            if (r4 != 0) goto L_0x0118
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r13.C
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2221c
            if (r4 != 0) goto L_0x0118
            if (r3 != 0) goto L_0x0118
            boolean r3 = r13 instanceof androidx.constraintlayout.solver.widgets.a
            if (r3 != 0) goto L_0x0118
            if (r11 != 0) goto L_0x0115
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r11 = r3
        L_0x0115:
            r11.add(r13)
        L_0x0118:
            int r5 = r5 + 1
            r3 = 0
            goto L_0x0047
        L_0x011d:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r6 == 0) goto L_0x013a
            java.util.Iterator r4 = r6.iterator()
        L_0x0128:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x013a
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.f r5 = (androidx.constraintlayout.solver.widgets.f) r5
            r6 = 0
            r13 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r6, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r13)
            goto L_0x0128
        L_0x013a:
            r6 = 0
            r13 = 0
            if (r7 == 0) goto L_0x015b
            java.util.Iterator r4 = r7.iterator()
        L_0x0142:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x015b
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.h r5 = (androidx.constraintlayout.solver.widgets.h) r5
            androidx.constraintlayout.solver.widgets.analyzer.n r7 = a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r6, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r13)
            r5.a(r3, r6, r7)
            r7.a((java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3)
            r6 = 0
            r13 = 0
            goto L_0x0142
        L_0x015b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            java.util.HashSet r5 = r4.a()
            if (r5 == 0) goto L_0x0183
            java.util.HashSet r4 = r4.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x016f:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0183
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.f2219a
            r6 = 0
            r7 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r6, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r7)
            goto L_0x016f
        L_0x0183:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            java.util.HashSet r5 = r4.a()
            if (r5 == 0) goto L_0x01ab
            java.util.HashSet r4 = r4.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x0197:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01ab
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.f2219a
            r6 = 0
            r7 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r6, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r7)
            goto L_0x0197
        L_0x01ab:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            java.util.HashSet r5 = r4.a()
            if (r5 == 0) goto L_0x01d3
            java.util.HashSet r4 = r4.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x01bf:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01d3
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.f2219a
            r6 = 0
            r7 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r6, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r7)
            goto L_0x01bf
        L_0x01d3:
            r6 = 0
            r7 = 0
            if (r10 == 0) goto L_0x01eb
            java.util.Iterator r4 = r10.iterator()
        L_0x01db:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01eb
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r6, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r7)
            goto L_0x01db
        L_0x01eb:
            if (r8 == 0) goto L_0x0201
            java.util.Iterator r4 = r8.iterator()
        L_0x01f1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0201
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.f r5 = (androidx.constraintlayout.solver.widgets.f) r5
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r12, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r7)
            goto L_0x01f1
        L_0x0201:
            if (r9 == 0) goto L_0x021f
            java.util.Iterator r4 = r9.iterator()
        L_0x0207:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x021f
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.h r5 = (androidx.constraintlayout.solver.widgets.h) r5
            androidx.constraintlayout.solver.widgets.analyzer.n r6 = a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r12, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r7)
            r5.a(r3, r12, r6)
            r6.a((java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3)
            r7 = 0
            goto L_0x0207
        L_0x021f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            java.util.HashSet r5 = r4.a()
            if (r5 == 0) goto L_0x0246
            java.util.HashSet r4 = r4.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x0233:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0246
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.f2219a
            r6 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r12, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r6)
            goto L_0x0233
        L_0x0246:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            java.util.HashSet r5 = r4.a()
            if (r5 == 0) goto L_0x026d
            java.util.HashSet r4 = r4.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x025a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x026d
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.f2219a
            r6 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r12, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r6)
            goto L_0x025a
        L_0x026d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            java.util.HashSet r5 = r4.a()
            if (r5 == 0) goto L_0x0294
            java.util.HashSet r4 = r4.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x0281:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0294
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.f2219a
            r6 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r12, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r6)
            goto L_0x0281
        L_0x0294:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            java.util.HashSet r5 = r4.a()
            if (r5 == 0) goto L_0x02bb
            java.util.HashSet r4 = r4.a()
            java.util.Iterator r4 = r4.iterator()
        L_0x02a8:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02bb
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r5.f2219a
            r13 = 0
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r12, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r13)
            goto L_0x02a8
        L_0x02bb:
            r13 = 0
            if (r11 == 0) goto L_0x02d2
            java.util.Iterator r4 = r11.iterator()
        L_0x02c2:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x02d2
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5
            a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (int) r12, (java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (androidx.constraintlayout.solver.widgets.analyzer.n) r13)
            goto L_0x02c2
        L_0x02d2:
            r4 = 0
        L_0x02d3:
            if (r4 >= r2) goto L_0x02ff
            java.lang.Object r5 = r1.get(r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5
            boolean r6 = r5.t()
            if (r6 == 0) goto L_0x02fc
            int r6 = r5.f2260au
            androidx.constraintlayout.solver.widgets.analyzer.n r6 = a((java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (int) r6)
            int r5 = r5.f2261av
            androidx.constraintlayout.solver.widgets.analyzer.n r5 = a((java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.n>) r3, (int) r5)
            if (r6 == 0) goto L_0x02fc
            if (r5 == 0) goto L_0x02fc
            r7 = 0
            r6.a((int) r7, (androidx.constraintlayout.solver.widgets.analyzer.n) r5)
            r7 = 2
            r5.a((int) r7)
            r3.remove(r6)
        L_0x02fc:
            int r4 = r4 + 1
            goto L_0x02d3
        L_0x02ff:
            int r1 = r3.size()
            if (r1 > r12) goto L_0x0307
            r1 = 0
            return r1
        L_0x0307:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.S()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x0347
            java.util.Iterator r1 = r3.iterator()
            r2 = r13
            r6 = 0
        L_0x0315:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0339
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.solver.widgets.analyzer.n r4 = (androidx.constraintlayout.solver.widgets.analyzer.n) r4
            int r5 = r4.a()
            if (r5 != r12) goto L_0x0328
            goto L_0x0315
        L_0x0328:
            r5 = 0
            r4.a((boolean) r5)
            androidx.constraintlayout.solver.d r7 = r16.ab()
            int r7 = r4.a((androidx.constraintlayout.solver.d) r7, (int) r5)
            if (r7 <= r6) goto L_0x0315
            r2 = r4
            r6 = r7
            goto L_0x0315
        L_0x0339:
            if (r2 == 0) goto L_0x0347
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            r0.o(r6)
            r2.a((boolean) r12)
            goto L_0x0348
        L_0x0347:
            r2 = r13
        L_0x0348:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r16.T()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r4) goto L_0x038a
            java.util.Iterator r1 = r3.iterator()
            r3 = r13
            r6 = 0
        L_0x0356:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x037a
            java.lang.Object r4 = r1.next()
            androidx.constraintlayout.solver.widgets.analyzer.n r4 = (androidx.constraintlayout.solver.widgets.analyzer.n) r4
            int r5 = r4.a()
            if (r5 != 0) goto L_0x0369
            goto L_0x0356
        L_0x0369:
            r5 = 0
            r4.a((boolean) r5)
            androidx.constraintlayout.solver.d r7 = r16.ab()
            int r7 = r4.a((androidx.constraintlayout.solver.d) r7, (int) r12)
            if (r7 <= r6) goto L_0x0356
            r3 = r4
            r6 = r7
            goto L_0x0356
        L_0x037a:
            r5 = 0
            if (r3 == 0) goto L_0x038b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r0.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            r0.p(r6)
            r3.a((boolean) r12)
            r4 = r3
            goto L_0x038c
        L_0x038a:
            r5 = 0
        L_0x038b:
            r4 = r13
        L_0x038c:
            if (r2 != 0) goto L_0x0393
            if (r4 == 0) goto L_0x0391
            goto L_0x0393
        L_0x0391:
            r3 = 0
            goto L_0x0394
        L_0x0393:
            r3 = 1
        L_0x0394:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.h.a(androidx.constraintlayout.solver.widgets.d, androidx.constraintlayout.solver.widgets.analyzer.b$b):boolean");
    }
}
