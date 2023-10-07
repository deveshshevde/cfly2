package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public final class PathUtils {
    private static final char SEP = File.separatorChar;

    private PathUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static String getAbsolutePath(File file) {
        return file == null ? "" : file.getAbsolutePath();
    }

    public static String getAppDataPathExternalFirst() {
        String externalAppDataPath = getExternalAppDataPath();
        return TextUtils.isEmpty(externalAppDataPath) ? getInternalAppDataPath() : externalAppDataPath;
    }

    public static String getCachePathExternalFirst() {
        String externalAppCachePath = getExternalAppCachePath();
        return TextUtils.isEmpty(externalAppCachePath) ? getInternalAppCachePath() : externalAppCachePath;
    }

    public static String getDataPath() {
        return getAbsolutePath(Environment.getDataDirectory());
    }

    public static String getDownloadCachePath() {
        return getAbsolutePath(Environment.getDownloadCacheDirectory());
    }

    public static String getExternalAlarmsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS));
    }

    public static String getExternalAppAlarmsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_ALARMS));
    }

    public static String getExternalAppCachePath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalCacheDir());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = com.blankj.utilcode.util.Utils.getApp().getExternalCacheDir();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getExternalAppDataPath() {
        /*
            boolean r0 = com.blankj.utilcode.util.UtilsBridge.isSDCardEnableByEnvironment()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            android.app.Application r0 = com.blankj.utilcode.util.Utils.getApp()
            java.io.File r0 = r0.getExternalCacheDir()
            if (r0 != 0) goto L_0x0014
            return r1
        L_0x0014:
            java.io.File r0 = r0.getParentFile()
            java.lang.String r0 = getAbsolutePath(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.PathUtils.getExternalAppDataPath():java.lang.String");
    }

    public static String getExternalAppDcimPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DCIM));
    }

    public static String getExternalAppDocumentsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS));
        }
        return getAbsolutePath(Utils.getApp().getExternalFilesDir((String) null)) + "/Documents";
    }

    public static String getExternalAppDownloadPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String getExternalAppFilesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir((String) null));
    }

    public static String getExternalAppMoviesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MOVIES));
    }

    public static String getExternalAppMusicPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_MUSIC));
    }

    public static String getExternalAppNotificationsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String getExternalAppObbPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getObbDir());
    }

    public static String getExternalAppPicturesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PICTURES));
    }

    public static String getExternalAppPodcastsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_PODCASTS));
    }

    public static String getExternalAppRingtonesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Utils.getApp().getExternalFilesDir(Environment.DIRECTORY_RINGTONES));
    }

    public static String getExternalDcimPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
    }

    public static String getExternalDocumentsPath() {
        if (!UtilsBridge.isSDCardEnableByEnvironment()) {
            return "";
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS));
        }
        return getAbsolutePath(Environment.getExternalStorageDirectory()) + "/Documents";
    }

    public static String getExternalDownloadsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String getExternalMoviesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES));
    }

    public static String getExternalMusicPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC));
    }

    public static String getExternalNotificationsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS));
    }

    public static String getExternalPicturesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
    }

    public static String getExternalPodcastsPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PODCASTS));
    }

    public static String getExternalRingtonesPath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES));
    }

    public static String getExternalStoragePath() {
        return !UtilsBridge.isSDCardEnableByEnvironment() ? "" : getAbsolutePath(Environment.getExternalStorageDirectory());
    }

    public static String getFilesPathExternalFirst() {
        String externalAppFilesPath = getExternalAppFilesPath();
        return TextUtils.isEmpty(externalAppFilesPath) ? getInternalAppFilesPath() : externalAppFilesPath;
    }

    public static String getInternalAppCachePath() {
        return getAbsolutePath(Utils.getApp().getCacheDir());
    }

    public static String getInternalAppCodeCacheDir() {
        if (Build.VERSION.SDK_INT >= 21) {
            return getAbsolutePath(Utils.getApp().getCodeCacheDir());
        }
        return Utils.getApp().getApplicationInfo().dataDir + "/code_cache";
    }

    public static String getInternalAppDataPath() {
        return Build.VERSION.SDK_INT < 24 ? Utils.getApp().getApplicationInfo().dataDir : getAbsolutePath(Utils.getApp().getDataDir());
    }

    public static String getInternalAppDbPath(String str) {
        return getAbsolutePath(Utils.getApp().getDatabasePath(str));
    }

    public static String getInternalAppDbsPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/databases";
    }

    public static String getInternalAppFilesPath() {
        return getAbsolutePath(Utils.getApp().getFilesDir());
    }

    public static String getInternalAppNoBackupFilesPath() {
        if (Build.VERSION.SDK_INT >= 21) {
            return getAbsolutePath(Utils.getApp().getNoBackupFilesDir());
        }
        return Utils.getApp().getApplicationInfo().dataDir + "/no_backup";
    }

    public static String getInternalAppSpPath() {
        return Utils.getApp().getApplicationInfo().dataDir + "/shared_prefs";
    }

    private static String getLegalSegment(String str) {
        char[] charArray = str.toCharArray();
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < charArray.length; i4++) {
            if (charArray[i4] != SEP) {
                if (i2 == -1) {
                    i2 = i4;
                }
                i3 = i4;
            }
        }
        if (i2 >= 0 && i3 >= i2) {
            return str.substring(i2, i3 + 1);
        }
        throw new IllegalArgumentException("segment of <" + str + "> is illegal");
    }

    public static String getRootPath() {
        return getAbsolutePath(Environment.getRootDirectory());
    }

    public static String getRootPathExternalFirst() {
        String externalStoragePath = getExternalStoragePath();
        return TextUtils.isEmpty(externalStoragePath) ? getRootPath() : externalStoragePath;
    }

    public static String join(String str, String str2) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (str == null) {
            str = "";
        }
        int length = str.length();
        String legalSegment = getLegalSegment(str2);
        if (length == 0) {
            return SEP + legalSegment;
        }
        char charAt = str.charAt(length - 1);
        char c2 = SEP;
        if (charAt == c2) {
            sb = new StringBuilder();
            sb.append(str);
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(c2);
        }
        sb.append(legalSegment);
        return sb.toString();
    }
}
