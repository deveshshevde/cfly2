package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import gr.b;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f19997a = 0;

    public ExpandableBehavior() {
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private boolean a(boolean z2) {
        if (!z2) {
            return this.f19997a == 1;
        }
        int i2 = this.f19997a;
        return i2 == 0 || i2 == 2;
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(View view, View view2, boolean z2, boolean z3);

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = e(r3, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r3, final android.view.View r4, int r5) {
        /*
            r2 = this;
            boolean r5 = t.ac.G(r4)
            if (r5 != 0) goto L_0x002d
            gr.b r3 = r2.e(r3, r4)
            if (r3 == 0) goto L_0x002d
            boolean r5 = r3.a()
            boolean r5 = r2.a((boolean) r5)
            if (r5 == 0) goto L_0x002d
            boolean r5 = r3.a()
            if (r5 == 0) goto L_0x001e
            r5 = 1
            goto L_0x001f
        L_0x001e:
            r5 = 2
        L_0x001f:
            r2.f19997a = r5
            android.view.ViewTreeObserver r0 = r4.getViewTreeObserver()
            com.google.android.material.transformation.ExpandableBehavior$1 r1 = new com.google.android.material.transformation.ExpandableBehavior$1
            r1.<init>(r4, r5, r3)
            r0.addOnPreDrawListener(r1)
        L_0x002d:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.ExpandableBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int):boolean");
    }

    public abstract boolean a(CoordinatorLayout coordinatorLayout, View view, View view2);

    public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        b bVar = (b) view2;
        if (!a(bVar.a())) {
            return false;
        }
        this.f19997a = bVar.a() ? 1 : 2;
        return a((View) bVar, view, bVar.a(), true);
    }

    /* access modifiers changed from: protected */
    public b e(CoordinatorLayout coordinatorLayout, View view) {
        List<View> c2 = coordinatorLayout.c(view);
        int size = c2.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view2 = c2.get(i2);
            if (a(coordinatorLayout, view, view2)) {
                return (b) view2;
            }
        }
        return null;
    }
}
