package fq;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;
import java.util.Arrays;

public final class k implements j {

    /* renamed from: c  reason: collision with root package name */
    private static final double[] f27798c = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f27799a;

    /* renamed from: b  reason: collision with root package name */
    private u f27800b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27801d;

    /* renamed from: e  reason: collision with root package name */
    private long f27802e;

    /* renamed from: f  reason: collision with root package name */
    private final ae f27803f;

    /* renamed from: g  reason: collision with root package name */
    private final q f27804g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f27805h;

    /* renamed from: i  reason: collision with root package name */
    private final a f27806i;

    /* renamed from: j  reason: collision with root package name */
    private final q f27807j;

    /* renamed from: k  reason: collision with root package name */
    private long f27808k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27809l;

    /* renamed from: m  reason: collision with root package name */
    private long f27810m;

    /* renamed from: n  reason: collision with root package name */
    private long f27811n;

    /* renamed from: o  reason: collision with root package name */
    private long f27812o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f27813p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f27814q;

    private static final class a {

        /* renamed from: d  reason: collision with root package name */
        private static final byte[] f27815d = {0, 0, 1};

        /* renamed from: a  reason: collision with root package name */
        public int f27816a;

        /* renamed from: b  reason: collision with root package name */
        public int f27817b;

        /* renamed from: c  reason: collision with root package name */
        public byte[] f27818c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f27819e;

        public a(int i2) {
            this.f27818c = new byte[i2];
        }

        public void a() {
            this.f27819e = false;
            this.f27816a = 0;
            this.f27817b = 0;
        }

        public void a(byte[] bArr, int i2, int i3) {
            if (this.f27819e) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f27818c;
                int length = bArr2.length;
                int i5 = this.f27816a;
                if (length < i5 + i4) {
                    this.f27818c = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f27818c, this.f27816a, i4);
                this.f27816a += i4;
            }
        }

