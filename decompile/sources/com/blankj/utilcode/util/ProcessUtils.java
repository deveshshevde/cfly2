package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class ProcessUtils {
    private ProcessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Set<String> getAllBackgroundProcesses() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                Collections.addAll(hashSet, runningAppProcessInfo.pkgList);
            }
        }
        return hashSet;
    }

    public static String getCurrentProcessName() {
        String currentProcessNameByFile = getCurrentProcessNameByFile();
        if (!TextUtils.isEmpty(currentProcessNameByFile)) {
            return currentProcessNameByFile;
        }
        String currentProcessNameByAms = getCurrentProcessNameByAms();
        return !TextUtils.isEmpty(currentProcessNameByAms) ? currentProcessNameByAms : getCurrentProcessNameByReflect();
    }

    private static String getCurrentProcessNameByAms() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) Utils.getApp().getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return "";
            }
            if (runningAppProcesses.size() == 0) {
                return "";
            }
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == myPid && next.processName != null) {
                    return next.processName;
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getCurrentProcessNameByFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String getCurrentProcessNameByReflect() {
        try {
            Application app = Utils.getApp();
            Field field = app.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(app);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(obj2, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getForegroundProcessName() {
        List<UsageStats> list;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) Utils.getApp().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.importance == 100) {
                    return next.processName;
                }
            }
        }
        if (Build.VERSION.SDK_INT > 21) {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            Intent intent = new Intent("android.settings.USAGE_ACCESS_SETTINGS");
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            Log.i("ProcessUtils", queryIntentActivities.toString());
            if (queryIntentActivities.size() <= 0) {
                Log.i("ProcessUtils", "getForegroundProcessName: noun of access to usage information.");
                return "";
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(Utils.getApp().getPackageName(), 0);
                AppOpsManager appOpsManager = (AppOpsManager) Utils.getApp().getSystemService("appops");
                if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                    intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    Utils.getApp().startActivity(intent);
                }
                if (appOpsManager.checkOpNoThrow("android:get_usage_stats", applicationInfo.uid, applicationInfo.packageName) != 0) {
                    Log.i("ProcessUtils", "getForegroundProcessName: refuse to device usage stats.");
                    return "";
                }
                UsageStatsManager usageStatsManager = (UsageStatsManager) Utils.getApp().getSystemService("usagestats");
                if (usageStatsManager != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    list = usageStatsManager.queryUsageStats(4, currentTimeMillis - 604800000, currentTimeMillis);
                } else {
                    list = null;
                }
                if (list != null) {
                    if (!list.isEmpty()) {
                        UsageStats usageStats = null;
                        for (UsageStats next2 : list) {
                            if (usageStats == null || next2.getLastTimeUsed() > usageStats.getLastTimeUsed()) {
                                usageStats = next2;
                            }
                        }
                        if (usageStats == null) {
                            return null;
                        }
                        return usageStats.getPackageName();
                    }
                }
                return "";
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public static boolean isMainProcess() {
        return Utils.getApp().getPackageName().equals(getCurrentProcessName());
    }

    public static Set<String> killAllBackgroundProcesses() {
        ActivityManager activityManager = (ActivityManager) Utils.getApp().getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        HashSet hashSet = new HashSet();
        if (runningAppProcesses == null) {
            return hashSet;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            for (String str : it2.next().pkgList) {
                activityManager.killBackgroundProcesses(str);
                hashSet.add(str);
            }
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            for (String remove : runningAppProcessInfo.pkgList) {
                hashSet.remove(remove);
            }
        }
        return hashSet;
    }

    public static boolean killBackgroundProcesses(String str) {
        Objects.requireNonNull(str, "Argument 'packageName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        ActivityManager activityManager = (ActivityManager) Utils.getApp().getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (!(runningAppProcesses == null || runningAppProcesses.size() == 0)) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    activityManager.killBackgroundProcesses(str);
                }
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = activityManager.getRunningAppProcesses();
            if (!(runningAppProcesses2 == null || runningAppProcesses2.size() == 0)) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses2) {
                    if (Arrays.asList(runningAppProcessInfo2.pkgList).contains(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
