package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import t.ac;
import t.ak;
import t.q;
import t.r;
import t.s;
import t.t;

public class ActionBarOverlayLayout extends ViewGroup implements o, q, r, s {

    /* renamed from: e  reason: collision with root package name */
    static final int[] f996e = {R.attr.actionBarSize, 16842841};
    private ak A;
    private a B;
    private OverScroller C;
    private final Runnable D;
    private final Runnable E;
    private final t F;

    /* renamed from: a  reason: collision with root package name */
    ActionBarContainer f997a;

    /* renamed from: b  reason: collision with root package name */
    boolean f998b;

    /* renamed from: c  reason: collision with root package name */
    ViewPropertyAnimator f999c;

    /* renamed from: d  reason: collision with root package name */
    final AnimatorListenerAdapter f1000d;

    /* renamed from: f  reason: collision with root package name */
    private int f1001f;

    /* renamed from: g  reason: collision with root package name */
    private int f1002g;

    /* renamed from: h  reason: collision with root package name */
    private ContentFrameLayout f1003h;

    /* renamed from: i  reason: collision with root package name */
    private p f1004i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f1005j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1006k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1007l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1008m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1009n;

    /* renamed from: o  reason: collision with root package name */
    private int f1010o;

    /* renamed from: p  reason: collision with root package name */
    private int f1011p;

    /* renamed from: q  reason: collision with root package name */
    private final Rect f1012q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f1013r;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f1014s;

    /* renamed from: t  reason: collision with root package name */
    private final Rect f1015t;

    /* renamed from: u  reason: collision with root package name */
    private final Rect f1016u;

    /* renamed from: v  reason: collision with root package name */
    private final Rect f1017v;

    /* renamed from: w  reason: collision with root package name */
    private final Rect f1018w;

    /* renamed from: x  reason: collision with root package name */
    private ak f1019x;

    /* renamed from: y  reason: collision with root package name */
    private ak f1020y;

    /* renamed from: z  reason: collision with root package name */
    private ak f1021z;

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

    public interface a {
        void b(int i2);

        void g(boolean z2);

        void l();

        void m();

        void n();

