package com.xeagle.android.login.fragment;

import android.content.Intent;
import com.xeagle.android.dialogs.d;

public final class DeviceFragment$showConnectWifiList$1 implements d.a {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$showConnectWifiList$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onNo() {
    }

    public void onYes() {
        Intent intent = new Intent();
        intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");
        this.this$0.startActivity(intent);
    }
}
