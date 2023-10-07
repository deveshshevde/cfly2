package eg;

import ef.a;
import ef.c;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class d {
    public static a a(b bVar, b bVar2) throws Exception {
        double a2 = ((bVar.b().a() - bVar.a().a()) * (bVar2.b().b() - bVar2.a().b())) - ((bVar.b().b() - bVar.a().b()) * (bVar2.b().a() - bVar2.a().a()));
        if (a2 != i.f27244a) {
            double b2 = (((bVar.a().b() - bVar2.a().b()) * (bVar2.b().a() - bVar2.a().a())) - ((bVar.a().a() - bVar2.a().a()) * (bVar2.b().b() - bVar2.a().b()))) / a2;
            double b3 = (((bVar.a().b() - bVar2.a().b()) * (bVar.b().a() - bVar.a().a())) - ((bVar.a().a() - bVar2.a().a()) * (bVar.b().b() - bVar.a().b()))) / a2;
            if (b2 >= i.f27244a && b2 <= 1.0d && b3 >= i.f27244a && b3 <= 1.0d) {
                return new a(bVar.a().a() + ((bVar.b().a() - bVar.a().a()) * b2), bVar.a().b() + (b2 * (bVar.b().b() - bVar.a().b())));
            }
            throw new Exception("No Intersection");
        }
        throw new Exception("Parralel Lines");
    }

    public static b a(a aVar, List<b> list) {
        b bVar = list.get(0);
        double d2 = Double.MAX_VALUE;
        for (b next : list) {
            a a2 = a.a(aVar, next.a()).doubleValue() < a.a(aVar, next.b()).doubleValue() ? next.a() : next.b();
            if (d2 > a.a(aVar, a2).doubleValue()) {
                d2 = a.a(aVar, a2).doubleValue();
                bVar = next;
            }
        }
        return bVar;
    }

    public static b a(ArrayList<a> arrayList) {
        a a2 = e.a(arrayList, new c(arrayList).b());
        return new b(a2, e.a(arrayList, a2));
    }
}
