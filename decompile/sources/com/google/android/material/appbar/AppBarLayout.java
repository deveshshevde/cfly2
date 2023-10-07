package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import gw.h;
import gw.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import t.ac;
import t.ak;
import t.m;
import u.c;
import u.f;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18384a = R.style.Widget_Design_AppBarLayout;

    /* renamed from: b  reason: collision with root package name */
    private int f18385b;

    /* renamed from: c  reason: collision with root package name */
    private int f18386c;

    /* renamed from: d  reason: collision with root package name */
    private int f18387d;

    /* renamed from: e  reason: collision with root package name */
    private int f18388e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18389f;

    /* renamed from: g  reason: collision with root package name */
    private int f18390g;

    /* renamed from: h  reason: collision with root package name */
    private ak f18391h;

    /* renamed from: i  reason: collision with root package name */
    private List<a> f18392i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18393j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18394k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18395l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f18396m;

    /* renamed from: n  reason: collision with root package name */
    private int f18397n;

    /* renamed from: o  reason: collision with root package name */
    private WeakReference<View> f18398o;

    /* renamed from: p  reason: collision with root package name */
    private ValueAnimator f18399p;

    /* renamed from: q  reason: collision with root package name */
    private int[] f18400q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f18401r;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f18405b;

        /* renamed from: c  reason: collision with root package name */
        private int f18406c;

        /* renamed from: d  reason: collision with root package name */
        private ValueAnimator f18407d;

        /* renamed from: e  reason: collision with root package name */
        private int f18408e = -1;

        /* renamed from: f  reason: collision with root package name */
        private boolean f18409f;

        /* renamed from: g  reason: collision with root package name */
        private float f18410g;

        /* renamed from: h  reason: collision with root package name */
        private WeakReference<View> f18411h;

        /* renamed from: i  reason: collision with root package name */
        private a f18412i;

        protected static class SavedState extends AbsSavedState {
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
            int f18424a;

            /* renamed from: b  reason: collision with root package name */
            float f18425b;

            /* renamed from: d  reason: collision with root package name */
            boolean f18426d;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f18424a = parcel.readInt();
                this.f18425b = parcel.readFloat();
                this.f18426d = parcel.readByte() != 0;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f18424a);
                parcel.writeFloat(this.f18425b);
                parcel.writeByte(this.f18426d ? (byte) 1 : 0);
            }
        }

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t2);
        }

        public BaseBehavior() {
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int a(T t2, int i2) {
            int childCount = t2.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t2.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (a(layoutParams.a(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof m) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private void a(CoordinatorLayout coordinatorLayout, T t2, int i2, float f2) {
            int abs = Math.abs(b() - i2);
            float abs2 = Math.abs(f2);
            a(coordinatorLayout, t2, i2, abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) t2.getHeight())) + 1.0f) * 150.0f));
        }

        private void a(final CoordinatorLayout coordinatorLayout, final T t2, int i2, int i3) {
            int b2 = b();
            if (b2 == i2) {
                ValueAnimator valueAnimator = this.f18407d;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f18407d.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f18407d;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f18407d = valueAnimator3;
                valueAnimator3.setInterpolator(gl.a.f28539e);
                this.f18407d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.a_(coordinatorLayout, t2, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.f18407d.setDuration((long) Math.min(i3, 600));
            this.f18407d.setIntValues(new int[]{b2, i2});
            this.f18407d.start();
        }

        private void a(CoordinatorLayout coordinatorLayout, T t2, int i2, int i3, boolean z2) {
            View c2 = c((AppBarLayout) t2, i2);
            if (c2 != null) {
                int a2 = ((LayoutParams) c2.getLayoutParams()).a();
                boolean z3 = false;
                if ((a2 & 1) != 0) {
                    int q2 = ac.q(c2);
                    if (i3 <= 0 || (a2 & 12) == 0 ? !((a2 & 2) == 0 || (-i2) < (c2.getBottom() - q2) - t2.getTopInset()) : (-i2) >= (c2.getBottom() - q2) - t2.getTopInset()) {
                        z3 = true;
                    }
                }
                if (t2.d()) {
                    z3 = t2.a(a(coordinatorLayout));
                }
                boolean a3 = t2.a(z3);
                if (z2 || (a3 && e(coordinatorLayout, t2))) {
                    t2.jumpDrawablesToCurrentState();
                }
            }
        }

        private void a(CoordinatorLayout coordinatorLayout, final T t2, c.a aVar, final boolean z2) {
            ac.a(coordinatorLayout, aVar, (CharSequence) null, new f() {
                public boolean a(View view, f.a aVar) {
                    t2.setExpanded(z2);
                    return true;
                }
            });
        }

        private static boolean a(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t2, View view) {
            return t2.c() && coordinatorLayout.getHeight() - view.getHeight() <= t2.getHeight();
        }

        private int b(T t2, int i2) {
            int abs = Math.abs(i2);
            int childCount = t2.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t2.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b2 = layoutParams.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = layoutParams.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= ac.q(childAt);
                        }
                    }
                    if (ac.x(childAt)) {
                        i3 -= t2.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = (float) i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation(((float) (abs - childAt.getTop())) / f2)));
                    }
                }
            }
            return i2;
        }

        private void b(CoordinatorLayout coordinatorLayout, T t2, View view) {
            if (b() != (-t2.getTotalScrollRange()) && view.canScrollVertically(1)) {
                a(coordinatorLayout, t2, c.a.f34543m, false);
            }
            if (b() == 0) {
                return;
            }
            if (view.canScrollVertically(-1)) {
                final int i2 = -t2.getDownNestedPreScrollRange();
                if (i2 != 0) {
                    final CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
                    final T t3 = t2;
                    final View view2 = view;
                    ac.a(coordinatorLayout, c.a.f34544n, (CharSequence) null, new f() {
                        public boolean a(View view, f.a aVar) {
                            BaseBehavior.this.a(coordinatorLayout2, t3, view2, 0, i2, new int[]{0, 0}, 1);
                            return true;
                        }
                    });
                    return;
                }
                return;
            }
            a(coordinatorLayout, t2, c.a.f34544n, true);
        }

        private static View c(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private void c(CoordinatorLayout coordinatorLayout, T t2) {
            int b2 = b();
            int a2 = a(t2, b2);
            if (a2 >= 0) {
                View childAt = t2.getChildAt(a2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a3 = layoutParams.a();
                if ((a3 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (a2 == t2.getChildCount() - 1) {
                        i3 += t2.getTopInset();
                    }
                    if (a(a3, 2)) {
                        i3 += ac.q(childAt);
                    } else if (a(a3, 5)) {
                        int q2 = ac.q(childAt) + i3;
                        if (b2 < q2) {
                            i2 = q2;
                        } else {
                            i3 = q2;
                        }
                    }
                    if (a(a3, 32)) {
                        i2 += layoutParams.topMargin;
                        i3 -= layoutParams.bottomMargin;
                    }
                    if (b2 < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    a(coordinatorLayout, t2, o.a.a(i2, -t2.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void d(CoordinatorLayout coordinatorLayout, T t2) {
            ac.c((View) coordinatorLayout, c.a.f34543m.a());
            ac.c((View) coordinatorLayout, c.a.f34544n.a());
            View a2 = a(coordinatorLayout);
            if (a2 != null && t2.getTotalScrollRange() != 0 && (((CoordinatorLayout.d) a2.getLayoutParams()).b() instanceof ScrollingViewBehavior)) {
                b(coordinatorLayout, t2, a2);
            }
        }

        private boolean e(CoordinatorLayout coordinatorLayout, T t2) {
            List<View> d2 = coordinatorLayout.d((View) t2);
            int size = d2.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.Behavior b2 = ((CoordinatorLayout.d) d2.get(i2).getLayoutParams()).b();
                if (b2 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) b2).e() != 0;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public int a(CoordinatorLayout coordinatorLayout, T t2, int i2, int i3, int i4) {
            int b2 = b();
            int i5 = 0;
            if (i3 == 0 || b2 < i3 || b2 > i4) {
                this.f18405b = 0;
            } else {
                int a2 = o.a.a(i2, i3, i4);
                if (b2 != a2) {
                    int b3 = t2.b() ? b(t2, a2) : a2;
                    boolean a3 = a(b3);
                    i5 = b2 - a2;
                    this.f18405b = a2 - b3;
                    if (!a3 && t2.b()) {
                        coordinatorLayout.b((View) t2);
                    }
                    t2.a(c());
                    a(coordinatorLayout, t2, a2, a2 < b2 ? -1 : 1, false);
                }
            }
            d(coordinatorLayout, t2);
            return i5;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void e(CoordinatorLayout coordinatorLayout, T t2) {
            c(coordinatorLayout, t2);
            if (t2.d()) {
                t2.a(t2.a(a(coordinatorLayout)));
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, T t2, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.a(coordinatorLayout, t2, savedState.a());
                this.f18408e = savedState.f18424a;
                this.f18410g = savedState.f18425b;
                this.f18409f = savedState.f18426d;
                return;
            }
            super.a(coordinatorLayout, t2, parcelable);
            this.f18408e = -1;
        }

        public void a(CoordinatorLayout coordinatorLayout, T t2, View view, int i2) {
            if (this.f18406c == 0 || i2 == 1) {
                c(coordinatorLayout, t2);
                if (t2.d()) {
                    t2.a(t2.a(view));
                }
            }
            this.f18411h = new WeakReference<>(view);
        }

        public void a(CoordinatorLayout coordinatorLayout, T t2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = b(coordinatorLayout, t2, i5, -t2.getDownNestedScrollRange(), 0);
            }
            if (i5 == 0) {
                d(coordinatorLayout, t2);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, T t2, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t2.getTotalScrollRange();
                    i6 = i7;
                    i5 = t2.getDownNestedPreScrollRange() + i7;
                } else {
                    i6 = -t2.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i6 != i5) {
                    iArr[1] = b(coordinatorLayout, t2, i3, i6, i5);
                }
            }
            if (t2.d()) {
                t2.a(t2.a(view));
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t2, int i2) {
            boolean a2 = super.a(coordinatorLayout, t2, i2);
            int pendingAction = t2.getPendingAction();
            int i3 = this.f18408e;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t2.getChildAt(i3);
                a_(coordinatorLayout, t2, (-childAt.getBottom()) + (this.f18409f ? ac.q(childAt) + t2.getTopInset() : Math.round(((float) childAt.getHeight()) * this.f18410g)));
            } else if (pendingAction != 0) {
                boolean z2 = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -t2.getUpNestedPreScrollRange();
                    if (z2) {
                        a(coordinatorLayout, t2, i4, 0.0f);
                    } else {
                        a_(coordinatorLayout, t2, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z2) {
                        a(coordinatorLayout, t2, 0, 0.0f);
                    } else {
                        a_(coordinatorLayout, t2, 0);
                    }
                }
            }
            t2.e();
            this.f18408e = -1;
            a(o.a.a(c(), -t2.getTotalScrollRange(), 0));
            a(coordinatorLayout, t2, c(), 0, true);
            t2.a(c());
            d(coordinatorLayout, t2);
            return a2;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t2, int i2, int i3, int i4, int i5) {
            if (((CoordinatorLayout.d) t2.getLayoutParams()).height != -2) {
                return super.a(coordinatorLayout, t2, i2, i3, i4, i5);
            }
            coordinatorLayout.a((View) t2, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, T t2, View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z2 = (i2 & 2) != 0 && (t2.d() || a(coordinatorLayout, t2, view));
            if (z2 && (valueAnimator = this.f18407d) != null) {
                valueAnimator.cancel();
            }
            this.f18411h = null;
            this.f18406c = i3;
            return z2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean c(T t2) {
            a aVar = this.f18412i;
            if (aVar != null) {
                return aVar.a(t2);
            }
            WeakReference<View> weakReference = this.f18411h;
            if (weakReference == null) {
                return true;
            }
            View view = (View) weakReference.get();
            return view != null && view.isShown() && !view.canScrollVertically(-1);
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return c() + this.f18405b;
        }

        /* access modifiers changed from: package-private */
        public int b(T t2) {
            return -t2.getDownNestedScrollRange();
        }

        /* renamed from: b */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t2) {
            Parcelable d2 = super.d(coordinatorLayout, t2);
            int c2 = c();
            int childCount = t2.getChildCount();
            boolean z2 = false;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = t2.getChildAt(i2);
                int bottom = childAt.getBottom() + c2;
                if (childAt.getTop() + c2 > 0 || bottom < 0) {
                    i2++;
                } else {
                    SavedState savedState = new SavedState(d2);
                    savedState.f18424a = i2;
                    if (bottom == ac.q(childAt) + t2.getTopInset()) {
                        z2 = true;
                    }
                    savedState.f18426d = z2;
                    savedState.f18425b = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return d2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public int a(T t2) {
            return t2.getTotalScrollRange();
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.a(coordinatorLayout, appBarLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            super.a(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6, iArr);
        }

        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.a(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        public /* bridge */ /* synthetic */ boolean a(int i2) {
            return super.a(i2);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.a(coordinatorLayout, appBarLayout, i2);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.a(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.a(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        public /* bridge */ /* synthetic */ Parcelable b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f18427a = 1;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f18428b;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f18427a = obtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f18428b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public int a() {
            return this.f18427a;
        }

        public Interpolator b() {
            return this.f18428b;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            int i2 = this.f18427a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            b(obtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior b2 = ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).b();
            if (b2 instanceof BaseBehavior) {
                return ((BaseBehavior) b2).b();
            }
            return 0;
        }

        private void a(View view, View view2) {
            CoordinatorLayout.Behavior b2 = ((CoordinatorLayout.d) view2.getLayoutParams()).b();
            if (b2 instanceof BaseBehavior) {
                ac.e(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) b2).f18405b) + d()) - c(view2));
            }
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.d()) {
                    appBarLayout.a(appBarLayout.a(view));
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float a(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int a2 = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + a2 > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) a2) / ((float) i2)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public AppBarLayout b(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public /* bridge */ /* synthetic */ boolean a(int i2) {
            return super.a(i2);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.a(coordinatorLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.a(coordinatorLayout, view, i2, i3, i4, i5);
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            AppBarLayout a2 = b(coordinatorLayout.c(view));
            if (a2 != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f18470a;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    a2.a(false, !z2);
                    return true;
                }
            }
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        /* access modifiers changed from: package-private */
        public int b(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.b(view);
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        public void c(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                ac.c((View) coordinatorLayout, c.a.f34543m.a());
                ac.c((View) coordinatorLayout, c.a.f34544n.a());
            }
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t2, int i2);
    }

    public interface b extends a<AppBarLayout> {
    }

    public AppBarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            r9 = this;
            int r4 = f18384a
            android.content.Context r10 = gx.a.a(r10, r11, r12, r4)
            r9.<init>(r10, r11, r12)
            r10 = -1
            r9.f18386c = r10
            r9.f18387d = r10
            r9.f18388e = r10
            r6 = 0
            r9.f18390g = r6
            android.content.Context r7 = r9.getContext()
            r0 = 1
            r9.setOrientation(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r8 = 21
            if (r0 < r8) goto L_0x0027
            com.google.android.material.appbar.b.a(r9)
            com.google.android.material.appbar.b.a(r9, r11, r12, r4)
        L_0x0027:
            int[] r2 = com.google.android.material.R.styleable.AppBarLayout
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r11
            r3 = r12
            android.content.res.TypedArray r11 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_background
            android.graphics.drawable.Drawable r12 = r11.getDrawable(r12)
            t.ac.a((android.view.View) r9, (android.graphics.drawable.Drawable) r12)
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            boolean r12 = r12 instanceof android.graphics.drawable.ColorDrawable
            if (r12 == 0) goto L_0x005f
            android.graphics.drawable.Drawable r12 = r9.getBackground()
            android.graphics.drawable.ColorDrawable r12 = (android.graphics.drawable.ColorDrawable) r12
            gw.h r0 = new gw.h
            r0.<init>()
            int r12 = r12.getColor()
            android.content.res.ColorStateList r12 = android.content.res.ColorStateList.valueOf(r12)
            r0.g((android.content.res.ColorStateList) r12)
            r0.a((android.content.Context) r7)
            t.ac.a((android.view.View) r9, (android.graphics.drawable.Drawable) r0)
        L_0x005f:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x0070
            int r12 = com.google.android.material.R.styleable.AppBarLayout_expanded
            boolean r12 = r11.getBoolean(r12, r6)
            r9.a(r12, r6, r6)
        L_0x0070:
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r8) goto L_0x0086
            int r12 = com.google.android.material.R.styleable.AppBarLayout_elevation
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x0086
            int r12 = com.google.android.material.R.styleable.AppBarLayout_elevation
            int r12 = r11.getDimensionPixelSize(r12, r6)
            float r12 = (float) r12
            com.google.android.material.appbar.b.a(r9, r12)
        L_0x0086:
            int r12 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r12 < r0) goto L_0x00ae
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x009d
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_keyboardNavigationCluster
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setKeyboardNavigationCluster(r12)
        L_0x009d:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r12 = r11.hasValue(r12)
            if (r12 == 0) goto L_0x00ae
            int r12 = com.google.android.material.R.styleable.AppBarLayout_android_touchscreenBlocksFocus
            boolean r12 = r11.getBoolean(r12, r6)
            r9.setTouchscreenBlocksFocus(r12)
        L_0x00ae:
            int r12 = com.google.android.material.R.styleable.AppBarLayout_liftOnScroll
            boolean r12 = r11.getBoolean(r12, r6)
            r9.f18396m = r12
            int r12 = com.google.android.material.R.styleable.AppBarLayout_liftOnScrollTargetViewId
            int r10 = r11.getResourceId(r12, r10)
            r9.f18397n = r10
            int r10 = com.google.android.material.R.styleable.AppBarLayout_statusBarForeground
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r10)
            r9.setStatusBarForeground(r10)
            r11.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r10 = new com.google.android.material.appbar.AppBarLayout$1
            r10.<init>()
            t.ac.a((android.view.View) r9, (t.u) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void a(final h hVar, boolean z2) {
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f2 = z2 ? 0.0f : dimension;
        if (!z2) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f18399p;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, dimension});
        this.f18399p = ofFloat;
        ofFloat.setDuration((long) getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.f18399p.setInterpolator(gl.a.f28535a);
        this.f18399p.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                hVar.r(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f18399p.start();
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        int i2 = 0;
        int i3 = (z2 ? 1 : 2) | (z3 ? 4 : 0);
        if (z4) {
            i2 = 8;
        }
        this.f18390g = i3 | i2;
        requestLayout();
    }

    private View b(View view) {
        int i2;
        if (this.f18398o == null && (i2 = this.f18397n) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f18397n);
            }
            if (findViewById != null) {
                this.f18398o = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.f18398o;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    private boolean b(boolean z2) {
        if (this.f18394k == z2) {
            return false;
        }
        this.f18394k = z2;
        refreshDrawableState();
        return true;
    }

    private void f() {
        setWillNotDraw(!g());
    }

    private boolean g() {
        return this.f18401r != null && getTopInset() > 0;
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void i() {
        this.f18386c = -1;
        this.f18387d = -1;
        this.f18388e = -1;
    }

    private void j() {
        WeakReference<View> weakReference = this.f18398o;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f18398o = null;
    }

    private boolean k() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return childAt.getVisibility() != 8 && !ac.x(childAt);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams) : new LayoutParams((LinearLayout.LayoutParams) layoutParams);
    }

    /* access modifiers changed from: package-private */
    public ak a(ak akVar) {
        ak akVar2 = ac.x(this) ? akVar : null;
        if (!s.c.a((Object) this.f18391h, (Object) akVar2)) {
            this.f18391h = akVar2;
            f();
            requestLayout();
        }
        return akVar;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f18385b = i2;
        if (!willNotDraw()) {
            ac.e(this);
        }
        List<a> list = this.f18392i;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.f18392i.get(i3);
                if (aVar != null) {
                    aVar.a(this, i2);
                }
            }
        }
    }

    public void a(a aVar) {
        if (this.f18392i == null) {
            this.f18392i = new ArrayList();
        }
        if (aVar != null && !this.f18392i.contains(aVar)) {
            this.f18392i.add(aVar);
        }
    }

    public void a(b bVar) {
        a((a) bVar);
    }

    public void a(boolean z2, boolean z3) {
        a(z2, z3, true);
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view) {
        View b2 = b(view);
        if (b2 != null) {
            view = b2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z2) {
        if (this.f18395l == z2) {
            return false;
        }
        this.f18395l = z2;
        refreshDrawableState();
        if (!this.f18396m || !(getBackground() instanceof h)) {
            return true;
        }
        a((h) getBackground(), z2);
        return true;
    }

    public void b(a aVar) {
        List<a> list = this.f18392i;
        if (list != null && aVar != null) {
            list.remove(aVar);
        }
    }

    public void b(b bVar) {
        b((a) bVar);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f18389f;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean d() {
        return this.f18396m;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (g()) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.f18385b));
            this.f18401r.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f18401r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        this.f18390g = 0;
    }

    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int q2;
        int i3 = this.f18387d;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f18427a;
            if ((i5 & 5) == 5) {
                int i6 = layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i5 & 8) != 0) {
                    q2 = ac.q(childAt);
                } else if ((i5 & 2) != 0) {
                    q2 = measuredHeight - ac.q(childAt);
                } else {
                    i2 = i6 + measuredHeight;
                    if (childCount == 0 && ac.x(childAt)) {
                        i2 = Math.min(i2, measuredHeight - getTopInset());
                    }
                    i4 += i2;
                }
                i2 = i6 + q2;
                i2 = Math.min(i2, measuredHeight - getTopInset());
                i4 += i2;
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f18387d = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.f18388e;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i5 = layoutParams.f18427a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= ac.q(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f18388e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f18397n;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int q2 = ac.q(this);
        if (q2 == 0) {
            int childCount = getChildCount();
            q2 = childCount >= 1 ? ac.q(getChildAt(childCount - 1)) : 0;
            if (q2 == 0) {
                return getHeight() / 3;
            }
        }
        return (q2 * 2) + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f18390g;
    }

    public Drawable getStatusBarForeground() {
        return this.f18401r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        ak akVar = this.f18391h;
        if (akVar != null) {
            return akVar.b();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f18386c;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f18427a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if (i3 == 0 && ac.x(childAt)) {
                i4 -= getTopInset();
            }
            if ((i5 & 2) != 0) {
                i4 -= ac.q(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f18386c = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.f18400q == null) {
            this.f18400q = new int[4];
        }
        int[] iArr = this.f18400q;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        iArr[0] = this.f18394k ? R.attr.state_liftable : -R.attr.state_liftable;
        iArr[1] = (!this.f18394k || !this.f18395l) ? -R.attr.state_lifted : R.attr.state_lifted;
        iArr[2] = this.f18394k ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[3] = (!this.f18394k || !this.f18395l) ? -R.attr.state_collapsed : R.attr.state_collapsed;
        return mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        boolean z3 = true;
        if (ac.x(this) && k()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ac.e(getChildAt(childCount), topInset);
            }
        }
        i();
        this.f18389f = false;
        int childCount2 = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f18389f = true;
                break;
            } else {
                i6++;
            }
        }
        Drawable drawable = this.f18401r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f18393j) {
            if (!this.f18396m && !h()) {
                z3 = false;
            }
            b(z3);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && ac.x(this) && k()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = o.a.a(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        i();
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a((View) this, f2);
    }

    public void setExpanded(boolean z2) {
        a(z2, ac.G(this));
    }

    public void setLiftOnScroll(boolean z2) {
        this.f18396m = z2;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.f18397n = i2;
        j();
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f18401r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f18401r = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f18401r.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.f18401r, ac.i(this));
                this.f18401r.setVisible(getVisibility() == 0, false);
                this.f18401r.setCallback(this);
            }
            f();
            ac.e(this);
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(c.a.b(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.a(this, f2);
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f18401r;
        if (drawable != null) {
            drawable.setVisible(z2, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f18401r;
    }
}
