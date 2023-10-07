package om;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import ok.e;
import ok.i;
import rx.internal.schedulers.ScheduledAction;

public final class b extends e {

    /* renamed from: b  reason: collision with root package name */
    private final Handler f32483b;

    static class a extends e.a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Handler f32484a;

        /* renamed from: b  reason: collision with root package name */
        private final ot.b f32485b = new ot.b();

        a(Handler handler) {
            this.f32484a = handler;
        }

        public i a(on.a aVar) {
            return a(aVar, 0, TimeUnit.MILLISECONDS);
        }

        public i a(on.a aVar, long j2, TimeUnit timeUnit) {
            if (this.f32485b.isUnsubscribed()) {
                return ot.e.b();
            }
            final ScheduledAction scheduledAction = new ScheduledAction(ol.a.a().b().a(aVar));
            scheduledAction.a(this.f32485b);
            this.f32485b.a((i) scheduledAction);
            this.f32484a.postDelayed(scheduledAction, timeUnit.toMillis(j2));
            scheduledAction.a(ot.e.a((on.a) new on.a() {
                public void call() {
                    a.this.f32484a.removeCallbacks(scheduledAction);
                }
            }));
            return scheduledAction;
        }

        public boolean isUnsubscribed() {
            return this.f32485b.isUnsubscribed();
        }

        public void unsubscribe() {
            this.f32485b.unsubscribe();
        }
    }

    b(Handler handler) {
        this.f32483b = handler;
    }

    public e.a a() {
        return new a(this.f32483b);
    }
}
