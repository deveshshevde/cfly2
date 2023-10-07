package org.greenrobot.eventbus;

class a implements Runnable, k {

    /* renamed from: a  reason: collision with root package name */
    private final j f13993a = new j();

    /* renamed from: b  reason: collision with root package name */
    private final c f13994b;

    a(c cVar) {
        this.f13994b = cVar;
    }

    public void a(p pVar, Object obj) {
        this.f13993a.a(i.a(pVar, obj));
        this.f13994b.c().execute(this);
    }

    public void run() {
        i a2 = this.f13993a.a();
        if (a2 != null) {
            this.f13994b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
