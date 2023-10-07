package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.List;

public class DependencyNode implements d {

    /* renamed from: a  reason: collision with root package name */
    public d f2301a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2302b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2303c = false;

    /* renamed from: d  reason: collision with root package name */
    WidgetRun f2304d;

    /* renamed from: e  reason: collision with root package name */
    Type f2305e = Type.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    int f2306f;

    /* renamed from: g  reason: collision with root package name */
    public int f2307g;

    /* renamed from: h  reason: collision with root package name */
    int f2308h = 1;

    /* renamed from: i  reason: collision with root package name */
    f f2309i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2310j = false;

    /* renamed from: k  reason: collision with root package name */
    List<d> f2311k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    List<DependencyNode> f2312l = new ArrayList();

    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f2304d = widgetRun;
    }

    public void a() {
        this.f2312l.clear();
        this.f2311k.clear();
        this.f2310j = false;
        this.f2307g = 0;
        this.f2303c = false;
        this.f2302b = false;
    }

    public void a(int i2) {
        if (!this.f2310j) {
            this.f2310j = true;
            this.f2307g = i2;
            for (d next : this.f2311k) {
                next.a(next);
            }
        }
    }

    public void a(d dVar) {
        for (DependencyNode dependencyNode : this.f2312l) {
            if (!dependencyNode.f2310j) {
                return;
            }
        }
        this.f2303c = true;
        d dVar2 = this.f2301a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f2302b) {
            this.f2304d.a((d) this);
            return;
        }
        DependencyNode dependencyNode2 = null;
        int i2 = 0;
        for (DependencyNode next : this.f2312l) {
            if (!(next instanceof f)) {
                i2++;
                dependencyNode2 = next;
            }
        }
        if (dependencyNode2 != null && i2 == 1 && dependencyNode2.f2310j) {
            f fVar = this.f2309i;
            if (fVar != null) {
                if (fVar.f2310j) {
                    this.f2306f = this.f2308h * this.f2309i.f2307g;
                } else {
                    return;
                }
            }
            a(dependencyNode2.f2307g + this.f2306f);
        }
        d dVar3 = this.f2301a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f2311k.add(dVar);
        if (this.f2310j) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2304d.f2323d.x());
        sb.append(":");
        sb.append(this.f2305e);
        sb.append("(");
        sb.append(this.f2310j ? Integer.valueOf(this.f2307g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f2312l.size());
        sb.append(":d=");
        sb.append(this.f2311k.size());
        sb.append(">");
        return sb.toString();
    }
}
