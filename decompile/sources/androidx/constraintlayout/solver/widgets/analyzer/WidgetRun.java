package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public abstract class WidgetRun implements d {

    /* renamed from: c  reason: collision with root package name */
    public int f2322c;

    /* renamed from: d  reason: collision with root package name */
    ConstraintWidget f2323d;

    /* renamed from: e  reason: collision with root package name */
    l f2324e;

    /* renamed from: f  reason: collision with root package name */
    protected ConstraintWidget.DimensionBehaviour f2325f;

    /* renamed from: g  reason: collision with root package name */
    f f2326g = new f(this);

    /* renamed from: h  reason: collision with root package name */
    public int f2327h = 0;

    /* renamed from: i  reason: collision with root package name */
    boolean f2328i = false;

    /* renamed from: j  reason: collision with root package name */
    public DependencyNode f2329j = new DependencyNode(this);

    /* renamed from: k  reason: collision with root package name */
    public DependencyNode f2330k = new DependencyNode(this);

    /* renamed from: l  reason: collision with root package name */
    protected RunType f2331l = RunType.NONE;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2332a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2332a = r0
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2332a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2332a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2332a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f2332a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f2323d = constraintWidget;
    }

    private void b(int i2, int i3) {
        int i4;
        f fVar;
        int i5 = this.f2322c;
        if (i5 != 0) {
            if (i5 == 1) {
                int a2 = a(this.f2326g.f2365m, i2);
                fVar = this.f2326g;
                i4 = Math.min(a2, i3);
                fVar.a(i4);
            } else if (i5 == 2) {
                ConstraintWidget v2 = this.f2323d.v();
                if (v2 != null) {
                    WidgetRun widgetRun = i2 == 0 ? v2.f2270f : v2.f2271g;
                    if (widgetRun.f2326g.f2310j) {
                        ConstraintWidget constraintWidget = this.f2323d;
                        i3 = (int) ((((float) widgetRun.f2326g.f2307g) * (i2 == 0 ? constraintWidget.f2281q : constraintWidget.f2284t)) + 0.5f);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (i5 == 3) {
                if (this.f2323d.f2270f.f2325f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f2323d.f2270f.f2322c != 3 || this.f2323d.f2271g.f2325f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f2323d.f2271g.f2322c != 3) {
                    ConstraintWidget constraintWidget2 = this.f2323d;
                    WidgetRun widgetRun2 = i2 == 0 ? constraintWidget2.f2271g : constraintWidget2.f2270f;
                    if (widgetRun2.f2326g.f2310j) {
                        float N = this.f2323d.N();
                        this.f2326g.a(i2 == 1 ? (int) ((((float) widgetRun2.f2326g.f2307g) / N) + 0.5f) : (int) ((N * ((float) widgetRun2.f2326g.f2307g)) + 0.5f));
                        return;
                    }
                    return;
                }
                return;
            } else {
                return;
            }
        }
        fVar = this.f2326g;
        i4 = a(i3, i2);
        fVar.a(i4);
    }

    /* access modifiers changed from: protected */
    public final int a(int i2, int i3) {
        int i4;
        if (i3 == 0) {
            int i5 = this.f2323d.f2280p;
            i4 = Math.max(this.f2323d.f2279o, i2);
            if (i5 > 0) {
                i4 = Math.min(i5, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        } else {
            int i6 = this.f2323d.f2283s;
            int max = Math.max(this.f2323d.f2282r, i2);
            if (i6 > 0) {
                max = Math.min(i6, i2);
            }
            if (i4 == i2) {
                return i2;
            }
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode a(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f2221c == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.f2221c.f2219a;
        int i2 = AnonymousClass1.f2332a[constraintAnchor.f2221c.f2220b.ordinal()];
        if (i2 == 1) {
            return constraintWidget.f2270f.f2329j;
        }
        if (i2 == 2) {
            return constraintWidget.f2270f.f2330k;
        }
        if (i2 == 3) {
            return constraintWidget.f2271g.f2329j;
        }
        if (i2 == 4) {
            return constraintWidget.f2271g.f2377a;
        }
        if (i2 != 5) {
            return null;
        }
        return constraintWidget.f2271g.f2330k;
    }

    /* access modifiers changed from: protected */
    public final DependencyNode a(ConstraintAnchor constraintAnchor, int i2) {
        if (constraintAnchor.f2221c == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.f2221c.f2219a;
        WidgetRun widgetRun = i2 == 0 ? constraintWidget.f2270f : constraintWidget.f2271g;
        int i3 = AnonymousClass1.f2332a[constraintAnchor.f2221c.f2220b.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f2330k;
        }
        return widgetRun.f2329j;
    }

    /* access modifiers changed from: protected */
    public final void a(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2) {
        dependencyNode.f2312l.add(dependencyNode2);
        dependencyNode.f2306f = i2;
        dependencyNode2.f2311k.add(dependencyNode);
    }

    /* access modifiers changed from: protected */
    public final void a(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2, f fVar) {
        dependencyNode.f2312l.add(dependencyNode2);
        dependencyNode.f2312l.add(this.f2326g);
        dependencyNode.f2308h = i2;
        dependencyNode.f2309i = fVar;
        dependencyNode2.f2311k.add(dependencyNode);
        fVar.f2311k.add(dependencyNode);
    }

    public void a(d dVar) {
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        DependencyNode dependencyNode;
        DependencyNode a2 = a(constraintAnchor);
        DependencyNode a3 = a(constraintAnchor2);
        if (a2.f2310j && a3.f2310j) {
            int j2 = a2.f2307g + constraintAnchor.j();
            int j3 = a3.f2307g - constraintAnchor2.j();
            int i3 = j3 - j2;
            if (!this.f2326g.f2310j && this.f2325f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                b(i2, i3);
            }
            if (this.f2326g.f2310j) {
                if (this.f2326g.f2307g == i3) {
                    this.f2329j.a(j2);
                    dependencyNode = this.f2330k;
                } else {
                    ConstraintWidget constraintWidget = this.f2323d;
                    float I = i2 == 0 ? constraintWidget.I() : constraintWidget.J();
                    if (a2 == a3) {
                        j2 = a2.f2307g;
                        j3 = a3.f2307g;
                        I = 0.5f;
                    }
                    this.f2329j.a((int) (((float) j2) + 0.5f + (((float) ((j3 - j2) - this.f2326g.f2307g)) * I)));
                    dependencyNode = this.f2330k;
                    j3 = this.f2329j.f2307g + this.f2326g.f2307g;
                }
                dependencyNode.a(j3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a();

    public long b() {
        if (this.f2326g.f2310j) {
            return (long) this.f2326g.f2307g;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void b(d dVar) {
    }

    /* access modifiers changed from: package-private */
    public abstract void c();

    /* access modifiers changed from: protected */
    public void c(d dVar) {
    }

    /* access modifiers changed from: package-private */
    public abstract void d();

    /* access modifiers changed from: package-private */
    public abstract void e();

    /* access modifiers changed from: package-private */
    public abstract void f();

    public boolean g() {
        return this.f2328i;
    }
}
