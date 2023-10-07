package eg;

import ef.a;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f26889a;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f26890b = new ArrayList();

    public c(a aVar, a aVar2) {
        ArrayList arrayList = new ArrayList();
        this.f26889a = arrayList;
        arrayList.add(aVar);
        this.f26889a.add(aVar2);
    }

    private a a(List<a> list) {
        return list.get(list.size() - 1);
    }

    private List<a> a(a aVar, a aVar2, double d2) {
        ArrayList arrayList = new ArrayList();
        double d3 = a.d(aVar, aVar2);
        double a2 = a.c(aVar, aVar2).a();
        double d4 = i.f27244a;
        while (d4 < a2) {
            arrayList.add(a.a(aVar, d3, d4));
            d4 += d2;
        }
        return arrayList;
    }

    public List<a> a(double d2) {
        for (int i2 = 1; i2 < this.f26889a.size(); i2++) {
            a aVar = this.f26889a.get(i2 - 1);
            if (aVar != null) {
                this.f26890b.addAll(a(aVar, this.f26889a.get(i2), d2));
            }
        }
        a a2 = a(this.f26889a);
        if (a2 != null) {
            this.f26890b.add(a2);
        }
        return this.f26890b;
    }
}
