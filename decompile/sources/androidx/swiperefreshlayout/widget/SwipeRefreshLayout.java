package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.widget.g;
import com.blankj.utilcode.constant.MemoryConstants;
import fg.i;
import t.ac;
import t.m;
import t.p;
import t.q;
import t.t;

public class SwipeRefreshLayout extends ViewGroup implements m, q {
    private static final int[] E = {16842766};

    /* renamed from: n  reason: collision with root package name */
    private static final String f4531n = "SwipeRefreshLayout";
    private boolean A;
    private int B;
    private boolean C;
    private final DecelerateInterpolator D;
    private int F;
    private Animation G;
    private Animation H;
    private Animation I;
    private Animation J;
    private Animation K;
    private int L;
    private a M;
    private Animation.AnimationListener N;
    private final Animation O;
    private final Animation P;

    /* renamed from: a  reason: collision with root package name */
    b f4532a;

    /* renamed from: b  reason: collision with root package name */
    boolean f4533b;

    /* renamed from: c  reason: collision with root package name */
    int f4534c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4535d;

    /* renamed from: e  reason: collision with root package name */
    a f4536e;

    /* renamed from: f  reason: collision with root package name */
    protected int f4537f;

    /* renamed from: g  reason: collision with root package name */
    float f4538g;

    /* renamed from: h  reason: collision with root package name */
    protected int f4539h;

    /* renamed from: i  reason: collision with root package name */
    int f4540i;

    /* renamed from: j  reason: collision with root package name */
    int f4541j;

    /* renamed from: k  reason: collision with root package name */
    b f4542k;

    /* renamed from: l  reason: collision with root package name */
    boolean f4543l;

    /* renamed from: m  reason: collision with root package name */
    boolean f4544m;

    /* renamed from: o  reason: collision with root package name */
    private View f4545o;

    /* renamed from: p  reason: collision with root package name */
    private int f4546p;

    /* renamed from: q  reason: collision with root package name */
    private float f4547q;

    /* renamed from: r  reason: collision with root package name */
    private float f4548r;

    /* renamed from: s  reason: collision with root package name */
    private final t f4549s;

    /* renamed from: t  reason: collision with root package name */
    private final p f4550t;

    /* renamed from: u  reason: collision with root package name */
    private final int[] f4551u;

    /* renamed from: v  reason: collision with root package name */
    private final int[] f4552v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4553w;

    /* renamed from: x  reason: collision with root package name */
    private int f4554x;

    /* renamed from: y  reason: collision with root package name */
    private float f4555y;

    /* renamed from: z  reason: collision with root package name */
    private float f4556z;

