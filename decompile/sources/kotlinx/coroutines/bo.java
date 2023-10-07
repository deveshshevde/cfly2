package kotlinx.coroutines;

import java.util.Objects;
import kotlin.coroutines.c;
import kotlin.coroutines.f;
import kotlin.coroutines.intrinsics.a;
import kotlin.l;
import mm.m;

final class bo extends bu {

    /* renamed from: c  reason: collision with root package name */
    private final Object f30363c;

    public bo(f fVar, m<? super af, ? super c<? super l>, ? extends Object> mVar) {
        super(fVar, false);
        this.f30363c = a.a(mVar, this, this);
    }

    /* access modifiers changed from: protected */
    public void d() {
        Object obj = this.f30363c;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        mu.a.a((c) obj, this);
    }
}
