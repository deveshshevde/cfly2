package net.lucode.hackware.magicindicator;

import java.util.List;

public class a {
    public static na.a a(List<na.a> list, int i2) {
        int i3;
        if (i2 >= 0 && i2 <= list.size() - 1) {
            return list.get(i2);
        }
        na.a aVar = new na.a();
        if (i2 < 0) {
            i3 = 0;
        } else {
            i2 = (i2 - list.size()) + 1;
            i3 = list.size() - 1;
        }
        na.a aVar2 = list.get(i3);
        aVar.f31303a = aVar2.f31303a + (aVar2.a() * i2);
        aVar.f31304b = aVar2.f31304b;
        aVar.f31305c = aVar2.f31305c + (aVar2.a() * i2);
        aVar.f31306d = aVar2.f31306d;
        aVar.f31307e = aVar2.f31307e + (aVar2.a() * i2);
        aVar.f31308f = aVar2.f31308f;
        aVar.f31309g = aVar2.f31309g + (i2 * aVar2.a());
        aVar.f31310h = aVar2.f31310h;
        return aVar;
    }
}
