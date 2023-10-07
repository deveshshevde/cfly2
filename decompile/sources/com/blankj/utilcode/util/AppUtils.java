package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.blankj.utilcode.util.Utils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class AppUtils {

    public static class AppInfo {
        private Drawable icon;
        private boolean isSystem;
        private String name;
        private String packageName;
        private String packagePath;
        private int versionCode;
        private String versionName;

        public AppInfo(String str, String str2, Drawable drawable, String str3, String str4, int i2, boolean z2) {
            setName(str2);
            setIcon(drawable);
            setPackageName(str);
            setPackagePath(str3);
            setVersionName(str4);
            setVersionCode(i2);
            setSystem(z2);
        }

        public Drawable getIcon() {
            return this.icon;
        }

        public String getName() {
            return this.name;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getPackagePath() {
            return this.packagePath;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public String getVersionName() {
            return this.versionName;
        }

        public boolean isSystem() {
            return this.isSystem;
        }

        public void setIcon(Drawable drawable) {
            this.icon = drawable;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setPackagePath(String str) {
            this.packagePath = str;
        }

        public void setSystem(boolean z2) {
            this.isSystem = z2;
        }

        public void setVersionCode(int i2) {
            this.versionCode = i2;
        }

        public void setVersionName(String str) {
            this.versionName = str;
        }

        public String toString() {
            String str = "{\n    pkg name: " + getPackageName() + "\n    app icon: " + getIcon() + "\n    app name: " + getName() + "\n    app path: " + getPackagePath() + "\n    app v name: " + getVersionName() + "\n    app v code: " + getVersionCode() + "\n    is system: " + isSystem() + "\n}";
            Objects.requireNonNull(str, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.AppInfo.toString() marked by @androidx.annotation.NonNull");
            return str;
        }
    }

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void exitApp() {
        UtilsBridge.finishAllActivities();
        System.exit(0);
    }

    public static AppInfo getApkInfo(File file) {
        if (file == null || !file.isFile() || !file.exists()) {
            return null;
        }
        return getApkInfo(file.getAbsolutePath());
    }

    public static AppInfo getApkInfo(String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (UtilsBridge.isSpace(str) || (packageManager = Utils.getApp().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        return getBean(packageManager, packageArchiveInfo);
    }

    public static Drawable getAppIcon() {
        return getAppIcon(Utils.getApp().getPackageName());
    }

    public static Drawable getAppIcon(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.applicationInfo.loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int getAppIconId() {
        return getAppIconId(Utils.getApp().getPackageName());
    }

    public static int getAppIconId(String str) {
        if (UtilsBridge.isSpace(str)) {
            return 0;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return 0;
            }
            return packageInfo.applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static AppInfo getAppInfo() {
        return getAppInfo(Utils.getApp().getPackageName());
    }

    public static AppInfo getAppInfo(String str) {
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return getBean(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getAppName() {
        String appName = getAppName(Utils.getApp().getPackageName());
        Objects.requireNonNull(appName, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppName() marked by @androidx.annotation.NonNull");
        return appName;
    }

    public static String getAppName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            String charSequence = packageInfo == null ? "" : packageInfo.applicationInfo.loadLabel(packageManager).toString();
            if (charSequence != null) {
                return charSequence;
            }
            throw new NullPointerException("Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppName() marked by @androidx.annotation.NonNull");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getAppPackageName() {
        String packageName = Utils.getApp().getPackageName();
        Objects.requireNonNull(packageName, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppPackageName() marked by @androidx.annotation.NonNull");
        return packageName;
    }

    public static String getAppPath() {
        String appPath = getAppPath(Utils.getApp().getPackageName());
        Objects.requireNonNull(appPath, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppPath() marked by @androidx.annotation.NonNull");
        return appPath;
    }

    public static String getAppPath(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo == null ? "" : packageInfo.applicationInfo.sourceDir;
            if (str2 != null) {
                return str2;
            }
            throw new NullPointerException("Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppPath() marked by @androidx.annotation.NonNull");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Signature[] getAppSignatures() {
        return getAppSignatures(Utils.getApp().getPackageName());
    }

    public static Signature[] getAppSignatures(File file) {
        if (file == null) {
            return null;
        }
        PackageManager packageManager = Utils.getApp().getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        String absolutePath = file.getAbsolutePath();
        if (i2 >= 28) {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(absolutePath, AMapEngineUtils.HALF_MAX_P20_WIDTH);
            if (packageArchiveInfo == null) {
                return null;
            }
            SigningInfo signingInfo = packageArchiveInfo.signingInfo;
            return signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
        }
        PackageInfo packageArchiveInfo2 = packageManager.getPackageArchiveInfo(absolutePath, 64);
        if (packageArchiveInfo2 == null) {
            return null;
        }
        return packageArchiveInfo2.signatures;
    }

    public static Signature[] getAppSignatures(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        try {
            PackageManager packageManager = Utils.getApp().getPackageManager();
            if (Build.VERSION.SDK_INT >= 28) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, AMapEngineUtils.HALF_MAX_P20_WIDTH);
                if (packageInfo == null) {
                    return null;
                }
                SigningInfo signingInfo = packageInfo.signingInfo;
                return signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            }
            PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
            if (packageInfo2 == null) {
                return null;
            }
            return packageInfo2.signatures;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static List<String> getAppSignaturesHash(String str, String str2) {
        Signature[] appSignatures;
        ArrayList arrayList = new ArrayList();
        if (!UtilsBridge.isSpace(str) && (appSignatures = getAppSignatures(str)) != null && appSignatures.length > 0) {
            for (Signature byteArray : appSignatures) {
                arrayList.add(UtilsBridge.bytes2HexString(UtilsBridge.hashTemplate(byteArray.toByteArray(), str2)).replaceAll("(?<=[0-9A-F]{2})[0-9A-F]{2}", ":$0"));
            }
        }
        return arrayList;
    }

    public static List<String> getAppSignaturesMD5() {
        List<String> appSignaturesMD5 = getAppSignaturesMD5(Utils.getApp().getPackageName());
        Objects.requireNonNull(appSignaturesMD5, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesMD5() marked by @androidx.annotation.NonNull");
        return appSignaturesMD5;
    }

    public static List<String> getAppSignaturesMD5(String str) {
        List<String> appSignaturesHash = getAppSignaturesHash(str, "MD5");
        Objects.requireNonNull(appSignaturesHash, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesMD5() marked by @androidx.annotation.NonNull");
        return appSignaturesHash;
    }

    public static List<String> getAppSignaturesSHA1() {
        List<String> appSignaturesSHA1 = getAppSignaturesSHA1(Utils.getApp().getPackageName());
        Objects.requireNonNull(appSignaturesSHA1, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA1() marked by @androidx.annotation.NonNull");
        return appSignaturesSHA1;
    }

    public static List<String> getAppSignaturesSHA1(String str) {
        List<String> appSignaturesHash = getAppSignaturesHash(str, "SHA1");
        Objects.requireNonNull(appSignaturesHash, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA1() marked by @androidx.annotation.NonNull");
        return appSignaturesHash;
    }

    public static List<String> getAppSignaturesSHA256() {
        List<String> appSignaturesSHA256 = getAppSignaturesSHA256(Utils.getApp().getPackageName());
        Objects.requireNonNull(appSignaturesSHA256, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA256() marked by @androidx.annotation.NonNull");
        return appSignaturesSHA256;
    }

    public static List<String> getAppSignaturesSHA256(String str) {
        List<String> appSignaturesHash = getAppSignaturesHash(str, "SHA256");
        Objects.requireNonNull(appSignaturesHash, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppSignaturesSHA256() marked by @androidx.annotation.NonNull");
        return appSignaturesHash;
    }

    public static int getAppUid() {
        return getAppUid(Utils.getApp().getPackageName());
    }

    public static int getAppUid(String str) {
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(str, 0).uid;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static int getAppVersionCode() {
        return getAppVersionCode(Utils.getApp().getPackageName());
    }

    public static int getAppVersionCode(String str) {
        if (UtilsBridge.isSpace(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String getAppVersionName() {
        String appVersionName = getAppVersionName(Utils.getApp().getPackageName());
        Objects.requireNonNull(appVersionName, "Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppVersionName() marked by @androidx.annotation.NonNull");
        return appVersionName;
    }

    public static String getAppVersionName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = Utils.getApp().getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo == null ? "" : packageInfo.versionName;
            if (str2 != null) {
                return str2;
            }
            throw new NullPointerException("Detected an attempt to return null from a method com.blankj.utilcode.util.AppUtils.getAppVersionName() marked by @androidx.annotation.NonNull");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static List<AppInfo> getAppsInfo() {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = Utils.getApp().getPackageManager();
        if (packageManager == null) {
            return arrayList;
        }
        for (PackageInfo bean : packageManager.getInstalledPackages(0)) {
            AppInfo bean2 = getBean(packageManager, bean);
            if (bean2 != null) {
                arrayList.add(bean2);
            }
        }
        return arrayList;
    }

    private static AppInfo getBean(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        String str = packageInfo.versionName;
        int i2 = packageInfo.versionCode;
        String str2 = packageInfo.packageName;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        if (applicationInfo == null) {
            return new AppInfo(str2, "", (Drawable) null, "", str, i2, false);
        }
        return new AppInfo(str2, applicationInfo.loadLabel(packageManager).toString(), applicationInfo.loadIcon(packageManager), applicationInfo.sourceDir, str, i2, (applicationInfo.flags & 1) != 0);
    }

    public static void installApp(Uri uri) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(uri);
        if (installAppIntent != null) {
            Utils.getApp().startActivity(installAppIntent);
        }
    }

    public static void installApp(File file) {
        Intent installAppIntent = UtilsBridge.getInstallAppIntent(file);
        if (installAppIntent != null) {
            Utils.getApp().startActivity(installAppIntent);
        }
    }

    public static void installApp(String str) {
        installApp(UtilsBridge.getFileByPath(str));
    }

    public static boolean isAppDebug() {
        return isAppDebug(Utils.getApp().getPackageName());
    }

    public static boolean isAppDebug(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            return (Utils.getApp().getPackageManager().getApplicationInfo(str, 0).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isAppForeground() {
        return UtilsBridge.isAppForeground();
    }

    public static boolean isAppForeground(String str) {
        Objects.requireNonNull(str, "Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return !UtilsBridge.isSpace(str) && str.equals(UtilsBridge.getForegroundProcessName());
    }

    public static boolean isAppInstalled(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            return Utils.getApp().getPackageManager().getApplicationInfo(str, 0).enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isAppRoot() {
        return UtilsBridge.execCmd("echo root", true).result == 0;
    }

    public static boolean isAppRunning(String str) {
        ActivityManager activityManager;
        if (!UtilsBridge.isSpace(str) && (activityManager = (ActivityManager) Utils.getApp().getSystemService("activity")) != null) {
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(SubsamplingScaleImageView.TILE_SIZE_AUTO);
            if (runningTasks != null && runningTasks.size() > 0) {
                for (ActivityManager.RunningTaskInfo next : runningTasks) {
                    if (next.baseActivity != null && str.equals(next.baseActivity.getPackageName())) {
                        return true;
                    }
                }
            }
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(SubsamplingScaleImageView.TILE_SIZE_AUTO);
            if (runningServices != null && runningServices.size() > 0) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (str.equals(runningServiceInfo.service.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isAppSystem() {
        return isAppSystem(Utils.getApp().getPackageName());
    }

    public static boolean isAppSystem(String str) {
        if (UtilsBridge.isSpace(str)) {
            return false;
        }
        try {
            return (Utils.getApp().getPackageManager().getApplicationInfo(str, 0).flags & 1) != 0;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void launchApp(String str) {
        if (!UtilsBridge.isSpace(str)) {
            Intent launchAppIntent = UtilsBridge.getLaunchAppIntent(str);
            if (launchAppIntent == null) {
                Log.e("AppUtils", "Didn't exist launcher activity.");
            } else {
                Utils.getApp().startActivity(launchAppIntent);
            }
        }
    }

    public static void launchAppDetailsSettings() {
        launchAppDetailsSettings(Utils.getApp().getPackageName());
    }

    public static void launchAppDetailsSettings(Activity activity, int i2) {
        launchAppDetailsSettings(activity, i2, Utils.getApp().getPackageName());
    }

    public static void launchAppDetailsSettings(Activity activity, int i2, String str) {
        if (activity != null && !UtilsBridge.isSpace(str)) {
            Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(str, false);
            if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
                activity.startActivityForResult(launchAppDetailsSettingsIntent, i2);
            }
        }
    }

    public static void launchAppDetailsSettings(String str) {
        if (!UtilsBridge.isSpace(str)) {
            Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(str, true);
            if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
                Utils.getApp().startActivity(launchAppDetailsSettingsIntent);
            }
        }
    }

    public static void registerAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        Objects.requireNonNull(onAppStatusChangedListener, "Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        UtilsBridge.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    public static void relaunchApp() {
        relaunchApp(false);
    }

    public static void relaunchApp(boolean z2) {
        Intent launchAppIntent = UtilsBridge.getLaunchAppIntent(Utils.getApp().getPackageName());
        if (launchAppIntent == null) {
            Log.e("AppUtils", "Didn't exist launcher activity.");
            return;
        }
        launchAppIntent.addFlags(335577088);
        Utils.getApp().startActivity(launchAppIntent);
        if (z2) {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public static void uninstallApp(String str) {
        if (!UtilsBridge.isSpace(str)) {
            Utils.getApp().startActivity(UtilsBridge.getUninstallAppIntent(str));
        }
    }

    public static void unregisterAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        Objects.requireNonNull(onAppStatusChangedListener, "Argument 'listener' of type Utils.OnAppStatusChangedListener (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        UtilsBridge.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }
}
