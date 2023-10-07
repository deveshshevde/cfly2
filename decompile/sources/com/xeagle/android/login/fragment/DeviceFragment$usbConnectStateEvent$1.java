package com.xeagle.android.login.fragment;

final class DeviceFragment$usbConnectStateEvent$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$usbConnectStateEvent$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        this.this$0.setStatus(2, 5);
    }
}
