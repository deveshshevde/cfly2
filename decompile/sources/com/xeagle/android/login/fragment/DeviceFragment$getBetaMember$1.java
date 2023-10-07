package com.xeagle.android.login.fragment;

import com.amap.api.mapcore.util.fx;
import com.google.gson.Gson;
import com.xeagle.android.login.retrofitLogin.SimpleHttpClient;
import com.xeagle.android.vjoystick.beans.BetaMemberBean;
import java.io.IOException;
import kotlin.jvm.internal.h;
import okhttp3.ab;
import okhttp3.ac;

public final class DeviceFragment$getBetaMember$1 implements SimpleHttpClient.RequestCallBack {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$getBetaMember$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onFail(IOException iOException) {
        h.d(iOException, fx.f8867h);
    }

    public void onSuccess(ab abVar) {
        h.d(abVar, "response");
        try {
            ac g2 = abVar.g();
            h.a((Object) g2);
            BetaMemberBean betaMemberBean = (BetaMemberBean) new Gson().fromJson(g2.string(), BetaMemberBean.class);
            DeviceFragment.access$getPrefs$p(this.this$0).setMemberBean(betaMemberBean);
            DeviceFragment deviceFragment = this.this$0;
            h.b(betaMemberBean, "betaMemberDataTemp");
            DeviceFragment.access$handlerMember(deviceFragment, betaMemberBean);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
