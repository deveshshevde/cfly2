package androidx.activity;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.n;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    final ArrayDeque<b> f443a;

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f444b;

    private class LifecycleOnBackPressedCancellable implements a, k {

        /* renamed from: b  reason: collision with root package name */
        private final Lifecycle f446b;

        /* renamed from: c  reason: collision with root package name */
        private final b f447c;

        /* renamed from: d  reason: collision with root package name */
        private a f448d;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle, b bVar) {
            this.f446b = lifecycle;
            this.f447c = bVar;
            lifecycle.a(this);
        }

        public void a() {
            this.f446b.b(this);
            this.f447c.b(this);
            a aVar = this.f448d;
            if (aVar != null) {
                aVar.a();
                this.f448d = null;
            }
        }

        public void a(n nVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f448d = OnBackPressedDispatcher.this.a(this.f447c);
            } else if (event == Lifecycle.Event.ON_STOP) {
                a aVar = this.f448d;
                if (aVar != null) {
                    aVar.a();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                a();
            }
        }
    }

    private class a implements a {

        /* renamed from: b  reason: collision with root package name */
        private final b f450b;

        a(b bVar) {
            this.f450b = bVar;
        }

        public void a() {
            OnBackPressedDispatcher.this.f443a.remove(this.f450b);
            this.f450b.b(this);
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f443a = new ArrayDeque<>();
        this.f444b = runnable;
    }

    /* access modifiers changed from: package-private */
    public a a(b bVar) {
        this.f443a.add(bVar);
        a aVar = new a(bVar);
        bVar.a((a) aVar);
        return aVar;
    }

    public void a() {
        Iterator<b> descendingIterator = this.f443a.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.a()) {
                next.c();
                return;
            }
        }
        Runnable runnable = this.f444b;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(n nVar, b bVar) {
        Lifecycle lifecycle = nVar.getLifecycle();
        if (lifecycle.a() != Lifecycle.State.DESTROYED) {
            bVar.a((a) new LifecycleOnBackPressedCancellable(lifecycle, bVar));
        }
    }
}
