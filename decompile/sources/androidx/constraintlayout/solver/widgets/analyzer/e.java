package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.b;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.f;
import androidx.constraintlayout.solver.widgets.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class e {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<l> f2356a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private d f2357b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2358c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2359d = true;

    /* renamed from: e  reason: collision with root package name */
    private d f2360e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<WidgetRun> f2361f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<l> f2362g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private b.C0022b f2363h = null;

    /* renamed from: i  reason: collision with root package name */
    private b.a f2364i = new b.a();

    public e(d dVar) {
        this.f2357b = dVar;
        this.f2360e = dVar;
    }

    private int a(d dVar, int i2) {
        int size = this.f2356a.size();
        long j2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j2 = Math.max(j2, this.f2356a.get(i3).a(dVar, i2));
        }
        return (int) j2;
    }

    private void a(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        this.f2364i.f2344d = dimensionBehaviour;
        this.f2364i.f2345e = dimensionBehaviour2;
        this.f2364i.f2346f = i2;
        this.f2364i.f2347g = i3;
        this.f2363h.a(constraintWidget, this.f2364i);
        constraintWidget.o(this.f2364i.f2348h);
        constraintWidget.p(this.f2364i.f2349i);
        constraintWidget.c(this.f2364i.f2351k);
        constraintWidget.s(this.f2364i.f2350j);
    }

    private void a(DependencyNode dependencyNode, int i2, int i3, DependencyNode dependencyNode2, ArrayList<l> arrayList, l lVar) {
        WidgetRun widgetRun = dependencyNode.f2304d;
        if (widgetRun.f2324e == null && widgetRun != this.f2357b.f2270f && widgetRun != this.f2357b.f2271g) {
            if (lVar == null) {
                lVar = new l(widgetRun, i3);
                arrayList.add(lVar);
            }
            widgetRun.f2324e = lVar;
            lVar.a(widgetRun);
            for (d next : widgetRun.f2329j.f2311k) {
                if (next instanceof DependencyNode) {
                    a((DependencyNode) next, i2, 0, dependencyNode2, arrayList, lVar);
                }
            }
            for (d next2 : widgetRun.f2330k.f2311k) {
                if (next2 instanceof DependencyNode) {
                    a((DependencyNode) next2, i2, 1, dependencyNode2, arrayList, lVar);
                }
            }
            if (i2 == 1 && (widgetRun instanceof m)) {
                for (d next3 : ((m) widgetRun).f2377a.f2311k) {
                    if (next3 instanceof DependencyNode) {
                        a((DependencyNode) next3, i2, 2, dependencyNode2, arrayList, lVar);
                    }
                }
            }
            for (DependencyNode next4 : widgetRun.f2329j.f2312l) {
                if (next4 == dependencyNode2) {
                    lVar.f2371c = true;
                }
                a(next4, i2, 0, dependencyNode2, arrayList, lVar);
            }
            for (DependencyNode next5 : widgetRun.f2330k.f2312l) {
                if (next5 == dependencyNode2) {
                    lVar.f2371c = true;
                }
                a(next5, i2, 1, dependencyNode2, arrayList, lVar);
            }
            if (i2 == 1 && (widgetRun instanceof m)) {
                for (DependencyNode a2 : ((m) widgetRun).f2377a.f2312l) {
                    a(a2, i2, 2, dependencyNode2, arrayList, lVar);
                }
            }
        }
    }

    private void a(WidgetRun widgetRun, int i2, ArrayList<l> arrayList) {
        for (d next : widgetRun.f2329j.f2311k) {
            if (next instanceof DependencyNode) {
                a((DependencyNode) next, i2, 0, widgetRun.f2330k, arrayList, (l) null);
            } else if (next instanceof WidgetRun) {
                a(((WidgetRun) next).f2329j, i2, 0, widgetRun.f2330k, arrayList, (l) null);
            }
        }
        for (d next2 : widgetRun.f2330k.f2311k) {
            if (next2 instanceof DependencyNode) {
                a((DependencyNode) next2, i2, 1, widgetRun.f2329j, arrayList, (l) null);
            } else if (next2 instanceof WidgetRun) {
                a(((WidgetRun) next2).f2330k, i2, 1, widgetRun.f2329j, arrayList, (l) null);
            }
        }
        if (i2 == 1) {
            for (d next3 : ((m) widgetRun).f2377a.f2311k) {
                if (next3 instanceof DependencyNode) {
                    a((DependencyNode) next3, i2, 2, (DependencyNode) null, arrayList, (l) null);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x015b, code lost:
        if (r1.G[1].f2221c != null) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01da, code lost:
        if (r1.G[3].f2221c != null) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007a, code lost:
        if (r1.f2277m == 0) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(androidx.constraintlayout.solver.widgets.d r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = r13.aR
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x029e
            java.lang.Object r1 = r0.next()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r1.I
            r3 = r3[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r1.I
            r9 = 1
            r4 = r4[r9]
            int r5 = r1.w()
            r6 = 8
            if (r5 != r6) goto L_0x0027
        L_0x0024:
            r1.f2266b = r9
            goto L_0x0006
        L_0x0027:
            float r5 = r1.f2281q
            r10 = 1065353216(0x3f800000, float:1.0)
            r6 = 2
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x0036
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x0036
            r1.f2276l = r6
        L_0x0036:
            float r5 = r1.f2284t
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x0042
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x0042
            r1.f2277m = r6
        L_0x0042:
            float r5 = r1.N()
            r7 = 0
            r8 = 3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x007d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x005b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 == r5) goto L_0x0058
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r4 != r5) goto L_0x005b
        L_0x0058:
            r1.f2276l = r8
            goto L_0x007d
        L_0x005b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x006a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 == r5) goto L_0x0067
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 != r5) goto L_0x006a
        L_0x0067:
            r1.f2277m = r8
            goto L_0x007d
        L_0x006a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x007d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r5) goto L_0x007d
            int r5 = r1.f2276l
            if (r5 != 0) goto L_0x0078
            r1.f2276l = r8
        L_0x0078:
            int r5 = r1.f2277m
            if (r5 != 0) goto L_0x007d
            goto L_0x0067
        L_0x007d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 != r5) goto L_0x0093
            int r5 = r1.f2276l
            if (r5 != r9) goto L_0x0093
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r1.f2289y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.f2221c
            if (r5 == 0) goto L_0x0091
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r1.A
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.f2221c
            if (r5 != 0) goto L_0x0093
        L_0x0091:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
        L_0x0093:
            r5 = r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r4 != r3) goto L_0x00ac
            int r3 = r1.f2277m
            if (r3 != r9) goto L_0x00ac
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.f2290z
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 == 0) goto L_0x00a8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.B
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 != 0) goto L_0x00ac
        L_0x00a8:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7 = r3
            goto L_0x00ad
        L_0x00ac:
            r7 = r4
        L_0x00ad:
            androidx.constraintlayout.solver.widgets.analyzer.k r3 = r1.f2270f
            r3.f2325f = r5
            androidx.constraintlayout.solver.widgets.analyzer.k r3 = r1.f2270f
            int r4 = r1.f2276l
            r3.f2322c = r4
            androidx.constraintlayout.solver.widgets.analyzer.m r3 = r1.f2271g
            r3.f2325f = r7
            androidx.constraintlayout.solver.widgets.analyzer.m r3 = r1.f2271g
            int r4 = r1.f2277m
            r3.f2322c = r4
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r5 == r3) goto L_0x00cd
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 == r3) goto L_0x00cd
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r3) goto L_0x00db
        L_0x00cd:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r7 == r3) goto L_0x0249
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 == r3) goto L_0x0249
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r3) goto L_0x00db
            goto L_0x0249
        L_0x00db:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r11 = 1056964608(0x3f000000, float:0.5)
            if (r5 != r3) goto L_0x0163
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 == r3) goto L_0x00e9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r7 != r3) goto L_0x0163
        L_0x00e9:
            int r3 = r1.f2276l
            if (r3 != r8) goto L_0x010d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r7 != r2) goto L_0x00fc
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 0
            r3 = r12
            r4 = r1
            r3.a(r4, r5, r6, r7, r8)
        L_0x00fc:
            int r8 = r1.B()
            float r2 = (float) r8
            float r3 = r1.M
            float r2 = r2 * r3
            float r2 = r2 + r11
            int r6 = (int) r2
        L_0x0107:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
        L_0x0109:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            goto L_0x0281
        L_0x010d:
            int r3 = r1.f2276l
            if (r3 != r9) goto L_0x0126
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6 = 0
            r8 = 0
            r3 = r12
            r4 = r1
            r3.a(r4, r5, r6, r7, r8)
            androidx.constraintlayout.solver.widgets.analyzer.k r2 = r1.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r2.f2326g
            int r1 = r1.A()
        L_0x0122:
            r2.f2365m = r1
            goto L_0x0006
        L_0x0126:
            int r3 = r1.f2276l
            if (r3 != r6) goto L_0x014d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r13.I
            r3 = r3[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 == r4) goto L_0x013a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r13.I
            r3 = r3[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r3 != r4) goto L_0x0163
        L_0x013a:
            float r2 = r1.f2281q
            int r3 = r13.A()
            float r3 = (float) r3
            float r2 = r2 * r3
            float r2 = r2 + r11
            int r6 = (int) r2
            int r8 = r1.B()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            goto L_0x0281
        L_0x014d:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r1.G
            r3 = r3[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 == 0) goto L_0x015d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r1.G
            r3 = r3[r9]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 != 0) goto L_0x0163
        L_0x015d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6 = 0
            r8 = 0
            goto L_0x0281
        L_0x0163:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r3) goto L_0x01dd
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 == r3) goto L_0x016f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r5 != r3) goto L_0x01dd
        L_0x016f:
            int r3 = r1.f2277m
            if (r3 != r8) goto L_0x0198
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r5 != r2) goto L_0x0182
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 0
            r3 = r12
            r4 = r1
            r3.a(r4, r5, r6, r7, r8)
        L_0x0182:
            int r6 = r1.A()
            float r2 = r1.M
            int r3 = r1.O()
            r4 = -1
            if (r3 != r4) goto L_0x0191
            float r2 = r10 / r2
        L_0x0191:
            float r3 = (float) r6
        L_0x0192:
            float r3 = r3 * r2
            float r3 = r3 + r11
            int r8 = (int) r3
            goto L_0x0107
        L_0x0198:
            int r3 = r1.f2277m
            if (r3 != r9) goto L_0x01a7
            r6 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 0
            r3 = r12
            r4 = r1
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x023f
        L_0x01a7:
            int r3 = r1.f2277m
            if (r3 != r6) goto L_0x01cc
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r13.I
            r3 = r3[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 == r4) goto L_0x01bb
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r13.I
            r3 = r3[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r3 != r4) goto L_0x01dd
        L_0x01bb:
            float r2 = r1.f2284t
            int r6 = r1.A()
            int r3 = r13.B()
            float r3 = (float) r3
            float r2 = r2 * r3
            float r2 = r2 + r11
            int r8 = (int) r2
            goto L_0x0109
        L_0x01cc:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r1.G
            r3 = r3[r6]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 == 0) goto L_0x015d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r3 = r1.G
            r3 = r3[r8]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2221c
            if (r3 != 0) goto L_0x01dd
            goto L_0x015d
        L_0x01dd:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r3) goto L_0x0006
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r3) goto L_0x0006
            int r3 = r1.f2276l
            if (r3 == r9) goto L_0x022a
            int r3 = r1.f2277m
            if (r3 != r9) goto L_0x01ee
            goto L_0x022a
        L_0x01ee:
            int r3 = r1.f2277m
            if (r3 != r6) goto L_0x0006
            int r3 = r1.f2276l
            if (r3 != r6) goto L_0x0006
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r13.I
            r3 = r3[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r3 == r4) goto L_0x0206
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r13.I
            r2 = r3[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r2 != r3) goto L_0x0006
        L_0x0206:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.I
            r2 = r2[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r2 == r3) goto L_0x0216
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r13.I
            r2 = r2[r9]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r2 != r3) goto L_0x0006
        L_0x0216:
            float r2 = r1.f2281q
            float r3 = r1.f2284t
            int r4 = r13.A()
            float r4 = (float) r4
            float r2 = r2 * r4
            float r2 = r2 + r11
            int r6 = (int) r2
            int r2 = r13.B()
            float r2 = (float) r2
            goto L_0x0192
        L_0x022a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r6 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r8 = 0
            r3 = r12
            r4 = r1
            r3.a(r4, r5, r6, r7, r8)
            androidx.constraintlayout.solver.widgets.analyzer.k r2 = r1.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r2.f2326g
            int r3 = r1.A()
            r2.f2365m = r3
        L_0x023f:
            androidx.constraintlayout.solver.widgets.analyzer.m r2 = r1.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r2.f2326g
            int r1 = r1.B()
            goto L_0x0122
        L_0x0249:
            int r2 = r1.A()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r5 != r3) goto L_0x0264
            int r2 = r13.A()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.f2289y
            int r3 = r3.f2222d
            int r2 = r2 - r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.A
            int r3 = r3.f2222d
            int r2 = r2 - r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r6 = r2
            r5 = r3
            goto L_0x0265
        L_0x0264:
            r6 = r2
        L_0x0265:
            int r2 = r1.B()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r7 != r3) goto L_0x0280
            int r2 = r13.B()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.f2290z
            int r3 = r3.f2222d
            int r2 = r2 - r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r1.B
            int r3 = r3.f2222d
            int r2 = r2 - r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r8 = r2
            r7 = r3
            goto L_0x0281
        L_0x0280:
            r8 = r2
        L_0x0281:
            r3 = r12
            r4 = r1
            r3.a(r4, r5, r6, r7, r8)
            androidx.constraintlayout.solver.widgets.analyzer.k r2 = r1.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r2.f2326g
            int r3 = r1.A()
            r2.a(r3)
            androidx.constraintlayout.solver.widgets.analyzer.m r2 = r1.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r2.f2326g
            int r3 = r1.B()
            r2.a(r3)
            goto L_0x0024
        L_0x029e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.e.a(androidx.constraintlayout.solver.widgets.d):boolean");
    }

    public void a() {
        f fVar;
        int A;
        f fVar2;
        int A2;
        Iterator it2 = this.f2357b.aR.iterator();
        while (it2.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it2.next();
            if (!constraintWidget.f2266b) {
                boolean z2 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.I[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.I[1];
                int i2 = constraintWidget.f2276l;
                int i3 = constraintWidget.f2277m;
                boolean z3 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i2 == 1);
                if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i3 == 1)) {
                    z2 = true;
                }
                boolean z4 = constraintWidget.f2270f.f2326g.f2310j;
                boolean z5 = constraintWidget.f2271g.f2326g.f2310j;
                if (!z4 || !z5) {
                    if (!z4 || !z2) {
                        if (z5 && z3) {
                            a(constraintWidget, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.f2270f.f2326g.f2307g, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.f2271g.f2326g.f2307g);
                            if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                fVar2 = constraintWidget.f2270f.f2326g;
                                A2 = constraintWidget.A();
                            } else {
                                fVar = constraintWidget.f2270f.f2326g;
                                A = constraintWidget.A();
                                fVar.a(A);
                            }
                        }
                        if (constraintWidget.f2266b && constraintWidget.f2271g.f2378b != null) {
                            constraintWidget.f2271g.f2378b.a(constraintWidget.L());
                        }
                    } else {
                        a(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.f2270f.f2326g.f2307g, ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, constraintWidget.f2271g.f2326g.f2307g);
                        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            fVar2 = constraintWidget.f2271g.f2326g;
                            A2 = constraintWidget.B();
                        } else {
                            fVar = constraintWidget.f2271g.f2326g;
                            A = constraintWidget.B();
                            fVar.a(A);
                        }
                    }
                    fVar2.f2365m = A2;
                    constraintWidget.f2271g.f2378b.a(constraintWidget.L());
                } else {
                    a(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.f2270f.f2326g.f2307g, ConstraintWidget.DimensionBehaviour.FIXED, constraintWidget.f2271g.f2326g.f2307g);
                }
                constraintWidget.f2266b = true;
                constraintWidget.f2271g.f2378b.a(constraintWidget.L());
            }
        }
    }

    public void a(b.C0022b bVar) {
        this.f2363h = bVar;
    }

    public void a(ArrayList<WidgetRun> arrayList) {
        Object jVar;
        arrayList.clear();
        this.f2360e.f2270f.c();
        this.f2360e.f2271g.c();
        arrayList.add(this.f2360e.f2270f);
        arrayList.add(this.f2360e.f2271g);
        Iterator it2 = this.f2360e.aR.iterator();
        HashSet hashSet = null;
        while (it2.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it2.next();
            if (constraintWidget instanceof f) {
                jVar = new i(constraintWidget);
            } else {
                if (constraintWidget.U()) {
                    if (constraintWidget.f2268d == null) {
                        constraintWidget.f2268d = new c(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f2268d);
                } else {
                    arrayList.add(constraintWidget.f2270f);
                }
                if (constraintWidget.V()) {
                    if (constraintWidget.f2269e == null) {
                        constraintWidget.f2269e = new c(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f2269e);
                } else {
                    arrayList.add(constraintWidget.f2271g);
                }
                if (constraintWidget instanceof h) {
                    jVar = new j(constraintWidget);
                }
            }
            arrayList.add(jVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            it3.next().c();
        }
        Iterator<WidgetRun> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            WidgetRun next = it4.next();
            if (next.f2323d != this.f2360e) {
                next.f();
            }
        }
    }

    public boolean a(boolean z2) {
        boolean z3;
        boolean z4 = true;
        boolean z5 = z2 & true;
        if (this.f2358c || this.f2359d) {
            Iterator it2 = this.f2357b.aR.iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it2.next();
                constraintWidget.u();
                constraintWidget.f2266b = false;
                constraintWidget.f2270f.d();
                constraintWidget.f2271g.d();
            }
            this.f2357b.u();
            this.f2357b.f2266b = false;
            this.f2357b.f2270f.d();
            this.f2357b.f2271g.d();
            this.f2359d = false;
        }
        if (a(this.f2360e)) {
            return false;
        }
        this.f2357b.m(0);
        this.f2357b.n(0);
        ConstraintWidget.DimensionBehaviour v2 = this.f2357b.v(0);
        ConstraintWidget.DimensionBehaviour v3 = this.f2357b.v(1);
        if (this.f2358c) {
            d();
        }
        int y2 = this.f2357b.y();
        int z6 = this.f2357b.z();
        this.f2357b.f2270f.f2329j.a(y2);
        this.f2357b.f2271g.f2329j.a(z6);
        a();
        if (v2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || v3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            if (z5) {
                Iterator<WidgetRun> it3 = this.f2361f.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (!it3.next().a()) {
                            z5 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z5 && v2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f2357b.a(ConstraintWidget.DimensionBehaviour.FIXED);
                d dVar = this.f2357b;
                dVar.o(a(dVar, 0));
                this.f2357b.f2270f.f2326g.a(this.f2357b.A());
            }
            if (z5 && v3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f2357b.b(ConstraintWidget.DimensionBehaviour.FIXED);
                d dVar2 = this.f2357b;
                dVar2.p(a(dVar2, 1));
                this.f2357b.f2271g.f2326g.a(this.f2357b.B());
            }
        }
        if (this.f2357b.I[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.f2357b.I[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int A = this.f2357b.A() + y2;
            this.f2357b.f2270f.f2330k.a(A);
            this.f2357b.f2270f.f2326g.a(A - y2);
            a();
            if (this.f2357b.I[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.f2357b.I[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int B = this.f2357b.B() + z6;
                this.f2357b.f2271g.f2330k.a(B);
                this.f2357b.f2271g.f2326g.a(B - z6);
            }
            a();
            z3 = true;
        } else {
            z3 = false;
        }
        Iterator<WidgetRun> it4 = this.f2361f.iterator();
        while (it4.hasNext()) {
            WidgetRun next = it4.next();
            if (next.f2323d != this.f2357b || next.f2328i) {
                next.e();
            }
        }
        Iterator<WidgetRun> it5 = this.f2361f.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            WidgetRun next2 = it5.next();
            if ((z3 || next2.f2323d != this.f2357b) && (!next2.f2329j.f2310j || ((!next2.f2330k.f2310j && !(next2 instanceof i)) || (!next2.f2326g.f2310j && !(next2 instanceof c) && !(next2 instanceof i))))) {
                z4 = false;
            }
        }
        z4 = false;
        this.f2357b.a(v2);
        this.f2357b.b(v3);
        return z4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x014e A[EDGE_INSN: B:81:0x014e->B:65:0x014e ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(boolean r10, int r11) {
        /*
            r9 = this;
            r0 = 1
            r10 = r10 & r0
            androidx.constraintlayout.solver.widgets.d r1 = r9.f2357b
            r2 = 0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r1.v(r2)
            androidx.constraintlayout.solver.widgets.d r3 = r9.f2357b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r3.v(r0)
            androidx.constraintlayout.solver.widgets.d r4 = r9.f2357b
            int r4 = r4.y()
            androidx.constraintlayout.solver.widgets.d r5 = r9.f2357b
            int r5 = r5.z()
            if (r10 == 0) goto L_0x008c
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 == r6) goto L_0x0025
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r6) goto L_0x008c
        L_0x0025:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r6 = r9.f2361f
            java.util.Iterator r6 = r6.iterator()
        L_0x002b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0042
            java.lang.Object r7 = r6.next()
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r7 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r7
            int r8 = r7.f2327h
            if (r8 != r11) goto L_0x002b
            boolean r7 = r7.a()
            if (r7 != 0) goto L_0x002b
            r10 = 0
        L_0x0042:
            if (r11 != 0) goto L_0x0067
            if (r10 == 0) goto L_0x008c
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r10) goto L_0x008c
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r6)
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            int r6 = r9.a((androidx.constraintlayout.solver.widgets.d) r10, (int) r2)
            r10.o(r6)
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            androidx.constraintlayout.solver.widgets.analyzer.k r10 = r10.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r10.f2326g
            androidx.constraintlayout.solver.widgets.d r6 = r9.f2357b
            int r6 = r6.A()
            goto L_0x0089
        L_0x0067:
            if (r10 == 0) goto L_0x008c
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != r10) goto L_0x008c
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r10.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r6)
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            int r6 = r9.a((androidx.constraintlayout.solver.widgets.d) r10, (int) r0)
            r10.p(r6)
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            androidx.constraintlayout.solver.widgets.analyzer.m r10 = r10.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r10 = r10.f2326g
            androidx.constraintlayout.solver.widgets.d r6 = r9.f2357b
            int r6 = r6.B()
        L_0x0089:
            r10.a(r6)
        L_0x008c:
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r10.I
            if (r11 != 0) goto L_0x00bd
            r10 = r10[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r10 == r5) goto L_0x00a2
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r10.I
            r10 = r10[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r10 != r5) goto L_0x00ce
        L_0x00a2:
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            int r10 = r10.A()
            int r10 = r10 + r4
            androidx.constraintlayout.solver.widgets.d r5 = r9.f2357b
            androidx.constraintlayout.solver.widgets.analyzer.k r5 = r5.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r5 = r5.f2330k
            r5.a((int) r10)
            androidx.constraintlayout.solver.widgets.d r5 = r9.f2357b
            androidx.constraintlayout.solver.widgets.analyzer.k r5 = r5.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r5 = r5.f2326g
            int r10 = r10 - r4
            r5.a(r10)
            goto L_0x00ea
        L_0x00bd:
            r10 = r10[r0]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r10 == r4) goto L_0x00d0
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r10 = r10.I
            r10 = r10[r0]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r10 != r4) goto L_0x00ce
            goto L_0x00d0
        L_0x00ce:
            r10 = 0
            goto L_0x00eb
        L_0x00d0:
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            int r10 = r10.B()
            int r10 = r10 + r5
            androidx.constraintlayout.solver.widgets.d r4 = r9.f2357b
            androidx.constraintlayout.solver.widgets.analyzer.m r4 = r4.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r4 = r4.f2330k
            r4.a((int) r10)
            androidx.constraintlayout.solver.widgets.d r4 = r9.f2357b
            androidx.constraintlayout.solver.widgets.analyzer.m r4 = r4.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r4 = r4.f2326g
            int r10 = r10 - r5
            r4.a(r10)
        L_0x00ea:
            r10 = 1
        L_0x00eb:
            r9.a()
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r4 = r9.f2361f
            java.util.Iterator r4 = r4.iterator()
        L_0x00f4:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0114
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f2327h
            if (r6 == r11) goto L_0x0105
            goto L_0x00f4
        L_0x0105:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r5.f2323d
            androidx.constraintlayout.solver.widgets.d r7 = r9.f2357b
            if (r6 != r7) goto L_0x0110
            boolean r6 = r5.f2328i
            if (r6 != 0) goto L_0x0110
            goto L_0x00f4
        L_0x0110:
            r5.e()
            goto L_0x00f4
        L_0x0114:
            java.util.ArrayList<androidx.constraintlayout.solver.widgets.analyzer.WidgetRun> r4 = r9.f2361f
            java.util.Iterator r4 = r4.iterator()
        L_0x011a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x014e
            java.lang.Object r5 = r4.next()
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun r5 = (androidx.constraintlayout.solver.widgets.analyzer.WidgetRun) r5
            int r6 = r5.f2327h
            if (r6 == r11) goto L_0x012b
            goto L_0x011a
        L_0x012b:
            if (r10 != 0) goto L_0x0134
            androidx.constraintlayout.solver.widgets.ConstraintWidget r6 = r5.f2323d
            androidx.constraintlayout.solver.widgets.d r7 = r9.f2357b
            if (r6 != r7) goto L_0x0134
            goto L_0x011a
        L_0x0134:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r6 = r5.f2329j
            boolean r6 = r6.f2310j
            if (r6 != 0) goto L_0x013c
        L_0x013a:
            r0 = 0
            goto L_0x014e
        L_0x013c:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r6 = r5.f2330k
            boolean r6 = r6.f2310j
            if (r6 != 0) goto L_0x0143
            goto L_0x013a
        L_0x0143:
            boolean r6 = r5 instanceof androidx.constraintlayout.solver.widgets.analyzer.c
            if (r6 != 0) goto L_0x011a
            androidx.constraintlayout.solver.widgets.analyzer.f r5 = r5.f2326g
            boolean r5 = r5.f2310j
            if (r5 != 0) goto L_0x011a
            goto L_0x013a
        L_0x014e:
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            r10.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            androidx.constraintlayout.solver.widgets.d r10 = r9.f2357b
            r10.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.e.a(boolean, int):boolean");
    }

    public void b() {
        this.f2358c = true;
    }

    public boolean b(boolean z2) {
        if (this.f2358c) {
            Iterator it2 = this.f2357b.aR.iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it2.next();
                constraintWidget.u();
                constraintWidget.f2266b = false;
                constraintWidget.f2270f.f2326g.f2310j = false;
                constraintWidget.f2270f.f2328i = false;
                constraintWidget.f2270f.d();
                constraintWidget.f2271g.f2326g.f2310j = false;
                constraintWidget.f2271g.f2328i = false;
                constraintWidget.f2271g.d();
            }
            this.f2357b.u();
            this.f2357b.f2266b = false;
            this.f2357b.f2270f.f2326g.f2310j = false;
            this.f2357b.f2270f.f2328i = false;
            this.f2357b.f2270f.d();
            this.f2357b.f2271g.f2326g.f2310j = false;
            this.f2357b.f2271g.f2328i = false;
            this.f2357b.f2271g.d();
            d();
        }
        if (a(this.f2360e)) {
            return false;
        }
        this.f2357b.m(0);
        this.f2357b.n(0);
        this.f2357b.f2270f.f2329j.a(0);
        this.f2357b.f2271g.f2329j.a(0);
        return true;
    }

    public void c() {
        this.f2359d = true;
    }

    public void d() {
        a(this.f2361f);
        this.f2356a.clear();
        l.f2369a = 0;
        a(this.f2357b.f2270f, 0, this.f2356a);
        a(this.f2357b.f2271g, 1, this.f2356a);
        this.f2358c = false;
    }
}
