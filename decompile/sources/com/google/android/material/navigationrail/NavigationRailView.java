package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.af;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.internal.l;
import com.google.android.material.navigation.NavigationBarView;

public class NavigationRailView extends NavigationBarView {

    /* renamed from: a  reason: collision with root package name */
    private final int f19414a;

    /* renamed from: b  reason: collision with root package name */
    private View f19415b;

    public NavigationRailView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f19414a = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        af b2 = l.b(getContext(), attributeSet, R.styleable.NavigationRailView, i2, i3, new int[0]);
        int g2 = b2.g(R.styleable.NavigationRailView_headerLayout, 0);
        if (g2 != 0) {
            b(g2);
        }
        setMenuGravity(b2.a(R.styleable.NavigationRailView_menuGravity, 49));
        b2.b();
    }

    private boolean b() {
        View view = this.f19415b;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int c(int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i2;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), MemoryConstants.GB);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    public void a() {
        View view = this.f19415b;
        if (view != null) {
            removeView(view);
            this.f19415b = null;
        }
    }

    public void a(View view) {
        a();
        this.f19415b = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.f19414a;
        addView(view, 0, layoutParams);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public NavigationRailMenuView a(Context context) {
        return new NavigationRailMenuView(context);
    }

    public void b(int i2) {
        a(LayoutInflater.from(getContext()).inflate(i2, this, false));
    }

    public View getHeaderView() {
        return this.f19415b;
    }

    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i6 = 0;
        if (b()) {
            int bottom = this.f19415b.getBottom() + this.f19414a;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i6 = bottom - top;
            }
        } else if (navigationRailMenuView.a()) {
            i6 = this.f19414a;
        }
        if (i6 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i6, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i6);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int c2 = c(i2);
        super.onMeasure(c2, i3);
        if (b()) {
            measureChild(getNavigationRailMenuView(), c2, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.f19415b.getMeasuredHeight()) - this.f19414a, Integer.MIN_VALUE));
        }
    }

    public void setMenuGravity(int i2) {
        getNavigationRailMenuView().setMenuGravity(i2);
    }
}
