package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ad;
import com.google.android.exoplayer2.extractor.mp4.j;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.smoothstreaming.b;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.q;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.aa;
import ft.d;
import ft.e;
import ft.i;
import ft.l;
import ft.m;
import fv.a;
import java.io.IOException;
import java.util.List;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final q f16540a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16541b;

    /* renamed from: c  reason: collision with root package name */
    private final e[] f16542c;

    /* renamed from: d  reason: collision with root package name */
    private final f f16543d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.exoplayer2.trackselection.e f16544e;

    /* renamed from: f  reason: collision with root package name */
    private fv.a f16545f;

    /* renamed from: g  reason: collision with root package name */
    private int f16546g;

    /* renamed from: h  reason: collision with root package name */
    private IOException f16547h;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.a$a  reason: collision with other inner class name */
    public static final class C0115a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private final f.a f16548a;

        public C0115a(f.a aVar) {
            this.f16548a = aVar;
        }

        public b a(q qVar, fv.a aVar, int i2, com.google.android.exoplayer2.trackselection.e eVar, t tVar) {
            f a2 = this.f16548a.a();
            if (tVar != null) {
                a2.a(tVar);
            }
            return new a(qVar, aVar, i2, eVar, a2);
        }
    }

    private static final class b extends ft.b {

        /* renamed from: b  reason: collision with root package name */
        private final a.b f16549b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16550c;

        public b(a.b bVar, int i2, int i3) {
            super((long) i3, (long) (bVar.f28161d - 1));
            this.f16549b = bVar;
            this.f16550c = i2;
        }
    }

    public a(q qVar, fv.a aVar, int i2, com.google.android.exoplayer2.trackselection.e eVar, f fVar) {
        fv.a aVar2 = aVar;
        int i3 = i2;
        com.google.android.exoplayer2.trackselection.e eVar2 = eVar;
        this.f16540a = qVar;
        this.f16545f = aVar2;
        this.f16541b = i3;
        this.f16544e = eVar2;
        this.f16543d = fVar;
        a.b bVar = aVar2.f28154c[i3];
        this.f16542c = new e[eVar.h()];
        int i4 = 0;
        while (i4 < this.f16542c.length) {
            int b2 = eVar2.b(i4);
            Format format = bVar.f28160c[b2];
            int i5 = i4;
            j jVar = r7;
            j jVar2 = new j(b2, bVar.f28158a, bVar.f28159b, -9223372036854775807L, aVar2.f28155d, format, 0, format.f15095l != null ? aVar2.f28153b.f28157a : null, bVar.f28158a == 2 ? 4 : 0, (long[]) null, (long[]) null);
            this.f16542c[i5] = new e(new com.google.android.exoplayer2.extractor.mp4.e(3, (aa) null, jVar), bVar.f28158a, format);
            i4 = i5 + 1;
        }
    }

    private long a(long j2) {
        if (!this.f16545f.f28152a) {
            return -9223372036854775807L;
        }
        a.b bVar = this.f16545f.f28154c[this.f16541b];
        int i2 = bVar.f28161d - 1;
        return (bVar.a(i2) + bVar.b(i2)) - j2;
    }

    private static l a(Format format, f fVar, Uri uri, String str, int i2, long j2, long j3, long j4, int i3, Object obj, e eVar) {
        f fVar2 = fVar;
        long j5 = j3;
        long j6 = j4;
        int i4 = i3;
        Object obj2 = obj;
        h hVar = r26;
        h hVar2 = new h(uri, 0, -1, str);
        return new i(fVar2, hVar, format, i4, obj2, j2, j5, j6, -9223372036854775807L, (long) i2, 1, j2, eVar);
    }

    public int a(long j2, List<? extends l> list) {
        return (this.f16547h != null || this.f16544e.h() < 2) ? list.size() : this.f16544e.a(j2, list);
    }

    public long a(long j2, ad adVar) {
        a.b bVar = this.f16545f.f28154c[this.f16541b];
        int a2 = bVar.a(j2);
        long a3 = bVar.a(a2);
        return com.google.android.exoplayer2.util.ad.a(j2, adVar, a3, (a3 >= j2 || a2 >= bVar.f28161d + -1) ? a3 : bVar.a(a2 + 1));
    }

    public void a() throws IOException {
        IOException iOException = this.f16547h;
        if (iOException == null) {
            this.f16540a.f();
            return;
        }
        throw iOException;
    }

    public final void a(long j2, long j3, List<? extends l> list, ft.f fVar) {
        int i2;
        long j4 = j3;
        ft.f fVar2 = fVar;
        if (this.f16547h == null) {
            a.b bVar = this.f16545f.f28154c[this.f16541b];
            if (bVar.f28161d == 0) {
                fVar2.f28067b = !this.f16545f.f28152a;
                return;
            }
            if (list.isEmpty()) {
                i2 = bVar.a(j4);
                List<? extends l> list2 = list;
            } else {
                i2 = (int) (((l) list.get(list.size() - 1)).h() - ((long) this.f16546g));
                if (i2 < 0) {
                    this.f16547h = new BehindLiveWindowException();
                    return;
                }
            }
            if (i2 >= bVar.f28161d) {
                fVar2.f28067b = !this.f16545f.f28152a;
                return;
            }
            long j5 = j4 - j2;
            long a2 = a(j2);
            int h2 = this.f16544e.h();
            m[] mVarArr = new m[h2];
            for (int i3 = 0; i3 < h2; i3++) {
                mVarArr[i3] = new b(bVar, this.f16544e.b(i3), i2);
            }
            this.f16544e.a(j2, j5, a2, list, mVarArr);
            long a3 = bVar.a(i2);
            long b2 = a3 + bVar.b(i2);
            if (!list.isEmpty()) {
                j4 = -9223372036854775807L;
            }
            long j6 = j4;
            int i4 = i2 + this.f16546g;
            int a4 = this.f16544e.a();
            e eVar = this.f16542c[a4];
            Uri a5 = bVar.a(this.f16544e.b(a4), i2);
            fVar2.f28066a = a(this.f16544e.i(), this.f16543d, a5, (String) null, i4, a3, b2, j6, this.f16544e.b(), this.f16544e.c(), eVar);
        }
    }

    public void a(com.google.android.exoplayer2.trackselection.e eVar) {
        this.f16544e = eVar;
    }

    public void a(d dVar) {
    }

    public void a(fv.a aVar) {
        a.b bVar = this.f16545f.f28154c[this.f16541b];
        int i2 = bVar.f28161d;
        a.b bVar2 = aVar.f28154c[this.f16541b];
        if (!(i2 == 0 || bVar2.f28161d == 0)) {
            int i3 = i2 - 1;
            long a2 = bVar2.a(0);
            if (bVar.a(i3) + bVar.b(i3) > a2) {
                this.f16546g += bVar.a(a2);
                this.f16545f = aVar;
            }
        }
        this.f16546g += i2;
        this.f16545f = aVar;
    }

    public boolean a(d dVar, boolean z2, Exception exc, long j2) {
        if (z2 && j2 != -9223372036854775807L) {
            com.google.android.exoplayer2.trackselection.e eVar = this.f16544e;
            if (eVar.a(eVar.a(dVar.f13112e), j2)) {
                return true;
            }
        }
        return false;
    }
}
