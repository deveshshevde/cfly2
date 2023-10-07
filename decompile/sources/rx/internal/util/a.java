package rx.internal.util;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ok.e;
import op.d;
import op.y;

public abstract class a<T> {

    /* renamed from: a  reason: collision with root package name */
    Queue<T> f34377a;

    /* renamed from: b  reason: collision with root package name */
    final int f34378b;

    /* renamed from: c  reason: collision with root package name */
    final int f34379c;

    /* renamed from: d  reason: collision with root package name */
    private final long f34380d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicReference<e.a> f34381e;

    public a() {
        this(0, 0, 67);
    }

    private a(int i2, int i3, long j2) {
        this.f34378b = i2;
        this.f34379c = i3;
        this.f34380d = j2;
        this.f34381e = new AtomicReference<>();
        a(i2);
        a();
    }

    private void a(int i2) {
        this.f34377a = y.a() ? new d<>(Math.max(this.f34379c, 1024)) : new ConcurrentLinkedQueue<>();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f34377a.add(b());
        }
    }

    public void a() {
        e.a a2 = os.a.a().a();
        if (this.f34381e.compareAndSet((Object) null, a2)) {
            AnonymousClass1 r2 = new on.a() {
                public void call() {
                    int size = a.this.f34377a.size();
                    int i2 = 0;
                    if (size < a.this.f34378b) {
                        int i3 = a.this.f34379c - size;
                        while (i2 < i3) {
                            a.this.f34377a.add(a.this.b());
                            i2++;
                        }
                    } else if (size > a.this.f34379c) {
                        int i4 = size - a.this.f34379c;
                        while (i2 < i4) {
                            a.this.f34377a.poll();
                            i2++;
                        }
                    }
                }
            };
            long j2 = this.f34380d;
            a2.a(r2, j2, j2, TimeUnit.SECONDS);
            return;
        }
        a2.unsubscribe();
    }

    public void a(T t2) {
        if (t2 != null) {
            this.f34377a.offer(t2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract T b();
}
