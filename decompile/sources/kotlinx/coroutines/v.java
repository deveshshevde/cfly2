package kotlinx.coroutines;

import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    public final Object f30514a;

    /* renamed from: b  reason: collision with root package name */
    public final b<Throwable, l> f30515b;

    public v(Object obj, b<? super Throwable, l> bVar) {
        this.f30514a = obj;
        this.f30515b = bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return h.a(this.f30514a, vVar.f30514a) && h.a((Object) this.f30515b, (Object) vVar.f30515b);
    }

    public int hashCode() {
        Object obj = this.f30514a;
        int i2 = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        b<Throwable, l> bVar = this.f30515b;
        if (bVar != null) {
            i2 = bVar.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f30514a + ", onCancellation=" + this.f30515b + ")";
    }
}
