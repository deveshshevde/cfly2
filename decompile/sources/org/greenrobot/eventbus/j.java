package org.greenrobot.eventbus;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private i f14052a;

    /* renamed from: b  reason: collision with root package name */
    private i f14053b;

    j() {
    }

    /* access modifiers changed from: package-private */
    public synchronized i a() {
        i iVar;
        iVar = this.f14052a;
        if (iVar != null) {
            i iVar2 = iVar.f14051c;
            this.f14052a = iVar2;
            if (iVar2 == null) {
                this.f14053b = null;
            }
        }
        return iVar;
    }

    /* access modifiers changed from: package-private */
    public synchronized i a(int i2) throws InterruptedException {
        if (this.f14052a == null) {
            wait((long) i2);
        }
        return a();
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(i iVar) {
        if (iVar != null) {
            try {
                i iVar2 = this.f14053b;
                if (iVar2 != null) {
                    iVar2.f14051c = iVar;
                    this.f14053b = iVar;
                } else if (this.f14052a == null) {
                    this.f14053b = iVar;
                    this.f14052a = iVar;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }
}
