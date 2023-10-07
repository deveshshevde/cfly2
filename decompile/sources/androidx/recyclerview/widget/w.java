package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class w extends RecyclerView.e {

    /* renamed from: h  reason: collision with root package name */
    boolean f4323h = true;

    public final void a(RecyclerView.v vVar, boolean z2) {
        d(vVar, z2);
        f(vVar);
    }

    public void a(boolean z2) {
        this.f4323h = z2;
    }

    public abstract boolean a(RecyclerView.v vVar);

    public abstract boolean a(RecyclerView.v vVar, int i2, int i3, int i4, int i5);

    public boolean a(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i2 = cVar.f3956a;
        int i3 = cVar.f3957b;
        View view = vVar.itemView;
        int left = cVar2 == null ? view.getLeft() : cVar2.f3956a;
        int top = cVar2 == null ? view.getTop() : cVar2.f3957b;
        if (vVar.isRemoved() || (i2 == left && i3 == top)) {
            return a(vVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return a(vVar, i2, i3, left, top);
    }

    public abstract boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, int i2, int i3, int i4, int i5);

    public boolean a(RecyclerView.v vVar, RecyclerView.v vVar2, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        int i2;
        int i3;
        int i4 = cVar.f3956a;
        int i5 = cVar.f3957b;
        if (vVar2.shouldIgnore()) {
            int i6 = cVar.f3956a;
            i2 = cVar.f3957b;
            i3 = i6;
        } else {
            i3 = cVar2.f3956a;
            i2 = cVar2.f3957b;
        }
        return a(vVar, vVar2, i4, i5, i3, i2);
    }

    public final void b(RecyclerView.v vVar, boolean z2) {
        c(vVar, z2);
    }

    public abstract boolean b(RecyclerView.v vVar);

    public boolean b(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        if (cVar == null || (cVar.f3956a == cVar2.f3956a && cVar.f3957b == cVar2.f3957b)) {
            return b(vVar);
        }
        return a(vVar, cVar.f3956a, cVar.f3957b, cVar2.f3956a, cVar2.f3957b);
    }

    public void c(RecyclerView.v vVar, boolean z2) {
    }

    public boolean c(RecyclerView.v vVar, RecyclerView.e.c cVar, RecyclerView.e.c cVar2) {
        if (cVar.f3956a == cVar2.f3956a && cVar.f3957b == cVar2.f3957b) {
            j(vVar);
            return false;
        }
        return a(vVar, cVar.f3956a, cVar.f3957b, cVar2.f3956a, cVar2.f3957b);
    }

    public void d(RecyclerView.v vVar, boolean z2) {
    }

    public boolean h(RecyclerView.v vVar) {
        return !this.f4323h || vVar.isInvalid();
    }

    public final void i(RecyclerView.v vVar) {
        p(vVar);
        f(vVar);
    }

    public final void j(RecyclerView.v vVar) {
        t(vVar);
        f(vVar);
    }

    public final void k(RecyclerView.v vVar) {
        r(vVar);
        f(vVar);
    }

    public final void l(RecyclerView.v vVar) {
        o(vVar);
    }

    public final void m(RecyclerView.v vVar) {
        s(vVar);
    }

    public final void n(RecyclerView.v vVar) {
        q(vVar);
    }

    public void o(RecyclerView.v vVar) {
    }

    public void p(RecyclerView.v vVar) {
    }

    public void q(RecyclerView.v vVar) {
    }

    public void r(RecyclerView.v vVar) {
    }

    public void s(RecyclerView.v vVar) {
    }

    public void t(RecyclerView.v vVar) {
    }
}
