package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f5021a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayoutManager f5022b;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f5021a = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    a(LinearLayoutManager linearLayoutManager) {
        this.f5022b = linearLayoutManager;
    }

    private static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(viewGroup.getChildAt(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean b() {
        int i2;
        int i3;
        int i4;
        int i5;
        int z2 = this.f5022b.z();
        if (z2 == 0) {
            return true;
        }
        boolean z3 = this.f5022b.h() == 0;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = z2;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i6 = 0;
        while (i6 < z2) {
            View i7 = this.f5022b.i(i6);
            if (i7 != null) {
                ViewGroup.LayoutParams layoutParams = i7.getLayoutParams();
                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : f5021a;
                int[] iArr3 = iArr2[i6];
                if (z3) {
                    i3 = i7.getLeft();
                    i2 = marginLayoutParams.leftMargin;
                } else {
                    i3 = i7.getTop();
                    i2 = marginLayoutParams.topMargin;
                }
                iArr3[0] = i3 - i2;
                int[] iArr4 = iArr2[i6];
                if (z3) {
                    i5 = i7.getRight();
                    i4 = marginLayoutParams.rightMargin;
                } else {
                    i5 = i7.getBottom();
                    i4 = marginLayoutParams.bottomMargin;
                }
                iArr4[1] = i5 + i4;
                i6++;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr2, new Comparator<int[]>() {
            /* renamed from: a */
            public int compare(int[] iArr, int[] iArr2) {
                return iArr[0] - iArr2[0];
            }
        });
        for (int i8 = 1; i8 < z2; i8++) {
            if (iArr2[i8 - 1][1] != iArr2[i8][0]) {
                return false;
            }
        }
        return iArr2[0][0] <= 0 && iArr2[z2 - 1][1] >= iArr2[0][1] - iArr2[0][0];
    }

    private boolean c() {
        int z2 = this.f5022b.z();
        for (int i2 = 0; i2 < z2; i2++) {
            if (a(this.f5022b.i(i2))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return (!b() || this.f5022b.z() <= 1) && c();
    }
}
