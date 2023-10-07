package com.afollestad.materialdialogs.internal.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import ay.e;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.jvm.internal.h;

public final class DialogScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private DialogLayout f7608a;

    public DialogScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private final boolean b() {
        View childAt = getChildAt(0);
        h.a((Object) childAt, "getChildAt(0)");
        return childAt.getMeasuredHeight() > getHeight();
    }

    /* access modifiers changed from: private */
    public final void c() {
        setOverScrollMode((getChildCount() == 0 || getMeasuredHeight() == 0 || !b()) ? 2 : 1);
    }

    public final void a() {
        boolean z2 = false;
        if (getChildCount() == 0 || getMeasuredHeight() == 0 || !b()) {
            DialogLayout dialogLayout = this.f7608a;
            if (dialogLayout != null) {
                dialogLayout.a(false, false);
                return;
            }
            return;
        }
        View childAt = getChildAt(getChildCount() - 1);
        h.a((Object) childAt, Promotion.ACTION_VIEW);
        int bottom = childAt.getBottom() - (getMeasuredHeight() + getScrollY());
        DialogLayout dialogLayout2 = this.f7608a;
        if (dialogLayout2 != null) {
            boolean z3 = getScrollY() > 0;
            if (bottom > 0) {
                z2 = true;
            }
            dialogLayout2.a(z3, z2);
        }
    }

    public final DialogLayout getRootView() {
        return this.f7608a;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.f5573a.a(this, DialogScrollView$onAttachedToWindow$1.f7609a);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a();
    }

    public final void setRootView(DialogLayout dialogLayout) {
        this.f7608a = dialogLayout;
    }
}
