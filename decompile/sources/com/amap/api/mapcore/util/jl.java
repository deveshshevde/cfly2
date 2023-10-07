package com.amap.api.mapcore.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public final class jl extends ji {

    /* renamed from: j  reason: collision with root package name */
    public int f9472j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f9473k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f9474l = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: m  reason: collision with root package name */
    public int f9475m = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: n  reason: collision with root package name */
    public int f9476n = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    public jl(boolean z2) {
        super(z2, true);
    }

    /* renamed from: a */
    public final ji clone() {
        jl jlVar = new jl(this.f9459h);
        jlVar.a(this);
        jlVar.f9472j = this.f9472j;
        jlVar.f9473k = this.f9473k;
        jlVar.f9474l = this.f9474l;
        jlVar.f9475m = this.f9475m;
        jlVar.f9476n = this.f9476n;
        return jlVar;
    }

    public final String toString() {
        return "AmapCellLte{lac=" + this.f9472j + ", cid=" + this.f9473k + ", pci=" + this.f9474l + ", earfcn=" + this.f9475m + ", timingAdvance=" + this.f9476n + '}' + super.toString();
    }
}
