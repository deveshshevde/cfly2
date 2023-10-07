package kotlinx.coroutines;

import java.util.Objects;
import kotlinx.coroutines.bg;

public abstract class bl<J extends bg> extends w implements aq, bb {

    /* renamed from: b  reason: collision with root package name */
    public final J f30346b;

    public bl(J j2) {
        this.f30346b = j2;
    }

    public void a() {
        J j2 = this.f30346b;
        Objects.requireNonNull(j2, "null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        ((bm) j2).a((bl<?>) this);
    }

    public boolean b() {
        return true;
    }

    public String toString() {
        return ah.b(this) + '@' + ah.a((Object) this) + "[job@" + ah.a((Object) this.f30346b) + ']';
    }

    public bq z_() {
        return null;
    }
}
