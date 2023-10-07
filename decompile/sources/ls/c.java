package ls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.h;
import ou.a;

public final class c {
    public static final b a() {
        List<a.b> a2 = a.a();
        h.b(a2, "Timber.forest()");
        Collection arrayList = new ArrayList();
        for (Object next : a2) {
            if (next instanceof b) {
                arrayList.add(next);
            }
        }
        return (b) kotlin.collections.h.d((List) arrayList);
    }
}
