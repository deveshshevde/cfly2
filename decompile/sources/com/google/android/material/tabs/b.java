package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.s;
import com.google.android.material.tabs.TabLayout;
import gl.a;

class b {
    b() {
    }

    static RectF a(TabLayout.TabView tabView, int i2) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int a2 = (int) s.a(tabView.getContext(), i2);
        if (contentWidth < a2) {
            contentWidth = a2;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i3 = contentWidth / 2;
        return new RectF((float) (left - i3), (float) (top - (contentHeight / 2)), (float) (i3 + left), (float) (top + (left / 2)));
    }

    static RectF a(TabLayout tabLayout, View view) {
        return view == null ? new RectF() : (tabLayout.d() || !(view instanceof TabLayout.TabView)) ? new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom()) : a((TabLayout.TabView) view, 24);
    }

    /* access modifiers changed from: package-private */
    public void a(TabLayout tabLayout, View view, Drawable drawable) {
        RectF a2 = a(tabLayout, view);
        drawable.setBounds((int) a2.left, drawable.getBounds().top, (int) a2.right, drawable.getBounds().bottom);
    }

    /* access modifiers changed from: package-private */
    public void a(TabLayout tabLayout, View view, View view2, float f2, Drawable drawable) {
        RectF a2 = a(tabLayout, view);
        RectF a3 = a(tabLayout, view2);
        drawable.setBounds(a.a((int) a2.left, (int) a3.left, f2), drawable.getBounds().top, a.a((int) a2.right, (int) a3.right, f2), drawable.getBounds().bottom);
    }
}
