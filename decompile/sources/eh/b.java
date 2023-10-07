package eh;

import ef.a;
import java.util.ArrayList;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26895a = "b";

    private static List<a> a(a aVar, a aVar2, a aVar3, a aVar4) {
        return new a(aVar, aVar2, aVar3, aVar4).a(20);
    }

    public static List<a> a(List<a> list) {
        int size = list.size();
        if (size < 4) {
            System.err.println("Not enough points!");
            return list;
        }
        List<a> b2 = b(list);
        b2.add(0, list.get(0));
        b2.add(list.get(size - 1));
        return b2;
    }

    private static List<a> b(List<a> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 3; i2 < list.size(); i2++) {
            arrayList.addAll(a(list.get(i2 - 3), list.get(i2 - 2), list.get(i2 - 1), list.get(i2)));
        }
        return arrayList;
    }
}
