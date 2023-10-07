package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

class b implements e {
    b() {
    }

    private f j(d dVar) {
        return (f) dVar.c();
    }

    public float a(d dVar) {
        return j(dVar).a();
    }

    public void a() {
    }

    public void a(d dVar, float f2) {
        j(dVar).a(f2);
    }

    public void a(d dVar, Context context, ColorStateList colorStateList, float f2, float f3, float f4) {
        dVar.a(new f(colorStateList, f2));
        View d2 = dVar.d();
        d2.setClipToOutline(true);
        d2.setElevation(f3);
        b(dVar, f4);
    }

    public void a(d dVar, ColorStateList colorStateList) {
        j(dVar).a(colorStateList);
    }

    public float b(d dVar) {
        return d(dVar) * 2.0f;
    }

    public void b(d dVar, float f2) {
        j(dVar).a(f2, dVar.a(), dVar.b());
        f(dVar);
    }

    public float c(d dVar) {
        return d(dVar) * 2.0f;
    }

    public void c(d dVar, float f2) {
        dVar.d().setElevation(f2);
    }

    public float d(d dVar) {
        return j(dVar).b();
    }

    public float e(d dVar) {
        return dVar.d().getElevation();
    }

    public void f(d dVar) {
        if (!dVar.a()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float a2 = a(dVar);
        float d2 = d(dVar);
        int ceil = (int) Math.ceil((double) g.b(a2, d2, dVar.b()));
        int ceil2 = (int) Math.ceil((double) g.a(a2, d2, dVar.b()));
        dVar.a(ceil, ceil2, ceil, ceil2);
    }

    public void g(d dVar) {
        b(dVar, a(dVar));
    }

    public void h(d dVar) {
        b(dVar, a(dVar));
    }

    public ColorStateList i(d dVar) {
        return j(dVar).c();
    }
}
