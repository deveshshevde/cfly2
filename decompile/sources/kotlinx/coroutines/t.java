package kotlinx.coroutines;

import kotlin.l;
import mm.b;

final class t {
    private volatile Object _cancelHandler;
    private volatile Object _onCancellation;

    /* renamed from: a  reason: collision with root package name */
    public final Object f30509a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f30510b;

    /* renamed from: c  reason: collision with root package name */
    public final Throwable f30511c;

    public t(Object obj, h hVar, b<? super Throwable, l> bVar, Object obj2, Throwable th) {
        this.f30509a = obj;
        this.f30510b = obj2;
        this.f30511c = th;
        this._cancelHandler = hVar;
        this._onCancellation = bVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(Object obj, h hVar, b bVar, Object obj2, Throwable th, int i2, f fVar) {
        this(obj, (i2 & 2) != 0 ? null : hVar, (i2 & 4) != 0 ? null : bVar, (i2 & 8) != 0 ? null : obj2, (i2 & 16) != 0 ? null : th);
    }

    public static /* synthetic */ t a(t tVar, Object obj, h hVar, b<Throwable, l> bVar, Object obj2, Throwable th, int i2, Object obj3) {
        if ((i2 & 1) != 0) {
            obj = tVar.f30509a;
        }
        if ((i2 & 2) != 0) {
            hVar = tVar.a();
        }
        h hVar2 = hVar;
        if ((i2 & 4) != 0) {
            bVar = tVar.b();
        }
        b<Throwable, l> bVar2 = bVar;
        if ((i2 & 8) != 0) {
            obj2 = tVar.f30510b;
        }
        Object obj4 = obj2;
        if ((i2 & 16) != 0) {
            th = tVar.f30511c;
        }
        return tVar.a(obj, hVar2, bVar2, obj4, th);
    }

    public final h a() {
        return (h) this._cancelHandler;
    }

    public final t a(Object obj, h hVar, b<? super Throwable, l> bVar, Object obj2, Throwable th) {
        return new t(obj, hVar, bVar, obj2, th);
    }

    public final void a(k<?> kVar, Throwable th) {
        h a2 = a();
        if (a2 != null) {
            kVar.a(a2, th);
        }
        b<Throwable, l> b2 = b();
        if (b2 != null) {
            kVar.a((b<? super Throwable, l>) b2, th);
        }
        d();
    }

    public final b<Throwable, l> b() {
        return (b) this._onCancellation;
    }

    public final boolean c() {
        return this.f30511c != null;
    }

    public final void d() {
        this._cancelHandler = null;
        this._onCancellation = null;
    }
}
