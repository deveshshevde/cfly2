package com.xeagle.android.login.fragment;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xeagle.android.login.common.service.UdpDataService;
import kotlin.jvm.internal.h;

public final class DeviceFragment$connection$1 implements ServiceConnection {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$connection$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        h.d(componentName, "name");
        h.d(iBinder, "iBinder");
        this.this$0.udpService = ((UdpDataService.UdpBinder) iBinder).getService();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        h.d(componentName, "name");
    }
}
