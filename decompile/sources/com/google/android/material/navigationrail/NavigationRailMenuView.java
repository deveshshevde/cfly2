package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

public class NavigationRailMenuView extends NavigationBarMenuView {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout.LayoutParams f19413a;

    public NavigationRailMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f19413a = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    private int a(int i2, int i3, int i4) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), i3 / Math.max(1, i4)), 0);
    }

    private int a(int i2, int i3, int i4, View view) {
        a(i2, i3, i4);
        int a2 = view == null ? a(i2, i3, i4) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != view) {
                i5 += a(childAt, i2, a2);
            }
        }
        return i5;
    }

    private int a(View view, int i2, int i3) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i2, i3);
        return view.getMeasuredHeight();
    }

    private int b(int i2, int i3, int i4) {
        int i5;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i5 = a(childAt, i2, a(i2, i3, i4));
            i3 -= i5;
            i4--;
        } else {
            i5 = 0;
        }
        return i5 + a(i2, i3, i4, childAt);
    }

    /* access modifiers changed from: protected */
    public NavigationBarItemView a(Context context) {
        return new a(context);
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return (this.f19413a.gravity & 112) == 48;
    }

    /* access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.f19413a.gravity;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                childAt.layout(0, i7, i6, measuredHeight);
                i7 = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = getMenu().j().size();
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i2), i2, 0), View.resolveSizeAndState((size2 <= 1 || !a(getLabelVisibilityMode(), size2)) ? a(i2, size, size2, (View) null) : b(i2, size, size2), i3, 0));
    }

    /* access modifiers changed from: package-private */
    public void setMenuGravity(int i2) {
        if (this.f19413a.gravity != i2) {
            this.f19413a.gravity = i2;
            setLayoutParams(this.f19413a);
        }
    }
}
