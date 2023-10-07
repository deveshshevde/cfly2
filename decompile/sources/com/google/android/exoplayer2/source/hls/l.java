package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.e;
import com.google.android.exoplayer2.source.hls.l;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import fj.f;
import fj.h;
import fj.i;
import fj.s;
import fj.u;
import ft.d;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class l implements n.b, p, Loader.a<d>, Loader.e, i {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Integer> f11677a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 4})));
    private boolean A;
    private boolean B;
    private int C;
    private Format D;
    private Format E;
    private boolean F;
    private TrackGroupArray G;
    private Set<TrackGroup> H;
    private int[] I;
    private int J;
    private boolean K;
    private boolean[] L;
    private boolean[] M;
    private long N;
    private long O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private long T;
    private DrmInitData U;
    private int V;

    /* renamed from: b  reason: collision with root package name */
    private final int f11678b;

    /* renamed from: c  reason: collision with root package name */
    private final a f11679c;

    /* renamed from: d  reason: collision with root package name */
    private final e f11680d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f11681e;

    /* renamed from: f  reason: collision with root package name */
    private final Format f11682f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<?> f11683g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.p f11684h;

    /* renamed from: i  reason: collision with root package name */
    private final Loader f11685i = new Loader("Loader:HlsSampleStreamWrapper");

    /* renamed from: j  reason: collision with root package name */
    private final j.a f11686j;

    /* renamed from: k  reason: collision with root package name */
    private final int f11687k;

    /* renamed from: l  reason: collision with root package name */
    private final e.b f11688l = new e.b();

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList<i> f11689m;

    /* renamed from: n  reason: collision with root package name */
    private final List<i> f11690n;

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f11691o;

    /* renamed from: p  reason: collision with root package name */
    private final Runnable f11692p;

    /* renamed from: q  reason: collision with root package name */
    private final Handler f11693q;

    /* renamed from: r  reason: collision with root package name */
    private final ArrayList<k> f11694r;

    /* renamed from: s  reason: collision with root package name */
    private final Map<String, DrmInitData> f11695s;

    /* renamed from: t  reason: collision with root package name */
    private c[] f11696t;

    /* renamed from: u  reason: collision with root package name */
    private int[] f11697u = new int[0];

    /* renamed from: v  reason: collision with root package name */
    private Set<Integer> f11698v;

    /* renamed from: w  reason: collision with root package name */
    private SparseIntArray f11699w;

    /* renamed from: x  reason: collision with root package name */
    private u f11700x;

    /* renamed from: y  reason: collision with root package name */
    private int f11701y;

    /* renamed from: z  reason: collision with root package name */
    private int f11702z;

    public interface a extends p.a<l> {
        void a(Uri uri);

        void h();
    }

    private static class b implements u {

        /* renamed from: a  reason: collision with root package name */
        private static final Format f16251a = Format.a((String) null, "application/id3", Long.MAX_VALUE);

        /* renamed from: b  reason: collision with root package name */
        private static final Format f16252b = Format.a((String) null, "application/x-emsg", Long.MAX_VALUE);

        /* renamed from: c  reason: collision with root package name */
        private final com.google.android.exoplayer2.metadata.emsg.a f16253c = new com.google.android.exoplayer2.metadata.emsg.a();

        /* renamed from: d  reason: collision with root package name */
        private final u f16254d;

        /* renamed from: e  reason: collision with root package name */
        private final Format f16255e;

        /* renamed from: f  reason: collision with root package name */
        private Format f16256f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f16257g;

        /* renamed from: h  reason: collision with root package name */
        private int f16258h;

        public b(u uVar, int i2) {
            Format format;
            this.f16254d = uVar;
            if (i2 == 1) {
                format = f16251a;
            } else if (i2 == 3) {
                format = f16252b;
            } else {
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unknown metadataType: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f16255e = format;
            this.f16257g = new byte[0];
            this.f16258h = 0;
        }

        private q a(int i2, int i3) {
            int i4 = this.f16258h - i3;
            q qVar = new q(Arrays.copyOfRange(this.f16257g, i4 - i2, i4));
            byte[] bArr = this.f16257g;
            System.arraycopy(bArr, i4, bArr, 0, i3);
            this.f16258h = i3;
            return qVar;
        }

        private void a(int i2) {
            byte[] bArr = this.f16257g;
            if (bArr.length < i2) {
                this.f16257g = Arrays.copyOf(bArr, i2 + (i2 / 2));
            }
        }

        private boolean a(EventMessage eventMessage) {
            Format a2 = eventMessage.a();
            return a2 != null && ad.a((Object) this.f16255e.f15092i, (Object) a2.f15092i);
        }

        public int a(h hVar, int i2, boolean z2) throws IOException, InterruptedException {
            a(this.f16258h + i2);
            int a2 = hVar.a(this.f16257g, this.f16258h, i2);
            if (a2 != -1) {
                this.f16258h += a2;
                return a2;
            } else if (z2) {
                return -1;
            } else {
                throw new EOFException();
            }
        }

        public void a(long j2, int i2, int i3, int i4, u.a aVar) {
            com.google.android.exoplayer2.util.a.b(this.f16256f);
            q a2 = a(i3, i4);
            if (!ad.a((Object) this.f16256f.f15092i, (Object) this.f16255e.f15092i)) {
                if ("application/x-emsg".equals(this.f16256f.f15092i)) {
                    EventMessage a3 = this.f16253c.a(a2);
                    if (!a(a3)) {
                        k.c("EmsgUnwrappingTrackOutput", String.format("Ignoring EMSG. Expected it to contain wrapped %s but actual wrapped format: %s", new Object[]{this.f16255e.f15092i, a3.a()}));
                        return;
                    }
                    a2 = new q((byte[]) com.google.android.exoplayer2.util.a.b(a3.b()));
                } else {
                    String valueOf = String.valueOf(this.f16256f.f15092i);
                    k.c("EmsgUnwrappingTrackOutput", valueOf.length() != 0 ? "Ignoring sample for unsupported format: ".concat(valueOf) : new String("Ignoring sample for unsupported format: "));
                    return;
                }
            }
            int b2 = a2.b();
            this.f16254d.a(a2, b2);
            this.f16254d.a(j2, i2, b2, i4, aVar);
        }

        public void a(Format format) {
            this.f16256f = format;
            this.f16254d.a(this.f16255e);
        }

        public void a(q qVar, int i2) {
            a(this.f16258h + i2);
            qVar.a(this.f16257g, this.f16258h, i2);
            this.f16258h += i2;
        }
    }

    private static final class c extends n {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, DrmInitData> f16259a;

        /* renamed from: b  reason: collision with root package name */
        private DrmInitData f16260b;

        public c(com.google.android.exoplayer2.upstream.b bVar, Looper looper, com.google.android.exoplayer2.drm.b<?> bVar2, Map<String, DrmInitData> map) {
            super(bVar, looper, bVar2);
            this.f16259a = map;
        }

        private Metadata a(Metadata metadata) {
            if (metadata == null) {
                return null;
            }
            int a2 = metadata.a();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= a2) {
                    i3 = -1;
                    break;
                }
                Metadata.Entry a3 = metadata.a(i3);
                if ((a3 instanceof PrivFrame) && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame) a3).f15919a)) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return metadata;
            }
            if (a2 == 1) {
                return null;
            }
            Metadata.Entry[] entryArr = new Metadata.Entry[(a2 - 1)];
            while (i2 < a2) {
                if (i2 != i3) {
                    entryArr[i2 < i3 ? i2 : i2 - 1] = metadata.a(i2);
                }
                i2++;
            }
            return new Metadata(entryArr);
        }

        public void a(DrmInitData drmInitData) {
            this.f16260b = drmInitData;
            q();
        }

        public Format b(Format format) {
            DrmInitData drmInitData;
            DrmInitData drmInitData2 = this.f16260b;
            if (drmInitData2 == null) {
                drmInitData2 = format.f15095l;
            }
            if (!(drmInitData2 == null || (drmInitData = this.f16259a.get(drmInitData2.f15461a)) == null)) {
                drmInitData2 = drmInitData;
            }
            return super.b(format.a(drmInitData2, a(format.f15090g)));
        }
    }

    public l(int i2, a aVar, e eVar, Map<String, DrmInitData> map, com.google.android.exoplayer2.upstream.b bVar, long j2, Format format, com.google.android.exoplayer2.drm.b<?> bVar2, com.google.android.exoplayer2.upstream.p pVar, j.a aVar2, int i3) {
        this.f11678b = i2;
        this.f11679c = aVar;
        this.f11680d = eVar;
        this.f11695s = map;
        this.f11681e = bVar;
        this.f11682f = format;
        this.f11683g = bVar2;
        this.f11684h = pVar;
        this.f11686j = aVar2;
        this.f11687k = i3;
        Set<Integer> set = f11677a;
        this.f11698v = new HashSet(set.size());
        this.f11699w = new SparseIntArray(set.size());
        this.f11696t = new c[0];
        this.M = new boolean[0];
        this.L = new boolean[0];
        ArrayList<i> arrayList = new ArrayList<>();
        this.f11689m = arrayList;
        this.f11690n = Collections.unmodifiableList(arrayList);
        this.f11694r = new ArrayList<>();
        this.f11691o = new Runnable() {
            public final void run() {
                l.this.n();
            }
        };
        this.f11692p = new Runnable() {
            public final void run() {
                l.this.m();
            }
        };
        this.f11693q = new Handler();
        this.N = j2;
        this.O = j2;
    }

    private static Format a(Format format, Format format2, boolean z2) {
        if (format == null) {
            return format2;
        }
        int i2 = z2 ? format.f15088e : -1;
        int i3 = format.f15105v != -1 ? format.f15105v : format2.f15105v;
        String a2 = ad.a(format.f15089f, com.google.android.exoplayer2.util.n.h(format2.f15092i));
        String g2 = com.google.android.exoplayer2.util.n.g(a2);
        if (g2 == null) {
            g2 = format2.f15092i;
        }
        return format2.a(format.f15084a, format.f15085b, g2, a2, format.f15090g, i2, format.f15097n, format.f15098o, i3, format.f15086c, format.A);
    }

    private TrackGroupArray a(TrackGroup[] trackGroupArr) {
        for (int i2 = 0; i2 < trackGroupArr.length; i2++) {
            TrackGroup trackGroup = trackGroupArr[i2];
            Format[] formatArr = new Format[trackGroup.f16005a];
            for (int i3 = 0; i3 < trackGroup.f16005a; i3++) {
                Format a2 = trackGroup.a(i3);
                if (a2.f15095l != null) {
                    a2 = a2.a(this.f11683g.b(a2.f15095l));
                }
                formatArr[i3] = a2;
            }
            trackGroupArr[i2] = new TrackGroup(formatArr);
        }
        return new TrackGroupArray(trackGroupArr);
    }

    private void a(o[] oVarArr) {
        this.f11694r.clear();
        for (k kVar : oVarArr) {
            if (kVar != null) {
                this.f11694r.add(kVar);
            }
        }
    }

    private static boolean a(Format format, Format format2) {
        String str = format.f15092i;
        String str2 = format2.f15092i;
        int h2 = com.google.android.exoplayer2.util.n.h(str);
        if (h2 != 3) {
            return h2 == com.google.android.exoplayer2.util.n.h(str2);
        }
        if (!ad.a((Object) str, (Object) str2)) {
            return false;
        }
        return (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) || format.B == format2.B;
    }

    private boolean a(i iVar) {
        int i2 = iVar.f11662a;
        int length = this.f11696t.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.L[i3] && this.f11696t[i3].i() == i2) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(d dVar) {
        return dVar instanceof i;
    }

    private u b(int i2, int i3) {
        com.google.android.exoplayer2.util.a.a(f11677a.contains(Integer.valueOf(i3)));
        int i4 = this.f11699w.get(i3, -1);
        if (i4 == -1) {
            return null;
        }
        if (this.f11698v.add(Integer.valueOf(i3))) {
            this.f11697u[i4] = i2;
        }
        return this.f11697u[i4] == i2 ? this.f11696t[i4] : d(i2, i3);
    }

    private n c(int i2, int i3) {
        int length = this.f11696t.length;
        boolean z2 = true;
        if (!(i3 == 1 || i3 == 2)) {
            z2 = false;
        }
        c cVar = new c(this.f11681e, this.f11693q.getLooper(), this.f11683g, this.f11695s);
        if (z2) {
            cVar.a(this.U);
        }
        cVar.b(this.T);
        cVar.a(this.V);
        cVar.a((n.b) this);
        int i4 = length + 1;
        int[] copyOf = Arrays.copyOf(this.f11697u, i4);
        this.f11697u = copyOf;
        copyOf[length] = i2;
        this.f11696t = (c[]) ad.b((T[]) this.f11696t, cVar);
        boolean[] copyOf2 = Arrays.copyOf(this.M, i4);
        this.M = copyOf2;
        copyOf2[length] = z2;
        this.K = copyOf2[length] | this.K;
        this.f11698v.add(Integer.valueOf(i3));
        this.f11699w.append(i3, length);
        if (e(i3) > e(this.f11701y)) {
            this.f11702z = length;
            this.f11701y = i3;
        }
        this.L = Arrays.copyOf(this.L, i4);
        return cVar;
    }

    private static f d(int i2, int i3) {
        StringBuilder sb = new StringBuilder(54);
        sb.append("Unmapped track with id ");
        sb.append(i2);
        sb.append(" of type ");
        sb.append(i3);
        k.c("HlsSampleStreamWrapper", sb.toString());
        return new f();
    }

    private boolean d(long j2) {
        int length = this.f11696t.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (!this.f11696t[i2].a(j2, false) && (this.M[i2] || !this.K)) {
                return false;
            }
        }
        return true;
    }

    private static int e(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 0 : 1;
        }
        return 3;
    }

    private void l() {
        for (c a2 : this.f11696t) {
            a2.a(this.P);
        }
        this.P = false;
    }

    /* access modifiers changed from: private */
    public void m() {
        this.A = true;
        n();
    }

    /* access modifiers changed from: private */
    public void n() {
        if (!this.F && this.I == null && this.A) {
            c[] cVarArr = this.f11696t;
            int length = cVarArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (cVarArr[i2].j() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            if (this.G != null) {
                o();
                return;
            }
            p();
            s();
            this.f11679c.h();
        }
    }

    @RequiresNonNull({"trackGroups"})
    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    private void o() {
        int i2 = this.G.f16009b;
        int[] iArr = new int[i2];
        this.I = iArr;
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            while (true) {
                c[] cVarArr = this.f11696t;
                if (i4 >= cVarArr.length) {
                    break;
                } else if (a(cVarArr[i4].j(), this.G.a(i3).a(0))) {
                    this.I[i3] = i4;
                    break;
                } else {
                    i4++;
                }
            }
        }
        Iterator<k> it2 = this.f11694r.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void p() {
        int length = this.f11696t.length;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 6;
        int i4 = -1;
        while (true) {
            int i5 = 2;
            if (i2 >= length) {
                break;
            }
            String str = this.f11696t[i2].j().f15092i;
            if (!com.google.android.exoplayer2.util.n.b(str)) {
                i5 = com.google.android.exoplayer2.util.n.a(str) ? 1 : com.google.android.exoplayer2.util.n.c(str) ? 3 : 6;
            }
            if (e(i5) > e(i3)) {
                i4 = i2;
                i3 = i5;
            } else if (i5 == i3 && i4 != -1) {
                i4 = -1;
            }
            i2++;
        }
        TrackGroup b2 = this.f11680d.b();
        int i6 = b2.f16005a;
        this.J = -1;
        this.I = new int[length];
        for (int i7 = 0; i7 < length; i7++) {
            this.I[i7] = i7;
        }
        TrackGroup[] trackGroupArr = new TrackGroup[length];
        for (int i8 = 0; i8 < length; i8++) {
            Format j2 = this.f11696t[i8].j();
            if (i8 == i4) {
                Format[] formatArr = new Format[i6];
                if (i6 == 1) {
                    formatArr[0] = j2.a(b2.a(0));
                } else {
                    for (int i9 = 0; i9 < i6; i9++) {
                        formatArr[i9] = a(b2.a(i9), j2, true);
                    }
                }
                trackGroupArr[i8] = new TrackGroup(formatArr);
                this.J = i8;
            } else {
                trackGroupArr[i8] = new TrackGroup(a((i3 != 2 || !com.google.android.exoplayer2.util.n.a(j2.f15092i)) ? null : this.f11682f, j2, false));
            }
        }
        this.G = a(trackGroupArr);
        if (this.H == null) {
            z2 = true;
        }
        com.google.android.exoplayer2.util.a.b(z2);
        this.H = Collections.emptySet();
    }

    private i q() {
        ArrayList<i> arrayList = this.f11689m;
        return arrayList.get(arrayList.size() - 1);
    }

    private boolean r() {
        return this.O != -9223372036854775807L;
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void s() {
        this.B = true;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void t() {
        com.google.android.exoplayer2.util.a.b(this.B);
        com.google.android.exoplayer2.util.a.b(this.G);
        com.google.android.exoplayer2.util.a.b(this.H);
    }

    public int a(int i2) {
        t();
        com.google.android.exoplayer2.util.a.b(this.I);
        int i3 = this.I[i2];
        if (i3 == -1) {
            return this.H.contains(this.G.a(i2)) ? -3 : -2;
        }
        boolean[] zArr = this.L;
        if (zArr[i3]) {
            return -2;
        }
        zArr[i3] = true;
        return i3;
    }

    public int a(int i2, long j2) {
        if (r()) {
            return 0;
        }
        c cVar = this.f11696t[i2];
        return (!this.R || j2 <= cVar.k()) ? cVar.a(j2) : cVar.n();
    }

    public int a(int i2, com.google.android.exoplayer2.o oVar, fi.e eVar, boolean z2) {
        if (r()) {
            return -3;
        }
        int i3 = 0;
        if (!this.f11689m.isEmpty()) {
            int i4 = 0;
            while (i4 < this.f11689m.size() - 1 && a(this.f11689m.get(i4))) {
                i4++;
            }
            ad.a(this.f11689m, 0, i4);
            i iVar = this.f11689m.get(0);
            Format format = iVar.f13112e;
            if (!format.equals(this.E)) {
                this.f11686j.a(this.f11678b, format, iVar.f13113f, iVar.f13114g, iVar.f13115h);
            }
            this.E = format;
        }
        int a2 = this.f11696t[i2].a(oVar, eVar, z2, this.R, this.N);
        if (a2 == -5) {
            Format format2 = (Format) com.google.android.exoplayer2.util.a.b(oVar.f15972c);
            if (i2 == this.f11702z) {
                int i5 = this.f11696t[i2].i();
                while (i3 < this.f11689m.size() && this.f11689m.get(i3).f11662a != i5) {
                    i3++;
                }
                format2 = format2.a(i3 < this.f11689m.size() ? this.f11689m.get(i3).f13112e : (Format) com.google.android.exoplayer2.util.a.b(this.D));
            }
            oVar.f15972c = format2;
        }
        return a2;
    }

    public Loader.b a(d dVar, long j2, long j3, IOException iOException, int i2) {
        Loader.b a2;
        d dVar2 = dVar;
        long e2 = dVar.e();
        boolean a3 = a(dVar);
        long a4 = this.f11684h.a(dVar2.f13111d, j3, iOException, i2);
        boolean z2 = false;
        boolean a5 = a4 != -9223372036854775807L ? this.f11680d.a(dVar2, a4) : false;
        if (a5) {
            if (a3 && e2 == 0) {
                ArrayList<i> arrayList = this.f11689m;
                if (arrayList.remove(arrayList.size() - 1) == dVar2) {
                    z2 = true;
                }
                com.google.android.exoplayer2.util.a.b(z2);
                if (this.f11689m.isEmpty()) {
                    this.O = this.N;
                }
            }
            a2 = Loader.f16945c;
        } else {
            long b2 = this.f11684h.b(dVar2.f13111d, j3, iOException, i2);
            a2 = b2 != -9223372036854775807L ? Loader.a(false, b2) : Loader.f16946d;
        }
        Loader.b bVar = a2;
        this.f11686j.a(dVar2.f13110c, dVar.f(), dVar.g(), dVar2.f13111d, this.f11678b, dVar2.f13112e, dVar2.f13113f, dVar2.f13114g, dVar2.f13115h, dVar2.f13116i, j2, j3, e2, iOException, !bVar.a());
        if (a5) {
            if (!this.B) {
                c(this.N);
            } else {
                this.f11679c.a(this);
            }
        }
        return bVar;
    }

    public u a(int i2, int i3) {
        u uVar;
        if (!f11677a.contains(Integer.valueOf(i3))) {
            int i4 = 0;
            while (true) {
                u[] uVarArr = this.f11696t;
                if (i4 >= uVarArr.length) {
                    uVar = null;
                    break;
                } else if (this.f11697u[i4] == i2) {
                    uVar = uVarArr[i4];
                    break;
                } else {
                    i4++;
                }
            }
        } else {
            uVar = b(i2, i3);
        }
        if (uVar == null) {
            if (this.S) {
                return d(i2, i3);
            }
            uVar = c(i2, i3);
        }
        if (i3 != 4) {
            return uVar;
        }
        if (this.f11700x == null) {
            this.f11700x = new b(uVar, this.f11687k);
        }
        return this.f11700x;
    }

    public void a() {
        this.S = true;
        this.f11693q.post(this.f11692p);
    }

    public void a(int i2, boolean z2) {
        this.V = i2;
        for (c a2 : this.f11696t) {
            a2.a(i2);
        }
        if (z2) {
            for (c c2 : this.f11696t) {
                c2.c();
            }
        }
    }

    public void a(long j2) {
    }

    public void a(long j2, boolean z2) {
        if (this.A && !r()) {
            int length = this.f11696t.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f11696t[i2].a(j2, z2, this.L[i2]);
            }
        }
    }

    public void a(Format format) {
        this.f11693q.post(this.f11691o);
    }

    public void a(DrmInitData drmInitData) {
        if (!ad.a((Object) this.U, (Object) drmInitData)) {
            this.U = drmInitData;
            int i2 = 0;
            while (true) {
                c[] cVarArr = this.f11696t;
                if (i2 < cVarArr.length) {
                    if (this.M[i2]) {
                        cVarArr[i2].a(drmInitData);
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public void a(s sVar) {
    }

    public void a(d dVar, long j2, long j3) {
        d dVar2 = dVar;
        this.f11680d.a(dVar2);
        this.f11686j.a(dVar2.f13110c, dVar.f(), dVar.g(), dVar2.f13111d, this.f11678b, dVar2.f13112e, dVar2.f13113f, dVar2.f13114g, dVar2.f13115h, dVar2.f13116i, j2, j3, dVar.e());
        if (!this.B) {
            c(this.N);
        } else {
            this.f11679c.a(this);
        }
    }

    public void a(d dVar, long j2, long j3, boolean z2) {
        d dVar2 = dVar;
        this.f11686j.b(dVar2.f13110c, dVar.f(), dVar.g(), dVar2.f13111d, this.f11678b, dVar2.f13112e, dVar2.f13113f, dVar2.f13114g, dVar2.f13115h, dVar2.f13116i, j2, j3, dVar.e());
        if (!z2) {
            l();
            if (this.C > 0) {
                this.f11679c.a(this);
            }
        }
    }

    public void a(boolean z2) {
        this.f11680d.a(z2);
    }

    public void a(TrackGroup[] trackGroupArr, int i2, int... iArr) {
        this.G = a(trackGroupArr);
        this.H = new HashSet();
        for (int a2 : iArr) {
            this.H.add(this.G.a(a2));
        }
        this.J = i2;
        Handler handler = this.f11693q;
        a aVar = this.f11679c;
        Objects.requireNonNull(aVar);
        handler.post(new Runnable() {
            public final void run() {
                l.a.this.h();
            }
        });
        s();
    }

    public boolean a(Uri uri, long j2) {
        return this.f11680d.a(uri, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.google.android.exoplayer2.trackselection.e[] r20, boolean[] r21, com.google.android.exoplayer2.source.o[] r22, boolean[] r23, long r24, boolean r26) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r22
            r12 = r24
            r19.t()
            int r3 = r0.C
            r14 = 0
            r4 = 0
        L_0x000f:
            int r5 = r1.length
            r6 = 0
            r15 = 1
            if (r4 >= r5) goto L_0x002f
            r5 = r2[r4]
            com.google.android.exoplayer2.source.hls.k r5 = (com.google.android.exoplayer2.source.hls.k) r5
            if (r5 == 0) goto L_0x002c
            r7 = r1[r4]
            if (r7 == 0) goto L_0x0022
            boolean r7 = r21[r4]
            if (r7 != 0) goto L_0x002c
        L_0x0022:
            int r7 = r0.C
            int r7 = r7 - r15
            r0.C = r7
            r5.d()
            r2[r4] = r6
        L_0x002c:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x002f:
            if (r26 != 0) goto L_0x0041
            boolean r4 = r0.Q
            if (r4 == 0) goto L_0x0038
            if (r3 != 0) goto L_0x003f
            goto L_0x0041
        L_0x0038:
            long r3 = r0.N
            int r5 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r3 = 0
            goto L_0x0042
        L_0x0041:
            r3 = 1
        L_0x0042:
            com.google.android.exoplayer2.source.hls.e r4 = r0.f11680d
            com.google.android.exoplayer2.trackselection.e r4 = r4.c()
            r16 = r3
            r11 = r4
            r3 = 0
        L_0x004c:
            int r5 = r1.length
            if (r3 >= r5) goto L_0x00a3
            r5 = r1[r3]
            if (r5 != 0) goto L_0x0054
            goto L_0x00a0
        L_0x0054:
            com.google.android.exoplayer2.source.TrackGroupArray r7 = r0.G
            com.google.android.exoplayer2.source.TrackGroup r8 = r5.g()
            int r7 = r7.a((com.google.android.exoplayer2.source.TrackGroup) r8)
            int r8 = r0.J
            if (r7 != r8) goto L_0x0068
            com.google.android.exoplayer2.source.hls.e r8 = r0.f11680d
            r8.a((com.google.android.exoplayer2.trackselection.e) r5)
            r11 = r5
        L_0x0068:
            r5 = r2[r3]
            if (r5 != 0) goto L_0x00a0
            int r5 = r0.C
            int r5 = r5 + r15
            r0.C = r5
            com.google.android.exoplayer2.source.hls.k r5 = new com.google.android.exoplayer2.source.hls.k
            r5.<init>(r0, r7)
            r2[r3] = r5
            r23[r3] = r15
            int[] r5 = r0.I
            if (r5 == 0) goto L_0x00a0
            r5 = r2[r3]
            com.google.android.exoplayer2.source.hls.k r5 = (com.google.android.exoplayer2.source.hls.k) r5
            r5.a()
            if (r16 != 0) goto L_0x00a0
            com.google.android.exoplayer2.source.hls.l$c[] r5 = r0.f11696t
            int[] r8 = r0.I
            r7 = r8[r7]
            r5 = r5[r7]
            boolean r7 = r5.a((long) r12, (boolean) r15)
            if (r7 != 0) goto L_0x009d
            int r5 = r5.h()
            if (r5 == 0) goto L_0x009d
            r5 = 1
            goto L_0x009e
        L_0x009d:
            r5 = 0
        L_0x009e:
            r16 = r5
        L_0x00a0:
            int r3 = r3 + 1
            goto L_0x004c
        L_0x00a3:
            int r1 = r0.C
            if (r1 != 0) goto L_0x00da
            com.google.android.exoplayer2.source.hls.e r1 = r0.f11680d
            r1.d()
            r0.E = r6
            r0.P = r15
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.i> r1 = r0.f11689m
            r1.clear()
            com.google.android.exoplayer2.upstream.Loader r1 = r0.f11685i
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x00d5
            boolean r1 = r0.A
            if (r1 == 0) goto L_0x00ce
            com.google.android.exoplayer2.source.hls.l$c[] r1 = r0.f11696t
            int r3 = r1.length
        L_0x00c4:
            if (r14 >= r3) goto L_0x00ce
            r4 = r1[r14]
            r4.p()
            int r14 = r14 + 1
            goto L_0x00c4
        L_0x00ce:
            com.google.android.exoplayer2.upstream.Loader r1 = r0.f11685i
            r1.d()
            goto L_0x0140
        L_0x00d5:
            r19.l()
            goto L_0x0140
        L_0x00da:
            java.util.ArrayList<com.google.android.exoplayer2.source.hls.i> r1 = r0.f11689m
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x012d
            boolean r1 = com.google.android.exoplayer2.util.ad.a((java.lang.Object) r11, (java.lang.Object) r4)
            if (r1 != 0) goto L_0x012d
            boolean r1 = r0.Q
            if (r1 != 0) goto L_0x0124
            r3 = 0
            int r1 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00f3
            long r3 = -r12
        L_0x00f3:
            r6 = r3
            com.google.android.exoplayer2.source.hls.i r1 = r19.q()
            com.google.android.exoplayer2.source.hls.e r3 = r0.f11680d
            ft.m[] r17 = r3.a((com.google.android.exoplayer2.source.hls.i) r1, (long) r12)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            java.util.List<com.google.android.exoplayer2.source.hls.i> r10 = r0.f11690n
            r3 = r11
            r4 = r24
            r18 = r11
            r11 = r17
            r3.a(r4, r6, r8, r10, r11)
            com.google.android.exoplayer2.source.hls.e r3 = r0.f11680d
            com.google.android.exoplayer2.source.TrackGroup r3 = r3.b()
            com.google.android.exoplayer2.Format r1 = r1.f13112e
            int r1 = r3.a((com.google.android.exoplayer2.Format) r1)
            int r3 = r18.j()
            if (r3 == r1) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r1 = 0
            goto L_0x0125
        L_0x0124:
            r1 = 1
        L_0x0125:
            if (r1 == 0) goto L_0x012d
            r0.P = r15
            r1 = 1
            r16 = 1
            goto L_0x012f
        L_0x012d:
            r1 = r26
        L_0x012f:
            if (r16 == 0) goto L_0x0140
            r0.b((long) r12, (boolean) r1)
        L_0x0134:
            int r1 = r2.length
            if (r14 >= r1) goto L_0x0140
            r1 = r2[r14]
            if (r1 == 0) goto L_0x013d
            r23[r14] = r15
        L_0x013d:
            int r14 = r14 + 1
            goto L_0x0134
        L_0x0140:
            r0.a((com.google.android.exoplayer2.source.o[]) r2)
            r0.Q = r15
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.l.a(com.google.android.exoplayer2.trackselection.e[], boolean[], com.google.android.exoplayer2.source.o[], boolean[], long, boolean):boolean");
    }

    public void b() {
        if (!this.B) {
            c(this.N);
        }
    }

    public void b(int i2) {
        t();
        com.google.android.exoplayer2.util.a.b(this.I);
        int i3 = this.I[i2];
        com.google.android.exoplayer2.util.a.b(this.L[i3]);
        this.L[i3] = false;
    }

    public void b(long j2) {
        if (this.T != j2) {
            this.T = j2;
            for (c b2 : this.f11696t) {
                b2.b(j2);
            }
        }
    }

    public boolean b(long j2, boolean z2) {
        this.N = j2;
        if (r()) {
            this.O = j2;
            return true;
        } else if (this.A && !z2 && d(j2)) {
            return false;
        } else {
            this.O = j2;
            this.R = false;
            this.f11689m.clear();
            if (this.f11685i.c()) {
                this.f11685i.d();
            } else {
                this.f11685i.b();
                l();
            }
            return true;
        }
    }

    public void c() throws IOException {
        j();
        if (this.R && !this.B) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public boolean c(int i2) {
        return !r() && this.f11696t[i2].b(this.R);
    }

    public boolean c(long j2) {
        List<i> list;
        long max;
        if (this.R || this.f11685i.c() || this.f11685i.a()) {
            return false;
        }
        if (r()) {
            list = Collections.emptyList();
            max = this.O;
        } else {
            list = this.f11690n;
            i q2 = q();
            max = q2.i() ? q2.f13116i : Math.max(this.N, q2.f13115h);
        }
        List<i> list2 = list;
        this.f11680d.a(j2, max, list2, this.B || !list2.isEmpty(), this.f11688l);
        boolean z2 = this.f11688l.f16215b;
        d dVar = this.f11688l.f16214a;
        Uri uri = this.f11688l.f16216c;
        this.f11688l.a();
        if (z2) {
            this.O = -9223372036854775807L;
            this.R = true;
            return true;
        } else if (dVar == null) {
            if (uri != null) {
                this.f11679c.a(uri);
            }
            return false;
        } else {
            if (a(dVar)) {
                this.O = -9223372036854775807L;
                i iVar = (i) dVar;
                iVar.a(this);
                this.f11689m.add(iVar);
                this.D = iVar.f13112e;
            }
            this.f11686j.a(dVar.f13110c, dVar.f13111d, this.f11678b, dVar.f13112e, dVar.f13113f, dVar.f13114g, dVar.f13115h, dVar.f13116i, this.f11685i.a(dVar, this, this.f11684h.a(dVar.f13111d)));
            return true;
        }
    }

    public long d() {
        if (this.R) {
            return Long.MIN_VALUE;
        }
        if (r()) {
            return this.O;
        }
        long j2 = this.N;
        i q2 = q();
        if (!q2.i()) {
            if (this.f11689m.size() > 1) {
                ArrayList<i> arrayList = this.f11689m;
                q2 = arrayList.get(arrayList.size() - 2);
            } else {
                q2 = null;
            }
        }
        if (q2 != null) {
            j2 = Math.max(j2, q2.f13116i);
        }
        if (this.A) {
            for (c k2 : this.f11696t) {
                j2 = Math.max(j2, k2.k());
            }
        }
        return j2;
    }

    public void d(int i2) throws IOException {
        j();
        this.f11696t[i2].f();
    }

    public long e() {
        if (r()) {
            return this.O;
        }
        if (this.R) {
            return Long.MIN_VALUE;
        }
        return q().f13116i;
    }

    public boolean f() {
        return this.f11685i.c();
    }

    public TrackGroupArray g() {
        t();
        return this.G;
    }

    public void h() {
        for (c a2 : this.f11696t) {
            a2.a();
        }
    }

    public void i() {
        if (this.B) {
            for (c e2 : this.f11696t) {
                e2.e();
            }
        }
        this.f11685i.a((Loader.e) this);
        this.f11693q.removeCallbacksAndMessages((Object) null);
        this.F = true;
        this.f11694r.clear();
    }

    public void j() throws IOException {
        this.f11685i.f();
        this.f11680d.a();
    }

    public void k() {
        this.f11698v.clear();
    }
}
