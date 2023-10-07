package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private a f18478a;

    /* renamed from: b  reason: collision with root package name */
    private int f18479b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f18480c = 0;

    public ViewOffsetBehavior() {
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(int i2) {
        a aVar = this.f18478a;
        if (aVar != null) {
            return aVar.a(i2);
        }
        this.f18479b = i2;
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        b(coordinatorLayout, v2, i2);
        if (this.f18478a == null) {
            this.f18478a = new a(v2);
        }
        this.f18478a.a();
        this.f18478a.b();
        int i3 = this.f18479b;
        if (i3 != 0) {
            this.f18478a.a(i3);
            this.f18479b = 0;
        }
        int i4 = this.f18480c;
        if (i4 == 0) {
            return true;
        }
        this.f18478a.b(i4);
        this.f18480c = 0;
        return true;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        coordinatorLayout.b((View) v2, i2);
    }

    public int c() {
        a aVar = this.f18478a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }
}
