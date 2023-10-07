package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;

public class m extends WidgetRun {

    /* renamed from: a  reason: collision with root package name */
    public DependencyNode f2377a = new DependencyNode(this);

    /* renamed from: b  reason: collision with root package name */
    f f2378b = null;

    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.m$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2379a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2379a = r0
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2379a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2379a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.m.AnonymousClass1.<clinit>():void");
        }
    }

    public m(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f2329j.f2305e = DependencyNode.Type.TOP;
        this.f2330k.f2305e = DependencyNode.Type.BOTTOM;
        this.f2377a.f2305e = DependencyNode.Type.BASELINE;
        this.f2327h = 1;
    }

    public void a(d dVar) {
        f fVar;
        int i2;
        float f2;
        int i3 = AnonymousClass1.f2379a[this.f2331l.ordinal()];
        if (i3 == 1) {
            b(dVar);
        } else if (i3 == 2) {
            c(dVar);
        } else if (i3 == 3) {
            a(dVar, this.f2323d.f2290z, this.f2323d.B, 1);
            return;
        }
        if (this.f2326g.f2303c && !this.f2326g.f2310j && this.f2325f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i4 = this.f2323d.f2277m;
            if (i4 == 2) {
                ConstraintWidget v2 = this.f2323d.v();
                if (v2 != null && v2.f2271g.f2326g.f2310j) {
                    f2 = ((float) v2.f2271g.f2326g.f2307g) * this.f2323d.f2284t;
                }
            } else if (i4 == 3 && this.f2323d.f2270f.f2326g.f2310j) {
                int O = this.f2323d.O();
                if (O != -1) {
                    if (O == 0) {
                        f2 = ((float) this.f2323d.f2270f.f2326g.f2307g) * this.f2323d.N();
                    } else if (O != 1) {
                        i2 = 0;
                        this.f2326g.a(i2);
                    }
                }
                f2 = ((float) this.f2323d.f2270f.f2326g.f2307g) / this.f2323d.N();
            }
            i2 = (int) (f2 + 0.5f);
            this.f2326g.a(i2);
        }
        if (this.f2329j.f2303c && this.f2330k.f2303c) {
            if (this.f2329j.f2310j && this.f2330k.f2310j && this.f2326g.f2310j) {
                return;
            }
            if (this.f2326g.f2310j || this.f2325f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f2323d.f2276l != 0 || this.f2323d.V()) {
                if (!this.f2326g.f2310j && this.f2325f == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f2322c == 1 && this.f2329j.f2312l.size() > 0 && this.f2330k.f2312l.size() > 0) {
                    int i5 = (this.f2330k.f2312l.get(0).f2307g + this.f2330k.f2306f) - (this.f2329j.f2312l.get(0).f2307g + this.f2329j.f2306f);
                    if (i5 < this.f2326g.f2365m) {
                        fVar = this.f2326g;
                    } else {
                        fVar = this.f2326g;
                        i5 = this.f2326g.f2365m;
                    }
                    fVar.a(i5);
                }
                if (this.f2326g.f2310j && this.f2329j.f2312l.size() > 0 && this.f2330k.f2312l.size() > 0) {
                    DependencyNode dependencyNode = this.f2329j.f2312l.get(0);
                    DependencyNode dependencyNode2 = this.f2330k.f2312l.get(0);
                    int i6 = dependencyNode.f2307g + this.f2329j.f2306f;
                    int i7 = dependencyNode2.f2307g + this.f2330k.f2306f;
                    float J = this.f2323d.J();
                    if (dependencyNode == dependencyNode2) {
                        i6 = dependencyNode.f2307g;
                        i7 = dependencyNode2.f2307g;
                        J = 0.5f;
                    }
                    this.f2329j.a((int) (((float) i6) + 0.5f + (((float) ((i7 - i6) - this.f2326g.f2307g)) * J)));
                    this.f2330k.a(this.f2329j.f2307g + this.f2326g.f2307g);
                    return;
                }
                return;
            }
            int i8 = this.f2329j.f2312l.get(0).f2307g + this.f2329j.f2306f;
            int i9 = this.f2330k.f2312l.get(0).f2307g + this.f2330k.f2306f;
            this.f2329j.a(i8);
            this.f2330k.a(i9);
            this.f2326g.a(i9 - i8);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f2325f != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f2323d.f2277m == 0;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f2324e = null;
        this.f2329j.a();
        this.f2330k.a();
        this.f2377a.a();
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
        this.f2377a.a();
        this.f2377a.f2310j = false;
        this.f2326g.f2310j = false;
    }

    public void e() {
        if (this.f2329j.f2310j) {
            this.f2323d.n(this.f2329j.f2307g);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0322, code lost:
        if (r7.f2323d.K() != false) goto L_0x0324;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0387, code lost:
        if (r7.f2323d.f2270f.f2325f == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L_0x0448;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03c1, code lost:
        if (r7.f2323d.K() != false) goto L_0x0324;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0446, code lost:
        if (r7.f2323d.f2270f.f2325f == androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L_0x0448;
     */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r7 = this;
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.f2266b
            if (r0 == 0) goto L_0x0011
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            int r1 = r1.B()
            r0.a(r1)
        L_0x0011:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            boolean r0 = r0.f2310j
            if (r0 != 0) goto L_0x009b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r0.T()
            r7.f2325f = r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x002e
            androidx.constraintlayout.solver.widgets.analyzer.a r0 = new androidx.constraintlayout.solver.widgets.analyzer.a
            r0.<init>(r7)
            r7.f2378b = r0
        L_0x002e:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 == r1) goto L_0x00d5
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r0 != r1) goto L_0x0089
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            if (r0 == 0) goto L_0x0089
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r0.T()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r1 != r2) goto L_0x0089
            int r1 = r0.B()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2290z
            int r2 = r2.j()
            int r1 = r1 - r2
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.B
            int r2 = r2.j()
            int r1 = r1 - r2
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.m r3 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r3 = r3.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.f2290z
            int r4 = r4.j()
            r7.a(r2, r3, r4)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.B
            int r3 = r3.j()
            int r3 = -r3
            r7.a(r2, r0, r3)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            r0.a(r1)
            return
        L_0x0089:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r0 != r1) goto L_0x00d5
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            int r1 = r1.B()
            r0.a(r1)
            goto L_0x00d5
        L_0x009b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
            if (r0 != r1) goto L_0x00d5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            if (r0 == 0) goto L_0x00d5
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = r0.T()
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            if (r1 != r2) goto L_0x00d5
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.m r2 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r2.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.f2290z
            int r3 = r3.j()
            r7.a(r1, r2, r3)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.B
            int r2 = r2.j()
            int r2 = -r2
            r7.a(r1, r0, r2)
            return
        L_0x00d5:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            boolean r0 = r0.f2310j
            r1 = 0
            r2 = 4
            r3 = 1
            r4 = 2
            r5 = 3
            if (r0 == 0) goto L_0x0262
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.f2266b
            if (r0 == 0) goto L_0x0262
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x0176
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x0176
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.V()
            if (r0 == 0) goto L_0x0120
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r1.G
            r1 = r1[r4]
            int r1 = r1.j()
            r0.f2306f = r1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r1.G
            r1 = r1[r5]
            int r1 = r1.j()
            int r1 = -r1
            r0.f2306f = r1
            goto L_0x015f
        L_0x0120:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.G
            r2 = r2[r4]
            int r2 = r2.j()
            r7.a(r1, r0, r2)
        L_0x013b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x0157
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.G
            r2 = r2[r5]
            int r2 = r2.j()
            int r2 = -r2
            r7.a(r1, r0, r2)
        L_0x0157:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2329j
            r0.f2302b = r3
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            r0.f2302b = r3
        L_0x015f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0474
        L_0x0167:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2377a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            int r2 = r2.L()
        L_0x0171:
            r7.a(r0, r1, r2)
            goto L_0x0474
        L_0x0176:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x01af
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x0474
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.G
            r2 = r2[r4]
            int r2 = r2.j()
            r7.a(r1, r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            int r2 = r2.f2307g
            r7.a(r0, r1, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0474
            goto L_0x0167
        L_0x01af:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x01eb
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x01e1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.G
            r2 = r2[r5]
            int r2 = r2.j()
            int r2 = -r2
            r7.a(r1, r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            int r2 = r2.f2307g
            int r2 = -r2
            r7.a(r0, r1, r2)
        L_0x01e1:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0474
            goto L_0x0167
        L_0x01eb:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x021e
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x0474
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r7.f2377a
            r7.a(r2, r0, r1)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2377a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            int r2 = r2.L()
            int r2 = -r2
            r7.a(r0, r1, r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            int r2 = r2.f2307g
            goto L_0x0171
        L_0x021e:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0 instanceof androidx.constraintlayout.solver.widgets.g
            if (r0 != 0) goto L_0x0474
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            if (r0 == 0) goto L_0x0474
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 != 0) goto L_0x0474
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            int r2 = r2.z()
            r7.a(r1, r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            int r2 = r2.f2307g
            r7.a(r0, r1, r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0474
            goto L_0x0167
        L_0x0262:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            boolean r0 = r0.f2310j
            if (r0 != 0) goto L_0x02bf
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r6) goto L_0x02bf
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            int r0 = r0.f2277m
            if (r0 == r4) goto L_0x028d
            if (r0 == r5) goto L_0x0277
            goto L_0x02c4
        L_0x0277:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.V()
            if (r0 != 0) goto L_0x02c4
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            int r0 = r0.f2276l
            if (r0 != r5) goto L_0x0286
            goto L_0x02c4
        L_0x0286:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r0.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            goto L_0x029a
        L_0x028d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            if (r0 != 0) goto L_0x0296
            goto L_0x02c4
        L_0x0296:
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
        L_0x029a:
            androidx.constraintlayout.solver.widgets.analyzer.f r6 = r7.f2326g
            java.util.List r6 = r6.f2312l
            r6.add(r0)
            java.util.List<androidx.constraintlayout.solver.widgets.analyzer.d> r0 = r0.f2311k
            androidx.constraintlayout.solver.widgets.analyzer.f r6 = r7.f2326g
            r0.add(r6)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            r0.f2302b = r3
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            java.util.List r0 = r0.f2311k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r6 = r7.f2329j
            r0.add(r6)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            java.util.List r0 = r0.f2311k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r6 = r7.f2330k
            r0.add(r6)
            goto L_0x02c4
        L_0x02bf:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            r0.b(r7)
        L_0x02c4:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x032f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x032f
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.V()
            if (r0 == 0) goto L_0x02fe
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r1.G
            r1 = r1[r4]
            int r1 = r1.j()
            r0.f2306f = r1
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r1.G
            r1 = r1[r5]
            int r1 = r1.j()
            int r1 = -r1
            r0.f2306f = r1
            goto L_0x031c
        L_0x02fe:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r1 = r1.G
            r1 = r1[r5]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r1)
            r0.b(r7)
            r1.b(r7)
            androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType r0 = androidx.constraintlayout.solver.widgets.analyzer.WidgetRun.RunType.CENTER
            r7.f2331l = r0
        L_0x031c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0466
        L_0x0324:
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2377a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2378b
        L_0x032a:
            r7.a((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0, (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1, (int) r3, (androidx.constraintlayout.solver.widgets.analyzer.f) r2)
            goto L_0x0466
        L_0x032f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            r6 = 0
            if (r0 == 0) goto L_0x038b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x0466
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.G
            r2 = r2[r4]
            int r2 = r2.j()
            r7.a(r1, r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            r7.a((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0, (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1, (int) r3, (androidx.constraintlayout.solver.widgets.analyzer.f) r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x036f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2377a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2378b
            r7.a((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0, (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1, (int) r3, (androidx.constraintlayout.solver.widgets.analyzer.f) r2)
        L_0x036f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0466
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            float r0 = r0.N()
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0466
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r0.f2270f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r0.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0466
            goto L_0x0448
        L_0x038b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            r4 = -1
            if (r0 == 0) goto L_0x03c5
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r5]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x0466
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2330k
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r2 = r2.G
            r2 = r2[r5]
            int r2 = r2.j()
            int r2 = -r2
            r7.a(r1, r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            r7.a((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0, (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1, (int) r4, (androidx.constraintlayout.solver.widgets.analyzer.f) r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x0466
            goto L_0x0324
        L_0x03c5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x03f1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor[] r0 = r0.G
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r0)
            if (r0 == 0) goto L_0x0466
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r2 = r7.f2377a
            r7.a(r2, r0, r1)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2377a
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2378b
            r7.a((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0, (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1, (int) r4, (androidx.constraintlayout.solver.widgets.analyzer.f) r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            goto L_0x032a
        L_0x03f1:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0 instanceof androidx.constraintlayout.solver.widgets.g
            if (r0 != 0) goto L_0x0466
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            if (r0 == 0) goto L_0x0466
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.v()
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r0.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r7.f2323d
            int r2 = r2.z()
            r7.a(r1, r0, r2)
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2330k
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2326g
            r7.a((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0, (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1, (int) r3, (androidx.constraintlayout.solver.widgets.analyzer.f) r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            boolean r0 = r0.K()
            if (r0 == 0) goto L_0x042e
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r7.f2377a
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r1 = r7.f2329j
            androidx.constraintlayout.solver.widgets.analyzer.f r2 = r7.f2378b
            r7.a((androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r0, (androidx.constraintlayout.solver.widgets.analyzer.DependencyNode) r1, (int) r3, (androidx.constraintlayout.solver.widgets.analyzer.f) r2)
        L_0x042e:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r7.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0466
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            float r0 = r0.N()
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0466
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r0.f2270f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r0 = r0.f2325f
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x0466
        L_0x0448:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r7.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r0.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r0.f2326g
            java.util.List r0 = r0.f2311k
            androidx.constraintlayout.solver.widgets.analyzer.f r1 = r7.f2326g
            r0.add(r1)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            java.util.List r0 = r0.f2312l
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r7.f2323d
            androidx.constraintlayout.solver.widgets.analyzer.k r1 = r1.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.f r1 = r1.f2326g
            r0.add(r1)
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            r0.f2301a = r7
        L_0x0466:
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            java.util.List r0 = r0.f2312l
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0474
            androidx.constraintlayout.solver.widgets.analyzer.f r0 = r7.f2326g
            r0.f2303c = r3
        L_0x0474:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.analyzer.m.f():void");
    }

    public String toString() {
        return "VerticalRun " + this.f2323d.x();
    }
}
