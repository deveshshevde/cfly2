package com.huawei.android.multiscreen.dlna.sdk.networkmanager.wifinetwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f20910a;

    /* renamed from: b  reason: collision with root package name */
    private List<b> f20911b = new ArrayList();

    public static a a() {
        if (f20910a == null) {
            f20910a = new a();
        }
        return f20910a;
    }

    public void b() {
        synchronized (this.f20911b) {
            Iterator<b> it2 = this.f20911b.iterator();
            while (it2.hasNext()) {
                b next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.a();
                }
            }
        }
    }

    public void c() {
        synchronized (this.f20911b) {
            Iterator<b> it2 = this.f20911b.iterator();
            while (it2.hasNext()) {
                b next = it2.next();
                if (next == null) {
                    it2.remove();
                } else {
                    next.b();
                }
            }
        }
    }
}
