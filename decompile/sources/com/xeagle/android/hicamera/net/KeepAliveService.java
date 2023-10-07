package com.xeagle.android.hicamera.net;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.xeagle.android.hicamera.unity.e;

public class KeepAliveService extends Service {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f23622a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f23623b = true;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f23624c = 0;

    private void a() {
        new Thread("KeepAliveThread") {
            public void run() {
                while (KeepAliveService.this.f23622a) {
                    if (!e.a(KeepAliveService.this)) {
                        KeepAliveService.b(KeepAliveService.this);
                        Log.d("KeepAliveService", "isDeviceAvailable:false");
                        if (KeepAliveService.this.f23624c > 3) {
                            int unused = KeepAliveService.this.f23624c = 0;
                            boolean unused2 = KeepAliveService.this.f23623b = false;
                            Log.d("KeepAliveService", "bNetworkPast:" + KeepAliveService.this.f23623b);
                            Intent intent = new Intent("com.xeagle.DV_ISALIVE_ACTION");
                            intent.putExtra("networkpast", KeepAliveService.this.f23623b);
                            KeepAliveService.this.sendBroadcast(intent);
                        }
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        int unused3 = KeepAliveService.this.f23624c = 0;
                        Log.d("KeepAliveService", "isDeviceAvailable:true");
                        if (!KeepAliveService.this.f23623b) {
                            boolean unused4 = KeepAliveService.this.f23623b = true;
                            Log.d("KeepAliveService", "bNetworkPast:" + KeepAliveService.this.f23623b);
                            Intent intent2 = new Intent("com.xeagle.DV_ISALIVE_ACTION");
                            intent2.putExtra("networkpast", KeepAliveService.this.f23623b);
                            KeepAliveService.this.sendBroadcast(intent2);
                        }
                        Thread.sleep(5000);
                    }
                }
            }
        }.start();
    }

    static /* synthetic */ int b(KeepAliveService keepAliveService) {
        int i2 = keepAliveService.f23624c;
        keepAliveService.f23624c = i2 + 1;
        return i2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        Log.d("KeepAliveService", "onCreate");
        this.f23622a = true;
        a();
        super.onCreate();
    }

    public void onDestroy() {
        Log.d("KeepAliveService", "onDestroy");
        this.f23622a = false;
        super.onDestroy();
    }
}
