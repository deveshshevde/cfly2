package io.realm.internal;

import io.realm.log.RealmLog;
import java.lang.ref.ReferenceQueue;

class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ReferenceQueue<e> f29032a;

    c(ReferenceQueue<e> referenceQueue) {
        this.f29032a = referenceQueue;
    }

    public void run() {
        while (true) {
            try {
                ((NativeObjectReference) this.f29032a.remove()).a();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                RealmLog.b("The FinalizerRunnable thread has been interrupted. Native resources cannot be freed anymore", new Object[0]);
                return;
            }
        }
    }
}
