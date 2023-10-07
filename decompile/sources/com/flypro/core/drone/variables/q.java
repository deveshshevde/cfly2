package com.flypro.core.drone.variables;

import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import en.a;

public class q extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14368a;

    /* renamed from: c  reason: collision with root package name */
    private double f14369c;

    /* renamed from: d  reason: collision with root package name */
    private double f14370d;

    public q(a aVar) {
        super(aVar);
    }

    public void a(float f2, float f3, short s2) {
        this.f14368a = (double) f2;
        this.f14369c = (double) f3;
        this.f14370d = (double) s2;
        this.f11557b.a(DroneInterfaces.DroneEventsType.NAVIGATION);
    }
}
