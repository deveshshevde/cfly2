package com.google.android.material.navigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;

public final class a extends g {

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f19411d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19412e;

    public a(Context context, Class<?> cls, int i2) {
        super(context);
        this.f19411d = cls;
        this.f19412e = i2;
    }

    /* access modifiers changed from: protected */
    public MenuItem a(int i2, int i3, int i4, CharSequence charSequence) {
        if (size() + 1 <= this.f19412e) {
            h();
            MenuItem a2 = super.a(i2, i3, i4, charSequence);
            if (a2 instanceof i) {
                ((i) a2).a(true);
            }
            i();
            return a2;
        }
        String simpleName = this.f19411d.getSimpleName();
        throw new IllegalArgumentException("Maximum number of items supported by " + simpleName + " is " + this.f19412e + ". Limit can be checked with " + simpleName + "#getMaxItemCount()");
    }

    public SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f19411d.getSimpleName() + " does not support submenus");
    }
}
