package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.core.widget.f;
import com.blankj.utilcode.constant.MemoryConstants;
import d.c;
import java.lang.reflect.Field;
import t.ag;

class r extends ListView {

    /* renamed from: a  reason: collision with root package name */
    b f1552a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f1553b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private int f1554c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1555d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1556e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1557f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f1558g;

    /* renamed from: h  reason: collision with root package name */
    private Field f1559h;

    /* renamed from: i  reason: collision with root package name */
    private a f1560i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1561j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1562k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1563l;

    /* renamed from: m  reason: collision with root package name */
    private ag f1564m;

    /* renamed from: n  reason: collision with root package name */
    private f f1565n;

    private static class a extends c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1566a = true;

        a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z2) {
            this.f1566a = z2;
        }

        public void draw(Canvas canvas) {
            if (this.f1566a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f2, float f3) {
            if (this.f1566a) {
                super.setHotspot(f2, f3);
            }
        }

        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f1566a) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f1566a) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f1566a) {
                return super.setVisible(z2, z3);
            }
            return false;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void a() {
            r.this.f1552a = null;
            r.this.removeCallbacks(this);
        }

        public void b() {
            r.this.post(this);
        }

        public void run() {
            r.this.f1552a = null;
            r.this.drawableStateChanged();
        }
    }

    r(Context context, boolean z2) {
        super(context, (AttributeSet) null, R.attr.dropDownListViewStyle);
        this.f1562k = z2;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1559h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    private void a() {
        Drawable selector = getSelector();
        if (selector != null && c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void a(int i2, View view) {
        Drawable selector = getSelector();
        boolean z2 = true;
        boolean z3 = (selector == null || i2 == -1) ? false : true;
        if (z3) {
            selector.setVisible(false, false);
        }
        b(i2, view);
        if (z3) {
            Rect rect = this.f1553b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z2 = false;
            }
            selector.setVisible(z2, false);
            androidx.core.graphics.drawable.a.a(selector, exactCenterX, exactCenterY);
        }
    }

    private void a(int i2, View view, float f2, float f3) {
        a(i2, view);
        Drawable selector = getSelector();
        if (selector != null && i2 != -1) {
            androidx.core.graphics.drawable.a.a(selector, f2, f3);
        }
    }

    private void a(Canvas canvas) {
        Drawable selector;
        if (!this.f1553b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1553b);
            selector.draw(canvas);
        }
    }

    private void a(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void a(View view, int i2, float f2, float f3) {
        View childAt;
        this.f1563l = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f2, f3);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f1558g;
        if (!(i3 == -1 || (childAt = getChildAt(i3 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1558g = i2;
        float left = f2 - ((float) view.getLeft());
        float top = f3 - ((float) view.getTop());
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        a(i2, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void b() {
        this.f1563l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1558g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ag agVar = this.f1564m;
        if (agVar != null) {
            agVar.b();
            this.f1564m = null;
        }
    }

    private void b(int i2, View view) {
        Rect rect = this.f1553b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1554c;
        rect.top -= this.f1555d;
        rect.right += this.f1556e;
        rect.bottom += this.f1557f;
        try {
            boolean z2 = this.f1559h.getBoolean(this);
            if (view.isEnabled() != z2) {
                this.f1559h.set(this, Boolean.valueOf(!z2));
                if (i2 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    private boolean c() {
        return this.f1563l;
    }

    private void setSelectorEnabled(boolean z2) {
        a aVar = this.f1560i;
        if (aVar != null) {
            aVar.a(z2);
        }
    }

    public int a(int i2, int i3, int i4, int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        int i7 = listPaddingTop + listPaddingBottom;
        if (adapter == null) {
            return i7;
        }
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i2, layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec(layoutParams.height, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                i7 += dividerHeight;
            }
            i7 += view.getMeasuredHeight();
            if (i7 >= i5) {
                return (i6 < 0 || i8 <= i6 || i10 <= 0 || i7 == i5) ? i5 : i10;
            }
            if (i6 >= 0 && i8 >= i6) {
                i10 = i7;
            }
            i8++;
        }
        return i7;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = 0
            r3 = 1
            goto L_0x0046
        L_0x0011:
            r9 = 0
            r3 = 0
            goto L_0x0046
        L_0x0014:
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = 1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.a((android.view.View) r3, (int) r5, (float) r4, (float) r9)
            if (r0 != r2) goto L_0x000e
            r7.a((android.view.View) r3, (int) r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.b()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.f r9 = r7.f1565n
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f1565n = r9
        L_0x005a:
            androidx.core.widget.f r9 = r7.f1565n
            r9.a((boolean) r2)
            androidx.core.widget.f r9 = r7.f1565n
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.f r8 = r7.f1565n
            if (r8 == 0) goto L_0x006c
            r8.a((boolean) r1)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r.a(android.view.MotionEvent, int):boolean");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        a(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1552a == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            a();
        }
    }

    public boolean hasFocus() {
        return this.f1562k || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1562k || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1562k || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1562k && this.f1561j) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1552a = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1552a == null) {
            b bVar = new b();
            this.f1552a = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                a();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1558g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f1552a;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z2) {
        this.f1561j = z2;
    }

    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f1560i = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1554c = rect.left;
        this.f1555d = rect.top;
        this.f1556e = rect.right;
        this.f1557f = rect.bottom;
    }
}
