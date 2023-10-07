package fm;

import android.util.Pair;
import android.util.SparseArray;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.blankj.utilcode.constant.CacheConstants;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.s;
import fj.u;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class d implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27487a = $$Lambda$d$gJF9UJtNKcMa7H6JT5NtnWBj0vQ.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f27488b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f27489c = ad.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f27490d = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final UUID f27491e = new UUID(72057594037932032L, -9223371306706625679L);
    private boolean A;
    private int B;
    private long C;
    private boolean D;
    private long E;
    private long F;
    private long G;
    private l H;
    private l I;
    private boolean J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private int[] Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private int W;
    private int X;
    private int Y;
    private boolean Z;

    /* renamed from: aa  reason: collision with root package name */
    private boolean f27492aa;

    /* renamed from: ab  reason: collision with root package name */
    private boolean f27493ab;

    /* renamed from: ac  reason: collision with root package name */
    private int f27494ac;

    /* renamed from: ad  reason: collision with root package name */
    private byte f27495ad;

    /* renamed from: ae  reason: collision with root package name */
    private boolean f27496ae;

    /* renamed from: af  reason: collision with root package name */
    private i f27497af;

    /* renamed from: f  reason: collision with root package name */
    private final c f27498f;

    /* renamed from: g  reason: collision with root package name */
    private final f f27499g;

    /* renamed from: h  reason: collision with root package name */
    private final SparseArray<b> f27500h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f27501i;

    /* renamed from: j  reason: collision with root package name */
    private final q f27502j;

    /* renamed from: k  reason: collision with root package name */
    private final q f27503k;

    /* renamed from: l  reason: collision with root package name */
    private final q f27504l;

    /* renamed from: m  reason: collision with root package name */
    private final q f27505m;

    /* renamed from: n  reason: collision with root package name */
    private final q f27506n;

    /* renamed from: o  reason: collision with root package name */
    private final q f27507o;

    /* renamed from: p  reason: collision with root package name */
    private final q f27508p;

    /* renamed from: q  reason: collision with root package name */
    private final q f27509q;

    /* renamed from: r  reason: collision with root package name */
    private final q f27510r;

    /* renamed from: s  reason: collision with root package name */
    private final q f27511s;

    /* renamed from: t  reason: collision with root package name */
    private ByteBuffer f27512t;

    /* renamed from: u  reason: collision with root package name */
    private long f27513u;

    /* renamed from: v  reason: collision with root package name */
    private long f27514v;

    /* renamed from: w  reason: collision with root package name */
    private long f27515w;

    /* renamed from: x  reason: collision with root package name */
    private long f27516x;

    /* renamed from: y  reason: collision with root package name */
    private long f27517y;

    /* renamed from: z  reason: collision with root package name */
    private b f27518z;

    private final class a implements b {
        private a() {
        }

        public int a(int i2) {
            return d.this.a(i2);
        }

        public void a(int i2, double d2) throws ParserException {
            d.this.a(i2, d2);
        }

        public void a(int i2, int i3, h hVar) throws IOException, InterruptedException {
            d.this.a(i2, i3, hVar);
        }

        public void a(int i2, long j2) throws ParserException {
            d.this.a(i2, j2);
        }

        public void a(int i2, long j2, long j3) throws ParserException {
            d.this.a(i2, j2, j3);
        }

        public void a(int i2, String str) throws ParserException {
            d.this.a(i2, str);
        }

        public boolean b(int i2) {
            return d.this.b(i2);
        }

        public void c(int i2) throws ParserException {
            d.this.c(i2);
        }
    }

    private static final class b {
        public int A;
        public int B;
        public float C;
        public float D;
        public float E;
        public float F;
        public float G;
        public float H;
        public float I;
        public float J;
        public float K;
        public float L;
        public int M;
        public int N;
        public int O;
        public long P;
        public long Q;
        public c R;
        public boolean S;
        public boolean T;
        public u U;
        public int V;
        /* access modifiers changed from: private */
        public String W;

        /* renamed from: a  reason: collision with root package name */
        public String f27520a;

        /* renamed from: b  reason: collision with root package name */
        public String f27521b;

        /* renamed from: c  reason: collision with root package name */
        public int f27522c;

        /* renamed from: d  reason: collision with root package name */
        public int f27523d;

        /* renamed from: e  reason: collision with root package name */
        public int f27524e;

        /* renamed from: f  reason: collision with root package name */
        public int f27525f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f27526g;

        /* renamed from: h  reason: collision with root package name */
        public byte[] f27527h;

        /* renamed from: i  reason: collision with root package name */
        public u.a f27528i;

        /* renamed from: j  reason: collision with root package name */
        public byte[] f27529j;

        /* renamed from: k  reason: collision with root package name */
        public DrmInitData f27530k;

        /* renamed from: l  reason: collision with root package name */
        public int f27531l;

        /* renamed from: m  reason: collision with root package name */
        public int f27532m;

        /* renamed from: n  reason: collision with root package name */
        public int f27533n;

        /* renamed from: o  reason: collision with root package name */
        public int f27534o;

        /* renamed from: p  reason: collision with root package name */
        public int f27535p;

        /* renamed from: q  reason: collision with root package name */
        public int f27536q;

        /* renamed from: r  reason: collision with root package name */
        public float f27537r;

        /* renamed from: s  reason: collision with root package name */
        public float f27538s;

        /* renamed from: t  reason: collision with root package name */
        public float f27539t;

        /* renamed from: u  reason: collision with root package name */
        public byte[] f27540u;

        /* renamed from: v  reason: collision with root package name */
        public int f27541v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f27542w;

        /* renamed from: x  reason: collision with root package name */
        public int f27543x;

        /* renamed from: y  reason: collision with root package name */
        public int f27544y;

        /* renamed from: z  reason: collision with root package name */
        public int f27545z;

        private b() {
            this.f27531l = -1;
            this.f27532m = -1;
            this.f27533n = -1;
            this.f27534o = -1;
            this.f27535p = 0;
            this.f27536q = -1;
            this.f27537r = 0.0f;
            this.f27538s = 0.0f;
            this.f27539t = 0.0f;
            this.f27540u = null;
            this.f27541v = -1;
            this.f27542w = false;
            this.f27543x = -1;
            this.f27544y = -1;
            this.f27545z = -1;
            this.A = 1000;
            this.B = 200;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = -1.0f;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = -1.0f;
            this.K = -1.0f;
            this.L = -1.0f;
            this.M = 1;
            this.N = -1;
            this.O = 8000;
            this.P = 0;
            this.Q = 0;
            this.T = true;
            this.W = "eng";
        }

        private static Pair<String, List<byte[]>> a(q qVar) throws ParserException {
            try {
                qVar.d(16);
                long o2 = qVar.o();
                if (o2 == 1482049860) {
                    return new Pair<>("video/divx", (Object) null);
                }
                if (o2 == 859189832) {
                    return new Pair<>("video/3gpp", (Object) null);
                }
                if (o2 == 826496599) {
                    byte[] bArr = qVar.f17159a;
                    for (int d2 = qVar.d() + 20; d2 < bArr.length - 4; d2++) {
                        if (bArr[d2] == 0 && bArr[d2 + 1] == 0 && bArr[d2 + 2] == 1 && bArr[d2 + 3] == 15) {
                            return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArr, d2, bArr.length)));
                        }
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
                com.google.android.exoplayer2.util.k.c("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair<>("video/x-unknown", (Object) null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC private data");
            }
        }

        private static List<byte[]> a(byte[] bArr) throws ParserException {
            try {
                if (bArr[0] == 2) {
                    int i2 = 1;
                    int i3 = 0;
                    while (bArr[i2] == -1) {
                        i3 += 255;
                        i2++;
                    }
                    int i4 = i2 + 1;
                    int i5 = i3 + bArr[i2];
                    int i6 = 0;
                    while (bArr[i4] == -1) {
                        i6 += 255;
                        i4++;
                    }
                    int i7 = i4 + 1;
                    int i8 = i6 + bArr[i4];
                    if (bArr[i7] == 1) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i7, bArr2, 0, i5);
                        int i9 = i7 + i5;
                        if (bArr[i9] == 3) {
                            int i10 = i9 + i8;
                            if (bArr[i10] == 5) {
                                byte[] bArr3 = new byte[(bArr.length - i10)];
                                System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                }
                throw new ParserException("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        private static boolean b(q qVar) throws ParserException {
            try {
                int j2 = qVar.j();
                if (j2 == 1) {
                    return true;
                }
                if (j2 != 65534) {
                    return false;
                }
                qVar.c(24);
                return qVar.r() == d.f27491e.getMostSignificantBits() && qVar.r() == d.f27491e.getLeastSignificantBits();
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private byte[] c() {
            if (this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            order.put((byte) 0);
            order.putShort((short) ((int) ((this.C * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.D * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.E * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.F * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.G * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.H * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.I * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) ((this.J * 50000.0f) + 0.5f)));
            order.putShort((short) ((int) (this.K + 0.5f)));
            order.putShort((short) ((int) (this.L + 0.5f)));
            order.putShort((short) this.A);
            order.putShort((short) this.B);
            return bArr;
        }

        public void a() {
            c cVar = this.R;
            if (cVar != null) {
                cVar.a(this);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v49, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: java.lang.String} */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0246, code lost:
            r4.append("Unsupported PCM bit depth: ");
            r4.append(r1);
            r4.append(". Setting mimeType to ");
            r4.append(r6);
            r1 = r4.toString();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0256, code lost:
            com.google.android.exoplayer2.util.k.c("MatroskaExtractor", r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x025a, code lost:
            r26 = r1;
            r6 = "audio/raw";
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x026b, code lost:
            r6 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x026d, code lost:
            r1 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x026f, code lost:
            r26 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0271, code lost:
            r31 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a5, code lost:
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x02a6, code lost:
            r6 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x02df, code lost:
            r6 = r16;
            r1 = null;
            r26 = -1;
            r31 = 4096;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:148:0x034d, code lost:
            r2 = r0.T | 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:149:0x0352, code lost:
            if (r0.S == false) goto L_0x0356;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:150:0x0354, code lost:
            r3 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:151:0x0356, code lost:
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x0357, code lost:
            r2 = r2 | r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:153:0x035c, code lost:
            if (com.google.android.exoplayer2.util.n.a(r6) == false) goto L_0x0384;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x035e, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r44), r6, (java.lang.String) null, -1, r31, r0.M, r0.O, r26, r1, r0.f27530k, (int) r2, r0.W);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0388, code lost:
            if (com.google.android.exoplayer2.util.n.b(r6) == false) goto L_0x048a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:158:0x038c, code lost:
            if (r0.f27535p != 0) goto L_0x03a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:159:0x038e, code lost:
            r2 = r0.f27533n;
            r3 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0391, code lost:
            if (r2 != -1) goto L_0x0395;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:161:0x0393, code lost:
            r2 = r0.f27531l;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:162:0x0395, code lost:
            r0.f27533n = r2;
            r2 = r0.f27534o;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:163:0x0399, code lost:
            if (r2 != -1) goto L_0x039d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:164:0x039b, code lost:
            r2 = r0.f27532m;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:165:0x039d, code lost:
            r0.f27534o = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:166:0x03a0, code lost:
            r3 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:167:0x03a1, code lost:
            r4 = r0.f27533n;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:168:0x03a5, code lost:
            if (r4 == r3) goto L_0x03b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:169:0x03a7, code lost:
            r5 = r0.f27534o;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:170:0x03a9, code lost:
            if (r5 == r3) goto L_0x03b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:171:0x03ab, code lost:
            r37 = ((float) (r0.f27532m * r4)) / ((float) (r0.f27531l * r5));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:172:0x03b9, code lost:
            r37 = -1.0f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:174:0x03bd, code lost:
            if (r0.f27542w == false) goto L_0x03d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:175:0x03bf, code lost:
            r40 = new com.google.android.exoplayer2.video.ColorInfo(r0.f27543x, r0.f27545z, r0.f27544y, c());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:176:0x03d1, code lost:
            r40 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:178:0x03dd, code lost:
            if ("htc_video_rotA-000".equals(r0.f27520a) == false) goto L_0x03e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:179:0x03df, code lost:
            r9 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:181:0x03e9, code lost:
            if ("htc_video_rotA-090".equals(r0.f27520a) == false) goto L_0x03ee;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:182:0x03eb, code lost:
            r9 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:184:0x03f6, code lost:
            if ("htc_video_rotA-180".equals(r0.f27520a) == false) goto L_0x03fb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:185:0x03f8, code lost:
            r9 = 180;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:187:0x0403, code lost:
            if ("htc_video_rotA-270".equals(r0.f27520a) == false) goto L_0x0408;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:188:0x0405, code lost:
            r9 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ORIENTATION_270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:189:0x0408, code lost:
            r9 = -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:191:0x040b, code lost:
            if (r0.f27536q != 0) goto L_0x045f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:193:0x0414, code lost:
            if (java.lang.Float.compare(r0.f27537r, 0.0f) != 0) goto L_0x045f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:195:0x041c, code lost:
            if (java.lang.Float.compare(r0.f27538s, 0.0f) != 0) goto L_0x045f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:197:0x0424, code lost:
            if (java.lang.Float.compare(r0.f27539t, 0.0f) != 0) goto L_0x0429;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:198:0x0426, code lost:
            r36 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:200:0x0431, code lost:
            if (java.lang.Float.compare(r0.f27538s, 90.0f) != 0) goto L_0x0436;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:201:0x0433, code lost:
            r36 = 90;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:203:0x043e, code lost:
            if (java.lang.Float.compare(r0.f27538s, -180.0f) == 0) goto L_0x045a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:205:0x0448, code lost:
            if (java.lang.Float.compare(r0.f27538s, 180.0f) != 0) goto L_0x044b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:207:0x0453, code lost:
            if (java.lang.Float.compare(r0.f27538s, -90.0f) != 0) goto L_0x045f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:208:0x0455, code lost:
            r36 = com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ORIENTATION_270;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:209:0x045a, code lost:
            r36 = 180;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:210:0x045f, code lost:
            r36 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:211:0x0461, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r44), r6, (java.lang.String) null, -1, r31, r0.f27531l, r0.f27532m, -1.0f, r1, r36, r37, r0.f27540u, r0.f27541v, r40, r0.f27530k);
            r5 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:213:0x048e, code lost:
            if ("application/x-subrip".equals(r6) == false) goto L_0x049f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:214:0x0490, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r44), r6, (int) r2, r0.W, r0.f27530k);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:215:0x049c, code lost:
            r5 = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:217:0x04a3, code lost:
            if ("text/x-ssa".equals(r6) == false) goto L_0x04d9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:218:0x04a5, code lost:
            r1 = new java.util.ArrayList(2);
            r1.add(fm.d.a());
            r1.add(r0.f27529j);
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r44), r6, (java.lang.String) null, -1, (int) r2, r0.W, -1, r0.f27530k, Long.MAX_VALUE, (java.util.List<byte[]>) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:220:0x04dd, code lost:
            if ("application/vobsub".equals(r6) != false) goto L_0x04f4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:222:0x04e3, code lost:
            if ("application/pgs".equals(r6) != false) goto L_0x04f4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x04e9, code lost:
            if ("application/dvbsubs".equals(r6) == false) goto L_0x04ec;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:226:0x04f3, code lost:
            throw new com.google.android.exoplayer2.ParserException("Unexpected MIME type.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:227:0x04f4, code lost:
            r1 = com.google.android.exoplayer2.Format.a(java.lang.Integer.toString(r44), r6, (java.lang.String) null, -1, (int) r2, r1, r0.W, r0.f27530k);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:228:0x050f, code lost:
            r2 = r43.a(r0.f27522c, r5);
            r0.U = r2;
            r2.a(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:229:0x051c, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(fj.i r43, int r44) throws com.google.android.exoplayer2.ParserException {
            /*
                r42 = this;
                r0 = r42
                java.lang.String r1 = r0.f27521b
                r1.hashCode()
                int r2 = r1.hashCode()
                r3 = 4
                r4 = 8
                r5 = 1
                r7 = 3
                r8 = 0
                switch(r2) {
                    case -2095576542: goto L_0x0196;
                    case -2095575984: goto L_0x018a;
                    case -1985379776: goto L_0x017e;
                    case -1784763192: goto L_0x0172;
                    case -1730367663: goto L_0x0166;
                    case -1482641358: goto L_0x015a;
                    case -1482641357: goto L_0x014e;
                    case -1373388978: goto L_0x0142;
                    case -933872740: goto L_0x0134;
                    case -538363189: goto L_0x0126;
                    case -538363109: goto L_0x0118;
                    case -425012669: goto L_0x010a;
                    case -356037306: goto L_0x00fc;
                    case 62923557: goto L_0x00ee;
                    case 62923603: goto L_0x00e0;
                    case 62927045: goto L_0x00d2;
                    case 82318131: goto L_0x00c4;
                    case 82338133: goto L_0x00b6;
                    case 82338134: goto L_0x00a8;
                    case 99146302: goto L_0x009a;
                    case 444813526: goto L_0x008c;
                    case 542569478: goto L_0x007f;
                    case 725957860: goto L_0x0072;
                    case 738597099: goto L_0x0065;
                    case 855502857: goto L_0x0058;
                    case 1422270023: goto L_0x004b;
                    case 1809237540: goto L_0x003e;
                    case 1950749482: goto L_0x0031;
                    case 1950789798: goto L_0x0024;
                    case 1951062397: goto L_0x0017;
                    default: goto L_0x0014;
                }
            L_0x0014:
                r1 = -1
                goto L_0x01a1
            L_0x0017:
                java.lang.String r2 = "A_OPUS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0020
                goto L_0x0014
            L_0x0020:
                r1 = 29
                goto L_0x01a1
            L_0x0024:
                java.lang.String r2 = "A_FLAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x002d
                goto L_0x0014
            L_0x002d:
                r1 = 28
                goto L_0x01a1
            L_0x0031:
                java.lang.String r2 = "A_EAC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x003a
                goto L_0x0014
            L_0x003a:
                r1 = 27
                goto L_0x01a1
            L_0x003e:
                java.lang.String r2 = "V_MPEG2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0047
                goto L_0x0014
            L_0x0047:
                r1 = 26
                goto L_0x01a1
            L_0x004b:
                java.lang.String r2 = "S_TEXT/UTF8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0054
                goto L_0x0014
            L_0x0054:
                r1 = 25
                goto L_0x01a1
            L_0x0058:
                java.lang.String r2 = "V_MPEGH/ISO/HEVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0061
                goto L_0x0014
            L_0x0061:
                r1 = 24
                goto L_0x01a1
            L_0x0065:
                java.lang.String r2 = "S_TEXT/ASS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x006e
                goto L_0x0014
            L_0x006e:
                r1 = 23
                goto L_0x01a1
            L_0x0072:
                java.lang.String r2 = "A_PCM/INT/LIT"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x007b
                goto L_0x0014
            L_0x007b:
                r1 = 22
                goto L_0x01a1
            L_0x007f:
                java.lang.String r2 = "A_DTS/EXPRESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0088
                goto L_0x0014
            L_0x0088:
                r1 = 21
                goto L_0x01a1
            L_0x008c:
                java.lang.String r2 = "V_THEORA"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0096
                goto L_0x0014
            L_0x0096:
                r1 = 20
                goto L_0x01a1
            L_0x009a:
                java.lang.String r2 = "S_HDMV/PGS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00a4
                goto L_0x0014
            L_0x00a4:
                r1 = 19
                goto L_0x01a1
            L_0x00a8:
                java.lang.String r2 = "V_VP9"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00b2
                goto L_0x0014
            L_0x00b2:
                r1 = 18
                goto L_0x01a1
            L_0x00b6:
                java.lang.String r2 = "V_VP8"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00c0
                goto L_0x0014
            L_0x00c0:
                r1 = 17
                goto L_0x01a1
            L_0x00c4:
                java.lang.String r2 = "V_AV1"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00ce
                goto L_0x0014
            L_0x00ce:
                r1 = 16
                goto L_0x01a1
            L_0x00d2:
                java.lang.String r2 = "A_DTS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00dc
                goto L_0x0014
            L_0x00dc:
                r1 = 15
                goto L_0x01a1
            L_0x00e0:
                java.lang.String r2 = "A_AC3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00ea
                goto L_0x0014
            L_0x00ea:
                r1 = 14
                goto L_0x01a1
            L_0x00ee:
                java.lang.String r2 = "A_AAC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x00f8
                goto L_0x0014
            L_0x00f8:
                r1 = 13
                goto L_0x01a1
            L_0x00fc:
                java.lang.String r2 = "A_DTS/LOSSLESS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0106
                goto L_0x0014
            L_0x0106:
                r1 = 12
                goto L_0x01a1
            L_0x010a:
                java.lang.String r2 = "S_VOBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0114
                goto L_0x0014
            L_0x0114:
                r1 = 11
                goto L_0x01a1
            L_0x0118:
                java.lang.String r2 = "V_MPEG4/ISO/AVC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0122
                goto L_0x0014
            L_0x0122:
                r1 = 10
                goto L_0x01a1
            L_0x0126:
                java.lang.String r2 = "V_MPEG4/ISO/ASP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0130
                goto L_0x0014
            L_0x0130:
                r1 = 9
                goto L_0x01a1
            L_0x0134:
                java.lang.String r2 = "S_DVBSUB"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x013e
                goto L_0x0014
            L_0x013e:
                r1 = 8
                goto L_0x01a1
            L_0x0142:
                java.lang.String r2 = "V_MS/VFW/FOURCC"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x014c
                goto L_0x0014
            L_0x014c:
                r1 = 7
                goto L_0x01a1
            L_0x014e:
                java.lang.String r2 = "A_MPEG/L3"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0158
                goto L_0x0014
            L_0x0158:
                r1 = 6
                goto L_0x01a1
            L_0x015a:
                java.lang.String r2 = "A_MPEG/L2"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0164
                goto L_0x0014
            L_0x0164:
                r1 = 5
                goto L_0x01a1
            L_0x0166:
                java.lang.String r2 = "A_VORBIS"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0170
                goto L_0x0014
            L_0x0170:
                r1 = 4
                goto L_0x01a1
            L_0x0172:
                java.lang.String r2 = "A_TRUEHD"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x017c
                goto L_0x0014
            L_0x017c:
                r1 = 3
                goto L_0x01a1
            L_0x017e:
                java.lang.String r2 = "A_MS/ACM"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0188
                goto L_0x0014
            L_0x0188:
                r1 = 2
                goto L_0x01a1
            L_0x018a:
                java.lang.String r2 = "V_MPEG4/ISO/SP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x0194
                goto L_0x0014
            L_0x0194:
                r1 = 1
                goto L_0x01a1
            L_0x0196:
                java.lang.String r2 = "V_MPEG4/ISO/AP"
                boolean r1 = r1.equals(r2)
                if (r1 != 0) goto L_0x01a0
                goto L_0x0014
            L_0x01a0:
                r1 = 0
            L_0x01a1:
                java.lang.String r2 = ". Setting mimeType to "
                java.lang.String r10 = "Unsupported PCM bit depth: "
                java.lang.String r11 = "application/dvbsubs"
                java.lang.String r12 = "application/pgs"
                java.lang.String r13 = "application/vobsub"
                java.lang.String r14 = "text/x-ssa"
                java.lang.String r15 = "application/x-subrip"
                java.lang.String r16 = "audio/raw"
                r17 = 4096(0x1000, float:5.74E-42)
                java.lang.String r9 = "MatroskaExtractor"
                java.lang.String r6 = "audio/x-unknown"
                r18 = 0
                switch(r1) {
                    case 0: goto L_0x033e;
                    case 1: goto L_0x033e;
                    case 2: goto L_0x0304;
                    case 3: goto L_0x02f9;
                    case 4: goto L_0x02e8;
                    case 5: goto L_0x02dd;
                    case 6: goto L_0x02da;
                    case 7: goto L_0x02c4;
                    case 8: goto L_0x02a9;
                    case 9: goto L_0x033e;
                    case 10: goto L_0x0292;
                    case 11: goto L_0x028a;
                    case 12: goto L_0x0287;
                    case 13: goto L_0x027e;
                    case 14: goto L_0x027b;
                    case 15: goto L_0x0278;
                    case 16: goto L_0x0275;
                    case 17: goto L_0x0269;
                    case 18: goto L_0x0266;
                    case 19: goto L_0x0264;
                    case 20: goto L_0x0261;
                    case 21: goto L_0x0278;
                    case 22: goto L_0x0231;
                    case 23: goto L_0x022f;
                    case 24: goto L_0x021a;
                    case 25: goto L_0x0218;
                    case 26: goto L_0x0215;
                    case 27: goto L_0x0212;
                    case 28: goto L_0x0208;
                    case 29: goto L_0x01c4;
                    default: goto L_0x01bc;
                }
            L_0x01bc:
                com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
                java.lang.String r2 = "Unrecognized codec identifier."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x01c4:
                r17 = 5760(0x1680, float:8.071E-42)
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r7)
                byte[] r2 = r0.f27529j
                r1.add(r2)
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r4)
                java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r2 = r2.order(r3)
                long r9 = r0.P
                java.nio.ByteBuffer r2 = r2.putLong(r9)
                byte[] r2 = r2.array()
                r1.add(r2)
                java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r4)
                java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN
                java.nio.ByteBuffer r2 = r2.order(r3)
                long r3 = r0.Q
                java.nio.ByteBuffer r2 = r2.putLong(r3)
                byte[] r2 = r2.array()
                r1.add(r2)
                java.lang.String r16 = "audio/opus"
                r6 = r16
                r26 = -1
                r31 = 5760(0x1680, float:8.071E-42)
                goto L_0x034d
            L_0x0208:
                byte[] r1 = r0.f27529j
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r16 = "audio/flac"
                goto L_0x02a6
            L_0x0212:
                java.lang.String r16 = "audio/eac3"
                goto L_0x026b
            L_0x0215:
                java.lang.String r16 = "video/mpeg2"
                goto L_0x026b
            L_0x0218:
                r6 = r15
                goto L_0x026d
            L_0x021a:
                com.google.android.exoplayer2.util.q r1 = new com.google.android.exoplayer2.util.q
                byte[] r2 = r0.f27529j
                r1.<init>((byte[]) r2)
                com.google.android.exoplayer2.video.c r1 = com.google.android.exoplayer2.video.c.a(r1)
                java.util.List<byte[]> r2 = r1.f17220a
                int r1 = r1.f17221b
                r0.V = r1
                java.lang.String r16 = "video/hevc"
                goto L_0x02a5
            L_0x022f:
                r6 = r14
                goto L_0x026d
            L_0x0231:
                int r1 = r0.N
                int r1 = com.google.android.exoplayer2.util.ad.c((int) r1)
                if (r1 != 0) goto L_0x025a
                int r1 = r0.N
                int r3 = r6.length()
                int r3 = r3 + 60
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r3)
            L_0x0246:
                r4.append(r10)
                r4.append(r1)
                r4.append(r2)
                r4.append(r6)
                java.lang.String r1 = r4.toString()
            L_0x0256:
                com.google.android.exoplayer2.util.k.c(r9, r1)
                goto L_0x026d
            L_0x025a:
                r26 = r1
                r6 = r16
                r1 = r18
                goto L_0x0271
            L_0x0261:
                java.lang.String r16 = "video/x-unknown"
                goto L_0x026b
            L_0x0264:
                r6 = r12
                goto L_0x026d
            L_0x0266:
                java.lang.String r16 = "video/x-vnd.on2.vp9"
                goto L_0x026b
            L_0x0269:
                java.lang.String r16 = "video/x-vnd.on2.vp8"
            L_0x026b:
                r6 = r16
            L_0x026d:
                r1 = r18
            L_0x026f:
                r26 = -1
            L_0x0271:
                r31 = -1
                goto L_0x034d
            L_0x0275:
                java.lang.String r16 = "video/av01"
                goto L_0x026b
            L_0x0278:
                java.lang.String r16 = "audio/vnd.dts"
                goto L_0x026b
            L_0x027b:
                java.lang.String r16 = "audio/ac3"
                goto L_0x026b
            L_0x027e:
                byte[] r1 = r0.f27529j
                java.util.List r1 = java.util.Collections.singletonList(r1)
                java.lang.String r16 = "audio/mp4a-latm"
                goto L_0x02a6
            L_0x0287:
                java.lang.String r16 = "audio/vnd.dts.hd"
                goto L_0x026b
            L_0x028a:
                byte[] r1 = r0.f27529j
                java.util.List r1 = java.util.Collections.singletonList(r1)
                r6 = r13
                goto L_0x026f
            L_0x0292:
                com.google.android.exoplayer2.util.q r1 = new com.google.android.exoplayer2.util.q
                byte[] r2 = r0.f27529j
                r1.<init>((byte[]) r2)
                com.google.android.exoplayer2.video.a r1 = com.google.android.exoplayer2.video.a.a(r1)
                java.util.List<byte[]> r2 = r1.f17212a
                int r1 = r1.f17213b
                r0.V = r1
                java.lang.String r16 = "video/avc"
            L_0x02a5:
                r1 = r2
            L_0x02a6:
                r6 = r16
                goto L_0x026f
            L_0x02a9:
                byte[] r1 = new byte[r3]
                byte[] r2 = r0.f27529j
                byte r3 = r2[r8]
                r1[r8] = r3
                byte r3 = r2[r5]
                r1[r5] = r3
                r3 = 2
                byte r4 = r2[r3]
                r1[r3] = r4
                byte r2 = r2[r7]
                r1[r7] = r2
                java.util.List r1 = java.util.Collections.singletonList(r1)
                r6 = r11
                goto L_0x026f
            L_0x02c4:
                com.google.android.exoplayer2.util.q r1 = new com.google.android.exoplayer2.util.q
                byte[] r2 = r0.f27529j
                r1.<init>((byte[]) r2)
                android.util.Pair r1 = a((com.google.android.exoplayer2.util.q) r1)
                java.lang.Object r2 = r1.first
                r16 = r2
                java.lang.String r16 = (java.lang.String) r16
                java.lang.Object r1 = r1.second
                java.util.List r1 = (java.util.List) r1
                goto L_0x02a6
            L_0x02da:
                java.lang.String r16 = "audio/mpeg"
                goto L_0x02df
            L_0x02dd:
                java.lang.String r16 = "audio/mpeg-L2"
            L_0x02df:
                r6 = r16
                r1 = r18
                r26 = -1
                r31 = 4096(0x1000, float:5.74E-42)
                goto L_0x034d
            L_0x02e8:
                r17 = 8192(0x2000, float:1.14794E-41)
                byte[] r1 = r0.f27529j
                java.util.List r1 = a((byte[]) r1)
                java.lang.String r16 = "audio/vorbis"
                r6 = r16
                r26 = -1
                r31 = 8192(0x2000, float:1.14794E-41)
                goto L_0x034d
            L_0x02f9:
                fm.d$c r1 = new fm.d$c
                r1.<init>()
                r0.R = r1
                java.lang.String r16 = "audio/true-hd"
                goto L_0x026b
            L_0x0304:
                com.google.android.exoplayer2.util.q r1 = new com.google.android.exoplayer2.util.q
                byte[] r3 = r0.f27529j
                r1.<init>((byte[]) r3)
                boolean r1 = b(r1)
                if (r1 == 0) goto L_0x0328
                int r1 = r0.N
                int r1 = com.google.android.exoplayer2.util.ad.c((int) r1)
                if (r1 != 0) goto L_0x025a
                int r1 = r0.N
                int r3 = r6.length()
                int r3 = r3 + 60
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r3)
                goto L_0x0246
            L_0x0328:
                java.lang.String r1 = "Non-PCM MS/ACM is unsupported. Setting mimeType to "
                int r2 = r6.length()
                if (r2 == 0) goto L_0x0336
                java.lang.String r1 = r1.concat(r6)
                goto L_0x0256
            L_0x0336:
                java.lang.String r2 = new java.lang.String
                r2.<init>(r1)
                r1 = r2
                goto L_0x0256
            L_0x033e:
                byte[] r1 = r0.f27529j
                if (r1 != 0) goto L_0x0345
                r1 = r18
                goto L_0x0349
            L_0x0345:
                java.util.List r1 = java.util.Collections.singletonList(r1)
            L_0x0349:
                java.lang.String r16 = "video/mp4v-es"
                goto L_0x02a6
            L_0x034d:
                boolean r2 = r0.T
                r2 = r2 | r8
                boolean r3 = r0.S
                if (r3 == 0) goto L_0x0356
                r3 = 2
                goto L_0x0357
            L_0x0356:
                r3 = 0
            L_0x0357:
                r2 = r2 | r3
                boolean r3 = com.google.android.exoplayer2.util.n.a((java.lang.String) r6)
                if (r3 == 0) goto L_0x0384
                java.lang.String r19 = java.lang.Integer.toString(r44)
                r21 = 0
                r22 = -1
                int r3 = r0.M
                int r4 = r0.O
                com.google.android.exoplayer2.drm.DrmInitData r7 = r0.f27530k
                java.lang.String r8 = r0.W
                r20 = r6
                r23 = r31
                r24 = r3
                r25 = r4
                r27 = r1
                r28 = r7
                r29 = r2
                r30 = r8
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r19, (java.lang.String) r20, (java.lang.String) r21, (int) r22, (int) r23, (int) r24, (int) r25, (int) r26, (java.util.List<byte[]>) r27, (com.google.android.exoplayer2.drm.DrmInitData) r28, (int) r29, (java.lang.String) r30)
                goto L_0x050f
            L_0x0384:
                boolean r3 = com.google.android.exoplayer2.util.n.b(r6)
                if (r3 == 0) goto L_0x048a
                int r2 = r0.f27535p
                if (r2 != 0) goto L_0x03a0
                int r2 = r0.f27533n
                r3 = -1
                if (r2 != r3) goto L_0x0395
                int r2 = r0.f27531l
            L_0x0395:
                r0.f27533n = r2
                int r2 = r0.f27534o
                if (r2 != r3) goto L_0x039d
                int r2 = r0.f27532m
            L_0x039d:
                r0.f27534o = r2
                goto L_0x03a1
            L_0x03a0:
                r3 = -1
            L_0x03a1:
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r4 = r0.f27533n
                if (r4 == r3) goto L_0x03b9
                int r5 = r0.f27534o
                if (r5 == r3) goto L_0x03b9
                int r2 = r0.f27532m
                int r2 = r2 * r4
                float r2 = (float) r2
                int r4 = r0.f27531l
                int r4 = r4 * r5
                float r4 = (float) r4
                float r2 = r2 / r4
                r37 = r2
                goto L_0x03bb
            L_0x03b9:
                r37 = -1082130432(0xffffffffbf800000, float:-1.0)
            L_0x03bb:
                boolean r2 = r0.f27542w
                if (r2 == 0) goto L_0x03d1
                byte[] r2 = r42.c()
                com.google.android.exoplayer2.video.ColorInfo r4 = new com.google.android.exoplayer2.video.ColorInfo
                int r5 = r0.f27543x
                int r7 = r0.f27545z
                int r9 = r0.f27544y
                r4.<init>(r5, r7, r9, r2)
                r40 = r4
                goto L_0x03d3
            L_0x03d1:
                r40 = r18
            L_0x03d3:
                java.lang.String r2 = r0.f27520a
                java.lang.String r4 = "htc_video_rotA-000"
                boolean r2 = r4.equals(r2)
                r4 = 90
                if (r2 == 0) goto L_0x03e1
                r9 = 0
                goto L_0x0409
            L_0x03e1:
                java.lang.String r2 = r0.f27520a
                java.lang.String r5 = "htc_video_rotA-090"
                boolean r2 = r5.equals(r2)
                if (r2 == 0) goto L_0x03ee
                r9 = 90
                goto L_0x0409
            L_0x03ee:
                java.lang.String r2 = r0.f27520a
                java.lang.String r5 = "htc_video_rotA-180"
                boolean r2 = r5.equals(r2)
                if (r2 == 0) goto L_0x03fb
                r9 = 180(0xb4, float:2.52E-43)
                goto L_0x0409
            L_0x03fb:
                java.lang.String r2 = r0.f27520a
                java.lang.String r5 = "htc_video_rotA-270"
                boolean r2 = r5.equals(r2)
                if (r2 == 0) goto L_0x0408
                r9 = 270(0x10e, float:3.78E-43)
                goto L_0x0409
            L_0x0408:
                r9 = -1
            L_0x0409:
                int r2 = r0.f27536q
                if (r2 != 0) goto L_0x045f
                float r2 = r0.f27537r
                r3 = 0
                int r2 = java.lang.Float.compare(r2, r3)
                if (r2 != 0) goto L_0x045f
                float r2 = r0.f27538s
                int r2 = java.lang.Float.compare(r2, r3)
                if (r2 != 0) goto L_0x045f
                float r2 = r0.f27539t
                int r2 = java.lang.Float.compare(r2, r3)
                if (r2 != 0) goto L_0x0429
                r36 = 0
                goto L_0x0461
            L_0x0429:
                float r2 = r0.f27538s
                r3 = 1119092736(0x42b40000, float:90.0)
                int r2 = java.lang.Float.compare(r2, r3)
                if (r2 != 0) goto L_0x0436
                r36 = 90
                goto L_0x0461
            L_0x0436:
                float r2 = r0.f27538s
                r3 = -1020002304(0xffffffffc3340000, float:-180.0)
                int r2 = java.lang.Float.compare(r2, r3)
                if (r2 == 0) goto L_0x045a
                float r2 = r0.f27538s
                r3 = 1127481344(0x43340000, float:180.0)
                int r2 = java.lang.Float.compare(r2, r3)
                if (r2 != 0) goto L_0x044b
                goto L_0x045a
            L_0x044b:
                float r2 = r0.f27538s
                r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
                int r2 = java.lang.Float.compare(r2, r3)
                if (r2 != 0) goto L_0x045f
                r8 = 270(0x10e, float:3.78E-43)
                r36 = 270(0x10e, float:3.78E-43)
                goto L_0x0461
            L_0x045a:
                r8 = 180(0xb4, float:2.52E-43)
                r36 = 180(0xb4, float:2.52E-43)
                goto L_0x0461
            L_0x045f:
                r36 = r9
            L_0x0461:
                java.lang.String r27 = java.lang.Integer.toString(r44)
                r29 = 0
                r30 = -1
                int r2 = r0.f27531l
                int r3 = r0.f27532m
                r34 = -1082130432(0xffffffffbf800000, float:-1.0)
                byte[] r4 = r0.f27540u
                int r5 = r0.f27541v
                com.google.android.exoplayer2.drm.DrmInitData r7 = r0.f27530k
                r28 = r6
                r32 = r2
                r33 = r3
                r35 = r1
                r38 = r4
                r39 = r5
                r41 = r7
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r27, (java.lang.String) r28, (java.lang.String) r29, (int) r30, (int) r31, (int) r32, (int) r33, (float) r34, (java.util.List<byte[]>) r35, (int) r36, (float) r37, (byte[]) r38, (int) r39, (com.google.android.exoplayer2.video.ColorInfo) r40, (com.google.android.exoplayer2.drm.DrmInitData) r41)
                r5 = 2
                goto L_0x050f
            L_0x048a:
                boolean r3 = r15.equals(r6)
                if (r3 == 0) goto L_0x049f
                java.lang.String r1 = java.lang.Integer.toString(r44)
                java.lang.String r3 = r0.W
                com.google.android.exoplayer2.drm.DrmInitData r4 = r0.f27530k
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r1, (java.lang.String) r6, (int) r2, (java.lang.String) r3, (com.google.android.exoplayer2.drm.DrmInitData) r4)
            L_0x049c:
                r5 = 3
                goto L_0x050f
            L_0x049f:
                boolean r3 = r14.equals(r6)
                if (r3 == 0) goto L_0x04d9
                java.util.ArrayList r1 = new java.util.ArrayList
                r3 = 2
                r1.<init>(r3)
                byte[] r3 = fm.d.f27489c
                r1.add(r3)
                byte[] r3 = r0.f27529j
                r1.add(r3)
                java.lang.String r27 = java.lang.Integer.toString(r44)
                r29 = 0
                r30 = -1
                java.lang.String r3 = r0.W
                r33 = -1
                com.google.android.exoplayer2.drm.DrmInitData r4 = r0.f27530k
                r35 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r28 = r6
                r31 = r2
                r32 = r3
                r34 = r4
                r37 = r1
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r27, (java.lang.String) r28, (java.lang.String) r29, (int) r30, (int) r31, (java.lang.String) r32, (int) r33, (com.google.android.exoplayer2.drm.DrmInitData) r34, (long) r35, (java.util.List<byte[]>) r37)
                goto L_0x049c
            L_0x04d9:
                boolean r3 = r13.equals(r6)
                if (r3 != 0) goto L_0x04f4
                boolean r3 = r12.equals(r6)
                if (r3 != 0) goto L_0x04f4
                boolean r3 = r11.equals(r6)
                if (r3 == 0) goto L_0x04ec
                goto L_0x04f4
            L_0x04ec:
                com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
                java.lang.String r2 = "Unexpected MIME type."
                r1.<init>((java.lang.String) r2)
                throw r1
            L_0x04f4:
                java.lang.String r27 = java.lang.Integer.toString(r44)
                r29 = 0
                r30 = -1
                java.lang.String r3 = r0.W
                com.google.android.exoplayer2.drm.DrmInitData r4 = r0.f27530k
                r28 = r6
                r31 = r2
                r32 = r1
                r33 = r3
                r34 = r4
                com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r27, (java.lang.String) r28, (java.lang.String) r29, (int) r30, (int) r31, (java.util.List<byte[]>) r32, (java.lang.String) r33, (com.google.android.exoplayer2.drm.DrmInitData) r34)
                goto L_0x049c
            L_0x050f:
                int r2 = r0.f27522c
                r3 = r43
                fj.u r2 = r3.a(r2, r5)
                r0.U = r2
                r2.a(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fm.d.b.a(fj.i, int):void");
        }

        public void b() {
            c cVar = this.R;
            if (cVar != null) {
                cVar.a();
            }
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f27546a = new byte[10];

        /* renamed from: b  reason: collision with root package name */
        private boolean f27547b;

        /* renamed from: c  reason: collision with root package name */
        private int f27548c;

        /* renamed from: d  reason: collision with root package name */
        private long f27549d;

        /* renamed from: e  reason: collision with root package name */
        private int f27550e;

        /* renamed from: f  reason: collision with root package name */
        private int f27551f;

        /* renamed from: g  reason: collision with root package name */
        private int f27552g;

        public void a() {
            this.f27547b = false;
            this.f27548c = 0;
        }

        public void a(h hVar) throws IOException, InterruptedException {
            if (!this.f27547b) {
                hVar.d(this.f27546a, 0, 10);
                hVar.a();
                if (com.google.android.exoplayer2.audio.a.b(this.f27546a) != 0) {
                    this.f27547b = true;
                }
            }
        }

        public void a(b bVar) {
            if (this.f27548c > 0) {
                bVar.U.a(this.f27549d, this.f27550e, this.f27551f, this.f27552g, bVar.f27528i);
                this.f27548c = 0;
            }
        }

        public void a(b bVar, long j2, int i2, int i3, int i4) {
            if (this.f27547b) {
                int i5 = this.f27548c;
                int i6 = i5 + 1;
                this.f27548c = i6;
                if (i5 == 0) {
                    this.f27549d = j2;
                    this.f27550e = i2;
                    this.f27551f = 0;
                }
                this.f27551f += i3;
                this.f27552g = i4;
                if (i6 >= 16) {
                    a(bVar);
                }
            }
        }
    }

    public d() {
        this(0);
    }

    public d(int i2) {
        this(new a(), i2);
    }

    d(c cVar, int i2) {
        this.f27514v = -1;
        this.f27515w = -9223372036854775807L;
        this.f27516x = -9223372036854775807L;
        this.f27517y = -9223372036854775807L;
        this.E = -1;
        this.F = -1;
        this.G = -9223372036854775807L;
        this.f27498f = cVar;
        cVar.a((b) new a());
        this.f27501i = (i2 & 1) != 0 ? false : true;
        this.f27499g = new f();
        this.f27500h = new SparseArray<>();
        this.f27504l = new q(4);
        this.f27505m = new q(ByteBuffer.allocate(4).putInt(-1).array());
        this.f27506n = new q(4);
        this.f27502j = new q(o.f17135a);
        this.f27503k = new q(4);
        this.f27507o = new q();
        this.f27508p = new q();
        this.f27509q = new q(8);
        this.f27510r = new q();
        this.f27511s = new q();
    }

    private int a(h hVar, u uVar, int i2) throws IOException, InterruptedException {
        int b2 = this.f27507o.b();
        if (b2 <= 0) {
            return uVar.a(hVar, i2, false);
        }
        int min = Math.min(i2, b2);
        uVar.a(this.f27507o, min);
        return min;
    }

    private int a(h hVar, b bVar, int i2) throws IOException, InterruptedException {
        int i3;
        if ("S_TEXT/UTF8".equals(bVar.f27521b)) {
            a(hVar, f27488b, i2);
        } else if ("S_TEXT/ASS".equals(bVar.f27521b)) {
            a(hVar, f27490d, i2);
        } else {
            u uVar = bVar.U;
            boolean z2 = true;
            if (!this.Z) {
                if (bVar.f27526g) {
                    this.T &= -1073741825;
                    int i4 = 128;
                    if (!this.f27492aa) {
                        hVar.b(this.f27504l.f17159a, 0, 1);
                        this.W++;
                        if ((this.f27504l.f17159a[0] & 128) != 128) {
                            this.f27495ad = this.f27504l.f17159a[0];
                            this.f27492aa = true;
                        } else {
                            throw new ParserException("Extension bit is set in signal byte");
                        }
                    }
                    byte b2 = this.f27495ad;
                    if ((b2 & 1) == 1) {
                        boolean z3 = (b2 & 2) == 2;
                        this.T |= MemoryConstants.GB;
                        if (!this.f27496ae) {
                            hVar.b(this.f27509q.f17159a, 0, 8);
                            this.W += 8;
                            this.f27496ae = true;
                            byte[] bArr = this.f27504l.f17159a;
                            if (!z3) {
                                i4 = 0;
                            }
                            bArr[0] = (byte) (i4 | 8);
                            this.f27504l.c(0);
                            uVar.a(this.f27504l, 1);
                            this.X++;
                            this.f27509q.c(0);
                            uVar.a(this.f27509q, 8);
                            this.X += 8;
                        }
                        if (z3) {
                            if (!this.f27493ab) {
                                hVar.b(this.f27504l.f17159a, 0, 1);
                                this.W++;
                                this.f27504l.c(0);
                                this.f27494ac = this.f27504l.h();
                                this.f27493ab = true;
                            }
                            int i5 = this.f27494ac * 4;
                            this.f27504l.a(i5);
                            hVar.b(this.f27504l.f17159a, 0, i5);
                            this.W += i5;
                            short s2 = (short) ((this.f27494ac / 2) + 1);
                            int i6 = (s2 * 6) + 2;
                            ByteBuffer byteBuffer = this.f27512t;
                            if (byteBuffer == null || byteBuffer.capacity() < i6) {
                                this.f27512t = ByteBuffer.allocate(i6);
                            }
                            this.f27512t.position(0);
                            this.f27512t.putShort(s2);
                            int i7 = 0;
                            int i8 = 0;
                            while (true) {
                                i3 = this.f27494ac;
                                if (i7 >= i3) {
                                    break;
                                }
                                int v2 = this.f27504l.v();
                                if (i7 % 2 == 0) {
                                    this.f27512t.putShort((short) (v2 - i8));
                                } else {
                                    this.f27512t.putInt(v2 - i8);
                                }
                                i7++;
                                i8 = v2;
                            }
                            int i9 = (i2 - this.W) - i8;
                            int i10 = i3 % 2;
                            ByteBuffer byteBuffer2 = this.f27512t;
                            if (i10 == 1) {
                                byteBuffer2.putInt(i9);
                            } else {
                                byteBuffer2.putShort((short) i9);
                                this.f27512t.putInt(0);
                            }
                            this.f27510r.a(this.f27512t.array(), i6);
                            uVar.a(this.f27510r, i6);
                            this.X += i6;
                        }
                    }
                } else if (bVar.f27527h != null) {
                    this.f27507o.a(bVar.f27527h, bVar.f27527h.length);
                }
                if (bVar.f27525f > 0) {
                    this.T |= AMapEngineUtils.MAX_P20_WIDTH;
                    this.f27511s.a();
                    this.f27504l.a(4);
                    this.f27504l.f17159a[0] = (byte) ((i2 >> 24) & 255);
                    this.f27504l.f17159a[1] = (byte) ((i2 >> 16) & 255);
                    this.f27504l.f17159a[2] = (byte) ((i2 >> 8) & 255);
                    this.f27504l.f17159a[3] = (byte) (i2 & 255);
                    uVar.a(this.f27504l, 4);
                    this.X += 4;
                }
                this.Z = true;
            }
            int c2 = i2 + this.f27507o.c();
            if (!"V_MPEG4/ISO/AVC".equals(bVar.f27521b) && !"V_MPEGH/ISO/HEVC".equals(bVar.f27521b)) {
                if (bVar.R != null) {
                    if (this.f27507o.c() != 0) {
                        z2 = false;
                    }
                    com.google.android.exoplayer2.util.a.b(z2);
                    bVar.R.a(hVar);
                }
                while (true) {
                    int i11 = this.W;
                    if (i11 >= c2) {
                        break;
                    }
                    int a2 = a(hVar, uVar, c2 - i11);
                    this.W += a2;
                    this.X += a2;
                }
            } else {
                byte[] bArr2 = this.f27503k.f17159a;
                bArr2[0] = 0;
                bArr2[1] = 0;
                bArr2[2] = 0;
                int i12 = bVar.V;
                int i13 = 4 - bVar.V;
                while (this.W < c2) {
                    int i14 = this.Y;
                    if (i14 == 0) {
                        a(hVar, bArr2, i13, i12);
                        this.W += i12;
                        this.f27503k.c(0);
                        this.Y = this.f27503k.v();
                        this.f27502j.c(0);
                        uVar.a(this.f27502j, 4);
                        this.X += 4;
                    } else {
                        int a3 = a(hVar, uVar, i14);
                        this.W += a3;
                        this.X += a3;
                        this.Y -= a3;
                    }
                }
            }
            if ("A_VORBIS".equals(bVar.f27521b)) {
                this.f27505m.c(0);
                uVar.a(this.f27505m, 4);
                this.X += 4;
            }
            return d();
        }
        return d();
    }

    private long a(long j2) throws ParserException {
        long j3 = this.f27515w;
        if (j3 != -9223372036854775807L) {
            return ad.d(j2, j3, 1000);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private void a(h hVar, int i2) throws IOException, InterruptedException {
        if (this.f27504l.c() < i2) {
            if (this.f27504l.e() < i2) {
                q qVar = this.f27504l;
                qVar.a(Arrays.copyOf(qVar.f17159a, Math.max(this.f27504l.f17159a.length * 2, i2)), this.f27504l.c());
            }
            hVar.b(this.f27504l.f17159a, this.f27504l.c(), i2 - this.f27504l.c());
            this.f27504l.b(i2);
        }
    }

    private void a(h hVar, byte[] bArr, int i2) throws IOException, InterruptedException {
        int length = bArr.length + i2;
        if (this.f27508p.e() < length) {
            this.f27508p.f17159a = Arrays.copyOf(bArr, length + i2);
        } else {
            System.arraycopy(bArr, 0, this.f27508p.f17159a, 0, bArr.length);
        }
        hVar.b(this.f27508p.f17159a, bArr.length, i2);
        this.f27508p.a(length);
    }

    private void a(h hVar, byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int min = Math.min(i3, this.f27507o.b());
        hVar.b(bArr, i2 + min, i3 - min);
        if (min > 0) {
            this.f27507o.a(bArr, i2, min);
        }
    }

    private void a(b bVar, long j2, int i2, int i3, int i4) {
        String str;
        if (bVar.R != null) {
            bVar.R.a(bVar, j2, i2, i3, i4);
        } else {
            if ("S_TEXT/UTF8".equals(bVar.f27521b) || "S_TEXT/ASS".equals(bVar.f27521b)) {
                if (this.P > 1) {
                    str = "Skipping subtitle sample in laced block.";
                } else if (this.N == -9223372036854775807L) {
                    str = "Skipping subtitle sample with no duration.";
                } else {
                    a(bVar.f27521b, this.N, this.f27508p.f17159a);
                    u uVar = bVar.U;
                    q qVar = this.f27508p;
                    uVar.a(qVar, qVar.c());
                    i3 += this.f27508p.c();
                }
                com.google.android.exoplayer2.util.k.c("MatroskaExtractor", str);
            }
            if ((268435456 & i2) != 0) {
                if (this.P > 1) {
                    i2 &= -268435457;
                } else {
                    int c2 = this.f27511s.c();
                    bVar.U.a(this.f27511s, c2);
                    i3 += c2;
                }
            }
            bVar.U.a(j2, i2, i3, i4, bVar.f27528i);
        }
        this.K = true;
    }

    private static void a(String str, long j2, byte[] bArr) {
        int i2;
        byte[] bArr2;
        str.hashCode();
        if (str.equals("S_TEXT/ASS")) {
            bArr2 = a(j2, "%01d:%02d:%02d:%02d", 10000);
            i2 = 21;
        } else if (!str.equals("S_TEXT/UTF8")) {
            throw new IllegalArgumentException();
        } else {
            bArr2 = a(j2, "%02d:%02d:%02d,%03d", 1000);
            i2 = 19;
        }
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
    }

    private boolean a(r rVar, long j2) {
        if (this.D) {
            this.F = j2;
            rVar.f27401a = this.E;
            this.D = false;
            return true;
        }
        if (this.A) {
            long j3 = this.F;
            if (j3 != -1) {
                rVar.f27401a = j3;
                this.F = -1;
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_AV1".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static byte[] a(long j2, String str, long j3) {
        com.google.android.exoplayer2.util.a.a(j2 != -9223372036854775807L);
        int i2 = (int) (j2 / 3600000000L);
        long j4 = j2 - (((long) (i2 * CacheConstants.HOUR)) * 1000000);
        int i3 = (int) (j4 / 60000000);
        long j5 = j4 - (((long) (i3 * 60)) * 1000000);
        int i4 = (int) (j5 / 1000000);
        return ad.c(String.format(Locale.US, str, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - (((long) i4) * 1000000)) / j3))}));
    }

    private static int[] a(int[] iArr, int i2) {
        return iArr == null ? new int[i2] : iArr.length >= i2 ? iArr : new int[Math.max(iArr.length * 2, i2)];
    }

    private int d() {
        int i2 = this.X;
        e();
        return i2;
    }

    private void e() {
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = false;
        this.f27492aa = false;
        this.f27493ab = false;
        this.f27494ac = 0;
        this.f27495ad = 0;
        this.f27496ae = false;
        this.f27507o.a();
    }

    private s f() {
        l lVar;
        l lVar2;
        int i2;
        if (this.f27514v == -1 || this.f27517y == -9223372036854775807L || (lVar = this.H) == null || lVar.a() == 0 || (lVar2 = this.I) == null || lVar2.a() != this.H.a()) {
            this.H = null;
            this.I = null;
            return new s.b(this.f27517y);
        }
        int a2 = this.H.a();
        int[] iArr = new int[a2];
        long[] jArr = new long[a2];
        long[] jArr2 = new long[a2];
        long[] jArr3 = new long[a2];
        int i3 = 0;
        for (int i4 = 0; i4 < a2; i4++) {
            jArr3[i4] = this.H.a(i4);
            jArr[i4] = this.f27514v + this.I.a(i4);
        }
        while (true) {
            i2 = a2 - 1;
            if (i3 >= i2) {
                break;
            }
            int i5 = i3 + 1;
            iArr[i3] = (int) (jArr[i5] - jArr[i3]);
            jArr2[i3] = jArr3[i5] - jArr3[i3];
            i3 = i5;
        }
        iArr[i2] = (int) ((this.f27514v + this.f27513u) - jArr[i2]);
        jArr2[i2] = this.f27517y - jArr3[i2];
        long j2 = jArr2[i2];
        if (j2 <= 0) {
            StringBuilder sb = new StringBuilder(72);
            sb.append("Discarding last cue point with unexpected duration: ");
            sb.append(j2);
            com.google.android.exoplayer2.util.k.c("MatroskaExtractor", sb.toString());
            iArr = Arrays.copyOf(iArr, i2);
            jArr = Arrays.copyOf(jArr, i2);
            jArr2 = Arrays.copyOf(jArr2, i2);
            jArr3 = Arrays.copyOf(jArr3, i2);
        }
        this.H = null;
        this.I = null;
        return new fj.b(iArr, jArr, jArr2, jArr3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] g() {
        return new g[]{new d()};
    }

    /* access modifiers changed from: protected */
    public int a(int i2) {
        switch (i2) {
            case IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED:
            case IChannelListener.CMD_CHANNEL_CARD_PROTECTED:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case IChannelListener.CMD_CHANNEL_ERROR_CONNECT:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public final int a(h hVar, r rVar) throws IOException, InterruptedException {
        this.K = false;
        boolean z2 = true;
        while (z2 && !this.K) {
            z2 = this.f27498f.a(hVar);
            if (z2 && a(rVar, hVar.c())) {
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        for (int i2 = 0; i2 < this.f27500h.size(); i2++) {
            this.f27500h.valueAt(i2).a();
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, double d2) throws ParserException {
        if (i2 == 181) {
            this.f27518z.O = (int) d2;
        } else if (i2 != 17545) {
            switch (i2) {
                case 21969:
                    this.f27518z.C = (float) d2;
                    return;
                case 21970:
                    this.f27518z.D = (float) d2;
                    return;
                case 21971:
                    this.f27518z.E = (float) d2;
                    return;
                case 21972:
                    this.f27518z.F = (float) d2;
                    return;
                case 21973:
                    this.f27518z.G = (float) d2;
                    return;
                case 21974:
                    this.f27518z.H = (float) d2;
                    return;
                case 21975:
                    this.f27518z.I = (float) d2;
                    return;
                case 21976:
                    this.f27518z.J = (float) d2;
                    return;
                case 21977:
                    this.f27518z.K = (float) d2;
                    return;
                case 21978:
                    this.f27518z.L = (float) d2;
                    return;
                default:
                    switch (i2) {
                        case 30323:
                            this.f27518z.f27537r = (float) d2;
                            return;
                        case 30324:
                            this.f27518z.f27538s = (float) d2;
                            return;
                        case 30325:
                            this.f27518z.f27539t = (float) d2;
                            return;
                        default:
                            return;
                    }
            }
        } else {
            this.f27516x = (long) d2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0220, code lost:
        throw new com.google.android.exoplayer2.ParserException("EBML lacing sample size out of range.");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r21, int r22, fj.h r23) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r20 = this;
            r7 = r20
            r0 = r21
            r1 = r22
            r8 = r23
            r2 = 161(0xa1, float:2.26E-43)
            r3 = 163(0xa3, float:2.28E-43)
            r4 = 2
            r9 = 0
            r10 = 1
            if (r0 == r2) goto L_0x00b7
            if (r0 == r3) goto L_0x00b7
            r2 = 165(0xa5, float:2.31E-43)
            if (r0 == r2) goto L_0x00a1
            r2 = 16981(0x4255, float:2.3795E-41)
            if (r0 == r2) goto L_0x0092
            r2 = 18402(0x47e2, float:2.5787E-41)
            if (r0 == r2) goto L_0x0082
            r2 = 21419(0x53ab, float:3.0014E-41)
            if (r0 == r2) goto L_0x0062
            r2 = 25506(0x63a2, float:3.5742E-41)
            if (r0 == r2) goto L_0x0053
            r2 = 30322(0x7672, float:4.249E-41)
            if (r0 != r2) goto L_0x003a
            fm.d$b r0 = r7.f27518z
            byte[] r2 = new byte[r1]
            r0.f27540u = r2
            fm.d$b r0 = r7.f27518z
            byte[] r0 = r0.f27540u
            r8.b(r0, r9, r1)
            goto L_0x02e5
        L_0x003a:
            com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
            r2 = 26
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Unexpected id: "
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x0053:
            fm.d$b r0 = r7.f27518z
            byte[] r2 = new byte[r1]
            r0.f27529j = r2
            fm.d$b r0 = r7.f27518z
            byte[] r0 = r0.f27529j
            r8.b(r0, r9, r1)
            goto L_0x02e5
        L_0x0062:
            com.google.android.exoplayer2.util.q r0 = r7.f27506n
            byte[] r0 = r0.f17159a
            java.util.Arrays.fill(r0, r9)
            com.google.android.exoplayer2.util.q r0 = r7.f27506n
            byte[] r0 = r0.f17159a
            int r2 = 4 - r1
            r8.b(r0, r2, r1)
            com.google.android.exoplayer2.util.q r0 = r7.f27506n
            r0.c(r9)
            com.google.android.exoplayer2.util.q r0 = r7.f27506n
            long r0 = r0.n()
            int r1 = (int) r0
            r7.B = r1
            goto L_0x02e5
        L_0x0082:
            byte[] r0 = new byte[r1]
            r8.b(r0, r9, r1)
            fm.d$b r1 = r7.f27518z
            fj.u$a r2 = new fj.u$a
            r2.<init>(r10, r0, r9, r9)
            r1.f27528i = r2
            goto L_0x02e5
        L_0x0092:
            fm.d$b r0 = r7.f27518z
            byte[] r2 = new byte[r1]
            r0.f27527h = r2
            fm.d$b r0 = r7.f27518z
            byte[] r0 = r0.f27527h
            r8.b(r0, r9, r1)
            goto L_0x02e5
        L_0x00a1:
            int r0 = r7.L
            if (r0 == r4) goto L_0x00a6
            return
        L_0x00a6:
            android.util.SparseArray<fm.d$b> r0 = r7.f27500h
            int r2 = r7.R
            java.lang.Object r0 = r0.get(r2)
            fm.d$b r0 = (fm.d.b) r0
            int r2 = r7.U
            r7.a((fm.d.b) r0, (int) r2, (fj.h) r8, (int) r1)
            goto L_0x02e5
        L_0x00b7:
            int r2 = r7.L
            r5 = 8
            if (r2 != 0) goto L_0x00dc
            fm.f r2 = r7.f27499g
            long r11 = r2.a(r8, r9, r10, r5)
            int r2 = (int) r11
            r7.R = r2
            fm.f r2 = r7.f27499g
            int r2 = r2.b()
            r7.S = r2
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.N = r11
            r7.L = r10
            com.google.android.exoplayer2.util.q r2 = r7.f27504l
            r2.a()
        L_0x00dc:
            android.util.SparseArray<fm.d$b> r2 = r7.f27500h
            int r6 = r7.R
            java.lang.Object r2 = r2.get(r6)
            r11 = r2
            fm.d$b r11 = (fm.d.b) r11
            if (r11 != 0) goto L_0x00f3
            int r0 = r7.S
            int r0 = r1 - r0
            r8.b(r0)
            r7.L = r9
            return
        L_0x00f3:
            int r2 = r7.L
            if (r2 != r10) goto L_0x029c
            r2 = 3
            r7.a((fj.h) r8, (int) r2)
            com.google.android.exoplayer2.util.q r6 = r7.f27504l
            byte[] r6 = r6.f17159a
            byte r6 = r6[r4]
            r6 = r6 & 6
            int r6 = r6 >> r10
            r12 = 255(0xff, float:3.57E-43)
            if (r6 != 0) goto L_0x011a
            r7.P = r10
            int[] r6 = r7.Q
            int[] r6 = a((int[]) r6, (int) r10)
            r7.Q = r6
            int r13 = r7.S
            int r1 = r1 - r13
            int r1 = r1 - r2
            r6[r9] = r1
            goto L_0x0234
        L_0x011a:
            r13 = 4
            r7.a((fj.h) r8, (int) r13)
            com.google.android.exoplayer2.util.q r14 = r7.f27504l
            byte[] r14 = r14.f17159a
            byte r14 = r14[r2]
            r14 = r14 & r12
            int r14 = r14 + r10
            r7.P = r14
            int[] r15 = r7.Q
            int[] r14 = a((int[]) r15, (int) r14)
            r7.Q = r14
            if (r6 != r4) goto L_0x013e
            int r2 = r7.S
            int r1 = r1 - r2
            int r1 = r1 - r13
            int r2 = r7.P
            int r1 = r1 / r2
            java.util.Arrays.fill(r14, r9, r2, r1)
            goto L_0x0234
        L_0x013e:
            if (r6 != r10) goto L_0x0175
            r2 = 0
            r6 = 0
        L_0x0142:
            int r14 = r7.P
            int r15 = r14 + -1
            if (r2 >= r15) goto L_0x0169
            int[] r14 = r7.Q
            r14[r2] = r9
        L_0x014c:
            int r13 = r13 + r10
            r7.a((fj.h) r8, (int) r13)
            com.google.android.exoplayer2.util.q r14 = r7.f27504l
            byte[] r14 = r14.f17159a
            int r15 = r13 + -1
            byte r14 = r14[r15]
            r14 = r14 & r12
            int[] r15 = r7.Q
            r16 = r15[r2]
            int r16 = r16 + r14
            r15[r2] = r16
            if (r14 == r12) goto L_0x014c
            r14 = r15[r2]
            int r6 = r6 + r14
            int r2 = r2 + 1
            goto L_0x0142
        L_0x0169:
            int[] r2 = r7.Q
            int r14 = r14 - r10
            int r15 = r7.S
            int r1 = r1 - r15
            int r1 = r1 - r13
            int r1 = r1 - r6
            r2[r14] = r1
            goto L_0x0234
        L_0x0175:
            if (r6 != r2) goto L_0x0283
            r2 = 0
            r6 = 0
        L_0x0179:
            int r14 = r7.P
            int r15 = r14 + -1
            if (r2 >= r15) goto L_0x0229
            int[] r14 = r7.Q
            r14[r2] = r9
            int r13 = r13 + 1
            r7.a((fj.h) r8, (int) r13)
            com.google.android.exoplayer2.util.q r14 = r7.f27504l
            byte[] r14 = r14.f17159a
            int r15 = r13 + -1
            byte r14 = r14[r15]
            if (r14 == 0) goto L_0x0221
            r16 = 0
            r14 = 0
        L_0x0195:
            if (r14 >= r5) goto L_0x01ef
            int r18 = 7 - r14
            int r18 = r10 << r18
            com.google.android.exoplayer2.util.q r3 = r7.f27504l
            byte[] r3 = r3.f17159a
            byte r3 = r3[r15]
            r3 = r3 & r18
            if (r3 == 0) goto L_0x01e6
            int r13 = r13 + r14
            r7.a((fj.h) r8, (int) r13)
            com.google.android.exoplayer2.util.q r3 = r7.f27504l
            byte[] r3 = r3.f17159a
            int r16 = r15 + 1
            byte r3 = r3[r15]
            r3 = r3 & r12
            r15 = r18 ^ -1
            r3 = r3 & r15
            long r9 = (long) r3
            r3 = r16
        L_0x01b8:
            r16 = r9
            if (r3 >= r13) goto L_0x01d2
            long r9 = r16 << r5
            com.google.android.exoplayer2.util.q r15 = r7.f27504l
            byte[] r15 = r15.f17159a
            int r16 = r3 + 1
            byte r3 = r15[r3]
            r3 = r3 & r12
            r19 = r13
            long r12 = (long) r3
            long r9 = r9 | r12
            r3 = r16
            r13 = r19
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x01b8
        L_0x01d2:
            r19 = r13
            if (r2 <= 0) goto L_0x01e1
            int r14 = r14 * 7
            int r14 = r14 + 6
            r9 = 1
            long r12 = r9 << r14
            long r12 = r12 - r9
            long r16 = r16 - r12
        L_0x01e1:
            r9 = r16
            r13 = r19
            goto L_0x01f1
        L_0x01e6:
            int r14 = r14 + 1
            r3 = 163(0xa3, float:2.28E-43)
            r9 = 0
            r10 = 1
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0195
        L_0x01ef:
            r9 = r16
        L_0x01f1:
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r3 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x0219
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x0219
            int r3 = (int) r9
            int[] r9 = r7.Q
            if (r2 != 0) goto L_0x0205
            goto L_0x020a
        L_0x0205:
            int r10 = r2 + -1
            r10 = r9[r10]
            int r3 = r3 + r10
        L_0x020a:
            r9[r2] = r3
            r3 = r9[r2]
            int r6 = r6 + r3
            int r2 = r2 + 1
            r3 = 163(0xa3, float:2.28E-43)
            r9 = 0
            r10 = 1
            r12 = 255(0xff, float:3.57E-43)
            goto L_0x0179
        L_0x0219:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "EBML lacing sample size out of range."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0221:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "No valid varint length mask found"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0229:
            int[] r2 = r7.Q
            r3 = 1
            int r14 = r14 - r3
            int r3 = r7.S
            int r1 = r1 - r3
            int r1 = r1 - r13
            int r1 = r1 - r6
            r2[r14] = r1
        L_0x0234:
            com.google.android.exoplayer2.util.q r1 = r7.f27504l
            byte[] r1 = r1.f17159a
            r2 = 0
            byte r1 = r1[r2]
            int r1 = r1 << r5
            com.google.android.exoplayer2.util.q r2 = r7.f27504l
            byte[] r2 = r2.f17159a
            r3 = 1
            byte r2 = r2[r3]
            r3 = 255(0xff, float:3.57E-43)
            r2 = r2 & r3
            r1 = r1 | r2
            long r2 = r7.G
            long r9 = (long) r1
            long r9 = r7.a((long) r9)
            long r2 = r2 + r9
            r7.M = r2
            com.google.android.exoplayer2.util.q r1 = r7.f27504l
            byte[] r1 = r1.f17159a
            byte r1 = r1[r4]
            r1 = r1 & r5
            if (r1 != r5) goto L_0x025c
            r1 = 1
            goto L_0x025d
        L_0x025c:
            r1 = 0
        L_0x025d:
            int r2 = r11.f27523d
            if (r2 == r4) goto L_0x0273
            r2 = 163(0xa3, float:2.28E-43)
            if (r0 != r2) goto L_0x0271
            com.google.android.exoplayer2.util.q r2 = r7.f27504l
            byte[] r2 = r2.f17159a
            byte r2 = r2[r4]
            r3 = 128(0x80, float:1.794E-43)
            r2 = r2 & r3
            if (r2 != r3) goto L_0x0271
            goto L_0x0273
        L_0x0271:
            r2 = 0
            goto L_0x0274
        L_0x0273:
            r2 = 1
        L_0x0274:
            if (r1 == 0) goto L_0x0279
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x027a
        L_0x0279:
            r1 = 0
        L_0x027a:
            r1 = r1 | r2
            r7.T = r1
            r7.L = r4
            r1 = 0
            r7.O = r1
            goto L_0x029c
        L_0x0283:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            r1 = 36
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Unexpected lacing value: "
            r2.append(r1)
            r2.append(r6)
            java.lang.String r1 = r2.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x029c:
            r1 = 163(0xa3, float:2.28E-43)
            if (r0 != r1) goto L_0x02ce
        L_0x02a0:
            int r0 = r7.O
            int r1 = r7.P
            if (r0 >= r1) goto L_0x02ca
            int[] r1 = r7.Q
            r0 = r1[r0]
            int r5 = r7.a((fj.h) r8, (fm.d.b) r11, (int) r0)
            long r0 = r7.M
            int r2 = r7.O
            int r3 = r11.f27524e
            int r2 = r2 * r3
            int r2 = r2 / 1000
            long r2 = (long) r2
            long r2 = r2 + r0
            int r4 = r7.T
            r6 = 0
            r0 = r20
            r1 = r11
            r0.a(r1, r2, r4, r5, r6)
            int r0 = r7.O
            r1 = 1
            int r0 = r0 + r1
            r7.O = r0
            goto L_0x02a0
        L_0x02ca:
            r0 = 0
            r7.L = r0
            goto L_0x02e5
        L_0x02ce:
            int r0 = r7.O
            int r1 = r7.P
            if (r0 >= r1) goto L_0x02e5
            int[] r1 = r7.Q
            r2 = r1[r0]
            int r2 = r7.a((fj.h) r8, (fm.d.b) r11, (int) r2)
            r1[r0] = r2
            int r0 = r7.O
            r1 = 1
            int r0 = r0 + r1
            r7.O = r0
            goto L_0x02ce
        L_0x02e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.d.a(int, int, fj.h):void");
    }

    /* access modifiers changed from: protected */
    public void a(int i2, long j2) throws ParserException {
        if (i2 != 20529) {
            if (i2 != 20530) {
                boolean z2 = false;
                switch (i2) {
                    case IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED:
                        this.f27518z.f27523d = (int) j2;
                        return;
                    case IChannelListener.CMD_CHANNEL_CARD_PROTECTED:
                        b bVar = this.f27518z;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        bVar.T = z2;
                        return;
                    case 155:
                        this.N = a(j2);
                        return;
                    case 159:
                        this.f27518z.M = (int) j2;
                        return;
                    case 176:
                        this.f27518z.f27531l = (int) j2;
                        return;
                    case 179:
                        this.H.a(a(j2));
                        return;
                    case 186:
                        this.f27518z.f27532m = (int) j2;
                        return;
                    case 215:
                        this.f27518z.f27522c = (int) j2;
                        return;
                    case 231:
                        this.G = a(j2);
                        return;
                    case 238:
                        this.U = (int) j2;
                        return;
                    case 241:
                        if (!this.J) {
                            this.I.a(j2);
                            this.J = true;
                            return;
                        }
                        return;
                    case 251:
                        this.V = true;
                        return;
                    case 16980:
                        if (j2 != 3) {
                            StringBuilder sb = new StringBuilder(50);
                            sb.append("ContentCompAlgo ");
                            sb.append(j2);
                            sb.append(" not supported");
                            throw new ParserException(sb.toString());
                        }
                        return;
                    case 17029:
                        if (j2 < 1 || j2 > 2) {
                            StringBuilder sb2 = new StringBuilder(53);
                            sb2.append("DocTypeReadVersion ");
                            sb2.append(j2);
                            sb2.append(" not supported");
                            throw new ParserException(sb2.toString());
                        }
                        return;
                    case 17143:
                        if (j2 != 1) {
                            StringBuilder sb3 = new StringBuilder(50);
                            sb3.append("EBMLReadVersion ");
                            sb3.append(j2);
                            sb3.append(" not supported");
                            throw new ParserException(sb3.toString());
                        }
                        return;
                    case 18401:
                        if (j2 != 5) {
                            StringBuilder sb4 = new StringBuilder(49);
                            sb4.append("ContentEncAlgo ");
                            sb4.append(j2);
                            sb4.append(" not supported");
                            throw new ParserException(sb4.toString());
                        }
                        return;
                    case 18408:
                        if (j2 != 1) {
                            StringBuilder sb5 = new StringBuilder(56);
                            sb5.append("AESSettingsCipherMode ");
                            sb5.append(j2);
                            sb5.append(" not supported");
                            throw new ParserException(sb5.toString());
                        }
                        return;
                    case 21420:
                        this.C = j2 + this.f27514v;
                        return;
                    case 21432:
                        int i3 = (int) j2;
                        if (i3 == 0) {
                            this.f27518z.f27541v = 0;
                            return;
                        } else if (i3 == 1) {
                            this.f27518z.f27541v = 2;
                            return;
                        } else if (i3 == 3) {
                            this.f27518z.f27541v = 1;
                            return;
                        } else if (i3 == 15) {
                            this.f27518z.f27541v = 3;
                            return;
                        } else {
                            return;
                        }
                    case 21680:
                        this.f27518z.f27533n = (int) j2;
                        return;
                    case 21682:
                        this.f27518z.f27535p = (int) j2;
                        return;
                    case 21690:
                        this.f27518z.f27534o = (int) j2;
                        return;
                    case 21930:
                        b bVar2 = this.f27518z;
                        if (j2 == 1) {
                            z2 = true;
                        }
                        bVar2.S = z2;
                        return;
                    case 21998:
                        this.f27518z.f27525f = (int) j2;
                        return;
                    case 22186:
                        this.f27518z.P = j2;
                        return;
                    case 22203:
                        this.f27518z.Q = j2;
                        return;
                    case 25188:
                        this.f27518z.N = (int) j2;
                        return;
                    case 30321:
                        int i4 = (int) j2;
                        if (i4 == 0) {
                            this.f27518z.f27536q = 0;
                            return;
                        } else if (i4 == 1) {
                            this.f27518z.f27536q = 1;
                            return;
                        } else if (i4 == 2) {
                            this.f27518z.f27536q = 2;
                            return;
                        } else if (i4 == 3) {
                            this.f27518z.f27536q = 3;
                            return;
                        } else {
                            return;
                        }
                    case 2352003:
                        this.f27518z.f27524e = (int) j2;
                        return;
                    case 2807729:
                        this.f27515w = j2;
                        return;
                    default:
                        switch (i2) {
                            case 21945:
                                int i5 = (int) j2;
                                if (i5 == 1) {
                                    this.f27518z.f27545z = 2;
                                    return;
                                } else if (i5 == 2) {
                                    this.f27518z.f27545z = 1;
                                    return;
                                } else {
                                    return;
                                }
                            case 21946:
                                int i6 = (int) j2;
                                if (i6 != 1) {
                                    if (i6 == 16) {
                                        this.f27518z.f27544y = 6;
                                        return;
                                    } else if (i6 == 18) {
                                        this.f27518z.f27544y = 7;
                                        return;
                                    } else if (!(i6 == 6 || i6 == 7)) {
                                        return;
                                    }
                                }
                                this.f27518z.f27544y = 3;
                                return;
                            case 21947:
                                this.f27518z.f27542w = true;
                                int i7 = (int) j2;
                                if (i7 == 1) {
                                    this.f27518z.f27543x = 1;
                                    return;
                                } else if (i7 == 9) {
                                    this.f27518z.f27543x = 6;
                                    return;
                                } else if (i7 == 4 || i7 == 5 || i7 == 6 || i7 == 7) {
                                    this.f27518z.f27543x = 2;
                                    return;
                                } else {
                                    return;
                                }
                            case 21948:
                                this.f27518z.A = (int) j2;
                                return;
                            case 21949:
                                this.f27518z.B = (int) j2;
                                return;
                            default:
                                return;
                        }
                }
            } else if (j2 != 1) {
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j2);
                sb6.append(" not supported");
                throw new ParserException(sb6.toString());
            }
        } else if (j2 != 0) {
            StringBuilder sb7 = new StringBuilder(55);
            sb7.append("ContentEncodingOrder ");
            sb7.append(j2);
            sb7.append(" not supported");
            throw new ParserException(sb7.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, long j2, long j3) throws ParserException {
        if (i2 == 160) {
            this.V = false;
        } else if (i2 == 174) {
            this.f27518z = new b();
        } else if (i2 == 187) {
            this.J = false;
        } else if (i2 == 19899) {
            this.B = -1;
            this.C = -1;
        } else if (i2 == 20533) {
            this.f27518z.f27526g = true;
        } else if (i2 == 21968) {
            this.f27518z.f27542w = true;
        } else if (i2 == 408125543) {
            long j4 = this.f27514v;
            if (j4 == -1 || j4 == j2) {
                this.f27514v = j2;
                this.f27513u = j3;
                return;
            }
            throw new ParserException("Multiple Segment elements not supported");
        } else if (i2 == 475249515) {
            this.H = new l();
            this.I = new l();
        } else if (i2 != 524531317 || this.A) {
        } else {
            if (!this.f27501i || this.E == -1) {
                this.f27497af.a(new s.b(this.f27517y));
                this.A = true;
                return;
            }
            this.D = true;
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str) throws ParserException {
        if (i2 == 134) {
            this.f27518z.f27521b = str;
        } else if (i2 != 17026) {
            if (i2 == 21358) {
                this.f27518z.f27520a = str;
            } else if (i2 == 2274716) {
                String unused = this.f27518z.W = str;
            }
        } else if (!"webm".equals(str) && !"matroska".equals(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new ParserException(sb.toString());
        }
    }

    public void a(long j2, long j3) {
        this.G = -9223372036854775807L;
        this.L = 0;
        this.f27498f.a();
        this.f27499g.a();
        e();
        for (int i2 = 0; i2 < this.f27500h.size(); i2++) {
            this.f27500h.valueAt(i2).b();
        }
    }

    public final void a(i iVar) {
        this.f27497af = iVar;
    }

    /* access modifiers changed from: protected */
    public void a(b bVar, int i2, h hVar, int i3) throws IOException, InterruptedException {
        if (i2 != 4 || !"V_VP9".equals(bVar.f27521b)) {
            hVar.b(i3);
            return;
        }
        this.f27511s.a(i3);
        hVar.b(this.f27511s.f17159a, 0, i3);
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        return new e().a(hVar);
    }

    /* access modifiers changed from: protected */
    public boolean b(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    public final void c() {
    }

    /* access modifiers changed from: protected */
    public void c(int i2) throws ParserException {
        if (i2 != 160) {
            if (i2 == 174) {
                if (a(this.f27518z.f27521b)) {
                    b bVar = this.f27518z;
                    bVar.a(this.f27497af, bVar.f27522c);
                    this.f27500h.put(this.f27518z.f27522c, this.f27518z);
                }
                this.f27518z = null;
            } else if (i2 == 19899) {
                int i3 = this.B;
                if (i3 != -1) {
                    long j2 = this.C;
                    if (j2 != -1) {
                        if (i3 == 475249515) {
                            this.E = j2;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            } else if (i2 != 25152) {
                if (i2 != 28032) {
                    if (i2 == 357149030) {
                        if (this.f27515w == -9223372036854775807L) {
                            this.f27515w = 1000000;
                        }
                        long j3 = this.f27516x;
                        if (j3 != -9223372036854775807L) {
                            this.f27517y = a(j3);
                        }
                    } else if (i2 != 374648427) {
                        if (i2 == 475249515 && !this.A) {
                            this.f27497af.a(f());
                            this.A = true;
                        }
                    } else if (this.f27500h.size() != 0) {
                        this.f27497af.a();
                    } else {
                        throw new ParserException("No valid tracks were found");
                    }
                } else if (this.f27518z.f27526g && this.f27518z.f27527h != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
            } else if (!this.f27518z.f27526g) {
            } else {
                if (this.f27518z.f27528i != null) {
                    this.f27518z.f27530k = new DrmInitData(new DrmInitData.SchemeData(e.f15477a, "video/webm", this.f27518z.f27528i.f27410b));
                    return;
                }
                throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
            }
        } else if (this.L == 2) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.P; i5++) {
                i4 += this.Q[i5];
            }
            b bVar2 = this.f27500h.get(this.R);
            for (int i6 = 0; i6 < this.P; i6++) {
                long j4 = ((long) ((bVar2.f27524e * i6) / 1000)) + this.M;
                int i7 = this.T;
                if (i6 == 0 && !this.V) {
                    i7 |= 1;
                }
                int i8 = this.Q[i6];
                i4 -= i8;
                a(bVar2, j4, i7, i8, i4);
            }
            this.L = 0;
        }
    }
}
