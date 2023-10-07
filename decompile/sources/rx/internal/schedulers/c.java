package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import ok.e;
import ok.i;

public final class c extends e {

    /* renamed from: b  reason: collision with root package name */
    public static final c f34331b = new c();

    private class a extends e.a implements i {

        /* renamed from: a  reason: collision with root package name */
        final ot.a f34332a = new ot.a();

        a() {
        }

        public i a(on.a aVar) {
            aVar.call();
            return ot.e.b();
        }

        public i a(on.a aVar, long j2, TimeUnit timeUnit) {
            return a(new f(aVar, this, c.this.b() + timeUnit.toMillis(j2)));
        }

        public boolean isUnsubscribed() {
            return this.f34332a.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f34332a.unsubscribe();
        }
    }

    private c() {
    }

    public e.a a() {
        return new a();
    }
}
