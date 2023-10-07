package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private final o f3660a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f3661b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    private a f3662c;

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle.Event f3663a;

        /* renamed from: b  reason: collision with root package name */
        private final o f3664b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3665c = false;

        a(o oVar, Lifecycle.Event event) {
            this.f3664b = oVar;
            this.f3663a = event;
        }

        public void run() {
            if (!this.f3665c) {
                this.f3664b.a(this.f3663a);
                this.f3665c = true;
            }
        }
    }

    public z(n nVar) {
        this.f3660a = new o(nVar);
    }

    private void a(Lifecycle.Event event) {
        a aVar = this.f3662c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f3660a, event);
        this.f3662c = aVar2;
        this.f3661b.postAtFrontOfQueue(aVar2);
    }

    public void a() {
        a(Lifecycle.Event.ON_CREATE);
    }

    public void b() {
        a(Lifecycle.Event.ON_START);
    }

    public void c() {
        a(Lifecycle.Event.ON_START);
    }

    public void d() {
        a(Lifecycle.Event.ON_STOP);
        a(Lifecycle.Event.ON_DESTROY);
    }

    public Lifecycle e() {
        return this.f3660a;
    }
}
