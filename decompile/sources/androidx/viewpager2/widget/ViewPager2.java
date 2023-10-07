package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import androidx.viewpager2.R;
import t.ac;
import u.c;
import u.f;

public final class ViewPager2 extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    static boolean f4980a = true;

    /* renamed from: b  reason: collision with root package name */
    int f4981b;

    /* renamed from: c  reason: collision with root package name */
    boolean f4982c = false;

    /* renamed from: d  reason: collision with root package name */
    RecyclerView f4983d;

    /* renamed from: e  reason: collision with root package name */
    e f4984e;

    /* renamed from: f  reason: collision with root package name */
    a f4985f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f4986g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    private final Rect f4987h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private b f4988i = new b(3);

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.b f4989j = new c() {
        public void a() {
            ViewPager2.this.f4982c = true;
            ViewPager2.this.f4984e.a();
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private LinearLayoutManager f4990k;

    /* renamed from: l  reason: collision with root package name */
    private int f4991l = -1;

    /* renamed from: m  reason: collision with root package name */
    private Parcelable f4992m;

    /* renamed from: n  reason: collision with root package name */
    private t f4993n;

    /* renamed from: o  reason: collision with root package name */
    private b f4994o;

    /* renamed from: p  reason: collision with root package name */
    private c f4995p;

    /* renamed from: q  reason: collision with root package name */
    private d f4996q;

    /* renamed from: r  reason: collision with root package name */
    private RecyclerView.e f4997r = null;

    /* renamed from: s  reason: collision with root package name */
    private boolean f4998s = false;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4999t = true;

    /* renamed from: u  reason: collision with root package name */
    private int f5000u = -1;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f5005a;

        /* renamed from: b  reason: collision with root package name */
        int f5006b;

        /* renamed from: c  reason: collision with root package name */
        Parcelable f5007c;

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, (ClassLoader) null);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f5005a = parcel.readInt();
            this.f5006b = parcel.readInt();
            this.f5007c = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f5005a);
            parcel.writeInt(this.f5006b);
            parcel.writeParcelable(this.f5007c, i2);
        }
    }

    private abstract class a {
        private a() {
        }

        /* access modifiers changed from: package-private */
        public void a(AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar, RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public void a(u.c cVar) {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void c() {
        }

        /* access modifiers changed from: package-private */
        public void d() {
        }

        /* access modifiers changed from: package-private */
        public void e() {
        }

        /* access modifiers changed from: package-private */
        public void f() {
        }

        /* access modifiers changed from: package-private */
        public void g() {
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public CharSequence i() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    class b extends a {
        b() {
            super();
        }

        public void a(u.c cVar) {
            if (!ViewPager2.this.d()) {
                cVar.b(c.a.f34544n);
                cVar.b(c.a.f34543m);
                cVar.k(false);
            }
        }

        public boolean a(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.d();
        }

        public boolean b(int i2) {
            if (a(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean h() {
            return true;
        }

        public CharSequence i() {
            if (h()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class c extends RecyclerView.b {
        private c() {
        }

        public abstract void a();

        public final void a(int i2, int i3) {
            a();
        }

        public final void a(int i2, int i3, int i4) {
            a();
        }

        public final void a(int i2, int i3, Object obj) {
            a();
        }

        public final void b(int i2, int i3) {
            a();
        }

        public final void c(int i2, int i3) {
            a();
        }
    }

    private class d extends LinearLayoutManager {
        d(Context context) {
            super(context);
        }

        public void a(RecyclerView.n nVar, RecyclerView.s sVar, u.c cVar) {
            super.a(nVar, sVar, cVar);
            ViewPager2.this.f4985f.a(cVar);
        }

        /* access modifiers changed from: protected */
        public void a(RecyclerView.s sVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.a(sVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public boolean a(RecyclerView.n nVar, RecyclerView.s sVar, int i2, Bundle bundle) {
            return ViewPager2.this.f4985f.a(i2) ? ViewPager2.this.f4985f.b(i2) : super.a(nVar, sVar, i2, bundle);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            return false;
        }
    }

    public static abstract class e {
        public void a(int i2) {
        }

        public void a(int i2, float f2, int i3) {
        }

        public void b(int i2) {
        }
    }

    class f extends a {

        /* renamed from: c  reason: collision with root package name */
        private final u.f f5012c = new u.f() {
            public boolean a(View view, f.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private final u.f f5013d = new u.f() {
            public boolean a(View view, f.a aVar) {
                f.this.c(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };

        /* renamed from: e  reason: collision with root package name */
        private RecyclerView.b f5014e;

        f() {
            super();
        }

        private void b(AccessibilityNodeInfo accessibilityNodeInfo) {
            int i2;
            int i3;
            if (ViewPager2.this.getAdapter() == null) {
                i3 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i3 = ViewPager2.this.getAdapter().getItemCount();
            } else {
                i2 = ViewPager2.this.getAdapter().getItemCount();
                i3 = 0;
                u.c.a(accessibilityNodeInfo).a((Object) c.b.a(i3, i2, false, 0));
            }
            i2 = 0;
            u.c.a(accessibilityNodeInfo).a((Object) c.b.a(i3, i2, false, 0));
        }

        private void c(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.d()) {
                if (ViewPager2.this.f4981b > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (ViewPager2.this.f4981b < itemCount - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
                accessibilityNodeInfo.setScrollable(true);
            }
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(b());
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            b(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                c(accessibilityNodeInfo);
            }
        }

        public void a(RecyclerView.Adapter<?> adapter) {
            j();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.f5014e);
            }
        }

        public void a(b bVar, RecyclerView recyclerView) {
            ac.b((View) recyclerView, 2);
            this.f5014e = new c() {
                public void a() {
                    f.this.j();
                }
            };
            if (ac.f(ViewPager2.this) == 0) {
                ac.b((View) ViewPager2.this, 1);
            }
        }

        public boolean a() {
            return true;
        }

        public boolean a(int i2, Bundle bundle) {
            return i2 == 8192 || i2 == 4096;
        }

        public String b() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void b(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.f5014e);
            }
        }

        public boolean b(int i2, Bundle bundle) {
            if (a(i2, bundle)) {
                c(i2 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
                return true;
            }
            throw new IllegalStateException();
        }

        public void c() {
            j();
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            if (ViewPager2.this.d()) {
                ViewPager2.this.b(i2, true);
            }
        }

        public void d() {
            j();
        }

        public void e() {
            j();
        }

        public void f() {
            j();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        public void g() {
            j();
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i2 = 16908360;
            ac.c((View) viewPager2, 16908360);
            ac.c((View) viewPager2, 16908361);
            ac.c((View) viewPager2, 16908358);
            ac.c((View) viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.d()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean b2 = ViewPager2.this.b();
                    int i3 = b2 ? 16908360 : 16908361;
                    if (b2) {
                        i2 = 16908361;
                    }
                    if (ViewPager2.this.f4981b < itemCount - 1) {
                        ac.a(viewPager2, new c.a(i3, (CharSequence) null), (CharSequence) null, this.f5012c);
                    }
                    if (ViewPager2.this.f4981b > 0) {
                        ac.a(viewPager2, new c.a(i2, (CharSequence) null), (CharSequence) null, this.f5013d);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f4981b < itemCount - 1) {
                    ac.a(viewPager2, new c.a(16908359, (CharSequence) null), (CharSequence) null, this.f5012c);
                }
                if (ViewPager2.this.f4981b > 0) {
                    ac.a(viewPager2, new c.a(16908358, (CharSequence) null), (CharSequence) null, this.f5013d);
                }
            }
        }
    }

    public interface g {
        void a(View view, float f2);
    }

    private class h extends t {
        h() {
        }

        public View a(RecyclerView.h hVar) {
            if (ViewPager2.this.c()) {
                return null;
            }
            return super.a(hVar);
        }
    }

    private class i extends RecyclerView {
        i(Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.f4985f.h() ? ViewPager2.this.f4985f.i() : super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f4981b);
            accessibilityEvent.setToIndex(ViewPager2.this.f4981b);
            ViewPager2.this.f4985f.a(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.d() && super.onInterceptTouchEvent(motionEvent);
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.d() && super.onTouchEvent(motionEvent);
        }
    }

    private static class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f5019a;

        /* renamed from: b  reason: collision with root package name */
        private final RecyclerView f5020b;

        j(int i2, RecyclerView recyclerView) {
            this.f5019a = i2;
            this.f5020b = recyclerView;
        }

        public void run() {
            this.f5020b.c(this.f5019a);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f4985f = f4980a ? new f() : new b();
        i iVar = new i(context);
        this.f4983d = iVar;
        iVar.setId(ac.a());
        this.f4983d.setDescendantFocusability(131072);
        d dVar = new d(context);
        this.f4990k = dVar;
        this.f4983d.setLayoutManager(dVar);
        this.f4983d.setScrollingTouchSlop(1);
        b(context, attributeSet);
        this.f4983d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f4983d.a(f());
        e eVar = new e(this);
        this.f4984e = eVar;
        this.f4995p = new c(this, eVar, this.f4983d);
        h hVar = new h();
        this.f4993n = hVar;
        hVar.a(this.f4983d);
        this.f4983d.a((RecyclerView.l) this.f4984e);
        b bVar = new b(3);
        this.f4994o = bVar;
        this.f4984e.a((e) bVar);
        AnonymousClass2 r3 = new e() {
            public void a(int i2) {
                if (ViewPager2.this.f4981b != i2) {
                    ViewPager2.this.f4981b = i2;
                    ViewPager2.this.f4985f.e();
                }
            }

            public void b(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.a();
                }
            }
        };
        AnonymousClass3 r4 = new e() {
            public void a(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f4983d.requestFocus(2);
                }
            }
        };
        this.f4994o.a((e) r3);
        this.f4994o.a((e) r4);
        this.f4985f.a(this.f4994o, this.f4983d);
        this.f4994o.a((e) this.f4988i);
        d dVar2 = new d(this.f4990k);
        this.f4996q = dVar2;
        this.f4994o.a((e) dVar2);
        RecyclerView recyclerView = this.f4983d;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void a(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.f4989j);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, R.styleable.ViewPager2, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void b(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f4989j);
        }
    }

    private RecyclerView.i f() {
        return new RecyclerView.i() {
            public void a(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            public void b(View view) {
            }
        };
    }

    private void g() {
        RecyclerView.Adapter adapter;
        if (this.f4991l != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f4992m;
            if (parcelable != null) {
                if (adapter instanceof androidx.viewpager2.adapter.c) {
                    ((androidx.viewpager2.adapter.c) adapter).a(parcelable);
                }
                this.f4992m = null;
            }
            int max = Math.max(0, Math.min(this.f4991l, adapter.getItemCount() - 1));
            this.f4981b = max;
            this.f4991l = -1;
            this.f4983d.a(max);
            this.f4985f.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        t tVar = this.f4993n;
        if (tVar != null) {
            View a2 = tVar.a(this.f4990k);
            if (a2 != null) {
                int d2 = this.f4990k.d(a2);
                if (d2 != this.f4981b && getScrollState() == 0) {
                    this.f4994o.a(d2);
                }
                this.f4982c = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void a(int i2, boolean z2) {
        if (!c()) {
            b(i2, z2);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, boolean z2) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.f4991l != -1) {
                this.f4991l = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            if (min != this.f4981b || !this.f4984e.c()) {
                int i3 = this.f4981b;
                if (min != i3 || !z2) {
                    double d2 = (double) i3;
                    this.f4981b = min;
                    this.f4985f.e();
                    if (!this.f4984e.c()) {
                        d2 = this.f4984e.e();
                    }
                    this.f4984e.a(min, z2);
                    if (!z2) {
                        this.f4983d.a(min);
                        return;
                    }
                    double d3 = (double) min;
                    Double.isNaN(d3);
                    if (Math.abs(d3 - d2) > 3.0d) {
                        this.f4983d.a(d3 > d2 ? min - 3 : min + 3);
                        RecyclerView recyclerView = this.f4983d;
                        recyclerView.post(new j(min, recyclerView));
                        return;
                    }
                    this.f4983d.c(min);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f4990k.x() == 1;
    }

    public boolean c() {
        return this.f4995p.a();
    }

    public boolean canScrollHorizontally(int i2) {
        return this.f4983d.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.f4983d.canScrollVertically(i2);
    }

    public boolean d() {
        return this.f4999t;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).f5005a;
            sparseArray.put(this.f4983d.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        g();
    }

    public void e() {
        if (this.f4996q.a() != null) {
            double e2 = this.f4984e.e();
            int i2 = (int) e2;
            double d2 = (double) i2;
            Double.isNaN(d2);
            float f2 = (float) (e2 - d2);
            this.f4996q.a(i2, f2, Math.round(((float) getPageSize()) * f2));
        }
    }

    public CharSequence getAccessibilityClassName() {
        return this.f4985f.a() ? this.f4985f.b() : super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f4983d.getAdapter();
    }

    public int getCurrentItem() {
        return this.f4981b;
    }

    public int getItemDecorationCount() {
        return this.f4983d.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f5000u;
    }

    public int getOrientation() {
        return this.f4990k.h();
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int i2;
        int i3;
        RecyclerView recyclerView = this.f4983d;
        if (getOrientation() == 0) {
            i2 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i3 = recyclerView.getPaddingRight();
        } else {
            i2 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i3 = recyclerView.getPaddingBottom();
        }
        return i2 - i3;
    }

    public int getScrollState() {
        return this.f4984e.b();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f4985f.a(accessibilityNodeInfo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f4983d.getMeasuredWidth();
        int measuredHeight = this.f4983d.getMeasuredHeight();
        this.f4986g.left = getPaddingLeft();
        this.f4986g.right = (i4 - i2) - getPaddingRight();
        this.f4986g.top = getPaddingTop();
        this.f4986g.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.f4986g, this.f4987h);
        this.f4983d.layout(this.f4987h.left, this.f4987h.top, this.f4987h.right, this.f4987h.bottom);
        if (this.f4982c) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        measureChild(this.f4983d, i2, i3);
        int measuredWidth = this.f4983d.getMeasuredWidth();
        int measuredHeight = this.f4983d.getMeasuredHeight();
        int measuredState = this.f4983d.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4991l = savedState.f5006b;
        this.f4992m = savedState.f5007c;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f5005a = this.f4983d.getId();
        int i2 = this.f4991l;
        if (i2 == -1) {
            i2 = this.f4981b;
        }
        savedState.f5006b = i2;
        Parcelable parcelable = this.f4992m;
        if (parcelable == null) {
            RecyclerView.Adapter adapter = this.f4983d.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.c) {
                parcelable = ((androidx.viewpager2.adapter.c) adapter).b();
            }
            return savedState;
        }
        savedState.f5007c = parcelable;
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.f4985f.a(i2, bundle) ? this.f4985f.b(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f4983d.getAdapter();
        this.f4985f.b((RecyclerView.Adapter<?>) adapter2);
        b(adapter2);
        this.f4983d.setAdapter(adapter);
        this.f4981b = 0;
        g();
        this.f4985f.a((RecyclerView.Adapter<?>) adapter);
        a(adapter);
    }

    public void setCurrentItem(int i2) {
        a(i2, true);
    }

    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.f4985f.g();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.f5000u = i2;
            this.f4983d.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.f4990k.b(i2);
        this.f4985f.d();
    }

    public void setPageTransformer(g gVar) {
        boolean z2 = this.f4998s;
        if (gVar != null) {
            if (!z2) {
                this.f4997r = this.f4983d.getItemAnimator();
                this.f4998s = true;
            }
            this.f4983d.setItemAnimator((RecyclerView.e) null);
        } else if (z2) {
            this.f4983d.setItemAnimator(this.f4997r);
            this.f4997r = null;
            this.f4998s = false;
        }
        if (gVar != this.f4996q.a()) {
            this.f4996q.a(gVar);
            e();
        }
    }

    public void setUserInputEnabled(boolean z2) {
        this.f4999t = z2;
        this.f4985f.f();
    }
}
