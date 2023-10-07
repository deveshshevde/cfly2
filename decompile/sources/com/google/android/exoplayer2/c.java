package com.google.android.exoplayer2;

import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.x;

public abstract class c implements x {

    /* renamed from: a  reason: collision with root package name */
    protected final af.b f15418a = new af.b();

    protected static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final x.a f15419a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f15420b;

        public a(x.a aVar) {
            this.f15419a = aVar;
        }

        public void a() {
            this.f15420b = true;
        }

        public void a(b bVar) {
            if (!this.f15420b) {
                bVar.invokeListener(this.f15419a);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f15419a.equals(((a) obj).f15419a);
        }

        public int hashCode() {
            return this.f15419a.hashCode();
        }
    }

    protected interface b {
        void invokeListener(x.a aVar);
    }

    private int r() {
        int o2 = o();
        if (o2 == 1) {
            return 0;
        }
        return o2;
    }

    public final boolean a() {
        return k() == 3 && n() && l() == 0;
    }

    public final boolean b() {
        return e() != -1;
    }

    public final boolean c() {
        return d() != -1;
    }

    public final int d() {
        af E = E();
        if (E.a()) {
            return -1;
        }
        return E.a(t(), r(), p());
    }

    public final int e() {
        af E = E();
        if (E.a()) {
            return -1;
        }
        return E.b(t(), r(), p());
    }

    public final boolean f() {
        af E = E();
        return !E.a() && E.a(t(), this.f15418a).f15178g;
    }

    public final long g() {
        af E = E();
        if (E.a()) {
            return -9223372036854775807L;
        }
        return E.a(t(), this.f15418a).c();
    }
}
