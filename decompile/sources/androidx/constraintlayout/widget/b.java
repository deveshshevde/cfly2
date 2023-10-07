package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import fg.i;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f2632d = {0, 4, 8};

    /* renamed from: f  reason: collision with root package name */
    private static SparseIntArray f2633f;

    /* renamed from: a  reason: collision with root package name */
    private boolean f2634a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, ConstraintAttribute> f2635b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f2636c = true;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, a> f2637e = new HashMap<>();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2638a;

        /* renamed from: b  reason: collision with root package name */
        public final d f2639b = new d();

        /* renamed from: c  reason: collision with root package name */
        public final c f2640c = new c();

        /* renamed from: d  reason: collision with root package name */
        public final C0024b f2641d = new C0024b();

        /* renamed from: e  reason: collision with root package name */
        public final e f2642e = new e();

        /* renamed from: f  reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f2643f = new HashMap<>();

        /* access modifiers changed from: private */
        public void a(int i2, ConstraintLayout.LayoutParams layoutParams) {
            this.f2638a = i2;
            this.f2641d.f2662h = layoutParams.f2564d;
            this.f2641d.f2663i = layoutParams.f2565e;
            this.f2641d.f2664j = layoutParams.f2566f;
            this.f2641d.f2665k = layoutParams.f2567g;
            this.f2641d.f2666l = layoutParams.f2568h;
            this.f2641d.f2667m = layoutParams.f2569i;
            this.f2641d.f2668n = layoutParams.f2570j;
            this.f2641d.f2669o = layoutParams.f2571k;
            this.f2641d.f2670p = layoutParams.f2572l;
            this.f2641d.f2671q = layoutParams.f2576p;
            this.f2641d.f2672r = layoutParams.f2577q;
            this.f2641d.f2673s = layoutParams.f2578r;
            this.f2641d.f2674t = layoutParams.f2579s;
            this.f2641d.f2675u = layoutParams.f2586z;
            this.f2641d.f2676v = layoutParams.A;
            this.f2641d.f2677w = layoutParams.B;
            this.f2641d.f2678x = layoutParams.f2573m;
            this.f2641d.f2679y = layoutParams.f2574n;
            this.f2641d.f2680z = layoutParams.f2575o;
            this.f2641d.A = layoutParams.Q;
            this.f2641d.B = layoutParams.R;
            this.f2641d.C = layoutParams.S;
            this.f2641d.f2661g = layoutParams.f2563c;
            this.f2641d.f2659e = layoutParams.f2546a;
            this.f2641d.f2660f = layoutParams.f2562b;
            this.f2641d.f2657c = layoutParams.width;
            this.f2641d.f2658d = layoutParams.height;
            this.f2641d.D = layoutParams.leftMargin;
            this.f2641d.E = layoutParams.rightMargin;
            this.f2641d.F = layoutParams.topMargin;
            this.f2641d.G = layoutParams.bottomMargin;
            this.f2641d.P = layoutParams.F;
            this.f2641d.Q = layoutParams.E;
            this.f2641d.S = layoutParams.H;
            this.f2641d.R = layoutParams.G;
            this.f2641d.f2653ah = layoutParams.T;
            this.f2641d.f2654ai = layoutParams.U;
            this.f2641d.T = layoutParams.I;
            this.f2641d.U = layoutParams.J;
            this.f2641d.V = layoutParams.M;
            this.f2641d.W = layoutParams.N;
            this.f2641d.X = layoutParams.K;
            this.f2641d.Y = layoutParams.L;
            this.f2641d.Z = layoutParams.O;
            this.f2641d.f2646aa = layoutParams.P;
            this.f2641d.f2652ag = layoutParams.V;
            this.f2641d.K = layoutParams.f2581u;
            this.f2641d.M = layoutParams.f2583w;
            this.f2641d.J = layoutParams.f2580t;
            this.f2641d.L = layoutParams.f2582v;
            this.f2641d.O = layoutParams.f2584x;
            this.f2641d.N = layoutParams.f2585y;
            if (Build.VERSION.SDK_INT >= 17) {
                this.f2641d.H = layoutParams.getMarginEnd();
                this.f2641d.I = layoutParams.getMarginStart();
            }
        }

        /* access modifiers changed from: private */
        public void a(int i2, Constraints.LayoutParams layoutParams) {
            a(i2, (ConstraintLayout.LayoutParams) layoutParams);
            this.f2639b.f2692d = layoutParams.f2597ap;
            this.f2642e.f2696b = layoutParams.f2600as;
            this.f2642e.f2697c = layoutParams.f2601at;
            this.f2642e.f2698d = layoutParams.f2602au;
            this.f2642e.f2699e = layoutParams.f2603av;
            this.f2642e.f2700f = layoutParams.f2604aw;
            this.f2642e.f2701g = layoutParams.f2605ax;
            this.f2642e.f2702h = layoutParams.f2606ay;
            this.f2642e.f2703i = layoutParams.f2607az;
            this.f2642e.f2704j = layoutParams.aA;
            this.f2642e.f2705k = layoutParams.aB;
            this.f2642e.f2707m = layoutParams.f2599ar;
            this.f2642e.f2706l = layoutParams.f2598aq;
        }

        /* access modifiers changed from: private */
        public void a(ConstraintHelper constraintHelper, int i2, Constraints.LayoutParams layoutParams) {
            a(i2, layoutParams);
            if (constraintHelper instanceof Barrier) {
                this.f2641d.f2649ad = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.f2641d.f2647ab = barrier.getType();
                this.f2641d.f2650ae = barrier.getReferencedIds();
                this.f2641d.f2648ac = barrier.getMargin();
            }
        }

        /* renamed from: a */
        public a clone() {
            a aVar = new a();
            aVar.f2641d.a(this.f2641d);
            aVar.f2640c.a(this.f2640c);
            aVar.f2639b.a(this.f2639b);
            aVar.f2642e.a(this.f2642e);
            aVar.f2638a = this.f2638a;
            return aVar;
        }

        public void a(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.f2564d = this.f2641d.f2662h;
            layoutParams.f2565e = this.f2641d.f2663i;
            layoutParams.f2566f = this.f2641d.f2664j;
            layoutParams.f2567g = this.f2641d.f2665k;
            layoutParams.f2568h = this.f2641d.f2666l;
            layoutParams.f2569i = this.f2641d.f2667m;
            layoutParams.f2570j = this.f2641d.f2668n;
            layoutParams.f2571k = this.f2641d.f2669o;
            layoutParams.f2572l = this.f2641d.f2670p;
            layoutParams.f2576p = this.f2641d.f2671q;
            layoutParams.f2577q = this.f2641d.f2672r;
            layoutParams.f2578r = this.f2641d.f2673s;
            layoutParams.f2579s = this.f2641d.f2674t;
            layoutParams.leftMargin = this.f2641d.D;
            layoutParams.rightMargin = this.f2641d.E;
            layoutParams.topMargin = this.f2641d.F;
            layoutParams.bottomMargin = this.f2641d.G;
            layoutParams.f2584x = this.f2641d.O;
            layoutParams.f2585y = this.f2641d.N;
            layoutParams.f2581u = this.f2641d.K;
            layoutParams.f2583w = this.f2641d.M;
            layoutParams.f2586z = this.f2641d.f2675u;
            layoutParams.A = this.f2641d.f2676v;
            layoutParams.f2573m = this.f2641d.f2678x;
            layoutParams.f2574n = this.f2641d.f2679y;
            layoutParams.f2575o = this.f2641d.f2680z;
            layoutParams.B = this.f2641d.f2677w;
            layoutParams.Q = this.f2641d.A;
            layoutParams.R = this.f2641d.B;
            layoutParams.F = this.f2641d.P;
            layoutParams.E = this.f2641d.Q;
            layoutParams.H = this.f2641d.S;
            layoutParams.G = this.f2641d.R;
            layoutParams.T = this.f2641d.f2653ah;
            layoutParams.U = this.f2641d.f2654ai;
            layoutParams.I = this.f2641d.T;
            layoutParams.J = this.f2641d.U;
            layoutParams.M = this.f2641d.V;
            layoutParams.N = this.f2641d.W;
            layoutParams.K = this.f2641d.X;
            layoutParams.L = this.f2641d.Y;
            layoutParams.O = this.f2641d.Z;
            layoutParams.P = this.f2641d.f2646aa;
            layoutParams.S = this.f2641d.C;
            layoutParams.f2563c = this.f2641d.f2661g;
            layoutParams.f2546a = this.f2641d.f2659e;
            layoutParams.f2562b = this.f2641d.f2660f;
            layoutParams.width = this.f2641d.f2657c;
            layoutParams.height = this.f2641d.f2658d;
            if (this.f2641d.f2652ag != null) {
                layoutParams.V = this.f2641d.f2652ag;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.f2641d.I);
                layoutParams.setMarginEnd(this.f2641d.H);
            }
            layoutParams.b();
        }
    }

    /* renamed from: androidx.constraintlayout.widget.b$b  reason: collision with other inner class name */
    public static class C0024b {

        /* renamed from: ak  reason: collision with root package name */
        private static SparseIntArray f2644ak;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2645a = false;

        /* renamed from: aa  reason: collision with root package name */
        public float f2646aa = 1.0f;

        /* renamed from: ab  reason: collision with root package name */
        public int f2647ab = -1;

        /* renamed from: ac  reason: collision with root package name */
        public int f2648ac = 0;

        /* renamed from: ad  reason: collision with root package name */
        public int f2649ad = -1;

        /* renamed from: ae  reason: collision with root package name */
        public int[] f2650ae;

        /* renamed from: af  reason: collision with root package name */
        public String f2651af;

        /* renamed from: ag  reason: collision with root package name */
        public String f2652ag;

        /* renamed from: ah  reason: collision with root package name */
        public boolean f2653ah = false;

        /* renamed from: ai  reason: collision with root package name */
        public boolean f2654ai = false;

        /* renamed from: aj  reason: collision with root package name */
        public boolean f2655aj = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2656b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2657c;

        /* renamed from: d  reason: collision with root package name */
        public int f2658d;

        /* renamed from: e  reason: collision with root package name */
        public int f2659e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f2660f = -1;

        /* renamed from: g  reason: collision with root package name */
        public float f2661g = -1.0f;

        /* renamed from: h  reason: collision with root package name */
        public int f2662h = -1;

        /* renamed from: i  reason: collision with root package name */
        public int f2663i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f2664j = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f2665k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f2666l = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f2667m = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f2668n = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f2669o = -1;

        /* renamed from: p  reason: collision with root package name */
        public int f2670p = -1;

        /* renamed from: q  reason: collision with root package name */
        public int f2671q = -1;

        /* renamed from: r  reason: collision with root package name */
        public int f2672r = -1;

        /* renamed from: s  reason: collision with root package name */
        public int f2673s = -1;

        /* renamed from: t  reason: collision with root package name */
        public int f2674t = -1;

        /* renamed from: u  reason: collision with root package name */
        public float f2675u = 0.5f;

        /* renamed from: v  reason: collision with root package name */
        public float f2676v = 0.5f;

        /* renamed from: w  reason: collision with root package name */
        public String f2677w = null;

        /* renamed from: x  reason: collision with root package name */
        public int f2678x = -1;

        /* renamed from: y  reason: collision with root package name */
        public int f2679y = 0;

        /* renamed from: z  reason: collision with root package name */
        public float f2680z = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2644ak = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f2644ak.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f2644ak.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f2644ak.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            f2644ak.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            f2644ak.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f2644ak.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f2644ak.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f2644ak.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f2644ak.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            f2644ak.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            f2644ak.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            f2644ak.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            f2644ak.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            f2644ak.append(R.styleable.Layout_android_orientation, 26);
            f2644ak.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            f2644ak.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            f2644ak.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f2644ak.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f2644ak.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            f2644ak.append(R.styleable.Layout_layout_goneMarginTop, 16);
            f2644ak.append(R.styleable.Layout_layout_goneMarginRight, 14);
            f2644ak.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            f2644ak.append(R.styleable.Layout_layout_goneMarginStart, 15);
            f2644ak.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            f2644ak.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            f2644ak.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            f2644ak.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f2644ak.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f2644ak.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            f2644ak.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            f2644ak.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            f2644ak.append(R.styleable.Layout_layout_constraintLeft_creator, 76);
            f2644ak.append(R.styleable.Layout_layout_constraintTop_creator, 76);
            f2644ak.append(R.styleable.Layout_layout_constraintRight_creator, 76);
            f2644ak.append(R.styleable.Layout_layout_constraintBottom_creator, 76);
            f2644ak.append(R.styleable.Layout_layout_constraintBaseline_creator, 76);
            f2644ak.append(R.styleable.Layout_android_layout_marginLeft, 23);
            f2644ak.append(R.styleable.Layout_android_layout_marginRight, 27);
            f2644ak.append(R.styleable.Layout_android_layout_marginStart, 30);
            f2644ak.append(R.styleable.Layout_android_layout_marginEnd, 8);
            f2644ak.append(R.styleable.Layout_android_layout_marginTop, 33);
            f2644ak.append(R.styleable.Layout_android_layout_marginBottom, 2);
            f2644ak.append(R.styleable.Layout_android_layout_width, 22);
            f2644ak.append(R.styleable.Layout_android_layout_height, 21);
            f2644ak.append(R.styleable.Layout_layout_constraintCircle, 61);
            f2644ak.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            f2644ak.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            f2644ak.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            f2644ak.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            f2644ak.append(R.styleable.Layout_chainUseRtl, 71);
            f2644ak.append(R.styleable.Layout_barrierDirection, 72);
            f2644ak.append(R.styleable.Layout_barrierMargin, 73);
            f2644ak.append(R.styleable.Layout_constraint_referenced_ids, 74);
            f2644ak.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            StringBuilder sb;
            String str;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Layout);
            this.f2656b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = f2644ak.get(index);
                if (i3 == 80) {
                    this.f2653ah = obtainStyledAttributes.getBoolean(index, this.f2653ah);
                } else if (i3 != 81) {
                    switch (i3) {
                        case 1:
                            this.f2670p = b.b(obtainStyledAttributes, index, this.f2670p);
                            break;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        case 3:
                            this.f2669o = b.b(obtainStyledAttributes, index, this.f2669o);
                            break;
                        case 4:
                            this.f2668n = b.b(obtainStyledAttributes, index, this.f2668n);
                            break;
                        case 5:
                            this.f2677w = obtainStyledAttributes.getString(index);
                            break;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            break;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            break;
                        case 8:
                            if (Build.VERSION.SDK_INT < 17) {
                                break;
                            } else {
                                this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                                break;
                            }
                        case 9:
                            this.f2674t = b.b(obtainStyledAttributes, index, this.f2674t);
                            break;
                        case 10:
                            this.f2673s = b.b(obtainStyledAttributes, index, this.f2673s);
                            break;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        case 17:
                            this.f2659e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2659e);
                            break;
                        case 18:
                            this.f2660f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2660f);
                            break;
                        case 19:
                            this.f2661g = obtainStyledAttributes.getFloat(index, this.f2661g);
                            break;
                        case 20:
                            this.f2675u = obtainStyledAttributes.getFloat(index, this.f2675u);
                            break;
                        case 21:
                            this.f2658d = obtainStyledAttributes.getLayoutDimension(index, this.f2658d);
                            break;
                        case 22:
                            this.f2657c = obtainStyledAttributes.getLayoutDimension(index, this.f2657c);
                            break;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            break;
                        case 24:
                            this.f2662h = b.b(obtainStyledAttributes, index, this.f2662h);
                            break;
                        case 25:
                            this.f2663i = b.b(obtainStyledAttributes, index, this.f2663i);
                            break;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            break;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            break;
                        case 28:
                            this.f2664j = b.b(obtainStyledAttributes, index, this.f2664j);
                            break;
                        case 29:
                            this.f2665k = b.b(obtainStyledAttributes, index, this.f2665k);
                            break;
                        case 30:
                            if (Build.VERSION.SDK_INT < 17) {
                                break;
                            } else {
                                this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                                break;
                            }
                        case 31:
                            this.f2671q = b.b(obtainStyledAttributes, index, this.f2671q);
                            break;
                        case 32:
                            this.f2672r = b.b(obtainStyledAttributes, index, this.f2672r);
                            break;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            break;
                        case 34:
                            this.f2667m = b.b(obtainStyledAttributes, index, this.f2667m);
                            break;
                        case 35:
                            this.f2666l = b.b(obtainStyledAttributes, index, this.f2666l);
                            break;
                        case 36:
                            this.f2676v = obtainStyledAttributes.getFloat(index, this.f2676v);
                            break;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            break;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            break;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            break;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            break;
                        default:
                            switch (i3) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    break;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    break;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    break;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    break;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    break;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    break;
                                default:
                                    switch (i3) {
                                        case 61:
                                            this.f2678x = b.b(obtainStyledAttributes, index, this.f2678x);
                                            break;
                                        case 62:
                                            this.f2679y = obtainStyledAttributes.getDimensionPixelSize(index, this.f2679y);
                                            break;
                                        case 63:
                                            this.f2680z = obtainStyledAttributes.getFloat(index, this.f2680z);
                                            break;
                                        default:
                                            switch (i3) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.f2646aa = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.f2647ab = obtainStyledAttributes.getInt(index, this.f2647ab);
                                                    continue;
                                                case 73:
                                                    this.f2648ac = obtainStyledAttributes.getDimensionPixelSize(index, this.f2648ac);
                                                    continue;
                                                case 74:
                                                    this.f2651af = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.f2655aj = obtainStyledAttributes.getBoolean(index, this.f2655aj);
                                                    continue;
                                                case 76:
                                                    sb = new StringBuilder();
                                                    str = "unused attribute 0x";
                                                    break;
                                                case 77:
                                                    this.f2652ag = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    sb = new StringBuilder();
                                                    str = "Unknown attribute 0x";
                                                    break;
                                            }
                                            sb.append(str);
                                            sb.append(Integer.toHexString(index));
                                            sb.append("   ");
                                            sb.append(f2644ak.get(index));
                                            Log.w("ConstraintSet", sb.toString());
                                            break;
                                    }
                            }
                    }
                } else {
                    this.f2654ai = obtainStyledAttributes.getBoolean(index, this.f2654ai);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(C0024b bVar) {
            this.f2645a = bVar.f2645a;
            this.f2657c = bVar.f2657c;
            this.f2656b = bVar.f2656b;
            this.f2658d = bVar.f2658d;
            this.f2659e = bVar.f2659e;
            this.f2660f = bVar.f2660f;
            this.f2661g = bVar.f2661g;
            this.f2662h = bVar.f2662h;
            this.f2663i = bVar.f2663i;
            this.f2664j = bVar.f2664j;
            this.f2665k = bVar.f2665k;
            this.f2666l = bVar.f2666l;
            this.f2667m = bVar.f2667m;
            this.f2668n = bVar.f2668n;
            this.f2669o = bVar.f2669o;
            this.f2670p = bVar.f2670p;
            this.f2671q = bVar.f2671q;
            this.f2672r = bVar.f2672r;
            this.f2673s = bVar.f2673s;
            this.f2674t = bVar.f2674t;
            this.f2675u = bVar.f2675u;
            this.f2676v = bVar.f2676v;
            this.f2677w = bVar.f2677w;
            this.f2678x = bVar.f2678x;
            this.f2679y = bVar.f2679y;
            this.f2680z = bVar.f2680z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            this.H = bVar.H;
            this.I = bVar.I;
            this.J = bVar.J;
            this.K = bVar.K;
            this.L = bVar.L;
            this.M = bVar.M;
            this.N = bVar.N;
            this.O = bVar.O;
            this.P = bVar.P;
            this.Q = bVar.Q;
            this.R = bVar.R;
            this.S = bVar.S;
            this.T = bVar.T;
            this.U = bVar.U;
            this.V = bVar.V;
            this.W = bVar.W;
            this.X = bVar.X;
            this.Y = bVar.Y;
            this.Z = bVar.Z;
            this.f2646aa = bVar.f2646aa;
            this.f2647ab = bVar.f2647ab;
            this.f2648ac = bVar.f2648ac;
            this.f2649ad = bVar.f2649ad;
            this.f2652ag = bVar.f2652ag;
            int[] iArr = bVar.f2650ae;
            if (iArr != null) {
                this.f2650ae = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.f2650ae = null;
            }
            this.f2651af = bVar.f2651af;
            this.f2653ah = bVar.f2653ah;
            this.f2654ai = bVar.f2654ai;
            this.f2655aj = bVar.f2655aj;
        }
    }

    public static class c {

        /* renamed from: h  reason: collision with root package name */
        private static SparseIntArray f2681h;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2682a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2683b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f2684c = null;

        /* renamed from: d  reason: collision with root package name */
        public int f2685d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f2686e = 0;

        /* renamed from: f  reason: collision with root package name */
        public float f2687f = Float.NaN;

        /* renamed from: g  reason: collision with root package name */
        public float f2688g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2681h = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            f2681h.append(R.styleable.Motion_pathMotionArc, 2);
            f2681h.append(R.styleable.Motion_transitionEasing, 3);
            f2681h.append(R.styleable.Motion_drawPath, 4);
            f2681h.append(R.styleable.Motion_animate_relativeTo, 5);
            f2681h.append(R.styleable.Motion_motionStagger, 6);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
            this.f2682a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f2681h.get(index)) {
                    case 1:
                        this.f2688g = obtainStyledAttributes.getFloat(index, this.f2688g);
                        break;
                    case 2:
                        this.f2685d = obtainStyledAttributes.getInt(index, this.f2685d);
                        break;
                    case 3:
                        this.f2684c = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : k.c.f29910c[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.f2686e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f2683b = b.b(obtainStyledAttributes, index, this.f2683b);
                        break;
                    case 6:
                        this.f2687f = obtainStyledAttributes.getFloat(index, this.f2687f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(c cVar) {
            this.f2682a = cVar.f2682a;
            this.f2683b = cVar.f2683b;
            this.f2684c = cVar.f2684c;
            this.f2685d = cVar.f2685d;
            this.f2686e = cVar.f2686e;
            this.f2688g = cVar.f2688g;
            this.f2687f = cVar.f2687f;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2689a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f2690b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f2691c = 0;

        /* renamed from: d  reason: collision with root package name */
        public float f2692d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f2693e = Float.NaN;

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
            this.f2689a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.f2692d = obtainStyledAttributes.getFloat(index, this.f2692d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.f2690b = obtainStyledAttributes.getInt(index, this.f2690b);
                    this.f2690b = b.f2632d[this.f2690b];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.f2691c = obtainStyledAttributes.getInt(index, this.f2691c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.f2693e = obtainStyledAttributes.getFloat(index, this.f2693e);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(d dVar) {
            this.f2689a = dVar.f2689a;
            this.f2690b = dVar.f2690b;
            this.f2692d = dVar.f2692d;
            this.f2693e = dVar.f2693e;
            this.f2691c = dVar.f2691c;
        }
    }

    public static class e {

        /* renamed from: n  reason: collision with root package name */
        private static SparseIntArray f2694n;

        /* renamed from: a  reason: collision with root package name */
        public boolean f2695a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f2696b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f2697c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        public float f2698d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public float f2699e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f2700f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        public float f2701g = Float.NaN;

        /* renamed from: h  reason: collision with root package name */
        public float f2702h = Float.NaN;

        /* renamed from: i  reason: collision with root package name */
        public float f2703i = 0.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f2704j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f2705k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        public boolean f2706l = false;

        /* renamed from: m  reason: collision with root package name */
        public float f2707m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2694n = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            f2694n.append(R.styleable.Transform_android_rotationX, 2);
            f2694n.append(R.styleable.Transform_android_rotationY, 3);
            f2694n.append(R.styleable.Transform_android_scaleX, 4);
            f2694n.append(R.styleable.Transform_android_scaleY, 5);
            f2694n.append(R.styleable.Transform_android_transformPivotX, 6);
            f2694n.append(R.styleable.Transform_android_transformPivotY, 7);
            f2694n.append(R.styleable.Transform_android_translationX, 8);
            f2694n.append(R.styleable.Transform_android_translationY, 9);
            f2694n.append(R.styleable.Transform_android_translationZ, 10);
            f2694n.append(R.styleable.Transform_android_elevation, 11);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transform);
            this.f2695a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                switch (f2694n.get(index)) {
                    case 1:
                        this.f2696b = obtainStyledAttributes.getFloat(index, this.f2696b);
                        break;
                    case 2:
                        this.f2697c = obtainStyledAttributes.getFloat(index, this.f2697c);
                        break;
                    case 3:
                        this.f2698d = obtainStyledAttributes.getFloat(index, this.f2698d);
                        break;
                    case 4:
                        this.f2699e = obtainStyledAttributes.getFloat(index, this.f2699e);
                        break;
                    case 5:
                        this.f2700f = obtainStyledAttributes.getFloat(index, this.f2700f);
                        break;
                    case 6:
                        this.f2701g = obtainStyledAttributes.getDimension(index, this.f2701g);
                        break;
                    case 7:
                        this.f2702h = obtainStyledAttributes.getDimension(index, this.f2702h);
                        break;
                    case 8:
                        this.f2703i = obtainStyledAttributes.getDimension(index, this.f2703i);
                        break;
                    case 9:
                        this.f2704j = obtainStyledAttributes.getDimension(index, this.f2704j);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.f2705k = obtainStyledAttributes.getDimension(index, this.f2705k);
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            this.f2706l = true;
                            this.f2707m = obtainStyledAttributes.getDimension(index, this.f2707m);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(e eVar) {
            this.f2695a = eVar.f2695a;
            this.f2696b = eVar.f2696b;
            this.f2697c = eVar.f2697c;
            this.f2698d = eVar.f2698d;
            this.f2699e = eVar.f2699e;
            this.f2700f = eVar.f2700f;
            this.f2701g = eVar.f2701g;
            this.f2702h = eVar.f2702h;
            this.f2703i = eVar.f2703i;
            this.f2704j = eVar.f2704j;
            this.f2705k = eVar.f2705k;
            this.f2706l = eVar.f2706l;
            this.f2707m = eVar.f2707m;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2633f = sparseIntArray;
        sparseIntArray.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        f2633f.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        f2633f.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        f2633f.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        f2633f.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        f2633f.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        f2633f.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        f2633f.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        f2633f.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        f2633f.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        f2633f.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        f2633f.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        f2633f.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        f2633f.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        f2633f.append(R.styleable.Constraint_android_orientation, 27);
        f2633f.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        f2633f.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        f2633f.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        f2633f.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        f2633f.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        f2633f.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        f2633f.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        f2633f.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        f2633f.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        f2633f.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        f2633f.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        f2633f.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        f2633f.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        f2633f.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        f2633f.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        f2633f.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        f2633f.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        f2633f.append(R.styleable.Constraint_layout_constraintLeft_creator, 82);
        f2633f.append(R.styleable.Constraint_layout_constraintTop_creator, 82);
        f2633f.append(R.styleable.Constraint_layout_constraintRight_creator, 82);
        f2633f.append(R.styleable.Constraint_layout_constraintBottom_creator, 82);
        f2633f.append(R.styleable.Constraint_layout_constraintBaseline_creator, 82);
        f2633f.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        f2633f.append(R.styleable.Constraint_android_layout_marginRight, 28);
        f2633f.append(R.styleable.Constraint_android_layout_marginStart, 31);
        f2633f.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        f2633f.append(R.styleable.Constraint_android_layout_marginTop, 34);
        f2633f.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        f2633f.append(R.styleable.Constraint_android_layout_width, 23);
        f2633f.append(R.styleable.Constraint_android_layout_height, 21);
        f2633f.append(R.styleable.Constraint_android_visibility, 22);
        f2633f.append(R.styleable.Constraint_android_alpha, 43);
        f2633f.append(R.styleable.Constraint_android_elevation, 44);
        f2633f.append(R.styleable.Constraint_android_rotationX, 45);
        f2633f.append(R.styleable.Constraint_android_rotationY, 46);
        f2633f.append(R.styleable.Constraint_android_rotation, 60);
        f2633f.append(R.styleable.Constraint_android_scaleX, 47);
        f2633f.append(R.styleable.Constraint_android_scaleY, 48);
        f2633f.append(R.styleable.Constraint_android_transformPivotX, 49);
        f2633f.append(R.styleable.Constraint_android_transformPivotY, 50);
        f2633f.append(R.styleable.Constraint_android_translationX, 51);
        f2633f.append(R.styleable.Constraint_android_translationY, 52);
        f2633f.append(R.styleable.Constraint_android_translationZ, 53);
        f2633f.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        f2633f.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        f2633f.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        f2633f.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        f2633f.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        f2633f.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        f2633f.append(R.styleable.Constraint_layout_constraintCircle, 61);
        f2633f.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        f2633f.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        f2633f.append(R.styleable.Constraint_animate_relativeTo, 64);
        f2633f.append(R.styleable.Constraint_transitionEasing, 65);
        f2633f.append(R.styleable.Constraint_drawPath, 66);
        f2633f.append(R.styleable.Constraint_transitionPathRotate, 67);
        f2633f.append(R.styleable.Constraint_motionStagger, 79);
        f2633f.append(R.styleable.Constraint_android_id, 38);
        f2633f.append(R.styleable.Constraint_motionProgress, 68);
        f2633f.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        f2633f.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        f2633f.append(R.styleable.Constraint_chainUseRtl, 71);
        f2633f.append(R.styleable.Constraint_barrierDirection, 72);
        f2633f.append(R.styleable.Constraint_barrierMargin, 73);
        f2633f.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        f2633f.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        f2633f.append(R.styleable.Constraint_pathMotionArc, 76);
        f2633f.append(R.styleable.Constraint_layout_constraintTag, 77);
        f2633f.append(R.styleable.Constraint_visibilityMode, 78);
        f2633f.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        f2633f.append(R.styleable.Constraint_layout_constrainedHeight, 81);
    }

    private a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Constraint);
        a(context, aVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return aVar;
    }

    private void a(Context context, a aVar, TypedArray typedArray) {
        c cVar;
        String str;
        String str2;
        StringBuilder sb;
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (!(index == R.styleable.Constraint_android_id || R.styleable.Constraint_android_layout_marginStart == index || R.styleable.Constraint_android_layout_marginEnd == index)) {
                aVar.f2640c.f2682a = true;
                aVar.f2641d.f2656b = true;
                aVar.f2639b.f2689a = true;
                aVar.f2642e.f2695a = true;
            }
            switch (f2633f.get(index)) {
                case 1:
                    aVar.f2641d.f2670p = b(typedArray, index, aVar.f2641d.f2670p);
                    continue;
                case 2:
                    aVar.f2641d.G = typedArray.getDimensionPixelSize(index, aVar.f2641d.G);
                    continue;
                case 3:
                    aVar.f2641d.f2669o = b(typedArray, index, aVar.f2641d.f2669o);
                    continue;
                case 4:
                    aVar.f2641d.f2668n = b(typedArray, index, aVar.f2641d.f2668n);
                    continue;
                case 5:
                    aVar.f2641d.f2677w = typedArray.getString(index);
                    continue;
                case 6:
                    aVar.f2641d.A = typedArray.getDimensionPixelOffset(index, aVar.f2641d.A);
                    continue;
                case 7:
                    aVar.f2641d.B = typedArray.getDimensionPixelOffset(index, aVar.f2641d.B);
                    continue;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        aVar.f2641d.H = typedArray.getDimensionPixelSize(index, aVar.f2641d.H);
                        break;
                    } else {
                        continue;
                    }
                case 9:
                    aVar.f2641d.f2674t = b(typedArray, index, aVar.f2641d.f2674t);
                    continue;
                case 10:
                    aVar.f2641d.f2673s = b(typedArray, index, aVar.f2641d.f2673s);
                    continue;
                case 11:
                    aVar.f2641d.M = typedArray.getDimensionPixelSize(index, aVar.f2641d.M);
                    continue;
                case 12:
                    aVar.f2641d.N = typedArray.getDimensionPixelSize(index, aVar.f2641d.N);
                    continue;
                case 13:
                    aVar.f2641d.J = typedArray.getDimensionPixelSize(index, aVar.f2641d.J);
                    continue;
                case 14:
                    aVar.f2641d.L = typedArray.getDimensionPixelSize(index, aVar.f2641d.L);
                    continue;
                case 15:
                    aVar.f2641d.O = typedArray.getDimensionPixelSize(index, aVar.f2641d.O);
                    continue;
                case 16:
                    aVar.f2641d.K = typedArray.getDimensionPixelSize(index, aVar.f2641d.K);
                    continue;
                case 17:
                    aVar.f2641d.f2659e = typedArray.getDimensionPixelOffset(index, aVar.f2641d.f2659e);
                    continue;
                case 18:
                    aVar.f2641d.f2660f = typedArray.getDimensionPixelOffset(index, aVar.f2641d.f2660f);
                    continue;
                case 19:
                    aVar.f2641d.f2661g = typedArray.getFloat(index, aVar.f2641d.f2661g);
                    continue;
                case 20:
                    aVar.f2641d.f2675u = typedArray.getFloat(index, aVar.f2641d.f2675u);
                    continue;
                case 21:
                    aVar.f2641d.f2658d = typedArray.getLayoutDimension(index, aVar.f2641d.f2658d);
                    continue;
                case 22:
                    aVar.f2639b.f2690b = typedArray.getInt(index, aVar.f2639b.f2690b);
                    aVar.f2639b.f2690b = f2632d[aVar.f2639b.f2690b];
                    continue;
                case 23:
                    aVar.f2641d.f2657c = typedArray.getLayoutDimension(index, aVar.f2641d.f2657c);
                    continue;
                case 24:
                    aVar.f2641d.D = typedArray.getDimensionPixelSize(index, aVar.f2641d.D);
                    continue;
                case 25:
                    aVar.f2641d.f2662h = b(typedArray, index, aVar.f2641d.f2662h);
                    continue;
                case 26:
                    aVar.f2641d.f2663i = b(typedArray, index, aVar.f2641d.f2663i);
                    continue;
                case 27:
                    aVar.f2641d.C = typedArray.getInt(index, aVar.f2641d.C);
                    continue;
                case 28:
                    aVar.f2641d.E = typedArray.getDimensionPixelSize(index, aVar.f2641d.E);
                    continue;
                case 29:
                    aVar.f2641d.f2664j = b(typedArray, index, aVar.f2641d.f2664j);
                    continue;
                case 30:
                    aVar.f2641d.f2665k = b(typedArray, index, aVar.f2641d.f2665k);
                    continue;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        aVar.f2641d.I = typedArray.getDimensionPixelSize(index, aVar.f2641d.I);
                        break;
                    } else {
                        continue;
                    }
                case 32:
                    aVar.f2641d.f2671q = b(typedArray, index, aVar.f2641d.f2671q);
                    continue;
                case 33:
                    aVar.f2641d.f2672r = b(typedArray, index, aVar.f2641d.f2672r);
                    continue;
                case 34:
                    aVar.f2641d.F = typedArray.getDimensionPixelSize(index, aVar.f2641d.F);
                    continue;
                case 35:
                    aVar.f2641d.f2667m = b(typedArray, index, aVar.f2641d.f2667m);
                    continue;
                case 36:
                    aVar.f2641d.f2666l = b(typedArray, index, aVar.f2641d.f2666l);
                    continue;
                case 37:
                    aVar.f2641d.f2676v = typedArray.getFloat(index, aVar.f2641d.f2676v);
                    continue;
                case 38:
                    aVar.f2638a = typedArray.getResourceId(index, aVar.f2638a);
                    continue;
                case 39:
                    aVar.f2641d.Q = typedArray.getFloat(index, aVar.f2641d.Q);
                    continue;
                case 40:
                    aVar.f2641d.P = typedArray.getFloat(index, aVar.f2641d.P);
                    continue;
                case 41:
                    aVar.f2641d.R = typedArray.getInt(index, aVar.f2641d.R);
                    continue;
                case 42:
                    aVar.f2641d.S = typedArray.getInt(index, aVar.f2641d.S);
                    continue;
                case 43:
                    aVar.f2639b.f2692d = typedArray.getFloat(index, aVar.f2639b.f2692d);
                    continue;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar.f2642e.f2706l = true;
                        aVar.f2642e.f2707m = typedArray.getDimension(index, aVar.f2642e.f2707m);
                        break;
                    } else {
                        continue;
                    }
                case 45:
                    aVar.f2642e.f2697c = typedArray.getFloat(index, aVar.f2642e.f2697c);
                    continue;
                case 46:
                    aVar.f2642e.f2698d = typedArray.getFloat(index, aVar.f2642e.f2698d);
                    continue;
                case 47:
                    aVar.f2642e.f2699e = typedArray.getFloat(index, aVar.f2642e.f2699e);
                    continue;
                case 48:
                    aVar.f2642e.f2700f = typedArray.getFloat(index, aVar.f2642e.f2700f);
                    continue;
                case 49:
                    aVar.f2642e.f2701g = typedArray.getDimension(index, aVar.f2642e.f2701g);
                    continue;
                case 50:
                    aVar.f2642e.f2702h = typedArray.getDimension(index, aVar.f2642e.f2702h);
                    continue;
                case 51:
                    aVar.f2642e.f2703i = typedArray.getDimension(index, aVar.f2642e.f2703i);
                    continue;
                case 52:
                    aVar.f2642e.f2704j = typedArray.getDimension(index, aVar.f2642e.f2704j);
                    continue;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar.f2642e.f2705k = typedArray.getDimension(index, aVar.f2642e.f2705k);
                        break;
                    } else {
                        continue;
                    }
                case 54:
                    aVar.f2641d.T = typedArray.getInt(index, aVar.f2641d.T);
                    continue;
                case 55:
                    aVar.f2641d.U = typedArray.getInt(index, aVar.f2641d.U);
                    continue;
                case 56:
                    aVar.f2641d.V = typedArray.getDimensionPixelSize(index, aVar.f2641d.V);
                    continue;
                case 57:
                    aVar.f2641d.W = typedArray.getDimensionPixelSize(index, aVar.f2641d.W);
                    continue;
                case 58:
                    aVar.f2641d.X = typedArray.getDimensionPixelSize(index, aVar.f2641d.X);
                    continue;
                case 59:
                    aVar.f2641d.Y = typedArray.getDimensionPixelSize(index, aVar.f2641d.Y);
                    continue;
                case 60:
                    aVar.f2642e.f2696b = typedArray.getFloat(index, aVar.f2642e.f2696b);
                    continue;
                case 61:
                    aVar.f2641d.f2678x = b(typedArray, index, aVar.f2641d.f2678x);
                    continue;
                case 62:
                    aVar.f2641d.f2679y = typedArray.getDimensionPixelSize(index, aVar.f2641d.f2679y);
                    continue;
                case 63:
                    aVar.f2641d.f2680z = typedArray.getFloat(index, aVar.f2641d.f2680z);
                    continue;
                case 64:
                    aVar.f2640c.f2683b = b(typedArray, index, aVar.f2640c.f2683b);
                    continue;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        cVar = aVar.f2640c;
                        str = typedArray.getString(index);
                    } else {
                        cVar = aVar.f2640c;
                        str = k.c.f29910c[typedArray.getInteger(index, 0)];
                    }
                    cVar.f2684c = str;
                    continue;
                case 66:
                    aVar.f2640c.f2686e = typedArray.getInt(index, 0);
                    continue;
                case 67:
                    aVar.f2640c.f2688g = typedArray.getFloat(index, aVar.f2640c.f2688g);
                    continue;
                case 68:
                    aVar.f2639b.f2693e = typedArray.getFloat(index, aVar.f2639b.f2693e);
                    continue;
                case 69:
                    aVar.f2641d.Z = typedArray.getFloat(index, 1.0f);
                    continue;
                case 70:
                    aVar.f2641d.f2646aa = typedArray.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    aVar.f2641d.f2647ab = typedArray.getInt(index, aVar.f2641d.f2647ab);
                    continue;
                case 73:
                    aVar.f2641d.f2648ac = typedArray.getDimensionPixelSize(index, aVar.f2641d.f2648ac);
                    continue;
                case 74:
                    aVar.f2641d.f2651af = typedArray.getString(index);
                    continue;
                case 75:
                    aVar.f2641d.f2655aj = typedArray.getBoolean(index, aVar.f2641d.f2655aj);
                    continue;
                case 76:
                    aVar.f2640c.f2685d = typedArray.getInt(index, aVar.f2640c.f2685d);
                    continue;
                case 77:
                    aVar.f2641d.f2652ag = typedArray.getString(index);
                    continue;
                case 78:
                    aVar.f2639b.f2691c = typedArray.getInt(index, aVar.f2639b.f2691c);
                    continue;
                case 79:
                    aVar.f2640c.f2687f = typedArray.getFloat(index, aVar.f2640c.f2687f);
                    continue;
                case 80:
                    aVar.f2641d.f2653ah = typedArray.getBoolean(index, aVar.f2641d.f2653ah);
                    continue;
                case 81:
                    aVar.f2641d.f2654ai = typedArray.getBoolean(index, aVar.f2641d.f2654ai);
                    continue;
                case 82:
                    sb = new StringBuilder();
                    str2 = "unused attribute 0x";
                    break;
                default:
                    sb = new StringBuilder();
                    str2 = "Unknown attribute 0x";
                    break;
            }
            sb.append(str2);
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(f2633f.get(index));
            Log.w("ConstraintSet", sb.toString());
        }
    }

    private int[] a(View view, String str) {
        int i2;
        Object a2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = R.id.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) view.getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
                i2 = ((Integer) a2).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }

    /* access modifiers changed from: private */
    public static int b(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    private a g(int i2) {
        if (!this.f2637e.containsKey(Integer.valueOf(i2))) {
            this.f2637e.put(Integer.valueOf(i2), new a());
        }
        return this.f2637e.get(Integer.valueOf(i2));
    }

    public a a(int i2) {
        return g(i2);
    }

    public void a(int i2, int i3) {
        if (this.f2637e.containsKey(Integer.valueOf(i2))) {
            a aVar = this.f2637e.get(Integer.valueOf(i2));
            switch (i3) {
                case 1:
                    aVar.f2641d.f2663i = -1;
                    aVar.f2641d.f2662h = -1;
                    aVar.f2641d.D = -1;
                    aVar.f2641d.J = -1;
                    return;
                case 2:
                    aVar.f2641d.f2665k = -1;
                    aVar.f2641d.f2664j = -1;
                    aVar.f2641d.E = -1;
                    aVar.f2641d.L = -1;
                    return;
                case 3:
                    aVar.f2641d.f2667m = -1;
                    aVar.f2641d.f2666l = -1;
                    aVar.f2641d.F = -1;
                    aVar.f2641d.K = -1;
                    return;
                case 4:
                    aVar.f2641d.f2668n = -1;
                    aVar.f2641d.f2669o = -1;
                    aVar.f2641d.G = -1;
                    aVar.f2641d.M = -1;
                    return;
                case 5:
                    aVar.f2641d.f2670p = -1;
                    return;
                case 6:
                    aVar.f2641d.f2671q = -1;
                    aVar.f2641d.f2672r = -1;
                    aVar.f2641d.I = -1;
                    aVar.f2641d.O = -1;
                    return;
                case 7:
                    aVar.f2641d.f2673s = -1;
                    aVar.f2641d.f2674t = -1;
                    aVar.f2641d.H = -1;
                    aVar.f2641d.N = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void a(int i2, int i3, int i4, float f2) {
        a g2 = g(i2);
        g2.f2641d.f2678x = i3;
        g2.f2641d.f2679y = i4;
        g2.f2641d.f2680z = f2;
    }

    public void a(int i2, ConstraintLayout.LayoutParams layoutParams) {
        if (this.f2637e.containsKey(Integer.valueOf(i2))) {
            this.f2637e.get(Integer.valueOf(i2)).a(layoutParams);
        }
    }

    public void a(Context context, int i2) {
        b((ConstraintLayout) LayoutInflater.from(context).inflate(i2, (ViewGroup) null));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x017b, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            int r0 = r11.getEventType()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1 = 0
            r2 = r1
        L_0x0006:
            r3 = 1
            if (r0 == r3) goto L_0x018a
            if (r0 == 0) goto L_0x0178
            java.lang.String r4 = "Constraint"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x0036
            if (r0 == r5) goto L_0x0015
            goto L_0x017b
        L_0x0015:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.String r3 = "ConstraintSet"
            boolean r3 = r3.equals(r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r3 == 0) goto L_0x0022
            return
        L_0x0022:
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x017b
            java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.b$a> r0 = r9.f2637e     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            int r3 = r2.f2638a     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r0.put(r3, r2)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r2 = r1
            goto L_0x017b
        L_0x0036:
            java.lang.String r0 = r11.getName()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r7 = -1
            int r8 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            switch(r8) {
                case -2025855158: goto L_0x0086;
                case -1984451626: goto L_0x007c;
                case -1269513683: goto L_0x0073;
                case -1238332596: goto L_0x0069;
                case -71750448: goto L_0x005f;
                case 1331510167: goto L_0x0055;
                case 1791837707: goto L_0x004b;
                case 1803088381: goto L_0x0043;
                default: goto L_0x0042;
            }     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x0042:
            goto L_0x0090
        L_0x0043:
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            r5 = 0
            goto L_0x0091
        L_0x004b:
            java.lang.String r4 = "CustomAttribute"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            r5 = 7
            goto L_0x0091
        L_0x0055:
            java.lang.String r4 = "Barrier"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            r5 = 2
            goto L_0x0091
        L_0x005f:
            java.lang.String r4 = "Guideline"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            r5 = 1
            goto L_0x0091
        L_0x0069:
            java.lang.String r4 = "Transform"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            r5 = 4
            goto L_0x0091
        L_0x0073:
            java.lang.String r4 = "PropertySet"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            goto L_0x0091
        L_0x007c:
            java.lang.String r4 = "Motion"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            r5 = 6
            goto L_0x0091
        L_0x0086:
            java.lang.String r4 = "Layout"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            if (r0 == 0) goto L_0x0090
            r5 = 5
            goto L_0x0091
        L_0x0090:
            r5 = -1
        L_0x0091:
            java.lang.String r0 = "XML parser error must be within a Constraint "
            switch(r5) {
                case 0: goto L_0x016e;
                case 1: goto L_0x015d;
                case 2: goto L_0x0150;
                case 3: goto L_0x012b;
                case 4: goto L_0x0106;
                case 5: goto L_0x00e0;
                case 6: goto L_0x00ba;
                case 7: goto L_0x0098;
                default: goto L_0x0096;
            }
        L_0x0096:
            goto L_0x017b
        L_0x0098:
            if (r2 == 0) goto L_0x00a1
            java.util.HashMap<java.lang.String, androidx.constraintlayout.widget.ConstraintAttribute> r0 = r2.f2643f     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            androidx.constraintlayout.widget.ConstraintAttribute.a(r10, r11, r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x017b
        L_0x00a1:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x00ba:
            if (r2 == 0) goto L_0x00c7
            androidx.constraintlayout.widget.b$c r0 = r2.f2640c     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x017b
        L_0x00c7:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x00e0:
            if (r2 == 0) goto L_0x00ed
            androidx.constraintlayout.widget.b$b r0 = r2.f2641d     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x017b
        L_0x00ed:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x0106:
            if (r2 == 0) goto L_0x0112
            androidx.constraintlayout.widget.b$e r0 = r2.f2642e     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x017b
        L_0x0112:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x012b:
            if (r2 == 0) goto L_0x0137
            androidx.constraintlayout.widget.b$d r0 = r2.f2639b     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r0.a(r10, r3)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x017b
        L_0x0137:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.<init>()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            int r11 = r11.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r1.append(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            java.lang.String r11 = r1.toString()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r10.<init>(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            throw r10     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x0150:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            androidx.constraintlayout.widget.b$a r0 = r9.a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            androidx.constraintlayout.widget.b$b r2 = r0.f2641d     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r2.f2649ad = r3     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x0176
        L_0x015d:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            androidx.constraintlayout.widget.b$a r0 = r9.a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            androidx.constraintlayout.widget.b$b r2 = r0.f2641d     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r2.f2645a = r3     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            androidx.constraintlayout.widget.b$b r2 = r0.f2641d     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            r2.f2656b = r3     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x0176
        L_0x016e:
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            androidx.constraintlayout.widget.b$a r0 = r9.a((android.content.Context) r10, (android.util.AttributeSet) r0)     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x0176:
            r2 = r0
            goto L_0x017b
        L_0x0178:
            r11.getName()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
        L_0x017b:
            int r0 = r11.next()     // Catch:{ XmlPullParserException -> 0x0186, IOException -> 0x0181 }
            goto L_0x0006
        L_0x0181:
            r10 = move-exception
            r10.printStackTrace()
            goto L_0x018a
        L_0x0186:
            r10 = move-exception
            r10.printStackTrace()
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void a(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int id2 = constraintHelper.getId();
        if (this.f2637e.containsKey(Integer.valueOf(id2))) {
            a aVar = this.f2637e.get(Integer.valueOf(id2));
            if (constraintWidget instanceof h) {
                constraintHelper.a(aVar, (h) constraintWidget, layoutParams, sparseArray);
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f2636c || id2 != -1) {
                if (!this.f2637e.containsKey(Integer.valueOf(id2))) {
                    this.f2637e.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f2637e.get(Integer.valueOf(id2));
                if (!aVar.f2641d.f2656b) {
                    aVar.a(id2, layoutParams);
                    if (childAt instanceof ConstraintHelper) {
                        aVar.f2641d.f2650ae = ((ConstraintHelper) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f2641d.f2655aj = barrier.a();
                            aVar.f2641d.f2647ab = barrier.getType();
                            aVar.f2641d.f2648ac = barrier.getMargin();
                        }
                    }
                    aVar.f2641d.f2656b = true;
                }
                if (!aVar.f2639b.f2689a) {
                    aVar.f2639b.f2690b = childAt.getVisibility();
                    aVar.f2639b.f2692d = childAt.getAlpha();
                    aVar.f2639b.f2689a = true;
                }
                if (Build.VERSION.SDK_INT >= 17 && !aVar.f2642e.f2695a) {
                    aVar.f2642e.f2695a = true;
                    aVar.f2642e.f2696b = childAt.getRotation();
                    aVar.f2642e.f2697c = childAt.getRotationX();
                    aVar.f2642e.f2698d = childAt.getRotationY();
                    aVar.f2642e.f2699e = childAt.getScaleX();
                    aVar.f2642e.f2700f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == i.f27244a && ((double) pivotY) == i.f27244a)) {
                        aVar.f2642e.f2701g = pivotX;
                        aVar.f2642e.f2702h = pivotY;
                    }
                    aVar.f2642e.f2703i = childAt.getTranslationX();
                    aVar.f2642e.f2704j = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar.f2642e.f2705k = childAt.getTranslationZ();
                        if (aVar.f2642e.f2706l) {
                            aVar.f2642e.f2707m = childAt.getElevation();
                        }
                    }
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ConstraintLayout constraintLayout, boolean z2) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f2637e.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id2 = childAt.getId();
            if (!this.f2637e.containsKey(Integer.valueOf(id2))) {
                Log.w("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.a(childAt));
            } else if (this.f2636c && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id2 != -1) {
                if (this.f2637e.containsKey(Integer.valueOf(id2))) {
                    hashSet.remove(Integer.valueOf(id2));
                    a aVar = this.f2637e.get(Integer.valueOf(id2));
                    if (childAt instanceof Barrier) {
                        aVar.f2641d.f2649ad = 1;
                    }
                    if (aVar.f2641d.f2649ad != -1 && aVar.f2641d.f2649ad == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id2);
                        barrier.setType(aVar.f2641d.f2647ab);
                        barrier.setMargin(aVar.f2641d.f2648ac);
                        barrier.setAllowsGoneWidget(aVar.f2641d.f2655aj);
                        if (aVar.f2641d.f2650ae != null) {
                            barrier.setReferencedIds(aVar.f2641d.f2650ae);
                        } else if (aVar.f2641d.f2651af != null) {
                            aVar.f2641d.f2650ae = a((View) barrier, aVar.f2641d.f2651af);
                            barrier.setReferencedIds(aVar.f2641d.f2650ae);
                        }
                    }
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                    layoutParams.b();
                    aVar.a(layoutParams);
                    if (z2) {
                        ConstraintAttribute.a(childAt, aVar.f2643f);
                    }
                    childAt.setLayoutParams(layoutParams);
                    if (aVar.f2639b.f2691c == 0) {
                        childAt.setVisibility(aVar.f2639b.f2690b);
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(aVar.f2639b.f2692d);
                        childAt.setRotation(aVar.f2642e.f2696b);
                        childAt.setRotationX(aVar.f2642e.f2697c);
                        childAt.setRotationY(aVar.f2642e.f2698d);
                        childAt.setScaleX(aVar.f2642e.f2699e);
                        childAt.setScaleY(aVar.f2642e.f2700f);
                        if (!Float.isNaN(aVar.f2642e.f2701g)) {
                            childAt.setPivotX(aVar.f2642e.f2701g);
                        }
                        if (!Float.isNaN(aVar.f2642e.f2702h)) {
                            childAt.setPivotY(aVar.f2642e.f2702h);
                        }
                        childAt.setTranslationX(aVar.f2642e.f2703i);
                        childAt.setTranslationY(aVar.f2642e.f2704j);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(aVar.f2642e.f2705k);
                            if (aVar.f2642e.f2706l) {
                                childAt.setElevation(aVar.f2642e.f2707m);
                            }
                        }
                    }
                } else {
                    Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id2);
                }
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Integer num = (Integer) it2.next();
            a aVar2 = this.f2637e.get(num);
            if (aVar2.f2641d.f2649ad != -1 && aVar2.f2641d.f2649ad == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                if (aVar2.f2641d.f2650ae != null) {
                    barrier2.setReferencedIds(aVar2.f2641d.f2650ae);
                } else if (aVar2.f2641d.f2651af != null) {
                    aVar2.f2641d.f2650ae = a((View) barrier2, aVar2.f2641d.f2651af);
                    barrier2.setReferencedIds(aVar2.f2641d.f2650ae);
                }
                barrier2.setType(aVar2.f2641d.f2647ab);
                barrier2.setMargin(aVar2.f2641d.f2648ac);
                ConstraintLayout.LayoutParams i3 = constraintLayout.generateDefaultLayoutParams();
                barrier2.c();
                aVar2.a(i3);
                constraintLayout.addView(barrier2, i3);
            }
            if (aVar2.f2641d.f2645a) {
                Guideline guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams i4 = constraintLayout.generateDefaultLayoutParams();
                aVar2.a(i4);
                constraintLayout.addView(guideline, i4);
            }
        }
    }

    public void a(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f2637e.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraints.getChildAt(i2);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f2636c || id2 != -1) {
                if (!this.f2637e.containsKey(Integer.valueOf(id2))) {
                    this.f2637e.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f2637e.get(Integer.valueOf(id2));
                if (childAt instanceof ConstraintHelper) {
                    aVar.a((ConstraintHelper) childAt, id2, layoutParams);
                }
                aVar.a(id2, layoutParams);
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void a(b bVar) {
        for (Integer next : bVar.f2637e.keySet()) {
            int intValue = next.intValue();
            a aVar = bVar.f2637e.get(next);
            if (!this.f2637e.containsKey(Integer.valueOf(intValue))) {
                this.f2637e.put(Integer.valueOf(intValue), new a());
            }
            a aVar2 = this.f2637e.get(Integer.valueOf(intValue));
            if (!aVar2.f2641d.f2656b) {
                aVar2.f2641d.a(aVar.f2641d);
            }
            if (!aVar2.f2639b.f2689a) {
                aVar2.f2639b.a(aVar.f2639b);
            }
            if (!aVar2.f2642e.f2695a) {
                aVar2.f2642e.a(aVar.f2642e);
            }
            if (!aVar2.f2640c.f2682a) {
                aVar2.f2640c.a(aVar.f2640c);
            }
            for (String next2 : aVar.f2643f.keySet()) {
                if (!aVar2.f2643f.containsKey(next2)) {
                    aVar2.f2643f.put(next2, aVar.f2643f.get(next2));
                }
            }
        }
    }

    public void a(boolean z2) {
        this.f2636c = z2;
    }

    public int[] a() {
        Integer[] numArr = (Integer[]) this.f2637e.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public int b(int i2) {
        return g(i2).f2639b.f2691c;
    }

    public void b(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a a2 = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.f2641d.f2645a = true;
                    }
                    this.f2637e.put(Integer.valueOf(a2.f2638a), a2);
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f2637e.clear();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (!this.f2636c || id2 != -1) {
                if (!this.f2637e.containsKey(Integer.valueOf(id2))) {
                    this.f2637e.put(Integer.valueOf(id2), new a());
                }
                a aVar = this.f2637e.get(Integer.valueOf(id2));
                aVar.f2643f = ConstraintAttribute.a(this.f2635b, childAt);
                aVar.a(id2, layoutParams);
                aVar.f2639b.f2690b = childAt.getVisibility();
                if (Build.VERSION.SDK_INT >= 17) {
                    aVar.f2639b.f2692d = childAt.getAlpha();
                    aVar.f2642e.f2696b = childAt.getRotation();
                    aVar.f2642e.f2697c = childAt.getRotationX();
                    aVar.f2642e.f2698d = childAt.getRotationY();
                    aVar.f2642e.f2699e = childAt.getScaleX();
                    aVar.f2642e.f2700f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == i.f27244a && ((double) pivotY) == i.f27244a)) {
                        aVar.f2642e.f2701g = pivotX;
                        aVar.f2642e.f2702h = pivotY;
                    }
                    aVar.f2642e.f2703i = childAt.getTranslationX();
                    aVar.f2642e.f2704j = childAt.getTranslationY();
                    if (Build.VERSION.SDK_INT >= 21) {
                        aVar.f2642e.f2705k = childAt.getTranslationZ();
                        if (aVar.f2642e.f2706l) {
                            aVar.f2642e.f2707m = childAt.getElevation();
                        }
                    }
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f2641d.f2655aj = barrier.a();
                    aVar.f2641d.f2650ae = barrier.getReferencedIds();
                    aVar.f2641d.f2647ab = barrier.getType();
                    aVar.f2641d.f2648ac = barrier.getMargin();
                }
                i2++;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void b(boolean z2) {
        this.f2634a = z2;
    }

    public int c(int i2) {
        return g(i2).f2639b.f2690b;
    }

    public void c(ConstraintLayout constraintLayout) {
        a(constraintLayout, true);
        constraintLayout.setConstraintSet((b) null);
        constraintLayout.requestLayout();
    }

    public int d(int i2) {
        return g(i2).f2641d.f2658d;
    }

    public void d(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id2 = childAt.getId();
            if (!this.f2637e.containsKey(Integer.valueOf(id2))) {
                Log.v("ConstraintSet", "id unknown " + androidx.constraintlayout.motion.widget.a.a(childAt));
            } else if (this.f2636c && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (this.f2637e.containsKey(Integer.valueOf(id2))) {
                ConstraintAttribute.a(childAt, this.f2637e.get(Integer.valueOf(id2)).f2643f);
            }
        }
    }

    public int e(int i2) {
        return g(i2).f2641d.f2657c;
    }

    public a f(int i2) {
        if (this.f2637e.containsKey(Integer.valueOf(i2))) {
            return this.f2637e.get(Integer.valueOf(i2));
        }
        return null;
    }
}
