package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

public abstract class CarouselAdapter<T extends Adapter> extends ViewGroup {
    @ViewDebug.ExportedProperty

    /* renamed from: a  reason: collision with root package name */
    int f25466a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f25467b;

    /* renamed from: c  reason: collision with root package name */
    int f25468c;

    /* renamed from: d  reason: collision with root package name */
    long f25469d = Long.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    long f25470e;

    /* renamed from: f  reason: collision with root package name */
    boolean f25471f = false;

    /* renamed from: g  reason: collision with root package name */
    int f25472g;

    /* renamed from: h  reason: collision with root package name */
    boolean f25473h = false;

    /* renamed from: i  reason: collision with root package name */
    e f25474i;

    /* renamed from: j  reason: collision with root package name */
    c f25475j;

    /* renamed from: k  reason: collision with root package name */
    d f25476k;

    /* renamed from: l  reason: collision with root package name */
    boolean f25477l;
    @ViewDebug.ExportedProperty

    /* renamed from: m  reason: collision with root package name */
    int f25478m = -1;

    /* renamed from: n  reason: collision with root package name */
    long f25479n = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty

    /* renamed from: o  reason: collision with root package name */
    int f25480o = -1;

    /* renamed from: p  reason: collision with root package name */
    long f25481p = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty

    /* renamed from: q  reason: collision with root package name */
    int f25482q;

    /* renamed from: r  reason: collision with root package name */
    int f25483r;

    /* renamed from: s  reason: collision with root package name */
    int f25484s = -1;

    /* renamed from: t  reason: collision with root package name */
    long f25485t = Long.MIN_VALUE;

    /* renamed from: u  reason: collision with root package name */
    boolean f25486u = false;

    /* renamed from: v  reason: collision with root package name */
    private int f25487v;

    /* renamed from: w  reason: collision with root package name */
    private View f25488w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f25489x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f25490y;

    /* renamed from: z  reason: collision with root package name */
    private CarouselAdapter<T>.f f25491z;

    public static class a implements ContextMenu.ContextMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public View f25492a;

        /* renamed from: b  reason: collision with root package name */
        public int f25493b;

        /* renamed from: c  reason: collision with root package name */
        public long f25494c;

