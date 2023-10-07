package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.z;
import fi.e;
import java.io.IOException;

public abstract class d implements aa, z {

    /* renamed from: a  reason: collision with root package name */
    private final int f15421a;

    /* renamed from: b  reason: collision with root package name */
    private final o f15422b = new o();

    /* renamed from: c  reason: collision with root package name */
    private ab f15423c;

    /* renamed from: d  reason: collision with root package name */
    private int f15424d;

    /* renamed from: e  reason: collision with root package name */
    private int f15425e;

    /* renamed from: f  reason: collision with root package name */
    private o f15426f;

    /* renamed from: g  reason: collision with root package name */
    private Format[] f15427g;

    /* renamed from: h  reason: collision with root package name */
    private long f15428h;

    /* renamed from: i  reason: collision with root package name */
    private long f15429i = Long.MIN_VALUE;

    /* renamed from: j  reason: collision with root package name */
    private boolean f15430j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f15431k;

    public d(int i2) {
        this.f15421a = i2;
    }

    protected static boolean a(b<?> bVar, DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (bVar == null) {
            return false;
        }
        return bVar.a(drmInitData);
    }

    public final int a() {
        return this.f15421a;
    }

    /* access modifiers changed from: protected */
    public final int a(o oVar, e eVar, boolean z2) {
        int a2 = this.f15426f.a(oVar, eVar, z2);
        if (a2 == -4) {
            if (eVar.isEndOfStream()) {
                this.f15429i = Long.MIN_VALUE;
                return this.f15430j ? -4 : -3;
            }
            eVar.f13101d += this.f15428h;
            this.f15429i = Math.max(this.f15429i, eVar.f13101d);
        } else if (a2 == -5) {
            Format format = oVar.f15972c;
            if (format.f15096m != Long.MAX_VALUE) {
                oVar.f15972c = format.a(format.f15096m + this.f15428h);
            }
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public final ExoPlaybackException a(Exception exc, Format format) {
        int i2;
        if (format != null && !this.f15431k) {
            this.f15431k = true;
            try {
                i2 = aa.CC.c(a(format));
            } catch (ExoPlaybackException unused) {
            } finally {
                this.f15431k = false;
            }
            return ExoPlaybackException.a(exc, w(), format, i2);
        }
        i2 = 4;
        return ExoPlaybackException.a(exc, w(), format, i2);
    }

    /* access modifiers changed from: protected */
    public final <T extends com.google.android.exoplayer2.drm.d> DrmSession<T> a(Format format, Format format2, b<T> bVar, DrmSession<T> drmSession) throws ExoPlaybackException {
        DrmSession<T> drmSession2 = null;
        if (!(!ad.a((Object) format2.f15095l, (Object) format == null ? null : format.f15095l))) {
            return drmSession;
        }
        if (format2.f15095l != null) {
            if (bVar != null) {
                drmSession2 = bVar.a((Looper) a.b(Looper.myLooper()), format2.f15095l);
            } else {
                throw a((Exception) new IllegalStateException("Media requires a DrmSessionManager"), format2);
            }
        }
        if (drmSession != null) {
            drmSession.i();
        }
        return drmSession2;
    }

    public /* synthetic */ void a(float f2) {
        z.CC.$default$a(this, f2);
    }

    public final void a(int i2) {
        this.f15424d = i2;
    }

    public void a(int i2, Object obj) throws ExoPlaybackException {
    }

    public final void a(long j2) throws ExoPlaybackException {
        this.f15430j = false;
        this.f15429i = j2;
        a(j2, false);
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws ExoPlaybackException {
    }

    public final void a(ab abVar, Format[] formatArr, o oVar, long j2, boolean z2, long j3) throws ExoPlaybackException {
        a.b(this.f15425e == 0);
        this.f15423c = abVar;
        this.f15425e = 1;
        a(z2);
        a(formatArr, oVar, j3);
        a(j2, z2);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) throws ExoPlaybackException {
    }

    public final void a(Format[] formatArr, o oVar, long j2) throws ExoPlaybackException {
        a.b(!this.f15430j);
        this.f15426f = oVar;
        this.f15429i = j2;
        this.f15427g = formatArr;
        this.f15428h = j2;
        a(formatArr, j2);
    }

    /* access modifiers changed from: protected */
    public int b(long j2) {
        return this.f15426f.a_(j2 - this.f15428h);
    }

    public final aa b() {
        return this;
    }

    public m c() {
        return null;
    }

    public final void e() throws ExoPlaybackException {
        boolean z2 = true;
        if (this.f15425e != 1) {
            z2 = false;
        }
        a.b(z2);
        this.f15425e = 2;
        p();
    }

    public final o f() {
        return this.f15426f;
    }

    public final boolean g() {
        return this.f15429i == Long.MIN_VALUE;
    }

    public final long h() {
        return this.f15429i;
    }

    public final void i() {
        this.f15430j = true;
    }

    public final boolean j() {
        return this.f15430j;
    }

    public final void k() throws IOException {
        this.f15426f.c();
    }

    public final void l() throws ExoPlaybackException {
        a.b(this.f15425e == 2);
        this.f15425e = 1;
        q();
    }

    public final void m() {
        boolean z2 = true;
        if (this.f15425e != 1) {
            z2 = false;
        }
        a.b(z2);
        this.f15422b.a();
        this.f15425e = 0;
        this.f15426f = null;
        this.f15427g = null;
        this.f15430j = false;
        r();
    }

    public final int m_() {
        return this.f15425e;
    }

    public final void n() {
        a.b(this.f15425e == 0);
        this.f15422b.a();
        s();
    }

    public int o() throws ExoPlaybackException {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void p() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void q() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void r() {
    }

    /* access modifiers changed from: protected */
    public void s() {
    }

    /* access modifiers changed from: protected */
    public final o t() {
        this.f15422b.a();
        return this.f15422b;
    }

    /* access modifiers changed from: protected */
    public final Format[] u() {
        return this.f15427g;
    }

    /* access modifiers changed from: protected */
    public final ab v() {
        return this.f15423c;
    }

    /* access modifiers changed from: protected */
    public final int w() {
        return this.f15424d;
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return g() ? this.f15430j : this.f15426f.b();
    }
}
