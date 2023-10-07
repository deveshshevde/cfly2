package com.huawei.android.multiscreen.dlna.sdk.dms;

import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaUniswitch;
import id.d;

public class a extends com.huawei.android.multiscreen.dlna.sdk.dlnamanager.a implements b {

    /* renamed from: a  reason: collision with root package name */
    private d f20829a;

    /* renamed from: b  reason: collision with root package name */
    private c f20830b;

    public a() {
        d a2 = d.a();
        this.f20829a = a2;
        this.f20830b = a2.f();
    }

    public boolean a(boolean z2) {
        if (DlnaUniswitch.a().dlnaApiDmsEnableShare(z2) != 0) {
            return false;
        }
        this.f20829a.e();
        return true;
    }
}
