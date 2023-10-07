package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.app.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.blankj.utilcode.util.Utils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import s.d;

public final class ActivityUtils {
    private ActivityUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.addActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    public static void addActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static void finishActivity(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        finishActivity(activity, false);
    }

    public static void finishActivity(Activity activity, int i2, int i3) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.finish();
        activity.overridePendingTransition(i2, i3);
    }

    public static void finishActivity(Activity activity, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        activity.finish();
        if (!z2) {
            activity.overridePendingTransition(0, 0);
        }
    }

    public static void finishActivity(Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        finishActivity(cls, false);
    }

    public static void finishActivity(Class<? extends Activity> cls, int i2, int i3) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (next.getClass().equals(cls)) {
                next.finish();
                next.overridePendingTransition(i2, i3);
            }
        }
    }

    public static void finishActivity(Class<? extends Activity> cls, boolean z2) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (next.getClass().equals(cls)) {
                next.finish();
                if (!z2) {
                    next.overridePendingTransition(0, 0);
                }
            }
        }
    }

    public static void finishAllActivities() {
        finishAllActivities(false);
    }

    public static void finishAllActivities(int i2, int i3) {
        for (Activity next : UtilsBridge.getActivityList()) {
            next.finish();
            next.overridePendingTransition(i2, i3);
        }
    }

    public static void finishAllActivities(boolean z2) {
        for (Activity next : UtilsBridge.getActivityList()) {
            next.finish();
            if (!z2) {
                next.overridePendingTransition(0, 0);
            }
        }
    }

    public static void finishAllActivitiesExceptNewest() {
        finishAllActivitiesExceptNewest(false);
    }

    public static void finishAllActivitiesExceptNewest(int i2, int i3) {
        List<Activity> activityList = UtilsBridge.getActivityList();
        for (int i4 = 1; i4 < activityList.size(); i4++) {
            finishActivity(activityList.get(i4), i2, i3);
        }
    }

    public static void finishAllActivitiesExceptNewest(boolean z2) {
        List<Activity> activityList = UtilsBridge.getActivityList();
        for (int i2 = 1; i2 < activityList.size(); i2++) {
            finishActivity(activityList.get(i2), z2);
        }
    }

    public static void finishOtherActivities(Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        finishOtherActivities(cls, false);
    }

    public static void finishOtherActivities(Class<? extends Activity> cls, int i2, int i3) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (!next.getClass().equals(cls)) {
                finishActivity(next, i2, i3);
            }
        }
    }

    public static void finishOtherActivities(Class<? extends Activity> cls, boolean z2) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (!next.getClass().equals(cls)) {
                finishActivity(next, z2);
            }
        }
    }

    public static boolean finishToActivity(Activity activity, boolean z2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return finishToActivity(activity, z2, false);
    }

    public static boolean finishToActivity(Activity activity, boolean z2, int i2, int i3) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (!next.equals(activity)) {
                finishActivity(next, i2, i3);
            } else if (!z2) {
                return true;
            } else {
                finishActivity(next, i2, i3);
                return true;
            }
        }
        return false;
    }

    public static boolean finishToActivity(Activity activity, boolean z2, boolean z3) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (!next.equals(activity)) {
                finishActivity(next, z3);
            } else if (!z2) {
                return true;
            } else {
                finishActivity(next, z3);
                return true;
            }
        }
        return false;
    }

    public static boolean finishToActivity(Class<? extends Activity> cls, boolean z2) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return finishToActivity(cls, z2, false);
    }

    public static boolean finishToActivity(Class<? extends Activity> cls, boolean z2, int i2, int i3) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (!next.getClass().equals(cls)) {
                finishActivity(next, i2, i3);
            } else if (!z2) {
                return true;
            } else {
                finishActivity(next, i2, i3);
                return true;
            }
        }
        return false;
    }

    public static boolean finishToActivity(Class<? extends Activity> cls, boolean z2, boolean z3) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity next : UtilsBridge.getActivityList()) {
            if (!next.getClass().equals(cls)) {
                finishActivity(next, z3);
            } else if (!z2) {
                return true;
            } else {
                finishActivity(next, z3);
                return true;
            }
        }
        return false;
    }

    public static Activity getActivityByContext(Context context) {
        Objects.requireNonNull(context, "Argument 'context' of type Context (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Activity activityByContextInner = getActivityByContextInner(context);
        if (!isActivityAlive(activityByContextInner)) {
            return null;
        }
        return activityByContextInner;
    }

    private static Activity getActivityByContextInner(Context context) {
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Activity activityFromDecorContext = getActivityFromDecorContext(context);
            if (activityFromDecorContext != null) {
                return activityFromDecorContext;
            }
            arrayList.add(context);
            context = ((ContextWrapper) context).getBaseContext();
            if (context != null) {
                if (arrayList.contains(context)) {
                    break;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    private static Activity getActivityFromDecorContext(Context context) {
        if (context != null && context.getClass().getName().equals("com.android.internal.policy.DecorContext")) {
            try {
                Field declaredField = context.getClass().getDeclaredField("mActivityContext");
                declaredField.setAccessible(true);
                return (Activity) ((WeakReference) declaredField.get(context)).get();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Drawable getActivityIcon(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getActivityIcon(activity.getComponentName());
    }

    public static Drawable getActivityIcon(ComponentName componentName) {
        Objects.requireNonNull(componentName, "Argument 'activityName' of type ComponentName (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return Utils.getApp().getPackageManager().getActivityIcon(componentName);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable getActivityIcon(Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getActivityIcon(new ComponentName(Utils.getApp(), cls));
    }

    public static List<Activity> getActivityList() {
        return UtilsBridge.getActivityList();
    }

    public static Drawable getActivityLogo(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getActivityLogo(activity.getComponentName());
    }

    public static Drawable getActivityLogo(ComponentName componentName) {
        Objects.requireNonNull(componentName, "Argument 'activityName' of type ComponentName (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        try {
            return Utils.getApp().getPackageManager().getActivityLogo(componentName);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable getActivityLogo(Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getActivityLogo(new ComponentName(Utils.getApp(), cls));
    }

    public static String getLauncherActivity() {
        return getLauncherActivity(Utils.getApp().getPackageName());
    }

    public static String getLauncherActivity(String str) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = Utils.getApp().getPackageManager().queryIntentActivities(intent, 0);
        return (queryIntentActivities == null || queryIntentActivities.size() == 0) ? "" : queryIntentActivities.get(0).activityInfo.name;
    }

    public static List<String> getMainActivities() {
        return getMainActivities(Utils.getApp().getPackageName());
    }

    public static List<String> getMainActivities(String str) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = Utils.getApp().getPackageManager().queryIntentActivities(intent, 0);
        int size = queryIntentActivities.size();
        if (size == 0) {
            return arrayList;
        }
        for (int i2 = 0; i2 < size; i2++) {
            ResolveInfo resolveInfo = queryIntentActivities.get(i2);
            if (resolveInfo.activityInfo.processName.equals(str)) {
                arrayList.add(resolveInfo.activityInfo.name);
            }
        }
        return arrayList;
    }

    private static Bundle getOptionsBundle(Activity activity, View[] viewArr) {
        int length;
        if (Build.VERSION.SDK_INT < 21 || viewArr == null || (length = viewArr.length) <= 0) {
            return null;
        }
        d[] dVarArr = new d[length];
        for (int i2 = 0; i2 < length; i2++) {
            dVarArr[i2] = d.a(viewArr[i2], viewArr[i2].getTransitionName());
        }
        return b.a(activity, dVarArr).a();
    }

    private static Bundle getOptionsBundle(Context context, int i2, int i3) {
        return b.a(context, i2, i3).a();
    }

    private static Bundle getOptionsBundle(Fragment fragment, int i2, int i3) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return b.a(activity, i2, i3).a();
    }

    private static Bundle getOptionsBundle(Fragment fragment, View[] viewArr) {
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        return getOptionsBundle((Activity) activity, viewArr);
    }

    public static Activity getTopActivity() {
        return UtilsBridge.getTopActivity();
    }

    private static Context getTopActivityOrApp() {
        if (!UtilsBridge.isAppForeground()) {
            return Utils.getApp();
        }
        Activity topActivity = getTopActivity();
        return topActivity == null ? Utils.getApp() : topActivity;
    }

    public static boolean isActivityAlive(Activity activity) {
        return activity != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed());
    }

    public static boolean isActivityAlive(Context context) {
        return isActivityAlive(getActivityByContext(context));
    }

    public static boolean isActivityExists(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        PackageManager packageManager = Utils.getApp().getPackageManager();
        return (packageManager.resolveActivity(intent, 0) == null || intent.resolveActivity(packageManager) == null || packageManager.queryIntentActivities(intent, 0).size() == 0) ? false : true;
    }

    public static boolean isActivityExistsInStack(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity equals : UtilsBridge.getActivityList()) {
            if (equals.equals(activity)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isActivityExistsInStack(Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        for (Activity activity : UtilsBridge.getActivityList()) {
            if (activity.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIntentAvailable(Intent intent) {
        return Utils.getApp().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsBridge.removeActivityLifecycleCallbacks(activity);
    }

    public static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.removeActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    public static void removeActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsBridge.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    public static void startActivities(Activity activity, Intent[] intentArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivities(intentArr, (Context) activity, (Bundle) null);
    }

    public static void startActivities(Activity activity, Intent[] intentArr, int i2, int i3) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivities(intentArr, (Context) activity, getOptionsBundle((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivities(Activity activity, Intent[] intentArr, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivities(intentArr, (Context) activity, bundle);
    }

    public static void startActivities(Intent[] intentArr) {
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivities(intentArr, getTopActivityOrApp(), (Bundle) null);
    }

    public static void startActivities(Intent[] intentArr, int i2, int i3) {
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivities(intentArr, topActivityOrApp, getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT < 16 && (topActivityOrApp instanceof Activity)) {
            ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
        }
    }

    private static void startActivities(Intent[] intentArr, Context context, Bundle bundle) {
        if (!(context instanceof Activity)) {
            for (Intent addFlags : intentArr) {
                addFlags.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
            }
        }
        if (bundle == null || Build.VERSION.SDK_INT < 16) {
            context.startActivities(intentArr);
        } else {
            context.startActivities(intentArr, bundle);
        }
    }

    public static void startActivities(Intent[] intentArr, Bundle bundle) {
        Objects.requireNonNull(intentArr, "Argument 'intents' of type Intent[] (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivities(intentArr, getTopActivityOrApp(), bundle);
    }

    public static void startActivity(Activity activity, Intent intent) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(intent, (Context) activity, (Bundle) null);
    }

    public static void startActivity(Activity activity, Intent intent, int i2, int i3) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(intent, (Context) activity, getOptionsBundle((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Activity activity, Intent intent, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(intent, (Context) activity, bundle);
    }

    public static void startActivity(Activity activity, Intent intent, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(intent, (Context) activity, getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls, int i2, int i3) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), getOptionsBundle((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), bundle);
    }

    public static void startActivity(Activity activity, Class<? extends Activity> cls, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, activity.getPackageName(), cls.getName(), getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Activity activity, String str, String str2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, str, str2, (Bundle) null);
    }

    public static void startActivity(Activity activity, String str, String str2, int i2, int i3) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, str, str2, getOptionsBundle((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Activity activity, String str, String str2, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, str, str2, bundle);
    }

    public static void startActivity(Activity activity, String str, String str2, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, (Bundle) null, str, str2, getOptionsBundle(activity, viewArr));
    }

    private static void startActivity(Context context, Bundle bundle, String str, String str2, Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        startActivity(intent, context, bundle2);
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, activity.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, int i3) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, activity.getPackageName(), cls.getName(), getOptionsBundle((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, activity.getPackageName(), cls.getName(), bundle2);
    }

    public static void startActivity(Bundle bundle, Activity activity, Class<? extends Activity> cls, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, activity.getPackageName(), cls.getName(), getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, str, str2, (Bundle) null);
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2, int i2, int i3) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, str, str2, getOptionsBundle((Context) activity, i2, i3));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, str, str2, bundle2);
    }

    public static void startActivity(Bundle bundle, Activity activity, String str, String str2, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity((Context) activity, bundle, str, str2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivity(Bundle bundle, Class<? extends Activity> cls) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, topActivityOrApp.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivity(Bundle bundle, Class<? extends Activity> cls, int i2, int i3) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, topActivityOrApp.getPackageName(), cls.getName(), getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT < 16 && (topActivityOrApp instanceof Activity)) {
            ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Bundle bundle, Class<? extends Activity> cls, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, topActivityOrApp.getPackageName(), cls.getName(), bundle2);
    }

    public static void startActivity(Bundle bundle, String str, String str2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(getTopActivityOrApp(), bundle, str, str2, (Bundle) null);
    }

    public static void startActivity(Bundle bundle, String str, String str2, int i2, int i3) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, bundle, str, str2, getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT < 16 && (topActivityOrApp instanceof Activity)) {
            ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Bundle bundle, String str, String str2, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(getTopActivityOrApp(), bundle, str, str2, bundle2);
    }

    public static void startActivity(Class<? extends Activity> cls) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, topActivityOrApp.getPackageName(), cls.getName(), (Bundle) null);
    }

    public static void startActivity(Class<? extends Activity> cls, int i2, int i3) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, topActivityOrApp.getPackageName(), cls.getName(), getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT < 16 && (topActivityOrApp instanceof Activity)) {
            ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, topActivityOrApp.getPackageName(), cls.getName(), bundle);
    }

    public static void startActivity(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(getTopActivityOrApp(), (Bundle) null, str, str2, (Bundle) null);
    }

    public static void startActivity(String str, String str2, int i2, int i3) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        startActivity(topActivityOrApp, (Bundle) null, str, str2, getOptionsBundle(topActivityOrApp, i2, i3));
        if (Build.VERSION.SDK_INT < 16 && (topActivityOrApp instanceof Activity)) {
            ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
        }
    }

    public static void startActivity(String str, String str2, Bundle bundle) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivity(getTopActivityOrApp(), (Bundle) null, str, str2, bundle);
    }

    public static boolean startActivity(Intent intent) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return startActivity(intent, getTopActivityOrApp(), (Bundle) null);
    }

    public static boolean startActivity(Intent intent, int i2, int i3) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Context topActivityOrApp = getTopActivityOrApp();
        boolean startActivity = startActivity(intent, topActivityOrApp, getOptionsBundle(topActivityOrApp, i2, i3));
        if (startActivity && Build.VERSION.SDK_INT < 16 && (topActivityOrApp instanceof Activity)) {
            ((Activity) topActivityOrApp).overridePendingTransition(i2, i3);
        }
        return startActivity;
    }

    private static boolean startActivity(Intent intent, Context context, Bundle bundle) {
        if (!isIntentAvailable(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        }
        if (bundle == null || Build.VERSION.SDK_INT < 16) {
            context.startActivity(intent);
            return true;
        }
        context.startActivity(intent, bundle);
        return true;
    }

    public static boolean startActivity(Intent intent, Bundle bundle) {
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return startActivity(intent, getTopActivityOrApp(), bundle);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, activity, i2, (Bundle) null);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, int i3, int i4) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, activity, i2, getOptionsBundle((Context) activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, activity, i2, bundle);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i2, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, activity, i2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2, int i3, int i4) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, getOptionsBundle((Context) activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, bundle);
    }

    public static void startActivityForResult(Activity activity, Class<? extends Activity> cls, int i2, View... viewArr) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, (Bundle) null, activity.getPackageName(), cls.getName(), i2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, int i3, int i4) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, getOptionsBundle((Context) activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, bundle2);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, Class<? extends Activity> cls, int i2, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, activity.getPackageName(), cls.getName(), i2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, str, str2, i2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2, int i3, int i4) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, str, str2, i2, getOptionsBundle((Context) activity, i3, i4));
        if (Build.VERSION.SDK_INT < 16) {
            activity.overridePendingTransition(i3, i4);
        }
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, str, str2, i2, bundle2);
    }

    public static void startActivityForResult(Bundle bundle, Activity activity, String str, String str2, int i2, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(activity, bundle, str, str2, i2, getOptionsBundle(activity, viewArr));
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2, int i3, int i4) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, i3, i4));
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, bundle2);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, Class<? extends Activity> cls, int i2, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, viewArr));
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, str, str2, i2, (Bundle) null);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2, int i3, int i4) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, str, str2, i2, getOptionsBundle(fragment, i3, i4));
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2, Bundle bundle2) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, str, str2, i2, bundle2);
    }

    public static void startActivityForResult(Bundle bundle, Fragment fragment, String str, String str2, int i2, View... viewArr) {
        Objects.requireNonNull(bundle, "Argument 'extras' of type Bundle (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#2 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(str2, "Argument 'cls' of type String (#3 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, bundle, str, str2, i2, getOptionsBundle(fragment, viewArr));
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, fragment, i2, (Bundle) null);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2, int i3, int i4) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, fragment, i2, getOptionsBundle(fragment, i3, i4));
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, fragment, i2, bundle);
    }

    public static void startActivityForResult(Fragment fragment, Intent intent, int i2, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(intent, "Argument 'intent' of type Intent (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(intent, fragment, i2, getOptionsBundle(fragment, viewArr));
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, (Bundle) null);
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2, int i3, int i4) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, i3, i4));
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2, Bundle bundle) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, bundle);
    }

    public static void startActivityForResult(Fragment fragment, Class<? extends Activity> cls, int i2, View... viewArr) {
        Objects.requireNonNull(fragment, "Argument 'fragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cls, "Argument 'clz' of type Class<? extends Activity> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        startActivityForResult(fragment, (Bundle) null, Utils.getApp().getPackageName(), cls.getName(), i2, getOptionsBundle(fragment, viewArr));
    }

    private static boolean startActivityForResult(Activity activity, Bundle bundle, String str, String str2, int i2, Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return startActivityForResult(intent, activity, i2, bundle2);
    }

    private static boolean startActivityForResult(Intent intent, Activity activity, int i2, Bundle bundle) {
        if (!isIntentAvailable(intent)) {
            Log.e("ActivityUtils", "intent is unavailable");
            return false;
        } else if (bundle == null || Build.VERSION.SDK_INT < 16) {
            activity.startActivityForResult(intent, i2);
            return true;
        } else {
            activity.startActivityForResult(intent, i2, bundle);
            return true;
        }
    }

    private static boolean startActivityForResult(Intent intent, Fragment fragment, int i2, Bundle bundle) {
        String str;
        if (!isIntentAvailable(intent)) {
            str = "intent is unavailable";
        } else if (fragment.getActivity() == null) {
            str = "Fragment " + fragment + " not attached to Activity";
        } else if (bundle == null || Build.VERSION.SDK_INT < 16) {
            fragment.startActivityForResult(intent, i2);
            return true;
        } else {
            fragment.startActivityForResult(intent, i2, bundle);
            return true;
        }
        Log.e("ActivityUtils", str);
        return false;
    }

    private static boolean startActivityForResult(Fragment fragment, Bundle bundle, String str, String str2, int i2, Bundle bundle2) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return startActivityForResult(intent, fragment, i2, bundle2);
    }

    public static void startHomeActivity() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        startActivity(intent);
    }

    public static void startLauncherActivity() {
        startLauncherActivity(Utils.getApp().getPackageName());
    }

    public static void startLauncherActivity(String str) {
        Objects.requireNonNull(str, "Argument 'pkg' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String launcherActivity = getLauncherActivity(str);
        if (!TextUtils.isEmpty(launcherActivity)) {
            startActivity(str, launcherActivity);
        }
    }
}
