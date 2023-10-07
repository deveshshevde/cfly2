package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.t;
import en.a;
import fg.i;
import java.util.Locale;
import org.greenrobot.eventbus.c;

public class r extends d {

    /* renamed from: a  reason: collision with root package name */
    private double f14371a = i.f27244a;

    /* renamed from: c  reason: collision with root package name */
    private double f14372c = i.f27244a;

    /* renamed from: d  reason: collision with root package name */
    private double f14373d = i.f27244a;

    public r(a aVar) {
        super(aVar);
    }

    public double a() {
        return this.f14371a;
    }

    public void a(double d2, double d3, double d4) {
        this.f14371a = d2;
        this.f14372c = d3;
        this.f14373d = d4;
        this.f11557b.Q().b(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Double.valueOf(d3)})));
        this.f11557b.Q().c(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Double.valueOf(d2)})));
        this.f11557b.Q().d(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Double.valueOf(d4)})));
        c.a().d(new t(15));
    }

    public double b() {
        return this.f14372c;
    }

    public double c() {
        return this.f14373d;
    }
}
