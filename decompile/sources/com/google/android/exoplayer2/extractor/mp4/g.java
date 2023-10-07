package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import fj.t;
import fj.u;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public final class g implements fj.g, s {

    /* renamed from: a  reason: collision with root package name */
    public static final k f15595a = $$Lambda$g$g9sdKJycxXS7lJ0AIdKDDY4GNAI.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private final int f15596b;

    /* renamed from: c  reason: collision with root package name */
    private final q f15597c;

    /* renamed from: d  reason: collision with root package name */
    private final q f15598d;

    /* renamed from: e  reason: collision with root package name */
    private final q f15599e;

    /* renamed from: f  reason: collision with root package name */
    private final q f15600f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque<a.C0110a> f15601g;

    /* renamed from: h  reason: collision with root package name */
    private int f15602h;

    /* renamed from: i  reason: collision with root package name */
    private int f15603i;

    /* renamed from: j  reason: collision with root package name */
    private long f15604j;

    /* renamed from: k  reason: collision with root package name */
    private int f15605k;

    /* renamed from: l  reason: collision with root package name */
    private q f15606l;

    /* renamed from: m  reason: collision with root package name */
    private int f15607m;

    /* renamed from: n  reason: collision with root package name */
    private int f15608n;

    /* renamed from: o  reason: collision with root package name */
    private int f15609o;

    /* renamed from: p  reason: collision with root package name */
    private int f15610p;

    /* renamed from: q  reason: collision with root package name */
    private i f15611q;

    /* renamed from: r  reason: collision with root package name */
    private a[] f15612r;

    /* renamed from: s  reason: collision with root package name */
    private long[][] f15613s;

    /* renamed from: t  reason: collision with root package name */
    private int f15614t;

    /* renamed from: u  reason: collision with root package name */
    private long f15615u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f15616v;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j f15617a;

        /* renamed from: b  reason: collision with root package name */
        public final m f15618b;

        /* renamed from: c  reason: collision with root package name */
        public final u f15619c;

        /* renamed from: d  reason: collision with root package name */
        public int f15620d;

        public a(j jVar, m mVar, u uVar) {
            this.f15617a = jVar;
            this.f15618b = mVar;
            this.f15619c = uVar;
        }
    }

    public g() {
        this(0);
    }

    public g(int i2) {
        this.f15596b = i2;
        this.f15600f = new q(16);
        this.f15601g = new ArrayDeque<>();
        this.f15597c = new q(o.f17135a);
        this.f15598d = new q(4);
        this.f15599e = new q();
        this.f15607m = -1;
    }

    private static int a(m mVar, long j2) {
        int a2 = mVar.a(j2);
        return a2 == -1 ? mVar.b(j2) : a2;
    }

    private static long a(m mVar, long j2, long j3) {
        int a2 = a(mVar, j2);
        return a2 == -1 ? j3 : Math.min(mVar.f15662c[a2], j3);
    }

    private ArrayList<m> a(a.C0110a aVar, fj.o oVar, boolean z2) throws ParserException {
        j a2;
        ArrayList<m> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < aVar.f15518d.size(); i2++) {
            a.C0110a aVar2 = aVar.f15518d.get(i2);
            if (aVar2.f15515a == 1953653099 && (a2 = b.a(aVar2, aVar.d(1836476516), -9223372036854775807L, (DrmInitData) null, z2, this.f15616v)) != null) {
                m a3 = b.a(a2, aVar2.e(1835297121).e(1835626086).e(1937007212), oVar);
                if (a3.f15661b != 0) {
                    arrayList.add(a3);
                }
            }
        }
        return arrayList;
    }

    private void a(a.C0110a aVar) throws ParserException {
        Metadata metadata;
        long j2;
        m mVar;
        a.C0110a aVar2 = aVar;
        ArrayList arrayList = new ArrayList();
        fj.o oVar = new fj.o();
        a.b d2 = aVar2.d(1969517665);
        Metadata metadata2 = null;
        if (d2 != null) {
            metadata = b.a(d2, this.f15616v);
            if (metadata != null) {
                oVar.a(metadata);
            }
        } else {
            metadata = null;
        }
        a.C0110a e2 = aVar2.e(1835365473);
        if (e2 != null) {
            metadata2 = b.a(e2);
        }
        ArrayList<m> a2 = a(aVar2, oVar, (this.f15596b & 1) != 0);
        int size = a2.size();
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        int i2 = 0;
        int i3 = -1;
        while (i2 < size) {
            m mVar2 = a2.get(i2);
            j jVar = mVar2.f15660a;
            m mVar3 = mVar2;
            if (jVar.f15629e != j3) {
                j2 = jVar.f15629e;
                mVar = mVar3;
            } else {
                mVar = mVar3;
                j2 = mVar.f15667h;
            }
            long max = Math.max(j4, j2);
            ArrayList<m> arrayList2 = a2;
            int i4 = size;
            a aVar3 = new a(jVar, mVar, this.f15611q.a(i2, jVar.f15626b));
            Format a3 = jVar.f15630f.a(mVar.f15664e + 30);
            long j5 = max;
            if (jVar.f15626b == 2 && j2 > 0) {
                if (mVar.f15661b > 1) {
                    a3 = a3.a(((float) mVar.f15661b) / (((float) j2) / 1000000.0f));
                }
            }
            aVar3.f15619c.a(f.a(jVar.f15626b, a3, metadata, metadata2, oVar));
            if (jVar.f15626b == 2) {
                if (i3 == -1) {
                    i3 = arrayList.size();
                }
            }
            arrayList.add(aVar3);
            i2++;
            a2 = arrayList2;
            size = i4;
            j4 = j5;
            j3 = -9223372036854775807L;
        }
        this.f15614t = i3;
        this.f15615u = j4;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.f15612r = aVarArr;
        this.f15613s = a(aVarArr);
        this.f15611q.a();
        this.f15611q.a(this);
    }

    private static boolean a(int i2) {
        return i2 == 1835296868 || i2 == 1836476516 || i2 == 1751411826 || i2 == 1937011556 || i2 == 1937011827 || i2 == 1937011571 || i2 == 1668576371 || i2 == 1701606260 || i2 == 1937011555 || i2 == 1937011578 || i2 == 1937013298 || i2 == 1937007471 || i2 == 1668232756 || i2 == 1953196132 || i2 == 1718909296 || i2 == 1969517665 || i2 == 1801812339 || i2 == 1768715124;
    }

    private static boolean a(q qVar) {
        qVar.c(8);
        if (qVar.p() == 1903435808) {
            return true;
        }
        qVar.d(4);
        while (qVar.b() > 0) {
            if (qVar.p() == 1903435808) {
                return true;
            }
        }
        return false;
    }

    private static long[][] a(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            jArr[i2] = new long[aVarArr[i2].f15618b.f15661b];
            jArr2[i2] = aVarArr[i2].f15618b.f15665f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < aVarArr.length) {
            long j3 = Long.MAX_VALUE;
            int i4 = -1;
            for (int i5 = 0; i5 < aVarArr.length; i5++) {
                if (!zArr[i5] && jArr2[i5] <= j3) {
                    j3 = jArr2[i5];
                    i4 = i5;
                }
            }
            int i6 = iArr[i4];
            jArr[i4][i6] = j2;
            j2 += (long) aVarArr[i4].f15618b.f15663d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr[i4].length) {
                jArr2[i4] = aVarArr[i4].f15618b.f15665f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private void b(long j2) throws ParserException {
        while (!this.f15601g.isEmpty() && this.f15601g.peek().f15516b == j2) {
            a.C0110a pop = this.f15601g.pop();
            if (pop.f15515a == 1836019574) {
                a(pop);
                this.f15601g.clear();
                this.f15602h = 2;
            } else if (!this.f15601g.isEmpty()) {
                this.f15601g.peek().a(pop);
            }
        }
        if (this.f15602h != 2) {
            d();
        }
    }

    private static boolean b(int i2) {
        return i2 == 1836019574 || i2 == 1953653099 || i2 == 1835297121 || i2 == 1835626086 || i2 == 1937007212 || i2 == 1701082227 || i2 == 1835365473;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(fj.h r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            int r0 = r8.f15605k
            r1 = 1
            r2 = 8
            r3 = 0
            if (r0 != 0) goto L_0x002a
            com.google.android.exoplayer2.util.q r0 = r8.f15600f
            byte[] r0 = r0.f17159a
            boolean r0 = r9.a(r0, r3, r2, r1)
            if (r0 != 0) goto L_0x0013
            return r3
        L_0x0013:
            r8.f15605k = r2
            com.google.android.exoplayer2.util.q r0 = r8.f15600f
            r0.c(r3)
            com.google.android.exoplayer2.util.q r0 = r8.f15600f
            long r4 = r0.n()
            r8.f15604j = r4
            com.google.android.exoplayer2.util.q r0 = r8.f15600f
            int r0 = r0.p()
            r8.f15603i = r0
        L_0x002a:
            long r4 = r8.f15604j
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0047
            com.google.android.exoplayer2.util.q r0 = r8.f15600f
            byte[] r0 = r0.f17159a
            r9.b(r0, r2, r2)
            int r0 = r8.f15605k
            int r0 = r0 + r2
            r8.f15605k = r0
            com.google.android.exoplayer2.util.q r0 = r8.f15600f
            long r4 = r0.x()
        L_0x0044:
            r8.f15604j = r4
            goto L_0x0077
        L_0x0047:
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0077
            long r4 = r9.d()
            r6 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0069
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r0 = r8.f15601g
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0069
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r0 = r8.f15601g
            java.lang.Object r0 = r0.peek()
            com.google.android.exoplayer2.extractor.mp4.a$a r0 = (com.google.android.exoplayer2.extractor.mp4.a.C0110a) r0
            long r4 = r0.f15516b
        L_0x0069:
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x0077
            long r6 = r9.c()
            long r4 = r4 - r6
            int r0 = r8.f15605k
            long r6 = (long) r0
            long r4 = r4 + r6
            goto L_0x0044
        L_0x0077:
            long r4 = r8.f15604j
            int r0 = r8.f15605k
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x00fc
            int r0 = r8.f15603i
            boolean r0 = b((int) r0)
            if (r0 == 0) goto L_0x00bf
            long r2 = r9.c()
            long r4 = r8.f15604j
            long r2 = r2 + r4
            int r0 = r8.f15605k
            long r6 = (long) r0
            long r2 = r2 - r6
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00a2
            int r0 = r8.f15603i
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r0 != r4) goto L_0x00a2
            r8.c((fj.h) r9)
        L_0x00a2:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r9 = r8.f15601g
            com.google.android.exoplayer2.extractor.mp4.a$a r0 = new com.google.android.exoplayer2.extractor.mp4.a$a
            int r4 = r8.f15603i
            r0.<init>(r4, r2)
            r9.push(r0)
            long r4 = r8.f15604j
            int r9 = r8.f15605k
            long r6 = (long) r9
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x00bb
            r8.b((long) r2)
            goto L_0x00fb
        L_0x00bb:
            r8.d()
            goto L_0x00fb
        L_0x00bf:
            int r9 = r8.f15603i
            boolean r9 = a((int) r9)
            if (r9 == 0) goto L_0x00f6
            int r9 = r8.f15605k
            if (r9 != r2) goto L_0x00cd
            r9 = 1
            goto L_0x00ce
        L_0x00cd:
            r9 = 0
        L_0x00ce:
            com.google.android.exoplayer2.util.a.b((boolean) r9)
            long r4 = r8.f15604j
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 > 0) goto L_0x00dc
            r9 = 1
            goto L_0x00dd
        L_0x00dc:
            r9 = 0
        L_0x00dd:
            com.google.android.exoplayer2.util.a.b((boolean) r9)
            com.google.android.exoplayer2.util.q r9 = new com.google.android.exoplayer2.util.q
            long r4 = r8.f15604j
            int r0 = (int) r4
            r9.<init>((int) r0)
            r8.f15606l = r9
            com.google.android.exoplayer2.util.q r9 = r8.f15600f
            byte[] r9 = r9.f17159a
            com.google.android.exoplayer2.util.q r0 = r8.f15606l
            byte[] r0 = r0.f17159a
            java.lang.System.arraycopy(r9, r3, r0, r3, r2)
            goto L_0x00f9
        L_0x00f6:
            r9 = 0
            r8.f15606l = r9
        L_0x00f9:
            r8.f15602h = r1
        L_0x00fb:
            return r1
        L_0x00fc:
            com.google.android.exoplayer2.ParserException r9 = new com.google.android.exoplayer2.ParserException
            java.lang.String r0 = "Atom size less than header length (unsupported)."
            r9.<init>((java.lang.String) r0)
            goto L_0x0105
        L_0x0104:
            throw r9
        L_0x0105:
            goto L_0x0104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.g.b(fj.h):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(fj.h r10, fj.r r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            long r0 = r9.f15604j
            int r2 = r9.f15605k
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.c()
            long r2 = r2 + r0
            com.google.android.exoplayer2.util.q r4 = r9.f15606l
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0046
            byte[] r11 = r4.f17159a
            int r4 = r9.f15605k
            int r1 = (int) r0
            r10.b(r11, r4, r1)
            int r10 = r9.f15603i
            r11 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r11) goto L_0x0029
            com.google.android.exoplayer2.util.q r10 = r9.f15606l
            boolean r10 = a((com.google.android.exoplayer2.util.q) r10)
            r9.f15616v = r10
            goto L_0x0051
        L_0x0029:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r10 = r9.f15601g
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x0051
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r10 = r9.f15601g
            java.lang.Object r10 = r10.peek()
            com.google.android.exoplayer2.extractor.mp4.a$a r10 = (com.google.android.exoplayer2.extractor.mp4.a.C0110a) r10
            com.google.android.exoplayer2.extractor.mp4.a$b r11 = new com.google.android.exoplayer2.extractor.mp4.a$b
            int r0 = r9.f15603i
            com.google.android.exoplayer2.util.q r1 = r9.f15606l
            r11.<init>(r0, r1)
            r10.a((com.google.android.exoplayer2.extractor.mp4.a.b) r11)
            goto L_0x0051
        L_0x0046:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0053
            int r11 = (int) r0
            r10.b(r11)
        L_0x0051:
            r10 = 0
            goto L_0x005b
        L_0x0053:
            long r7 = r10.c()
            long r7 = r7 + r0
            r11.f27401a = r7
            r10 = 1
        L_0x005b:
            r9.b((long) r2)
            if (r10 == 0) goto L_0x0066
            int r10 = r9.f15602h
            r11 = 2
            if (r10 == r11) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r5 = 0
        L_0x0067:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.g.b(fj.h, fj.r):boolean");
    }

    private int c(long j2) {
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        boolean z3 = true;
        long j5 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.f15612r;
            if (i4 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i4];
            int i5 = aVar.f15620d;
            if (i5 != aVar.f15618b.f15661b) {
                long j6 = aVar.f15618b.f15662c[i5];
                long j7 = this.f15613s[i4][i5];
                long j8 = j6 - j2;
                boolean z4 = j8 < 0 || j8 >= 262144;
                if ((!z4 && z3) || (z4 == z3 && j8 < j5)) {
                    z3 = z4;
                    j5 = j8;
                    i3 = i4;
                    j4 = j7;
                }
                if (j7 < j3) {
                    z2 = z4;
                    i2 = i4;
                    j3 = j7;
                }
            }
            i4++;
        }
        return (j3 == Long.MAX_VALUE || !z2 || j4 < j3 + 10485760) ? i3 : i2;
    }

    private int c(h hVar, r rVar) throws IOException, InterruptedException {
        long c2 = hVar.c();
        if (this.f15607m == -1) {
            int c3 = c(c2);
            this.f15607m = c3;
            if (c3 == -1) {
                return -1;
            }
        }
        a aVar = this.f15612r[this.f15607m];
        u uVar = aVar.f15619c;
        int i2 = aVar.f15620d;
        long j2 = aVar.f15618b.f15662c[i2];
        int i3 = aVar.f15618b.f15663d[i2];
        long j3 = (j2 - c2) + ((long) this.f15608n);
        if (j3 < 0 || j3 >= 262144) {
            rVar.f27401a = j2;
            return 1;
        }
        if (aVar.f15617a.f15631g == 1) {
            j3 += 8;
            i3 -= 8;
        }
        hVar.b((int) j3);
        if (aVar.f15617a.f15634j == 0) {
            if ("audio/ac4".equals(aVar.f15617a.f15630f.f15092i)) {
                if (this.f15609o == 0) {
                    b.a(i3, this.f15599e);
                    uVar.a(this.f15599e, 7);
                    this.f15609o += 7;
                }
                i3 += 7;
            }
            while (true) {
                int i4 = this.f15609o;
                if (i4 >= i3) {
                    break;
                }
                int a2 = uVar.a(hVar, i3 - i4, false);
                this.f15608n += a2;
                this.f15609o += a2;
                this.f15610p -= a2;
            }
        } else {
            byte[] bArr = this.f15598d.f17159a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i5 = aVar.f15617a.f15634j;
            int i6 = 4 - aVar.f15617a.f15634j;
            while (this.f15609o < i3) {
                int i7 = this.f15610p;
                if (i7 == 0) {
                    hVar.b(bArr, i6, i5);
                    this.f15608n += i5;
                    this.f15598d.c(0);
                    int p2 = this.f15598d.p();
                    if (p2 >= 0) {
                        this.f15610p = p2;
                        this.f15597c.c(0);
                        uVar.a(this.f15597c, 4);
                        this.f15609o += 4;
                        i3 += i6;
                    } else {
                        throw new ParserException("Invalid NAL length");
                    }
                } else {
                    int a3 = uVar.a(hVar, i7, false);
                    this.f15608n += a3;
                    this.f15609o += a3;
                    this.f15610p -= a3;
                }
            }
        }
        uVar.a(aVar.f15618b.f15665f[i2], aVar.f15618b.f15666g[i2], i3, 0, (u.a) null);
        aVar.f15620d++;
        this.f15607m = -1;
        this.f15608n = 0;
        this.f15609o = 0;
        this.f15610p = 0;
        return 0;
    }

    private void c(h hVar) throws IOException, InterruptedException {
        this.f15599e.a(8);
        hVar.d(this.f15599e.f17159a, 0, 8);
        this.f15599e.d(4);
        if (this.f15599e.p() == 1751411826) {
            hVar.a();
        } else {
            hVar.b(4);
        }
    }

    private void d() {
        this.f15602h = 0;
        this.f15605k = 0;
    }

    private void d(long j2) {
        for (a aVar : this.f15612r) {
            m mVar = aVar.f15618b;
            int a2 = mVar.a(j2);
            if (a2 == -1) {
                a2 = mVar.b(j2);
            }
            aVar.f15620d = a2;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ fj.g[] e() {
        return new fj.g[]{new g()};
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f15602h;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return c(hVar, rVar);
                    }
                    throw new IllegalStateException();
                } else if (b(hVar, rVar)) {
                    return 1;
                }
            } else if (!b(hVar)) {
                return -1;
            }
        }
    }

    public s.a a(long j2) {
        long j3;
        long j4;
        long j5;
        long j6;
        int b2;
        a[] aVarArr = this.f15612r;
        if (aVarArr.length == 0) {
            return new s.a(t.f27406a);
        }
        int i2 = this.f15614t;
        if (i2 != -1) {
            m mVar = aVarArr[i2].f15618b;
            int a2 = a(mVar, j2);
            if (a2 == -1) {
                return new s.a(t.f27406a);
            }
            long j7 = mVar.f15665f[a2];
            j3 = mVar.f15662c[a2];
            if (j7 >= j2 || a2 >= mVar.f15661b - 1 || (b2 = mVar.b(j2)) == -1 || b2 == a2) {
                j6 = -1;
                j5 = -9223372036854775807L;
            } else {
                j5 = mVar.f15665f[b2];
                j6 = mVar.f15662c[b2];
            }
            j4 = j6;
            j2 = j7;
        } else {
            j3 = Long.MAX_VALUE;
            j4 = -1;
            j5 = -9223372036854775807L;
        }
        int i3 = 0;
        while (true) {
            a[] aVarArr2 = this.f15612r;
            if (i3 >= aVarArr2.length) {
                break;
            }
            if (i3 != this.f15614t) {
                m mVar2 = aVarArr2[i3].f15618b;
                long a3 = a(mVar2, j2, j3);
                if (j5 != -9223372036854775807L) {
                    j4 = a(mVar2, j5, j4);
                }
                j3 = a3;
            }
            i3++;
        }
        t tVar = new t(j2, j3);
        return j5 == -9223372036854775807L ? new s.a(tVar) : new s.a(tVar, new t(j5, j4));
    }

    public void a(long j2, long j3) {
        this.f15601g.clear();
        this.f15605k = 0;
        this.f15607m = -1;
        this.f15608n = 0;
        this.f15609o = 0;
        this.f15610p = 0;
        if (j2 == 0) {
            d();
        } else if (this.f15612r != null) {
            d(j3);
        }
    }

    public void a(i iVar) {
        this.f15611q = iVar;
    }

    public boolean a() {
        return true;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        return i.b(hVar);
    }

    public long b() {
        return this.f15615u;
    }

    public void c() {
    }
}
