package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.a;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;

class j extends WidgetRun {
    public j(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void a(DependencyNode dependencyNode) {
        this.f2329j.f2311k.add(dependencyNode);
        dependencyNode.f2312l.add(this.f2329j);
    }

    public void a(d dVar) {
        a aVar = (a) this.f2323d;
        int b2 = aVar.b();
        int i2 = 0;
        int i3 = -1;
        for (DependencyNode dependencyNode : this.f2329j.f2312l) {
            int i4 = dependencyNode.f2307g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (b2 == 0 || b2 == 2) {
            this.f2329j.a(i3 + aVar.g());
        } else {
            this.f2329j.a(i2 + aVar.g());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f2324e = null;
        this.f2329j.a();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f2329j.f2310j = false;
    }

    public void e() {
        if (this.f2323d instanceof a) {
            int b2 = ((a) this.f2323d).b();
            if (b2 == 0 || b2 == 1) {
                this.f2323d.m(this.f2329j.f2307g);
            } else {
                this.f2323d.n(this.f2329j.f2307g);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        DependencyNode dependencyNode;
        if (this.f2323d instanceof a) {
            this.f2329j.f2302b = true;
            a aVar = (a) this.f2323d;
            int b2 = aVar.b();
            boolean c2 = aVar.c();
            int i2 = 0;
            if (b2 == 0) {
                this.f2329j.f2305e = DependencyNode.Type.LEFT;
                while (i2 < aVar.f2448ax) {
                    ConstraintWidget constraintWidget = aVar.f2447aw[i2];
                    if (c2 || constraintWidget.w() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget.f2270f.f2329j;
                        dependencyNode2.f2311k.add(this.f2329j);
                        this.f2329j.f2312l.add(dependencyNode2);
                    }
                    i2++;
                }
            } else if (b2 != 1) {
                if (b2 == 2) {
                    this.f2329j.f2305e = DependencyNode.Type.TOP;
                    while (i2 < aVar.f2448ax) {
                        ConstraintWidget constraintWidget2 = aVar.f2447aw[i2];
                        if (c2 || constraintWidget2.w() != 8) {
                            DependencyNode dependencyNode3 = constraintWidget2.f2271g.f2329j;
                            dependencyNode3.f2311k.add(this.f2329j);
                            this.f2329j.f2312l.add(dependencyNode3);
                        }
                        i2++;
                    }
                } else if (b2 == 3) {
                    this.f2329j.f2305e = DependencyNode.Type.BOTTOM;
                    while (i2 < aVar.f2448ax) {
                        ConstraintWidget constraintWidget3 = aVar.f2447aw[i2];
                        if (c2 || constraintWidget3.w() != 8) {
                            DependencyNode dependencyNode4 = constraintWidget3.f2271g.f2330k;
                            dependencyNode4.f2311k.add(this.f2329j);
                            this.f2329j.f2312l.add(dependencyNode4);
                        }
                        i2++;
                    }
                } else {
                    return;
                }
                a(this.f2323d.f2271g.f2329j);
                dependencyNode = this.f2323d.f2271g.f2330k;
                a(dependencyNode);
            } else {
                this.f2329j.f2305e = DependencyNode.Type.RIGHT;
                while (i2 < aVar.f2448ax) {
                    ConstraintWidget constraintWidget4 = aVar.f2447aw[i2];
                    if (c2 || constraintWidget4.w() != 8) {
                        DependencyNode dependencyNode5 = constraintWidget4.f2270f.f2330k;
                        dependencyNode5.f2311k.add(this.f2329j);
                        this.f2329j.f2312l.add(dependencyNode5);
                    }
                    i2++;
                }
            }
            a(this.f2323d.f2270f.f2329j);
            dependencyNode = this.f2323d.f2270f.f2330k;
            a(dependencyNode);
        }
    }
}
