package com.xeagle.android.login.fragment;

import android.os.SystemClock;
import com.flypro.core.MAVLink.b;

final class DeviceFragment$reStartRtsp$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$reStartRtsp$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        while (!this.this$0.isReceiveVersion) {
            b.a(this.this$0.drone, (byte) 99);
            SystemClock.sleep(500);
        }
        this.this$0.setupStreamRatesFromPref();
    }
}
