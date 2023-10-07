package kb;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f29961a;

    public c() {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f29961a = atomicInteger;
        atomicInteger.set(1);
    }

    public void a() {
        b.a(0, this.f29961a.get());
        this.f29961a.set(1);
    }

    /* access modifiers changed from: protected */
    public abstract void b();

    public final void c() {
        int decrementAndGet = this.f29961a.decrementAndGet();
        if (decrementAndGet == 0) {
            b();
        } else {
            b.b(decrementAndGet, 0);
        }
    }
}
