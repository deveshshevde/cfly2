package com.xeagle.android.login.fragment;

import com.xeagle.android.XEagleApp;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.prefs.a;
import kotlin.jvm.internal.h;
import kotlin.text.f;

final class DeviceFragment$mReceiver$1$onReceive$2 implements Runnable {
    final /* synthetic */ DeviceFragment$mReceiver$1 this$0;

    DeviceFragment$mReceiver$1$onReceive$2(DeviceFragment$mReceiver$1 deviceFragment$mReceiver$1) {
        this.this$0 = deviceFragment$mReceiver$1;
    }

    public final void run() {
        XEagleApp access$getXEagleApp$p = this.this$0.this$0.xEagleApp;
        h.a((Object) access$getXEagleApp$p);
        if (!access$getXEagleApp$p.c()) {
            a access$getPrefs$p = DeviceFragment.access$getPrefs$p(this.this$0.this$0);
            h.a((Object) access$getPrefs$p);
            if (c.i(access$getPrefs$p.q()) < 130) {
                a access$getPrefs$p2 = DeviceFragment.access$getPrefs$p(this.this$0.this$0);
                h.a((Object) access$getPrefs$p2);
                if (!f.a(access$getPrefs$p2.q(), "N/A", true)) {
                    this.this$0.this$0.showConnectWifiList();
                }
            }
        }
    }
}
