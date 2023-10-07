package eg;

import ef.a;
import fg.i;
import java.util.ArrayList;
import java.util.Iterator;

public class e {
    public static double a(a aVar, a aVar2, a aVar3) {
        double d2;
        double d3;
        double a2 = aVar3.a() - aVar.a();
        double b2 = aVar3.b() - aVar.b();
        double a3 = aVar2.a() - aVar.a();
        double b3 = aVar2.b() - aVar.b();
        double d4 = ((a2 * a3) + (b2 * b3)) / ((a3 * a3) + (b3 * b3));
        if (d4 < i.f27244a) {
            d3 = aVar.a();
            d2 = aVar.b();
        } else if (d4 > 1.0d) {
            d3 = aVar2.a();
            d2 = aVar2.b();
        } else {
            d2 = aVar.b() + (d4 * b3);
            d3 = aVar.a() + (a3 * d4);
        }
        return Math.hypot(d3 - aVar3.a(), d2 - aVar3.b());
    }

    public static a a(ArrayList<a> arrayList, a aVar) {
        Iterator<a> it2 = arrayList.iterator();
        double d2 = Double.NEGATIVE_INFINITY;
        a aVar2 = null;
        while (it2.hasNext()) {
            a next = it2.next();
            double doubleValue = a.a(next, aVar).doubleValue();
            if (doubleValue > d2) {
                aVar2 = next;
                d2 = doubleValue;
            }
        }
        return aVar2;
    }
}
