package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import en.a;
import fg.i;
import org.greenrobot.eventbus.c;

public class f extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14301a;

    /* renamed from: c  reason: collision with root package name */
    private double f14302c;

    public f(a aVar) {
        super(aVar);
    }

    public ef.a a() {
        double d2 = this.f14301a;
        if (d2 == i.f27244a) {
            return null;
        }
        double d3 = this.f14302c;
        if (d3 == i.f27244a) {
            return null;
        }
        return new ef.a(d2, d3);
    }

    public void a(double d2, double d3) {
        this.f14301a = d2;
        this.f14302c = d3;
        c.a().d(new com.flypro.core.drone.f("home"));
    }
}
