package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.RemoteViews;
import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import it.sephiroth.android.library.R;
import it.sephiroth.android.library.widget.AbsHListView;
import java.util.ArrayList;

@RemoteViews.RemoteView
public class HListView extends AbsHListView {
    private ArrayList<b> aA;
    private boolean aB;
    private boolean aC;
    private boolean aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private final Rect aH;
    private Paint aI;
    private final a aJ;
    private c aK;

    /* renamed from: au  reason: collision with root package name */
    Drawable f29303au;

    /* renamed from: av  reason: collision with root package name */
    int f29304av;

    /* renamed from: aw  reason: collision with root package name */
    int f29305aw;

    /* renamed from: ax  reason: collision with root package name */
    Drawable f29306ax;

    /* renamed from: ay  reason: collision with root package name */
    Drawable f29307ay;

    /* renamed from: az  reason: collision with root package name */
    private ArrayList<b> f29308az;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f29309a;

        /* renamed from: b  reason: collision with root package name */
        private int f29310b;

        private a() {
        }

        public int a() {
            return this.f29309a;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.f29309a = i2;
            this.f29310b = i3;
        }

        public int b() {
            return this.f29310b;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public View f29311a;

        /* renamed from: b  reason: collision with root package name */
        public Object f29312b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29313c;
    }

    private class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f29315b;

        /* renamed from: c  reason: collision with root package name */
        private int f29316c;

        private c() {
        }

        public c a(int i2, int i3) {
            this.f29315b = i2;
            this.f29316c = i3;
            return this;
        }

