package fw;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    private final q f28203a = new q();

    /* renamed from: b  reason: collision with root package name */
    private final p f28204b = new p();

    /* renamed from: c  reason: collision with root package name */
    private final int f28205c;

    /* renamed from: d  reason: collision with root package name */
    private final a[] f28206d;

    /* renamed from: e  reason: collision with root package name */
    private a f28207e;

    /* renamed from: f  reason: collision with root package name */
    private List<com.google.android.exoplayer2.text.b> f28208f;

    /* renamed from: g  reason: collision with root package name */
    private List<com.google.android.exoplayer2.text.b> f28209g;

    /* renamed from: h  reason: collision with root package name */
    private b f28210h;

    /* renamed from: i  reason: collision with root package name */
    private int f28211i;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f28212a = a(2, 2, 2, 0);

        /* renamed from: b  reason: collision with root package name */
        public static final int f28213b;

        /* renamed from: c  reason: collision with root package name */
        public static final int f28214c;

        /* renamed from: d  reason: collision with root package name */
        private static final int[] f28215d = {0, 0, 0, 0, 0, 2, 0};

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f28216e = {0, 0, 0, 0, 0, 0, 2};

        /* renamed from: f  reason: collision with root package name */
        private static final int[] f28217f = {3, 3, 3, 3, 3, 3, 1};

        /* renamed from: g  reason: collision with root package name */
        private static final boolean[] f28218g = {false, false, false, true, true, true, false};

        /* renamed from: h  reason: collision with root package name */
        private static final int[] f28219h;

        /* renamed from: i  reason: collision with root package name */
        private static final int[] f28220i = {0, 1, 2, 3, 4, 3, 4};

        /* renamed from: j  reason: collision with root package name */
        private static final int[] f28221j = {0, 0, 0, 0, 0, 3, 3};

        /* renamed from: k  reason: collision with root package name */
        private static final int[] f28222k;
        private int A;
        private int B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;

        /* renamed from: l  reason: collision with root package name */
        private final List<SpannableString> f28223l = new ArrayList();

        /* renamed from: m  reason: collision with root package name */
        private final SpannableStringBuilder f28224m = new SpannableStringBuilder();

        /* renamed from: n  reason: collision with root package name */
        private boolean f28225n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f28226o;

        /* renamed from: p  reason: collision with root package name */
        private int f28227p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f28228q;

        /* renamed from: r  reason: collision with root package name */
        private int f28229r;

        /* renamed from: s  reason: collision with root package name */
        private int f28230s;

        /* renamed from: t  reason: collision with root package name */
        private int f28231t;

        /* renamed from: u  reason: collision with root package name */
        private int f28232u;

        /* renamed from: v  reason: collision with root package name */
        private boolean f28233v;

        /* renamed from: w  reason: collision with root package name */
        private int f28234w;

        /* renamed from: x  reason: collision with root package name */
        private int f28235x;

        /* renamed from: y  reason: collision with root package name */
        private int f28236y;

        /* renamed from: z  reason: collision with root package name */
        private int f28237z;

        static {
            int a2 = a(0, 0, 0, 0);
            f28213b = a2;
            int a3 = a(0, 0, 0, 3);
            f28214c = a3;
            f28219h = new int[]{a2, a3, a2, a2, a3, a2, a2};
            f28222k = new int[]{a2, a2, a2, a2, a2, a3, a3};
        }

        public a() {
            b();
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x002e  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int a(int r4, int r5, int r6, int r7) {
            /*
                r0 = 0
                r1 = 4
                com.google.android.exoplayer2.util.a.a(r4, r0, r1)
                com.google.android.exoplayer2.util.a.a(r5, r0, r1)
                com.google.android.exoplayer2.util.a.a(r6, r0, r1)
                com.google.android.exoplayer2.util.a.a(r7, r0, r1)
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L_0x0021
                if (r7 == r1) goto L_0x0021
                r3 = 2
                if (r7 == r3) goto L_0x001e
                r3 = 3
                if (r7 == r3) goto L_0x001c
                goto L_0x0021
            L_0x001c:
                r7 = 0
                goto L_0x0023
            L_0x001e:
                r7 = 127(0x7f, float:1.78E-43)
                goto L_0x0023
            L_0x0021:
                r7 = 255(0xff, float:3.57E-43)
            L_0x0023:
                if (r4 <= r1) goto L_0x0028
                r4 = 255(0xff, float:3.57E-43)
                goto L_0x0029
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r5 <= r1) goto L_0x002e
                r5 = 255(0xff, float:3.57E-43)
                goto L_0x002f
            L_0x002e:
                r5 = 0
            L_0x002f:
                if (r6 <= r1) goto L_0x0033
                r0 = 255(0xff, float:3.57E-43)
            L_0x0033:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: fw.c.a.a(int, int, int, int):int");
        }

        public static int b(int i2, int i3, int i4) {
            return a(i2, i3, i4, 0);
        }

        public void a(char c2) {
            if (c2 == 10) {
                this.f28223l.add(g());
                this.f28224m.clear();
                if (this.A != -1) {
                    this.A = 0;
                }
                if (this.B != -1) {
                    this.B = 0;
                }
                if (this.C != -1) {
                    this.C = 0;
                }
                if (this.E != -1) {
                    this.E = 0;
                }
                while (true) {
                    if ((this.f28233v && this.f28223l.size() >= this.f28232u) || this.f28223l.size() >= 15) {
                        this.f28223l.remove(0);
                    } else {
                        return;
                    }
                }
            } else {
                this.f28224m.append(c2);
            }
        }

        public void a(int i2, int i3) {
            if (this.G != i2) {
                a(10);
            }
            this.G = i2;
        }

        public void a(int i2, int i3, int i4) {
            if (!(this.C == -1 || this.D == i2)) {
                this.f28224m.setSpan(new ForegroundColorSpan(this.D), this.C, this.f28224m.length(), 33);
            }
            if (i2 != f28212a) {
                this.C = this.f28224m.length();
                this.D = i2;
            }
            if (!(this.E == -1 || this.F == i3)) {
                this.f28224m.setSpan(new BackgroundColorSpan(this.F), this.E, this.f28224m.length(), 33);
            }
            if (i3 != f28213b) {
                this.E = this.f28224m.length();
                this.F = i3;
            }
        }

        public void a(int i2, int i3, int i4, boolean z2, boolean z3, int i5, int i6) {
            if (this.A != -1) {
                if (!z2) {
                    this.f28224m.setSpan(new StyleSpan(2), this.A, this.f28224m.length(), 33);
                    this.A = -1;
                }
            } else if (z2) {
                this.A = this.f28224m.length();
            }
            if (this.B != -1) {
                if (!z3) {
                    this.f28224m.setSpan(new UnderlineSpan(), this.B, this.f28224m.length(), 33);
                    this.B = -1;
                }
            } else if (z3) {
                this.B = this.f28224m.length();
            }
        }

        public void a(int i2, int i3, boolean z2, int i4, int i5, int i6, int i7) {
            this.f28237z = i2;
            this.f28234w = i7;
        }

        public void a(boolean z2) {
            this.f28226o = z2;
        }

        public void a(boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            boolean z6 = z3;
            int i10 = i8;
            int i11 = i9;
            this.f28225n = true;
            this.f28226o = z2;
            this.f28233v = z6;
            this.f28227p = i2;
            this.f28228q = z5;
            this.f28229r = i3;
            this.f28230s = i4;
            this.f28231t = i7;
            int i12 = i5 + 1;
            if (this.f28232u != i12) {
                this.f28232u = i12;
                while (true) {
                    if ((!z6 || this.f28223l.size() < this.f28232u) && this.f28223l.size() < 15) {
                        break;
                    }
                    this.f28223l.remove(0);
                }
            }
            if (!(i10 == 0 || this.f28235x == i10)) {
                this.f28235x = i10;
                int i13 = i10 - 1;
                a(f28219h[i13], f28214c, f28218g[i13], 0, f28216e[i13], f28217f[i13], f28215d[i13]);
            }
            if (i11 != 0 && this.f28236y != i11) {
                this.f28236y = i11;
                int i14 = i11 - 1;
                a(0, 1, 1, false, false, f28221j[i14], f28220i[i14]);
                a(f28212a, f28222k[i14], f28213b);
            }
        }

        public boolean a() {
            return !d() || (this.f28223l.isEmpty() && this.f28224m.length() == 0);
        }

        public void b() {
            c();
            this.f28225n = false;
            this.f28226o = false;
            this.f28227p = 4;
            this.f28228q = false;
            this.f28229r = 0;
            this.f28230s = 0;
            this.f28231t = 0;
            this.f28232u = 15;
            this.f28233v = true;
            this.f28234w = 0;
            this.f28235x = 0;
            this.f28236y = 0;
            int i2 = f28213b;
            this.f28237z = i2;
            this.D = f28212a;
            this.F = i2;
        }

        public void c() {
            this.f28223l.clear();
            this.f28224m.clear();
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.E = -1;
            this.G = 0;
        }

        public boolean d() {
            return this.f28225n;
        }

        public boolean e() {
            return this.f28226o;
        }

        public void f() {
            int length = this.f28224m.length();
            if (length > 0) {
                this.f28224m.delete(length - 1, length);
            }
        }

        public SpannableString g() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f28224m);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.A != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
                }
                if (this.B != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
                }
                if (this.C != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
                }
                if (this.E != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0093  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00a0  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00ae  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public fw.b h() {
            /*
                r15 = this;
                boolean r0 = r15.a()
                if (r0 == 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                android.text.SpannableStringBuilder r2 = new android.text.SpannableStringBuilder
                r2.<init>()
                r0 = 0
                r1 = 0
            L_0x000f:
                java.util.List<android.text.SpannableString> r3 = r15.f28223l
                int r3 = r3.size()
                if (r1 >= r3) goto L_0x002a
                java.util.List<android.text.SpannableString> r3 = r15.f28223l
                java.lang.Object r3 = r3.get(r1)
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                r2.append(r3)
                r3 = 10
                r2.append(r3)
                int r1 = r1 + 1
                goto L_0x000f
            L_0x002a:
                android.text.SpannableString r1 = r15.g()
                r2.append(r1)
                int r1 = r15.f28234w
                r3 = 2
                r4 = 3
                r5 = 1
                if (r1 == 0) goto L_0x0060
                if (r1 == r5) goto L_0x005d
                if (r1 == r3) goto L_0x005a
                if (r1 != r4) goto L_0x003f
                goto L_0x0060
            L_0x003f:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                int r1 = r15.f28234w
                r2 = 43
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r2)
                java.lang.String r2 = "Unexpected justification value: "
                r3.append(r2)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                r0.<init>(r1)
                throw r0
            L_0x005a:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x0062
            L_0x005d:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x0062
            L_0x0060:
                android.text.Layout$Alignment r1 = android.text.Layout.Alignment.ALIGN_NORMAL
            L_0x0062:
                r6 = r1
                boolean r1 = r15.f28228q
                if (r1 == 0) goto L_0x0072
                int r1 = r15.f28230s
                float r1 = (float) r1
                r7 = 1120272384(0x42c60000, float:99.0)
                float r1 = r1 / r7
                int r8 = r15.f28229r
                float r8 = (float) r8
                float r8 = r8 / r7
                goto L_0x007f
            L_0x0072:
                int r1 = r15.f28230s
                float r1 = (float) r1
                r7 = 1129381888(0x43510000, float:209.0)
                float r1 = r1 / r7
                int r7 = r15.f28229r
                float r7 = (float) r7
                r8 = 1116995584(0x42940000, float:74.0)
                float r8 = r7 / r8
            L_0x007f:
                r7 = 1063675494(0x3f666666, float:0.9)
                float r1 = r1 * r7
                r9 = 1028443341(0x3d4ccccd, float:0.05)
                float r10 = r1 + r9
                float r8 = r8 * r7
                float r7 = r8 + r9
                int r1 = r15.f28231t
                int r8 = r1 % 3
                if (r8 != 0) goto L_0x0095
                r8 = 0
                goto L_0x009c
            L_0x0095:
                int r8 = r1 % 3
                if (r8 != r5) goto L_0x009b
                r8 = 1
                goto L_0x009c
            L_0x009b:
                r8 = 2
            L_0x009c:
                int r9 = r1 / 3
                if (r9 != 0) goto L_0x00a2
                r9 = 0
                goto L_0x00a8
            L_0x00a2:
                int r1 = r1 / r4
                if (r1 != r5) goto L_0x00a7
                r9 = 1
                goto L_0x00a8
            L_0x00a7:
                r9 = 2
            L_0x00a8:
                int r11 = r15.f28237z
                int r1 = f28213b
                if (r11 == r1) goto L_0x00af
                r0 = 1
            L_0x00af:
                fw.b r13 = new fw.b
                r5 = 0
                r12 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
                int r14 = r15.f28227p
                r1 = r13
                r3 = r6
                r4 = r7
                r6 = r8
                r7 = r10
                r8 = r9
                r9 = r12
                r10 = r0
                r12 = r14
                r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: fw.c.a.h():fw.b");
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f28238a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28239b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f28240c;

        /* renamed from: d  reason: collision with root package name */
        int f28241d = 0;

        public b(int i2, int i3) {
            this.f28238a = i2;
            this.f28239b = i3;
            this.f28240c = new byte[((i3 * 2) - 1)];
        }
    }

    public c(int i2, List<byte[]> list) {
        this.f28205c = i2 == -1 ? 1 : i2;
        this.f28206d = new a[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f28206d[i3] = new a();
        }
        this.f28207e = this.f28206d[0];
        p();
    }

    private void a(int i2) {
        p pVar;
        if (i2 == 0) {
            return;
        }
        if (i2 != 3) {
            int i3 = 8;
            if (i2 != 8) {
                switch (i2) {
                    case 12:
                        p();
                        return;
                    case 13:
                        this.f28207e.a(10);
                        return;
                    case 14:
                        return;
                    default:
                        if (i2 >= 17 && i2 <= 23) {
                            StringBuilder sb = new StringBuilder(55);
                            sb.append("Currently unsupported COMMAND_EXT1 Command: ");
                            sb.append(i2);
                            k.c("Cea708Decoder", sb.toString());
                            pVar = this.f28204b;
                        } else if (i2 < 24 || i2 > 31) {
                            StringBuilder sb2 = new StringBuilder(31);
                            sb2.append("Invalid C0 command: ");
                            sb2.append(i2);
                            k.c("Cea708Decoder", sb2.toString());
                            return;
                        } else {
                            StringBuilder sb3 = new StringBuilder(54);
                            sb3.append("Currently unsupported COMMAND_P16 Command: ");
                            sb3.append(i2);
                            k.c("Cea708Decoder", sb3.toString());
                            pVar = this.f28204b;
                            i3 = 16;
                        }
                        pVar.b(i3);
                        return;
                }
            } else {
                this.f28207e.f();
            }
        } else {
            this.f28208f = o();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006d, code lost:
        r5 = r4.f28204b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006f, code lost:
        r5.b(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0085, code lost:
        if (r2 > 8) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (r4.f28204b.e() == false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        r4.f28206d[8 - r2].b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b7, code lost:
        if (r2 > 8) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        if (r4.f28204b.e() == false) goto L_0x00cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c1, code lost:
        r4.f28206d[8 - r2].a(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cb, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00e5, code lost:
        if (r2 > 8) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ed, code lost:
        if (r4.f28204b.e() == false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ef, code lost:
        r4.f28206d[8 - r2].c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f8, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0107, code lost:
        r4.f28207e = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r5) {
        /*
            r4 = this;
            r0 = 16
            r1 = 8
            r2 = 1
            switch(r5) {
                case 128: goto L_0x00fb;
                case 129: goto L_0x00fb;
                case 130: goto L_0x00fb;
                case 131: goto L_0x00fb;
                case 132: goto L_0x00fb;
                case 133: goto L_0x00fb;
                case 134: goto L_0x00fb;
                case 135: goto L_0x00fb;
                case 136: goto L_0x00e5;
                case 137: goto L_0x00ce;
                case 138: goto L_0x00b7;
                case 139: goto L_0x009b;
                case 140: goto L_0x0085;
                case 141: goto L_0x007e;
                case 142: goto L_0x0109;
                case 143: goto L_0x0079;
                case 144: goto L_0x0065;
                case 145: goto L_0x0053;
                case 146: goto L_0x0045;
                case 147: goto L_0x0008;
                case 148: goto L_0x0008;
                case 149: goto L_0x0008;
                case 150: goto L_0x0008;
                case 151: goto L_0x0033;
                case 152: goto L_0x0022;
                case 153: goto L_0x0022;
                case 154: goto L_0x0022;
                case 155: goto L_0x0022;
                case 156: goto L_0x0022;
                case 157: goto L_0x0022;
                case 158: goto L_0x0022;
                case 159: goto L_0x0022;
                default: goto L_0x0008;
            }
        L_0x0008:
            r0 = 31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Invalid C1 command: "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String r0 = "Cea708Decoder"
            com.google.android.exoplayer2.util.k.c(r0, r5)
            goto L_0x0109
        L_0x0022:
            int r5 = r5 + -152
            r4.i(r5)
            int r0 = r4.f28211i
            if (r0 == r5) goto L_0x0109
            r4.f28211i = r5
            fw.c$a[] r0 = r4.f28206d
            r5 = r0[r5]
            goto L_0x0107
        L_0x0033:
            fw.c$a r5 = r4.f28207e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x0040
            com.google.android.exoplayer2.util.p r5 = r4.f28204b
            r0 = 32
            goto L_0x006f
        L_0x0040:
            r4.n()
            goto L_0x0109
        L_0x0045:
            fw.c$a r5 = r4.f28207e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x004e
            goto L_0x006d
        L_0x004e:
            r4.m()
            goto L_0x0109
        L_0x0053:
            fw.c$a r5 = r4.f28207e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x0060
            com.google.android.exoplayer2.util.p r5 = r4.f28204b
            r0 = 24
            goto L_0x006f
        L_0x0060:
            r4.l()
            goto L_0x0109
        L_0x0065:
            fw.c$a r5 = r4.f28207e
            boolean r5 = r5.d()
            if (r5 != 0) goto L_0x0074
        L_0x006d:
            com.google.android.exoplayer2.util.p r5 = r4.f28204b
        L_0x006f:
            r5.b(r0)
            goto L_0x0109
        L_0x0074:
            r4.k()
            goto L_0x0109
        L_0x0079:
            r4.p()
            goto L_0x0109
        L_0x007e:
            com.google.android.exoplayer2.util.p r5 = r4.f28204b
            r5.b(r1)
            goto L_0x0109
        L_0x0085:
            if (r2 > r1) goto L_0x0109
            com.google.android.exoplayer2.util.p r5 = r4.f28204b
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x0098
            fw.c$a[] r5 = r4.f28206d
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.b()
        L_0x0098:
            int r2 = r2 + 1
            goto L_0x0085
        L_0x009b:
            r5 = 1
        L_0x009c:
            if (r5 > r1) goto L_0x0109
            com.google.android.exoplayer2.util.p r0 = r4.f28204b
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00b4
            fw.c$a[] r0 = r4.f28206d
            int r3 = 8 - r5
            r0 = r0[r3]
            boolean r3 = r0.e()
            r3 = r3 ^ r2
            r0.a((boolean) r3)
        L_0x00b4:
            int r5 = r5 + 1
            goto L_0x009c
        L_0x00b7:
            if (r2 > r1) goto L_0x0109
            com.google.android.exoplayer2.util.p r5 = r4.f28204b
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x00cb
            fw.c$a[] r5 = r4.f28206d
            int r0 = 8 - r2
            r5 = r5[r0]
            r0 = 0
            r5.a((boolean) r0)
        L_0x00cb:
            int r2 = r2 + 1
            goto L_0x00b7
        L_0x00ce:
            r5 = 1
        L_0x00cf:
            if (r5 > r1) goto L_0x0109
            com.google.android.exoplayer2.util.p r0 = r4.f28204b
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x00e2
            fw.c$a[] r0 = r4.f28206d
            int r3 = 8 - r5
            r0 = r0[r3]
            r0.a((boolean) r2)
        L_0x00e2:
            int r5 = r5 + 1
            goto L_0x00cf
        L_0x00e5:
            if (r2 > r1) goto L_0x0109
            com.google.android.exoplayer2.util.p r5 = r4.f28204b
            boolean r5 = r5.e()
            if (r5 == 0) goto L_0x00f8
            fw.c$a[] r5 = r4.f28206d
            int r0 = 8 - r2
            r5 = r5[r0]
            r5.c()
        L_0x00f8:
            int r2 = r2 + 1
            goto L_0x00e5
        L_0x00fb:
            int r5 = r5 + -128
            int r0 = r4.f28211i
            if (r0 == r5) goto L_0x0109
            r4.f28211i = r5
            fw.c$a[] r0 = r4.f28206d
            r5 = r0[r5]
        L_0x0107:
            r4.f28207e = r5
        L_0x0109:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fw.c.b(int):void");
    }

    private void c(int i2) {
        p pVar;
        int i3;
        if (i2 > 7) {
            if (i2 <= 15) {
                pVar = this.f28204b;
                i3 = 8;
            } else if (i2 <= 23) {
                pVar = this.f28204b;
                i3 = 16;
            } else if (i2 <= 31) {
                pVar = this.f28204b;
                i3 = 24;
            } else {
                return;
            }
            pVar.b(i3);
        }
    }

    private void d(int i2) {
        p pVar;
        int i3;
        if (i2 <= 135) {
            pVar = this.f28204b;
            i3 = 32;
        } else if (i2 <= 143) {
            pVar = this.f28204b;
            i3 = 40;
        } else if (i2 <= 159) {
            this.f28204b.b(2);
            this.f28204b.b(this.f28204b.c(6) * 8);
            return;
        } else {
            return;
        }
        pVar.b(i3);
    }

    private void e(int i2) {
        if (i2 == 127) {
            this.f28207e.a(9835);
        } else {
            this.f28207e.a((char) (i2 & 255));
        }
    }

    private void f(int i2) {
        this.f28207e.a((char) (i2 & 255));
    }

    private void g(int i2) {
        a aVar;
        char c2 = ' ';
        if (i2 == 32) {
            aVar = this.f28207e;
        } else if (i2 == 33) {
            aVar = this.f28207e;
            c2 = 160;
        } else if (i2 == 37) {
            aVar = this.f28207e;
            c2 = 8230;
        } else if (i2 == 42) {
            aVar = this.f28207e;
            c2 = 352;
        } else if (i2 == 44) {
            aVar = this.f28207e;
            c2 = 338;
        } else if (i2 == 63) {
            aVar = this.f28207e;
            c2 = 376;
        } else if (i2 == 57) {
            aVar = this.f28207e;
            c2 = 8482;
        } else if (i2 == 58) {
            aVar = this.f28207e;
            c2 = 353;
        } else if (i2 == 60) {
            aVar = this.f28207e;
            c2 = 339;
        } else if (i2 != 61) {
            switch (i2) {
                case 48:
                    aVar = this.f28207e;
                    c2 = 9608;
                    break;
                case 49:
                    aVar = this.f28207e;
                    c2 = 8216;
                    break;
                case 50:
                    aVar = this.f28207e;
                    c2 = 8217;
                    break;
                case 51:
                    aVar = this.f28207e;
                    c2 = 8220;
                    break;
                case 52:
                    aVar = this.f28207e;
                    c2 = 8221;
                    break;
                case 53:
                    aVar = this.f28207e;
                    c2 = 8226;
                    break;
                default:
                    switch (i2) {
                        case 118:
                            aVar = this.f28207e;
                            c2 = 8539;
                            break;
                        case 119:
                            aVar = this.f28207e;
                            c2 = 8540;
                            break;
                        case 120:
                            aVar = this.f28207e;
                            c2 = 8541;
                            break;
                        case 121:
                            aVar = this.f28207e;
                            c2 = 8542;
                            break;
                        case 122:
                            aVar = this.f28207e;
                            c2 = 9474;
                            break;
                        case 123:
                            aVar = this.f28207e;
                            c2 = 9488;
                            break;
                        case 124:
                            aVar = this.f28207e;
                            c2 = 9492;
                            break;
                        case 125:
                            aVar = this.f28207e;
                            c2 = 9472;
                            break;
                        case 126:
                            aVar = this.f28207e;
                            c2 = 9496;
                            break;
                        case 127:
                            aVar = this.f28207e;
                            c2 = 9484;
                            break;
                        default:
                            StringBuilder sb = new StringBuilder(33);
                            sb.append("Invalid G2 character: ");
                            sb.append(i2);
                            k.c("Cea708Decoder", sb.toString());
                            return;
                    }
            }
        } else {
            aVar = this.f28207e;
            c2 = 8480;
        }
        aVar.a(c2);
    }

    private void h(int i2) {
        a aVar;
        char c2;
        if (i2 == 160) {
            aVar = this.f28207e;
            c2 = 13252;
        } else {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Invalid G3 character: ");
            sb.append(i2);
            k.c("Cea708Decoder", sb.toString());
            aVar = this.f28207e;
            c2 = '_';
        }
        aVar.a(c2);
    }

    private void i() {
        if (this.f28210h != null) {
            j();
            this.f28210h = null;
        }
    }

    private void i(int i2) {
        a aVar = this.f28206d[i2];
        this.f28204b.b(2);
        boolean e2 = this.f28204b.e();
        boolean e3 = this.f28204b.e();
        boolean e4 = this.f28204b.e();
        int c2 = this.f28204b.c(3);
        boolean e5 = this.f28204b.e();
        int c3 = this.f28204b.c(7);
        int c4 = this.f28204b.c(8);
        int c5 = this.f28204b.c(4);
        int c6 = this.f28204b.c(4);
        this.f28204b.b(2);
        int c7 = this.f28204b.c(6);
        this.f28204b.b(2);
        aVar.a(e2, e3, e4, c2, e5, c3, c4, c6, c7, c5, this.f28204b.c(3), this.f28204b.c(3));
    }

    private void j() {
        StringBuilder sb;
        String str;
        if (this.f28210h.f28241d != (this.f28210h.f28239b * 2) - 1) {
            int i2 = this.f28210h.f28241d;
            int i3 = this.f28210h.f28238a;
            StringBuilder sb2 = new StringBuilder(IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED);
            sb2.append("DtvCcPacket ended prematurely; size is ");
            sb2.append((this.f28210h.f28239b * 2) - 1);
            sb2.append(", but current index is ");
            sb2.append(i2);
            sb2.append(" (sequence number ");
            sb2.append(i3);
            sb2.append("); ignoring packet");
            k.c("Cea708Decoder", sb2.toString());
            return;
        }
        this.f28204b.a(this.f28210h.f28240c, this.f28210h.f28241d);
        int c2 = this.f28204b.c(3);
        int c3 = this.f28204b.c(5);
        if (c2 == 7) {
            this.f28204b.b(2);
            c2 = this.f28204b.c(6);
            if (c2 < 7) {
                StringBuilder sb3 = new StringBuilder(44);
                sb3.append("Invalid extended service number: ");
                sb3.append(c2);
                k.c("Cea708Decoder", sb3.toString());
            }
        }
        if (c3 == 0) {
            if (c2 != 0) {
                StringBuilder sb4 = new StringBuilder(59);
                sb4.append("serviceNumber is non-zero (");
                sb4.append(c2);
                sb4.append(") when blockSize is 0");
                k.c("Cea708Decoder", sb4.toString());
            }
        } else if (c2 == this.f28205c) {
            boolean z2 = false;
            while (this.f28204b.a() > 0) {
                int c4 = this.f28204b.c(8);
                if (c4 == 16) {
                    c4 = this.f28204b.c(8);
                    if (c4 <= 31) {
                        c(c4);
                    } else if (c4 <= 127) {
                        g(c4);
                    } else if (c4 <= 159) {
                        d(c4);
                    } else if (c4 <= 255) {
                        h(c4);
                    } else {
                        sb = new StringBuilder(37);
                        str = "Invalid extended command: ";
                        sb.append(str);
                        sb.append(c4);
                        k.c("Cea708Decoder", sb.toString());
                    }
                } else if (c4 <= 31) {
                    a(c4);
                } else if (c4 <= 127) {
                    e(c4);
                } else if (c4 <= 159) {
                    b(c4);
                } else if (c4 <= 255) {
                    f(c4);
                } else {
                    sb = new StringBuilder(33);
                    str = "Invalid base command: ";
                    sb.append(str);
                    sb.append(c4);
                    k.c("Cea708Decoder", sb.toString());
                }
                z2 = true;
            }
            if (z2) {
                this.f28208f = o();
            }
        }
    }

    private void k() {
        this.f28207e.a(this.f28204b.c(4), this.f28204b.c(2), this.f28204b.c(2), this.f28204b.e(), this.f28204b.e(), this.f28204b.c(3), this.f28204b.c(3));
    }

    private void l() {
        int a2 = a.a(this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2));
        int a3 = a.a(this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2));
        this.f28204b.b(2);
        this.f28207e.a(a2, a3, a.b(this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2)));
    }

    private void m() {
        this.f28204b.b(4);
        int c2 = this.f28204b.c(4);
        this.f28204b.b(2);
        this.f28207e.a(c2, this.f28204b.c(6));
    }

    private void n() {
        int a2 = a.a(this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2));
        int c2 = this.f28204b.c(2);
        int b2 = a.b(this.f28204b.c(2), this.f28204b.c(2), this.f28204b.c(2));
        if (this.f28204b.e()) {
            c2 |= 4;
        }
        boolean e2 = this.f28204b.e();
        int c3 = this.f28204b.c(2);
        int c4 = this.f28204b.c(2);
        int c5 = this.f28204b.c(2);
        this.f28204b.b(8);
        this.f28207e.a(a2, b2, e2, c2, c3, c4, c5);
    }

    private List<com.google.android.exoplayer2.text.b> o() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            if (!this.f28206d[i2].a() && this.f28206d[i2].e()) {
                arrayList.add(this.f28206d[i2].h());
            }
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void p() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f28206d[i2].b();
        }
    }

    public /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) {
        this.f28203a.a(hVar.f13099b.array(), hVar.f13099b.limit());
        while (this.f28203a.b() >= 3) {
            int h2 = this.f28203a.h() & 7;
            int i2 = h2 & 3;
            boolean z2 = false;
            boolean z3 = (h2 & 4) == 4;
            byte h3 = (byte) this.f28203a.h();
            byte h4 = (byte) this.f28203a.h();
            if ((i2 == 2 || i2 == 3) && z3) {
                if (i2 == 3) {
                    i();
                    int i3 = (h3 & 192) >> 6;
                    byte b2 = h3 & 63;
                    if (b2 == 0) {
                        b2 = 64;
                    }
                    b bVar = new b(i3, b2);
                    this.f28210h = bVar;
                    byte[] bArr = bVar.f28240c;
                    b bVar2 = this.f28210h;
                    int i4 = bVar2.f28241d;
                    bVar2.f28241d = i4 + 1;
                    bArr[i4] = h4;
                } else {
                    if (i2 == 2) {
                        z2 = true;
                    }
                    com.google.android.exoplayer2.util.a.a(z2);
                    b bVar3 = this.f28210h;
                    if (bVar3 == null) {
                        k.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                    } else {
                        byte[] bArr2 = bVar3.f28240c;
                        b bVar4 = this.f28210h;
                        int i5 = bVar4.f28241d;
                        bVar4.f28241d = i5 + 1;
                        bArr2[i5] = h3;
                        byte[] bArr3 = this.f28210h.f28240c;
                        b bVar5 = this.f28210h;
                        int i6 = bVar5.f28241d;
                        bVar5.f28241d = i6 + 1;
                        bArr3[i6] = h4;
                    }
                }
                if (this.f28210h.f28241d == (this.f28210h.f28239b * 2) - 1) {
                    i();
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ void b(h hVar) throws SubtitleDecoderException {
        super.a(hVar);
    }

    public void c() {
        super.c();
        this.f28208f = null;
        this.f28209g = null;
        this.f28211i = 0;
        this.f28207e = this.f28206d[0];
        p();
        this.f28210h = null;
    }

    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return this.f28208f != this.f28209g;
    }

    /* access modifiers changed from: protected */
    public e f() {
        List<com.google.android.exoplayer2.text.b> list = this.f28208f;
        this.f28209g = list;
        return new f(list);
    }

    public /* bridge */ /* synthetic */ i g() throws SubtitleDecoderException {
        return super.b();
    }

    public /* bridge */ /* synthetic */ h h() throws SubtitleDecoderException {
        return super.a();
    }
}
