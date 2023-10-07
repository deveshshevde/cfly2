package com.huawei.android.multiscreen.dlna.sdk.dmc;

import com.huawei.android.multiscreen.dlna.sdk.dmc.db.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private int f20800a = 30;

    /* renamed from: b  reason: collision with root package name */
    private List<a> f20801b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<Object> f20802c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<Object> f20803d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private f f20804e = new c();

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, g> f20805f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private Map<Integer, i> f20806g = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    private Map<Integer, h> f20807h = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    private Map<Integer, j> f20808i = new ConcurrentHashMap();

    /* renamed from: j  reason: collision with root package name */
    private d f20809j = new d();

    /* renamed from: k  reason: collision with root package name */
    private List<Object> f20810k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private List<Object> f20811l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private List<Object> f20812m = new ArrayList();

    public b() {
        this.f20801b.add(this.f20809j);
    }

    public void a() {
        for (Map.Entry next : this.f20805f.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            a(intValue);
            a.a().a(intValue);
            ((b) com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b.a().e()).a(1, (g) next.getValue());
        }
        this.f20809j.a();
    }

    public void a(int i2) {
        StringBuilder sb;
        ie.a.a("DmcManager", "DLNAService.removeDevice start");
        if (this.f20805f.containsKey(Integer.valueOf(i2))) {
            g gVar = this.f20805f.get(Integer.valueOf(i2));
            if (gVar instanceof i) {
                this.f20806g.remove(Integer.valueOf(i2));
                sb = new StringBuilder("DLNAService.removeDevice DMS Device removed: deviceId=");
            } else if (gVar instanceof h) {
                this.f20807h.remove(Integer.valueOf(i2));
                sb = new StringBuilder("DLNAService.removeDevice DMR Device removed: deviceId=");
            } else {
                if (gVar instanceof j) {
                    this.f20808i.remove(Integer.valueOf(i2));
                }
                this.f20805f.remove(Integer.valueOf(i2));
                this.f20809j.a(i2);
            }
            sb.append(i2);
            sb.append(" DeviceName=");
            sb.append(gVar.a());
            ie.a.a("DmcManager", sb.toString());
            this.f20805f.remove(Integer.valueOf(i2));
            this.f20809j.a(i2);
        }
        ie.a.a("DmcManager", "DLNAService.removeDevice end");
    }

    public void a(int i2, g gVar) {
        if (gVar != null) {
            synchronized (this.f20801b) {
                Iterator<a> it2 = this.f20801b.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next != null) {
                        a aVar = next;
                        if (i2 == 0) {
                            try {
                                aVar.a(gVar);
                            } catch (Throwable unused) {
                                ie.a.d("DmcManager", "notifyDeviceChanged happened Exception");
                            }
                        } else {
                            aVar.b(gVar);
                        }
                    }
                    it2.remove();
                }
            }
        }
    }
}
