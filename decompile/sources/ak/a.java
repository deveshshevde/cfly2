package ak;

import androidx.work.j;
import androidx.work.n;
import ao.p;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static final String f223a = j.a("DelayedWorkTracker");

    /* renamed from: b  reason: collision with root package name */
    final b f224b;

    /* renamed from: c  reason: collision with root package name */
    private final n f225c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Runnable> f226d = new HashMap();

    public a(b bVar, n nVar) {
        this.f224b = bVar;
        this.f225c = nVar;
    }

    public void a(final p pVar) {
        Runnable remove = this.f226d.remove(pVar.f5495a);
        if (remove != null) {
            this.f225c.a(remove);
        }
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                j.a().b(a.f223a, String.format("Scheduling work %s", new Object[]{pVar.f5495a}), new Throwable[0]);
                a.this.f224b.a(pVar);
            }
        };
        this.f226d.put(pVar.f5495a, r0);
        long currentTimeMillis = System.currentTimeMillis();
        this.f225c.a(pVar.c() - currentTimeMillis, r0);
    }

    public void a(String str) {
        Runnable remove = this.f226d.remove(str);
        if (remove != null) {
            this.f225c.a(remove);
        }
    }
}
