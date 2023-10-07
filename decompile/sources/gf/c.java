package gf;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final CountDownLatch f28494a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    boolean f28495b = false;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<a> f28496c;

    /* renamed from: d  reason: collision with root package name */
    private final long f28497d;

    public c(a aVar, long j2) {
        this.f28496c = new WeakReference<>(aVar);
        this.f28497d = j2;
        start();
    }

    private final void a() {
        a aVar = (a) this.f28496c.get();
        if (aVar != null) {
            aVar.a();
            this.f28495b = true;
        }
    }

    public final void run() {
        try {
            if (!this.f28494a.await(this.f28497d, TimeUnit.MILLISECONDS)) {
                a();
            }
        } catch (InterruptedException unused) {
            a();
        }
    }
}