        public boolean a(int i2, int i3) {
            if (this.f27819e) {
                int i4 = this.f27816a - i3;
                this.f27816a = i4;
                if (this.f27817b == 0 && i2 == 181) {
                    this.f27817b = i4;
                } else {
                    this.f27819e = false;
                    return true;
                }
            } else if (i2 == 179) {
                this.f27819e = true;
            }
            byte[] bArr = f27815d;
            a(bArr, 0, bArr.length);
            return false;
        }
    }

    public k() {
        this((ae) null);
    }

    k(ae aeVar) {
        q qVar;
        this.f27803f = aeVar;
        this.f27805h = new boolean[4];
        this.f27806i = new a(128);
        if (aeVar != null) {
            this.f27807j = new q(178, 128);
            qVar = new q();
        } else {
            qVar = null;
            this.f27807j = null;
        }
        this.f27804g = qVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.google.android.exoplayer2.Format, java.lang.Long> a(fq.k.a r20, java.lang.String r21) {
        /*
            r0 = r20
            byte[] r1 = r0.f27818c
            int r2 = r0.f27816a
            byte[] r1 = java.util.Arrays.copyOf(r1, r2)
            r2 = 4
            byte r3 = r1[r2]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 5
            byte r5 = r1[r4]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = 6
            byte r6 = r1[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r3 = r3 << r2
            int r7 = r5 >> 4
            r13 = r3 | r7
            r3 = r5 & 15
            int r3 = r3 << 8
            r14 = r3 | r6
            r3 = 7
            byte r5 = r1[r3]
            r5 = r5 & 240(0xf0, float:3.36E-43)
            int r5 = r5 >> r2
            r6 = 2
            if (r5 == r6) goto L_0x0043
            r6 = 3
            if (r5 == r6) goto L_0x003d
            if (r5 == r2) goto L_0x0037
            r2 = 1065353216(0x3f800000, float:1.0)
            r18 = 1065353216(0x3f800000, float:1.0)
            goto L_0x004c
        L_0x0037:
            int r2 = r14 * 121
            float r2 = (float) r2
            int r5 = r13 * 100
            goto L_0x0048
        L_0x003d:
            int r2 = r14 * 16
            float r2 = (float) r2
            int r5 = r13 * 9
            goto L_0x0048
        L_0x0043:
            int r2 = r14 * 4
            float r2 = (float) r2
            int r5 = r13 * 3
        L_0x0048:
            float r5 = (float) r5
            float r2 = r2 / r5
            r18 = r2
        L_0x004c:
            r10 = 0
            r11 = -1
            r12 = -1
            r15 = -1082130432(0xffffffffbf800000, float:-1.0)
            java.util.List r16 = java.util.Collections.singletonList(r1)
            r17 = -1
            r19 = 0
            java.lang.String r9 = "video/mpeg2"
            r8 = r21
            com.google.android.exoplayer2.Format r2 = com.google.android.exoplayer2.Format.a((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (int) r11, (int) r12, (int) r13, (int) r14, (float) r15, (java.util.List<byte[]>) r16, (int) r17, (float) r18, (com.google.android.exoplayer2.drm.DrmInitData) r19)
            r5 = 0
            byte r3 = r1[r3]
            r3 = r3 & 15
            int r3 = r3 + -1
            if (r3 < 0) goto L_0x0098
            double[] r7 = f27798c
            int r8 = r7.length
            if (r3 >= r8) goto L_0x0098
            r5 = r7[r3]
            int r0 = r0.f27817b
            int r0 = r0 + 9
            byte r3 = r1[r0]
            r3 = r3 & 96
            int r3 = r3 >> r4
            byte r0 = r1[r0]
            r0 = r0 & 31
            if (r3 == r0) goto L_0x0091
            double r3 = (double) r3
            r7 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r3)
            double r3 = r3 + r7
            int r0 = r0 + 1
            double r0 = (double) r0
            java.lang.Double.isNaN(r0)
            double r3 = r3 / r0
            double r5 = r5 * r3
        L_0x0091:
            r0 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r0 = r0 / r5
            long r5 = (long) r0
        L_0x0098:
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            android.util.Pair r0 = android.util.Pair.create(r2, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fq.k.a(fq.k$a, java.lang.String):android.util.Pair");
    }

    public void a() {
        o.a(this.f27805h);
        this.f27806i.a();
        if (this.f27803f != null) {
            this.f27807j.a();
        }
        this.f27808k = 0;
        this.f27809l = false;
    }

    public void a(long j2, int i2) {
        this.f27810m = j2;
    }

    public void a(q qVar) {
        int i2;
        q qVar2 = qVar;
        int d2 = qVar.d();
        int c2 = qVar.c();
        byte[] bArr = qVar2.f17159a;
        this.f27808k += (long) qVar.b();
        this.f27800b.a(qVar2, qVar.b());
        while (true) {
            int a2 = o.a(bArr, d2, c2, this.f27805h);
            if (a2 == c2) {
                break;
            }
            int i3 = a2 + 3;
            byte b2 = qVar2.f17159a[i3] & 255;
            int i4 = a2 - d2;
            boolean z2 = false;
            if (!this.f27801d) {
                if (i4 > 0) {
                    this.f27806i.a(bArr, d2, a2);
                }
                if (this.f27806i.a(b2, i4 < 0 ? -i4 : 0)) {
                    Pair<Format, Long> a3 = a(this.f27806i, this.f27799a);
                    this.f27800b.a((Format) a3.first);
                    this.f27802e = ((Long) a3.second).longValue();
                    this.f27801d = true;
                }
            }
            if (this.f27803f != null) {
                if (i4 > 0) {
                    this.f27807j.a(bArr, d2, a2);
                    i2 = 0;
                } else {
                    i2 = -i4;
                }
                if (this.f27807j.b(i2)) {
                    this.f27804g.a(this.f27807j.f27934a, o.a(this.f27807j.f27934a, this.f27807j.f27935b));
                    this.f27803f.a(this.f27812o, this.f27804g);
                }
                if (b2 == 178 && qVar2.f17159a[a2 + 2] == 1) {
                    this.f27807j.a(b2);
                }
            }
            if (b2 == 0 || b2 == 179) {
                int i5 = c2 - a2;
                if (this.f27809l && this.f27814q && this.f27801d) {
                    this.f27800b.a(this.f27812o, this.f27813p ? 1 : 0, ((int) (this.f27808k - this.f27811n)) - i5, i5, (u.a) null);
                }
                boolean z3 = this.f27809l;
                if (!z3 || this.f27814q) {
                    this.f27811n = this.f27808k - ((long) i5);
                    long j2 = this.f27810m;
                    if (j2 == -9223372036854775807L) {
                        j2 = z3 ? this.f27812o + this.f27802e : 0;
                    }
                    this.f27812o = j2;
                    this.f27813p = false;
                    this.f27810m = -9223372036854775807L;
                    this.f27809l = true;
                }
                if (b2 == 0) {
                    z2 = true;
                }
                this.f27814q = z2;
            } else if (b2 == 184) {
                this.f27813p = true;
            }
            d2 = i3;
        }
        if (!this.f27801d) {
            this.f27806i.a(bArr, d2, c2);
        }
        if (this.f27803f != null) {
            this.f27807j.a(bArr, d2, c2);
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27799a = dVar.c();
        this.f27800b = iVar.a(dVar.b(), 2);
        ae aeVar = this.f27803f;
        if (aeVar != null) {
            aeVar.a(iVar, dVar);
        }
    }

    public void b() {
    }
}
