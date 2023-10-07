package com.xeagle.android.login.fragment;

import com.xeagle.android.login.HostManagerActivity;
import kotlin.jvm.internal.h;

final class DeviceFragment$handlerMember$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$handlerMember$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public final void run() {
        HostManagerActivity access$getParent$p = this.this$0.parent;
        h.a((Object) access$getParent$p);
        access$getParent$p.bindTime();
    }
}
