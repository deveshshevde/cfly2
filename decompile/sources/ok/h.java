package ok;

import rx.internal.util.e;

public abstract class h<T> implements c<T>, i {
    private static final Long NOT_SET = Long.MIN_VALUE;
    private d producer;
    private long requested;
    private final h<?> subscriber;
    private final e subscriptions;

    protected h() {
        this((h<?>) null, false);
    }

    protected h(h<?> hVar) {
        this(hVar, true);
    }

    protected h(h<?> hVar, boolean z2) {
        this.requested = NOT_SET.longValue();
        this.subscriber = hVar;
        this.subscriptions = (!z2 || hVar == null) ? new e() : hVar.subscriptions;
    }

    private void addToRequested(long j2) {
        if (this.requested != NOT_SET.longValue()) {
            long j3 = this.requested + j2;
            if (j3 < 0) {
                j2 = Long.MAX_VALUE;
            } else {
                this.requested = j3;
                return;
            }
        }
        this.requested = j2;
    }

    public final void add(i iVar) {
        this.subscriptions.a(iVar);
    }

    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    public void onStart() {
    }

    /* access modifiers changed from: protected */
    public final void request(long j2) {
        if (j2 >= 0) {
            synchronized (this) {
                d dVar = this.producer;
                if (dVar != null) {
                    dVar.request(j2);
                } else {
                    addToRequested(j2);
                }
            }
        } else {
            throw new IllegalArgumentException("number requested cannot be negative: " + j2);
        }
    }

    public void setProducer(d dVar) {
        long j2;
        boolean z2;
        d dVar2;
        synchronized (this) {
            j2 = this.requested;
            this.producer = dVar;
            z2 = this.subscriber != null && j2 == NOT_SET.longValue();
        }
        if (z2) {
            this.subscriber.setProducer(this.producer);
            return;
        }
        if (j2 == NOT_SET.longValue()) {
            dVar2 = this.producer;
            j2 = Long.MAX_VALUE;
        } else {
            dVar2 = this.producer;
        }
        dVar2.request(j2);
    }

    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }
}
