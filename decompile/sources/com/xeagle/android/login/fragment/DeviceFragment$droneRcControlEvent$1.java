package com.xeagle.android.login.fragment;

import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.common.service.UdpDataService;
import com.xeagle.android.utils.prefs.a;
import ea.e;
import hf.d;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.f;

public final class DeviceFragment$droneRcControlEvent$1 implements UdpDataService.OnReceiveDataListener {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$droneRcControlEvent$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onReceiveDataListener(String str) {
        h.d(str, "msg");
        d.b("HEART", "onReceiveDataListener:===MSG=== " + str);
        CharSequence charSequence = str;
        if (((!f.a(charSequence, (CharSequence) "[", false, 2, (Object) null) && !f.a(charSequence, (CharSequence) "]", false, 2, (Object) null) && str.length() >= 14) || f.a(charSequence, (CharSequence) "Addr", false, 2, (Object) null)) && str.length() > 6) {
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, 6);
            h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            String substring2 = str.substring(8, 14);
            h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring2);
            String sb2 = sb.toString();
            a access$getPrefs$p = DeviceFragment.access$getPrefs$p(this.this$0);
            h.a((Object) access$getPrefs$p);
            access$getPrefs$p.e(sb2);
            XEagleApp access$getXEagleApp$p = this.this$0.xEagleApp;
            h.a((Object) access$getXEagleApp$p);
            e n2 = access$getXEagleApp$p.n();
            h.b(n2, "xEagleApp!!.getlInfo()");
            n2.g(sb2);
        }
        l unused = this.this$0.getRcVersion();
    }

    public void onReceiveError(String str) {
        h.d(str, "msg");
        l unused = this.this$0.getRcVersion();
    }
}
