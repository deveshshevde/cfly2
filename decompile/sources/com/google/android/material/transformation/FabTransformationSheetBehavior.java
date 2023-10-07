package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.transformation.FabTransformationBehavior;
import gl.h;
import gl.j;
import java.util.HashMap;
import java.util.Map;
import t.ac;

@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* renamed from: a  reason: collision with root package name */
    private Map<View, Integer> f20028a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(View view, boolean z2) {
        int i2;
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z2) {
                this.f20028a = new HashMap(childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.d) && (((CoordinatorLayout.d) childAt.getLayoutParams()).b() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z3) {
                    if (!z2) {
                        Map<View, Integer> map = this.f20028a;
                        if (map != null && map.containsKey(childAt)) {
                            i2 = this.f20028a.get(childAt).intValue();
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f20028a.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        i2 = 4;
                    }
                    ac.b(childAt, i2);
                }
            }
            if (!z2) {
                this.f20028a = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public FabTransformationBehavior.a a(Context context, boolean z2) {
        int i2 = z2 ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.a aVar = new FabTransformationBehavior.a();
        aVar.f20021a = h.a(context, i2);
        aVar.f20022b = new j(17, 0.0f, 0.0f);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public boolean a(View view, View view2, boolean z2, boolean z3) {
        a(view2, z2);
        return super.a(view, view2, z2, z3);
    }
}
