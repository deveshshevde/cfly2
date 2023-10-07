package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.f;

class i extends WidgetRun {
    public i(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f2270f.c();
        constraintWidget.f2271g.c();
        this.f2327h = ((f) constraintWidget).c();
    }

    private void a(DependencyNode dependencyNode) {
        this.f2329j.f2311k.add(dependencyNode);
        dependencyNode.f2312l.add(this.f2329j);
    }

    public void a(d dVar) {
        if (this.f2329j.f2303c && !this.f2329j.f2310j) {
            this.f2329j.a((int) ((((float) this.f2329j.f2312l.get(0).f2307g) * ((f) this.f2323d).f()) + 0.5f));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f2329j.a();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f2329j.f2310j = false;
        this.f2330k.f2310j = false;
    }

    public void e() {
        if (((f) this.f2323d).c() == 1) {
            this.f2323d.m(this.f2329j.f2307g);
        } else {
            this.f2323d.n(this.f2329j.f2307g);
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        DependencyNode dependencyNode;
        DependencyNode dependencyNode2;
        DependencyNode dependencyNode3;
        f fVar = (f) this.f2323d;
        int g2 = fVar.g();
        int h2 = fVar.h();
        fVar.f();
        if (fVar.c() == 1) {
            DependencyNode dependencyNode4 = this.f2329j;
            if (g2 != -1) {
                dependencyNode4.f2312l.add(this.f2323d.J.f2270f.f2329j);
                this.f2323d.J.f2270f.f2329j.f2311k.add(this.f2329j);
                dependencyNode3 = this.f2329j;
            } else if (h2 != -1) {
                dependencyNode4.f2312l.add(this.f2323d.J.f2270f.f2330k);
                this.f2323d.J.f2270f.f2330k.f2311k.add(this.f2329j);
                dependencyNode3 = this.f2329j;
                g2 = -h2;
            } else {
                dependencyNode4.f2302b = true;
                this.f2329j.f2312l.add(this.f2323d.J.f2270f.f2330k);
                this.f2323d.J.f2270f.f2330k.f2311k.add(this.f2329j);
                a(this.f2323d.f2270f.f2329j);
                dependencyNode = this.f2323d.f2270f.f2330k;
            }
            dependencyNode3.f2306f = g2;
            a(this.f2323d.f2270f.f2329j);
            dependencyNode = this.f2323d.f2270f.f2330k;
        } else {
            DependencyNode dependencyNode5 = this.f2329j;
            if (g2 != -1) {
                dependencyNode5.f2312l.add(this.f2323d.J.f2271g.f2329j);
                this.f2323d.J.f2271g.f2329j.f2311k.add(this.f2329j);
                dependencyNode2 = this.f2329j;
            } else if (h2 != -1) {
                dependencyNode5.f2312l.add(this.f2323d.J.f2271g.f2330k);
                this.f2323d.J.f2271g.f2330k.f2311k.add(this.f2329j);
                dependencyNode2 = this.f2329j;
                g2 = -h2;
            } else {
                dependencyNode5.f2302b = true;
                this.f2329j.f2312l.add(this.f2323d.J.f2271g.f2330k);
                this.f2323d.J.f2271g.f2330k.f2311k.add(this.f2329j);
                a(this.f2323d.f2271g.f2329j);
                dependencyNode = this.f2323d.f2271g.f2330k;
            }
            dependencyNode2.f2306f = g2;
            a(this.f2323d.f2271g.f2329j);
            dependencyNode = this.f2323d.f2271g.f2330k;
        }
        a(dependencyNode);
    }
}
