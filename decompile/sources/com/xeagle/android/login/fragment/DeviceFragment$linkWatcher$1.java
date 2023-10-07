package com.xeagle.android.login.fragment;

final class DeviceFragment$linkWatcher$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$linkWatcher$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        this.this$0.connectToMav(2);
    }
}
