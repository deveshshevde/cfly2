package com.xeagle.android.vjoystick.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import jo.aj;
import jo.r;
import org.greenrobot.eventbus.c;

public class HomeWatcherReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i("ACTION", "onReceive: action: " + action);
        if (action.equalsIgnoreCase("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
            String stringExtra = intent.getStringExtra("reason");
            Log.i("Sochip", "reason: " + stringExtra);
            if ("homekey".equalsIgnoreCase(stringExtra)) {
                Log.i("Sochip", "homekey");
                c.a().d(new r(true));
                SystemClock.sleep(100);
            } else if ("recentapps".equalsIgnoreCase(stringExtra)) {
                Log.i("Sochip", "long press home key or activity switch");
                c.a().d(new aj(true));
                return;
            } else if ("lock".equalsIgnoreCase(stringExtra)) {
                Log.i("ACTION", "lock");
                c.a().d(new r(true));
            } else if ("assist".equalsIgnoreCase(stringExtra)) {
                Log.i("ACTION", "assist");
                return;
            } else {
                return;
            }
            System.exit(0);
        }
    }
}