    public interface a {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface b {
        void a();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4533b = false;
        this.f4547q = -1.0f;
        this.f4551u = new int[2];
        this.f4552v = new int[2];
        this.B = -1;
        this.F = -1;
        this.N = new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f4533b) {
                    SwipeRefreshLayout.this.f4542k.setAlpha(255);
                    SwipeRefreshLayout.this.f4542k.start();
                    if (SwipeRefreshLayout.this.f4543l && SwipeRefreshLayout.this.f4532a != null) {
                        SwipeRefreshLayout.this.f4532a.a();
                    }
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    swipeRefreshLayout.f4534c = swipeRefreshLayout.f4536e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.a();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.O = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((SwipeRefreshLayout.this.f4537f + ((int) (((float) ((!SwipeRefreshLayout.this.f4544m ? SwipeRefreshLayout.this.f4540i - Math.abs(SwipeRefreshLayout.this.f4539h) : SwipeRefreshLayout.this.f4540i) - SwipeRefreshLayout.this.f4537f)) * f2))) - SwipeRefreshLayout.this.f4536e.getTop());
                SwipeRefreshLayout.this.f4542k.b(1.0f - f2);
            }
        };
        this.P = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.a(f2);
            }
        };
        this.f4546p = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f4554x = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.D = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.L = (int) (displayMetrics.density * 40.0f);
        c();
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.f4540i = i2;
        this.f4547q = (float) i2;
        this.f4549s = new t(this);
        this.f4550t = new p(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.L;
        this.f4534c = i3;
        this.f4539h = i3;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private Animation a(final int i2, final int i3) {
        AnonymousClass4 r0 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                b bVar = SwipeRefreshLayout.this.f4542k;
                int i2 = i2;
                bVar.setAlpha((int) (((float) i2) + (((float) (i3 - i2)) * f2)));
            }
        };
        r0.setDuration(300);
        this.f4536e.a((Animation.AnimationListener) null);
        this.f4536e.clearAnimation();
        this.f4536e.startAnimation(r0);
        return r0;
    }

    private void a(int i2, Animation.AnimationListener animationListener) {
        this.f4537f = i2;
        this.O.reset();
        this.O.setDuration(200);
        this.O.setInterpolator(this.D);
        if (animationListener != null) {
            this.f4536e.a(animationListener);
        }
        this.f4536e.clearAnimation();
        this.f4536e.startAnimation(this.O);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.B) {
            this.B = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void a(boolean z2, boolean z3) {
        if (this.f4533b != z2) {
            this.f4543l = z3;
            f();
            this.f4533b = z2;
            if (z2) {
                a(this.f4534c, this.N);
            } else {
                a(this.N);
            }
        }
    }

    private boolean a(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    private void b(float f2) {
        this.f4542k.a(true);
        float min = Math.min(1.0f, Math.abs(f2 / this.f4547q));
        double d2 = (double) min;
        Double.isNaN(d2);
        float max = (((float) Math.max(d2 - 0.4d, i.f27244a)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.f4547q;
        int i2 = this.f4541j;
        if (i2 <= 0) {
            i2 = this.f4544m ? this.f4540i - this.f4539h : this.f4540i;
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        double pow = Math.pow(max2, 2.0d);
        Double.isNaN(max2);
        float f4 = ((float) (max2 - pow)) * 2.0f;
        int i3 = this.f4539h + ((int) ((f3 * min) + (f3 * f4 * 2.0f)));
        if (this.f4536e.getVisibility() != 0) {
            this.f4536e.setVisibility(0);
        }
        if (!this.f4535d) {
            this.f4536e.setScaleX(1.0f);
            this.f4536e.setScaleY(1.0f);
        }
        if (this.f4535d) {
            setAnimationProgress(Math.min(1.0f, f2 / this.f4547q));
        }
        if (f2 < this.f4547q) {
            if (this.f4542k.getAlpha() > 76 && !a(this.I)) {
                d();
            }
        } else if (this.f4542k.getAlpha() < 255 && !a(this.J)) {
            e();
        }
        this.f4542k.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.f4542k.b(Math.min(1.0f, max));
        this.f4542k.c((((max * 0.4f) - 16.0f) + (f4 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.f4534c);
    }

    private void b(int i2, Animation.AnimationListener animationListener) {
        if (this.f4535d) {
            c(i2, animationListener);
            return;
        }
        this.f4537f = i2;
        this.P.reset();
        this.P.setDuration(200);
        this.P.setInterpolator(this.D);
        if (animationListener != null) {
            this.f4536e.a(animationListener);
        }
        this.f4536e.clearAnimation();
        this.f4536e.startAnimation(this.P);
    }

    private void b(Animation.AnimationListener animationListener) {
        this.f4536e.setVisibility(0);
        this.f4542k.setAlpha(255);
        AnonymousClass2 r0 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.G = r0;
        r0.setDuration((long) this.f4554x);
        if (animationListener != null) {
            this.f4536e.a(animationListener);
        }
        this.f4536e.clearAnimation();
        this.f4536e.startAnimation(this.G);
    }

    private void c() {
        this.f4536e = new a(getContext(), -328966);
        b bVar = new b(getContext());
        this.f4542k = bVar;
        bVar.a(1);
        this.f4536e.setImageDrawable(this.f4542k);
        this.f4536e.setVisibility(8);
        addView(this.f4536e);
    }

    private void c(float f2) {
        if (f2 > this.f4547q) {
            a(true, true);
            return;
        }
        this.f4533b = false;
        this.f4542k.a(0.0f, 0.0f);
        AnonymousClass5 r0 = null;
        if (!this.f4535d) {
            r0 = new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.f4535d) {
                        SwipeRefreshLayout.this.a((Animation.AnimationListener) null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            };
        }
        b(this.f4534c, r0);
        this.f4542k.a(false);
    }

    private void c(int i2, Animation.AnimationListener animationListener) {
        this.f4537f = i2;
        this.f4538g = this.f4536e.getScaleX();
        AnonymousClass8 r3 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f4538g + ((-SwipeRefreshLayout.this.f4538g) * f2));
                SwipeRefreshLayout.this.a(f2);
            }
        };
        this.K = r3;
        r3.setDuration(150);
        if (animationListener != null) {
            this.f4536e.a(animationListener);
        }
        this.f4536e.clearAnimation();
        this.f4536e.startAnimation(this.K);
    }

    private void d() {
        this.I = a(this.f4542k.getAlpha(), 76);
    }

    private void d(float f2) {
        float f3 = this.f4556z;
        int i2 = this.f4546p;
        if (f2 - f3 > ((float) i2) && !this.A) {
            this.f4555y = f3 + ((float) i2);
            this.A = true;
            this.f4542k.setAlpha(76);
        }
    }

    private void e() {
        this.J = a(this.f4542k.getAlpha(), 255);
    }

    private void f() {
        if (this.f4545o == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.f4536e)) {
                    this.f4545o = childAt;
                    return;
                }
            }
        }
    }

    private void setColorViewAlpha(int i2) {
        this.f4536e.getBackground().setAlpha(i2);
        this.f4542k.setAlpha(i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f4536e.clearAnimation();
        this.f4542k.stop();
        this.f4536e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f4535d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.f4539h - this.f4534c);
        }
        this.f4534c = this.f4536e.getTop();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        int i2 = this.f4537f;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.f4539h - i2)) * f2))) - this.f4536e.getTop());
    }

    /* access modifiers changed from: package-private */
    public void a(Animation.AnimationListener animationListener) {
        AnonymousClass3 r0 = new Animation() {
            public void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.H = r0;
        r0.setDuration(150);
        this.f4536e.a(animationListener);
        this.f4536e.clearAnimation();
        this.f4536e.startAnimation(this.H);
    }

    public boolean b() {
        a aVar = this.M;
        if (aVar != null) {
            return aVar.a(this, this.f4545o);
        }
        View view = this.f4545o;
        return view instanceof ListView ? g.b((ListView) view, -1) : view.canScrollVertically(-1);
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return this.f4550t.a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f4550t.a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f4550t.a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f4550t.a(i2, i3, i4, i5, iArr);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.F;
        return i4 < 0 ? i3 : i3 == i2 + -1 ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    public int getNestedScrollAxes() {
        return this.f4549s.a();
    }

    public int getProgressCircleDiameter() {
        return this.L;
    }

    public int getProgressViewEndOffset() {
        return this.f4540i;
    }

    public int getProgressViewStartOffset() {
        return this.f4539h;
    }

    public boolean hasNestedScrollingParent() {
        return this.f4550t.b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.f4550t.a();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.C && actionMasked == 0) {
            this.C = false;
        }
        if (!isEnabled() || this.C || b() || this.f4533b || this.f4553w) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.B;
                    if (i2 == -1) {
                        Log.e(f4531n, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i2);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    d(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.A = false;
            this.B = -1;
        } else {
            setTargetOffsetTopAndBottom(this.f4539h - this.f4536e.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.B = pointerId;
            this.A = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.f4556z = motionEvent.getY(findPointerIndex2);
        }
        return this.A;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f4545o == null) {
                f();
            }
            View view = this.f4545o;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f4536e.getMeasuredWidth();
                int measuredHeight2 = this.f4536e.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.f4534c;
                this.f4536e.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f4545o == null) {
            f();
        }
        View view = this.f4545o;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), MemoryConstants.GB));
            this.f4536e.measure(View.MeasureSpec.makeMeasureSpec(this.L, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(this.L, MemoryConstants.GB));
            this.F = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.f4536e) {
                    this.F = i4;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return dispatchNestedFling(f2, f3, z2);
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f4548r;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.f4548r = 0.0f;
                } else {
                    this.f4548r = f2 - f3;
                    iArr[1] = i3;
                }
                b(this.f4548r);
            }
        }
        if (this.f4544m && i3 > 0 && this.f4548r == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.f4536e.setVisibility(8);
        }
        int[] iArr2 = this.f4551u;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.f4552v);
        int i6 = i5 + this.f4552v[1];
        if (i6 < 0 && !b()) {
            float abs = this.f4548r + ((float) Math.abs(i6));
            this.f4548r = abs;
            b(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f4549s.a(view, view2, i2);
        startNestedScroll(i2 & 2);
        this.f4548r = 0.0f;
        this.f4553w = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return isEnabled() && !this.C && !this.f4533b && (i2 & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.f4549s.a(view);
        this.f4553w = false;
        float f2 = this.f4548r;
        if (f2 > 0.0f) {
            c(f2);
            this.f4548r = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.C && actionMasked == 0) {
            this.C = false;
        }
        if (!isEnabled() || this.C || b() || this.f4533b || this.f4553w) {
            return false;
        }
        if (actionMasked == 0) {
            this.B = motionEvent.getPointerId(0);
            this.A = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.B);
            if (findPointerIndex < 0) {
                Log.e(f4531n, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.A) {
                this.A = false;
                c((motionEvent.getY(findPointerIndex) - this.f4555y) * 0.5f);
            }
            this.B = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.B);
            if (findPointerIndex2 < 0) {
                Log.e(f4531n, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y2 = motionEvent.getY(findPointerIndex2);
            d(y2);
            if (this.A) {
                float f2 = (y2 - this.f4555y) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                b(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f4531n, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.B = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                a(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f4545o instanceof AbsListView)) {
            View view = this.f4545o;
            if (view == null || ac.E(view)) {
                super.requestDisallowInterceptTouchEvent(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setAnimationProgress(float f2) {
        this.f4536e.setScaleX(f2);
        this.f4536e.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        f();
        this.f4542k.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = androidx.core.content.b.c(context, iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f4547q = (float) i2;
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!z2) {
            a();
        }
    }

    public void setNestedScrollingEnabled(boolean z2) {
        this.f4550t.a(z2);
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.M = aVar;
    }

    public void setOnRefreshListener(b bVar) {
        this.f4532a = bVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.f4536e.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.b.c(getContext(), i2));
    }

    public void setRefreshing(boolean z2) {
        if (!z2 || this.f4533b == z2) {
            a(z2, false);
            return;
        }
        this.f4533b = z2;
        setTargetOffsetTopAndBottom((!this.f4544m ? this.f4540i + this.f4539h : this.f4540i) - this.f4534c);
        this.f4543l = false;
        b(this.N);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.L = (int) (getResources().getDisplayMetrics().density * (i2 == 0 ? 56.0f : 40.0f));
            this.f4536e.setImageDrawable((Drawable) null);
            this.f4542k.a(i2);
            this.f4536e.setImageDrawable(this.f4542k);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.f4541j = i2;
    }

    /* access modifiers changed from: package-private */
    public void setTargetOffsetTopAndBottom(int i2) {
        this.f4536e.bringToFront();
        ac.e((View) this.f4536e, i2);
        this.f4534c = this.f4536e.getTop();
    }

    public boolean startNestedScroll(int i2) {
        return this.f4550t.b(i2);
    }

    public void stopNestedScroll() {
        this.f4550t.c();
    }
}
