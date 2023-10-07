package com.blankj.utilcode.util;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.h;
import com.blankj.utilcode.util.NotificationUtils;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.Utils;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

class UtilsBridge {

    static final class FileHead {
        private LinkedHashMap<String, String> mFirst = new LinkedHashMap<>();
        private LinkedHashMap<String, String> mLast = new LinkedHashMap<>();
        private String mName;

        FileHead(String str) {
            this.mName = str;
        }

        private void append2Host(Map<String, String> map, String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int length = 19 - str.length();
                if (length > 0) {
                    str = str + "                   ".substring(0, length);
                }
                map.put(str, str2);
            }
        }

        private void append2Host(Map<String, String> map, Map<String, String> map2) {
            if (map2 != null && !map2.isEmpty()) {
                for (Map.Entry next : map2.entrySet()) {
                    append2Host(map, (String) next.getKey(), (String) next.getValue());
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void addFirst(String str, String str2) {
            append2Host(this.mFirst, str, str2);
        }

        /* access modifiers changed from: package-private */
        public void append(String str, String str2) {
            append2Host(this.mLast, str, str2);
        }

        /* access modifiers changed from: package-private */
        public void append(Map<String, String> map) {
            append2Host(this.mLast, map);
        }

        public String getAppended() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : this.mLast.entrySet()) {
                sb.append((String) next.getKey());
                sb.append(": ");
                sb.append((String) next.getValue());
                sb.append("\n");
            }
            return sb.toString();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = "************* " + this.mName + " Head ****************\n";
            sb.append(str);
            for (Map.Entry next : this.mFirst.entrySet()) {
                sb.append((String) next.getKey());
                sb.append(": ");
                sb.append((String) next.getValue());
                sb.append("\n");
            }
            sb.append("Rom Info           : ");
            sb.append(RomUtils.getRomInfo());
            sb.append("\n");
            sb.append("Device Manufacturer: ");
            sb.append(Build.MANUFACTURER);
            sb.append("\n");
            sb.append("Device Model       : ");
            sb.append(Build.MODEL);
            sb.append("\n");
            sb.append("Android Version    : ");
            sb.append(Build.VERSION.RELEASE);
            sb.append("\n");
            sb.append("Android SDK        : ");
            sb.append(Build.VERSION.SDK_INT);
            sb.append("\n");
            sb.append("App VersionName    : ");
            sb.append(AppUtils.getAppVersionName());
            sb.append("\n");
            sb.append("App VersionCode    : ");
            sb.append(AppUtils.getAppVersionCode());
            sb.append("\n");
            sb.append(getAppended());
            sb.append(str);
            sb.append("\n");
            return sb.toString();
        }
    }

    UtilsBridge() {
    }

    static void addActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    static void addActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    static void addOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.addOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    static byte[] base64Decode(byte[] bArr) {
        return EncodeUtils.base64Decode(bArr);
    }

    static byte[] base64Encode(byte[] bArr) {
        return EncodeUtils.base64Encode(bArr);
    }

    static byte[] bitmap2Bytes(Bitmap bitmap) {
        return ImageUtils.bitmap2Bytes(bitmap);
    }

    static byte[] bitmap2Bytes(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        return ImageUtils.bitmap2Bytes(bitmap, compressFormat, i2);
    }

    static Drawable bitmap2Drawable(Bitmap bitmap) {
        return ImageUtils.bitmap2Drawable(bitmap);
    }

    static String byte2FitMemorySize(long j2) {
        return ConvertUtils.byte2FitMemorySize(j2);
    }

    static Bitmap bytes2Bitmap(byte[] bArr) {
        return ImageUtils.bytes2Bitmap(bArr);
    }

    static Drawable bytes2Drawable(byte[] bArr) {
        return ImageUtils.bytes2Drawable(bArr);
    }

    static String bytes2HexString(byte[] bArr) {
        return ConvertUtils.bytes2HexString(bArr);
    }

