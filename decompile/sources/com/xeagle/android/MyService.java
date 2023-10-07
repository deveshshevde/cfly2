package com.xeagle.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public IBinder onBind(Intent intent) {
        Log.i("TAG", "onBind");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Log.i("TAG", "onCreate");
        Toast.makeText(this, "Service created...", 1).show();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy");
        Toast.makeText(this, "Service destroyed...", 1).show();
    }
}
