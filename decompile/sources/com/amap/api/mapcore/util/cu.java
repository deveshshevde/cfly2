package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;

public final class cu {

    /* renamed from: a  reason: collision with root package name */
    public final double f8208a;

    /* renamed from: b  reason: collision with root package name */
    public final double f8209b;

    /* renamed from: c  reason: collision with root package name */
    public final double f8210c;

    /* renamed from: d  reason: collision with root package name */
    public final double f8211d;

    /* renamed from: e  reason: collision with root package name */
    public final double f8212e;

    /* renamed from: f  reason: collision with root package name */
    public final double f8213f;

    public cu(double d2, double d3, double d4, double d5) {
        this.f8208a = d2;
        this.f8209b = d4;
        this.f8210c = d3;
        this.f8211d = d5;
        this.f8212e = (d2 + d3) / 2.0d;
        this.f8213f = (d4 + d5) / 2.0d;
    }

    private boolean a(double d2, double d3, double d4, double d5) {
        return d2 < this.f8210c && this.f8208a < d3 && d4 < this.f8211d && this.f8209b < d5;
    }

    public final boolean a(double d2, double d3) {
        return this.f8208a <= d2 && d2 <= this.f8210c && this.f8209b <= d3 && d3 <= this.f8211d;
    }

    public final boolean a(cu cuVar) {
        return a(cuVar.f8208a, cuVar.f8210c, cuVar.f8209b, cuVar.f8211d);
    }

    public final boolean a(DPoint dPoint) {
        return a(dPoint.f10009x, dPoint.f10010y);
    }

    public final boolean b(cu cuVar) {
        return cuVar.f8208a >= this.f8208a && cuVar.f8210c <= this.f8210c && cuVar.f8209b >= this.f8209b && cuVar.f8211d <= this.f8211d;
    }
}
