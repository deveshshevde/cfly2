package it.sephiroth.android.library.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;

public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int V = 0;
    protected int W;

    /* renamed from: a  reason: collision with root package name */
    private int f29272a;

    /* renamed from: aa  reason: collision with root package name */
    protected int f29273aa;

    /* renamed from: ab  reason: collision with root package name */
    protected long f29274ab = Long.MIN_VALUE;

    /* renamed from: ac  reason: collision with root package name */
    protected long f29275ac;

    /* renamed from: ad  reason: collision with root package name */
    protected boolean f29276ad = false;

    /* renamed from: ae  reason: collision with root package name */
    int f29277ae;

    /* renamed from: af  reason: collision with root package name */
    protected boolean f29278af = false;

    /* renamed from: ag  reason: collision with root package name */
    e f29279ag;

    /* renamed from: ah  reason: collision with root package name */
    c f29280ah;

    /* renamed from: ai  reason: collision with root package name */
    d f29281ai;

    /* renamed from: aj  reason: collision with root package name */
    public boolean f29282aj;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: ak  reason: collision with root package name */
    protected int f29283ak = -1;

    /* renamed from: al  reason: collision with root package name */
    protected long f29284al = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: am  reason: collision with root package name */
    protected int f29285am = -1;

    /* renamed from: an  reason: collision with root package name */
    protected long f29286an = Long.MIN_VALUE;
    @ViewDebug.ExportedProperty(category = "list")

    /* renamed from: ao  reason: collision with root package name */
    protected int f29287ao;

    /* renamed from: ap  reason: collision with root package name */
    protected int f29288ap;

    /* renamed from: aq  reason: collision with root package name */
    AccessibilityManager f29289aq;

    /* renamed from: ar  reason: collision with root package name */
    protected int f29290ar = -1;

    /* renamed from: as  reason: collision with root package name */
    protected long f29291as = Long.MIN_VALUE;

    /* renamed from: at  reason: collision with root package name */
    protected boolean f29292at = false;

    /* renamed from: b  reason: collision with root package name */
    private View f29293b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f29294c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29295d;

    /* renamed from: e  reason: collision with root package name */
    private AdapterView<T>.f f29296e;

    public interface c {
        void a(AdapterView<?> adapterView, View view, int i2, long j2);
    }

    public interface d {
        boolean b(AdapterView<?> adapterView, View view, int i2, long j2);
    }

    public static class a implements ContextMenu.ContextMenuInfo {

        /* renamed from: a  reason: collision with root package name */
        public View f29297a;

        /* renamed from: b  reason: collision with root package name */
        public int f29298b;

        /* renamed from: c  reason: collision with root package name */
        public long f29299c;

        public a(View view, int i2, long j2) {
            this.f29297a = view;
            this.f29298b = i2;
            this.f29299c = j2;
        }
    }

    class b extends DataSetObserver {

        /* renamed from: a  reason: collision with root package name */
        private Parcelable f29300a = null;

        b() {
        }

        public void onChanged() {
            Log.i("View", "onChanged");
            AdapterView.this.f29282aj = true;
            AdapterView adapterView = AdapterView.this;
            adapterView.f29288ap = adapterView.f29287ao;
            AdapterView adapterView2 = AdapterView.this;
            adapterView2.f29287ao = adapterView2.getAdapter().getCount();
            if (!AdapterView.this.getAdapter().hasStableIds() || this.f29300a == null || AdapterView.this.f29288ap != 0 || AdapterView.this.f29287ao <= 0) {
                Log.d("View", "else calling rememberSyncState");
                AdapterView.this.w();
            } else {
                Log.d("View", "calling onRestoreInstanceState");
                AdapterView.this.onRestoreInstanceState(this.f29300a);
                this.f29300a = null;
            }
            AdapterView.this.s();
            AdapterView.this.requestLayout();
        }

        public void onInvalidated() {
            Log.i("View", "onInvalidated");
            AdapterView.this.f29282aj = true;
            if (AdapterView.this.getAdapter().hasStableIds()) {
                this.f29300a = AdapterView.this.onSaveInstanceState();
            }
            AdapterView adapterView = AdapterView.this;
            adapterView.f29288ap = adapterView.f29287ao;
            AdapterView.this.f29287ao = 0;
            AdapterView.this.f29285am = -1;
            AdapterView.this.f29286an = Long.MIN_VALUE;
            AdapterView.this.f29283ak = -1;
            AdapterView.this.f29284al = Long.MIN_VALUE;
            AdapterView.this.f29276ad = false;
            AdapterView.this.s();
            AdapterView.this.requestLayout();
        }
    }

    public interface e {
        void a(AdapterView<?> adapterView);

        void a(AdapterView<?> adapterView, View view, int i2, long j2);
    }

    private class f implements Runnable {
        private f() {
        }

        public void run() {
            if (!AdapterView.this.f29282aj) {
                AdapterView.this.a();
                AdapterView.this.b();
            } else if (AdapterView.this.getAdapter() != null) {
                AdapterView.this.post(this);
            }
        }
    }

    public AdapterView(Context context) {
        super(context);
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdapterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f29289aq = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.f29279ag != null) {
            int selectedItemPosition = getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                this.f29279ag.a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
                return;
            }
            this.f29279ag.a(this);
        }
    }

    private void a(boolean z2) {
        if (r()) {
            z2 = false;
        }
        if (z2) {
            View view = this.f29293b;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f29282aj) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.f29293b;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f29289aq.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    private boolean c() {
        int count;
        Adapter adapter = getAdapter();
        if (adapter == null || (count = adapter.getCount()) <= 0) {
            return false;
        }
        return getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count - 1;
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
                return this.V + i2;
            }
        }
        return -1;
    }

    public boolean a(View view, int i2, long j2) {
        if (this.f29280ah == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.f29280ah.a(this, view, i2, j2);
        return true;
    }

    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    public void addView(View view, int i2) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    /* access modifiers changed from: protected */
    public int b(int i2, boolean z2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.f29287ao > 0;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public Object f(int i2) {
        Adapter adapter = getAdapter();
        if (adapter == null || i2 < 0) {
            return null;
        }
        return adapter.getItem(i2);
    }

    public long g(int i2) {
        Adapter adapter = getAdapter();
        if (adapter == null || i2 < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i2);
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.f29287ao;
    }

    public View getEmptyView() {
        return this.f29293b;
    }

    public int getFirstVisiblePosition() {
        return this.V;
    }

    public int getLastVisiblePosition() {
        return (this.V + getChildCount()) - 1;
    }

    public final c getOnItemClickListener() {
        return this.f29280ah;
    }

    public final d getOnItemLongClickListener() {
        return this.f29281ai;
    }

    public final e getOnItemSelectedListener() {
        return this.f29279ag;
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
        return this.f29284al;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.f29283ak;
    }

    public abstract View getSelectedView();

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f29296e);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AdapterView.class.getName());
        accessibilityEvent.setScrollable(c());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AdapterView.class.getName());
        accessibilityNodeInfo.setScrollable(c());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f29272a = getWidth();
    }

    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            return false;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(obtain);
        view.dispatchPopulateAccessibilityEvent(obtain);
        accessibilityEvent.appendRecord(obtain);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q() {
        /*
            r5 = this;
            int r0 = r5.f29287ao
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0040
            boolean r3 = r5.f29276ad
            if (r3 == 0) goto L_0x001d
            r5.f29276ad = r2
            int r3 = r5.v()
            if (r3 < 0) goto L_0x001d
            int r4 = r5.b(r3, r1)
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
            int r0 = r5.b(r4, r1)
            if (r0 >= 0) goto L_0x0035
            int r0 = r5.b(r4, r2)
        L_0x0035:
            if (r0 < 0) goto L_0x003e
            r5.setNextSelectedPositionInt(r0)
            r5.u()
            goto L_0x0041
        L_0x003e:
            r1 = r3
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            if (r1 != 0) goto L_0x0053
            r0 = -1
            r5.f29285am = r0
            r3 = -9223372036854775808
            r5.f29286an = r3
            r5.f29283ak = r0
            r5.f29284al = r3
            r5.f29276ad = r2
            r5.u()
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AdapterView.q():void");
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return false;
    }

    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    public void removeViewAt(int i2) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    /* access modifiers changed from: protected */
    public void s() {
        Adapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = !(adapter == null || adapter.getCount() == 0) || r();
        super.setFocusableInTouchMode(z3 && this.f29295d);
        super.setFocusable(z3 && this.f29294c);
        if (this.f29293b != null) {
            if (adapter == null || adapter.isEmpty()) {
                z2 = true;
            }
            a(z2);
        }
    }

    public abstract void setAdapter(T t2);

    public void setEmptyView(View view) {
        this.f29293b = view;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 16 && view != null && view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        Adapter adapter = getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            z2 = false;
        }
        a(z2);
    }

    public void setFocusable(boolean z2) {
        Adapter adapter = getAdapter();
        boolean z3 = true;
        boolean z4 = adapter == null || adapter.getCount() == 0;
        this.f29294c = z2;
        if (!z2) {
            this.f29295d = false;
        }
        if (!z2 || (z4 && !r())) {
            z3 = false;
        }
        super.setFocusable(z3);
    }

    public void setFocusableInTouchMode(boolean z2) {
        Adapter adapter = getAdapter();
        boolean z3 = false;
        boolean z4 = adapter == null || adapter.getCount() == 0;
        this.f29295d = z2;
        if (z2) {
            this.f29294c = true;
        }
        if (z2 && (!z4 || r())) {
            z3 = true;
        }
        super.setFocusableInTouchMode(z3);
    }

    /* access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i2) {
        this.f29283ak = i2;
        long g2 = g(i2);
        this.f29284al = g2;
        if (this.f29276ad && this.f29277ae == 0 && i2 >= 0) {
            this.f29273aa = i2;
            this.f29274ab = g2;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(c cVar) {
        this.f29280ah = cVar;
    }

    public void setOnItemLongClickListener(d dVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f29281ai = dVar;
    }

    public void setOnItemSelectedListener(e eVar) {
        this.f29279ag = eVar;
    }

    /* access modifiers changed from: protected */
    public void setSelectedPositionInt(int i2) {
        this.f29285am = i2;
        this.f29286an = g(i2);
    }

    public abstract void setSelection(int i2);

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.f29279ag == null && !this.f29289aq.isEnabled()) {
            return;
        }
        if (this.f29278af || this.f29292at) {
            if (this.f29296e == null) {
                this.f29296e = new f();
            }
            post(this.f29296e);
            return;
        }
        a();
        b();
    }

    /* access modifiers changed from: protected */
    public void u() {
        if (this.f29285am != this.f29290ar || this.f29286an != this.f29291as) {
            t();
            this.f29290ar = this.f29285am;
            this.f29291as = this.f29286an;
        }
    }

    /* access modifiers changed from: package-private */
    public int v() {
        int i2 = this.f29287ao;
        if (i2 == 0) {
            return -1;
        }
        long j2 = this.f29274ab;
        int i3 = this.f29273aa;
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

    public void w() {
        if (getChildCount() > 0) {
            this.f29276ad = true;
            this.f29275ac = (long) this.f29272a;
            int i2 = this.f29285am;
            if (i2 >= 0) {
                View childAt = getChildAt(i2 - this.V);
                this.f29274ab = this.f29284al;
                this.f29273aa = this.f29283ak;
                if (childAt != null) {
                    this.W = childAt.getLeft();
                }
                this.f29277ae = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapter = getAdapter();
            int i3 = this.V;
            this.f29274ab = (i3 < 0 || i3 >= adapter.getCount()) ? -1 : adapter.getItemId(this.V);
            this.f29273aa = this.V;
            if (childAt2 != null) {
                this.W = childAt2.getLeft();
            }
            this.f29277ae = 1;
        }
    }
}
