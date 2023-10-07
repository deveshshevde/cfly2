package jc;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import ja.i;

public class a {
    public static void a(View view, i iVar, final jb.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                iVar.a().e(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).a((AppBarLayout.b) new AppBarLayout.b() {
                            public void a(AppBarLayout appBarLayout, int i2) {
                                jb.a aVar = aVar;
                                boolean z2 = true;
                                boolean z3 = i2 >= 0;
                                if (appBarLayout.getTotalScrollRange() + i2 > 0) {
                                    z2 = false;
                                }
                                aVar.a(z3, z2);
                            }
                        });
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
