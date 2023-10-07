package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.i;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.a;
import java.util.concurrent.atomic.AtomicLong;
import lx.d;
import lx.f;
import oj.b;
import oj.c;

public final class FlowableObserveOn<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final i f28730c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f28731d;

    /* renamed from: e  reason: collision with root package name */
    final int f28732e;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements e<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;

        /* renamed from: a  reason: collision with root package name */
        final i.c f28733a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f28734b;

        /* renamed from: c  reason: collision with root package name */
        final int f28735c;

        /* renamed from: d  reason: collision with root package name */
        final int f28736d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicLong f28737e = new AtomicLong();

        /* renamed from: f  reason: collision with root package name */
        c f28738f;

        /* renamed from: g  reason: collision with root package name */
        f<T> f28739g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f28740h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f28741i;

        /* renamed from: j  reason: collision with root package name */
        Throwable f28742j;

        /* renamed from: k  reason: collision with root package name */
        int f28743k;

        /* renamed from: l  reason: collision with root package name */
        long f28744l;

        /* renamed from: m  reason: collision with root package name */
        boolean f28745m;

        BaseObserveOnSubscriber(i.c cVar, boolean z2, int i2) {
            this.f28733a = cVar;
            this.f28734b = z2;
            this.f28735c = i2;
            this.f28736d = i2 - (i2 >> 2);
        }

        public final int a(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f28745m = true;
            return 2;
        }

        public final void a(long j2) {
            if (SubscriptionHelper.b(j2)) {
                a.a(this.f28737e, j2);
                d();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
            if (r3 != null) goto L_0x0027;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(boolean r3, boolean r4, oj.b<?> r5) {
            /*
                r2 = this;
                boolean r0 = r2.f28740h
                r1 = 1
                if (r0 == 0) goto L_0x0009
                r2.v_()
                return r1
            L_0x0009:
                if (r3 == 0) goto L_0x0033
                boolean r3 = r2.f28734b
                if (r3 == 0) goto L_0x001e
                if (r4 == 0) goto L_0x0033
                r2.f28740h = r1
                java.lang.Throwable r3 = r2.f28742j
                if (r3 == 0) goto L_0x002f
                goto L_0x0027
            L_0x0018:
                io.reactivex.i$c r3 = r2.f28733a
                r3.dispose()
                return r1
            L_0x001e:
                java.lang.Throwable r3 = r2.f28742j
                if (r3 == 0) goto L_0x002b
                r2.f28740h = r1
                r2.v_()
            L_0x0027:
                r5.onError(r3)
                goto L_0x0018
            L_0x002b:
                if (r4 == 0) goto L_0x0033
                r2.f28740h = r1
            L_0x002f:
                r5.onComplete()
                goto L_0x0018
            L_0x0033:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber.a(boolean, boolean, oj.b):boolean");
        }

        public final boolean b() {
            return this.f28739g.b();
        }

        public final void c() {
            if (!this.f28740h) {
                this.f28740h = true;
                this.f28738f.c();
                this.f28733a.dispose();
                if (getAndIncrement() == 0) {
                    this.f28739g.v_();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void d() {
            if (getAndIncrement() == 0) {
                this.f28733a.a((Runnable) this);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void e();

        /* access modifiers changed from: package-private */
        public abstract void f();

        /* access modifiers changed from: package-private */
        public abstract void g();

        public final void onComplete() {
            if (!this.f28741i) {
                this.f28741i = true;
                d();
            }
        }

        public final void onError(Throwable th) {
            if (this.f28741i) {
                ly.a.a(th);
                return;
            }
            this.f28742j = th;
            this.f28741i = true;
            d();
        }

        public final void onNext(T t2) {
            if (!this.f28741i) {
                if (this.f28743k == 2) {
                    d();
                    return;
                }
                if (!this.f28739g.a(t2)) {
                    this.f28738f.c();
                    this.f28742j = new MissingBackpressureException("Queue is full?!");
                    this.f28741i = true;
                }
                d();
            }
        }

        public final void run() {
            if (this.f28745m) {
                e();
            } else if (this.f28743k == 1) {
                f();
            } else {
                g();
            }
        }

        public final void v_() {
            this.f28739g.v_();
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;

        /* renamed from: n  reason: collision with root package name */
        final lx.a<? super T> f28746n;

        /* renamed from: o  reason: collision with root package name */
        long f28747o;

        ObserveOnConditionalSubscriber(lx.a<? super T> aVar, i.c cVar, boolean z2, int i2) {
            super(cVar, z2, i2);
            this.f28746n = aVar;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int i2 = 1;
            while (!this.f28740h) {
                boolean z2 = this.f28741i;
                this.f28746n.onNext(null);
                if (z2) {
                    this.f28740h = true;
                    Throwable th = this.f28742j;
                    if (th != null) {
                        this.f28746n.onError(th);
                    } else {
                        this.f28746n.onComplete();
                    }
                    this.f28733a.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
            if (r10.f28740h == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
            if (r1.b() == false) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
            r6 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
            if (r5 != r6) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0053, code lost:
            r10.f28744l = r2;
            r5 = addAndGet(-r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
            if (r5 != 0) goto L_0x0008;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x005d, code lost:
            r5 = r6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f() {
            /*
                r10 = this;
                lx.a<? super T> r0 = r10.f28746n
                lx.f r1 = r10.f28739g
                long r2 = r10.f28744l
                r4 = 1
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r10.f28737e
                long r6 = r6.get()
            L_0x000e:
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 == 0) goto L_0x0041
                java.lang.Object r8 = r1.w_()     // Catch:{ all -> 0x0032 }
                boolean r9 = r10.f28740h
                if (r9 == 0) goto L_0x001b
                return
            L_0x001b:
                if (r8 != 0) goto L_0x0028
            L_0x001d:
                r10.f28740h = r4
                r0.onComplete()
            L_0x0022:
                io.reactivex.i$c r0 = r10.f28733a
                r0.dispose()
                return
            L_0x0028:
                boolean r8 = r0.a(r8)
                if (r8 == 0) goto L_0x000e
                r8 = 1
                long r2 = r2 + r8
                goto L_0x000e
            L_0x0032:
                r1 = move-exception
                io.reactivex.exceptions.a.b(r1)
                r10.f28740h = r4
                oj.c r2 = r10.f28738f
                r2.c()
                r0.onError(r1)
                goto L_0x0022
            L_0x0041:
                boolean r6 = r10.f28740h
                if (r6 == 0) goto L_0x0046
                return
            L_0x0046:
                boolean r6 = r1.b()
                if (r6 == 0) goto L_0x004d
                goto L_0x001d
            L_0x004d:
                int r6 = r10.get()
                if (r5 != r6) goto L_0x005d
                r10.f28744l = r2
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L_0x0008
                return
            L_0x005d:
                r5 = r6
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableObserveOn.ObserveOnConditionalSubscriber.f():void");
        }

        /* access modifiers changed from: package-private */
        public void g() {
            lx.a<? super T> aVar = this.f28746n;
            f fVar = this.f28739g;
            long j2 = this.f28744l;
            long j3 = this.f28747o;
            int i2 = 1;
            while (true) {
                long j4 = this.f28737e.get();
                while (j2 != j4) {
                    boolean z2 = this.f28741i;
                    try {
                        Object w_ = fVar.w_();
                        boolean z3 = w_ == null;
                        if (!a(z2, z3, aVar)) {
                            if (z3) {
                                break;
                            }
                            if (aVar.a(w_)) {
                                j2++;
                            }
                            j3++;
                            if (j3 == ((long) this.f28736d)) {
                                this.f28738f.a(j3);
                                j3 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f28740h = true;
                        this.f28738f.c();
                        fVar.v_();
                        aVar.onError(th);
                        this.f28733a.dispose();
                        return;
                    }
                }
                if (j2 != j4 || !a(this.f28741i, fVar.b(), aVar)) {
                    int i3 = get();
                    if (i2 == i3) {
                        this.f28744l = j2;
                        this.f28747o = j3;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }

        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.a(this.f28738f, cVar)) {
                this.f28738f = cVar;
                if (cVar instanceof d) {
                    d dVar = (d) cVar;
                    int a2 = dVar.a(7);
                    if (a2 == 1) {
                        this.f28743k = 1;
                        this.f28739g = dVar;
                        this.f28741i = true;
                        this.f28746n.onSubscribe(this);
                        return;
                    } else if (a2 == 2) {
                        this.f28743k = 2;
                        this.f28739g = dVar;
                        this.f28746n.onSubscribe(this);
                        cVar.a((long) this.f28735c);
                        return;
                    }
                }
                this.f28739g = new SpscArrayQueue(this.f28735c);
                this.f28746n.onSubscribe(this);
                cVar.a((long) this.f28735c);
            }
        }

        public T w_() throws Exception {
            T w_ = this.f28739g.w_();
            if (!(w_ == null || this.f28743k == 1)) {
                long j2 = this.f28747o + 1;
                if (j2 == ((long) this.f28736d)) {
                    this.f28747o = 0;
                    this.f28738f.a(j2);
                } else {
                    this.f28747o = j2;
                }
            }
            return w_;
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements e<T> {
        private static final long serialVersionUID = -4547113800637756442L;

        /* renamed from: n  reason: collision with root package name */
        final b<? super T> f28748n;

        ObserveOnSubscriber(b<? super T> bVar, i.c cVar, boolean z2, int i2) {
            super(cVar, z2, i2);
            this.f28748n = bVar;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            int i2 = 1;
            while (!this.f28740h) {
                boolean z2 = this.f28741i;
                this.f28748n.onNext(null);
                if (z2) {
                    this.f28740h = true;
                    Throwable th = this.f28742j;
                    if (th != null) {
                        this.f28748n.onError(th);
                    } else {
                        this.f28748n.onComplete();
                    }
                    this.f28733a.dispose();
                    return;
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
            if (r10.f28740h == false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
            if (r1.b() == false) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
            r6 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
            if (r5 != r6) goto L_0x005a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
            r10.f28744l = r2;
            r5 = addAndGet(-r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
            if (r5 != 0) goto L_0x0008;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
            r5 = r6;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void f() {
            /*
                r10 = this;
                oj.b<? super T> r0 = r10.f28748n
                lx.f r1 = r10.f28739g
                long r2 = r10.f28744l
                r4 = 1
                r5 = 1
            L_0x0008:
                java.util.concurrent.atomic.AtomicLong r6 = r10.f28737e
                long r6 = r6.get()
            L_0x000e:
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 == 0) goto L_0x003e
                java.lang.Object r8 = r1.w_()     // Catch:{ all -> 0x002f }
                boolean r9 = r10.f28740h
                if (r9 == 0) goto L_0x001b
                return
            L_0x001b:
                if (r8 != 0) goto L_0x0028
            L_0x001d:
                r10.f28740h = r4
                r0.onComplete()
            L_0x0022:
                io.reactivex.i$c r0 = r10.f28733a
                r0.dispose()
                return
            L_0x0028:
                r0.onNext(r8)
                r8 = 1
                long r2 = r2 + r8
                goto L_0x000e
            L_0x002f:
                r1 = move-exception
                io.reactivex.exceptions.a.b(r1)
                r10.f28740h = r4
                oj.c r2 = r10.f28738f
                r2.c()
                r0.onError(r1)
                goto L_0x0022
            L_0x003e:
                boolean r6 = r10.f28740h
                if (r6 == 0) goto L_0x0043
                return
            L_0x0043:
                boolean r6 = r1.b()
                if (r6 == 0) goto L_0x004a
                goto L_0x001d
            L_0x004a:
                int r6 = r10.get()
                if (r5 != r6) goto L_0x005a
                r10.f28744l = r2
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L_0x0008
                return
            L_0x005a:
                r5 = r6
                goto L_0x0008
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableObserveOn.ObserveOnSubscriber.f():void");
        }

        /* access modifiers changed from: package-private */
        public void g() {
            b<? super T> bVar = this.f28748n;
            f fVar = this.f28739g;
            long j2 = this.f28744l;
            int i2 = 1;
            while (true) {
                long j3 = this.f28737e.get();
                while (j2 != j3) {
                    boolean z2 = this.f28741i;
                    try {
                        Object w_ = fVar.w_();
                        boolean z3 = w_ == null;
                        if (!a(z2, z3, bVar)) {
                            if (z3) {
                                break;
                            }
                            bVar.onNext(w_);
                            j2++;
                            if (j2 == ((long) this.f28736d)) {
                                if (j3 != Long.MAX_VALUE) {
                                    j3 = this.f28737e.addAndGet(-j2);
                                }
                                this.f28738f.a(j2);
                                j2 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f28740h = true;
                        this.f28738f.c();
                        fVar.v_();
                        bVar.onError(th);
                        this.f28733a.dispose();
                        return;
                    }
                }
                if (j2 != j3 || !a(this.f28741i, fVar.b(), bVar)) {
                    int i3 = get();
                    if (i2 == i3) {
                        this.f28744l = j2;
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        i2 = i3;
                    }
                } else {
                    return;
                }
            }
        }

        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.a(this.f28738f, cVar)) {
                this.f28738f = cVar;
                if (cVar instanceof d) {
                    d dVar = (d) cVar;
                    int a2 = dVar.a(7);
                    if (a2 == 1) {
                        this.f28743k = 1;
                        this.f28739g = dVar;
                        this.f28741i = true;
                        this.f28748n.onSubscribe(this);
                        return;
                    } else if (a2 == 2) {
                        this.f28743k = 2;
                        this.f28739g = dVar;
                        this.f28748n.onSubscribe(this);
                        cVar.a((long) this.f28735c);
                        return;
                    }
                }
                this.f28739g = new SpscArrayQueue(this.f28735c);
                this.f28748n.onSubscribe(this);
                cVar.a((long) this.f28735c);
            }
        }

        public T w_() throws Exception {
            T w_ = this.f28739g.w_();
            if (!(w_ == null || this.f28743k == 1)) {
                long j2 = this.f28744l + 1;
                if (j2 == ((long) this.f28736d)) {
                    this.f28744l = 0;
                    this.f28738f.a(j2);
                } else {
                    this.f28744l = j2;
                }
            }
            return w_;
        }
    }

    public FlowableObserveOn(io.reactivex.b<T> bVar, i iVar, boolean z2, int i2) {
        super(bVar);
        this.f28730c = iVar;
        this.f28731d = z2;
        this.f28732e = i2;
    }

    public void b(b<? super T> bVar) {
        e eVar;
        io.reactivex.b bVar2;
        i.c a2 = this.f28730c.a();
        if (bVar instanceof lx.a) {
            bVar2 = this.f28764b;
            eVar = new ObserveOnConditionalSubscriber((lx.a) bVar, a2, this.f28731d, this.f28732e);
        } else {
            bVar2 = this.f28764b;
            eVar = new ObserveOnSubscriber(bVar, a2, this.f28731d, this.f28732e);
        }
        bVar2.a(eVar);
    }
}
