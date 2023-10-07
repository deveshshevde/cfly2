package com.google.android.exoplayer2.source;

public class c implements p {

    /* renamed from: a  reason: collision with root package name */
    protected final p[] f16027a;

    public c(p[] pVarArr) {
        this.f16027a = pVarArr;
    }

    public final void a(long j2) {
        for (p a2 : this.f16027a) {
            a2.a(j2);
        }
    }

    public boolean c(long j2) {
        long j3 = j2;
        boolean z2 = false;
        while (true) {
            long e2 = e();
            if (e2 != Long.MIN_VALUE) {
                boolean z3 = false;
                for (p pVar : this.f16027a) {
                    long e3 = pVar.e();
                    boolean z4 = e3 != Long.MIN_VALUE && e3 <= j3;
                    if (e3 == e2 || z4) {
                        z3 |= pVar.c(j3);
                    }
                }
                z2 |= z3;
                if (!z3) {
                    break;
                }
            } else {
                break;
            }
        }
        return z2;
    }

    public final long d() {
        long j2 = Long.MAX_VALUE;
        for (p d2 : this.f16027a) {
            long d3 = d2.d();
            if (d3 != Long.MIN_VALUE) {
                j2 = Math.min(j2, d3);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public final long e() {
        long j2 = Long.MAX_VALUE;
        for (p e2 : this.f16027a) {
            long e3 = e2.e();
            if (e3 != Long.MIN_VALUE) {
                j2 = Math.min(j2, e3);
            }
        }
        if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j2;
    }

    public boolean f() {
        for (p f2 : this.f16027a) {
            if (f2.f()) {
                return true;
            }
        }
        return false;
    }
}
