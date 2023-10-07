package bl;

import bl.m;
import cc.l;
import java.util.Queue;

abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f5754a = l.a(20);

    d() {
    }

    public void a(T t2) {
        if (this.f5754a.size() < 20) {
            this.f5754a.offer(t2);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract T b();

    /* access modifiers changed from: package-private */
    public T c() {
        T t2 = (m) this.f5754a.poll();
        return t2 == null ? b() : t2;
    }
}
