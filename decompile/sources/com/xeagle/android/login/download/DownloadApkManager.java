package com.xeagle.android.login.download;

import android.content.Context;
import android.content.IntentFilter;

public class DownloadApkManager {
    private static PackageInstallReceiver receiver;

    public static void registerReceiver(Context context, String str) {
        receiver = new PackageInstallReceiver(str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        context.registerReceiver(receiver, intentFilter);
    }

    public static void unRegisterReceiver(Context context) {
        PackageInstallReceiver packageInstallReceiver = receiver;
        if (packageInstallReceiver != null) {
            context.unregisterReceiver(packageInstallReceiver);
        }
    }
}
