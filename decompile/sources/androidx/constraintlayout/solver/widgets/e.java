package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.d;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

public class e extends j {
    /* access modifiers changed from: private */
    public int aA = -1;
    /* access modifiers changed from: private */
    public int aB = -1;
    /* access modifiers changed from: private */
    public int aC = -1;
    /* access modifiers changed from: private */
    public int aD = -1;
    /* access modifiers changed from: private */
    public int aE = -1;
    /* access modifiers changed from: private */
    public float aF = 0.5f;
    /* access modifiers changed from: private */
    public float aG = 0.5f;
    /* access modifiers changed from: private */
    public float aH = 0.5f;
    /* access modifiers changed from: private */
    public float aI = 0.5f;
    /* access modifiers changed from: private */
    public float aJ = 0.5f;
    /* access modifiers changed from: private */
    public float aK = 0.5f;
    /* access modifiers changed from: private */
    public int aL = 0;
    /* access modifiers changed from: private */
    public int aM = 0;
    /* access modifiers changed from: private */
    public int aN = 2;
    /* access modifiers changed from: private */
    public int aO = 2;
    private int aP = 0;
    private int aQ = -1;
    private int aR = 0;
    private ArrayList<a> aS = new ArrayList<>();
    private ConstraintWidget[] aT = null;
    private ConstraintWidget[] aU = null;
    private int[] aV = null;
    /* access modifiers changed from: private */
    public ConstraintWidget[] aW;
    /* access modifiers changed from: private */
    public int aX = 0;
    /* access modifiers changed from: private */

    /* renamed from: az  reason: collision with root package name */
    public int f2422az = -1;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        int f2423a = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f2425c = 0;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public ConstraintWidget f2426d = null;

        /* renamed from: e  reason: collision with root package name */
        private ConstraintAnchor f2427e;

        /* renamed from: f  reason: collision with root package name */
        private ConstraintAnchor f2428f;

        /* renamed from: g  reason: collision with root package name */
        private ConstraintAnchor f2429g;

        /* renamed from: h  reason: collision with root package name */
        private ConstraintAnchor f2430h;

        /* renamed from: i  reason: collision with root package name */
        private int f2431i = 0;

        /* renamed from: j  reason: collision with root package name */
        private int f2432j = 0;

        /* renamed from: k  reason: collision with root package name */
        private int f2433k = 0;

        /* renamed from: l  reason: collision with root package name */
        private int f2434l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f2435m = 0;

        /* renamed from: n  reason: collision with root package name */
        private int f2436n = 0;

        /* renamed from: o  reason: collision with root package name */
        private int f2437o = 0;

        /* renamed from: p  reason: collision with root package name */
        private int f2438p = 0;

        /* renamed from: q  reason: collision with root package name */
        private int f2439q = 0;

        /* renamed from: r  reason: collision with root package name */
        private int f2440r = 0;

        public a(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.f2425c = i2;
            this.f2427e = constraintAnchor;
            this.f2428f = constraintAnchor2;
            this.f2429g = constraintAnchor3;
            this.f2430h = constraintAnchor4;
            this.f2431i = e.this.f();
            this.f2432j = e.this.b();
            this.f2433k = e.this.g();
            this.f2434l = e.this.c();
            this.f2440r = i3;
        }

        private void d() {
            this.f2435m = 0;
            this.f2436n = 0;
            this.f2426d = null;
            this.f2423a = 0;
            int i2 = this.f2438p;
            int i3 = 0;
            while (i3 < i2 && this.f2437o + i3 < e.this.aX) {
                ConstraintWidget constraintWidget = e.this.aW[this.f2437o + i3];
                if (this.f2425c == 0) {
                    int A = constraintWidget.A();
                    int a2 = e.this.aL;
                    if (constraintWidget.w() == 8) {
                        a2 = 0;
                    }
                    this.f2435m += A + a2;
                    int b2 = e.this.b(constraintWidget, this.f2440r);
                    if (this.f2426d == null || this.f2423a < b2) {
                        this.f2426d = constraintWidget;
                        this.f2423a = b2;
                        this.f2436n = b2;
                    }
                } else {
                    int a3 = e.this.a(constraintWidget, this.f2440r);
                    int b3 = e.this.b(constraintWidget, this.f2440r);
                    int b4 = e.this.aM;
                    if (constraintWidget.w() == 8) {
                        b4 = 0;
                    }
                    this.f2436n += b3 + b4;
                    if (this.f2426d == null || this.f2423a < a3) {
                        this.f2426d = constraintWidget;
                        this.f2423a = a3;
                        this.f2435m = a3;
                    }
                }
                i3++;
            }
        }

        public void a() {
            this.f2423a = 0;
            this.f2426d = null;
            this.f2435m = 0;
            this.f2436n = 0;
            this.f2437o = 0;
            this.f2438p = 0;
            this.f2439q = 0;
        }

        public void a(int i2) {
            this.f2437o = i2;
        }

        public void a(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.f2425c = i2;
            this.f2427e = constraintAnchor;
            this.f2428f = constraintAnchor2;
            this.f2429g = constraintAnchor3;
            this.f2430h = constraintAnchor4;
            this.f2431i = i3;
            this.f2432j = i4;
            this.f2433k = i5;
            this.f2434l = i6;
            this.f2440r = i7;
        }

        public void a(ConstraintWidget constraintWidget) {
            int i2 = 0;
            if (this.f2425c == 0) {
                int a2 = e.this.a(constraintWidget, this.f2440r);
                if (constraintWidget.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f2439q++;
                    a2 = 0;
                }
                int a3 = e.this.aL;
                if (constraintWidget.w() != 8) {
                    i2 = a3;
                }
                this.f2435m += a2 + i2;
                int b2 = e.this.b(constraintWidget, this.f2440r);
                if (this.f2426d == null || this.f2423a < b2) {
                    this.f2426d = constraintWidget;
                    this.f2423a = b2;
                    this.f2436n = b2;
                }
            } else {
                int a4 = e.this.a(constraintWidget, this.f2440r);
                int b3 = e.this.b(constraintWidget, this.f2440r);
                if (constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f2439q++;
                    b3 = 0;
                }
                int b4 = e.this.aM;
                if (constraintWidget.w() != 8) {
                    i2 = b4;
                }
                this.f2436n += b3 + i2;
                if (this.f2426d == null || this.f2423a < a4) {
                    this.f2426d = constraintWidget;
                    this.f2423a = a4;
                    this.f2435m = a4;
                }
            }
            this.f2438p++;
        }

