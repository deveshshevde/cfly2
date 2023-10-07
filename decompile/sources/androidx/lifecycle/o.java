package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import h.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class o extends Lifecycle {

    /* renamed from: b  reason: collision with root package name */
    private h.a<m, a> f3622b;

    /* renamed from: c  reason: collision with root package name */
    private Lifecycle.State f3623c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakReference<n> f3624d;

    /* renamed from: e  reason: collision with root package name */
    private int f3625e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3626f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3627g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Lifecycle.State> f3628h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f3629i;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        Lifecycle.State f3630a;

        /* renamed from: b  reason: collision with root package name */
        k f3631b;

        a(m mVar, Lifecycle.State state) {
            this.f3631b = q.a((Object) mVar);
            this.f3630a = state;
        }

        /* access modifiers changed from: package-private */
        public void a(n nVar, Lifecycle.Event event) {
            Lifecycle.State a2 = event.a();
            this.f3630a = o.a(this.f3630a, a2);
            this.f3631b.a(nVar, event);
            this.f3630a = a2;
        }
    }

    public o(n nVar) {
        this(nVar, true);
    }

    private o(n nVar, boolean z2) {
        this.f3622b = new h.a<>();
        this.f3625e = 0;
        this.f3626f = false;
        this.f3627g = false;
        this.f3628h = new ArrayList<>();
        this.f3624d = new WeakReference<>(nVar);
        this.f3623c = Lifecycle.State.INITIALIZED;
        this.f3629i = z2;
    }

    static Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    private void a(n nVar) {
        b<K, V>.d c2 = this.f3622b.c();
        while (c2.hasNext() && !this.f3627g) {
            Map.Entry entry = (Map.Entry) c2.next();
            a aVar = (a) entry.getValue();
            while (aVar.f3630a.compareTo(this.f3623c) < 0 && !this.f3627g && this.f3622b.c(entry.getKey())) {
                d(aVar.f3630a);
                Lifecycle.Event b2 = Lifecycle.Event.b(aVar.f3630a);
                if (b2 != null) {
                    aVar.a(nVar, b2);
                    c();
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3630a);
                }
            }
        }
    }

    private void a(String str) {
        if (this.f3629i && !g.a.a().c()) {
            throw new IllegalStateException("Method " + str + " must be called on the main thread");
        }
    }

    private void b(n nVar) {
        Iterator<Map.Entry<m, a>> b2 = this.f3622b.b();
        while (b2.hasNext() && !this.f3627g) {
            Map.Entry next = b2.next();
            a aVar = (a) next.getValue();
            while (aVar.f3630a.compareTo(this.f3623c) > 0 && !this.f3627g && this.f3622b.c(next.getKey())) {
                Lifecycle.Event a2 = Lifecycle.Event.a(aVar.f3630a);
                if (a2 != null) {
                    d(a2.a());
                    aVar.a(nVar, a2);
                    c();
                } else {
                    throw new IllegalStateException("no event down from " + aVar.f3630a);
                }
            }
        }
    }

    private boolean b() {
        if (this.f3622b.a() == 0) {
            return true;
        }
        Lifecycle.State state = this.f3622b.d().getValue().f3630a;
        Lifecycle.State state2 = this.f3622b.e().getValue().f3630a;
        return state == state2 && this.f3623c == state2;
    }

    private Lifecycle.State c(m mVar) {
        Map.Entry<m, a> d2 = this.f3622b.d(mVar);
        Lifecycle.State state = null;
        Lifecycle.State state2 = d2 != null ? d2.getValue().f3630a : null;
        if (!this.f3628h.isEmpty()) {
            ArrayList<Lifecycle.State> arrayList = this.f3628h;
            state = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.f3623c, state2), state);
    }

    private void c() {
        ArrayList<Lifecycle.State> arrayList = this.f3628h;
        arrayList.remove(arrayList.size() - 1);
    }

    private void c(Lifecycle.State state) {
        if (this.f3623c != state) {
            this.f3623c = state;
            if (this.f3626f || this.f3625e != 0) {
                this.f3627g = true;
                return;
            }
            this.f3626f = true;
            d();
            this.f3626f = false;
        }
    }

    private void d() {
        n nVar = (n) this.f3624d.get();
        if (nVar != null) {
            while (true) {
                boolean b2 = b();
                this.f3627g = false;
                if (!b2) {
                    if (this.f3623c.compareTo(this.f3622b.d().getValue().f3630a) < 0) {
                        b(nVar);
                    }
                    Map.Entry<m, a> e2 = this.f3622b.e();
                    if (!this.f3627g && e2 != null && this.f3623c.compareTo(e2.getValue().f3630a) > 0) {
                        a(nVar);
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }

    private void d(Lifecycle.State state) {
        this.f3628h.add(state);
    }

    public Lifecycle.State a() {
        return this.f3623c;
    }

    public void a(Lifecycle.Event event) {
        a("handleLifecycleEvent");
        c(event.a());
    }

    @Deprecated
    public void a(Lifecycle.State state) {
        a("markState");
        b(state);
    }

    public void a(m mVar) {
        n nVar;
        a("addObserver");
        a aVar = new a(mVar, this.f3623c == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.f3622b.a(mVar, aVar) == null && (nVar = (n) this.f3624d.get()) != null) {
            boolean z2 = this.f3625e != 0 || this.f3626f;
            Lifecycle.State c2 = c(mVar);
            this.f3625e++;
            while (aVar.f3630a.compareTo(c2) < 0 && this.f3622b.c(mVar)) {
                d(aVar.f3630a);
                Lifecycle.Event b2 = Lifecycle.Event.b(aVar.f3630a);
                if (b2 != null) {
                    aVar.a(nVar, b2);
                    c();
                    c2 = c(mVar);
                } else {
                    throw new IllegalStateException("no event up from " + aVar.f3630a);
                }
            }
            if (!z2) {
                d();
            }
            this.f3625e--;
        }
    }

    public void b(Lifecycle.State state) {
        a("setCurrentState");
        c(state);
    }

    public void b(m mVar) {
        a("removeObserver");
        this.f3622b.b(mVar);
    }
}
