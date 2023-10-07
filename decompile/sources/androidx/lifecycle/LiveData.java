package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f3570b = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f3571a = new Object();

    /* renamed from: c  reason: collision with root package name */
    int f3572c = 0;

    /* renamed from: d  reason: collision with root package name */
    volatile Object f3573d;

    /* renamed from: e  reason: collision with root package name */
    private h.b<t<? super T>, LiveData<T>.b> f3574e = new h.b<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f3575f;

    /* renamed from: g  reason: collision with root package name */
    private volatile Object f3576g;

    /* renamed from: h  reason: collision with root package name */
    private int f3577h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3578i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3579j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f3580k;

    class LifecycleBoundObserver extends LiveData<T>.b implements k {

        /* renamed from: a  reason: collision with root package name */
        final n f3582a;

        LifecycleBoundObserver(n nVar, t<? super T> tVar) {
            super(tVar);
            this.f3582a = nVar;
        }

        public void a(n nVar, Lifecycle.Event event) {
            Lifecycle.State a2 = this.f3582a.getLifecycle().a();
            if (a2 == Lifecycle.State.DESTROYED) {
                LiveData.this.b(this.f3585c);
                return;
            }
            Lifecycle.State state = null;
            while (state != a2) {
                a(a());
                state = a2;
                a2 = this.f3582a.getLifecycle().a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f3582a.getLifecycle().a().a(Lifecycle.State.STARTED);
        }

        /* access modifiers changed from: package-private */
        public boolean a(n nVar) {
            return this.f3582a == nVar;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3582a.getLifecycle().b(this);
        }
    }

    private class a extends LiveData<T>.b {
        a(t<? super T> tVar) {
            super(tVar);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return true;
        }
    }

    private abstract class b {

        /* renamed from: c  reason: collision with root package name */
        final t<? super T> f3585c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3586d;

        /* renamed from: e  reason: collision with root package name */
        int f3587e = -1;

        b(t<? super T> tVar) {
            this.f3585c = tVar;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z2) {
            if (z2 != this.f3586d) {
                this.f3586d = z2;
                LiveData.this.a(z2 ? 1 : -1);
                if (this.f3586d) {
                    LiveData.this.a((LiveData<T>.b) this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a();

        /* access modifiers changed from: package-private */
        public boolean a(n nVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }
    }

    public LiveData() {
        Object obj = f3570b;
        this.f3573d = obj;
        this.f3580k = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f3571a) {
                    obj = LiveData.this.f3573d;
                    LiveData.this.f3573d = LiveData.f3570b;
                }
                LiveData.this.b(obj);
            }
        };
        this.f3576g = obj;
        this.f3577h = -1;
    }

    static void a(String str) {
        if (!g.a.a().c()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void b(LiveData<T>.b bVar) {
        if (bVar.f3586d) {
            if (!bVar.a()) {
                bVar.a(false);
                return;
            }
            int i2 = bVar.f3587e;
            int i3 = this.f3577h;
            if (i2 < i3) {
                bVar.f3587e = i3;
                bVar.f3585c.onChanged(this.f3576g);
            }
        }
    }

    public T a() {
        T t2 = this.f3576g;
        if (t2 != f3570b) {
            return t2;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        int i3 = this.f3572c;
        this.f3572c = i2 + i3;
        if (!this.f3575f) {
            this.f3575f = true;
            while (true) {
                try {
                    int i4 = this.f3572c;
                    if (i3 != i4) {
                        boolean z2 = i3 == 0 && i4 > 0;
                        boolean z3 = i3 > 0 && i4 == 0;
                        if (z2) {
                            b();
                        } else if (z3) {
                            c();
                        }
                        i3 = i4;
                    } else {
                        return;
                    }
                } finally {
                    this.f3575f = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(LiveData<T>.b bVar) {
        if (this.f3578i) {
            this.f3579j = true;
            return;
        }
        this.f3578i = true;
        do {
            this.f3579j = false;
            if (bVar == null) {
                h.b<K, V>.d c2 = this.f3574e.c();
                while (c2.hasNext()) {
                    b((LiveData<T>.b) (b) ((Map.Entry) c2.next()).getValue());
                    if (this.f3579j) {
                        break;
                    }
                }
            } else {
                b(bVar);
                bVar = null;
            }
        } while (this.f3579j);
        this.f3578i = false;
    }

    public void a(n nVar, t<? super T> tVar) {
        a("observe");
        if (nVar.getLifecycle().a() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(nVar, tVar);
            b a2 = this.f3574e.a(tVar, lifecycleBoundObserver);
            if (a2 != null && !a2.a(nVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (a2 == null) {
                nVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void a(t<? super T> tVar) {
        a("observeForever");
        a aVar = new a(tVar);
        b a2 = this.f3574e.a(tVar, aVar);
        if (a2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (a2 == null) {
            aVar.a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t2) {
        boolean z2;
        synchronized (this.f3571a) {
            z2 = this.f3573d == f3570b;
            this.f3573d = t2;
        }
        if (z2) {
            g.a.a().b(this.f3580k);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void b(t<? super T> tVar) {
        a("removeObserver");
        b b2 = this.f3574e.b(tVar);
        if (b2 != null) {
            b2.b();
            b2.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void b(T t2) {
        a("setValue");
        this.f3577h++;
        this.f3576g = t2;
        a((LiveData<T>.b) null);
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public boolean d() {
        return this.f3572c > 0;
    }
}
