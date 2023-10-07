package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;

final class ah {

    /* renamed from: a  reason: collision with root package name */
    private final WifiManager f15190a;

    /* renamed from: b  reason: collision with root package name */
    private WifiManager.WifiLock f15191b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15192c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15193d;

    public ah(Context context) {
        this.f15190a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void a() {
        WifiManager.WifiLock wifiLock = this.f15191b;
        if (wifiLock != null) {
            if (!this.f15192c || !this.f15193d) {
                wifiLock.release();
            } else {
                wifiLock.acquire();
            }
        }
    }

    public void a(boolean z2) {
        this.f15193d = z2;
        a();
    }
}
