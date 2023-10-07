package in.srain.cube.views.ptr;

import lq.a;

class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private b f13677a;

    /* renamed from: b  reason: collision with root package name */
    private c f13678b;

    private c() {
    }

    public static void a(c cVar, b bVar) {
        if (bVar != null && cVar != null) {
            if (cVar.f13677a == null) {
                cVar.f13677a = bVar;
                return;
            }
            while (!cVar.a(bVar)) {
                c cVar2 = cVar.f13678b;
                if (cVar2 == null) {
                    c cVar3 = new c();
                    cVar3.f13677a = bVar;
                    cVar.f13678b = cVar3;
                    return;
                }
                cVar = cVar2;
            }
        }
    }

    private boolean a(b bVar) {
        b bVar2 = this.f13677a;
        return bVar2 != null && bVar2 == bVar;
    }

    public static c b() {
        return new c();
    }

    private b c() {
        return this.f13677a;
    }

    public void a(PtrFrameLayout ptrFrameLayout) {
        c cVar = this;
        do {
            b c2 = cVar.c();
            if (c2 != null) {
                c2.a(ptrFrameLayout);
            }
            cVar = cVar.f13678b;
        } while (cVar != null);
    }

    public void a(PtrFrameLayout ptrFrameLayout, boolean z2, byte b2, a aVar) {
        c cVar = this;
        do {
            b c2 = cVar.c();
            if (c2 != null) {
                c2.a(ptrFrameLayout, z2, b2, aVar);
            }
            cVar = cVar.f13678b;
        } while (cVar != null);
    }

    public boolean a() {
        return this.f13677a != null;
    }

    public void b(PtrFrameLayout ptrFrameLayout) {
        if (a()) {
            c cVar = this;
            do {
                b c2 = cVar.c();
                if (c2 != null) {
                    c2.b(ptrFrameLayout);
                }
                cVar = cVar.f13678b;
            } while (cVar != null);
        }
    }

    public void c(PtrFrameLayout ptrFrameLayout) {
        c cVar = this;
        do {
            b c2 = cVar.c();
            if (c2 != null) {
                c2.c(ptrFrameLayout);
            }
            cVar = cVar.f13678b;
        } while (cVar != null);
    }

    public void d(PtrFrameLayout ptrFrameLayout) {
        c cVar = this;
        do {
            b c2 = cVar.c();
            if (c2 != null) {
                c2.d(ptrFrameLayout);
            }
            cVar = cVar.f13678b;
        } while (cVar != null);
    }
}
