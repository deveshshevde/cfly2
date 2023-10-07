package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.upstream.q;
import com.google.android.exoplayer2.upstream.t;
import ft.g;
import fv.a;
import java.io.IOException;
import java.util.ArrayList;

final class c implements h, p.a<g<b>> {

    /* renamed from: a  reason: collision with root package name */
    private final b.a f16551a;

    /* renamed from: b  reason: collision with root package name */
    private final t f16552b;

    /* renamed from: c  reason: collision with root package name */
    private final q f16553c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<?> f16554d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.p f16555e;

    /* renamed from: f  reason: collision with root package name */
    private final j.a f16556f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f16557g;

    /* renamed from: h  reason: collision with root package name */
    private final TrackGroupArray f16558h;

    /* renamed from: i  reason: collision with root package name */
    private final d f16559i;

    /* renamed from: j  reason: collision with root package name */
    private h.a f16560j;

    /* renamed from: k  reason: collision with root package name */
    private a f16561k;

    /* renamed from: l  reason: collision with root package name */
    private g<b>[] f16562l;

    /* renamed from: m  reason: collision with root package name */
    private p f16563m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16564n;

    public c(a aVar, b.a aVar2, t tVar, d dVar, com.google.android.exoplayer2.drm.b<?> bVar, com.google.android.exoplayer2.upstream.p pVar, j.a aVar3, q qVar, com.google.android.exoplayer2.upstream.b bVar2) {
        this.f16561k = aVar;
        this.f16551a = aVar2;
        this.f16552b = tVar;
        this.f16553c = qVar;
        this.f16554d = bVar;
        this.f16555e = pVar;
        this.f16556f = aVar3;
        this.f16557g = bVar2;
        this.f16559i = dVar;
        this.f16558h = a(aVar, bVar);
        g<b>[] a2 = a(0);
        this.f16562l = a2;
        this.f16563m = dVar.a(a2);
        aVar3.a();
    }

    private static TrackGroupArray a(a aVar, com.google.android.exoplayer2.drm.b<?> bVar) {
        TrackGroup[] trackGroupArr = new TrackGroup[aVar.f28154c.length];
        for (int i2 = 0; i2 < aVar.f28154c.length; i2++) {
            Format[] formatArr = aVar.f28154c[i2].f28160c;
            Format[] formatArr2 = new Format[formatArr.length];
            for (int i3 = 0; i3 < formatArr.length; i3++) {
                Format format = formatArr[i3];
                if (format.f15095l != null) {
                    format = format.a(bVar.b(format.f15095l));
                }
                formatArr2[i3] = format;
            }
            trackGroupArr[i2] = new TrackGroup(formatArr2);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private g<b> a(e eVar, long j2) {
        int a2 = this.f16558h.a(eVar.g());
        return new g(this.f16561k.f28154c[a2].f28158a, (int[]) null, (Format[]) null, this.f16551a.a(this.f16553c, this.f16561k, a2, eVar, this.f16552b), this, this.f16557g, j2, this.f16554d, this.f16555e, this.f16556f);
    }

    private static g<b>[] a(int i2) {
        return new g[i2];
    }

    public long a(long j2, ad adVar) {
        for (g<b> gVar : this.f16562l) {
            if (gVar.f28068a == 2) {
                return gVar.a(j2, adVar);
            }
        }
        return j2;
    }

    public long a(e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            if (oVarArr[i2] != null) {
                g gVar = oVarArr[i2];
                if (eVarArr[i2] == null || !zArr[i2]) {
                    gVar.g();
                    oVarArr[i2] = null;
                } else {
                    ((b) gVar.a()).a(eVarArr[i2]);
                    arrayList.add(gVar);
                }
            }
            if (oVarArr[i2] == null && eVarArr[i2] != null) {
                g<b> a2 = a(eVarArr[i2], j2);
                arrayList.add(a2);
                oVarArr[i2] = a2;
                zArr2[i2] = true;
            }
        }
        g<b>[] a3 = a(arrayList.size());
        this.f16562l = a3;
        arrayList.toArray(a3);
        this.f16563m = this.f16559i.a(this.f16562l);
        return j2;
    }

    public void a(long j2) {
        this.f16563m.a(j2);
    }

    public void a(long j2, boolean z2) {
        for (g<b> a2 : this.f16562l) {
            a2.a(j2, z2);
        }
    }

    public void a(h.a aVar, long j2) {
        this.f16560j = aVar;
        aVar.a(this);
    }

    public void a(g<b> gVar) {
        this.f16560j.a(this);
    }

    public void a(a aVar) {
        this.f16561k = aVar;
        for (g<b> a2 : this.f16562l) {
            a2.a().a(aVar);
        }
        this.f16560j.a(this);
    }

    public long b(long j2) {
        for (g<b> b2 : this.f16562l) {
            b2.b(j2);
        }
        return j2;
    }

    public TrackGroupArray b() {
        return this.f16558h;
    }

    public long c() {
        if (this.f16564n) {
            return -9223372036854775807L;
        }
        this.f16556f.c();
        this.f16564n = true;
        return -9223372036854775807L;
    }

    public boolean c(long j2) {
        return this.f16563m.c(j2);
    }

    public long d() {
        return this.f16563m.d();
    }

    public long e() {
        return this.f16563m.e();
    }

    public boolean f() {
        return this.f16563m.f();
    }

    public void g() {
        for (g<b> g2 : this.f16562l) {
            g2.g();
        }
        this.f16560j = null;
        this.f16556f.b();
    }

    public void n_() throws IOException {
        this.f16553c.f();
    }
}
