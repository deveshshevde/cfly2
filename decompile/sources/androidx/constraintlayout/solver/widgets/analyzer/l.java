package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.d;
import java.util.ArrayList;

class l {

    /* renamed from: a  reason: collision with root package name */
    public static int f2369a;

    /* renamed from: b  reason: collision with root package name */
    public int f2370b = 0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2371c = false;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f2372d = null;

    /* renamed from: e  reason: collision with root package name */
    WidgetRun f2373e = null;

    /* renamed from: f  reason: collision with root package name */
    ArrayList<WidgetRun> f2374f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    int f2375g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f2376h;

    public l(WidgetRun widgetRun, int i2) {
        int i3 = f2369a;
        this.f2375g = i3;
        f2369a = i3 + 1;
        this.f2372d = widgetRun;
        this.f2373e = widgetRun;
        this.f2376h = i2;
    }

    private long a(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.f2304d;
        if (widgetRun instanceof j) {
            return j2;
        }
        int size = dependencyNode.f2311k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = dependencyNode.f2311k.get(i2);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f2304d != widgetRun) {
                    j3 = Math.max(j3, a(dependencyNode2, ((long) dependencyNode2.f2306f) + j2));
                }
            }
        }
        if (dependencyNode != widgetRun.f2329j) {
            return j3;
        }
        long b2 = j2 + widgetRun.b();
        return Math.max(Math.max(j3, a(widgetRun.f2330k, b2)), b2 - ((long) widgetRun.f2330k.f2306f));
    }

    private long b(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.f2304d;
        if (widgetRun instanceof j) {
            return j2;
        }
        int size = dependencyNode.f2311k.size();
        long j3 = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = dependencyNode.f2311k.get(i2);
            if (dVar instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dVar;
                if (dependencyNode2.f2304d != widgetRun) {
                    j3 = Math.min(j3, b(dependencyNode2, ((long) dependencyNode2.f2306f) + j2));
                }
            }
        }
        if (dependencyNode != widgetRun.f2330k) {
            return j3;
        }
        long b2 = j2 - widgetRun.b();
        return Math.min(Math.min(j3, b(widgetRun.f2329j, b2)), b2 - ((long) widgetRun.f2329j.f2306f));
    }

    public long a(d dVar, int i2) {
        long j2;
        long j3;
        long j4;
        WidgetRun widgetRun = this.f2372d;
        long j5 = 0;
        if (widgetRun instanceof c) {
            if (((c) widgetRun).f2327h != i2) {
                return 0;
            }
        } else if (i2 == 0) {
            if (!(widgetRun instanceof k)) {
                return 0;
            }
        } else if (!(widgetRun instanceof m)) {
            return 0;
        }
        DependencyNode dependencyNode = i2 == 0 ? dVar.f2270f.f2329j : dVar.f2271g.f2329j;
        DependencyNode dependencyNode2 = i2 == 0 ? dVar.f2270f.f2330k : dVar.f2271g.f2330k;
        boolean contains = this.f2372d.f2329j.f2312l.contains(dependencyNode);
        boolean contains2 = this.f2372d.f2330k.f2312l.contains(dependencyNode2);
        long b2 = this.f2372d.b();
        if (!contains || !contains2) {
            if (contains) {
                j4 = a(this.f2372d.f2329j, (long) this.f2372d.f2329j.f2306f);
                j3 = ((long) this.f2372d.f2329j.f2306f) + b2;
            } else if (contains2) {
                long b3 = b(this.f2372d.f2330k, (long) this.f2372d.f2330k.f2306f);
                j3 = ((long) (-this.f2372d.f2330k.f2306f)) + b2;
                j4 = -b3;
            } else {
                j2 = ((long) this.f2372d.f2329j.f2306f) + this.f2372d.b();
            }
            return Math.max(j4, j3);
        }
        long a2 = a(this.f2372d.f2329j, 0);
        long b4 = b(this.f2372d.f2330k, 0);
        long j6 = a2 - b2;
        if (j6 >= ((long) (-this.f2372d.f2330k.f2306f))) {
            j6 += (long) this.f2372d.f2330k.f2306f;
        }
        long j7 = ((-b4) - b2) - ((long) this.f2372d.f2329j.f2306f);
        if (j7 >= ((long) this.f2372d.f2329j.f2306f)) {
            j7 -= (long) this.f2372d.f2329j.f2306f;
        }
        float l2 = this.f2372d.f2323d.l(i2);
        if (l2 > 0.0f) {
            j5 = (long) ((((float) j7) / l2) + (((float) j6) / (1.0f - l2)));
        }
        float f2 = (float) j5;
        j2 = ((long) this.f2372d.f2329j.f2306f) + ((long) ((f2 * l2) + 0.5f)) + b2 + ((long) ((f2 * (1.0f - l2)) + 0.5f));
        return j2 - ((long) this.f2372d.f2330k.f2306f);
    }

    public void a(WidgetRun widgetRun) {
        this.f2374f.add(widgetRun);
        this.f2373e = widgetRun;
    }
}
