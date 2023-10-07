package com.google.android.exoplayer2.source.dash;

import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.g;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.q;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.ad;
import ft.g;
import fu.c;
import fu.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class b implements h, p.a<g<a>>, g.b<a> {

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f16074b = Pattern.compile("CC([1-4])=(.+)");

    /* renamed from: a  reason: collision with root package name */
    final int f16075a;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0113a f16076c;

    /* renamed from: d  reason: collision with root package name */
    private final t f16077d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.exoplayer2.drm.b<?> f16078e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.p f16079f;

    /* renamed from: g  reason: collision with root package name */
    private final long f16080g;

    /* renamed from: h  reason: collision with root package name */
    private final q f16081h;

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f16082i;

    /* renamed from: j  reason: collision with root package name */
    private final TrackGroupArray f16083j;

    /* renamed from: k  reason: collision with root package name */
    private final a[] f16084k;

    /* renamed from: l  reason: collision with root package name */
    private final d f16085l;

    /* renamed from: m  reason: collision with root package name */
    private final g f16086m;

    /* renamed from: n  reason: collision with root package name */
    private final IdentityHashMap<g<a>, g.c> f16087n = new IdentityHashMap<>();

    /* renamed from: o  reason: collision with root package name */
    private final j.a f16088o;

    /* renamed from: p  reason: collision with root package name */
    private h.a f16089p;

    /* renamed from: q  reason: collision with root package name */
    private ft.g<a>[] f16090q = b(0);

    /* renamed from: r  reason: collision with root package name */
    private f[] f16091r = new f[0];

    /* renamed from: s  reason: collision with root package name */
    private p f16092s;

    /* renamed from: t  reason: collision with root package name */
    private fu.b f16093t;

    /* renamed from: u  reason: collision with root package name */
    private int f16094u;

    /* renamed from: v  reason: collision with root package name */
    private List<fu.d> f16095v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f16096w;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f16097a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16098b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16099c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16100d;

        /* renamed from: e  reason: collision with root package name */
        public final int f16101e;

        /* renamed from: f  reason: collision with root package name */
        public final int f16102f;

        /* renamed from: g  reason: collision with root package name */
        public final int f16103g;

        private a(int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7) {
            this.f16098b = i2;
            this.f16097a = iArr;
            this.f16099c = i3;
            this.f16101e = i4;
            this.f16102f = i5;
            this.f16103g = i6;
            this.f16100d = i7;
        }

        public static a a(int i2) {
            return new a(4, 2, new int[0], -1, -1, -1, i2);
        }

        public static a a(int i2, int[] iArr, int i3, int i4, int i5) {
            return new a(i2, 0, iArr, i3, i4, i5, -1);
        }

        public static a a(int[] iArr, int i2) {
            return new a(4, 1, iArr, i2, -1, -1, -1);
        }

        public static a b(int[] iArr, int i2) {
            return new a(3, 1, iArr, i2, -1, -1, -1);
        }
    }

    public b(int i2, fu.b bVar, int i3, a.C0113a aVar, t tVar, com.google.android.exoplayer2.drm.b<?> bVar2, com.google.android.exoplayer2.upstream.p pVar, j.a aVar2, long j2, q qVar, com.google.android.exoplayer2.upstream.b bVar3, d dVar, g.b bVar4) {
        this.f16075a = i2;
        this.f16093t = bVar;
        this.f16094u = i3;
        this.f16076c = aVar;
        this.f16077d = tVar;
        this.f16078e = bVar2;
        this.f16079f = pVar;
        this.f16088o = aVar2;
        this.f16080g = j2;
        this.f16081h = qVar;
        this.f16082i = bVar3;
        this.f16085l = dVar;
        this.f16086m = new g(bVar, bVar4, bVar3);
        this.f16092s = dVar.a(this.f16090q);
        e a2 = bVar.a(i3);
        this.f16095v = a2.f28140d;
        Pair<TrackGroupArray, a[]> a3 = a(bVar2, a2.f28139c, this.f16095v);
        this.f16083j = (TrackGroupArray) a3.first;
        this.f16084k = (a[]) a3.second;
        aVar2.a();
    }

    private static int a(int i2, List<fu.a> list, int[][] iArr, boolean[] zArr, Format[][] formatArr) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (a(list, iArr[i4])) {
                zArr[i4] = true;
                i3++;
            }
            formatArr[i4] = b(list, iArr[i4]);
            if (formatArr[i4].length != 0) {
                i3++;
            }
        }
        return i3;
    }

    private int a(int i2, int[] iArr) {
        int i3 = iArr[i2];
        if (i3 == -1) {
            return -1;
        }
        int i4 = this.f16084k[i3].f16101e;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 == i4 && this.f16084k[i6].f16099c == 0) {
                return i5;
            }
        }
        return -1;
    }

    private static int a(com.google.android.exoplayer2.drm.b<?> bVar, List<fu.a> list, int[][] iArr, int i2, boolean[] zArr, Format[][] formatArr, TrackGroup[] trackGroupArr, a[] aVarArr) {
        int i3;
        int i4;
        List<fu.a> list2 = list;
        int i5 = i2;
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int[] iArr2 = iArr[i6];
            ArrayList arrayList = new ArrayList();
            for (int i8 : iArr2) {
                arrayList.addAll(list.get(i8).f28116c);
            }
            int size = arrayList.size();
            Format[] formatArr2 = new Format[size];
            for (int i9 = 0; i9 < size; i9++) {
                Format format = ((fu.g) arrayList.get(i9)).f28145a;
                DrmInitData drmInitData = format.f15095l;
                com.google.android.exoplayer2.drm.b<?> bVar2 = bVar;
                if (drmInitData != null) {
                    format = format.a(bVar.b(drmInitData));
                }
                formatArr2[i9] = format;
            }
            com.google.android.exoplayer2.drm.b<?> bVar3 = bVar;
            fu.a aVar = list.get(iArr2[0]);
            int i10 = i7 + 1;
            if (zArr[i6]) {
                i3 = i10 + 1;
            } else {
                i3 = i10;
                i10 = -1;
            }
            if (formatArr[i6].length != 0) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
                i3 = -1;
            }
            trackGroupArr[i7] = new TrackGroup(formatArr2);
            aVarArr[i7] = a.a(aVar.f28115b, iArr2, i7, i10, i3);
            if (i10 != -1) {
                int i11 = aVar.f28114a;
                StringBuilder sb = new StringBuilder(16);
                sb.append(i11);
                sb.append(":emsg");
                trackGroupArr[i10] = new TrackGroup(Format.a(sb.toString(), "application/x-emsg", (String) null, -1, (DrmInitData) null));
                aVarArr[i10] = a.a(iArr2, i7);
            }
            if (i3 != -1) {
                trackGroupArr[i3] = new TrackGroup(formatArr[i6]);
                aVarArr[i3] = a.b(iArr2, i7);
            }
            i6++;
            i7 = i4;
        }
        return i7;
    }

    private static Pair<TrackGroupArray, a[]> a(com.google.android.exoplayer2.drm.b<?> bVar, List<fu.a> list, List<fu.d> list2) {
        int[][] a2 = a(list);
        int length = a2.length;
        boolean[] zArr = new boolean[length];
        Format[][] formatArr = new Format[length][];
        int a3 = a(length, list, a2, zArr, formatArr) + length + list2.size();
        TrackGroup[] trackGroupArr = new TrackGroup[a3];
        a[] aVarArr = new a[a3];
        a(list2, trackGroupArr, aVarArr, a(bVar, list, a2, length, zArr, formatArr, trackGroupArr, aVarArr));
        return Pair.create(new TrackGroupArray(trackGroupArr), aVarArr);
    }

    private static Format a(int i2) {
        return a(i2, (String) null, -1);
    }

    private static Format a(int i2, String str, int i3) {
        String str2;
        if (i3 != -1) {
            StringBuilder sb = new StringBuilder(12);
            sb.append(":");
            sb.append(i3);
            str2 = sb.toString();
        } else {
            str2 = "";
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 18);
        sb2.append(i2);
        sb2.append(":cea608");
        sb2.append(str2);
        return Format.a(sb2.toString(), "application/cea-608", (String) null, -1, 0, str, i3, (DrmInitData) null, Long.MAX_VALUE, (List<byte[]>) null);
    }

    private ft.g<a> a(a aVar, com.google.android.exoplayer2.trackselection.e eVar, long j2) {
        int i2;
        TrackGroup trackGroup;
        TrackGroup trackGroup2;
        int i3;
        a aVar2 = aVar;
        boolean z2 = aVar2.f16102f != -1;
        g.c cVar = null;
        if (z2) {
            trackGroup = this.f16083j.a(aVar2.f16102f);
            i2 = 1;
        } else {
            trackGroup = null;
            i2 = 0;
        }
        boolean z3 = aVar2.f16103g != -1;
        if (z3) {
            trackGroup2 = this.f16083j.a(aVar2.f16103g);
            i2 += trackGroup2.f16005a;
        } else {
            trackGroup2 = null;
        }
        Format[] formatArr = new Format[i2];
        int[] iArr = new int[i2];
        if (z2) {
            formatArr[0] = trackGroup.a(0);
            iArr[0] = 4;
            i3 = 1;
        } else {
            i3 = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            for (int i4 = 0; i4 < trackGroup2.f16005a; i4++) {
                formatArr[i3] = trackGroup2.a(i4);
                iArr[i3] = 3;
                arrayList.add(formatArr[i3]);
                i3++;
            }
        }
        if (this.f16093t.f28122c && z2) {
            cVar = this.f16086m.a();
        }
        g.c cVar2 = cVar;
        g.c cVar3 = cVar2;
        ft.g gVar = new ft.g(aVar2.f16098b, iArr, formatArr, this.f16076c.a(this.f16081h, this.f16093t, this.f16094u, aVar2.f16097a, eVar, aVar2.f16098b, this.f16080g, z2, arrayList, cVar2, this.f16077d), this, this.f16082i, j2, this.f16078e, this.f16079f, this.f16088o);
        synchronized (this) {
            this.f16087n.put(gVar, cVar3);
        }
        return gVar;
    }

    private static c a(List<c> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            if (str.equals(cVar.f28130a)) {
                return cVar;
            }
        }
        return null;
    }

    private static void a(List<fu.d> list, TrackGroup[] trackGroupArr, a[] aVarArr, int i2) {
        int i3 = 0;
        while (i3 < list.size()) {
            trackGroupArr[i2] = new TrackGroup(Format.a(list.get(i3).a(), "application/x-emsg", (String) null, -1, (DrmInitData) null));
            aVarArr[i2] = a.a(i3);
            i3++;
            i2++;
        }
    }

    private void a(com.google.android.exoplayer2.trackselection.e[] eVarArr, o[] oVarArr, int[] iArr) {
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            if ((oVarArr[i2] instanceof f) || (oVarArr[i2] instanceof g.a)) {
                int a2 = a(i2, iArr);
                if (!(a2 == -1 ? oVarArr[i2] instanceof f : (oVarArr[i2] instanceof g.a) && oVarArr[i2].f28090a == oVarArr[a2])) {
                    if (oVarArr[i2] instanceof g.a) {
                        oVarArr[i2].a();
                    }
                    oVarArr[i2] = null;
                }
            }
        }
    }

    private void a(com.google.android.exoplayer2.trackselection.e[] eVarArr, o[] oVarArr, boolean[] zArr, long j2, int[] iArr) {
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            com.google.android.exoplayer2.trackselection.e eVar = eVarArr[i2];
            if (eVar != null) {
                if (oVarArr[i2] == null) {
                    zArr[i2] = true;
                    a aVar = this.f16084k[iArr[i2]];
                    if (aVar.f16099c == 0) {
                        oVarArr[i2] = a(aVar, eVar, j2);
                    } else if (aVar.f16099c == 2) {
                        oVarArr[i2] = new f(this.f16095v.get(aVar.f16100d), eVar.g().a(0), this.f16093t.f28122c);
                    }
                } else if (oVarArr[i2] instanceof ft.g) {
                    ((a) oVarArr[i2].a()).a(eVar);
                }
            }
        }
        for (int i3 = 0; i3 < eVarArr.length; i3++) {
            if (oVarArr[i3] == null && eVarArr[i3] != null) {
                a aVar2 = this.f16084k[iArr[i3]];
                if (aVar2.f16099c == 1) {
                    int a2 = a(i3, iArr);
                    if (a2 == -1) {
                        oVarArr[i3] = new f();
                    } else {
                        oVarArr[i3] = oVarArr[a2].a(j2, aVar2.f16098b);
                    }
                }
            }
        }
    }

    private void a(com.google.android.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr) {
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            if (eVarArr[i2] == null || !zArr[i2]) {
                if (oVarArr[i2] instanceof ft.g) {
                    oVarArr[i2].a(this);
                } else if (oVarArr[i2] instanceof g.a) {
                    oVarArr[i2].a();
                }
                oVarArr[i2] = null;
            }
        }
    }

    private static boolean a(List<fu.a> list, int[] iArr) {
        for (int i2 : iArr) {
            List<fu.g> list2 = list.get(i2).f28116c;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (!list2.get(i3).f28148d.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    private int[] a(com.google.android.exoplayer2.trackselection.e[] eVarArr) {
        int[] iArr = new int[eVarArr.length];
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            if (eVarArr[i2] != null) {
                iArr[i2] = this.f16083j.a(eVarArr[i2].g());
            } else {
                iArr[i2] = -1;
            }
        }
        return iArr;
    }

    private static int[][] a(List<fu.a> list) {
        int i2;
        c b2;
        int size = list.size();
        SparseIntArray sparseIntArray = new SparseIntArray(size);
        ArrayList arrayList = new ArrayList(size);
        SparseArray sparseArray = new SparseArray(size);
        for (int i3 = 0; i3 < size; i3++) {
            sparseIntArray.put(list.get(i3).f28114a, i3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(Integer.valueOf(i3));
            arrayList.add(arrayList2);
            sparseArray.put(i3, arrayList2);
        }
        for (int i4 = 0; i4 < size; i4++) {
            fu.a aVar = list.get(i4);
            c c2 = c(aVar.f28118e);
            if (c2 == null) {
                c2 = c(aVar.f28119f);
            }
            if (c2 == null || (i2 = sparseIntArray.get(Integer.parseInt(c2.f28131b), -1)) == -1) {
                i2 = i4;
            }
            if (i2 == i4 && (b2 = b(aVar.f28119f)) != null) {
                for (String parseInt : ad.a(b2.f28131b, ",")) {
                    int i5 = sparseIntArray.get(Integer.parseInt(parseInt), -1);
                    if (i5 != -1) {
                        i2 = Math.min(i2, i5);
                    }
                }
            }
            if (i2 != i4) {
                List list2 = (List) sparseArray.get(i4);
                List list3 = (List) sparseArray.get(i2);
                list3.addAll(list2);
                sparseArray.put(i4, list3);
                arrayList.remove(list2);
            }
        }
        int size2 = arrayList.size();
        int[][] iArr = new int[size2][];
        for (int i6 = 0; i6 < size2; i6++) {
            iArr[i6] = ad.a((List<Integer>) (List) arrayList.get(i6));
            Arrays.sort(iArr[i6]);
        }
        return iArr;
    }

    private static c b(List<c> list) {
        return a(list, "urn:mpeg:dash:adaptation-set-switching:2016");
    }

    private static Format[] b(List<fu.a> list, int[] iArr) {
        for (int i2 : iArr) {
            fu.a aVar = list.get(i2);
            List<c> list2 = list.get(i2).f28117d;
            for (int i3 = 0; i3 < list2.size(); i3++) {
                c cVar = list2.get(i3);
                if ("urn:scte:dash:cc:cea-608:2015".equals(cVar.f28130a)) {
                    String str = cVar.f28131b;
                    if (str == null) {
                        return new Format[]{a(aVar.f28114a)};
                    }
                    String[] a2 = ad.a(str, ";");
                    Format[] formatArr = new Format[a2.length];
                    for (int i4 = 0; i4 < a2.length; i4++) {
                        Matcher matcher = f16074b.matcher(a2[i4]);
                        if (!matcher.matches()) {
                            return new Format[]{a(aVar.f28114a)};
                        }
                        formatArr[i4] = a(aVar.f28114a, matcher.group(2), Integer.parseInt(matcher.group(1)));
                    }
                    return formatArr;
                }
            }
        }
        return new Format[0];
    }

    private static ft.g<a>[] b(int i2) {
        return new ft.g[i2];
    }

    private static c c(List<c> list) {
        return a(list, "http://dashif.org/guidelines/trickmode");
    }

    public long a(long j2, com.google.android.exoplayer2.ad adVar) {
        for (ft.g<a> gVar : this.f16090q) {
            if (gVar.f28068a == 2) {
                return gVar.a(j2, adVar);
            }
        }
        return j2;
    }

    public long a(com.google.android.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        int[] a2 = a(eVarArr);
        a(eVarArr, zArr, oVarArr);
        a(eVarArr, oVarArr, a2);
        a(eVarArr, oVarArr, zArr2, j2, a2);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ft.g gVar : oVarArr) {
            if (gVar instanceof ft.g) {
                arrayList.add(gVar);
            } else if (gVar instanceof f) {
                arrayList2.add((f) gVar);
            }
        }
        ft.g<a>[] b2 = b(arrayList.size());
        this.f16090q = b2;
        arrayList.toArray(b2);
        f[] fVarArr = new f[arrayList2.size()];
        this.f16091r = fVarArr;
        arrayList2.toArray(fVarArr);
        this.f16092s = this.f16085l.a(this.f16090q);
        return j2;
    }

    public void a(long j2) {
        this.f16092s.a(j2);
    }

    public void a(long j2, boolean z2) {
        for (ft.g<a> a2 : this.f16090q) {
            a2.a(j2, z2);
        }
    }

    public void a(h.a aVar, long j2) {
        this.f16089p = aVar;
        aVar.a(this);
    }

    public synchronized void a(ft.g<a> gVar) {
        g.c remove = this.f16087n.remove(gVar);
        if (remove != null) {
            remove.a();
        }
    }

    public void a(fu.b bVar, int i2) {
        this.f16093t = bVar;
        this.f16094u = i2;
        this.f16086m.a(bVar);
        ft.g<a>[] gVarArr = this.f16090q;
        if (gVarArr != null) {
            for (ft.g<a> a2 : gVarArr) {
                a2.a().a(bVar, i2);
            }
            this.f16089p.a(this);
        }
        this.f16095v = bVar.a(i2).f28140d;
        for (f fVar : this.f16091r) {
            Iterator<fu.d> it2 = this.f16095v.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                fu.d next = it2.next();
                if (next.a().equals(fVar.a())) {
                    boolean z2 = true;
                    int a3 = bVar.a() - 1;
                    if (!bVar.f28122c || i2 != a3) {
                        z2 = false;
                    }
                    fVar.a(next, z2);
                }
            }
        }
    }

    public long b(long j2) {
        for (ft.g<a> b2 : this.f16090q) {
            b2.b(j2);
        }
        for (f b3 : this.f16091r) {
            b3.b(j2);
        }
        return j2;
    }

    public TrackGroupArray b() {
        return this.f16083j;
    }

    /* renamed from: b */
    public void a(ft.g<a> gVar) {
        this.f16089p.a(this);
    }

    public long c() {
        if (this.f16096w) {
            return -9223372036854775807L;
        }
        this.f16088o.c();
        this.f16096w = true;
        return -9223372036854775807L;
    }

    public boolean c(long j2) {
        return this.f16092s.c(j2);
    }

    public long d() {
        return this.f16092s.d();
    }

    public long e() {
        return this.f16092s.e();
    }

    public boolean f() {
        return this.f16092s.f();
    }

    public void g() {
        this.f16086m.b();
        for (ft.g<a> a2 : this.f16090q) {
            a2.a((g.b<a>) this);
        }
        this.f16089p = null;
        this.f16088o.b();
    }

    public void n_() throws IOException {
        this.f16081h.f();
    }
}
