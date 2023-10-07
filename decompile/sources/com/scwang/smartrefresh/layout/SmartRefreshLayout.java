package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import ja.e;
import ja.f;
import ja.g;
import ja.h;
import ja.i;
import ja.j;
import ja.k;
import jb.d;
import t.p;
import t.q;
import t.t;

public class SmartRefreshLayout extends ViewGroup implements j, q {
    protected static ja.a aI;
    protected static ja.b aJ;
    protected static ja.c aK;
    protected static ViewGroup.MarginLayoutParams aL = new ViewGroup.MarginLayoutParams(-1, -1);
    protected boolean A;
    protected boolean B;
    protected boolean C;
    protected boolean D;
    protected boolean E;
    protected boolean F;
    protected boolean G;
    protected boolean H;
    protected boolean I;
    protected boolean J;
    protected boolean K;
    protected boolean L;
    protected boolean M;
    protected boolean N;
    protected boolean O;
    protected boolean P;
    protected boolean Q;
    protected boolean R;
    protected boolean S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected boolean W;

    /* renamed from: a  reason: collision with root package name */
    protected int f11972a;
    protected RefreshState aA;
    protected long aB;
    protected int aC;
    protected int aD;
    protected boolean aE;
    protected boolean aF;
    protected boolean aG;
    protected boolean aH;
    protected boolean aM;
    protected MotionEvent aN;
    protected Runnable aO;
    protected ValueAnimator aP;

    /* renamed from: aa  reason: collision with root package name */
    protected d f11973aa;

    /* renamed from: ab  reason: collision with root package name */
    protected jb.b f11974ab;

    /* renamed from: ac  reason: collision with root package name */
    protected jb.c f11975ac;

    /* renamed from: ad  reason: collision with root package name */
    protected k f11976ad;

    /* renamed from: ae  reason: collision with root package name */
    protected int f11977ae;

    /* renamed from: af  reason: collision with root package name */
    protected boolean f11978af;

    /* renamed from: ag  reason: collision with root package name */
    protected int[] f11979ag;

    /* renamed from: ah  reason: collision with root package name */
    protected p f11980ah;

    /* renamed from: ai  reason: collision with root package name */
    protected t f11981ai;

    /* renamed from: aj  reason: collision with root package name */
    protected int f11982aj;

    /* renamed from: ak  reason: collision with root package name */
    protected com.scwang.smartrefresh.layout.constant.a f11983ak;

    /* renamed from: al  reason: collision with root package name */
    protected int f11984al;

    /* renamed from: am  reason: collision with root package name */
    protected com.scwang.smartrefresh.layout.constant.a f11985am;

    /* renamed from: an  reason: collision with root package name */
    protected int f11986an;

    /* renamed from: ao  reason: collision with root package name */
    protected int f11987ao;

    /* renamed from: ap  reason: collision with root package name */
    protected float f11988ap;

    /* renamed from: aq  reason: collision with root package name */
    protected float f11989aq;

    /* renamed from: ar  reason: collision with root package name */
    protected float f11990ar;

    /* renamed from: as  reason: collision with root package name */
    protected float f11991as;

    /* renamed from: at  reason: collision with root package name */
    protected h f11992at;

    /* renamed from: au  reason: collision with root package name */
    protected h f11993au;

    /* renamed from: av  reason: collision with root package name */
    protected e f11994av;

    /* renamed from: aw  reason: collision with root package name */
    protected Paint f11995aw;

    /* renamed from: ax  reason: collision with root package name */
    protected Handler f11996ax;

    /* renamed from: ay  reason: collision with root package name */
    protected i f11997ay;

    /* renamed from: az  reason: collision with root package name */
    protected RefreshState f11998az;

    /* renamed from: b  reason: collision with root package name */
    protected int f11999b;

    /* renamed from: c  reason: collision with root package name */
    protected int f12000c;

    /* renamed from: d  reason: collision with root package name */
    protected int f12001d;

    /* renamed from: e  reason: collision with root package name */
    protected int f12002e;

    /* renamed from: f  reason: collision with root package name */
    protected int f12003f;

    /* renamed from: g  reason: collision with root package name */
    protected int f12004g;

    /* renamed from: h  reason: collision with root package name */
    protected float f12005h;

    /* renamed from: i  reason: collision with root package name */
    protected float f12006i;

    /* renamed from: j  reason: collision with root package name */
    protected float f12007j;

    /* renamed from: k  reason: collision with root package name */
    protected float f12008k;

    /* renamed from: l  reason: collision with root package name */
    protected float f12009l;

    /* renamed from: m  reason: collision with root package name */
    protected char f12010m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f12011n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f12012o;

    /* renamed from: p  reason: collision with root package name */
    protected int f12013p;

    /* renamed from: q  reason: collision with root package name */
    protected int f12014q;

    /* renamed from: r  reason: collision with root package name */
    protected int f12015r;

    /* renamed from: s  reason: collision with root package name */
    protected int f12016s;

    /* renamed from: t  reason: collision with root package name */
    protected int f12017t;

    /* renamed from: u  reason: collision with root package name */
    protected int f12018u;

    /* renamed from: v  reason: collision with root package name */
    protected int f12019v;

    /* renamed from: w  reason: collision with root package name */
    protected Scroller f12020w;

    /* renamed from: x  reason: collision with root package name */
    protected VelocityTracker f12021x;

    /* renamed from: y  reason: collision with root package name */
    protected Interpolator f12022y;

    /* renamed from: z  reason: collision with root package name */
    protected int[] f12023z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f12041a = 0;

