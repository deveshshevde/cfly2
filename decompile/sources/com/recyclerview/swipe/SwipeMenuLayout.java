package com.recyclerview.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import com.recyclerview.swipe.e;
import com.yanzhenjie.recyclerview.swipe.R;
import t.ac;

public class SwipeMenuLayout extends FrameLayout implements l {

    /* renamed from: a  reason: collision with root package name */
    private int f21502a;

    /* renamed from: b  reason: collision with root package name */
    private int f21503b;

    /* renamed from: c  reason: collision with root package name */
    private int f21504c;

    /* renamed from: d  reason: collision with root package name */
    private float f21505d;

    /* renamed from: e  reason: collision with root package name */
    private int f21506e;

    /* renamed from: f  reason: collision with root package name */
    private int f21507f;

    /* renamed from: g  reason: collision with root package name */
    private int f21508g;

    /* renamed from: h  reason: collision with root package name */
    private int f21509h;

    /* renamed from: i  reason: collision with root package name */
    private int f21510i;

    /* renamed from: j  reason: collision with root package name */
    private int f21511j;

    /* renamed from: k  reason: collision with root package name */
    private View f21512k;

    /* renamed from: l  reason: collision with root package name */
    private f f21513l;

    /* renamed from: m  reason: collision with root package name */
    private k f21514m;

    /* renamed from: n  reason: collision with root package name */
    private e f21515n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f21516o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f21517p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f21518q;

    /* renamed from: r  reason: collision with root package name */
    private OverScroller f21519r;

    /* renamed from: s  reason: collision with root package name */
    private VelocityTracker f21520s;

    /* renamed from: t  reason: collision with root package name */
    private int f21521t;

    /* renamed from: u  reason: collision with root package name */
    private int f21522u;

