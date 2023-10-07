package kotlinx.coroutines;

import kotlinx.coroutines.internal.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public abstract class at extends aa {

    /* renamed from: b  reason: collision with root package name */
    private long f30321b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30322d;

    /* renamed from: e  reason: collision with root package name */
    private a<an<?>> f30323e;

    public static /* synthetic */ void a(at atVar, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            atVar.a(z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    private final long c(boolean z2) {
        if (z2) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1;
    }

    public final void a(an<?> anVar) {
        a<an<?>> aVar = this.f30323e;
        if (aVar == null) {
            aVar = new a<>();
            this.f30323e = aVar;
        }
        aVar.a(anVar);
    }

    public final void a(boolean z2) {
        this.f30321b += c(z2);
        if (!z2) {
            this.f30322d = true;
        }
    }

    public long b() {
        return !e() ? Long.MAX_VALUE : 0;
    }

    public final void b(boolean z2) {
        long c2 = this.f30321b - c(z2);
        this.f30321b = c2;
        if (c2 <= 0) {
            if (ag.a()) {
                if (!(this.f30321b == 0)) {
                    throw new AssertionError();
                }
            }
            if (this.f30322d) {
                h();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return g();
    }

    /* access modifiers changed from: protected */
    public long d() {
        a<an<?>> aVar = this.f30323e;
        return (aVar == null || aVar.a()) ? Long.MAX_VALUE : 0;
    }

    public final boolean e() {
        an b2;
        a<an<?>> aVar = this.f30323e;
        if (aVar == null || (b2 = aVar.b()) == null) {
            return false;
        }
        b2.run();
        return true;
    }

    public final boolean f() {
        return this.f30321b >= c(true);
    }

    public final boolean g() {
        a<an<?>> aVar = this.f30323e;
        if (aVar != null) {
            return aVar.a();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void h() {
    }
}
