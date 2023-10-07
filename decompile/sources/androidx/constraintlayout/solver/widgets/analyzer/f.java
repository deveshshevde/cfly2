package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;

class f extends DependencyNode {

    /* renamed from: m  reason: collision with root package name */
    public int f2365m;

    public f(WidgetRun widgetRun) {
        super(widgetRun);
        this.f2305e = widgetRun instanceof k ? DependencyNode.Type.HORIZONTAL_DIMENSION : DependencyNode.Type.VERTICAL_DIMENSION;
    }

    public void a(int i2) {
        if (!this.f2310j) {
            this.f2310j = true;
            this.f2307g = i2;
            for (d dVar : this.f2311k) {
                dVar.a(dVar);
            }
        }
    }
}
