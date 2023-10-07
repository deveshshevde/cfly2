package com.xeagle.android.login.fragment;

import android.view.View;
import android.widget.TextView;
import com.flypro.core.util.e;
import com.xeagle.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.utils.prefs.a;
import hf.d;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlin.text.f;

public final class DeviceFragment$droneUpdateFirmwareEvent$4 implements Runnable {
    final /* synthetic */ DeviceFragment this$0;

    DeviceFragment$droneUpdateFirmwareEvent$4(DeviceFragment deviceFragment) {
        this.this$0 = deviceFragment;
    }

    public void run() {
        DeviceFragment deviceFragment;
        int i2;
        int i3;
        DeviceFragment deviceFragment2;
        d.b("tv_device_name", "run:======droneType4==== " + DeviceFragment.access$getPrefs$p(this.this$0).j());
        View access$getMLayoutView$p = this.this$0.mLayoutView;
        TextView textView = access$getMLayoutView$p != null ? (TextView) access$getMLayoutView$p.findViewById(R.id.tv_device_name) : null;
        h.a((Object) textView);
        l lVar = l.f30252a;
        Locale locale = Locale.US;
        a access$getPrefs$p = DeviceFragment.access$getPrefs$p(this.this$0);
        h.a((Object) access$getPrefs$p);
        String j2 = access$getPrefs$p.j();
        h.b(j2, "prefs!!.droneType");
        String format = String.format(locale, "DF%s", Arrays.copyOf(new Object[]{f.a(j2, "-", "", false, 4, (Object) null)}, 1));
        h.b(format, "java.lang.String.format(locale, format, *args)");
        textView.setText(format);
        XEagleApp access$getXEagleApp$p = this.this$0.xEagleApp;
        h.a((Object) access$getXEagleApp$p);
        com.xeagle.android.a m2 = access$getXEagleApp$p.m();
        h.b(m2, "xEagleApp!!.appState");
        if (m2.a() != 1) {
            XEagleApp access$getXEagleApp$p2 = this.this$0.xEagleApp;
            h.a((Object) access$getXEagleApp$p2);
            com.xeagle.android.a m3 = access$getXEagleApp$p2.m();
            h.b(m3, "xEagleApp!!.appState");
            if (m3.a() != 2) {
                return;
            }
            if (DeviceFragment.Companion.isStartSession()) {
                d.b("setStatus", "DRONE_CONNECTED: 3");
                XEagleApp access$getXEagleApp$p3 = this.this$0.xEagleApp;
                if (access$getXEagleApp$p3 == null || !access$getXEagleApp$p3.c()) {
                    deviceFragment = this.this$0;
                    i2 = 5;
                    deviceFragment.setStatus(1, i2);
                    return;
                }
            } else {
                XEagleApp access$getXEagleApp$p4 = this.this$0.xEagleApp;
                h.a((Object) access$getXEagleApp$p4);
                if (access$getXEagleApp$p4.h() != null) {
                    XEagleApp access$getXEagleApp$p5 = this.this$0.xEagleApp;
                    h.a((Object) access$getXEagleApp$p5);
                    SochipPresenter h2 = access$getXEagleApp$p5.h();
                    HostManagerActivity access$getParent$p = this.this$0.parent;
                    h.a((Object) access$getParent$p);
                    h2.startSession(access$getParent$p.getApplicationContext());
                    return;
                }
                return;
            }
        } else if (DeviceFragment.Companion.isStartSession()) {
            d.b("setStatus", "DRONE_CONNECTED: 4");
            XEagleApp access$getXEagleApp$p6 = this.this$0.xEagleApp;
            if (access$getXEagleApp$p6 == null || !access$getXEagleApp$p6.c()) {
                deviceFragment = this.this$0;
                i2 = 4;
                deviceFragment.setStatus(1, i2);
                return;
            }
        } else {
            XEagleApp access$getXEagleApp$p7 = this.this$0.xEagleApp;
            h.a((Object) access$getXEagleApp$p7);
            if (!access$getXEagleApp$p7.c()) {
                XEagleApp access$getXEagleApp$p8 = this.this$0.xEagleApp;
                h.a((Object) access$getXEagleApp$p8);
                if (access$getXEagleApp$p8.a() != null) {
                    XEagleApp access$getXEagleApp$p9 = this.this$0.xEagleApp;
                    h.a((Object) access$getXEagleApp$p9);
                    e a2 = access$getXEagleApp$p9.a();
                    h.b(a2, "xEagleApp!!.function");
                    if (a2.c()) {
                        deviceFragment2 = this.this$0;
                        i3 = 6;
                    }
                }
                this.this$0.setStatus(0, 8);
                return;
            }
            XEagleApp access$getXEagleApp$p10 = this.this$0.xEagleApp;
            h.a((Object) access$getXEagleApp$p10);
            if (access$getXEagleApp$p10.g() != null) {
                XEagleApp access$getXEagleApp$p11 = this.this$0.xEagleApp;
                h.a((Object) access$getXEagleApp$p11);
                access$getXEagleApp$p11.g().e();
            }
            d.b(DeviceFragment.TAG, "handler.post: 连接中");
            deviceFragment2 = this.this$0;
            i3 = 7;
            deviceFragment2.setStatus(2, i3);
            return;
        }
        this.this$0.timeoutReset(2);
    }
}
