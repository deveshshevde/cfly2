package com.xeagle.android.login.fragment;

import com.xeagle.android.XEagleApp;
import com.xeagle.android.vjoystick.DroneControlFragment;
import hf.d;
import kotlin.jvm.internal.h;

final class DeviceFragment$runTimeOut$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$runTimeOut$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        if (this.this$0.xEagleApp != null) {
            XEagleApp access$getXEagleApp$p = this.this$0.xEagleApp;
            h.a((Object) access$getXEagleApp$p);
            if (access$getXEagleApp$p.c()) {
                d.b(DeviceFragment.TAG, "setStatus:====isConnect10005===runTimeOut 194");
                this.this$0.isReceiveVersion = true;
                com.hoho.android.usb.usb.data_proxy.d.f11899b.a(false);
                this.this$0.setStatus(2, 3);
                DroneControlFragment.f12789g = false;
                XEagleApp access$getXEagleApp$p2 = this.this$0.xEagleApp;
                h.a((Object) access$getXEagleApp$p2);
                access$getXEagleApp$p2.f().c();
            }
        }
    }
}
