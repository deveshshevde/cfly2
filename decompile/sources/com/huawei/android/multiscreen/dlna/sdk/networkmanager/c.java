package com.huawei.android.multiscreen.dlna.sdk.networkmanager;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaInitMode;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.EDlnaProductType;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.e;
import com.huawei.android.multiscreen.dlna.sdk.networkmanager.wifinetwork.a;

public class c {

    /* renamed from: f  reason: collision with root package name */
    private static c f20896f;

    /* renamed from: a  reason: collision with root package name */
    private String f20897a;

    /* renamed from: b  reason: collision with root package name */
    private int f20898b = this.f20901e.getInt("LastNetworkType", -1);

    /* renamed from: c  reason: collision with root package name */
    private String f20899c = this.f20901e.getString("LastNetworkIP", "");

    /* renamed from: d  reason: collision with root package name */
    private String f20900d = this.f20901e.getString("LastNetworkMAC", "");

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f20901e;

    /* renamed from: g  reason: collision with root package name */
    private a f20902g = new a(this.f20897a, ENetworkType.a(this.f20898b), this.f20899c, this.f20900d);

    private c() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(b.a().d());
        this.f20901e = defaultSharedPreferences;
        this.f20897a = defaultSharedPreferences.getString("LastNetworkName", "xxx");
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f20896f == null) {
                f20896f = new c();
            }
            cVar = f20896f;
        }
        return cVar;
    }

    private boolean a(a aVar, a aVar2) {
        if (aVar2 == null || ENetworkType.NO_NETWORK == aVar2.b()) {
            return true;
        }
        Log.d("DMC", "newNetwork.getNetworkName():" + aVar.a() + "oldNetwork.getNetworkName():" + aVar2.a());
        return !aVar.a().equals(aVar2.a()) || aVar.b() != aVar2.b() || !aVar.c().equals(aVar2.c()) || !aVar.d().equals(aVar2.d());
    }

    private boolean d() {
        EDlnaInitMode i2 = b.a().i();
        return i2 == EDlnaInitMode.DMS || i2 == EDlnaInitMode.DMS_DMC || i2 == EDlnaInitMode.DMS_DMP || i2 == EDlnaInitMode.DMS_DMR || i2 == EDlnaInitMode.DMS_DMR_DMC || i2 == EDlnaInitMode.DMS_DMR_DMP;
    }

    public void a(a aVar) {
        b j2;
        boolean a2;
        e a3 = b.a();
        if (a3.i() != null) {
            if (aVar == null) {
                a3.c();
                c();
            } else if (aVar.b() == ENetworkType.NO_NETWORK) {
                ((b) a3).b();
                b(aVar);
            } else if (a(aVar, this.f20902g)) {
                ((b) a3).b();
                b(aVar);
                EDlnaInitMode i2 = a3.i();
                if (i2.toString().contains("DMS")) {
                    com.huawei.android.multiscreen.dlna.sdk.dms.b g2 = a3.g();
                    g2.a(g2.a());
                    EDlnaProductType b2 = g2.b();
                    if (b2 != null) {
                        g2.a(b2);
                    }
                }
                if (i2.toString().contains("DMR")) {
                    ic.c f2 = a3.f();
                    f2.a(f2.a());
                    EDlnaProductType b3 = f2.b();
                    if (b3 != null) {
                        f2.a(b3);
                    }
                }
                a3.a(i2);
                a.a().c();
                if (d() && (j2 = a3.j()) != null && (a2 = j2.a(aVar, this.f20902g))) {
                    a3.g().a(a2);
                    return;
                }
                return;
            } else {
                return;
            }
            a.a().b();
        } else if (a(aVar, this.f20902g)) {
            b(aVar);
        }
    }

    public a b() {
        return this.f20902g;
    }

    public void b(a aVar) {
        SharedPreferences.Editor edit = this.f20901e.edit();
        if (aVar != null) {
            edit.putString("LastNetworkName", aVar.a());
            edit.putInt("LastNetworkType", aVar.b().a());
            edit.putString("LastNetworkIP", aVar.c());
            edit.putString("LastNetworkMAC", aVar.d());
        } else {
            edit.putString("LastNetworkName", "");
            edit.putInt("LastNetworkType", -1);
            edit.putString("LastNetworkIP", "");
            edit.putString("LastNetworkMAC", "");
        }
        try {
            edit.commit();
            this.f20902g = aVar;
        } catch (Exception unused) {
            ie.a.d("NetworkStateReceiverManager", "setNetworkInfo happened Exception");
        }
    }

    public void c() {
        SharedPreferences.Editor edit = this.f20901e.edit();
        edit.putString("LastNetworkName", "");
        edit.putInt("LastNetworkType", -1);
        edit.putString("LastNetworkIP", "");
        edit.putString("LastNetworkMAC", "");
        try {
            edit.commit();
            this.f20902g = null;
        } catch (Exception unused) {
            ie.a.d("NetworkStateReceiverManager", "setNetworkInfo happened Exception");
        }
    }
}
