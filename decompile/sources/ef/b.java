package ef;

import ej.a;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private a f26884a;

    public b(double d2, double d3, a aVar) {
        super(d2, d3);
        this.f26884a = aVar;
    }

    public b(a aVar, a aVar2) {
        this(aVar.d(), aVar.c(), aVar2);
    }

    public void a(double d2, double d3, a aVar) {
        super.a(d2, d3);
        this.f26884a = aVar;
    }

    public a g() {
        return this.f26884a;
    }
}
