package eg;

import ef.a;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class g {
    public static List<a> a(List<a> list, double d2) {
        int size = list.size() - 1;
        double d3 = i.f27244a;
        int i2 = 0;
        for (int i3 = 1; i3 < size; i3++) {
            double a2 = e.a(list.get(0), list.get(size), list.get(i3));
            if (a2 > d3) {
                i2 = i3;
                d3 = a2;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (d3 > d2) {
            List<a> a3 = a(list.subList(0, i2 + 1), d2);
            List<a> a4 = a(list.subList(i2, size + 1), d2);
            a3.remove(a3.size() - 1);
            arrayList.addAll(a3);
            arrayList.addAll(a4);
        } else {
            arrayList.add(list.get(0));
            arrayList.add(list.get(size));
        }
        return arrayList;
    }
}
