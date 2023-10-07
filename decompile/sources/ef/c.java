package ef;

import eg.a;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public a f26885a;

    /* renamed from: b  reason: collision with root package name */
    public a f26886b;

    public c(List<a> list) {
        for (a a2 : list) {
            a(a2);
        }
    }

    public double a() {
        return a.b(a.a(this.f26886b, this.f26885a).doubleValue()).doubleValue();
    }

    public void a(a aVar) {
        boolean z2 = true;
        boolean z3 = this.f26885a == null;
        if (this.f26886b != null) {
            z2 = false;
        }
        if (z3 || z2) {
            this.f26886b = new a(aVar);
            this.f26885a = new a(aVar);
            return;
        }
        if (aVar.b() > this.f26886b.b()) {
            a aVar2 = this.f26886b;
            aVar2.a(aVar2.a(), aVar.b());
        }
        if (aVar.a() > this.f26886b.a()) {
            this.f26886b.a(aVar.a(), this.f26886b.b());
        }
        if (aVar.b() < this.f26885a.b()) {
            a aVar3 = this.f26885a;
            aVar3.a(aVar3.a(), aVar.b());
        }
        if (aVar.a() < this.f26885a.a()) {
            this.f26885a.a(aVar.a(), this.f26885a.b());
        }
    }

    public a b() {
        return new a((this.f26886b.d() + this.f26885a.d()) / 2.0d, (this.f26886b.c() + this.f26885a.c()) / 2.0d);
    }
}
