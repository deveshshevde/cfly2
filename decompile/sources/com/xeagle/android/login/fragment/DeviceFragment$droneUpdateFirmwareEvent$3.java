package com.xeagle.android.login.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.common.ip.TipsDialog;
import com.xeagle.android.utils.prefs.a;
import java.util.Objects;
import kotlin.jvm.internal.h;

public final class DeviceFragment$droneUpdateFirmwareEvent$3 implements TipsDialog.Listener {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$droneUpdateFirmwareEvent$3(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onCheckBtn(boolean z2) {
        a aVar;
        boolean z3;
        if (z2) {
            if (DeviceFragment.access$getPrefs$p(this.this$0) != null) {
                a access$getPrefs$p = DeviceFragment.access$getPrefs$p(this.this$0);
                h.a((Object) access$getPrefs$p);
                if (!access$getPrefs$p.aM()) {
                    aVar = DeviceFragment.access$getPrefs$p(this.this$0);
                    h.a((Object) aVar);
                    z3 = true;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (DeviceFragment.access$getPrefs$p(this.this$0) != null) {
            a access$getPrefs$p2 = DeviceFragment.access$getPrefs$p(this.this$0);
            h.a((Object) access$getPrefs$p2);
            if (access$getPrefs$p2.aM()) {
                aVar = DeviceFragment.access$getPrefs$p(this.this$0);
                h.a((Object) aVar);
                z3 = false;
            } else {
                return;
            }
        } else {
            return;
        }
        aVar.p(z3);
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
