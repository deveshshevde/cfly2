package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.core.content.b;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class PermissionUtils {
    /* access modifiers changed from: private */
    public static PermissionUtils sInstance;
    /* access modifiers changed from: private */
    public static SimpleCallback sSimpleCallback4DrawOverlays;
    /* access modifiers changed from: private */
    public static SimpleCallback sSimpleCallback4WriteSettings;
    private FullCallback mFullCallback;
    /* access modifiers changed from: private */
    public OnExplainListener mOnExplainListener;
    private OnRationaleListener mOnRationaleListener;
    private Set<String> mPermissions;
    /* access modifiers changed from: private */
    public List<String> mPermissionsDenied;
    /* access modifiers changed from: private */
    public List<String> mPermissionsDeniedForever;
    private List<String> mPermissionsGranted;
    private String[] mPermissionsParam;
    /* access modifiers changed from: private */
    public List<String> mPermissionsRequest;
    private SimpleCallback mSimpleCallback;
    private SingleCallback mSingleCallback;
    /* access modifiers changed from: private */
    public ThemeCallback mThemeCallback;

    public interface FullCallback {
        void onDenied(List<String> list, List<String> list2);

        void onGranted(List<String> list);
    }

    public interface OnExplainListener {

        public interface ShouldRequest {
            void start(boolean z2);
        }

        void explain(UtilsTransActivity utilsTransActivity, List<String> list, ShouldRequest shouldRequest);
    }

    public interface OnRationaleListener {

        public interface ShouldRequest {
            void again(boolean z2);
        }

        void rationale(UtilsTransActivity utilsTransActivity, ShouldRequest shouldRequest);
    }

    static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {
        private static PermissionActivityImpl INSTANCE = new PermissionActivityImpl();
        private static final String TYPE = "TYPE";
        private static final int TYPE_DRAW_OVERLAYS = 3;
        private static final int TYPE_RUNTIME = 1;
        private static final int TYPE_WRITE_SETTINGS = 2;
        private static int currentRequestCode = -1;

        PermissionActivityImpl() {
        }

        private void checkRequestCallback(int i2) {
            if (i2 == 2) {
                if (PermissionUtils.sSimpleCallback4WriteSettings != null) {
                    if (PermissionUtils.isGrantedWriteSettings()) {
                        PermissionUtils.sSimpleCallback4WriteSettings.onGranted();
                    } else {
                        PermissionUtils.sSimpleCallback4WriteSettings.onDenied();
                    }
                    SimpleCallback unused = PermissionUtils.sSimpleCallback4WriteSettings = null;
                }
            } else if (i2 == 3 && PermissionUtils.sSimpleCallback4DrawOverlays != null) {
                if (PermissionUtils.isGrantedDrawOverlays()) {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onGranted();
                } else {
                    PermissionUtils.sSimpleCallback4DrawOverlays.onDenied();
                }
                SimpleCallback unused2 = PermissionUtils.sSimpleCallback4DrawOverlays = null;
            }
        }

        /* access modifiers changed from: private */
        public void requestPermissions(final UtilsTransActivity utilsTransActivity) {
            if (!PermissionUtils.sInstance.shouldRationale(utilsTransActivity, new Runnable() {
                public void run() {
                    utilsTransActivity.requestPermissions((String[]) PermissionUtils.sInstance.mPermissionsRequest.toArray(new String[0]), 1);
                }
            })) {
                utilsTransActivity.requestPermissions((String[]) PermissionUtils.sInstance.mPermissionsRequest.toArray(new String[0]), 1);
            }
        }

        public static void start(final int i2) {
            UtilsTransActivity.start((Utils.Consumer<Intent>) new Utils.Consumer<Intent>() {
                public void accept(Intent intent) {
                    intent.putExtra(PermissionActivityImpl.TYPE, i2);
                }
            }, (UtilsTransActivity.TransActivityDelegate) INSTANCE);
        }

        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
            return true;
        }

        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i2, int i3, Intent intent) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
        }

        public void onCreated(final UtilsTransActivity utilsTransActivity, Bundle bundle) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra(TYPE, -1);
            if (intExtra == 1) {
                if (PermissionUtils.sInstance == null) {
                    Log.e("PermissionUtils", "sInstance is null.");
                    utilsTransActivity.finish();
                } else if (PermissionUtils.sInstance.mPermissionsRequest == null) {
                    Log.e("PermissionUtils", "mPermissionsRequest is null.");
                    utilsTransActivity.finish();
                } else if (PermissionUtils.sInstance.mPermissionsRequest.size() <= 0) {
                    Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                    utilsTransActivity.finish();
                } else {
                    if (PermissionUtils.sInstance.mThemeCallback != null) {
                        PermissionUtils.sInstance.mThemeCallback.onActivityCreate(utilsTransActivity);
                    }
                    if (PermissionUtils.sInstance.mOnExplainListener != null) {
                        PermissionUtils.sInstance.mOnExplainListener.explain(utilsTransActivity, PermissionUtils.sInstance.mPermissionsRequest, new OnExplainListener.ShouldRequest() {
                            public void start(boolean z2) {
                                if (!z2) {
                                    utilsTransActivity.finish();
                                } else {
                                    PermissionActivityImpl.this.requestPermissions(utilsTransActivity);
                                }
                            }
                        });
                        OnExplainListener unused = PermissionUtils.sInstance.mOnExplainListener = null;
                        return;
                    }
                    requestPermissions(utilsTransActivity);
                }
            } else if (intExtra == 2) {
                currentRequestCode = 2;
                PermissionUtils.startWriteSettingsActivity(utilsTransActivity, 2);
            } else if (intExtra == 3) {
                currentRequestCode = 3;
                PermissionUtils.startOverlayPermissionActivity(utilsTransActivity, 3);
            } else {
                utilsTransActivity.finish();
                Log.e("PermissionUtils", "type is wrong.");
            }
        }

        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            int i2 = currentRequestCode;
            if (i2 != -1) {
                checkRequestCallback(i2);
                currentRequestCode = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i2, String[] strArr, int[] iArr) {
            Objects.requireNonNull(utilsTransActivity, "Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(strArr, "Argument 'permissions' of type String[] (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(iArr, "Argument 'grantResults' of type int[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            utilsTransActivity.finish();
            if (PermissionUtils.sInstance != null && PermissionUtils.sInstance.mPermissionsRequest != null) {
                PermissionUtils.sInstance.onRequestPermissionsResult(utilsTransActivity);
            }
        }
    }

    public interface SimpleCallback {
        void onDenied();

        void onGranted();
    }

    public interface SingleCallback {
        void callback(boolean z2, List<String> list, List<String> list2, List<String> list3);
    }

    public interface ThemeCallback {
        void onActivityCreate(Activity activity);
    }

    private PermissionUtils(String... strArr) {
        this.mPermissionsParam = strArr;
        sInstance = this;
    }

    public static List<String> getPermissions() {
        return getPermissions(Utils.getApp().getPackageName());
    }

    public static List<String> getPermissions(String str) {
        try {
            String[] strArr = Utils.getApp().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void getPermissionsStatus(Activity activity) {
        List<String> list;
        for (String next : this.mPermissionsRequest) {
            if (isGranted(next)) {
                list = this.mPermissionsGranted;
            } else {
                this.mPermissionsDenied.add(next);
                if (!activity.shouldShowRequestPermissionRationale(next)) {
                    list = this.mPermissionsDeniedForever;
                }
            }
            list.add(next);
        }
    }

    private static Pair<List<String>, List<String>> getRequestAndDeniedPermissions(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<String> permissions = getPermissions();
        for (String str : strArr) {
            boolean z2 = false;
            for (String str2 : PermissionConstants.getPermissions(str)) {
                if (permissions.contains(str2)) {
                    arrayList.add(str2);
                    z2 = true;
                }
            }
            if (!z2) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    private static boolean isGranted(String str) {
        return Build.VERSION.SDK_INT < 23 || b.b((Context) Utils.getApp(), str) == 0;
    }

    public static boolean isGranted(String... strArr) {
        Pair<List<String>, List<String>> requestAndDeniedPermissions = getRequestAndDeniedPermissions(strArr);
        if (!((List) requestAndDeniedPermissions.second).isEmpty()) {
            return false;
        }
        for (String isGranted : (List) requestAndDeniedPermissions.first) {
            if (!isGranted(isGranted)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isGrantedDrawOverlays() {
        return Settings.canDrawOverlays(Utils.getApp());
    }

    public static boolean isGrantedWriteSettings() {
        return Settings.System.canWrite(Utils.getApp());
    }

    public static void launchAppDetailsSettings() {
        Intent launchAppDetailsSettingsIntent = UtilsBridge.getLaunchAppDetailsSettingsIntent(Utils.getApp().getPackageName(), true);
        if (UtilsBridge.isIntentAvailable(launchAppDetailsSettingsIntent)) {
            Utils.getApp().startActivity(launchAppDetailsSettingsIntent);
        }
    }

    /* access modifiers changed from: private */
    public void onRequestPermissionsResult(Activity activity) {
        getPermissionsStatus(activity);
        requestCallback();
    }

    public static PermissionUtils permission(String... strArr) {
        return new PermissionUtils(strArr);
    }

    public static PermissionUtils permissionGroup(String... strArr) {
        return permission(strArr);
    }

    private void rationalInner(final UtilsTransActivity utilsTransActivity, final Runnable runnable) {
        getPermissionsStatus(utilsTransActivity);
        this.mOnRationaleListener.rationale(utilsTransActivity, new OnRationaleListener.ShouldRequest() {
            public void again(boolean z2) {
                if (z2) {
                    List unused = PermissionUtils.this.mPermissionsDenied = new ArrayList();
                    List unused2 = PermissionUtils.this.mPermissionsDeniedForever = new ArrayList();
                    runnable.run();
                    return;
                }
                utilsTransActivity.finish();
                PermissionUtils.this.requestCallback();
            }
        });
    }

    /* access modifiers changed from: private */
    public void requestCallback() {
        SingleCallback singleCallback = this.mSingleCallback;
        if (singleCallback != null) {
            singleCallback.callback(this.mPermissionsDenied.isEmpty(), this.mPermissionsGranted, this.mPermissionsDeniedForever, this.mPermissionsDenied);
            this.mSingleCallback = null;
        }
        if (this.mSimpleCallback != null) {
            if (this.mPermissionsDenied.isEmpty()) {
                this.mSimpleCallback.onGranted();
            } else {
                this.mSimpleCallback.onDenied();
            }
            this.mSimpleCallback = null;
        }
        if (this.mFullCallback != null) {
            if (this.mPermissionsRequest.size() == 0 || this.mPermissionsGranted.size() > 0) {
                this.mFullCallback.onGranted(this.mPermissionsGranted);
            }
            if (!this.mPermissionsDenied.isEmpty()) {
                this.mFullCallback.onDenied(this.mPermissionsDeniedForever, this.mPermissionsDenied);
            }
            this.mFullCallback = null;
        }
        this.mOnRationaleListener = null;
        this.mThemeCallback = null;
    }

    public static void requestDrawOverlays(SimpleCallback simpleCallback) {
        if (!isGrantedDrawOverlays()) {
            sSimpleCallback4DrawOverlays = simpleCallback;
            PermissionActivityImpl.start(3);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    public static void requestWriteSettings(SimpleCallback simpleCallback) {
        if (!isGrantedWriteSettings()) {
            sSimpleCallback4WriteSettings = simpleCallback;
            PermissionActivityImpl.start(2);
        } else if (simpleCallback != null) {
            simpleCallback.onGranted();
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldRationale(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        boolean z2 = false;
        if (this.mOnRationaleListener != null) {
            Iterator<String> it2 = this.mPermissionsRequest.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (utilsTransActivity.shouldShowRequestPermissionRationale(it2.next())) {
                        rationalInner(utilsTransActivity, runnable);
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.mOnRationaleListener = null;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public static void startOverlayPermissionActivity(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!UtilsBridge.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    private void startPermissionActivity() {
        PermissionActivityImpl.start(1);
    }

    /* access modifiers changed from: private */
    public static void startWriteSettingsActivity(Activity activity, int i2) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.getApp().getPackageName()));
        if (!UtilsBridge.isIntentAvailable(intent)) {
            launchAppDetailsSettings();
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public PermissionUtils callback(FullCallback fullCallback) {
        this.mFullCallback = fullCallback;
        return this;
    }

    public PermissionUtils callback(SimpleCallback simpleCallback) {
        this.mSimpleCallback = simpleCallback;
        return this;
    }

    public PermissionUtils callback(SingleCallback singleCallback) {
        this.mSingleCallback = singleCallback;
        return this;
    }

    public PermissionUtils explain(OnExplainListener onExplainListener) {
        this.mOnExplainListener = onExplainListener;
        return this;
    }

    public PermissionUtils rationale(OnRationaleListener onRationaleListener) {
        this.mOnRationaleListener = onRationaleListener;
        return this;
    }

    public void request() {
        String[] strArr = this.mPermissionsParam;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.mPermissions = new LinkedHashSet();
        this.mPermissionsRequest = new ArrayList();
        this.mPermissionsGranted = new ArrayList();
        this.mPermissionsDenied = new ArrayList();
        this.mPermissionsDeniedForever = new ArrayList();
        Pair<List<String>, List<String>> requestAndDeniedPermissions = getRequestAndDeniedPermissions(this.mPermissionsParam);
        this.mPermissions.addAll((Collection) requestAndDeniedPermissions.first);
        this.mPermissionsDenied.addAll((Collection) requestAndDeniedPermissions.second);
        if (Build.VERSION.SDK_INT < 23) {
            this.mPermissionsGranted.addAll(this.mPermissions);
        } else {
            for (String next : this.mPermissions) {
                (isGranted(next) ? this.mPermissionsGranted : this.mPermissionsRequest).add(next);
            }
            if (!this.mPermissionsRequest.isEmpty()) {
                startPermissionActivity();
                return;
            }
        }
        requestCallback();
    }

    public PermissionUtils theme(ThemeCallback themeCallback) {
        this.mThemeCallback = themeCallback;
        return this;
    }
}
