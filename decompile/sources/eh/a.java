package eh;

import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private ef.a f26891a;

    /* renamed from: b  reason: collision with root package name */
    private ef.a f26892b;

    /* renamed from: c  reason: collision with root package name */
    private ef.a f26893c;

    /* renamed from: d  reason: collision with root package name */
    private ef.a f26894d;

    public a(ef.a aVar, ef.a aVar2, ef.a aVar3, ef.a aVar4) {
        this.f26891a = aVar2;
        this.f26892b = aVar3.b(aVar).a(0.625d);
        ef.a a2 = aVar4.b(this.f26891a).a(0.625d);
        this.f26893c = ef.a.a(this.f26891a.a(2.0d), aVar3.a(-2.0d), this.f26892b, a2);
        this.f26894d = ef.a.a(this.f26891a.a(-3.0d), aVar3.a(3.0d), this.f26892b.a(-2.0d), a2.f());
    }

    private ef.a a(double d2) {
        double d3 = d2 * d2;
        return ef.a.a(this.f26893c.a(d3 * d2), this.f26894d.a(d3), this.f26892b.a(d2), this.f26891a);
    }

    public List<ef.a> a(int i2) {
        ArrayList arrayList = new ArrayList();
        float f2 = 1.0f / ((float) i2);
        for (float f3 = 0.0f; f3 < 1.0f; f3 += f2) {
            arrayList.add(a((double) f3));
        }
        return arrayList;
    }
}
