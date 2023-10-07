package com.xeagle.android.login.fragment;

import android.view.View;
import android.widget.TextView;
import com.xeagle.R;
import hf.d;
import kotlin.jvm.internal.h;

public final class DeviceFragment$droneUpdateFirmwareEvent$1 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$droneUpdateFirmwareEvent$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void run() {
        d.b("tv_device_name", "run:======droneType3==== DF808");
        View access$getMLayoutView$p = this.this$0.mLayoutView;
        TextView textView = access$getMLayoutView$p != null ? (TextView) access$getMLayoutView$p.findViewById(R.id.tv_device_name) : null;
        h.a((Object) textView);
        textView.setText("Drone");
        this.this$0.setStatus(0, 7);
    }
}
