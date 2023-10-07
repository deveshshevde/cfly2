package com.flypro.core.drone.variables;

import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import fg.i;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14268a = -1.0d;

    /* renamed from: c  reason: collision with root package name */
    private double f14269c = i.f27244a;

    /* renamed from: d  reason: collision with root package name */
    private double f14270d = i.f27244a;

    /* renamed from: e  reason: collision with root package name */
    private double f14271e = i.f27244a;

    public a(en.a aVar) {
        super(aVar);
    }

    public double a() {
        return this.f14268a;
    }

    public void a(double d2) {
        this.f14271e = d2;
    }

    public double b() {
        return this.f14271e;
    }

    public void b(double d2) {
        this.f14268a = d2;
        if (d2 > 121.92d && this.f14270d <= 121.92d) {
            this.f11557b.a(DroneInterfaces.DroneEventsType.WARNING_400FT_EXCEEDED);
        }
        this.f14270d = d2;
    }

    public double c() {
        return this.f14269c;
    }

    public void c(double d2) {
        this.f14269c = d2 + this.f14268a;
    }
}
