package com.xeagle.android.login.fragment;

import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.common.service.UdpDataService;
import com.xeagle.android.utils.prefs.a;
import ea.e;
import hf.d;
import kotlin.jvm.internal.h;

public final class DeviceFragment$rcVersion$1 implements UdpDataService.OnReceiveDataListener {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$rcVersion$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onReceiveDataListener(String str) {
        h.d(str, "msg");
        d.b("HEART", "onReceiveDataListener:---rc version--- " + str);
        a access$getPrefs$p = DeviceFragment.access$getPrefs$p(this.this$0);
        h.a((Object) access$getPrefs$p);
        access$getPrefs$p.f(str);
        XEagleApp access$getXEagleApp$p = this.this$0.xEagleApp;
        h.a((Object) access$getXEagleApp$p);
        e n2 = access$getXEagleApp$p.n();
        h.b(n2, "xEagleApp!!.getlInfo()");
        n2.f(str);
    }

    public void onReceiveError(String str) {
        h.d(str, "msg");
    }
}
