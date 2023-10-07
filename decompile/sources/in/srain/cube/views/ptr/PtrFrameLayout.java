package in.srain.cube.views.ptr;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

public class PtrFrameLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13643a = false;

    /* renamed from: e  reason: collision with root package name */
    private static int f13644e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static byte f13645f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static byte f13646g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static byte f13647h = 4;

    /* renamed from: i  reason: collision with root package name */
    private static byte f13648i = 8;

    /* renamed from: j  reason: collision with root package name */
    private static byte f13649j = 3;
    private d A;
    private int B;
    private long C;
    /* access modifiers changed from: private */
    public lq.a D;
    private boolean E;
    private Runnable F;

    /* renamed from: b  reason: collision with root package name */
    protected final String f13650b;

    /* renamed from: c  reason: collision with root package name */
    protected View f13651c;

    /* renamed from: d  reason: collision with root package name */
    private byte f13652d;

    /* renamed from: k  reason: collision with root package name */
    private int f13653k;

    /* renamed from: l  reason: collision with root package name */
    private int f13654l;

    /* renamed from: m  reason: collision with root package name */
    private int f13655m;

    /* renamed from: n  reason: collision with root package name */
    private int f13656n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f13657o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f13658p;

    /* renamed from: q  reason: collision with root package name */
    private View f13659q;

    /* renamed from: r  reason: collision with root package name */
    private c f13660r;

    /* renamed from: s  reason: collision with root package name */
    private a f13661s;

    /* renamed from: t  reason: collision with root package name */
    private a f13662t;

    /* renamed from: u  reason: collision with root package name */
    private int f13663u;

    /* renamed from: v  reason: collision with root package name */
    private int f13664v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f13665w;

    /* renamed from: x  reason: collision with root package name */
    private int f13666x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13667y;

    /* renamed from: z  reason: collision with root package name */
    private MotionEvent f13668z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f13672b;

        /* renamed from: c  reason: collision with root package name */
        private Scroller f13673c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f13674d = false;

        /* renamed from: e  reason: collision with root package name */
        private int f13675e;

        /* renamed from: f  reason: collision with root package name */
        private int f13676f;

        public a() {
            this.f13673c = new Scroller(PtrFrameLayout.this.getContext());
        }

        private void b() {
            if (PtrFrameLayout.f13643a) {
                lr.a.a(PtrFrameLayout.this.f13650b, "finish, currentPos:%s", Integer.valueOf(PtrFrameLayout.this.D.k()));
            }
            c();
            PtrFrameLayout.this.b();
        }

        private void c() {
            this.f13674d = false;
            this.f13672b = 0;
            PtrFrameLayout.this.removeCallbacks(this);
        }

        /* access modifiers changed from: private */
        public void d() {
            c();
            if (!this.f13673c.isFinished()) {
                this.f13673c.forceFinished(true);
            }
        }

        public void a() {
            if (this.f13674d) {
                if (!this.f13673c.isFinished()) {
                    this.f13673c.forceFinished(true);
                }
                PtrFrameLayout.this.a();
                c();
            }
        }

        public void a(int i2, int i3) {
            if (!PtrFrameLayout.this.D.e(i2)) {
                int k2 = PtrFrameLayout.this.D.k();
                this.f13675e = k2;
                this.f13676f = i2;
                int i4 = i2 - k2;
                if (PtrFrameLayout.f13643a) {
                    lr.a.b(PtrFrameLayout.this.f13650b, "tryToScrollTo: start: %s, distance:%s, to:%s", Integer.valueOf(this.f13675e), Integer.valueOf(i4), Integer.valueOf(i2));
                }
                PtrFrameLayout.this.removeCallbacks(this);
                this.f13672b = 0;
                if (!this.f13673c.isFinished()) {
                    this.f13673c.forceFinished(true);
                }
                this.f13673c.startScroll(0, 0, 0, i4, i3);
                PtrFrameLayout.this.post(this);
                this.f13674d = true;
            }
        }

        public void run() {
            boolean z2 = !this.f13673c.computeScrollOffset() || this.f13673c.isFinished();
            int currY = this.f13673c.getCurrY();
            int i2 = currY - this.f13672b;
            if (PtrFrameLayout.f13643a && i2 != 0) {
                lr.a.a(PtrFrameLayout.this.f13650b, "scroll: %s, start: %s, to: %s, currentPos: %s, current :%s, last: %s, delta: %s", Boolean.valueOf(z2), Integer.valueOf(this.f13675e), Integer.valueOf(this.f13676f), Integer.valueOf(PtrFrameLayout.this.D.k()), Integer.valueOf(currY), Integer.valueOf(this.f13672b), Integer.valueOf(i2));
            }
            if (!z2) {
                this.f13672b = currY;
                PtrFrameLayout.this.a((float) i2);
                PtrFrameLayout.this.post(this);
                return;
            }
            b();
        }
    }

    public PtrFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PtrFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13652d = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("ptr-frame-");
        int i3 = f13644e + 1;
        f13644e = i3;
        sb.append(i3);
        this.f13650b = sb.toString();
        this.f13653k = 0;
        this.f13654l = 0;
        this.f13655m = 200;
        this.f13656n = 1000;
        this.f13657o = true;
        this.f13658p = false;
        this.f13660r = c.b();
        this.f13665w = false;
        this.f13666x = 0;
        this.f13667y = false;
        this.B = 500;
        this.C = 0;
        this.E = false;
        this.F = new Runnable() {
            public void run() {
                PtrFrameLayout.this.o();
            }
        };
        this.D = new lq.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PtrFrameLayout, 0, 0);
        if (obtainStyledAttributes != null) {
            this.f13653k = obtainStyledAttributes.getResourceId(R.styleable.PtrFrameLayout_ptr_header, this.f13653k);
            this.f13654l = obtainStyledAttributes.getResourceId(R.styleable.PtrFrameLayout_ptr_content, this.f13654l);
            this.D.a(obtainStyledAttributes.getFloat(R.styleable.PtrFrameLayout_ptr_resistance, this.D.b()));
            this.f13655m = obtainStyledAttributes.getInt(R.styleable.PtrFrameLayout_ptr_duration_to_close, this.f13655m);
            this.f13656n = obtainStyledAttributes.getInt(R.styleable.PtrFrameLayout_ptr_duration_to_close_header, this.f13656n);
            this.D.b(obtainStyledAttributes.getFloat(R.styleable.PtrFrameLayout_ptr_ratio_of_header_height_to_refresh, this.D.f()));
            this.f13657o = obtainStyledAttributes.getBoolean(R.styleable.PtrFrameLayout_ptr_keep_header_when_refresh, this.f13657o);
            this.f13658p = obtainStyledAttributes.getBoolean(R.styleable.PtrFrameLayout_ptr_pull_to_fresh, this.f13658p);
            obtainStyledAttributes.recycle();
        }
        this.f13662t = new a();
        this.f13663u = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
    }

    /* access modifiers changed from: private */
    public void a(float f2) {
        int i2 = 0;
        if (f2 >= 0.0f || !this.D.r()) {
            int k2 = this.D.k() + ((int) f2);
            if (!this.D.f(k2)) {
                i2 = k2;
            } else if (f13643a) {
                lr.a.c(this.f13650b, String.format("over top", new Object[0]));
            }
            this.D.b(i2);
            a(i2 - this.D.j());
        } else if (f13643a) {
            lr.a.c(this.f13650b, String.format("has reached the top", new Object[0]));
        }
    }

    private void a(int i2) {
        if (i2 != 0) {
            boolean a2 = this.D.a();
            if (a2 && !this.E && this.D.q()) {
                this.E = true;
                r();
            }
            if ((this.D.n() && this.f13652d == 1) || (this.D.e() && this.f13652d == 4 && d())) {
                this.f13652d = 2;
                this.f13660r.b(this);
                if (f13643a) {
                    lr.a.c(this.f13650b, "PtrUIHandler: onUIRefreshPrepare, mFlag %s", Integer.valueOf(this.f13666x));
                }
            }
            if (this.D.o()) {
                n();
                if (a2) {
                    s();
                }
            }
            if (this.f13652d == 2) {
                if (a2 && !c() && this.f13658p && this.D.s()) {
                    l();
                }
                if (q() && this.D.t()) {
                    l();
                }
            }
            if (f13643a) {
                lr.a.a(this.f13650b, "updatePos: change: %s, current: %s last: %s, top: %s, headerHeight: %s", Integer.valueOf(i2), Integer.valueOf(this.D.k()), Integer.valueOf(this.D.j()), Integer.valueOf(this.f13651c.getTop()), Integer.valueOf(this.f13664v));
            }
            this.f13659q.offsetTopAndBottom(i2);
            if (!e()) {
                this.f13651c.offsetTopAndBottom(i2);
            }
            invalidate();
            if (this.f13660r.a()) {
                this.f13660r.a(this, a2, this.f13652d, this.D);
            }
            a(a2, this.f13652d, this.D);
        }
    }

    private void a(View view, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin, marginLayoutParams.height));
    }

    private void a(boolean z2) {
        l();
        byte b2 = this.f13652d;
        if (b2 == 3) {
            if (!this.f13657o) {
                i();
            } else if (this.D.u() && !z2) {
                this.f13662t.a(this.D.v(), this.f13655m);
            }
        } else if (b2 == 4) {
            b(false);
        } else {
            k();
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (!this.D.m() || z2 || this.A == null) {
            if (this.f13660r.a()) {
                if (f13643a) {
                    lr.a.b(this.f13650b, "PtrUIHandler: onUIRefreshComplete");
                }
                this.f13660r.d(this);
            }
            this.D.d();
            j();
            n();
            return;
        }
        if (f13643a) {
            lr.a.a(this.f13650b, "notifyUIRefreshComplete mRefreshCompleteHook run.");
        }
        this.A.a();
    }

    private void g() {
        int k2 = this.D.k();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        View view = this.f13659q;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i2 = marginLayoutParams.leftMargin + paddingLeft;
            int i3 = ((marginLayoutParams.topMargin + paddingTop) + k2) - this.f13664v;
            int measuredWidth = this.f13659q.getMeasuredWidth() + i2;
            int measuredHeight = this.f13659q.getMeasuredHeight() + i3;
            this.f13659q.layout(i2, i3, measuredWidth, measuredHeight);
            if (f13643a) {
                lr.a.b(this.f13650b, "onLayout header: %s %s %s %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            }
        }
        if (this.f13651c != null) {
            if (e()) {
                k2 = 0;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13651c.getLayoutParams();
            int i4 = paddingLeft + marginLayoutParams2.leftMargin;
            int i5 = paddingTop + marginLayoutParams2.topMargin + k2;
            int measuredWidth2 = this.f13651c.getMeasuredWidth() + i4;
            int measuredHeight2 = this.f13651c.getMeasuredHeight() + i5;
            if (f13643a) {
                lr.a.b(this.f13650b, "onLayout content: %s %s %s %s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(measuredWidth2), Integer.valueOf(measuredHeight2));
            }
            this.f13651c.layout(i4, i5, measuredWidth2, measuredHeight2);
        }
    }

    private void h() {
        if (!this.D.a()) {
            this.f13662t.a(0, this.f13656n);
        }
    }

    private void i() {
        h();
    }

    private void j() {
        h();
    }

    private void k() {
        h();
    }

    private boolean l() {
        if (this.f13652d != 2) {
            return false;
        }
        if ((this.D.u() && c()) || this.D.p()) {
            this.f13652d = 3;
            m();
        }
        return false;
    }

    private void m() {
        this.C = System.currentTimeMillis();
        if (this.f13660r.a()) {
            this.f13660r.c(this);
            if (f13643a) {
                lr.a.b(this.f13650b, "PtrUIHandler: onUIRefreshBegin");
            }
        }
        a aVar = this.f13661s;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private boolean n() {
        byte b2 = this.f13652d;
        if ((b2 != 4 && b2 != 2) || !this.D.r()) {
            return false;
        }
        if (this.f13660r.a()) {
            this.f13660r.a(this);
            if (f13643a) {
                lr.a.b(this.f13650b, "PtrUIHandler: onUIReset");
            }
        }
        this.f13652d = 1;
        p();
        return true;
    }

    /* access modifiers changed from: private */
    public void o() {
        this.f13652d = 4;
        if (!this.f13662t.f13674d || !c()) {
            b(false);
        } else if (f13643a) {
            lr.a.b(this.f13650b, "performRefreshComplete do nothing, scrolling: %s, auto refresh: %s", Boolean.valueOf(this.f13662t.f13674d), Integer.valueOf(this.f13666x));
        }
    }

    private void p() {
        this.f13666x &= f13649j ^ -1;
    }

    private boolean q() {
        return (this.f13666x & f13649j) == f13646g;
    }

    private void r() {
        if (f13643a) {
            lr.a.a(this.f13650b, "send cancel event");
        }
        MotionEvent motionEvent = this.f13668z;
        if (motionEvent != null) {
            a(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime() + ((long) ViewConfiguration.getLongPressTimeout()), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
        }
    }

    private void s() {
        if (f13643a) {
            lr.a.a(this.f13650b, "send down event");
        }
        MotionEvent motionEvent = this.f13668z;
        a(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 0, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState()));
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.D.m() && c()) {
            if (f13643a) {
                lr.a.a(this.f13650b, "call onRelease after scroll abort");
            }
            a(true);
        }
    }

    public void a(b bVar) {
        c.a(this.f13660r, bVar);
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2, byte b2, lq.a aVar) {
    }

    public boolean a(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.D.m() && c()) {
            if (f13643a) {
                lr.a.a(this.f13650b, "call onRelease after scroll finish");
            }
            a(true);
        }
    }

    public boolean c() {
        return (this.f13666x & f13649j) > 0;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean d() {
        return (this.f13666x & f13647h) > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r0 != 3) goto L_0x00e9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            boolean r0 = r12.isEnabled()
            if (r0 == 0) goto L_0x0139
            android.view.View r0 = r12.f13651c
            if (r0 == 0) goto L_0x0139
            android.view.View r0 = r12.f13659q
            if (r0 != 0) goto L_0x0010
            goto L_0x0139
        L_0x0010:
            int r0 = r13.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x011f
            if (r0 == r2) goto L_0x00ee
            r3 = 3
            r4 = 2
            if (r0 == r4) goto L_0x0022
            if (r0 == r3) goto L_0x00ee
            goto L_0x00e9
        L_0x0022:
            r12.f13668z = r13
            lq.a r0 = r12.D
            float r5 = r13.getX()
            float r6 = r13.getY()
            r0.b(r5, r6)
            lq.a r0 = r12.D
            float r0 = r0.h()
            lq.a r5 = r12.D
            float r5 = r5.i()
            boolean r6 = r12.f13665w
            if (r6 == 0) goto L_0x0066
            boolean r6 = r12.f13667y
            if (r6 != 0) goto L_0x0066
            float r6 = java.lang.Math.abs(r0)
            int r7 = r12.f13663u
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x0066
            float r0 = java.lang.Math.abs(r0)
            float r6 = java.lang.Math.abs(r5)
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0066
            lq.a r0 = r12.D
            boolean r0 = r0.r()
            if (r0 == 0) goto L_0x0066
            r12.f13667y = r2
        L_0x0066:
            boolean r0 = r12.f13667y
            if (r0 == 0) goto L_0x006f
            boolean r13 = r12.a((android.view.MotionEvent) r13)
            return r13
        L_0x006f:
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0076
            r0 = 1
            goto L_0x0077
        L_0x0076:
            r0 = 0
        L_0x0077:
            r6 = r0 ^ 1
            lq.a r7 = r12.D
            boolean r7 = r7.m()
            boolean r8 = f13643a
            if (r8 == 0) goto L_0x00ca
            in.srain.cube.views.ptr.a r8 = r12.f13661s
            if (r8 == 0) goto L_0x0093
            android.view.View r9 = r12.f13651c
            android.view.View r10 = r12.f13659q
            boolean r8 = r8.a(r12, r9, r10)
            if (r8 == 0) goto L_0x0093
            r8 = 1
            goto L_0x0094
        L_0x0093:
            r8 = 0
        L_0x0094:
            java.lang.String r9 = r12.f13650b
            r10 = 6
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.Float r11 = java.lang.Float.valueOf(r5)
            r10[r1] = r11
            lq.a r1 = r12.D
            int r1 = r1.k()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10[r2] = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r6)
            r10[r4] = r1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)
            r10[r3] = r1
            r1 = 4
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
            r10[r1] = r3
            r1 = 5
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r8)
            r10[r1] = r3
            java.lang.String r1 = "ACTION_MOVE: offsetY:%s, currentPos: %s, moveUp: %s, canMoveUp: %s, moveDown: %s: canMoveDown: %s"
            lr.a.a(r9, r1, r10)
        L_0x00ca:
            if (r0 == 0) goto L_0x00df
            in.srain.cube.views.ptr.a r1 = r12.f13661s
            if (r1 == 0) goto L_0x00df
            android.view.View r3 = r12.f13651c
            android.view.View r4 = r12.f13659q
            boolean r1 = r1.a(r12, r3, r4)
            if (r1 != 0) goto L_0x00df
            boolean r13 = r12.a((android.view.MotionEvent) r13)
            return r13
        L_0x00df:
            if (r6 == 0) goto L_0x00e3
            if (r7 != 0) goto L_0x00e5
        L_0x00e3:
            if (r0 == 0) goto L_0x00e9
        L_0x00e5:
            r12.a((float) r5)
            return r2
        L_0x00e9:
            boolean r13 = r12.a((android.view.MotionEvent) r13)
            return r13
        L_0x00ee:
            lq.a r0 = r12.D
            r0.c()
            lq.a r0 = r12.D
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x011a
            boolean r0 = f13643a
            if (r0 == 0) goto L_0x0106
            java.lang.String r0 = r12.f13650b
            java.lang.String r3 = "call onRelease when user release"
            lr.a.a(r0, r3)
        L_0x0106:
            r12.a((boolean) r1)
            lq.a r0 = r12.D
            boolean r0 = r0.q()
            if (r0 == 0) goto L_0x0115
            r12.r()
            return r2
        L_0x0115:
            boolean r13 = r12.a((android.view.MotionEvent) r13)
            return r13
        L_0x011a:
            boolean r13 = r12.a((android.view.MotionEvent) r13)
            return r13
        L_0x011f:
            r12.E = r1
            lq.a r0 = r12.D
            float r3 = r13.getX()
            float r4 = r13.getY()
            r0.a((float) r3, (float) r4)
            in.srain.cube.views.ptr.PtrFrameLayout$a r0 = r12.f13662t
            r0.a()
            r12.f13667y = r1
            r12.a((android.view.MotionEvent) r13)
            return r2
        L_0x0139:
            boolean r13 = r12.a((android.view.MotionEvent) r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: in.srain.cube.views.ptr.PtrFrameLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean e() {
        return (this.f13666x & f13648i) > 0;
    }

    public boolean f() {
        return this.f13658p;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public View getContentView() {
        return this.f13651c;
    }

    public float getDurationToClose() {
        return (float) this.f13655m;
    }

    public long getDurationToCloseHeader() {
        return (long) this.f13656n;
    }

    public int getHeaderHeight() {
        return this.f13664v;
    }

    public View getHeaderView() {
        return this.f13659q;
    }

    public int getOffsetToKeepHeaderWhileLoading() {
        return this.D.v();
    }

    public int getOffsetToRefresh() {
        return this.D.g();
    }

    public float getRatioOfHeaderToHeightRefresh() {
        return this.D.f();
    }

    public float getResistance() {
        return this.D.b();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f13662t;
        if (aVar != null) {
            aVar.d();
        }
        Runnable runnable = this.F;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onFinishInflate() {
        /*
            r4 = this;
            int r0 = r4.getChildCount()
            r1 = 2
            if (r0 > r1) goto L_0x0098
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x005e
            int r0 = r4.f13653k
            if (r0 == 0) goto L_0x0019
            android.view.View r1 = r4.f13659q
            if (r1 != 0) goto L_0x0019
            android.view.View r0 = r4.findViewById(r0)
            r4.f13659q = r0
        L_0x0019:
            int r0 = r4.f13654l
            if (r0 == 0) goto L_0x0027
            android.view.View r1 = r4.f13651c
            if (r1 != 0) goto L_0x0027
            android.view.View r0 = r4.findViewById(r0)
            r4.f13651c = r0
        L_0x0027:
            android.view.View r0 = r4.f13651c
            if (r0 == 0) goto L_0x002f
            android.view.View r0 = r4.f13659q
            if (r0 != 0) goto L_0x008d
        L_0x002f:
            android.view.View r0 = r4.getChildAt(r2)
            android.view.View r1 = r4.getChildAt(r3)
            boolean r2 = r0 instanceof in.srain.cube.views.ptr.b
            if (r2 == 0) goto L_0x0040
        L_0x003b:
            r4.f13659q = r0
            r4.f13651c = r1
            goto L_0x008d
        L_0x0040:
            boolean r2 = r1 instanceof in.srain.cube.views.ptr.b
            if (r2 == 0) goto L_0x0047
            r4.f13659q = r1
            goto L_0x0064
        L_0x0047:
            android.view.View r2 = r4.f13651c
            if (r2 != 0) goto L_0x0050
            android.view.View r3 = r4.f13659q
            if (r3 != 0) goto L_0x0050
            goto L_0x003b
        L_0x0050:
            android.view.View r3 = r4.f13659q
            if (r3 != 0) goto L_0x005a
            if (r2 != r0) goto L_0x0057
            r0 = r1
        L_0x0057:
            r4.f13659q = r0
            goto L_0x008d
        L_0x005a:
            if (r3 != r0) goto L_0x0064
            r0 = r1
            goto L_0x0064
        L_0x005e:
            if (r0 != r3) goto L_0x0067
            android.view.View r0 = r4.getChildAt(r2)
        L_0x0064:
            r4.f13651c = r0
            goto L_0x008d
        L_0x0067:
            android.widget.TextView r0 = new android.widget.TextView
            android.content.Context r1 = r4.getContext()
            r0.<init>(r1)
            r0.setClickable(r3)
            r1 = -39424(0xffffffffffff6600, float:NaN)
            r0.setTextColor(r1)
            r1 = 17
            r0.setGravity(r1)
            r1 = 1101004800(0x41a00000, float:20.0)
            r0.setTextSize(r1)
            java.lang.String r1 = "The content view in PtrFrameLayout is empty. Do you forget to specify its id in xml layout file?"
            r0.setText(r1)
            r4.f13651c = r0
            r4.addView(r0)
        L_0x008d:
            android.view.View r0 = r4.f13659q
            if (r0 == 0) goto L_0x0094
            r0.bringToFront()
        L_0x0094:
            super.onFinishInflate()
            return
        L_0x0098:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "PtrFrameLayout only can host 2 elements"
            r0.<init>(r1)
            goto L_0x00a1
        L_0x00a0:
            throw r0
        L_0x00a1:
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.srain.cube.views.ptr.PtrFrameLayout.onFinishInflate():void");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        g();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (f13643a) {
            lr.a.b(this.f13650b, "onMeasure frame: width: %s, height: %s, padding: %s %s %s %s", Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getPaddingLeft()), Integer.valueOf(getPaddingRight()), Integer.valueOf(getPaddingTop()), Integer.valueOf(getPaddingBottom()));
        }
        View view = this.f13659q;
        if (view != null) {
            measureChildWithMargins(view, i2, 0, i3, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f13659q.getLayoutParams();
            int measuredHeight = this.f13659q.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            this.f13664v = measuredHeight;
            this.D.c(measuredHeight);
        }
        View view2 = this.f13651c;
        if (view2 != null) {
            int i4 = i2;
            a(view2, i2, i3);
            if (f13643a) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f13651c.getLayoutParams();
                lr.a.b(this.f13650b, "onMeasure content, width: %s, height: %s, margin: %s %s %s %s", Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()), Integer.valueOf(marginLayoutParams2.leftMargin), Integer.valueOf(marginLayoutParams2.topMargin), Integer.valueOf(marginLayoutParams2.rightMargin), Integer.valueOf(marginLayoutParams2.bottomMargin));
                lr.a.b(this.f13650b, "onMeasure, currentPos: %s, lastPos: %s, top: %s", Integer.valueOf(this.D.k()), Integer.valueOf(this.D.j()), Integer.valueOf(this.f13651c.getTop()));
            }
        }
    }

    public void setDurationToClose(int i2) {
        this.f13655m = i2;
    }

    public void setDurationToCloseHeader(int i2) {
        this.f13656n = i2;
    }

    public void setEnabledNextPtrAtOnce(boolean z2) {
        this.f13666x = z2 ? this.f13666x | f13647h : this.f13666x & (f13647h ^ -1);
    }

    public void setHeaderView(View view) {
        View view2 = this.f13659q;
        if (!(view2 == null || view == null || view2 == view)) {
            removeView(view2);
        }
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LayoutParams(-1, -2));
        }
        this.f13659q = view;
        addView(view);
    }

    @Deprecated
    public void setInterceptEventWhileWorking(boolean z2) {
    }

    public void setKeepHeaderWhenRefresh(boolean z2) {
        this.f13657o = z2;
    }

    public void setLoadingMinTime(int i2) {
        this.B = i2;
    }

    public void setOffsetToKeepHeaderWhileLoading(int i2) {
        this.D.d(i2);
    }

    public void setOffsetToRefresh(int i2) {
        this.D.a(i2);
    }

    public void setPinContent(boolean z2) {
        this.f13666x = z2 ? this.f13666x | f13648i : this.f13666x & (f13648i ^ -1);
    }

    public void setPtrHandler(a aVar) {
        this.f13661s = aVar;
    }

    public void setPtrIndicator(lq.a aVar) {
        lq.a aVar2 = this.D;
        if (!(aVar2 == null || aVar2 == aVar)) {
            aVar.a(aVar2);
        }
        this.D = aVar;
    }

    public void setPullToRefresh(boolean z2) {
        this.f13658p = z2;
    }

    public void setRatioOfHeaderHeightToRefresh(float f2) {
        this.D.b(f2);
    }

    public void setRefreshCompleteHook(d dVar) {
        this.A = dVar;
        dVar.b(new Runnable() {
            public void run() {
                if (PtrFrameLayout.f13643a) {
                    lr.a.a(PtrFrameLayout.this.f13650b, "mRefreshCompleteHook resume.");
                }
                PtrFrameLayout.this.b(true);
            }
        });
    }

    public void setResistance(float f2) {
        this.D.a(f2);
    }
}
