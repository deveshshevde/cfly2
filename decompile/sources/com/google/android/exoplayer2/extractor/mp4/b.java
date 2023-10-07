package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.extractor.mp4.d;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.video.ColorInfo;
import fj.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f15520a = ad.c("OpusHead");

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f15521a;

        /* renamed from: b  reason: collision with root package name */
        public int f15522b;

        /* renamed from: c  reason: collision with root package name */
        public int f15523c;

        /* renamed from: d  reason: collision with root package name */
        public long f15524d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f15525e;

        /* renamed from: f  reason: collision with root package name */
        private final q f15526f;

        /* renamed from: g  reason: collision with root package name */
        private final q f15527g;

        /* renamed from: h  reason: collision with root package name */
        private int f15528h;

        /* renamed from: i  reason: collision with root package name */
        private int f15529i;

        public a(q qVar, q qVar2, boolean z2) {
            this.f15527g = qVar;
            this.f15526f = qVar2;
            this.f15525e = z2;
            qVar2.c(12);
            this.f15521a = qVar2.v();
            qVar.c(12);
            this.f15529i = qVar.v();
            com.google.android.exoplayer2.util.a.b(qVar.p() != 1 ? false : true, "first_chunk must be 1");
            this.f15522b = -1;
        }

        public boolean a() {
            int i2 = this.f15522b + 1;
            this.f15522b = i2;
            if (i2 == this.f15521a) {
                return false;
            }
            this.f15524d = this.f15525e ? this.f15526f.x() : this.f15526f.n();
            if (this.f15522b == this.f15528h) {
                this.f15523c = this.f15527g.v();
                this.f15527g.d(4);
                int i3 = this.f15529i - 1;
                this.f15529i = i3;
                this.f15528h = i3 > 0 ? this.f15527g.v() - 1 : -1;
            }
            return true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.b$b  reason: collision with other inner class name */
    private interface C0111b {
        int a();

        int b();

        boolean c();
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final k[] f15530a;

        /* renamed from: b  reason: collision with root package name */
        public Format f15531b;

        /* renamed from: c  reason: collision with root package name */
        public int f15532c;

        /* renamed from: d  reason: collision with root package name */
        public int f15533d = 0;

        public c(int i2) {
            this.f15530a = new k[i2];
        }
    }

    static final class d implements C0111b {

        /* renamed from: a  reason: collision with root package name */
        private final int f15534a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15535b;

        /* renamed from: c  reason: collision with root package name */
        private final q f15536c;

        public d(a.b bVar) {
            q qVar = bVar.f15519b;
            this.f15536c = qVar;
            qVar.c(12);
            this.f15534a = qVar.v();
            this.f15535b = qVar.v();
        }

        public int a() {
            return this.f15535b;
        }

        public int b() {
            int i2 = this.f15534a;
            return i2 == 0 ? this.f15536c.v() : i2;
        }

        public boolean c() {
            return this.f15534a != 0;
        }
    }

    static final class e implements C0111b {

        /* renamed from: a  reason: collision with root package name */
        private final q f15537a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15538b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15539c;

        /* renamed from: d  reason: collision with root package name */
        private int f15540d;

        /* renamed from: e  reason: collision with root package name */
        private int f15541e;

        public e(a.b bVar) {
            q qVar = bVar.f15519b;
            this.f15537a = qVar;
            qVar.c(12);
            this.f15539c = qVar.v() & 255;
            this.f15538b = qVar.v();
        }

        public int a() {
            return this.f15538b;
        }

        public int b() {
            int i2 = this.f15539c;
            if (i2 == 8) {
                return this.f15537a.h();
            }
            if (i2 == 16) {
                return this.f15537a.i();
            }
            int i3 = this.f15540d;
            this.f15540d = i3 + 1;
            if (i3 % 2 != 0) {
                return this.f15541e & 15;
            }
            int h2 = this.f15537a.h();
            this.f15541e = h2;
            return (h2 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4;
        }

        public boolean c() {
            return false;
        }
    }

    private static final class f {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f15542a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f15543b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f15544c;

        public f(int i2, long j2, int i3) {
            this.f15542a = i2;
            this.f15543b = j2;
            this.f15544c = i3;
        }
    }

    private static int a(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728) {
            return 3;
        }
        return i2 == 1835365473 ? 4 : -1;
    }

    private static long a(q qVar) {
        int i2 = 8;
        qVar.c(8);
        if (a.a(qVar.p()) != 0) {
            i2 = 16;
        }
        qVar.d(i2);
        return qVar.n();
    }

    static Pair<Integer, k> a(q qVar, int i2, int i3) {
        int i4 = i2 + 8;
        boolean z2 = false;
        String str = null;
        Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            qVar.c(i4);
            int p2 = qVar.p();
            int p3 = qVar.p();
            if (p3 == 1718775137) {
                num = Integer.valueOf(qVar.p());
            } else if (p3 == 1935894637) {
                qVar.d(4);
                str = qVar.e(4);
            } else if (p3 == 1935894633) {
                i5 = i4;
                i6 = p2;
            }
            i4 += p2;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        com.google.android.exoplayer2.util.a.a(num != null, (Object) "frma atom is mandatory");
        com.google.android.exoplayer2.util.a.a(i5 != -1, (Object) "schi atom is mandatory");
        k a2 = a(qVar, i5, i6, str);
        if (a2 != null) {
            z2 = true;
        }
        com.google.android.exoplayer2.util.a.a(z2, (Object) "tenc atom is mandatory");
        return Pair.create(num, a2);
    }

    private static c a(q qVar, int i2, int i3, String str, DrmInitData drmInitData, boolean z2) throws ParserException {
        q qVar2 = qVar;
        qVar2.c(12);
        int p2 = qVar.p();
        c cVar = new c(p2);
        for (int i4 = 0; i4 < p2; i4++) {
            int d2 = qVar.d();
            int p3 = qVar.p();
            com.google.android.exoplayer2.util.a.a(p3 > 0, (Object) "childAtomSize should be positive");
            int p4 = qVar.p();
            if (p4 == 1635148593 || p4 == 1635148595 || p4 == 1701733238 || p4 == 1836070006 || p4 == 1752589105 || p4 == 1751479857 || p4 == 1932670515 || p4 == 1987063864 || p4 == 1987063865 || p4 == 1635135537 || p4 == 1685479798 || p4 == 1685479729 || p4 == 1685481573 || p4 == 1685481521) {
                a(qVar, p4, d2, p3, i2, i3, drmInitData, cVar, i4);
            } else if (p4 == 1836069985 || p4 == 1701733217 || p4 == 1633889587 || p4 == 1700998451 || p4 == 1633889588 || p4 == 1685353315 || p4 == 1685353317 || p4 == 1685353320 || p4 == 1685353324 || p4 == 1935764850 || p4 == 1935767394 || p4 == 1819304813 || p4 == 1936684916 || p4 == 1953984371 || p4 == 778924083 || p4 == 1634492771 || p4 == 1634492791 || p4 == 1970037111 || p4 == 1332770163 || p4 == 1716281667) {
                a(qVar, p4, d2, p3, i2, str, z2, drmInitData, cVar, i4);
            } else if (p4 == 1414810956 || p4 == 1954034535 || p4 == 2004251764 || p4 == 1937010800 || p4 == 1664495672) {
                a(qVar, p4, d2, p3, i2, str, cVar);
            } else if (p4 == 1667329389) {
                cVar.f15531b = Format.a(Integer.toString(i2), "application/x-camera-motion", (String) null, -1, (DrmInitData) null);
            }
            qVar2.c(d2 + p3);
        }
        return cVar;
    }

    public static j a(a.C0110a aVar, a.b bVar, long j2, DrmInitData drmInitData, boolean z2, boolean z3) throws ParserException {
        long j3;
        a.b bVar2;
        long[] jArr;
        long[] jArr2;
        a.C0110a aVar2 = aVar;
        a.C0110a e2 = aVar2.e(1835297121);
        int a2 = a(c(e2.d(1751411826).f15519b));
        if (a2 == -1) {
            return null;
        }
        f b2 = b(aVar2.d(1953196132).f15519b);
        long j4 = -9223372036854775807L;
        if (j2 == -9223372036854775807L) {
            bVar2 = bVar;
            j3 = b2.f15543b;
        } else {
            bVar2 = bVar;
            j3 = j2;
        }
        long a3 = a(bVar2.f15519b);
        if (j3 != -9223372036854775807L) {
            j4 = ad.d(j3, 1000000, a3);
        }
        long j5 = j4;
        a.C0110a e3 = e2.e(1835626086).e(1937007212);
        Pair<Long, String> d2 = d(e2.d(1835296868).f15519b);
        c a4 = a(e3.d(1937011556).f15519b, b2.f15542a, b2.f15544c, (String) d2.second, drmInitData, z3);
        if (!z2) {
            Pair<long[], long[]> b3 = b(aVar2.e(1701082227));
            jArr = (long[]) b3.second;
            jArr2 = (long[]) b3.first;
        } else {
            jArr2 = null;
            jArr = null;
        }
        if (a4.f15531b == null) {
            return null;
        }
        return new j(b2.f15542a, a2, ((Long) d2.first).longValue(), a3, j5, a4.f15531b, a4.f15533d, a4.f15530a, a4.f15532c, jArr2, jArr);
    }

    private static k a(q qVar, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            qVar.c(i6);
            int p2 = qVar.p();
            if (qVar.p() == 1952804451) {
                int a2 = a.a(qVar.p());
                qVar.d(1);
                if (a2 == 0) {
                    qVar.d(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int h2 = qVar.h();
                    i4 = h2 & 15;
                    i5 = (h2 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >> 4;
                }
                boolean z2 = qVar.h() == 1;
                int h3 = qVar.h();
                byte[] bArr2 = new byte[16];
                qVar.a(bArr2, 0, 16);
                if (z2 && h3 == 0) {
                    int h4 = qVar.h();
                    bArr = new byte[h4];
                    qVar.a(bArr, 0, h4);
                }
                return new k(z2, str, h3, bArr2, i5, i4, bArr);
            }
            i6 += p2;
        }
    }

    public static m a(j jVar, a.C0110a aVar, o oVar) throws ParserException {
        C0111b bVar;
        boolean z2;
        int i2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        long j2;
        int[] iArr;
        long[] jArr;
        j jVar2;
        int[] iArr2;
        long[] jArr2;
        int i6;
        int i7;
        int i8;
        int[] iArr3;
        int[] iArr4;
        long[] jArr3;
        int i9;
        int i10;
        int i11;
        boolean z4;
        int i12;
        int i13;
        int i14;
        j jVar3 = jVar;
        a.C0110a aVar2 = aVar;
        o oVar2 = oVar;
        a.b d2 = aVar2.d(1937011578);
        if (d2 != null) {
            bVar = new d(d2);
        } else {
            a.b d3 = aVar2.d(1937013298);
            if (d3 != null) {
                bVar = new e(d3);
            } else {
                throw new ParserException("Track has no sample table size information");
            }
        }
        int a2 = bVar.a();
        if (a2 == 0) {
            return new m(jVar, new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
        }
        a.b d4 = aVar2.d(1937007471);
        if (d4 == null) {
            d4 = aVar2.d(1668232756);
            z2 = true;
        } else {
            z2 = false;
        }
        q qVar = d4.f15519b;
        q qVar2 = aVar2.d(1937011555).f15519b;
        q qVar3 = aVar2.d(1937011827).f15519b;
        a.b d5 = aVar2.d(1937011571);
        q qVar4 = null;
        q qVar5 = d5 != null ? d5.f15519b : null;
        a.b d6 = aVar2.d(1668576371);
        q qVar6 = d6 != null ? d6.f15519b : null;
        a aVar3 = new a(qVar2, qVar, z2);
        qVar3.c(12);
        int v2 = qVar3.v() - 1;
        int v3 = qVar3.v();
        int v4 = qVar3.v();
        if (qVar6 != null) {
            qVar6.c(12);
            i2 = qVar6.v();
        } else {
            i2 = 0;
        }
        int i15 = -1;
        if (qVar5 != null) {
            qVar5.c(12);
            i3 = qVar5.v();
            if (i3 > 0) {
                i15 = qVar5.v() - 1;
                qVar4 = qVar5;
            }
        } else {
            qVar4 = qVar5;
            i3 = 0;
        }
        if (bVar.c() && "audio/raw".equals(jVar3.f15630f.f15092i) && v2 == 0 && i2 == 0 && i3 == 0) {
            i4 = v2;
            z3 = true;
        } else {
            i4 = v2;
            z3 = false;
        }
        if (!z3) {
            long[] jArr4 = new long[a2];
            int[] iArr5 = new int[a2];
            long[] jArr5 = new long[a2];
            int[] iArr6 = new int[a2];
            q qVar7 = qVar3;
            int i16 = i15;
            int i17 = 0;
            i5 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            long j3 = 0;
            long j4 = 0;
            int i21 = i2;
            int i22 = v4;
            int i23 = v3;
            while (true) {
                if (i17 >= a2) {
                    int i24 = a2;
                    i9 = i23;
                    i10 = i18;
                    i11 = i19;
                    break;
                }
                long j5 = j4;
                int i25 = i19;
                boolean z5 = true;
                while (i25 == 0) {
                    z5 = aVar3.a();
                    if (!z5) {
                        break;
                    }
                    int i26 = i23;
                    long j6 = aVar3.f15524d;
                    i25 = aVar3.f15523c;
                    j5 = j6;
                    i23 = i26;
                    i22 = i22;
                    a2 = a2;
                }
                int i27 = a2;
                i9 = i23;
                int i28 = i22;
                if (!z5) {
                    k.c("AtomParsers", "Unexpected end of chunk data");
                    jArr4 = Arrays.copyOf(jArr4, i17);
                    iArr5 = Arrays.copyOf(iArr5, i17);
                    jArr5 = Arrays.copyOf(jArr5, i17);
                    iArr6 = Arrays.copyOf(iArr6, i17);
                    a2 = i17;
                    i10 = i18;
                    i11 = i25;
                    break;
                }
                if (qVar6 != null) {
                    while (i20 == 0 && i21 > 0) {
                        i20 = qVar6.v();
                        i18 = qVar6.p();
                        i21--;
                    }
                    i20--;
                }
                int i29 = i18;
                jArr4[i17] = j5;
                iArr5[i17] = bVar.b();
                if (iArr5[i17] > i5) {
                    i5 = iArr5[i17];
                }
                jArr5[i17] = j3 + ((long) i29);
                iArr6[i17] = qVar4 == null ? 1 : 0;
                if (i17 == i16) {
                    iArr6[i17] = 1;
                    i3--;
                    if (i3 > 0) {
                        i16 = qVar4.v() - 1;
                    }
                }
                int i30 = i16;
                int i31 = i29;
                int i32 = i28;
                j3 += (long) i32;
                int i33 = i9 - 1;
                if (i33 != 0 || i4 <= 0) {
                    i14 = i32;
                    i13 = i4;
                } else {
                    i33 = qVar7.v();
                    i14 = qVar7.p();
                    i13 = i4 - 1;
                }
                int i34 = i33;
                i19 = i25 - 1;
                i17++;
                j4 = j5 + ((long) iArr5[i17]);
                i16 = i30;
                i22 = i14;
                a2 = i27;
                i18 = i31;
                int i35 = i13;
                i23 = i34;
                i4 = i35;
            }
            long j7 = j3 + ((long) i10);
            while (true) {
                if (i21 <= 0) {
                    z4 = true;
                    break;
                } else if (qVar6.v() != 0) {
                    z4 = false;
                    break;
                } else {
                    qVar6.p();
                    i21--;
                }
            }
            if (i3 == 0 && i9 == 0 && i11 == 0 && i4 == 0) {
                i12 = i20;
                if (i12 == 0 && z4) {
                    jVar2 = jVar;
                    i6 = a2;
                    jArr2 = jArr4;
                    jArr = jArr5;
                    iArr = iArr6;
                    iArr2 = iArr5;
                    j2 = j7;
                }
            } else {
                i12 = i20;
            }
            jVar2 = jVar;
            int i36 = jVar2.f15625a;
            String str = !z4 ? ", ctts invalid" : "";
            StringBuilder sb = new StringBuilder(str.length() + 262);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i36);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i3);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i9);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i11);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i4);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i12);
            sb.append(str);
            k.c("AtomParsers", sb.toString());
            i6 = a2;
            jArr2 = jArr4;
            jArr = jArr5;
            iArr = iArr6;
            iArr2 = iArr5;
            j2 = j7;
        } else {
            jVar2 = jVar3;
            int i37 = a2;
            long[] jArr6 = new long[aVar3.f15521a];
            int[] iArr7 = new int[aVar3.f15521a];
            while (aVar3.a()) {
                jArr6[aVar3.f15522b] = aVar3.f15524d;
                iArr7[aVar3.f15522b] = aVar3.f15523c;
            }
            d.a a3 = d.a(ad.c(jVar2.f15630f.f15107x, jVar2.f15630f.f15105v), jArr6, iArr7, (long) v4);
            long[] jArr7 = a3.f15549a;
            int[] iArr8 = a3.f15550b;
            int i38 = a3.f15551c;
            jArr = a3.f15552d;
            iArr = a3.f15553e;
            j2 = a3.f15554f;
            i5 = i38;
            i6 = i37;
            iArr2 = iArr8;
            jArr2 = jArr7;
        }
        long d7 = ad.d(j2, 1000000, jVar2.f15627c);
        if (jVar2.f15632h == null) {
            ad.a(jArr, 1000000, jVar2.f15627c);
            return new m(jVar, jArr2, iArr2, i5, jArr, iArr, d7);
        }
        if (jVar2.f15632h.length == 1 && jVar2.f15626b == 1 && jArr.length >= 2) {
            long j8 = jVar2.f15633i[0];
            i7 = i5;
            long d8 = ad.d(jVar2.f15632h[0], jVar2.f15627c, jVar2.f15628d) + j8;
            if (a(jArr, j2, j8, d8)) {
                long j9 = j2 - d8;
                long d9 = ad.d(j8 - jArr[0], (long) jVar2.f15630f.f15106w, jVar2.f15627c);
                long d10 = ad.d(j9, (long) jVar2.f15630f.f15106w, jVar2.f15627c);
                if (!(d9 == 0 && d10 == 0) && d9 <= 2147483647L && d10 <= 2147483647L) {
                    o oVar3 = oVar;
                    oVar3.f27384a = (int) d9;
                    oVar3.f27385b = (int) d10;
                    ad.a(jArr, 1000000, jVar2.f15627c);
                    return new m(jVar, jArr2, iArr2, i7, jArr, iArr, ad.d(jVar2.f15632h[0], 1000000, jVar2.f15628d));
                }
            }
        } else {
            i7 = i5;
        }
        if (jVar2.f15632h.length == 1 && jVar2.f15632h[0] == 0) {
            long j10 = jVar2.f15633i[0];
            for (int i39 = 0; i39 < jArr.length; i39++) {
                jArr[i39] = ad.d(jArr[i39] - j10, 1000000, jVar2.f15627c);
            }
            return new m(jVar, jArr2, iArr2, i7, jArr, iArr, ad.d(j2 - j10, 1000000, jVar2.f15627c));
        }
        boolean z6 = jVar2.f15626b == 1;
        int[] iArr9 = new int[jVar2.f15632h.length];
        int[] iArr10 = new int[jVar2.f15632h.length];
        int i40 = 0;
        boolean z7 = false;
        int i41 = 0;
        int i42 = 0;
        while (i40 < jVar2.f15632h.length) {
            int i43 = i41;
            long j11 = jVar2.f15633i[i40];
            if (j11 != -1) {
                jArr3 = jArr2;
                iArr4 = iArr2;
                long d11 = ad.d(jVar2.f15632h[i40], jVar2.f15627c, jVar2.f15628d);
                iArr9[i40] = ad.a(jArr, j11, true, true);
                iArr10[i40] = ad.b(jArr, j11 + d11, z6, false);
                while (iArr9[i40] < iArr10[i40] && (iArr[iArr9[i40]] & 1) == 0) {
                    iArr9[i40] = iArr9[i40] + 1;
                }
                i41 = i43 + (iArr10[i40] - iArr9[i40]);
                boolean z8 = i42 != iArr9[i40];
                i42 = iArr10[i40];
                z7 |= z8;
            } else {
                jArr3 = jArr2;
                iArr4 = iArr2;
                i41 = i43;
            }
            i40++;
            jArr2 = jArr3;
            iArr2 = iArr4;
        }
        long[] jArr8 = jArr2;
        int[] iArr11 = iArr2;
        int i44 = 0;
        boolean z9 = true;
        if (i41 == i6) {
            z9 = false;
        }
        boolean z10 = z7 | z9;
        long[] jArr9 = z10 ? new long[i41] : jArr8;
        int[] iArr12 = z10 ? new int[i41] : iArr11;
        int i45 = z10 ? 0 : i7;
        int[] iArr13 = z10 ? new int[i41] : iArr;
        long[] jArr10 = new long[i41];
        int i46 = 0;
        long j12 = 0;
        while (i44 < jVar2.f15632h.length) {
            long j13 = jVar2.f15633i[i44];
            int i47 = iArr9[i44];
            int[] iArr14 = iArr9;
            int i48 = iArr10[i44];
            int[] iArr15 = iArr10;
            if (z10) {
                int i49 = i48 - i47;
                i8 = i45;
                System.arraycopy(jArr8, i47, jArr9, i46, i49);
                iArr3 = iArr11;
                System.arraycopy(iArr3, i47, iArr12, i46, i49);
                System.arraycopy(iArr, i47, iArr13, i46, i49);
            } else {
                i8 = i45;
                iArr3 = iArr11;
            }
            int i50 = i8;
            while (i47 < i48) {
                int[] iArr16 = iArr;
                int i51 = i48;
                long j14 = j12;
                int i52 = i44;
                long[] jArr11 = jArr9;
                jArr10[i46] = ad.d(j12, 1000000, jVar2.f15628d) + ad.d(Math.max(0, jArr[i47] - j13), 1000000, jVar2.f15627c);
                if (z10 && iArr12[i46] > i50) {
                    i50 = iArr3[i47];
                }
                i46++;
                i47++;
                i48 = i51;
                i44 = i52;
                j12 = j14;
                iArr = iArr16;
                jArr9 = jArr11;
            }
            int i53 = i44;
            j12 += jVar2.f15632h[i53];
            i44 = i53 + 1;
            iArr = iArr;
            iArr9 = iArr14;
            jArr9 = jArr9;
            iArr11 = iArr3;
            i45 = i50;
            iArr10 = iArr15;
        }
        return new m(jVar, jArr9, iArr12, i45, jArr10, iArr13, ad.d(j12, 1000000, jVar2.f15628d));
    }

    public static Metadata a(a.C0110a aVar) {
        a.b d2 = aVar.d(1751411826);
        a.b d3 = aVar.d(1801812339);
        a.b d4 = aVar.d(1768715124);
        if (d2 == null || d3 == null || d4 == null || c(d2.f15519b) != 1835299937) {
            return null;
        }
        q qVar = d3.f15519b;
        qVar.c(12);
        int p2 = qVar.p();
        String[] strArr = new String[p2];
        for (int i2 = 0; i2 < p2; i2++) {
            int p3 = qVar.p();
            qVar.d(4);
            strArr[i2] = qVar.e(p3 - 8);
        }
        q qVar2 = d4.f15519b;
        qVar2.c(8);
        ArrayList arrayList = new ArrayList();
        while (qVar2.b() > 8) {
            int d5 = qVar2.d();
            int p4 = qVar2.p();
            int p5 = qVar2.p() - 1;
            if (p5 < 0 || p5 >= p2) {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Skipped metadata with unknown key index: ");
                sb.append(p5);
                k.c("AtomParsers", sb.toString());
            } else {
                MdtaMetadataEntry a2 = f.a(qVar2, d5 + p4, strArr[p5]);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            qVar2.c(d5 + p4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    public static Metadata a(a.b bVar, boolean z2) {
        if (z2) {
            return null;
        }
        q qVar = bVar.f15519b;
        qVar.c(8);
        while (qVar.b() >= 8) {
            int d2 = qVar.d();
            int p2 = qVar.p();
            if (qVar.p() == 1835365473) {
                qVar.c(d2);
                return a(qVar, d2 + p2);
            }
            qVar.c(d2 + p2);
        }
        return null;
    }

    private static Metadata a(q qVar, int i2) {
        qVar.d(12);
        while (qVar.d() < i2) {
            int d2 = qVar.d();
            int p2 = qVar.p();
            if (qVar.p() == 1768715124) {
                qVar.c(d2);
                return b(qVar, d2 + p2);
            }
            qVar.c(d2 + p2);
        }
        return null;
    }

    private static void a(q qVar, int i2, int i3, int i4, int i5, int i6, DrmInitData drmInitData, c cVar, int i7) throws ParserException {
        q qVar2 = qVar;
        int i8 = i3;
        int i9 = i4;
        DrmInitData drmInitData2 = drmInitData;
        c cVar2 = cVar;
        qVar2.c(i8 + 8 + 8);
        qVar2.d(16);
        int i10 = qVar.i();
        int i11 = qVar.i();
        qVar2.d(50);
        int d2 = qVar.d();
        int i12 = i2;
        if (i12 == 1701733238) {
            Pair<Integer, k> c2 = c(qVar2, i8, i9);
            if (c2 != null) {
                i12 = ((Integer) c2.first).intValue();
                drmInitData2 = drmInitData2 == null ? null : drmInitData2.a(((k) c2.second).f15637b);
                cVar2.f15530a[i7] = (k) c2.second;
            }
            qVar2.c(d2);
        }
        DrmInitData drmInitData3 = drmInitData2;
        String str = null;
        String str2 = null;
        List<byte[]> list = null;
        byte[] bArr = null;
        boolean z2 = false;
        float f2 = 1.0f;
        int i13 = -1;
        while (d2 - i8 < i9) {
            qVar2.c(d2);
            int d3 = qVar.d();
            int p2 = qVar.p();
            if (p2 == 0 && qVar.d() - i8 == i9) {
                break;
            }
            com.google.android.exoplayer2.util.a.a(p2 > 0, (Object) "childAtomSize should be positive");
            int p3 = qVar.p();
            if (p3 == 1635148611) {
                com.google.android.exoplayer2.util.a.b(str == null);
                qVar2.c(d3 + 8);
                com.google.android.exoplayer2.video.a a2 = com.google.android.exoplayer2.video.a.a(qVar);
                list = a2.f17212a;
                cVar2.f15532c = a2.f17213b;
                if (!z2) {
                    f2 = a2.f17216e;
                }
                str = "video/avc";
            } else if (p3 == 1752589123) {
                com.google.android.exoplayer2.util.a.b(str == null);
                qVar2.c(d3 + 8);
                com.google.android.exoplayer2.video.c a3 = com.google.android.exoplayer2.video.c.a(qVar);
                list = a3.f17220a;
                cVar2.f15532c = a3.f17221b;
                str = "video/hevc";
            } else if (p3 == 1685480259 || p3 == 1685485123) {
                com.google.android.exoplayer2.video.b a4 = com.google.android.exoplayer2.video.b.a(qVar);
                if (a4 != null) {
                    str2 = a4.f17219c;
                    str = "video/dolby-vision";
                }
            } else if (p3 == 1987076931) {
                com.google.android.exoplayer2.util.a.b(str == null);
                str = i12 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
            } else if (p3 == 1635135811) {
                com.google.android.exoplayer2.util.a.b(str == null);
                str = "video/av01";
            } else if (p3 == 1681012275) {
                com.google.android.exoplayer2.util.a.b(str == null);
                str = "video/3gpp";
            } else if (p3 == 1702061171) {
                com.google.android.exoplayer2.util.a.b(str == null);
                Pair<String, byte[]> d4 = d(qVar2, d3);
                str = (String) d4.first;
                list = Collections.singletonList((byte[]) d4.second);
            } else if (p3 == 1885434736) {
                f2 = c(qVar2, d3);
                z2 = true;
            } else if (p3 == 1937126244) {
                bArr = d(qVar2, d3, p2);
            } else if (p3 == 1936995172) {
                int h2 = qVar.h();
                qVar2.d(3);
                if (h2 == 0) {
                    int h3 = qVar.h();
                    if (h3 == 0) {
                        i13 = 0;
                    } else if (h3 == 1) {
                        i13 = 1;
                    } else if (h3 == 2) {
                        i13 = 2;
                    } else if (h3 == 3) {
                        i13 = 3;
                    }
                }
            }
            d2 += p2;
            i8 = i3;
        }
        if (str != null) {
            cVar2.f15531b = Format.a(Integer.toString(i5), str, str2, -1, -1, i10, i11, -1.0f, list, i6, f2, bArr, i13, (ColorInfo) null, drmInitData3);
        }
    }

    private static void a(q qVar, int i2, int i3, int i4, int i5, String str, c cVar) throws ParserException {
        q qVar2 = qVar;
        int i6 = i2;
        c cVar2 = cVar;
        qVar2.c(i3 + 8 + 8);
        String str2 = "application/ttml+xml";
        List list = null;
        long j2 = Long.MAX_VALUE;
        if (i6 != 1414810956) {
            if (i6 == 1954034535) {
                int i7 = (i4 - 8) - 8;
                byte[] bArr = new byte[i7];
                qVar2.a(bArr, 0, i7);
                list = Collections.singletonList(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i6 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i6 == 1937010800) {
                j2 = 0;
            } else if (i6 == 1664495672) {
                cVar2.f15533d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar2.f15531b = Format.a(Integer.toString(i5), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j2, (List<byte[]>) list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02b9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:138:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(com.google.android.exoplayer2.util.q r28, int r29, int r30, int r31, int r32, java.lang.String r33, boolean r34, com.google.android.exoplayer2.drm.DrmInitData r35, com.google.android.exoplayer2.extractor.mp4.b.c r36, int r37) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            r14 = r33
            r3 = r35
            r15 = r36
            int r4 = r1 + 8
            r5 = 8
            int r4 = r4 + r5
            r0.c(r4)
            r4 = 6
            r13 = 0
            if (r34 == 0) goto L_0x0020
            int r5 = r28.i()
            r0.d(r4)
            goto L_0x0024
        L_0x0020:
            r0.d(r5)
            r5 = 0
        L_0x0024:
            r6 = 16
            r12 = 2
            r11 = 1
            if (r5 == 0) goto L_0x0046
            if (r5 != r11) goto L_0x002d
            goto L_0x0046
        L_0x002d:
            if (r5 != r12) goto L_0x0045
            r0.d(r6)
            double r4 = r28.z()
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r28.v()
            r6 = 20
            r0.d(r6)
            goto L_0x0058
        L_0x0045:
            return
        L_0x0046:
            int r7 = r28.i()
            r0.d(r4)
            int r4 = r28.t()
            if (r5 != r11) goto L_0x0056
            r0.d(r6)
        L_0x0056:
            r5 = r4
            r4 = r7
        L_0x0058:
            int r6 = r28.d()
            r7 = 1701733217(0x656e6361, float:7.0359778E22)
            r16 = 0
            r8 = r29
            if (r8 != r7) goto L_0x008d
            android.util.Pair r7 = c(r0, r1, r2)
            if (r7 == 0) goto L_0x008a
            java.lang.Object r8 = r7.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x0078
            r3 = r16
            goto L_0x0082
        L_0x0078:
            java.lang.Object r9 = r7.second
            com.google.android.exoplayer2.extractor.mp4.k r9 = (com.google.android.exoplayer2.extractor.mp4.k) r9
            java.lang.String r9 = r9.f15637b
            com.google.android.exoplayer2.drm.DrmInitData r3 = r3.a((java.lang.String) r9)
        L_0x0082:
            com.google.android.exoplayer2.extractor.mp4.k[] r9 = r15.f15530a
            java.lang.Object r7 = r7.second
            com.google.android.exoplayer2.extractor.mp4.k r7 = (com.google.android.exoplayer2.extractor.mp4.k) r7
            r9[r37] = r7
        L_0x008a:
            r0.c(r6)
        L_0x008d:
            r10 = r3
            r3 = 1633889587(0x61632d33, float:2.6191674E20)
            r9 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r7 = "audio/raw"
            r12 = -1
            if (r8 != r3) goto L_0x009f
            java.lang.String r7 = "audio/ac3"
        L_0x009b:
            r18 = -1
            goto L_0x0129
        L_0x009f:
            r3 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r8 != r3) goto L_0x00a7
            java.lang.String r7 = "audio/eac3"
            goto L_0x009b
        L_0x00a7:
            r3 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r8 != r3) goto L_0x00af
            java.lang.String r7 = "audio/ac4"
            goto L_0x009b
        L_0x00af:
            r3 = 1685353315(0x64747363, float:1.803728E22)
            if (r8 != r3) goto L_0x00b7
            java.lang.String r7 = "audio/vnd.dts"
            goto L_0x009b
        L_0x00b7:
            r3 = 1685353320(0x64747368, float:1.8037286E22)
            if (r8 == r3) goto L_0x0125
            r3 = 1685353324(0x6474736c, float:1.803729E22)
            if (r8 != r3) goto L_0x00c3
            goto L_0x0125
        L_0x00c3:
            r3 = 1685353317(0x64747365, float:1.8037282E22)
            if (r8 != r3) goto L_0x00cb
            java.lang.String r7 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x009b
        L_0x00cb:
            r3 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r8 != r3) goto L_0x00d3
            java.lang.String r7 = "audio/3gpp"
            goto L_0x009b
        L_0x00d3:
            r3 = 1935767394(0x73617762, float:1.7863284E31)
            if (r8 != r3) goto L_0x00db
            java.lang.String r7 = "audio/amr-wb"
            goto L_0x009b
        L_0x00db:
            r3 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r8 == r3) goto L_0x0122
            r3 = 1936684916(0x736f7774, float:1.89725E31)
            if (r8 != r3) goto L_0x00e6
            goto L_0x0122
        L_0x00e6:
            r3 = 1953984371(0x74776f73, float:7.841539E31)
            if (r8 != r3) goto L_0x00f0
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r18 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0129
        L_0x00f0:
            r3 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r8 != r3) goto L_0x00f8
            java.lang.String r7 = "audio/mpeg"
            goto L_0x009b
        L_0x00f8:
            if (r8 != r9) goto L_0x00fd
            java.lang.String r7 = "audio/alac"
            goto L_0x009b
        L_0x00fd:
            r3 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r8 != r3) goto L_0x0105
            java.lang.String r7 = "audio/g711-alaw"
            goto L_0x009b
        L_0x0105:
            r3 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r8 != r3) goto L_0x010d
            java.lang.String r7 = "audio/g711-mlaw"
            goto L_0x009b
        L_0x010d:
            r3 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r8 != r3) goto L_0x0115
            java.lang.String r7 = "audio/opus"
            goto L_0x009b
        L_0x0115:
            r3 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r8 != r3) goto L_0x011e
            java.lang.String r7 = "audio/flac"
            goto L_0x009b
        L_0x011e:
            r7 = r16
            goto L_0x009b
        L_0x0122:
            r18 = 2
            goto L_0x0129
        L_0x0125:
            java.lang.String r7 = "audio/vnd.dts.hd"
            goto L_0x009b
        L_0x0129:
            r20 = r4
            r21 = r5
            r8 = r6
            r19 = r7
            r22 = r16
        L_0x0132:
            int r3 = r8 - r1
            if (r3 >= r2) goto L_0x02b3
            r0.c(r8)
            int r7 = r28.p()
            if (r7 <= 0) goto L_0x0141
            r3 = 1
            goto L_0x0142
        L_0x0141:
            r3 = 0
        L_0x0142:
            java.lang.String r4 = "childAtomSize should be positive"
            com.google.android.exoplayer2.util.a.a((boolean) r3, (java.lang.Object) r4)
            int r3 = r28.p()
            r4 = 1702061171(0x65736473, float:7.183675E22)
            if (r3 == r4) goto L_0x0262
            if (r34 == 0) goto L_0x0159
            r5 = 2002876005(0x77617665, float:4.5729223E33)
            if (r3 != r5) goto L_0x0159
            goto L_0x0262
        L_0x0159:
            r4 = 1684103987(0x64616333, float:1.6630662E22)
            if (r3 != r4) goto L_0x017b
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.audio.a.a(r0, r3, r14, r10)
        L_0x016b:
            r15.f15531b = r3
            r5 = r7
            r6 = r8
            r23 = r10
            r1 = 0
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r17 = 2
            r24 = 1
            goto L_0x0260
        L_0x017b:
            r4 = 1684366131(0x64656333, float:1.692581E22)
            if (r3 != r4) goto L_0x018e
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.audio.a.b(r0, r3, r14, r10)
            goto L_0x016b
        L_0x018e:
            r4 = 1684103988(0x64616334, float:1.6630663E22)
            if (r3 != r4) goto L_0x01a1
            int r3 = r8 + 8
            r0.c(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.audio.b.a(r0, r3, r14, r10)
            goto L_0x016b
        L_0x01a1:
            r4 = 1684305011(0x64647473, float:1.6856995E22)
            if (r3 != r4) goto L_0x01dc
            java.lang.String r3 = java.lang.Integer.toString(r32)
            r5 = 0
            r6 = -1
            r23 = -1
            r24 = 0
            r25 = 0
            r4 = r19
            r26 = r7
            r7 = r23
            r27 = r8
            r8 = r20
            r9 = r21
            r23 = r10
            r10 = r24
            r24 = 1
            r11 = r23
            r17 = 2
            r12 = r25
            r1 = 0
            r13 = r33
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6, (int) r7, (int) r8, (int) r9, (java.util.List<byte[]>) r10, (com.google.android.exoplayer2.drm.DrmInitData) r11, (int) r12, (java.lang.String) r13)
            r15.f15531b = r3
            r5 = r26
            r6 = r27
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x0260
        L_0x01dc:
            r26 = r7
            r27 = r8
            r23 = r10
            r1 = 0
            r17 = 2
            r24 = 1
            r4 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r3 != r4) goto L_0x020d
            r5 = r26
            int r7 = r5 + -8
            byte[] r3 = f15520a
            int r4 = r3.length
            int r4 = r4 + r7
            byte[] r4 = new byte[r4]
            int r6 = r3.length
            java.lang.System.arraycopy(r3, r1, r4, r1, r6)
            r6 = r27
            int r8 = r6 + 8
            r0.c(r8)
            int r3 = r3.length
            r0.a(r4, r3, r7)
            r22 = r4
        L_0x0207:
            r3 = -1
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x02a5
        L_0x020d:
            r5 = r26
            r6 = r27
            r4 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r3 != r4) goto L_0x0239
            int r7 = r5 + -12
            int r3 = r7 + 4
            byte[] r3 = new byte[r3]
            r4 = 102(0x66, float:1.43E-43)
            r3[r1] = r4
            r4 = 76
            r3[r24] = r4
            r4 = 97
            r3[r17] = r4
            r4 = 3
            r8 = 67
            r3[r4] = r8
            int r8 = r6 + 12
            r0.c(r8)
            r4 = 4
            r0.a(r3, r4, r7)
            r22 = r3
            goto L_0x0207
        L_0x0239:
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r3 != r7) goto L_0x0260
            int r3 = r5 + -12
            byte[] r4 = new byte[r3]
            int r8 = r6 + 12
            r0.c(r8)
            r0.a(r4, r1, r3)
            android.util.Pair r3 = com.google.android.exoplayer2.util.c.b((byte[]) r4)
            java.lang.Object r8 = r3.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r21 = r8.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r20 = r3.intValue()
            r22 = r4
        L_0x0260:
            r3 = -1
            goto L_0x02a5
        L_0x0262:
            r5 = r7
            r6 = r8
            r23 = r10
            r1 = 0
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r17 = 2
            r24 = 1
            if (r3 != r4) goto L_0x0272
            r8 = r6
            goto L_0x0276
        L_0x0272:
            int r8 = b(r0, r6, r5)
        L_0x0276:
            r3 = -1
            if (r8 == r3) goto L_0x02a5
            android.util.Pair r4 = d(r0, r8)
            java.lang.Object r8 = r4.first
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r4 = r4.second
            r22 = r4
            byte[] r22 = (byte[]) r22
            java.lang.String r4 = "audio/mp4a-latm"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x02a3
            android.util.Pair r4 = com.google.android.exoplayer2.util.c.a((byte[]) r22)
            java.lang.Object r9 = r4.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r21 = r9.intValue()
            java.lang.Object r4 = r4.second
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r20 = r4.intValue()
        L_0x02a3:
            r19 = r8
        L_0x02a5:
            int r8 = r6 + r5
            r1 = r30
            r10 = r23
            r9 = 1634492771(0x616c6163, float:2.7252807E20)
            r11 = 1
            r12 = -1
            r13 = 0
            goto L_0x0132
        L_0x02b3:
            r23 = r10
            com.google.android.exoplayer2.Format r0 = r15.f15531b
            if (r0 != 0) goto L_0x02df
            if (r19 == 0) goto L_0x02df
            java.lang.String r0 = java.lang.Integer.toString(r32)
            r2 = 0
            r3 = -1
            r4 = -1
            if (r22 != 0) goto L_0x02c7
            r8 = r16
            goto L_0x02cc
        L_0x02c7:
            java.util.List r1 = java.util.Collections.singletonList(r22)
            r8 = r1
        L_0x02cc:
            r10 = 0
            r1 = r19
            r5 = r20
            r6 = r21
            r7 = r18
            r9 = r23
            r11 = r33
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (java.util.List<byte[]>) r8, (com.google.android.exoplayer2.drm.DrmInitData) r9, (int) r10, (java.lang.String) r11)
            r15.f15531b = r0
        L_0x02df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.b.a(com.google.android.exoplayer2.util.q, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.b$c, int):void");
    }

    private static boolean a(long[] jArr, long j2, long j3, long j4) {
        int length = jArr.length - 1;
        return jArr[0] <= j3 && j3 < jArr[ad.a(4, 0, length)] && jArr[ad.a(jArr.length - 4, 0, length)] < j4 && j4 <= j2;
    }

    private static int b(q qVar, int i2, int i3) {
        int d2 = qVar.d();
        while (d2 - i2 < i3) {
            qVar.c(d2);
            int p2 = qVar.p();
            com.google.android.exoplayer2.util.a.a(p2 > 0, (Object) "childAtomSize should be positive");
            if (qVar.p() == 1702061171) {
                return d2;
            }
            d2 += p2;
        }
        return -1;
    }

    private static Pair<long[], long[]> b(a.C0110a aVar) {
        a.b d2;
        if (aVar == null || (d2 = aVar.d(1701606260)) == null) {
            return Pair.create((Object) null, (Object) null);
        }
        q qVar = d2.f15519b;
        qVar.c(8);
        int a2 = a.a(qVar.p());
        int v2 = qVar.v();
        long[] jArr = new long[v2];
        long[] jArr2 = new long[v2];
        int i2 = 0;
        while (i2 < v2) {
            jArr[i2] = a2 == 1 ? qVar.x() : qVar.n();
            jArr2[i2] = a2 == 1 ? qVar.r() : (long) qVar.p();
            if (qVar.k() == 1) {
                qVar.d(2);
                i2++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static f b(q qVar) {
        boolean z2;
        int i2 = 8;
        qVar.c(8);
        int a2 = a.a(qVar.p());
        qVar.d(a2 == 0 ? 8 : 16);
        int p2 = qVar.p();
        qVar.d(4);
        int d2 = qVar.d();
        if (a2 == 0) {
            i2 = 4;
        }
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z2 = true;
                break;
            } else if (qVar.f17159a[d2 + i4] != -1) {
                z2 = false;
                break;
            } else {
                i4++;
            }
        }
        long j2 = -9223372036854775807L;
        if (z2) {
            qVar.d(i2);
        } else {
            long n2 = a2 == 0 ? qVar.n() : qVar.x();
            if (n2 != 0) {
                j2 = n2;
            }
        }
        qVar.d(16);
        int p3 = qVar.p();
        int p4 = qVar.p();
        qVar.d(4);
        int p5 = qVar.p();
        int p6 = qVar.p();
        if (p3 == 0 && p4 == 65536 && p5 == -65536 && p6 == 0) {
            i3 = 90;
        } else if (p3 == 0 && p4 == -65536 && p5 == 65536 && p6 == 0) {
            i3 = SubsamplingScaleImageView.ORIENTATION_270;
        } else if (p3 == -65536 && p4 == 0 && p5 == 0 && p6 == -65536) {
            i3 = 180;
        }
        return new f(p2, j2, i3);
    }

    private static Metadata b(q qVar, int i2) {
        qVar.d(8);
        ArrayList arrayList = new ArrayList();
        while (qVar.d() < i2) {
            Metadata.Entry a2 = f.a(qVar);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static float c(q qVar, int i2) {
        qVar.c(i2 + 8);
        return ((float) qVar.v()) / ((float) qVar.v());
    }

    private static int c(q qVar) {
        qVar.c(16);
        return qVar.p();
    }

    private static Pair<Integer, k> c(q qVar, int i2, int i3) {
        Pair<Integer, k> a2;
        int d2 = qVar.d();
        while (d2 - i2 < i3) {
            qVar.c(d2);
            int p2 = qVar.p();
            com.google.android.exoplayer2.util.a.a(p2 > 0, (Object) "childAtomSize should be positive");
            if (qVar.p() == 1936289382 && (a2 = a(qVar, d2, p2)) != null) {
                return a2;
            }
            d2 += p2;
        }
        return null;
    }

    private static Pair<Long, String> d(q qVar) {
        int i2 = 8;
        qVar.c(8);
        int a2 = a.a(qVar.p());
        qVar.d(a2 == 0 ? 8 : 16);
        long n2 = qVar.n();
        if (a2 == 0) {
            i2 = 4;
        }
        qVar.d(i2);
        int i3 = qVar.i();
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) (((i3 >> 10) & 31) + 96));
        sb.append((char) (((i3 >> 5) & 31) + 96));
        sb.append((char) ((i3 & 31) + 96));
        return Pair.create(Long.valueOf(n2), sb.toString());
    }

    private static Pair<String, byte[]> d(q qVar, int i2) {
        qVar.c(i2 + 8 + 4);
        qVar.d(1);
        e(qVar);
        qVar.d(2);
        int h2 = qVar.h();
        if ((h2 & 128) != 0) {
            qVar.d(2);
        }
        if ((h2 & 64) != 0) {
            qVar.d(qVar.i());
        }
        if ((h2 & 32) != 0) {
            qVar.d(2);
        }
        qVar.d(1);
        e(qVar);
        String a2 = n.a(qVar.h());
        if ("audio/mpeg".equals(a2) || "audio/vnd.dts".equals(a2) || "audio/vnd.dts.hd".equals(a2)) {
            return Pair.create(a2, (Object) null);
        }
        qVar.d(12);
        qVar.d(1);
        int e2 = e(qVar);
        byte[] bArr = new byte[e2];
        qVar.a(bArr, 0, e2);
        return Pair.create(a2, bArr);
    }

    private static byte[] d(q qVar, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            qVar.c(i4);
            int p2 = qVar.p();
            if (qVar.p() == 1886547818) {
                return Arrays.copyOfRange(qVar.f17159a, i4, p2 + i4);
            }
            i4 += p2;
        }
        return null;
    }

    private static int e(q qVar) {
        int h2 = qVar.h();
        int i2 = h2 & 127;
        while ((h2 & 128) == 128) {
            h2 = qVar.h();
            i2 = (i2 << 7) | (h2 & 127);
        }
        return i2;
    }
}
