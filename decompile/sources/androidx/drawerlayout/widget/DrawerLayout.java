package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import com.blankj.utilcode.constant.MemoryConstants;
import java.util.ArrayList;
import java.util.List;
import t.ac;
import t.f;
import u.c;
import x.c;

public class DrawerLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f3090a = {16842931};

    /* renamed from: b  reason: collision with root package name */
    static final boolean f3091b = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f3092c = {16843828};

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f3093d;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private CharSequence E;
    private CharSequence F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<View> M;
    private Rect N;
    private Matrix O;

    /* renamed from: e  reason: collision with root package name */
    private final b f3094e;

    /* renamed from: f  reason: collision with root package name */
    private float f3095f;

    /* renamed from: g  reason: collision with root package name */
    private int f3096g;

    /* renamed from: h  reason: collision with root package name */
    private int f3097h;

    /* renamed from: i  reason: collision with root package name */
    private float f3098i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f3099j;

    /* renamed from: k  reason: collision with root package name */
    private final x.c f3100k;

    /* renamed from: l  reason: collision with root package name */
    private final x.c f3101l;

    /* renamed from: m  reason: collision with root package name */
    private final d f3102m;

    /* renamed from: n  reason: collision with root package name */
    private final d f3103n;

    /* renamed from: o  reason: collision with root package name */
    private int f3104o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3105p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3106q;

    /* renamed from: r  reason: collision with root package name */
    private int f3107r;

    /* renamed from: s  reason: collision with root package name */
    private int f3108s;

    /* renamed from: t  reason: collision with root package name */
    private int f3109t;

    /* renamed from: u  reason: collision with root package name */
    private int f3110u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f3111v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f3112w;

    /* renamed from: x  reason: collision with root package name */
    private c f3113x;

    /* renamed from: y  reason: collision with root package name */
    private List<c> f3114y;

    /* renamed from: z  reason: collision with root package name */
    private float f3115z;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f3117a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f3118b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3119c;

        /* renamed from: d  reason: collision with root package name */
        int f3120d;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f3090a);
            this.f3117a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3117a = layoutParams.f3117a;
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
        int f3121a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f3122b;

        /* renamed from: d  reason: collision with root package name */
        int f3123d;

        /* renamed from: e  reason: collision with root package name */
        int f3124e;

        /* renamed from: f  reason: collision with root package name */
        int f3125f;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3121a = parcel.readInt();
            this.f3122b = parcel.readInt();
            this.f3123d = parcel.readInt();
            this.f3124e = parcel.readInt();
            this.f3125f = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f3121a);
            parcel.writeInt(this.f3122b);
            parcel.writeInt(this.f3123d);
            parcel.writeInt(this.f3124e);
            parcel.writeInt(this.f3125f);
        }
    }

    class a extends t.a {

        /* renamed from: b  reason: collision with root package name */
        private final Rect f3127b = new Rect();

        a() {
        }

        private void a(u.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.l(childAt)) {
                    cVar.c(childAt);
                }
            }
        }

        private void a(u.c cVar, u.c cVar2) {
            Rect rect = this.f3127b;
            cVar2.a(rect);
            cVar.b(rect);
            cVar2.c(rect);
            cVar.d(rect);
            cVar.e(cVar2.j());
            cVar.a(cVar2.r());
            cVar.b(cVar2.s());
            cVar.e(cVar2.u());
            cVar.j(cVar2.o());
            cVar.h(cVar2.m());
            cVar.c(cVar2.h());
            cVar.d(cVar2.i());
            cVar.f(cVar2.k());
            cVar.g(cVar2.l());
            cVar.i(cVar2.n());
            cVar.a(cVar2.d());
        }

        public void a(View view, u.c cVar) {
            if (DrawerLayout.f3091b) {
                super.a(view, cVar);
            } else {
                u.c a2 = u.c.a(cVar);
                super.a(view, a2);
                cVar.b(view);
                ViewParent j2 = ac.j(view);
                if (j2 instanceof View) {
                    cVar.d((View) j2);
                }
                a(cVar, a2);
                a2.v();
                a(cVar, (ViewGroup) view);
            }
            cVar.b((CharSequence) DrawerLayout.class.getName());
            cVar.c(false);
            cVar.d(false);
            cVar.b(c.a.f34531a);
            cVar.b(c.a.f34532b);
        }

        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f3091b || DrawerLayout.l(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        public boolean b(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence b2;
            if (accessibilityEvent.getEventType() != 32) {
                return super.b(view, accessibilityEvent);
            }
            List text = accessibilityEvent.getText();
            View c2 = DrawerLayout.this.c();
            if (c2 == null || (b2 = DrawerLayout.this.b(DrawerLayout.this.e(c2))) == null) {
                return true;
            }
            text.add(b2);
            return true;
        }

        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }
    }

    static final class b extends t.a {
        b() {
        }

        public void a(View view, u.c cVar) {
            super.a(view, cVar);
            if (!DrawerLayout.l(view)) {
                cVar.d((View) null);
            }
        }
    }

    public interface c {
        void a(int i2);

        void a(View view);

        void a(View view, float f2);

        void b(View view);
    }

    private class d extends c.a {

        /* renamed from: b  reason: collision with root package name */
        private final int f3129b;

        /* renamed from: c  reason: collision with root package name */
        private x.c f3130c;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f3131d = new Runnable() {
            public void run() {
                d.this.b();
            }
        };

        d(int i2) {
            this.f3129b = i2;
        }

        private void c() {
            int i2 = 3;
            if (this.f3129b == 3) {
                i2 = 5;
            }
            View c2 = DrawerLayout.this.c(i2);
            if (c2 != null) {
                DrawerLayout.this.i(c2);
            }
        }

        public int a(View view) {
            if (DrawerLayout.this.g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public int a(View view, int i2, int i3) {
            int width;
            int width2;
            if (DrawerLayout.this.a(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i2, width));
        }

        public void a() {
            DrawerLayout.this.removeCallbacks(this.f3131d);
        }

        public void a(int i2) {
            DrawerLayout.this.a(this.f3129b, i2, this.f3130c.c());
        }

        public void a(int i2, int i3) {
            DrawerLayout.this.postDelayed(this.f3131d, 160);
        }

        public void a(View view, float f2, float f3) {
            int i2;
            float d2 = DrawerLayout.this.d(view);
            int width = view.getWidth();
            if (DrawerLayout.this.a(view, 3)) {
                i2 = (f2 > 0.0f || (f2 == 0.0f && d2 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && d2 > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f3130c.a(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public void a(View view, int i2) {
            ((LayoutParams) view.getLayoutParams()).f3119c = false;
            c();
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.a(view, 3) ? (float) (i2 + width) : (float) (DrawerLayout.this.getWidth() - i2)) / ((float) width);
            DrawerLayout.this.b(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void a(x.c cVar) {
            this.f3130c = cVar;
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            View view;
            int i2;
            int b2 = this.f3130c.b();
            int i3 = 0;
            boolean z2 = this.f3129b == 3;
            if (z2) {
                view = DrawerLayout.this.c(3);
                if (view != null) {
                    i3 = -view.getWidth();
                }
                i2 = i3 + b2;
            } else {
                view = DrawerLayout.this.c(5);
                i2 = DrawerLayout.this.getWidth() - b2;
            }
            if (view == null) {
                return;
            }
            if (((z2 && view.getLeft() < i2) || (!z2 && view.getLeft() > i2)) && DrawerLayout.this.a(view) == 0) {
                this.f3130c.a(view, i2, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f3119c = true;
                DrawerLayout.this.invalidate();
                c();
                DrawerLayout.this.d();
            }
        }

        public void b(int i2, int i3) {
            DrawerLayout drawerLayout;
            int i4;
            if ((i2 & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i4 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i4 = 5;
            }
            View c2 = drawerLayout.c(i4);
            if (c2 != null && DrawerLayout.this.a(c2) == 0) {
                this.f3130c.a(c2, i3);
            }
        }

        public boolean b(int i2) {
            return false;
        }

        public boolean b(View view, int i2) {
            return DrawerLayout.this.g(view) && DrawerLayout.this.a(view, this.f3129b) && DrawerLayout.this.a(view) == 0;
        }
    }

    static {
        boolean z2 = true;
        if (Build.VERSION.SDK_INT < 21) {
            z2 = false;
        }
        f3093d = z2;
    }

    public DrawerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f3094e = new b();
        this.f3097h = -1728053248;
        this.f3099j = new Paint();
        this.f3106q = true;
        this.f3107r = 3;
        this.f3108s = 3;
        this.f3109t = 3;
        this.f3110u = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f3096g = (int) ((64.0f * f2) + 0.5f);
        float f3 = 400.0f * f2;
        d dVar = new d(3);
        this.f3102m = dVar;
        d dVar2 = new d(5);
        this.f3103n = dVar2;
        x.c a2 = x.c.a((ViewGroup) this, 1.0f, (c.a) dVar);
        this.f3100k = a2;
        a2.a(1);
        a2.a(f3);
        dVar.a(a2);
        x.c a3 = x.c.a((ViewGroup) this, 1.0f, (c.a) dVar2);
        this.f3101l = a3;
        a3.a(2);
        a3.a(f3);
        dVar2.a(a3);
        setFocusableInTouchMode(true);
        ac.b((View) this, 1);
        ac.a((View) this, (t.a) new a());
        setMotionEventSplittingEnabled(false);
        if (ac.x(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).a((Object) windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f3092c);
                try {
                    this.B = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.B = null;
            }
        }
        this.f3095f = f2 * 10.0f;
        this.M = new ArrayList<>();
    }

    private boolean a(float f2, float f3, View view) {
        if (this.N == null) {
            this.N = new Rect();
        }
        view.getHitRect(this.N);
        return this.N.contains((int) f2, (int) f3);
    }

    private boolean a(Drawable drawable, int i2) {
        if (drawable == null || !androidx.core.graphics.drawable.a.b(drawable)) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable, i2);
        return true;
    }

    private boolean a(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent b2 = b(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(b2);
            b2.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent b(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.O == null) {
                this.O = new Matrix();
            }
            matrix.invert(this.O);
            obtain.transform(this.O);
        }
        return obtain;
    }

    private void c(View view, boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            ac.b(childAt, ((z2 || g(childAt)) && (!z2 || childAt != view)) ? 4 : 1);
        }
    }

    static String d(int i2) {
        return (i2 & 3) == 3 ? "LEFT" : (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    private void e() {
        if (!f3093d) {
            this.C = f();
            this.D = g();
        }
    }

    private Drawable f() {
        int i2 = ac.i(this);
        if (i2 == 0) {
            Drawable drawable = this.I;
            if (drawable != null) {
                a(drawable, i2);
                return this.I;
            }
        } else {
            Drawable drawable2 = this.J;
            if (drawable2 != null) {
                a(drawable2, i2);
                return this.J;
            }
        }
        return this.K;
    }

    private Drawable g() {
        int i2 = ac.i(this);
        if (i2 == 0) {
            Drawable drawable = this.J;
            if (drawable != null) {
                a(drawable, i2);
                return this.J;
            }
        } else {
            Drawable drawable2 = this.I;
            if (drawable2 != null) {
                a(drawable2, i2);
                return this.I;
            }
        }
        return this.L;
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).f3119c) {
                return true;
            }
        }
        return false;
    }

    private boolean i() {
        return c() != null;
    }

    static boolean l(View view) {
        return (ac.f(view) == 4 || ac.f(view) == 2) ? false : true;
    }

    private static boolean m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public int a(int i2) {
        int i3 = ac.i(this);
        if (i2 == 3) {
            int i4 = this.f3107r;
            if (i4 != 3) {
                return i4;
            }
            int i5 = i3 == 0 ? this.f3109t : this.f3110u;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        } else if (i2 == 5) {
            int i6 = this.f3108s;
            if (i6 != 3) {
                return i6;
            }
            int i7 = i3 == 0 ? this.f3110u : this.f3109t;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i8 = this.f3109t;
            if (i8 != 3) {
                return i8;
            }
            int i9 = i3 == 0 ? this.f3107r : this.f3108s;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i10 = this.f3110u;
            if (i10 != 3) {
                return i10;
            }
            int i11 = i3 == 0 ? this.f3108s : this.f3107r;
            if (i11 != 3) {
                return i11;
            }
            return 0;
        }
    }

    public int a(View view) {
        if (g(view)) {
            return a(((LayoutParams) view.getLayoutParams()).f3117a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public View a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).f3120d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public void a(int i2, int i3) {
        View c2;
        int a2 = f.a(i3, ac.i(this));
        if (i3 == 3) {
            this.f3107r = i2;
        } else if (i3 == 5) {
            this.f3108s = i2;
        } else if (i3 == 8388611) {
            this.f3109t = i2;
        } else if (i3 == 8388613) {
            this.f3110u = i2;
        }
        if (i2 != 0) {
            (a2 == 3 ? this.f3100k : this.f3101l).e();
        }
        if (i2 == 1) {
            View c3 = c(a2);
            if (c3 != null) {
                i(c3);
            }
        } else if (i2 == 2 && (c2 = c(a2)) != null) {
            h(c2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, View view) {
        int a2 = this.f3100k.a();
        int a3 = this.f3101l.a();
        int i4 = 2;
        if (a2 == 1 || a3 == 1) {
            i4 = 1;
        } else if (!(a2 == 2 || a3 == 2)) {
            i4 = 0;
        }
        if (view != null && i3 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f3118b == 0.0f) {
                b(view);
            } else if (layoutParams.f3118b == 1.0f) {
                c(view);
            }
        }
        if (i4 != this.f3104o) {
            this.f3104o = i4;
            List<c> list = this.f3114y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3114y.get(size).a(i4);
                }
            }
        }
    }

    public void a(int i2, boolean z2) {
        View c2 = c(i2);
        if (c2 != null) {
            a(c2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + d(i2));
    }

    /* access modifiers changed from: package-private */
    public void a(View view, float f2) {
        List<c> list = this.f3114y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3114y.get(size).a(view, f2);
            }
        }
    }

    public void a(View view, boolean z2) {
        if (g(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f3106q) {
                layoutParams.f3118b = 1.0f;
                layoutParams.f3120d = 1;
                c(view, true);
            } else if (z2) {
                layoutParams.f3120d |= 2;
                if (a(view, 3)) {
                    this.f3100k.a(view, 0, view.getTop());
                } else {
                    this.f3101l.a(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                c(view, 1.0f);
                a(layoutParams.f3117a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void a(c cVar) {
        if (cVar != null) {
            if (this.f3114y == null) {
                this.f3114y = new ArrayList();
            }
            this.f3114y.add(cVar);
        }
    }

    public void a(Object obj, boolean z2) {
        this.G = obj;
        this.H = z2;
        setWillNotDraw(!z2 && getBackground() == null);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (g(childAt) && (!z2 || layoutParams.f3119c)) {
                z3 |= a(childAt, 3) ? this.f3100k.a(childAt, -childAt.getWidth(), childAt.getTop()) : this.f3101l.a(childAt, getWidth(), childAt.getTop());
                layoutParams.f3119c = false;
            }
        }
        this.f3102m.a();
        this.f3103n.a();
        if (z3) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view, int i2) {
        return (e(view) & i2) == i2;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z2 = false;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!g(childAt)) {
                    this.M.add(childAt);
                } else if (j(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z2 = true;
                }
            }
            if (!z2) {
                int size = this.M.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = this.M.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            this.M.clear();
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        ac.b(view, (a() != null || g(view)) ? 4 : 1);
        if (!f3091b) {
            ac.a(view, (t.a) this.f3094e);
        }
    }

    public CharSequence b(int i2) {
        int a2 = f.a(i2, ac.i(this));
        if (a2 == 3) {
            return this.E;
        }
        if (a2 == 5) {
            return this.F;
        }
        return null;
    }

    public void b() {
        a(false);
    }

    public void b(int i2, boolean z2) {
        View c2 = c(i2);
        if (c2 != null) {
            b(c2, z2);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + d(i2));
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f3120d & 1) == 1) {
            layoutParams.f3120d = 0;
            List<c> list = this.f3114y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3114y.get(size).b(view);
                }
            }
            c(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 != layoutParams.f3118b) {
            layoutParams.f3118b = f2;
            a(view, f2);
        }
    }

    public void b(View view, boolean z2) {
        x.c cVar;
        int i2;
        if (g(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f3106q) {
                layoutParams.f3118b = 0.0f;
                layoutParams.f3120d = 0;
            } else if (z2) {
                layoutParams.f3120d |= 4;
                if (a(view, 3)) {
                    cVar = this.f3100k;
                    i2 = -view.getWidth();
                } else {
                    cVar = this.f3101l;
                    i2 = getWidth();
                }
                cVar.a(view, i2, view.getTop());
            } else {
                c(view, 0.0f);
                a(layoutParams.f3117a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void b(c cVar) {
        List<c> list;
        if (cVar != null && (list = this.f3114y) != null) {
            list.remove(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    public View c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (g(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View c(int i2) {
        int a2 = f.a(i2, ac.i(this)) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((e(childAt) & 7) == a2) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f3120d & 1) == 0) {
            layoutParams.f3120d = 1;
            List<c> list = this.f3114y;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f3114y.get(size).a(view);
                }
            }
            c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(View view, float f2) {
        float d2 = d(view);
        float width = (float) view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (d2 * width));
        if (!a(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        b(view, f2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).f3118b);
        }
        this.f3098i = f2;
        boolean a2 = this.f3100k.a(true);
        boolean a3 = this.f3101l.a(true);
        if (a2 || a3) {
            ac.e(this);
        }
    }

    /* access modifiers changed from: package-private */
    public float d(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3118b;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!this.f3112w) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f3112w = true;
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f3098i <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (a(x2, y2, childAt) && !f(childAt) && a(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Drawable drawable;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean f2 = f(view2);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (f2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view2 && childAt.getVisibility() == 0 && m(childAt) && g(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i3) {
                            i3 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f3 = this.f3098i;
        if (f3 <= 0.0f || !f2) {
            if (this.C != null && a(view2, 3)) {
                int intrinsicWidth = this.C.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f3100k.b()), 1.0f));
                this.C.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.C.setAlpha((int) (max * 255.0f));
                drawable = this.C;
            } else if (this.D != null && a(view2, 5)) {
                int intrinsicWidth2 = this.D.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f3101l.b()), 1.0f));
                this.D.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.D.setAlpha((int) (max2 * 255.0f));
                drawable = this.D;
            }
            drawable.draw(canvas);
        } else {
            int i5 = this.f3097h;
            this.f3099j.setColor((i5 & 16777215) | (((int) (((float) ((-16777216 & i5) >>> 24)) * f3)) << 24));
            canvas.drawRect((float) i2, 0.0f, (float) width, (float) getHeight(), this.f3099j);
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public int e(View view) {
        return f.a(((LayoutParams) view.getLayoutParams()).f3117a, ac.i(this));
    }

    public void e(int i2) {
        a(i2, true);
    }

    public void f(int i2) {
        b(i2, true);
    }

    /* access modifiers changed from: package-private */
    public boolean f(View view) {
        return ((LayoutParams) view.getLayoutParams()).f3117a == 0;
    }

    public boolean g(int i2) {
        View c2 = c(i2);
        if (c2 != null) {
            return j(c2);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean g(View view) {
        int a2 = f.a(((LayoutParams) view.getLayoutParams()).f3117a, ac.i(view));
        return ((a2 & 3) == 0 && (a2 & 5) == 0) ? false : true;
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
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (f3093d) {
            return this.f3095f;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    public void h(View view) {
        a(view, true);
    }

    public boolean h(int i2) {
        View c2 = c(i2);
        if (c2 != null) {
            return k(c2);
        }
        return false;
    }

    public void i(View view) {
        b(view, true);
    }

    public boolean j(View view) {
        if (g(view)) {
            return (((LayoutParams) view.getLayoutParams()).f3120d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public boolean k(View view) {
        if (g(view)) {
            return ((LayoutParams) view.getLayoutParams()).f3118b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3106q = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3106q = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r4.G;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r5) {
        /*
            r4 = this;
            super.onDraw(r5)
            boolean r0 = r4.H
            if (r0 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r4.B
            if (r0 == 0) goto L_0x002e
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            r2 = 0
            if (r0 < r1) goto L_0x001d
            java.lang.Object r0 = r4.G
            if (r0 == 0) goto L_0x001d
            android.view.WindowInsets r0 = (android.view.WindowInsets) r0
            int r0 = r0.getSystemWindowInsetTop()
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r1 = r4.B
            int r3 = r4.getWidth()
            r1.setBounds(r2, r2, r3, r0)
            android.graphics.drawable.Drawable r0 = r4.B
            r0.draw(r5)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
        r7 = r6.f3100k.d((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0038;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            x.c r1 = r6.f3100k
            boolean r1 = r1.a((android.view.MotionEvent) r7)
            x.c r2 = r6.f3101l
            boolean r2 = r2.a((android.view.MotionEvent) r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0038
        L_0x001e:
            x.c r7 = r6.f3100k
            boolean r7 = r7.d(r4)
            if (r7 == 0) goto L_0x0038
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.f3102m
            r7.a()
            androidx.drawerlayout.widget.DrawerLayout$d r7 = r6.f3103n
            r7.a()
            goto L_0x0038
        L_0x0031:
            r6.a((boolean) r2)
            r6.f3111v = r3
            r6.f3112w = r3
        L_0x0038:
            r7 = 0
            goto L_0x0064
        L_0x003a:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.f3115z = r0
            r6.A = r7
            float r4 = r6.f3098i
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005f
            x.c r4 = r6.f3100k
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.d(r0, r7)
            if (r7 == 0) goto L_0x005f
            boolean r7 = r6.f((android.view.View) r7)
            if (r7 == 0) goto L_0x005f
            r7 = 1
            goto L_0x0060
        L_0x005f:
            r7 = 0
        L_0x0060:
            r6.f3111v = r3
            r6.f3112w = r3
        L_0x0064:
            if (r1 != 0) goto L_0x0074
            if (r7 != 0) goto L_0x0074
            boolean r7 = r6.h()
            if (r7 != 0) goto L_0x0074
            boolean r7 = r6.f3112w
            if (r7 == 0) goto L_0x0073
            goto L_0x0074
        L_0x0073:
            r2 = 0
        L_0x0074:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !i()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View c2 = c();
        if (c2 != null && a(c2) == 0) {
            b();
        }
        return c2 != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int i6;
        this.f3105p = true;
        int i7 = i4 - i2;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.f3118b * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i9 = i7 - ((int) (layoutParams.f3118b * f4));
                        f2 = ((float) (i7 - i9)) / f4;
                        i6 = i9;
                    }
                    boolean z3 = f2 != layoutParams.f3118b;
                    int i10 = layoutParams.f3117a & 112;
                    if (i10 == 16) {
                        int i11 = i5 - i3;
                        int i12 = (i11 - measuredHeight) / 2;
                        if (i12 < layoutParams.topMargin) {
                            i12 = layoutParams.topMargin;
                        } else if (i12 + measuredHeight > i11 - layoutParams.bottomMargin) {
                            i12 = (i11 - layoutParams.bottomMargin) - measuredHeight;
                        }
                        childAt.layout(i6, i12, measuredWidth + i6, measuredHeight + i12);
                    } else if (i10 != 80) {
                        childAt.layout(i6, layoutParams.topMargin, measuredWidth + i6, layoutParams.topMargin + measuredHeight);
                    } else {
                        int i13 = i5 - i3;
                        childAt.layout(i6, (i13 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i13 - layoutParams.bottomMargin);
                    }
                    if (z3) {
                        b(childAt, f2);
                    }
                    int i14 = layoutParams.f3118b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i14) {
                        childAt.setVisibility(i14);
                    }
                }
            }
        }
        this.f3105p = false;
        this.f3106q = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode != Integer.MIN_VALUE && mode == 0) {
                    size = 300;
                }
                if (mode2 != Integer.MIN_VALUE && mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i4 = 0;
        boolean z2 = this.G != null && ac.x(this);
        int i5 = ac.i(this);
        int childCount = getChildCount();
        int i6 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z2) {
                    int a2 = f.a(layoutParams.f3117a, i5);
                    boolean x2 = ac.x(childAt);
                    int i7 = Build.VERSION.SDK_INT;
                    if (x2) {
                        if (i7 >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.G;
                            if (a2 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i4, windowInsets.getSystemWindowInsetBottom());
                            } else if (a2 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i4, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (i7 >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.G;
                        if (a2 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i4, windowInsets2.getSystemWindowInsetBottom());
                        } else if (a2 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i4, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets2.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets2.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (f(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, MemoryConstants.GB));
                } else if (g(childAt)) {
                    if (f3093d) {
                        float s2 = ac.s(childAt);
                        float f2 = this.f3095f;
                        if (s2 != f2) {
                            ac.d(childAt, f2);
                        }
                    }
                    int e2 = e(childAt) & 7;
                    boolean z5 = e2 == 3;
                    if ((!z5 || !z3) && (z5 || !z4)) {
                        if (z5) {
                            z3 = true;
                        } else {
                            z4 = true;
                        }
                        childAt.measure(getChildMeasureSpec(i2, this.f3096g + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), getChildMeasureSpec(i3, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                        i6++;
                        i4 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + d(e2) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i6 + " does not have a valid layout_gravity - must be Gravity.LEFT, " + "Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i8 = i2;
            int i9 = i3;
            i6++;
            i4 = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View c2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (!(savedState.f3121a == 0 || (c2 = c(savedState.f3121a)) == null)) {
            h(c2);
        }
        if (savedState.f3122b != 3) {
            a(savedState.f3122b, 3);
        }
        if (savedState.f3123d != 3) {
            a(savedState.f3123d, 5);
        }
        if (savedState.f3124e != 3) {
            a(savedState.f3124e, 8388611);
        }
        if (savedState.f3125f != 3) {
            a(savedState.f3125f, 8388613);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        e();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            boolean z2 = true;
            boolean z3 = layoutParams.f3120d == 1;
            if (layoutParams.f3120d != 2) {
                z2 = false;
            }
            if (z3 || z2) {
                savedState.f3121a = layoutParams.f3117a;
            } else {
                i2++;
            }
        }
        savedState.f3122b = this.f3107r;
        savedState.f3123d = this.f3108s;
        savedState.f3124e = this.f3109t;
        savedState.f3125f = this.f3110u;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View a2;
        this.f3100k.b(motionEvent);
        this.f3101l.b(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View d2 = this.f3100k.d((int) x2, (int) y2);
                if (d2 != null && f(d2)) {
                    float f2 = x2 - this.f3115z;
                    float f3 = y2 - this.A;
                    int d3 = this.f3100k.d();
                    if (!((f2 * f2) + (f3 * f3) >= ((float) (d3 * d3)) || (a2 = a()) == null || a(a2) == 2)) {
                        z2 = false;
                        a(z2);
                        this.f3111v = false;
                    }
                }
                z2 = true;
                a(z2);
                this.f3111v = false;
            } else if (action == 3) {
                a(true);
            }
            return true;
        }
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        this.f3115z = x3;
        this.A = y3;
        this.f3111v = false;
        this.f3112w = false;
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        this.f3111v = z2;
        if (z2) {
            a(true);
        }
    }

    public void requestLayout() {
        if (!this.f3105p) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f2) {
        this.f3095f = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (g(childAt)) {
                ac.d(childAt, this.f3095f);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(c cVar) {
        c cVar2 = this.f3113x;
        if (cVar2 != null) {
            b(cVar2);
        }
        if (cVar != null) {
            a(cVar);
        }
        this.f3113x = cVar;
    }

    public void setDrawerLockMode(int i2) {
        a(i2, 3);
        a(i2, 5);
    }

    public void setScrimColor(int i2) {
        this.f3097h = i2;
        invalidate();
    }

    public void setStatusBarBackground(int i2) {
        this.B = i2 != 0 ? androidx.core.content.b.a(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.B = new ColorDrawable(i2);
        invalidate();
    }
}
