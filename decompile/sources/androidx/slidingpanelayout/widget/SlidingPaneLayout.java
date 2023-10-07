package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.customview.view.AbsSavedState;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import t.ac;
import x.c;

public class SlidingPaneLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    View f4491a;

    /* renamed from: b  reason: collision with root package name */
    float f4492b;

    /* renamed from: c  reason: collision with root package name */
    int f4493c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4494d;

    /* renamed from: e  reason: collision with root package name */
    final x.c f4495e;

    /* renamed from: f  reason: collision with root package name */
    boolean f4496f;

    /* renamed from: g  reason: collision with root package name */
    final ArrayList<b> f4497g;

    /* renamed from: h  reason: collision with root package name */
    private int f4498h;

    /* renamed from: i  reason: collision with root package name */
    private int f4499i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f4500j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f4501k;

    /* renamed from: l  reason: collision with root package name */
    private final int f4502l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4503m;

    /* renamed from: n  reason: collision with root package name */
    private float f4504n;

    /* renamed from: o  reason: collision with root package name */
    private int f4505o;

    /* renamed from: p  reason: collision with root package name */
    private float f4506p;

    /* renamed from: q  reason: collision with root package name */
    private float f4507q;

    /* renamed from: r  reason: collision with root package name */
    private d f4508r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f4509s;

    /* renamed from: t  reason: collision with root package name */
    private final Rect f4510t;

    /* renamed from: u  reason: collision with root package name */
    private Method f4511u;

    /* renamed from: v  reason: collision with root package name */
    private Field f4512v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f4513w;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        private static final int[] f4514e = {16843137};

        /* renamed from: a  reason: collision with root package name */
        public float f4515a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        boolean f4516b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4517c;

        /* renamed from: d  reason: collision with root package name */
        Paint f4518d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4514e);
            this.f4515a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
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
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f4519a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4519a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f4519a ? 1 : 0);
        }
    }

    class a extends t.a {

        /* renamed from: b  reason: collision with root package name */
        private final Rect f4521b = new Rect();

        a() {
        }

        private void a(u.c cVar, u.c cVar2) {
            Rect rect = this.f4521b;
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
            cVar.b(cVar2.e());
        }

        public void a(View view, u.c cVar) {
            u.c a2 = u.c.a(cVar);
            super.a(view, a2);
            a(cVar, a2);
            a2.v();
            cVar.b((CharSequence) SlidingPaneLayout.class.getName());
            cVar.b(view);
            ViewParent j2 = ac.j(view);
            if (j2 instanceof View) {
                cVar.d((View) j2);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i2);
                if (!c(childAt) && childAt.getVisibility() == 0) {
                    ac.b(childAt, 1);
                    cVar.c(childAt);
                }
            }
        }

        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!c(view)) {
                return super.a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        public boolean c(View view) {
            return SlidingPaneLayout.this.f(view);
        }

        public void d(View view, AccessibilityEvent accessibilityEvent) {
            super.d(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }
    }

    private class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final View f4522a;

        b(View view) {
            this.f4522a = view;
        }

        public void run() {
            if (this.f4522a.getParent() == SlidingPaneLayout.this) {
                this.f4522a.setLayerType(0, (Paint) null);
                SlidingPaneLayout.this.e(this.f4522a);
            }
            SlidingPaneLayout.this.f4497g.remove(this);
        }
    }

    private class c extends c.a {
        c() {
        }

        public int a(View view) {
            return SlidingPaneLayout.this.f4493c;
        }

        public int a(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f4491a.getLayoutParams();
            if (SlidingPaneLayout.this.f()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin) + SlidingPaneLayout.this.f4491a.getWidth());
                return Math.max(Math.min(i2, width), width - SlidingPaneLayout.this.f4493c);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i2, paddingLeft), SlidingPaneLayout.this.f4493c + paddingLeft);
        }

        public void a(int i2) {
            SlidingPaneLayout slidingPaneLayout;
            boolean z2;
            if (SlidingPaneLayout.this.f4495e.a() == 0) {
                if (SlidingPaneLayout.this.f4492b == 0.0f) {
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.d(slidingPaneLayout2.f4491a);
                    SlidingPaneLayout slidingPaneLayout3 = SlidingPaneLayout.this;
                    slidingPaneLayout3.c(slidingPaneLayout3.f4491a);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z2 = false;
                } else {
                    SlidingPaneLayout slidingPaneLayout4 = SlidingPaneLayout.this;
                    slidingPaneLayout4.b(slidingPaneLayout4.f4491a);
                    slidingPaneLayout = SlidingPaneLayout.this;
                    z2 = true;
                }
                slidingPaneLayout.f4496f = z2;
            }
        }

        public void a(View view, float f2, float f3) {
            int i2;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.f()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + layoutParams.rightMargin;
                if (f2 < 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.f4492b > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f4493c;
                }
                i2 = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f4491a.getWidth();
            } else {
                i2 = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f2 > 0.0f || (f2 == 0.0f && SlidingPaneLayout.this.f4492b > 0.5f)) {
                    i2 += SlidingPaneLayout.this.f4493c;
                }
            }
            SlidingPaneLayout.this.f4495e.a(i2, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        public void a(View view, int i2) {
            SlidingPaneLayout.this.a();
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            SlidingPaneLayout.this.a(i2);
            SlidingPaneLayout.this.invalidate();
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        public void b(int i2, int i3) {
            SlidingPaneLayout.this.f4495e.a(SlidingPaneLayout.this.f4491a, i3);
        }

        public boolean b(View view, int i2) {
            if (SlidingPaneLayout.this.f4494d) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f4516b;
        }
    }

    public interface d {
        void a(View view);

        void a(View view, float f2);

        void b(View view);
    }

    public SlidingPaneLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4498h = -858993460;
        this.f4509s = true;
        this.f4510t = new Rect();
        this.f4497g = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f4502l = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        ac.a((View) this, (t.a) new a());
        ac.b((View) this, 1);
        x.c a2 = x.c.a((ViewGroup) this, 0.5f, (c.a) new c());
        this.f4495e = a2;
        a2.a(f2 * 400.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.f()
            android.view.View r1 = r9.f4491a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.f4517c
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0059
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f4491a
            if (r4 != r5) goto L_0x002c
            goto L_0x0056
        L_0x002c:
            float r5 = r9.f4504n
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.f4505o
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.f4504n = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0044
            int r5 = -r5
        L_0x0044:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0056
            float r5 = r9.f4504n
            if (r0 == 0) goto L_0x004f
            float r5 = r5 - r6
            goto L_0x0051
        L_0x004f:
            float r5 = r6 - r5
        L_0x0051:
            int r6 = r9.f4499i
            r9.a(r4, r5, r6)
        L_0x0056:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0059:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.a(float):void");
    }

    private void a(View view, float f2, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i2 != 0) {
            int i3 = (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24) | (i2 & 16777215);
            if (layoutParams.f4518d == null) {
                layoutParams.f4518d = new Paint();
            }
            layoutParams.f4518d.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f4518d);
            }
            e(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.f4518d != null) {
                layoutParams.f4518d.setColorFilter((ColorFilter) null);
            }
            b bVar = new b(view);
            this.f4497g.add(bVar);
            ac.a((View) this, (Runnable) bVar);
        }
    }

    private boolean a(View view, int i2) {
        if (!this.f4509s && !a(0.0f, i2)) {
            return false;
        }
        this.f4496f = false;
        return true;
    }

    private boolean b(View view, int i2) {
        if (!this.f4509s && !a(1.0f, i2)) {
            return false;
        }
        this.f4496f = true;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
        r4 = r4.getBackground();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean g(android.view.View r4) {
        /*
            boolean r0 = r4.isOpaque()
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 18
            r3 = 0
            if (r0 < r2) goto L_0x0010
            return r3
        L_0x0010:
            android.graphics.drawable.Drawable r4 = r4.getBackground()
            if (r4 == 0) goto L_0x0020
            int r4 = r4.getOpacity()
            r0 = -1
            if (r4 != r0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            return r1
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.g(android.view.View):boolean");
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (this.f4491a == null) {
            this.f4492b = 0.0f;
            return;
        }
        boolean f2 = f();
        LayoutParams layoutParams = (LayoutParams) this.f4491a.getLayoutParams();
        int width = this.f4491a.getWidth();
        if (f2) {
            i2 = (getWidth() - i2) - width;
        }
        float paddingRight = ((float) (i2 - ((f2 ? getPaddingRight() : getPaddingLeft()) + (f2 ? layoutParams.rightMargin : layoutParams.leftMargin)))) / ((float) this.f4493c);
        this.f4492b = paddingRight;
        if (this.f4505o != 0) {
            a(paddingRight);
        }
        if (layoutParams.f4517c) {
            a(this.f4491a, this.f4492b, this.f4498h);
        }
        a(this.f4491a);
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        d dVar = this.f4508r;
        if (dVar != null) {
            dVar.a(view, this.f4492b);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, int i2) {
        int i3;
        if (!this.f4503m) {
            return false;
        }
        boolean f3 = f();
        LayoutParams layoutParams = (LayoutParams) this.f4491a.getLayoutParams();
        if (f3) {
            i3 = (int) (((float) getWidth()) - ((((float) (getPaddingRight() + layoutParams.rightMargin)) + (f2 * ((float) this.f4493c))) + ((float) this.f4491a.getWidth())));
        } else {
            i3 = (int) (((float) (getPaddingLeft() + layoutParams.leftMargin)) + (f2 * ((float) this.f4493c)));
        }
        x.c cVar = this.f4495e;
        View view = this.f4491a;
        if (!cVar.a(view, i3, view.getTop())) {
            return false;
        }
        a();
        ac.e(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        d dVar = this.f4508r;
        if (dVar != null) {
            dVar.a(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean b() {
        return b(this.f4491a, 0);
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        d dVar = this.f4508r;
        if (dVar != null) {
            dVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean c() {
        return a(this.f4491a, 0);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.f4495e.a(true)) {
            return;
        }
        if (!this.f4503m) {
            this.f4495e.f();
        } else {
            ac.e(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        View childAt;
        boolean z2;
        View view2 = view;
        boolean f2 = f();
        int width = f2 ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = f2 ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !g(view)) {
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
        } else {
            i5 = view.getLeft();
            i4 = view.getRight();
            i3 = view.getTop();
            i2 = view.getBottom();
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 < childCount && (childAt = getChildAt(i6)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z2 = f2;
                } else {
                    z2 = f2;
                    childAt.setVisibility((Math.max(f2 ? paddingLeft : width, childAt.getLeft()) < i5 || Math.max(paddingTop, childAt.getTop()) < i3 || Math.min(f2 ? width : paddingLeft, childAt.getRight()) > i4 || Math.min(height, childAt.getBottom()) > i2) ? 0 : 4);
                }
                i6++;
                view2 = view;
                f2 = z2;
            } else {
                return;
            }
        }
    }

    public boolean d() {
        return !this.f4503m || this.f4492b == 1.0f;
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3;
        super.draw(canvas);
        Drawable drawable = f() ? this.f4501k : this.f4500j;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (f()) {
                i3 = childAt.getRight();
                i2 = intrinsicWidth + i3;
            } else {
                int left = childAt.getLeft();
                int i4 = left - intrinsicWidth;
                i2 = left;
                i3 = i4;
            }
            drawable.setBounds(i3, top, i2, bottom);
            drawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f4503m && !layoutParams.f4516b && this.f4491a != null) {
            canvas.getClipBounds(this.f4510t);
            if (f()) {
                Rect rect = this.f4510t;
                rect.left = Math.max(rect.left, this.f4491a.getRight());
            } else {
                Rect rect2 = this.f4510t;
                rect2.right = Math.min(rect2.right, this.f4491a.getLeft());
            }
            canvas.clipRect(this.f4510t);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        Field field;
        if (Build.VERSION.SDK_INT >= 17) {
            ac.a(view, ((LayoutParams) view.getLayoutParams()).f4518d);
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!this.f4513w) {
                try {
                    this.f4511u = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
                } catch (NoSuchMethodException e2) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e2);
                }
                try {
                    Field declaredField = View.class.getDeclaredField("mRecreateDisplayList");
                    this.f4512v = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
                }
                this.f4513w = true;
            }
            if (this.f4511u == null || (field = this.f4512v) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.f4511u.invoke(view, (Object[]) null);
            } catch (Exception e4) {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", e4);
            }
        }
        ac.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    public boolean e() {
        return this.f4503m;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return ac.i(this) == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean f(View view) {
        if (view == null) {
            return false;
        }
        return this.f4503m && ((LayoutParams) view.getLayoutParams()).f4517c && this.f4492b > 0.0f;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f4499i;
    }

    public int getParallaxDistance() {
        return this.f4505o;
    }

    public int getSliderFadeColor() {
        return this.f4498h;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4509s = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4509s = true;
        int size = this.f4497g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4497g.get(i2).run();
        }
        this.f4497g.clear();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f4503m && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f4496f = !this.f4495e.b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f4503m || (this.f4494d && actionMasked != 0)) {
            this.f4495e.e();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            this.f4495e.e();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f4494d = false;
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                this.f4506p = x2;
                this.f4507q = y2;
                if (this.f4495e.b(this.f4491a, (int) x2, (int) y2) && f(this.f4491a)) {
                    z2 = true;
                    return this.f4495e.a(motionEvent) || z2;
                }
            } else if (actionMasked == 2) {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                float abs = Math.abs(x3 - this.f4506p);
                float abs2 = Math.abs(y3 - this.f4507q);
                if (abs > ((float) this.f4495e.d()) && abs2 > abs) {
                    this.f4495e.e();
                    this.f4494d = true;
                    return false;
                }
            }
            z2 = false;
            if (this.f4495e.a(motionEvent)) {
                return true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        boolean f2 = f();
        x.c cVar = this.f4495e;
        if (f2) {
            cVar.a(2);
        } else {
            cVar.a(1);
        }
        int i10 = i4 - i2;
        int paddingRight = f2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f4509s) {
            this.f4492b = (!this.f4503m || !this.f4496f) ? 0.0f : 1.0f;
        }
        int i11 = paddingRight;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f4516b) {
                    int i13 = i10 - paddingLeft;
                    int min = (Math.min(paddingRight, i13 - this.f4502l) - i11) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f4493c = min;
                    int i14 = f2 ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f4517c = ((i11 + i14) + min) + (measuredWidth / 2) > i13;
                    int i15 = (int) (((float) min) * this.f4492b);
                    i11 += i14 + i15;
                    this.f4492b = ((float) i15) / ((float) this.f4493c);
                    i6 = 0;
                } else if (!this.f4503m || (i9 = this.f4505o) == 0) {
                    i11 = paddingRight;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.f4492b) * ((float) i9));
                    i11 = paddingRight;
                }
                if (f2) {
                    i7 = (i10 - i11) + i6;
                    i8 = i7 - measuredWidth;
                } else {
                    i8 = i11 - i6;
                    i7 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i7, childAt.getMeasuredHeight() + paddingTop);
                paddingRight += childAt.getWidth();
            }
        }
        if (this.f4509s) {
            if (this.f4503m) {
                if (this.f4505o != 0) {
                    a(this.f4492b);
                }
                if (((LayoutParams) this.f4491a.getLayoutParams()).f4517c) {
                    a(this.f4491a, this.f4492b, this.f4498h);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    a(getChildAt(i16), 0.0f, this.f4498h);
                }
            }
            d(this.f4491a);
        }
        this.f4509s = false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0119 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            int r1 = android.view.View.MeasureSpec.getMode(r21)
            int r2 = android.view.View.MeasureSpec.getSize(r21)
            int r3 = android.view.View.MeasureSpec.getMode(r22)
            int r4 = android.view.View.MeasureSpec.getSize(r22)
            r5 = 300(0x12c, float:4.2E-43)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            if (r1 == r7) goto L_0x0030
            boolean r8 = r20.isInEditMode()
            if (r8 == 0) goto L_0x0028
            if (r1 != r6) goto L_0x0023
            goto L_0x0047
        L_0x0023:
            if (r1 != 0) goto L_0x0047
            r2 = 300(0x12c, float:4.2E-43)
            goto L_0x0047
        L_0x0028:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Width must have an exact value or MATCH_PARENT"
            r1.<init>(r2)
            throw r1
        L_0x0030:
            if (r3 != 0) goto L_0x0047
            boolean r1 = r20.isInEditMode()
            if (r1 == 0) goto L_0x003f
            if (r3 != 0) goto L_0x0047
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 300(0x12c, float:4.2E-43)
            goto L_0x0047
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Height must not be UNSPECIFIED"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            r1 = 0
            if (r3 == r6) goto L_0x005b
            if (r3 == r7) goto L_0x004f
            r4 = 0
            r5 = 0
            goto L_0x0067
        L_0x004f:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            r5 = r4
            goto L_0x0067
        L_0x005b:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            r5 = r4
            r4 = 0
        L_0x0067:
            int r8 = r20.getPaddingLeft()
            int r8 = r2 - r8
            int r9 = r20.getPaddingRight()
            int r8 = r8 - r9
            int r9 = r20.getChildCount()
            r10 = 2
            if (r9 <= r10) goto L_0x0080
            java.lang.String r10 = "SlidingPaneLayout"
            java.lang.String r11 = "onMeasure: More than two child views are not supported."
            android.util.Log.e(r10, r11)
        L_0x0080:
            r10 = 0
            r0.f4491a = r10
            r14 = r8
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x0087:
            r15 = 8
            r16 = 1
            if (r11 >= r9) goto L_0x0122
            android.view.View r6 = r0.getChildAt(r11)
            android.view.ViewGroup$LayoutParams r18 = r6.getLayoutParams()
            r7 = r18
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x00a3
            r7.f4517c = r1
            goto L_0x0119
        L_0x00a3:
            float r10 = r7.f4515a
            r15 = 0
            int r10 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r10 <= 0) goto L_0x00b2
            float r10 = r7.f4515a
            float r13 = r13 + r10
            int r10 = r7.width
            if (r10 != 0) goto L_0x00b2
            goto L_0x0119
        L_0x00b2:
            int r10 = r7.leftMargin
            int r15 = r7.rightMargin
            int r10 = r10 + r15
            int r15 = r7.width
            r1 = -2
            if (r15 != r1) goto L_0x00c7
            int r1 = r8 - r10
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x00d9
        L_0x00c7:
            int r1 = r7.width
            r15 = -1
            if (r1 != r15) goto L_0x00d1
            int r1 = r8 - r10
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x00d5
        L_0x00d1:
            r10 = 1073741824(0x40000000, float:2.0)
            int r1 = r7.width
        L_0x00d5:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
        L_0x00d9:
            int r15 = r7.height
            r10 = -2
            if (r15 != r10) goto L_0x00e5
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00e0:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            goto L_0x00f5
        L_0x00e5:
            int r10 = r7.height
            r15 = -1
            if (r10 != r15) goto L_0x00ed
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x00e0
        L_0x00ed:
            r10 = 1073741824(0x40000000, float:2.0)
            int r15 = r7.height
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
        L_0x00f5:
            r6.measure(r1, r15)
            int r1 = r6.getMeasuredWidth()
            int r10 = r6.getMeasuredHeight()
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 != r15) goto L_0x010a
            if (r10 <= r4) goto L_0x010a
            int r4 = java.lang.Math.min(r10, r5)
        L_0x010a:
            int r14 = r14 - r1
            if (r14 >= 0) goto L_0x010f
            r1 = 1
            goto L_0x0110
        L_0x010f:
            r1 = 0
        L_0x0110:
            r7.f4516b = r1
            r12 = r12 | r1
            boolean r1 = r7.f4516b
            if (r1 == 0) goto L_0x0119
            r0.f4491a = r6
        L_0x0119:
            int r11 = r11 + 1
            r1 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0087
        L_0x0122:
            if (r12 != 0) goto L_0x0129
            r1 = 0
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x021a
        L_0x0129:
            int r1 = r0.f4502l
            int r1 = r8 - r1
            r3 = 0
        L_0x012e:
            if (r3 >= r9) goto L_0x021a
            android.view.View r6 = r0.getChildAt(r3)
            int r7 = r6.getVisibility()
            if (r7 != r15) goto L_0x0141
        L_0x013a:
            r19 = r1
        L_0x013c:
            r1 = 0
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0212
        L_0x0141:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x014e
            goto L_0x013a
        L_0x014e:
            int r10 = r7.width
            if (r10 != 0) goto L_0x015b
            float r10 = r7.f4515a
            r11 = 0
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x015b
            r10 = 1
            goto L_0x015c
        L_0x015b:
            r10 = 0
        L_0x015c:
            if (r10 == 0) goto L_0x0160
            r11 = 0
            goto L_0x0164
        L_0x0160:
            int r11 = r6.getMeasuredWidth()
        L_0x0164:
            if (r12 == 0) goto L_0x01aa
            android.view.View r15 = r0.f4491a
            if (r6 == r15) goto L_0x01aa
            int r15 = r7.width
            if (r15 >= 0) goto L_0x013a
            if (r11 > r1) goto L_0x0177
            float r11 = r7.f4515a
            r15 = 0
            int r11 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r11 <= 0) goto L_0x013a
        L_0x0177:
            if (r10 == 0) goto L_0x0198
            int r10 = r7.height
            r11 = -2
            if (r10 != r11) goto L_0x0187
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x01a2
        L_0x0187:
            int r10 = r7.height
            r11 = -1
            if (r10 != r11) goto L_0x0193
            r10 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            goto L_0x01a2
        L_0x0193:
            r10 = 1073741824(0x40000000, float:2.0)
            int r7 = r7.height
            goto L_0x019e
        L_0x0198:
            r10 = 1073741824(0x40000000, float:2.0)
            int r7 = r6.getMeasuredHeight()
        L_0x019e:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10)
        L_0x01a2:
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r10)
            r6.measure(r11, r7)
            goto L_0x013a
        L_0x01aa:
            float r10 = r7.f4515a
            r15 = 0
            int r10 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r10 <= 0) goto L_0x013a
            int r10 = r7.width
            if (r10 != 0) goto L_0x01d8
            int r10 = r7.height
            r15 = -2
            if (r10 != r15) goto L_0x01c5
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            int r17 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            r15 = r17
            r10 = 1073741824(0x40000000, float:2.0)
            goto L_0x01e2
        L_0x01c5:
            int r10 = r7.height
            r15 = -1
            if (r10 != r15) goto L_0x01d3
            r10 = 1073741824(0x40000000, float:2.0)
            int r19 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r10)
            r15 = r19
            goto L_0x01e2
        L_0x01d3:
            r10 = 1073741824(0x40000000, float:2.0)
            int r15 = r7.height
            goto L_0x01de
        L_0x01d8:
            r10 = 1073741824(0x40000000, float:2.0)
            int r15 = r6.getMeasuredHeight()
        L_0x01de:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
        L_0x01e2:
            if (r12 == 0) goto L_0x01fa
            int r10 = r7.leftMargin
            int r7 = r7.rightMargin
            int r10 = r10 + r7
            int r7 = r8 - r10
            r19 = r1
            r10 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r10)
            if (r11 == r7) goto L_0x013c
            r6.measure(r1, r15)
            goto L_0x013c
        L_0x01fa:
            r19 = r1
            r1 = 0
            int r10 = java.lang.Math.max(r1, r14)
            float r7 = r7.f4515a
            float r10 = (float) r10
            float r7 = r7 * r10
            float r7 = r7 / r13
            int r7 = (int) r7
            int r11 = r11 + r7
            r7 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r11, r7)
            r6.measure(r10, r15)
        L_0x0212:
            int r3 = r3 + 1
            r1 = r19
            r15 = 8
            goto L_0x012e
        L_0x021a:
            int r1 = r20.getPaddingTop()
            int r4 = r4 + r1
            int r1 = r20.getPaddingBottom()
            int r4 = r4 + r1
            r0.setMeasuredDimension(r2, r4)
            r0.f4503m = r12
            x.c r1 = r0.f4495e
            int r1 = r1.a()
            if (r1 == 0) goto L_0x0238
            if (r12 != 0) goto L_0x0238
            x.c r1 = r0.f4495e
            r1.f()
        L_0x0238:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        if (savedState.f4519a) {
            b();
        } else {
            c();
        }
        this.f4496f = savedState.f4519a;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4519a = e() ? d() : this.f4496f;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            this.f4509s = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f4503m) {
            return super.onTouchEvent(motionEvent);
        }
        this.f4495e.b(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.f4506p = x2;
            this.f4507q = y2;
        } else if (actionMasked == 1 && f(this.f4491a)) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float f2 = x3 - this.f4506p;
            float f3 = y3 - this.f4507q;
            int d2 = this.f4495e.d();
            if ((f2 * f2) + (f3 * f3) < ((float) (d2 * d2)) && this.f4495e.b(this.f4491a, (int) x3, (int) y3)) {
                a(this.f4491a, 0);
            }
        }
        return true;
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f4503m) {
            this.f4496f = view == this.f4491a;
        }
    }

    public void setCoveredFadeColor(int i2) {
        this.f4499i = i2;
    }

    public void setPanelSlideListener(d dVar) {
        this.f4508r = dVar;
    }

    public void setParallaxDistance(int i2) {
        this.f4505o = i2;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f4500j = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f4501k = drawable;
    }

    @Deprecated
    public void setShadowResource(int i2) {
        setShadowDrawable(getResources().getDrawable(i2));
    }

    public void setShadowResourceLeft(int i2) {
        setShadowDrawableLeft(androidx.core.content.b.a(getContext(), i2));
    }

    public void setShadowResourceRight(int i2) {
        setShadowDrawableRight(androidx.core.content.b.a(getContext(), i2));
    }

    public void setSliderFadeColor(int i2) {
        this.f4498h = i2;
    }
}
