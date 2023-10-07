package com.xeagle.android.login.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.cfly.uav_pro.R;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.login.HostManagerActivity;
import java.util.Objects;
import kotlin.jvm.internal.h;

public final class DeviceFragment$droneUpdateFirmwareEvent$2 implements c.a {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$droneUpdateFirmwareEvent$2(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onNo() {
    }

    public void onYes() {
        HostManagerActivity access$getParent$p = this.this$0.parent;
        h.a((Object) access$getParent$p);
        Object systemService = access$getParent$p.getSystemService("clipboard");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        HostManagerActivity access$getParent$p2 = this.this$0.parent;
        h.a((Object) access$getParent$p2);
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("simple text", access$getParent$p2.getString(R.string.clip_board_str)));
    }
}
