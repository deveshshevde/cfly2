package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import ok.i;
import ot.b;
import rx.internal.util.e;

public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, i {
    private static final long serialVersionUID = -3962399486978279857L;

    /* renamed from: a  reason: collision with root package name */
    final e f34285a;

    /* renamed from: b  reason: collision with root package name */
    final on.a f34286b;

    private static final class Remover extends AtomicBoolean implements i {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a  reason: collision with root package name */
        final ScheduledAction f34287a;

        /* renamed from: b  reason: collision with root package name */
        final b f34288b;

        public Remover(ScheduledAction scheduledAction, b bVar) {
            this.f34287a = scheduledAction;
            this.f34288b = bVar;
        }

        public boolean isUnsubscribed() {
            return this.f34287a.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f34288b.b(this.f34287a);
            }
        }
    }

    private static final class Remover2 extends AtomicBoolean implements i {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a  reason: collision with root package name */
        final ScheduledAction f34289a;

        /* renamed from: b  reason: collision with root package name */
        final e f34290b;

        public Remover2(ScheduledAction scheduledAction, e eVar) {
            this.f34289a = scheduledAction;
            this.f34290b = eVar;
        }

        public boolean isUnsubscribed() {
            return this.f34289a.isUnsubscribed();
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f34290b.b(this.f34289a);
            }
        }
    }

    private final class a implements i {

        /* renamed from: b  reason: collision with root package name */
        private final Future<?> f34292b;

        a(Future<?> future) {
            this.f34292b = future;
        }

        public boolean isUnsubscribed() {
            return this.f34292b.isCancelled();
        }

        public void unsubscribe() {
            boolean z2;
            Future<?> future;
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                future = this.f34292b;
                z2 = true;
            } else {
                future = this.f34292b;
                z2 = false;
            }
            future.cancel(z2);
        }
    }

    public ScheduledAction(on.a aVar) {
        this.f34286b = aVar;
        this.f34285a = new e();
    }

    public ScheduledAction(on.a aVar, b bVar) {
        this.f34286b = aVar;
        this.f34285a = new e((i) new Remover(this, bVar));
    }

    public ScheduledAction(on.a aVar, e eVar) {
        this.f34286b = aVar;
        this.f34285a = new e((i) new Remover2(this, eVar));
    }

    public void a(Future<?> future) {
        this.f34285a.a((i) new a(future));
    }

    public void a(i iVar) {
        this.f34285a.a(iVar);
    }

    public void a(b bVar) {
        this.f34285a.a((i) new Remover(this, bVar));
    }

    public boolean isUnsubscribed() {
        return this.f34285a.isUnsubscribed();
    }

    public void run() {
        try {
            lazySet(Thread.currentThread());
            this.f34286b.call();
        } catch (Throwable th) {
            unsubscribe();
            throw th;
        }
        unsubscribe();
    }

    public void unsubscribe() {
        if (!this.f34285a.isUnsubscribed()) {
            this.f34285a.unsubscribe();
        }
    }
}