        /* renamed from: b  reason: collision with root package name */
        public com.scwang.smartrefresh.layout.constant.b f12042b = null;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f12041a = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f12041a);
            if (obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.f12042b = com.scwang.smartrefresh.layout.constant.b.f12104f[obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, com.scwang.smartrefresh.layout.constant.b.f12099a.f12105g)];
            }
            obtainStyledAttributes.recycle();
        }
    }

    protected class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f12043a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f12044b = 10;

        /* renamed from: c  reason: collision with root package name */
        int f12045c;

        /* renamed from: d  reason: collision with root package name */
        long f12046d;

        /* renamed from: e  reason: collision with root package name */
        float f12047e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        float f12048f;

        a(float f2, int i2) {
            this.f12048f = f2;
            this.f12045c = i2;
            this.f12046d = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.f11996ax.postDelayed(this, (long) this.f12044b);
            SmartRefreshLayout.this.f11997ay.a(f2 > 0.0f ? RefreshState.PullDownToRefresh : RefreshState.PullUpToLoad);
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                java.lang.Runnable r0 = r0.aO
                if (r0 != r6) goto L_0x00f2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                boolean r0 = r0.f12082w
                if (r0 != 0) goto L_0x00f2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11999b
                int r0 = java.lang.Math.abs(r0)
                int r1 = r6.f12045c
                int r1 = java.lang.Math.abs(r1)
                if (r0 < r1) goto L_0x0034
                int r0 = r6.f12045c
                if (r0 == 0) goto L_0x002b
                float r0 = r6.f12048f
                double r0 = (double) r0
                r2 = 4601778099032424448(0x3fdcccccc0000000, double:0.44999998807907104)
                goto L_0x003c
            L_0x002b:
                float r0 = r6.f12048f
                double r0 = (double) r0
                r2 = 4605831339126554624(0x3feb333340000000, double:0.8500000238418579)
                goto L_0x003c
            L_0x0034:
                float r0 = r6.f12048f
                double r0 = (double) r0
                r2 = 4606732058729906176(0x3fee666660000000, double:0.949999988079071)
            L_0x003c:
                int r4 = r6.f12043a
                int r4 = r4 + 1
                r6.f12043a = r4
                int r4 = r4 * 2
                double r4 = (double) r4
                double r2 = java.lang.Math.pow(r2, r4)
                java.lang.Double.isNaN(r0)
                double r0 = r0 * r2
                float r0 = (float) r0
                r6.f12048f = r0
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                long r2 = r6.f12046d
                long r2 = r0 - r2
                float r2 = (float) r2
                r3 = 1065353216(0x3f800000, float:1.0)
                float r2 = r2 * r3
                r4 = 1148846080(0x447a0000, float:1000.0)
                float r2 = r2 / r4
                float r4 = r6.f12048f
                float r4 = r4 * r2
                float r2 = java.lang.Math.abs(r4)
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 < 0) goto L_0x0084
                r6.f12046d = r0
                float r0 = r6.f12047e
                float r0 = r0 + r4
                r6.f12047e = r0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                r1.c((float) r0)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.f11996ax
                int r1 = r6.f12044b
                long r1 = (long) r1
                r0.postDelayed(r6, r1)
                goto L_0x00f2
            L_0x0084:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.aA
                boolean r0 = r0.f12080u
                if (r0 == 0) goto L_0x009e
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.aA
                boolean r0 = r0.f12077r
                if (r0 == 0) goto L_0x009e
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.i r0 = r0.f11997ay
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled
            L_0x009a:
                r0.a((com.scwang.smartrefresh.layout.constant.RefreshState) r1)
                goto L_0x00b5
            L_0x009e:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.aA
                boolean r0 = r0.f12080u
                if (r0 == 0) goto L_0x00b5
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.aA
                boolean r0 = r0.f12078s
                if (r0 == 0) goto L_0x00b5
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.i r0 = r0.f11997ay
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpCanceled
                goto L_0x009a
            L_0x00b5:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                r1 = 0
                r0.aO = r1
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11999b
                int r0 = java.lang.Math.abs(r0)
                int r1 = r6.f12045c
                int r1 = java.lang.Math.abs(r1)
                if (r0 < r1) goto L_0x00f2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11999b
                int r1 = r6.f12045c
                int r0 = r0 - r1
                int r0 = java.lang.Math.abs(r0)
                float r0 = jc.b.a((int) r0)
                int r0 = (int) r0
                r1 = 30
                int r0 = java.lang.Math.max(r0, r1)
                r1 = 100
                int r0 = java.lang.Math.min(r0, r1)
                int r0 = r0 * 10
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r6.f12045c
                r3 = 0
                android.view.animation.Interpolator r4 = r1.f12022y
                r1.a(r2, r3, r4, r0)
            L_0x00f2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.a.run():void");
        }
    }

    protected class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f12050a;

        /* renamed from: b  reason: collision with root package name */
        int f12051b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f12052c = 10;

        /* renamed from: d  reason: collision with root package name */
        float f12053d;

        /* renamed from: e  reason: collision with root package name */
        float f12054e = 0.98f;

        /* renamed from: f  reason: collision with root package name */
        long f12055f = 0;

        /* renamed from: g  reason: collision with root package name */
        long f12056g = AnimationUtils.currentAnimationTimeMillis();

        b(float f2) {
            this.f12053d = f2;
            this.f12050a = SmartRefreshLayout.this.f11999b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
            if (r0.a(r0.B) != false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
            if (r0.a(r0.B) != false) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
            if (r10.f12057h.f11999b >= (-r10.f12057h.f11984al)) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0073, code lost:
            if (r10.f12057h.f11999b > r10.f12057h.f11982aj) goto L_0x0075;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Runnable a() {
            /*
                r10 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                boolean r0 = r0.f12082w
                r1 = 0
                if (r0 == 0) goto L_0x000a
                return r1
            L_0x000a:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11999b
                if (r0 == 0) goto L_0x00db
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                boolean r0 = r0.f12081v
                if (r0 != 0) goto L_0x0034
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.S
                if (r0 == 0) goto L_0x0075
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.G
                if (r0 == 0) goto L_0x0075
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.T
                if (r0 == 0) goto L_0x0075
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r0.B
                boolean r0 = r0.a((boolean) r2)
                if (r0 == 0) goto L_0x0075
            L_0x0034:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                if (r0 == r2) goto L_0x0058
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.S
                if (r0 == 0) goto L_0x0063
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.G
                if (r0 == 0) goto L_0x0063
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r0.T
                if (r0 == 0) goto L_0x0063
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r0.B
                boolean r0 = r0.a((boolean) r2)
                if (r0 == 0) goto L_0x0063
            L_0x0058:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11999b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11984al
                int r2 = -r2
                if (r0 < r2) goto L_0x0075
            L_0x0063:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r0 != r2) goto L_0x00db
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11999b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11982aj
                if (r0 <= r2) goto L_0x00db
            L_0x0075:
                r0 = 0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.f11999b
                float r4 = r10.f12053d
            L_0x0080:
                int r5 = r3 * r2
                if (r5 <= 0) goto L_0x00db
                double r4 = (double) r4
                float r6 = r10.f12054e
                double r6 = (double) r6
                int r0 = r0 + 1
                int r8 = r10.f12052c
                int r8 = r8 * r0
                float r8 = (float) r8
                r9 = 1092616192(0x41200000, float:10.0)
                float r8 = r8 / r9
                double r8 = (double) r8
                double r6 = java.lang.Math.pow(r6, r8)
                java.lang.Double.isNaN(r4)
                double r4 = r4 * r6
                float r4 = (float) r4
                int r5 = r10.f12052c
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r4
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto L_0x00d7
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                boolean r0 = r0.f12081v
                if (r0 == 0) goto L_0x00d6
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r0 != r3) goto L_0x00c7
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11982aj
                if (r2 > r0) goto L_0x00d6
            L_0x00c7:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = r0.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r0 == r3) goto L_0x00db
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.f11984al
                int r0 = -r0
                if (r2 >= r0) goto L_0x00db
            L_0x00d6:
                return r1
            L_0x00d7:
                float r2 = (float) r2
                float r2 = r2 + r5
                int r2 = (int) r2
                goto L_0x0080
            L_0x00db:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r10.f12055f = r0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.f11996ax
                int r1 = r10.f12052c
                long r1 = (long) r1
                r0.postDelayed(r10, r1)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.b.a():java.lang.Runnable");
        }

        public void run() {
            if (SmartRefreshLayout.this.aO == this && !SmartRefreshLayout.this.f11998az.f12082w) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                double d2 = (double) this.f12053d;
                double pow = Math.pow((double) this.f12054e, (double) (((float) (currentAnimationTimeMillis - this.f12055f)) / (1000.0f / ((float) this.f12052c))));
                Double.isNaN(d2);
                float f2 = (float) (d2 * pow);
                this.f12053d = f2;
                float f3 = f2 * ((((float) (currentAnimationTimeMillis - this.f12056g)) * 1.0f) / 1000.0f);
                if (Math.abs(f3) > 1.0f) {
                    this.f12056g = currentAnimationTimeMillis;
                    this.f12050a = (int) (((float) this.f12050a) + f3);
                    if (SmartRefreshLayout.this.f11999b * this.f12050a > 0) {
                        SmartRefreshLayout.this.f11997ay.a(this.f12050a, true);
                        SmartRefreshLayout.this.f11996ax.postDelayed(this, (long) this.f12052c);
                        return;
                    }
                    SmartRefreshLayout.this.aO = null;
                    SmartRefreshLayout.this.f11997ay.a(0, true);
                    jc.b.a(SmartRefreshLayout.this.f11994av.b(), (int) (-this.f12053d));
                    if (SmartRefreshLayout.this.aH && f3 > 0.0f) {
                        SmartRefreshLayout.this.aH = false;
                        return;
                    }
                    return;
                }
                SmartRefreshLayout.this.aO = null;
            }
        }
    }

    public class c implements i {
        public c() {
        }

        public ValueAnimator a(int i2) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.a(i2, 0, smartRefreshLayout.f12022y, SmartRefreshLayout.this.f12003f);
        }

        /* JADX WARNING: Removed duplicated region for block: B:53:0x00ea  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00f3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ja.i a(int r19, boolean r20) {
            /*
                r18 = this;
                r0 = r18
                r1 = r19
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                if (r2 != r1) goto L_0x002b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                if (r2 == 0) goto L_0x001a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                boolean r2 = r2.a()
                if (r2 != 0) goto L_0x002b
            L_0x001a:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11993au
                if (r2 == 0) goto L_0x002a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11993au
                boolean r2 = r2.a()
                if (r2 != 0) goto L_0x002b
            L_0x002a:
                return r0
            L_0x002b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r9 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r10 = r9.f11999b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                r2.f11999b = r1
                if (r20 == 0) goto L_0x00ad
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.aA
                boolean r2 = r2.f12080u
                if (r2 != 0) goto L_0x0045
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.aA
                boolean r2 = r2.f12081v
                if (r2 == 0) goto L_0x00ad
            L_0x0045:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                float r2 = (float) r2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.f11982aj
                float r3 = (float) r3
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r4 = r4.f11990ar
                float r3 = r3 * r4
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x006b
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel
                if (r2 == r3) goto L_0x00ad
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.i r2 = r2.f11997ay
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh
            L_0x0067:
                r2.a((com.scwang.smartrefresh.layout.constant.RefreshState) r3)
                goto L_0x00ad
            L_0x006b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                int r2 = -r2
                float r2 = (float) r2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.f11984al
                float r3 = (float) r3
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r4 = r4.f11991as
                float r3 = r3 * r4
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x008d
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.S
                if (r2 != 0) goto L_0x008d
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.i r2 = r2.f11997ay
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad
                goto L_0x0067
            L_0x008d:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                if (r2 >= 0) goto L_0x00a0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.S
                if (r2 != 0) goto L_0x00a0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.i r2 = r2.f11997ay
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
                goto L_0x0067
            L_0x00a0:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                if (r2 <= 0) goto L_0x00ad
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.i r2 = r2.f11997ay
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
                goto L_0x0067
            L_0x00ad:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.e r2 = r2.f11994av
                r11 = 1
                r12 = 0
                if (r2 == 0) goto L_0x019f
                if (r1 < 0) goto L_0x00d2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                if (r2 == 0) goto L_0x00d2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r2.E
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r4 = r4.f11992at
                boolean r2 = r2.a((boolean) r3, (ja.h) r4)
                if (r2 == 0) goto L_0x00ce
                r2 = r1
            L_0x00cc:
                r3 = 1
                goto L_0x00d4
            L_0x00ce:
                if (r10 >= 0) goto L_0x00d2
                r2 = 0
                goto L_0x00cc
            L_0x00d2:
                r2 = 0
                r3 = 0
            L_0x00d4:
                if (r1 > 0) goto L_0x00f1
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r4 = r4.f11993au
                if (r4 == 0) goto L_0x00f1
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r5 = r4.F
                com.scwang.smartrefresh.layout.SmartRefreshLayout r6 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r6 = r6.f11993au
                boolean r4 = r4.a((boolean) r5, (ja.h) r6)
                if (r4 == 0) goto L_0x00ed
                r2 = r1
            L_0x00eb:
                r3 = 1
                goto L_0x00f1
            L_0x00ed:
                if (r10 <= 0) goto L_0x00f1
                r2 = 0
                goto L_0x00eb
            L_0x00f1:
                if (r3 == 0) goto L_0x019f
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.e r3 = r3.f11994av
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r4 = r4.f12015r
                com.scwang.smartrefresh.layout.SmartRefreshLayout r5 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r5 = r5.f12016s
                r3.a((int) r2, (int) r4, (int) r5)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.S
                if (r3 == 0) goto L_0x0142
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.T
                if (r3 == 0) goto L_0x0142
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.G
                if (r3 == 0) goto L_0x0142
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r3 = r3.f11993au
                boolean r3 = r3 instanceof ja.f
                if (r3 == 0) goto L_0x0142
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r3 = r3.f11993au
                com.scwang.smartrefresh.layout.constant.b r3 = r3.getSpinnerStyle()
                com.scwang.smartrefresh.layout.constant.b r4 = com.scwang.smartrefresh.layout.constant.b.f12099a
                if (r3 != r4) goto L_0x0142
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r4 = r3.B
                boolean r3 = r3.a((boolean) r4)
                if (r3 == 0) goto L_0x0142
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r3 = r3.f11993au
                android.view.View r3 = r3.getView()
                int r4 = java.lang.Math.max(r12, r2)
                float r4 = (float) r4
                r3.setTranslationY(r4)
            L_0x0142:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r3.C
                if (r3 == 0) goto L_0x015c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r3 = r3.f11992at
                if (r3 == 0) goto L_0x015c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r3 = r3.f11992at
                com.scwang.smartrefresh.layout.constant.b r3 = r3.getSpinnerStyle()
                com.scwang.smartrefresh.layout.constant.b r4 = com.scwang.smartrefresh.layout.constant.b.f12101c
                if (r3 != r4) goto L_0x015c
                r3 = 1
                goto L_0x015d
            L_0x015c:
                r3 = 0
            L_0x015d:
                if (r3 != 0) goto L_0x0168
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.aC
                if (r3 == 0) goto L_0x0166
                goto L_0x0168
            L_0x0166:
                r3 = 0
                goto L_0x0169
            L_0x0168:
                r3 = 1
            L_0x0169:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r4 = r4.D
                if (r4 == 0) goto L_0x0183
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r4 = r4.f11993au
                if (r4 == 0) goto L_0x0183
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r4 = r4.f11993au
                com.scwang.smartrefresh.layout.constant.b r4 = r4.getSpinnerStyle()
                com.scwang.smartrefresh.layout.constant.b r5 = com.scwang.smartrefresh.layout.constant.b.f12101c
                if (r4 != r5) goto L_0x0183
                r4 = 1
                goto L_0x0184
            L_0x0183:
                r4 = 0
            L_0x0184:
                if (r4 != 0) goto L_0x018f
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r4 = r4.aD
                if (r4 == 0) goto L_0x018d
                goto L_0x018f
            L_0x018d:
                r4 = 0
                goto L_0x0190
            L_0x018f:
                r4 = 1
            L_0x0190:
                if (r3 == 0) goto L_0x0196
                if (r2 >= 0) goto L_0x019c
                if (r10 > 0) goto L_0x019c
            L_0x0196:
                if (r4 == 0) goto L_0x019f
                if (r2 <= 0) goto L_0x019c
                if (r10 >= 0) goto L_0x019f
            L_0x019c:
                r9.invalidate()
            L_0x019f:
                r13 = 1065353216(0x3f800000, float:1.0)
                r14 = 1073741824(0x40000000, float:2.0)
                if (r1 >= 0) goto L_0x01a7
                if (r10 <= 0) goto L_0x02e2
            L_0x01a7:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                if (r2 == 0) goto L_0x02e2
                int r8 = java.lang.Math.max(r1, r12)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r15 = r2.f11982aj
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11982aj
                float r2 = (float) r2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r3 = r3.f11988ap
                float r2 = r2 * r3
                int r7 = (int) r2
                float r2 = (float) r8
                float r2 = r2 * r13
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.f11982aj
                if (r3 != 0) goto L_0x01cc
                r3 = 1
                goto L_0x01d0
            L_0x01cc:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.f11982aj
            L_0x01d0:
                float r3 = (float) r3
                float r16 = r2 / r3
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r2.A
                boolean r2 = r2.a((boolean) r3)
                if (r2 != 0) goto L_0x01ec
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish
                if (r2 != r3) goto L_0x01e8
                if (r20 != 0) goto L_0x01e8
                goto L_0x01ec
            L_0x01e8:
                r17 = r7
                goto L_0x02b9
            L_0x01ec:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                if (r10 == r2) goto L_0x0290
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                com.scwang.smartrefresh.layout.constant.b r2 = r2.getSpinnerStyle()
                com.scwang.smartrefresh.layout.constant.b r3 = com.scwang.smartrefresh.layout.constant.b.f12099a
                if (r2 != r3) goto L_0x022c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                android.view.View r2 = r2.getView()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r3 = r3.f11999b
                float r3 = (float) r3
                r2.setTranslationY(r3)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.aC
                if (r2 == 0) goto L_0x0280
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.graphics.Paint r2 = r2.f11995aw
                if (r2 == 0) goto L_0x0280
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r3 = r2.E
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r4 = r4.f11992at
                boolean r2 = r2.a((boolean) r3, (ja.h) r4)
                if (r2 != 0) goto L_0x0280
                r9.invalidate()
                goto L_0x0280
            L_0x022c:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                com.scwang.smartrefresh.layout.constant.b r2 = r2.getSpinnerStyle()
                boolean r2 = r2.f12107i
                if (r2 == 0) goto L_0x0280
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                android.view.View r2 = r2.getView()
                android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
                boolean r4 = r3 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r4 == 0) goto L_0x024b
                android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
                goto L_0x024d
            L_0x024b:
                android.view.ViewGroup$MarginLayoutParams r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.aL
            L_0x024d:
                int r4 = r2.getMeasuredWidth()
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r14)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r5 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r5 = r5.f11999b
                int r6 = r3.bottomMargin
                int r5 = r5 - r6
                int r6 = r3.topMargin
                int r5 = r5 - r6
                int r5 = java.lang.Math.max(r5, r12)
                int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r14)
                r2.measure(r4, r5)
                int r4 = r3.leftMargin
                int r3 = r3.topMargin
                com.scwang.smartrefresh.layout.SmartRefreshLayout r5 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r5 = r5.f11986an
                int r3 = r3 + r5
                int r5 = r2.getMeasuredWidth()
                int r5 = r5 + r4
                int r6 = r2.getMeasuredHeight()
                int r6 = r6 + r3
                r2.layout(r4, r3, r5, r6)
            L_0x0280:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                r3 = r20
                r4 = r16
                r5 = r8
                r6 = r15
                r17 = r7
                r2.a(r3, r4, r5, r6, r7)
                goto L_0x0292
            L_0x0290:
                r17 = r7
            L_0x0292:
                if (r20 == 0) goto L_0x02b9
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                boolean r2 = r2.a()
                if (r2 == 0) goto L_0x02b9
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r2 = r2.f12007j
                int r2 = (int) r2
                int r3 = r9.getWidth()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r4 = r4.f12007j
                if (r3 != 0) goto L_0x02af
                r5 = 1
                goto L_0x02b0
            L_0x02af:
                r5 = r3
            L_0x02b0:
                float r5 = (float) r5
                float r4 = r4 / r5
                com.scwang.smartrefresh.layout.SmartRefreshLayout r5 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r5 = r5.f11992at
                r5.a((float) r4, (int) r2, (int) r3)
            L_0x02b9:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                if (r10 == r2) goto L_0x02e2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                jb.c r2 = r2.f11975ac
                if (r2 == 0) goto L_0x02e2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11992at
                boolean r2 = r2 instanceof ja.g
                if (r2 == 0) goto L_0x02e2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                jb.c r2 = r2.f11975ac
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r3 = r3.f11992at
                ja.g r3 = (ja.g) r3
                r4 = r20
                r5 = r16
                r6 = r8
                r7 = r15
                r8 = r17
                r2.a((ja.g) r3, (boolean) r4, (float) r5, (int) r6, (int) r7, (int) r8)
            L_0x02e2:
                if (r1 <= 0) goto L_0x02e6
                if (r10 >= 0) goto L_0x041c
            L_0x02e6:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11993au
                if (r2 == 0) goto L_0x041c
                int r1 = java.lang.Math.min(r1, r12)
                int r7 = -r1
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r8 = r1.f11984al
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.f11984al
                float r1 = (float) r1
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r2 = r2.f11989aq
                float r1 = r1 * r2
                int r15 = (int) r1
                float r1 = (float) r7
                float r1 = r1 * r13
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11984al
                if (r2 != 0) goto L_0x030c
                r2 = 1
                goto L_0x0310
            L_0x030c:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11984al
            L_0x0310:
                float r2 = (float) r2
                float r13 = r1 / r2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r1.B
                boolean r1 = r1.a((boolean) r2)
                if (r1 != 0) goto L_0x0327
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r1.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadFinish
                if (r1 != r2) goto L_0x03f5
                if (r20 != 0) goto L_0x03f5
            L_0x0327:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.f11999b
                if (r10 == r1) goto L_0x03cf
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r1 = r1.f11993au
                com.scwang.smartrefresh.layout.constant.b r1 = r1.getSpinnerStyle()
                com.scwang.smartrefresh.layout.constant.b r2 = com.scwang.smartrefresh.layout.constant.b.f12099a
                if (r1 != r2) goto L_0x0367
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r1 = r1.f11993au
                android.view.View r1 = r1.getView()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                float r2 = (float) r2
                r1.setTranslationY(r2)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.aD
                if (r1 == 0) goto L_0x03c2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.graphics.Paint r1 = r1.f11995aw
                if (r1 == 0) goto L_0x03c2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r1.F
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r3 = r3.f11993au
                boolean r1 = r1.a((boolean) r2, (ja.h) r3)
                if (r1 != 0) goto L_0x03c2
                r9.invalidate()
                goto L_0x03c2
            L_0x0367:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r1 = r1.f11993au
                com.scwang.smartrefresh.layout.constant.b r1 = r1.getSpinnerStyle()
                boolean r1 = r1.f12107i
                if (r1 == 0) goto L_0x03c2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r1 = r1.f11993au
                android.view.View r1 = r1.getView()
                android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
                boolean r3 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
                if (r3 == 0) goto L_0x0386
                android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                goto L_0x0388
            L_0x0386:
                android.view.ViewGroup$MarginLayoutParams r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.aL
            L_0x0388:
                int r3 = r1.getMeasuredWidth()
                int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r14)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r4 = r4.f11999b
                int r4 = -r4
                int r5 = r2.bottomMargin
                int r4 = r4 - r5
                int r5 = r2.topMargin
                int r4 = r4 - r5
                int r4 = java.lang.Math.max(r4, r12)
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r14)
                r1.measure(r3, r4)
                int r3 = r2.leftMargin
                int r2 = r2.topMargin
                int r4 = r9.getMeasuredHeight()
                int r2 = r2 + r4
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r4 = r4.f11987ao
                int r2 = r2 - r4
                int r4 = r1.getMeasuredHeight()
                int r4 = r2 - r4
                int r5 = r1.getMeasuredWidth()
                int r5 = r5 + r3
                r1.layout(r3, r4, r5, r2)
            L_0x03c2:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r1 = r1.f11993au
                r2 = r20
                r3 = r13
                r4 = r7
                r5 = r8
                r6 = r15
                r1.a(r2, r3, r4, r5, r6)
            L_0x03cf:
                if (r20 == 0) goto L_0x03f5
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r1 = r1.f11993au
                boolean r1 = r1.a()
                if (r1 == 0) goto L_0x03f5
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r1 = r1.f12007j
                int r1 = (int) r1
                int r2 = r9.getWidth()
                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                float r3 = r3.f12007j
                if (r2 != 0) goto L_0x03eb
                goto L_0x03ec
            L_0x03eb:
                r11 = r2
            L_0x03ec:
                float r4 = (float) r11
                float r3 = r3 / r4
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r4 = r4.f11993au
                r4.a((float) r3, (int) r1, (int) r2)
            L_0x03f5:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.f11999b
                if (r10 == r1) goto L_0x041c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                jb.c r1 = r1.f11975ac
                if (r1 == 0) goto L_0x041c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r1 = r1.f11993au
                boolean r1 = r1 instanceof ja.f
                if (r1 == 0) goto L_0x041c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                jb.c r1 = r1.f11975ac
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                ja.h r2 = r2.f11993au
                ja.f r2 = (ja.f) r2
                r3 = r20
                r4 = r13
                r5 = r7
                r6 = r8
                r7 = r15
                r1.a((ja.f) r2, (boolean) r3, (float) r4, (int) r5, (int) r6, (int) r7)
            L_0x041c:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.c.a(int, boolean):ja.i");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
            return null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
            r2.a(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x013b, code lost:
            r2.a(r0);
            a(com.scwang.smartrefresh.layout.constant.RefreshState.None);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x019d, code lost:
            r2.setViceState(r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ja.i a(com.scwang.smartrefresh.layout.constant.RefreshState r2) {
            /*
                r1 = this;
                int[] r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass2.f21555a
                int r2 = r2.ordinal()
                r2 = r0[r2]
                r0 = 1
                switch(r2) {
                    case 1: goto L_0x01a1;
                    case 2: goto L_0x0181;
                    case 3: goto L_0x014a;
                    case 4: goto L_0x0125;
                    case 5: goto L_0x00f6;
                    case 6: goto L_0x00d8;
                    case 7: goto L_0x00a0;
                    case 8: goto L_0x0083;
                    case 9: goto L_0x0066;
                    case 10: goto L_0x0049;
                    case 11: goto L_0x0042;
                    case 12: goto L_0x003b;
                    case 13: goto L_0x002e;
                    case 14: goto L_0x0021;
                    case 15: goto L_0x0018;
                    case 16: goto L_0x0013;
                    case 17: goto L_0x000e;
                    default: goto L_0x000c;
                }
            L_0x000c:
                goto L_0x01bf
            L_0x000e:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel
                goto L_0x001c
            L_0x0013:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelFinish
                goto L_0x001c
            L_0x0018:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelReleased
            L_0x001c:
                r2.a((com.scwang.smartrefresh.layout.constant.RefreshState) r0)
                goto L_0x01bf
            L_0x0021:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                if (r2 != r0) goto L_0x01bf
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadFinish
                goto L_0x001c
            L_0x002e:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r2 != r0) goto L_0x01bf
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish
                goto L_0x001c
            L_0x003b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                r2.setStateLoading(r0)
                goto L_0x01bf
            L_0x0042:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                r2.setStateRefreshing(r0)
                goto L_0x01bf
            L_0x0049:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x0060
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.B
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x0060
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased
                goto L_0x001c
            L_0x0060:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased
                goto L_0x019d
            L_0x0066:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x007d
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.A
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x007d
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshReleased
                goto L_0x001c
            L_0x007d:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshReleased
                goto L_0x019d
            L_0x0083:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x009a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.A
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x009a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel
                goto L_0x001c
            L_0x009a:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel
                goto L_0x019d
            L_0x00a0:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.B
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x00d2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x00d2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12082w
                if (r2 != 0) goto L_0x00d2
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.S
                if (r2 == 0) goto L_0x00cc
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.G
                if (r2 == 0) goto L_0x00cc
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.T
                if (r2 != 0) goto L_0x00d2
            L_0x00cc:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad
                goto L_0x001c
            L_0x00d2:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad
                goto L_0x019d
            L_0x00d8:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x00f0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.A
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x00f0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh
                goto L_0x001c
            L_0x00f0:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh
                goto L_0x019d
            L_0x00f6:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.B
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x011f
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x011f
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.S
                if (r2 == 0) goto L_0x011a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.G
                if (r2 == 0) goto L_0x011a
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.T
                if (r2 != 0) goto L_0x011f
            L_0x011a:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpCanceled
                goto L_0x013b
            L_0x011f:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpCanceled
                goto L_0x019d
            L_0x0125:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x0145
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.A
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x0145
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled
            L_0x013b:
                r2.a((com.scwang.smartrefresh.layout.constant.RefreshState) r0)
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.None
                r1.a((com.scwang.smartrefresh.layout.constant.RefreshState) r2)
                goto L_0x01bf
            L_0x0145:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled
                goto L_0x019d
            L_0x014a:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.B
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x017c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x017c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12082w
                if (r2 != 0) goto L_0x017c
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.S
                if (r2 == 0) goto L_0x0176
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.G
                if (r2 == 0) goto L_0x0176
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r2 = r2.T
                if (r2 != 0) goto L_0x017c
            L_0x0176:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
                goto L_0x001c
            L_0x017c:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
                goto L_0x019d
            L_0x0181:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                boolean r2 = r2.f12081v
                if (r2 != 0) goto L_0x0199
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                boolean r0 = r2.A
                boolean r2 = r2.a((boolean) r0)
                if (r2 == 0) goto L_0x0199
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
                goto L_0x001c
            L_0x0199:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
            L_0x019d:
                r2.setViceState(r0)
                goto L_0x01bf
            L_0x01a1:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r2.f11998az
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.None
                if (r2 == r0) goto L_0x01b5
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                if (r2 != 0) goto L_0x01b5
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.None
                goto L_0x001c
            L_0x01b5:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r2 = r2.f11999b
                if (r2 == 0) goto L_0x01bf
                r2 = 0
                r1.a((int) r2)
            L_0x01bf:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.c.a(com.scwang.smartrefresh.layout.constant.RefreshState):ja.i");
        }

        public i a(h hVar, int i2) {
            if (SmartRefreshLayout.this.f11995aw == null && i2 != 0) {
                SmartRefreshLayout.this.f11995aw = new Paint();
            }
            if (hVar.equals(SmartRefreshLayout.this.f11992at)) {
                SmartRefreshLayout.this.aC = i2;
            } else if (hVar.equals(SmartRefreshLayout.this.f11993au)) {
                SmartRefreshLayout.this.aD = i2;
            }
            return this;
        }

        public i a(h hVar, boolean z2) {
            if (hVar.equals(SmartRefreshLayout.this.f11992at)) {
                SmartRefreshLayout.this.aE = z2;
            } else if (hVar.equals(SmartRefreshLayout.this.f11993au)) {
                SmartRefreshLayout.this.aF = z2;
            }
            return this;
        }

        public i a(boolean z2) {
            if (z2) {
                AnonymousClass1 r4 = new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SmartRefreshLayout.this.f11997ay.a(RefreshState.TwoLevel);
                    }
                };
                ValueAnimator a2 = a(SmartRefreshLayout.this.getMeasuredHeight());
                if (a2 == null || a2 != SmartRefreshLayout.this.aP) {
                    r4.onAnimationEnd((Animator) null);
                } else {
                    a2.setDuration((long) SmartRefreshLayout.this.f12002e);
                    a2.addListener(r4);
                }
            } else if (a(0) == null) {
                SmartRefreshLayout.this.a(RefreshState.None);
            }
            return this;
        }

        public j a() {
            return SmartRefreshLayout.this;
        }

        public i b() {
            if (SmartRefreshLayout.this.f11998az == RefreshState.TwoLevel) {
                SmartRefreshLayout.this.f11997ay.a(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.f11999b == 0) {
                    a(0, false);
                    SmartRefreshLayout.this.a(RefreshState.None);
                } else {
                    a(0).setDuration((long) SmartRefreshLayout.this.f12002e);
                }
            }
            return this;
        }

        public i b(int i2) {
            SmartRefreshLayout.this.f12002e = i2;
            return this;
        }
    }

    /* renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21555a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21555a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpCanceled     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadFinish     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelReleased     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelFinish     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f21555a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass2.<clinit>():void");
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12002e = 300;
        this.f12003f = 300;
        this.f12009l = 0.5f;
        this.f12010m = 'n';
        this.f12013p = -1;
        this.f12014q = -1;
        this.f12015r = -1;
        this.f12016s = -1;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = true;
        this.E = true;
        this.F = true;
        this.G = false;
        this.H = true;
        this.I = true;
        this.J = false;
        this.K = true;
        this.L = false;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.f11979ag = new int[2];
        this.f11980ah = new p(this);
        this.f11981ai = new t(this);
        this.f11983ak = com.scwang.smartrefresh.layout.constant.a.f12084a;
        this.f11985am = com.scwang.smartrefresh.layout.constant.a.f12084a;
        this.f11988ap = 2.5f;
        this.f11989aq = 2.5f;
        this.f11990ar = 1.0f;
        this.f11991as = 1.0f;
        this.f11997ay = new c();
        this.f11998az = RefreshState.None;
        this.aA = RefreshState.None;
        this.aB = 0;
        this.aC = 0;
        this.aD = 0;
        this.aH = false;
        this.aM = false;
        this.aN = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f11996ax = new Handler();
        this.f12020w = new Scroller(context);
        this.f12021x = VelocityTracker.obtain();
        this.f12004g = context.getResources().getDisplayMetrics().heightPixels;
        this.f12022y = new jc.b(jc.b.f13807a);
        this.f11972a = viewConfiguration.getScaledTouchSlop();
        this.f12017t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f12018u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f11984al = jc.b.a(60.0f);
        this.f11982aj = jc.b.a(100.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        ja.c cVar = aK;
        if (cVar != null) {
            cVar.a(context, this);
        }
        this.f12009l = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.f12009l);
        this.f11988ap = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.f11988ap);
        this.f11989aq = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.f11989aq);
        this.f11990ar = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.f11990ar);
        this.f11991as = obtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.f11991as);
        this.A = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.A);
        this.f12003f = obtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.f12003f);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.B);
        this.f11982aj = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.f11982aj);
        this.f11984al = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.f11984al);
        this.f11986an = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.f11986an);
        this.f11987ao = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.f11987ao);
        this.Q = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.Q);
        this.R = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.R);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.E);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.F);
        this.H = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.H);
        this.K = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.K);
        this.I = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.I);
        this.L = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.L);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.M);
        this.N = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.N);
        this.O = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.O);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.G);
        this.G = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, this.G);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.C);
        this.D = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.D);
        this.J = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.J);
        this.f12013p = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.f12013p);
        this.f12014q = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.f12014q);
        this.f12015r = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.f12015r);
        this.f12016s = obtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.f12016s);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.P);
        this.P = z2;
        this.f11980ah.a(z2);
        this.U = this.U || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.V = this.V || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.W = this.W || obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.f11983ak = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? com.scwang.smartrefresh.layout.constant.a.f12090g : this.f11983ak;
        this.f11985am = obtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? com.scwang.smartrefresh.layout.constant.a.f12090g : this.f11985am;
        int color = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f12023z = new int[]{color2, color};
            } else {
                this.f12023z = new int[]{color2};
            }
        } else if (color != 0) {
            this.f12023z = new int[]{0, color};
        }
        if (this.L && !this.U && !this.B) {
            this.B = true;
        }
        obtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreator(ja.a aVar) {
        aI = aVar;
    }

    public static void setDefaultRefreshHeaderCreator(ja.b bVar) {
        aJ = bVar;
    }

    public static void setDefaultRefreshInitializer(ja.c cVar) {
        aK = cVar;
    }

    /* access modifiers changed from: protected */
    public ValueAnimator a(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.f11999b == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.aP;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.aO = null;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f11999b, i2});
        this.aP = ofInt;
        ofInt.setDuration((long) i4);
        this.aP.setInterpolator(interpolator);
        this.aP.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.aP = null;
                if (SmartRefreshLayout.this.f11999b == 0 && SmartRefreshLayout.this.f11998az != RefreshState.None && !SmartRefreshLayout.this.f11998az.f12081v && !SmartRefreshLayout.this.f11998az.f12080u) {
                    SmartRefreshLayout.this.a(RefreshState.None);
                } else if (SmartRefreshLayout.this.f11998az != SmartRefreshLayout.this.aA) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.setViceState(smartRefreshLayout.f11998az);
                }
            }
        });
        this.aP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout.this.f11997ay.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
            }
        });
        this.aP.setStartDelay((long) i3);
        this.aP.start();
        return this.aP;
    }

    public j a(int i2, final boolean z2, final Boolean bool) {
        final int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        AnonymousClass7 r1 = new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            int f12031a = 0;

            public void run() {
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
                boolean z2 = false;
                if (this.f12031a != 0) {
                    int a2 = SmartRefreshLayout.this.f11992at.a(SmartRefreshLayout.this, z2);
                    if (SmartRefreshLayout.this.f11975ac != null && (SmartRefreshLayout.this.f11992at instanceof g)) {
                        SmartRefreshLayout.this.f11975ac.a((g) SmartRefreshLayout.this.f11992at, z2);
                    }
                    if (a2 < Integer.MAX_VALUE) {
                        if (SmartRefreshLayout.this.f12011n || SmartRefreshLayout.this.f11978af) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (SmartRefreshLayout.this.f12011n) {
                                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                                smartRefreshLayout.f12006i = smartRefreshLayout.f12008k;
                                SmartRefreshLayout.this.f12001d = 0;
                                SmartRefreshLayout.this.f12011n = false;
                                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                                long j2 = currentTimeMillis;
                                boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j2, 0, smartRefreshLayout2.f12007j, (SmartRefreshLayout.this.f12008k + ((float) SmartRefreshLayout.this.f11999b)) - ((float) (SmartRefreshLayout.this.f11972a * 2)), 0));
                                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                                boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j2, 2, smartRefreshLayout3.f12007j, SmartRefreshLayout.this.f12008k + ((float) SmartRefreshLayout.this.f11999b), 0));
                            }
                            if (SmartRefreshLayout.this.f11978af) {
                                SmartRefreshLayout.this.f11977ae = 0;
                                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                                boolean unused3 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout4.f12007j, SmartRefreshLayout.this.f12008k, 0));
                                SmartRefreshLayout.this.f11978af = false;
                                SmartRefreshLayout.this.f12001d = 0;
                            }
                        }
                        if (SmartRefreshLayout.this.f11999b > 0) {
                            SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                            ValueAnimator a3 = smartRefreshLayout5.a(0, a2, smartRefreshLayout5.f12022y, SmartRefreshLayout.this.f12003f);
                            if (SmartRefreshLayout.this.N) {
                                animatorUpdateListener = SmartRefreshLayout.this.f11994av.a(SmartRefreshLayout.this.f11999b);
                            }
                            if (a3 != null && animatorUpdateListener != null) {
                                a3.addUpdateListener(animatorUpdateListener);
                                return;
                            }
                            return;
                        } else if (SmartRefreshLayout.this.f11999b < 0) {
                            SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                            smartRefreshLayout6.a(0, a2, smartRefreshLayout6.f12022y, SmartRefreshLayout.this.f12003f);
                            return;
                        } else {
                            SmartRefreshLayout.this.f11997ay.a(0, false);
                        }
                    } else {
                        return;
                    }
                } else if (SmartRefreshLayout.this.f11998az == RefreshState.None && SmartRefreshLayout.this.aA == RefreshState.Refreshing) {
                    SmartRefreshLayout.this.aA = RefreshState.None;
                    return;
                } else if (SmartRefreshLayout.this.aP != null && SmartRefreshLayout.this.f11998az.f12077r && (SmartRefreshLayout.this.f11998az.f12080u || SmartRefreshLayout.this.f11998az == RefreshState.RefreshReleased)) {
                    ValueAnimator valueAnimator = SmartRefreshLayout.this.aP;
                    SmartRefreshLayout.this.aP = null;
                    valueAnimator.cancel();
                } else if (SmartRefreshLayout.this.f11998az == RefreshState.Refreshing && SmartRefreshLayout.this.f11992at != null && SmartRefreshLayout.this.f11994av != null) {
                    this.f12031a++;
                    SmartRefreshLayout.this.f11996ax.postDelayed(this, (long) i3);
                    SmartRefreshLayout.this.a(RefreshState.RefreshFinish);
                    Boolean bool = bool;
                    if (bool != null) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (bool == Boolean.TRUE) {
                            z2 = true;
                        }
                        smartRefreshLayout7.f(z2);
                        return;
                    }
                    return;
                } else {
                    return;
                }
                SmartRefreshLayout.this.f11997ay.a(RefreshState.None);
            }
        };
        if (i4 > 0) {
            this.f11996ax.postDelayed(r1, (long) i4);
        } else {
            r1.run();
        }
        return this;
    }

    public j a(int i2, final boolean z2, final boolean z3) {
        final int i3 = i2 >> 16;
        int i4 = (i2 << 16) >> 16;
        AnonymousClass8 r1 = new Runnable() {

            /* renamed from: a  reason: collision with root package name */
            int f12036a = 0;

            public void run() {
                boolean z2 = true;
                if (this.f12036a == 0) {
                    if (SmartRefreshLayout.this.f11998az == RefreshState.None && SmartRefreshLayout.this.aA == RefreshState.Loading) {
                        SmartRefreshLayout.this.aA = RefreshState.None;
                    } else if (SmartRefreshLayout.this.aP != null && ((SmartRefreshLayout.this.f11998az.f12080u || SmartRefreshLayout.this.f11998az == RefreshState.LoadReleased) && SmartRefreshLayout.this.f11998az.f12078s)) {
                        ValueAnimator valueAnimator = SmartRefreshLayout.this.aP;
                        SmartRefreshLayout.this.aP = null;
                        valueAnimator.cancel();
                        SmartRefreshLayout.this.f11997ay.a(RefreshState.None);
                    } else if (!(SmartRefreshLayout.this.f11998az != RefreshState.Loading || SmartRefreshLayout.this.f11993au == null || SmartRefreshLayout.this.f11994av == null)) {
                        this.f12036a++;
                        SmartRefreshLayout.this.f11996ax.postDelayed(this, (long) i3);
                        SmartRefreshLayout.this.a(RefreshState.LoadFinish);
                        return;
                    }
                    if (z3) {
                        SmartRefreshLayout.this.f(true);
                        return;
                    }
                    return;
                }
                int a2 = SmartRefreshLayout.this.f11993au.a(SmartRefreshLayout.this, z2);
                if (SmartRefreshLayout.this.f11975ac != null && (SmartRefreshLayout.this.f11993au instanceof f)) {
                    SmartRefreshLayout.this.f11975ac.a((f) SmartRefreshLayout.this.f11993au, z2);
                }
                if (a2 < Integer.MAX_VALUE) {
                    if (!z3 || !SmartRefreshLayout.this.G || SmartRefreshLayout.this.f11999b >= 0 || !SmartRefreshLayout.this.f11994av.d()) {
                        z2 = false;
                    }
                    final int max = SmartRefreshLayout.this.f11999b - (z2 ? Math.max(SmartRefreshLayout.this.f11999b, -SmartRefreshLayout.this.f11984al) : 0);
                    if (SmartRefreshLayout.this.f12011n || SmartRefreshLayout.this.f11978af) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (SmartRefreshLayout.this.f12011n) {
                            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                            smartRefreshLayout.f12006i = smartRefreshLayout.f12008k;
                            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                            smartRefreshLayout2.f12001d = smartRefreshLayout2.f11999b - max;
                            SmartRefreshLayout.this.f12011n = false;
                            int i2 = SmartRefreshLayout.this.F ? max : 0;
                            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                            float f2 = (float) i2;
                            long j2 = currentTimeMillis;
                            boolean unused = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j2, 0, smartRefreshLayout3.f12007j, SmartRefreshLayout.this.f12008k + f2 + ((float) (SmartRefreshLayout.this.f11972a * 2)), 0));
                            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                            boolean unused2 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, j2, 2, smartRefreshLayout4.f12007j, SmartRefreshLayout.this.f12008k + f2, 0));
                        }
                        if (SmartRefreshLayout.this.f11978af) {
                            SmartRefreshLayout.this.f11977ae = 0;
                            SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                            boolean unused3 = SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(currentTimeMillis, currentTimeMillis, 1, smartRefreshLayout5.f12007j, SmartRefreshLayout.this.f12008k, 0));
                            SmartRefreshLayout.this.f11978af = false;
                            SmartRefreshLayout.this.f12001d = 0;
                        }
                    }
                    SmartRefreshLayout.this.f11996ax.postDelayed(new Runnable() {
                        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
                        /* JADX WARNING: Removed duplicated region for block: B:29:0x00be  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                                r5 = this;
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                boolean r0 = r0.M
                                r1 = 0
                                if (r0 == 0) goto L_0x001e
                                int r0 = r2
                                if (r0 >= 0) goto L_0x001e
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                ja.e r0 = r0.f11994av
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r2 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                int r2 = r2.f11999b
                                android.animation.ValueAnimator$AnimatorUpdateListener r0 = r0.a((int) r2)
                                goto L_0x001f
                            L_0x001e:
                                r0 = r1
                            L_0x001f:
                                if (r0 == 0) goto L_0x002e
                                r2 = 2
                                int[] r2 = new int[r2]
                                r2 = {0, 0} // fill-array
                                android.animation.ValueAnimator r2 = android.animation.ValueAnimator.ofInt(r2)
                                r0.onAnimationUpdate(r2)
                            L_0x002e:
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8$1$1 r2 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$8$1$1
                                r2.<init>()
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                int r3 = r3.f11999b
                                r4 = 0
                                if (r3 <= 0) goto L_0x0048
                            L_0x003c:
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                ja.i r0 = r0.f11997ay
                                android.animation.ValueAnimator r0 = r0.a((int) r4)
                                goto L_0x00b8
                            L_0x0048:
                                if (r0 != 0) goto L_0x008c
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                int r0 = r0.f11999b
                                if (r0 != 0) goto L_0x0053
                                goto L_0x008c
                            L_0x0053:
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                boolean r0 = r7
                                if (r0 == 0) goto L_0x003c
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                boolean r0 = r0.G
                                if (r0 == 0) goto L_0x003c
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                int r0 = r0.f11999b
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                int r3 = r3.f11984al
                                int r3 = -r3
                                if (r0 < r3) goto L_0x007a
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.None
                                r0.a((com.scwang.smartrefresh.layout.constant.RefreshState) r3)
                                goto L_0x00b7
                            L_0x007a:
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                ja.i r0 = r0.f11997ay
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r3 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                int r3 = r3.f11984al
                                int r3 = -r3
                                android.animation.ValueAnimator r0 = r0.a((int) r3)
                                goto L_0x00b8
                            L_0x008c:
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                android.animation.ValueAnimator r0 = r0.aP
                                if (r0 == 0) goto L_0x00a3
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                android.animation.ValueAnimator r0 = r0.aP
                                r0.cancel()
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                r0.aP = r1
                            L_0x00a3:
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                ja.i r0 = r0.f11997ay
                                r0.a((int) r4, (boolean) r4)
                                com.scwang.smartrefresh.layout.SmartRefreshLayout$8 r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.this
                                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                                ja.i r0 = r0.f11997ay
                                com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.None
                                r0.a((com.scwang.smartrefresh.layout.constant.RefreshState) r3)
                            L_0x00b7:
                                r0 = r1
                            L_0x00b8:
                                if (r0 == 0) goto L_0x00be
                                r0.addListener(r2)
                                goto L_0x00c1
                            L_0x00be:
                                r2.onAnimationEnd(r1)
                            L_0x00c1:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.AnonymousClass8.AnonymousClass1.run():void");
                        }
                    }, SmartRefreshLayout.this.f11999b < 0 ? (long) a2 : 0);
                }
            }
        };
        if (i4 > 0) {
            this.f11996ax.postDelayed(r1, (long) i4);
        } else {
            r1.run();
        }
        return this;
    }

    public j a(f fVar) {
        return a(fVar, -1, -2);
    }

    public j a(f fVar, int i2, int i3) {
        h hVar;
        h hVar2 = this.f11993au;
        if (hVar2 != null) {
            super.removeView(hVar2.getView());
        }
        this.f11993au = fVar;
        this.aH = false;
        this.aD = 0;
        this.T = false;
        this.aF = false;
        this.f11985am = this.f11985am.a();
        this.B = !this.U || this.B;
        if (this.f11993au.getSpinnerStyle().f12106h) {
            super.addView(this.f11993au.getView(), getChildCount(), new LayoutParams(i2, i3));
        } else {
            super.addView(this.f11993au.getView(), 0, new LayoutParams(i2, i3));
        }
        int[] iArr = this.f12023z;
        if (!(iArr == null || (hVar = this.f11993au) == null)) {
            hVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public j a(g gVar) {
        return a(gVar, -1, -2);
    }

    public j a(g gVar, int i2, int i3) {
        h hVar;
        h hVar2 = this.f11992at;
        if (hVar2 != null) {
            super.removeView(hVar2.getView());
        }
        this.f11992at = gVar;
        this.aC = 0;
        this.aE = false;
        this.f11983ak = this.f11983ak.a();
        if (this.f11992at.getSpinnerStyle().f12106h) {
            super.addView(this.f11992at.getView(), getChildCount(), new LayoutParams(i2, i3));
        } else {
            super.addView(this.f11992at.getView(), 0, new LayoutParams(i2, i3));
        }
        int[] iArr = this.f12023z;
        if (!(iArr == null || (hVar = this.f11992at) == null)) {
            hVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public j a(jb.b bVar) {
        this.f11974ab = bVar;
        this.B = this.B || (!this.U && bVar != null);
        return this;
    }

    public j a(d dVar) {
        this.f11973aa = dVar;
        return this;
    }

    /* access modifiers changed from: protected */
    public void a() {
        int i2;
        i iVar;
        int i3;
        i iVar2;
        RefreshState refreshState;
        if (this.f11998az != RefreshState.TwoLevel) {
            if (this.f11998az == RefreshState.Loading || (this.G && this.S && this.T && this.f11999b < 0 && a(this.B))) {
                int i4 = this.f11999b;
                i3 = this.f11984al;
                if (i4 < (-i3)) {
                    iVar = this.f11997ay;
                } else {
                    if (i4 <= 0) {
                        return;
                    }
                    this.f11997ay.a(0);
                    return;
                }
            } else if (this.f11998az == RefreshState.Refreshing) {
                int i5 = this.f11999b;
                i2 = this.f11982aj;
                if (i5 > i2) {
                    iVar = this.f11997ay;
                    iVar.a(i2);
                }
                if (i5 >= 0) {
                    return;
                }
                this.f11997ay.a(0);
                return;
            } else {
                if (this.f11998az == RefreshState.PullDownToRefresh) {
                    iVar2 = this.f11997ay;
                    refreshState = RefreshState.PullDownCanceled;
                } else if (this.f11998az == RefreshState.PullUpToLoad) {
                    iVar2 = this.f11997ay;
                    refreshState = RefreshState.PullUpCanceled;
                } else if (this.f11998az == RefreshState.ReleaseToRefresh) {
                    iVar2 = this.f11997ay;
                    refreshState = RefreshState.Refreshing;
                } else if (this.f11998az == RefreshState.ReleaseToLoad) {
                    iVar2 = this.f11997ay;
                    refreshState = RefreshState.Loading;
                } else if (this.f11998az == RefreshState.ReleaseToTwoLevel) {
                    iVar2 = this.f11997ay;
                    refreshState = RefreshState.TwoLevelReleased;
                } else if (this.f11998az == RefreshState.RefreshReleased) {
                    if (this.aP == null) {
                        iVar = this.f11997ay;
                        i2 = this.f11982aj;
                        iVar.a(i2);
                    }
                    return;
                } else if (this.f11998az != RefreshState.LoadReleased) {
                    if (this.f11999b == 0) {
                        return;
                    }
                    this.f11997ay.a(0);
                    return;
                } else if (this.aP == null) {
                    iVar = this.f11997ay;
                    i3 = this.f11984al;
                } else {
                    return;
                }
                iVar2.a(refreshState);
                return;
            }
            i2 = -i3;
            iVar.a(i2);
        } else if (this.f12019v > -1000 && this.f11999b > getMeasuredHeight() / 2) {
            ValueAnimator a2 = this.f11997ay.a(getMeasuredHeight());
            if (a2 != null) {
                a2.setDuration((long) this.f12002e);
            }
        } else if (this.f12011n) {
            this.f11997ay.b();
        }
    }

    /* access modifiers changed from: protected */
    public void a(RefreshState refreshState) {
        RefreshState refreshState2 = this.f11998az;
        if (refreshState2 != refreshState) {
            this.f11998az = refreshState;
            this.aA = refreshState;
            h hVar = this.f11992at;
            h hVar2 = this.f11993au;
            jb.c cVar = this.f11975ac;
            if (hVar != null) {
                hVar.a(this, refreshState2, refreshState);
            }
            if (hVar2 != null) {
                hVar2.a(this, refreshState2, refreshState);
            }
            if (cVar != null) {
                cVar.a(this, refreshState2, refreshState);
            }
            if (refreshState == RefreshState.LoadFinish) {
                this.aH = false;
            }
        } else if (this.aA != refreshState2) {
            this.aA = refreshState2;
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(float f2) {
        if (f2 == 0.0f) {
            f2 = (float) this.f12019v;
        }
        if (Build.VERSION.SDK_INT > 27 && this.f11994av != null) {
            getScaleY();
            View a2 = this.f11994av.a();
            if (getScaleY() == -1.0f && a2.getScaleY() == -1.0f) {
                f2 = -f2;
            }
        }
        if (Math.abs(f2) > ((float) this.f12017t)) {
            if (((float) this.f11999b) * f2 < 0.0f) {
                if (this.f11998az == RefreshState.Refreshing || this.f11998az == RefreshState.Loading || (this.f11999b < 0 && this.S)) {
                    this.aO = new b(f2).a();
                    return true;
                } else if (this.f11998az.f12083x) {
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.I && (this.B || this.J)) || ((this.f11998az == RefreshState.Loading && this.f11999b >= 0) || (this.K && a(this.B))))) || (f2 > 0.0f && ((this.I && this.A) || this.J || (this.f11998az == RefreshState.Refreshing && this.f11999b <= 0)))) {
                this.aM = false;
                this.f12020w.fling(0, 0, 0, (int) (-f2), 0, 0, -2147483647, SubsamplingScaleImageView.TILE_SIZE_AUTO);
                this.f12020w.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        i iVar;
        RefreshState refreshState;
        if (i2 == 0) {
            if (this.aP != null) {
                if (this.f11998az.f12082w || this.f11998az == RefreshState.TwoLevelReleased) {
                    return true;
                }
                if (this.f11998az == RefreshState.PullDownCanceled) {
                    iVar = this.f11997ay;
                    refreshState = RefreshState.PullDownToRefresh;
                } else {
                    if (this.f11998az == RefreshState.PullUpCanceled) {
                        iVar = this.f11997ay;
                        refreshState = RefreshState.PullUpToLoad;
                    }
                    this.aP.cancel();
                    this.aP = null;
                }
                iVar.a(refreshState);
                this.aP.cancel();
                this.aP = null;
            }
            this.aO = null;
        }
        return this.aP != null;
    }

    /* access modifiers changed from: protected */
    public boolean a(boolean z2) {
        return z2 && !this.L;
    }

    /* access modifiers changed from: protected */
    public boolean a(boolean z2, h hVar) {
        return z2 || this.L || hVar == null || hVar.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12101c;
    }

    public j b() {
        return g(true);
    }

    public j b(int i2) {
        return a(i2, true, Boolean.FALSE);
    }

    public j b(boolean z2) {
        this.U = true;
        this.B = z2;
        return this;
    }

    /* access modifiers changed from: protected */
    public void b(float f2) {
        a aVar;
        if (this.aP == null) {
            if (f2 > 0.0f && (this.f11998az == RefreshState.Refreshing || this.f11998az == RefreshState.TwoLevel)) {
                aVar = new a(f2, this.f11982aj);
            } else if (f2 < 0.0f && (this.f11998az == RefreshState.Loading || ((this.G && this.S && this.T && a(this.B)) || (this.K && !this.S && a(this.B) && this.f11998az != RefreshState.Refreshing)))) {
                aVar = new a(f2, -this.f11984al);
            } else if (this.f11999b == 0 && this.I) {
                aVar = new a(f2, 0);
            } else {
                return;
            }
            this.aO = aVar;
        }
    }

    public j c() {
        return a(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.aB))), 300) << 16, true, true);
    }

    public j c(int i2) {
        return a(i2, true, false);
    }

    public j c(boolean z2) {
        this.A = z2;
        return this;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(float r18) {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r0.f11978af
            r2 = 0
            if (r1 == 0) goto L_0x0019
            boolean r1 = r0.O
            if (r1 != 0) goto L_0x0019
            int r1 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0019
            ja.e r1 = r0.f11994av
            boolean r1 = r1.d()
            if (r1 != 0) goto L_0x0019
            r1 = 0
            goto L_0x001b
        L_0x0019:
            r1 = r18
        L_0x001b:
            int r3 = r0.f12004g
            int r3 = r3 * 5
            float r3 = (float) r3
            r4 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x003b
            java.lang.Object r3 = r17.getTag()
            if (r3 != 0) goto L_0x003b
            java.lang.String r3 = "你这么死拉，臣妾做不到啊！"
            android.content.Context r5 = r17.getContext()
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r3, r4)
            r5.show()
            r0.setTag(r3)
        L_0x003b:
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel
            r6 = 1
            if (r3 != r5) goto L_0x0056
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0056
            ja.i r3 = r0.f11997ay
            int r5 = (int) r1
            int r7 = r17.getMeasuredHeight()
            int r5 = java.lang.Math.min(r5, r7)
        L_0x0051:
            r3.a((int) r5, (boolean) r6)
            goto L_0x01bb
        L_0x0056:
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            r10 = 4636737291354636288(0x4059000000000000, double:100.0)
            r12 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r3 != r5) goto L_0x00b8
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x00b8
            int r3 = r0.f11982aj
            float r5 = (float) r3
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0073
            ja.i r3 = r0.f11997ay
            int r5 = (int) r1
            goto L_0x0051
        L_0x0073:
            float r5 = r0.f11988ap
            float r5 = r5 - r7
            float r3 = (float) r3
            float r5 = r5 * r3
            double r14 = (double) r5
            int r3 = r0.f12004g
            int r3 = r3 * 4
            int r3 = r3 / 3
            int r5 = r17.getHeight()
            int r3 = java.lang.Math.max(r3, r5)
            int r5 = r0.f11982aj
            int r3 = r3 - r5
            double r6 = (double) r3
            float r3 = (float) r5
            float r3 = r1 - r3
            float r5 = r0.f12009l
            float r3 = r3 * r5
            float r3 = java.lang.Math.max(r2, r3)
            double r4 = (double) r3
            java.lang.Double.isNaN(r4)
            double r2 = -r4
            int r16 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r16 != 0) goto L_0x00a1
            r6 = r12
        L_0x00a1:
            double r2 = r2 / r6
            double r2 = java.lang.Math.pow(r10, r2)
            double r12 = r12 - r2
            java.lang.Double.isNaN(r14)
            double r14 = r14 * r12
            double r2 = java.lang.Math.min(r14, r4)
            ja.i r4 = r0.f11997ay
            int r2 = (int) r2
            int r3 = r0.f11982aj
            int r2 = r2 + r3
            goto L_0x01b7
        L_0x00b8:
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x013e
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r3 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
            if (r2 == r3) goto L_0x00e6
            boolean r2 = r0.G
            if (r2 == 0) goto L_0x00d6
            boolean r2 = r0.S
            if (r2 == 0) goto L_0x00d6
            boolean r2 = r0.T
            if (r2 == 0) goto L_0x00d6
            boolean r2 = r0.B
            boolean r2 = r0.a((boolean) r2)
            if (r2 != 0) goto L_0x00e6
        L_0x00d6:
            boolean r2 = r0.K
            if (r2 == 0) goto L_0x013e
            boolean r2 = r0.S
            if (r2 != 0) goto L_0x013e
            boolean r2 = r0.B
            boolean r2 = r0.a((boolean) r2)
            if (r2 == 0) goto L_0x013e
        L_0x00e6:
            int r2 = r0.f11984al
            int r3 = -r2
            float r3 = (float) r3
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00f7
            ja.i r2 = r0.f11997ay
            int r3 = (int) r1
            r4 = 1
            r2.a((int) r3, (boolean) r4)
            goto L_0x01bb
        L_0x00f7:
            float r3 = r0.f11989aq
            float r3 = r3 - r7
            float r2 = (float) r2
            float r3 = r3 * r2
            double r2 = (double) r3
            int r4 = r0.f12004g
            int r4 = r4 * 4
            int r4 = r4 / 3
            int r5 = r17.getHeight()
            int r4 = java.lang.Math.max(r4, r5)
            int r5 = r0.f11984al
            int r4 = r4 - r5
            double r6 = (double) r4
            float r4 = (float) r5
            float r4 = r4 + r1
            float r5 = r0.f12009l
            float r4 = r4 * r5
            r5 = 0
            float r4 = java.lang.Math.min(r5, r4)
            float r4 = -r4
            double r4 = (double) r4
            java.lang.Double.isNaN(r4)
            double r14 = -r4
            int r16 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r16 != 0) goto L_0x0126
            r6 = r12
        L_0x0126:
            double r14 = r14 / r6
            double r6 = java.lang.Math.pow(r10, r14)
            double r12 = r12 - r6
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r12
            double r2 = java.lang.Math.min(r2, r4)
            double r2 = -r2
            ja.i r4 = r0.f11997ay
            int r2 = (int) r2
            int r3 = r0.f11984al
            int r2 = r2 - r3
            goto L_0x01b7
        L_0x013e:
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x017b
            float r2 = r0.f11988ap
            int r3 = r0.f11982aj
            float r3 = (float) r3
            float r2 = r2 * r3
            double r2 = (double) r2
            int r4 = r0.f12004g
            int r4 = r4 / 2
            int r5 = r17.getHeight()
            int r4 = java.lang.Math.max(r4, r5)
            double r4 = (double) r4
            float r6 = r0.f12009l
            float r6 = r6 * r1
            r7 = 0
            float r6 = java.lang.Math.max(r7, r6)
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r14 = -r6
            int r16 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r16 != 0) goto L_0x016b
            r4 = r12
        L_0x016b:
            double r14 = r14 / r4
            double r4 = java.lang.Math.pow(r10, r14)
            double r12 = r12 - r4
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r12
            double r2 = java.lang.Math.min(r2, r6)
            goto L_0x01b4
        L_0x017b:
            float r2 = r0.f11989aq
            int r3 = r0.f11984al
            float r3 = (float) r3
            float r2 = r2 * r3
            double r2 = (double) r2
            int r4 = r0.f12004g
            int r4 = r4 / 2
            int r5 = r17.getHeight()
            int r4 = java.lang.Math.max(r4, r5)
            double r4 = (double) r4
            float r6 = r0.f12009l
            float r6 = r6 * r1
            r7 = 0
            float r6 = java.lang.Math.min(r7, r6)
            float r6 = -r6
            double r6 = (double) r6
            java.lang.Double.isNaN(r6)
            double r14 = -r6
            int r16 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r16 != 0) goto L_0x01a4
            r4 = r12
        L_0x01a4:
            double r14 = r14 / r4
            double r4 = java.lang.Math.pow(r10, r14)
            double r12 = r12 - r4
            java.lang.Double.isNaN(r2)
            double r2 = r2 * r12
            double r2 = java.lang.Math.min(r2, r6)
            double r2 = -r2
        L_0x01b4:
            ja.i r4 = r0.f11997ay
            int r2 = (int) r2
        L_0x01b7:
            r3 = 1
            r4.a((int) r2, (boolean) r3)
        L_0x01bb:
            boolean r2 = r0.K
            if (r2 == 0) goto L_0x0202
            boolean r2 = r0.S
            if (r2 != 0) goto L_0x0202
            boolean r2 = r0.B
            boolean r2 = r0.a((boolean) r2)
            if (r2 == 0) goto L_0x0202
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0202
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r1 == r2) goto L_0x0202
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
            if (r1 == r2) goto L_0x0202
            com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadFinish
            if (r1 == r2) goto L_0x0202
            boolean r1 = r0.R
            if (r1 == 0) goto L_0x01f1
            r1 = 0
            r0.aO = r1
            ja.i r1 = r0.f11997ay
            int r2 = r0.f11984al
            int r2 = -r2
            r1.a((int) r2)
        L_0x01f1:
            r1 = 0
            r0.setStateDirectLoading(r1)
            android.os.Handler r1 = r0.f11996ax
            com.scwang.smartrefresh.layout.SmartRefreshLayout$6 r2 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$6
            r2.<init>()
            int r3 = r0.f12003f
            long r3 = (long) r3
            r1.postDelayed(r2, r3)
        L_0x0202:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.c(float):void");
    }

    public void computeScroll() {
        this.f12020w.getCurrY();
        if (this.f12020w.computeScrollOffset()) {
            int finalY = this.f12020w.getFinalY();
            if ((finalY >= 0 || ((!this.A && !this.J) || !this.f11994av.c())) && (finalY <= 0 || ((!this.B && !this.J) || !this.f11994av.d()))) {
                this.aM = true;
                invalidate();
                return;
            }
            if (this.aM) {
                b(Build.VERSION.SDK_INT >= 14 ? finalY > 0 ? -this.f12020w.getCurrVelocity() : this.f12020w.getCurrVelocity() : (((float) (this.f12020w.getCurrY() - finalY)) * 1.0f) / ((float) Math.max(this.f12020w.getDuration() - this.f12020w.timePassed(), 1)));
            }
            this.f12020w.forceFinished(true);
        }
    }

    public j d(float f2) {
        this.f11988ap = f2;
        h hVar = this.f11992at;
        if (hVar == null || !this.aG) {
            this.f11983ak = this.f11983ak.a();
        } else {
            i iVar = this.f11997ay;
            int i2 = this.f11982aj;
            hVar.a(iVar, i2, (int) (f2 * ((float) i2)));
        }
        return this;
    }

    public j d(boolean z2) {
        this.K = z2;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0112, code lost:
        if (r6 != 3) goto L_0x031c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x02b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            int r6 = r23.getActionMasked()
            r2 = 6
            r10 = 0
            r11 = 1
            if (r6 != r2) goto L_0x000f
            r3 = 1
            goto L_0x0010
        L_0x000f:
            r3 = 0
        L_0x0010:
            if (r3 == 0) goto L_0x0017
            int r4 = r23.getActionIndex()
            goto L_0x0018
        L_0x0017:
            r4 = -1
        L_0x0018:
            int r5 = r23.getPointerCount()
            r7 = 0
            r8 = 0
            r9 = 0
            r12 = 0
        L_0x0020:
            if (r8 >= r5) goto L_0x0032
            if (r4 != r8) goto L_0x0025
            goto L_0x002f
        L_0x0025:
            float r13 = r1.getX(r8)
            float r9 = r9 + r13
            float r13 = r1.getY(r8)
            float r12 = r12 + r13
        L_0x002f:
            int r8 = r8 + 1
            goto L_0x0020
        L_0x0032:
            if (r3 == 0) goto L_0x0036
            int r5 = r5 + -1
        L_0x0036:
            float r3 = (float) r5
            float r9 = r9 / r3
            float r8 = r12 / r3
            r3 = 5
            if (r6 == r2) goto L_0x003f
            if (r6 != r3) goto L_0x004c
        L_0x003f:
            boolean r4 = r0.f12011n
            if (r4 == 0) goto L_0x004c
            float r4 = r0.f12006i
            float r5 = r0.f12008k
            float r5 = r8 - r5
            float r4 = r4 + r5
            r0.f12006i = r4
        L_0x004c:
            r0.f12007j = r9
            r0.f12008k = r8
            boolean r4 = r0.f11978af
            r5 = 2
            if (r4 == 0) goto L_0x00a6
            int r2 = r0.f11977ae
            boolean r1 = super.dispatchTouchEvent(r23)
            if (r6 != r5) goto L_0x00a5
            int r3 = r0.f11977ae
            if (r2 != r3) goto L_0x00a5
            float r2 = r0.f12007j
            int r2 = (int) r2
            int r3 = r22.getWidth()
            float r4 = r0.f12007j
            if (r3 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r11 = r3
        L_0x006e:
            float r5 = (float) r11
            float r4 = r4 / r5
            boolean r5 = r0.A
            boolean r5 = r0.a((boolean) r5)
            if (r5 == 0) goto L_0x008c
            int r5 = r0.f11999b
            if (r5 <= 0) goto L_0x008c
            ja.h r5 = r0.f11992at
            if (r5 == 0) goto L_0x008c
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x008c
            ja.h r5 = r0.f11992at
        L_0x0088:
            r5.a((float) r4, (int) r2, (int) r3)
            goto L_0x00a5
        L_0x008c:
            boolean r5 = r0.B
            boolean r5 = r0.a((boolean) r5)
            if (r5 == 0) goto L_0x00a5
            int r5 = r0.f11999b
            if (r5 >= 0) goto L_0x00a5
            ja.h r5 = r0.f11993au
            if (r5 == 0) goto L_0x00a5
            boolean r5 = r5.a()
            if (r5 == 0) goto L_0x00a5
            ja.h r5 = r0.f11993au
            goto L_0x0088
        L_0x00a5:
            return r1
        L_0x00a6:
            boolean r4 = r22.isEnabled()
            if (r4 == 0) goto L_0x0361
            boolean r4 = r0.A
            if (r4 != 0) goto L_0x00b8
            boolean r4 = r0.B
            if (r4 != 0) goto L_0x00b8
            boolean r4 = r0.J
            if (r4 == 0) goto L_0x0361
        L_0x00b8:
            boolean r4 = r0.aE
            if (r4 == 0) goto L_0x00ce
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            boolean r4 = r4.f12081v
            if (r4 != 0) goto L_0x00c8
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            boolean r4 = r4.f12082w
            if (r4 == 0) goto L_0x00ce
        L_0x00c8:
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            boolean r4 = r4.f12077r
            if (r4 != 0) goto L_0x0361
        L_0x00ce:
            boolean r4 = r0.aF
            if (r4 == 0) goto L_0x00e6
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            boolean r4 = r4.f12081v
            if (r4 != 0) goto L_0x00de
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            boolean r4 = r4.f12082w
            if (r4 == 0) goto L_0x00e6
        L_0x00de:
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            boolean r4 = r4.f12078s
            if (r4 == 0) goto L_0x00e6
            goto L_0x0361
        L_0x00e6:
            boolean r4 = r0.a((int) r6)
            if (r4 != 0) goto L_0x0360
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            boolean r4 = r4.f12082w
            if (r4 != 0) goto L_0x0360
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r12 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
            if (r4 != r12) goto L_0x00fc
            boolean r4 = r0.R
            if (r4 != 0) goto L_0x0360
        L_0x00fc:
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r12 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
            if (r4 != r12) goto L_0x0108
            boolean r4 = r0.Q
            if (r4 == 0) goto L_0x0108
            goto L_0x0360
        L_0x0108:
            r4 = 104(0x68, float:1.46E-43)
            if (r6 == 0) goto L_0x0321
            r2 = 0
            if (r6 == r11) goto L_0x02d3
            r3 = 3
            if (r6 == r5) goto L_0x0116
            if (r6 == r3) goto L_0x02ee
            goto L_0x031c
        L_0x0116:
            float r5 = r0.f12005h
            float r9 = r9 - r5
            float r5 = r0.f12006i
            float r5 = r8 - r5
            android.view.VelocityTracker r6 = r0.f12021x
            r6.addMovement(r1)
            boolean r6 = r0.f12011n
            if (r6 != 0) goto L_0x01ea
            char r6 = r0.f12010m
            if (r6 == r4) goto L_0x01ea
            ja.e r12 = r0.f11994av
            if (r12 == 0) goto L_0x01ea
            r12 = 118(0x76, float:1.65E-43)
            if (r6 == r12) goto L_0x0169
            float r6 = java.lang.Math.abs(r5)
            int r13 = r0.f11972a
            float r13 = (float) r13
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x014a
            float r6 = java.lang.Math.abs(r9)
            float r13 = java.lang.Math.abs(r5)
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 >= 0) goto L_0x014a
            goto L_0x0169
        L_0x014a:
            float r6 = java.lang.Math.abs(r9)
            int r13 = r0.f11972a
            float r13 = (float) r13
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x01ea
            float r6 = java.lang.Math.abs(r9)
            float r13 = java.lang.Math.abs(r5)
            int r6 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x01ea
            char r6 = r0.f12010m
            if (r6 == r12) goto L_0x01ea
            r0.f12010m = r4
            goto L_0x01ea
        L_0x0169:
            r0.f12010m = r12
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x018d
            int r4 = r0.f11999b
            if (r4 < 0) goto L_0x0183
            boolean r4 = r0.J
            if (r4 != 0) goto L_0x017b
            boolean r4 = r0.A
            if (r4 == 0) goto L_0x018d
        L_0x017b:
            ja.e r4 = r0.f11994av
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x018d
        L_0x0183:
            r0.f12011n = r11
            int r4 = r0.f11972a
            float r4 = (float) r4
            float r4 = r8 - r4
        L_0x018a:
            r0.f12006i = r4
            goto L_0x01b6
        L_0x018d:
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x01b6
            int r4 = r0.f11999b
            if (r4 > 0) goto L_0x01af
            boolean r4 = r0.J
            if (r4 != 0) goto L_0x019d
            boolean r4 = r0.B
            if (r4 == 0) goto L_0x01b6
        L_0x019d:
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
            if (r4 != r6) goto L_0x01a7
            boolean r4 = r0.aH
            if (r4 != 0) goto L_0x01af
        L_0x01a7:
            ja.e r4 = r0.f11994av
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x01b6
        L_0x01af:
            r0.f12011n = r11
            int r4 = r0.f11972a
            float r4 = (float) r4
            float r4 = r4 + r8
            goto L_0x018a
        L_0x01b6:
            boolean r4 = r0.f12011n
            if (r4 == 0) goto L_0x01ea
            float r4 = r0.f12006i
            float r5 = r8 - r4
            boolean r4 = r0.f12012o
            if (r4 == 0) goto L_0x01c8
            r1.setAction(r3)
            super.dispatchTouchEvent(r23)
        L_0x01c8:
            ja.i r4 = r0.f11997ay
            int r6 = r0.f11999b
            if (r6 > 0) goto L_0x01d8
            if (r6 != 0) goto L_0x01d5
            int r6 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x01d5
            goto L_0x01d8
        L_0x01d5:
            com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
            goto L_0x01da
        L_0x01d8:
            com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
        L_0x01da:
            r4.a((com.scwang.smartrefresh.layout.constant.RefreshState) r6)
            android.view.ViewParent r4 = r22.getParent()
            boolean r6 = r4 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x01ea
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r4.requestDisallowInterceptTouchEvent(r11)
        L_0x01ea:
            boolean r4 = r0.f12011n
            if (r4 == 0) goto L_0x02c1
            int r4 = (int) r5
            int r6 = r0.f12001d
            int r4 = r4 + r6
            com.scwang.smartrefresh.layout.constant.RefreshState r6 = r0.aA
            boolean r6 = r6.f12077r
            if (r6 == 0) goto L_0x01fe
            if (r4 < 0) goto L_0x020a
            int r6 = r0.f12000c
            if (r6 < 0) goto L_0x020a
        L_0x01fe:
            com.scwang.smartrefresh.layout.constant.RefreshState r6 = r0.aA
            boolean r6 = r6.f12078s
            if (r6 == 0) goto L_0x02bc
            if (r4 > 0) goto L_0x020a
            int r6 = r0.f12000c
            if (r6 <= 0) goto L_0x02bc
        L_0x020a:
            r0.f12000c = r4
            long r20 = r23.getEventTime()
            android.view.MotionEvent r1 = r0.aN
            if (r1 != 0) goto L_0x022d
            r16 = 0
            float r1 = r0.f12005h
            float r17 = r1 + r9
            float r1 = r0.f12006i
            r19 = 0
            r12 = r20
            r14 = r20
            r18 = r1
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r12, r14, r16, r17, r18, r19)
            r0.aN = r1
            super.dispatchTouchEvent(r1)
        L_0x022d:
            r16 = 2
            float r1 = r0.f12005h
            float r17 = r1 + r9
            float r1 = r0.f12006i
            float r6 = (float) r4
            float r18 = r1 + r6
            r19 = 0
            r12 = r20
            r14 = r20
            android.view.MotionEvent r1 = android.view.MotionEvent.obtain(r12, r14, r16, r17, r18, r19)
            super.dispatchTouchEvent(r1)
            boolean r6 = r0.aH
            if (r6 == 0) goto L_0x0256
            int r6 = r0.f11972a
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0256
            int r5 = r0.f11999b
            if (r5 >= 0) goto L_0x0256
            r0.aH = r10
        L_0x0256:
            if (r4 <= 0) goto L_0x0276
            boolean r5 = r0.J
            if (r5 != 0) goto L_0x0260
            boolean r5 = r0.A
            if (r5 == 0) goto L_0x0276
        L_0x0260:
            ja.e r5 = r0.f11994av
            boolean r5 = r5.c()
            if (r5 == 0) goto L_0x0276
            r0.f12008k = r8
            r0.f12006i = r8
            r0.f12001d = r10
            ja.i r4 = r0.f11997ay
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh
        L_0x0272:
            r4.a((com.scwang.smartrefresh.layout.constant.RefreshState) r5)
            goto L_0x0294
        L_0x0276:
            if (r4 >= 0) goto L_0x0293
            boolean r5 = r0.J
            if (r5 != 0) goto L_0x0280
            boolean r5 = r0.B
            if (r5 == 0) goto L_0x0293
        L_0x0280:
            ja.e r5 = r0.f11994av
            boolean r5 = r5.d()
            if (r5 == 0) goto L_0x0293
            r0.f12008k = r8
            r0.f12006i = r8
            r0.f12001d = r10
            ja.i r4 = r0.f11997ay
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad
            goto L_0x0272
        L_0x0293:
            r10 = r4
        L_0x0294:
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.aA
            boolean r4 = r4.f12077r
            if (r4 == 0) goto L_0x029c
            if (r10 < 0) goto L_0x02a4
        L_0x029c:
            com.scwang.smartrefresh.layout.constant.RefreshState r4 = r0.aA
            boolean r4 = r4.f12078s
            if (r4 == 0) goto L_0x02ac
            if (r10 <= 0) goto L_0x02ac
        L_0x02a4:
            int r1 = r0.f11999b
            if (r1 == 0) goto L_0x02ab
            r0.c((float) r7)
        L_0x02ab:
            return r11
        L_0x02ac:
            android.view.MotionEvent r4 = r0.aN
            if (r4 == 0) goto L_0x02b8
            r0.aN = r2
            r1.setAction(r3)
            super.dispatchTouchEvent(r1)
        L_0x02b8:
            r1.recycle()
            r4 = r10
        L_0x02bc:
            float r1 = (float) r4
            r0.c((float) r1)
            return r11
        L_0x02c1:
            boolean r2 = r0.aH
            if (r2 == 0) goto L_0x031c
            int r2 = r0.f11972a
            float r2 = (float) r2
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x031c
            int r2 = r0.f11999b
            if (r2 >= 0) goto L_0x031c
            r0.aH = r10
            goto L_0x031c
        L_0x02d3:
            android.view.VelocityTracker r3 = r0.f12021x
            r3.addMovement(r1)
            android.view.VelocityTracker r3 = r0.f12021x
            r4 = 1000(0x3e8, float:1.401E-42)
            int r5 = r0.f12018u
            float r5 = (float) r5
            r3.computeCurrentVelocity(r4, r5)
            android.view.VelocityTracker r3 = r0.f12021x
            float r3 = r3.getYVelocity()
            int r3 = (int) r3
            r0.f12019v = r3
            r0.a((float) r7)
        L_0x02ee:
            android.view.VelocityTracker r3 = r0.f12021x
            r3.clear()
            r3 = 110(0x6e, float:1.54E-43)
            r0.f12010m = r3
            android.view.MotionEvent r3 = r0.aN
            if (r3 == 0) goto L_0x0312
            r3.recycle()
            r0.aN = r2
            long r4 = r23.getEventTime()
            float r7 = r0.f12005h
            r9 = 0
            r2 = r4
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r2, r4, r6, r7, r8, r9)
            super.dispatchTouchEvent(r2)
            r2.recycle()
        L_0x0312:
            r22.a()
            boolean r2 = r0.f12011n
            if (r2 == 0) goto L_0x031c
            r0.f12011n = r10
            return r11
        L_0x031c:
            boolean r1 = super.dispatchTouchEvent(r23)
            return r1
        L_0x0321:
            r0.f12019v = r10
            android.view.VelocityTracker r5 = r0.f12021x
            r5.addMovement(r1)
            android.widget.Scroller r5 = r0.f12020w
            r5.forceFinished(r11)
            r0.f12005h = r9
            r0.f12006i = r8
            r0.f12000c = r10
            int r5 = r0.f11999b
            r0.f12001d = r5
            r0.f12011n = r10
            boolean r5 = super.dispatchTouchEvent(r23)
            r0.f12012o = r5
            com.scwang.smartrefresh.layout.constant.RefreshState r5 = r0.f11998az
            com.scwang.smartrefresh.layout.constant.RefreshState r6 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel
            if (r5 != r6) goto L_0x0358
            float r5 = r0.f12006i
            int r6 = r22.getMeasuredHeight()
            int r6 = r6 * 5
            int r6 = r6 / r2
            float r2 = (float) r6
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0358
            r0.f12010m = r4
            boolean r1 = r0.f12012o
            return r1
        L_0x0358:
            ja.e r2 = r0.f11994av
            if (r2 == 0) goto L_0x035f
            r2.a((android.view.MotionEvent) r1)
        L_0x035f:
            return r11
        L_0x0360:
            return r10
        L_0x0361:
            boolean r1 = super.dispatchTouchEvent(r23)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Paint paint;
        Paint paint2;
        e eVar = this.f11994av;
        View a2 = eVar != null ? eVar.a() : null;
        h hVar = this.f11992at;
        if (hVar != null && hVar.getView() == view) {
            if (!a(this.A) || (!this.H && isInEditMode())) {
                return true;
            }
            if (a2 != null) {
                int max = Math.max(a2.getTop() + a2.getPaddingTop() + this.f11999b, view.getTop());
                int i2 = this.aC;
                if (!(i2 == 0 || (paint2 = this.f11995aw) == null)) {
                    paint2.setColor(i2);
                    if (this.f11992at.getSpinnerStyle().f12107i) {
                        max = view.getBottom();
                    } else if (this.f11992at.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12099a) {
                        max = view.getBottom() + this.f11999b;
                    }
                    canvas.drawRect(0.0f, (float) view.getTop(), (float) getWidth(), (float) max, this.f11995aw);
                }
                if (this.C && this.f11992at.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12101c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), max);
                    boolean drawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild;
                }
            }
        }
        h hVar2 = this.f11993au;
        if (hVar2 != null && hVar2.getView() == view) {
            if (!a(this.B) || (!this.H && isInEditMode())) {
                return true;
            }
            if (a2 != null) {
                int min = Math.min((a2.getBottom() - a2.getPaddingBottom()) + this.f11999b, view.getBottom());
                int i3 = this.aD;
                if (!(i3 == 0 || (paint = this.f11995aw) == null)) {
                    paint.setColor(i3);
                    if (this.f11993au.getSpinnerStyle().f12107i) {
                        min = view.getTop();
                    } else if (this.f11993au.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12099a) {
                        min = view.getTop() + this.f11999b;
                    }
                    canvas.drawRect(0.0f, (float) min, (float) getWidth(), (float) view.getBottom(), this.f11995aw);
                }
                if (this.D && this.f11993au.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12101c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), min, view.getRight(), view.getBottom());
                    boolean drawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return drawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    public j e(boolean z2) {
        setNestedScrollingEnabled(z2);
        return this;
    }

    public j f(boolean z2) {
        if (this.f11998az != RefreshState.Loading || !z2) {
            if (this.S != z2) {
                this.S = z2;
                h hVar = this.f11993au;
                if (hVar instanceof f) {
                    if (((f) hVar).a(z2)) {
                        this.T = true;
                        if (this.S && this.G && this.f11999b > 0 && this.f11993au.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12099a && a(this.B) && a(this.A, this.f11992at)) {
                            this.f11993au.getView().setTranslationY((float) this.f11999b);
                        }
                    } else {
                        this.T = false;
                        new RuntimeException("Footer:" + this.f11993au + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                    }
                }
            }
            return this;
        }
        c();
        return this;
    }

    public j g(boolean z2) {
        return z2 ? a(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.aB))), 300) << 16, true, Boolean.FALSE) : a(0, false, (Boolean) null);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ViewGroup getLayout() {
        return this;
    }

    public int getNestedScrollAxes() {
        return this.f11981ai.a();
    }

    public f getRefreshFooter() {
        h hVar = this.f11993au;
        if (hVar instanceof f) {
            return (f) hVar;
        }
        return null;
    }

    public g getRefreshHeader() {
        h hVar = this.f11992at;
        if (hVar instanceof g) {
            return (g) hVar;
        }
        return null;
    }

    public RefreshState getState() {
        return this.f11998az;
    }

    public boolean isNestedScrollingEnabled() {
        return this.P && (this.J || this.A || this.B);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 1
            r5.aG = r0
            boolean r1 = r5.isInEditMode()
            if (r1 != 0) goto L_0x00f9
            ja.h r1 = r5.f11992at
            if (r1 != 0) goto L_0x0029
            ja.b r1 = aJ
            if (r1 == 0) goto L_0x001d
            android.content.Context r2 = r5.getContext()
            ja.g r1 = r1.createRefreshHeader(r2, r5)
            goto L_0x0026
        L_0x001d:
            com.scwang.smartrefresh.layout.header.BezierRadarHeader r1 = new com.scwang.smartrefresh.layout.header.BezierRadarHeader
            android.content.Context r2 = r5.getContext()
            r1.<init>(r2)
        L_0x0026:
            r5.a((ja.g) r1)
        L_0x0029:
            ja.h r1 = r5.f11993au
            r2 = 0
            if (r1 != 0) goto L_0x004f
            ja.a r0 = aI
            if (r0 == 0) goto L_0x003e
            android.content.Context r1 = r5.getContext()
            ja.f r0 = r0.createRefreshFooter(r1, r5)
            r5.a((ja.f) r0)
            goto L_0x005a
        L_0x003e:
            boolean r0 = r5.B
            com.scwang.smartrefresh.layout.footer.BallPulseFooter r1 = new com.scwang.smartrefresh.layout.footer.BallPulseFooter
            android.content.Context r3 = r5.getContext()
            r1.<init>(r3)
            r5.a((ja.f) r1)
        L_0x004c:
            r5.B = r0
            goto L_0x005a
        L_0x004f:
            boolean r1 = r5.B
            if (r1 != 0) goto L_0x004c
            boolean r1 = r5.U
            if (r1 != 0) goto L_0x0058
            goto L_0x004c
        L_0x0058:
            r0 = 0
            goto L_0x004c
        L_0x005a:
            ja.e r0 = r5.f11994av
            if (r0 != 0) goto L_0x0087
            int r0 = r5.getChildCount()
            r1 = 0
        L_0x0063:
            if (r1 >= r0) goto L_0x0087
            android.view.View r3 = r5.getChildAt(r1)
            ja.h r4 = r5.f11992at
            if (r4 == 0) goto L_0x0073
            android.view.View r4 = r4.getView()
            if (r3 == r4) goto L_0x0084
        L_0x0073:
            ja.h r4 = r5.f11993au
            if (r4 == 0) goto L_0x007d
            android.view.View r4 = r4.getView()
            if (r3 == r4) goto L_0x0084
        L_0x007d:
            com.scwang.smartrefresh.layout.impl.a r4 = new com.scwang.smartrefresh.layout.impl.a
            r4.<init>(r3)
            r5.f11994av = r4
        L_0x0084:
            int r1 = r1 + 1
            goto L_0x0063
        L_0x0087:
            ja.e r0 = r5.f11994av
            if (r0 != 0) goto L_0x00c4
            r0 = 1101004800(0x41a00000, float:20.0)
            int r1 = jc.b.a((float) r0)
            android.widget.TextView r3 = new android.widget.TextView
            android.content.Context r4 = r5.getContext()
            r3.<init>(r4)
            r4 = -39424(0xffffffffffff6600, float:NaN)
            r3.setTextColor(r4)
            r4 = 17
            r3.setGravity(r4)
            r3.setTextSize(r0)
            int r0 = com.scwang.smartrefresh.layout.R.string.srl_content_empty
            r3.setText(r0)
            com.scwang.smartrefresh.layout.SmartRefreshLayout$LayoutParams r0 = new com.scwang.smartrefresh.layout.SmartRefreshLayout$LayoutParams
            r4 = -1
            r0.<init>((int) r4, (int) r4)
            super.addView(r3, r2, r0)
            com.scwang.smartrefresh.layout.impl.a r0 = new com.scwang.smartrefresh.layout.impl.a
            r0.<init>(r3)
            r5.f11994av = r0
            android.view.View r0 = r0.a()
            r0.setPadding(r1, r1, r1, r1)
        L_0x00c4:
            int r0 = r5.f12013p
            android.view.View r0 = r5.findViewById(r0)
            int r1 = r5.f12014q
            android.view.View r1 = r5.findViewById(r1)
            ja.e r3 = r5.f11994av
            ja.k r4 = r5.f11976ad
            r3.a((ja.k) r4)
            ja.e r3 = r5.f11994av
            boolean r4 = r5.O
            r3.a((boolean) r4)
            ja.e r3 = r5.f11994av
            ja.i r4 = r5.f11997ay
            r3.a((ja.i) r4, (android.view.View) r0, (android.view.View) r1)
            int r0 = r5.f11999b
            if (r0 == 0) goto L_0x00f9
            com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.None
            r5.a((com.scwang.smartrefresh.layout.constant.RefreshState) r0)
            ja.e r0 = r5.f11994av
            r5.f11999b = r2
            int r1 = r5.f12015r
            int r3 = r5.f12016s
            r0.a((int) r2, (int) r1, (int) r3)
        L_0x00f9:
            int[] r0 = r5.f12023z
            if (r0 == 0) goto L_0x010d
            ja.h r1 = r5.f11992at
            if (r1 == 0) goto L_0x0104
            r1.setPrimaryColors(r0)
        L_0x0104:
            ja.h r0 = r5.f11993au
            if (r0 == 0) goto L_0x010d
            int[] r1 = r5.f12023z
            r0.setPrimaryColors(r1)
        L_0x010d:
            ja.e r0 = r5.f11994av
            if (r0 == 0) goto L_0x0118
            android.view.View r0 = r0.a()
            super.bringChildToFront(r0)
        L_0x0118:
            ja.h r0 = r5.f11992at
            if (r0 == 0) goto L_0x012d
            com.scwang.smartrefresh.layout.constant.b r0 = r0.getSpinnerStyle()
            boolean r0 = r0.f12106h
            if (r0 == 0) goto L_0x012d
            ja.h r0 = r5.f11992at
            android.view.View r0 = r0.getView()
            super.bringChildToFront(r0)
        L_0x012d:
            ja.h r0 = r5.f11993au
            if (r0 == 0) goto L_0x0142
            com.scwang.smartrefresh.layout.constant.b r0 = r0.getSpinnerStyle()
            boolean r0 = r0.f12106h
            if (r0 == 0) goto L_0x0142
            ja.h r0 = r5.f11993au
            android.view.View r0 = r0.getView()
            super.bringChildToFront(r0)
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onAttachedToWindow():void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aG = false;
        this.f11997ay.a(0, true);
        a(RefreshState.None);
        Handler handler = this.f11996ax;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.U = true;
        this.aO = null;
        ValueAnimator valueAnimator = this.aP;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.aP.removeAllUpdateListeners();
            this.aP.cancel();
            this.aP = null;
        }
        this.aH = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFinishInflate() {
        /*
            r11 = this;
            super.onFinishInflate()
            int r0 = super.getChildCount()
            r1 = 3
            if (r0 > r1) goto L_0x009e
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = 0
        L_0x000f:
            r7 = 2
            r8 = 1
            if (r4 >= r0) goto L_0x0033
            android.view.View r9 = super.getChildAt(r4)
            boolean r10 = jc.b.c(r9)
            if (r10 == 0) goto L_0x0024
            if (r6 < r7) goto L_0x0021
            if (r4 != r8) goto L_0x0024
        L_0x0021:
            r5 = r4
            r6 = 2
            goto L_0x0030
        L_0x0024:
            boolean r7 = r9 instanceof ja.h
            if (r7 != 0) goto L_0x0030
            if (r6 >= r8) goto L_0x0030
            if (r4 <= 0) goto L_0x002e
            r6 = 1
            goto L_0x002f
        L_0x002e:
            r6 = 0
        L_0x002f:
            r5 = r4
        L_0x0030:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0033:
            if (r5 < 0) goto L_0x004d
            com.scwang.smartrefresh.layout.impl.a r4 = new com.scwang.smartrefresh.layout.impl.a
            android.view.View r6 = super.getChildAt(r5)
            r4.<init>(r6)
            r11.f11994av = r4
            if (r5 != r8) goto L_0x0048
            if (r0 != r1) goto L_0x0046
            r1 = 0
            goto L_0x004f
        L_0x0046:
            r1 = 0
            goto L_0x004e
        L_0x0048:
            if (r0 != r7) goto L_0x004d
            r1 = -1
            r7 = 1
            goto L_0x004f
        L_0x004d:
            r1 = -1
        L_0x004e:
            r7 = -1
        L_0x004f:
            r4 = 0
        L_0x0050:
            if (r4 >= r0) goto L_0x009d
            android.view.View r5 = super.getChildAt(r4)
            if (r4 == r1) goto L_0x008b
            if (r4 == r7) goto L_0x0065
            if (r1 != r2) goto L_0x0065
            ja.h r6 = r11.f11992at
            if (r6 != 0) goto L_0x0065
            boolean r6 = r5 instanceof ja.g
            if (r6 == 0) goto L_0x0065
            goto L_0x008b
        L_0x0065:
            if (r4 == r7) goto L_0x006d
            if (r7 != r2) goto L_0x009a
            boolean r6 = r5 instanceof ja.f
            if (r6 == 0) goto L_0x009a
        L_0x006d:
            boolean r6 = r11.B
            if (r6 != 0) goto L_0x0078
            boolean r6 = r11.U
            if (r6 != 0) goto L_0x0076
            goto L_0x0078
        L_0x0076:
            r6 = 0
            goto L_0x0079
        L_0x0078:
            r6 = 1
        L_0x0079:
            r11.B = r6
            boolean r6 = r5 instanceof ja.f
            if (r6 == 0) goto L_0x0082
            ja.f r5 = (ja.f) r5
            goto L_0x0088
        L_0x0082:
            com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper
            r6.<init>(r5)
            r5 = r6
        L_0x0088:
            r11.f11993au = r5
            goto L_0x009a
        L_0x008b:
            boolean r6 = r5 instanceof ja.g
            if (r6 == 0) goto L_0x0092
            ja.g r5 = (ja.g) r5
            goto L_0x0098
        L_0x0092:
            com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper r6 = new com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper
            r6.<init>(r5)
            r5 = r6
        L_0x0098:
            r11.f11992at = r5
        L_0x009a:
            int r4 = r4 + 1
            goto L_0x0050
        L_0x009d:
            return
        L_0x009e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "最多只支持3个子View，Most only support three sub view"
            r0.<init>(r1)
            goto L_0x00a7
        L_0x00a6:
            throw r0
        L_0x00a7:
            goto L_0x00a6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onFinishInflate():void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = super.getChildAt(i7);
            if (!(childAt.getVisibility() == 8 || childAt.getTag(R.string.srl_component_falsify) == childAt)) {
                e eVar = this.f11994av;
                boolean z3 = true;
                if (eVar != null && eVar.a() == childAt) {
                    boolean z4 = isInEditMode() && this.H && a(this.A) && this.f11992at != null;
                    View a2 = this.f11994av.a();
                    ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : aL;
                    int i8 = marginLayoutParams.leftMargin + paddingLeft;
                    int i9 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = a2.getMeasuredWidth() + i8;
                    int measuredHeight = a2.getMeasuredHeight() + i9;
                    if (z4 && a(this.E, this.f11992at)) {
                        int i10 = this.f11982aj;
                        i9 += i10;
                        measuredHeight += i10;
                    }
                    a2.layout(i8, i9, measuredWidth, measuredHeight);
                }
                h hVar = this.f11992at;
                if (hVar != null && hVar.getView() == childAt) {
                    boolean z5 = isInEditMode() && this.H && a(this.A);
                    View view = this.f11992at.getView();
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : aL;
                    int i11 = marginLayoutParams2.leftMargin;
                    int i12 = marginLayoutParams2.topMargin + this.f11986an;
                    int measuredWidth2 = view.getMeasuredWidth() + i11;
                    int measuredHeight2 = view.getMeasuredHeight() + i12;
                    if (!z5 && this.f11992at.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12099a) {
                        int i13 = this.f11982aj;
                        i12 -= i13;
                        measuredHeight2 -= i13;
                    }
                    view.layout(i11, i12, measuredWidth2, measuredHeight2);
                }
                h hVar2 = this.f11993au;
                if (hVar2 != null && hVar2.getView() == childAt) {
                    if (!isInEditMode() || !this.H || !a(this.B)) {
                        z3 = false;
                    }
                    View view2 = this.f11993au.getView();
                    ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : aL;
                    com.scwang.smartrefresh.layout.constant.b spinnerStyle = this.f11993au.getSpinnerStyle();
                    int i14 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.f11987ao;
                    if (this.S && this.T && this.G && this.f11994av != null && this.f11993au.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f12099a && a(this.B)) {
                        View a3 = this.f11994av.a();
                        ViewGroup.LayoutParams layoutParams4 = a3.getLayoutParams();
                        measuredHeight3 = a3.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f12103e) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.f11987ao;
                    } else {
                        if (z3 || spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f12102d || spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f12101c) {
                            i6 = this.f11984al;
                        } else if (spinnerStyle.f12107i && this.f11999b < 0) {
                            i6 = Math.max(a(this.B) ? -this.f11999b : 0, 0);
                        }
                        measuredHeight3 -= i6;
                    }
                    view2.layout(i14, measuredHeight3, view2.getMeasuredWidth() + i14, view2.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0201  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r16.isInEditMode()
            if (r3 == 0) goto L_0x0012
            boolean r3 = r0.H
            if (r3 == 0) goto L_0x0012
            r3 = 1
            goto L_0x0013
        L_0x0012:
            r3 = 0
        L_0x0013:
            int r6 = super.getChildCount()
            r7 = 0
            r8 = 0
        L_0x0019:
            if (r7 >= r6) goto L_0x02fd
            android.view.View r9 = super.getChildAt(r7)
            int r10 = r9.getVisibility()
            r11 = 8
            if (r10 == r11) goto L_0x02f8
            int r10 = com.scwang.smartrefresh.layout.R.string.srl_component_falsify
            java.lang.Object r10 = r9.getTag(r10)
            if (r10 != r9) goto L_0x0031
            goto L_0x02f8
        L_0x0031:
            ja.h r10 = r0.f11992at
            r13 = -2
            if (r10 == 0) goto L_0x014a
            android.view.View r10 = r10.getView()
            if (r10 != r9) goto L_0x014a
            ja.h r10 = r0.f11992at
            android.view.View r10 = r10.getView()
            android.view.ViewGroup$LayoutParams r15 = r10.getLayoutParams()
            boolean r4 = r15 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r4 == 0) goto L_0x004e
            r4 = r15
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            goto L_0x0050
        L_0x004e:
            android.view.ViewGroup$MarginLayoutParams r4 = aL
        L_0x0050:
            int r12 = r4.leftMargin
            int r14 = r4.rightMargin
            int r12 = r12 + r14
            int r14 = r15.width
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r1, r12, r14)
            int r14 = r0.f11982aj
            com.scwang.smartrefresh.layout.constant.a r11 = r0.f11983ak
            int r11 = r11.f12097m
            com.scwang.smartrefresh.layout.constant.a r5 = com.scwang.smartrefresh.layout.constant.a.f12090g
            int r5 = r5.f12097m
            if (r11 >= r5) goto L_0x00d8
            int r5 = r15.height
            if (r5 <= 0) goto L_0x008d
            int r5 = r15.height
            int r11 = r4.bottomMargin
            int r5 = r5 + r11
            int r11 = r4.topMargin
            int r5 = r5 + r11
            com.scwang.smartrefresh.layout.constant.a r11 = r0.f11983ak
            com.scwang.smartrefresh.layout.constant.a r14 = com.scwang.smartrefresh.layout.constant.a.f12088e
            boolean r11 = r11.a(r14)
            if (r11 == 0) goto L_0x008b
            int r11 = r15.height
            int r14 = r4.bottomMargin
            int r11 = r11 + r14
            int r14 = r4.topMargin
            int r11 = r11 + r14
            r0.f11982aj = r11
            com.scwang.smartrefresh.layout.constant.a r11 = com.scwang.smartrefresh.layout.constant.a.f12088e
            r0.f11983ak = r11
        L_0x008b:
            r14 = r5
            goto L_0x00d8
        L_0x008d:
            int r5 = r15.height
            if (r5 != r13) goto L_0x00d8
            ja.h r5 = r0.f11992at
            com.scwang.smartrefresh.layout.constant.b r5 = r5.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.b r11 = com.scwang.smartrefresh.layout.constant.b.f12103e
            if (r5 != r11) goto L_0x00a1
            com.scwang.smartrefresh.layout.constant.a r5 = r0.f11983ak
            boolean r5 = r5.f12098n
            if (r5 != 0) goto L_0x00d8
        L_0x00a1:
            int r5 = android.view.View.MeasureSpec.getSize(r18)
            int r11 = r4.bottomMargin
            int r5 = r5 - r11
            int r11 = r4.topMargin
            int r5 = r5 - r11
            r11 = 0
            int r5 = java.lang.Math.max(r5, r11)
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r11)
            r10.measure(r12, r15)
            int r11 = r10.getMeasuredHeight()
            if (r11 <= 0) goto L_0x00d8
            if (r11 == r5) goto L_0x00d7
            com.scwang.smartrefresh.layout.constant.a r5 = r0.f11983ak
            com.scwang.smartrefresh.layout.constant.a r14 = com.scwang.smartrefresh.layout.constant.a.f12086c
            boolean r5 = r5.a(r14)
            if (r5 == 0) goto L_0x00d7
            int r5 = r4.bottomMargin
            int r11 = r11 + r5
            int r5 = r4.topMargin
            int r11 = r11 + r5
            r0.f11982aj = r11
            com.scwang.smartrefresh.layout.constant.a r5 = com.scwang.smartrefresh.layout.constant.a.f12086c
            r0.f11983ak = r5
        L_0x00d7:
            r14 = -1
        L_0x00d8:
            ja.h r5 = r0.f11992at
            com.scwang.smartrefresh.layout.constant.b r5 = r5.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.b r11 = com.scwang.smartrefresh.layout.constant.b.f12103e
            if (r5 != r11) goto L_0x00e9
            int r14 = android.view.View.MeasureSpec.getSize(r18)
            r5 = -1
            r11 = 0
            goto L_0x0109
        L_0x00e9:
            ja.h r5 = r0.f11992at
            com.scwang.smartrefresh.layout.constant.b r5 = r5.getSpinnerStyle()
            boolean r5 = r5.f12107i
            if (r5 == 0) goto L_0x0107
            if (r3 != 0) goto L_0x0107
            boolean r5 = r0.A
            boolean r5 = r0.a((boolean) r5)
            if (r5 == 0) goto L_0x0100
            int r5 = r0.f11999b
            goto L_0x0101
        L_0x0100:
            r5 = 0
        L_0x0101:
            r11 = 0
            int r14 = java.lang.Math.max(r11, r5)
            goto L_0x0108
        L_0x0107:
            r11 = 0
        L_0x0108:
            r5 = -1
        L_0x0109:
            if (r14 == r5) goto L_0x011e
            int r5 = r4.bottomMargin
            int r14 = r14 - r5
            int r4 = r4.topMargin
            int r14 = r14 - r4
            int r4 = java.lang.Math.max(r14, r11)
            r5 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r5)
            r10.measure(r12, r4)
        L_0x011e:
            com.scwang.smartrefresh.layout.constant.a r4 = r0.f11983ak
            boolean r4 = r4.f12098n
            if (r4 != 0) goto L_0x013b
            com.scwang.smartrefresh.layout.constant.a r4 = r0.f11983ak
            com.scwang.smartrefresh.layout.constant.a r4 = r4.b()
            r0.f11983ak = r4
            ja.h r4 = r0.f11992at
            ja.i r5 = r0.f11997ay
            int r11 = r0.f11982aj
            float r12 = r0.f11988ap
            float r14 = (float) r11
            float r12 = r12 * r14
            int r12 = (int) r12
            r4.a((ja.i) r5, (int) r11, (int) r12)
        L_0x013b:
            if (r3 == 0) goto L_0x014a
            boolean r4 = r0.A
            boolean r4 = r0.a((boolean) r4)
            if (r4 == 0) goto L_0x014a
            int r4 = r10.getMeasuredHeight()
            int r8 = r8 + r4
        L_0x014a:
            ja.h r4 = r0.f11993au
            if (r4 == 0) goto L_0x0262
            android.view.View r4 = r4.getView()
            if (r4 != r9) goto L_0x0262
            ja.h r4 = r0.f11993au
            android.view.View r4 = r4.getView()
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            boolean r10 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x0166
            r10 = r5
            android.view.ViewGroup$MarginLayoutParams r10 = (android.view.ViewGroup.MarginLayoutParams) r10
            goto L_0x0168
        L_0x0166:
            android.view.ViewGroup$MarginLayoutParams r10 = aL
        L_0x0168:
            int r11 = r10.leftMargin
            int r12 = r10.rightMargin
            int r11 = r11 + r12
            int r12 = r5.width
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r1, r11, r12)
            int r12 = r0.f11984al
            com.scwang.smartrefresh.layout.constant.a r14 = r0.f11985am
            int r14 = r14.f12097m
            com.scwang.smartrefresh.layout.constant.a r15 = com.scwang.smartrefresh.layout.constant.a.f12090g
            int r15 = r15.f12097m
            if (r14 >= r15) goto L_0x01f0
            int r14 = r5.height
            if (r14 <= 0) goto L_0x01a4
            int r12 = r5.height
            int r13 = r10.topMargin
            int r12 = r12 + r13
            int r13 = r10.bottomMargin
            int r12 = r12 + r13
            com.scwang.smartrefresh.layout.constant.a r13 = r0.f11985am
            com.scwang.smartrefresh.layout.constant.a r14 = com.scwang.smartrefresh.layout.constant.a.f12088e
            boolean r13 = r13.a(r14)
            if (r13 == 0) goto L_0x01f0
            int r5 = r5.height
            int r13 = r10.topMargin
            int r5 = r5 + r13
            int r13 = r10.bottomMargin
            int r5 = r5 + r13
            r0.f11984al = r5
            com.scwang.smartrefresh.layout.constant.a r5 = com.scwang.smartrefresh.layout.constant.a.f12088e
            r0.f11985am = r5
            goto L_0x01f0
        L_0x01a4:
            int r5 = r5.height
            if (r5 != r13) goto L_0x01f0
            ja.h r5 = r0.f11993au
            com.scwang.smartrefresh.layout.constant.b r5 = r5.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.b r13 = com.scwang.smartrefresh.layout.constant.b.f12103e
            if (r5 != r13) goto L_0x01b8
            com.scwang.smartrefresh.layout.constant.a r5 = r0.f11985am
            boolean r5 = r5.f12098n
            if (r5 != 0) goto L_0x01f0
        L_0x01b8:
            int r5 = android.view.View.MeasureSpec.getSize(r18)
            int r13 = r10.bottomMargin
            int r5 = r5 - r13
            int r13 = r10.topMargin
            int r5 = r5 - r13
            r13 = 0
            int r5 = java.lang.Math.max(r5, r13)
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r13)
            r4.measure(r11, r13)
            int r13 = r4.getMeasuredHeight()
            if (r13 <= 0) goto L_0x01f0
            if (r13 == r5) goto L_0x01ee
            com.scwang.smartrefresh.layout.constant.a r5 = r0.f11985am
            com.scwang.smartrefresh.layout.constant.a r12 = com.scwang.smartrefresh.layout.constant.a.f12086c
            boolean r5 = r5.a(r12)
            if (r5 == 0) goto L_0x01ee
            int r5 = r10.topMargin
            int r13 = r13 + r5
            int r5 = r10.bottomMargin
            int r13 = r13 + r5
            r0.f11984al = r13
            com.scwang.smartrefresh.layout.constant.a r5 = com.scwang.smartrefresh.layout.constant.a.f12086c
            r0.f11985am = r5
        L_0x01ee:
            r5 = -1
            goto L_0x01f1
        L_0x01f0:
            r5 = r12
        L_0x01f1:
            ja.h r12 = r0.f11993au
            com.scwang.smartrefresh.layout.constant.b r12 = r12.getSpinnerStyle()
            com.scwang.smartrefresh.layout.constant.b r13 = com.scwang.smartrefresh.layout.constant.b.f12103e
            if (r12 != r13) goto L_0x0201
            int r5 = android.view.View.MeasureSpec.getSize(r18)
        L_0x01ff:
            r12 = 0
            goto L_0x021f
        L_0x0201:
            ja.h r12 = r0.f11993au
            com.scwang.smartrefresh.layout.constant.b r12 = r12.getSpinnerStyle()
            boolean r12 = r12.f12107i
            if (r12 == 0) goto L_0x01ff
            if (r3 != 0) goto L_0x01ff
            boolean r5 = r0.B
            boolean r5 = r0.a((boolean) r5)
            if (r5 == 0) goto L_0x0219
            int r5 = r0.f11999b
            int r5 = -r5
            goto L_0x021a
        L_0x0219:
            r5 = 0
        L_0x021a:
            r12 = 0
            int r5 = java.lang.Math.max(r12, r5)
        L_0x021f:
            r13 = -1
            if (r5 == r13) goto L_0x0235
            int r13 = r10.bottomMargin
            int r5 = r5 - r13
            int r10 = r10.topMargin
            int r5 = r5 - r10
            int r5 = java.lang.Math.max(r5, r12)
            r10 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            r4.measure(r11, r5)
        L_0x0235:
            com.scwang.smartrefresh.layout.constant.a r5 = r0.f11985am
            boolean r5 = r5.f12098n
            if (r5 != 0) goto L_0x0252
            com.scwang.smartrefresh.layout.constant.a r5 = r0.f11985am
            com.scwang.smartrefresh.layout.constant.a r5 = r5.b()
            r0.f11985am = r5
            ja.h r5 = r0.f11993au
            ja.i r10 = r0.f11997ay
            int r11 = r0.f11984al
            float r13 = r0.f11989aq
            float r14 = (float) r11
            float r13 = r13 * r14
            int r13 = (int) r13
            r5.a((ja.i) r10, (int) r11, (int) r13)
        L_0x0252:
            if (r3 == 0) goto L_0x0263
            boolean r5 = r0.B
            boolean r5 = r0.a((boolean) r5)
            if (r5 == 0) goto L_0x0263
            int r4 = r4.getMeasuredHeight()
            int r8 = r8 + r4
            goto L_0x0263
        L_0x0262:
            r12 = 0
        L_0x0263:
            ja.e r4 = r0.f11994av
            if (r4 == 0) goto L_0x02f9
            android.view.View r4 = r4.a()
            if (r4 != r9) goto L_0x02f9
            ja.e r4 = r0.f11994av
            android.view.View r4 = r4.a()
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            boolean r9 = r5 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r9 == 0) goto L_0x027f
            r9 = r5
            android.view.ViewGroup$MarginLayoutParams r9 = (android.view.ViewGroup.MarginLayoutParams) r9
            goto L_0x0281
        L_0x027f:
            android.view.ViewGroup$MarginLayoutParams r9 = aL
        L_0x0281:
            ja.h r10 = r0.f11992at
            if (r10 == 0) goto L_0x0299
            boolean r10 = r0.A
            boolean r10 = r0.a((boolean) r10)
            if (r10 == 0) goto L_0x0299
            boolean r10 = r0.E
            ja.h r11 = r0.f11992at
            boolean r10 = r0.a((boolean) r10, (ja.h) r11)
            if (r10 == 0) goto L_0x0299
            r11 = 1
            goto L_0x029a
        L_0x0299:
            r11 = 0
        L_0x029a:
            ja.h r10 = r0.f11993au
            if (r10 == 0) goto L_0x02b2
            boolean r10 = r0.B
            boolean r10 = r0.a((boolean) r10)
            if (r10 == 0) goto L_0x02b2
            boolean r10 = r0.F
            ja.h r13 = r0.f11993au
            boolean r10 = r0.a((boolean) r10, (ja.h) r13)
            if (r10 == 0) goto L_0x02b2
            r10 = 1
            goto L_0x02b3
        L_0x02b2:
            r10 = 0
        L_0x02b3:
            int r13 = r16.getPaddingLeft()
            int r14 = r16.getPaddingRight()
            int r13 = r13 + r14
            int r14 = r9.leftMargin
            int r13 = r13 + r14
            int r14 = r9.rightMargin
            int r13 = r13 + r14
            int r14 = r5.width
            int r13 = android.view.ViewGroup.getChildMeasureSpec(r1, r13, r14)
            int r14 = r16.getPaddingTop()
            int r15 = r16.getPaddingBottom()
            int r14 = r14 + r15
            int r15 = r9.topMargin
            int r14 = r14 + r15
            int r9 = r9.bottomMargin
            int r14 = r14 + r9
            if (r3 == 0) goto L_0x02de
            if (r11 == 0) goto L_0x02de
            int r11 = r0.f11982aj
            goto L_0x02df
        L_0x02de:
            r11 = 0
        L_0x02df:
            int r14 = r14 + r11
            if (r3 == 0) goto L_0x02e7
            if (r10 == 0) goto L_0x02e7
            int r11 = r0.f11984al
            goto L_0x02e8
        L_0x02e7:
            r11 = 0
        L_0x02e8:
            int r14 = r14 + r11
            int r5 = r5.height
            int r5 = android.view.ViewGroup.getChildMeasureSpec(r2, r14, r5)
            r4.measure(r13, r5)
            int r4 = r4.getMeasuredHeight()
            int r8 = r8 + r4
            goto L_0x02f9
        L_0x02f8:
            r12 = 0
        L_0x02f9:
            int r7 = r7 + 1
            goto L_0x0019
        L_0x02fd:
            int r3 = super.getSuggestedMinimumWidth()
            int r1 = android.view.View.resolveSize(r3, r1)
            int r2 = android.view.View.resolveSize(r8, r2)
            super.setMeasuredDimension(r1, r2)
            int r1 = r16.getMeasuredWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            r0.f12007j = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return this.f11980ah.a(f2, f3, z2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return (this.aH && f3 > 0.0f) || a(-f3) || this.f11980ah.a(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        int i4 = this.f11977ae;
        int i5 = 0;
        if (i3 * i4 > 0) {
            if (Math.abs(i3) > Math.abs(this.f11977ae)) {
                int i6 = this.f11977ae;
                this.f11977ae = 0;
                i5 = i6;
            } else {
                this.f11977ae -= i3;
                i5 = i3;
            }
            c((float) this.f11977ae);
        } else if (i3 > 0 && this.aH) {
            int i7 = i4 - i3;
            this.f11977ae = i7;
            c((float) i7);
            i5 = i3;
        }
        this.f11980ah.a(i2, i3 - i5, iArr, (int[]) null);
        iArr[1] = iArr[1] + i5;
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        k kVar;
        k kVar2;
        boolean a2 = this.f11980ah.a(i2, i3, i4, i5, this.f11979ag);
        int i6 = i5 + this.f11979ag[1];
        if ((i6 < 0 && ((this.A || this.J) && (this.f11977ae != 0 || (kVar2 = this.f11976ad) == null || kVar2.a(this.f11994av.a())))) || (i6 > 0 && ((this.B || this.J) && (this.f11977ae != 0 || (kVar = this.f11976ad) == null || kVar.b(this.f11994av.a()))))) {
            if (this.aA == RefreshState.None || this.aA.f12081v) {
                this.f11997ay.a(i6 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!a2) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i7 = this.f11977ae - i6;
            this.f11977ae = i7;
            c((float) i7);
        }
        if (this.aH && i3 < 0) {
            this.aH = false;
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f11981ai.a(view, view2, i2);
        this.f11980ah.b(i2 & 2);
        this.f11977ae = this.f11999b;
        this.f11978af = true;
        a(0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0) && (this.J || this.A || this.B);
    }

    public void onStopNestedScroll(View view) {
        this.f11981ai.a(view);
        this.f11978af = false;
        this.f11977ae = 0;
        a();
        this.f11980ah.c();
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.P = z2;
        this.f11980ah.a(z2);
    }

    /* access modifiers changed from: protected */
    public void setStateDirectLoading(boolean z2) {
        if (this.f11998az != RefreshState.Loading) {
            this.aB = System.currentTimeMillis();
            this.aH = true;
            a(RefreshState.Loading);
            jb.b bVar = this.f11974ab;
            if (bVar != null) {
                if (z2) {
                    bVar.onLoadMore(this);
                }
            } else if (this.f11975ac == null) {
                c((int) GSYVideoView.CHANGE_DELAY_TIME);
            }
            h hVar = this.f11993au;
            if (hVar != null) {
                int i2 = this.f11984al;
                hVar.b(this, i2, (int) (this.f11989aq * ((float) i2)));
            }
            jb.c cVar = this.f11975ac;
            if (cVar != null && (this.f11993au instanceof f)) {
                if (z2) {
                    cVar.onLoadMore(this);
                }
                int i3 = this.f11984al;
                this.f11975ac.b((f) this.f11993au, i3, (int) (this.f11989aq * ((float) i3)));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setStateLoading(final boolean z2) {
        AnonymousClass1 r0 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.setStateDirectLoading(z2);
            }
        };
        a(RefreshState.LoadReleased);
        ValueAnimator a2 = this.f11997ay.a(-this.f11984al);
        if (a2 != null) {
            a2.addListener(r0);
        }
        h hVar = this.f11993au;
        if (hVar != null) {
            int i2 = this.f11984al;
            hVar.a((j) this, i2, (int) (this.f11989aq * ((float) i2)));
        }
        jb.c cVar = this.f11975ac;
        if (cVar != null) {
            h hVar2 = this.f11993au;
            if (hVar2 instanceof f) {
                int i3 = this.f11984al;
                cVar.a((f) hVar2, i3, (int) (this.f11989aq * ((float) i3)));
            }
        }
        if (a2 == null) {
            r0.onAnimationEnd((Animator) null);
        }
    }

    /* access modifiers changed from: protected */
    public void setStateRefreshing(final boolean z2) {
        AnonymousClass3 r0 = new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.aB = System.currentTimeMillis();
                SmartRefreshLayout.this.a(RefreshState.Refreshing);
                if (SmartRefreshLayout.this.f11973aa != null) {
                    if (z2) {
                        SmartRefreshLayout.this.f11973aa.onRefresh(SmartRefreshLayout.this);
                    }
                } else if (SmartRefreshLayout.this.f11975ac == null) {
                    SmartRefreshLayout.this.b(3000);
                }
                if (SmartRefreshLayout.this.f11992at != null) {
                    h hVar = SmartRefreshLayout.this.f11992at;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    hVar.b(smartRefreshLayout, smartRefreshLayout.f11982aj, (int) (SmartRefreshLayout.this.f11988ap * ((float) SmartRefreshLayout.this.f11982aj)));
                }
                if (SmartRefreshLayout.this.f11975ac != null && (SmartRefreshLayout.this.f11992at instanceof g)) {
                    if (z2) {
                        SmartRefreshLayout.this.f11975ac.onRefresh(SmartRefreshLayout.this);
                    }
                    SmartRefreshLayout.this.f11975ac.b((g) SmartRefreshLayout.this.f11992at, SmartRefreshLayout.this.f11982aj, (int) (SmartRefreshLayout.this.f11988ap * ((float) SmartRefreshLayout.this.f11982aj)));
                }
            }
        };
        a(RefreshState.RefreshReleased);
        ValueAnimator a2 = this.f11997ay.a(this.f11982aj);
        if (a2 != null) {
            a2.addListener(r0);
        }
        h hVar = this.f11992at;
        if (hVar != null) {
            int i2 = this.f11982aj;
            hVar.a((j) this, i2, (int) (this.f11988ap * ((float) i2)));
        }
        jb.c cVar = this.f11975ac;
        if (cVar != null) {
            h hVar2 = this.f11992at;
            if (hVar2 instanceof g) {
                int i3 = this.f11982aj;
                cVar.a((g) hVar2, i3, (int) (this.f11988ap * ((float) i3)));
            }
        }
        if (a2 == null) {
            r0.onAnimationEnd((Animator) null);
        }
    }

    /* access modifiers changed from: protected */
    public void setViceState(RefreshState refreshState) {
        if (this.f11998az.f12080u && this.f11998az.f12077r != refreshState.f12077r) {
            a(RefreshState.None);
        }
        if (this.aA != refreshState) {
            this.aA = refreshState;
        }
    }
}
