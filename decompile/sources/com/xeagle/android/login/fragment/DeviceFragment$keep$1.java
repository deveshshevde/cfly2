package com.xeagle.android.login.fragment;

import android.os.Handler;
import com.flypro.core.MAVLink.b;
import kotlin.jvm.internal.h;

public final class DeviceFragment$keep$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$keep$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void run() {
        b.a(this.this$0.drone, (byte) 22);
        Handler access$getHandler$p = this.this$0.handler;
        h.a((Object) access$getHandler$p);
        access$getHandler$p.postDelayed(this, 10000);
    }
}
