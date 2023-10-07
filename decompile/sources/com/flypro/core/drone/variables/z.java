package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.bb;
import en.a;
import org.greenrobot.eventbus.c;

public class z extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14403a = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private double f14404c = -1.0d;

    public z(a aVar) {
        super(aVar);
    }

    public double a() {
        return this.f14403a;
    }

    public void a(double d2, double d3) {
        if (this.f14403a != d2 || this.f14404c != d3) {
            this.f14403a = d2;
            this.f14404c = d3;
            com.flypro.core.util.a.a().k();
            c.a().d(new bb(57));
        }
    }

    public double b() {
        return this.f14404c;
    }
}
