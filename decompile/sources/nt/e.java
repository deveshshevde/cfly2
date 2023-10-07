package nt;

import java.util.Map;
import java.util.logging.Level;
import org.greenrobot.eventbus.f;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<? extends Throwable>, Integer> f31630a;

    public Integer a(Throwable th) {
        int i2 = 20;
        Throwable th2 = th;
        do {
            Integer b2 = b(th2);
            if (b2 != null) {
                return b2;
            }
            th2 = th2.getCause();
            i2--;
            if (i2 <= 0 || th2 == th) {
                f.a.a().a(Level.FINE, "No specific message resource ID found for " + th);
            }
        } while (th2 != null);
        f.a.a().a(Level.FINE, "No specific message resource ID found for " + th);
        return null;
    }

    /* access modifiers changed from: protected */
    public Integer b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer num = this.f31630a.get(cls);
        if (num == null) {
            Class cls2 = null;
            for (Map.Entry next : this.f31630a.entrySet()) {
                Class cls3 = (Class) next.getKey();
                if (cls3.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(cls3))) {
                    num = (Integer) next.getValue();
                    cls2 = cls3;
                }
            }
        }
        return num;
    }
}
