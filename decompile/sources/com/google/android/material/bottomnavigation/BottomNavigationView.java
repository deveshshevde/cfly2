package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.af;
import com.google.android.material.R;
import com.google.android.material.internal.l;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import gw.h;

public class BottomNavigationView extends NavigationBarView {

    @Deprecated
    public interface a extends NavigationBarView.a {
    }

    @Deprecated
    public interface b extends NavigationBarView.b {
    }

    public BottomNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Context context2 = getContext();
        af b2 = l.b(context2, attributeSet, R.styleable.BottomNavigationView, i2, i3, new int[0]);
        setItemHorizontalTranslationEnabled(b2.a(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        b2.b();
        if (a()) {
            b(context2);
        }
    }

    private boolean a() {
        return Build.VERSION.SDK_INT < 21 && !(getBackground() instanceof h);
    }

    private void b(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.b.c(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    /* access modifiers changed from: protected */
    public NavigationBarMenuView a(Context context) {
        return new BottomNavigationMenuView(context);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public void setItemHorizontalTranslationEnabled(boolean z2) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.a() != z2) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z2);
            getPresenter().a(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(b bVar) {
        setOnItemSelectedListener(bVar);
    }
}
