package fw;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.text.h;
import com.google.android.exoplayer2.text.i;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f28167a = {11, 1, 3, 12, 14, 5, 7, 9};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f28168b = {0, 4, 8, 12, 16, 20, 24, 28};
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f28169c = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f28170d = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f28171e = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 251};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f28172f = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f28173g = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};

    /* renamed from: h  reason: collision with root package name */
    private static final boolean[] f28174h = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: i  reason: collision with root package name */
    private final q f28175i = new q();

    /* renamed from: j  reason: collision with root package name */
    private final int f28176j;

    /* renamed from: k  reason: collision with root package name */
    private final int f28177k;

    /* renamed from: l  reason: collision with root package name */
    private final int f28178l;

    /* renamed from: m  reason: collision with root package name */
    private final ArrayList<C0179a> f28179m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    private C0179a f28180n = new C0179a(0, 4);

    /* renamed from: o  reason: collision with root package name */
    private List<b> f28181o;

    /* renamed from: p  reason: collision with root package name */
    private List<b> f28182p;

    /* renamed from: q  reason: collision with root package name */
    private int f28183q;

    /* renamed from: r  reason: collision with root package name */
    private int f28184r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f28185s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f28186t;

    /* renamed from: u  reason: collision with root package name */
    private byte f28187u;

    /* renamed from: v  reason: collision with root package name */
    private byte f28188v;

    /* renamed from: w  reason: collision with root package name */
    private int f28189w = 0;

    /* renamed from: x  reason: collision with root package name */
    private boolean f28190x;

    /* renamed from: fw.a$a  reason: collision with other inner class name */
    private static class C0179a {

        /* renamed from: a  reason: collision with root package name */
        private final List<C0180a> f28191a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<SpannableString> f28192b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final StringBuilder f28193c = new StringBuilder();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f28194d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f28195e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f28196f;

        /* renamed from: g  reason: collision with root package name */
        private int f28197g;

        /* renamed from: h  reason: collision with root package name */
        private int f28198h;

        /* renamed from: fw.a$a$a  reason: collision with other inner class name */
        private static class C0180a {

            /* renamed from: a  reason: collision with root package name */
            public final int f28199a;

            /* renamed from: b  reason: collision with root package name */
            public final boolean f28200b;

            /* renamed from: c  reason: collision with root package name */
            public int f28201c;

            public C0180a(int i2, boolean z2, int i3) {
                this.f28199a = i2;
                this.f28200b = z2;
                this.f28201c = i3;
            }
        }

        public C0179a(int i2, int i3) {
            a(i2);
            c(i3);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
        }

        private static void a(SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
            if (i4 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i2, i3, 33);
            }
        }

        private static void b(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i2, i3, 33);
        }

        private SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f28193c);
            int length = spannableStringBuilder.length();
            int i2 = 0;
            int i3 = -1;
            int i4 = -1;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            boolean z2 = false;
            while (i2 < this.f28191a.size()) {
                C0180a aVar = this.f28191a.get(i2);
                boolean z3 = aVar.f28200b;
                int i8 = aVar.f28199a;
                if (i8 != 8) {
                    boolean z4 = i8 == 7;
                    if (i8 != 7) {
                        i7 = a.f28169c[i8];
                    }
                    z2 = z4;
                }
                int i9 = aVar.f28201c;
                i2++;
                if (i9 != (i2 < this.f28191a.size() ? this.f28191a.get(i2).f28201c : length)) {
                    if (i3 != -1 && !z3) {
                        a(spannableStringBuilder, i3, i9);
                        i3 = -1;
                    } else if (i3 == -1 && z3) {
                        i3 = i9;
                    }
                    if (i4 != -1 && !z2) {
                        b(spannableStringBuilder, i4, i9);
                        i4 = -1;
                    } else if (i4 == -1 && z2) {
                        i4 = i9;
                    }
                    if (i7 != i6) {
                        a(spannableStringBuilder, i5, i9, i6);
                        i6 = i7;
                        i5 = i9;
                    }
                }
            }
            if (!(i3 == -1 || i3 == length)) {
                a(spannableStringBuilder, i3, length);
            }
            if (!(i4 == -1 || i4 == length)) {
                b(spannableStringBuilder, i4, length);
            }
            if (i5 != length) {
                a(spannableStringBuilder, i5, length, i6);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void a(char c2) {
            this.f28193c.append(c2);
        }

        public void a(int i2) {
            this.f28197g = i2;
            this.f28191a.clear();
            this.f28192b.clear();
            this.f28193c.setLength(0);
            this.f28194d = 15;
            this.f28195e = 0;
            this.f28196f = 0;
        }

        public void a(int i2, boolean z2) {
            this.f28191a.add(new C0180a(i2, z2, this.f28193c.length()));
        }

        public boolean a() {
            return this.f28191a.isEmpty() && this.f28192b.isEmpty() && this.f28193c.length() == 0;
        }

        public void b() {
            int length = this.f28193c.length();
            if (length > 0) {
                this.f28193c.delete(length - 1, length);
                int size = this.f28191a.size() - 1;
                while (size >= 0) {
                    C0180a aVar = this.f28191a.get(size);
                    if (aVar.f28201c == length) {
                        aVar.f28201c--;
                        size--;
                    } else {
                        return;
                    }
                }
            }
        }

        public void b(int i2) {
            this.f28197g = i2;
        }

        public void c() {
            this.f28192b.add(d());
            this.f28193c.setLength(0);
            this.f28191a.clear();
            int min = Math.min(this.f28198h, this.f28194d);
            while (this.f28192b.size() >= min) {
                this.f28192b.remove(0);
            }
        }

        public void c(int i2) {
            this.f28198h = i2;
        }

        public b d(int i2) {
            float f2;
            int i3;
            int i4;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i5 = 0; i5 < this.f28192b.size(); i5++) {
                spannableStringBuilder.append(this.f28192b.get(i5));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(d());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i6 = this.f28195e + this.f28196f;
            int length = (32 - i6) - spannableStringBuilder.length();
            int i7 = i6 - length;
            if (i2 == Integer.MIN_VALUE) {
                i2 = (this.f28197g != 2 || (Math.abs(i7) >= 3 && length >= 0)) ? (this.f28197g != 2 || i7 <= 0) ? 0 : 2 : 1;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i6 = 32 - length;
                }
                f2 = ((((float) i6) / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            if (this.f28197g == 1 || (i4 = this.f28194d) > 7) {
                i4 = (this.f28194d - 15) - 2;
                i3 = 2;
            } else {
                i3 = 0;
            }
            return new b(spannableStringBuilder, Layout.Alignment.ALIGN_NORMAL, (float) i4, 1, i3, f2, i2, -3.4028235E38f);
        }
    }

    public a(String str, int i2) {
        this.f28176j = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    this.f28178l = 0;
                } else if (i2 != 4) {
                    k.c("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                } else {
                    this.f28178l = 1;
                }
                this.f28177k = 1;
                a(0);
                k();
                this.f28190x = true;
            }
            this.f28178l = 1;
            this.f28177k = 0;
            a(0);
            k();
            this.f28190x = true;
        }
        this.f28178l = 0;
        this.f28177k = 0;
        a(0);
        k();
        this.f28190x = true;
    }

    private void a(byte b2, byte b3) {
        int i2 = f28167a[b2 & 7];
        boolean z2 = false;
        if ((b3 & 32) != 0) {
            i2++;
        }
        if (i2 != this.f28180n.f28194d) {
            if (this.f28183q != 1 && !this.f28180n.a()) {
                C0179a aVar = new C0179a(this.f28183q, this.f28184r);
                this.f28180n = aVar;
                this.f28179m.add(aVar);
            }
            int unused = this.f28180n.f28194d = i2;
        }
        boolean z3 = (b3 & 16) == 16;
        if ((b3 & 1) == 1) {
            z2 = true;
        }
        int i3 = (b3 >> 1) & 7;
        this.f28180n.a(z3 ? 8 : i3, z2);
        if (z3) {
            int unused2 = this.f28180n.f28195e = f28168b[i3];
        }
    }

    private void a(int i2) {
        int i3 = this.f28183q;
        if (i3 != i2) {
            this.f28183q = i2;
            if (i2 == 3) {
                for (int i4 = 0; i4 < this.f28179m.size(); i4++) {
                    this.f28179m.get(i4).b(i2);
                }
                return;
            }
            k();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.f28181o = Collections.emptyList();
            }
        }
    }

    private boolean a(byte b2) {
        if (h(b2)) {
            this.f28189w = i(b2);
        }
        return this.f28189w == this.f28178l;
    }

    private boolean a(boolean z2, byte b2, byte b3) {
        if (!z2 || !j(b2)) {
            this.f28186t = false;
        } else if (this.f28186t && this.f28187u == b2 && this.f28188v == b3) {
            this.f28186t = false;
            return true;
        } else {
            this.f28186t = true;
            this.f28187u = b2;
            this.f28188v = b3;
        }
        return false;
    }

    private void b(byte b2) {
        this.f28180n.a(' ');
        this.f28180n.a((b2 >> 1) & 7, (b2 & 1) == 1);
    }

    private void b(byte b2, byte b3) {
        if (!k(b2)) {
            if (l(b2)) {
                if (!(b3 == 32 || b3 == 47)) {
                    switch (b3) {
                        case 37:
                        case 38:
                        case 39:
                            break;
                        default:
                            switch (b3) {
                                case 41:
                                    break;
                                case 42:
                                case 43:
                                    break;
                                default:
                                    return;
                            }
                    }
                }
                this.f28190x = true;
                return;
            }
            return;
        }
        this.f28190x = false;
    }

    private void b(int i2) {
        this.f28184r = i2;
        this.f28180n.c(i2);
    }

    private void c(byte b2) {
        if (b2 == 32) {
            a(2);
        } else if (b2 != 41) {
            switch (b2) {
                case 37:
                    a(1);
                    b(2);
                    return;
                case 38:
                    a(1);
                    b(3);
                    return;
                case 39:
                    a(1);
                    b(4);
                    return;
                default:
                    int i2 = this.f28183q;
                    if (i2 != 0) {
                        if (b2 != 33) {
                            switch (b2) {
                                case 44:
                                    this.f28181o = Collections.emptyList();
                                    int i3 = this.f28183q;
                                    if (!(i3 == 1 || i3 == 3)) {
                                        return;
                                    }
                                case 45:
                                    if (i2 == 1 && !this.f28180n.a()) {
                                        this.f28180n.c();
                                        return;
                                    }
                                    return;
                                case 46:
                                    break;
                                case 47:
                                    this.f28181o = j();
                                    break;
                                default:
                                    return;
                            }
                            k();
                            return;
                        }
                        this.f28180n.b();
                        return;
                    }
                    return;
            }
        } else {
            a(3);
        }
    }

    private static boolean c(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 48;
    }

    private static char d(byte b2) {
        return (char) f28170d[(b2 & Byte.MAX_VALUE) - 32];
    }

    private static boolean d(byte b2, byte b3) {
        return (b2 & 246) == 18 && (b3 & 224) == 32;
    }

    private static char e(byte b2) {
        return (char) f28171e[b2 & 15];
    }

    private static char e(byte b2, byte b3) {
        return (b2 & 1) == 0 ? f(b3) : g(b3);
    }

    private static char f(byte b2) {
        return (char) f28172f[b2 & 31];
    }

    private static boolean f(byte b2, byte b3) {
        return (b2 & 247) == 17 && (b3 & 240) == 32;
    }

    private static char g(byte b2) {
        return (char) f28173g[b2 & 31];
    }

    private static boolean g(byte b2, byte b3) {
        return (b2 & 240) == 16 && (b3 & 192) == 64;
    }

    private static boolean h(byte b2) {
        return (b2 & 224) == 0;
    }

    private static boolean h(byte b2, byte b3) {
        return (b2 & 247) == 23 && b3 >= 33 && b3 <= 35;
    }

    private static int i(byte b2) {
        return (b2 >> 3) & 1;
    }

    private static boolean i(byte b2, byte b3) {
        return (b2 & 246) == 20 && (b3 & 240) == 32;
    }

    private List<b> j() {
        int size = this.f28179m.size();
        ArrayList arrayList = new ArrayList(size);
        int i2 = 2;
        for (int i3 = 0; i3 < size; i3++) {
            b d2 = this.f28179m.get(i3).d(Integer.MIN_VALUE);
            arrayList.add(d2);
            if (d2 != null) {
                i2 = Math.min(i2, d2.f16592i);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = (b) arrayList.get(i4);
            if (bVar != null) {
                if (bVar.f16592i != i2) {
                    bVar = this.f28179m.get(i4).d(i2);
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    private static boolean j(byte b2) {
        return (b2 & 240) == 16;
    }

    private void k() {
        this.f28180n.a(this.f28183q);
        this.f28179m.clear();
        this.f28179m.add(this.f28180n);
    }

    private static boolean k(byte b2) {
        return 1 <= b2 && b2 <= 15;
    }

    private static boolean l(byte b2) {
        return (b2 & 247) == 20;
    }

    public /* bridge */ /* synthetic */ void a(long j2) {
        super.a(j2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0014 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.google.android.exoplayer2.text.h r10) {
        /*
            r9 = this;
            com.google.android.exoplayer2.util.q r0 = r9.f28175i
            java.nio.ByteBuffer r1 = r10.f13099b
            byte[] r1 = r1.array()
            java.nio.ByteBuffer r10 = r10.f13099b
            int r10 = r10.limit()
            r0.a((byte[]) r1, (int) r10)
            r10 = 0
            r0 = 1
            r1 = 0
        L_0x0014:
            com.google.android.exoplayer2.util.q r2 = r9.f28175i
            int r2 = r2.b()
            int r3 = r9.f28176j
            if (r2 < r3) goto L_0x00ec
            r2 = 2
            if (r3 != r2) goto L_0x0023
            r2 = -4
            goto L_0x002a
        L_0x0023:
            com.google.android.exoplayer2.util.q r2 = r9.f28175i
            int r2 = r2.h()
            byte r2 = (byte) r2
        L_0x002a:
            com.google.android.exoplayer2.util.q r3 = r9.f28175i
            int r3 = r3.h()
            com.google.android.exoplayer2.util.q r4 = r9.f28175i
            int r4 = r4.h()
            r5 = r2 & 2
            if (r5 == 0) goto L_0x003b
            goto L_0x0014
        L_0x003b:
            r5 = r2 & 1
            int r6 = r9.f28177k
            if (r5 == r6) goto L_0x0042
            goto L_0x0014
        L_0x0042:
            r5 = r3 & 127(0x7f, float:1.78E-43)
            byte r5 = (byte) r5
            r6 = r4 & 127(0x7f, float:1.78E-43)
            byte r6 = (byte) r6
            if (r5 != 0) goto L_0x004d
            if (r6 != 0) goto L_0x004d
            goto L_0x0014
        L_0x004d:
            boolean r7 = r9.f28185s
            r2 = r2 & 4
            r8 = 4
            if (r2 != r8) goto L_0x0060
            boolean[] r2 = f28174h
            boolean r3 = r2[r3]
            if (r3 == 0) goto L_0x0060
            boolean r2 = r2[r4]
            if (r2 == 0) goto L_0x0060
            r2 = 1
            goto L_0x0061
        L_0x0060:
            r2 = 0
        L_0x0061:
            r9.f28185s = r2
            boolean r2 = r9.a(r2, r5, r6)
            if (r2 == 0) goto L_0x006a
            goto L_0x0014
        L_0x006a:
            boolean r2 = r9.f28185s
            if (r2 != 0) goto L_0x0075
            if (r7 == 0) goto L_0x0014
            r9.k()
        L_0x0073:
            r1 = 1
            goto L_0x0014
        L_0x0075:
            r9.b(r5, r6)
            boolean r2 = r9.f28190x
            if (r2 != 0) goto L_0x007d
            goto L_0x0014
        L_0x007d:
            boolean r2 = r9.a((byte) r5)
            if (r2 != 0) goto L_0x0084
            goto L_0x0014
        L_0x0084:
            boolean r1 = h(r5)
            if (r1 == 0) goto L_0x00d5
            boolean r1 = c(r5, r6)
            if (r1 == 0) goto L_0x0097
            fw.a$a r1 = r9.f28180n
            char r2 = e(r6)
            goto L_0x00e8
        L_0x0097:
            boolean r1 = d(r5, r6)
            if (r1 == 0) goto L_0x00a9
            fw.a$a r1 = r9.f28180n
            r1.b()
            fw.a$a r1 = r9.f28180n
            char r2 = e(r5, r6)
            goto L_0x00e8
        L_0x00a9:
            boolean r1 = f(r5, r6)
            if (r1 == 0) goto L_0x00b3
            r9.b((byte) r6)
            goto L_0x0073
        L_0x00b3:
            boolean r1 = g(r5, r6)
            if (r1 == 0) goto L_0x00bd
            r9.a(r5, r6)
            goto L_0x0073
        L_0x00bd:
            boolean r1 = h(r5, r6)
            if (r1 == 0) goto L_0x00cb
            fw.a$a r1 = r9.f28180n
            int r6 = r6 + -32
            int unused = r1.f28196f = r6
            goto L_0x0073
        L_0x00cb:
            boolean r1 = i(r5, r6)
            if (r1 == 0) goto L_0x0073
            r9.c(r6)
            goto L_0x0073
        L_0x00d5:
            fw.a$a r1 = r9.f28180n
            char r2 = d(r5)
            r1.a((char) r2)
            r1 = r6 & 224(0xe0, float:3.14E-43)
            if (r1 == 0) goto L_0x0073
            fw.a$a r1 = r9.f28180n
            char r2 = d(r6)
        L_0x00e8:
            r1.a((char) r2)
            goto L_0x0073
        L_0x00ec:
            if (r1 == 0) goto L_0x00fb
            int r10 = r9.f28183q
            if (r10 == r0) goto L_0x00f5
            r0 = 3
            if (r10 != r0) goto L_0x00fb
        L_0x00f5:
            java.util.List r10 = r9.j()
            r9.f28181o = r10
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fw.a.a(com.google.android.exoplayer2.text.h):void");
    }

    public /* bridge */ /* synthetic */ void b(h hVar) throws SubtitleDecoderException {
        super.a(hVar);
    }

    public void c() {
        super.c();
        this.f28181o = null;
        this.f28182p = null;
        a(0);
        b(4);
        k();
        this.f28185s = false;
        this.f28186t = false;
        this.f28187u = 0;
        this.f28188v = 0;
        this.f28189w = 0;
        this.f28190x = true;
    }

    public void d() {
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return this.f28181o != this.f28182p;
    }

    /* access modifiers changed from: protected */
    public e f() {
        List<b> list = this.f28181o;
        this.f28182p = list;
        return new f(list);
    }

    public /* bridge */ /* synthetic */ i g() throws SubtitleDecoderException {
        return super.b();
    }

    public /* bridge */ /* synthetic */ h h() throws SubtitleDecoderException {
        return super.a();
    }
}
