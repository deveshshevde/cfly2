package io.reactivex.internal.operators.observable;

import io.reactivex.disposables.b;
import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.a;
import lx.f;

public final class ObservableObserveOn<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final i f28771b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28772c;

    /* renamed from: d  reason: collision with root package name */
    final int f28773d;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements h<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f28774a;

        /* renamed from: b  reason: collision with root package name */
        final i.c f28775b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f28776c;

        /* renamed from: d  reason: collision with root package name */
        final int f28777d;

        /* renamed from: e  reason: collision with root package name */
        f<T> f28778e;

        /* renamed from: f  reason: collision with root package name */
        b f28779f;

        /* renamed from: g  reason: collision with root package name */
        Throwable f28780g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f28781h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f28782i;

        /* renamed from: j  reason: collision with root package name */
        int f28783j;

        /* renamed from: k  reason: collision with root package name */
        boolean f28784k;

        ObserveOnObserver(h<? super T> hVar, i.c cVar, boolean z2, int i2) {
            this.f28774a = hVar;
            this.f28775b = cVar;
            this.f28776c = z2;
            this.f28777d = i2;
        }

        public int a(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.f28784k = true;
            return 2;
        }

        public void a() {
            if (!this.f28781h) {
                this.f28781h = true;
                d();
            }
        }

        public void a(b bVar) {
            if (DisposableHelper.a(this.f28779f, bVar)) {
                this.f28779f = bVar;
                if (bVar instanceof lx.b) {
                    lx.b bVar2 = (lx.b) bVar;
                    int a2 = bVar2.a(7);
                    if (a2 == 1) {
                        this.f28783j = a2;
                        this.f28778e = bVar2;
                        this.f28781h = true;
                        this.f28774a.a((b) this);
                        d();
                        return;
                    } else if (a2 == 2) {
                        this.f28783j = a2;
                        this.f28778e = bVar2;
                        this.f28774a.a((b) this);
                        return;
                    }
                }
                this.f28778e = new a(this.f28777d);
                this.f28774a.a((b) this);
            }
        }

        public void a(Throwable th) {
            if (this.f28781h) {
                ly.a.a(th);
                return;
            }
            this.f28780g = th;
            this.f28781h = true;
            d();
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z2, boolean z3, h<? super T> hVar) {
            if (this.f28782i) {
                this.f28778e.v_();
                return true;
            } else if (!z2) {
                return false;
            } else {
                Throwable th = this.f28780g;
                if (this.f28776c) {
                    if (!z3) {
                        return false;
                    }
                    this.f28782i = true;
                    if (th != null) {
                        hVar.a(th);
                    } else {
                        hVar.a();
                    }
                    this.f28775b.dispose();
                    return true;
                } else if (th != null) {
                    this.f28782i = true;
                    this.f28778e.v_();
                    hVar.a(th);
                    this.f28775b.dispose();
                    return true;
                } else if (!z3) {
                    return false;
                } else {
                    this.f28782i = true;
                    hVar.a();
                    this.f28775b.dispose();
                    return true;
                }
            }
        }

        public void a_(T t2) {
            if (!this.f28781h) {
                if (this.f28783j != 2) {
                    this.f28778e.a(t2);
                }
                d();
            }
        }

        public boolean b() {
            return this.f28778e.b();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                this.f28775b.a((Runnable) this);
            }
        }

        public void dispose() {
            if (!this.f28782i) {
                this.f28782i = true;
                this.f28779f.dispose();
                this.f28775b.dispose();
                if (getAndIncrement() == 0) {
                    this.f28778e.v_();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            f<T> fVar = this.f28778e;
            h<? super T> hVar = this.f28774a;
            int i2 = 1;
            while (!a(this.f28781h, fVar.b(), hVar)) {
                while (true) {
                    boolean z2 = this.f28781h;
                    try {
                        T w_ = fVar.w_();
                        boolean z3 = w_ == null;
                        if (!a(z2, z3, hVar)) {
                            if (z3) {
                                i2 = addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            } else {
                                hVar.a_(w_);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f28782i = true;
                        this.f28779f.dispose();
                        fVar.v_();
                        hVar.a(th);
                        this.f28775b.dispose();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int i2 = 1;
            while (!this.f28782i) {
                boolean z2 = this.f28781h;
                Throwable th = this.f28780g;
                if (this.f28776c || !z2 || th == null) {
                    this.f28774a.a_(null);
                    if (z2) {
                        this.f28782i = true;
                        Throwable th2 = this.f28780g;
                        if (th2 != null) {
                            this.f28774a.a(th2);
                        } else {
                            this.f28774a.a();
                        }
                    } else {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                } else {
                    this.f28782i = true;
                    this.f28774a.a(this.f28780g);
                }
                this.f28775b.dispose();
                return;
            }
        }

        public boolean isDisposed() {
            return this.f28782i;
        }

        public void run() {
            if (this.f28784k) {
                f();
            } else {
                e();
            }
        }

        public void v_() {
            this.f28778e.v_();
        }

        public T w_() throws Exception {
            return this.f28778e.w_();
        }
    }

    public ObservableObserveOn(g<T> gVar, i iVar, boolean z2, int i2) {
        super(gVar);
        this.f28771b = iVar;
        this.f28772c = z2;
        this.f28773d = i2;
    }

    /* access modifiers changed from: protected */
    public void b(h<? super T> hVar) {
        i iVar = this.f28771b;
        if (iVar instanceof io.reactivex.internal.schedulers.h) {
            this.f28794a.a(hVar);
            return;
        }
        this.f28794a.a(new ObserveOnObserver(hVar, iVar.a(), this.f28772c, this.f28773d));
    }
}
