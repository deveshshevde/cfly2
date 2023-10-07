package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import gw.h;
import gw.m;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import t.ac;
import t.ak;
import u.c;
import u.f;
import x.c;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int M = R.style.Widget_Design_BottomSheet_Modal;
    /* access modifiers changed from: private */
    public int A;
    private boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    /* access modifiers changed from: private */
    public boolean E;
    private boolean F;
    /* access modifiers changed from: private */
    public int G;
    /* access modifiers changed from: private */
    public int H;
    private m I;
    private boolean J;
    private BottomSheetBehavior<V>.b K = null;
    private ValueAnimator L;
    /* access modifiers changed from: private */
    public boolean N;
    /* access modifiers changed from: private */
    public boolean O = true;
    private boolean P;
    private int Q;
    private boolean R;
    private int S;
    private final ArrayList<a> T = new ArrayList<>();
    private VelocityTracker U;
    private int V;
    private Map<View, Integer> W;
    private int X = -1;
    private final c.a Y = new c.a() {
        private boolean c(View view) {
            return view.getTop() > (BottomSheetBehavior.this.f18617k + BottomSheetBehavior.this.b()) / 2;
        }

        public int a(View view, int i2, int i3) {
            return view.getLeft();
        }

        public void a(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.O) {
                BottomSheetBehavior.this.f(1);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
            if (java.lang.Math.abs(r6.getTop() - r5.f18642a.b()) < java.lang.Math.abs(r6.getTop() - r5.f18642a.f18609c)) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
            r7 = r5.f18642a.b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b3, code lost:
            if (java.lang.Math.abs(r7 - r5.f18642a.f18609c) < java.lang.Math.abs(r7 - r5.f18642a.f18611e)) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00da, code lost:
            if (java.lang.Math.abs(r7 - r5.f18642a.f18608b) < java.lang.Math.abs(r7 - r5.f18642a.f18611e)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ee, code lost:
            if (r7 < java.lang.Math.abs(r7 - r5.f18642a.f18611e)) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0104, code lost:
            if (java.lang.Math.abs(r7 - r5.f18642a.f18609c) < java.lang.Math.abs(r7 - r5.f18642a.f18611e)) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
            if (r6.getTop() > r5.f18642a.f18609c) goto L_0x00b5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r6, float r7, float r8) {
            /*
                r5 = this;
                r0 = 0
                r1 = 4
                r2 = 6
                r3 = 3
                int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r4 >= 0) goto L_0x0023
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r7 = r7.f18623q
                if (r7 == 0) goto L_0x0017
            L_0x0010:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r7 = r7.f18608b
            L_0x0014:
                r1 = 3
                goto L_0x0107
            L_0x0017:
                int r7 = r6.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f18609c
                if (r7 <= r8) goto L_0x0077
                goto L_0x00b5
            L_0x0023:
                com.google.android.material.bottomsheet.BottomSheetBehavior r4 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r4 = r4.f18613g
                if (r4 == 0) goto L_0x007e
                com.google.android.material.bottomsheet.BottomSheetBehavior r4 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r4 = r4.a((android.view.View) r6, (float) r8)
                if (r4 == 0) goto L_0x007e
                float r7 = java.lang.Math.abs(r7)
                float r0 = java.lang.Math.abs(r8)
                int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r7 >= 0) goto L_0x0043
                r7 = 1140457472(0x43fa0000, float:500.0)
                int r7 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
                if (r7 > 0) goto L_0x0049
            L_0x0043:
                boolean r7 = r5.c(r6)
                if (r7 == 0) goto L_0x0050
            L_0x0049:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r7 = r7.f18617k
                r1 = 5
                goto L_0x0107
            L_0x0050:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r7 = r7.f18623q
                if (r7 == 0) goto L_0x0059
                goto L_0x0010
            L_0x0059:
                int r7 = r6.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.b()
                int r7 = r7 - r8
                int r7 = java.lang.Math.abs(r7)
                int r8 = r6.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f18609c
                int r8 = r8 - r0
                int r8 = java.lang.Math.abs(r8)
                if (r7 >= r8) goto L_0x00b5
            L_0x0077:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r7 = r7.b()
                goto L_0x0014
            L_0x007e:
                int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r0 == 0) goto L_0x00bb
                float r7 = java.lang.Math.abs(r7)
                float r8 = java.lang.Math.abs(r8)
                int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
                if (r7 <= 0) goto L_0x008f
                goto L_0x00bb
            L_0x008f:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r7 = r7.f18623q
                if (r7 == 0) goto L_0x009c
            L_0x0097:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r7 = r7.f18611e
                goto L_0x0107
            L_0x009c:
                int r7 = r6.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f18609c
                int r8 = r7 - r8
                int r8 = java.lang.Math.abs(r8)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f18611e
                int r7 = r7 - r0
                int r7 = java.lang.Math.abs(r7)
                if (r8 >= r7) goto L_0x0097
            L_0x00b5:
                com.google.android.material.bottomsheet.BottomSheetBehavior r7 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r7 = r7.f18609c
                r1 = 6
                goto L_0x0107
            L_0x00bb:
                int r7 = r6.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r8 = r8.f18623q
                if (r8 == 0) goto L_0x00de
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f18608b
                int r8 = r7 - r8
                int r8 = java.lang.Math.abs(r8)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f18611e
                int r7 = r7 - r0
                int r7 = java.lang.Math.abs(r7)
                if (r8 >= r7) goto L_0x0097
                goto L_0x0010
            L_0x00de:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f18609c
                if (r7 >= r8) goto L_0x00f1
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f18611e
                int r8 = r7 - r8
                int r8 = java.lang.Math.abs(r8)
                if (r7 >= r8) goto L_0x00b5
                goto L_0x0077
            L_0x00f1:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r8 = r8.f18609c
                int r8 = r7 - r8
                int r8 = java.lang.Math.abs(r8)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.f18611e
                int r7 = r7 - r0
                int r7 = java.lang.Math.abs(r7)
                if (r8 >= r7) goto L_0x0097
                goto L_0x00b5
            L_0x0107:
                com.google.android.material.bottomsheet.BottomSheetBehavior r8 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                r0 = 1
                r8.a((android.view.View) r6, (int) r1, (int) r7, (boolean) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.a(android.view.View, float, float):void");
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.g(i3);
        }

        public int b(View view) {
            return BottomSheetBehavior.this.f18613g ? BottomSheetBehavior.this.f18617k : BottomSheetBehavior.this.f18611e;
        }

        public int b(View view, int i2, int i3) {
            return o.a.a(i2, BottomSheetBehavior.this.b(), BottomSheetBehavior.this.f18613g ? BottomSheetBehavior.this.f18617k : BottomSheetBehavior.this.f18611e);
        }

        public boolean b(View view, int i2) {
            if (BottomSheetBehavior.this.f18614h == 1 || BottomSheetBehavior.this.f18621o) {
                return false;
            }
            if (BottomSheetBehavior.this.f18614h == 3 && BottomSheetBehavior.this.f18620n == i2) {
                View view2 = BottomSheetBehavior.this.f18619m != null ? (View) BottomSheetBehavior.this.f18619m.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            return BottomSheetBehavior.this.f18618l != null && BottomSheetBehavior.this.f18618l.get() == view;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f18607a;

    /* renamed from: b  reason: collision with root package name */
    int f18608b;

    /* renamed from: c  reason: collision with root package name */
    int f18609c;

    /* renamed from: d  reason: collision with root package name */
    float f18610d = 0.5f;

    /* renamed from: e  reason: collision with root package name */
    int f18611e;

    /* renamed from: f  reason: collision with root package name */
    float f18612f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    boolean f18613g;

    /* renamed from: h  reason: collision with root package name */
    int f18614h = 4;

    /* renamed from: i  reason: collision with root package name */
    c f18615i;

    /* renamed from: j  reason: collision with root package name */
    int f18616j;

    /* renamed from: k  reason: collision with root package name */
    int f18617k;

    /* renamed from: l  reason: collision with root package name */
    WeakReference<V> f18618l;

    /* renamed from: m  reason: collision with root package name */
    WeakReference<View> f18619m;

    /* renamed from: n  reason: collision with root package name */
    int f18620n;

    /* renamed from: o  reason: collision with root package name */
    boolean f18621o;

    /* renamed from: p  reason: collision with root package name */
    private int f18622p = 0;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f18623q = true;

    /* renamed from: r  reason: collision with root package name */
    private boolean f18624r = false;

    /* renamed from: s  reason: collision with root package name */
    private float f18625s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f18626t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f18627u;

    /* renamed from: v  reason: collision with root package name */
    private int f18628v;

    /* renamed from: w  reason: collision with root package name */
    private int f18629w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f18630x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public h f18631y;

    /* renamed from: z  reason: collision with root package name */
    private int f18632z = -1;

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
        final int f18645a;

        /* renamed from: b  reason: collision with root package name */
        int f18646b;

        /* renamed from: d  reason: collision with root package name */
        boolean f18647d;

        /* renamed from: e  reason: collision with root package name */
        boolean f18648e;

        /* renamed from: f  reason: collision with root package name */
        boolean f18649f;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f18645a = parcel.readInt();
            this.f18646b = parcel.readInt();
            boolean z2 = false;
            this.f18647d = parcel.readInt() == 1;
            this.f18648e = parcel.readInt() == 1;
            this.f18649f = parcel.readInt() == 1 ? true : z2;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f18645a = bottomSheetBehavior.f18614h;
            this.f18646b = bottomSheetBehavior.f18626t;
            this.f18647d = bottomSheetBehavior.f18623q;
            this.f18648e = bottomSheetBehavior.f18613g;
            this.f18649f = bottomSheetBehavior.N;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f18645a);
            parcel.writeInt(this.f18646b);
            parcel.writeInt(this.f18647d ? 1 : 0);
            parcel.writeInt(this.f18648e ? 1 : 0);
            parcel.writeInt(this.f18649f ? 1 : 0);
        }
    }

    public static abstract class a {
        public abstract void a(View view, float f2);

        public abstract void a(View view, int i2);
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f18650a;

        /* renamed from: c  reason: collision with root package name */
        private final View f18652c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f18653d;

        b(View view, int i2) {
            this.f18652c = view;
            this.f18650a = i2;
        }

        public void run() {
            if (BottomSheetBehavior.this.f18615i == null || !BottomSheetBehavior.this.f18615i.a(true)) {
                BottomSheetBehavior.this.f(this.f18650a);
            } else {
                ac.a(this.f18652c, (Runnable) this);
            }
            this.f18653d = false;
        }
    }

    public BottomSheetBehavior() {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18629w = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.f18630x = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (hasValue) {
            a(context, attributeSet, hasValue, gt.c.a(context, obtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, hasValue);
        }
        k();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f18612f = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            a(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        b((peekValue == null || peekValue.data != -1) ? obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1) : peekValue.data);
        b(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        e(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        a(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        d(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        d(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        a(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        c((peekValue2 == null || peekValue2.type != 16) ? obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0) : peekValue2.data);
        this.C = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.D = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.F = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.f18625s = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private int a(V v2, int i2, int i3) {
        return ac.a((View) v2, (CharSequence) v2.getResources().getString(i2), j(i3));
    }

    private void a(Context context, AttributeSet attributeSet, boolean z2) {
        a(context, attributeSet, z2, (ColorStateList) null);
    }

    private void a(Context context, AttributeSet attributeSet, boolean z2, ColorStateList colorStateList) {
        if (this.f18630x) {
            this.I = m.a(context, attributeSet, R.attr.bottomSheetStyle, M).a();
            h hVar = new h(this.I);
            this.f18631y = hVar;
            hVar.a(context);
            if (!z2 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f18631y.setTint(typedValue.data);
                return;
            }
            this.f18631y.g(colorStateList);
        }
    }

    private void a(V v2, c.a aVar, int i2) {
        ac.a(v2, aVar, (CharSequence) null, j(i2));
    }

    private void a(SavedState savedState) {
        int i2 = this.f18622p;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f18626t = savedState.f18646b;
            }
            int i3 = this.f18622p;
            if (i3 == -1 || (i3 & 2) == 2) {
                this.f18623q = savedState.f18647d;
            }
            int i4 = this.f18622p;
            if (i4 == -1 || (i4 & 4) == 4) {
                this.f18613g = savedState.f18648e;
            }
            int i5 = this.f18622p;
            if (i5 == -1 || (i5 & 8) == 8) {
                this.N = savedState.f18649f;
            }
        }
    }

    public static <V extends View> BottomSheetBehavior<V> b(V v2) {
        ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.d) {
            CoordinatorLayout.Behavior b2 = ((CoordinatorLayout.d) layoutParams).b();
            if (b2 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) b2;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private void c(View view) {
        final boolean z2 = Build.VERSION.SDK_INT >= 29 && !d() && !this.f18627u;
        if (this.C || this.D || this.E || z2) {
            s.a(view, (s.a) new s.a() {
                public ak a(View view, ak akVar, s.b bVar) {
                    int unused = BottomSheetBehavior.this.H = akVar.b();
                    boolean a2 = s.a(view);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingLeft = view.getPaddingLeft();
                    int paddingRight = view.getPaddingRight();
                    if (BottomSheetBehavior.this.C) {
                        int unused2 = BottomSheetBehavior.this.G = akVar.d();
                        paddingBottom = bVar.f19341d + BottomSheetBehavior.this.G;
                    }
                    if (BottomSheetBehavior.this.D) {
                        paddingLeft = (a2 ? bVar.f19340c : bVar.f19338a) + akVar.a();
                    }
                    if (BottomSheetBehavior.this.E) {
                        paddingRight = (a2 ? bVar.f19338a : bVar.f19340c) + akVar.c();
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (z2) {
                        int unused3 = BottomSheetBehavior.this.A = akVar.l().f31048e;
                    }
                    if (BottomSheetBehavior.this.C || z2) {
                        BottomSheetBehavior.this.f(false);
                    }
                    return akVar;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void f(boolean z2) {
        View view;
        if (this.f18618l != null) {
            h();
            if (this.f18614h == 4 && (view = (View) this.f18618l.get()) != null) {
                if (z2) {
                    h(this.f18614h);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r0 = r3.A;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int g() {
        /*
            r3 = this;
            boolean r0 = r3.f18627u
            if (r0 == 0) goto L_0x001d
            int r0 = r3.f18628v
            int r1 = r3.f18617k
            int r2 = r3.f18616j
            int r2 = r2 * 9
            int r2 = r2 / 16
            int r1 = r1 - r2
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r3.S
            int r0 = java.lang.Math.min(r0, r1)
            int r1 = r3.G
            int r0 = r0 + r1
            return r0
        L_0x001d:
            boolean r0 = r3.B
            if (r0 != 0) goto L_0x0033
            boolean r0 = r3.C
            if (r0 != 0) goto L_0x0033
            int r0 = r3.A
            if (r0 <= 0) goto L_0x0033
            int r1 = r3.f18626t
            int r2 = r3.f18629w
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r1, r0)
            return r0
        L_0x0033:
            int r0 = r3.f18626t
            int r1 = r3.G
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.g():int");
    }

    private void g(boolean z2) {
        Map<View, Integer> map;
        int intValue;
        WeakReference<V> weakReference = this.f18618l;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z2) {
                    if (this.W == null) {
                        this.W = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = coordinatorLayout.getChildAt(i2);
                    if (childAt != this.f18618l.get()) {
                        if (z2) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.W.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            if (this.f18624r) {
                                intValue = 4;
                            }
                        } else if (this.f18624r && (map = this.W) != null && map.containsKey(childAt)) {
                            intValue = this.W.get(childAt).intValue();
                        }
                        ac.b(childAt, intValue);
                    }
                }
                if (!z2) {
                    this.W = null;
                } else if (this.f18624r) {
                    ((View) this.f18618l.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    private void h() {
        int g2 = g();
        if (this.f18623q) {
            this.f18611e = Math.max(this.f18617k - g2, this.f18608b);
        } else {
            this.f18611e = this.f18617k - g2;
        }
    }

    private void h(final int i2) {
        final View view = (View) this.f18618l.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !ac.J(view)) {
                a(view, i2);
            } else {
                view.post(new Runnable() {
                    public void run() {
                        BottomSheetBehavior.this.a(view, i2);
                    }
                });
            }
        }
    }

    private void i() {
        this.f18609c = (int) (((float) this.f18617k) * (1.0f - this.f18610d));
    }

    private void i(int i2) {
        ValueAnimator valueAnimator;
        if (i2 != 2) {
            boolean z2 = i2 == 3;
            if (this.J != z2) {
                this.J = z2;
                if (this.f18631y != null && (valueAnimator = this.L) != null) {
                    if (valueAnimator.isRunning()) {
                        this.L.reverse();
                        return;
                    }
                    float f2 = z2 ? 0.0f : 1.0f;
                    this.L.setFloatValues(new float[]{1.0f - f2, f2});
                    this.L.start();
                }
            }
        }
    }

    private f j(final int i2) {
        return new f() {
            public boolean a(View view, f.a aVar) {
                BottomSheetBehavior.this.e(i2);
                return true;
            }
        };
    }

    private void j() {
        this.f18620n = -1;
        VelocityTracker velocityTracker = this.U;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.U = null;
        }
    }

    private void k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.L = ofFloat;
        ofFloat.setDuration(500);
        this.L.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.f18631y != null) {
                    BottomSheetBehavior.this.f18631y.p(floatValue);
                }
            }
        });
    }

    private float l() {
        VelocityTracker velocityTracker = this.U;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f18625s);
        return this.U.getYVelocity(this.f18620n);
    }

    private void m() {
        View view;
        c.a aVar;
        WeakReference<V> weakReference = this.f18618l;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            ac.c(view, 524288);
            ac.c(view, 262144);
            ac.c(view, (int) MemoryConstants.MB);
            int i2 = this.X;
            if (i2 != -1) {
                ac.c(view, i2);
            }
            int i3 = 6;
            if (!this.f18623q && this.f18614h != 6) {
                this.X = a(view, R.string.bottomsheet_action_expand_halfway, 6);
            }
            if (this.f18613g && this.f18614h != 5) {
                a(view, c.a.f34551u, 5);
            }
            int i4 = this.f18614h;
            if (i4 == 3) {
                if (this.f18623q) {
                    i3 = 4;
                }
                aVar = c.a.f34550t;
            } else if (i4 == 4) {
                if (this.f18623q) {
                    i3 = 3;
                }
                aVar = c.a.f34549s;
            } else if (i4 == 6) {
                a(view, c.a.f34550t, 4);
                a(view, c.a.f34549s, 3);
                return;
            } else {
                return;
            }
            a(view, aVar, i3);
        }
    }

    /* access modifiers changed from: package-private */
    public View a(View view) {
        if (ac.E(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View a2 = a(viewGroup.getChildAt(i2));
            if (a2 != null) {
                return a2;
            }
        }
        return null;
    }

    public void a() {
        super.a();
        this.f18618l = null;
        this.f18615i = null;
    }

    public void a(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.f18610d = f2;
        if (this.f18618l != null) {
            i();
        }
    }

    public void a(int i2) {
        this.f18632z = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.f18627u
            if (r4 != 0) goto L_0x0015
            r3.f18627u = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.f18627u
            if (r2 != 0) goto L_0x0017
            int r2 = r3.f18626t
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x001f
        L_0x0017:
            r3.f18627u = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f18626t = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.f((boolean) r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.f18611e;
        } else if (i2 == 6) {
            int i5 = this.f18609c;
            if (!this.f18623q || i5 > (i4 = this.f18608b)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = b();
        } else if (!this.f18613g || i2 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        } else {
            i3 = this.f18617k;
        }
        a(view, i2, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, int i3, boolean z2) {
        x.c cVar = this.f18615i;
        if (cVar != null && (!z2 ? cVar.a(view, view.getLeft(), i3) : cVar.a(view.getLeft(), i3))) {
            f(2);
            i(i2);
            if (this.K == null) {
                this.K = new b(view, i2);
            }
            if (!this.K.f18653d) {
                this.K.f18650a = i2;
                ac.a(view, (Runnable) this.K);
                boolean unused = this.K.f18653d = true;
                return;
            }
            this.K.f18650a = i2;
            return;
        }
        f(i2);
    }

    public void a(CoordinatorLayout.d dVar) {
        super.a(dVar);
        this.f18618l = null;
        this.f18615i = null;
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, v2, savedState.a());
        a(savedState);
        this.f18614h = (savedState.f18645a == 1 || savedState.f18645a == 2) ? 4 : savedState.f18645a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006b, code lost:
        if (java.lang.Math.abs(r3 - r2.f18608b) < java.lang.Math.abs(r3 - r2.f18611e)) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007a, code lost:
        if (r3 < java.lang.Math.abs(r3 - r2.f18611e)) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.f18611e)) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00a8, code lost:
        if (java.lang.Math.abs(r3 - r2.f18609c) < java.lang.Math.abs(r3 - r2.f18611e)) goto L_0x00aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.b()
            r0 = 3
            if (r3 != r6) goto L_0x000f
            r2.f((int) r0)
            return
        L_0x000f:
            java.lang.ref.WeakReference<android.view.View> r3 = r2.f18619m
            if (r3 == 0) goto L_0x00b3
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L_0x00b3
            boolean r3 = r2.R
            if (r3 != 0) goto L_0x001f
            goto L_0x00b3
        L_0x001f:
            int r3 = r2.Q
            r5 = 4
            r6 = 6
            if (r3 <= 0) goto L_0x003e
            boolean r3 = r2.f18623q
            if (r3 == 0) goto L_0x002d
        L_0x0029:
            int r3 = r2.f18608b
            goto L_0x00ad
        L_0x002d:
            int r3 = r4.getTop()
            int r5 = r2.f18609c
            if (r3 <= r5) goto L_0x0038
            r3 = r5
            goto L_0x00ac
        L_0x0038:
            int r3 = r2.b()
            goto L_0x00ad
        L_0x003e:
            boolean r3 = r2.f18613g
            if (r3 == 0) goto L_0x0050
            float r3 = r2.l()
            boolean r3 = r2.a((android.view.View) r4, (float) r3)
            if (r3 == 0) goto L_0x0050
            int r3 = r2.f18617k
            r0 = 5
            goto L_0x00ad
        L_0x0050:
            int r3 = r2.Q
            if (r3 != 0) goto L_0x008d
            int r3 = r4.getTop()
            boolean r1 = r2.f18623q
            if (r1 == 0) goto L_0x006e
            int r6 = r2.f18608b
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            int r1 = r2.f18611e
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r6 >= r3) goto L_0x0091
            goto L_0x0029
        L_0x006e:
            int r1 = r2.f18609c
            if (r3 >= r1) goto L_0x007d
            int r5 = r2.f18611e
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            if (r3 >= r5) goto L_0x00aa
            goto L_0x0038
        L_0x007d:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f18611e
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0091
            goto L_0x00aa
        L_0x008d:
            boolean r3 = r2.f18623q
            if (r3 == 0) goto L_0x0095
        L_0x0091:
            int r3 = r2.f18611e
            r0 = 4
            goto L_0x00ad
        L_0x0095:
            int r3 = r4.getTop()
            int r0 = r2.f18609c
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.f18611e
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0091
        L_0x00aa:
            int r3 = r2.f18609c
        L_0x00ac:
            r0 = 6
        L_0x00ad:
            r5 = 0
            r2.a((android.view.View) r4, (int) r0, (int) r3, (boolean) r5)
            r2.R = r5
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
    }

    public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
        int i5;
        if (i4 != 1) {
            WeakReference<View> weakReference = this.f18619m;
            if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                int top = v2.getTop();
                int i6 = top - i3;
                if (i3 <= 0) {
                    if (i3 < 0 && !view.canScrollVertically(-1)) {
                        int i7 = this.f18611e;
                        if (i6 > i7 && !this.f18613g) {
                            iArr[1] = top - i7;
                            ac.e((View) v2, -iArr[1]);
                            i5 = 4;
                        } else if (this.O) {
                            iArr[1] = i3;
                            ac.e((View) v2, -i3);
                            f(1);
                        } else {
                            return;
                        }
                    }
                    g(v2.getTop());
                    this.Q = i3;
                    this.R = true;
                } else if (i6 < b()) {
                    iArr[1] = top - b();
                    ac.e((View) v2, -iArr[1]);
                    i5 = 3;
                } else if (this.O) {
                    iArr[1] = i3;
                    ac.e((View) v2, -i3);
                    f(1);
                    g(v2.getTop());
                    this.Q = i3;
                    this.R = true;
                } else {
                    return;
                }
                f(i5);
                g(v2.getTop());
                this.Q = i3;
                this.R = true;
            }
        }
    }

    public void a(a aVar) {
        if (!this.T.contains(aVar)) {
            this.T.add(aVar);
        }
    }

    public void a(boolean z2) {
        if (this.f18623q != z2) {
            this.f18623q = z2;
            if (this.f18618l != null) {
                h();
            }
            f((!this.f18623q || this.f18614h != 6) ? this.f18614h : 3);
            m();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, float f2) {
        if (this.N) {
            return true;
        }
        if (view.getTop() < this.f18611e) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.f18611e)) / ((float) g()) > 0.5f;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, final V v2, int i2) {
        int i3;
        h hVar;
        if (ac.x(coordinatorLayout) && !ac.x(v2)) {
            v2.setFitsSystemWindows(true);
        }
        if (this.f18618l == null) {
            this.f18628v = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            c((View) v2);
            this.f18618l = new WeakReference<>(v2);
            if (this.f18630x && (hVar = this.f18631y) != null) {
                ac.a((View) v2, (Drawable) hVar);
            }
            h hVar2 = this.f18631y;
            if (hVar2 != null) {
                float f2 = this.f18612f;
                if (f2 == -1.0f) {
                    f2 = ac.s(v2);
                }
                hVar2.r(f2);
                boolean z2 = this.f18614h == 3;
                this.J = z2;
                this.f18631y.p(z2 ? 0.0f : 1.0f);
            }
            m();
            if (ac.f(v2) == 0) {
                ac.b((View) v2, 1);
            }
            int measuredWidth = v2.getMeasuredWidth();
            int i4 = this.f18632z;
            if (measuredWidth > i4 && i4 != -1) {
                final ViewGroup.LayoutParams layoutParams = v2.getLayoutParams();
                layoutParams.width = this.f18632z;
                v2.post(new Runnable() {
                    public void run() {
                        v2.setLayoutParams(layoutParams);
                    }
                });
            }
        }
        if (this.f18615i == null) {
            this.f18615i = x.c.a((ViewGroup) coordinatorLayout, this.Y);
        }
        int top = v2.getTop();
        coordinatorLayout.b((View) v2, i2);
        this.f18616j = coordinatorLayout.getWidth();
        this.f18617k = coordinatorLayout.getHeight();
        int height = v2.getHeight();
        this.S = height;
        int i5 = this.f18617k;
        int i6 = i5 - height;
        int i7 = this.H;
        if (i6 < i7) {
            if (this.F) {
                this.S = i5;
            } else {
                this.S = i5 - i7;
            }
        }
        this.f18608b = Math.max(0, i5 - this.S);
        i();
        h();
        int i8 = this.f18614h;
        if (i8 == 3) {
            i3 = b();
        } else if (i8 == 6) {
            i3 = this.f18609c;
        } else if (this.f18613g && i8 == 5) {
            i3 = this.f18617k;
        } else if (i8 == 4) {
            i3 = this.f18611e;
        } else {
            if (i8 == 1 || i8 == 2) {
                ac.e((View) v2, top - v2.getTop());
            }
            this.f18619m = new WeakReference<>(a((View) v2));
            return true;
        }
        ac.e((View) v2, i3);
        this.f18619m = new WeakReference<>(a((View) v2));
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            boolean r0 = r11.isShown()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00d2
            boolean r0 = r9.O
            if (r0 != 0) goto L_0x000e
            goto L_0x00d2
        L_0x000e:
            int r0 = r12.getActionMasked()
            if (r0 != 0) goto L_0x0017
            r9.j()
        L_0x0017:
            android.view.VelocityTracker r3 = r9.U
            if (r3 != 0) goto L_0x0021
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r9.U = r3
        L_0x0021:
            android.view.VelocityTracker r3 = r9.U
            r3.addMovement(r12)
            r3 = 0
            r4 = -1
            r5 = 2
            if (r0 == 0) goto L_0x003c
            if (r0 == r2) goto L_0x0031
            r11 = 3
            if (r0 == r11) goto L_0x0031
            goto L_0x007f
        L_0x0031:
            r9.f18621o = r1
            r9.f18620n = r4
            boolean r11 = r9.P
            if (r11 == 0) goto L_0x007f
            r9.P = r1
            return r1
        L_0x003c:
            float r6 = r12.getX()
            int r6 = (int) r6
            float r7 = r12.getY()
            int r7 = (int) r7
            r9.V = r7
            int r7 = r9.f18614h
            if (r7 == r5) goto L_0x006e
            java.lang.ref.WeakReference<android.view.View> r7 = r9.f18619m
            if (r7 == 0) goto L_0x0057
            java.lang.Object r7 = r7.get()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0058
        L_0x0057:
            r7 = r3
        L_0x0058:
            if (r7 == 0) goto L_0x006e
            int r8 = r9.V
            boolean r7 = r10.a((android.view.View) r7, (int) r6, (int) r8)
            if (r7 == 0) goto L_0x006e
            int r7 = r12.getActionIndex()
            int r7 = r12.getPointerId(r7)
            r9.f18620n = r7
            r9.f18621o = r2
        L_0x006e:
            int r7 = r9.f18620n
            if (r7 != r4) goto L_0x007c
            int r4 = r9.V
            boolean r11 = r10.a((android.view.View) r11, (int) r6, (int) r4)
            if (r11 != 0) goto L_0x007c
            r11 = 1
            goto L_0x007d
        L_0x007c:
            r11 = 0
        L_0x007d:
            r9.P = r11
        L_0x007f:
            boolean r11 = r9.P
            if (r11 != 0) goto L_0x008e
            x.c r11 = r9.f18615i
            if (r11 == 0) goto L_0x008e
            boolean r11 = r11.a((android.view.MotionEvent) r12)
            if (r11 == 0) goto L_0x008e
            return r2
        L_0x008e:
            java.lang.ref.WeakReference<android.view.View> r11 = r9.f18619m
            if (r11 == 0) goto L_0x0099
            java.lang.Object r11 = r11.get()
            r3 = r11
            android.view.View r3 = (android.view.View) r3
        L_0x0099:
            if (r0 != r5) goto L_0x00d1
            if (r3 == 0) goto L_0x00d1
            boolean r11 = r9.P
            if (r11 != 0) goto L_0x00d1
            int r11 = r9.f18614h
            if (r11 == r2) goto L_0x00d1
            float r11 = r12.getX()
            int r11 = (int) r11
            float r0 = r12.getY()
            int r0 = (int) r0
            boolean r10 = r10.a((android.view.View) r3, (int) r11, (int) r0)
            if (r10 != 0) goto L_0x00d1
            x.c r10 = r9.f18615i
            if (r10 == 0) goto L_0x00d1
            int r10 = r9.V
            float r10 = (float) r10
            float r11 = r12.getY()
            float r10 = r10 - r11
            float r10 = java.lang.Math.abs(r10)
            x.c r11 = r9.f18615i
            int r11 = r11.d()
            float r11 = (float) r11
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00d1
            r1 = 1
        L_0x00d1:
            return r1
        L_0x00d2:
            r9.P = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.f18619m;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.f18614h != 3 || super.a(coordinatorLayout, v2, view, f2, f3);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
        this.Q = 0;
        this.R = false;
        return (i2 & 2) != 0;
    }

    public int b() {
        if (this.f18623q) {
            return this.f18608b;
        }
        return Math.max(this.f18607a, this.F ? 0 : this.H);
    }

    public void b(int i2) {
        a(i2, false);
    }

    public void b(a aVar) {
        this.T.remove(aVar);
    }

    public void b(boolean z2) {
        if (this.f18613g != z2) {
            this.f18613g = z2;
            if (!z2 && this.f18614h == 5) {
                e(4);
            }
            m();
        }
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (!v2.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f18614h == 1 && actionMasked == 0) {
            return true;
        }
        x.c cVar = this.f18615i;
        if (cVar != null) {
            cVar.b(motionEvent);
        }
        if (actionMasked == 0) {
            j();
        }
        if (this.U == null) {
            this.U = VelocityTracker.obtain();
        }
        this.U.addMovement(motionEvent);
        if (this.f18615i != null && actionMasked == 2 && !this.P && Math.abs(((float) this.V) - motionEvent.getY()) > ((float) this.f18615i.d())) {
            this.f18615i.a((View) v2, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.P;
    }

    public void c(int i2) {
        if (i2 >= 0) {
            this.f18607a = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void c(boolean z2) {
        this.N = z2;
    }

    public boolean c() {
        return this.f18613g;
    }

    public Parcelable d(CoordinatorLayout coordinatorLayout, V v2) {
        return new SavedState(super.d(coordinatorLayout, v2), (BottomSheetBehavior<?>) this);
    }

    public void d(int i2) {
        this.f18622p = i2;
    }

    public void d(boolean z2) {
        this.O = z2;
    }

    public boolean d() {
        return this.B;
    }

    public int e() {
        return this.f18614h;
    }

    public void e(int i2) {
        if (i2 != this.f18614h) {
            if (this.f18618l != null) {
                h(i2);
            } else if (i2 == 4 || i2 == 3 || i2 == 6 || (this.f18613g && i2 == 5)) {
                this.f18614h = i2;
            }
        }
    }

    public void e(boolean z2) {
        this.B = z2;
    }

    /* access modifiers changed from: package-private */
    public h f() {
        return this.f18631y;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        View view;
        if (this.f18614h != i2) {
            this.f18614h = i2;
            WeakReference<V> weakReference = this.f18618l;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i2 == 3) {
                    g(true);
                } else if (i2 == 6 || i2 == 5 || i2 == 4) {
                    g(false);
                }
                i(i2);
                for (int i3 = 0; i3 < this.T.size(); i3++) {
                    this.T.get(i3).a(view, i2);
                }
                m();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        float f2;
        float f3;
        View view = (View) this.f18618l.get();
        if (view != null && !this.T.isEmpty()) {
            int i3 = this.f18611e;
            if (i2 > i3 || i3 == b()) {
                int i4 = this.f18611e;
                f2 = (float) (i4 - i2);
                f3 = (float) (this.f18617k - i4);
            } else {
                int i5 = this.f18611e;
                f2 = (float) (i5 - i2);
                f3 = (float) (i5 - b());
            }
            float f4 = f2 / f3;
            for (int i6 = 0; i6 < this.T.size(); i6++) {
                this.T.get(i6).a(view, f4);
            }
        }
    }
}
