package com.amap.api.mapcore.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public final class jm extends ji {

    /* renamed from: j  reason: collision with root package name */
    public int f9477j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f9478k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f9479l = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: m  reason: collision with root package name */
    public int f9480m = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    public jm(boolean z2, boolean z3) {
        super(z2, z3);
    }

    /* renamed from: a */
    public final ji clone() {
        jm jmVar = new jm(this.f9459h, this.f9460i);
        jmVar.a(this);
        jmVar.f9477j = this.f9477j;
        jmVar.f9478k = this.f9478k;
        jmVar.f9479l = this.f9479l;
        jmVar.f9480m = this.f9480m;
        return jmVar;
    }

    public final String toString() {
        return "AmapCellWcdma{lac=" + this.f9477j + ", cid=" + this.f9478k + ", psc=" + this.f9479l + ", uarfcn=" + this.f9480m + '}' + super.toString();
    }
}
