package fr;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.u;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f13104a = $$Lambda$a$aql97i_d82wSHmD1TwUss_SavT8.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private i f13105b;

    /* renamed from: c  reason: collision with root package name */
    private u f13106c;

    /* renamed from: d  reason: collision with root package name */
    private b f13107d;

    /* renamed from: e  reason: collision with root package name */
    private int f13108e = -1;

    /* renamed from: f  reason: collision with root package name */
    private long f13109f = -1;

    /* renamed from: fr.a$a  reason: collision with other inner class name */
    private static final class C0176a implements b {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f27995a = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* renamed from: b  reason: collision with root package name */
        private static final int[] f27996b = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* renamed from: c  reason: collision with root package name */
        private final i f27997c;

        /* renamed from: d  reason: collision with root package name */
        private final u f27998d;

        /* renamed from: e  reason: collision with root package name */
        private final b f27999e;

        /* renamed from: f  reason: collision with root package name */
        private final int f28000f;

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f28001g;

        /* renamed from: h  reason: collision with root package name */
        private final q f28002h;

        /* renamed from: i  reason: collision with root package name */
        private final int f28003i;

        /* renamed from: j  reason: collision with root package name */
        private final Format f28004j;

        /* renamed from: k  reason: collision with root package name */
        private int f28005k;

        /* renamed from: l  reason: collision with root package name */
        private long f28006l;

        /* renamed from: m  reason: collision with root package name */
        private int f28007m;

        /* renamed from: n  reason: collision with root package name */
        private long f28008n;

        public C0176a(i iVar, u uVar, b bVar) throws ParserException {
            b bVar2 = bVar;
            this.f27997c = iVar;
            this.f27998d = uVar;
            this.f27999e = bVar2;
            int max = Math.max(1, bVar2.f28019c / 10);
            this.f28003i = max;
            q qVar = new q(bVar2.f28023g);
            qVar.j();
            int j2 = qVar.j();
            this.f28000f = j2;
            int i2 = bVar2.f28018b;
            int i3 = (((bVar2.f28021e - (i2 * 4)) * 8) / (bVar2.f28022f * i2)) + 1;
            if (j2 == i3) {
                int a2 = ad.a(max, j2);
                this.f28001g = new byte[(bVar2.f28021e * a2)];
                this.f28002h = new q(a2 * a(j2, i2));
                this.f28004j = Format.a((String) null, "audio/raw", (String) null, ((bVar2.f28019c * bVar2.f28021e) * 8) / j2, a(max, i2), bVar2.f28018b, bVar2.f28019c, 2, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
                return;
            }
            StringBuilder sb = new StringBuilder(56);
            sb.append("Expected frames per block: ");
            sb.append(i3);
            sb.append("; got: ");
            sb.append(j2);
            throw new ParserException(sb.toString());
        }

        private static int a(int i2, int i3) {
            return i2 * 2 * i3;
        }

        private void a(int i2) {
            long d2 = this.f28006l + ad.d(this.f28008n, 1000000, (long) this.f27999e.f28019c);
            int c2 = c(i2);
            this.f27998d.a(d2, 1, c2, this.f28007m - c2, (u.a) null);
            this.f28008n += (long) i2;
            this.f28007m -= c2;
        }

        private void a(byte[] bArr, int i2, int i3, byte[] bArr2) {
            int i4 = this.f27999e.f28021e;
            int i5 = this.f27999e.f28018b;
            int i6 = (i2 * i4) + (i3 * 4);
            int i7 = (i5 * 4) + i6;
            int i8 = (i4 / i5) - 4;
            int i9 = (short) (((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255));
            int min = Math.min(bArr[i6 + 2] & 255, 88);
            int i10 = f27996b[min];
            int i11 = ((i2 * this.f28000f * i5) + i3) * 2;
            bArr2[i11] = (byte) (i9 & 255);
            bArr2[i11 + 1] = (byte) (i9 >> 8);
            for (int i12 = 0; i12 < i8 * 2; i12++) {
                byte b2 = bArr[((i12 / 8) * i5 * 4) + i7 + ((i12 / 2) % 4)] & 255;
                int i13 = i12 % 2 == 0 ? b2 & 15 : b2 >> 4;
                int i14 = ((((i13 & 7) * 2) + 1) * i10) >> 3;
                if ((i13 & 8) != 0) {
                    i14 = -i14;
                }
                i9 = ad.a(i9 + i14, -32768, 32767);
                i11 += i5 * 2;
                bArr2[i11] = (byte) (i9 & 255);
                bArr2[i11 + 1] = (byte) (i9 >> 8);
                int i15 = min + f27995a[i13];
                int[] iArr = f27996b;
                min = ad.a(i15, 0, iArr.length - 1);
                i10 = iArr[min];
            }
        }

        private void a(byte[] bArr, int i2, q qVar) {
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < this.f27999e.f28018b; i4++) {
                    a(bArr, i3, i4, qVar.f17159a);
                }
            }
            qVar.a(c(this.f28000f * i2));
        }

        private int b(int i2) {
            return i2 / (this.f27999e.f28018b * 2);
        }

        private int c(int i2) {
            return a(i2, this.f27999e.f28018b);
        }

        public void a(int i2, long j2) {
            this.f27997c.a(new d(this.f27999e, this.f28000f, (long) i2, j2));
            this.f27998d.a(this.f28004j);
        }

        public void a(long j2) {
            this.f28005k = 0;
            this.f28006l = j2;
            this.f28007m = 0;
            this.f28008n = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[EDGE_INSN: B:22:0x003f->B:10:0x003f ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(fj.h r7, long r8) throws java.io.IOException, java.lang.InterruptedException {
            /*
                r6 = this;
                int r0 = r6.f28003i
                int r1 = r6.f28007m
                int r1 = r6.b(r1)
                int r0 = r0 - r1
                int r1 = r6.f28000f
                int r0 = com.google.android.exoplayer2.util.ad.a((int) r0, (int) r1)
                fr.b r1 = r6.f27999e
                int r1 = r1.f28021e
                int r0 = r0 * r1
                r1 = 1
                r2 = 0
                int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r4 != 0) goto L_0x001e
            L_0x001c:
                r2 = 1
                goto L_0x001f
            L_0x001e:
                r2 = 0
            L_0x001f:
                if (r2 != 0) goto L_0x003f
                int r3 = r6.f28005k
                if (r3 >= r0) goto L_0x003f
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r4 = (int) r3
                byte[] r3 = r6.f28001g
                int r5 = r6.f28005k
                int r3 = r7.a(r3, r5, r4)
                r4 = -1
                if (r3 != r4) goto L_0x0039
                goto L_0x001c
            L_0x0039:
                int r4 = r6.f28005k
                int r4 = r4 + r3
                r6.f28005k = r4
                goto L_0x001f
            L_0x003f:
                int r7 = r6.f28005k
                fr.b r8 = r6.f27999e
                int r8 = r8.f28021e
                int r7 = r7 / r8
                if (r7 <= 0) goto L_0x0077
                byte[] r8 = r6.f28001g
                com.google.android.exoplayer2.util.q r9 = r6.f28002h
                r6.a(r8, r7, r9)
                int r8 = r6.f28005k
                fr.b r9 = r6.f27999e
                int r9 = r9.f28021e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f28005k = r8
                com.google.android.exoplayer2.util.q r7 = r6.f28002h
                int r7 = r7.c()
                fj.u r8 = r6.f27998d
                com.google.android.exoplayer2.util.q r9 = r6.f28002h
                r8.a(r9, r7)
                int r8 = r6.f28007m
                int r8 = r8 + r7
                r6.f28007m = r8
                int r7 = r6.b(r8)
                int r8 = r6.f28003i
                if (r7 < r8) goto L_0x0077
                r6.a((int) r8)
            L_0x0077:
                if (r2 == 0) goto L_0x0084
                int r7 = r6.f28007m
                int r7 = r6.b(r7)
                if (r7 <= 0) goto L_0x0084
                r6.a((int) r7)
            L_0x0084:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: fr.a.C0176a.a(fj.h, long):boolean");
        }
    }

    private interface b {
        void a(int i2, long j2) throws ParserException;

        void a(long j2);

        boolean a(h hVar, long j2) throws IOException, InterruptedException;
    }

    private static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final i f28009a;

        /* renamed from: b  reason: collision with root package name */
        private final u f28010b;

        /* renamed from: c  reason: collision with root package name */
        private final b f28011c;

        /* renamed from: d  reason: collision with root package name */
        private final Format f28012d;

        /* renamed from: e  reason: collision with root package name */
        private final int f28013e;

        /* renamed from: f  reason: collision with root package name */
        private long f28014f;

        /* renamed from: g  reason: collision with root package name */
        private int f28015g;

        /* renamed from: h  reason: collision with root package name */
        private long f28016h;

        public c(i iVar, u uVar, b bVar, String str, int i2) throws ParserException {
            b bVar2 = bVar;
            this.f28009a = iVar;
            this.f28010b = uVar;
            this.f28011c = bVar2;
            int i3 = (bVar2.f28018b * bVar2.f28022f) / 8;
            if (bVar2.f28021e == i3) {
                int max = Math.max(i3, (bVar2.f28019c * i3) / 10);
                this.f28013e = max;
                this.f28012d = Format.a((String) null, str, (String) null, bVar2.f28019c * i3 * 8, max, bVar2.f28018b, bVar2.f28019c, i2, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
                return;
            }
            int i4 = bVar2.f28021e;
            StringBuilder sb = new StringBuilder(50);
            sb.append("Expected block size: ");
            sb.append(i3);
            sb.append("; got: ");
            sb.append(i4);
            throw new ParserException(sb.toString());
        }

        public void a(int i2, long j2) {
            this.f28009a.a(new d(this.f28011c, 1, (long) i2, j2));
            this.f28010b.a(this.f28012d);
        }

        public void a(long j2) {
            this.f28014f = j2;
            this.f28015g = 0;
            this.f28016h = 0;
        }

        public boolean a(h hVar, long j2) throws IOException, InterruptedException {
            int i2;
            int i3;
            long j3 = j2;
            while (j3 > 0 && (i2 = this.f28015g) < (i3 = this.f28013e)) {
                int a2 = this.f28010b.a(hVar, (int) Math.min((long) (i3 - i2), j3), true);
                if (a2 == -1) {
                    j3 = 0;
                } else {
                    this.f28015g += a2;
                    j3 -= (long) a2;
                }
            }
            int i4 = this.f28011c.f28021e;
            int i5 = this.f28015g / i4;
            if (i5 > 0) {
                int i6 = i5 * i4;
                int i7 = this.f28015g - i6;
                this.f28010b.a(this.f28014f + ad.d(this.f28016h, 1000000, (long) this.f28011c.f28019c), 1, i6, i7, (u.a) null);
                this.f28016h += (long) i5;
                this.f28015g = i7;
            }
            return j3 <= 0;
        }
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void a() {
        com.google.android.exoplayer2.util.a.a(this.f13106c);
        ad.a(this.f13105b);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] b() {
        return new g[]{new a()};
    }

    /* JADX WARNING: type inference failed for: r8v21, types: [fr.a$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(fj.h r7, fj.r r8) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r6 = this;
            r6.a()
            fr.a$b r8 = r6.f13107d
            if (r8 != 0) goto L_0x007f
            fr.b r3 = fr.c.a(r7)
            if (r3 == 0) goto L_0x0077
            int r8 = r3.f28017a
            r0 = 17
            if (r8 != r0) goto L_0x001f
            fr.a$a r8 = new fr.a$a
            fj.i r0 = r6.f13105b
            fj.u r1 = r6.f13106c
            r8.<init>(r0, r1, r3)
        L_0x001c:
            r6.f13107d = r8
            goto L_0x007f
        L_0x001f:
            int r8 = r3.f28017a
            r0 = 6
            if (r8 != r0) goto L_0x0032
            fr.a$c r8 = new fr.a$c
            fj.i r1 = r6.f13105b
            fj.u r2 = r6.f13106c
            r5 = -1
            java.lang.String r4 = "audio/g711-alaw"
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x001c
        L_0x0032:
            int r8 = r3.f28017a
            r0 = 7
            if (r8 != r0) goto L_0x0045
            fr.a$c r8 = new fr.a$c
            fj.i r1 = r6.f13105b
            fj.u r2 = r6.f13106c
            r5 = -1
            java.lang.String r4 = "audio/g711-mlaw"
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x001c
        L_0x0045:
            int r8 = r3.f28017a
            int r0 = r3.f28022f
            int r5 = com.google.android.exoplayer2.audio.t.a(r8, r0)
            if (r5 == 0) goto L_0x005c
            fr.a$c r8 = new fr.a$c
            fj.i r1 = r6.f13105b
            fj.u r2 = r6.f13106c
            java.lang.String r4 = "audio/raw"
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x001c
        L_0x005c:
            com.google.android.exoplayer2.ParserException r7 = new com.google.android.exoplayer2.ParserException
            int r8 = r3.f28017a
            r0 = 40
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unsupported WAV format type: "
            r1.append(r0)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x0077:
            com.google.android.exoplayer2.ParserException r7 = new com.google.android.exoplayer2.ParserException
            java.lang.String r8 = "Unsupported or unrecognized wav header."
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x007f:
            int r8 = r6.f13108e
            r0 = -1
            if (r8 != r0) goto L_0x00a4
            android.util.Pair r8 = fr.c.b(r7)
            java.lang.Object r1 = r8.first
            java.lang.Long r1 = (java.lang.Long) r1
            int r1 = r1.intValue()
            r6.f13108e = r1
            java.lang.Object r8 = r8.second
            java.lang.Long r8 = (java.lang.Long) r8
            long r1 = r8.longValue()
            r6.f13109f = r1
            fr.a$b r8 = r6.f13107d
            int r3 = r6.f13108e
            r8.a((int) r3, (long) r1)
            goto L_0x00b3
        L_0x00a4:
            long r1 = r7.c()
            r3 = 0
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x00b3
            int r8 = r6.f13108e
            r7.b(r8)
        L_0x00b3:
            long r1 = r6.f13109f
            r3 = -1
            r8 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00be
            r1 = 1
            goto L_0x00bf
        L_0x00be:
            r1 = 0
        L_0x00bf:
            com.google.android.exoplayer2.util.a.b((boolean) r1)
            long r1 = r6.f13109f
            long r3 = r7.c()
            long r1 = r1 - r3
            fr.a$b r3 = r6.f13107d
            boolean r7 = r3.a((fj.h) r7, (long) r1)
            if (r7 == 0) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r0 = 0
        L_0x00d3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.a.a(fj.h, fj.r):int");
    }

    public void a(long j2, long j3) {
        b bVar = this.f13107d;
        if (bVar != null) {
            bVar.a(j3);
        }
    }

    public void a(i iVar) {
        this.f13105b = iVar;
        this.f13106c = iVar.a(0, 1);
        iVar.a();
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        return c.a(hVar) != null;
    }

    public void c() {
    }
}
