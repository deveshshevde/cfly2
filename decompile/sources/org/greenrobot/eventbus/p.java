package org.greenrobot.eventbus;

final class p {

    /* renamed from: a  reason: collision with root package name */
    final Object f14077a;

    /* renamed from: b  reason: collision with root package name */
    final n f14078b;

    /* renamed from: c  reason: collision with root package name */
    volatile boolean f14079c = true;

    p(Object obj, n nVar) {
        this.f14077a = obj;
        this.f14078b = nVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f14077a == pVar.f14077a && this.f14078b.equals(pVar.f14078b);
    }

    public int hashCode() {
        return this.f14077a.hashCode() + this.f14078b.f14063f.hashCode();
    }
}
