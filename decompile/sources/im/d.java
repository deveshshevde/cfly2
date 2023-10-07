package im;

import com.liulishuo.filedownloader.download.c;
import iq.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class d {
    public static b a(Map<String, List<String>> map, b bVar, List<String> list) throws IOException, IllegalAccessException {
        int e2 = bVar.e();
        String a2 = bVar.a("Location");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (a(e2)) {
            if (a2 != null) {
                if (iq.d.f29057a) {
                    iq.d.c(d.class, "redirect to %s with %d, %s", a2, Integer.valueOf(e2), arrayList);
                }
                bVar.f();
                bVar = a(map, a2);
                arrayList.add(a2);
                bVar.d();
                e2 = bVar.e();
                a2 = bVar.a("Location");
                i2++;
                if (i2 >= 10) {
                    throw new IllegalAccessException(f.a("redirect too many times! %s", arrayList));
                }
            } else {
                throw new IllegalAccessException(f.a("receive %d (redirect) but the location is null with response [%s]", Integer.valueOf(e2), bVar.c()));
            }
        }
        if (list != null) {
            list.addAll(arrayList);
        }
        return bVar;
    }

    private static b a(Map<String, List<String>> map, String str) throws IOException {
        b a2 = c.a().a(str);
        for (Map.Entry next : map.entrySet()) {
            String str2 = (String) next.getKey();
            List<String> list = (List) next.getValue();
            if (list != null) {
                for (String a3 : list) {
                    a2.a(str2, a3);
                }
            }
        }
        return a2;
    }

    private static boolean a(int i2) {
        return i2 == 301 || i2 == 302 || i2 == 303 || i2 == 300 || i2 == 307 || i2 == 308;
    }
}
