package kotlinx.coroutines.internal;

import kotlin.coroutines.f;

final class ad {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f30392a;

    /* renamed from: b  reason: collision with root package name */
    private int f30393b;

    /* renamed from: c  reason: collision with root package name */
    private final f f30394c;

    public ad(f fVar, int i2) {
        this.f30394c = fVar;
        this.f30392a = new Object[i2];
    }

    public final Object a() {
        Object[] objArr = this.f30392a;
        int i2 = this.f30393b;
        this.f30393b = i2 + 1;
        return objArr[i2];
    }

    public final void a(Object obj) {
        Object[] objArr = this.f30392a;
        int i2 = this.f30393b;
        this.f30393b = i2 + 1;
        objArr[i2] = obj;
    }

    public final void b() {
        this.f30393b = 0;
    }

    public final f c() {
        return this.f30394c;
    }
}
