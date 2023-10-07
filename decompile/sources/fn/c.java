package fn;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.o;
import fj.p;
import fj.u;
import java.io.EOFException;
import java.io.IOException;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27562a = $$Lambda$c$ExK73j3cNCfLNHFcGFqM6mQGuQ.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final a.C0112a f27563b = $$Lambda$c$TTgvFUxYSlF_d8z9g4MxZ0cqto.INSTANCE;

    /* renamed from: c  reason: collision with root package name */
    private final int f27564c;

    /* renamed from: d  reason: collision with root package name */
    private final long f27565d;

    /* renamed from: e  reason: collision with root package name */
    private final q f27566e;

    /* renamed from: f  reason: collision with root package name */
    private final fj.q f27567f;

    /* renamed from: g  reason: collision with root package name */
    private final o f27568g;

    /* renamed from: h  reason: collision with root package name */
    private final p f27569h;

    /* renamed from: i  reason: collision with root package name */
    private i f27570i;

    /* renamed from: j  reason: collision with root package name */
    private u f27571j;

    /* renamed from: k  reason: collision with root package name */
    private int f27572k;

    /* renamed from: l  reason: collision with root package name */
    private Metadata f27573l;

    /* renamed from: m  reason: collision with root package name */
    private d f27574m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f27575n;

    /* renamed from: o  reason: collision with root package name */
    private long f27576o;

    /* renamed from: p  reason: collision with root package name */
    private long f27577p;

    /* renamed from: q  reason: collision with root package name */
    private long f27578q;

    /* renamed from: r  reason: collision with root package name */
    private int f27579r;

    public c() {
        this(0);
    }

    public c(int i2) {
        this(i2, -9223372036854775807L);
    }

    public c(int i2, long j2) {
        this.f27564c = i2;
        this.f27565d = j2;
        this.f27566e = new q(10);
        this.f27567f = new fj.q();
        this.f27568g = new o();
        this.f27576o = -9223372036854775807L;
        this.f27569h = new p();
    }

    private static int a(q qVar, int i2) {
        if (qVar.c() >= i2 + 4) {
            qVar.c(i2);
            int p2 = qVar.p();
            if (p2 == 1483304551 || p2 == 1231971951) {
                return p2;
            }
        }
        if (qVar.c() < 40) {
            return 0;
        }
        qVar.c(36);
        return qVar.p() == 1447187017 ? 1447187017 : 0;
    }

    private static b a(Metadata metadata, long j2) {
        if (metadata == null) {
            return null;
        }
        int a2 = metadata.a();
        for (int i2 = 0; i2 < a2; i2++) {
            Metadata.Entry a3 = metadata.a(i2);
            if (a3 instanceof MlltFrame) {
                return b.a(j2, (MlltFrame) a3);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i2, int i3, int i4, int i5, int i6) {
        return (i3 == 67 && i4 == 79 && i5 == 77 && (i6 == 77 || i2 == 2)) || (i3 == 77 && i4 == 76 && i5 == 76 && (i6 == 84 || i2 == 2));
    }

    private static boolean a(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
    }

    private boolean a(h hVar, boolean z2) throws IOException, InterruptedException {
        int i2;
        int i3;
        int a2;
        int i4 = z2 ? 16384 : 131072;
        hVar.a();
        if (hVar.c() == 0) {
            Metadata a3 = this.f27569h.a(hVar, (this.f27564c & 2) == 0 ? null : f27563b);
            this.f27573l = a3;
            if (a3 != null) {
                this.f27568g.a(a3);
            }
            i2 = (int) hVar.b();
            if (!z2) {
                hVar.b(i2);
            }
            i3 = 0;
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (!c(hVar)) {
                this.f27566e.c(0);
                int p2 = this.f27566e.p();
                if ((i3 == 0 || a(p2, (long) i3)) && (a2 = fj.q.a(p2)) != -1) {
                    i5++;
                    if (i5 != 1) {
                        if (i5 == 4) {
                            break;
                        }
                    } else {
                        fj.q.a(p2, this.f27567f);
                        i3 = p2;
                    }
                    hVar.c(a2 - 4);
                } else {
                    int i7 = i6 + 1;
                    if (i6 != i4) {
                        if (z2) {
                            hVar.a();
                            hVar.c(i2 + i7);
                        } else {
                            hVar.b(1);
                        }
                        i6 = i7;
                        i3 = 0;
                        i5 = 0;
                    } else if (z2) {
                        return false;
                    } else {
                        throw new ParserException("Searched too many bytes.");
                    }
                }
            } else if (i5 <= 0) {
                throw new EOFException();
            }
        }
        if (z2) {
            hVar.b(i2 + i6);
        } else {
            hVar.a();
        }
        this.f27572k = i3;
        return true;
    }

    private int b(h hVar) throws IOException, InterruptedException {
        if (this.f27579r == 0) {
            hVar.a();
            if (c(hVar)) {
                return -1;
            }
            this.f27566e.c(0);
            int p2 = this.f27566e.p();
            if (!a(p2, (long) this.f27572k) || fj.q.a(p2) == -1) {
                hVar.b(1);
                this.f27572k = 0;
                return 0;
            }
            fj.q.a(p2, this.f27567f);
            if (this.f27576o == -9223372036854775807L) {
                this.f27576o = this.f27574m.c(hVar.c());
                if (this.f27565d != -9223372036854775807L) {
                    this.f27576o += this.f27565d - this.f27574m.c(0);
                }
            }
            this.f27579r = this.f27567f.f27396c;
        }
        int a2 = this.f27571j.a(hVar, this.f27579r, true);
        if (a2 == -1) {
            return -1;
        }
        int i2 = this.f27579r - a2;
        this.f27579r = i2;
        if (i2 > 0) {
            return 0;
        }
        this.f27571j.a(this.f27576o + ((this.f27577p * 1000000) / ((long) this.f27567f.f27397d)), 1, this.f27567f.f27396c, 0, (u.a) null);
        this.f27577p += (long) this.f27567f.f27400g;
        this.f27579r = 0;
        return 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] b() {
        return new g[]{new c()};
    }

    private boolean c(h hVar) throws IOException, InterruptedException {
        d dVar = this.f27574m;
        if (dVar != null) {
            long c2 = dVar.c();
            if (c2 != -1 && hVar.b() > c2 - 4) {
                return true;
            }
        }
        try {
            return !hVar.b(this.f27566e.f17159a, 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0041 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ab A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private fn.d d(fj.h r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r10 = this;
            com.google.android.exoplayer2.util.q r5 = new com.google.android.exoplayer2.util.q
            fj.q r0 = r10.f27567f
            int r0 = r0.f27396c
            r5.<init>((int) r0)
            byte[] r0 = r5.f17159a
            fj.q r1 = r10.f27567f
            int r1 = r1.f27396c
            r6 = 0
            r11.d(r0, r6, r1)
            fj.q r0 = r10.f27567f
            int r0 = r0.f27394a
            r1 = 1
            r0 = r0 & r1
            r2 = 21
            if (r0 == 0) goto L_0x0028
            fj.q r0 = r10.f27567f
            int r0 = r0.f27398e
            if (r0 == r1) goto L_0x002e
            r2 = 36
            r7 = 36
            goto L_0x0035
        L_0x0028:
            fj.q r0 = r10.f27567f
            int r0 = r0.f27398e
            if (r0 == r1) goto L_0x0031
        L_0x002e:
            r7 = 21
            goto L_0x0035
        L_0x0031:
            r2 = 13
            r7 = 13
        L_0x0035:
            int r8 = a((com.google.android.exoplayer2.util.q) r5, (int) r7)
            r0 = 1483304551(0x58696e67, float:1.02664153E15)
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r8 == r0) goto L_0x0064
            if (r8 != r9) goto L_0x0044
            goto L_0x0064
        L_0x0044:
            r0 = 1447187017(0x56425249, float:5.3414667E13)
            if (r8 != r0) goto L_0x005f
            long r0 = r11.d()
            long r2 = r11.c()
            fj.q r4 = r10.f27567f
            fn.e r0 = fn.e.a(r0, r2, r4, r5)
            fj.q r1 = r10.f27567f
            int r1 = r1.f27396c
            r11.b(r1)
            goto L_0x00b2
        L_0x005f:
            r0 = 0
            r11.a()
            goto L_0x00b2
        L_0x0064:
            long r0 = r11.d()
            long r2 = r11.c()
            fj.q r4 = r10.f27567f
            fn.f r0 = fn.f.a(r0, r2, r4, r5)
            if (r0 == 0) goto L_0x009c
            fj.o r1 = r10.f27568g
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x009c
            r11.a()
            int r7 = r7 + 141
            r11.c(r7)
            com.google.android.exoplayer2.util.q r1 = r10.f27566e
            byte[] r1 = r1.f17159a
            r2 = 3
            r11.d(r1, r6, r2)
            com.google.android.exoplayer2.util.q r1 = r10.f27566e
            r1.c(r6)
            fj.o r1 = r10.f27568g
            com.google.android.exoplayer2.util.q r2 = r10.f27566e
            int r2 = r2.l()
            r1.a((int) r2)
        L_0x009c:
            fj.q r1 = r10.f27567f
            int r1 = r1.f27396c
            r11.b(r1)
            if (r0 == 0) goto L_0x00b2
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x00b2
            if (r8 != r9) goto L_0x00b2
            fn.d r11 = r10.e(r11)
            return r11
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fn.c.d(fj.h):fn.d");
    }

    private d e(h hVar) throws IOException, InterruptedException {
        hVar.d(this.f27566e.f17159a, 0, 4);
        this.f27566e.c(0);
        fj.q.a(this.f27566e.p(), this.f27567f);
        return new a(hVar.d(), hVar.c(), this.f27567f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(fj.h r19, fj.r r20) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            int r2 = r0.f27572k
            if (r2 != 0) goto L_0x000f
            r2 = 0
            r0.a((fj.h) r1, (boolean) r2)     // Catch:{ EOFException -> 0x000d }
            goto L_0x000f
        L_0x000d:
            r1 = -1
            return r1
        L_0x000f:
            fn.d r2 = r0.f27574m
            if (r2 != 0) goto L_0x008d
            fn.d r2 = r18.d(r19)
            com.google.android.exoplayer2.metadata.Metadata r3 = r0.f27573l
            long r4 = r19.c()
            fn.b r3 = a((com.google.android.exoplayer2.metadata.Metadata) r3, (long) r4)
            boolean r4 = r0.f27575n
            if (r4 == 0) goto L_0x002d
            fn.d$a r2 = new fn.d$a
            r2.<init>()
        L_0x002a:
            r0.f27574m = r2
            goto L_0x004b
        L_0x002d:
            if (r3 == 0) goto L_0x0032
            r0.f27574m = r3
            goto L_0x0036
        L_0x0032:
            if (r2 == 0) goto L_0x0036
            r0.f27574m = r2
        L_0x0036:
            fn.d r2 = r0.f27574m
            if (r2 == 0) goto L_0x0046
            boolean r2 = r2.a()
            if (r2 != 0) goto L_0x004b
            int r2 = r0.f27564c
            r2 = r2 & 1
            if (r2 == 0) goto L_0x004b
        L_0x0046:
            fn.d r2 = r18.e(r19)
            goto L_0x002a
        L_0x004b:
            fj.i r2 = r0.f27570i
            fn.d r3 = r0.f27574m
            r2.a(r3)
            fj.u r2 = r0.f27571j
            r3 = 0
            fj.q r4 = r0.f27567f
            java.lang.String r4 = r4.f27395b
            r5 = 0
            r6 = -1
            r7 = 4096(0x1000, float:5.74E-42)
            fj.q r8 = r0.f27567f
            int r8 = r8.f27398e
            fj.q r9 = r0.f27567f
            int r9 = r9.f27397d
            r10 = -1
            fj.o r11 = r0.f27568g
            int r11 = r11.f27384a
            fj.o r12 = r0.f27568g
            int r12 = r12.f27385b
            r13 = 0
            r14 = 0
            r16 = 0
            int r15 = r0.f27564c
            r15 = r15 & 2
            if (r15 == 0) goto L_0x007a
            r15 = 0
            goto L_0x007c
        L_0x007a:
            com.google.android.exoplayer2.metadata.Metadata r15 = r0.f27573l
        L_0x007c:
            r17 = r15
            r15 = 0
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6, (int) r7, (int) r8, (int) r9, (int) r10, (int) r11, (int) r12, (java.util.List<byte[]>) r13, (com.google.android.exoplayer2.drm.DrmInitData) r14, (int) r15, (java.lang.String) r16, (com.google.android.exoplayer2.metadata.Metadata) r17)
            r2.a(r3)
            long r2 = r19.c()
            r0.f27578q = r2
            goto L_0x00a4
        L_0x008d:
            long r2 = r0.f27578q
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00a4
            long r2 = r19.c()
            long r4 = r0.f27578q
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a4
            long r4 = r4 - r2
            int r2 = (int) r4
            r1.b(r2)
        L_0x00a4:
            int r1 = r18.b(r19)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fn.c.a(fj.h, fj.r):int");
    }

    public void a() {
        this.f27575n = true;
    }

    public void a(long j2, long j3) {
        this.f27572k = 0;
        this.f27576o = -9223372036854775807L;
        this.f27577p = 0;
        this.f27579r = 0;
    }

    public void a(i iVar) {
        this.f27570i = iVar;
        this.f27571j = iVar.a(0, 1);
        this.f27570i.a();
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        return a(hVar, true);
    }

    public void c() {
    }
}
