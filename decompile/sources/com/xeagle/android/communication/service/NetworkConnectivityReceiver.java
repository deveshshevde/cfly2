package com.xeagle.android.communication.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkConnectivityReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22468a = "NetworkConnectivityReceiver";

    public static void a(Context context, boolean z2) {
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, NetworkConnectivityReceiver.class), z2 ? 1 : 2, 1);
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && !intent.getBooleanExtra("noConnectivity", false)) {
            context.startService(UploaderService.a(context));
            Log.d(f22468a, "Disabling connectivity receiver.");
            a(context, false);
        }
    }
}
