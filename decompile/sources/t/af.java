package t;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

public final class af {
    public static void a(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof r) {
            ((r) viewParent).a(view, i2);
        } else if (i2 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onStopNestedScroll(view);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e2);
                }
            } else if (viewParent instanceof q) {
                ((q) viewParent).onStopNestedScroll(view);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof s) {
            ((s) viewParent2).a(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent2 instanceof r) {
            ((r) viewParent2).a(view, i2, i3, i4, i5, i6);
        } else if (i6 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScroll(view, i2, i3, i4, i5);
                } catch (AbstractMethodError e2) {
                    AbstractMethodError abstractMethodError = e2;
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", abstractMethodError);
                }
            } else if (viewParent2 instanceof q) {
                ((q) viewParent2).onNestedScroll(view, i2, i3, i4, i5);
            }
        }
    }

    public static void a(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof r) {
            ((r) viewParent).a(view, i2, i3, iArr, i4);
        } else if (i4 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedPreScroll(view, i2, i3, iArr);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
                }
            } else if (viewParent instanceof q) {
                ((q) viewParent).onNestedPreScroll(view, i2, i3, iArr);
            }
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
                return false;
            }
        } else if (viewParent instanceof q) {
            return ((q) viewParent).onNestedPreFling(view, f2, f3);
        } else {
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f2, float f3, boolean z2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z2);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
                return false;
            }
        } else if (viewParent instanceof q) {
            return ((q) viewParent).onNestedFling(view, f2, f3, z2);
        } else {
            return false;
        }
    }

    public static boolean a(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof r) {
            return ((r) viewParent).a(view, view2, i2, i3);
        }
        if (i3 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i2);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e2);
                return false;
            }
        } else if (viewParent instanceof q) {
            return ((q) viewParent).onStartNestedScroll(view, view2, i2);
        } else {
            return false;
        }
    }

    @Deprecated
    public static boolean a(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void b(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof r) {
            ((r) viewParent).b(view, view2, i2, i3);
        } else if (i3 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    viewParent.onNestedScrollAccepted(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e2);
                }
            } else if (viewParent instanceof q) {
                ((q) viewParent).onNestedScrollAccepted(view, view2, i2);
            }
        }
    }
}