    static JSONArray bytes2JSONArray(byte[] bArr) {
        return ConvertUtils.bytes2JSONArray(bArr);
    }

    static JSONObject bytes2JSONObject(byte[] bArr) {
        return ConvertUtils.bytes2JSONObject(bArr);
    }

    static Object bytes2Object(byte[] bArr) {
        return ConvertUtils.bytes2Object(bArr);
    }

    static <T> T bytes2Parcelable(byte[] bArr, Parcelable.Creator<T> creator) {
        return ConvertUtils.bytes2Parcelable(bArr, creator);
    }

    static String bytes2String(byte[] bArr) {
        return ConvertUtils.bytes2String(bArr);
    }

    static boolean createFileByDeleteOldFile(File file) {
        return FileUtils.createFileByDeleteOldFile(file);
    }

    static boolean createOrExistsDir(File file) {
        return FileUtils.createOrExistsDir(file);
    }

    static boolean createOrExistsFile(File file) {
        return FileUtils.createOrExistsFile(file);
    }

    static boolean deleteAllInDir(File file) {
        return FileUtils.deleteAllInDir(file);
    }

    static <T> Utils.Task<T> doAsync(Utils.Task<T> task) {
        ThreadUtils.getCachedPool().execute(task);
        return task;
    }

    static int dp2px(float f2) {
        return SizeUtils.dp2px(f2);
    }

    static Bitmap drawable2Bitmap(Drawable drawable) {
        return ImageUtils.drawable2Bitmap(drawable);
    }

    static byte[] drawable2Bytes(Drawable drawable) {
        return ImageUtils.drawable2Bytes(drawable);
    }

    static byte[] drawable2Bytes(Drawable drawable, Bitmap.CompressFormat compressFormat, int i2) {
        return ImageUtils.drawable2Bytes(drawable, compressFormat, i2);
    }

