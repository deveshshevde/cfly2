package com.amap.api.mapcore.util;

public final class jj extends ji {

    /* renamed from: j  reason: collision with root package name */
    public int f9461j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f9462k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f9463l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f9464m;

    /* renamed from: n  reason: collision with root package name */
    public int f9465n;

    public jj(boolean z2, boolean z3) {
        super(z2, z3);
    }

    /* renamed from: a */
    public final ji clone() {
        jj jjVar = new jj(this.f9459h, this.f9460i);
        jjVar.a(this);
        this.f9461j = jjVar.f9461j;
        this.f9462k = jjVar.f9462k;
        this.f9463l = jjVar.f9463l;
        this.f9464m = jjVar.f9464m;
        this.f9465n = jjVar.f9465n;
        return jjVar;
    }

    public final String toString() {
        return "AmapCellCdma{sid=" + this.f9461j + ", nid=" + this.f9462k + ", bid=" + this.f9463l + ", latitude=" + this.f9464m + ", longitude=" + this.f9465n + '}' + super.toString();
    }
}