        public void run() {
            HListView.this.e(this.f29315b, this.f29316c);
        }
    }

    public HListView(Context context) {
        this(context, (AttributeSet) null);
    }

    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sephiroth_listViewStyle);
    }

    public HListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29308az = new ArrayList<>();
        this.aA = new ArrayList<>();
        this.aF = true;
        this.aG = false;
        this.aH = new Rect();
        this.aJ = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HListView, i2, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(R.styleable.HListView_android_entries);
        if (textArray != null) {
            setAdapter((ListAdapter) new ArrayAdapter(context, 17367043, textArray));
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.HListView_android_divider);
        if (drawable != null) {
            setDivider(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.HListView_overScrollHeader);
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.HListView_overScrollFooter);
        if (drawable3 != null) {
            setOverscrollFooter(drawable3);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.HListView_dividerWidth, 0);
        if (dimensionPixelSize != 0) {
            setDividerWidth(dimensionPixelSize);
        }
        this.aD = obtainStyledAttributes.getBoolean(R.styleable.HListView_headerDividersEnabled, true);
        this.aE = obtainStyledAttributes.getBoolean(R.styleable.HListView_footerDividersEnabled, true);
        this.f29305aw = obtainStyledAttributes.getInteger(R.styleable.HListView_measureWithChild, -1);
        Log.d("HListView", "mMeasureWithChild: " + this.f29305aw);
        obtainStyledAttributes.recycle();
    }

    private boolean A() {
        int childCount = getChildCount();
        return (this.V + childCount) - 1 < this.f29287ao - 1 || getChildAt(childCount + -1).getRight() < (getScrollX() + getWidth()) - this.f29216u.right;
    }

    private int a(int i2, View view, int i3) {
        int i4;
        view.getDrawingRect(this.aH);
        offsetDescendantRectToMyCoords(view, this.aH);
        if (i2 == 33) {
            if (this.aH.left < this.f29216u.left) {
                i4 = this.f29216u.left - this.aH.left;
                if (i3 <= 0) {
                    return i4;
                }
            }
            return 0;
        }
        int width = getWidth() - this.f29216u.right;
        if (this.aH.bottom > width) {
            i4 = this.aH.right - width;
            if (i3 >= this.f29287ao - 1) {
                return i4;
            }
        }
        return 0;
        return i4 + getArrowScrollPreviewLength();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(int r9, int r10, int r11) {
        /*
            r8 = this;
            int r0 = r8.getHorizontalFadingEdgeLength()
            int r7 = r8.f29285am
            int r10 = r8.c(r10, r0, r7)
            int r11 = r8.b((int) r11, (int) r0, (int) r7)
            android.graphics.Rect r0 = r8.f29216u
            int r5 = r0.top
            r4 = 1
            r6 = 1
            r1 = r8
            r2 = r7
            r3 = r9
            android.view.View r9 = r1.a((int) r2, (int) r3, (boolean) r4, (int) r5, (boolean) r6)
            int r0 = r9.getRight()
            if (r0 <= r11) goto L_0x0034
            int r0 = r9.getLeft()
            int r0 = r0 - r10
            int r10 = r9.getRight()
            int r10 = r10 - r11
            int r10 = java.lang.Math.min(r0, r10)
            int r10 = -r10
        L_0x0030:
            r9.offsetLeftAndRight(r10)
            goto L_0x0049
        L_0x0034:
            int r0 = r9.getLeft()
            if (r0 >= r10) goto L_0x0049
            int r0 = r9.getLeft()
            int r10 = r10 - r0
            int r0 = r9.getRight()
            int r11 = r11 - r0
            int r10 = java.lang.Math.min(r10, r11)
            goto L_0x0030
        L_0x0049:
            r8.a((android.view.View) r9, (int) r7)
            boolean r10 = r8.K
            if (r10 != 0) goto L_0x0058
            int r10 = r8.getChildCount()
            r8.l(r10)
            goto L_0x005f
        L_0x0058:
            int r10 = r8.getChildCount()
            r8.m(r10)
        L_0x005f:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.a(int, int, int):android.view.View");
    }

    private View a(int i2, int i3, boolean z2, int i4, boolean z3) {
        View a2;
        boolean z4;
        if (this.f29282aj || (a2 = this.f29211p.c(i2)) == null) {
            a2 = a(i2, this.P);
            z4 = this.P[0];
        } else {
            z4 = true;
        }
        a(a2, i2, i3, z2, i4, z3, z4);
        return a2;
    }

    private View a(View view, View view2, int i2, int i3, int i4) {
        View view3;
        boolean z2;
        int i5;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i6 = this.f29285am;
        int c2 = c(i3, horizontalFadingEdgeLength, i6);
        int b2 = b(i3, horizontalFadingEdgeLength, i6);
        if (i2 > 0) {
            View a2 = a(i6 - 1, view.getLeft(), true, this.f29216u.top, false);
            int i7 = this.f29304av;
            view3 = a(i6, a2.getRight() + i7, true, this.f29216u.top, true);
            if (view3.getRight() > b2) {
                int i8 = -Math.min(Math.min(view3.getLeft() - c2, view3.getRight() - b2), (i4 - i3) / 2);
                a2.offsetLeftAndRight(i8);
                view3.offsetLeftAndRight(i8);
            }
            if (!this.K) {
                g(this.f29285am - 2, view3.getLeft() - i7);
                y();
                f(this.f29285am + 1, view3.getRight() + i7);
            } else {
                f(this.f29285am + 1, view3.getRight() + i7);
                y();
                g(this.f29285am - 2, view3.getLeft() - i7);
            }
        } else {
            if (i2 < 0) {
                if (view2 != null) {
                    i5 = view2.getLeft();
                    z2 = true;
                } else {
                    i5 = view.getLeft();
                    z2 = false;
                }
                view3 = a(i6, i5, z2, this.f29216u.top, true);
                if (view3.getLeft() < c2) {
                    view3.offsetLeftAndRight(Math.min(Math.min(c2 - view3.getLeft(), b2 - view3.getRight()), (i4 - i3) / 2));
                }
            } else {
                int left = view.getLeft();
                view3 = a(i6, left, true, this.f29216u.top, true);
                if (left < i3 && view3.getRight() < i3 + 20) {
                    view3.offsetLeftAndRight(i3 - view3.getLeft());
                }
            }
            a(view3, i6);
        }
        return view3;
    }

    private void a(View view, int i2) {
        int i3 = this.f29304av;
        if (!this.K) {
            g(i2 - 1, view.getLeft() - i3);
            y();
            f(i2 + 1, view.getRight() + i3);
            return;
        }
        f(i2 + 1, view.getRight() + i3);
        y();
        g(i2 - 1, view.getLeft() - i3);
    }

    private void a(View view, int i2, int i3) {
        AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.f29226a = this.f29205j.getItemViewType(i2);
        layoutParams.f29228c = true;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, this.f29216u.top + this.f29216u.bottom, layoutParams.height);
        int i4 = layoutParams.width;
        view.measure(i4 > 0 ? View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    private void a(View view, int i2, int i3, boolean z2) {
        View view2;
        boolean z3;
        if (i3 != -1) {
            int i4 = this.f29285am - this.V;
            int i5 = i3 - this.V;
            boolean z4 = true;
            if (i2 == 33) {
                z3 = true;
                view2 = view;
                view = getChildAt(i5);
                int i6 = i4;
                i4 = i5;
                i5 = i6;
            } else {
                view2 = getChildAt(i5);
                z3 = false;
            }
            int childCount = getChildCount();
            if (view != null) {
                view.setSelected(!z2 && z3);
                b(view, i4, childCount);
            }
            if (view2 != null) {
                if (z2 || z3) {
                    z4 = false;
                }
                view2.setSelected(z4);
                b(view2, i5, childCount);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("newSelectedPosition needs to be valid");
    }

    private void a(View view, int i2, int i3, boolean z2, int i4, boolean z3, boolean z4) {
        View view2 = view;
        int i5 = i2;
        int i6 = i4;
        boolean z5 = z3 && h();
        boolean z6 = z5 != view.isSelected();
        int i7 = this.F;
        boolean z7 = i7 > 0 && i7 < 3 && this.A == i5;
        boolean z8 = z7 != view.isPressed();
        boolean z9 = !z4 || z6 || view.isLayoutRequested();
        AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
        }
        layoutParams.f29226a = this.f29205j.getItemViewType(i5);
        int i8 = -1;
        if ((!z4 || layoutParams.f29228c) && (!layoutParams.f29227b || layoutParams.f29226a != -2)) {
            layoutParams.f29228c = false;
            if (layoutParams.f29226a == -2) {
                layoutParams.f29227b = true;
            }
            if (!z2) {
                i8 = 0;
            }
            addViewInLayout(view2, i8, layoutParams, true);
        } else {
            if (!z2) {
                i8 = 0;
            }
            attachViewToParent(view2, i8, layoutParams);
        }
        if (z6) {
            view2.setSelected(z5);
        }
        if (z8) {
            view2.setPressed(z7);
        }
        if (!(this.f29193b == 0 || this.f29201f == null)) {
            if (view2 instanceof Checkable) {
                ((Checkable) view2).setChecked(this.f29201f.get(i5));
            } else if (Build.VERSION.SDK_INT >= 11) {
                view2.setActivated(this.f29201f.get(i5));
            }
        }
        if (z9) {
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f29217v, this.f29216u.top + this.f29216u.bottom, layoutParams.height);
            int i9 = layoutParams.width;
            view2.measure(i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = z2 ? i3 : i3 - measuredWidth;
        if (z9) {
            view2.layout(i10, i6, measuredWidth + i10, measuredHeight + i6);
        } else {
            view2.offsetLeftAndRight(i10 - view.getLeft());
            view2.offsetTopAndBottom(i6 - view.getTop());
        }
        if (this.f29220y && !view.isDrawingCacheEnabled()) {
            view2.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT >= 11 && z4 && ((AbsHListView.LayoutParams) view.getLayoutParams()).f29229d != i5) {
            view.jumpDrawablesToCurrentState();
        }
    }

    private void a(ArrayList<b> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) arrayList.get(i2).f29311a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f29227b = false;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        if (r11.hasNoModifiers() != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        r4 = n(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0083, code lost:
        if (i(com.xeagle.android.login.amba.connectivity.IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR) != false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b3, code lost:
        if (i(33) != false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c7, code lost:
        if (i(com.xeagle.android.login.amba.connectivity.IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR) != false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00db, code lost:
        if (i(33) != false) goto L_0x0169;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x016e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r9, int r10, android.view.KeyEvent r11) {
        /*
            r8 = this;
            android.widget.ListAdapter r0 = r8.f29205j
            r1 = 0
            if (r0 == 0) goto L_0x0185
            boolean r0 = r8.S
            if (r0 != 0) goto L_0x000b
            goto L_0x0185
        L_0x000b:
            boolean r0 = r8.f29282aj
            if (r0 == 0) goto L_0x0012
            r8.e()
        L_0x0012:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 11
            if (r0 >= r2) goto L_0x0019
            return r1
        L_0x0019:
            int r0 = r11.getAction()
            r2 = 2
            r3 = 1
            if (r0 == r3) goto L_0x016b
            r4 = 62
            r5 = 33
            r6 = 130(0x82, float:1.82E-43)
            if (r9 == r4) goto L_0x0148
            r4 = 66
            if (r9 == r4) goto L_0x012c
            r7 = 92
            if (r9 == r7) goto L_0x0106
            r7 = 93
            if (r9 == r7) goto L_0x00df
            r7 = 122(0x7a, float:1.71E-43)
            if (r9 == r7) goto L_0x00cb
            r7 = 123(0x7b, float:1.72E-43)
            if (r9 == r7) goto L_0x00b7
            switch(r9) {
                case 19: goto L_0x0087;
                case 20: goto L_0x0057;
                case 21: goto L_0x0049;
                case 22: goto L_0x0042;
                case 23: goto L_0x012c;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x016b
        L_0x0042:
            boolean r5 = r11.hasNoModifiers()
            if (r5 == 0) goto L_0x016b
            goto L_0x0051
        L_0x0049:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x016b
            r4 = 17
        L_0x0051:
            boolean r4 = r8.n(r4)
            goto L_0x016c
        L_0x0057:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x0073
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x016c
        L_0x0063:
            int r5 = r10 + -1
            if (r10 <= 0) goto L_0x0070
            boolean r10 = r8.j(r6)
            if (r10 == 0) goto L_0x0070
            r10 = r5
            r4 = 1
            goto L_0x0063
        L_0x0070:
            r10 = r5
            goto L_0x016c
        L_0x0073:
            boolean r4 = r11.hasModifiers(r2)
            if (r4 == 0) goto L_0x016b
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.i(r6)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x0087:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x00a3
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x016c
        L_0x0093:
            int r6 = r10 + -1
            if (r10 <= 0) goto L_0x00a0
            boolean r10 = r8.j(r5)
            if (r10 == 0) goto L_0x00a0
            r10 = r6
            r4 = 1
            goto L_0x0093
        L_0x00a0:
            r10 = r6
            goto L_0x016c
        L_0x00a3:
            boolean r4 = r11.hasModifiers(r2)
            if (r4 == 0) goto L_0x016b
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.i(r5)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x00b7:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x016b
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.i(r6)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x00cb:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x016b
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.i(r5)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x00df:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x00f3
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.h(r6)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x00f3:
            boolean r4 = r11.hasModifiers(r2)
            if (r4 == 0) goto L_0x016b
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.i(r6)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x0106:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x0119
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.h(r5)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x0119:
            boolean r4 = r11.hasModifiers(r2)
            if (r4 == 0) goto L_0x016b
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.i(r5)
            if (r4 == 0) goto L_0x016b
            goto L_0x0169
        L_0x012c:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x016b
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x016c
            int r5 = r11.getRepeatCount()
            if (r5 != 0) goto L_0x016c
            int r5 = r8.getChildCount()
            if (r5 <= 0) goto L_0x016c
            r8.i()
            goto L_0x0169
        L_0x0148:
            boolean r4 = r11.hasNoModifiers()
            if (r4 == 0) goto L_0x0159
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.h(r6)
            goto L_0x0169
        L_0x0159:
            boolean r4 = r11.hasModifiers(r3)
            if (r4 == 0) goto L_0x0169
            boolean r4 = r8.n()
            if (r4 != 0) goto L_0x0169
            boolean r4 = r8.h(r5)
        L_0x0169:
            r4 = 1
            goto L_0x016c
        L_0x016b:
            r4 = 0
        L_0x016c:
            if (r4 == 0) goto L_0x016f
            return r3
        L_0x016f:
            if (r0 == 0) goto L_0x0180
            if (r0 == r3) goto L_0x017b
            if (r0 == r2) goto L_0x0176
            return r1
        L_0x0176:
            boolean r9 = super.onKeyMultiple(r9, r10, r11)
            return r9
        L_0x017b:
            boolean r9 = super.onKeyUp(r9, r11)
            return r9
        L_0x0180:
            boolean r9 = super.onKeyDown(r9, r11)
            return r9
        L_0x0185:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.a(int, int, android.view.KeyEvent):boolean");
    }

    private boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        return (parent instanceof ViewGroup) && a((View) parent, view2);
    }

    private int b(int i2, int i3, int i4) {
        return i4 != this.f29287ao + -1 ? i2 - i3 : i2;
    }

    private View b(View view, int i2) {
        int i3 = i2 - 1;
        View a2 = a(i3, this.P);
        a(a2, i3, view.getLeft() - this.f29304av, false, this.f29216u.top, false, this.P[0]);
        return a2;
    }

    private void b(View view, int i2, int i3) {
        int width = view.getWidth();
        d(view);
        if (view.getMeasuredWidth() != width) {
            e(view);
            int measuredWidth = view.getMeasuredWidth() - width;
            while (true) {
                i2++;
                if (i2 < i3) {
                    getChildAt(i2).offsetLeftAndRight(measuredWidth);
                } else {
                    return;
                }
            }
        }
    }

    private int c(int i2, int i3, int i4) {
        return i4 > 0 ? i2 + i3 : i2;
    }

    private View c(View view, int i2) {
        int i3 = i2 + 1;
        View a2 = a(i3, this.P);
        a(a2, i3, view.getRight() + this.f29304av, true, this.f29216u.top, false, this.P[0]);
        return a2;
    }

    private boolean c(View view) {
        ArrayList<b> arrayList = this.f29308az;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (view == arrayList.get(i2).f29311a) {
                return true;
            }
        }
        ArrayList<b> arrayList2 = this.aA;
        int size2 = arrayList2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (view == arrayList2.get(i3).f29311a) {
                return true;
            }
        }
        return false;
    }

    private void d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f29217v, this.f29216u.top + this.f29216u.bottom, layoutParams.height);
        int i2 = layoutParams.width;
        view.measure(i2 > 0 ? View.MeasureSpec.makeMeasureSpec(i2, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0), childMeasureSpec);
    }

    private void e(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = this.f29216u.top;
        int left = view.getLeft();
        view.layout(left, i2, measuredWidth + left, measuredHeight + i2);
    }

    private int f(View view) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (a(view, getChildAt(i2))) {
                return this.V + i2;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private View f(int i2, int i3) {
        int right = getRight() - getLeft();
        View view = null;
        int i4 = i3;
        while (true) {
            boolean z2 = true;
            if (i4 >= right || i2 >= this.f29287ao) {
                d(this.V, (this.V + getChildCount()) - 1);
            } else {
                if (i2 != this.f29285am) {
                    z2 = false;
                }
                View a2 = a(i2, i4, true, this.f29216u.top, z2);
                i4 = this.f29304av + a2.getRight();
                if (z2) {
                    view = a2;
                }
                i2++;
            }
        }
        d(this.V, (this.V + getChildCount()) - 1);
        return view;
    }

    private int g(View view) {
        view.getDrawingRect(this.aH);
        offsetDescendantRectToMyCoords(view, this.aH);
        int right = (getRight() - getLeft()) - this.f29216u.right;
        if (this.aH.right < this.f29216u.left) {
            return this.f29216u.left - this.aH.right;
        }
        if (this.aH.left > right) {
            return this.aH.left - right;
        }
        return 0;
    }

    private View g(int i2, int i3) {
        View view = null;
        int i4 = i3;
        while (true) {
            boolean z2 = true;
            if (i4 <= 0 || i2 < 0) {
                this.V = i2 + 1;
                d(this.V, (this.V + getChildCount()) - 1);
            } else {
                if (i2 != this.f29285am) {
                    z2 = false;
                }
                View a2 = a(i2, i4, false, this.f29216u.top, z2);
                i4 = a2.getLeft() - this.f29304av;
                if (z2) {
                    view = a2;
                }
                i2--;
            }
        }
        this.V = i2 + 1;
        d(this.V, (this.V + getChildCount()) - 1);
        return view;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private View h(int i2, int i3) {
        int i4 = i3 - i2;
        int m2 = m();
        View a2 = a(m2, i2, true, this.f29216u.top, true);
        this.V = m2;
        int measuredWidth = a2.getMeasuredWidth();
        if (measuredWidth <= i4) {
            a2.offsetLeftAndRight((i4 - measuredWidth) / 2);
        }
        a(a2, m2);
        if (!this.K) {
            l(getChildCount());
        } else {
            m(getChildCount());
        }
        return a2;
    }

    private View i(int i2, int i3) {
        View view;
        View view2;
        boolean z2 = i2 == this.f29285am;
        View a2 = a(i2, i3, true, this.f29216u.top, z2);
        this.V = i2;
        int i4 = this.f29304av;
        if (!this.K) {
            view2 = g(i2 - 1, a2.getLeft() - i4);
            y();
            view = f(i2 + 1, a2.getRight() + i4);
            int childCount = getChildCount();
            if (childCount > 0) {
                l(childCount);
            }
        } else {
            View f2 = f(i2 + 1, a2.getRight() + i4);
            y();
            View g2 = g(i2 - 1, a2.getLeft() - i4);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                m(childCount2);
            }
            View view3 = f2;
            view2 = g2;
            view = view3;
        }
        return z2 ? a2 : view2 != null ? view2 : view;
    }

    private int j(int i2, int i3) {
        int width = getWidth() - this.f29216u.right;
        int i4 = this.f29216u.left;
        int childCount = getChildCount();
        if (i2 == 130) {
            int i5 = childCount - 1;
            int i6 = i3 != -1 ? i3 - this.V : i5;
            int i7 = this.V + i6;
            View childAt = getChildAt(i6);
            int arrowScrollPreviewLength = i7 < this.f29287ao + -1 ? width - getArrowScrollPreviewLength() : width;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i3 != -1 && arrowScrollPreviewLength - childAt.getLeft() >= getMaxScrollAmount()) {
                return 0;
            }
            int right = childAt.getRight() - arrowScrollPreviewLength;
            if (this.V + childCount == this.f29287ao) {
                right = Math.min(right, getChildAt(i5).getRight() - width);
            }
            return Math.min(right, getMaxScrollAmount());
        }
        int i8 = i3 != -1 ? i3 - this.V : 0;
        int i9 = this.V + i8;
        View childAt2 = getChildAt(i8);
        int arrowScrollPreviewLength2 = i9 > 0 ? getArrowScrollPreviewLength() + i4 : i4;
        if (childAt2.getLeft() >= arrowScrollPreviewLength2) {
            return 0;
        }
        if (i3 != -1 && childAt2.getRight() - arrowScrollPreviewLength2 >= getMaxScrollAmount()) {
            return 0;
        }
        int left = arrowScrollPreviewLength2 - childAt2.getLeft();
        if (this.V == 0) {
            left = Math.min(left, i4 - getChildAt(0).getLeft());
        }
        return Math.min(left, getMaxScrollAmount());
    }

    private View k(int i2) {
        this.V = Math.min(this.V, this.f29285am);
        this.V = Math.min(this.V, this.f29287ao - 1);
        if (this.V < 0) {
            this.V = 0;
        }
        return f(this.V, i2);
    }

    private void l(int i2) {
        if ((this.V + i2) - 1 == this.f29287ao - 1 && i2 > 0) {
            int right = ((getRight() - getLeft()) - this.f29216u.right) - getChildAt(i2 - 1).getRight();
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            if (right <= 0) {
                return;
            }
            if (this.V > 0 || left < this.f29216u.top) {
                if (this.V == 0) {
                    right = Math.min(right, this.f29216u.top - left);
                }
                c(right);
                if (this.V > 0) {
                    g(this.V - 1, childAt.getLeft() - this.f29304av);
                    y();
                }
            }
        }
    }

    private void m(int i2) {
        if (this.V == 0 && i2 > 0) {
            int left = getChildAt(0).getLeft();
            int i3 = this.f29216u.left;
            int right = (getRight() - getLeft()) - this.f29216u.right;
            int i4 = left - i3;
            View childAt = getChildAt(i2 - 1);
            int right2 = childAt.getRight();
            int i5 = (this.V + i2) - 1;
            if (i4 > 0) {
                if (i5 < this.f29287ao - 1 || right2 > right) {
                    if (i5 == this.f29287ao - 1) {
                        i4 = Math.min(i4, right2 - right);
                    }
                    c(-i4);
                    if (i5 < this.f29287ao - 1) {
                        f(i5 + 1, childAt.getRight() + this.f29304av);
                    } else {
                        return;
                    }
                } else if (i5 != this.f29287ao - 1) {
                    return;
                }
                y();
            }
        }
    }

    private boolean n(int i2) {
        View selectedView;
        if (i2 == 17 || i2 == 66) {
            int childCount = getChildCount();
            if (!this.aG || childCount <= 0 || this.f29285am == -1 || (selectedView = getSelectedView()) == null || !selectedView.hasFocus() || !(selectedView instanceof ViewGroup)) {
                return false;
            }
            View findFocus = selectedView.findFocus();
            View findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i2);
            if (findNextFocus != null) {
                findFocus.getFocusedRect(this.aH);
                offsetDescendantRectToMyCoords(findFocus, this.aH);
                offsetRectIntoDescendantCoords(findNextFocus, this.aH);
                if (findNextFocus.requestFocus(i2, this.aH)) {
                    return true;
                }
            }
            View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i2);
            if (findNextFocus2 != null) {
                return a(findNextFocus2, (View) this);
            }
            return false;
        }
        throw new IllegalArgumentException("direction must be one of {View.FOCUS_LEFT, View.FOCUS_RIGHT}");
    }

    private boolean o(int i2) {
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i3 = this.f29285am;
        int p2 = p(i2);
        int j2 = j(i2, p2);
        View view = null;
        a q2 = this.aG ? q(i2) : null;
        if (q2 != null) {
            p2 = q2.a();
            j2 = q2.b();
        }
        boolean z2 = q2 != null;
        if (p2 != -1) {
            a(selectedView, i2, p2, q2 != null);
            setSelectedPositionInt(p2);
            setNextSelectedPositionInt(p2);
            selectedView = getSelectedView();
            if (this.aG && q2 == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            u();
            i3 = p2;
            z2 = true;
        }
        if (j2 > 0) {
            if (i2 != 33) {
                j2 = -j2;
            }
            r(j2);
            z2 = true;
        }
        if (this.aG && q2 == null && selectedView != null && selectedView.hasFocus()) {
            View findFocus = selectedView.findFocus();
            if (!a(findFocus, (View) this) || g(findFocus) > 0) {
                findFocus.clearFocus();
            }
        }
        if (p2 != -1 || selectedView == null || a(selectedView, (View) this)) {
            view = selectedView;
        } else {
            l();
            this.M = -1;
        }
        if (!z2) {
            return false;
        }
        if (view != null) {
            a(i3, view);
            this.J = view.getLeft();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        b();
        return true;
    }

    private int p(int i2) {
        int i3 = this.V;
        if (i2 == 130) {
            int i4 = this.f29285am != -1 ? this.f29285am + 1 : i3;
            if (i4 >= this.f29205j.getCount()) {
                return -1;
            }
            if (i4 < i3) {
                i4 = i3;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter = getAdapter();
            while (i4 <= lastVisiblePosition) {
                if (adapter.isEnabled(i4) && getChildAt(i4 - i3).getVisibility() == 0) {
                    return i4;
                }
                i4++;
            }
        } else {
            int childCount = (getChildCount() + i3) - 1;
            int childCount2 = (this.f29285am != -1 ? this.f29285am : getChildCount() + i3) - 1;
            if (childCount2 >= 0 && childCount2 < this.f29205j.getCount()) {
                if (childCount2 <= childCount) {
                    childCount = childCount2;
                }
                ListAdapter adapter2 = getAdapter();
                while (childCount >= i3) {
                    if (adapter2.isEnabled(childCount) && getChildAt(childCount - i3).getVisibility() == 0) {
                        return childCount;
                    }
                    childCount--;
                }
            }
        }
        return -1;
    }

    private a q(int i2) {
        View view;
        int p2;
        int i3;
        View selectedView = getSelectedView();
        if (selectedView == null || !selectedView.hasFocus()) {
            boolean z2 = true;
            int i4 = this.V;
            if (i2 == 130) {
                if (i4 <= 0) {
                    z2 = false;
                }
                i3 = this.f29216u.left + (z2 ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getLeft() > i3) {
                    i3 = selectedView.getLeft();
                }
            } else {
                if ((i4 + getChildCount()) - 1 >= this.f29287ao) {
                    z2 = false;
                }
                i3 = (getWidth() - this.f29216u.right) - (z2 ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < i3) {
                    i3 = selectedView.getRight();
                }
            }
            this.aH.set(i3, 0, i3, 0);
            view = FocusFinder.getInstance().findNextFocusFromRect(this, this.aH, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i2);
        }
        if (view != null) {
            int f2 = f(view);
            if (this.f29285am != -1 && f2 != this.f29285am && (p2 = p(i2)) != -1 && ((i2 == 130 && p2 < f2) || (i2 == 33 && p2 > f2))) {
                return null;
            }
            int a2 = a(i2, view, f2);
            int maxScrollAmount = getMaxScrollAmount();
            if (a2 < maxScrollAmount) {
                view.requestFocus(i2);
                this.aJ.a(f2, a2);
            } else if (g(view) < maxScrollAmount) {
                view.requestFocus(i2);
                this.aJ.a(f2, maxScrollAmount);
            }
            return this.aJ;
        }
        return null;
    }

    private void r(int i2) {
        int i3;
        c(i2);
        int width = getWidth() - this.f29216u.right;
        int i4 = this.f29216u.left;
        AbsHListView.j jVar = this.f29211p;
        if (i2 < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < width && (this.V + childCount) - 1 < this.f29287ao - 1) {
                childAt = c(childAt, i3);
                childCount++;
            }
            if (childAt.getBottom() < width) {
                c(width - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (childAt2.getRight() < i4) {
                if (jVar.b(((AbsHListView.LayoutParams) childAt2.getLayoutParams()).f29226a)) {
                    detachViewFromParent(childAt2);
                    jVar.a(childAt2, this.V);
                } else {
                    removeViewInLayout(childAt2);
                }
                childAt2 = getChildAt(0);
                this.V++;
            }
            return;
        }
        View childAt3 = getChildAt(0);
        while (childAt3.getLeft() > i4 && this.V > 0) {
            childAt3 = b(childAt3, this.V);
            this.V--;
        }
        if (childAt3.getLeft() > i4) {
            c(i4 - childAt3.getLeft());
        }
        int childCount2 = getChildCount();
        while (true) {
            childCount2--;
            View childAt4 = getChildAt(childCount2);
            if (childAt4.getLeft() <= width) {
                return;
            }
            if (jVar.b(((AbsHListView.LayoutParams) childAt4.getLayoutParams()).f29226a)) {
                detachViewFromParent(childAt4);
                jVar.a(childAt4, this.V + childCount2);
            } else {
                removeViewInLayout(childAt4);
            }
        }
    }

    private void y() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i2 = 0;
            if (!this.K) {
                int left = getChildAt(0).getLeft() - this.f29216u.left;
                if (this.V != 0) {
                    left -= this.f29304av;
                }
                if (left >= 0) {
                    i2 = left;
                }
            } else {
                int right = getChildAt(childCount - 1).getRight() - (getWidth() - this.f29216u.right);
                if (this.V + childCount < this.f29287ao) {
                    right += this.f29304av;
                }
                if (right <= 0) {
                    i2 = right;
                }
            }
            if (i2 != 0) {
                c(-i2);
            }
        }
    }

    private boolean z() {
        return this.V > 0 || getChildAt(0).getLeft() > getScrollX() + this.f29216u.left;
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2, int i3, int i4, int i5, int i6) {
        Log.i("HListView", "measureWidthOfChildren, from " + i3 + " to " + i4);
        ListAdapter listAdapter = this.f29205j;
        if (listAdapter == null) {
            return this.f29216u.left + this.f29216u.right;
        }
        int i7 = this.f29216u.left + this.f29216u.right;
        int i8 = this.f29304av;
        int i9 = 0;
        if (i8 <= 0 || this.f29303au == null) {
            i8 = 0;
        }
        if (i4 == -1) {
            i4 = listAdapter.getCount() - 1;
        }
        AbsHListView.j jVar = this.f29211p;
        boolean x2 = x();
        boolean[] zArr = this.P;
        while (i3 <= i4) {
            View a2 = a(i3, zArr);
            a(a2, i3, i2);
            if (i3 > 0) {
                i7 += i8;
            }
            if (x2 && jVar.b(((AbsHListView.LayoutParams) a2.getLayoutParams()).f29226a)) {
                jVar.a(a2, -1);
            }
            i7 += a2.getMeasuredWidth();
            if (i7 >= i5) {
                return (i6 < 0 || i3 <= i6 || i9 <= 0 || i7 == i5) ? i5 : i9;
            }
            if (i6 >= 0 && i3 >= i6) {
                i9 = i7;
            }
            i3++;
        }
        return i7;
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i2) {
        Drawable drawable = this.f29303au;
        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.left = rect.right - minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void a(View view, Object obj, boolean z2) {
        if (this.f29205j == null || (this.f29205j instanceof b)) {
            b bVar = new b();
            bVar.f29311a = view;
            bVar.f29312b = obj;
            bVar.f29313c = z2;
            this.f29308az.add(bVar);
            if (this.f29205j != null && this.f29204i != null) {
                this.f29204i.onChanged();
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        int childCount = getChildCount();
        int i2 = 0;
        if (z2) {
            if (childCount > 0) {
                i2 = this.f29304av + getChildAt(childCount - 1).getRight();
            }
            f(this.V + childCount, i2);
            l(getChildCount());
            return;
        }
        g(this.V - 1, childCount > 0 ? getChildAt(0).getLeft() - this.f29304av : getWidth() - 0);
        m(getChildCount());
    }

    /* access modifiers changed from: package-private */
    public final int[] a(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i4;
        StringBuilder sb = new StringBuilder();
        sb.append("measureWithLargeChildren, from ");
        int i9 = i3;
        sb.append(i9);
        sb.append(" to ");
        sb.append(i8);
        Log.i("HListView", sb.toString());
        ListAdapter listAdapter = this.f29205j;
        if (listAdapter == null) {
            return new int[]{this.f29216u.left + this.f29216u.right, this.f29216u.top + this.f29216u.bottom};
        }
        int i10 = this.f29216u.left + this.f29216u.right;
        int i11 = this.f29216u.top + this.f29216u.bottom;
        int i12 = this.f29304av;
        if (i12 <= 0 || this.f29303au == null) {
            i12 = 0;
        }
        if (i8 == -1) {
            i8 = listAdapter.getCount() - 1;
        }
        AbsHListView.j jVar = this.f29211p;
        boolean x2 = x();
        boolean[] zArr = this.P;
        int i13 = 0;
        int i14 = 0;
        while (i9 <= i8) {
            View a2 = a(i9, zArr);
            a(a2, i9, i2);
            if (x2 && jVar.b(((AbsHListView.LayoutParams) a2.getLayoutParams()).f29226a)) {
                jVar.a(a2, -1);
            }
            i13 = Math.max(i13, a2.getMeasuredWidth() + i12);
            i14 = Math.max(i14, a2.getMeasuredHeight());
            i9++;
        }
        return new int[]{Math.min(i10 + i13, i5), Math.min(i11 + i14, i6)};
    }

    /* access modifiers changed from: protected */
    public int b(int i2, boolean z2) {
        int i3;
        ListAdapter listAdapter = this.f29205j;
        if (listAdapter != null && !isInTouchMode()) {
            int count = listAdapter.getCount();
            if (!this.aF) {
                if (z2) {
                    i3 = Math.max(0, i2);
                    while (i3 < count && !listAdapter.isEnabled(i3)) {
                        i3++;
                    }
                } else {
                    int min = Math.min(i2, count - 1);
                    while (i3 >= 0 && !listAdapter.isEnabled(i3)) {
                        min = i3 - 1;
                    }
                }
                if (i3 < 0 || i3 >= count) {
                    return -1;
                }
                return i3;
            } else if (i2 < 0 || i2 >= count) {
                return -1;
            } else {
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        if (rect.right - rect.left < minimumWidth) {
            rect.right = rect.left + minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    public void b(View view) {
        a(view, (Object) null, true);
    }

    /* access modifiers changed from: protected */
    public boolean canAnimate() {
        return super.canAnimate() && this.f29287ao > 0;
    }

    /* access modifiers changed from: protected */
    public int d(int i2) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return -1;
        }
        if (!this.K) {
            for (int i3 = 0; i3 < childCount; i3++) {
                if (i2 <= getChildAt(i3).getRight()) {
                    return this.V + i3;
                }
            }
            return -1;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            if (i2 >= getChildAt(i4).getLeft()) {
                return this.V + i4;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void d() {
        a(this.f29308az);
        a(this.aA);
        super.d();
        this.f29203h = 0;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01bb, code lost:
        if (r8.isEnabled(r3 + 1) == false) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0117, code lost:
        if (r8.isEnabled(r7 + 1) == false) goto L_0x011c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            boolean r2 = r0.f29220y
            r3 = 1
            if (r2 == 0) goto L_0x000b
            r0.f29221z = r3
        L_0x000b:
            int r2 = r0.f29304av
            android.graphics.drawable.Drawable r4 = r0.f29306ax
            android.graphics.drawable.Drawable r5 = r0.f29307ay
            if (r4 == 0) goto L_0x0015
            r7 = 1
            goto L_0x0016
        L_0x0015:
            r7 = 0
        L_0x0016:
            if (r5 == 0) goto L_0x001a
            r8 = 1
            goto L_0x001b
        L_0x001a:
            r8 = 0
        L_0x001b:
            if (r2 <= 0) goto L_0x0023
            android.graphics.drawable.Drawable r9 = r0.f29303au
            if (r9 == 0) goto L_0x0023
            r9 = 1
            goto L_0x0024
        L_0x0023:
            r9 = 0
        L_0x0024:
            if (r9 != 0) goto L_0x002a
            if (r7 != 0) goto L_0x002a
            if (r8 == 0) goto L_0x0200
        L_0x002a:
            android.graphics.Rect r10 = r0.aH
            int r11 = r24.getPaddingTop()
            r10.top = r11
            int r11 = r24.getBottom()
            int r12 = r24.getTop()
            int r11 = r11 - r12
            int r12 = r24.getPaddingBottom()
            int r11 = r11 - r12
            r10.bottom = r11
            int r11 = r24.getChildCount()
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r12 = r0.f29308az
            int r12 = r12.size()
            int r13 = r0.f29287ao
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r14 = r0.aA
            int r14 = r14.size()
            int r14 = r13 - r14
            int r14 = r14 - r3
            boolean r15 = r0.aD
            boolean r3 = r0.aE
            int r6 = r0.V
            r18 = r5
            boolean r5 = r0.aF
            r19 = r13
            android.widget.ListAdapter r13 = r0.f29205j
            boolean r20 = r24.isOpaque()
            if (r20 == 0) goto L_0x0074
            boolean r20 = super.isOpaque()
            if (r20 != 0) goto L_0x0074
            r16 = 1
            goto L_0x0076
        L_0x0074:
            r16 = 0
        L_0x0076:
            if (r16 == 0) goto L_0x0096
            r20 = r13
            android.graphics.Paint r13 = r0.aI
            if (r13 != 0) goto L_0x0093
            boolean r13 = r0.aB
            if (r13 == 0) goto L_0x0093
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>()
            r0.aI = r13
            r21 = r5
            int r5 = r24.getCacheColorHint()
            r13.setColor(r5)
            goto L_0x009a
        L_0x0093:
            r21 = r5
            goto L_0x009a
        L_0x0096:
            r21 = r5
            r20 = r13
        L_0x009a:
            android.graphics.Paint r5 = r0.aI
            int r13 = r24.getRight()
            int r22 = r24.getLeft()
            int r13 = r13 - r22
            r22 = r5
            r5 = 0
            int r13 = r13 - r5
            int r17 = r24.getScrollX()
            int r13 = r13 + r17
            boolean r5 = r0.K
            r23 = r8
            r8 = -1
            if (r5 != 0) goto L_0x015c
            int r5 = r24.getScrollX()
            if (r11 <= 0) goto L_0x00d5
            if (r5 >= 0) goto L_0x00d5
            if (r7 == 0) goto L_0x00ca
            r7 = 0
            r10.right = r7
            r10.left = r5
            r0.a((android.graphics.Canvas) r1, (android.graphics.drawable.Drawable) r4, (android.graphics.Rect) r10)
            goto L_0x00d5
        L_0x00ca:
            r7 = 0
            if (r9 == 0) goto L_0x00d5
            r10.right = r7
            int r4 = -r2
            r10.left = r4
            r0.a((android.graphics.Canvas) r1, (android.graphics.Rect) r10, (int) r8)
        L_0x00d5:
            r4 = 0
            r5 = 0
        L_0x00d7:
            if (r4 >= r11) goto L_0x0142
            if (r15 != 0) goto L_0x00df
            int r7 = r6 + r4
            if (r7 < r12) goto L_0x00e6
        L_0x00df:
            if (r3 != 0) goto L_0x00ed
            int r7 = r6 + r4
            if (r7 >= r14) goto L_0x00e6
            goto L_0x00ed
        L_0x00e6:
            r8 = r20
            r20 = r13
        L_0x00ea:
            r13 = r22
            goto L_0x0139
        L_0x00ed:
            android.view.View r5 = r0.getChildAt(r4)
            int r5 = r5.getRight()
            if (r9 == 0) goto L_0x00e6
            if (r5 >= r13) goto L_0x00e6
            if (r23 == 0) goto L_0x00ff
            int r7 = r11 + -1
            if (r4 == r7) goto L_0x00e6
        L_0x00ff:
            if (r21 != 0) goto L_0x012a
            int r7 = r6 + r4
            r8 = r20
            boolean r17 = r8.isEnabled(r7)
            if (r17 == 0) goto L_0x011a
            r20 = r13
            int r13 = r11 + -1
            if (r4 == r13) goto L_0x012e
            int r7 = r7 + 1
            boolean r7 = r8.isEnabled(r7)
            if (r7 == 0) goto L_0x011c
            goto L_0x012e
        L_0x011a:
            r20 = r13
        L_0x011c:
            if (r16 == 0) goto L_0x00ea
            r10.left = r5
            int r7 = r5 + r2
            r10.right = r7
            r13 = r22
            r1.drawRect(r10, r13)
            goto L_0x0139
        L_0x012a:
            r8 = r20
            r20 = r13
        L_0x012e:
            r13 = r22
            r10.left = r5
            int r7 = r5 + r2
            r10.right = r7
            r0.a((android.graphics.Canvas) r1, (android.graphics.Rect) r10, (int) r4)
        L_0x0139:
            int r4 = r4 + 1
            r22 = r13
            r13 = r20
            r20 = r8
            goto L_0x00d7
        L_0x0142:
            int r2 = r24.getRight()
            int r3 = r24.getScrollX()
            int r2 = r2 + r3
            if (r23 == 0) goto L_0x0200
            int r6 = r6 + r11
            r3 = r19
            if (r6 != r3) goto L_0x0200
            if (r2 <= r5) goto L_0x0200
            r10.left = r5
            r10.right = r2
            r5 = r18
            goto L_0x01ef
        L_0x015c:
            r19 = r9
            r5 = r18
            r8 = r20
            r20 = r13
            r13 = r22
            int r9 = r24.getScrollX()
            if (r11 <= 0) goto L_0x0181
            if (r7 == 0) goto L_0x0181
            r10.left = r9
            r22 = r7
            r7 = 0
            android.view.View r7 = r0.getChildAt(r7)
            int r7 = r7.getLeft()
            r10.right = r7
            r0.a((android.graphics.Canvas) r1, (android.graphics.drawable.Drawable) r4, (android.graphics.Rect) r10)
            goto L_0x0183
        L_0x0181:
            r22 = r7
        L_0x0183:
            r7 = r22
        L_0x0185:
            if (r7 >= r11) goto L_0x01e0
            if (r15 != 0) goto L_0x0193
            int r4 = r6 + r7
            if (r4 < r12) goto L_0x018e
            goto L_0x0193
        L_0x018e:
            r17 = r3
            r22 = r6
            goto L_0x01d9
        L_0x0193:
            if (r3 != 0) goto L_0x0199
            int r4 = r6 + r7
            if (r4 >= r14) goto L_0x018e
        L_0x0199:
            android.view.View r4 = r0.getChildAt(r7)
            int r4 = r4.getLeft()
            if (r4 <= 0) goto L_0x018e
            r17 = r3
            if (r21 != 0) goto L_0x01cc
            int r3 = r6 + r7
            boolean r22 = r8.isEnabled(r3)
            if (r22 == 0) goto L_0x01be
            r22 = r6
            int r6 = r11 + -1
            if (r7 == r6) goto L_0x01ce
            int r3 = r3 + 1
            boolean r3 = r8.isEnabled(r3)
            if (r3 == 0) goto L_0x01c0
            goto L_0x01ce
        L_0x01be:
            r22 = r6
        L_0x01c0:
            if (r16 == 0) goto L_0x01d9
            int r3 = r4 - r2
            r10.left = r3
            r10.right = r4
            r1.drawRect(r10, r13)
            goto L_0x01d9
        L_0x01cc:
            r22 = r6
        L_0x01ce:
            int r3 = r4 - r2
            r10.left = r3
            r10.right = r4
            int r3 = r7 + -1
            r0.a((android.graphics.Canvas) r1, (android.graphics.Rect) r10, (int) r3)
        L_0x01d9:
            int r7 = r7 + 1
            r3 = r17
            r6 = r22
            goto L_0x0185
        L_0x01e0:
            if (r11 <= 0) goto L_0x0200
            if (r9 <= 0) goto L_0x0200
            if (r23 == 0) goto L_0x01f3
            int r2 = r24.getRight()
            r10.left = r2
            int r2 = r2 + r9
            r10.right = r2
        L_0x01ef:
            r0.b((android.graphics.Canvas) r1, (android.graphics.drawable.Drawable) r5, (android.graphics.Rect) r10)
            goto L_0x0200
        L_0x01f3:
            if (r19 == 0) goto L_0x0200
            r13 = r20
            r10.left = r13
            int r13 = r13 + r2
            r10.right = r13
            r2 = -1
            r0.a((android.graphics.Canvas) r1, (android.graphics.Rect) r10, (int) r2)
        L_0x0200:
            super.dispatchDraw(r25)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.dispatchDraw(android.graphics.Canvas):void");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (this.f29221z) {
            this.f29221z = false;
        }
        return drawChild;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x018d, code lost:
        if (r7.aG == false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0193, code lost:
        if (hasFocus() == false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0199, code lost:
        if (r1.hasFocus() != false) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x019b, code lost:
        if (r1 != r9) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x019d, code lost:
        if (r10 == null) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01a3, code lost:
        if (r10.requestFocus() != false) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01a9, code lost:
        if (r1.requestFocus() == false) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ac, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ad, code lost:
        if (r0 != false) goto L_0x01bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01af, code lost:
        r0 = getFocusedChild();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01b3, code lost:
        if (r0 == null) goto L_0x01b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01b5, code lost:
        r0.clearFocus();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01b8, code lost:
        a(-1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01bc, code lost:
        r1.setSelected(false);
        r7.f29210o.setEmpty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01c5, code lost:
        r7.J = r1.getLeft();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01ce, code lost:
        if (r7.F <= 0) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01d3, code lost:
        if (r7.F >= 3) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01d5, code lost:
        r0 = getChildAt(r7.A - r7.V);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01de, code lost:
        if (r0 == null) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01e0, code lost:
        a(r7.A, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01e6, code lost:
        r7.J = 0;
        r7.f29210o.setEmpty();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01f2, code lost:
        if (hasFocus() == false) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01f4, code lost:
        if (r10 == null) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01f6, code lost:
        r10.requestFocus();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01f9, code lost:
        if (r10 == null) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01ff, code lost:
        if (r10.getWindowToken() == null) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0201, code lost:
        r10.onFinishTemporaryDetach();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0204, code lost:
        r7.f29203h = 0;
        r7.f29282aj = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x020b, code lost:
        if (r7.O == null) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x020d, code lost:
        post(r7.O);
        r7.O = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0215, code lost:
        r7.f29276ad = false;
        setNextSelectedPositionInt(r7.f29285am);
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0222, code lost:
        if (r7.f29287ao <= 0) goto L_0x0227;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0224, code lost:
        u();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0227, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0104, code lost:
        r1 = i(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0118, code lost:
        y();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0185, code lost:
        r15.e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0188, code lost:
        if (r1 == null) goto L_0x01cc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c A[Catch:{ all -> 0x026a }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ all -> 0x026a }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009e A[SYNTHETIC, Splitter:B:43:0x009e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r18 = this;
            r7 = r18
            boolean r8 = r7.f29292at
            if (r8 != 0) goto L_0x0271
            r0 = 1
            r7.f29292at = r0
            r9 = 0
            super.e()     // Catch:{ all -> 0x026a }
            r18.invalidate()     // Catch:{ all -> 0x026a }
            android.widget.ListAdapter r1 = r7.f29205j     // Catch:{ all -> 0x026a }
            if (r1 != 0) goto L_0x001f
            r18.d()     // Catch:{ all -> 0x026a }
            r18.b()     // Catch:{ all -> 0x026a }
            if (r8 != 0) goto L_0x001e
            r7.f29292at = r9
        L_0x001e:
            return
        L_0x001f:
            android.graphics.Rect r1 = r7.f29216u     // Catch:{ all -> 0x026a }
            int r5 = r1.left     // Catch:{ all -> 0x026a }
            int r1 = r18.getRight()     // Catch:{ all -> 0x026a }
            int r2 = r18.getLeft()     // Catch:{ all -> 0x026a }
            int r1 = r1 - r2
            android.graphics.Rect r2 = r7.f29216u     // Catch:{ all -> 0x026a }
            int r2 = r2.right     // Catch:{ all -> 0x026a }
            int r6 = r1 - r2
            int r1 = r18.getChildCount()     // Catch:{ all -> 0x026a }
            int r2 = r7.f29203h     // Catch:{ all -> 0x026a }
            r10 = 3
            if (r2 == r0) goto L_0x0084
            r3 = 2
            if (r2 == r3) goto L_0x0074
            if (r2 == r10) goto L_0x0084
            r3 = 4
            if (r2 == r3) goto L_0x0084
            r3 = 5
            if (r2 == r3) goto L_0x0084
            int r2 = r7.f29285am     // Catch:{ all -> 0x026a }
            int r3 = r7.V     // Catch:{ all -> 0x026a }
            int r2 = r2 - r3
            if (r2 < 0) goto L_0x0054
            if (r2 >= r1) goto L_0x0054
            android.view.View r3 = r7.getChildAt(r2)     // Catch:{ all -> 0x026a }
            goto L_0x0055
        L_0x0054:
            r3 = 0
        L_0x0055:
            android.view.View r4 = r7.getChildAt(r9)     // Catch:{ all -> 0x026a }
            int r12 = r7.f29283ak     // Catch:{ all -> 0x026a }
            if (r12 < 0) goto L_0x0063
            int r12 = r7.f29283ak     // Catch:{ all -> 0x026a }
            int r13 = r7.f29285am     // Catch:{ all -> 0x026a }
            int r12 = r12 - r13
            goto L_0x0064
        L_0x0063:
            r12 = 0
        L_0x0064:
            int r2 = r2 + r12
            android.view.View r2 = r7.getChildAt(r2)     // Catch:{ all -> 0x026a }
            r16 = r3
            r3 = r2
            r2 = r16
            r17 = r12
            r12 = r4
            r4 = r17
            goto L_0x0088
        L_0x0074:
            int r2 = r7.f29283ak     // Catch:{ all -> 0x026a }
            int r3 = r7.V     // Catch:{ all -> 0x026a }
            int r2 = r2 - r3
            if (r2 < 0) goto L_0x0084
            if (r2 >= r1) goto L_0x0084
            android.view.View r2 = r7.getChildAt(r2)     // Catch:{ all -> 0x026a }
            r3 = r2
            r2 = 0
            goto L_0x0086
        L_0x0084:
            r2 = 0
            r3 = 0
        L_0x0086:
            r4 = 0
            r12 = 0
        L_0x0088:
            boolean r13 = r7.f29282aj     // Catch:{ all -> 0x026a }
            if (r13 == 0) goto L_0x008f
            r18.q()     // Catch:{ all -> 0x026a }
        L_0x008f:
            int r14 = r7.f29287ao     // Catch:{ all -> 0x026a }
            if (r14 != 0) goto L_0x009e
            r18.d()     // Catch:{ all -> 0x026a }
            r18.b()     // Catch:{ all -> 0x026a }
            if (r8 != 0) goto L_0x009d
            r7.f29292at = r9
        L_0x009d:
            return
        L_0x009e:
            int r14 = r7.f29287ao     // Catch:{ all -> 0x026a }
            android.widget.ListAdapter r15 = r7.f29205j     // Catch:{ all -> 0x026a }
            int r15 = r15.getCount()     // Catch:{ all -> 0x026a }
            if (r14 != r15) goto L_0x0230
            int r14 = r7.f29283ak     // Catch:{ all -> 0x026a }
            r7.setSelectedPositionInt(r14)     // Catch:{ all -> 0x026a }
            int r14 = r7.V     // Catch:{ all -> 0x026a }
            it.sephiroth.android.library.widget.AbsHListView$j r15 = r7.f29211p     // Catch:{ all -> 0x026a }
            if (r13 == 0) goto L_0x00c4
            r11 = 0
        L_0x00b4:
            if (r11 >= r1) goto L_0x00c7
            android.view.View r10 = r7.getChildAt(r11)     // Catch:{ all -> 0x026a }
            int r9 = r14 + r11
            r15.a((android.view.View) r10, (int) r9)     // Catch:{ all -> 0x026a }
            int r11 = r11 + 1
            r9 = 0
            r10 = 3
            goto L_0x00b4
        L_0x00c4:
            r15.a((int) r1, (int) r14)     // Catch:{ all -> 0x026a }
        L_0x00c7:
            android.view.View r9 = r18.getFocusedChild()     // Catch:{ all -> 0x026a }
            if (r9 == 0) goto L_0x00e6
            if (r13 == 0) goto L_0x00d9
            boolean r10 = r7.c(r9)     // Catch:{ all -> 0x026a }
            if (r10 == 0) goto L_0x00d6
            goto L_0x00d9
        L_0x00d6:
            r9 = 0
            r10 = 0
            goto L_0x00e2
        L_0x00d9:
            android.view.View r10 = r18.findFocus()     // Catch:{ all -> 0x026a }
            if (r10 == 0) goto L_0x00e2
            r10.onStartTemporaryDetach()     // Catch:{ all -> 0x026a }
        L_0x00e2:
            r18.requestFocus()     // Catch:{ all -> 0x026a }
            goto L_0x00e8
        L_0x00e6:
            r9 = 0
            r10 = 0
        L_0x00e8:
            r18.detachAllViewsFromParent()     // Catch:{ all -> 0x026a }
            r15.d()     // Catch:{ all -> 0x026a }
            int r11 = r7.f29203h     // Catch:{ all -> 0x026a }
            switch(r11) {
                case 1: goto L_0x012d;
                case 2: goto L_0x011d;
                case 3: goto L_0x0111;
                case 4: goto L_0x010a;
                case 5: goto L_0x0100;
                case 6: goto L_0x00f8;
                default: goto L_0x00f3;
            }     // Catch:{ all -> 0x026a }
        L_0x00f3:
            if (r1 != 0) goto L_0x0157
            boolean r1 = r7.K     // Catch:{ all -> 0x026a }
            goto L_0x0135
        L_0x00f8:
            r1 = r18
            android.view.View r1 = r1.a((android.view.View) r2, (android.view.View) r3, (int) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x0100:
            int r1 = r7.f29273aa     // Catch:{ all -> 0x026a }
            int r2 = r7.W     // Catch:{ all -> 0x026a }
        L_0x0104:
            android.view.View r1 = r7.i(r1, r2)     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x010a:
            int r1 = r18.m()     // Catch:{ all -> 0x026a }
            int r2 = r7.W     // Catch:{ all -> 0x026a }
            goto L_0x0104
        L_0x0111:
            int r1 = r7.f29287ao     // Catch:{ all -> 0x026a }
            int r1 = r1 - r0
            android.view.View r1 = r7.g(r1, r6)     // Catch:{ all -> 0x026a }
        L_0x0118:
            r18.y()     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x011d:
            if (r3 == 0) goto L_0x0128
            int r1 = r3.getLeft()     // Catch:{ all -> 0x026a }
            android.view.View r1 = r7.a((int) r1, (int) r5, (int) r6)     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x0128:
            android.view.View r1 = r7.h(r5, r6)     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x012d:
            r1 = 0
            r7.V = r1     // Catch:{ all -> 0x026a }
            android.view.View r1 = r7.k(r5)     // Catch:{ all -> 0x026a }
            goto L_0x0118
        L_0x0135:
            if (r1 != 0) goto L_0x0144
            r1 = 0
            int r2 = r7.b((int) r1, (boolean) r0)     // Catch:{ all -> 0x026a }
            r7.setSelectedPositionInt(r2)     // Catch:{ all -> 0x026a }
            android.view.View r1 = r7.k(r5)     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x0144:
            int r1 = r7.f29287ao     // Catch:{ all -> 0x026a }
            int r1 = r1 - r0
            r2 = 0
            int r1 = r7.b((int) r1, (boolean) r2)     // Catch:{ all -> 0x026a }
            r7.setSelectedPositionInt(r1)     // Catch:{ all -> 0x026a }
            int r1 = r7.f29287ao     // Catch:{ all -> 0x026a }
            int r1 = r1 - r0
            android.view.View r1 = r7.g(r1, r6)     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x0157:
            int r1 = r7.f29285am     // Catch:{ all -> 0x026a }
            if (r1 < 0) goto L_0x016f
            int r1 = r7.f29285am     // Catch:{ all -> 0x026a }
            int r3 = r7.f29287ao     // Catch:{ all -> 0x026a }
            if (r1 >= r3) goto L_0x016f
            int r1 = r7.f29285am     // Catch:{ all -> 0x026a }
            if (r2 != 0) goto L_0x0166
            goto L_0x016a
        L_0x0166:
            int r5 = r2.getLeft()     // Catch:{ all -> 0x026a }
        L_0x016a:
            android.view.View r1 = r7.i(r1, r5)     // Catch:{ all -> 0x026a }
            goto L_0x0185
        L_0x016f:
            int r1 = r7.V     // Catch:{ all -> 0x026a }
            int r2 = r7.f29287ao     // Catch:{ all -> 0x026a }
            if (r1 >= r2) goto L_0x017f
            int r1 = r7.V     // Catch:{ all -> 0x026a }
            if (r12 != 0) goto L_0x017a
            goto L_0x016a
        L_0x017a:
            int r5 = r12.getLeft()     // Catch:{ all -> 0x026a }
            goto L_0x016a
        L_0x017f:
            r1 = 0
            android.view.View r2 = r7.i(r1, r5)     // Catch:{ all -> 0x026a }
            r1 = r2
        L_0x0185:
            r15.e()     // Catch:{ all -> 0x026a }
            if (r1 == 0) goto L_0x01cc
            boolean r2 = r7.aG     // Catch:{ all -> 0x026a }
            r3 = -1
            if (r2 == 0) goto L_0x01b8
            boolean r2 = r18.hasFocus()     // Catch:{ all -> 0x026a }
            if (r2 == 0) goto L_0x01b8
            boolean r2 = r1.hasFocus()     // Catch:{ all -> 0x026a }
            if (r2 != 0) goto L_0x01b8
            if (r1 != r9) goto L_0x01a5
            if (r10 == 0) goto L_0x01a5
            boolean r2 = r10.requestFocus()     // Catch:{ all -> 0x026a }
            if (r2 != 0) goto L_0x01ad
        L_0x01a5:
            boolean r2 = r1.requestFocus()     // Catch:{ all -> 0x026a }
            if (r2 == 0) goto L_0x01ac
            goto L_0x01ad
        L_0x01ac:
            r0 = 0
        L_0x01ad:
            if (r0 != 0) goto L_0x01bc
            android.view.View r0 = r18.getFocusedChild()     // Catch:{ all -> 0x026a }
            if (r0 == 0) goto L_0x01b8
            r0.clearFocus()     // Catch:{ all -> 0x026a }
        L_0x01b8:
            r7.a((int) r3, (android.view.View) r1)     // Catch:{ all -> 0x026a }
            goto L_0x01c5
        L_0x01bc:
            r2 = 0
            r1.setSelected(r2)     // Catch:{ all -> 0x026a }
            android.graphics.Rect r0 = r7.f29210o     // Catch:{ all -> 0x026a }
            r0.setEmpty()     // Catch:{ all -> 0x026a }
        L_0x01c5:
            int r0 = r1.getLeft()     // Catch:{ all -> 0x026a }
            r7.J = r0     // Catch:{ all -> 0x026a }
            goto L_0x01f9
        L_0x01cc:
            int r0 = r7.F     // Catch:{ all -> 0x026a }
            if (r0 <= 0) goto L_0x01e6
            int r0 = r7.F     // Catch:{ all -> 0x026a }
            r1 = 3
            if (r0 >= r1) goto L_0x01e6
            int r0 = r7.A     // Catch:{ all -> 0x026a }
            int r1 = r7.V     // Catch:{ all -> 0x026a }
            int r0 = r0 - r1
            android.view.View r0 = r7.getChildAt(r0)     // Catch:{ all -> 0x026a }
            if (r0 == 0) goto L_0x01ee
            int r1 = r7.A     // Catch:{ all -> 0x026a }
            r7.a((int) r1, (android.view.View) r0)     // Catch:{ all -> 0x026a }
            goto L_0x01ee
        L_0x01e6:
            r1 = 0
            r7.J = r1     // Catch:{ all -> 0x026a }
            android.graphics.Rect r0 = r7.f29210o     // Catch:{ all -> 0x026a }
            r0.setEmpty()     // Catch:{ all -> 0x026a }
        L_0x01ee:
            boolean r0 = r18.hasFocus()     // Catch:{ all -> 0x026a }
            if (r0 == 0) goto L_0x01f9
            if (r10 == 0) goto L_0x01f9
            r10.requestFocus()     // Catch:{ all -> 0x026a }
        L_0x01f9:
            if (r10 == 0) goto L_0x0204
            android.os.IBinder r0 = r10.getWindowToken()     // Catch:{ all -> 0x026a }
            if (r0 == 0) goto L_0x0204
            r10.onFinishTemporaryDetach()     // Catch:{ all -> 0x026a }
        L_0x0204:
            r1 = 0
            r7.f29203h = r1     // Catch:{ all -> 0x026a }
            r7.f29282aj = r1     // Catch:{ all -> 0x026a }
            java.lang.Runnable r0 = r7.O     // Catch:{ all -> 0x026a }
            if (r0 == 0) goto L_0x0215
            java.lang.Runnable r0 = r7.O     // Catch:{ all -> 0x026a }
            r7.post(r0)     // Catch:{ all -> 0x026a }
            r0 = 0
            r7.O = r0     // Catch:{ all -> 0x026a }
        L_0x0215:
            r1 = 0
            r7.f29276ad = r1     // Catch:{ all -> 0x026a }
            int r0 = r7.f29285am     // Catch:{ all -> 0x026a }
            r7.setNextSelectedPositionInt(r0)     // Catch:{ all -> 0x026a }
            r18.f()     // Catch:{ all -> 0x026a }
            int r0 = r7.f29287ao     // Catch:{ all -> 0x026a }
            if (r0 <= 0) goto L_0x0227
            r18.u()     // Catch:{ all -> 0x026a }
        L_0x0227:
            r18.b()     // Catch:{ all -> 0x026a }
            if (r8 != 0) goto L_0x022f
            r1 = 0
            r7.f29292at = r1
        L_0x022f:
            return
        L_0x0230:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x026a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x026a }
            r1.<init>()     // Catch:{ all -> 0x026a }
            java.lang.String r2 = "The content of the adapter has changed but ListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ListView("
            r1.append(r2)     // Catch:{ all -> 0x026a }
            int r2 = r18.getId()     // Catch:{ all -> 0x026a }
            r1.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r2 = ", "
            r1.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.Class r2 = r18.getClass()     // Catch:{ all -> 0x026a }
            r1.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r2 = ") with Adapter("
            r1.append(r2)     // Catch:{ all -> 0x026a }
            android.widget.ListAdapter r2 = r7.f29205j     // Catch:{ all -> 0x026a }
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x026a }
            r1.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r2 = ")]"
            r1.append(r2)     // Catch:{ all -> 0x026a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x026a }
            r0.<init>(r1)     // Catch:{ all -> 0x026a }
            throw r0     // Catch:{ all -> 0x026a }
        L_0x026a:
            r0 = move-exception
            if (r8 != 0) goto L_0x0270
            r1 = 0
            r7.f29292at = r1
        L_0x0270:
            throw r0
        L_0x0271:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.e():void");
    }

    public void e(int i2, int i3) {
        if (this.f29205j != null) {
            if (!isInTouchMode()) {
                i2 = b(i2, true);
                if (i2 >= 0) {
                    setNextSelectedPositionInt(i2);
                }
            } else {
                this.M = i2;
            }
            if (i2 >= 0) {
                this.f29203h = 4;
                this.W = this.f29216u.left + i3;
                if (this.f29276ad) {
                    this.f29273aa = i2;
                    this.f29274ab = this.f29205j.getItemId(i2);
                }
                if (this.I != null) {
                    this.I.a();
                }
                requestLayout();
            }
        }
    }

    public ListAdapter getAdapter() {
        return this.f29205j;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        if (this.f29205j != null && this.f29205j.hasStableIds()) {
            return getCheckedItemIds();
        }
        if (this.f29193b == 0 || this.f29201f == null || this.f29205j == null) {
            return new long[0];
        }
        SparseBooleanArray sparseBooleanArray = this.f29201f;
        int size = sparseBooleanArray.size();
        long[] jArr = new long[size];
        ListAdapter listAdapter = this.f29205j;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (sparseBooleanArray.valueAt(i3)) {
                jArr[i2] = listAdapter.getItemId(sparseBooleanArray.keyAt(i3));
                i2++;
            }
        }
        if (i2 == size) {
            return jArr;
        }
        long[] jArr2 = new long[i2];
        System.arraycopy(jArr, 0, jArr2, 0, i2);
        return jArr2;
    }

    public Drawable getDivider() {
        return this.f29303au;
    }

    public int getDividerWidth() {
        return this.f29304av;
    }

    public int getFooterViewsCount() {
        return this.aA.size();
    }

    public int getHeaderViewsCount() {
        return this.f29308az.size();
    }

    public boolean getItemsCanFocus() {
        return this.aG;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) (getRight() - getLeft())) * 0.33f);
    }

    public Drawable getOverscrollFooter() {
        return this.f29307ay;
    }

    public Drawable getOverscrollHeader() {
        return this.f29306ax;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(int r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            r2 = 33
            if (r5 != r2) goto L_0x0013
            int r5 = r4.f29285am
            int r2 = r4.getChildCount()
            int r5 = r5 - r2
            int r5 = r5 - r1
            int r5 = java.lang.Math.max(r0, r5)
            goto L_0x0029
        L_0x0013:
            r2 = 130(0x82, float:1.82E-43)
            if (r5 != r2) goto L_0x0028
            int r5 = r4.f29287ao
            int r5 = r5 - r1
            int r2 = r4.f29285am
            int r3 = r4.getChildCount()
            int r2 = r2 + r3
            int r2 = r2 - r1
            int r5 = java.lang.Math.min(r5, r2)
            r2 = 1
            goto L_0x002a
        L_0x0028:
            r5 = -1
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r5 < 0) goto L_0x0068
            int r5 = r4.b((int) r5, (boolean) r2)
            if (r5 < 0) goto L_0x0068
            r0 = 4
            r4.f29203h = r0
            int r0 = r4.getPaddingLeft()
            int r3 = r4.getHorizontalFadingEdgeLength()
            int r0 = r0 + r3
            r4.W = r0
            if (r2 == 0) goto L_0x004e
            int r0 = r4.f29287ao
            int r3 = r4.getChildCount()
            int r0 = r0 - r3
            if (r5 <= r0) goto L_0x004e
            r0 = 3
            r4.f29203h = r0
        L_0x004e:
            if (r2 != 0) goto L_0x0058
            int r0 = r4.getChildCount()
            if (r5 >= r0) goto L_0x0058
            r4.f29203h = r1
        L_0x0058:
            r4.setSelectionInt(r5)
            r4.b()
            boolean r5 = r4.awakenScrollBars()
            if (r5 != 0) goto L_0x0067
            r4.invalidate()
        L_0x0067:
            return r1
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.h(int):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean i(int i2) {
        int b2;
        boolean z2 = false;
        if (i2 == 33) {
            if (this.f29285am != 0) {
                b2 = b(0, true);
                if (b2 >= 0) {
                    this.f29203h = 1;
                }
                z2 = true;
            }
            if (z2 && !awakenScrollBars()) {
                awakenScrollBars();
                invalidate();
            }
            return z2;
        }
        if (i2 == 130 && this.f29285am < this.f29287ao - 1) {
            b2 = b(this.f29287ao - 1, true);
            if (b2 >= 0) {
                this.f29203h = 3;
            }
            z2 = true;
        }
        awakenScrollBars();
        invalidate();
        return z2;
        setSelectionInt(b2);
        b();
        z2 = true;
        awakenScrollBars();
        invalidate();
        return z2;
    }

    public boolean isOpaque() {
        boolean z2 = (this.f29221z && this.aB && this.aC) || super.isOpaque();
        if (z2) {
            int paddingLeft = this.f29216u != null ? this.f29216u.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt != null && childAt.getLeft() <= paddingLeft) {
                int width = getWidth() - (this.f29216u != null ? this.f29216u.right : getPaddingRight());
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2 == null || childAt2.getRight() < width) {
                    return false;
                }
            }
            return false;
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public boolean j(int i2) {
        try {
            this.f29278af = true;
            boolean o2 = o(i2);
            if (o2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
            }
            this.f29278af = false;
            return o2;
        } catch (Throwable th) {
            this.f29278af = false;
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                b(getChildAt(i2));
            }
            removeAllViews();
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        ListAdapter listAdapter = this.f29205j;
        int i3 = 0;
        int i4 = -1;
        if (!(listAdapter == null || !z2 || rect == null)) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.V) {
                this.f29203h = 0;
                e();
            }
            Rect rect2 = this.aH;
            int childCount = getChildCount();
            int i5 = this.V;
            int i6 = 0;
            int i7 = -1;
            int i8 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            while (i3 < childCount) {
                if (listAdapter.isEnabled(i5 + i3)) {
                    View childAt = getChildAt(i3);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int a2 = a(rect, rect2, i2);
                    if (a2 < i8) {
                        i6 = childAt.getLeft();
                        i7 = i3;
                        i8 = a2;
                    }
                }
                i3++;
            }
            i3 = i6;
            i4 = i7;
        }
        if (i4 >= 0) {
            e(i4 + this.V, i3);
        } else {
            requestLayout();
        }
    }

    public void onGlobalLayout() {
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HListView.class.getName());
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return a(i2, 1, keyEvent);
    }

    public boolean onKeyMultiple(int i2, int i3, KeyEvent keyEvent) {
        return a(i2, i3, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        return a(i2, 1, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i7 = 0;
        this.f29287ao = this.f29205j == null ? 0 : this.f29205j.getCount();
        if (this.f29287ao <= 0 || !(mode == 0 || mode2 == 0)) {
            i5 = 0;
            i4 = 0;
        } else {
            Log.d("HListView", "let's measure a scrap child");
            View a2 = a(0, this.P);
            a(a2, 0, i3);
            int measuredWidth = a2.getMeasuredWidth();
            int measuredHeight = a2.getMeasuredHeight();
            if (Build.VERSION.SDK_INT >= 11) {
                i7 = combineMeasuredStates(0, a2.getMeasuredState());
            }
            if (x() && this.f29211p.b(((AbsHListView.LayoutParams) a2.getLayoutParams()).f29226a)) {
                this.f29211p.a(a2, -1);
            }
            i5 = i7;
            i4 = measuredWidth;
            i7 = measuredHeight;
        }
        if (mode2 == 0) {
            size2 = this.f29216u.top + this.f29216u.bottom + i7 + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.f29287ao > 0 && (i6 = this.f29305aw) > -1) {
            size2 = a(i3, i6, i6, size, size2, -1)[1];
        } else if (Build.VERSION.SDK_INT >= 11) {
            size2 |= -16777216 & i5;
        }
        if (mode == 0) {
            size = this.f29216u.left + this.f29216u.right + i4 + (getHorizontalFadingEdgeLength() * 2);
        }
        int i8 = size;
        if (mode == Integer.MIN_VALUE) {
            i8 = a(i3, 0, -1, i8, -1);
        }
        setMeasuredDimension(i8, size2);
        this.f29217v = i3;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.V + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i2 - getPaddingLeft()));
            if (this.aK == null) {
                this.aK = new c();
            }
            post(this.aK.a(indexOfChild, left));
        }
        super.onSizeChanged(i2, i3, i4, i5);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        int i2;
        int i3 = rect.left;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int width = getWidth();
        int scrollX = getScrollX();
        int i4 = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (z() && (this.f29285am > 0 || i3 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        boolean z3 = true;
        int right = getChildAt(getChildCount() - 1).getRight();
        if (A() && (this.f29285am < this.f29287ao - 1 || rect.right < right - horizontalFadingEdgeLength)) {
            i4 -= horizontalFadingEdgeLength;
        }
        if (rect.right > i4 && rect.left > scrollX) {
            i2 = Math.min((rect.width() > width ? rect.left - scrollX : rect.right - i4) + 0, right - i4);
        } else if (rect.left >= scrollX || rect.right >= i4) {
            i2 = 0;
        } else {
            i2 = Math.max(rect.width() > width ? 0 - (i4 - rect.right) : 0 - (scrollX - rect.left), getChildAt(0).getLeft() - scrollX);
        }
        if (i2 == 0) {
            z3 = false;
        }
        if (z3) {
            r(-i2);
            a(-1, view);
            this.J = view.getTop();
            invalidate();
        }
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x008e, code lost:
        if (r3.f29287ao == 0) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAdapter(android.widget.ListAdapter r4) {
        /*
            r3 = this;
            android.widget.ListAdapter r0 = r3.f29205j
            if (r0 == 0) goto L_0x000f
            it.sephiroth.android.library.widget.AbsHListView$a r0 = r3.f29204i
            if (r0 == 0) goto L_0x000f
            android.widget.ListAdapter r0 = r3.f29205j
            it.sephiroth.android.library.widget.AbsHListView$a r1 = r3.f29204i
            r0.unregisterDataSetObserver(r1)
        L_0x000f:
            r3.d()
            it.sephiroth.android.library.widget.AbsHListView$j r0 = r3.f29211p
            r0.b()
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r0 = r3.f29308az
            int r0 = r0.size()
            if (r0 > 0) goto L_0x002b
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r0 = r3.aA
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0028
            goto L_0x002b
        L_0x0028:
            r3.f29205j = r4
            goto L_0x0036
        L_0x002b:
            it.sephiroth.android.library.widget.b r0 = new it.sephiroth.android.library.widget.b
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r1 = r3.f29308az
            java.util.ArrayList<it.sephiroth.android.library.widget.HListView$b> r2 = r3.aA
            r0.<init>(r1, r2, r4)
            r3.f29205j = r0
        L_0x0036:
            r0 = -1
            r3.f29290ar = r0
            r0 = -9223372036854775808
            r3.f29291as = r0
            super.setAdapter((android.widget.ListAdapter) r4)
            android.widget.ListAdapter r4 = r3.f29205j
            r0 = 1
            if (r4 == 0) goto L_0x0091
            android.widget.ListAdapter r4 = r3.f29205j
            boolean r4 = r4.areAllItemsEnabled()
            r3.aF = r4
            int r4 = r3.f29287ao
            r3.f29288ap = r4
            android.widget.ListAdapter r4 = r3.f29205j
            int r4 = r4.getCount()
            r3.f29287ao = r4
            r3.s()
            it.sephiroth.android.library.widget.AbsHListView$a r4 = new it.sephiroth.android.library.widget.AbsHListView$a
            r4.<init>()
            r3.f29204i = r4
            android.widget.ListAdapter r4 = r3.f29205j
            it.sephiroth.android.library.widget.AbsHListView$a r1 = r3.f29204i
            r4.registerDataSetObserver(r1)
            it.sephiroth.android.library.widget.AbsHListView$j r4 = r3.f29211p
            android.widget.ListAdapter r1 = r3.f29205j
            int r1 = r1.getViewTypeCount()
            r4.a(r1)
            boolean r4 = r3.K
            r1 = 0
            if (r4 == 0) goto L_0x0082
            int r4 = r3.f29287ao
            int r4 = r4 - r0
            int r4 = r3.b((int) r4, (boolean) r1)
            goto L_0x0086
        L_0x0082:
            int r4 = r3.b((int) r1, (boolean) r0)
        L_0x0086:
            r3.setSelectedPositionInt(r4)
            r3.setNextSelectedPositionInt(r4)
            int r4 = r3.f29287ao
            if (r4 != 0) goto L_0x0099
            goto L_0x0096
        L_0x0091:
            r3.aF = r0
            r3.s()
        L_0x0096:
            r3.u()
        L_0x0099:
            r3.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.setAdapter(android.widget.ListAdapter):void");
    }

    public void setCacheColorHint(int i2) {
        boolean z2 = (i2 >>> 24) == 255;
        this.aB = z2;
        if (z2) {
            if (this.aI == null) {
                this.aI = new Paint();
            }
            this.aI.setColor(i2);
        }
        super.setCacheColorHint(i2);
    }

    public void setDivider(Drawable drawable) {
        Log.i("HListView", "setDivider: " + drawable);
        boolean z2 = false;
        if (drawable != null) {
            this.f29304av = drawable.getIntrinsicWidth();
        } else {
            this.f29304av = 0;
        }
        this.f29303au = drawable;
        if (drawable == null || drawable.getOpacity() == -1) {
            z2 = true;
        }
        this.aC = z2;
        requestLayout();
        invalidate();
    }

    public void setDividerWidth(int i2) {
        Log.i("HListView", "setDividerWidth: " + i2);
        this.f29304av = i2;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z2) {
        this.aE = z2;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z2) {
        this.aD = z2;
        invalidate();
    }

    public void setItemsCanFocus(boolean z2) {
        this.aG = z2;
        if (!z2) {
            setDescendantFocusability(393216);
        }
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.f29307ay = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.f29306ax = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    public void setSelection(int i2) {
        e(i2, 0);
    }

    public void setSelectionInt(int i2) {
        setNextSelectedPositionInt(i2);
        int i3 = this.f29285am;
        boolean z2 = true;
        if (i3 < 0 || !(i2 == i3 - 1 || i2 == i3 + 1)) {
            z2 = false;
        }
        if (this.I != null) {
            this.I.a();
        }
        e();
        if (z2) {
            awakenScrollBars();
        }
    }

    /* access modifiers changed from: protected */
    @ViewDebug.ExportedProperty(category = "list")
    public boolean x() {
        return true;
    }
}
