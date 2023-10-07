package ec;

import com.flypro.core.MAVLink.g;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final en.a f26850a;

    /* renamed from: b  reason: collision with root package name */
    private final int f26851b;

    /* renamed from: c  reason: collision with root package name */
    private ScheduledExecutorService f26852c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f26853d = new Runnable() {
        public void run() {
            g.a(a.this.f26850a);
        }
    };

    public a(en.a aVar, int i2) {
        this.f26850a = aVar;
        this.f26851b = i2;
    }

    public void a(boolean z2) {
        if (z2) {
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            this.f26852c = newSingleThreadScheduledExecutor;
            newSingleThreadScheduledExecutor.scheduleWithFixedDelay(this.f26853d, 0, (long) this.f26851b, TimeUnit.SECONDS);
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this.f26852c;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f26852c = null;
        }
    }
}
