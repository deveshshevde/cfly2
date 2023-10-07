package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class ActionMenuView extends LinearLayoutCompat implements g.b, n {

    /* renamed from: a  reason: collision with root package name */
    g.a f1055a;

    /* renamed from: b  reason: collision with root package name */
    d f1056b;

    /* renamed from: c  reason: collision with root package name */
    private g f1057c;

    /* renamed from: d  reason: collision with root package name */
    private Context f1058d;

    /* renamed from: e  reason: collision with root package name */
    private int f1059e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1060f;

    /* renamed from: g  reason: collision with root package name */
    private ActionMenuPresenter f1061g;

    /* renamed from: h  reason: collision with root package name */
    private m.a f1062h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1063i;

    /* renamed from: j  reason: collision with root package name */
    private int f1064j;

    /* renamed from: k  reason: collision with root package name */
    private int f1065k;

    /* renamed from: l  reason: collision with root package name */
    private int f1066l;

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f1067a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f1068b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f1069c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f1070d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f1071e;

        /* renamed from: f  reason: collision with root package name */
        boolean f1072f;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f1067a = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1067a = layoutParams.f1067a;
        }
    }

    public interface a {
        boolean c();

        boolean d();
    }

    private static class b implements m.a {
        b() {
        }

        public void a(g gVar, boolean z2) {
        }

        public boolean a(g gVar) {
            return false;
        }
    }

    private class c implements g.a {
        c() {
        }

        public void a(g gVar) {
            if (ActionMenuView.this.f1055a != null) {
                ActionMenuView.this.f1055a.a(gVar);
            }
        }

        public boolean a(g gVar, MenuItem menuItem) {
            return ActionMenuView.this.f1056b != null && ActionMenuView.this.f1056b.a(menuItem);
        }
    }

    public interface d {
        boolean a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.f1065k = (int) (56.0f * f2);
        this.f1066l = (int) (f2 * 4.0f);
        this.f1058d = context;
        this.f1059e = 0;
    }

    static int a(View view, int i2, int i3, int i4, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = true;
        boolean z3 = actionMenuItemView != null && actionMenuItemView.b();
        int i6 = 2;
        if (i3 <= 0 || (z3 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z3 || i7 >= 2) {
                i6 = i7;
            }
        }
        if (layoutParams.f1067a || !z3) {
            z2 = false;
        }
        layoutParams.f1070d = z2;
        layoutParams.f1068b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, MemoryConstants.GB), makeMeasureSpec);
        return i6;
    }

    private void c(int i2, int i3) {
        int i4;
        boolean z2;
        int i5;
        int i6;
        boolean z3;
        boolean z4;
        int i7;
        boolean z5;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i3, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.f1065k;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        boolean z6 = false;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        long j2 = 0;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            int i18 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i19 = i15 + 1;
                if (z7) {
                    int i20 = this.f1066l;
                    i7 = i19;
                    z5 = false;
                    childAt.setPadding(i20, 0, i20, 0);
                } else {
                    i7 = i19;
                    z5 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f1072f = z5;
                layoutParams.f1069c = z5 ? 1 : 0;
                layoutParams.f1068b = z5;
                layoutParams.f1070d = z5;
                layoutParams.leftMargin = z5;
                layoutParams.rightMargin = z5;
                layoutParams.f1071e = z7 && ((ActionMenuItemView) childAt).b();
                int a2 = a(childAt, i12, layoutParams.f1067a ? 1 : i10, childMeasureSpec, paddingTop);
                i16 = Math.max(i16, a2);
                if (layoutParams.f1070d) {
                    i17++;
                }
                if (layoutParams.f1067a) {
                    z6 = true;
                }
                i10 -= a2;
                i13 = Math.max(i13, childAt.getMeasuredHeight());
                if (a2 == 1) {
                    j2 |= (long) (1 << i14);
                    i13 = i13;
                } else {
                    int i21 = i13;
                }
                i15 = i7;
            }
            i14++;
            size2 = i18;
        }
        int i22 = size2;
        boolean z8 = z6 && i15 == 2;
        boolean z9 = false;
        while (true) {
            if (i17 <= 0 || i10 <= 0) {
                i6 = mode;
                i4 = i8;
                z2 = z9;
                i5 = i13;
            } else {
                int i23 = 0;
                int i24 = 0;
                int i25 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                long j3 = 0;
                while (i24 < childCount) {
                    boolean z10 = z9;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i24).getLayoutParams();
                    int i26 = i13;
                    if (layoutParams2.f1070d) {
                        if (layoutParams2.f1068b < i25) {
                            i25 = layoutParams2.f1068b;
                            j3 = 1 << i24;
                            i23 = 1;
                        } else if (layoutParams2.f1068b == i25) {
                            i23++;
                            j3 |= 1 << i24;
                        }
                    }
                    i24++;
                    i13 = i26;
                    z9 = z10;
                }
                z2 = z9;
                i5 = i13;
                j2 |= j3;
                if (i23 > i10) {
                    i6 = mode;
                    i4 = i8;
                    break;
                }
                int i27 = i25 + 1;
                int i28 = 0;
                while (i28 < childCount) {
                    View childAt2 = getChildAt(i28);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i29 = i8;
                    int i30 = mode;
                    long j4 = (long) (1 << i28);
                    if ((j3 & j4) == 0) {
                        if (layoutParams3.f1068b == i27) {
                            j2 |= j4;
                        }
                        z4 = z8;
                    } else {
                        if (!z8 || !layoutParams3.f1071e || i10 != 1) {
                            z4 = z8;
                        } else {
                            int i31 = this.f1066l;
                            z4 = z8;
                            childAt2.setPadding(i31 + i12, 0, i31, 0);
                        }
                        layoutParams3.f1068b++;
                        layoutParams3.f1072f = true;
                        i10--;
                    }
                    i28++;
                    mode = i30;
                    i8 = i29;
                    z8 = z4;
                }
                i13 = i5;
                z9 = true;
            }
        }
        boolean z11 = !z6 && i15 == 1;
        if (i10 <= 0 || j2 == 0 || (i10 >= i15 - 1 && !z11 && i16 <= 1)) {
            z3 = z2;
        } else {
            float bitCount = (float) Long.bitCount(j2);
            if (!z11) {
                if ((j2 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f1071e) {
                    bitCount -= 0.5f;
                }
                int i32 = childCount - 1;
                if ((j2 & ((long) (1 << i32))) != 0 && !((LayoutParams) getChildAt(i32).getLayoutParams()).f1071e) {
                    bitCount -= 0.5f;
                }
            }
            int i33 = bitCount > 0.0f ? (int) (((float) (i10 * i12)) / bitCount) : 0;
            z3 = z2;
            for (int i34 = 0; i34 < childCount; i34++) {
                if ((j2 & ((long) (1 << i34))) != 0) {
                    View childAt3 = getChildAt(i34);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f1069c = i33;
                        layoutParams4.f1072f = true;
                        if (i34 == 0 && !layoutParams4.f1071e) {
                            layoutParams4.leftMargin = (-i33) / 2;
                        }
                    } else if (layoutParams4.f1067a) {
                        layoutParams4.f1069c = i33;
                        layoutParams4.f1072f = true;
                        layoutParams4.rightMargin = (-i33) / 2;
                    } else {
                        if (i34 != 0) {
                            layoutParams4.leftMargin = i33 / 2;
                        }
                        if (i34 != childCount - 1) {
                            layoutParams4.rightMargin = i33 / 2;
                        }
                    }
                    z3 = true;
                }
            }
        }
        if (z3) {
            for (int i35 = 0; i35 < childCount; i35++) {
                View childAt4 = getChildAt(i35);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f1072f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f1068b * i12) + layoutParams5.f1069c, MemoryConstants.GB), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i6 != 1073741824 ? i5 : i22);
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return j();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    public void a(g gVar) {
        this.f1057c = gVar;
    }

    public void a(m.a aVar, g.a aVar2) {
        this.f1062h = aVar;
        this.f1055a = aVar2;
    }

    public boolean a() {
        return this.f1060f;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2) {
        boolean z2 = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z2 = false | ((a) childAt).d();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z2 : z2 | ((a) childAt2).c();
    }

    public boolean a(i iVar) {
        return this.f1057c.a((MenuItem) iVar, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutParams j() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams c() {
        LayoutParams b2 = j();
        b2.f1067a = true;
        return b2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public g d() {
        return this.f1057c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public boolean e() {
        ActionMenuPresenter actionMenuPresenter = this.f1061g;
        return actionMenuPresenter != null && actionMenuPresenter.e();
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.f1061g;
        return actionMenuPresenter != null && actionMenuPresenter.g();
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.f1061g;
        return actionMenuPresenter != null && actionMenuPresenter.j();
    }

    public Menu getMenu() {
        if (this.f1057c == null) {
            Context context = getContext();
            g gVar = new g(context);
            this.f1057c = gVar;
            gVar.a((g.a) new c());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f1061g = actionMenuPresenter;
            actionMenuPresenter.b(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f1061g;
            m.a aVar = this.f1062h;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.a(aVar);
            this.f1057c.a((m) this.f1061g, this.f1058d);
            this.f1061g.a(this);
        }
        return this.f1057c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1061g.d();
    }

    public int getPopupTheme() {
        return this.f1059e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.f1061g;
        return actionMenuPresenter != null && actionMenuPresenter.k();
    }

    public void i() {
        ActionMenuPresenter actionMenuPresenter = this.f1061g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.h();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f1061g;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.a(false);
            if (this.f1061g.j()) {
                this.f1061g.g();
                this.f1061g.e();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (!this.f1063i) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i4 - i2;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = al.a(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1067a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (a(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i6 = getPaddingLeft() + layoutParams.leftMargin;
                        i7 = i6 + measuredWidth;
                    } else {
                        i7 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i6 = i7 - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i6, i13, i7, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    a(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        int max = Math.max(0, i16 > 0 ? paddingRight / i16 : 0);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f1067a) {
                    int i18 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width = i18 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f1067a) {
                int i21 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        g gVar;
        boolean z2 = this.f1063i;
        boolean z3 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.f1063i = z3;
        if (z2 != z3) {
            this.f1064j = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.f1063i || (gVar = this.f1057c) == null || size == this.f1064j)) {
            this.f1064j = size;
            gVar.b(true);
        }
        int childCount = getChildCount();
        if (!this.f1063i || childCount <= 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        c(i2, i3);
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.f1061g.c(z2);
    }

    public void setOnMenuItemClickListener(d dVar) {
        this.f1056b = dVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1061g.a(drawable);
    }

    public void setOverflowReserved(boolean z2) {
        this.f1060f = z2;
    }

    public void setPopupTheme(int i2) {
        if (this.f1059e != i2) {
            this.f1059e = i2;
            if (i2 == 0) {
                this.f1058d = getContext();
            } else {
                this.f1058d = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f1061g = actionMenuPresenter;
        actionMenuPresenter.a(this);
    }
}
