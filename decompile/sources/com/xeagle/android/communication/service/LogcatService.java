package com.xeagle.android.communication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.flypro.core.util.d;
import com.xeagle.android.utils.c;

public class LogcatService extends Service {
    private void a() {
        String a2 = d.a("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis());
        c.f12769a = true;
        c.f(kx.d.n(getApplicationContext()) + "/" + a2 + ".txt");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        a();
        return super.onStartCommand(intent, i2, i3);
    }
}
