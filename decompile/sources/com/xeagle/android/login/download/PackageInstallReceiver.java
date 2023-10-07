package com.xeagle.android.login.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class PackageInstallReceiver extends BroadcastReceiver {
    private String apkPath;

    public PackageInstallReceiver(String str) {
        this.apkPath = str;
    }

    public void onReceive(Context context, Intent intent) {
        File file;
        if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
            Log.i("APK", "onReceive:---INSTALL ");
            if (TextUtils.equals(ApkUtils.getPackageName(context), intent.getData().getSchemeSpecificPart())) {
                file = new File(this.apkPath);
                if (!file.exists()) {
                    return;
                }
            } else {
                return;
            }
        } else if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
            Log.i("APK", "onReceive: ----uninstall");
            intent.getData().getSchemeSpecificPart();
            return;
        } else if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REPLACED")) {
            Log.i("APK", "onReceive: ----replace");
            if (TextUtils.equals(ApkUtils.getPackageName(context), intent.getData().getSchemeSpecificPart())) {
                file = new File(this.apkPath);
                if (!file.exists()) {
                    return;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        file.delete();
    }
}
