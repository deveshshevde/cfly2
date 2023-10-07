package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import ok.b;
import ok.e;
import ok.h;
import op.r;
import op.y;
import rx.exceptions.MissingBackpressureException;
import rx.internal.schedulers.c;
import rx.internal.schedulers.g;
import rx.internal.util.d;

public final class f<T> implements b.C0235b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final e f34239a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f34240b;

    /* renamed from: c  reason: collision with root package name */
    private final int f34241c;

    private static final class a<T> extends h<T> implements on.a {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f34242a;

        /* renamed from: b  reason: collision with root package name */
        final e.a f34243b;

        /* renamed from: c  reason: collision with root package name */
        final b<T> f34244c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f34245d;

        /* renamed from: e  reason: collision with root package name */
        final Queue<Object> f34246e;

        /* renamed from: f  reason: collision with root package name */
        final int f34247f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f34248g;

        /* renamed from: h  reason: collision with root package name */
        final AtomicLong f34249h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        final AtomicLong f34250i = new AtomicLong();

        /* renamed from: j  reason: collision with root package name */
        Throwable f34251j;

        /* renamed from: k  reason: collision with root package name */
        long f34252k;

        public a(e eVar, h<? super T> hVar, boolean z2, int i2) {
            this.f34242a = hVar;
            this.f34243b = eVar.a();
            this.f34245d = z2;
            this.f34244c = b.a();
            i2 = i2 <= 0 ? d.f34386b : i2;
            this.f34247f = i2 - (i2 >> 2);
            this.f34246e = y.a() ? new r<>(i2) : new oo.b<>(i2);
            request((long) i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            h<? super T> hVar = this.f34242a;
            hVar.setProducer(new ok.d() {
                public void request(long j2) {
                    if (j2 > 0) {
                        a.a(a.this.f34249h, j2);
                        a.this.b();
                    }
                }
            });
            hVar.add(this.f34243b);
            hVar.add(this);
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z2, boolean z3, h<? super T> hVar, Queue<Object> queue) {
            if (hVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (!z2) {
                return false;
            } else {
                if (!this.f34245d) {
                    Throwable th = this.f34251j;
                    if (th != null) {
                        queue.clear();
                        try {
                            hVar.onError(th);
                            return true;
                        } finally {
                            this.f34243b.unsubscribe();
                        }
                    } else if (!z3) {
                        return false;
                    } else {
                        try {
                            hVar.onCompleted();
                            return true;
                        } finally {
                            this.f34243b.unsubscribe();
                        }
                    }
                } else if (!z3) {
                    return false;
                } else {
                    Throwable th2 = this.f34251j;
                    if (th2 != null) {
                        try {
                            hVar.onError(th2);
                        } catch (Throwable th3) {
                            this.f34243b.unsubscribe();
                            throw th3;
                        }
                    } else {
                        hVar.onCompleted();
                    }
                    this.f34243b.unsubscribe();
                    return false;
                }
            }
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (this.f34250i.getAndIncrement() == 0) {
                this.f34243b.a(this);
            }
        }

        public void call() {
            long j2 = this.f34252k;
            Queue<Object> queue = this.f34246e;
            h<? super T> hVar = this.f34242a;
            b<T> bVar = this.f34244c;
            long j3 = 1;
            do {
                long j4 = this.f34249h.get();
                while (j4 != j2) {
                    boolean z2 = this.f34248g;
                    Object poll = queue.poll();
                    boolean z3 = poll == null;
                    if (!a(z2, z3, hVar, queue)) {
                        if (z3) {
                            break;
                        }
                        hVar.onNext(bVar.b(poll));
                        j2++;
                        if (j2 == ((long) this.f34247f)) {
                            j4 = a.b(this.f34249h, j2);
                            request(j2);
                            j2 = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (j4 != j2 || !a(this.f34248g, queue.isEmpty(), hVar, queue)) {
                    this.f34252k = j2;
                    j3 = this.f34250i.addAndGet(-j3);
                } else {
                    return;
                }
            } while (j3 != 0);
        }

        public void onCompleted() {
            if (!isUnsubscribed() && !this.f34248g) {
                this.f34248g = true;
                b();
            }
        }

        public void onError(Throwable th) {
            if (isUnsubscribed() || this.f34248g) {
                or.d.a().b().a(th);
                return;
            }
            this.f34251j = th;
            this.f34248g = true;
            b();
        }

        public void onNext(T t2) {
            if (!isUnsubscribed() && !this.f34248g) {
                if (!this.f34246e.offer(this.f34244c.a(t2))) {
                    onError(new MissingBackpressureException());
                } else {
                    b();
                }
            }
        }
    }

    public f(e eVar, boolean z2, int i2) {
        this.f34239a = eVar;
        this.f34240b = z2;
        this.f34241c = i2 <= 0 ? d.f34386b : i2;
    }

    /* renamed from: a */
    public h<? super T> call(h<? super T> hVar) {
        e eVar = this.f34239a;
        if ((eVar instanceof c) || (eVar instanceof g)) {
            return hVar;
        }
        a aVar = new a(eVar, hVar, this.f34240b, this.f34241c);
        aVar.a();
        return aVar;
    }
}
