package androidx.lifecycle;

import java.util.Queue;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3612a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3613b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3614c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Runnable> f3615d;

    private final boolean e() {
        return this.f3613b || !this.f3612a;
    }

    public final void a() {
        this.f3612a = true;
    }

    public final void b() {
        if (this.f3612a) {
            if (!this.f3613b) {
                this.f3612a = false;
                d();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }

    public final void c() {
        this.f3613b = true;
        d();
    }

    public final void d() {
        if (!this.f3614c) {
            boolean z2 = false;
            z2 = true;
            try {
                while (true) {
                    if (!(this.f3615d.isEmpty() ^ z2)) {
                        break;
                    } else if (!e()) {
                        break;
                    } else {
                        Runnable poll = this.f3615d.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.f3614c = z2;
            } finally {
                this.f3614c = z2;
            }
        }
    }
}
