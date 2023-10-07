package y;

import y.b;

public final class d extends b<d> {

    /* renamed from: w  reason: collision with root package name */
    private e f34674w = null;

    /* renamed from: x  reason: collision with root package name */
    private float f34675x = Float.MAX_VALUE;

    /* renamed from: y  reason: collision with root package name */
    private boolean f34676y = false;

    public <K> d(K k2, c<K> cVar) {
        super(k2, cVar);
    }

    private void e() {
        e eVar = this.f34674w;
        if (eVar != null) {
            double a2 = (double) eVar.a();
            if (a2 > ((double) this.f34665u)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (a2 < ((double) this.f34666v)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public d a(e eVar) {
        this.f34674w = eVar;
        return this;
    }

    public void a() {
        e();
        this.f34674w.a((double) d());
        super.a();
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, float f3) {
        return this.f34674w.a(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public boolean b(long j2) {
        long j3;
        double d2;
        double d3;
        e eVar;
        if (this.f34676y) {
            float f2 = this.f34675x;
            if (f2 != Float.MAX_VALUE) {
                this.f34674w.c(f2);
                this.f34675x = Float.MAX_VALUE;
            }
            this.f34660p = this.f34674w.a();
            this.f34659o = 0.0f;
            this.f34676y = false;
            return true;
        }
        if (this.f34675x != Float.MAX_VALUE) {
            this.f34674w.a();
            j3 = j2 / 2;
            b.a a2 = this.f34674w.a((double) this.f34660p, (double) this.f34659o, j3);
            this.f34674w.c(this.f34675x);
            this.f34675x = Float.MAX_VALUE;
            eVar = this.f34674w;
            d3 = (double) a2.f34671a;
            d2 = (double) a2.f34672b;
        } else {
            eVar = this.f34674w;
            d3 = (double) this.f34660p;
            d2 = (double) this.f34659o;
            j3 = j2;
        }
        b.a a3 = eVar.a(d3, d2, j3);
        this.f34660p = a3.f34671a;
        this.f34659o = a3.f34672b;
        this.f34660p = Math.max(this.f34660p, this.f34666v);
        this.f34660p = Math.min(this.f34660p, this.f34665u);
        if (!a(this.f34660p, this.f34659o)) {
            return false;
        }
        this.f34660p = this.f34674w.a();
        this.f34659o = 0.0f;
        return true;
    }

    public void c(float f2) {
        if (c()) {
            this.f34675x = f2;
            return;
        }
        if (this.f34674w == null) {
            this.f34674w = new e(f2);
        }
        this.f34674w.c(f2);
        a();
    }
}
