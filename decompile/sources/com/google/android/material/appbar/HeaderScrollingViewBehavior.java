package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.blankj.utilcode.constant.MemoryConstants;
import java.util.List;
import o.a;
import t.ac;
import t.ak;
import t.f;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: a  reason: collision with root package name */
    final Rect f18470a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    final Rect f18471b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private int f18472c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f18473d;

    public HeaderScrollingViewBehavior() {
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int c(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public float a(View view) {
        return 1.0f;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View b2;
        ak lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (b2 = b(coordinatorLayout.c(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ac.x(b2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.b() + lastWindowInsets.d();
        }
        int b3 = size + b(b2);
        int measuredHeight = b2.getMeasuredHeight();
        if (b()) {
            view.setTranslationY((float) (-measuredHeight));
        } else {
            b3 -= measuredHeight;
        }
        coordinatorLayout.a(view, i2, i3, View.MeasureSpec.makeMeasureSpec(b3, i6 == -1 ? MemoryConstants.GB : Integer.MIN_VALUE), i5);
        return true;
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public abstract View b(List<View> list);

    public final void b(int i2) {
        this.f18473d = i2;
    }

    /* access modifiers changed from: protected */
    public void b(CoordinatorLayout coordinatorLayout, View view, int i2) {
        int i3;
        View b2 = b(coordinatorLayout.c(view));
        if (b2 != null) {
            CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
            Rect rect = this.f18470a;
            rect.set(coordinatorLayout.getPaddingLeft() + dVar.leftMargin, b2.getBottom() + dVar.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - dVar.rightMargin, ((coordinatorLayout.getHeight() + b2.getBottom()) - coordinatorLayout.getPaddingBottom()) - dVar.bottomMargin);
            ak lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ac.x(coordinatorLayout) && !ac.x(view)) {
                rect.left += lastWindowInsets.a();
                rect.right -= lastWindowInsets.c();
            }
            Rect rect2 = this.f18471b;
            f.a(c(dVar.f2755c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int c2 = c(b2);
            view.layout(rect2.left, rect2.top - c2, rect2.right, rect2.bottom - c2);
            i3 = rect2.top - b2.getBottom();
        } else {
            super.b(coordinatorLayout, view, i2);
            i3 = 0;
        }
        this.f18472c = i3;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int c(View view) {
        if (this.f18473d == 0) {
            return 0;
        }
        float a2 = a(view);
        int i2 = this.f18473d;
        return a.a((int) (a2 * ((float) i2)), 0, i2);
    }

    /* access modifiers changed from: package-private */
    public final int d() {
        return this.f18472c;
    }

    public final int e() {
        return this.f18473d;
    }
}
