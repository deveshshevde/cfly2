package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.Objects;

public final class BarUtils {
    private static final int KEY_OFFSET = -123;
    private static final String TAG_OFFSET = "TAG_OFFSET";
    private static final String TAG_STATUS_BAR = "TAG_STATUS_BAR";

    private BarUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addMarginTopEqualStatusBarHeight(View view) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19) {
            view.setTag(TAG_OFFSET);
            Object tag = view.getTag(KEY_OFFSET);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setTag(KEY_OFFSET, true);
            }
        }
    }

    private static void addMarginTopEqualStatusBarHeight(Window window) {
        View findViewWithTag;
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19 && (findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET)) != null) {
            addMarginTopEqualStatusBarHeight(findViewWithTag);
        }
    }

    private static View applyStatusBarColor(Activity activity, int i2, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return applyStatusBarColor(activity.getWindow(), i2, z2);
    }

    private static View applyStatusBarColor(Window window, int i2, boolean z2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ViewGroup viewGroup = (ViewGroup) (z2 ? window.getDecorView() : window.findViewById(16908290));
        View findViewWithTag = viewGroup.findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag != null) {
            if (findViewWithTag.getVisibility() == 8) {
                findViewWithTag.setVisibility(0);
            }
            findViewWithTag.setBackgroundColor(i2);
            return findViewWithTag;
        }
        View createStatusBarView = createStatusBarView(window.getContext(), i2);
        viewGroup.addView(createStatusBarView);
        return createStatusBarView;
    }

    private static View createStatusBarView(Context context, int i2) {
        Objects.requireNonNull(context, "Argument 'context' of type Context (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View view = new View(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
        view.setBackgroundColor(i2);
        view.setTag(TAG_STATUS_BAR);
        return view;
    }

    public static int getActionBarHeight() {
        TypedValue typedValue = new TypedValue();
        if (Utils.getApp().getTheme().resolveAttribute(16843499, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, Utils.getApp().getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static int getNavBarColor(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getNavBarColor(activity.getWindow());
    }

    public static int getNavBarColor(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return window.getNavigationBarColor();
    }

    public static int getNavBarHeight() {
        Resources resources = Utils.getApp().getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static String getResNameById(int i2) {
        try {
            return Utils.getApp().getResources().getResourceEntryName(i2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static int getStatusBarHeight() {
        Resources resources = Utils.getApp().getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    private static void hideStatusBarView(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        hideStatusBarView(activity.getWindow());
    }

    private static void hideStatusBarView(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(8);
        }
    }

    private static void invokePanels(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(Utils.getApp().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean isNavBarLightMode(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isNavBarLightMode(activity.getWindow());
    }

    public static boolean isNavBarLightMode(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Build.VERSION.SDK_INT >= 26 && (window.getDecorView().getSystemUiVisibility() & 16) != 0;
    }

    public static boolean isNavBarVisible(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isNavBarVisible(activity.getWindow());
    }

    public static boolean isNavBarVisible(Window window) {
        boolean z2;
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        int childCount = viewGroup.getChildCount();
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                z2 = false;
                break;
            }
            View childAt = viewGroup.getChildAt(i2);
            int id2 = childAt.getId();
            if (id2 != -1 && "navigationBarBackground".equals(getResNameById(id2)) && childAt.getVisibility() == 0) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (!z2) {
            return z2;
        }
        if (UtilsBridge.isSamsung() && Build.VERSION.SDK_INT >= 17 && Build.VERSION.SDK_INT < 29) {
            try {
                return Settings.Global.getInt(Utils.getApp().getContentResolver(), "navigationbar_hide_bar_enabled") == 0;
            } catch (Exception unused) {
            }
        }
        if ((viewGroup.getSystemUiVisibility() & 2) == 0) {
            z3 = true;
        }
        return z3;
    }

    public static boolean isStatusBarLightMode(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return isStatusBarLightMode(activity.getWindow());
    }

    public static boolean isStatusBarLightMode(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Build.VERSION.SDK_INT >= 23 && (window.getDecorView().getSystemUiVisibility() & 8192) != 0;
    }

    public static boolean isStatusBarVisible(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return (activity.getWindow().getAttributes().flags & 1024) == 0;
    }

    public static boolean isSupportNavBar() {
        if (Build.VERSION.SDK_INT >= 17) {
            WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            return (point2.y == point.y && point2.x == point.x) ? false : true;
        }
        return !ViewConfiguration.get(Utils.getApp()).hasPermanentMenuKey() && !KeyCharacterMap.deviceHasKey(4);
    }

    public static void setNavBarColor(Activity activity, int i2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setNavBarColor(activity.getWindow(), i2);
    }

    public static void setNavBarColor(Window window, int i2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i2);
    }

    public static void setNavBarLightMode(Activity activity, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setNavBarLightMode(activity.getWindow(), z2);
    }

    public static void setNavBarLightMode(Window window, boolean z2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z2 ? systemUiVisibility | 16 : systemUiVisibility & -17);
        }
    }

    public static void setNavBarVisibility(Activity activity, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19) {
            setNavBarVisibility(activity.getWindow(), z2);
        }
    }

    public static void setNavBarVisibility(Window window, boolean z2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                int id2 = childAt.getId();
                if (id2 != -1 && "navigationBarBackground".equals(getResNameById(id2))) {
                    childAt.setVisibility(z2 ? 0 : 4);
                }
            }
            viewGroup.setSystemUiVisibility(z2 ? viewGroup.getSystemUiVisibility() & -4611 : viewGroup.getSystemUiVisibility() | 4610);
        }
    }

    public static void setNotificationBarVisibility(boolean z2) {
        invokePanels(z2 ? Build.VERSION.SDK_INT <= 16 ? "expand" : "expandNotificationsPanel" : Build.VERSION.SDK_INT <= 16 ? "collapse" : "collapsePanels");
    }

    public static View setStatusBarColor(Activity activity, int i2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return setStatusBarColor(activity, i2, false);
    }

    public static View setStatusBarColor(Activity activity, int i2, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        transparentStatusBar(activity);
        return applyStatusBarColor(activity, i2, z2);
    }

    public static View setStatusBarColor(Window window, int i2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return setStatusBarColor(window, i2, false);
    }

    public static View setStatusBarColor(Window window, int i2, boolean z2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        transparentStatusBar(window);
        return applyStatusBarColor(window, i2, z2);
    }

    public static void setStatusBarColor(View view, int i2) {
        Activity activityByContext;
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            view.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = getStatusBarHeight();
            view.setBackgroundColor(i2);
        }
    }

    public static void setStatusBarColor4Drawer(DrawerLayout drawerLayout, View view, int i2) {
        Objects.requireNonNull(drawerLayout, "Argument 'drawer' of type DrawerLayout (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setStatusBarColor4Drawer(drawerLayout, view, i2, false);
    }

    public static void setStatusBarColor4Drawer(DrawerLayout drawerLayout, View view, int i2, boolean z2) {
        Activity activityByContext;
        Objects.requireNonNull(drawerLayout, "Argument 'drawer' of type DrawerLayout (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            drawerLayout.setFitsSystemWindows(false);
            setStatusBarColor(view, i2);
            int childCount = drawerLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                drawerLayout.getChildAt(i3).setFitsSystemWindows(false);
            }
            if (z2) {
                hideStatusBarView(activityByContext);
            } else {
                setStatusBarColor(activityByContext, i2, false);
            }
        }
    }

    public static void setStatusBarCustom(View view) {
        Activity activityByContext;
        Objects.requireNonNull(view, "Argument 'fakeStatusBar' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19 && (activityByContext = UtilsBridge.getActivityByContext(view.getContext())) != null) {
            transparentStatusBar(activityByContext);
            view.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight()));
                return;
            }
            layoutParams.width = -1;
            layoutParams.height = getStatusBarHeight();
        }
    }

    public static void setStatusBarLightMode(Activity activity, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setStatusBarLightMode(activity.getWindow(), z2);
    }

    public static void setStatusBarLightMode(Window window, boolean z2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z2 ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    public static void setStatusBarVisibility(Activity activity, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        setStatusBarVisibility(activity.getWindow(), z2);
    }

    public static void setStatusBarVisibility(Window window, boolean z2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z2) {
            window.clearFlags(1024);
            showStatusBarView(window);
            addMarginTopEqualStatusBarHeight(window);
            return;
        }
        window.addFlags(1024);
        hideStatusBarView(window);
        subtractMarginTopEqualStatusBarHeight(window);
    }

    private static void showStatusBarView(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        View findViewWithTag = ((ViewGroup) window.getDecorView()).findViewWithTag(TAG_STATUS_BAR);
        if (findViewWithTag != null) {
            findViewWithTag.setVisibility(0);
        }
    }

    public static void subtractMarginTopEqualStatusBarHeight(View view) {
        Object tag;
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19 && (tag = view.getTag(KEY_OFFSET)) != null && ((Boolean) tag).booleanValue()) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin - getStatusBarHeight(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            view.setTag(KEY_OFFSET, false);
        }
    }

    private static void subtractMarginTopEqualStatusBarHeight(Window window) {
        View findViewWithTag;
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19 && (findViewWithTag = window.getDecorView().findViewWithTag(TAG_OFFSET)) != null) {
            subtractMarginTopEqualStatusBarHeight(findViewWithTag);
        }
    }

    public static void transparentStatusBar(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        transparentStatusBar(activity.getWindow());
    }

    public static void transparentStatusBar(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
                window.setStatusBarColor(0);
                return;
            }
            window.addFlags(67108864);
        }
    }
}