    static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        return StringUtils.equals(charSequence, charSequence2);
    }

    static ShellUtils.CommandResult execCmd(String str, boolean z2) {
        return ShellUtils.execCmd(str, z2);
    }

    static Uri file2Uri(File file) {
        return UriUtils.file2Uri(file);
    }

    static void finishAllActivities() {
        ActivityUtils.finishAllActivities();
    }

    static void fixSoftInputLeaks(Activity activity) {
        KeyboardUtils.fixSoftInputLeaks(activity);
    }

    static String format(String str, Object... objArr) {
        return StringUtils.format(str, objArr);
    }

    static String formatJson(String str) {
        return JsonUtils.formatJson(str);
    }

    static <T> T fromJson(String str, Type type) {
        return GsonUtils.fromJson(str, type);
    }

    static Activity getActivityByContext(Context context) {
        return ActivityUtils.getActivityByContext(context);
    }

    static List<Activity> getActivityList() {
        return UtilsActivityLifecycleImpl.INSTANCE.getActivityList();
    }

    static int getAppScreenWidth() {
        return ScreenUtils.getAppScreenWidth();
    }

    static Application getApplicationByReflect() {
        return UtilsActivityLifecycleImpl.INSTANCE.getApplicationByReflect();
    }

    static Intent getCallIntent(String str) {
        return IntentUtils.getCallIntent(str);
    }

    static String getCurrentProcessName() {
        return ProcessUtils.getCurrentProcessName();
    }

    static Intent getDialIntent(String str) {
        return IntentUtils.getDialIntent(str);
    }

    static File getFileByPath(String str) {
        return FileUtils.getFileByPath(str);
    }

    static String getForegroundProcessName() {
        return ProcessUtils.getForegroundProcessName();
    }

    static long getFsAvailableSize(String str) {
        return FileUtils.getFsAvailableSize(str);
    }

    static long getFsTotalSize(String str) {
        return FileUtils.getFsTotalSize(str);
    }

    static String getFullStackTrace(Throwable th) {
        return ThrowableUtils.getFullStackTrace(th);
    }

    static Gson getGson4LogUtils() {
        return GsonUtils.getGson4LogUtils();
    }

    static Intent getInstallAppIntent(Uri uri) {
        return IntentUtils.getInstallAppIntent(uri);
    }

    static Intent getInstallAppIntent(File file) {
        return IntentUtils.getInstallAppIntent(file);
    }

    static Intent getLaunchAppDetailsSettingsIntent(String str, boolean z2) {
        return IntentUtils.getLaunchAppDetailsSettingsIntent(str, z2);
    }

    static Intent getLaunchAppIntent(String str) {
        return IntentUtils.getLaunchAppIntent(str);
    }

    static String getLauncherActivity(String str) {
        return ActivityUtils.getLauncherActivity(str);
    }

    static int getNavBarHeight() {
        return BarUtils.getNavBarHeight();
    }

    static Notification getNotification(NotificationUtils.ChannelConfig channelConfig, Utils.Consumer<h.d> consumer) {
        return NotificationUtils.getNotification(channelConfig, consumer);
    }

    static Intent getSendSmsIntent(String str, String str2) {
        return IntentUtils.getSendSmsIntent(str, str2);
    }

    static SPUtils getSpUtils4Utils() {
        return SPUtils.getInstance("Utils");
    }

    static int getStatusBarHeight() {
        return BarUtils.getStatusBarHeight();
    }

    static String getString(int i2) {
        return StringUtils.getString(i2);
    }

    static String getString(int i2, Object... objArr) {
        return StringUtils.getString(i2, objArr);
    }

    static Activity getTopActivity() {
        return UtilsActivityLifecycleImpl.INSTANCE.getTopActivity();
    }

    static Intent getUninstallAppIntent(String str) {
        return IntentUtils.getUninstallAppIntent(str);
    }

    static byte[] hashTemplate(byte[] bArr, String str) {
        return EncryptUtils.hashTemplate(bArr, str);
    }

    static byte[] hexString2Bytes(String str) {
        return ConvertUtils.hexString2Bytes(str);
    }

    static void init(Application application) {
        UtilsActivityLifecycleImpl.INSTANCE.init(application);
    }

    static ByteArrayOutputStream input2OutputStream(InputStream inputStream) {
        return ConvertUtils.input2OutputStream(inputStream);
    }

    static byte[] inputStream2Bytes(InputStream inputStream) {
        return ConvertUtils.inputStream2Bytes(inputStream);
    }

    static List<String> inputStream2Lines(InputStream inputStream, String str) {
        return ConvertUtils.inputStream2Lines(inputStream, str);
    }

    static boolean isActivityAlive(Activity activity) {
        return ActivityUtils.isActivityAlive(activity);
    }

    static boolean isAppDebug() {
        return AppUtils.isAppDebug();
    }

    static boolean isAppForeground() {
        return UtilsActivityLifecycleImpl.INSTANCE.isAppForeground();
    }

    static boolean isAppInstalled(String str) {
        return AppUtils.isAppInstalled(str);
    }

    static boolean isAppRunning(String str) {
        Objects.requireNonNull(str, "Argument 'pkgName' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return AppUtils.isAppRunning(str);
    }

    static boolean isFileExists(File file) {
        return FileUtils.isFileExists(file);
    }

    static boolean isGranted(String... strArr) {
        return PermissionUtils.isGranted(strArr);
    }

    static boolean isGrantedDrawOverlays() {
        return PermissionUtils.isGrantedDrawOverlays();
    }

    static boolean isIntentAvailable(Intent intent) {
        return IntentUtils.isIntentAvailable(intent);
    }

    static boolean isLayoutRtl() {
        return ViewUtils.isLayoutRtl();
    }

    static boolean isMainProcess() {
        return ProcessUtils.isMainProcess();
    }

    static boolean isSDCardEnableByEnvironment() {
        return SDCardUtils.isSDCardEnableByEnvironment();
    }

    static boolean isSamsung() {
        return RomUtils.isSamsung();
    }

    static boolean isServiceRunning(String str) {
        return ServiceUtils.isServiceRunning(str);
    }

    static boolean isSpace(String str) {
        return StringUtils.isSpace(str);
    }

    static boolean isValid(View view, long j2) {
        Objects.requireNonNull(view, "Argument 'view' of type View (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return DebouncingUtils.isValid(view, j2);
    }

    static byte[] jsonArray2Bytes(JSONArray jSONArray) {
        return ConvertUtils.jsonArray2Bytes(jSONArray);
    }

    static byte[] jsonObject2Bytes(JSONObject jSONObject) {
        return ConvertUtils.jsonObject2Bytes(jSONObject);
    }

    static View layoutId2View(int i2) {
        return ViewUtils.layoutId2View(i2);
    }

    static String millis2FitTimeSpan(long j2, int i2) {
        return TimeUtils.millis2FitTimeSpan(j2, i2);
    }

    static void notifySystemToScan(File file) {
        FileUtils.notifySystemToScan(file);
    }

    static byte[] parcelable2Bytes(Parcelable parcelable) {
        return ConvertUtils.parcelable2Bytes(parcelable);
    }

    static void preLoad() {
        preLoad(AdaptScreenUtils.getPreLoadRunnable());
    }

    private static void preLoad(Runnable... runnableArr) {
        for (Runnable execute : runnableArr) {
            ThreadUtils.getCachedPool().execute(execute);
        }
    }

    static int px2dp(float f2) {
        return SizeUtils.px2dp(f2);
    }

    static int px2sp(float f2) {
        return SizeUtils.px2sp(f2);
    }

    static byte[] readFile2Bytes(File file) {
        return FileIOUtils.readFile2BytesByChannel(file);
    }

    static void relaunchApp() {
        AppUtils.relaunchApp();
    }

    static void removeActivityLifecycleCallbacks(Activity activity) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity);
    }

    static void removeActivityLifecycleCallbacks(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activity, activityLifecycleCallbacks);
    }

    static void removeActivityLifecycleCallbacks(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        UtilsActivityLifecycleImpl.INSTANCE.removeActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    static void removeOnAppStatusChangedListener(Utils.OnAppStatusChangedListener onAppStatusChangedListener) {
        UtilsActivityLifecycleImpl.INSTANCE.removeOnAppStatusChangedListener(onAppStatusChangedListener);
    }

    static void runOnUiThread(Runnable runnable) {
        ThreadUtils.runOnUiThread(runnable);
    }

    static void runOnUiThreadDelayed(Runnable runnable, long j2) {
        ThreadUtils.runOnUiThreadDelayed(runnable, j2);
    }

    static byte[] serializable2Bytes(Serializable serializable) {
        return ConvertUtils.serializable2Bytes(serializable);
    }

    static int sp2px(float f2) {
        return SizeUtils.sp2px(f2);
    }

    static void startHomeActivity() {
        ActivityUtils.startHomeActivity();
    }

    static byte[] string2Bytes(String str) {
        return ConvertUtils.string2Bytes(str);
    }

    static String toJson(Object obj) {
        return GsonUtils.toJson(obj);
    }

    static void toastCancel() {
        ToastUtils.cancel();
    }

    static void toastShowShort(CharSequence charSequence) {
        ToastUtils.showShort(charSequence);
    }

    static void unInit(Application application) {
        UtilsActivityLifecycleImpl.INSTANCE.unInit(application);
    }

    static File uri2File(Uri uri) {
        return UriUtils.uri2File(uri);
    }

    static Bitmap view2Bitmap(View view) {
        return ImageUtils.view2Bitmap(view);
    }

    static boolean writeFileFromBytes(File file, byte[] bArr) {
        return FileIOUtils.writeFileFromBytesByChannel(file, bArr, true);
    }

    static boolean writeFileFromIS(String str, InputStream inputStream) {
        return FileIOUtils.writeFileFromIS(str, inputStream);
    }

    static boolean writeFileFromString(String str, String str2, boolean z2) {
        return FileIOUtils.writeFileFromString(str, str2, z2);
    }
}
