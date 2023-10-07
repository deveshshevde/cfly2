package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.b;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.f;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    SparseArray<View> J = new SparseArray<>();
    /* access modifiers changed from: protected */
    public d K = new d();
    protected boolean L = true;
    protected a M = null;
    int N = -1;
    int O = -1;
    int P = 0;
    int Q = 0;
    a R = new a(this);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ConstraintHelper> f2530a = new ArrayList<>(4);

    /* renamed from: b  reason: collision with root package name */
    private int f2531b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f2532c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f2533d = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: e  reason: collision with root package name */
    private int f2534e = SubsamplingScaleImageView.TILE_SIZE_AUTO;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f2535f = 257;

    /* renamed from: g  reason: collision with root package name */
    private b f2536g = null;

    /* renamed from: h  reason: collision with root package name */
    private int f2537h = -1;

    /* renamed from: i  reason: collision with root package name */
    private HashMap<String, Integer> f2538i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private int f2539j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f2540k = -1;

    /* renamed from: l  reason: collision with root package name */
    private SparseArray<ConstraintWidget> f2541l = new SparseArray<>();

    /* renamed from: m  reason: collision with root package name */
    private c f2542m;

    /* renamed from: n  reason: collision with root package name */
    private int f2543n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f2544o = 0;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2545a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2545a = r0
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2545a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2545a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f2545a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.<clinit>():void");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        float C = 0.0f;
        int D = 1;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public float O = 1.0f;
        public float P = 1.0f;
        public int Q = -1;
        public int R = -1;
        public int S = -1;
        public boolean T = false;
        public boolean U = false;
        public String V = null;
        boolean W = true;
        boolean X = true;
        boolean Y = false;
        boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f2546a = -1;

        /* renamed from: aa  reason: collision with root package name */
        boolean f2547aa = false;

        /* renamed from: ab  reason: collision with root package name */
        boolean f2548ab = false;

        /* renamed from: ac  reason: collision with root package name */
        boolean f2549ac = false;

        /* renamed from: ad  reason: collision with root package name */
        int f2550ad = -1;

        /* renamed from: ae  reason: collision with root package name */
        int f2551ae = -1;

        /* renamed from: af  reason: collision with root package name */
        int f2552af = -1;

        /* renamed from: ag  reason: collision with root package name */
        int f2553ag = -1;

        /* renamed from: ah  reason: collision with root package name */
        int f2554ah = -1;

        /* renamed from: ai  reason: collision with root package name */
        int f2555ai = -1;

        /* renamed from: aj  reason: collision with root package name */
        float f2556aj = 0.5f;

        /* renamed from: ak  reason: collision with root package name */
        int f2557ak;

        /* renamed from: al  reason: collision with root package name */
        int f2558al;

        /* renamed from: am  reason: collision with root package name */
        float f2559am;

        /* renamed from: an  reason: collision with root package name */
        ConstraintWidget f2560an = new ConstraintWidget();

        /* renamed from: ao  reason: collision with root package name */
        public boolean f2561ao = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2562b = -1;

        /* renamed from: c  reason: collision with root package name */
        public float f2563c = -1.0f;

        /* renamed from: d  reason: collision with root package name */
        public int f2564d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f2565e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2566f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2567g = -1;

        /* renamed from: h  reason: collision with root package name */
        public int f2568h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f2569i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f2570j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f2571k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f2572l = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f2573m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f2574n = 0;

        /* renamed from: o  reason: collision with root package name */
        public float f2575o = 0.0f;

        /* renamed from: p  reason: collision with root package name */
        public int f2576p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f2577q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f2578r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f2579s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f2580t = -1;

        /* renamed from: u  reason: collision with root package name */
        public int f2581u = -1;

        /* renamed from: v  reason: collision with root package name */
        public int f2582v = -1;

        /* renamed from: w  reason: collision with root package name */
        public int f2583w = -1;

        /* renamed from: x  reason: collision with root package name */
        public int f2584x = -1;

        /* renamed from: y  reason: collision with root package name */
        public int f2585y = -1;

        /* renamed from: z  reason: collision with root package name */
        public float f2586z = 0.5f;

        private static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f2587a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2587a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0222, code lost:
            android.util.Log.e("ConstraintLayout", r4);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public LayoutParams(android.content.Context r11, android.util.AttributeSet r12) {
            /*
                r10 = this;
                r10.<init>(r11, r12)
                r0 = -1
                r10.f2546a = r0
                r10.f2562b = r0
                r1 = -1082130432(0xffffffffbf800000, float:-1.0)
                r10.f2563c = r1
                r10.f2564d = r0
                r10.f2565e = r0
                r10.f2566f = r0
                r10.f2567g = r0
                r10.f2568h = r0
                r10.f2569i = r0
                r10.f2570j = r0
                r10.f2571k = r0
                r10.f2572l = r0
                r10.f2573m = r0
                r2 = 0
                r10.f2574n = r2
                r3 = 0
                r10.f2575o = r3
                r10.f2576p = r0
                r10.f2577q = r0
                r10.f2578r = r0
                r10.f2579s = r0
                r10.f2580t = r0
                r10.f2581u = r0
                r10.f2582v = r0
                r10.f2583w = r0
                r10.f2584x = r0
                r10.f2585y = r0
                r4 = 1056964608(0x3f000000, float:0.5)
                r10.f2586z = r4
                r10.A = r4
                r5 = 0
                r10.B = r5
                r10.C = r3
                r6 = 1
                r10.D = r6
                r10.E = r1
                r10.F = r1
                r10.G = r2
                r10.H = r2
                r10.I = r2
                r10.J = r2
                r10.K = r2
                r10.L = r2
                r10.M = r2
                r10.N = r2
                r1 = 1065353216(0x3f800000, float:1.0)
                r10.O = r1
                r10.P = r1
                r10.Q = r0
                r10.R = r0
                r10.S = r0
                r10.T = r2
                r10.U = r2
                r10.V = r5
                r10.W = r6
                r10.X = r6
                r10.Y = r2
                r10.Z = r2
                r10.f2547aa = r2
                r10.f2548ab = r2
                r10.f2549ac = r2
                r10.f2550ad = r0
                r10.f2551ae = r0
                r10.f2552af = r0
                r10.f2553ag = r0
                r10.f2554ah = r0
                r10.f2555ai = r0
                r10.f2556aj = r4
                androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = new androidx.constraintlayout.solver.widgets.ConstraintWidget
                r1.<init>()
                r10.f2560an = r1
                r10.f2561ao = r2
                int[] r1 = androidx.constraintlayout.widget.R.styleable.ConstraintLayout_Layout
                android.content.res.TypedArray r11 = r11.obtainStyledAttributes(r12, r1)
                int r12 = r11.getIndexCount()
                r1 = 0
            L_0x009e:
                if (r1 >= r12) goto L_0x03c9
                int r4 = r11.getIndex(r1)
                android.util.SparseIntArray r5 = androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.a.f2587a
                int r5 = r5.get(r4)
                java.lang.String r7 = "ConstraintLayout"
                r8 = 2
                r9 = -2
                switch(r5) {
                    case 1: goto L_0x03bd;
                    case 2: goto L_0x03ac;
                    case 3: goto L_0x03a3;
                    case 4: goto L_0x038e;
                    case 5: goto L_0x0385;
                    case 6: goto L_0x037c;
                    case 7: goto L_0x0373;
                    case 8: goto L_0x0362;
                    case 9: goto L_0x0351;
                    case 10: goto L_0x033f;
                    case 11: goto L_0x032d;
                    case 12: goto L_0x031b;
                    case 13: goto L_0x0309;
                    case 14: goto L_0x02f7;
                    case 15: goto L_0x02e5;
                    case 16: goto L_0x02d3;
                    case 17: goto L_0x02c1;
                    case 18: goto L_0x02af;
                    case 19: goto L_0x029d;
                    case 20: goto L_0x028b;
                    case 21: goto L_0x0281;
                    case 22: goto L_0x0277;
                    case 23: goto L_0x026d;
                    case 24: goto L_0x0263;
                    case 25: goto L_0x0259;
                    case 26: goto L_0x024f;
                    case 27: goto L_0x0245;
                    case 28: goto L_0x023b;
                    case 29: goto L_0x0231;
                    case 30: goto L_0x0227;
                    case 31: goto L_0x0218;
                    case 32: goto L_0x020d;
                    case 33: goto L_0x01f6;
                    case 34: goto L_0x01df;
                    case 35: goto L_0x01cf;
                    case 36: goto L_0x01b8;
                    case 37: goto L_0x01a1;
                    case 38: goto L_0x0191;
                    default: goto L_0x00b1;
                }
            L_0x00b1:
                switch(r5) {
                    case 44: goto L_0x00f6;
                    case 45: goto L_0x00ec;
                    case 46: goto L_0x00e2;
                    case 47: goto L_0x00da;
                    case 48: goto L_0x00d2;
                    case 49: goto L_0x00c8;
                    case 50: goto L_0x00be;
                    case 51: goto L_0x00b6;
                    default: goto L_0x00b4;
                }
            L_0x00b4:
                goto L_0x03c5
            L_0x00b6:
                java.lang.String r4 = r11.getString(r4)
                r10.V = r4
                goto L_0x03c5
            L_0x00be:
                int r5 = r10.R
                int r4 = r11.getDimensionPixelOffset(r4, r5)
                r10.R = r4
                goto L_0x03c5
            L_0x00c8:
                int r5 = r10.Q
                int r4 = r11.getDimensionPixelOffset(r4, r5)
                r10.Q = r4
                goto L_0x03c5
            L_0x00d2:
                int r4 = r11.getInt(r4, r2)
                r10.H = r4
                goto L_0x03c5
            L_0x00da:
                int r4 = r11.getInt(r4, r2)
                r10.G = r4
                goto L_0x03c5
            L_0x00e2:
                float r5 = r10.F
                float r4 = r11.getFloat(r4, r5)
                r10.F = r4
                goto L_0x03c5
            L_0x00ec:
                float r5 = r10.E
                float r4 = r11.getFloat(r4, r5)
                r10.E = r4
                goto L_0x03c5
            L_0x00f6:
                java.lang.String r4 = r11.getString(r4)
                r10.B = r4
                r5 = 2143289344(0x7fc00000, float:NaN)
                r10.C = r5
                r10.D = r0
                if (r4 == 0) goto L_0x03c5
                int r4 = r4.length()
                java.lang.String r5 = r10.B
                r7 = 44
                int r5 = r5.indexOf(r7)
                if (r5 <= 0) goto L_0x0134
                int r7 = r4 + -1
                if (r5 >= r7) goto L_0x0134
                java.lang.String r7 = r10.B
                java.lang.String r7 = r7.substring(r2, r5)
                java.lang.String r8 = "W"
                boolean r8 = r7.equalsIgnoreCase(r8)
                if (r8 == 0) goto L_0x0127
                r10.D = r2
                goto L_0x0131
            L_0x0127:
                java.lang.String r8 = "H"
                boolean r7 = r7.equalsIgnoreCase(r8)
                if (r7 == 0) goto L_0x0131
                r10.D = r6
            L_0x0131:
                int r5 = r5 + 1
                goto L_0x0135
            L_0x0134:
                r5 = 0
            L_0x0135:
                java.lang.String r7 = r10.B
                r8 = 58
                int r7 = r7.indexOf(r8)
                if (r7 < 0) goto L_0x0180
                int r4 = r4 + -1
                if (r7 >= r4) goto L_0x0180
                java.lang.String r4 = r10.B
                java.lang.String r4 = r4.substring(r5, r7)
                java.lang.String r5 = r10.B
                int r7 = r7 + 1
                java.lang.String r5 = r5.substring(r7)
                int r7 = r4.length()
                if (r7 <= 0) goto L_0x03c5
                int r7 = r5.length()
                if (r7 <= 0) goto L_0x03c5
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03c5 }
                float r5 = java.lang.Float.parseFloat(r5)     // Catch:{ NumberFormatException -> 0x03c5 }
                int r7 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03c5
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x03c5
                int r7 = r10.D     // Catch:{ NumberFormatException -> 0x03c5 }
                if (r7 != r6) goto L_0x017a
                float r5 = r5 / r4
                float r4 = java.lang.Math.abs(r5)     // Catch:{ NumberFormatException -> 0x03c5 }
            L_0x0176:
                r10.C = r4     // Catch:{ NumberFormatException -> 0x03c5 }
                goto L_0x03c5
            L_0x017a:
                float r4 = r4 / r5
                float r4 = java.lang.Math.abs(r4)     // Catch:{ NumberFormatException -> 0x03c5 }
                goto L_0x0176
            L_0x0180:
                java.lang.String r4 = r10.B
                java.lang.String r4 = r4.substring(r5)
                int r5 = r4.length()
                if (r5 <= 0) goto L_0x03c5
                float r4 = java.lang.Float.parseFloat(r4)     // Catch:{ NumberFormatException -> 0x03c5 }
                goto L_0x0176
            L_0x0191:
                float r5 = r10.P
                float r4 = r11.getFloat(r4, r5)
                float r4 = java.lang.Math.max(r3, r4)
                r10.P = r4
                r10.J = r8
                goto L_0x03c5
            L_0x01a1:
                int r5 = r10.N     // Catch:{ Exception -> 0x01ab }
                int r5 = r11.getDimensionPixelSize(r4, r5)     // Catch:{ Exception -> 0x01ab }
                r10.N = r5     // Catch:{ Exception -> 0x01ab }
                goto L_0x03c5
            L_0x01ab:
                int r5 = r10.N
                int r4 = r11.getInt(r4, r5)
                if (r4 != r9) goto L_0x03c5
                r10.N = r9
                goto L_0x03c5
            L_0x01b8:
                int r5 = r10.L     // Catch:{ Exception -> 0x01c2 }
                int r5 = r11.getDimensionPixelSize(r4, r5)     // Catch:{ Exception -> 0x01c2 }
                r10.L = r5     // Catch:{ Exception -> 0x01c2 }
                goto L_0x03c5
            L_0x01c2:
                int r5 = r10.L
                int r4 = r11.getInt(r4, r5)
                if (r4 != r9) goto L_0x03c5
                r10.L = r9
                goto L_0x03c5
            L_0x01cf:
                float r5 = r10.O
                float r4 = r11.getFloat(r4, r5)
                float r4 = java.lang.Math.max(r3, r4)
                r10.O = r4
                r10.I = r8
                goto L_0x03c5
            L_0x01df:
                int r5 = r10.M     // Catch:{ Exception -> 0x01e9 }
                int r5 = r11.getDimensionPixelSize(r4, r5)     // Catch:{ Exception -> 0x01e9 }
                r10.M = r5     // Catch:{ Exception -> 0x01e9 }
                goto L_0x03c5
            L_0x01e9:
                int r5 = r10.M
                int r4 = r11.getInt(r4, r5)
                if (r4 != r9) goto L_0x03c5
                r10.M = r9
                goto L_0x03c5
            L_0x01f6:
                int r5 = r10.K     // Catch:{ Exception -> 0x0200 }
                int r5 = r11.getDimensionPixelSize(r4, r5)     // Catch:{ Exception -> 0x0200 }
                r10.K = r5     // Catch:{ Exception -> 0x0200 }
                goto L_0x03c5
            L_0x0200:
                int r5 = r10.K
                int r4 = r11.getInt(r4, r5)
                if (r4 != r9) goto L_0x03c5
                r10.K = r9
                goto L_0x03c5
            L_0x020d:
                int r4 = r11.getInt(r4, r2)
                r10.J = r4
                if (r4 != r6) goto L_0x03c5
                java.lang.String r4 = "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead."
                goto L_0x0222
            L_0x0218:
                int r4 = r11.getInt(r4, r2)
                r10.I = r4
                if (r4 != r6) goto L_0x03c5
                java.lang.String r4 = "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead."
            L_0x0222:
                android.util.Log.e(r7, r4)
                goto L_0x03c5
            L_0x0227:
                float r5 = r10.A
                float r4 = r11.getFloat(r4, r5)
                r10.A = r4
                goto L_0x03c5
            L_0x0231:
                float r5 = r10.f2586z
                float r4 = r11.getFloat(r4, r5)
                r10.f2586z = r4
                goto L_0x03c5
            L_0x023b:
                boolean r5 = r10.U
                boolean r4 = r11.getBoolean(r4, r5)
                r10.U = r4
                goto L_0x03c5
            L_0x0245:
                boolean r5 = r10.T
                boolean r4 = r11.getBoolean(r4, r5)
                r10.T = r4
                goto L_0x03c5
            L_0x024f:
                int r5 = r10.f2585y
                int r4 = r11.getDimensionPixelSize(r4, r5)
                r10.f2585y = r4
                goto L_0x03c5
            L_0x0259:
                int r5 = r10.f2584x
                int r4 = r11.getDimensionPixelSize(r4, r5)
                r10.f2584x = r4
                goto L_0x03c5
            L_0x0263:
                int r5 = r10.f2583w
                int r4 = r11.getDimensionPixelSize(r4, r5)
                r10.f2583w = r4
                goto L_0x03c5
            L_0x026d:
                int r5 = r10.f2582v
                int r4 = r11.getDimensionPixelSize(r4, r5)
                r10.f2582v = r4
                goto L_0x03c5
            L_0x0277:
                int r5 = r10.f2581u
                int r4 = r11.getDimensionPixelSize(r4, r5)
                r10.f2581u = r4
                goto L_0x03c5
            L_0x0281:
                int r5 = r10.f2580t
                int r4 = r11.getDimensionPixelSize(r4, r5)
                r10.f2580t = r4
                goto L_0x03c5
            L_0x028b:
                int r5 = r10.f2579s
                int r5 = r11.getResourceId(r4, r5)
                r10.f2579s = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2579s = r4
                goto L_0x03c5
            L_0x029d:
                int r5 = r10.f2578r
                int r5 = r11.getResourceId(r4, r5)
                r10.f2578r = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2578r = r4
                goto L_0x03c5
            L_0x02af:
                int r5 = r10.f2577q
                int r5 = r11.getResourceId(r4, r5)
                r10.f2577q = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2577q = r4
                goto L_0x03c5
            L_0x02c1:
                int r5 = r10.f2576p
                int r5 = r11.getResourceId(r4, r5)
                r10.f2576p = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2576p = r4
                goto L_0x03c5
            L_0x02d3:
                int r5 = r10.f2572l
                int r5 = r11.getResourceId(r4, r5)
                r10.f2572l = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2572l = r4
                goto L_0x03c5
            L_0x02e5:
                int r5 = r10.f2571k
                int r5 = r11.getResourceId(r4, r5)
                r10.f2571k = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2571k = r4
                goto L_0x03c5
            L_0x02f7:
                int r5 = r10.f2570j
                int r5 = r11.getResourceId(r4, r5)
                r10.f2570j = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2570j = r4
                goto L_0x03c5
            L_0x0309:
                int r5 = r10.f2569i
                int r5 = r11.getResourceId(r4, r5)
                r10.f2569i = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2569i = r4
                goto L_0x03c5
            L_0x031b:
                int r5 = r10.f2568h
                int r5 = r11.getResourceId(r4, r5)
                r10.f2568h = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2568h = r4
                goto L_0x03c5
            L_0x032d:
                int r5 = r10.f2567g
                int r5 = r11.getResourceId(r4, r5)
                r10.f2567g = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2567g = r4
                goto L_0x03c5
            L_0x033f:
                int r5 = r10.f2566f
                int r5 = r11.getResourceId(r4, r5)
                r10.f2566f = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2566f = r4
                goto L_0x03c5
            L_0x0351:
                int r5 = r10.f2565e
                int r5 = r11.getResourceId(r4, r5)
                r10.f2565e = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2565e = r4
                goto L_0x03c5
            L_0x0362:
                int r5 = r10.f2564d
                int r5 = r11.getResourceId(r4, r5)
                r10.f2564d = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2564d = r4
                goto L_0x03c5
            L_0x0373:
                float r5 = r10.f2563c
                float r4 = r11.getFloat(r4, r5)
                r10.f2563c = r4
                goto L_0x03c5
            L_0x037c:
                int r5 = r10.f2562b
                int r4 = r11.getDimensionPixelOffset(r4, r5)
                r10.f2562b = r4
                goto L_0x03c5
            L_0x0385:
                int r5 = r10.f2546a
                int r4 = r11.getDimensionPixelOffset(r4, r5)
                r10.f2546a = r4
                goto L_0x03c5
            L_0x038e:
                float r5 = r10.f2575o
                float r4 = r11.getFloat(r4, r5)
                r5 = 1135869952(0x43b40000, float:360.0)
                float r4 = r4 % r5
                r10.f2575o = r4
                int r7 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
                if (r7 >= 0) goto L_0x03c5
                float r4 = r5 - r4
                float r4 = r4 % r5
                r10.f2575o = r4
                goto L_0x03c5
            L_0x03a3:
                int r5 = r10.f2574n
                int r4 = r11.getDimensionPixelSize(r4, r5)
                r10.f2574n = r4
                goto L_0x03c5
            L_0x03ac:
                int r5 = r10.f2573m
                int r5 = r11.getResourceId(r4, r5)
                r10.f2573m = r5
                if (r5 != r0) goto L_0x03c5
                int r4 = r11.getInt(r4, r0)
                r10.f2573m = r4
                goto L_0x03c5
            L_0x03bd:
                int r5 = r10.S
                int r4 = r11.getInt(r4, r5)
                r10.S = r4
            L_0x03c5:
                int r1 = r1 + 1
                goto L_0x009e
            L_0x03c9:
                r11.recycle()
                r10.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.<init>(android.content.Context, android.util.AttributeSet):void");
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public ConstraintWidget a() {
            return this.f2560an;
        }

        public void b() {
            this.Z = false;
            this.W = true;
            this.X = true;
            if (this.width == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            if (this.height == -2 && this.U) {
                this.X = false;
                if (this.J == 0) {
                    this.J = 1;
                }
            }
            if (this.width == 0 || this.width == -1) {
                this.W = false;
                if (this.width == 0 && this.I == 1) {
                    this.width = -2;
                    this.T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.X = false;
                if (this.height == 0 && this.J == 1) {
                    this.height = -2;
                    this.U = true;
                }
            }
            if (this.f2563c != -1.0f || this.f2546a != -1 || this.f2562b != -1) {
                this.Z = true;
                this.W = true;
                this.X = true;
                if (!(this.f2560an instanceof f)) {
                    this.f2560an = new f();
                }
                ((f) this.f2560an).a(this.S);
            }
        }

        public String c() {
            return this.V;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d4, code lost:
            if (r1 > 0) goto L_0x00d6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x00e3, code lost:
            if (r1 > 0) goto L_0x00d6;
         */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x00ea  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r10) {
            /*
                r9 = this;
                int r0 = r9.leftMargin
                int r1 = r9.rightMargin
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 0
                r4 = 1
                r5 = 17
                if (r2 < r5) goto L_0x0017
                super.resolveLayoutDirection(r10)
                int r10 = r9.getLayoutDirection()
                if (r4 != r10) goto L_0x0017
                r10 = 1
                goto L_0x0018
            L_0x0017:
                r10 = 0
            L_0x0018:
                r2 = -1
                r9.f2552af = r2
                r9.f2553ag = r2
                r9.f2550ad = r2
                r9.f2551ae = r2
                r9.f2554ah = r2
                r9.f2555ai = r2
                int r5 = r9.f2580t
                r9.f2554ah = r5
                int r5 = r9.f2582v
                r9.f2555ai = r5
                float r5 = r9.f2586z
                r9.f2556aj = r5
                int r6 = r9.f2546a
                r9.f2557ak = r6
                int r7 = r9.f2562b
                r9.f2558al = r7
                float r8 = r9.f2563c
                r9.f2559am = r8
                if (r10 == 0) goto L_0x0096
                int r10 = r9.f2576p
                if (r10 == r2) goto L_0x0047
                r9.f2552af = r10
            L_0x0045:
                r3 = 1
                goto L_0x004e
            L_0x0047:
                int r10 = r9.f2577q
                if (r10 == r2) goto L_0x004e
                r9.f2553ag = r10
                goto L_0x0045
            L_0x004e:
                int r10 = r9.f2578r
                if (r10 == r2) goto L_0x0055
                r9.f2551ae = r10
                r3 = 1
            L_0x0055:
                int r10 = r9.f2579s
                if (r10 == r2) goto L_0x005c
                r9.f2550ad = r10
                r3 = 1
            L_0x005c:
                int r10 = r9.f2584x
                if (r10 == r2) goto L_0x0062
                r9.f2555ai = r10
            L_0x0062:
                int r10 = r9.f2585y
                if (r10 == r2) goto L_0x0068
                r9.f2554ah = r10
            L_0x0068:
                r10 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0070
                float r3 = r10 - r5
                r9.f2556aj = r3
            L_0x0070:
                boolean r3 = r9.Z
                if (r3 == 0) goto L_0x00ba
                int r3 = r9.S
                if (r3 != r4) goto L_0x00ba
                r3 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r4 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r4 == 0) goto L_0x0086
                float r10 = r10 - r8
                r9.f2559am = r10
                r9.f2557ak = r2
                r9.f2558al = r2
                goto L_0x00ba
            L_0x0086:
                if (r6 == r2) goto L_0x008f
                r9.f2558al = r6
                r9.f2557ak = r2
            L_0x008c:
                r9.f2559am = r3
                goto L_0x00ba
            L_0x008f:
                if (r7 == r2) goto L_0x00ba
                r9.f2557ak = r7
                r9.f2558al = r2
                goto L_0x008c
            L_0x0096:
                int r10 = r9.f2576p
                if (r10 == r2) goto L_0x009c
                r9.f2551ae = r10
            L_0x009c:
                int r10 = r9.f2577q
                if (r10 == r2) goto L_0x00a2
                r9.f2550ad = r10
            L_0x00a2:
                int r10 = r9.f2578r
                if (r10 == r2) goto L_0x00a8
                r9.f2552af = r10
            L_0x00a8:
                int r10 = r9.f2579s
                if (r10 == r2) goto L_0x00ae
                r9.f2553ag = r10
            L_0x00ae:
                int r10 = r9.f2584x
                if (r10 == r2) goto L_0x00b4
                r9.f2554ah = r10
            L_0x00b4:
                int r10 = r9.f2585y
                if (r10 == r2) goto L_0x00ba
                r9.f2555ai = r10
            L_0x00ba:
                int r10 = r9.f2578r
                if (r10 != r2) goto L_0x0102
                int r10 = r9.f2579s
                if (r10 != r2) goto L_0x0102
                int r10 = r9.f2577q
                if (r10 != r2) goto L_0x0102
                int r10 = r9.f2576p
                if (r10 != r2) goto L_0x0102
                int r10 = r9.f2566f
                if (r10 == r2) goto L_0x00d9
                r9.f2552af = r10
                int r10 = r9.rightMargin
                if (r10 > 0) goto L_0x00e6
                if (r1 <= 0) goto L_0x00e6
            L_0x00d6:
                r9.rightMargin = r1
                goto L_0x00e6
            L_0x00d9:
                int r10 = r9.f2567g
                if (r10 == r2) goto L_0x00e6
                r9.f2553ag = r10
                int r10 = r9.rightMargin
                if (r10 > 0) goto L_0x00e6
                if (r1 <= 0) goto L_0x00e6
                goto L_0x00d6
            L_0x00e6:
                int r10 = r9.f2564d
                if (r10 == r2) goto L_0x00f5
                r9.f2550ad = r10
                int r10 = r9.leftMargin
                if (r10 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
            L_0x00f2:
                r9.leftMargin = r0
                goto L_0x0102
            L_0x00f5:
                int r10 = r9.f2565e
                if (r10 == r2) goto L_0x0102
                r9.f2551ae = r10
                int r10 = r9.leftMargin
                if (r10 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                goto L_0x00f2
            L_0x0102:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }
    }

    class a implements b.C0022b {

        /* renamed from: a  reason: collision with root package name */
        ConstraintLayout f2588a;

        /* renamed from: b  reason: collision with root package name */
        int f2589b;

        /* renamed from: c  reason: collision with root package name */
        int f2590c;

        /* renamed from: d  reason: collision with root package name */
        int f2591d;

        /* renamed from: e  reason: collision with root package name */
        int f2592e;

        /* renamed from: f  reason: collision with root package name */
        int f2593f;

        /* renamed from: g  reason: collision with root package name */
        int f2594g;

        public a(ConstraintLayout constraintLayout) {
            this.f2588a = constraintLayout;
        }

        private boolean a(int i2, int i3, int i4) {
            if (i2 == i3) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i2);
            View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i4 == size;
            }
            return false;
        }

        public final void a() {
            int childCount = this.f2588a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f2588a.getChildAt(i2);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).b(this.f2588a);
                }
            }
            int size = this.f2588a.f2530a.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ((ConstraintHelper) this.f2588a.f2530a.get(i3)).f(this.f2588a);
                }
            }
        }

        public void a(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f2589b = i4;
            this.f2590c = i5;
            this.f2591d = i6;
            this.f2592e = i7;
            this.f2593f = i2;
            this.f2594g = i3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x019a  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x019c  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x019f  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x01b6  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x01b8  */
        /* JADX WARNING: Removed duplicated region for block: B:113:0x01bd  */
        /* JADX WARNING: Removed duplicated region for block: B:114:0x01bf  */
        /* JADX WARNING: Removed duplicated region for block: B:119:0x01c9  */
        /* JADX WARNING: Removed duplicated region for block: B:120:0x01cb  */
        /* JADX WARNING: Removed duplicated region for block: B:125:0x01d5  */
        /* JADX WARNING: Removed duplicated region for block: B:126:0x01d7  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x01e1  */
        /* JADX WARNING: Removed duplicated region for block: B:132:0x01e3  */
        /* JADX WARNING: Removed duplicated region for block: B:136:0x01ec  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x01ee  */
        /* JADX WARNING: Removed duplicated region for block: B:139:0x01f1 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:140:0x01f2  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0129  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(androidx.constraintlayout.solver.widgets.ConstraintWidget r18, androidx.constraintlayout.solver.widgets.analyzer.b.a r19) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                if (r1 != 0) goto L_0x0009
                return
            L_0x0009:
                int r3 = r18.w()
                r4 = 8
                r5 = 0
                if (r3 != r4) goto L_0x001f
                boolean r3 = r18.o()
                if (r3 != 0) goto L_0x001f
                r2.f2348h = r5
                r2.f2349i = r5
                r2.f2350j = r5
                return
            L_0x001f:
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r18.v()
                if (r3 != 0) goto L_0x0026
                return
            L_0x0026:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = r2.f2344d
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r4 = r2.f2345e
                int r6 = r2.f2346f
                int r7 = r2.f2347g
                int r8 = r0.f2589b
                int r9 = r0.f2590c
                int r8 = r8 + r9
                int r9 = r0.f2591d
                java.lang.Object r10 = r18.M()
                android.view.View r10 = (android.view.View) r10
                int[] r11 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.f2545a
                int r12 = r3.ordinal()
                r11 = r11[r12]
                r12 = 4
                r13 = 3
                r14 = 2
                r5 = -2
                r15 = 1
                if (r11 == r15) goto L_0x00ad
                if (r11 == r14) goto L_0x00a6
                if (r11 == r13) goto L_0x0099
                if (r11 == r12) goto L_0x0052
                r6 = 0
                goto L_0x00b3
            L_0x0052:
                int r6 = r0.f2593f
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r5)
                int r9 = r1.f2276l
                if (r9 != r15) goto L_0x005e
                r9 = 1
                goto L_0x005f
            L_0x005e:
                r9 = 0
            L_0x005f:
                int r11 = r2.f2353m
                int r12 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2342b
                if (r11 == r12) goto L_0x006b
                int r11 = r2.f2353m
                int r12 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2343c
                if (r11 != r12) goto L_0x00b3
            L_0x006b:
                int r11 = r10.getMeasuredHeight()
                int r12 = r18.B()
                if (r11 != r12) goto L_0x0077
                r11 = 1
                goto L_0x0078
            L_0x0077:
                r11 = 0
            L_0x0078:
                int r12 = r2.f2353m
                int r13 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2343c
                if (r12 == r13) goto L_0x0091
                if (r9 == 0) goto L_0x0091
                if (r9 == 0) goto L_0x0084
                if (r11 != 0) goto L_0x0091
            L_0x0084:
                boolean r9 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r9 != 0) goto L_0x0091
                boolean r9 = r18.d()
                if (r9 == 0) goto L_0x008f
                goto L_0x0091
            L_0x008f:
                r9 = 0
                goto L_0x0092
            L_0x0091:
                r9 = 1
            L_0x0092:
                if (r9 == 0) goto L_0x00b3
                int r6 = r18.A()
                goto L_0x00ad
            L_0x0099:
                int r6 = r0.f2593f
                int r11 = r18.G()
                int r9 = r9 + r11
                r11 = -1
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r11)
                goto L_0x00b3
            L_0x00a6:
                int r6 = r0.f2593f
                int r6 = android.view.ViewGroup.getChildMeasureSpec(r6, r9, r5)
                goto L_0x00b3
            L_0x00ad:
                r9 = 1073741824(0x40000000, float:2.0)
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9)
            L_0x00b3:
                int[] r9 = androidx.constraintlayout.widget.ConstraintLayout.AnonymousClass1.f2545a
                int r11 = r4.ordinal()
                r9 = r9[r11]
                if (r9 == r15) goto L_0x0129
                if (r9 == r14) goto L_0x0122
                r7 = 3
                if (r9 == r7) goto L_0x0115
                r7 = 4
                if (r9 == r7) goto L_0x00c8
                r5 = 0
                goto L_0x0130
            L_0x00c8:
                int r7 = r0.f2594g
                int r5 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r5)
                int r7 = r1.f2277m
                if (r7 != r15) goto L_0x00d4
                r7 = 1
                goto L_0x00d5
            L_0x00d4:
                r7 = 0
            L_0x00d5:
                int r8 = r2.f2353m
                int r9 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2342b
                if (r8 == r9) goto L_0x00e1
                int r8 = r2.f2353m
                int r9 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2343c
                if (r8 != r9) goto L_0x0130
            L_0x00e1:
                int r8 = r10.getMeasuredWidth()
                int r9 = r18.A()
                if (r8 != r9) goto L_0x00ed
                r8 = 1
                goto L_0x00ee
            L_0x00ed:
                r8 = 0
            L_0x00ee:
                int r9 = r2.f2353m
                int r11 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2343c
                if (r9 == r11) goto L_0x0107
                if (r7 == 0) goto L_0x0107
                if (r7 == 0) goto L_0x00fa
                if (r8 != 0) goto L_0x0107
            L_0x00fa:
                boolean r7 = r10 instanceof androidx.constraintlayout.widget.Placeholder
                if (r7 != 0) goto L_0x0107
                boolean r7 = r18.e()
                if (r7 == 0) goto L_0x0105
                goto L_0x0107
            L_0x0105:
                r7 = 0
                goto L_0x0108
            L_0x0107:
                r7 = 1
            L_0x0108:
                if (r7 == 0) goto L_0x0130
                int r5 = r18.B()
                r7 = 1073741824(0x40000000, float:2.0)
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r7)
                goto L_0x0130
            L_0x0115:
                int r5 = r0.f2594g
                int r7 = r18.H()
                int r8 = r8 + r7
                r7 = -1
                int r5 = android.view.ViewGroup.getChildMeasureSpec(r5, r8, r7)
                goto L_0x0130
            L_0x0122:
                int r7 = r0.f2594g
                int r5 = android.view.ViewGroup.getChildMeasureSpec(r7, r8, r5)
                goto L_0x0130
            L_0x0129:
                r5 = 1073741824(0x40000000, float:2.0)
                int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                r5 = r7
            L_0x0130:
                androidx.constraintlayout.solver.widgets.ConstraintWidget r7 = r18.v()
                androidx.constraintlayout.solver.widgets.d r7 = (androidx.constraintlayout.solver.widgets.d) r7
                if (r7 == 0) goto L_0x01b2
                androidx.constraintlayout.widget.ConstraintLayout r8 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r8 = r8.f2535f
                r9 = 256(0x100, float:3.59E-43)
                boolean r8 = androidx.constraintlayout.solver.widgets.i.a(r8, r9)
                if (r8 == 0) goto L_0x01b2
                int r8 = r10.getMeasuredWidth()
                int r9 = r18.A()
                if (r8 != r9) goto L_0x01b2
                int r8 = r10.getMeasuredWidth()
                int r9 = r7.A()
                if (r8 >= r9) goto L_0x01b2
                int r8 = r10.getMeasuredHeight()
                int r9 = r18.B()
                if (r8 != r9) goto L_0x01b2
                int r8 = r10.getMeasuredHeight()
                int r7 = r7.B()
                if (r8 >= r7) goto L_0x01b2
                int r7 = r10.getBaseline()
                int r8 = r18.L()
                if (r7 != r8) goto L_0x01b2
                boolean r7 = r18.p()
                if (r7 != 0) goto L_0x01b2
                int r7 = r18.q()
                int r8 = r18.A()
                boolean r7 = r0.a(r7, r6, r8)
                if (r7 == 0) goto L_0x019c
                int r7 = r18.r()
                int r8 = r18.B()
                boolean r7 = r0.a(r7, r5, r8)
                if (r7 == 0) goto L_0x019c
                r7 = 1
                goto L_0x019d
            L_0x019c:
                r7 = 0
            L_0x019d:
                if (r7 == 0) goto L_0x01b2
                int r3 = r18.A()
                r2.f2348h = r3
                int r3 = r18.B()
                r2.f2349i = r3
                int r1 = r18.L()
                r2.f2350j = r1
                return
            L_0x01b2:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r3 != r7) goto L_0x01b8
                r7 = 1
                goto L_0x01b9
            L_0x01b8:
                r7 = 0
            L_0x01b9:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r8 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
                if (r4 != r8) goto L_0x01bf
                r8 = 1
                goto L_0x01c0
            L_0x01bf:
                r8 = 0
            L_0x01c0:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r4 == r9) goto L_0x01cb
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r4 != r9) goto L_0x01c9
                goto L_0x01cb
            L_0x01c9:
                r4 = 0
                goto L_0x01cc
            L_0x01cb:
                r4 = 1
            L_0x01cc:
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
                if (r3 == r9) goto L_0x01d7
                androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
                if (r3 != r9) goto L_0x01d5
                goto L_0x01d7
            L_0x01d5:
                r3 = 0
                goto L_0x01d8
            L_0x01d7:
                r3 = 1
            L_0x01d8:
                r9 = 0
                if (r7 == 0) goto L_0x01e3
                float r11 = r1.M
                int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r11 <= 0) goto L_0x01e3
                r11 = 1
                goto L_0x01e4
            L_0x01e3:
                r11 = 0
            L_0x01e4:
                if (r8 == 0) goto L_0x01ee
                float r12 = r1.M
                int r9 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
                if (r9 <= 0) goto L_0x01ee
                r9 = 1
                goto L_0x01ef
            L_0x01ee:
                r9 = 0
            L_0x01ef:
                if (r10 != 0) goto L_0x01f2
                return
            L_0x01f2:
                android.view.ViewGroup$LayoutParams r12 = r10.getLayoutParams()
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r12 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r12
                int r13 = r2.f2353m
                int r14 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2342b
                if (r13 == r14) goto L_0x0217
                int r13 = r2.f2353m
                int r14 = androidx.constraintlayout.solver.widgets.analyzer.b.a.f2343c
                if (r13 == r14) goto L_0x0217
                if (r7 == 0) goto L_0x0217
                int r7 = r1.f2276l
                if (r7 != 0) goto L_0x0217
                if (r8 == 0) goto L_0x0217
                int r7 = r1.f2277m
                if (r7 == 0) goto L_0x0211
                goto L_0x0217
            L_0x0211:
                r0 = -1
                r13 = 0
                r14 = 0
                r15 = 0
                goto L_0x02bb
            L_0x0217:
                boolean r7 = r10 instanceof androidx.constraintlayout.widget.VirtualLayout
                if (r7 == 0) goto L_0x0229
                boolean r7 = r1 instanceof androidx.constraintlayout.solver.widgets.j
                if (r7 == 0) goto L_0x0229
                r7 = r1
                androidx.constraintlayout.solver.widgets.j r7 = (androidx.constraintlayout.solver.widgets.j) r7
                r8 = r10
                androidx.constraintlayout.widget.VirtualLayout r8 = (androidx.constraintlayout.widget.VirtualLayout) r8
                r8.a(r7, r6, r5)
                goto L_0x022c
            L_0x0229:
                r10.measure(r6, r5)
            L_0x022c:
                r1.c(r6, r5)
                int r7 = r10.getMeasuredWidth()
                int r8 = r10.getMeasuredHeight()
                int r13 = r10.getBaseline()
                int r14 = r1.f2279o
                if (r14 <= 0) goto L_0x0246
                int r14 = r1.f2279o
                int r14 = java.lang.Math.max(r14, r7)
                goto L_0x0247
            L_0x0246:
                r14 = r7
            L_0x0247:
                int r15 = r1.f2280p
                if (r15 <= 0) goto L_0x0251
                int r15 = r1.f2280p
                int r14 = java.lang.Math.min(r15, r14)
            L_0x0251:
                int r15 = r1.f2282r
                if (r15 <= 0) goto L_0x025e
                int r15 = r1.f2282r
                int r15 = java.lang.Math.max(r15, r8)
                r16 = r5
                goto L_0x0261
            L_0x025e:
                r16 = r5
                r15 = r8
            L_0x0261:
                int r5 = r1.f2283s
                if (r5 <= 0) goto L_0x026b
                int r5 = r1.f2283s
                int r15 = java.lang.Math.min(r5, r15)
            L_0x026b:
                androidx.constraintlayout.widget.ConstraintLayout r5 = androidx.constraintlayout.widget.ConstraintLayout.this
                int r5 = r5.f2535f
                r0 = 1
                boolean r5 = androidx.constraintlayout.solver.widgets.i.a(r5, r0)
                if (r5 != 0) goto L_0x0290
                r0 = 1056964608(0x3f000000, float:0.5)
                if (r11 == 0) goto L_0x0286
                if (r4 == 0) goto L_0x0286
                float r3 = r1.M
                float r4 = (float) r15
                float r4 = r4 * r3
                float r4 = r4 + r0
                int r14 = (int) r4
                goto L_0x0290
            L_0x0286:
                if (r9 == 0) goto L_0x0290
                if (r3 == 0) goto L_0x0290
                float r3 = r1.M
                float r4 = (float) r14
                float r4 = r4 / r3
                float r4 = r4 + r0
                int r15 = (int) r4
            L_0x0290:
                if (r7 != r14) goto L_0x0297
                if (r8 == r15) goto L_0x0295
                goto L_0x0297
            L_0x0295:
                r0 = -1
                goto L_0x02bb
            L_0x0297:
                r0 = 1073741824(0x40000000, float:2.0)
                if (r7 == r14) goto L_0x029f
                int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r0)
            L_0x029f:
                if (r8 == r15) goto L_0x02a6
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r0)
                goto L_0x02a8
            L_0x02a6:
                r5 = r16
            L_0x02a8:
                r10.measure(r6, r5)
                r1.c(r6, r5)
                int r14 = r10.getMeasuredWidth()
                int r15 = r10.getMeasuredHeight()
                int r13 = r10.getBaseline()
                goto L_0x0295
            L_0x02bb:
                if (r13 == r0) goto L_0x02bf
                r0 = 1
                goto L_0x02c0
            L_0x02bf:
                r0 = 0
            L_0x02c0:
                int r3 = r2.f2346f
                if (r14 != r3) goto L_0x02cb
                int r3 = r2.f2347g
                if (r15 == r3) goto L_0x02c9
                goto L_0x02cb
            L_0x02c9:
                r5 = 0
                goto L_0x02cc
            L_0x02cb:
                r5 = 1
            L_0x02cc:
                r2.f2352l = r5
                boolean r3 = r12.Y
                if (r3 == 0) goto L_0x02d3
                r0 = 1
            L_0x02d3:
                if (r0 == 0) goto L_0x02e1
                r3 = -1
                if (r13 == r3) goto L_0x02e1
                int r1 = r18.L()
                if (r1 == r13) goto L_0x02e1
                r1 = 1
                r2.f2352l = r1
            L_0x02e1:
                r2.f2348h = r14
                r2.f2349i = r15
                r2.f2351k = r0
                r2.f2350j = r13
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.a(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.analyzer.b$a):void");
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        a((AttributeSet) null, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet, i2, 0);
    }

    private final ConstraintWidget a(int i2) {
        if (i2 == 0) {
            return this.K;
        }
        View view = this.J.get(i2);
        if (view == null && (view = findViewById(i2)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.K;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2560an;
    }

    private void a(AttributeSet attributeSet, int i2, int i3) {
        this.K.a((Object) this);
        this.K.a((b.C0022b) this.R);
        this.J.put(getId(), this);
        this.f2536g = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f2531b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2531b);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f2532c = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2532c);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f2533d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2533d);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f2534e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2534e);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f2535f = obtainStyledAttributes.getInt(index, this.f2535f);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            b(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.M = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        b bVar = new b();
                        this.f2536g = bVar;
                        bVar.b(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f2536g = null;
                    }
                    this.f2537h = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.K.a(this.f2535f);
    }

    private boolean a() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (getChildAt(i2).isLayoutRequested()) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (z2) {
            b();
        }
        return z2;
    }

    private void b() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ConstraintWidget a2 = a(getChildAt(i2));
            if (a2 != null) {
                a2.s();
            }
        }
        if (isInEditMode) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    a(0, (Object) resourceName, (Object) Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    a(childAt.getId()).a(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f2537h != -1) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt2 = getChildAt(i4);
                if (childAt2.getId() == this.f2537h && (childAt2 instanceof Constraints)) {
                    this.f2536g = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        b bVar = this.f2536g;
        if (bVar != null) {
            bVar.a(this, true);
        }
        this.K.ad();
        int size = this.f2530a.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                this.f2530a.get(i5).d(this);
            }
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt3 = getChildAt(i6);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).a(this);
            }
        }
        this.f2541l.clear();
        this.f2541l.put(0, this.K);
        this.f2541l.put(getId(), this.K);
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt4 = getChildAt(i7);
            this.f2541l.put(childAt4.getId(), a(childAt4));
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt5 = getChildAt(i8);
            ConstraintWidget a3 = a(childAt5);
            if (a3 != null) {
                this.K.b(a3);
                a(isInEditMode, childAt5, a3, (LayoutParams) childAt5.getLayoutParams(), this.f2541l);
            }
        }
    }

    private void c() {
        this.L = true;
        this.f2539j = -1;
        this.f2540k = -1;
        this.N = -1;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
    }

    private int getPaddingWidth() {
        int i2 = 0;
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            i2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return i2 > 0 ? i2 : max;
    }

    public final ConstraintWidget a(View view) {
        if (view == this) {
            return this.K;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2560an;
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Object a(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.f2538i;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.f2538i.get(str);
    }

    public void a(int i2, int i3, int i4) {
        a aVar = this.M;
        if (aVar != null) {
            aVar.a(i2, (float) i3, (float) i4);
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, int i4, int i5, boolean z2, boolean z3) {
        int i6 = this.R.f2592e;
        int i7 = i4 + this.R.f2591d;
        int i8 = i5 + i6;
        if (Build.VERSION.SDK_INT >= 11) {
            int resolveSizeAndState = resolveSizeAndState(i7, i2, 0);
            int min = Math.min(this.f2533d, resolveSizeAndState & 16777215);
            int min2 = Math.min(this.f2534e, resolveSizeAndState(i8, i3, 0) & 16777215);
            if (z2) {
                min |= 16777216;
            }
            if (z3) {
                min2 |= 16777216;
            }
            setMeasuredDimension(min, min2);
            this.f2539j = min;
            this.f2540k = min2;
            return;
        }
        setMeasuredDimension(i7, i8);
        this.f2539j = i7;
        this.f2540k = i8;
    }

    public void a(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f2538i == null) {
                this.f2538i = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.f2538i.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, int i2, int i3, int i4) {
        int i5;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i6 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.R.a(i3, i4, max, max2, paddingWidth, i6);
        if (Build.VERSION.SDK_INT >= 17) {
            int max3 = Math.max(0, getPaddingStart());
            int max4 = Math.max(0, getPaddingEnd());
            if (max3 <= 0 && max4 <= 0) {
                max3 = Math.max(0, getPaddingLeft());
            } else if (h()) {
                max3 = max4;
            }
            i5 = max3;
        } else {
            i5 = Math.max(0, getPaddingLeft());
        }
        int i7 = size - paddingWidth;
        int i8 = size2 - i6;
        a(dVar, mode, i7, mode2, i8);
        dVar.a(i2, mode, i7, mode2, i8, this.f2539j, this.f2540k, i5, max);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r4 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r4 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0027, code lost:
        if (r4 == 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (r4 == 0) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.constraintlayout.solver.widgets.d r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            androidx.constraintlayout.widget.ConstraintLayout$a r0 = r8.R
            int r0 = r0.f2592e
            androidx.constraintlayout.widget.ConstraintLayout$a r1 = r8.R
            int r1 = r1.f2591d
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            int r4 = r8.getChildCount()
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 0
            if (r10 == r6) goto L_0x002a
            if (r10 == 0) goto L_0x0025
            if (r10 == r5) goto L_0x001d
        L_0x001b:
            r11 = 0
            goto L_0x0034
        L_0x001d:
            int r10 = r8.f2533d
            int r10 = r10 - r1
            int r11 = java.lang.Math.min(r10, r11)
            goto L_0x0034
        L_0x0025:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L_0x001b
            goto L_0x002e
        L_0x002a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L_0x0034
        L_0x002e:
            int r10 = r8.f2531b
            int r11 = java.lang.Math.max(r7, r10)
        L_0x0034:
            if (r12 == r6) goto L_0x0049
            if (r12 == 0) goto L_0x0044
            if (r12 == r5) goto L_0x003c
        L_0x003a:
            r13 = 0
            goto L_0x0053
        L_0x003c:
            int r10 = r8.f2534e
            int r10 = r10 - r0
            int r13 = java.lang.Math.min(r10, r13)
            goto L_0x0053
        L_0x0044:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L_0x003a
            goto L_0x004d
        L_0x0049:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r3 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r4 != 0) goto L_0x0053
        L_0x004d:
            int r10 = r8.f2532c
            int r13 = java.lang.Math.max(r7, r10)
        L_0x0053:
            int r10 = r9.A()
            if (r11 != r10) goto L_0x005f
            int r10 = r9.B()
            if (r13 == r10) goto L_0x0062
        L_0x005f:
            r9.c()
        L_0x0062:
            r9.m(r7)
            r9.n(r7)
            int r10 = r8.f2533d
            int r10 = r10 - r1
            r9.h(r10)
            int r10 = r8.f2534e
            int r10 = r10 - r0
            r9.i(r10)
            r9.q(r7)
            r9.r(r7)
            r9.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r2)
            r9.o(r11)
            r9.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r3)
            r9.p(r13)
            int r10 = r8.f2531b
            int r10 = r10 - r1
            r9.q(r10)
            int r10 = r8.f2532c
            int r10 = r10 - r0
            r9.r(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a(androidx.constraintlayout.solver.widgets.d, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r20, android.view.View r21, androidx.constraintlayout.solver.widgets.ConstraintWidget r22, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r23, android.util.SparseArray<androidx.constraintlayout.solver.widgets.ConstraintWidget> r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            r7 = r22
            r8 = r23
            r9 = r24
            r23.b()
            r10 = 0
            r8.f2561ao = r10
            int r2 = r21.getVisibility()
            r7.j(r2)
            boolean r2 = r8.f2548ab
            r11 = 1
            if (r2 == 0) goto L_0x0024
            r7.d((boolean) r11)
            r2 = 8
            r7.j(r2)
        L_0x0024:
            r7.a((java.lang.Object) r1)
            boolean r2 = r1 instanceof androidx.constraintlayout.widget.ConstraintHelper
            if (r2 == 0) goto L_0x0036
            androidx.constraintlayout.widget.ConstraintHelper r1 = (androidx.constraintlayout.widget.ConstraintHelper) r1
            androidx.constraintlayout.solver.widgets.d r2 = r0.K
            boolean r2 = r2.Y()
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r7, (boolean) r2)
        L_0x0036:
            boolean r1 = r8.Z
            r2 = 17
            r12 = -1
            if (r1 == 0) goto L_0x0069
            r1 = r7
            androidx.constraintlayout.solver.widgets.f r1 = (androidx.constraintlayout.solver.widgets.f) r1
            int r3 = r8.f2557ak
            int r4 = r8.f2558al
            float r5 = r8.f2559am
            int r6 = android.os.Build.VERSION.SDK_INT
            if (r6 >= r2) goto L_0x0050
            int r3 = r8.f2546a
            int r4 = r8.f2562b
            float r5 = r8.f2563c
        L_0x0050:
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x005b
            r1.e(r5)
            goto L_0x02bf
        L_0x005b:
            if (r3 == r12) goto L_0x0062
            r1.b(r3)
            goto L_0x02bf
        L_0x0062:
            if (r4 == r12) goto L_0x02bf
            r1.y(r4)
            goto L_0x02bf
        L_0x0069:
            int r1 = r8.f2550ad
            int r3 = r8.f2551ae
            int r4 = r8.f2552af
            int r5 = r8.f2553ag
            int r6 = r8.f2554ah
            int r13 = r8.f2555ai
            float r14 = r8.f2556aj
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 >= r2) goto L_0x00b0
            int r1 = r8.f2564d
            int r2 = r8.f2565e
            int r4 = r8.f2566f
            int r5 = r8.f2567g
            int r3 = r8.f2580t
            int r6 = r8.f2582v
            float r14 = r8.f2586z
            if (r1 != r12) goto L_0x009a
            if (r2 != r12) goto L_0x009a
            int r13 = r8.f2577q
            if (r13 == r12) goto L_0x0094
            int r1 = r8.f2577q
            goto L_0x009a
        L_0x0094:
            int r13 = r8.f2576p
            if (r13 == r12) goto L_0x009a
            int r2 = r8.f2576p
        L_0x009a:
            if (r4 != r12) goto L_0x00ab
            if (r5 != r12) goto L_0x00ab
            int r13 = r8.f2578r
            if (r13 == r12) goto L_0x00a5
            int r4 = r8.f2578r
            goto L_0x00ab
        L_0x00a5:
            int r13 = r8.f2579s
            if (r13 == r12) goto L_0x00ab
            int r5 = r8.f2579s
        L_0x00ab:
            r13 = r4
            r15 = r6
            r6 = r3
            r3 = r2
            goto L_0x00b2
        L_0x00b0:
            r15 = r13
            r13 = r4
        L_0x00b2:
            r18 = r14
            r14 = r5
            r5 = r18
            int r2 = r8.f2573m
            if (r2 == r12) goto L_0x00ce
            int r1 = r8.f2573m
            java.lang.Object r1 = r9.get(r1)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r1
            if (r1 == 0) goto L_0x01f4
            float r2 = r8.f2575o
            int r3 = r8.f2574n
            r7.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r1, (float) r2, (int) r3)
            goto L_0x01f4
        L_0x00ce:
            if (r1 == r12) goto L_0x00eb
            java.lang.Object r1 = r9.get(r1)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x00e8
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            int r1 = r8.leftMargin
            r16 = r1
            r1 = r22
            r17 = r5
            r5 = r16
            goto L_0x0100
        L_0x00e8:
            r17 = r5
            goto L_0x0103
        L_0x00eb:
            r17 = r5
            if (r3 == r12) goto L_0x0103
            java.lang.Object r1 = r9.get(r3)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x0103
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            int r5 = r8.leftMargin
            r1 = r22
        L_0x0100:
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r2, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (int) r5, (int) r6)
        L_0x0103:
            if (r13 == r12) goto L_0x0113
            java.lang.Object r1 = r9.get(r13)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x012a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            goto L_0x0122
        L_0x0113:
            if (r14 == r12) goto L_0x012a
            java.lang.Object r1 = r9.get(r14)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x012a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
        L_0x0122:
            int r5 = r8.rightMargin
            r1 = r22
            r6 = r15
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r2, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (int) r5, (int) r6)
        L_0x012a:
            int r1 = r8.f2568h
            if (r1 == r12) goto L_0x013e
            int r1 = r8.f2568h
            java.lang.Object r1 = r9.get(r1)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x015a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            goto L_0x0151
        L_0x013e:
            int r1 = r8.f2569i
            if (r1 == r12) goto L_0x015a
            int r1 = r8.f2569i
            java.lang.Object r1 = r9.get(r1)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x015a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
        L_0x0151:
            int r5 = r8.topMargin
            int r6 = r8.f2581u
            r1 = r22
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r2, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (int) r5, (int) r6)
        L_0x015a:
            int r1 = r8.f2570j
            if (r1 == r12) goto L_0x016e
            int r1 = r8.f2570j
            java.lang.Object r1 = r9.get(r1)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x018a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            goto L_0x0181
        L_0x016e:
            int r1 = r8.f2571k
            if (r1 == r12) goto L_0x018a
            int r1 = r8.f2571k
            java.lang.Object r1 = r9.get(r1)
            r3 = r1
            androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3
            if (r3 == 0) goto L_0x018a
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
        L_0x0181:
            int r5 = r8.bottomMargin
            int r6 = r8.f2583w
            r1 = r22
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r2, (androidx.constraintlayout.solver.widgets.ConstraintWidget) r3, (androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4, (int) r5, (int) r6)
        L_0x018a:
            int r1 = r8.f2572l
            if (r1 == r12) goto L_0x01df
            android.util.SparseArray<android.view.View> r1 = r0.J
            int r2 = r8.f2572l
            java.lang.Object r1 = r1.get(r2)
            android.view.View r1 = (android.view.View) r1
            int r2 = r8.f2572l
            java.lang.Object r2 = r9.get(r2)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = (androidx.constraintlayout.solver.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x01df
            if (r1 == 0) goto L_0x01df
            android.view.ViewGroup$LayoutParams r3 = r1.getLayoutParams()
            boolean r3 = r3 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r3 == 0) goto L_0x01df
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r1 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r1
            r8.Y = r11
            r1.Y = r11
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r3)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r2 = r2.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r4)
            r3.a(r2, r10, r12, r11)
            r7.c((boolean) r11)
            androidx.constraintlayout.solver.widgets.ConstraintWidget r1 = r1.f2560an
            r1.c((boolean) r11)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r1)
            r1.l()
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r1)
            r1.l()
        L_0x01df:
            r1 = 0
            r14 = r17
            int r2 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r2 < 0) goto L_0x01e9
            r7.a((float) r14)
        L_0x01e9:
            float r2 = r8.A
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x01f4
            float r1 = r8.A
            r7.b((float) r1)
        L_0x01f4:
            if (r20 == 0) goto L_0x0205
            int r1 = r8.Q
            if (r1 != r12) goto L_0x01fe
            int r1 = r8.R
            if (r1 == r12) goto L_0x0205
        L_0x01fe:
            int r1 = r8.Q
            int r2 = r8.R
            r7.d(r1, r2)
        L_0x0205:
            boolean r1 = r8.W
            r2 = -2
            if (r1 != 0) goto L_0x0238
            int r1 = r8.width
            if (r1 != r12) goto L_0x022f
            boolean r1 = r8.T
            if (r1 == 0) goto L_0x0215
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            goto L_0x0217
        L_0x0215:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
        L_0x0217:
            r7.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r1)
            int r3 = r8.leftMargin
            r1.f2222d = r3
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r1)
            int r3 = r8.rightMargin
            r1.f2222d = r3
            goto L_0x024b
        L_0x022f:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r7.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            r7.o(r10)
            goto L_0x024b
        L_0x0238:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r7.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            int r1 = r8.width
            r7.o(r1)
            int r1 = r8.width
            if (r1 != r2) goto L_0x024b
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7.a((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
        L_0x024b:
            boolean r1 = r8.X
            if (r1 != 0) goto L_0x027d
            int r1 = r8.height
            if (r1 != r12) goto L_0x0274
            boolean r1 = r8.U
            if (r1 == 0) goto L_0x025a
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            goto L_0x025c
        L_0x025a:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT
        L_0x025c:
            r7.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r1)
            int r2 = r8.topMargin
            r1.f2222d = r2
            androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.solver.widgets.ConstraintAnchor r1 = r7.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor.Type) r1)
            int r2 = r8.bottomMargin
            r1.f2222d = r2
            goto L_0x0290
        L_0x0274:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r7.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            r7.p(r10)
            goto L_0x0290
        L_0x027d:
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            r7.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
            int r1 = r8.height
            r7.p(r1)
            int r1 = r8.height
            if (r1 != r2) goto L_0x0290
            androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r7.b((androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour) r1)
        L_0x0290:
            java.lang.String r1 = r8.B
            r7.b((java.lang.String) r1)
            float r1 = r8.E
            r7.c((float) r1)
            float r1 = r8.F
            r7.d((float) r1)
            int r1 = r8.G
            r7.t(r1)
            int r1 = r8.H
            r7.u(r1)
            int r1 = r8.I
            int r2 = r8.K
            int r3 = r8.M
            float r4 = r8.O
            r7.a((int) r1, (int) r2, (int) r3, (float) r4)
            int r1 = r8.J
            int r2 = r8.L
            int r3 = r8.N
            float r4 = r8.P
            r7.b(r1, r2, r3, r4)
        L_0x02bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a(boolean, android.view.View, androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        this.M = new a(getContext(), this, i2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public View d(int i2) {
        return this.J.get(i2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.f2530a;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f2530a.get(i2).a(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i4 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i5 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i4;
                        float f3 = (float) (i4 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f4 = (float) i5;
                        float f5 = f2;
                        float f6 = f2;
                        float f7 = f4;
                        Paint paint2 = paint;
                        float f8 = f3;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f5, f7, f8, f4, paint3);
                        float parseInt4 = (float) (i5 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f9 = f3;
                        float f10 = parseInt4;
                        canvas2.drawLine(f9, f7, f8, f10, paint3);
                        float f11 = parseInt4;
                        float f12 = f6;
                        canvas2.drawLine(f9, f11, f12, f10, paint3);
                        float f13 = f6;
                        canvas2.drawLine(f13, f11, f12, f4, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f14 = f3;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f13, f4, f14, parseInt4, paint6);
                        canvas2.drawLine(f13, parseInt4, f14, f4, paint6);
                    }
                }
            }
        }
    }

    public void forceLayout() {
        c();
        super.forceLayout();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getMaxHeight() {
        return this.f2534e;
    }

    public int getMaxWidth() {
        return this.f2533d;
    }

    public int getMinHeight() {
        return this.f2532c;
    }

    public int getMinWidth() {
        return this.f2531b;
    }

    public int getOptimizationLevel() {
        return this.K.h();
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f2560an;
            if ((childAt.getVisibility() != 8 || layoutParams.Z || layoutParams.f2547aa || layoutParams.f2549ac || isInEditMode) && !layoutParams.f2548ab) {
                int y2 = constraintWidget.y();
                int z3 = constraintWidget.z();
                int A = constraintWidget.A() + y2;
                int B = constraintWidget.B() + z3;
                childAt.layout(y2, z3, A, B);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(y2, z3, A, B);
                }
            }
        }
        int size = this.f2530a.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.f2530a.get(i7).b(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (!this.L) {
            int childCount = getChildCount();
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                } else if (getChildAt(i4).isLayoutRequested()) {
                    this.L = true;
                    break;
                } else {
                    i4++;
                }
            }
        }
        if (!this.L) {
            int i5 = this.f2543n;
            if (!(i5 == i2 && this.f2544o == i3)) {
                if (i5 == i2 && View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.f2544o) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i3) >= this.K.B()) {
                    this.f2543n = i2;
                    this.f2544o = i3;
                }
            }
            a(i2, i3, this.K.A(), this.K.B(), this.K.i(), this.K.X());
        }
        this.f2543n = i2;
        this.f2544o = i3;
        this.K.g(h());
        if (this.L) {
            this.L = false;
            if (a()) {
                this.K.f();
            }
        }
        a(this.K, this.f2535f, i2, i3);
        a(i2, i3, this.K.A(), this.K.B(), this.K.i(), this.K.X());
    }

    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget a2 = a(view);
        if ((view instanceof Guideline) && !(a2 instanceof f)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f2560an = new f();
            layoutParams.Z = true;
            ((f) layoutParams.f2560an).a(layoutParams.S);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.c();
            ((LayoutParams) view.getLayoutParams()).f2547aa = true;
            if (!this.f2530a.contains(constraintHelper)) {
                this.f2530a.add(constraintHelper);
            }
        }
        this.J.put(view.getId(), view);
        this.L = true;
    }

    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.J.remove(view.getId());
        this.K.c(a(view));
        this.f2530a.remove(view);
        this.L = true;
    }

    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    public void requestLayout() {
        c();
        super.requestLayout();
    }

    public void setConstraintSet(b bVar) {
        this.f2536g = bVar;
    }

    public void setId(int i2) {
        this.J.remove(getId());
        super.setId(i2);
        this.J.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.f2534e) {
            this.f2534e = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.f2533d) {
            this.f2533d = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.f2532c) {
            this.f2532c = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.f2531b) {
            this.f2531b = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(c cVar) {
        this.f2542m = cVar;
        a aVar = this.M;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.f2535f = i2;
        this.K.a(i2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
