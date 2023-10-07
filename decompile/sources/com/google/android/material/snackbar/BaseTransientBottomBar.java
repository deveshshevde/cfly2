package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.util.List;
import t.ac;
import t.ak;
import t.u;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a  reason: collision with root package name */
    static final Handler f19574a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).i();
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                ((BaseTransientBottomBar) message.obj).c(message.arg1);
                return true;
            }
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f19575d = (Build.VERSION.SDK_INT >= 16 && Build.VERSION.SDK_INT <= 19);

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f19576e = {R.attr.snackbarStyle};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String f19577f = BaseTransientBottomBar.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    protected final SnackbarBaseLayout f19578b;

    /* renamed from: c  reason: collision with root package name */
    b.a f19579c = new b.a() {
        public void a() {
            BaseTransientBottomBar.f19574a.sendMessage(BaseTransientBottomBar.f19574a.obtainMessage(0, BaseTransientBottomBar.this));
        }

        public void a(int i2) {
            BaseTransientBottomBar.f19574a.sendMessage(BaseTransientBottomBar.f19574a.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f19580g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Context f19581h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final a f19582i;

    /* renamed from: j  reason: collision with root package name */
    private int f19583j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19584k;

    /* renamed from: l  reason: collision with root package name */
    private View f19585l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f19586m = false;

    /* renamed from: n  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f19587n = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (BaseTransientBottomBar.this.f19586m) {
                BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
                int unused = baseTransientBottomBar.f19594u = baseTransientBottomBar.u();
                BaseTransientBottomBar.this.o();
            }
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private final Runnable f19588o = new Runnable() {
        public void run() {
            int e2;
            if (BaseTransientBottomBar.this.f19578b != null && BaseTransientBottomBar.this.f19581h != null && (e2 = (BaseTransientBottomBar.this.t() - BaseTransientBottomBar.this.s()) + ((int) BaseTransientBottomBar.this.f19578b.getTranslationY())) < BaseTransientBottomBar.this.f19593t) {
                ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f19578b.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    Log.w(BaseTransientBottomBar.f19577f, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                    return;
                }
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.f19593t - e2;
                BaseTransientBottomBar.this.f19578b.requestLayout();
            }
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private Rect f19589p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f19590q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f19591r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f19592s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f19593t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f19594u;

    /* renamed from: v  reason: collision with root package name */
    private List<a<B>> f19595v;

    /* renamed from: w  reason: collision with root package name */
    private Behavior f19596w;

    /* renamed from: x  reason: collision with root package name */
    private final AccessibilityManager f19597x;

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: g  reason: collision with root package name */
        private final b f19621g = new b(this);

        /* access modifiers changed from: private */
        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f19621g.a(baseTransientBottomBar);
        }

        public boolean a(View view) {
            return this.f19621g.a(view);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f19621g.a(coordinatorLayout, view, motionEvent);
            return super.a(coordinatorLayout, view, motionEvent);
        }
    }

    protected static class SnackbarBaseLayout extends FrameLayout {

        /* renamed from: a  reason: collision with root package name */
        private static final View.OnTouchListener f19622a = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private d f19623b;

        /* renamed from: c  reason: collision with root package name */
        private c f19624c;

        /* renamed from: d  reason: collision with root package name */
        private int f19625d;

        /* renamed from: e  reason: collision with root package name */
        private final float f19626e;

        /* renamed from: f  reason: collision with root package name */
        private final float f19627f;

        /* renamed from: g  reason: collision with root package name */
        private ColorStateList f19628g;

        /* renamed from: h  reason: collision with root package name */
        private PorterDuff.Mode f19629h;

        protected SnackbarBaseLayout(Context context) {
            this(context, (AttributeSet) null);
        }

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(gx.a.a(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ac.d((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            this.f19625d = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.f19626e = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(gt.c.a(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(s.a(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f19627f = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f19622a);
            setFocusable(true);
            if (getBackground() == null) {
                ac.a((View) this, a());
            }
        }

        private Drawable a() {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(gn.a.a(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f19628g == null) {
                return androidx.core.graphics.drawable.a.g(gradientDrawable);
            }
            Drawable g2 = androidx.core.graphics.drawable.a.g(gradientDrawable);
            androidx.core.graphics.drawable.a.a(g2, this.f19628g);
            return g2;
        }

        /* access modifiers changed from: package-private */
        public float getActionTextColorAlpha() {
            return this.f19627f;
        }

        /* access modifiers changed from: package-private */
        public int getAnimationMode() {
            return this.f19625d;
        }

        /* access modifiers changed from: package-private */
        public float getBackgroundOverlayColorAlpha() {
            return this.f19626e;
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            c cVar = this.f19624c;
            if (cVar != null) {
                cVar.a(this);
            }
            ac.w(this);
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            c cVar = this.f19624c;
            if (cVar != null) {
                cVar.b(this);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            d dVar = this.f19623b;
            if (dVar != null) {
                dVar.a(this, i2, i3, i4, i5);
            }
        }

        /* access modifiers changed from: package-private */
        public void setAnimationMode(int i2) {
            this.f19625d = i2;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f19628g == null)) {
                drawable = androidx.core.graphics.drawable.a.g(drawable.mutate());
                androidx.core.graphics.drawable.a.a(drawable, this.f19628g);
                androidx.core.graphics.drawable.a.a(drawable, this.f19629h);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f19628g = colorStateList;
            if (getBackground() != null) {
                Drawable g2 = androidx.core.graphics.drawable.a.g(getBackground().mutate());
                androidx.core.graphics.drawable.a.a(g2, colorStateList);
                androidx.core.graphics.drawable.a.a(g2, this.f19629h);
                if (g2 != getBackground()) {
                    super.setBackgroundDrawable(g2);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f19629h = mode;
            if (getBackground() != null) {
                Drawable g2 = androidx.core.graphics.drawable.a.g(getBackground().mutate());
                androidx.core.graphics.drawable.a.a(g2, mode);
                if (g2 != getBackground()) {
                    super.setBackgroundDrawable(g2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setOnAttachStateChangeListener(c cVar) {
            this.f19624c = cVar;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f19622a);
            super.setOnClickListener(onClickListener);
        }

        /* access modifiers changed from: package-private */
        public void setOnLayoutChangeListener(d dVar) {
            this.f19623b = dVar;
        }
    }

    public static abstract class a<B> {
        public void a(B b2) {
        }

        public void a(B b2, int i2) {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private b.a f19630a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.a(0.1f);
            swipeDismissBehavior.b(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    b.a().d(this.f19630a);
                }
            } else if (coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                b.a().c(this.f19630a);
            }
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f19630a = baseTransientBottomBar.f19579c;
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }
    }

    protected interface c {
        void a(View view);

        void b(View view);
    }

    protected interface d {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    protected BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (aVar != null) {
            this.f19580g = viewGroup;
            this.f19582i = aVar;
            this.f19581h = context;
            l.a(context);
            SnackbarBaseLayout snackbarBaseLayout = (SnackbarBaseLayout) LayoutInflater.from(context).inflate(a(), viewGroup, false);
            this.f19578b = snackbarBaseLayout;
            if (view instanceof SnackbarContentLayout) {
                ((SnackbarContentLayout) view).a(snackbarBaseLayout.getActionTextColorAlpha());
            }
            snackbarBaseLayout.addView(view);
            ViewGroup.LayoutParams layoutParams = snackbarBaseLayout.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f19589p = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            ac.d((View) snackbarBaseLayout, 1);
            ac.b((View) snackbarBaseLayout, 1);
            ac.b((View) snackbarBaseLayout, true);
            ac.a((View) snackbarBaseLayout, (u) new u() {
                public ak a(View view, ak akVar) {
                    int unused = BaseTransientBottomBar.this.f19590q = akVar.d();
                    int unused2 = BaseTransientBottomBar.this.f19591r = akVar.a();
                    int unused3 = BaseTransientBottomBar.this.f19592s = akVar.c();
                    BaseTransientBottomBar.this.o();
                    return akVar;
                }
            });
            ac.a((View) snackbarBaseLayout, (t.a) new t.a() {
                public void a(View view, u.c cVar) {
                    super.a(view, cVar);
                    cVar.a((int) MemoryConstants.MB);
                    cVar.m(true);
                }

                public boolean a(View view, int i2, Bundle bundle) {
                    if (i2 != 1048576) {
                        return super.a(view, i2, bundle);
                    }
                    BaseTransientBottomBar.this.f();
                    return true;
                }
            });
            this.f19597x = (AccessibilityManager) context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    private ValueAnimator a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(gl.a.f28535a);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseTransientBottomBar.this.f19578b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    private void a(CoordinatorLayout.d dVar) {
        SwipeDismissBehavior swipeDismissBehavior = this.f19596w;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = h();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).a((BaseTransientBottomBar<?>) this);
        }
        swipeDismissBehavior.a((SwipeDismissBehavior.a) new SwipeDismissBehavior.a() {
            public void a(int i2) {
                if (i2 == 0) {
                    b.a().d(BaseTransientBottomBar.this.f19579c);
                } else if (i2 == 1 || i2 == 2) {
                    b.a().c(BaseTransientBottomBar.this.f19579c);
                }
            }

            public void a(View view) {
                if (view.getParent() != null) {
                    view.setVisibility(8);
                }
                BaseTransientBottomBar.this.b(0);
            }
        });
        dVar.a((CoordinatorLayout.Behavior) swipeDismissBehavior);
        if (this.f19585l == null) {
            dVar.f2759g = 80;
        }
    }

    private ValueAnimator b(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(gl.a.f28538d);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                BaseTransientBottomBar.this.f19578b.setScaleX(floatValue);
                BaseTransientBottomBar.this.f19578b.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    private void e(int i2) {
        if (this.f19578b.getAnimationMode() == 1) {
            f(i2);
        } else {
            g(i2);
        }
    }

    private void f(final int i2) {
        ValueAnimator a2 = a(1.0f, 0.0f);
        a2.setDuration(75);
        a2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.d(i2);
            }
        });
        a2.start();
    }

    private void g(final int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{0, x()});
        valueAnimator.setInterpolator(gl.a.f28536b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.d(i2);
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f19582i.b(0, 180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            /* renamed from: b  reason: collision with root package name */
            private int f19599b = 0;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f19575d) {
                    ac.e((View) BaseTransientBottomBar.this.f19578b, intValue - this.f19599b);
                } else {
                    BaseTransientBottomBar.this.f19578b.setTranslationY((float) intValue);
                }
                this.f19599b = intValue;
            }
        });
        valueAnimator.start();
    }

    /* access modifiers changed from: private */
    public void o() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.f19578b.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.f19589p) == null) {
            Log.w(f19577f, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + (this.f19585l != null ? this.f19594u : this.f19590q);
        marginLayoutParams.leftMargin = this.f19589p.left + this.f19591r;
        marginLayoutParams.rightMargin = this.f19589p.right + this.f19592s;
        this.f19578b.requestLayout();
        if (Build.VERSION.SDK_INT >= 29 && p()) {
            this.f19578b.removeCallbacks(this.f19588o);
            this.f19578b.post(this.f19588o);
        }
    }

    private boolean p() {
        return this.f19593t > 0 && !this.f19584k && q();
    }

    private boolean q() {
        ViewGroup.LayoutParams layoutParams = this.f19578b.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.d) && (((CoordinatorLayout.d) layoutParams).b() instanceof SwipeDismissBehavior);
    }

    /* access modifiers changed from: private */
    public void r() {
        if (l()) {
            j();
            return;
        }
        if (this.f19578b.getParent() != null) {
            this.f19578b.setVisibility(0);
        }
        k();
    }

    /* access modifiers changed from: private */
    public int s() {
        int[] iArr = new int[2];
        this.f19578b.getLocationOnScreen(iArr);
        return iArr[1] + this.f19578b.getHeight();
    }

    /* access modifiers changed from: private */
    public int t() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.f19581h.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* access modifiers changed from: private */
    public int u() {
        View view = this.f19585l;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.f19580g.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f19580g.getHeight()) - i2;
    }

    /* access modifiers changed from: private */
    public void v() {
        ValueAnimator a2 = a(0.0f, 1.0f);
        ValueAnimator b2 = b(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{a2, b2});
        animatorSet.setDuration(150);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.k();
            }
        });
        animatorSet.start();
    }

    /* access modifiers changed from: private */
    public void w() {
        int x2 = x();
        if (f19575d) {
            ac.e((View) this.f19578b, x2);
        } else {
            this.f19578b.setTranslationY((float) x2);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(new int[]{x2, 0});
        valueAnimator.setInterpolator(gl.a.f28536b);
        valueAnimator.setDuration(250);
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BaseTransientBottomBar.this.k();
            }

            public void onAnimationStart(Animator animator) {
                BaseTransientBottomBar.this.f19582i.a(70, 180);
            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(x2) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f19616a;

            /* renamed from: c  reason: collision with root package name */
            private int f19618c;

            {
                this.f19616a = r2;
                this.f19618c = r2;
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (BaseTransientBottomBar.f19575d) {
                    ac.e((View) BaseTransientBottomBar.this.f19578b, intValue - this.f19618c);
                } else {
                    BaseTransientBottomBar.this.f19578b.setTranslationY((float) intValue);
                }
                this.f19618c = intValue;
            }
        });
        valueAnimator.start();
    }

    private int x() {
        int height = this.f19578b.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f19578b.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* access modifiers changed from: protected */
    public int a() {
        return b() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    public B a(int i2) {
        this.f19583j = i2;
        return this;
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        b.a().a(this.f19579c, i2);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        TypedArray obtainStyledAttributes = this.f19581h.obtainStyledAttributes(f19576e);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public int c() {
        return this.f19583j;
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        if (!l() || this.f19578b.getVisibility() != 0) {
            d(i2);
        } else {
            e(i2);
        }
    }

    public View d() {
        return this.f19578b;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        b.a().a(this.f19579c);
        List<a<B>> list = this.f19595v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f19595v.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.f19578b.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f19578b);
        }
    }

    public void e() {
        b.a().a(c(), this.f19579c);
    }

    public void f() {
        b(3);
    }

    public boolean g() {
        return b.a().e(this.f19579c);
    }

    /* access modifiers changed from: protected */
    public SwipeDismissBehavior<? extends View> h() {
        return new Behavior();
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        this.f19578b.setOnAttachStateChangeListener(new c() {
            public void a(View view) {
                WindowInsets rootWindowInsets;
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = BaseTransientBottomBar.this.f19578b.getRootWindowInsets()) != null) {
                    int unused = BaseTransientBottomBar.this.f19593t = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    BaseTransientBottomBar.this.o();
                }
            }

            public void b(View view) {
                if (BaseTransientBottomBar.this.g()) {
                    BaseTransientBottomBar.f19574a.post(new Runnable() {
                        public void run() {
                            BaseTransientBottomBar.this.d(3);
                        }
                    });
                }
            }
        });
        if (this.f19578b.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f19578b.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                a((CoordinatorLayout.d) layoutParams);
            }
            this.f19594u = u();
            o();
            this.f19578b.setVisibility(4);
            this.f19580g.addView(this.f19578b);
        }
        if (ac.G(this.f19578b)) {
            r();
        } else {
            this.f19578b.setOnLayoutChangeListener(new d() {
                public void a(View view, int i2, int i3, int i4, int i5) {
                    BaseTransientBottomBar.this.f19578b.setOnLayoutChangeListener((d) null);
                    BaseTransientBottomBar.this.r();
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f19578b.post(new Runnable() {
            public void run() {
                if (BaseTransientBottomBar.this.f19578b != null) {
                    if (BaseTransientBottomBar.this.f19578b.getParent() != null) {
                        BaseTransientBottomBar.this.f19578b.setVisibility(0);
                    }
                    if (BaseTransientBottomBar.this.f19578b.getAnimationMode() == 1) {
                        BaseTransientBottomBar.this.v();
                    } else {
                        BaseTransientBottomBar.this.w();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void k() {
        b.a().b(this.f19579c);
        List<a<B>> list = this.f19595v;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f19595v.get(size).a(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        AccessibilityManager accessibilityManager = this.f19597x;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }
}
