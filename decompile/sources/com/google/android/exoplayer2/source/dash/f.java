package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.b;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.util.ad;
import fi.e;
import fu.d;
import java.io.IOException;

final class f implements o {

    /* renamed from: a  reason: collision with root package name */
    private final Format f16128a;

    /* renamed from: b  reason: collision with root package name */
    private final b f16129b = new b();

    /* renamed from: c  reason: collision with root package name */
    private long[] f16130c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16131d;

    /* renamed from: e  reason: collision with root package name */
    private d f16132e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16133f;

    /* renamed from: g  reason: collision with root package name */
    private int f16134g;

    /* renamed from: h  reason: collision with root package name */
    private long f16135h = -9223372036854775807L;

    public f(d dVar, Format format, boolean z2) {
        this.f16128a = format;
        this.f16132e = dVar;
        this.f16130c = dVar.f28134b;
        a(dVar, z2);
    }

    public int a(com.google.android.exoplayer2.o oVar, e eVar, boolean z2) {
        if (z2 || !this.f16133f) {
            oVar.f15972c = this.f16128a;
            this.f16133f = true;
            return -5;
        }
        int i2 = this.f16134g;
        if (i2 != this.f16130c.length) {
            this.f16134g = i2 + 1;
            byte[] a2 = this.f16129b.a(this.f16132e.f28133a[i2]);
            if (a2 == null) {
                return -3;
            }
            eVar.b(a2.length);
            eVar.f13099b.put(a2);
            eVar.f13101d = this.f16130c[i2];
            eVar.setFlags(1);
            return -4;
        } else if (this.f16131d) {
            return -3;
        } else {
            eVar.setFlags(4);
            return -4;
        }
    }

    public String a() {
        return this.f16132e.a();
    }

    public void a(d dVar, boolean z2) {
        int i2 = this.f16134g;
        long j2 = i2 == 0 ? -9223372036854775807L : this.f16130c[i2 - 1];
        this.f16131d = z2;
        this.f16132e = dVar;
        long[] jArr = dVar.f28134b;
        this.f16130c = jArr;
        long j3 = this.f16135h;
        if (j3 != -9223372036854775807L) {
            b(j3);
        } else if (j2 != -9223372036854775807L) {
            this.f16134g = ad.b(jArr, j2, false, false);
        }
    }

    public int a_(long j2) {
        int max = Math.max(this.f16134g, ad.b(this.f16130c, j2, true, false));
        int i2 = max - this.f16134g;
        this.f16134g = max;
        return i2;
    }

    public void b(long j2) {
        boolean z2 = true;
        int b2 = ad.b(this.f16130c, j2, true, false);
        this.f16134g = b2;
        if (!this.f16131d || b2 != this.f16130c.length) {
            z2 = false;
        }
        if (!z2) {
            j2 = -9223372036854775807L;
        }
        this.f16135h = j2;
    }

    public boolean b() {
        return true;
    }

    public void c() throws IOException {
    }
}
