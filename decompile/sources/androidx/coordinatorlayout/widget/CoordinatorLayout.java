package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import s.e;
import t.ac;
import t.ak;
import t.r;
import t.s;
import t.t;
import t.u;

public class CoordinatorLayout extends ViewGroup implements r, s {

    /* renamed from: a  reason: collision with root package name */
    static final String f2725a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f2726b = {Context.class, AttributeSet.class};

    /* renamed from: c  reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f2727c = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    static final Comparator<View> f2728d;

    /* renamed from: f  reason: collision with root package name */
    private static final e.a<Rect> f2729f = new e.c(12);

    /* renamed from: e  reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f2730e;

    /* renamed from: g  reason: collision with root package name */
    private final List<View> f2731g;

    /* renamed from: h  reason: collision with root package name */
    private final a<View> f2732h;

    /* renamed from: i  reason: collision with root package name */
    private final List<View> f2733i;

    /* renamed from: j  reason: collision with root package name */
    private final List<View> f2734j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f2735k;

    /* renamed from: l  reason: collision with root package name */
    private final int[] f2736l;

    /* renamed from: m  reason: collision with root package name */
    private final int[] f2737m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2738n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f2739o;

    /* renamed from: p  reason: collision with root package name */
    private int[] f2740p;

    /* renamed from: q  reason: collision with root package name */
    private View f2741q;

    /* renamed from: r  reason: collision with root package name */
    private View f2742r;

    /* renamed from: s  reason: collision with root package name */
    private e f2743s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2744t;

    /* renamed from: u  reason: collision with root package name */
    private ak f2745u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2746v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f2747w;

    /* renamed from: x  reason: collision with root package name */
    private u f2748x;

    /* renamed from: y  reason: collision with root package name */
    private final t f2749y;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public int a(CoordinatorLayout coordinatorLayout, V v2) {
            return -16777216;
        }

        public ak a(CoordinatorLayout coordinatorLayout, V v2, ak akVar) {
            return akVar;
        }

        public void a() {
        }

