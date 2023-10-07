package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.b;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.w;

final class i implements m {

    /* renamed from: a  reason: collision with root package name */
    private final w f15681a;

    /* renamed from: b  reason: collision with root package name */
    private final a f15682b;

    /* renamed from: c  reason: collision with root package name */
    private z f15683c;

    /* renamed from: d  reason: collision with root package name */
    private m f15684d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15685e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15686f;

    public interface a {
        void a(v vVar);
    }

    public i(a aVar, b bVar) {
        this.f15682b = aVar;
        this.f15681a = new w(bVar);
    }

    private void b(boolean z2) {
        if (c(z2)) {
            this.f15685e = true;
            if (this.f15686f) {
                this.f15681a.a();
                return;
            }
            return;
        }
        long l_ = this.f15684d.l_();
        if (this.f15685e) {
            if (l_ < this.f15681a.l_()) {
                this.f15681a.b();
                return;
            }
            this.f15685e = false;
            if (this.f15686f) {
                this.f15681a.a();
            }
        }
        this.f15681a.a(l_);
        v d2 = this.f15684d.d();
        if (!d2.equals(this.f15681a.d())) {
            this.f15681a.a(d2);
            this.f15682b.a(d2);
        }
    }

    private boolean c(boolean z2) {
        z zVar = this.f15683c;
        return zVar == null || zVar.z() || (!this.f15683c.y() && (z2 || this.f15683c.g()));
    }

    public long a(boolean z2) {
        b(z2);
        return l_();
    }

    public void a() {
        this.f15686f = true;
        this.f15681a.a();
    }

    public void a(long j2) {
        this.f15681a.a(j2);
    }

    public void a(v vVar) {
        m mVar = this.f15684d;
        if (mVar != null) {
            mVar.a(vVar);
            vVar = this.f15684d.d();
        }
        this.f15681a.a(vVar);
    }

    public void a(z zVar) throws ExoPlaybackException {
        m mVar;
        m c2 = zVar.c();
        if (c2 != null && c2 != (mVar = this.f15684d)) {
            if (mVar == null) {
                this.f15684d = c2;
                this.f15683c = zVar;
                c2.a(this.f15681a.d());
                return;
            }
            throw ExoPlaybackException.a((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public void b() {
        this.f15686f = false;
        this.f15681a.b();
    }

    public void b(z zVar) {
        if (zVar == this.f15683c) {
            this.f15684d = null;
            this.f15683c = null;
            this.f15685e = true;
        }
    }

    public v d() {
        m mVar = this.f15684d;
        return mVar != null ? mVar.d() : this.f15681a.d();
    }

    public long l_() {
        return this.f15685e ? this.f15681a.l_() : this.f15684d.l_();
    }
}
