package jc;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.constant.MemoryConstants;
import t.m;
import t.q;
import t.z;

public class b implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public static int f13807a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f13808b = 1;

    /* renamed from: d  reason: collision with root package name */
    private static float f13809d = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: e  reason: collision with root package name */
    private static final float f13810e;

    /* renamed from: f  reason: collision with root package name */
    private static final float f13811f;

    /* renamed from: c  reason: collision with root package name */
    private int f13812c;

    static {
        float b2 = 1.0f / b(1.0f);
        f13810e = b2;
        f13811f = 1.0f - (b2 * b(1.0f));
    }

    public b(int i2) {
        this.f13812c = i2;
    }

    public static float a(int i2) {
        return ((float) i2) / f13809d;
    }

    public static int a(float f2) {
        return (int) ((f2 * f13809d) + 0.5f);
    }

    public static int a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        view.measure(ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width), layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec(layoutParams.height, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    public static void a(View view, int i2) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i2);
        } else if (view instanceof AbsListView) {
            if (Build.VERSION.SDK_INT >= 21) {
                ((AbsListView) view).fling(i2);
            }
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i2);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).f(i2);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).b(0, i2);
        }
    }

    public static void a(AbsListView absListView, int i2) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            absListView.scrollListBy(i2);
        } else if (absListView instanceof ListView) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition != -1 && (childAt = absListView.getChildAt(0)) != null) {
                ((ListView) absListView).setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i2);
            }
        } else {
            absListView.smoothScrollBy(i2, 0);
        }
    }

    public static boolean a(View view, PointF pointF) {
        if (b(view, -1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        PointF pointF2 = new PointF();
        while (childCount > 0) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (!a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                childCount--;
            } else if ("fixed".equals(childAt.getTag()) || "fixed-bottom".equals(childAt.getTag())) {
                return false;
            } else {
                pointF.offset(pointF2.x, pointF2.y);
                boolean a2 = a(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return a2;
            }
        }
        return true;
    }

    public static boolean a(View view, PointF pointF, boolean z2) {
        if (b(view, 1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !b(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            PointF pointF2 = new PointF();
            while (childCount > 0) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (!a(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    childCount--;
                } else if ("fixed".equals(childAt.getTag()) || "fixed-top".equals(childAt.getTag())) {
                    return false;
                } else {
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean a2 = a(childAt, pointF, z2);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return a2;
                }
            }
        }
        return z2 || b(view, -1);
    }

    public static boolean a(View view, View view2, float f2, float f3, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f2, f3};
        fArr[0] = fArr[0] + ((float) (view.getScrollX() - view2.getLeft()));
        fArr[1] = fArr[1] + ((float) (view.getScrollY() - view2.getTop()));
        boolean z2 = fArr[0] >= 0.0f && fArr[1] >= 0.0f && fArr[0] < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z2 && pointF != null) {
            pointF.set(fArr[0] - f2, fArr[1] - f3);
        }
        return z2;
    }

    private static float b(float f2) {
        float f3 = f2 * 8.0f;
        return f3 < 1.0f ? f3 - (1.0f - ((float) Math.exp((double) (-f3)))) : ((1.0f - ((float) Math.exp((double) (1.0f - f3)))) * 0.63212055f) + 0.36787945f;
    }

    public static boolean b(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof z) || (view instanceof WebView) || (view instanceof m);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r4 = r4 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(android.view.View r5, int r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 14
            if (r0 >= r1) goto L_0x005b
            boolean r0 = r5 instanceof android.widget.AbsListView
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x004b
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r3 = r5
            android.widget.AbsListView r3 = (android.widget.AbsListView) r3
            int r4 = r0.getChildCount()
            if (r6 <= 0) goto L_0x0032
            if (r4 <= 0) goto L_0x0030
            int r6 = r3.getLastVisiblePosition()
            int r4 = r4 - r1
            if (r6 < r4) goto L_0x0031
            android.view.View r6 = r0.getChildAt(r4)
            int r6 = r6.getBottom()
            int r5 = r5.getPaddingBottom()
            if (r6 <= r5) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r1 = 0
        L_0x0031:
            return r1
        L_0x0032:
            if (r4 <= 0) goto L_0x0049
            int r6 = r3.getFirstVisiblePosition()
            if (r6 > 0) goto L_0x004a
            android.view.View r6 = r0.getChildAt(r2)
            int r6 = r6.getTop()
            int r5 = r5.getPaddingTop()
            if (r6 >= r5) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r1 = 0
        L_0x004a:
            return r1
        L_0x004b:
            int r5 = r5.getScrollY()
            if (r6 <= 0) goto L_0x0056
            if (r5 >= 0) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r1 = 0
        L_0x0055:
            return r1
        L_0x0056:
            if (r5 <= 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r1 = 0
        L_0x005a:
            return r1
        L_0x005b:
            boolean r5 = r5.canScrollVertically(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: jc.b.b(android.view.View, int):boolean");
    }

    public static boolean c(View view) {
        return b(view) || (view instanceof ViewPager) || (view instanceof q);
    }

    public float getInterpolation(float f2) {
        if (this.f13812c == f13808b) {
            float f3 = 1.0f - f2;
            return 1.0f - (f3 * f3);
        }
        float b2 = f13810e * b(f2);
        return b2 > 0.0f ? b2 + f13811f : b2;
    }
}
