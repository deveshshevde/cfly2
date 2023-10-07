package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.aj;
import en.a;
import org.greenrobot.eventbus.c;

public class k extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14353a = -1.0d;

    public k(a aVar) {
        super(aVar);
    }

    public double a() {
        return this.f14353a;
    }

    public void a(double d2) {
        if (this.f14353a != d2) {
            this.f14353a = d2;
            this.f11557b.Q().a(d2);
            c.a().d(new aj(56));
        }
    }
}
