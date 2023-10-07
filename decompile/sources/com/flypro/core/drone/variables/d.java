package com.flypro.core.drone.variables;

import com.MAVLink.ardupilotmega.msg_mount_status;
import eo.a;
import eo.b;
import java.util.ArrayList;
import java.util.List;

public class d extends com.flypro.core.drone.d {

    /* renamed from: a  reason: collision with root package name */
    private a f14297a = new a();

    /* renamed from: c  reason: collision with root package name */
    private List<b> f14298c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private double f14299d;

    public d(en.a aVar) {
        super(aVar);
    }

    public b a() {
        List<b> list = this.f14298c;
        return list.get(list.size() - 1);
    }

    public void a(msg_mount_status msg_mount_status) {
        this.f14299d = (double) (90 - (msg_mount_status.f6437d / 100));
    }

    public b b() {
        double a2 = this.f11557b.t().a();
        return new b(this.f14297a, this.f11557b.b().b(), a2, this.f11557b.u().b(), this.f11557b.u().a(), this.f11557b.u().c());
    }
}
