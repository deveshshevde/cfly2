package an;

import android.content.Context;
import androidx.work.j;
import ap.a;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f257d = j.a("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    protected final a f258a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f259b;

    /* renamed from: c  reason: collision with root package name */
    T f260c;

    /* renamed from: e  reason: collision with root package name */
    private final Object f261e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Set<al.a<T>> f262f = new LinkedHashSet();

    d(Context context, a aVar) {
        this.f259b = context.getApplicationContext();
        this.f258a = aVar;
    }

    public void a(al.a<T> aVar) {
        synchronized (this.f261e) {
            if (this.f262f.add(aVar)) {
                if (this.f262f.size() == 1) {
                    this.f260c = c();
                    j.a().b(f257d, String.format("%s: initial state = %s", new Object[]{getClass().getSimpleName(), this.f260c}), new Throwable[0]);
                    d();
                }
                aVar.a(this.f260c);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(T r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f261e
            monitor-enter(r0)
            T r1 = r3.f260c     // Catch:{ all -> 0x002b }
            if (r1 == r4) goto L_0x0029
            if (r1 == 0) goto L_0x0010
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0010
            goto L_0x0029
        L_0x0010:
            r3.f260c = r4     // Catch:{ all -> 0x002b }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002b }
            java.util.Set<al.a<T>> r1 = r3.f262f     // Catch:{ all -> 0x002b }
            r4.<init>(r1)     // Catch:{ all -> 0x002b }
            ap.a r1 = r3.f258a     // Catch:{ all -> 0x002b }
            java.util.concurrent.Executor r1 = r1.a()     // Catch:{ all -> 0x002b }
            an.d$1 r2 = new an.d$1     // Catch:{ all -> 0x002b }
            r2.<init>(r4)     // Catch:{ all -> 0x002b }
            r1.execute(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x0029:
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: an.d.a(java.lang.Object):void");
    }

    public void b(al.a<T> aVar) {
        synchronized (this.f261e) {
            if (this.f262f.remove(aVar) && this.f262f.isEmpty()) {
                e();
            }
        }
    }

    public abstract T c();

    public abstract void d();

    public abstract void e();
}
