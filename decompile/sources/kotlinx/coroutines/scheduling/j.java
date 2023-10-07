package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.ah;

public final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    public final Runnable f30497a;

    public j(Runnable runnable, long j2, i iVar) {
        super(j2, iVar);
        this.f30497a = runnable;
    }

    public void run() {
        try {
            this.f30497a.run();
        } finally {
            this.f30496g.a();
        }
    }

    public String toString() {
        return "Task[" + ah.b(this.f30497a) + '@' + ah.a((Object) this.f30497a) + ", " + this.f30495f + ", " + this.f30496g + ']';
    }
}
