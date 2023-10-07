package ot;

import java.util.concurrent.Future;
import ok.i;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final b f34104a = new b();

    private static final class a implements i {

        /* renamed from: a  reason: collision with root package name */
        final Future<?> f34105a;

        public a(Future<?> future) {
            this.f34105a = future;
        }

        public boolean isUnsubscribed() {
            return this.f34105a.isCancelled();
        }

        public void unsubscribe() {
            this.f34105a.cancel(true);
        }
    }

    static final class b implements i {
        b() {
        }

        public boolean isUnsubscribed() {
            return true;
        }

        public void unsubscribe() {
        }
    }

    public static i a() {
        return a.a();
    }

    public static i a(Future<?> future) {
        return new a(future);
    }

    public static i a(on.a aVar) {
        return a.a(aVar);
    }

    public static i b() {
        return f34104a;
    }
}
