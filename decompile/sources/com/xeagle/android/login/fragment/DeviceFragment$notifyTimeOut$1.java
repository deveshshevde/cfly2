package com.xeagle.android.login.fragment;

import com.xeagle.android.XEagleApp;
import hf.d;

final class DeviceFragment$notifyTimeOut$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$notifyTimeOut$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        d.b("setStatus", "DRONE_CONNECTED: 6");
        XEagleApp access$getXEagleApp$p = this.this$0.xEagleApp;
        if (access$getXEagleApp$p == null || !access$getXEagleApp$p.c()) {
            this.this$0.setStatus(1, 2);
        } else {
            this.this$0.timeoutReset(2);
        }
    }
}
