package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.bp;
import mt.c;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public static final bp f30428a;

    /* renamed from: b  reason: collision with root package name */
    public static final o f30429b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f30430c = x.a("kotlinx.coroutines.fast.service.loader", true);

    static {
        o oVar = new o();
        f30429b = oVar;
        f30428a = oVar.a();
    }

    private o() {
    }

    private final bp a() {
        Object obj;
        bp a2;
        try {
            List<MainDispatcherFactory> a3 = f30430c ? h.f30410a.a() : c.b(c.a(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            Iterator it2 = a3.iterator();
            if (!it2.hasNext()) {
                obj = null;
            } else {
                obj = it2.next();
                if (it2.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) obj).getLoadPriority();
                    do {
                        Object next = it2.next();
                        int loadPriority2 = ((MainDispatcherFactory) next).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            obj = next;
                            loadPriority = loadPriority2;
                        }
                    } while (it2.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
            return (mainDispatcherFactory == null || (a2 = p.a(mainDispatcherFactory, (List<? extends MainDispatcherFactory>) a3)) == null) ? p.a((Throwable) null, (String) null, 3, (Object) null) : a2;
        } catch (Throwable th) {
            return p.a(th, (String) null, 2, (Object) null);
        }
    }
}
