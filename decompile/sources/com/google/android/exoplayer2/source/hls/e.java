package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.ac;
import com.google.android.exoplayer2.util.ad;
import ft.j;
import ft.l;
import ft.m;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final g f16195a;

    /* renamed from: b  reason: collision with root package name */
    private final f f16196b;

    /* renamed from: c  reason: collision with root package name */
    private final f f16197c;

    /* renamed from: d  reason: collision with root package name */
    private final m f16198d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri[] f16199e;

    /* renamed from: f  reason: collision with root package name */
    private final Format[] f16200f;

    /* renamed from: g  reason: collision with root package name */
    private final HlsPlaylistTracker f16201g;

    /* renamed from: h  reason: collision with root package name */
    private final TrackGroup f16202h;

    /* renamed from: i  reason: collision with root package name */
    private final List<Format> f16203i;

    /* renamed from: j  reason: collision with root package name */
    private final d f16204j = new d(4);

    /* renamed from: k  reason: collision with root package name */
    private boolean f16205k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f16206l = ad.f11760f;

    /* renamed from: m  reason: collision with root package name */
    private IOException f16207m;

    /* renamed from: n  reason: collision with root package name */
    private Uri f16208n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f16209o;

    /* renamed from: p  reason: collision with root package name */
    private com.google.android.exoplayer2.trackselection.e f16210p;

    /* renamed from: q  reason: collision with root package name */
    private long f16211q = -9223372036854775807L;

    /* renamed from: r  reason: collision with root package name */
    private boolean f16212r;

    private static final class a extends j {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f16213a;

        public a(f fVar, h hVar, Format format, int i2, Object obj, byte[] bArr) {
            super(fVar, hVar, 3, format, i2, obj, bArr);
        }

        /* access modifiers changed from: protected */
        public void a(byte[] bArr, int i2) {
            this.f16213a = Arrays.copyOf(bArr, i2);
        }

        public byte[] h() {
            return this.f16213a;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public ft.d f16214a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f16215b;

        /* renamed from: c  reason: collision with root package name */
        public Uri f16216c;

        public b() {
            a();
        }

        public void a() {
            this.f16214a = null;
            this.f16215b = false;
            this.f16216c = null;
        }
    }

    private static final class c extends ft.b {

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.exoplayer2.source.hls.playlist.d f16217b;

        /* renamed from: c  reason: collision with root package name */
        private final long f16218c;

        public c(com.google.android.exoplayer2.source.hls.playlist.d dVar, long j2, int i2) {
            super((long) i2, (long) (dVar.f16324l.size() - 1));
            this.f16217b = dVar;
            this.f16218c = j2;
        }
    }

    private static final class d extends com.google.android.exoplayer2.trackselection.b {

        /* renamed from: d  reason: collision with root package name */
        private int f16219d;

        public d(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
            this.f16219d = a(trackGroup.a(0));
        }

        public int a() {
            return this.f16219d;
        }

        public void a(long j2, long j3, long j4, List<? extends l> list, m[] mVarArr) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (b(this.f16219d, elapsedRealtime)) {
                for (int i2 = this.f16725b - 1; i2 >= 0; i2--) {
                    if (!b(i2, elapsedRealtime)) {
                        this.f16219d = i2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        public int b() {
            return 0;
        }

        public Object c() {
            return null;
        }
    }

    public e(g gVar, HlsPlaylistTracker hlsPlaylistTracker, Uri[] uriArr, Format[] formatArr, f fVar, t tVar, m mVar, List<Format> list) {
        this.f16195a = gVar;
        this.f16201g = hlsPlaylistTracker;
        this.f16199e = uriArr;
        this.f16200f = formatArr;
        this.f16198d = mVar;
        this.f16203i = list;
        f a2 = fVar.a(1);
        this.f16196b = a2;
        if (tVar != null) {
            a2.a(tVar);
        }
        this.f16197c = fVar.a(3);
        this.f16202h = new TrackGroup(formatArr);
        int[] iArr = new int[uriArr.length];
        for (int i2 = 0; i2 < uriArr.length; i2++) {
            iArr[i2] = i2;
        }
        this.f16210p = new d(this.f16202h, iArr);
    }

    private long a(long j2) {
        long j3 = this.f16211q;
        if (j3 != -9223372036854775807L) {
            return j3 - j2;
        }
        return -9223372036854775807L;
    }

    private long a(i iVar, boolean z2, com.google.android.exoplayer2.source.hls.playlist.d dVar, long j2, long j3) {
        long a2;
        long j4;
        if (iVar != null && !z2) {
            return iVar.h();
        }
        long j5 = dVar.f16325m + j2;
        if (iVar != null && !this.f16209o) {
            j3 = iVar.f13115h;
        }
        if (dVar.f16321i || j3 < j5) {
            a2 = (long) ad.a(dVar.f16324l, Long.valueOf(j3 - j2), true, !this.f16201g.e() || iVar == null);
            j4 = dVar.f16318f;
        } else {
            a2 = dVar.f16318f;
            j4 = (long) dVar.f16324l.size();
        }
        return a2 + j4;
    }

    private static Uri a(com.google.android.exoplayer2.source.hls.playlist.d dVar, d.a aVar) {
        if (aVar == null || aVar.f16333h == null) {
            return null;
        }
        return ac.a(dVar.f16338n, aVar.f16333h);
    }

    private ft.d a(Uri uri, int i2) {
        if (uri == null) {
            return null;
        }
        byte[] b2 = this.f16204j.b(uri);
        if (b2 != null) {
            this.f16204j.a(uri, b2);
            return null;
        }
        return new a(this.f16197c, new h(uri, 0, -1, (String) null, 1), this.f16200f[i2], this.f16210p.b(), this.f16210p.c(), this.f16206l);
    }

    private void a(com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        this.f16211q = dVar.f16321i ? -9223372036854775807L : dVar.a() - this.f16201g.c();
    }

    public void a() throws IOException {
        IOException iOException = this.f16207m;
        if (iOException == null) {
            Uri uri = this.f16208n;
            if (uri != null && this.f16212r) {
                this.f16201g.b(uri);
                return;
            }
            return;
        }
        throw iOException;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(long r29, long r31, java.util.List<com.google.android.exoplayer2.source.hls.i> r33, boolean r34, com.google.android.exoplayer2.source.hls.e.b r35) {
        /*
            r28 = this;
            r8 = r28
            r6 = r31
            r9 = r35
            boolean r0 = r33.isEmpty()
            r11 = 1
            if (r0 == 0) goto L_0x0011
            r1 = r33
            r4 = 0
            goto L_0x001f
        L_0x0011:
            int r0 = r33.size()
            int r0 = r0 - r11
            r1 = r33
            java.lang.Object r0 = r1.get(r0)
            com.google.android.exoplayer2.source.hls.i r0 = (com.google.android.exoplayer2.source.hls.i) r0
            r4 = r0
        L_0x001f:
            if (r4 != 0) goto L_0x0024
            r0 = -1
            r5 = -1
            goto L_0x002d
        L_0x0024:
            com.google.android.exoplayer2.source.TrackGroup r0 = r8.f16202h
            com.google.android.exoplayer2.Format r2 = r4.f13112e
            int r0 = r0.a((com.google.android.exoplayer2.Format) r2)
            r5 = r0
        L_0x002d:
            long r2 = r6 - r29
            long r12 = r28.a((long) r29)
            if (r4 == 0) goto L_0x0056
            boolean r0 = r8.f16209o
            if (r0 != 0) goto L_0x0056
            long r14 = r4.d()
            long r2 = r2 - r14
            r10 = 0
            long r2 = java.lang.Math.max(r10, r2)
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0056
            long r12 = r12 - r14
            long r10 = java.lang.Math.max(r10, r12)
            r15 = r2
            r17 = r10
            goto L_0x0059
        L_0x0056:
            r15 = r2
            r17 = r12
        L_0x0059:
            ft.m[] r20 = r8.a((com.google.android.exoplayer2.source.hls.i) r4, (long) r6)
            com.google.android.exoplayer2.trackselection.e r12 = r8.f16210p
            r13 = r29
            r19 = r33
            r12.a(r13, r15, r17, r19, r20)
            com.google.android.exoplayer2.trackselection.e r0 = r8.f16210p
            int r10 = r0.j()
            r11 = 0
            if (r5 == r10) goto L_0x0071
            r12 = 1
            goto L_0x0072
        L_0x0071:
            r12 = 0
        L_0x0072:
            android.net.Uri[] r0 = r8.f16199e
            r13 = r0[r10]
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r0 = r8.f16201g
            boolean r0 = r0.a((android.net.Uri) r13)
            if (r0 != 0) goto L_0x008e
            r9.f16216c = r13
            boolean r0 = r8.f16212r
            android.net.Uri r1 = r8.f16208n
            boolean r1 = r13.equals(r1)
            r0 = r0 & r1
            r8.f16212r = r0
            r8.f16208n = r13
            return
        L_0x008e:
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r0 = r8.f16201g
            r1 = 1
            com.google.android.exoplayer2.source.hls.playlist.d r14 = r0.a(r13, r1)
            com.google.android.exoplayer2.util.a.b(r14)
            boolean r0 = r14.f16340p
            r8.f16209o = r0
            r8.a((com.google.android.exoplayer2.source.hls.playlist.d) r14)
            long r0 = r14.f16315c
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r2 = r8.f16201g
            long r2 = r2.c()
            long r15 = r0 - r2
            r0 = r28
            r1 = r4
            r2 = r12
            r3 = r14
            r25 = r4
            r17 = r5
            r4 = r15
            r6 = r31
            long r0 = r0.a((com.google.android.exoplayer2.source.hls.i) r1, (boolean) r2, (com.google.android.exoplayer2.source.hls.playlist.d) r3, (long) r4, (long) r6)
            long r2 = r14.f16318f
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x00e5
            if (r25 == 0) goto L_0x00e5
            if (r12 == 0) goto L_0x00e5
            android.net.Uri[] r0 = r8.f16199e
            r0 = r0[r17]
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r1 = r8.f16201g
            r2 = 1
            com.google.android.exoplayer2.source.hls.playlist.d r1 = r1.a(r0, r2)
            com.google.android.exoplayer2.util.a.b(r1)
            long r2 = r1.f16315c
            com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker r4 = r8.f16201g
            long r4 = r4.c()
            long r2 = r2 - r4
            long r4 = r25.h()
            r15 = r2
            r3 = r0
            r2 = r1
            r0 = r4
            r5 = r17
            goto L_0x00e8
        L_0x00e5:
            r5 = r10
            r3 = r13
            r2 = r14
        L_0x00e8:
            long r6 = r2.f16318f
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x00f6
            com.google.android.exoplayer2.source.BehindLiveWindowException r0 = new com.google.android.exoplayer2.source.BehindLiveWindowException
            r0.<init>()
            r8.f16207m = r0
            return
        L_0x00f6:
            long r6 = r2.f16318f
            long r0 = r0 - r6
            int r1 = (int) r0
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.d$a> r0 = r2.f16324l
            int r0 = r0.size()
            if (r1 < r0) goto L_0x0122
            boolean r1 = r2.f16321i
            if (r1 == 0) goto L_0x0112
            if (r34 != 0) goto L_0x010e
            if (r0 != 0) goto L_0x010b
            goto L_0x010e
        L_0x010b:
            r1 = 1
            int r0 = r0 - r1
            goto L_0x0123
        L_0x010e:
            r1 = 1
            r9.f16215b = r1
            return
        L_0x0112:
            r9.f16216c = r3
            boolean r0 = r8.f16212r
            android.net.Uri r1 = r8.f16208n
            boolean r1 = r3.equals(r1)
            r0 = r0 & r1
            r8.f16212r = r0
            r8.f16208n = r3
            return
        L_0x0122:
            r0 = r1
        L_0x0123:
            r8.f16212r = r11
            r1 = 0
            r8.f16208n = r1
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.d$a> r1 = r2.f16324l
            java.lang.Object r1 = r1.get(r0)
            com.google.android.exoplayer2.source.hls.playlist.d$a r1 = (com.google.android.exoplayer2.source.hls.playlist.d.a) r1
            com.google.android.exoplayer2.source.hls.playlist.d$a r4 = r1.f16327b
            android.net.Uri r4 = a((com.google.android.exoplayer2.source.hls.playlist.d) r2, (com.google.android.exoplayer2.source.hls.playlist.d.a) r4)
            ft.d r6 = r8.a((android.net.Uri) r4, (int) r5)
            r9.f16214a = r6
            ft.d r6 = r9.f16214a
            if (r6 == 0) goto L_0x0141
            return
        L_0x0141:
            android.net.Uri r1 = a((com.google.android.exoplayer2.source.hls.playlist.d) r2, (com.google.android.exoplayer2.source.hls.playlist.d.a) r1)
            ft.d r6 = r8.a((android.net.Uri) r1, (int) r5)
            r9.f16214a = r6
            ft.d r6 = r9.f16214a
            if (r6 == 0) goto L_0x0150
            return
        L_0x0150:
            com.google.android.exoplayer2.source.hls.g r12 = r8.f16195a
            com.google.android.exoplayer2.upstream.f r13 = r8.f16196b
            com.google.android.exoplayer2.Format[] r6 = r8.f16200f
            r14 = r6[r5]
            java.util.List<com.google.android.exoplayer2.Format> r5 = r8.f16203i
            com.google.android.exoplayer2.trackselection.e r6 = r8.f16210p
            int r21 = r6.b()
            com.google.android.exoplayer2.trackselection.e r6 = r8.f16210p
            java.lang.Object r22 = r6.c()
            boolean r6 = r8.f16205k
            com.google.android.exoplayer2.source.hls.m r7 = r8.f16198d
            com.google.android.exoplayer2.source.hls.d r10 = r8.f16204j
            byte[] r26 = r10.a(r1)
            com.google.android.exoplayer2.source.hls.d r1 = r8.f16204j
            byte[] r27 = r1.a(r4)
            r17 = r2
            r18 = r0
            r19 = r3
            r20 = r5
            r23 = r6
            r24 = r7
            com.google.android.exoplayer2.source.hls.i r0 = com.google.android.exoplayer2.source.hls.i.a(r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r9.f16214a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.e.a(long, long, java.util.List, boolean, com.google.android.exoplayer2.source.hls.e$b):void");
    }

    public void a(com.google.android.exoplayer2.trackselection.e eVar) {
        this.f16210p = eVar;
    }

    public void a(ft.d dVar) {
        if (dVar instanceof a) {
            a aVar = (a) dVar;
            this.f16206l = aVar.c();
            this.f16204j.a(aVar.f13110c.f16995a, (byte[]) com.google.android.exoplayer2.util.a.b(aVar.h()));
        }
    }

    public void a(boolean z2) {
        this.f16205k = z2;
    }

    public boolean a(Uri uri, long j2) {
        int c2;
        int i2 = 0;
        while (true) {
            Uri[] uriArr = this.f16199e;
            if (i2 >= uriArr.length) {
                i2 = -1;
                break;
            } else if (uriArr[i2].equals(uri)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1 || (c2 = this.f16210p.c(i2)) == -1) {
            return true;
        }
        this.f16212r = uri.equals(this.f16208n) | this.f16212r;
        return j2 == -9223372036854775807L || this.f16210p.a(c2, j2);
    }

    public boolean a(ft.d dVar, long j2) {
        com.google.android.exoplayer2.trackselection.e eVar = this.f16210p;
        return eVar.a(eVar.c(this.f16202h.a(dVar.f13112e)), j2);
    }

    public m[] a(i iVar, long j2) {
        i iVar2 = iVar;
        int a2 = iVar2 == null ? -1 : this.f16202h.a(iVar2.f13112e);
        int h2 = this.f16210p.h();
        m[] mVarArr = new m[h2];
        for (int i2 = 0; i2 < h2; i2++) {
            int b2 = this.f16210p.b(i2);
            Uri uri = this.f16199e[b2];
            if (!this.f16201g.a(uri)) {
                mVarArr[i2] = m.f28109a;
            } else {
                com.google.android.exoplayer2.source.hls.playlist.d a3 = this.f16201g.a(uri, false);
                com.google.android.exoplayer2.util.a.b(a3);
                long c2 = a3.f16315c - this.f16201g.c();
                long j3 = c2;
                long a4 = a(iVar, b2 != a2, a3, c2, j2);
                if (a4 < a3.f16318f) {
                    mVarArr[i2] = m.f28109a;
                } else {
                    mVarArr[i2] = new c(a3, j3, (int) (a4 - a3.f16318f));
                }
            }
        }
        return mVarArr;
    }

    public TrackGroup b() {
        return this.f16202h;
    }

    public com.google.android.exoplayer2.trackselection.e c() {
        return this.f16210p;
    }

    public void d() {
        this.f16207m = null;
    }
}
