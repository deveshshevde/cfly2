package ma;

import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import oj.c;

public abstract class a<T> implements b, e<T> {
    final AtomicReference<c> upstream = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public final void cancel() {
        dispose();
    }

    public final void dispose() {
        SubscriptionHelper.a(this.upstream);
    }

    public final boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.upstream.get().a(Long.MAX_VALUE);
    }

    public final void onSubscribe(c cVar) {
        if (io.reactivex.internal.util.b.a(this.upstream, cVar, getClass())) {
            onStart();
        }
    }

    /* access modifiers changed from: protected */
    public final void request(long j2) {
        this.upstream.get().a(j2);
    }
}
