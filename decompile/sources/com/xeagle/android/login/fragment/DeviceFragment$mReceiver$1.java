package com.xeagle.android.login.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.flypro.core.util.e;
import com.xeagle.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import en.a;
import hf.d;
import kotlin.jvm.internal.h;

public final class DeviceFragment$mReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$mReceiver$1(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void onReceive(Context context, Intent intent) {
        h.d(context, "context");
        h.d(intent, "intent");
        String action = intent.getAction();
        XEagleApp access$getXEagleApp$p = this.this$0.xEagleApp;
        h.a((Object) access$getXEagleApp$p);
        if (!access$getXEagleApp$p.c()) {
            if (h.a((Object) "android.net.wifi.WIFI_STATE_CHANGED", (Object) action)) {
                int intExtra = intent.getIntExtra("wifi_state", -1);
                if (intExtra == 1) {
                    XEagleApp access$getXEagleApp$p2 = this.this$0.xEagleApp;
                    h.a((Object) access$getXEagleApp$p2);
                    if (access$getXEagleApp$p2.a() != null) {
                        Handler access$getHandler$p = this.this$0.handler;
                        h.a((Object) access$getHandler$p);
                        access$getHandler$p.post(new DeviceFragment$mReceiver$1$onReceive$1(this));
                        if (Build.VERSION.SDK_INT < 29) {
                            XEagleApp access$getXEagleApp$p3 = this.this$0.xEagleApp;
                            h.a((Object) access$getXEagleApp$p3);
                            access$getXEagleApp$p3.a().a();
                            return;
                        }
                        Handler access$getHandler$p2 = this.this$0.handler;
                        h.a((Object) access$getHandler$p2);
                        access$getHandler$p2.post(new DeviceFragment$mReceiver$1$onReceive$2(this));
                    }
                } else if (intExtra == 3) {
                    View access$getMLayoutView$p = this.this$0.mLayoutView;
                    IButton iButton = access$getMLayoutView$p != null ? (IButton) access$getMLayoutView$p.findViewById(R.id.tv_bottom_name) : null;
                    h.a((Object) iButton);
                    String obj = iButton.getText().toString();
                    HostManagerActivity access$getParent$p = this.this$0.parent;
                    h.a((Object) access$getParent$p);
                    if (h.a((Object) obj, (Object) access$getParent$p.getString(com.cfly.uav_pro.R.string.tv_guide_connect)) && this.this$0.drone != null) {
                        a access$getDrone$p = this.this$0.drone;
                        h.a((Object) access$getDrone$p);
                        access$getDrone$p.j().d();
                    }
                }
            } else if (!h.a((Object) "android.net.wifi.SCAN_RESULTS", (Object) action) && h.a((Object) "android.net.wifi.STATE_CHANGE", (Object) intent.getAction())) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                NetworkInfo.State state = NetworkInfo.State.DISCONNECTED;
                h.a((Object) networkInfo);
                if (state == networkInfo.getState()) {
                    Log.d("WIFI", "wifi没连接上");
                } else if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("wifi连接上了");
                    XEagleApp access$getXEagleApp$p4 = this.this$0.xEagleApp;
                    h.a((Object) access$getXEagleApp$p4);
                    e a2 = access$getXEagleApp$p4.a();
                    h.b(a2, "xEagleApp!!.function");
                    sb.append(a2.i());
                    Log.d("WIFI", sb.toString());
                    this.this$0.wifiConnect();
                } else if (NetworkInfo.State.CONNECTING == networkInfo.getState()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("wifi正在连接::");
                    XEagleApp access$getXEagleApp$p5 = this.this$0.xEagleApp;
                    h.a((Object) access$getXEagleApp$p5);
                    e a3 = access$getXEagleApp$p5.a();
                    h.b(a3, "xEagleApp!!.function");
                    sb2.append(a3.i());
                    d.b("WIFI", sb2.toString());
                    d.b(DeviceFragment.TAG, "(NetworkInfo.State.CONNECTING == info.getState(): 连接中");
                    this.this$0.setStatus(2, 2);
                }
            }
        }
    }
}
