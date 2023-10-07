package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.hls.l;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.e;
import com.google.android.exoplayer2.upstream.p;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public final class j implements h, l.a, HlsPlaylistTracker.b {

    /* renamed from: a  reason: collision with root package name */
    private final g f16226a;

    /* renamed from: b  reason: collision with root package name */
    private final HlsPlaylistTracker f16227b;

    /* renamed from: c  reason: collision with root package name */
    private final f f16228c;

    /* renamed from: d  reason: collision with root package name */
    private final t f16229d;

    /* renamed from: e  reason: collision with root package name */
    private final b<?> f16230e;

    /* renamed from: f  reason: collision with root package name */
    private final p f16231f;

    /* renamed from: g  reason: collision with root package name */
    private final j.a f16232g;

    /* renamed from: h  reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.b f16233h;

    /* renamed from: i  reason: collision with root package name */
    private final IdentityHashMap<o, Integer> f16234i = new IdentityHashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private final m f16235j = new m();

    /* renamed from: k  reason: collision with root package name */
    private final d f16236k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f16237l;

    /* renamed from: m  reason: collision with root package name */
    private final int f16238m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f16239n;

    /* renamed from: o  reason: collision with root package name */
    private h.a f16240o;

    /* renamed from: p  reason: collision with root package name */
    private int f16241p;

    /* renamed from: q  reason: collision with root package name */
    private TrackGroupArray f16242q;

    /* renamed from: r  reason: collision with root package name */
    private l[] f16243r = new l[0];

    /* renamed from: s  reason: collision with root package name */
    private l[] f16244s = new l[0];

    /* renamed from: t  reason: collision with root package name */
    private int[][] f16245t = new int[0][];

    /* renamed from: u  reason: collision with root package name */
    private com.google.android.exoplayer2.source.p f16246u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f16247v;

    public j(g gVar, HlsPlaylistTracker hlsPlaylistTracker, f fVar, t tVar, b<?> bVar, p pVar, j.a aVar, com.google.android.exoplayer2.upstream.b bVar2, d dVar, boolean z2, int i2, boolean z3) {
        this.f16226a = gVar;
        this.f16227b = hlsPlaylistTracker;
        this.f16228c = fVar;
        this.f16229d = tVar;
        this.f16230e = bVar;
        this.f16231f = pVar;
        this.f16232g = aVar;
        this.f16233h = bVar2;
        this.f16236k = dVar;
        this.f16237l = z2;
        this.f16238m = i2;
        this.f16239n = z3;
        this.f16246u = dVar.a(new com.google.android.exoplayer2.source.p[0]);
        aVar.a();
    }

    private static Format a(Format format) {
        String a2 = ad.a(format.f15089f, 2);
        return Format.a(format.f15084a, format.f15085b, format.f15091h, n.g(a2), a2, format.f15090g, format.f15088e, format.f15097n, format.f15098o, format.f15099p, (List<byte[]>) null, format.f15086c, format.f15087d);
    }

    private static Format a(Format format, Format format2, boolean z2) {
        String str;
        int i2;
        int i3;
        int i4;
        Metadata metadata;
        String str2;
        String str3;
        Format format3 = format;
        Format format4 = format2;
        if (format4 != null) {
            String str4 = format4.f15089f;
            Metadata metadata2 = format4.f15090g;
            int i5 = format4.f15105v;
            int i6 = format4.f15086c;
            int i7 = format4.f15087d;
            String str5 = format4.A;
            str3 = format4.f15085b;
            str2 = str4;
            metadata = metadata2;
            i4 = i5;
            i3 = i6;
            i2 = i7;
            str = str5;
        } else {
            String a2 = ad.a(format3.f15089f, 1);
            Metadata metadata3 = format3.f15090g;
            if (z2) {
                int i8 = format3.f15105v;
                str2 = a2;
                i4 = i8;
                i3 = format3.f15086c;
                metadata = metadata3;
                i2 = format3.f15087d;
                str = format3.A;
                str3 = format3.f15085b;
            } else {
                str2 = a2;
                str3 = null;
                str = null;
                metadata = metadata3;
                i4 = -1;
                i3 = 0;
                i2 = 0;
            }
        }
        return Format.a(format3.f15084a, str3, format3.f15091h, n.g(str2), str2, metadata, z2 ? format3.f15088e : -1, i4, -1, (List<byte[]>) null, i3, i2, str);
    }

    private l a(int i2, Uri[] uriArr, Format[] formatArr, Format format, List<Format> list, Map<String, DrmInitData> map, long j2) {
        return new l(i2, this, new e(this.f16226a, this.f16227b, uriArr, formatArr, this.f16228c, this.f16229d, this.f16235j, list), map, this.f16233h, j2, format, this.f16230e, this.f16231f, this.f16232g, this.f16238m);
    }

    private static Map<String, DrmInitData> a(List<DrmInitData> list) {
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList.size()) {
            DrmInitData drmInitData = list.get(i2);
            String str = drmInitData.f15461a;
            i2++;
            int i3 = i2;
            while (i3 < arrayList.size()) {
                DrmInitData drmInitData2 = (DrmInitData) arrayList.get(i3);
                if (TextUtils.equals(drmInitData2.f15461a, str)) {
                    drmInitData = drmInitData.a(drmInitData2);
                    arrayList.remove(i3);
                } else {
                    i3++;
                }
            }
            hashMap.put(str, drmInitData);
        }
        return hashMap;
    }

    private void a(long j2, List<c.a> list, List<l> list2, List<int[]> list3, Map<String, DrmInitData> map) {
        List<c.a> list4 = list;
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList(list.size());
        ArrayList arrayList3 = new ArrayList(list.size());
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list4.get(i2).f16306d;
            if (!hashSet.add(str)) {
                List<l> list5 = list2;
                List<int[]> list6 = list3;
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList3.clear();
                boolean z2 = true;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (ad.a((Object) str, (Object) list4.get(i3).f16306d)) {
                        c.a aVar = list4.get(i3);
                        arrayList3.add(Integer.valueOf(i3));
                        arrayList.add(aVar.f16303a);
                        arrayList2.add(aVar.f16304b);
                        z2 &= aVar.f16304b.f15089f != null;
                    }
                }
                l a2 = a(1, (Uri[]) arrayList.toArray((Uri[]) ad.a((T[]) new Uri[0])), (Format[]) arrayList2.toArray(new Format[0]), (Format) null, Collections.emptyList(), map, j2);
                list3.add(ad.a((List<Integer>) arrayList3));
                list2.add(a2);
                if (this.f16237l && z2) {
                    a2.a(new TrackGroup[]{new TrackGroup((Format[]) arrayList2.toArray(new Format[0]))}, 0, new int[0]);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.google.android.exoplayer2.source.hls.playlist.c r21, long r22, java.util.List<com.google.android.exoplayer2.source.hls.l> r24, java.util.List<int[]> r25, java.util.Map<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData> r26) {
        /*
            r20 = this;
            r0 = r21
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.c$b> r1 = r0.f16294c
            int r1 = r1.size()
            int[] r2 = new int[r1]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x000e:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.c$b> r7 = r0.f16294c
            int r7 = r7.size()
            r8 = -1
            r9 = 2
            r10 = 1
            if (r4 >= r7) goto L_0x0047
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.c$b> r7 = r0.f16294c
            java.lang.Object r7 = r7.get(r4)
            com.google.android.exoplayer2.source.hls.playlist.c$b r7 = (com.google.android.exoplayer2.source.hls.playlist.c.b) r7
            com.google.android.exoplayer2.Format r7 = r7.f16308b
            int r11 = r7.f15098o
            if (r11 > 0) goto L_0x0040
            java.lang.String r11 = r7.f15089f
            java.lang.String r11 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r11, (int) r9)
            if (r11 == 0) goto L_0x0030
            goto L_0x0040
        L_0x0030:
            java.lang.String r7 = r7.f15089f
            java.lang.String r7 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r7, (int) r10)
            if (r7 == 0) goto L_0x003d
            r2[r4] = r10
            int r6 = r6 + 1
            goto L_0x0044
        L_0x003d:
            r2[r4] = r8
            goto L_0x0044
        L_0x0040:
            r2[r4] = r9
            int r5 = r5 + 1
        L_0x0044:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x0047:
            if (r5 <= 0) goto L_0x004c
            r1 = r5
            r4 = 1
            goto L_0x0053
        L_0x004c:
            if (r6 >= r1) goto L_0x0052
            int r1 = r1 - r6
            r4 = 0
            r5 = 1
            goto L_0x0054
        L_0x0052:
            r4 = 0
        L_0x0053:
            r5 = 0
        L_0x0054:
            android.net.Uri[] r13 = new android.net.Uri[r1]
            com.google.android.exoplayer2.Format[] r6 = new com.google.android.exoplayer2.Format[r1]
            int[] r7 = new int[r1]
            r11 = 0
            r12 = 0
        L_0x005c:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.c$b> r14 = r0.f16294c
            int r14 = r14.size()
            if (r11 >= r14) goto L_0x0088
            if (r4 == 0) goto L_0x006a
            r14 = r2[r11]
            if (r14 != r9) goto L_0x0085
        L_0x006a:
            if (r5 == 0) goto L_0x0070
            r14 = r2[r11]
            if (r14 == r10) goto L_0x0085
        L_0x0070:
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.c$b> r14 = r0.f16294c
            java.lang.Object r14 = r14.get(r11)
            com.google.android.exoplayer2.source.hls.playlist.c$b r14 = (com.google.android.exoplayer2.source.hls.playlist.c.b) r14
            android.net.Uri r15 = r14.f16307a
            r13[r12] = r15
            com.google.android.exoplayer2.Format r14 = r14.f16308b
            r6[r12] = r14
            int r14 = r12 + 1
            r7[r12] = r11
            r12 = r14
        L_0x0085:
            int r11 = r11 + 1
            goto L_0x005c
        L_0x0088:
            r2 = r6[r3]
            java.lang.String r2 = r2.f15089f
            r12 = 0
            com.google.android.exoplayer2.Format r15 = r0.f16299h
            java.util.List<com.google.android.exoplayer2.Format> r4 = r0.f16300i
            r11 = r20
            r14 = r6
            r16 = r4
            r17 = r26
            r18 = r22
            com.google.android.exoplayer2.source.hls.l r4 = r11.a(r12, r13, r14, r15, r16, r17, r18)
            r5 = r24
            r5.add(r4)
            r5 = r25
            r5.add(r7)
            r5 = r20
            boolean r7 = r5.f16237l
            if (r7 == 0) goto L_0x0185
            if (r2 == 0) goto L_0x0185
            java.lang.String r7 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r2, (int) r9)
            if (r7 == 0) goto L_0x00b8
            r7 = 1
            goto L_0x00b9
        L_0x00b8:
            r7 = 0
        L_0x00b9:
            java.lang.String r9 = com.google.android.exoplayer2.util.ad.a((java.lang.String) r2, (int) r10)
            if (r9 == 0) goto L_0x00c1
            r9 = 1
            goto L_0x00c2
        L_0x00c1:
            r9 = 0
        L_0x00c2:
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            if (r7 == 0) goto L_0x0123
            com.google.android.exoplayer2.Format[] r2 = new com.google.android.exoplayer2.Format[r1]
            r7 = 0
        L_0x00cc:
            if (r7 >= r1) goto L_0x00d9
            r12 = r6[r7]
            com.google.android.exoplayer2.Format r12 = a((com.google.android.exoplayer2.Format) r12)
            r2[r7] = r12
            int r7 = r7 + 1
            goto L_0x00cc
        L_0x00d9:
            com.google.android.exoplayer2.source.TrackGroup r1 = new com.google.android.exoplayer2.source.TrackGroup
            r1.<init>((com.google.android.exoplayer2.Format[]) r2)
            r11.add(r1)
            if (r9 == 0) goto L_0x0103
            com.google.android.exoplayer2.Format r1 = r0.f16299h
            if (r1 != 0) goto L_0x00ef
            java.util.List<com.google.android.exoplayer2.source.hls.playlist.c$a> r1 = r0.f16296e
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0103
        L_0x00ef:
            com.google.android.exoplayer2.source.TrackGroup r1 = new com.google.android.exoplayer2.source.TrackGroup
            com.google.android.exoplayer2.Format[] r2 = new com.google.android.exoplayer2.Format[r10]
            r6 = r6[r3]
            com.google.android.exoplayer2.Format r7 = r0.f16299h
            com.google.android.exoplayer2.Format r6 = a(r6, r7, r3)
            r2[r3] = r6
            r1.<init>((com.google.android.exoplayer2.Format[]) r2)
            r11.add(r1)
        L_0x0103:
            java.util.List<com.google.android.exoplayer2.Format> r0 = r0.f16300i
            if (r0 == 0) goto L_0x013f
            r1 = 0
        L_0x0108:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x013f
            com.google.android.exoplayer2.source.TrackGroup r2 = new com.google.android.exoplayer2.source.TrackGroup
            com.google.android.exoplayer2.Format[] r6 = new com.google.android.exoplayer2.Format[r10]
            java.lang.Object r7 = r0.get(r1)
            com.google.android.exoplayer2.Format r7 = (com.google.android.exoplayer2.Format) r7
            r6[r3] = r7
            r2.<init>((com.google.android.exoplayer2.Format[]) r6)
            r11.add(r2)
            int r1 = r1 + 1
            goto L_0x0108
        L_0x0123:
            if (r9 == 0) goto L_0x0168
            com.google.android.exoplayer2.Format[] r2 = new com.google.android.exoplayer2.Format[r1]
            r7 = 0
        L_0x0128:
            if (r7 >= r1) goto L_0x0137
            r9 = r6[r7]
            com.google.android.exoplayer2.Format r12 = r0.f16299h
            com.google.android.exoplayer2.Format r9 = a(r9, r12, r10)
            r2[r7] = r9
            int r7 = r7 + 1
            goto L_0x0128
        L_0x0137:
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            r0.<init>((com.google.android.exoplayer2.Format[]) r2)
            r11.add(r0)
        L_0x013f:
            com.google.android.exoplayer2.source.TrackGroup r0 = new com.google.android.exoplayer2.source.TrackGroup
            com.google.android.exoplayer2.Format[] r1 = new com.google.android.exoplayer2.Format[r10]
            java.lang.String r2 = "ID3"
            java.lang.String r6 = "application/id3"
            r7 = 0
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r2, (java.lang.String) r6, (java.lang.String) r7, (int) r8, (com.google.android.exoplayer2.drm.DrmInitData) r7)
            r1[r3] = r2
            r0.<init>((com.google.android.exoplayer2.Format[]) r1)
            r11.add(r0)
            com.google.android.exoplayer2.source.TrackGroup[] r1 = new com.google.android.exoplayer2.source.TrackGroup[r3]
            java.lang.Object[] r1 = r11.toArray(r1)
            com.google.android.exoplayer2.source.TrackGroup[] r1 = (com.google.android.exoplayer2.source.TrackGroup[]) r1
            int[] r2 = new int[r10]
            int r0 = r11.indexOf(r0)
            r2[r3] = r0
            r4.a((com.google.android.exoplayer2.source.TrackGroup[]) r1, (int) r3, (int[]) r2)
            goto L_0x0185
        L_0x0168:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unexpected codecs attribute: "
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x017b
            java.lang.String r1 = r1.concat(r2)
            goto L_0x0181
        L_0x017b:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r1 = r2
        L_0x0181:
            r0.<init>(r1)
            throw r0
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.j.a(com.google.android.exoplayer2.source.hls.playlist.c, long, java.util.List, java.util.List, java.util.Map):void");
    }

    private void d(long j2) {
        c cVar = (c) a.b(this.f16227b.b());
        Map<String, DrmInitData> a2 = this.f16239n ? a(cVar.f16302k) : Collections.emptyMap();
        boolean z2 = !cVar.f16294c.isEmpty();
        List<c.a> list = cVar.f16296e;
        List<c.a> list2 = cVar.f16297f;
        this.f16241p = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (z2) {
            a(cVar, j2, (List<l>) arrayList, (List<int[]>) arrayList2, a2);
        }
        a(j2, list, (List<l>) arrayList, (List<int[]>) arrayList2, a2);
        int i2 = 0;
        while (i2 < list2.size()) {
            c.a aVar = list2.get(i2);
            int i3 = i2;
            l a3 = a(3, new Uri[]{aVar.f16303a}, new Format[]{aVar.f16304b}, (Format) null, Collections.emptyList(), a2, j2);
            arrayList2.add(new int[]{i3});
            arrayList.add(a3);
            a3.a(new TrackGroup[]{new TrackGroup(aVar.f16304b)}, 0, new int[0]);
            i2 = i3 + 1;
        }
        this.f16243r = (l[]) arrayList.toArray(new l[0]);
        this.f16245t = (int[][]) arrayList2.toArray(new int[0][]);
        l[] lVarArr = this.f16243r;
        this.f16241p = lVarArr.length;
        lVarArr[0].a(true);
        for (l b2 : this.f16243r) {
            b2.b();
        }
        this.f16244s = this.f16243r;
    }

    public long a(long j2, com.google.android.exoplayer2.ad adVar) {
        return j2;
    }

    public long a(e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        e[] eVarArr2 = eVarArr;
        o[] oVarArr2 = oVarArr;
        int[] iArr = new int[eVarArr2.length];
        int[] iArr2 = new int[eVarArr2.length];
        for (int i2 = 0; i2 < eVarArr2.length; i2++) {
            iArr[i2] = oVarArr2[i2] == null ? -1 : this.f16234i.get(oVarArr2[i2]).intValue();
            iArr2[i2] = -1;
            if (eVarArr2[i2] != null) {
                TrackGroup g2 = eVarArr2[i2].g();
                int i3 = 0;
                while (true) {
                    l[] lVarArr = this.f16243r;
                    if (i3 >= lVarArr.length) {
                        break;
                    } else if (lVarArr[i3].g().a(g2) != -1) {
                        iArr2[i2] = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        this.f16234i.clear();
        int length = eVarArr2.length;
        o[] oVarArr3 = new o[length];
        o[] oVarArr4 = new o[eVarArr2.length];
        e[] eVarArr3 = new e[eVarArr2.length];
        l[] lVarArr2 = new l[this.f16243r.length];
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        while (i5 < this.f16243r.length) {
            for (int i6 = 0; i6 < eVarArr2.length; i6++) {
                e eVar = null;
                oVarArr4[i6] = iArr[i6] == i5 ? oVarArr2[i6] : null;
                if (iArr2[i6] == i5) {
                    eVar = eVarArr2[i6];
                }
                eVarArr3[i6] = eVar;
            }
            l lVar = this.f16243r[i5];
            l lVar2 = lVar;
            int i7 = length;
            int i8 = i5;
            int i9 = i4;
            e[] eVarArr4 = eVarArr3;
            l[] lVarArr3 = lVarArr2;
            boolean a2 = lVar.a(eVarArr3, zArr, oVarArr4, zArr2, j2, z2);
            int i10 = 0;
            boolean z3 = false;
            while (true) {
                boolean z4 = true;
                if (i10 >= eVarArr2.length) {
                    break;
                }
                o oVar = oVarArr4[i10];
                if (iArr2[i10] == i8) {
                    a.b(oVar);
                    oVarArr3[i10] = oVar;
                    this.f16234i.put(oVar, Integer.valueOf(i8));
                    z3 = true;
                } else if (iArr[i10] == i8) {
                    if (oVar != null) {
                        z4 = false;
                    }
                    a.b(z4);
                }
                i10++;
            }
            if (z3) {
                lVarArr3[i9] = lVar2;
                i4 = i9 + 1;
                if (i9 == 0) {
                    lVar2.a(true);
                    if (!a2) {
                        l[] lVarArr4 = this.f16244s;
                        if (lVarArr4.length != 0) {
                            if (lVar2 == lVarArr4[0]) {
                            }
                            this.f16235j.a();
                            z2 = true;
                        }
                    }
                    this.f16235j.a();
                    z2 = true;
                } else {
                    lVar2.a(false);
                }
            } else {
                i4 = i9;
            }
            i5 = i8 + 1;
            lVarArr2 = lVarArr3;
            length = i7;
            eVarArr3 = eVarArr4;
            oVarArr2 = oVarArr;
        }
        System.arraycopy(oVarArr3, 0, oVarArr2, 0, length);
        l[] lVarArr5 = (l[]) ad.a((T[]) lVarArr2, i4);
        this.f16244s = lVarArr5;
        this.f16246u = this.f16236k.a(lVarArr5);
        return j2;
    }

    public void a(long j2) {
        this.f16246u.a(j2);
    }

    public void a(long j2, boolean z2) {
        for (l a2 : this.f16244s) {
            a2.a(j2, z2);
        }
    }

    public void a(Uri uri) {
        this.f16227b.c(uri);
    }

    public void a(h.a aVar, long j2) {
        this.f16240o = aVar;
        this.f16227b.a((HlsPlaylistTracker.b) this);
        d(j2);
    }

    public void a(l lVar) {
        this.f16240o.a(this);
    }

    public boolean a(Uri uri, long j2) {
        boolean z2 = true;
        for (l a2 : this.f16243r) {
            z2 &= a2.a(uri, j2);
        }
        this.f16240o.a(this);
        return z2;
    }

    public long b(long j2) {
        l[] lVarArr = this.f16244s;
        if (lVarArr.length > 0) {
            boolean b2 = lVarArr[0].b(j2, false);
            int i2 = 1;
            while (true) {
                l[] lVarArr2 = this.f16244s;
                if (i2 >= lVarArr2.length) {
                    break;
                }
                lVarArr2[i2].b(j2, b2);
                i2++;
            }
            if (b2) {
                this.f16235j.a();
            }
        }
        return j2;
    }

    public TrackGroupArray b() {
        return (TrackGroupArray) a.b(this.f16242q);
    }

    public long c() {
        if (this.f16247v) {
            return -9223372036854775807L;
        }
        this.f16232g.c();
        this.f16247v = true;
        return -9223372036854775807L;
    }

    public boolean c(long j2) {
        if (this.f16242q != null) {
            return this.f16246u.c(j2);
        }
        for (l b2 : this.f16243r) {
            b2.b();
        }
        return false;
    }

    public long d() {
        return this.f16246u.d();
    }

    public long e() {
        return this.f16246u.e();
    }

    public boolean f() {
        return this.f16246u.f();
    }

    public void g() {
        this.f16227b.b((HlsPlaylistTracker.b) this);
        for (l i2 : this.f16243r) {
            i2.i();
        }
        this.f16240o = null;
        this.f16232g.b();
    }

    public void h() {
        int i2 = this.f16241p - 1;
        this.f16241p = i2;
        if (i2 <= 0) {
            int i3 = 0;
            for (l g2 : this.f16243r) {
                i3 += g2.g().f16009b;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i3];
            int i4 = 0;
            for (l lVar : this.f16243r) {
                int i5 = lVar.g().f16009b;
                int i6 = 0;
                while (i6 < i5) {
                    trackGroupArr[i4] = lVar.g().a(i6);
                    i6++;
                    i4++;
                }
            }
            this.f16242q = new TrackGroupArray(trackGroupArr);
            this.f16240o.a(this);
        }
    }

    public void i() {
        this.f16240o.a(this);
    }

    public void n_() throws IOException {
        for (l c2 : this.f16243r) {
            c2.c();
        }
    }
}
