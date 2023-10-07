package com.hoho.android.usb.usb.data_proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import ha.e;
import kotlin.jvm.internal.h;
import kotlin.text.f;
import org.greenrobot.eventbus.c;

public final class UsbDataProxy$mReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f20255a;

    UsbDataProxy$mReceiver$1(d dVar) {
        this.f20255a = dVar;
    }

    public void onReceive(Context context, Intent intent) {
        e eVar;
        c cVar;
        e eVar2;
        c cVar2;
        h.d(context, "context");
        h.d(intent, "intent");
        String action = intent.getAction();
        Log.i("UsbDataProxytest", "onReceive: =====usb==" + action);
        if (f.a("android.hardware.usb.action.USB_STATE", action, true)) {
            d dVar = this.f20255a;
            Bundle extras = intent.getExtras();
            h.a((Object) extras);
            dVar.f11915p = extras.getBoolean("connected");
            Log.i("UsbDataProxytest", "onReceive: =====usb connected state====  " + this.f20255a.e());
            if (this.f20255a.e()) {
                Log.i("UsbDataProxy", "onReceive: 插入USB");
                cVar2 = c.a();
                eVar2 = new e(1, false);
            } else {
                Log.i("UsbDataProxy", "onReceive: 拔掉USB");
                cVar2 = c.a();
                eVar2 = new e(2, false);
            }
            cVar2.d(eVar2);
        }
        if (h.a((Object) "com.cfly.uav_pro.usb.permission", (Object) action)) {
            boolean booleanExtra = intent.getBooleanExtra("permission", false);
            Log.i("UsbDataProxy", "onReceive: ====usb permission===" + booleanExtra);
            if (booleanExtra) {
                cVar = c.a();
                eVar = new e(6, false);
            } else {
                cVar = c.a();
                eVar = new e(5, false);
            }
            cVar.d(eVar);
        }
    }
}
