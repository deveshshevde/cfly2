package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import t.ac;

public class BottomNavigationMenuView extends NavigationBarMenuView {

    /* renamed from: a  reason: collision with root package name */
    private final int f18600a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18601b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18602c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18603d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18604e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18605f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f18606g = new int[5];

    public BottomNavigationMenuView(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f18600a = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.f18601b = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.f18602c = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.f18603d = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.f18604e = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    }

    /* access modifiers changed from: protected */
    public NavigationBarItemView a(Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean a() {
        return this.f18605f;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ac.i(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        g menu = getMenu();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = menu.j().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f18604e, MemoryConstants.GB);
        if (!a(getLabelVisibilityMode(), size2) || !a()) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.f18602c);
            int i4 = size - (size2 * min);
            for (int i5 = 0; i5 < childCount; i5++) {
                if (getChildAt(i5).getVisibility() != 8) {
                    int[] iArr = this.f18606g;
                    iArr[i5] = min;
                    if (i4 > 0) {
                        iArr[i5] = iArr[i5] + 1;
                        i4--;
                    }
                } else {
                    this.f18606g[i5] = 0;
                }
            }
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            int i6 = this.f18603d;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f18602c, Integer.MIN_VALUE), makeMeasureSpec);
                i6 = Math.max(i6, childAt.getMeasuredWidth());
            }
            int i7 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.f18601b * i7), Math.min(i6, this.f18602c));
            int i8 = size - min2;
            int min3 = Math.min(i8 / (i7 == 0 ? 1 : i7), this.f18600a);
            int i9 = i8 - (i7 * min3);
            int i10 = 0;
            while (i10 < childCount) {
                if (getChildAt(i10).getVisibility() != 8) {
                    this.f18606g[i10] = i10 == getSelectedItemPosition() ? min2 : min3;
                    if (i9 > 0) {
                        int[] iArr2 = this.f18606g;
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.f18606g[i10] = 0;
                }
                i10++;
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.f18606g[i12], MemoryConstants.GB), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, MemoryConstants.GB), 0), View.resolveSizeAndState(this.f18604e, makeMeasureSpec, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        this.f18605f = z2;
    }
}
