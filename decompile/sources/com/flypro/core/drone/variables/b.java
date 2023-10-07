package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import com.flypro.core.parameters.Parameter;
import dy.i;
import en.a;
import org.greenrobot.eventbus.c;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14289a = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private double f14290c = -1.0d;

    /* renamed from: d  reason: collision with root package name */
    private double f14291d = -1.0d;

    /* renamed from: e  reason: collision with root package name */
    private double f14292e = -1.0d;

    /* renamed from: f  reason: collision with root package name */
    private double f14293f = -1.0d;

    public b(a aVar) {
        super(aVar);
    }

    public double a() {
        return this.f14289a;
    }

    public void a(double d2) {
        this.f14289a = d2;
        this.f11557b.Q().b((int) d2);
        c.a().d(new i(10));
    }

    public double b() {
        return this.f14290c;
    }

    public double c() {
        return this.f14291d;
    }

    public Double d() {
        Parameter b2 = this.f11557b.e().b("BATT_CAPACITY");
        if (b2 == null) {
            return null;
        }
        double d2 = this.f14290c;
        if (d2 == -1.0d) {
            return null;
        }
        return Double.valueOf((1.0d - (d2 / 100.0d)) * b2.f14456b);
    }
}
