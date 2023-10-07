package com.flypro.core.drone.variables;

import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import en.a;
import fg.i;

public class p extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14366a = i.f27244a;

    /* renamed from: c  reason: collision with root package name */
    private short f14367c = -1;

    public p(a aVar) {
        super(aVar);
    }

    public int a() {
        return this.f14367c;
    }

    public void a(double d2) {
        this.f14366a = d2;
    }

    public void a(short s2) {
        if (s2 != this.f14367c) {
            this.f14367c = s2;
            this.f11557b.a(DroneInterfaces.DroneEventsType.MISSION_WP_UPDATE);
        }
    }
}
