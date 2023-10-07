package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.d;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.c;
import androidx.constraintlayout.solver.widgets.analyzer.k;
import androidx.constraintlayout.solver.widgets.analyzer.m;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget {
    public static float X = 0.5f;
    public ConstraintAnchor A = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    public ConstraintAnchor B = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    public ConstraintAnchor C = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor D = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor E = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    public ConstraintAnchor F;
    public ConstraintAnchor[] G;
    protected ArrayList<ConstraintAnchor> H;
    public DimensionBehaviour[] I;
    public ConstraintWidget J;
    int K;
    int L;
    public float M;
    protected int N;
    protected int O;
    protected int P;
    int Q;
    int R;
    protected int S;
    protected int T;
    int U;
    protected int V;
    protected int W;
    float Y;
    float Z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f2239a = true;
    private int[] aA = {SubsamplingScaleImageView.TILE_SIZE_AUTO, SubsamplingScaleImageView.TILE_SIZE_AUTO};
    private float aB = 0.0f;
    private boolean aC = false;
    private boolean aD;
    private boolean aE = false;
    private int aF = 0;
    private int aG = 0;
    private boolean[] aH;
    private Object aI;
    private int aJ;
    private int aK;
    private String aL;
    private String aM;

    /* renamed from: aa  reason: collision with root package name */
    int f2240aa;

    /* renamed from: ab  reason: collision with root package name */
    int f2241ab;

    /* renamed from: ac  reason: collision with root package name */
    int f2242ac;

    /* renamed from: ad  reason: collision with root package name */
    int f2243ad;

    /* renamed from: ae  reason: collision with root package name */
    boolean f2244ae;

    /* renamed from: af  reason: collision with root package name */
    boolean f2245af;

    /* renamed from: ag  reason: collision with root package name */
    boolean f2246ag;

    /* renamed from: ah  reason: collision with root package name */
    boolean f2247ah;

    /* renamed from: ai  reason: collision with root package name */
    boolean f2248ai;

    /* renamed from: aj  reason: collision with root package name */
    boolean f2249aj;

    /* renamed from: ak  reason: collision with root package name */
    boolean f2250ak;

    /* renamed from: al  reason: collision with root package name */
    int f2251al;

    /* renamed from: am  reason: collision with root package name */
    int f2252am;

    /* renamed from: an  reason: collision with root package name */
    boolean f2253an;

    /* renamed from: ao  reason: collision with root package name */
    boolean f2254ao;

    /* renamed from: ap  reason: collision with root package name */
    public float[] f2255ap;

    /* renamed from: aq  reason: collision with root package name */
    protected ConstraintWidget[] f2256aq;

    /* renamed from: ar  reason: collision with root package name */
    protected ConstraintWidget[] f2257ar;

    /* renamed from: as  reason: collision with root package name */
    ConstraintWidget f2258as;

    /* renamed from: at  reason: collision with root package name */
    ConstraintWidget f2259at;

    /* renamed from: au  reason: collision with root package name */
    public int f2260au;

    /* renamed from: av  reason: collision with root package name */
    public int f2261av;

    /* renamed from: aw  reason: collision with root package name */
    private boolean f2262aw = false;

    /* renamed from: ax  reason: collision with root package name */
    private boolean f2263ax = true;

    /* renamed from: ay  reason: collision with root package name */
    private boolean f2264ay = false;

    /* renamed from: az  reason: collision with root package name */
    private boolean f2265az = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2266b = false;

    /* renamed from: c  reason: collision with root package name */
    public WidgetRun[] f2267c = new WidgetRun[2];

    /* renamed from: d  reason: collision with root package name */
    public c f2268d;

    /* renamed from: e  reason: collision with root package name */
    public c f2269e;

    /* renamed from: f  reason: collision with root package name */
    public k f2270f = null;

    /* renamed from: g  reason: collision with root package name */
    public m f2271g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean[] f2272h = {true, true};

    /* renamed from: i  reason: collision with root package name */
    boolean f2273i = false;

    /* renamed from: j  reason: collision with root package name */
    public int f2274j = -1;

    /* renamed from: k  reason: collision with root package name */
    public int f2275k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f2276l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f2277m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int[] f2278n = new int[2];

    /* renamed from: o  reason: collision with root package name */
    public int f2279o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f2280p = 0;

    /* renamed from: q  reason: collision with root package name */
    public float f2281q = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    public int f2282r = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f2283s = 0;

    /* renamed from: t  reason: collision with root package name */
    public float f2284t = 1.0f;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2285u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2286v;

    /* renamed from: w  reason: collision with root package name */
    int f2287w = -1;

    /* renamed from: x  reason: collision with root package name */
    float f2288x = 1.0f;

    /* renamed from: y  reason: collision with root package name */
    public ConstraintAnchor f2289y = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);

    /* renamed from: z  reason: collision with root package name */
    public ConstraintAnchor f2290z = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2291a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2292b;

        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x008f */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2292b = r0
                r1 = 1
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f2292b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f2292b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f2292b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type[] r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f2291a = r4
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = f2291a     // Catch:{ NoSuchFieldError -> 0x004e }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f2291a     // Catch:{ NoSuchFieldError -> 0x0058 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = f2291a     // Catch:{ NoSuchFieldError -> 0x0062 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = f2291a     // Catch:{ NoSuchFieldError -> 0x006d }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r0 = f2291a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f2291a     // Catch:{ NoSuchFieldError -> 0x0083 }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f2291a     // Catch:{ NoSuchFieldError -> 0x008f }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                int[] r0 = f2291a     // Catch:{ NoSuchFieldError -> 0x009b }
                androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.NONE     // Catch:{ NoSuchFieldError -> 0x009b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.<clinit>():void");
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.F = constraintAnchor;
        this.G = new ConstraintAnchor[]{this.f2289y, this.A, this.f2290z, this.B, this.C, constraintAnchor};
        this.H = new ArrayList<>();
        this.aH = new boolean[2];
        this.I = new DimensionBehaviour[]{DimensionBehaviour.FIXED, DimensionBehaviour.FIXED};
        this.J = null;
        this.K = 0;
        this.L = 0;
        this.M = 0.0f;
        this.N = -1;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        float f2 = X;
        this.Y = f2;
        this.Z = f2;
        this.aJ = 0;
        this.aK = 0;
        this.aL = null;
        this.aM = null;
        this.f2250ak = false;
        this.f2251al = 0;
        this.f2252am = 0;
        this.f2255ap = new float[]{-1.0f, -1.0f};
        this.f2256aq = new ConstraintWidget[]{null, null};
        this.f2257ar = new ConstraintWidget[]{null, null};
        this.f2258as = null;
        this.f2259at = null;
        this.f2260au = -1;
        this.f2261av = -1;
        b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03c6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x048b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:313:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x04c4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:344:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:348:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.constraintlayout.solver.d r32, boolean r33, boolean r34, boolean r35, boolean r36, androidx.constraintlayout.solver.SolverVariable r37, androidx.constraintlayout.solver.SolverVariable r38, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r39, boolean r40, androidx.constraintlayout.solver.widgets.ConstraintAnchor r41, androidx.constraintlayout.solver.widgets.ConstraintAnchor r42, int r43, int r44, int r45, int r46, float r47, boolean r48, boolean r49, boolean r50, boolean r51, boolean r52, int r53, int r54, int r55, int r56, float r57, boolean r58) {
        /*
            r31 = this;
            r0 = r31
            r10 = r32
            r11 = r37
            r12 = r38
            r13 = r41
            r14 = r42
            r15 = r45
            r1 = r46
            r2 = r54
            r3 = r55
            r4 = r56
            androidx.constraintlayout.solver.SolverVariable r9 = r10.a((java.lang.Object) r13)
            androidx.constraintlayout.solver.SolverVariable r8 = r10.a((java.lang.Object) r14)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r41.k()
            androidx.constraintlayout.solver.SolverVariable r7 = r10.a((java.lang.Object) r5)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r42.k()
            androidx.constraintlayout.solver.SolverVariable r6 = r10.a((java.lang.Object) r5)
            androidx.constraintlayout.solver.e r5 = androidx.constraintlayout.solver.d.a()
            if (r5 == 0) goto L_0x0040
            androidx.constraintlayout.solver.e r5 = androidx.constraintlayout.solver.d.a()
            long r11 = r5.f2189w
            r16 = 1
            long r11 = r11 + r16
            r5.f2189w = r11
        L_0x0040:
            boolean r11 = r41.m()
            boolean r12 = r42.m()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r0.F
            boolean r16 = r5.m()
            if (r12 == 0) goto L_0x0053
            int r5 = r11 + 1
            goto L_0x0054
        L_0x0053:
            r5 = r11
        L_0x0054:
            if (r16 == 0) goto L_0x0058
            int r5 = r5 + 1
        L_0x0058:
            if (r48 == 0) goto L_0x005d
            r18 = 3
            goto L_0x005f
        L_0x005d:
            r18 = r53
        L_0x005f:
            int[] r17 = androidx.constraintlayout.solver.widgets.ConstraintWidget.AnonymousClass1.f2292b
            int r19 = r39.ordinal()
            r2 = r17[r19]
            r14 = 1
            if (r2 == r14) goto L_0x0073
            r14 = 2
            if (r2 == r14) goto L_0x0073
            r14 = 3
            if (r2 == r14) goto L_0x0073
            r14 = 4
            if (r2 == r14) goto L_0x0078
        L_0x0073:
            r2 = r18
        L_0x0075:
            r18 = 0
            goto L_0x007e
        L_0x0078:
            r2 = r18
            if (r2 == r14) goto L_0x0075
            r18 = 1
        L_0x007e:
            int r14 = r0.aK
            r13 = 8
            if (r14 != r13) goto L_0x0088
            r14 = 0
            r18 = 0
            goto L_0x008a
        L_0x0088:
            r14 = r44
        L_0x008a:
            if (r58 == 0) goto L_0x00a8
            if (r11 != 0) goto L_0x0098
            if (r12 != 0) goto L_0x0098
            if (r16 != 0) goto L_0x0098
            r13 = r43
            r10.a((androidx.constraintlayout.solver.SolverVariable) r9, (int) r13)
            goto L_0x00a8
        L_0x0098:
            if (r11 == 0) goto L_0x00a8
            if (r12 != 0) goto L_0x00a8
            int r13 = r41.j()
            r21 = r6
            r6 = 8
            r10.c(r9, r7, r13, r6)
            goto L_0x00ac
        L_0x00a8:
            r21 = r6
            r6 = 8
        L_0x00ac:
            if (r18 != 0) goto L_0x00db
            r6 = 0
            if (r40 == 0) goto L_0x00c5
            r13 = 3
            r10.c(r8, r9, r6, r13)
            r13 = 8
            if (r15 <= 0) goto L_0x00bc
            r10.a((androidx.constraintlayout.solver.SolverVariable) r8, (androidx.constraintlayout.solver.SolverVariable) r9, (int) r15, (int) r13)
        L_0x00bc:
            r14 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r14) goto L_0x00ca
            r10.b((androidx.constraintlayout.solver.SolverVariable) r8, (androidx.constraintlayout.solver.SolverVariable) r9, (int) r1, (int) r13)
            goto L_0x00ca
        L_0x00c5:
            r13 = 8
            r10.c(r8, r9, r14, r13)
        L_0x00ca:
            r22 = r3
            r1 = r4
            r14 = r7
            r15 = r8
        L_0x00cf:
            r23 = r18
            r13 = r21
            r19 = 0
            r18 = r36
        L_0x00d7:
            r21 = r5
            goto L_0x01c2
        L_0x00db:
            r1 = 2
            r6 = 0
            if (r5 == r1) goto L_0x0103
            if (r48 != 0) goto L_0x0103
            r1 = 1
            if (r2 == r1) goto L_0x00e6
            if (r2 != 0) goto L_0x0103
        L_0x00e6:
            int r1 = java.lang.Math.max(r3, r14)
            if (r4 <= 0) goto L_0x00f0
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00f0:
            r13 = 8
            r10.c(r8, r9, r1, r13)
            r18 = r36
            r22 = r3
            r1 = r4
            r14 = r7
            r15 = r8
            r13 = r21
            r19 = 0
            r23 = 0
            goto L_0x00d7
        L_0x0103:
            r1 = -2
            if (r3 != r1) goto L_0x0108
            r13 = r14
            goto L_0x0109
        L_0x0108:
            r13 = r3
        L_0x0109:
            if (r4 != r1) goto L_0x010d
            r1 = r14
            goto L_0x010e
        L_0x010d:
            r1 = r4
        L_0x010e:
            if (r14 <= 0) goto L_0x0114
            r3 = 1
            if (r2 == r3) goto L_0x0114
            r14 = 0
        L_0x0114:
            if (r13 <= 0) goto L_0x011f
            r3 = 8
            r10.a((androidx.constraintlayout.solver.SolverVariable) r8, (androidx.constraintlayout.solver.SolverVariable) r9, (int) r13, (int) r3)
            int r14 = java.lang.Math.max(r14, r13)
        L_0x011f:
            if (r1 <= 0) goto L_0x0138
            if (r34 == 0) goto L_0x0128
            r3 = 1
            if (r2 != r3) goto L_0x0128
            r3 = 0
            goto L_0x0129
        L_0x0128:
            r3 = 1
        L_0x0129:
            if (r3 == 0) goto L_0x0131
            r3 = 8
            r10.b((androidx.constraintlayout.solver.SolverVariable) r8, (androidx.constraintlayout.solver.SolverVariable) r9, (int) r1, (int) r3)
            goto L_0x0133
        L_0x0131:
            r3 = 8
        L_0x0133:
            int r14 = java.lang.Math.min(r14, r1)
            goto L_0x013a
        L_0x0138:
            r3 = 8
        L_0x013a:
            r4 = 1
            if (r2 != r4) goto L_0x014f
            if (r34 == 0) goto L_0x0143
            r10.c(r8, r9, r14, r3)
            goto L_0x014a
        L_0x0143:
            r4 = 5
            r10.c(r8, r9, r14, r4)
            r10.b((androidx.constraintlayout.solver.SolverVariable) r8, (androidx.constraintlayout.solver.SolverVariable) r9, (int) r14, (int) r3)
        L_0x014a:
            r14 = r7
            r15 = r8
            r22 = r13
            goto L_0x00cf
        L_0x014f:
            r14 = 2
            if (r2 != r14) goto L_0x01b2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = r41.i()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r3 == r4) goto L_0x0174
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = r41.i()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r3 != r4) goto L_0x0163
            goto L_0x0174
        L_0x0163:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.SolverVariable r3 = r10.a((java.lang.Object) r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            goto L_0x0184
        L_0x0174:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.SolverVariable r3 = r10.a((java.lang.Object) r3)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r0.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
        L_0x0184:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            androidx.constraintlayout.solver.SolverVariable r4 = r10.a((java.lang.Object) r4)
            r18 = r3
            r6 = r4
            androidx.constraintlayout.solver.b r3 = r32.c()
            r4 = r8
            r14 = r5
            r5 = r9
            r40 = r13
            r13 = r21
            r19 = 0
            r21 = r14
            r14 = r7
            r7 = r18
            r15 = r8
            r8 = r57
            androidx.constraintlayout.solver.b r3 = r3.a(r4, r5, r6, r7, r8)
            r10.a((androidx.constraintlayout.solver.b) r3)
            r18 = r36
            r22 = r40
            r23 = 0
            goto L_0x01c2
        L_0x01b2:
            r14 = r7
            r15 = r8
            r40 = r13
            r13 = r21
            r19 = 0
            r21 = r5
            r22 = r40
            r23 = r18
            r18 = 1
        L_0x01c2:
            if (r58 == 0) goto L_0x04b8
            if (r50 == 0) goto L_0x01d2
            r1 = r37
            r4 = r38
            r2 = r15
            r5 = r21
            r3 = 0
            r6 = 2
            r15 = r9
            goto L_0x04c2
        L_0x01d2:
            if (r11 != 0) goto L_0x01da
            if (r12 != 0) goto L_0x01da
            if (r16 != 0) goto L_0x01da
            goto L_0x0485
        L_0x01da:
            if (r11 == 0) goto L_0x01e0
            if (r12 != 0) goto L_0x01e0
            goto L_0x0485
        L_0x01e0:
            if (r11 != 0) goto L_0x0216
            if (r12 == 0) goto L_0x0216
            int r1 = r42.j()
            int r1 = -r1
            r2 = 8
            r10.c(r15, r13, r1, r2)
            if (r34 == 0) goto L_0x0485
            boolean r1 = r0.f2262aw
            if (r1 == 0) goto L_0x020d
            boolean r1 = r9.f2100f
            if (r1 == 0) goto L_0x020d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r0.J
            if (r1 == 0) goto L_0x020d
            androidx.constraintlayout.solver.widgets.d r1 = (androidx.constraintlayout.solver.widgets.d) r1
            r7 = r41
            r8 = 0
            if (r33 == 0) goto L_0x0208
            r1.b((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r7)
            goto L_0x0485
        L_0x0208:
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r7)
            goto L_0x0485
        L_0x020d:
            r8 = 0
            r6 = r37
            r1 = 5
            r10.a((androidx.constraintlayout.solver.SolverVariable) r9, (androidx.constraintlayout.solver.SolverVariable) r6, (int) r8, (int) r1)
            goto L_0x0485
        L_0x0216:
            r6 = r37
            r7 = r41
            r8 = 0
            if (r11 == 0) goto L_0x0485
            if (r12 == 0) goto L_0x0485
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.f2221c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r11 = r3.f2219a
            r12 = r42
            r3 = 2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r12.f2221c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r4.f2219a
            androidx.constraintlayout.solver.widgets.ConstraintWidget r4 = r31.v()
            r16 = 6
            if (r23 == 0) goto L_0x0311
            if (r2 != 0) goto L_0x027c
            if (r1 != 0) goto L_0x025b
            if (r22 != 0) goto L_0x025b
            boolean r1 = r14.f2100f
            if (r1 == 0) goto L_0x0252
            boolean r1 = r13.f2100f
            if (r1 == 0) goto L_0x0252
            int r1 = r41.j()
            r2 = 8
            r10.c(r9, r14, r1, r2)
            int r1 = r42.j()
            int r1 = -r1
            r10.c(r15, r13, r1, r2)
            return
        L_0x0252:
            r1 = 0
            r3 = 1
            r19 = 0
            r21 = 8
            r24 = 8
            goto L_0x0263
        L_0x025b:
            r1 = 1
            r3 = 0
            r19 = 1
            r21 = 5
            r24 = 5
        L_0x0263:
            boolean r8 = r11 instanceof androidx.constraintlayout.solver.widgets.a
            if (r8 != 0) goto L_0x0271
            boolean r8 = r5 instanceof androidx.constraintlayout.solver.widgets.a
            if (r8 == 0) goto L_0x026c
            goto L_0x0271
        L_0x026c:
            r8 = r38
            r25 = r21
            goto L_0x0277
        L_0x0271:
            r8 = r38
            r25 = r21
            r24 = 4
        L_0x0277:
            r21 = r3
            r3 = 6
            goto L_0x035d
        L_0x027c:
            r8 = 1
            if (r2 != r8) goto L_0x028d
            r8 = r38
            r1 = 1
            r3 = 6
            r19 = 1
            r21 = 0
            r24 = 4
        L_0x0289:
            r25 = 8
            goto L_0x035d
        L_0x028d:
            r8 = 3
            if (r2 != r8) goto L_0x030a
            int r8 = r0.f2287w
            r3 = -1
            if (r8 != r3) goto L_0x02a9
            r8 = r38
            r1 = 1
            if (r51 == 0) goto L_0x02a0
            if (r34 == 0) goto L_0x029e
            r3 = 5
            goto L_0x02a2
        L_0x029e:
            r3 = 4
            goto L_0x02a2
        L_0x02a0:
            r3 = 8
        L_0x02a2:
            r19 = 1
            r21 = 1
            r24 = 5
            goto L_0x0289
        L_0x02a9:
            if (r48 == 0) goto L_0x02cd
            r3 = r54
            r8 = 2
            if (r3 == r8) goto L_0x02b6
            r1 = 1
            if (r3 != r1) goto L_0x02b4
            goto L_0x02b6
        L_0x02b4:
            r1 = 0
            goto L_0x02b7
        L_0x02b6:
            r1 = 1
        L_0x02b7:
            if (r1 != 0) goto L_0x02bd
            r1 = 8
            r3 = 5
            goto L_0x02bf
        L_0x02bd:
            r1 = 5
            r3 = 4
        L_0x02bf:
            r8 = r38
            r25 = r1
            r24 = r3
            r1 = 1
            r3 = 6
            r19 = 1
            r21 = 1
            goto L_0x035d
        L_0x02cd:
            if (r1 <= 0) goto L_0x02db
            r8 = r38
            r1 = 1
            r3 = 6
            r19 = 1
            r21 = 1
            r24 = 5
            goto L_0x035b
        L_0x02db:
            if (r1 != 0) goto L_0x0301
            if (r22 != 0) goto L_0x0301
            if (r51 != 0) goto L_0x02ed
            r8 = r38
            r1 = 1
            r3 = 6
            r19 = 1
            r21 = 1
            r24 = 8
            goto L_0x035b
        L_0x02ed:
            if (r11 == r4) goto L_0x02f3
            if (r5 == r4) goto L_0x02f3
            r1 = 4
            goto L_0x02f4
        L_0x02f3:
            r1 = 5
        L_0x02f4:
            r8 = r38
            r25 = r1
            r1 = 1
            r3 = 6
            r19 = 1
            r21 = 1
            r24 = 4
            goto L_0x035d
        L_0x0301:
            r8 = r38
            r1 = 1
            r3 = 6
            r19 = 1
            r21 = 1
            goto L_0x0359
        L_0x030a:
            r8 = r38
            r1 = 0
            r3 = 6
            r19 = 0
            goto L_0x0357
        L_0x0311:
            boolean r1 = r14.f2100f
            if (r1 == 0) goto L_0x0351
            boolean r1 = r13.f2100f
            if (r1 == 0) goto L_0x0351
            int r1 = r41.j()
            int r2 = r42.j()
            r3 = 8
            r48 = r32
            r49 = r9
            r50 = r14
            r51 = r1
            r52 = r47
            r53 = r13
            r54 = r15
            r55 = r2
            r56 = r3
            r48.a(r49, r50, r51, r52, r53, r54, r55, r56)
            if (r34 == 0) goto L_0x0350
            if (r18 == 0) goto L_0x0350
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r12.f2221c
            if (r1 == 0) goto L_0x0347
            int r1 = r42.j()
            r8 = r38
            goto L_0x034a
        L_0x0347:
            r8 = r38
            r1 = 0
        L_0x034a:
            if (r13 == r8) goto L_0x0350
            r2 = 5
            r10.a((androidx.constraintlayout.solver.SolverVariable) r8, (androidx.constraintlayout.solver.SolverVariable) r15, (int) r1, (int) r2)
        L_0x0350:
            return
        L_0x0351:
            r8 = r38
            r1 = 1
            r3 = 6
            r19 = 1
        L_0x0357:
            r21 = 0
        L_0x0359:
            r24 = 4
        L_0x035b:
            r25 = 5
        L_0x035d:
            if (r19 == 0) goto L_0x0368
            if (r14 != r13) goto L_0x0368
            if (r11 == r4) goto L_0x0368
            r19 = 0
            r26 = 0
            goto L_0x036a
        L_0x0368:
            r26 = 1
        L_0x036a:
            if (r1 == 0) goto L_0x03ae
            if (r23 != 0) goto L_0x037f
            if (r49 != 0) goto L_0x037f
            if (r51 != 0) goto L_0x037f
            if (r14 != r6) goto L_0x037f
            if (r13 != r8) goto L_0x037f
            r25 = 0
            r26 = 8
            r27 = 0
            r28 = 8
            goto L_0x0387
        L_0x037f:
            r28 = r25
            r27 = r26
            r25 = r34
            r26 = r3
        L_0x0387:
            int r29 = r41.j()
            int r30 = r42.j()
            r1 = r32
            r3 = r2
            r2 = r9
            r12 = r3
            r3 = r14
            r39 = r12
            r12 = r4
            r4 = r29
            r29 = r12
            r12 = r5
            r5 = r47
            r6 = r13
            r7 = r15
            r8 = r30
            r20 = r15
            r15 = r9
            r9 = r26
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)
            r26 = r27
            goto L_0x03ba
        L_0x03ae:
            r39 = r2
            r29 = r4
            r12 = r5
            r20 = r15
            r15 = r9
            r28 = r25
            r25 = r34
        L_0x03ba:
            int r1 = r0.aK
            r2 = 8
            if (r1 != r2) goto L_0x03c7
            boolean r1 = r42.b()
            if (r1 != 0) goto L_0x03c7
            return
        L_0x03c7:
            if (r19 == 0) goto L_0x03ef
            if (r25 == 0) goto L_0x03d9
            if (r14 == r13) goto L_0x03d9
            if (r23 != 0) goto L_0x03d9
            boolean r1 = r11 instanceof androidx.constraintlayout.solver.widgets.a
            if (r1 != 0) goto L_0x03d7
            boolean r1 = r12 instanceof androidx.constraintlayout.solver.widgets.a
            if (r1 == 0) goto L_0x03d9
        L_0x03d7:
            r1 = 6
            goto L_0x03db
        L_0x03d9:
            r1 = r28
        L_0x03db:
            int r2 = r41.j()
            r10.a((androidx.constraintlayout.solver.SolverVariable) r15, (androidx.constraintlayout.solver.SolverVariable) r14, (int) r2, (int) r1)
            int r2 = r42.j()
            int r2 = -r2
            r3 = r20
            r10.b((androidx.constraintlayout.solver.SolverVariable) r3, (androidx.constraintlayout.solver.SolverVariable) r13, (int) r2, (int) r1)
            r28 = r1
            goto L_0x03f1
        L_0x03ef:
            r3 = r20
        L_0x03f1:
            if (r25 == 0) goto L_0x0402
            if (r52 == 0) goto L_0x0402
            boolean r1 = r11 instanceof androidx.constraintlayout.solver.widgets.a
            if (r1 != 0) goto L_0x0402
            boolean r1 = r12 instanceof androidx.constraintlayout.solver.widgets.a
            if (r1 != 0) goto L_0x0402
            r1 = 6
            r2 = 6
            r26 = 1
            goto L_0x0406
        L_0x0402:
            r1 = r24
            r2 = r28
        L_0x0406:
            if (r26 == 0) goto L_0x0456
            if (r21 == 0) goto L_0x0436
            if (r51 == 0) goto L_0x040e
            if (r35 == 0) goto L_0x0436
        L_0x040e:
            r4 = r29
            if (r11 == r4) goto L_0x0417
            if (r12 != r4) goto L_0x0415
            goto L_0x0417
        L_0x0415:
            r16 = r1
        L_0x0417:
            boolean r5 = r11 instanceof androidx.constraintlayout.solver.widgets.f
            if (r5 != 0) goto L_0x041f
            boolean r5 = r12 instanceof androidx.constraintlayout.solver.widgets.f
            if (r5 == 0) goto L_0x0421
        L_0x041f:
            r16 = 5
        L_0x0421:
            boolean r5 = r11 instanceof androidx.constraintlayout.solver.widgets.a
            if (r5 != 0) goto L_0x0429
            boolean r5 = r12 instanceof androidx.constraintlayout.solver.widgets.a
            if (r5 == 0) goto L_0x042b
        L_0x0429:
            r16 = 5
        L_0x042b:
            if (r51 == 0) goto L_0x042f
            r5 = 5
            goto L_0x0431
        L_0x042f:
            r5 = r16
        L_0x0431:
            int r1 = java.lang.Math.max(r5, r1)
            goto L_0x0438
        L_0x0436:
            r4 = r29
        L_0x0438:
            if (r25 == 0) goto L_0x0447
            int r1 = java.lang.Math.min(r2, r1)
            if (r48 == 0) goto L_0x0447
            if (r51 != 0) goto L_0x0447
            if (r11 == r4) goto L_0x0446
            if (r12 != r4) goto L_0x0447
        L_0x0446:
            r1 = 4
        L_0x0447:
            int r2 = r41.j()
            r10.c(r15, r14, r2, r1)
            int r2 = r42.j()
            int r2 = -r2
            r10.c(r3, r13, r2, r1)
        L_0x0456:
            if (r25 == 0) goto L_0x0468
            r1 = r37
            if (r1 != r14) goto L_0x0461
            int r2 = r41.j()
            goto L_0x0462
        L_0x0461:
            r2 = 0
        L_0x0462:
            if (r14 == r1) goto L_0x0468
            r4 = 5
            r10.a((androidx.constraintlayout.solver.SolverVariable) r15, (androidx.constraintlayout.solver.SolverVariable) r1, (int) r2, (int) r4)
        L_0x0468:
            if (r25 == 0) goto L_0x0482
            if (r23 == 0) goto L_0x0482
            r2 = r3
            if (r45 != 0) goto L_0x0483
            if (r22 != 0) goto L_0x0483
            if (r23 == 0) goto L_0x047c
            r1 = r39
            r3 = 3
            if (r1 != r3) goto L_0x047c
            r1 = 8
            r3 = 0
            goto L_0x047e
        L_0x047c:
            r3 = 0
            r1 = 5
        L_0x047e:
            r10.a((androidx.constraintlayout.solver.SolverVariable) r2, (androidx.constraintlayout.solver.SolverVariable) r15, (int) r3, (int) r1)
            goto L_0x0489
        L_0x0482:
            r2 = r3
        L_0x0483:
            r3 = 0
            goto L_0x0489
        L_0x0485:
            r2 = r15
            r3 = 0
            r25 = r34
        L_0x0489:
            if (r25 == 0) goto L_0x04b7
            if (r18 == 0) goto L_0x04b7
            r1 = r42
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r1.f2221c
            if (r4 == 0) goto L_0x0497
            int r3 = r42.j()
        L_0x0497:
            r4 = r38
            if (r13 == r4) goto L_0x04b7
            boolean r5 = r0.f2262aw
            if (r5 == 0) goto L_0x04b3
            boolean r5 = r2.f2100f
            if (r5 == 0) goto L_0x04b3
            androidx.constraintlayout.solver.widgets.ConstraintWidget r5 = r0.J
            if (r5 == 0) goto L_0x04b3
            androidx.constraintlayout.solver.widgets.d r5 = (androidx.constraintlayout.solver.widgets.d) r5
            if (r33 == 0) goto L_0x04af
            r5.d((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r1)
            goto L_0x04b2
        L_0x04af:
            r5.c(r1)
        L_0x04b2:
            return
        L_0x04b3:
            r1 = 5
            r10.a((androidx.constraintlayout.solver.SolverVariable) r4, (androidx.constraintlayout.solver.SolverVariable) r2, (int) r3, (int) r1)
        L_0x04b7:
            return
        L_0x04b8:
            r1 = r37
            r4 = r38
            r2 = r15
            r3 = 0
            r15 = r9
            r5 = r21
            r6 = 2
        L_0x04c2:
            if (r5 >= r6) goto L_0x050b
            if (r34 == 0) goto L_0x050b
            if (r18 == 0) goto L_0x050b
            r5 = 8
            r10.a((androidx.constraintlayout.solver.SolverVariable) r15, (androidx.constraintlayout.solver.SolverVariable) r1, (int) r3, (int) r5)
            if (r33 != 0) goto L_0x04d8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.C
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.f2221c
            if (r1 != 0) goto L_0x04d6
            goto L_0x04d8
        L_0x04d6:
            r13 = 0
            goto L_0x04d9
        L_0x04d8:
            r13 = 1
        L_0x04d9:
            if (r33 != 0) goto L_0x0503
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.C
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.f2221c
            if (r1 == 0) goto L_0x0503
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r0.C
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r1.f2221c
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.f2219a
            float r5 = r1.M
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0501
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r1.I
            r5 = r5[r3]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0501
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.I
            r5 = 1
            r1 = r1[r5]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r6) goto L_0x0501
            r14 = 1
            goto L_0x0504
        L_0x0501:
            r14 = 0
            goto L_0x0504
        L_0x0503:
            r14 = r13
        L_0x0504:
            if (r14 == 0) goto L_0x050b
            r1 = 8
            r10.a((androidx.constraintlayout.solver.SolverVariable) r4, (androidx.constraintlayout.solver.SolverVariable) r2, (int) r3, (int) r1)
        L_0x050b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.a(androidx.constraintlayout.solver.d, boolean, boolean, boolean, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    private boolean a(int i2) {
        int i3 = i2 * 2;
        if (this.G[i3].f2221c != null) {
            ConstraintAnchor constraintAnchor = this.G[i3].f2221c.f2221c;
            ConstraintAnchor[] constraintAnchorArr = this.G;
            if (constraintAnchor != constraintAnchorArr[i3]) {
                int i4 = i3 + 1;
                return constraintAnchorArr[i4].f2221c != null && this.G[i4].f2221c.f2221c == this.G[i4];
            }
        }
    }

    private void b() {
        this.H.add(this.f2289y);
        this.H.add(this.f2290z);
        this.H.add(this.A);
        this.H.add(this.B);
        this.H.add(this.D);
        this.H.add(this.E);
        this.H.add(this.F);
        this.H.add(this.C);
    }

    public int A() {
        if (this.aK == 8) {
            return 0;
        }
        return this.K;
    }

    public int B() {
        if (this.aK == 8) {
            return 0;
        }
        return this.L;
    }

    public int C() {
        return this.V;
    }

    public int D() {
        return this.W;
    }

    public int E() {
        return y() + this.K;
    }

    public int F() {
        return z() + this.L;
    }

    public int G() {
        ConstraintAnchor constraintAnchor = this.f2289y;
        int i2 = 0;
        if (constraintAnchor != null) {
            i2 = 0 + constraintAnchor.f2222d;
        }
        ConstraintAnchor constraintAnchor2 = this.A;
        return constraintAnchor2 != null ? i2 + constraintAnchor2.f2222d : i2;
    }

    public int H() {
        int i2 = 0;
        if (this.f2289y != null) {
            i2 = 0 + this.f2290z.f2222d;
        }
        return this.A != null ? i2 + this.B.f2222d : i2;
    }

    public float I() {
        return this.Y;
    }

    public float J() {
        return this.Z;
    }

    public boolean K() {
        return this.aC;
    }

    public int L() {
        return this.U;
    }

    public Object M() {
        return this.aI;
    }

    public float N() {
        return this.M;
    }

    public int O() {
        return this.N;
    }

    public int P() {
        return this.f2251al;
    }

    public int Q() {
        return this.f2252am;
    }

    public void R() {
        ConstraintWidget v2 = v();
        if (v2 == null || !(v2 instanceof d) || !((d) v()).aa()) {
            int size = this.H.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.H.get(i2).l();
            }
        }
    }

    public DimensionBehaviour S() {
        return this.I[0];
    }

    public DimensionBehaviour T() {
        return this.I[1];
    }

    public boolean U() {
        if (this.f2289y.f2221c == null || this.f2289y.f2221c.f2221c != this.f2289y) {
            return this.A.f2221c != null && this.A.f2221c.f2221c == this.A;
        }
        return true;
    }

    public boolean V() {
        if (this.f2290z.f2221c == null || this.f2290z.f2221c.f2221c != this.f2290z) {
            return this.B.f2221c != null && this.B.f2221c.f2221c == this.B;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean W() {
        return (this instanceof j) || (this instanceof f);
    }

    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f2291a[type.ordinal()]) {
            case 1:
                return this.f2289y;
            case 2:
                return this.f2290z;
            case 3:
                return this.A;
            case 4:
                return this.B;
            case 5:
                return this.C;
            case 6:
                return this.F;
            case 7:
                return this.D;
            case 8:
                return this.E;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public void a(float f2) {
        this.Y = f2;
    }

    public void a(int i2, int i3) {
        this.f2289y.a(i2);
        this.A.a(i3);
        this.O = i2;
        this.K = i3 - i2;
        this.f2264ay = true;
    }

    public void a(int i2, int i3, int i4, float f2) {
        this.f2276l = i2;
        this.f2279o = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.f2280p = i4;
        this.f2281q = f2;
        if (f2 > 0.0f && f2 < 1.0f && i2 == 0) {
            this.f2276l = 2;
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.O = i2;
        this.P = i3;
        if (this.aK == 8) {
            this.K = 0;
            this.L = 0;
            return;
        }
        if (this.I[0] == DimensionBehaviour.FIXED && i8 < (i7 = this.K)) {
            i8 = i7;
        }
        if (this.I[1] == DimensionBehaviour.FIXED && i9 < (i6 = this.L)) {
            i9 = i6;
        }
        this.K = i8;
        this.L = i9;
        int i10 = this.W;
        if (i9 < i10) {
            this.L = i10;
        }
        int i11 = this.V;
        if (i8 < i11) {
            this.K = i11;
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z2) {
        this.aH[i2] = z2;
    }

    public void a(androidx.constraintlayout.solver.c cVar) {
        this.f2289y.a(cVar);
        this.f2290z.a(cVar);
        this.A.a(cVar);
        this.B.a(cVar);
        this.C.a(cVar);
        this.F.a(cVar);
        this.D.a(cVar);
        this.E.a(cVar);
    }

    public void a(d dVar) {
        dVar.a((Object) this.f2289y);
        dVar.a((Object) this.f2290z);
        dVar.a((Object) this.A);
        dVar.a((Object) this.B);
        if (this.U > 0) {
            dVar.a((Object) this.C);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:197:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x03aa  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x045d  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x04c7  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0571  */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x0574  */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x05ba  */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x05e0  */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x05ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.solver.d r51, boolean r52) {
        /*
            r50 = this;
            r15 = r50
            r14 = r51
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f2289y
            androidx.constraintlayout.solver.SolverVariable r13 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.A
            androidx.constraintlayout.solver.SolverVariable r12 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.f2290z
            androidx.constraintlayout.solver.SolverVariable r11 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.B
            androidx.constraintlayout.solver.SolverVariable r10 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.C
            androidx.constraintlayout.solver.SolverVariable r9 = r14.a((java.lang.Object) r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            r8 = 1
            r7 = 0
            if (r0 == 0) goto L_0x0047
            if (r0 == 0) goto L_0x0034
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r0.I
            r0 = r0[r7]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r1) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r15.J
            if (r1 == 0) goto L_0x0043
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r1.I
            r1 = r1[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x0043
            r1 = 1
            goto L_0x0044
        L_0x0043:
            r1 = 0
        L_0x0044:
            r5 = r0
            r6 = r1
            goto L_0x0049
        L_0x0047:
            r5 = 0
            r6 = 0
        L_0x0049:
            int r0 = r15.aK
            r4 = 8
            if (r0 != r4) goto L_0x0060
            boolean r0 = r50.k()
            if (r0 != 0) goto L_0x0060
            boolean[] r0 = r15.aH
            boolean r1 = r0[r7]
            if (r1 != 0) goto L_0x0060
            boolean r0 = r0[r8]
            if (r0 != 0) goto L_0x0060
            return
        L_0x0060:
            boolean r0 = r15.f2264ay
            r3 = 5
            if (r0 != 0) goto L_0x0069
            boolean r1 = r15.f2265az
            if (r1 == 0) goto L_0x00e6
        L_0x0069:
            if (r0 == 0) goto L_0x0098
            int r0 = r15.O
            r14.a((androidx.constraintlayout.solver.SolverVariable) r13, (int) r0)
            int r0 = r15.O
            int r1 = r15.K
            int r0 = r0 + r1
            r14.a((androidx.constraintlayout.solver.SolverVariable) r12, (int) r0)
            if (r5 == 0) goto L_0x0098
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x0098
            boolean r1 = r15.f2263ax
            if (r1 == 0) goto L_0x008f
            androidx.constraintlayout.solver.widgets.d r0 = (androidx.constraintlayout.solver.widgets.d) r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r15.f2289y
            r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r15.A
            r0.d((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r1)
            goto L_0x0098
        L_0x008f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.A
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r14.a((androidx.constraintlayout.solver.SolverVariable) r0, (androidx.constraintlayout.solver.SolverVariable) r12, (int) r7, (int) r3)
        L_0x0098:
            boolean r0 = r15.f2265az
            if (r0 == 0) goto L_0x00d9
            int r0 = r15.P
            r14.a((androidx.constraintlayout.solver.SolverVariable) r11, (int) r0)
            int r0 = r15.P
            int r1 = r15.L
            int r0 = r0 + r1
            r14.a((androidx.constraintlayout.solver.SolverVariable) r10, (int) r0)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.C
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x00b9
            int r0 = r15.P
            int r1 = r15.U
            int r0 = r0 + r1
            r14.a((androidx.constraintlayout.solver.SolverVariable) r9, (int) r0)
        L_0x00b9:
            if (r6 == 0) goto L_0x00d9
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x00d9
            boolean r1 = r15.f2263ax
            if (r1 == 0) goto L_0x00d0
            androidx.constraintlayout.solver.widgets.d r0 = (androidx.constraintlayout.solver.widgets.d) r0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r15.f2290z
            r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r15.B
            r0.c(r1)
            goto L_0x00d9
        L_0x00d0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.B
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r14.a((androidx.constraintlayout.solver.SolverVariable) r0, (androidx.constraintlayout.solver.SolverVariable) r10, (int) r7, (int) r3)
        L_0x00d9:
            boolean r0 = r15.f2264ay
            if (r0 == 0) goto L_0x00e6
            boolean r0 = r15.f2265az
            if (r0 == 0) goto L_0x00e6
            r15.f2264ay = r7
            r15.f2265az = r7
            return
        L_0x00e6:
            androidx.constraintlayout.solver.e r0 = androidx.constraintlayout.solver.d.f2146o
            r1 = 1
            if (r0 == 0) goto L_0x00f3
            androidx.constraintlayout.solver.e r0 = androidx.constraintlayout.solver.d.f2146o
            long r3 = r0.f2191y
            long r3 = r3 + r1
            r0.f2191y = r3
        L_0x00f3:
            if (r52 == 0) goto L_0x0192
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            if (r0 == 0) goto L_0x0192
            androidx.constraintlayout.solver.widgets.analyzer.m r3 = r15.f2271g
            if (r3 == 0) goto L_0x0192
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x0192
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x0192
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x0192
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x0192
            androidx.constraintlayout.solver.e r0 = androidx.constraintlayout.solver.d.f2146o
            if (r0 == 0) goto L_0x0126
            androidx.constraintlayout.solver.e r0 = androidx.constraintlayout.solver.d.f2146o
            long r3 = r0.f2184r
            long r3 = r3 + r1
            r0.f2184r = r3
        L_0x0126:
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            int r0 = r0.f2307g
            r14.a((androidx.constraintlayout.solver.SolverVariable) r13, (int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            int r0 = r0.f2307g
            r14.a((androidx.constraintlayout.solver.SolverVariable) r12, (int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            int r0 = r0.f2307g
            r14.a((androidx.constraintlayout.solver.SolverVariable) r11, (int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            int r0 = r0.f2307g
            r14.a((androidx.constraintlayout.solver.SolverVariable) r10, (int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2377a
            int r0 = r0.f2307g
            r14.a((androidx.constraintlayout.solver.SolverVariable) r9, (int) r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x018d
            if (r5 == 0) goto L_0x0172
            boolean[] r0 = r15.f2272h
            boolean r0 = r0[r7]
            if (r0 == 0) goto L_0x0172
            boolean r0 = r50.U()
            if (r0 != 0) goto L_0x0172
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.A
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r1 = 8
            r14.a((androidx.constraintlayout.solver.SolverVariable) r0, (androidx.constraintlayout.solver.SolverVariable) r12, (int) r7, (int) r1)
        L_0x0172:
            if (r6 == 0) goto L_0x018d
            boolean[] r0 = r15.f2272h
            boolean r0 = r0[r8]
            if (r0 == 0) goto L_0x018d
            boolean r0 = r50.V()
            if (r0 != 0) goto L_0x018d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.B
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r1 = 8
            r14.a((androidx.constraintlayout.solver.SolverVariable) r0, (androidx.constraintlayout.solver.SolverVariable) r10, (int) r7, (int) r1)
        L_0x018d:
            r15.f2264ay = r7
            r15.f2265az = r7
            return
        L_0x0192:
            androidx.constraintlayout.solver.e r0 = androidx.constraintlayout.solver.d.f2146o
            if (r0 == 0) goto L_0x019d
            androidx.constraintlayout.solver.e r0 = androidx.constraintlayout.solver.d.f2146o
            long r3 = r0.f2185s
            long r3 = r3 + r1
            r0.f2185s = r3
        L_0x019d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x0212
            boolean r0 = r15.a((int) r7)
            if (r0 == 0) goto L_0x01b0
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            androidx.constraintlayout.solver.widgets.d r0 = (androidx.constraintlayout.solver.widgets.d) r0
            r0.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r15, (int) r7)
            r0 = 1
            goto L_0x01b4
        L_0x01b0:
            boolean r0 = r50.U()
        L_0x01b4:
            boolean r1 = r15.a((int) r8)
            if (r1 == 0) goto L_0x01c3
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r15.J
            androidx.constraintlayout.solver.widgets.d r1 = (androidx.constraintlayout.solver.widgets.d) r1
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r15, (int) r8)
            r1 = 1
            goto L_0x01c7
        L_0x01c3:
            boolean r1 = r50.V()
        L_0x01c7:
            if (r0 != 0) goto L_0x01e8
            if (r5 == 0) goto L_0x01e8
            int r2 = r15.aK
            r3 = 8
            if (r2 == r3) goto L_0x01e8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.f2289y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 != 0) goto L_0x01e8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.A
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 != 0) goto L_0x01e8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r15.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.A
            androidx.constraintlayout.solver.SolverVariable r2 = r14.a((java.lang.Object) r2)
            r14.a((androidx.constraintlayout.solver.SolverVariable) r2, (androidx.constraintlayout.solver.SolverVariable) r12, (int) r7, (int) r8)
        L_0x01e8:
            if (r1 != 0) goto L_0x020d
            if (r6 == 0) goto L_0x020d
            int r2 = r15.aK
            r3 = 8
            if (r2 == r3) goto L_0x020d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.f2290z
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 != 0) goto L_0x020d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.B
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.f2221c
            if (r2 != 0) goto L_0x020d
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r15.C
            if (r2 != 0) goto L_0x020d
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r15.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.B
            androidx.constraintlayout.solver.SolverVariable r2 = r14.a((java.lang.Object) r2)
            r14.a((androidx.constraintlayout.solver.SolverVariable) r2, (androidx.constraintlayout.solver.SolverVariable) r10, (int) r7, (int) r8)
        L_0x020d:
            r29 = r0
            r28 = r1
            goto L_0x0216
        L_0x0212:
            r28 = 0
            r29 = 0
        L_0x0216:
            int r0 = r15.K
            int r1 = r15.V
            if (r0 >= r1) goto L_0x021d
            r0 = r1
        L_0x021d:
            int r1 = r15.L
            int r2 = r15.W
            if (r1 >= r2) goto L_0x0224
            r1 = r2
        L_0x0224:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r15.I
            r2 = r2[r7]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r2 == r3) goto L_0x022e
            r2 = 1
            goto L_0x022f
        L_0x022e:
            r2 = 0
        L_0x022f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r3 = r15.I
            r3 = r3[r8]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r3 == r4) goto L_0x0239
            r3 = 1
            goto L_0x023a
        L_0x0239:
            r3 = 0
        L_0x023a:
            int r4 = r15.N
            r15.f2287w = r4
            float r4 = r15.M
            r15.f2288x = r4
            int r8 = r15.f2276l
            int r7 = r15.f2277m
            r20 = 0
            r21 = 4
            r22 = r0
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x02f9
            int r4 = r15.aK
            r0 = 8
            if (r4 == r0) goto L_0x02f9
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r4 = 0
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r23 = r1
            r1 = 3
            if (r0 != r4) goto L_0x0265
            if (r8 != 0) goto L_0x0265
            r8 = 3
        L_0x0265:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r4 = 1
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r4) goto L_0x0271
            if (r7 != 0) goto L_0x0271
            r7 = 3
        L_0x0271:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r4 = 0
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r4) goto L_0x028b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r4 = 1
            r0 = r0[r4]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r4) goto L_0x028b
            if (r8 != r1) goto L_0x028b
            if (r7 != r1) goto L_0x028b
            r15.a((boolean) r5, (boolean) r6, (boolean) r2, (boolean) r3)
            goto L_0x02ef
        L_0x028b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r2 = 0
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x02b4
            if (r8 != r1) goto L_0x02b4
            r15.f2287w = r2
            float r0 = r15.f2288x
            int r1 = r15.L
            float r1 = (float) r1
            float r0 = r0 * r1
            int r0 = (int) r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.I
            r2 = 1
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r31 = r7
            if (r1 == r3) goto L_0x02b1
            r30 = r23
            r8 = 0
            r32 = 4
            goto L_0x0304
        L_0x02b1:
            r32 = r8
            goto L_0x02f5
        L_0x02b4:
            r2 = 1
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r3) goto L_0x02ef
            if (r7 != r1) goto L_0x02ef
            r15.f2287w = r2
            int r0 = r15.N
            r1 = -1
            if (r0 != r1) goto L_0x02cd
            r0 = 1065353216(0x3f800000, float:1.0)
            float r1 = r15.f2288x
            float r0 = r0 / r1
            r15.f2288x = r0
        L_0x02cd:
            float r0 = r15.f2288x
            int r1 = r15.K
            float r1 = (float) r1
            float r0 = r0 * r1
            int r1 = (int) r0
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r2 = 0
            r0 = r0[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r30 = r1
            if (r0 == r2) goto L_0x02e8
            r32 = r8
            r0 = r22
            r8 = 0
            r31 = 4
            goto L_0x0304
        L_0x02e8:
            r31 = r7
            r32 = r8
            r0 = r22
            goto L_0x02f7
        L_0x02ef:
            r31 = r7
            r32 = r8
            r0 = r22
        L_0x02f5:
            r30 = r23
        L_0x02f7:
            r8 = 1
            goto L_0x0304
        L_0x02f9:
            r23 = r1
            r31 = r7
            r32 = r8
            r0 = r22
            r30 = r23
            r8 = 0
        L_0x0304:
            int[] r1 = r15.f2278n
            r2 = 0
            r1[r2] = r32
            r2 = 1
            r1[r2] = r31
            r15.f2273i = r8
            if (r8 == 0) goto L_0x031a
            int r1 = r15.f2287w
            r2 = -1
            if (r1 == 0) goto L_0x0317
            if (r1 != r2) goto L_0x031b
        L_0x0317:
            r20 = 1
            goto L_0x031d
        L_0x031a:
            r2 = -1
        L_0x031b:
            r20 = 0
        L_0x031d:
            if (r8 == 0) goto L_0x0329
            int r1 = r15.f2287w
            r3 = 1
            if (r1 == r3) goto L_0x0326
            if (r1 != r2) goto L_0x0329
        L_0x0326:
            r33 = 1
            goto L_0x032b
        L_0x0329:
            r33 = 0
        L_0x032b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r15.I
            r2 = 0
            r1 = r1[r2]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r1 != r2) goto L_0x033b
            boolean r1 = r15 instanceof androidx.constraintlayout.solver.widgets.d
            if (r1 == 0) goto L_0x033b
            r21 = 1
            goto L_0x033d
        L_0x033b:
            r21 = 0
        L_0x033d:
            if (r21 == 0) goto L_0x0342
            r22 = 0
            goto L_0x0344
        L_0x0342:
            r22 = r0
        L_0x0344:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.F
            boolean r0 = r0.m()
            r1 = 1
            r34 = r0 ^ 1
            boolean[] r0 = r15.aH
            r2 = 0
            boolean r23 = r0[r2]
            boolean r35 = r0[r1]
            int r0 = r15.f2274j
            r7 = 2
            r36 = 0
            if (r0 == r7) goto L_0x044b
            boolean r0 = r15.f2264ay
            if (r0 != 0) goto L_0x044b
            if (r52 == 0) goto L_0x03aa
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            if (r0 == 0) goto L_0x03aa
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x03aa
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            boolean r0 = r0.f2310j
            if (r0 != 0) goto L_0x0374
            goto L_0x03aa
        L_0x0374:
            if (r52 == 0) goto L_0x044b
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            int r0 = r0.f2307g
            r14.a((androidx.constraintlayout.solver.SolverVariable) r13, (int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.k r0 = r15.f2270f
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            int r0 = r0.f2307g
            r14.a((androidx.constraintlayout.solver.SolverVariable) r12, (int) r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x044b
            if (r5 == 0) goto L_0x044b
            boolean[] r0 = r15.f2272h
            r1 = 0
            boolean r0 = r0[r1]
            if (r0 == 0) goto L_0x044b
            boolean r0 = r50.U()
            if (r0 != 0) goto L_0x044b
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.A
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r4 = 8
            r14.a((androidx.constraintlayout.solver.SolverVariable) r0, (androidx.constraintlayout.solver.SolverVariable) r12, (int) r1, (int) r4)
            goto L_0x044b
        L_0x03aa:
            r4 = 8
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x03b9
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.A
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r16 = r0
            goto L_0x03bb
        L_0x03b9:
            r16 = r36
        L_0x03bb:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x03c8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2289y
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r27 = r0
            goto L_0x03ca
        L_0x03c8:
            r27 = r36
        L_0x03ca:
            boolean[] r0 = r15.f2272h
            r19 = 0
            boolean r37 = r0[r19]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r38 = r0[r19]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r15.f2289y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r15.A
            int r2 = r15.O
            r40 = r2
            int r2 = r15.V
            int[] r4 = r15.aA
            r42 = r4[r19]
            float r4 = r15.Y
            r18 = 1
            r0 = r0[r18]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r7) goto L_0x03ef
            r44 = 1
            goto L_0x03f1
        L_0x03ef:
            r44 = 0
        L_0x03f1:
            int r0 = r15.f2279o
            r24 = r0
            int r0 = r15.f2280p
            r25 = r0
            float r0 = r15.f2281q
            r26 = r0
            r0 = r50
            r45 = r1
            r1 = r51
            r39 = r40
            r40 = r2
            r2 = 1
            r17 = r3
            r7 = 5
            r3 = r5
            r41 = r4
            r4 = r6
            r46 = r5
            r5 = r37
            r37 = r6
            r6 = r27
            r7 = r16
            r43 = r8
            r8 = r38
            r47 = r9
            r9 = r21
            r48 = r10
            r10 = r17
            r49 = r11
            r11 = r45
            r38 = r12
            r12 = r39
            r39 = r13
            r13 = r22
            r14 = r40
            r15 = r42
            r16 = r41
            r17 = r20
            r18 = r44
            r19 = r29
            r20 = r28
            r21 = r23
            r22 = r32
            r23 = r31
            r27 = r34
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x045b
        L_0x044b:
            r46 = r5
            r37 = r6
            r43 = r8
            r47 = r9
            r48 = r10
            r49 = r11
            r38 = r12
            r39 = r13
        L_0x045b:
            if (r52 == 0) goto L_0x04c7
            r15 = r50
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            if (r0 == 0) goto L_0x04ba
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x04ba
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            boolean r0 = r0.f2310j
            if (r0 == 0) goto L_0x04ba
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2329j
            int r0 = r0.f2307g
            r14 = r51
            r13 = r49
            r14.a((androidx.constraintlayout.solver.SolverVariable) r13, (int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2330k
            int r0 = r0.f2307g
            r12 = r48
            r14.a((androidx.constraintlayout.solver.SolverVariable) r12, (int) r0)
            androidx.constraintlayout.solver.widgets.analyzer.m r0 = r15.f2271g
            androidx.constraintlayout.solver.widgets.analyzer.DependencyNode r0 = r0.f2377a
            int r0 = r0.f2307g
            r1 = r47
            r14.a((androidx.constraintlayout.solver.SolverVariable) r1, (int) r0)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x04b4
            if (r28 != 0) goto L_0x04b4
            if (r37 == 0) goto L_0x04b4
            boolean[] r2 = r15.f2272h
            r11 = 1
            boolean r2 = r2[r11]
            if (r2 == 0) goto L_0x04b0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.B
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r2 = 8
            r10 = 0
            r14.a((androidx.constraintlayout.solver.SolverVariable) r0, (androidx.constraintlayout.solver.SolverVariable) r12, (int) r10, (int) r2)
            goto L_0x04b8
        L_0x04b0:
            r2 = 8
            r10 = 0
            goto L_0x04b8
        L_0x04b4:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x04b8:
            r8 = 0
            goto L_0x04d6
        L_0x04ba:
            r14 = r51
            r1 = r47
            r12 = r48
            r13 = r49
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x04d5
        L_0x04c7:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r50
            r14 = r51
            r1 = r47
            r12 = r48
            r13 = r49
        L_0x04d5:
            r8 = 1
        L_0x04d6:
            int r0 = r15.f2275k
            r3 = 2
            if (r0 != r3) goto L_0x04dd
            r7 = 0
            goto L_0x04de
        L_0x04dd:
            r7 = r8
        L_0x04de:
            if (r7 == 0) goto L_0x05b4
            boolean r0 = r15.f2265az
            if (r0 != 0) goto L_0x05b4
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r0 = r0[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r0 != r3) goto L_0x04f2
            boolean r0 = r15 instanceof androidx.constraintlayout.solver.widgets.d
            if (r0 == 0) goto L_0x04f2
            r9 = 1
            goto L_0x04f3
        L_0x04f2:
            r9 = 0
        L_0x04f3:
            if (r9 == 0) goto L_0x04f7
            r30 = 0
        L_0x04f7:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x0503
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.B
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r7 = r0
            goto L_0x0505
        L_0x0503:
            r7 = r36
        L_0x0505:
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r15.J
            if (r0 == 0) goto L_0x0511
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2290z
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r6 = r0
            goto L_0x0513
        L_0x0511:
            r6 = r36
        L_0x0513:
            int r0 = r15.U
            if (r0 > 0) goto L_0x051b
            int r0 = r15.aK
            if (r0 != r2) goto L_0x0551
        L_0x051b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.C
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            if (r0 == 0) goto L_0x0542
            int r0 = r50.L()
            r14.c(r1, r13, r0, r2)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.C
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.f2221c
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r14.c(r1, r0, r10, r2)
            if (r37 == 0) goto L_0x053f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r15.B
            androidx.constraintlayout.solver.SolverVariable r0 = r14.a((java.lang.Object) r0)
            r1 = 5
            r14.a((androidx.constraintlayout.solver.SolverVariable) r7, (androidx.constraintlayout.solver.SolverVariable) r0, (int) r10, (int) r1)
        L_0x053f:
            r27 = 0
            goto L_0x0553
        L_0x0542:
            int r0 = r15.aK
            if (r0 != r2) goto L_0x054a
            r14.c(r1, r13, r10, r2)
            goto L_0x0551
        L_0x054a:
            int r0 = r50.L()
            r14.c(r1, r13, r0, r2)
        L_0x0551:
            r27 = r34
        L_0x0553:
            boolean[] r0 = r15.f2272h
            boolean r5 = r0[r11]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r15.I
            r8 = r0[r11]
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r15.f2290z
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r15.B
            int r1 = r15.P
            int r2 = r15.W
            int[] r10 = r15.aA
            r16 = r10[r11]
            float r10 = r15.Z
            r17 = 0
            r0 = r0[r17]
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r11 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r11) goto L_0x0574
            r18 = 1
            goto L_0x0576
        L_0x0574:
            r18 = 0
        L_0x0576:
            int r0 = r15.f2282r
            r24 = r0
            int r0 = r15.f2283s
            r25 = r0
            float r0 = r15.f2284t
            r26 = r0
            r0 = r50
            r19 = r1
            r1 = r51
            r20 = r2
            r2 = 0
            r11 = r3
            r3 = r37
            r21 = r4
            r4 = r46
            r17 = r10
            r10 = r21
            r34 = r12
            r12 = r19
            r36 = r13
            r13 = r30
            r14 = r20
            r15 = r16
            r16 = r17
            r17 = r33
            r19 = r28
            r20 = r29
            r21 = r35
            r22 = r31
            r23 = r32
            r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x05b8
        L_0x05b4:
            r34 = r12
            r36 = r13
        L_0x05b8:
            if (r43 == 0) goto L_0x05e0
            r6 = 8
            r7 = r50
            int r0 = r7.f2287w
            r1 = 1
            float r5 = r7.f2288x
            if (r0 != r1) goto L_0x05d0
            r0 = r51
            r1 = r34
            r2 = r36
            r3 = r38
            r4 = r39
            goto L_0x05dc
        L_0x05d0:
            r6 = 8
            r0 = r51
            r1 = r38
            r2 = r39
            r3 = r34
            r4 = r36
        L_0x05dc:
            r0.a(r1, r2, r3, r4, r5, r6)
            goto L_0x05e2
        L_0x05e0:
            r7 = r50
        L_0x05e2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.F
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x060a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r7.F
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r0.k()
            androidx.constraintlayout.solver.widgets.ConstraintWidget r0 = r0.h()
            float r1 = r7.aB
            r2 = 1119092736(0x42b40000, float:90.0)
            float r1 = r1 + r2
            double r1 = (double) r1
            double r1 = java.lang.Math.toRadians(r1)
            float r1 = (float) r1
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r7.F
            int r2 = r2.j()
            r3 = r51
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r7, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r0, (float) r1, (int) r2)
        L_0x060a:
            r0 = 0
            r7.f2264ay = r0
            r7.f2265az = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.a(androidx.constraintlayout.solver.d, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c1, code lost:
        if (r6.m() != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f0, code lost:
        if (r6.m() != false) goto L_0x01f2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type r4, androidx.constraintlayout.solver.widgets.ConstraintWidget r5, androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type r6, int r7) {
        /*
            r3 = this;
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            r1 = 0
            if (r4 != r0) goto L_0x00b7
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            if (r6 != r4) goto L_0x0086
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r7)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r0)
            r2 = 1
            if (r4 == 0) goto L_0x002a
            boolean r4 = r4.m()
            if (r4 != 0) goto L_0x0032
        L_0x002a:
            if (r6 == 0) goto L_0x0034
            boolean r4 = r6.m()
            if (r4 == 0) goto L_0x0034
        L_0x0032:
            r4 = 0
            goto L_0x0043
        L_0x0034:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (int) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (int) r1)
            r4 = 1
        L_0x0043:
            if (r7 == 0) goto L_0x004b
            boolean r6 = r7.m()
            if (r6 != 0) goto L_0x0053
        L_0x004b:
            if (r0 == 0) goto L_0x0055
            boolean r6 = r0.m()
            if (r6 == 0) goto L_0x0055
        L_0x0053:
            r2 = 0
            goto L_0x0063
        L_0x0055:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r7, (int) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r7, (int) r1)
        L_0x0063:
            if (r4 == 0) goto L_0x0070
            if (r2 == 0) goto L_0x0070
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            goto L_0x00b2
        L_0x0070:
            if (r4 == 0) goto L_0x007b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            goto L_0x00b2
        L_0x007b:
            if (r2 == 0) goto L_0x01fb
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            goto L_0x00b2
        L_0x0086:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r6 == r4) goto L_0x00a2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r6 != r4) goto L_0x008f
            goto L_0x00a2
        L_0x008f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r6 == r4) goto L_0x0097
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r6 != r4) goto L_0x01fb
        L_0x0097:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (int) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (int) r1)
            goto L_0x00ac
        L_0x00a2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (int) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r5, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6, (int) r1)     // Catch:{ all -> 0x01fc }
        L_0x00ac:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
        L_0x00ae:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
        L_0x00b2:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            goto L_0x00df
        L_0x00b7:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r4 != r0) goto L_0x00e4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r6 == r0) goto L_0x00c3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r6 != r0) goto L_0x00e4
        L_0x00c3:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            r4.a(r5, r1)
            r6.a(r5, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
        L_0x00df:
            r4.a(r5, r1)
            goto L_0x01fb
        L_0x00e4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r4 != r0) goto L_0x0111
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r6 == r0) goto L_0x00f0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r6 != r0) goto L_0x0111
        L_0x00f0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r5)
            r5.a(r4, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r5)
            r5.a(r4, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r5)
            r5.a(r4, r1)
            goto L_0x01fb
        L_0x0111:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r4 != r0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            if (r6 != r0) goto L_0x013b
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r7)
            r4.a(r7, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r7)
            r4.a(r7, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            goto L_0x00ae
        L_0x013b:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r4 != r0) goto L_0x0165
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r0 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            if (r6 != r0) goto L_0x0165
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r7)
            r4.a(r7, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r7 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r7)
            r4.a(r7, r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            goto L_0x00ae
        L_0x0165:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r0 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r5 = r5.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            boolean r6 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r5)
            if (r6 == 0) goto L_0x01fb
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            if (r4 != r6) goto L_0x018f
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            if (r4 == 0) goto L_0x0188
            r4.l()
        L_0x0188:
            if (r6 == 0) goto L_0x018d
            r6.l()
        L_0x018d:
            r7 = 0
            goto L_0x01f8
        L_0x018f:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            if (r4 == r6) goto L_0x01c4
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            if (r4 != r6) goto L_0x0198
            goto L_0x01c4
        L_0x0198:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            if (r4 == r6) goto L_0x01a0
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            if (r4 != r6) goto L_0x01f8
        L_0x01a0:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.k()
            if (r1 == r5) goto L_0x01af
            r6.l()
        L_0x01af:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.n()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_X
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            boolean r1 = r6.m()
            if (r1 == 0) goto L_0x01f8
            goto L_0x01f2
        L_0x01c4:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            if (r6 == 0) goto L_0x01cf
            r6.l()
        L_0x01cf:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r6.k()
            if (r1 == r5) goto L_0x01de
            r6.l()
        L_0x01de:
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r4 = r4.n()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.CENTER_Y
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r3.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r6)
            boolean r1 = r6.m()
            if (r1 == 0) goto L_0x01f8
        L_0x01f2:
            r4.l()
            r6.l()
        L_0x01f8:
            r0.a(r5, r7)
        L_0x01fb:
            return
        L_0x01fc:
            r4 = move-exception
            goto L_0x01ff
        L_0x01fe:
            throw r4
        L_0x01ff:
            goto L_0x01fe
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.a(androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type, androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type, int):void");
    }

    public void a(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        a(type).a(constraintWidget.a(type2), i2, i3, true);
    }

    public void a(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        if (constraintAnchor.h() == this) {
            a(constraintAnchor.i(), constraintAnchor2.h(), constraintAnchor2.i(), i2);
        }
    }

    public void a(DimensionBehaviour dimensionBehaviour) {
        this.I[0] = dimensionBehaviour;
    }

    public void a(ConstraintWidget constraintWidget, float f2, int i2) {
        a(ConstraintAnchor.Type.CENTER, constraintWidget, ConstraintAnchor.Type.CENTER, i2, 0);
        this.aB = f2;
    }

    public void a(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.f2274j = constraintWidget.f2274j;
        this.f2275k = constraintWidget.f2275k;
        this.f2276l = constraintWidget.f2276l;
        this.f2277m = constraintWidget.f2277m;
        int[] iArr = this.f2278n;
        int[] iArr2 = constraintWidget.f2278n;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.f2279o = constraintWidget.f2279o;
        this.f2280p = constraintWidget.f2280p;
        this.f2282r = constraintWidget.f2282r;
        this.f2283s = constraintWidget.f2283s;
        this.f2284t = constraintWidget.f2284t;
        this.f2285u = constraintWidget.f2285u;
        this.f2286v = constraintWidget.f2286v;
        this.f2287w = constraintWidget.f2287w;
        this.f2288x = constraintWidget.f2288x;
        int[] iArr3 = constraintWidget.aA;
        this.aA = Arrays.copyOf(iArr3, iArr3.length);
        this.aB = constraintWidget.aB;
        this.aC = constraintWidget.aC;
        this.aD = constraintWidget.aD;
        this.f2289y.l();
        this.f2290z.l();
        this.A.l();
        this.B.l();
        this.C.l();
        this.D.l();
        this.E.l();
        this.F.l();
        this.I = (DimensionBehaviour[]) Arrays.copyOf(this.I, 2);
        ConstraintWidget constraintWidget2 = null;
        this.J = this.J == null ? null : hashMap.get(constraintWidget.J);
        this.K = constraintWidget.K;
        this.L = constraintWidget.L;
        this.M = constraintWidget.M;
        this.N = constraintWidget.N;
        this.O = constraintWidget.O;
        this.P = constraintWidget.P;
        this.Q = constraintWidget.Q;
        this.R = constraintWidget.R;
        this.S = constraintWidget.S;
        this.T = constraintWidget.T;
        this.U = constraintWidget.U;
        this.V = constraintWidget.V;
        this.W = constraintWidget.W;
        this.Y = constraintWidget.Y;
        this.Z = constraintWidget.Z;
        this.aI = constraintWidget.aI;
        this.aJ = constraintWidget.aJ;
        this.aK = constraintWidget.aK;
        this.aL = constraintWidget.aL;
        this.aM = constraintWidget.aM;
        this.f2240aa = constraintWidget.f2240aa;
        this.f2241ab = constraintWidget.f2241ab;
        this.f2242ac = constraintWidget.f2242ac;
        this.f2243ad = constraintWidget.f2243ad;
        this.f2244ae = constraintWidget.f2244ae;
        this.f2245af = constraintWidget.f2245af;
        this.f2246ag = constraintWidget.f2246ag;
        this.f2247ah = constraintWidget.f2247ah;
        this.f2248ai = constraintWidget.f2248ai;
        this.f2249aj = constraintWidget.f2249aj;
        this.f2251al = constraintWidget.f2251al;
        this.f2252am = constraintWidget.f2252am;
        this.f2253an = constraintWidget.f2253an;
        this.f2254ao = constraintWidget.f2254ao;
        float[] fArr = this.f2255ap;
        float[] fArr2 = constraintWidget.f2255ap;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.f2256aq;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.f2256aq;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.f2257ar;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.f2257ar;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.f2258as;
        this.f2258as = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.f2259at;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.f2259at = constraintWidget2;
    }

    public void a(d dVar, d dVar2, HashSet<ConstraintWidget> hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                i.a(dVar, dVar2, this);
                hashSet.remove(this);
                a(dVar2, dVar.b(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet<ConstraintAnchor> a2 = this.f2289y.a();
            if (a2 != null) {
                Iterator<ConstraintAnchor> it2 = a2.iterator();
                while (it2.hasNext()) {
                    it2.next().f2219a.a(dVar, dVar2, hashSet, i2, true);
                }
            }
            HashSet<ConstraintAnchor> a3 = this.A.a();
            if (a3 != null) {
                Iterator<ConstraintAnchor> it3 = a3.iterator();
                while (it3.hasNext()) {
                    it3.next().f2219a.a(dVar, dVar2, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> a4 = this.f2290z.a();
        if (a4 != null) {
            Iterator<ConstraintAnchor> it4 = a4.iterator();
            while (it4.hasNext()) {
                it4.next().f2219a.a(dVar, dVar2, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> a5 = this.B.a();
        if (a5 != null) {
            Iterator<ConstraintAnchor> it5 = a5.iterator();
            while (it5.hasNext()) {
                it5.next().f2219a.a(dVar, dVar2, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> a6 = this.C.a();
        if (a6 != null) {
            Iterator<ConstraintAnchor> it6 = a6.iterator();
            while (it6.hasNext()) {
                it6.next().f2219a.a(dVar, dVar2, hashSet, i2, true);
            }
        }
    }

    public void a(Object obj) {
        this.aI = obj;
    }

    public void a(String str) {
        this.aL = str;
    }

    public void a(boolean z2, boolean z3) {
        int i2;
        int i3;
        boolean g2 = z2 & this.f2270f.g();
        boolean g3 = z3 & this.f2271g.g();
        int i4 = this.f2270f.f2329j.f2307g;
        int i5 = this.f2271g.f2329j.f2307g;
        int i6 = this.f2270f.f2330k.f2307g;
        int i7 = this.f2271g.f2330k.f2307g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (g2) {
            this.O = i4;
        }
        if (g3) {
            this.P = i5;
        }
        if (this.aK == 8) {
            this.K = 0;
            this.L = 0;
            return;
        }
        if (g2) {
            if (this.I[0] == DimensionBehaviour.FIXED && i9 < (i3 = this.K)) {
                i9 = i3;
            }
            this.K = i9;
            int i11 = this.V;
            if (i9 < i11) {
                this.K = i11;
            }
        }
        if (g3) {
            if (this.I[1] == DimensionBehaviour.FIXED && i10 < (i2 = this.L)) {
                i10 = i2;
            }
            this.L = i10;
            int i12 = this.W;
            if (i10 < i12) {
                this.L = i12;
            }
        }
    }

    public void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        if (this.f2287w == -1) {
            if (z4 && !z5) {
                this.f2287w = 0;
            } else if (!z4 && z5) {
                this.f2287w = 1;
                if (this.N == -1) {
                    this.f2288x = 1.0f / this.f2288x;
                }
            }
        }
        if (this.f2287w == 0 && (!this.f2290z.m() || !this.B.m())) {
            this.f2287w = 1;
        } else if (this.f2287w == 1 && (!this.f2289y.m() || !this.A.m())) {
            this.f2287w = 0;
        }
        if (this.f2287w == -1 && (!this.f2290z.m() || !this.B.m() || !this.f2289y.m() || !this.A.m())) {
            if (this.f2290z.m() && this.B.m()) {
                this.f2287w = 0;
            } else if (this.f2289y.m() && this.A.m()) {
                this.f2288x = 1.0f / this.f2288x;
                this.f2287w = 1;
            }
        }
        if (this.f2287w == -1) {
            int i2 = this.f2279o;
            if (i2 > 0 && this.f2282r == 0) {
                this.f2287w = 0;
            } else if (i2 == 0 && this.f2282r > 0) {
                this.f2288x = 1.0f / this.f2288x;
                this.f2287w = 1;
            }
        }
    }

    public boolean a() {
        return this.aK != 8;
    }

    public void a_(ConstraintWidget constraintWidget) {
        this.J = constraintWidget;
    }

    public void b(float f2) {
        this.Z = f2;
    }

    public void b(int i2, int i3) {
        this.f2290z.a(i2);
        this.B.a(i3);
        this.P = i2;
        this.L = i3 - i2;
        if (this.aC) {
            this.C.a(i2 + this.U);
        }
        this.f2265az = true;
    }

    public void b(int i2, int i3, int i4, float f2) {
        this.f2277m = i2;
        this.f2282r = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.f2283s = i4;
        this.f2284t = f2;
        if (f2 > 0.0f && f2 < 1.0f && i2 == 0) {
            this.f2277m = 2;
        }
    }

    public void b(d dVar, boolean z2) {
        m mVar;
        k kVar;
        int b2 = dVar.b((Object) this.f2289y);
        int b3 = dVar.b((Object) this.f2290z);
        int b4 = dVar.b((Object) this.A);
        int b5 = dVar.b((Object) this.B);
        if (z2 && (kVar = this.f2270f) != null && kVar.f2329j.f2310j && this.f2270f.f2330k.f2310j) {
            b2 = this.f2270f.f2329j.f2307g;
            b4 = this.f2270f.f2330k.f2307g;
        }
        if (z2 && (mVar = this.f2271g) != null && mVar.f2329j.f2310j && this.f2271g.f2330k.f2310j) {
            b3 = this.f2271g.f2329j.f2307g;
            b5 = this.f2271g.f2330k.f2307g;
        }
        int i2 = b5 - b3;
        if (b4 - b2 < 0 || i2 < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        a(b2, b3, b4, b5);
    }

    public void b(DimensionBehaviour dimensionBehaviour) {
        this.I[1] = dimensionBehaviour;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x008e
            int r1 = r9.length()
            if (r1 != 0) goto L_0x000b
            goto L_0x008e
        L_0x000b:
            r1 = -1
            int r2 = r9.length()
            r3 = 44
            int r3 = r9.indexOf(r3)
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x0037
            int r6 = r2 + -1
            if (r3 >= r6) goto L_0x0037
            java.lang.String r6 = r9.substring(r4, r3)
            java.lang.String r7 = "W"
            boolean r7 = r6.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x002c
            r1 = 0
            goto L_0x0035
        L_0x002c:
            java.lang.String r4 = "H"
            boolean r4 = r6.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0035
            r1 = 1
        L_0x0035:
            int r4 = r3 + 1
        L_0x0037:
            r3 = 58
            int r3 = r9.indexOf(r3)
            if (r3 < 0) goto L_0x0075
            int r2 = r2 - r5
            if (r3 >= r2) goto L_0x0075
            java.lang.String r2 = r9.substring(r4, r3)
            int r3 = r3 + r5
            java.lang.String r9 = r9.substring(r3)
            int r3 = r2.length()
            if (r3 <= 0) goto L_0x0084
            int r3 = r9.length()
            if (r3 <= 0) goto L_0x0084
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            int r3 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            int r3 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r3 <= 0) goto L_0x0084
            if (r1 != r5) goto L_0x006f
            float r9 = r9 / r2
            float r9 = java.lang.Math.abs(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x006f:
            float r2 = r2 / r9
            float r9 = java.lang.Math.abs(r2)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0075:
            java.lang.String r9 = r9.substring(r4)
            int r2 = r9.length()
            if (r2 <= 0) goto L_0x0084
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x008d
            r8.M = r9
            r8.N = r1
        L_0x008d:
            return
        L_0x008e:
            r8.M = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.b(java.lang.String):void");
    }

    public void b(boolean z2) {
        this.aE = z2;
    }

    public WidgetRun c(int i2) {
        if (i2 == 0) {
            return this.f2270f;
        }
        if (i2 == 1) {
            return this.f2271g;
        }
        return null;
    }

    public void c(float f2) {
        this.f2255ap[0] = f2;
    }

    public void c(int i2, int i3) {
        this.aF = i2;
        this.aG = i3;
        e(false);
    }

    public void c(boolean z2) {
        this.aC = z2;
    }

    public void d(float f2) {
        this.f2255ap[1] = f2;
    }

    public void d(int i2) {
        this.f2289y.a(i2);
        this.O = i2;
    }

    public void d(int i2, int i3) {
        this.O = i2;
        this.P = i3;
    }

    public void d(boolean z2) {
        this.aD = z2;
    }

    public boolean d() {
        return this.f2264ay || (this.f2289y.f() && this.A.f());
    }

    public void d_() {
        this.f2264ay = false;
        this.f2265az = false;
        int size = this.H.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.H.get(i2).e();
        }
    }

    public void e(int i2) {
        this.f2290z.a(i2);
        this.P = i2;
    }

    public void e(int i2, int i3) {
        this.O = i2;
        int i4 = i3 - i2;
        this.K = i4;
        int i5 = this.V;
        if (i4 < i5) {
            this.K = i5;
        }
    }

    public void e(boolean z2) {
        this.f2239a = z2;
    }

    public boolean e() {
        return this.f2265az || (this.f2290z.f() && this.B.f());
    }

    public void f(int i2) {
        if (this.aC) {
            int i3 = i2 - this.U;
            int i4 = this.L + i3;
            this.P = i3;
            this.f2290z.a(i3);
            this.B.a(i4);
            this.C.a(i2);
            this.f2265az = true;
        }
    }

    public void f(int i2, int i3) {
        this.P = i2;
        int i4 = i3 - i2;
        this.L = i4;
        int i5 = this.W;
        if (i4 < i5) {
            this.L = i5;
        }
    }

    public boolean g(int i2) {
        if (i2 == 0) {
            return (this.f2289y.f2221c != null ? 1 : 0) + (this.A.f2221c != null ? 1 : 0) < 2;
        }
        return ((this.f2290z.f2221c != null ? 1 : 0) + (this.B.f2221c != null ? 1 : 0)) + (this.C.f2221c != null ? 1 : 0) < 2;
    }

    public void h(int i2) {
        this.aA[0] = i2;
    }

    public void i(int i2) {
        this.aA[1] = i2;
    }

    public void j(int i2) {
        this.aK = i2;
    }

    public int k(int i2) {
        if (i2 == 0) {
            return A();
        }
        if (i2 == 1) {
            return B();
        }
        return 0;
    }

    public boolean k() {
        int size = this.H.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.H.get(i2).b()) {
                return true;
            }
        }
        return false;
    }

    public float l(int i2) {
        if (i2 == 0) {
            return this.Y;
        }
        if (i2 == 1) {
            return this.Z;
        }
        return -1.0f;
    }

    public boolean l() {
        return this.aE;
    }

    public int m() {
        return this.aA[1];
    }

    public void m(int i2) {
        this.O = i2;
    }

    public int n() {
        return this.aA[0];
    }

    public void n(int i2) {
        this.P = i2;
    }

    public void o(int i2) {
        this.K = i2;
        int i3 = this.V;
        if (i2 < i3) {
            this.K = i3;
        }
    }

    public boolean o() {
        return this.aD;
    }

    public void p(int i2) {
        this.L = i2;
        int i3 = this.W;
        if (i2 < i3) {
            this.L = i3;
        }
    }

    public boolean p() {
        return this.f2239a && this.aK != 8;
    }

    public int q() {
        return this.aF;
    }

    public void q(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.V = i2;
    }

    public int r() {
        return this.aG;
    }

    public void r(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.W = i2;
    }

    public void s() {
        this.f2289y.l();
        this.f2290z.l();
        this.A.l();
        this.B.l();
        this.C.l();
        this.D.l();
        this.E.l();
        this.F.l();
        this.J = null;
        this.aB = 0.0f;
        this.K = 0;
        this.L = 0;
        this.M = 0.0f;
        this.N = -1;
        this.O = 0;
        this.P = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        float f2 = X;
        this.Y = f2;
        this.Z = f2;
        this.I[0] = DimensionBehaviour.FIXED;
        this.I[1] = DimensionBehaviour.FIXED;
        this.aI = null;
        this.aJ = 0;
        this.aK = 0;
        this.aM = null;
        this.f2248ai = false;
        this.f2249aj = false;
        this.f2251al = 0;
        this.f2252am = 0;
        this.f2253an = false;
        this.f2254ao = false;
        float[] fArr = this.f2255ap;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f2274j = -1;
        this.f2275k = -1;
        int[] iArr = this.aA;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f2276l = 0;
        this.f2277m = 0;
        this.f2281q = 1.0f;
        this.f2284t = 1.0f;
        this.f2280p = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f2283s = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f2279o = 0;
        this.f2282r = 0;
        this.f2273i = false;
        this.f2287w = -1;
        this.f2288x = 1.0f;
        this.f2250ak = false;
        boolean[] zArr = this.f2272h;
        zArr[0] = true;
        zArr[1] = true;
        this.aE = false;
        boolean[] zArr2 = this.aH;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f2239a = true;
    }

    public void s(int i2) {
        this.U = i2;
        this.aC = i2 > 0;
    }

    public void t(int i2) {
        this.f2251al = i2;
    }

    public boolean t() {
        return this.I[0] == DimensionBehaviour.MATCH_CONSTRAINT && this.I[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.aM != null) {
            str = "type: " + this.aM + " ";
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.aL != null) {
            str2 = "id: " + this.aL + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.O);
        sb.append(", ");
        sb.append(this.P);
        sb.append(") - (");
        sb.append(this.K);
        sb.append(" x ");
        sb.append(this.L);
        sb.append(")");
        return sb.toString();
    }

    public void u() {
        if (this.f2270f == null) {
            this.f2270f = new k(this);
        }
        if (this.f2271g == null) {
            this.f2271g = new m(this);
        }
    }

    public void u(int i2) {
        this.f2252am = i2;
    }

    public DimensionBehaviour v(int i2) {
        if (i2 == 0) {
            return S();
        }
        if (i2 == 1) {
            return T();
        }
        return null;
    }

    public ConstraintWidget v() {
        return this.J;
    }

    public int w() {
        return this.aK;
    }

    public ConstraintWidget w(int i2) {
        ConstraintAnchor constraintAnchor;
        if (i2 == 0) {
            if (this.f2289y.f2221c == null || this.f2289y.f2221c.f2221c != (constraintAnchor = this.f2289y)) {
                return null;
            }
        } else if (!(i2 == 1 && this.f2290z.f2221c != null && this.f2290z.f2221c.f2221c == (constraintAnchor = this.f2290z))) {
            return null;
        }
        return constraintAnchor.f2221c.f2219a;
    }

    public ConstraintWidget x(int i2) {
        ConstraintAnchor constraintAnchor;
        if (i2 == 0) {
            if (this.A.f2221c == null || this.A.f2221c.f2221c != (constraintAnchor = this.A)) {
                return null;
            }
        } else if (!(i2 == 1 && this.B.f2221c != null && this.B.f2221c.f2221c == (constraintAnchor = this.B))) {
            return null;
        }
        return constraintAnchor.f2221c.f2219a;
    }

    public String x() {
        return this.aL;
    }

    public int y() {
        ConstraintWidget constraintWidget = this.J;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.O : ((d) constraintWidget).aA + this.O;
    }

    public int z() {
        ConstraintWidget constraintWidget = this.J;
        return (constraintWidget == null || !(constraintWidget instanceof d)) ? this.P : ((d) constraintWidget).aB + this.P;
    }
}
