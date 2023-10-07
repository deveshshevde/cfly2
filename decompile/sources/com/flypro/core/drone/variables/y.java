package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import com.flypro.core.parameters.Parameter;
import en.a;
import fg.i;

public class y extends d {

    /* renamed from: a  reason: collision with root package name */
    private ej.d f14399a = new ej.d(i.f27244a);

    /* renamed from: c  reason: collision with root package name */
    private ej.d f14400c = new ej.d(i.f27244a);

    /* renamed from: d  reason: collision with root package name */
    private ej.d f14401d = new ej.d(i.f27244a);

    /* renamed from: e  reason: collision with root package name */
    private ej.d f14402e = new ej.d(i.f27244a);

    public y(a aVar) {
        super(aVar);
    }

    public ej.d a() {
        return this.f14399a;
    }

    public void a(double d2) {
        this.f14402e = new ej.d(d2 + this.f14401d.a());
    }

    public ej.d b() {
        return this.f14400c;
    }

    public ej.d c() {
        return this.f14401d;
    }

    public ej.d d() {
        Parameter b2 = this.f11557b.e().b("WPNAV_SPEED");
        if (b2 == null) {
            return null;
        }
        return new ej.d(b2.f14456b / 100.0d);
    }
}