        public void a(d dVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, Parcelable parcelable) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2) {
            if (i2 == 0) {
                d(coordinatorLayout, v2, view);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                a(coordinatorLayout, v2, view, i2, i3, i4, i5);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            a(coordinatorLayout, v2, view, i2, i3, i4, i5, i6);
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v2, View view, int i2, int i3, int[] iArr, int i4) {
            if (i4 == 0) {
                a(coordinatorLayout, v2, view, i2, i3, iArr);
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, Rect rect, boolean z2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, float f2, float f3, boolean z2) {
            return false;
        }

        @Deprecated
        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                return a(coordinatorLayout, v2, view, view2, i2);
            }
            return false;
        }

        public float b(CoordinatorLayout coordinatorLayout, V v2) {
            return 0.0f;
        }

        @Deprecated
        public void b(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2) {
        }

        public void b(CoordinatorLayout coordinatorLayout, V v2, View view, View view2, int i2, int i3) {
            if (i3 == 0) {
                b(coordinatorLayout, v2, view, view2, i2);
            }
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v2, View view) {
            return false;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v2, View view) {
        }

        public boolean c(CoordinatorLayout coordinatorLayout, V v2) {
            return b(coordinatorLayout, v2) > 0.0f;
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v2) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v2, View view) {
        }
    }

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
        SparseArray<Parcelable> f2751a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.f2751a = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.f2751a.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.f2751a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.f2751a.keyAt(i3);
                parcelableArr[i3] = this.f2751a.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }
    }

    public interface a {
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        Class<? extends Behavior> a();
    }

    private class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.f2730e != null) {
                CoordinatorLayout.this.f2730e.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.a(2);
            if (CoordinatorLayout.this.f2730e != null) {
                CoordinatorLayout.this.f2730e.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        Behavior f2753a;

        /* renamed from: b  reason: collision with root package name */
        boolean f2754b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f2755c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f2756d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f2757e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f2758f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f2759g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f2760h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f2761i;

        /* renamed from: j  reason: collision with root package name */
        int f2762j;

        /* renamed from: k  reason: collision with root package name */
        View f2763k;

        /* renamed from: l  reason: collision with root package name */
        View f2764l;

        /* renamed from: m  reason: collision with root package name */
        final Rect f2765m = new Rect();

        /* renamed from: n  reason: collision with root package name */
        Object f2766n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f2767o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f2768p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f2769q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f2770r;

        public d(int i2, int i3) {
            super(i2, i3);
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f2755c = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2758f = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2756d = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2757e = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2759g = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2760h = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            this.f2754b = hasValue;
            if (hasValue) {
                this.f2753a = CoordinatorLayout.a(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f2753a;
            if (behavior != null) {
                behavior.a(this);
            }
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public d(d dVar) {
            super(dVar);
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f2758f);
            this.f2763k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f2764l = findViewById;
                    return;
                } else if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f2758f) + " to anchor view " + view);
            }
            this.f2764l = null;
            this.f2763k = null;
        }

        private boolean a(View view, int i2) {
            int a2 = t.f.a(((d) view.getLayoutParams()).f2759g, i2);
            return a2 != 0 && (t.f.a(this.f2760h, i2) & a2) == a2;
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f2763k.getId() != this.f2758f) {
                return false;
            }
            View view2 = this.f2763k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f2764l = null;
                    this.f2763k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f2764l = view2;
            return true;
        }

        public int a() {
            return this.f2758f;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            a(i2, false);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, boolean z2) {
            if (i2 == 0) {
                this.f2768p = z2;
            } else if (i2 == 1) {
                this.f2769q = z2;
            }
        }

        /* access modifiers changed from: package-private */
        public void a(Rect rect) {
            this.f2765m.set(rect);
        }

        public void a(Behavior behavior) {
            Behavior behavior2 = this.f2753a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.a();
                }
                this.f2753a = behavior;
                this.f2766n = null;
                this.f2754b = true;
                if (behavior != null) {
                    behavior.a(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z2) {
            this.f2770r = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean a(CoordinatorLayout coordinatorLayout, View view) {
            boolean z2 = this.f2767o;
            if (z2) {
                return true;
            }
            Behavior behavior = this.f2753a;
            boolean c2 = (behavior != null ? behavior.c(coordinatorLayout, view) : false) | z2;
            this.f2767o = c2;
            return c2;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = r1.f2753a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4) {
            /*
                r1 = this;
                android.view.View r0 = r1.f2764l
                if (r4 == r0) goto L_0x001b
                int r0 = t.ac.i(r2)
                boolean r0 = r1.a((android.view.View) r4, (int) r0)
                if (r0 != 0) goto L_0x001b
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f2753a
                if (r0 == 0) goto L_0x0019
                boolean r2 = r0.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r2, r3, (android.view.View) r4)
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.d.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):boolean");
        }

        /* access modifiers changed from: package-private */
        public View b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f2758f == -1) {
                this.f2764l = null;
                this.f2763k = null;
                return null;
            }
            if (this.f2763k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.f2763k;
        }

        public Behavior b() {
            return this.f2753a;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2) {
            if (i2 == 0) {
                return this.f2768p;
            }
            if (i2 != 1) {
                return false;
            }
            return this.f2769q;
        }

        /* access modifiers changed from: package-private */
        public Rect c() {
            return this.f2765m;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f2763k == null && this.f2758f != -1;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.f2753a == null) {
                this.f2767o = false;
            }
            return this.f2767o;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f2767o = false;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.f2770r;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.f2770r = false;
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.a(0);
            return true;
        }
    }

    static class f implements Comparator<View> {
        f() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float H = ac.H(view);
            float H2 = ac.H(view2);
            if (H > H2) {
                return -1;
            }
            return H < H2 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.String r0 = r0.getName()
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            f2725a = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 21
            if (r0 < r2) goto L_0x001f
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$f
            r0.<init>()
            f2728d = r0
            goto L_0x0021
        L_0x001f:
            f2728d = r1
        L_0x0021:
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<android.util.AttributeSet> r2 = android.util.AttributeSet.class
            r0[r1] = r2
            f2726b = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            f2727c = r0
            s.e$c r0 = new s.e$c
            r1 = 12
            r0.<init>(r1)
            f2729f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2731g = new ArrayList();
        this.f2732h = new a<>();
        this.f2733i = new ArrayList();
        this.f2734j = new ArrayList();
        this.f2736l = new int[2];
        this.f2737m = new int[2];
        this.f2749y = new t(this);
        int[] iArr = R.styleable.CoordinatorLayout;
        TypedArray obtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R.style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = R.styleable.CoordinatorLayout;
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f2740p = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f2740p.length;
            for (int i3 = 0; i3 < length; i3++) {
                int[] iArr3 = this.f2740p;
                iArr3[i3] = (int) (((float) iArr3[i3]) * f2);
            }
        }
        this.f2747w = obtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        g();
        super.setOnHierarchyChangeListener(new c());
        if (ac.f(this) == 0) {
            ac.b((View) this, 1);
        }
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f2725a;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = f2727c;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f2726b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private static void a(Rect rect) {
        rect.setEmpty();
        f2729f.a(rect);
    }

    private void a(View view, int i2, Rect rect, Rect rect2, d dVar, int i3, int i4) {
        int a2 = t.f.a(e(dVar.f2755c), i2);
        int a3 = t.f.a(c(dVar.f2756d), i2);
        int i5 = a2 & 7;
        int i6 = a2 & 112;
        int i7 = a3 & 7;
        int i8 = a3 & 112;
        int width = i7 != 1 ? i7 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i8 != 16 ? i8 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i5 == 1) {
            width -= i3 / 2;
        } else if (i5 != 5) {
            width -= i3;
        }
        if (i6 == 16) {
            height -= i4 / 2;
        } else if (i6 != 80) {
            height -= i4;
        }
        rect2.set(width, height, i3 + width, i4 + height);
    }

    private void a(View view, Rect rect, int i2) {
        boolean z2;
        boolean z3;
        int width;
        int i3;
        int height;
        int i4;
        if (ac.G(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            d dVar = (d) view.getLayoutParams();
            Behavior b2 = dVar.b();
            Rect e2 = e();
            Rect e3 = e();
            e3.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (b2 == null || !b2.a(this, view, e2)) {
                e2.set(e3);
            } else if (!e3.contains(e2)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e2.toShortString() + " | Bounds:" + e3.toShortString());
            }
            a(e3);
            if (e2.isEmpty()) {
                a(e2);
                return;
            }
            int a2 = t.f.a(dVar.f2760h, i2);
            boolean z4 = true;
            if ((a2 & 48) != 48 || (i4 = (e2.top - dVar.topMargin) - dVar.f2762j) >= rect.top) {
                z2 = false;
            } else {
                f(view, rect.top - i4);
                z2 = true;
            }
            if ((a2 & 80) == 80 && (height = ((getHeight() - e2.bottom) - dVar.bottomMargin) + dVar.f2762j) < rect.bottom) {
                f(view, height - rect.bottom);
                z2 = true;
            }
            if (!z2) {
                f(view, 0);
            }
            if ((a2 & 3) != 3 || (i3 = (e2.left - dVar.leftMargin) - dVar.f2761i) >= rect.left) {
                z3 = false;
            } else {
                e(view, rect.left - i3);
                z3 = true;
            }
            if ((a2 & 5) != 5 || (width = ((getWidth() - e2.right) - dVar.rightMargin) + dVar.f2761i) >= rect.right) {
                z4 = z3;
            } else {
                e(view, width - rect.right);
            }
            if (!z4) {
                e(view, 0);
            }
            a(e2);
        }
    }

    private void a(View view, View view2, int i2) {
        Rect e2 = e();
        Rect e3 = e();
        try {
            a(view2, e2);
            a(view, i2, e2, e3);
            view.layout(e3.left, e3.top, e3.right, e3.bottom);
        } finally {
            a(e2);
            a(e3);
        }
    }

    private void a(d dVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - dVar.bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = f2728d;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private void a(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Behavior b2 = ((d) childAt.getLayoutParams()).b();
            if (b2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    b2.a(this, childAt, obtain);
                } else {
                    b2.b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((d) getChildAt(i3).getLayoutParams()).f();
        }
        this.f2741q = null;
        this.f2738n = false;
    }

    private boolean a(MotionEvent motionEvent, int i2) {
        MotionEvent motionEvent2 = motionEvent;
        int i3 = i2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f2733i;
        a(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z2 = false;
        boolean z3 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            d dVar = (d) view.getLayoutParams();
            Behavior b2 = dVar.b();
            if ((!z2 && !z3) || actionMasked == 0) {
                if (!z2 && b2 != null) {
                    if (i3 == 0) {
                        z2 = b2.a(this, view, motionEvent2);
                    } else if (i3 == 1) {
                        z2 = b2.b(this, view, motionEvent2);
                    }
                    if (z2) {
                        this.f2741q = view;
                    }
                }
                boolean e2 = dVar.e();
                boolean a2 = dVar.a(this, view);
                z3 = a2 && !e2;
                if (a2 && !z3) {
                    break;
                }
            } else if (b2 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i3 == 0) {
                    b2.a(this, view, motionEvent3);
                } else if (i3 == 1) {
                    b2.b(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z2;
    }

    private int b(int i2) {
        StringBuilder sb;
        int[] iArr = this.f2740p;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i2);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    private ak b(ak akVar) {
        Behavior b2;
        if (akVar.f()) {
            return akVar;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (ac.x(childAt) && (b2 = ((d) childAt.getLayoutParams()).b()) != null) {
                akVar = b2.a(this, childAt, akVar);
                if (akVar.f()) {
                    break;
                }
            }
        }
        return akVar;
    }

    private void b(View view, int i2, int i3) {
        d dVar = (d) view.getLayoutParams();
        int a2 = t.f.a(d(dVar.f2755c), i3);
        int i4 = a2 & 7;
        int i5 = a2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i3 == 1) {
            i2 = width - i2;
        }
        int b2 = b(i2) - measuredWidth;
        int i6 = 0;
        if (i4 == 1) {
            b2 += measuredWidth / 2;
        } else if (i4 == 5) {
            b2 += measuredWidth;
        }
        if (i5 == 16) {
            i6 = 0 + (measuredHeight / 2);
        } else if (i5 == 80) {
            i6 = measuredHeight + 0;
        }
        int max = Math.max(getPaddingLeft() + dVar.leftMargin, Math.min(b2, ((width - getPaddingRight()) - measuredWidth) - dVar.rightMargin));
        int max2 = Math.max(getPaddingTop() + dVar.topMargin, Math.min(i6, ((height - getPaddingBottom()) - measuredHeight) - dVar.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private static int c(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= 8388611;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int d(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void d(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        Rect e2 = e();
        e2.set(getPaddingLeft() + dVar.leftMargin, getPaddingTop() + dVar.topMargin, (getWidth() - getPaddingRight()) - dVar.rightMargin, (getHeight() - getPaddingBottom()) - dVar.bottomMargin);
        if (this.f2745u != null && ac.x(this) && !ac.x(view)) {
            e2.left += this.f2745u.a();
            e2.top += this.f2745u.b();
            e2.right -= this.f2745u.c();
            e2.bottom -= this.f2745u.d();
        }
        Rect e3 = e();
        t.f.a(c(dVar.f2755c), view.getMeasuredWidth(), view.getMeasuredHeight(), e2, e3, i2);
        view.layout(e3.left, e3.top, e3.right, e3.bottom);
        a(e2);
        a(e3);
    }

    private static int e(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static Rect e() {
        Rect a2 = f2729f.a();
        return a2 == null ? new Rect() : a2;
    }

    private void e(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.f2761i != i2) {
            ac.f(view, i2 - dVar.f2761i);
            dVar.f2761i = i2;
        }
    }

    private boolean e(View view) {
        return this.f2732h.e(view);
    }

    private void f() {
        this.f2731g.clear();
        this.f2732h.a();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d a2 = a(childAt);
            a2.b(this, childAt);
            this.f2732h.a(childAt);
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i3 != i2) {
                    View childAt2 = getChildAt(i3);
                    if (a2.a(this, childAt, childAt2)) {
                        if (!this.f2732h.b(childAt2)) {
                            this.f2732h.a(childAt2);
                        }
                        this.f2732h.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f2731g.addAll(this.f2732h.b());
        Collections.reverse(this.f2731g);
    }

    private void f(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.f2762j != i2) {
            ac.e(view, i2 - dVar.f2762j);
            dVar.f2762j = i2;
        }
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (ac.x(this)) {
                if (this.f2748x == null) {
                    this.f2748x = new u() {
                        public ak a(View view, ak akVar) {
                            return CoordinatorLayout.this.a(akVar);
                        }
                    };
                }
                ac.a((View) this, this.f2748x);
                setSystemUiVisibility(1280);
                return;
            }
            ac.a((View) this, (u) null);
        }
    }

    /* renamed from: a */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    public d a(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.f2754b) {
            if (view instanceof a) {
                Behavior behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                dVar.a(behavior);
            } else {
                b bVar = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    bVar = (b) cls.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                if (bVar != null) {
                    try {
                        dVar.a((Behavior) bVar.a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e("CoordinatorLayout", "Default behavior class " + bVar.a().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
            }
            dVar.f2754b = true;
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d ? new d((d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public final ak a(ak akVar) {
        if (s.c.a((Object) this.f2745u, (Object) akVar)) {
            return akVar;
        }
        this.f2745u = akVar;
        boolean z2 = true;
        boolean z3 = akVar != null && akVar.b() > 0;
        this.f2746v = z3;
        if (z3 || getBackground() != null) {
            z2 = false;
        }
        setWillNotDraw(z2);
        ak b2 = b(akVar);
        requestLayout();
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        boolean z2;
        int i3 = i2;
        int i4 = ac.i(this);
        int size = this.f2731g.size();
        Rect e2 = e();
        Rect e3 = e();
        Rect e4 = e();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f2731g.get(i5);
            d dVar = (d) view.getLayoutParams();
            if (i3 != 0 || view.getVisibility() != 8) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (dVar.f2764l == this.f2731g.get(i6)) {
                        c(view, i4);
                    }
                }
                a(view, true, e3);
                if (dVar.f2759g != 0 && !e3.isEmpty()) {
                    int a2 = t.f.a(dVar.f2759g, i4);
                    int i7 = a2 & 112;
                    if (i7 == 48) {
                        e2.top = Math.max(e2.top, e3.bottom);
                    } else if (i7 == 80) {
                        e2.bottom = Math.max(e2.bottom, getHeight() - e3.top);
                    }
                    int i8 = a2 & 7;
                    if (i8 == 3) {
                        e2.left = Math.max(e2.left, e3.right);
                    } else if (i8 == 5) {
                        e2.right = Math.max(e2.right, getWidth() - e3.left);
                    }
                }
                if (dVar.f2760h != 0 && view.getVisibility() == 0) {
                    a(view, e2, i4);
                }
                if (i3 != 2) {
                    c(view, e4);
                    if (!e4.equals(e3)) {
                        b(view, e3);
                    }
                }
                for (int i9 = i5 + 1; i9 < size; i9++) {
                    View view2 = this.f2731g.get(i9);
                    d dVar2 = (d) view2.getLayoutParams();
                    Behavior b2 = dVar2.b();
                    if (b2 != null && b2.a(this, view2, view)) {
                        if (i3 != 0 || !dVar2.g()) {
                            if (i3 != 2) {
                                z2 = b2.b(this, view2, view);
                            } else {
                                b2.c(this, view2, view);
                                z2 = true;
                            }
                            if (i3 == 1) {
                                dVar2.a(z2);
                            }
                        } else {
                            dVar2.h();
                        }
                    }
                }
            }
        }
        a(e2);
        a(e3);
        a(e4);
    }

    public void a(View view, int i2) {
        this.f2749y.a(view, i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.b(i2)) {
                Behavior b2 = dVar.b();
                if (b2 != null) {
                    b2.a(this, childAt, view, i2);
                }
                dVar.a(i2);
                dVar.h();
            }
        }
        this.f2742r = null;
    }

    public void a(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        a(view, i2, i3, i4, i5, 0, this.f2737m);
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        Behavior b2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(i6) && (b2 = dVar.b()) != null) {
                    int[] iArr2 = this.f2736l;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    b2.a(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.f2736l;
                    i7 = i4 > 0 ? Math.max(i7, iArr3[0]) : Math.min(i7, iArr3[0]);
                    i8 = i5 > 0 ? Math.max(i8, this.f2736l[1]) : Math.min(i8, this.f2736l[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (z2) {
            a(1);
        }
    }

    public void a(View view, int i2, int i3, int[] iArr, int i4) {
        Behavior b2;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                int i8 = i4;
            } else {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(i4) && (b2 = dVar.b()) != null) {
                    int[] iArr2 = this.f2736l;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    b2.a(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.f2736l;
                    i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.f2736l;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            a(1);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i2, rect, rect2, dVar, measuredWidth, measuredHeight);
        a(dVar, rect2, measuredWidth, measuredHeight);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, Rect rect) {
        b.b(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean a(View view, int i2, int i3) {
        Rect e2 = e();
        a(view, e2);
        try {
            return e2.contains(i2, i3);
        } finally {
            a(e2);
        }
    }

    public boolean a(View view, View view2, int i2, int i3) {
        int i4 = i3;
        int childCount = getChildCount();
        int i5 = 0;
        boolean z2 = false;
        while (true) {
            if (i5 >= childCount) {
                return z2;
            }
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior b2 = dVar.b();
                if (b2 != null) {
                    boolean a2 = b2.a(this, childAt, view, view2, i2, i3);
                    z2 |= a2;
                    dVar.a(i4, a2);
                } else {
                    dVar.a(i4, false);
                }
            }
            i5++;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f2739o) {
            if (this.f2743s == null) {
                this.f2743s = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2743s);
        }
        this.f2744t = true;
    }

    public void b(View view) {
        List c2 = this.f2732h.c(view);
        if (c2 != null && !c2.isEmpty()) {
            for (int i2 = 0; i2 < c2.size(); i2++) {
                View view2 = (View) c2.get(i2);
                Behavior b2 = ((d) view2.getLayoutParams()).b();
                if (b2 != null) {
                    b2.b(this, view2, view);
                }
            }
        }
    }

    public void b(View view, int i2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (dVar.f2763k != null) {
            a(view, dVar.f2763k, i2);
        } else if (dVar.f2757e >= 0) {
            b(view, dVar.f2757e, i2);
        } else {
            d(view, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view, Rect rect) {
        ((d) view.getLayoutParams()).a(rect);
    }

    public void b(View view, View view2, int i2, int i3) {
        Behavior b2;
        this.f2749y.a(view, view2, i2, i3);
        this.f2742r = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.b(i3) && (b2 = dVar.b()) != null) {
                b2.b(this, childAt, view, view2, i2, i3);
            }
        }
    }

    public List<View> c(View view) {
        List<View> d2 = this.f2732h.d(view);
        this.f2734j.clear();
        if (d2 != null) {
            this.f2734j.addAll(d2);
        }
        return this.f2734j;
    }

    /* access modifiers changed from: package-private */
    public void c(View view, int i2) {
        Behavior b2;
        View view2 = view;
        d dVar = (d) view.getLayoutParams();
        if (dVar.f2763k != null) {
            Rect e2 = e();
            Rect e3 = e();
            Rect e4 = e();
            a(dVar.f2763k, e2);
            boolean z2 = false;
            a(view2, false, e3);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i3 = measuredHeight;
            a(view, i2, e2, e4, dVar, measuredWidth, measuredHeight);
            if (!(e4.left == e3.left && e4.top == e3.top)) {
                z2 = true;
            }
            a(dVar, e4, measuredWidth, i3);
            int i4 = e4.left - e3.left;
            int i5 = e4.top - e3.top;
            if (i4 != 0) {
                ac.f(view2, i4);
            }
            if (i5 != 0) {
                ac.e(view2, i5);
            }
            if (z2 && (b2 = dVar.b()) != null) {
                b2.b(this, view2, dVar.f2763k);
            }
            a(e2);
            a(e3);
            a(e4);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(View view, Rect rect) {
        rect.set(((d) view.getLayoutParams()).c());
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public d generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    public List<View> d(View view) {
        List c2 = this.f2732h.c(view);
        this.f2734j.clear();
        if (c2 != null) {
            this.f2734j.addAll(c2);
        }
        return this.f2734j;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.f2753a != null) {
            float b2 = dVar.f2753a.b(this, view);
            if (b2 > 0.0f) {
                if (this.f2735k == null) {
                    this.f2735k = new Paint();
                }
                this.f2735k.setColor(dVar.f2753a.a(this, view));
                this.f2735k.setAlpha(a(Math.round(b2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.f2735k);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2747w;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public final List<View> getDependencySortedChildren() {
        f();
        return Collections.unmodifiableList(this.f2731g);
    }

    public final ak getLastWindowInsets() {
        return this.f2745u;
    }

    public int getNestedScrollAxes() {
        return this.f2749y.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f2747w;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.f2744t) {
            if (this.f2743s == null) {
                this.f2743s = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f2743s);
        }
        if (this.f2745u == null && ac.x(this)) {
            ac.w(this);
        }
        this.f2739o = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.f2744t && this.f2743s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2743s);
        }
        View view = this.f2742r;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f2739o = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2746v && this.f2747w != null) {
            ak akVar = this.f2745u;
            int b2 = akVar != null ? akVar.b() : 0;
            if (b2 > 0) {
                this.f2747w.setBounds(0, 0, getWidth(), b2);
                this.f2747w.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a2 = a(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        Behavior b2;
        int i6 = ac.i(this);
        int size = this.f2731g.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.f2731g.get(i7);
            if (view.getVisibility() != 8 && ((b2 = ((d) view.getLayoutParams()).b()) == null || !b2.a(this, view, i6))) {
                b(view, i6);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011c, code lost:
        if (r0.a(r30, r20, r11, r21, r23, 0) == false) goto L_0x012c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.f()
            r30.r_()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = t.ac.i(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = 1
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            t.ak r3 = r7.f2745u
            if (r3 == 0) goto L_0x004b
            boolean r3 = t.ac.x(r30)
            if (r3 == 0) goto L_0x004b
            r19 = 1
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.f2731g
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x0171
            java.util.List<android.view.View> r0 = r7.f2731g
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0169
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r1
            int r0 = r1.f2757e
            if (r0 < 0) goto L_0x00bc
            if (r13 == 0) goto L_0x00bc
            int r0 = r1.f2757e
            int r0 = r7.b((int) r0)
            int r11 = r1.f2755c
            int r11 = d((int) r11)
            int r11 = t.f.a(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0099
            if (r12 == 0) goto L_0x009e
        L_0x0099:
            r2 = 5
            if (r11 != r2) goto L_0x00aa
            if (r12 == 0) goto L_0x00aa
        L_0x009e:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r11 = 0
            goto L_0x00c1
        L_0x00aa:
            if (r11 != r2) goto L_0x00ae
            if (r12 == 0) goto L_0x00b3
        L_0x00ae:
            r2 = 3
            if (r11 != r2) goto L_0x00be
            if (r12 == 0) goto L_0x00be
        L_0x00b3:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00c1
        L_0x00bc:
            r22 = r2
        L_0x00be:
            r11 = 0
            r21 = 0
        L_0x00c1:
            if (r19 == 0) goto L_0x00f3
            boolean r0 = t.ac.x(r20)
            if (r0 != 0) goto L_0x00f3
            t.ak r0 = r7.f2745u
            int r0 = r0.a()
            t.ak r2 = r7.f2745u
            int r2 = r2.c()
            int r0 = r0 + r2
            t.ak r2 = r7.f2745u
            int r2 = r2.b()
            t.ak r11 = r7.f2745u
            int r11 = r11.d()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f7
        L_0x00f3:
            r11 = r31
            r23 = r32
        L_0x00f7:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.b()
            if (r0 == 0) goto L_0x011f
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.a((androidx.coordinatorlayout.widget.CoordinatorLayout) r1, r2, (int) r3, (int) r4, (int) r5, (int) r6)
            if (r0 != 0) goto L_0x0139
            goto L_0x012c
        L_0x011f:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012c:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.a((android.view.View) r1, (int) r2, (int) r3, (int) r4, (int) r5)
        L_0x0139:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0169:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x0171:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        Behavior b2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(0) && (b2 = dVar.b()) != null) {
                    z3 |= b2.a(this, childAt, view, f2, f3, z2);
                }
            }
        }
        if (z3) {
            a(1);
        }
        return z3;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior b2;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.b(0) && (b2 = dVar.b()) != null) {
                    z2 |= b2.a(this, childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        a(view, i2, i3, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        a(view, i2, i3, i4, i5, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        b(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.f2751a;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id2 = childAt.getId();
            Behavior b2 = a(childAt).b();
            if (!(id2 == -1 || b2 == null || (parcelable2 = sparseArray.get(id2)) == null)) {
                b2.a(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable d2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id2 = childAt.getId();
            Behavior b2 = ((d) childAt.getLayoutParams()).b();
            if (!(id2 == -1 || b2 == null || (d2 = b2.d(this, childAt)) == null)) {
                sparseArray.append(id2, d2);
            }
        }
        savedState.f2751a = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return a(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        a(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0016;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f2741q
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0015
            boolean r3 = r0.a((android.view.MotionEvent) r1, (int) r4)
            if (r3 == 0) goto L_0x002b
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            android.view.View r6 = r0.f2741q
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.b()
            if (r6 == 0) goto L_0x002b
            android.view.View r7 = r0.f2741q
            boolean r6 = r6.b((androidx.coordinatorlayout.widget.CoordinatorLayout) r0, r7, (android.view.MotionEvent) r1)
            goto L_0x002c
        L_0x002b:
            r6 = 0
        L_0x002c:
            android.view.View r7 = r0.f2741q
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.a((boolean) r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void r_() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (e(getChildAt(i2))) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        if (z2 == this.f2744t) {
            return;
        }
        if (z2) {
            b();
        } else {
            s_();
        }
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        Behavior b2 = ((d) view.getLayoutParams()).b();
        if (b2 == null || !b2.a(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (z2 && !this.f2738n) {
            a(false);
            this.f2738n = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void s_() {
        if (this.f2739o && this.f2743s != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f2743s);
        }
        this.f2744t = false;
    }

    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        g();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2730e = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f2747w;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f2747w = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f2747w.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.b(this.f2747w, ac.i(this));
                this.f2747w.setVisible(getVisibility() == 0, false);
                this.f2747w.setCallback(this);
            }
            ac.e(this);
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? androidx.core.content.b.a(getContext(), i2) : null);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.f2747w;
        if (drawable != null && drawable.isVisible() != z2) {
            this.f2747w.setVisible(z2, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2747w;
    }
}
