package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.ad;

final class g {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ad> f32032a = new LinkedHashSet();

    g() {
    }

    public synchronized void a(ad adVar) {
        this.f32032a.add(adVar);
    }

    public synchronized void b(ad adVar) {
        this.f32032a.remove(adVar);
    }

    public synchronized boolean c(ad adVar) {
        return this.f32032a.contains(adVar);
    }
}