        public a(View view, int i2, long j2) {
            this.f25492a = view;
            this.f25493b = i2;
            this.f25494c = j2;
        }
    }

    class b extends DataSetObserver {

        /* renamed from: b  reason: collision with root package name */
        private Parcelable f25496b = null;

        b() {
        }

        public void onChanged() {
            CarouselAdapter.this.f25477l = true;
            CarouselAdapter carouselAdapter = CarouselAdapter.this;
            carouselAdapter.f25483r = carouselAdapter.f25482q;
            CarouselAdapter carouselAdapter2 = CarouselAdapter.this;
            carouselAdapter2.f25482q = carouselAdapter2.getAdapter().getCount();
            if (!CarouselAdapter.this.getAdapter().hasStableIds() || this.f25496b == null || CarouselAdapter.this.f25483r != 0 || CarouselAdapter.this.f25482q <= 0) {
                CarouselAdapter.this.g();
            } else {
                CarouselAdapter.this.onRestoreInstanceState(this.f25496b);
                this.f25496b = null;
            }
            CarouselAdapter.this.b();
            CarouselAdapter.this.requestLayout();
        }

        public void onInvalidated() {
            CarouselAdapter.this.f25477l = true;
            if (CarouselAdapter.this.getAdapter().hasStableIds()) {
                this.f25496b = CarouselAdapter.this.onSaveInstanceState();
            }
            CarouselAdapter carouselAdapter = CarouselAdapter.this;
            carouselAdapter.f25483r = carouselAdapter.f25482q;
            CarouselAdapter.this.f25482q = 0;
            CarouselAdapter.this.f25480o = -1;
            CarouselAdapter.this.f25481p = Long.MIN_VALUE;
            CarouselAdapter.this.f25478m = -1;
            CarouselAdapter.this.f25479n = Long.MIN_VALUE;
            CarouselAdapter.this.f25471f = false;
            CarouselAdapter.this.e();
            CarouselAdapter.this.b();
            CarouselAdapter.this.requestLayout();
        }
    }

    public interface c {
        void a(CarouselAdapter<?> carouselAdapter, View view, int i2, long j2);
    }

    public interface d {
        boolean a(CarouselAdapter<?> carouselAdapter, View view, int i2, long j2);
    }

    public interface e {
        void a(CarouselAdapter<?> carouselAdapter);

        void a(CarouselAdapter<?> carouselAdapter, View view, int i2, long j2);
    }

    private class f extends Handler implements Runnable {
        private f() {
        }

        public void run() {
            if (CarouselAdapter.this.f25477l) {
                post(this);
            } else {
                CarouselAdapter.this.h();
            }
        }
    }

    public CarouselAdapter(Context context) {
        super(context);
    }

    public CarouselAdapter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CarouselAdapter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void a(boolean z2) {
        if (a()) {
            z2 = false;
        }
        if (z2) {
            View view = this.f25488w;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f25477l) {
                layout(getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.f25488w;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void h() {
        if (this.f25474i != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.f25474i.a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.f25474i.a(this);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, boolean z2) {
        return i2;
    }

    public int a(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
            }
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (getChildAt(i2).equals(view)) {
                return this.f25466a + i2;
            }
        }
        return -1;
    }

    public long a(int i2) {
        Adapter adapter = getAdapter();
        if (adapter == null || i2 < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return false;
    }

    public boolean a(View view, int i2, long j2) {
        if (this.f25475j == null) {
            return false;
        }
        playSoundEffect(0);
        this.f25475j.a(this, view, i2, j2);
        return true;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in CarouselAdapter");
    }

    public void addView(View view, int i2) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in CarouselAdapter");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in CarouselAdapter");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in CarouselAdapter");
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Adapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = !(adapter == null || adapter.getCount() == 0) || a();
        super.setFocusableInTouchMode(z3 && this.f25490y);
        super.setFocusable(z3 && this.f25489x);
        if (this.f25488w != null) {
            if (adapter == null || adapter.isEmpty()) {
                z2 = true;
            }
            a(z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f25474i != null) {
            if (this.f25473h || this.f25486u) {
                if (this.f25491z == null) {
                    this.f25491z = new f();
                }
                CarouselAdapter<T>.f fVar = this.f25491z;
                fVar.post(fVar);
            } else {
                h();
            }
        }
        if (this.f25480o != -1 && isShown() && !isInTouchMode()) {
            sendAccessibilityEvent(4);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.f25482q > 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r5 = this;
            int r0 = r5.f25482q
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0040
            boolean r3 = r5.f25471f
            if (r3 == 0) goto L_0x001d
            r5.f25471f = r2
            int r3 = r5.f()
            if (r3 < 0) goto L_0x001d
            int r4 = r5.a((int) r3, (boolean) r1)
            if (r4 != r3) goto L_0x001d
            r5.setNextSelectedPositionInt(r3)
            r3 = 1
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            if (r3 != 0) goto L_0x003e
            int r4 = r5.getSelectedItemPosition()
            if (r4 < r0) goto L_0x0028
            int r4 = r0 + -1
        L_0x0028:
            if (r4 >= 0) goto L_0x002b
            r4 = 0
        L_0x002b:
            int r0 = r5.a((int) r4, (boolean) r1)
            if (r0 >= 0) goto L_0x0035
            int r0 = r5.a((int) r4, (boolean) r2)
        L_0x0035:
            if (r0 < 0) goto L_0x003e
            r5.setNextSelectedPositionInt(r0)
            r5.e()
            goto L_0x0041
        L_0x003e:
            r1 = r3
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            if (r1 != 0) goto L_0x0053
            r0 = -1
            r5.f25480o = r0
            r3 = -9223372036854775808
            r5.f25481p = r3
            r5.f25478m = r0
            r5.f25479n = r3
            r5.f25471f = r2
            r5.e()
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.widgets.CarouselView.CarouselAdapter.d():void");
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 8) {
            accessibilityEvent.setEventType(4);
        }
        View selectedView = getSelectedView();
        boolean dispatchPopulateAccessibilityEvent = selectedView != null ? selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent) : false;
        if (!dispatchPopulateAccessibilityEvent) {
            if (selectedView != null) {
                accessibilityEvent.setEnabled(selectedView.isEnabled());
            }
            accessibilityEvent.setItemCount(getCount());
            accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        }
        return dispatchPopulateAccessibilityEvent;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f25480o != this.f25484s || this.f25481p != this.f25485t) {
            c();
            this.f25484s = this.f25480o;
            this.f25485t = this.f25481p;
        }
    }

    /* access modifiers changed from: package-private */
    public int f() {
        int i2 = this.f25482q;
        if (i2 == 0) {
            return -1;
        }
        long j2 = this.f25469d;
        int i3 = this.f25468c;
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        int i4 = i2 - 1;
        int min = Math.min(i4, Math.max(0, i3));
        long uptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i5 = min;
        int i6 = i5;
        loop0:
        while (true) {
            boolean z2 = false;
            while (SystemClock.uptimeMillis() <= uptimeMillis) {
                if (adapter.getItemId(min) != j2) {
                    boolean z3 = i5 == i4;
                    boolean z4 = i6 == 0;
                    if (z3 && z4) {
                        break loop0;
                    } else if (z4 || (z2 && !z3)) {
                        i5++;
                        min = i5;
                    } else if (z3 || (!z2 && !z4)) {
                        i6--;
                        min = i6;
                        z2 = true;
                    }
                } else {
                    return min;
                }
            }
            break loop0;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (getChildCount() > 0) {
            this.f25471f = true;
            this.f25470e = (long) this.f25487v;
            int i2 = this.f25480o;
            if (i2 >= 0) {
                View childAt = getChildAt(i2 - this.f25466a);
                this.f25469d = this.f25479n;
                this.f25468c = this.f25478m;
                if (childAt != null) {
                    this.f25467b = childAt.getTop();
                }
                this.f25472g = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapter = getAdapter();
            int i3 = this.f25466a;
            this.f25469d = (i3 < 0 || i3 >= adapter.getCount()) ? -1 : adapter.getItemId(this.f25466a);
            this.f25468c = this.f25466a;
            if (childAt2 != null) {
                this.f25467b = childAt2.getTop();
            }
            this.f25472g = 1;
        }
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.f25482q;
    }

    public View getEmptyView() {
        return this.f25488w;
    }

    public int getFirstVisiblePosition() {
        return this.f25466a;
    }

    public int getLastVisiblePosition() {
        return (this.f25466a + getChildCount()) - 1;
    }

    public final c getOnItemClickListener() {
        return this.f25475j;
    }

    public final d getOnItemLongClickListener() {
        return this.f25476k;
    }

    public final e getOnItemSelectedListener() {
        return this.f25474i;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.f25479n;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.f25478m;
    }

    public abstract View getSelectedView();

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f25487v = getHeight();
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in CarouselAdapter");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in CarouselAdapter");
    }

    public void removeViewAt(int i2) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in CarouselAdapter");
    }

    public abstract void setAdapter(T t2);

    public void setEmptyView(View view) {
        this.f25488w = view;
        Adapter adapter = getAdapter();
        a(adapter == null || adapter.isEmpty());
    }

    public void setFocusable(boolean z2) {
        Adapter adapter = getAdapter();
        boolean z3 = true;
        boolean z4 = adapter == null || adapter.getCount() == 0;
        this.f25489x = z2;
        if (!z2) {
            this.f25490y = false;
        }
        if (!z2 || (z4 && !a())) {
            z3 = false;
        }
        super.setFocusable(z3);
    }

    public void setFocusableInTouchMode(boolean z2) {
        Adapter adapter = getAdapter();
        boolean z3 = false;
        boolean z4 = adapter == null || adapter.getCount() == 0;
        this.f25490y = z2;
        if (z2) {
            this.f25489x = true;
        }
        if (z2 && (!z4 || a())) {
            z3 = true;
        }
        super.setFocusableInTouchMode(z3);
    }

    /* access modifiers changed from: package-private */
    public void setNextSelectedPositionInt(int i2) {
        this.f25478m = i2;
        long a2 = a(i2);
        this.f25479n = a2;
        if (this.f25471f && this.f25472g == 0 && i2 >= 0) {
            this.f25468c = i2;
            this.f25469d = a2;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an CarouselAdapter. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(c cVar) {
        this.f25475j = cVar;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f25476k = dVar;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.f25474i = eVar;
    }

    /* access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i2) {
        this.f25480o = i2;
        this.f25481p = a(i2);
    }

    public abstract void setSelection(int i2);
}