        /* JADX WARNING: Removed duplicated region for block: B:125:0x023f  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00df  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(boolean r17, int r18, boolean r19) {
            /*
                r16 = this;
                r0 = r16
                int r1 = r0.f2438p
                r2 = 0
                r3 = 0
            L_0x0006:
                if (r3 >= r1) goto L_0x0027
                int r4 = r0.f2437o
                int r4 = r4 + r3
                androidx.constraintlayout.solver.widgets.e r5 = androidx.constraintlayout.solver.widgets.e.this
                int r5 = r5.aX
                if (r4 < r5) goto L_0x0014
                goto L_0x0027
            L_0x0014:
                androidx.constraintlayout.solver.widgets.e r4 = androidx.constraintlayout.solver.widgets.e.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r4 = r4.aW
                int r5 = r0.f2437o
                int r5 = r5 + r3
                r4 = r4[r5]
                if (r4 == 0) goto L_0x0024
                r4.R()
            L_0x0024:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x0027:
                if (r1 == 0) goto L_0x032b
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.f2426d
                if (r3 != 0) goto L_0x002f
                goto L_0x032b
            L_0x002f:
                if (r19 == 0) goto L_0x0035
                if (r18 != 0) goto L_0x0035
                r4 = 1
                goto L_0x0036
            L_0x0035:
                r4 = 0
            L_0x0036:
                r5 = -1
                r6 = 0
                r7 = -1
                r8 = -1
            L_0x003a:
                if (r6 >= r1) goto L_0x0067
                if (r17 == 0) goto L_0x0042
                int r9 = r1 + -1
                int r9 = r9 - r6
                goto L_0x0043
            L_0x0042:
                r9 = r6
            L_0x0043:
                int r10 = r0.f2437o
                int r10 = r10 + r9
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                int r11 = r11.aX
                if (r10 < r11) goto L_0x004f
                goto L_0x0067
            L_0x004f:
                androidx.constraintlayout.solver.widgets.e r10 = androidx.constraintlayout.solver.widgets.e.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r10.aW
                int r11 = r0.f2437o
                int r11 = r11 + r9
                r9 = r10[r11]
                int r9 = r9.w()
                if (r9 != 0) goto L_0x0064
                if (r7 != r5) goto L_0x0063
                r7 = r6
            L_0x0063:
                r8 = r6
            L_0x0064:
                int r6 = r6 + 1
                goto L_0x003a
            L_0x0067:
                r6 = 0
                int r9 = r0.f2425c
                if (r9 != 0) goto L_0x01db
                androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r0.f2426d
                androidx.constraintlayout.solver.widgets.e r10 = androidx.constraintlayout.solver.widgets.e.this
                int r10 = r10.aA
                r9.u(r10)
                int r10 = r0.f2432j
                if (r18 <= 0) goto L_0x0082
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                int r11 = r11.aM
                int r10 = r10 + r11
            L_0x0082:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.f2290z
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.f2428f
                r11.a(r12, r10)
                if (r19 == 0) goto L_0x0094
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r9.B
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2430h
                int r12 = r0.f2434l
                r10.a(r11, r12)
            L_0x0094:
                if (r18 <= 0) goto L_0x00a1
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.f2428f
                androidx.constraintlayout.solver.widgets.ConstraintWidget r10 = r10.f2219a
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r10.B
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.f2290z
                r10.a(r11, r2)
            L_0x00a1:
                androidx.constraintlayout.solver.widgets.e r10 = androidx.constraintlayout.solver.widgets.e.this
                int r10 = r10.aO
                r11 = 3
                if (r10 != r11) goto L_0x00db
                boolean r10 = r9.K()
                if (r10 != 0) goto L_0x00db
                r10 = 0
            L_0x00b1:
                if (r10 >= r1) goto L_0x00db
                if (r17 == 0) goto L_0x00b9
                int r12 = r1 + -1
                int r12 = r12 - r10
                goto L_0x00ba
            L_0x00b9:
                r12 = r10
            L_0x00ba:
                int r13 = r0.f2437o
                int r13 = r13 + r12
                androidx.constraintlayout.solver.widgets.e r14 = androidx.constraintlayout.solver.widgets.e.this
                int r14 = r14.aX
                if (r13 < r14) goto L_0x00c6
                goto L_0x00db
            L_0x00c6:
                androidx.constraintlayout.solver.widgets.e r13 = androidx.constraintlayout.solver.widgets.e.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r13 = r13.aW
                int r14 = r0.f2437o
                int r14 = r14 + r12
                r12 = r13[r14]
                boolean r13 = r12.K()
                if (r13 == 0) goto L_0x00d8
                goto L_0x00dc
            L_0x00d8:
                int r10 = r10 + 1
                goto L_0x00b1
            L_0x00db:
                r12 = r9
            L_0x00dc:
                r10 = 0
            L_0x00dd:
                if (r10 >= r1) goto L_0x032b
                if (r17 == 0) goto L_0x00e5
                int r13 = r1 + -1
                int r13 = r13 - r10
                goto L_0x00e6
            L_0x00e5:
                r13 = r10
            L_0x00e6:
                int r14 = r0.f2437o
                int r14 = r14 + r13
                androidx.constraintlayout.solver.widgets.e r15 = androidx.constraintlayout.solver.widgets.e.this
                int r15 = r15.aX
                if (r14 < r15) goto L_0x00f3
                goto L_0x032b
            L_0x00f3:
                androidx.constraintlayout.solver.widgets.e r14 = androidx.constraintlayout.solver.widgets.e.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r14 = r14.aW
                int r15 = r0.f2437o
                int r15 = r15 + r13
                r14 = r14[r15]
                if (r10 != 0) goto L_0x0109
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r15 = r14.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2427e
                int r3 = r0.f2431i
                r14.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r15, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (int) r3)
            L_0x0109:
                if (r13 != 0) goto L_0x014c
                androidx.constraintlayout.solver.widgets.e r3 = androidx.constraintlayout.solver.widgets.e.this
                int r3 = r3.f2422az
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                float r11 = r11.aF
                int r13 = r0.f2437o
                if (r13 != 0) goto L_0x0130
                androidx.constraintlayout.solver.widgets.e r13 = androidx.constraintlayout.solver.widgets.e.this
                int r13 = r13.aB
                if (r13 == r5) goto L_0x0130
                androidx.constraintlayout.solver.widgets.e r3 = androidx.constraintlayout.solver.widgets.e.this
                int r3 = r3.aB
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                float r11 = r11.aH
                goto L_0x0146
            L_0x0130:
                if (r19 == 0) goto L_0x0146
                androidx.constraintlayout.solver.widgets.e r13 = androidx.constraintlayout.solver.widgets.e.this
                int r13 = r13.aD
                if (r13 == r5) goto L_0x0146
                androidx.constraintlayout.solver.widgets.e r3 = androidx.constraintlayout.solver.widgets.e.this
                int r3 = r3.aD
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                float r11 = r11.aJ
            L_0x0146:
                r14.t(r3)
                r14.a((float) r11)
            L_0x014c:
                int r3 = r1 + -1
                if (r10 != r3) goto L_0x0159
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2429g
                int r13 = r0.f2433k
                r14.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r3, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (int) r13)
            L_0x0159:
                if (r6 == 0) goto L_0x0184
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.A
                androidx.constraintlayout.solver.widgets.e r13 = androidx.constraintlayout.solver.widgets.e.this
                int r13 = r13.aL
                r3.a(r11, r13)
                if (r10 != r7) goto L_0x0171
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.f2289y
                int r11 = r0.f2431i
                r3.b(r11)
            L_0x0171:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r6.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r14.f2289y
                r3.a(r11, r2)
                r3 = 1
                int r11 = r8 + 1
                if (r10 != r11) goto L_0x0184
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r6.A
                int r6 = r0.f2433k
                r3.b(r6)
            L_0x0184:
                if (r14 == r9) goto L_0x01d4
                androidx.constraintlayout.solver.widgets.e r3 = androidx.constraintlayout.solver.widgets.e.this
                int r3 = r3.aO
                r6 = 3
                if (r3 != r6) goto L_0x01a2
                boolean r3 = r12.K()
                if (r3 == 0) goto L_0x01a2
                if (r14 == r12) goto L_0x01a2
                boolean r3 = r14.K()
                if (r3 == 0) goto L_0x01a2
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.C
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r12.C
                goto L_0x01d0
            L_0x01a2:
                androidx.constraintlayout.solver.widgets.e r3 = androidx.constraintlayout.solver.widgets.e.this
                int r3 = r3.aO
                if (r3 == 0) goto L_0x01cc
                r11 = 1
                if (r3 == r11) goto L_0x01c7
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.f2290z
                if (r4 == 0) goto L_0x01c2
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2428f
                int r13 = r0.f2432j
                r3.a(r11, r13)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.B
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2430h
                int r13 = r0.f2434l
                r3.a(r11, r13)
                goto L_0x01d5
            L_0x01c2:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.f2290z
                r3.a(r11, r2)
            L_0x01c7:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.B
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.B
                goto L_0x01d0
            L_0x01cc:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r3 = r14.f2290z
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r9.f2290z
            L_0x01d0:
                r3.a(r11, r2)
                goto L_0x01d5
            L_0x01d4:
                r6 = 3
            L_0x01d5:
                int r10 = r10 + 1
                r6 = r14
                r11 = 3
                goto L_0x00dd
            L_0x01db:
                androidx.constraintlayout.solver.widgets.ConstraintWidget r3 = r0.f2426d
                androidx.constraintlayout.solver.widgets.e r9 = androidx.constraintlayout.solver.widgets.e.this
                int r9 = r9.f2422az
                r3.t(r9)
                int r9 = r0.f2431i
                if (r18 <= 0) goto L_0x01f1
                androidx.constraintlayout.solver.widgets.e r10 = androidx.constraintlayout.solver.widgets.e.this
                int r10 = r10.aL
                int r9 = r9 + r10
            L_0x01f1:
                if (r17 == 0) goto L_0x0210
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2429g
                r10.a(r11, r9)
                if (r19 == 0) goto L_0x0205
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r3.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.f2427e
                int r11 = r0.f2433k
                r9.a(r10, r11)
            L_0x0205:
                if (r18 <= 0) goto L_0x022f
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r0.f2429g
                androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r9.f2219a
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.A
                goto L_0x022c
            L_0x0210:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2427e
                r10.a(r11, r9)
                if (r19 == 0) goto L_0x0222
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r3.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r0.f2429g
                int r11 = r0.f2433k
                r9.a(r10, r11)
            L_0x0222:
                if (r18 <= 0) goto L_0x022f
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r0.f2427e
                androidx.constraintlayout.solver.widgets.ConstraintWidget r9 = r9.f2219a
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r9 = r9.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r10 = r3.f2289y
            L_0x022c:
                r9.a(r10, r2)
            L_0x022f:
                r9 = 0
            L_0x0230:
                if (r9 >= r1) goto L_0x032b
                int r10 = r0.f2437o
                int r10 = r10 + r9
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                int r11 = r11.aX
                if (r10 < r11) goto L_0x023f
                goto L_0x032b
            L_0x023f:
                androidx.constraintlayout.solver.widgets.e r10 = androidx.constraintlayout.solver.widgets.e.this
                androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r10.aW
                int r11 = r0.f2437o
                int r11 = r11 + r9
                r10 = r10[r11]
                if (r9 != 0) goto L_0x0296
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.f2290z
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.f2428f
                int r13 = r0.f2432j
                r10.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r12, (int) r13)
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                int r11 = r11.aA
                androidx.constraintlayout.solver.widgets.e r12 = androidx.constraintlayout.solver.widgets.e.this
                float r12 = r12.aG
                int r13 = r0.f2437o
                if (r13 != 0) goto L_0x027a
                androidx.constraintlayout.solver.widgets.e r13 = androidx.constraintlayout.solver.widgets.e.this
                int r13 = r13.aC
                if (r13 == r5) goto L_0x027a
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                int r11 = r11.aC
                androidx.constraintlayout.solver.widgets.e r12 = androidx.constraintlayout.solver.widgets.e.this
                float r12 = r12.aI
                goto L_0x0290
            L_0x027a:
                if (r19 == 0) goto L_0x0290
                androidx.constraintlayout.solver.widgets.e r13 = androidx.constraintlayout.solver.widgets.e.this
                int r13 = r13.aE
                if (r13 == r5) goto L_0x0290
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                int r11 = r11.aE
                androidx.constraintlayout.solver.widgets.e r12 = androidx.constraintlayout.solver.widgets.e.this
                float r12 = r12.aK
            L_0x0290:
                r10.u(r11)
                r10.b((float) r12)
            L_0x0296:
                int r11 = r1 + -1
                if (r9 != r11) goto L_0x02a3
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.B
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r0.f2430h
                int r13 = r0.f2434l
                r10.a((androidx.constraintlayout.solver.widgets.ConstraintAnchor) r11, (androidx.constraintlayout.solver.widgets.ConstraintAnchor) r12, (int) r13)
            L_0x02a3:
                if (r6 == 0) goto L_0x02ce
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.f2290z
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r6.B
                androidx.constraintlayout.solver.widgets.e r13 = androidx.constraintlayout.solver.widgets.e.this
                int r13 = r13.aM
                r11.a(r12, r13)
                if (r9 != r7) goto L_0x02bb
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r10.f2290z
                int r12 = r0.f2432j
                r11.b(r12)
            L_0x02bb:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r6.B
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r12 = r10.f2290z
                r11.a(r12, r2)
                r11 = 1
                int r12 = r8 + 1
                if (r9 != r12) goto L_0x02ce
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r6.B
                int r11 = r0.f2434l
                r6.b(r11)
            L_0x02ce:
                if (r10 == r3) goto L_0x0325
                r6 = 2
                androidx.constraintlayout.solver.widgets.e r11 = androidx.constraintlayout.solver.widgets.e.this
                int r11 = r11.aN
                if (r17 == 0) goto L_0x02f6
                if (r11 == 0) goto L_0x02ee
                r12 = 1
                if (r11 == r12) goto L_0x02e9
                if (r11 == r6) goto L_0x02e1
                goto L_0x0325
            L_0x02e1:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.f2289y
                r6.a(r11, r2)
                goto L_0x02ee
            L_0x02e9:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.f2289y
                goto L_0x02f2
            L_0x02ee:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.A
            L_0x02f2:
                r6.a(r11, r2)
                goto L_0x0325
            L_0x02f6:
                r12 = 1
                if (r11 == 0) goto L_0x031d
                if (r11 == r12) goto L_0x0318
                if (r11 == r6) goto L_0x02fe
                goto L_0x0326
            L_0x02fe:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.f2289y
                if (r4 == 0) goto L_0x0313
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2427e
                int r13 = r0.f2431i
                r6.a(r11, r13)
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r0.f2429g
                int r13 = r0.f2433k
                r6.a(r11, r13)
                goto L_0x0326
            L_0x0313:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.f2289y
                r6.a(r11, r2)
            L_0x0318:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.A
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.A
                goto L_0x0321
            L_0x031d:
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r6 = r10.f2289y
                androidx.constraintlayout.solver.widgets.ConstraintAnchor r11 = r3.f2289y
            L_0x0321:
                r6.a(r11, r2)
                goto L_0x0326
            L_0x0325:
                r12 = 1
            L_0x0326:
                int r9 = r9 + 1
                r6 = r10
                goto L_0x0230
            L_0x032b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.e.a.a(boolean, int, boolean):void");
        }

        public int b() {
            return this.f2425c == 0 ? this.f2435m - e.this.aL : this.f2435m;
        }

        public void b(int i2) {
            int i3;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour;
            int i4;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
            e eVar;
            int i5 = this.f2439q;
            if (i5 != 0) {
                int i6 = this.f2438p;
                int i7 = i2 / i5;
                int i8 = 0;
                while (i8 < i6 && this.f2437o + i8 < e.this.aX) {
                    ConstraintWidget constraintWidget = e.this.aW[this.f2437o + i8];
                    if (this.f2425c == 0) {
                        if (constraintWidget != null && constraintWidget.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2276l == 0) {
                            eVar = e.this;
                            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                            dimensionBehaviour = constraintWidget.T();
                            i3 = constraintWidget.B();
                            i4 = i7;
                        }
                        i8++;
                    } else {
                        if (constraintWidget != null && constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f2277m == 0) {
                            eVar = e.this;
                            dimensionBehaviour2 = constraintWidget.S();
                            i4 = constraintWidget.A();
                            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                            i3 = i7;
                        }
                        i8++;
                    }
                    eVar.a(constraintWidget, dimensionBehaviour2, i4, dimensionBehaviour, i3);
                    i8++;
                }
                d();
            }
        }

        public int c() {
            return this.f2425c == 1 ? this.f2436n - e.this.aM : this.f2436n;
        }
    }

    /* access modifiers changed from: private */
    public final int a(ConstraintWidget constraintWidget, int i2) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.f2276l == 0) {
                return 0;
            }
            if (constraintWidget.f2276l == 2) {
                int i3 = (int) (constraintWidget.f2281q * ((float) i2));
                if (i3 != constraintWidget.A()) {
                    constraintWidget.e(true);
                    a(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i3, constraintWidget.T(), constraintWidget.B());
                }
                return i3;
            } else if (constraintWidget.f2276l == 1) {
                return constraintWidget.A();
            } else {
                if (constraintWidget.f2276l == 3) {
                    return (int) ((((float) constraintWidget.B()) * constraintWidget.M) + 0.5f);
                }
            }
        }
        return constraintWidget.A();
    }

    private void a(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        ConstraintAnchor constraintAnchor;
        int i5;
        int i6;
        int i7;
        ConstraintAnchor constraintAnchor2;
        int i8;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i4;
        if (i11 != 0) {
            this.aS.clear();
            a aVar = new a(i3, this.f2289y, this.f2290z, this.A, this.B, i4);
            this.aS.add(aVar);
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            if (i3 == 0) {
                while (i15 < i11) {
                    ConstraintWidget constraintWidget = constraintWidgetArr[i15];
                    int a2 = a(constraintWidget, i12);
                    if (constraintWidget.S() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i16 = i13;
                    boolean z2 = (i14 == i12 || (this.aL + i14) + a2 > i12) && aVar.f2426d != null;
                    if (!z2 && i15 > 0 && (i10 = this.aQ) > 0 && i15 % i10 == 0) {
                        z2 = true;
                    }
                    if (z2) {
                        aVar = new a(i3, this.f2289y, this.f2290z, this.A, this.B, i4);
                        aVar.a(i15);
                        this.aS.add(aVar);
                    } else if (i15 > 0) {
                        i14 += this.aL + a2;
                        aVar.a(constraintWidget);
                        i15++;
                        i13 = i16;
                    }
                    i14 = a2;
                    aVar.a(constraintWidget);
                    i15++;
                    i13 = i16;
                }
            } else {
                while (i15 < i11) {
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i15];
                    int b2 = b(constraintWidget2, i12);
                    if (constraintWidget2.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i13++;
                    }
                    int i17 = i13;
                    boolean z3 = (i14 == i12 || (this.aM + i14) + b2 > i12) && aVar.f2426d != null;
                    if (!z3 && i15 > 0 && (i9 = this.aQ) > 0 && i15 % i9 == 0) {
                        z3 = true;
                    }
                    if (z3) {
                        aVar = new a(i3, this.f2289y, this.f2290z, this.A, this.B, i4);
                        aVar.a(i15);
                        this.aS.add(aVar);
                    } else if (i15 > 0) {
                        i8 = i14 + this.aM + b2;
                        aVar.a(constraintWidget2);
                        i15++;
                        i13 = i17;
                    }
                    i8 = b2;
                    aVar.a(constraintWidget2);
                    i15++;
                    i13 = i17;
                }
            }
            int size = this.aS.size();
            ConstraintAnchor constraintAnchor3 = this.f2289y;
            ConstraintAnchor constraintAnchor4 = this.f2290z;
            ConstraintAnchor constraintAnchor5 = this.A;
            ConstraintAnchor constraintAnchor6 = this.B;
            int f2 = f();
            int b3 = b();
            int g2 = g();
            int c2 = c();
            boolean z4 = S() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || T() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (i13 > 0 && z4) {
                for (int i18 = 0; i18 < size; i18++) {
                    a aVar2 = this.aS.get(i18);
                    aVar2.b(i12 - (i3 == 0 ? aVar2.b() : aVar2.c()));
                }
            }
            int i19 = b3;
            int i20 = g2;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = f2;
            ConstraintAnchor constraintAnchor7 = constraintAnchor4;
            ConstraintAnchor constraintAnchor8 = constraintAnchor3;
            int i25 = c2;
            while (i23 < size) {
                a aVar3 = this.aS.get(i23);
                if (i3 == 0) {
                    if (i23 < size - 1) {
                        constraintAnchor2 = this.aS.get(i23 + 1).f2426d.f2290z;
                        i7 = 0;
                    } else {
                        constraintAnchor2 = this.B;
                        i7 = c();
                    }
                    ConstraintAnchor constraintAnchor9 = aVar3.f2426d.B;
                    ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                    ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                    int i26 = i21;
                    ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                    int i27 = i22;
                    ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                    ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                    i5 = i23;
                    aVar3.a(i3, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i24, i19, i20, i7, i4);
                    int max = Math.max(i27, aVar3.b());
                    i21 = i26 + aVar3.c();
                    if (i5 > 0) {
                        i21 += this.aM;
                    }
                    constraintAnchor8 = constraintAnchor11;
                    i22 = max;
                    constraintAnchor7 = constraintAnchor9;
                    i19 = 0;
                    constraintAnchor = constraintAnchor14;
                    int i28 = i7;
                    constraintAnchor6 = constraintAnchor2;
                    i25 = i28;
                } else {
                    ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                    int i29 = i21;
                    int i30 = i22;
                    i5 = i23;
                    if (i5 < size - 1) {
                        constraintAnchor = this.aS.get(i5 + 1).f2426d.f2289y;
                        i6 = 0;
                    } else {
                        constraintAnchor = this.A;
                        i6 = g();
                    }
                    ConstraintAnchor constraintAnchor16 = aVar3.f2426d.A;
                    aVar3.a(i3, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i24, i19, i6, i25, i4);
                    i22 = i30 + aVar3.b();
                    int max2 = Math.max(i29, aVar3.c());
                    if (i5 > 0) {
                        i22 += this.aL;
                    }
                    i21 = max2;
                    i20 = i6;
                    constraintAnchor8 = constraintAnchor16;
                    i24 = 0;
                }
                i23 = i5 + 1;
                int i31 = i4;
                constraintAnchor5 = constraintAnchor;
            }
            iArr[0] = i22;
            iArr[1] = i21;
        }
    }

    /* access modifiers changed from: private */
    public final int b(ConstraintWidget constraintWidget, int i2) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.T() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.f2277m == 0) {
                return 0;
            }
            if (constraintWidget.f2277m == 2) {
                int i3 = (int) (constraintWidget.f2284t * ((float) i2));
                if (i3 != constraintWidget.B()) {
                    constraintWidget.e(true);
                    a(constraintWidget, constraintWidget.S(), constraintWidget.A(), ConstraintWidget.DimensionBehaviour.FIXED, i3);
                }
                return i3;
            } else if (constraintWidget.f2277m == 1) {
                return constraintWidget.B();
            } else {
                if (constraintWidget.f2277m == 3) {
                    return (int) ((((float) constraintWidget.A()) * constraintWidget.M) + 0.5f);
                }
            }
        }
        return constraintWidget.B();
    }

    private void b(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        a aVar;
        int i5 = i2;
        if (i5 != 0) {
            if (this.aS.size() == 0) {
                aVar = new a(i3, this.f2289y, this.f2290z, this.A, this.B, i4);
                this.aS.add(aVar);
            } else {
                a aVar2 = this.aS.get(0);
                aVar2.a();
                aVar = aVar2;
                int i6 = i3;
                aVar.a(i6, this.f2289y, this.f2290z, this.A, this.B, f(), b(), g(), c(), i4);
            }
            for (int i7 = 0; i7 < i5; i7++) {
                aVar.a(constraintWidgetArr[i7]);
            }
            iArr[0] = aVar.b();
            iArr[1] = aVar.c();
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0129 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0066  */
    private void c(androidx.constraintlayout.solver.widgets.ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = 0
            int r6 = r0.aQ
            if (r3 != 0) goto L_0x0030
            if (r6 > 0) goto L_0x002d
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0014:
            if (r7 >= r2) goto L_0x002d
            if (r7 <= 0) goto L_0x001b
            int r9 = r0.aL
            int r8 = r8 + r9
        L_0x001b:
            r9 = r1[r7]
            if (r9 != 0) goto L_0x0020
            goto L_0x002a
        L_0x0020:
            int r9 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r9, (int) r4)
            int r8 = r8 + r9
            if (r8 <= r4) goto L_0x0028
            goto L_0x002d
        L_0x0028:
            int r6 = r6 + 1
        L_0x002a:
            int r7 = r7 + 1
            goto L_0x0014
        L_0x002d:
            r7 = r6
            r6 = 0
            goto L_0x004f
        L_0x0030:
            if (r6 > 0) goto L_0x004e
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0035:
            if (r7 >= r2) goto L_0x004e
            if (r7 <= 0) goto L_0x003c
            int r9 = r0.aM
            int r8 = r8 + r9
        L_0x003c:
            r9 = r1[r7]
            if (r9 != 0) goto L_0x0041
            goto L_0x004b
        L_0x0041:
            int r9 = r0.b(r9, r4)
            int r8 = r8 + r9
            if (r8 <= r4) goto L_0x0049
            goto L_0x004e
        L_0x0049:
            int r6 = r6 + 1
        L_0x004b:
            int r7 = r7 + 1
            goto L_0x0035
        L_0x004e:
            r7 = 0
        L_0x004f:
            int[] r8 = r0.aV
            if (r8 != 0) goto L_0x0058
            r8 = 2
            int[] r8 = new int[r8]
            r0.aV = r8
        L_0x0058:
            r8 = 1
            if (r6 != 0) goto L_0x005d
            if (r3 == r8) goto L_0x0061
        L_0x005d:
            if (r7 != 0) goto L_0x0063
            if (r3 != 0) goto L_0x0063
        L_0x0061:
            r9 = 1
            goto L_0x0064
        L_0x0063:
            r9 = 0
        L_0x0064:
            if (r9 != 0) goto L_0x0129
            if (r3 != 0) goto L_0x0072
            float r6 = (float) r2
            float r10 = (float) r7
            float r6 = r6 / r10
            double r10 = (double) r6
            double r10 = java.lang.Math.ceil(r10)
            int r6 = (int) r10
            goto L_0x007b
        L_0x0072:
            float r7 = (float) r2
            float r10 = (float) r6
            float r7 = r7 / r10
            double r10 = (double) r7
            double r10 = java.lang.Math.ceil(r10)
            int r7 = (int) r10
        L_0x007b:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r0.aU
            r11 = 0
            if (r10 == 0) goto L_0x0088
            int r12 = r10.length
            if (r12 >= r7) goto L_0x0084
            goto L_0x0088
        L_0x0084:
            java.util.Arrays.fill(r10, r11)
            goto L_0x008c
        L_0x0088:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r7]
            r0.aU = r10
        L_0x008c:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = r0.aT
            if (r10 == 0) goto L_0x0098
            int r12 = r10.length
            if (r12 >= r6) goto L_0x0094
            goto L_0x0098
        L_0x0094:
            java.util.Arrays.fill(r10, r11)
            goto L_0x009c
        L_0x0098:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r10 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r6]
            r0.aT = r10
        L_0x009c:
            r10 = 0
        L_0x009d:
            if (r10 >= r7) goto L_0x00e5
            r11 = 0
        L_0x00a0:
            if (r11 >= r6) goto L_0x00e2
            int r12 = r11 * r7
            int r12 = r12 + r10
            if (r3 != r8) goto L_0x00aa
            int r12 = r10 * r6
            int r12 = r12 + r11
        L_0x00aa:
            int r13 = r1.length
            if (r12 < r13) goto L_0x00ae
            goto L_0x00df
        L_0x00ae:
            r12 = r1[r12]
            if (r12 != 0) goto L_0x00b3
            goto L_0x00df
        L_0x00b3:
            int r13 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r12, (int) r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r14 = r0.aU
            r15 = r14[r10]
            if (r15 == 0) goto L_0x00c5
            r14 = r14[r10]
            int r14 = r14.A()
            if (r14 >= r13) goto L_0x00c9
        L_0x00c5:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r13 = r0.aU
            r13[r10] = r12
        L_0x00c9:
            int r13 = r0.b(r12, r4)
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r14 = r0.aT
            r15 = r14[r11]
            if (r15 == 0) goto L_0x00db
            r14 = r14[r11]
            int r14 = r14.B()
            if (r14 >= r13) goto L_0x00df
        L_0x00db:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r13 = r0.aT
            r13[r11] = r12
        L_0x00df:
            int r11 = r11 + 1
            goto L_0x00a0
        L_0x00e2:
            int r10 = r10 + 1
            goto L_0x009d
        L_0x00e5:
            r10 = 0
            r11 = 0
        L_0x00e7:
            if (r10 >= r7) goto L_0x00fc
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r12 = r0.aU
            r12 = r12[r10]
            if (r12 == 0) goto L_0x00f9
            if (r10 <= 0) goto L_0x00f4
            int r13 = r0.aL
            int r11 = r11 + r13
        L_0x00f4:
            int r12 = r0.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r12, (int) r4)
            int r11 = r11 + r12
        L_0x00f9:
            int r10 = r10 + 1
            goto L_0x00e7
        L_0x00fc:
            r10 = 0
            r12 = 0
        L_0x00fe:
            if (r10 >= r6) goto L_0x0113
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r13 = r0.aT
            r13 = r13[r10]
            if (r13 == 0) goto L_0x0110
            if (r10 <= 0) goto L_0x010b
            int r14 = r0.aM
            int r12 = r12 + r14
        L_0x010b:
            int r13 = r0.b(r13, r4)
            int r12 = r12 + r13
        L_0x0110:
            int r10 = r10 + 1
            goto L_0x00fe
        L_0x0113:
            r21[r5] = r11
            r21[r8] = r12
            if (r3 != 0) goto L_0x0121
            if (r11 <= r4) goto L_0x0061
            if (r7 <= r8) goto L_0x0061
            int r7 = r7 + -1
            goto L_0x0064
        L_0x0121:
            if (r12 <= r4) goto L_0x0061
            if (r6 <= r8) goto L_0x0061
            int r6 = r6 + -1
            goto L_0x0064
        L_0x0129:
            int[] r1 = r0.aV
            r1[r5] = r7
            r1[r8] = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.e.c(androidx.constraintlayout.solver.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void g(boolean z2) {
        ConstraintWidget constraintWidget;
        if (this.aV != null && this.aU != null && this.aT != null) {
            for (int i2 = 0; i2 < this.aX; i2++) {
                this.aW[i2].R();
            }
            int[] iArr = this.aV;
            int i3 = iArr[0];
            int i4 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            for (int i5 = 0; i5 < i3; i5++) {
                ConstraintWidget constraintWidget3 = this.aU[z2 ? (i3 - i5) - 1 : i5];
                if (!(constraintWidget3 == null || constraintWidget3.w() == 8)) {
                    if (i5 == 0) {
                        constraintWidget3.a(constraintWidget3.f2289y, this.f2289y, f());
                        constraintWidget3.t(this.f2422az);
                        constraintWidget3.a(this.aF);
                    }
                    if (i5 == i3 - 1) {
                        constraintWidget3.a(constraintWidget3.A, this.A, g());
                    }
                    if (i5 > 0) {
                        constraintWidget3.a(constraintWidget3.f2289y, constraintWidget2.A, this.aL);
                        constraintWidget2.a(constraintWidget2.A, constraintWidget3.f2289y, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
            }
            for (int i6 = 0; i6 < i4; i6++) {
                ConstraintWidget constraintWidget4 = this.aT[i6];
                if (!(constraintWidget4 == null || constraintWidget4.w() == 8)) {
                    if (i6 == 0) {
                        constraintWidget4.a(constraintWidget4.f2290z, this.f2290z, b());
                        constraintWidget4.u(this.aA);
                        constraintWidget4.b(this.aG);
                    }
                    if (i6 == i4 - 1) {
                        constraintWidget4.a(constraintWidget4.B, this.B, c());
                    }
                    if (i6 > 0) {
                        constraintWidget4.a(constraintWidget4.f2290z, constraintWidget2.B, this.aM);
                        constraintWidget2.a(constraintWidget2.B, constraintWidget4.f2290z, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i7 = 0; i7 < i3; i7++) {
                for (int i8 = 0; i8 < i4; i8++) {
                    int i9 = (i8 * i3) + i7;
                    if (this.aR == 1) {
                        i9 = (i7 * i4) + i8;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.aW;
                    if (!(i9 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i9]) == null || constraintWidget.w() == 8)) {
                        ConstraintWidget constraintWidget5 = this.aU[i7];
                        ConstraintWidget constraintWidget6 = this.aT[i8];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.a(constraintWidget.f2289y, constraintWidget5.f2289y, 0);
                            constraintWidget.a(constraintWidget.A, constraintWidget5.A, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.a(constraintWidget.f2290z, constraintWidget6.f2290z, 0);
                            constraintWidget.a(constraintWidget.B, constraintWidget6.B, 0);
                        }
                    }
                }
            }
        }
    }

    public void A(int i2) {
        this.aE = i2;
    }

    public void B(int i2) {
        this.f2422az = i2;
    }

    public void C(int i2) {
        this.aA = i2;
    }

    public void D(int i2) {
        this.aN = i2;
    }

    public void E(int i2) {
        this.aO = i2;
    }

    public void F(int i2) {
        this.aP = i2;
    }

    public void G(int i2) {
        this.aL = i2;
    }

    public void H(int i2) {
        this.aM = i2;
    }

    public void I(int i2) {
        this.aQ = i2;
    }

    public void a(int i2) {
        this.aR = i2;
    }

    public void a(d dVar, boolean z2) {
        super.a(dVar, z2);
        boolean Y = v() != null ? ((d) v()).Y() : false;
        int i2 = this.aP;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = this.aS.size();
                int i3 = 0;
                while (i3 < size) {
                    this.aS.get(i3).a(Y, i3, i3 == size + -1);
                    i3++;
                }
            } else if (i2 == 2) {
                g(Y);
            }
        } else if (this.aS.size() > 0) {
            this.aS.get(0).a(Y, 0, true);
        }
        f(false);
    }

    public void a(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.a(constraintWidget, hashMap);
        e eVar = (e) constraintWidget;
        this.f2422az = eVar.f2422az;
        this.aA = eVar.aA;
        this.aB = eVar.aB;
        this.aC = eVar.aC;
        this.aD = eVar.aD;
        this.aE = eVar.aE;
        this.aF = eVar.aF;
        this.aG = eVar.aG;
        this.aH = eVar.aH;
        this.aI = eVar.aI;
        this.aJ = eVar.aJ;
        this.aK = eVar.aK;
        this.aL = eVar.aL;
        this.aM = eVar.aM;
        this.aN = eVar.aN;
        this.aO = eVar.aO;
        this.aP = eVar.aP;
        this.aQ = eVar.aQ;
        this.aR = eVar.aR;
    }

    public void b(int i2) {
        this.aB = i2;
    }

    /* JADX WARNING: type inference failed for: r11v2 */
    /* JADX WARNING: type inference failed for: r11v9 */
    /* JADX WARNING: type inference failed for: r11v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        if (r6.aA == -1) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r6.aA == -1) goto L_0x0054;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r19, int r20, int r21, int r22) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = r20
            r9 = r21
            r10 = r22
            int r0 = r6.f2448ax
            r11 = 0
            if (r0 <= 0) goto L_0x001c
            boolean r0 = r18.Z()
            if (r0 != 0) goto L_0x001c
            r6.g(r11, r11)
            r6.f(r11)
            return
        L_0x001c:
            int r12 = r18.f()
            int r13 = r18.g()
            int r14 = r18.b()
            int r15 = r18.c()
            r0 = 2
            int[] r5 = new int[r0]
            int r1 = r8 - r12
            int r1 = r1 - r13
            int r2 = r6.aR
            r4 = 1
            if (r2 != r4) goto L_0x003a
            int r1 = r10 - r14
            int r1 = r1 - r15
        L_0x003a:
            r16 = r1
            r1 = -1
            if (r2 != 0) goto L_0x004a
            int r2 = r6.f2422az
            if (r2 != r1) goto L_0x0045
            r6.f2422az = r11
        L_0x0045:
            int r2 = r6.aA
            if (r2 != r1) goto L_0x0056
            goto L_0x0054
        L_0x004a:
            int r2 = r6.f2422az
            if (r2 != r1) goto L_0x0050
            r6.f2422az = r11
        L_0x0050:
            int r2 = r6.aA
            if (r2 != r1) goto L_0x0056
        L_0x0054:
            r6.aA = r11
        L_0x0056:
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = r6.f2447aw
            r2 = 0
            r3 = 0
        L_0x005a:
            int r11 = r6.f2448ax
            r0 = 8
            if (r2 >= r11) goto L_0x0070
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11 = r6.f2447aw
            r11 = r11[r2]
            int r11 = r11.w()
            if (r11 != r0) goto L_0x006c
            int r3 = r3 + 1
        L_0x006c:
            int r2 = r2 + 1
            r0 = 2
            goto L_0x005a
        L_0x0070:
            int r2 = r6.f2448ax
            if (r3 <= 0) goto L_0x0092
            int r1 = r6.f2448ax
            int r1 = r1 - r3
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r1 = new androidx.constraintlayout.solver.widgets.ConstraintWidget[r1]
            r2 = 0
            r3 = 0
        L_0x007b:
            int r11 = r6.f2448ax
            if (r2 >= r11) goto L_0x0091
            androidx.constraintlayout.solver.widgets.ConstraintWidget[] r11 = r6.f2447aw
            r11 = r11[r2]
            int r4 = r11.w()
            if (r4 == r0) goto L_0x008d
            r1[r3] = r11
            int r3 = r3 + 1
        L_0x008d:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x007b
        L_0x0091:
            r2 = r3
        L_0x0092:
            r6.aW = r1
            r6.aX = r2
            int r0 = r6.aP
            if (r0 == 0) goto L_0x00bf
            r4 = 1
            if (r0 == r4) goto L_0x00b2
            r3 = 2
            if (r0 == r3) goto L_0x00a5
            r17 = r5
            r0 = 0
            r11 = 1
            goto L_0x00cc
        L_0x00a5:
            int r3 = r6.aR
            r0 = r18
            r11 = 1
            r4 = r16
            r17 = r5
            r0.c(r1, r2, r3, r4, r5)
            goto L_0x00cb
        L_0x00b2:
            r17 = r5
            r11 = 1
            int r3 = r6.aR
            r0 = r18
            r4 = r16
            r0.a(r1, r2, r3, r4, r5)
            goto L_0x00cb
        L_0x00bf:
            r17 = r5
            r11 = 1
            int r3 = r6.aR
            r0 = r18
            r4 = r16
            r0.b(r1, r2, r3, r4, r5)
        L_0x00cb:
            r0 = 0
        L_0x00cc:
            r1 = r17[r0]
            int r1 = r1 + r12
            int r1 = r1 + r13
            r2 = r17[r11]
            int r2 = r2 + r14
            int r2 = r2 + r15
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r7 != r4) goto L_0x00dc
            r1 = r8
            goto L_0x00e7
        L_0x00dc:
            if (r7 != r3) goto L_0x00e3
            int r1 = java.lang.Math.min(r1, r8)
            goto L_0x00e7
        L_0x00e3:
            if (r7 != 0) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r1 = 0
        L_0x00e7:
            if (r9 != r4) goto L_0x00eb
            r2 = r10
            goto L_0x00f6
        L_0x00eb:
            if (r9 != r3) goto L_0x00f2
            int r2 = java.lang.Math.min(r2, r10)
            goto L_0x00f6
        L_0x00f2:
            if (r9 != 0) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r2 = 0
        L_0x00f6:
            r6.g(r1, r2)
            r6.o(r1)
            r6.p(r2)
            int r1 = r6.f2448ax
            if (r1 <= 0) goto L_0x0104
            goto L_0x0105
        L_0x0104:
            r11 = 0
        L_0x0105:
            r6.f(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.e.b(int, int, int, int):void");
    }

    public void e(float f2) {
        this.aF = f2;
    }

    public void f(float f2) {
        this.aG = f2;
    }

    public void g(float f2) {
        this.aH = f2;
    }

    public void h(float f2) {
        this.aI = f2;
    }

    public void i(float f2) {
        this.aJ = f2;
    }

    public void j(float f2) {
        this.aK = f2;
    }

    public void y(int i2) {
        this.aC = i2;
    }

    public void z(int i2) {
        this.aD = i2;
    }
}
