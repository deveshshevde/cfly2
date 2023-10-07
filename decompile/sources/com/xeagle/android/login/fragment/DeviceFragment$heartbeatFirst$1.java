package com.xeagle.android.login.fragment;

import android.os.SystemClock;
import android.util.Log;
import com.flypro.core.MAVLink.b;

final class DeviceFragment$heartbeatFirst$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$heartbeatFirst$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        while (!this.this$0.isReceiveVersion) {
            Log.i("HEART", "onDroneConnectEvent:-------- 683");
            b.a(this.this$0.drone, (byte) 99);
            SystemClock.sleep(1000);
        }
        this.this$0.setupStreamRatesFromPref();
    }
}
