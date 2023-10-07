package fq;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.c;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.util.r;
import fj.i;
import fj.u;
import fq.ac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class l implements j {

    /* renamed from: a  reason: collision with root package name */
    private final x f27820a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f27821b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27822c;

    /* renamed from: d  reason: collision with root package name */
    private final q f27823d = new q(7, 128);

    /* renamed from: e  reason: collision with root package name */
    private final q f27824e = new q(8, 128);

    /* renamed from: f  reason: collision with root package name */
    private final q f27825f = new q(6, 128);

    /* renamed from: g  reason: collision with root package name */
    private long f27826g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f27827h = new boolean[3];

    /* renamed from: i  reason: collision with root package name */
    private String f27828i;

    /* renamed from: j  reason: collision with root package name */
    private u f27829j;

    /* renamed from: k  reason: collision with root package name */
    private a f27830k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f27831l;

    /* renamed from: m  reason: collision with root package name */
    private long f27832m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f27833n;

    /* renamed from: o  reason: collision with root package name */
    private final q f27834o = new q();

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final u f27835a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f27836b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f27837c;

        /* renamed from: d  reason: collision with root package name */
        private final SparseArray<o.b> f27838d = new SparseArray<>();

        /* renamed from: e  reason: collision with root package name */
        private final SparseArray<o.a> f27839e = new SparseArray<>();

        /* renamed from: f  reason: collision with root package name */
        private final r f27840f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f27841g;

        /* renamed from: h  reason: collision with root package name */
        private int f27842h;

        /* renamed from: i  reason: collision with root package name */
        private int f27843i;

        /* renamed from: j  reason: collision with root package name */
        private long f27844j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f27845k;

        /* renamed from: l  reason: collision with root package name */
        private long f27846l;

        /* renamed from: m  reason: collision with root package name */
        private C0175a f27847m = new C0175a();

        /* renamed from: n  reason: collision with root package name */
        private C0175a f27848n = new C0175a();

        /* renamed from: o  reason: collision with root package name */
        private boolean f27849o;

        /* renamed from: p  reason: collision with root package name */
        private long f27850p;

        /* renamed from: q  reason: collision with root package name */
        private long f27851q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f27852r;

        /* renamed from: fq.l$a$a  reason: collision with other inner class name */
        private static final class C0175a {

            /* renamed from: a  reason: collision with root package name */
            private boolean f27853a;

            /* renamed from: b  reason: collision with root package name */
            private boolean f27854b;

            /* renamed from: c  reason: collision with root package name */
            private o.b f27855c;

            /* renamed from: d  reason: collision with root package name */
            private int f27856d;

            /* renamed from: e  reason: collision with root package name */
            private int f27857e;

            /* renamed from: f  reason: collision with root package name */
            private int f27858f;

            /* renamed from: g  reason: collision with root package name */
            private int f27859g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f27860h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f27861i;

            /* renamed from: j  reason: collision with root package name */
            private boolean f27862j;

            /* renamed from: k  reason: collision with root package name */
            private boolean f27863k;

            /* renamed from: l  reason: collision with root package name */
            private int f27864l;

            /* renamed from: m  reason: collision with root package name */
            private int f27865m;

            /* renamed from: n  reason: collision with root package name */
            private int f27866n;

            /* renamed from: o  reason: collision with root package name */
            private int f27867o;

            /* renamed from: p  reason: collision with root package name */
            private int f27868p;

            private C0175a() {
            }

            /* access modifiers changed from: private */
            public boolean a(C0175a aVar) {
                boolean z2;
                boolean z3;
                if (this.f27853a) {
                    if (!aVar.f27853a || this.f27858f != aVar.f27858f || this.f27859g != aVar.f27859g || this.f27860h != aVar.f27860h) {
                        return true;
                    }
                    if (this.f27861i && aVar.f27861i && this.f27862j != aVar.f27862j) {
                        return true;
                    }
                    int i2 = this.f27856d;
                    int i3 = aVar.f27856d;
                    if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                        return true;
                    }
                    if (this.f27855c.f17152k == 0 && aVar.f27855c.f17152k == 0 && (this.f27865m != aVar.f27865m || this.f27866n != aVar.f27866n)) {
                        return true;
                    }
                    if ((this.f27855c.f17152k != 1 || aVar.f27855c.f17152k != 1 || (this.f27867o == aVar.f27867o && this.f27868p == aVar.f27868p)) && (z2 = this.f27863k) == (z3 = aVar.f27863k)) {
                        return z2 && z3 && this.f27864l != aVar.f27864l;
                    }
                    return true;
                }
            }

            public void a() {
                this.f27854b = false;
                this.f27853a = false;
            }

            public void a(int i2) {
                this.f27857e = i2;
                this.f27854b = true;
            }

            public void a(o.b bVar, int i2, int i3, int i4, int i5, boolean z2, boolean z3, boolean z4, boolean z5, int i6, int i7, int i8, int i9, int i10) {
                this.f27855c = bVar;
                this.f27856d = i2;
                this.f27857e = i3;
                this.f27858f = i4;
                this.f27859g = i5;
                this.f27860h = z2;
                this.f27861i = z3;
                this.f27862j = z4;
                this.f27863k = z5;
                this.f27864l = i6;
                this.f27865m = i7;
                this.f27866n = i8;
                this.f27867o = i9;
                this.f27868p = i10;
                this.f27853a = true;
                this.f27854b = true;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = r2.f27857e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean b() {
                /*
                    r2 = this;
                    boolean r0 = r2.f27854b
                    if (r0 == 0) goto L_0x000e
                    int r0 = r2.f27857e
                    r1 = 7
                    if (r0 == r1) goto L_0x000c
                    r1 = 2
                    if (r0 != r1) goto L_0x000e
                L_0x000c:
                    r0 = 1
                    goto L_0x000f
                L_0x000e:
                    r0 = 0
                L_0x000f:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: fq.l.a.C0175a.b():boolean");
            }
        }

        public a(u uVar, boolean z2, boolean z3) {
            this.f27835a = uVar;
            this.f27836b = z2;
            this.f27837c = z3;
            byte[] bArr = new byte[128];
            this.f27841g = bArr;
            this.f27840f = new r(bArr, 0, 0);
            b();
        }

        private void a(int i2) {
            boolean z2 = this.f27852r;
            int i3 = (int) (this.f27844j - this.f27850p);
            this.f27835a.a(this.f27851q, z2 ? 1 : 0, i3, i2, (u.a) null);
        }

        public void a(long j2, int i2, long j3) {
            this.f27843i = i2;
            this.f27846l = j3;
            this.f27844j = j2;
            if (!this.f27836b || i2 != 1) {
                if (!this.f27837c) {
                    return;
                }
                if (!(i2 == 5 || i2 == 1 || i2 == 2)) {
                    return;
                }
            }
            C0175a aVar = this.f27847m;
            this.f27847m = this.f27848n;
            this.f27848n = aVar;
            aVar.a();
            this.f27842h = 0;
            this.f27845k = true;
        }

        public void a(o.a aVar) {
            this.f27839e.append(aVar.f17139a, aVar);
        }

        public void a(o.b bVar) {
            this.f27838d.append(bVar.f17145d, bVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x014e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.f27845k
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.f27841g
                int r4 = r3.length
                int r5 = r0.f27842h
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.f27841g = r3
            L_0x001e:
                byte[] r3 = r0.f27841g
                int r4 = r0.f27842h
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.f27842h
                int r1 = r1 + r2
                r0.f27842h = r1
                com.google.android.exoplayer2.util.r r2 = r0.f27840f
                byte[] r3 = r0.f27841g
                r4 = 0
                r2.a(r3, r4, r1)
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                r2 = 8
                boolean r1 = r1.b(r2)
                if (r1 != 0) goto L_0x003f
                return
            L_0x003f:
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                r1.a()
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                int r10 = r1.c(r7)
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                r2 = 5
                r1.a(r2)
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0059
                return
            L_0x0059:
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                r1.d()
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0067
                return
            L_0x0067:
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                int r11 = r1.d()
                boolean r1 = r0.f27837c
                if (r1 != 0) goto L_0x0079
                r0.f27845k = r4
                fq.l$a$a r1 = r0.f27848n
                r1.a((int) r11)
                return
            L_0x0079:
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0082
                return
            L_0x0082:
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                int r13 = r1.d()
                android.util.SparseArray<com.google.android.exoplayer2.util.o$a> r1 = r0.f27839e
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0093
                r0.f27845k = r4
                return
            L_0x0093:
                android.util.SparseArray<com.google.android.exoplayer2.util.o$a> r1 = r0.f27839e
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.util.o$a r1 = (com.google.android.exoplayer2.util.o.a) r1
                android.util.SparseArray<com.google.android.exoplayer2.util.o$b> r3 = r0.f27838d
                int r5 = r1.f17140b
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                com.google.android.exoplayer2.util.o$b r9 = (com.google.android.exoplayer2.util.o.b) r9
                boolean r3 = r9.f17149h
                if (r3 == 0) goto L_0x00b8
                com.google.android.exoplayer2.util.r r3 = r0.f27840f
                boolean r3 = r3.b(r7)
                if (r3 != 0) goto L_0x00b3
                return
            L_0x00b3:
                com.google.android.exoplayer2.util.r r3 = r0.f27840f
                r3.a(r7)
            L_0x00b8:
                com.google.android.exoplayer2.util.r r3 = r0.f27840f
                int r5 = r9.f17151j
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00c3
                return
            L_0x00c3:
                com.google.android.exoplayer2.util.r r3 = r0.f27840f
                int r5 = r9.f17151j
                int r12 = r3.c(r5)
                boolean r3 = r9.f17150i
                r5 = 1
                if (r3 != 0) goto L_0x00f7
                com.google.android.exoplayer2.util.r r3 = r0.f27840f
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00d9
                return
            L_0x00d9:
                com.google.android.exoplayer2.util.r r3 = r0.f27840f
                boolean r3 = r3.b()
                if (r3 == 0) goto L_0x00f5
                com.google.android.exoplayer2.util.r r6 = r0.f27840f
                boolean r6 = r6.b(r5)
                if (r6 != 0) goto L_0x00ea
                return
            L_0x00ea:
                com.google.android.exoplayer2.util.r r6 = r0.f27840f
                boolean r6 = r6.b()
                r14 = r3
                r16 = r6
                r15 = 1
                goto L_0x00fb
            L_0x00f5:
                r14 = r3
                goto L_0x00f8
            L_0x00f7:
                r14 = 0
            L_0x00f8:
                r15 = 0
                r16 = 0
            L_0x00fb:
                int r3 = r0.f27843i
                if (r3 != r2) goto L_0x0102
                r17 = 1
                goto L_0x0104
            L_0x0102:
                r17 = 0
            L_0x0104:
                if (r17 == 0) goto L_0x0118
                com.google.android.exoplayer2.util.r r2 = r0.f27840f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x010f
                return
            L_0x010f:
                com.google.android.exoplayer2.util.r r2 = r0.f27840f
                int r2 = r2.d()
                r18 = r2
                goto L_0x011a
            L_0x0118:
                r18 = 0
            L_0x011a:
                int r2 = r9.f17152k
                if (r2 != 0) goto L_0x014e
                com.google.android.exoplayer2.util.r r2 = r0.f27840f
                int r3 = r9.f17153l
                boolean r2 = r2.b(r3)
                if (r2 != 0) goto L_0x0129
                return
            L_0x0129:
                com.google.android.exoplayer2.util.r r2 = r0.f27840f
                int r3 = r9.f17153l
                int r2 = r2.c(r3)
                boolean r1 = r1.f17141c
                if (r1 == 0) goto L_0x014b
                if (r14 != 0) goto L_0x014b
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0140
                return
            L_0x0140:
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                int r1 = r1.e()
                r20 = r1
                r19 = r2
                goto L_0x018e
            L_0x014b:
                r19 = r2
                goto L_0x018c
            L_0x014e:
                int r2 = r9.f17152k
                if (r2 != r5) goto L_0x018a
                boolean r2 = r9.f17154m
                if (r2 != 0) goto L_0x018a
                com.google.android.exoplayer2.util.r r2 = r0.f27840f
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x015f
                return
            L_0x015f:
                com.google.android.exoplayer2.util.r r2 = r0.f27840f
                int r2 = r2.e()
                boolean r1 = r1.f17141c
                if (r1 == 0) goto L_0x0183
                if (r14 != 0) goto L_0x0183
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0174
                return
            L_0x0174:
                com.google.android.exoplayer2.util.r r1 = r0.f27840f
                int r1 = r1.e()
                r22 = r1
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0192
            L_0x0183:
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0190
            L_0x018a:
                r19 = 0
            L_0x018c:
                r20 = 0
            L_0x018e:
                r21 = 0
            L_0x0190:
                r22 = 0
            L_0x0192:
                fq.l$a$a r8 = r0.f27848n
                r8.a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.f27845k = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fq.l.a.a(byte[], int, int):void");
        }

        public boolean a() {
            return this.f27837c;
        }

        public boolean a(long j2, int i2, boolean z2, boolean z3) {
            boolean z4 = false;
            if (this.f27843i == 9 || (this.f27837c && this.f27848n.a(this.f27847m))) {
                if (z2 && this.f27849o) {
                    a(i2 + ((int) (j2 - this.f27844j)));
                }
                this.f27850p = this.f27844j;
                this.f27851q = this.f27846l;
                this.f27852r = false;
                this.f27849o = true;
            }
            if (this.f27836b) {
                z3 = this.f27848n.b();
            }
            boolean z5 = this.f27852r;
            int i3 = this.f27843i;
            if (i3 == 5 || (z3 && i3 == 1)) {
                z4 = true;
            }
            boolean z6 = z5 | z4;
            this.f27852r = z6;
            return z6;
        }

        public void b() {
            this.f27845k = false;
            this.f27849o = false;
            this.f27848n.a();
        }
    }

    public l(x xVar, boolean z2, boolean z3) {
        this.f27820a = xVar;
        this.f27821b = z2;
        this.f27822c = z3;
    }

    private void a(long j2, int i2, int i3, long j3) {
        q qVar;
        int i4 = i3;
        if (!this.f27831l || this.f27830k.a()) {
            this.f27823d.b(i4);
            this.f27824e.b(i4);
            if (!this.f27831l) {
                if (this.f27823d.b() && this.f27824e.b()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.f27823d.f27934a, this.f27823d.f27935b));
                    arrayList.add(Arrays.copyOf(this.f27824e.f27934a, this.f27824e.f27935b));
                    o.b a2 = o.a(this.f27823d.f27934a, 3, this.f27823d.f27935b);
                    o.a b2 = o.b(this.f27824e.f27934a, 3, this.f27824e.f27935b);
                    this.f27829j.a(Format.a(this.f27828i, "video/avc", c.b(a2.f17142a, a2.f17143b, a2.f17144c), -1, -1, a2.f17146e, a2.f17147f, -1.0f, (List<byte[]>) arrayList, -1, a2.f17148g, (DrmInitData) null));
                    this.f27831l = true;
                    this.f27830k.a(a2);
                    this.f27830k.a(b2);
                    this.f27823d.a();
                    qVar = this.f27824e;
                }
            } else if (this.f27823d.b()) {
                this.f27830k.a(o.a(this.f27823d.f27934a, 3, this.f27823d.f27935b));
                qVar = this.f27823d;
            } else if (this.f27824e.b()) {
                this.f27830k.a(o.b(this.f27824e.f27934a, 3, this.f27824e.f27935b));
                qVar = this.f27824e;
            }
            qVar.a();
        }
        if (this.f27825f.b(i3)) {
            this.f27834o.a(this.f27825f.f27934a, o.a(this.f27825f.f27934a, this.f27825f.f27935b));
            this.f27834o.c(4);
            this.f27820a.a(j3, this.f27834o);
        }
        if (this.f27830k.a(j2, i2, this.f27831l, this.f27833n)) {
            this.f27833n = false;
        }
    }

    private void a(long j2, int i2, long j3) {
        if (!this.f27831l || this.f27830k.a()) {
            this.f27823d.a(i2);
            this.f27824e.a(i2);
        }
        this.f27825f.a(i2);
        this.f27830k.a(j2, i2, j3);
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (!this.f27831l || this.f27830k.a()) {
            this.f27823d.a(bArr, i2, i3);
            this.f27824e.a(bArr, i2, i3);
        }
        this.f27825f.a(bArr, i2, i3);
        this.f27830k.a(bArr, i2, i3);
    }

    public void a() {
        o.a(this.f27827h);
        this.f27823d.a();
        this.f27824e.a();
        this.f27825f.a();
        this.f27830k.b();
        this.f27826g = 0;
        this.f27833n = false;
    }

    public void a(long j2, int i2) {
        this.f27832m = j2;
        this.f27833n |= (i2 & 2) != 0;
    }

    public void a(q qVar) {
        int d2 = qVar.d();
        int c2 = qVar.c();
        byte[] bArr = qVar.f17159a;
        this.f27826g += (long) qVar.b();
        this.f27829j.a(qVar, qVar.b());
        while (true) {
            int a2 = o.a(bArr, d2, c2, this.f27827h);
            if (a2 == c2) {
                a(bArr, d2, c2);
                return;
            }
            int b2 = o.b(bArr, a2);
            int i2 = a2 - d2;
            if (i2 > 0) {
                a(bArr, d2, a2);
            }
            int i3 = c2 - a2;
            long j2 = this.f27826g - ((long) i3);
            a(j2, i3, i2 < 0 ? -i2 : 0, this.f27832m);
            a(j2, b2, this.f27832m);
            d2 = a2 + 3;
        }
    }

    public void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f27828i = dVar.c();
        u a2 = iVar.a(dVar.b(), 2);
        this.f27829j = a2;
        this.f27830k = new a(a2, this.f27821b, this.f27822c);
        this.f27820a.a(iVar, dVar);
    }

    public void b() {
    }
}