    public SwipeMenuLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21502a = 0;
        this.f21503b = 0;
        this.f21504c = 0;
        this.f21505d = 0.5f;
        this.f21506e = 200;
        this.f21518q = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeMenuLayout);
        this.f21502a = obtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_leftViewId, this.f21502a);
        this.f21503b = obtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_contentViewId, this.f21503b);
        this.f21504c = obtainStyledAttributes.getResourceId(R.styleable.SwipeMenuLayout_rightViewId, this.f21504c);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f21507f = viewConfiguration.getScaledTouchSlop();
        this.f21521t = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f21522u = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f21519r = new OverScroller(getContext());
    }

    private int a(MotionEvent motionEvent, int i2) {
        int x2 = (int) (motionEvent.getX() - ((float) getScrollX()));
        int d2 = this.f21515n.d();
        int i3 = d2 / 2;
        float f2 = (float) d2;
        float f3 = (float) i3;
        return Math.min(i2 > 0 ? Math.round(Math.abs((f3 + (a(Math.min(1.0f, (((float) Math.abs(x2)) * 1.0f) / f2)) * f3)) / ((float) i2)) * 1000.0f) * 4 : (int) (((((float) Math.abs(x2)) / f2) + 1.0f) * 100.0f), this.f21506e);
    }

    private void a(int i2, int i3) {
        if (this.f21515n == null) {
            return;
        }
        if (((float) Math.abs(getScrollX())) < ((float) this.f21515n.c().getWidth()) * this.f21505d || (Math.abs(i2) > this.f21507f || Math.abs(i3) > this.f21507f ? j() : b())) {
            a();
        } else {
            m();
        }
    }

    private void b(int i2) {
        e eVar = this.f21515n;
        if (eVar != null) {
            eVar.a(this.f21519r, getScrollX(), i2);
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public float a(float f2) {
        double d2 = (double) (f2 - 0.5f);
        Double.isNaN(d2);
        return (float) Math.sin((double) ((float) (d2 * 0.4712389167638204d)));
    }

    public void a() {
        a(this.f21506e);
    }

    public void a(int i2) {
        e eVar = this.f21515n;
        if (eVar != null) {
            eVar.b(this.f21519r, getScrollX(), i2);
            invalidate();
        }
    }

    public boolean b() {
        return f() || g();
    }

    public boolean c() {
        return this.f21518q;
    }

    public void computeScroll() {
        e eVar;
        if (this.f21519r.computeScrollOffset() && (eVar = this.f21515n) != null) {
            scrollTo(eVar instanceof k ? Math.abs(this.f21519r.getCurrX()) : -Math.abs(this.f21519r.getCurrX()), 0);
            invalidate();
        }
    }

    public boolean d() {
        f fVar = this.f21513l;
        return fVar != null && fVar.a();
    }

    public boolean e() {
        k kVar = this.f21514m;
        return kVar != null && kVar.a();
    }

    public boolean f() {
        f fVar = this.f21513l;
        return fVar != null && fVar.b(getScrollX());
    }

    public boolean g() {
        k kVar = this.f21514m;
        return kVar != null && kVar.b(getScrollX());
    }

    public float getOpenPercent() {
        return this.f21505d;
    }

    public boolean h() {
        f fVar = this.f21513l;
        return fVar != null && !fVar.a(getScrollX());
    }

    public boolean i() {
        k kVar = this.f21514m;
        return kVar != null && !kVar.a(getScrollX());
    }

    public boolean j() {
        return k() || l();
    }

    public boolean k() {
        f fVar = this.f21513l;
        return fVar != null && fVar.c(getScrollX());
    }

    public boolean l() {
        k kVar = this.f21514m;
        return kVar != null && kVar.c(getScrollX());
    }

    public void m() {
        b(this.f21506e);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f21502a;
        if (i2 != 0 && this.f21513l == null) {
            this.f21513l = new f(findViewById(i2));
        }
        int i3 = this.f21504c;
        if (i3 != 0 && this.f21514m == null) {
            this.f21514m = new k(findViewById(i3));
        }
        int i4 = this.f21503b;
        if (i4 == 0 || this.f21512k != null) {
            TextView textView = new TextView(getContext());
            textView.setClickable(true);
            textView.setGravity(17);
            textView.setTextSize(12.0f);
            textView.setText("You may not have set the ContentView.");
            this.f21512k = textView;
            addView(textView);
            return;
        }
        this.f21512k = findViewById(i4);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            int x2 = (int) motionEvent.getX();
            this.f21508g = x2;
            this.f21510i = x2;
            this.f21511j = (int) motionEvent.getY();
            return false;
        } else if (action == 1) {
            e eVar = this.f21515n;
            boolean z2 = eVar != null && eVar.a(getWidth(), motionEvent.getX());
            if (!b() || !z2) {
                return false;
            }
            a();
            return true;
        } else if (action == 2) {
            int x3 = (int) (motionEvent.getX() - ((float) this.f21510i));
            return Math.abs(x3) > this.f21507f && Math.abs(x3) > Math.abs((int) (motionEvent.getY() - ((float) this.f21511j)));
        } else if (action != 3) {
            return onInterceptTouchEvent;
        } else {
            if (!this.f21519r.isFinished()) {
                this.f21519r.abortAnimation();
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        View view = this.f21512k;
        if (view != null) {
            int measuredWidthAndState = view.getMeasuredWidthAndState();
            int measuredHeightAndState = this.f21512k.getMeasuredHeightAndState();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + ((FrameLayout.LayoutParams) this.f21512k.getLayoutParams()).topMargin;
            this.f21512k.layout(paddingLeft, paddingTop, measuredWidthAndState + paddingLeft, measuredHeightAndState + paddingTop);
        }
        f fVar = this.f21513l;
        if (fVar != null) {
            View c2 = fVar.c();
            int measuredWidthAndState2 = c2.getMeasuredWidthAndState();
            int measuredHeightAndState2 = c2.getMeasuredHeightAndState();
            int paddingTop2 = getPaddingTop() + ((FrameLayout.LayoutParams) c2.getLayoutParams()).topMargin;
            c2.layout(-measuredWidthAndState2, paddingTop2, 0, measuredHeightAndState2 + paddingTop2);
        }
        k kVar = this.f21514m;
        if (kVar != null) {
            View c3 = kVar.c();
            int measuredWidthAndState3 = c3.getMeasuredWidthAndState();
            int measuredHeightAndState3 = c3.getMeasuredHeightAndState();
            int paddingTop3 = getPaddingTop() + ((FrameLayout.LayoutParams) c3.getLayoutParams()).topMargin;
            int measuredWidthAndState4 = getMeasuredWidthAndState();
            c3.layout(measuredWidthAndState4, paddingTop3, measuredWidthAndState3 + measuredWidthAndState4, measuredHeightAndState3 + paddingTop3);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        e eVar;
        if (this.f21520s == null) {
            this.f21520s = VelocityTracker.obtain();
        }
        this.f21520s.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f21508g = (int) motionEvent.getX();
            this.f21509h = (int) motionEvent.getY();
        } else if (action == 1) {
            int x2 = (int) (((float) this.f21510i) - motionEvent.getX());
            int y2 = (int) (((float) this.f21511j) - motionEvent.getY());
            this.f21517p = false;
            this.f21520s.computeCurrentVelocity(1000, (float) this.f21522u);
            int xVelocity = (int) this.f21520s.getXVelocity();
            int abs = Math.abs(xVelocity);
            if (abs <= this.f21521t) {
                a(x2, y2);
            } else if (this.f21515n != null) {
                int a2 = a(motionEvent, abs);
                if (!(this.f21515n instanceof k) ? xVelocity <= 0 : xVelocity >= 0) {
                    a(a2);
                } else {
                    b(a2);
                }
                ac.e(this);
            }
            this.f21520s.clear();
            this.f21520s.recycle();
            this.f21520s = null;
            if (Math.abs(((float) this.f21510i) - motionEvent.getX()) > ((float) this.f21507f) || Math.abs(((float) this.f21511j) - motionEvent.getY()) > ((float) this.f21507f) || f() || g()) {
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
        } else if (action != 2) {
            if (action == 3) {
                this.f21517p = false;
                if (!this.f21519r.isFinished()) {
                    this.f21519r.abortAnimation();
                } else {
                    a((int) (((float) this.f21510i) - motionEvent.getX()), (int) (((float) this.f21511j) - motionEvent.getY()));
                }
            }
        } else if (c()) {
            int x3 = (int) (((float) this.f21508g) - motionEvent.getX());
            int y3 = (int) (((float) this.f21509h) - motionEvent.getY());
            if (!this.f21517p && Math.abs(x3) > this.f21507f && Math.abs(x3) > Math.abs(y3)) {
                this.f21517p = true;
            }
            if (this.f21517p) {
                if (this.f21515n == null || this.f21516o) {
                    if (x3 < 0) {
                        eVar = this.f21513l;
                        if (eVar == null) {
                            eVar = this.f21514m;
                        }
                    } else {
                        eVar = this.f21514m;
                        if (eVar == null) {
                            eVar = this.f21513l;
                        }
                    }
                    this.f21515n = eVar;
                }
                scrollBy(x3, 0);
                this.f21508g = (int) motionEvent.getX();
                this.f21509h = (int) motionEvent.getY();
                this.f21516o = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollTo(int i2, int i3) {
        e eVar = this.f21515n;
        if (eVar == null) {
            super.scrollTo(i2, i3);
            return;
        }
        e.a a2 = eVar.a(i2, i3);
        this.f21516o = a2.f21537c;
        if (a2.f21535a != getScrollX()) {
            super.scrollTo(a2.f21535a, a2.f21536b);
        }
    }

    public void setOpenPercent(float f2) {
        this.f21505d = f2;
    }

    public void setScrollerDuration(int i2) {
        this.f21506e = i2;
    }

    public void setSwipeEnable(boolean z2) {
        this.f21518q = z2;
    }
}
