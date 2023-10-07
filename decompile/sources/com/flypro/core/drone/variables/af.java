package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.bf;
import en.a;
import org.greenrobot.eventbus.c;

public class af extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14288a = -1.0d;

    public af(a aVar) {
        super(aVar);
    }

    public double a() {
        return this.f14288a;
    }

    public void a(double d2) {
        this.f14288a = d2;
        c.a().d(new bf(58));
    }
}
