package com.xeagle.android.login.fragment;

final class DeviceFragment$notifyTimeOut$2 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$notifyTimeOut$2(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        this.this$0.setStatus(0, 6);
    }
}
