package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.s;
import gl.k;
import gw.h;
import gw.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t.ac;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.a {

    /* renamed from: g  reason: collision with root package name */
    private static final int f18547g = R.style.Widget_MaterialComponents_BottomAppBar;

    /* renamed from: e  reason: collision with root package name */
    AnimatorListenerAdapter f18548e;

    /* renamed from: f  reason: collision with root package name */
    k<FloatingActionButton> f18549f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f18550h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final h f18551i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public Animator f18552j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public Animator f18553k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f18554l;

    /* renamed from: m  reason: collision with root package name */
    private int f18555m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f18556n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final boolean f18557o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final boolean f18558p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final boolean f18559q;

    /* renamed from: r  reason: collision with root package name */
    private int f18560r;

    /* renamed from: s  reason: collision with root package name */
    private ArrayList<a> f18561s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f18562t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public boolean f18563u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f18564v;

    /* renamed from: w  reason: collision with root package name */
    private Behavior f18565w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public int f18566x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f18567y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public int f18568z;

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Rect f18587a = new Rect();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<BottomAppBar> f18588b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f18589c;

        /* renamed from: d  reason: collision with root package name */
        private final View.OnLayoutChangeListener f18590d = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f18588b.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                floatingActionButton.b(Behavior.this.f18587a);
                int height = Behavior.this.f18587a.height();
                bottomAppBar.c(height);
                bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().f().a(new RectF(Behavior.this.f18587a)));
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
                if (Behavior.this.f18589c == 0) {
                    dVar.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    dVar.leftMargin = bottomAppBar.getLeftInset();
                    dVar.rightMargin = bottomAppBar.getRightInset();
                    if (s.a(floatingActionButton)) {
                        dVar.leftMargin += bottomAppBar.f18550h;
                    } else {
                        dVar.rightMargin += bottomAppBar.f18550h;
                    }
                }
            }
        };

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i2) {
            this.f18588b = new WeakReference<>(bottomAppBar);
            View w2 = bottomAppBar.p();
            if (w2 != null && !ac.G(w2)) {
                CoordinatorLayout.d dVar = (CoordinatorLayout.d) w2.getLayoutParams();
                dVar.f2756d = 49;
                this.f18589c = dVar.bottomMargin;
                if (w2 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) w2;
                    floatingActionButton.addOnLayoutChangeListener(this.f18590d);
                    bottomAppBar.a(floatingActionButton);
                }
                bottomAppBar.s();
            }
            coordinatorLayout.b((View) bottomAppBar, i2);
            return super.a(coordinatorLayout, bottomAppBar, i2);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.a(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f18592a;

        /* renamed from: b  reason: collision with root package name */
        boolean f18593b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f18592a = parcel.readInt();
            this.f18593b = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f18592a);
            parcel.writeInt(this.f18593b ? 1 : 0);
        }
    }

    interface a {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public BottomAppBar(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BottomAppBar(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = f18547g
            android.content.Context r11 = gx.a.a(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            gw.h r11 = new gw.h
            r11.<init>()
            r10.f18551i = r11
            r7 = 0
            r10.f18560r = r7
            r10.f18562t = r7
            r10.f18563u = r7
            r0 = 1
            r10.f18564v = r0
            com.google.android.material.bottomappbar.BottomAppBar$1 r0 = new com.google.android.material.bottomappbar.BottomAppBar$1
            r0.<init>()
            r10.f18548e = r0
            com.google.android.material.bottomappbar.BottomAppBar$2 r0 = new com.google.android.material.bottomappbar.BottomAppBar$2
            r0.<init>()
            r10.f18549f = r0
            android.content.Context r8 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.BottomAppBar
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.BottomAppBar_backgroundTint
            android.content.res.ColorStateList r1 = gt.c.a((android.content.Context) r8, (android.content.res.TypedArray) r0, (int) r1)
            int r2 = com.google.android.material.R.styleable.BottomAppBar_elevation
            int r2 = r0.getDimensionPixelSize(r2, r7)
            int r3 = com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin
            int r3 = r0.getDimensionPixelOffset(r3, r7)
            float r3 = (float) r3
            int r4 = com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius
            int r4 = r0.getDimensionPixelOffset(r4, r7)
            float r4 = (float) r4
            int r5 = com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset
            int r5 = r0.getDimensionPixelOffset(r5, r7)
            float r5 = (float) r5
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode
            int r9 = r0.getInt(r9, r7)
            r10.f18554l = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode
            int r9 = r0.getInt(r9, r7)
            r10.f18555m = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_hideOnScroll
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f18556n = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f18557o = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f18558p = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets
            boolean r7 = r0.getBoolean(r9, r7)
            r10.f18559q = r7
            r0.recycle()
            android.content.res.Resources r0 = r10.getResources()
            int r7 = com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode
            int r0 = r0.getDimensionPixelOffset(r7)
            r10.f18550h = r0
            com.google.android.material.bottomappbar.a r0 = new com.google.android.material.bottomappbar.a
            r0.<init>(r3, r4, r5)
            gw.m$a r3 = gw.m.a()
            gw.m$a r0 = r3.a((gw.f) r0)
            gw.m r0 = r0.a()
            r11.setShapeAppearanceModel(r0)
            r0 = 2
            r11.D(r0)
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            r11.a((android.graphics.Paint.Style) r0)
            r11.a((android.content.Context) r8)
            float r0 = (float) r2
            r10.setElevation(r0)
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r11, (android.content.res.ColorStateList) r1)
            t.ac.a((android.view.View) r10, (android.graphics.drawable.Drawable) r11)
            com.google.android.material.bottomappbar.BottomAppBar$3 r11 = new com.google.android.material.bottomappbar.BottomAppBar$3
            r11.<init>()
            com.google.android.material.internal.s.a(r10, r12, r13, r6, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        if (!ac.G(this)) {
            this.f18563u = false;
            b(this.f18562t);
            return;
        }
        Animator animator = this.f18553k;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!q()) {
            i2 = 0;
            z2 = false;
        }
        a(i2, z2, (List<Animator>) arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f18553k = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BottomAppBar.this.n();
                boolean unused = BottomAppBar.this.f18563u = false;
                Animator unused2 = BottomAppBar.this.f18553k = null;
            }

            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.m();
            }
        });
        this.f18553k.start();
    }

    private void a(final int i2, final boolean z2, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            if (Math.abs(actionMenuView.getTranslationX() - ((float) a(actionMenuView, i2, z2))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.addListener(new AnimatorListenerAdapter() {

                    /* renamed from: a  reason: collision with root package name */
                    public boolean f18577a;

                    public void onAnimationCancel(Animator animator) {
                        this.f18577a = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!this.f18577a) {
                            boolean z2 = BottomAppBar.this.f18562t != 0;
                            BottomAppBar bottomAppBar = BottomAppBar.this;
                            bottomAppBar.b(bottomAppBar.f18562t);
                            BottomAppBar.this.a(actionMenuView, i2, z2, z2);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(150);
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final ActionMenuView actionMenuView, final int i2, final boolean z2, boolean z3) {
        AnonymousClass8 r0 = new Runnable() {
            public void run() {
                ActionMenuView actionMenuView = actionMenuView;
                actionMenuView.setTranslationX((float) BottomAppBar.this.a(actionMenuView, i2, z2));
            }
        };
        if (z3) {
            actionMenuView.post(r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    public void a(FloatingActionButton floatingActionButton) {
        floatingActionButton.b((Animator.AnimatorListener) this.f18548e);
        floatingActionButton.a((Animator.AnimatorListener) new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.f18548e.onAnimationStart(animator);
                FloatingActionButton q2 = BottomAppBar.this.o();
                if (q2 != null) {
                    q2.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.a((k<? extends FloatingActionButton>) this.f18549f);
    }

    private void b(int i2, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o(), "translationX", new float[]{e(i2)});
        ofFloat.setDuration(300);
        list.add(ofFloat);
    }

    private void b(ActionMenuView actionMenuView, int i2, boolean z2) {
        a(actionMenuView, i2, z2, false);
    }

    private void d(int i2) {
        if (this.f18554l != i2 && ac.G(this)) {
            Animator animator = this.f18552j;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.f18555m == 1) {
                b(i2, (List<Animator>) arrayList);
            } else {
                a(i2, (List<Animator>) arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f18552j = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.n();
                    Animator unused = BottomAppBar.this.f18552j = null;
                }

                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.m();
                }
            });
            this.f18552j.start();
        }
    }

    /* access modifiers changed from: private */
    public float e(int i2) {
        boolean a2 = s.a(this);
        int i3 = 1;
        if (i2 != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) - (this.f18550h + (a2 ? this.f18568z : this.f18567y));
        if (a2) {
            i3 = -1;
        }
        return (float) (measuredWidth * i3);
    }

    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int getBottomInset() {
        return this.f18566x;
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return e(this.f18554l);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().c();
    }

    /* access modifiers changed from: private */
    public int getLeftInset() {
        return this.f18568z;
    }

    /* access modifiers changed from: private */
    public int getRightInset() {
        return this.f18567y;
    }

    /* access modifiers changed from: private */
    public a getTopEdgeTreatment() {
        return (a) this.f18551i.M().k();
    }

    /* access modifiers changed from: private */
    public void m() {
        ArrayList<a> arrayList;
        int i2 = this.f18560r;
        this.f18560r = i2 + 1;
        if (i2 == 0 && (arrayList = this.f18561s) != null) {
            Iterator<a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        ArrayList<a> arrayList;
        int i2 = this.f18560r - 1;
        this.f18560r = i2;
        if (i2 == 0 && (arrayList = this.f18561s) != null) {
            Iterator<a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().b(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public FloatingActionButton o() {
        View p2 = p();
        if (p2 instanceof FloatingActionButton) {
            return (FloatingActionButton) p2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View p() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.d((android.view.View) r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.p():android.view.View");
    }

    private boolean q() {
        FloatingActionButton o2 = o();
        return o2 != null && o2.c();
    }

    /* access modifiers changed from: private */
    public void r() {
        Animator animator = this.f18553k;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f18552j;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        getTopEdgeTreatment().b(getFabTranslationX());
        View p2 = p();
        this.f18551i.p((!this.f18564v || !q()) ? 0.0f : 1.0f);
        if (p2 != null) {
            p2.setTranslationY(getFabTranslationY());
            p2.setTranslationX(getFabTranslationX());
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.f18553k == null) {
            actionMenuView.setAlpha(1.0f);
            if (!q()) {
                b(actionMenuView, 0, false);
            } else {
                b(actionMenuView, this.f18554l, this.f18564v);
            }
        }
    }

    /* access modifiers changed from: protected */
    public int a(ActionMenuView actionMenuView, int i2, boolean z2) {
        if (i2 != 1 || !z2) {
            return 0;
        }
        boolean a2 = s.a(this);
        int measuredWidth = a2 ? getMeasuredWidth() : 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f490a & 8388615) == 8388611) {
                measuredWidth = a2 ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((a2 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (a2 ? this.f18567y : -this.f18568z));
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, List<Animator> list) {
        FloatingActionButton o2 = o();
        if (o2 != null && !o2.b()) {
            m();
            o2.b((FloatingActionButton.a) new FloatingActionButton.a() {
                public void a(FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.e(i2));
                    floatingActionButton.a((FloatingActionButton.a) new FloatingActionButton.a() {
                        public void b(FloatingActionButton floatingActionButton) {
                            BottomAppBar.this.n();
                        }
                    });
                }
            });
        }
    }

    public void b(int i2) {
        if (i2 != 0) {
            this.f18562t = 0;
            getMenu().clear();
            a(i2);
        }
    }

    public void b(int i2, int i3) {
        this.f18562t = i3;
        this.f18563u = true;
        a(i2, this.f18564v);
        d(i2);
        this.f18554l = i2;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2) {
        float f2 = (float) i2;
        if (f2 == getTopEdgeTreatment().a()) {
            return false;
        }
        getTopEdgeTreatment().a(f2);
        this.f18551i.invalidateSelf();
        return true;
    }

    public ColorStateList getBackgroundTint() {
        return this.f18551i.P();
    }

    public Behavior getBehavior() {
        if (this.f18565w == null) {
            this.f18565w = new Behavior();
        }
        return this.f18565w;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().c();
    }

    public int getFabAlignmentMode() {
        return this.f18554l;
    }

    public int getFabAnimationMode() {
        return this.f18555m;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().d();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().e();
    }

    public boolean getHideOnScroll() {
        return this.f18556n;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this, this.f18551i);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            r();
            s();
        }
        t();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f18554l = savedState.f18592a;
        this.f18564v = savedState.f18593b;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f18592a = this.f18554l;
        savedState.f18593b = this.f18564v;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        androidx.core.graphics.drawable.a.a((Drawable) this.f18551i, colorStateList);
    }

    public void setCradleVerticalOffset(float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().c(f2);
            this.f18551i.invalidateSelf();
            s();
        }
    }

    public void setElevation(float f2) {
        this.f18551i.r(f2);
        getBehavior().a(this, this.f18551i.Y() - this.f18551i.ab());
    }

    public void setFabAlignmentMode(int i2) {
        b(i2, 0);
    }

    public void setFabAnimationMode(int i2) {
        this.f18555m = i2;
    }

    /* access modifiers changed from: package-private */
    public void setFabCornerSize(float f2) {
        if (f2 != getTopEdgeTreatment().f()) {
            getTopEdgeTreatment().f(f2);
            this.f18551i.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().d(f2);
            this.f18551i.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().e(f2);
            this.f18551i.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z2) {
        this.f18556n = z2;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }
}
