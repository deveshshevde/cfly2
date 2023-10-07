package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.b;
import io.reactivex.c;
import io.reactivex.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.a;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableCreate<T> extends b<T> {

    /* renamed from: b  reason: collision with root package name */
    final d<T> f28708b;

    /* renamed from: c  reason: collision with root package name */
    final BackpressureStrategy f28709c;

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28710a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.reactivex.BackpressureStrategy[] r0 = io.reactivex.BackpressureStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28710a = r0
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.MISSING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28710a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28710a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.DROP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f28710a     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.reactivex.BackpressureStrategy r1 = io.reactivex.BackpressureStrategy.LATEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.AnonymousClass1.<clinit>():void");
        }
    }

    static abstract class BaseEmitter<T> extends AtomicLong implements c<T>, oj.c {
        private static final long serialVersionUID = 7326289992464377023L;

        /* renamed from: a  reason: collision with root package name */
        final oj.b<? super T> f28711a;

        /* renamed from: b  reason: collision with root package name */
        final SequentialDisposable f28712b = new SequentialDisposable();

        BaseEmitter(oj.b<? super T> bVar) {
            this.f28711a = bVar;
        }

        public void a() {
            b();
        }

        public final void a(long j2) {
            if (SubscriptionHelper.b(j2)) {
                a.a((AtomicLong) this, j2);
                f();
            }
        }

        public final void a(Throwable th) {
            if (!b(th)) {
                ly.a.a(th);
            }
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (!e()) {
                try {
                    this.f28711a.onComplete();
                } finally {
                    this.f28712b.dispose();
                }
            }
        }

        public boolean b(Throwable th) {
            return c(th);
        }

        public final void c() {
            this.f28712b.dispose();
            d();
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        public boolean c(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (e()) {
                return false;
            }
            try {
                this.f28711a.onError(th);
                this.f28712b.dispose();
                return true;
            } catch (Throwable th2) {
                this.f28712b.dispose();
                throw th2;
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
        }

        public final boolean e() {
            return this.f28712b.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.internal.queue.a<T> f28713c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f28714d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f28715e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f28716f = new AtomicInteger();

        BufferAsyncEmitter(oj.b<? super T> bVar, int i2) {
            super(bVar);
            this.f28713c = new io.reactivex.internal.queue.a<>(i2);
        }

        public void a() {
            this.f28715e = true;
            g();
        }

        public void a(T t2) {
            if (!this.f28715e && !e()) {
                if (t2 == null) {
                    a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f28713c.a(t2);
                g();
            }
        }

        public boolean b(Throwable th) {
            if (this.f28715e || e()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f28714d = th;
            this.f28715e = true;
            g();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f28716f.getAndIncrement() == 0) {
                this.f28713c.v_();
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            g();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            if (this.f28716f.getAndIncrement() == 0) {
                oj.b bVar = this.f28711a;
                io.reactivex.internal.queue.a<T> aVar = this.f28713c;
                int i2 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (j3 != j2) {
                        if (e()) {
                            aVar.v_();
                            return;
                        }
                        boolean z2 = this.f28715e;
                        T w_ = aVar.w_();
                        boolean z3 = w_ == null;
                        if (z2 && z3) {
                            Throwable th = this.f28714d;
                            if (th != null) {
                                c(th);
                                return;
                            } else {
                                b();
                                return;
                            }
                        } else if (z3) {
                            break;
                        } else {
                            bVar.onNext(w_);
                            j3++;
                        }
                    }
                    if (j3 == j2) {
                        if (e()) {
                            aVar.v_();
                            return;
                        }
                        boolean z4 = this.f28715e;
                        boolean b2 = aVar.b();
                        if (z4 && b2) {
                            Throwable th2 = this.f28714d;
                            if (th2 != null) {
                                c(th2);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        a.b(this, j3);
                    }
                    i2 = this.f28716f.addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(oj.b<? super T> bVar) {
            super(bVar);
        }

        /* access modifiers changed from: package-private */
        public void g() {
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(oj.b<? super T> bVar) {
            super(bVar);
        }

        /* access modifiers changed from: package-private */
        public void g() {
            a((Throwable) new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<T> f28717c = new AtomicReference<>();

        /* renamed from: d  reason: collision with root package name */
        Throwable f28718d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f28719e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f28720f = new AtomicInteger();

        LatestAsyncEmitter(oj.b<? super T> bVar) {
            super(bVar);
        }

        public void a() {
            this.f28719e = true;
            g();
        }

        public void a(T t2) {
            if (!this.f28719e && !e()) {
                if (t2 == null) {
                    a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                    return;
                }
                this.f28717c.set(t2);
                g();
            }
        }

        public boolean b(Throwable th) {
            if (this.f28719e || e()) {
                return false;
            }
            if (th == null) {
                a((Throwable) new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f28718d = th;
            this.f28719e = true;
            g();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (this.f28720f.getAndIncrement() == 0) {
                this.f28717c.lazySet((Object) null);
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            g();
        }

        /* access modifiers changed from: package-private */
        public void g() {
            boolean z2;
            if (this.f28720f.getAndIncrement() == 0) {
                oj.b bVar = this.f28711a;
                AtomicReference<T> atomicReference = this.f28717c;
                int i2 = 1;
                do {
                    long j2 = get();
                    long j3 = 0;
                    while (true) {
                        z2 = false;
                        if (j3 == j2) {
                            break;
                        } else if (e()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        } else {
                            boolean z3 = this.f28719e;
                            T andSet = atomicReference.getAndSet((Object) null);
                            boolean z4 = andSet == null;
                            if (z3 && z4) {
                                Throwable th = this.f28718d;
                                if (th != null) {
                                    c(th);
                                    return;
                                } else {
                                    b();
                                    return;
                                }
                            } else if (z4) {
                                break;
                            } else {
                                bVar.onNext(andSet);
                                j3++;
                            }
                        }
                    }
                    if (j3 == j2) {
                        if (e()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        }
                        boolean z5 = this.f28719e;
                        if (atomicReference.get() == null) {
                            z2 = true;
                        }
                        if (z5 && z2) {
                            Throwable th2 = this.f28718d;
                            if (th2 != null) {
                                c(th2);
                                return;
                            } else {
                                b();
                                return;
                            }
                        }
                    }
                    if (j3 != 0) {
                        a.b(this, j3);
                    }
                    i2 = this.f28720f.addAndGet(-i2);
                } while (i2 != 0);
            }
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(oj.b<? super T> bVar) {
            super(bVar);
        }

        public void a(T t2) {
            long j2;
            if (!e()) {
                if (t2 != null) {
                    this.f28711a.onNext(t2);
                    do {
                        j2 = get();
                        if (j2 == 0 || compareAndSet(j2, j2 - 1)) {
                            return;
                        }
                        j2 = get();
                        return;
                    } while (compareAndSet(j2, j2 - 1));
                    return;
                }
                a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(oj.b<? super T> bVar) {
            super(bVar);
        }

        public final void a(T t2) {
            if (!e()) {
                if (t2 == null) {
                    a((Throwable) new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else if (get() != 0) {
                    this.f28711a.onNext(t2);
                    a.b(this, 1);
                } else {
                    g();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void g();
    }

    public FlowableCreate(d<T> dVar, BackpressureStrategy backpressureStrategy) {
        this.f28708b = dVar;
        this.f28709c = backpressureStrategy;
    }

    public void b(oj.b<? super T> bVar) {
        int i2 = AnonymousClass1.f28710a[this.f28709c.ordinal()];
        BaseEmitter bufferAsyncEmitter = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new BufferAsyncEmitter(bVar, a()) : new LatestAsyncEmitter(bVar) : new DropAsyncEmitter(bVar) : new ErrorAsyncEmitter(bVar) : new MissingEmitter(bVar);
        bVar.onSubscribe(bufferAsyncEmitter);
        try {
            this.f28708b.subscribe(bufferAsyncEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            bufferAsyncEmitter.a(th);
        }
    }
}
