package eg;

import ef.a;
import ej.c;
import fg.i;
import java.util.List;

public class f {
    public static c a(List<a> list) {
        double d2 = i.f27244a;
        for (int i2 = 1; i2 < list.size(); i2++) {
            a aVar = list.get(i2 - 1);
            if (aVar != null) {
                d2 += a.c(list.get(i2), aVar).a();
            }
        }
        return new c(d2);
    }
}