        void o();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1002g = 0;
        this.f1012q = new Rect();
        this.f1013r = new Rect();
        this.f1014s = new Rect();
        this.f1015t = new Rect();
        this.f1016u = new Rect();
        this.f1017v = new Rect();
        this.f1018w = new Rect();
        this.f1019x = ak.f34443a;
        this.f1020y = ak.f34443a;
        this.f1021z = ak.f34443a;
        this.A = ak.f34443a;
        this.f1000d = new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.f999c = null;
                ActionBarOverlayLayout.this.f998b = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.f999c = null;
                ActionBarOverlayLayout.this.f998b = false;
            }
        };
        this.D = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f999c = actionBarOverlayLayout.f997a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1000d);
            }
        };
        this.E = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.f999c = actionBarOverlayLayout.f997a.animate().translationY((float) (-ActionBarOverlayLayout.this.f997a.getHeight())).setListener(ActionBarOverlayLayout.this.f1000d);
            }
        };
        a(context);
        this.F = new t(this);
    }

    private p a(View view) {
        if (view instanceof p) {
            return (p) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void a(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f996e);
        boolean z2 = false;
        this.f1001f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1005j = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.f1006k = z2;
        this.C = new OverScroller(context);
    }

    private boolean a(float f2) {
        this.C.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        return this.C.getFinalY() > this.f997a.getHeight();
    }

    private boolean a(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z2 || layoutParams.leftMargin == rect.left) {
            z6 = false;
        } else {
            layoutParams.leftMargin = rect.left;
            z6 = true;
        }
        if (z3 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z6 = true;
        }
        if (z5 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z6 = true;
        }
        if (!z4 || layoutParams.bottomMargin == rect.bottom) {
            return z6;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    private void l() {
        d();
        postDelayed(this.D, 600);
    }

    private void m() {
        d();
        postDelayed(this.E, 600);
    }

    private void n() {
        d();
        this.D.run();
    }

    private void o() {
        d();
        this.E.run();
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void a(int i2) {
        c();
        if (i2 == 2) {
            this.f1004i.f();
        } else if (i2 == 5) {
            this.f1004i.g();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    public void a(Menu menu, m.a aVar) {
        c();
        this.f1004i.a(menu, aVar);
    }

    public void a(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        a(view, i2, i3, i4, i5, i6);
    }

    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    public boolean a() {
        return this.f1007l;
    }

    public boolean a(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public void b(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f1003h == null) {
            this.f1003h = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.f997a = (ActionBarContainer) findViewById(R.id.action_bar_container);
            this.f1004i = a(findViewById(R.id.action_bar));
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.f999c;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1005j != null && !this.f1006k) {
            int bottom = this.f997a.getVisibility() == 0 ? (int) (((float) this.f997a.getBottom()) + this.f997a.getTranslationY() + 0.5f) : 0;
            this.f1005j.setBounds(0, bottom, getWidth(), this.f1005j.getIntrinsicHeight() + bottom);
            this.f1005j.draw(canvas);
        }
    }

    public boolean e() {
        c();
        return this.f1004i.h();
    }

    public boolean f() {
        c();
        return this.f1004i.i();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        c();
        boolean a2 = a((View) this.f997a, rect, true, true, false, true);
        this.f1015t.set(rect);
        al.a(this, this.f1015t, this.f1012q);
        if (!this.f1016u.equals(this.f1015t)) {
            this.f1016u.set(this.f1015t);
            a2 = true;
        }
        if (!this.f1013r.equals(this.f1012q)) {
            this.f1013r.set(this.f1012q);
            a2 = true;
        }
        if (a2) {
            requestLayout();
        }
        return true;
    }

    public boolean g() {
        c();
        return this.f1004i.j();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f997a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        c();
        return this.f1004i.e();
    }

    public boolean h() {
        c();
        return this.f1004i.k();
    }

    public boolean i() {
        c();
        return this.f1004i.l();
    }

    public void j() {
        c();
        this.f1004i.m();
    }

    public void k() {
        c();
        this.f1004i.n();
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        c();
        ak a2 = ak.a(windowInsets, this);
        boolean a3 = a((View) this.f997a, new Rect(a2.a(), a2.b(), a2.c(), a2.d()), true, true, false, true);
        ac.a((View) this, a2, this.f1012q);
        ak b2 = a2.b(this.f1012q.left, this.f1012q.top, this.f1012q.right, this.f1012q.bottom);
        this.f1019x = b2;
        boolean z2 = true;
        if (!this.f1020y.equals(b2)) {
            this.f1020y = this.f1019x;
            a3 = true;
        }
        if (!this.f1013r.equals(this.f1012q)) {
            this.f1013r.set(this.f1012q);
        } else {
            z2 = a3;
        }
        if (z2) {
            requestLayout();
        }
        return a2.j().g().h().m();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        ac.w(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                int i8 = layoutParams.topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r12, int r13) {
        /*
            r11 = this;
            r11.c()
            androidx.appcompat.widget.ActionBarContainer r1 = r11.f997a
            r3 = 0
            r5 = 0
            r0 = r11
            r2 = r12
            r4 = r13
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            androidx.appcompat.widget.ActionBarContainer r0 = r11.f997a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r0 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r0
            androidx.appcompat.widget.ActionBarContainer r1 = r11.f997a
            int r1 = r1.getMeasuredWidth()
            int r2 = r0.leftMargin
            int r1 = r1 + r2
            int r2 = r0.rightMargin
            int r1 = r1 + r2
            r2 = 0
            int r7 = java.lang.Math.max(r2, r1)
            androidx.appcompat.widget.ActionBarContainer r1 = r11.f997a
            int r1 = r1.getMeasuredHeight()
            int r3 = r0.topMargin
            int r1 = r1 + r3
            int r0 = r0.bottomMargin
            int r1 = r1 + r0
            int r8 = java.lang.Math.max(r2, r1)
            androidx.appcompat.widget.ActionBarContainer r0 = r11.f997a
            int r0 = r0.getMeasuredState()
            int r9 = android.view.View.combineMeasuredStates(r2, r0)
            int r0 = t.ac.v(r11)
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x004a
            r0 = 1
            goto L_0x004b
        L_0x004a:
            r0 = 0
        L_0x004b:
            if (r0 == 0) goto L_0x005f
            int r1 = r11.f1001f
            boolean r3 = r11.f1008m
            if (r3 == 0) goto L_0x0071
            androidx.appcompat.widget.ActionBarContainer r3 = r11.f997a
            android.view.View r3 = r3.getTabContainer()
            if (r3 == 0) goto L_0x0071
            int r3 = r11.f1001f
            int r1 = r1 + r3
            goto L_0x0071
        L_0x005f:
            androidx.appcompat.widget.ActionBarContainer r1 = r11.f997a
            int r1 = r1.getVisibility()
            r3 = 8
            if (r1 == r3) goto L_0x0070
            androidx.appcompat.widget.ActionBarContainer r1 = r11.f997a
            int r1 = r1.getMeasuredHeight()
            goto L_0x0071
        L_0x0070:
            r1 = 0
        L_0x0071:
            android.graphics.Rect r3 = r11.f1014s
            android.graphics.Rect r4 = r11.f1012q
            r3.set(r4)
            int r3 = android.os.Build.VERSION.SDK_INT
            r10 = 21
            if (r3 < r10) goto L_0x0083
            t.ak r3 = r11.f1019x
            r11.f1021z = r3
            goto L_0x008a
        L_0x0083:
            android.graphics.Rect r3 = r11.f1017v
            android.graphics.Rect r4 = r11.f1015t
            r3.set(r4)
        L_0x008a:
            boolean r3 = r11.f1007l
            if (r3 != 0) goto L_0x00a9
            if (r0 != 0) goto L_0x00a9
            android.graphics.Rect r0 = r11.f1014s
            int r3 = r0.top
            int r3 = r3 + r1
            r0.top = r3
            android.graphics.Rect r0 = r11.f1014s
            int r3 = r0.bottom
            int r3 = r3 + r2
            r0.bottom = r3
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r10) goto L_0x00eb
            t.ak r0 = r11.f1021z
            t.ak r0 = r0.b(r2, r1, r2, r2)
            goto L_0x00da
        L_0x00a9:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r10) goto L_0x00dd
            t.ak r0 = r11.f1021z
            int r0 = r0.a()
            t.ak r3 = r11.f1021z
            int r3 = r3.b()
            int r3 = r3 + r1
            t.ak r1 = r11.f1021z
            int r1 = r1.c()
            t.ak r4 = r11.f1021z
            int r4 = r4.d()
            int r4 = r4 + r2
            m.b r0 = m.b.a(r0, r3, r1, r4)
            t.ak$b r1 = new t.ak$b
            t.ak r2 = r11.f1021z
            r1.<init>(r2)
            t.ak$b r0 = r1.a(r0)
            t.ak r0 = r0.a()
        L_0x00da:
            r11.f1021z = r0
            goto L_0x00eb
        L_0x00dd:
            android.graphics.Rect r0 = r11.f1017v
            int r3 = r0.top
            int r3 = r3 + r1
            r0.top = r3
            android.graphics.Rect r0 = r11.f1017v
            int r1 = r0.bottom
            int r1 = r1 + r2
            r0.bottom = r1
        L_0x00eb:
            androidx.appcompat.widget.ContentFrameLayout r1 = r11.f1003h
            android.graphics.Rect r2 = r11.f1014s
            r3 = 1
            r4 = 1
            r5 = 1
            r6 = 1
            r0 = r11
            r0.a((android.view.View) r1, (android.graphics.Rect) r2, (boolean) r3, (boolean) r4, (boolean) r5, (boolean) r6)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r10) goto L_0x010f
            t.ak r0 = r11.A
            t.ak r1 = r11.f1021z
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x010f
            t.ak r0 = r11.f1021z
            r11.A = r0
            androidx.appcompat.widget.ContentFrameLayout r1 = r11.f1003h
            t.ac.b((android.view.View) r1, (t.ak) r0)
            goto L_0x012b
        L_0x010f:
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r10) goto L_0x012b
            android.graphics.Rect r0 = r11.f1018w
            android.graphics.Rect r1 = r11.f1017v
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012b
            android.graphics.Rect r0 = r11.f1018w
            android.graphics.Rect r1 = r11.f1017v
            r0.set(r1)
            androidx.appcompat.widget.ContentFrameLayout r0 = r11.f1003h
            android.graphics.Rect r1 = r11.f1017v
            r0.a(r1)
        L_0x012b:
            androidx.appcompat.widget.ContentFrameLayout r1 = r11.f1003h
            r3 = 0
            r5 = 0
            r0 = r11
            r2 = r12
            r4 = r13
            r0.measureChildWithMargins(r1, r2, r3, r4, r5)
            androidx.appcompat.widget.ContentFrameLayout r0 = r11.f1003h
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams r0 = (androidx.appcompat.widget.ActionBarOverlayLayout.LayoutParams) r0
            androidx.appcompat.widget.ContentFrameLayout r1 = r11.f1003h
            int r1 = r1.getMeasuredWidth()
            int r2 = r0.leftMargin
            int r1 = r1 + r2
            int r2 = r0.rightMargin
            int r1 = r1 + r2
            int r1 = java.lang.Math.max(r7, r1)
            androidx.appcompat.widget.ContentFrameLayout r2 = r11.f1003h
            int r2 = r2.getMeasuredHeight()
            int r3 = r0.topMargin
            int r2 = r2 + r3
            int r0 = r0.bottomMargin
            int r2 = r2 + r0
            int r0 = java.lang.Math.max(r8, r2)
            androidx.appcompat.widget.ContentFrameLayout r2 = r11.f1003h
            int r2 = r2.getMeasuredState()
            int r2 = android.view.View.combineMeasuredStates(r9, r2)
            int r3 = r11.getPaddingLeft()
            int r4 = r11.getPaddingRight()
            int r3 = r3 + r4
            int r1 = r1 + r3
            int r3 = r11.getPaddingTop()
            int r4 = r11.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            int r3 = r11.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            int r3 = r11.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r3)
            int r1 = android.view.View.resolveSizeAndState(r1, r12, r2)
            int r2 = r2 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r13, r2)
            r11.setMeasuredDimension(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f1009n || !z2) {
            return false;
        }
        if (a(f3)) {
            o();
        } else {
            n();
        }
        this.f998b = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f1010o + i3;
        this.f1010o = i6;
        setActionBarHideOffset(i6);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.F.a(view, view2, i2);
        this.f1010o = getActionBarHideOffset();
        d();
        a aVar = this.B;
        if (aVar != null) {
            aVar.n();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f997a.getVisibility() != 0) {
            return false;
        }
        return this.f1009n;
    }

    public void onStopNestedScroll(View view) {
        if (this.f1009n && !this.f998b) {
            if (this.f1010o <= this.f997a.getHeight()) {
                l();
            } else {
                m();
            }
        }
        a aVar = this.B;
        if (aVar != null) {
            aVar.o();
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i2);
        }
        c();
        int i3 = this.f1011p ^ i2;
        this.f1011p = i2;
        boolean z2 = false;
        boolean z3 = (i2 & 4) == 0;
        if ((i2 & 256) != 0) {
            z2 = true;
        }
        a aVar = this.B;
        if (aVar != null) {
            aVar.g(!z2);
            if (z3 || !z2) {
                this.B.l();
            } else {
                this.B.m();
            }
        }
        if ((i3 & 256) != 0 && this.B != null) {
            ac.w(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f1002g = i2;
        a aVar = this.B;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public void setActionBarHideOffset(int i2) {
        d();
        this.f997a.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f997a.getHeight()))));
    }

    public void setActionBarVisibilityCallback(a aVar) {
        this.B = aVar;
        if (getWindowToken() != null) {
            this.B.b(this.f1002g);
            int i2 = this.f1011p;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                ac.w(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f1008m = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f1009n) {
            this.f1009n = z2;
            if (!z2) {
                d();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        c();
        this.f1004i.a(i2);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.f1004i.a(drawable);
    }

    public void setLogo(int i2) {
        c();
        this.f1004i.b(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.f1007l = z2;
        this.f1006k = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    public void setWindowCallback(Window.Callback callback) {
        c();
        this.f1004i.a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.f1004i.a(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
