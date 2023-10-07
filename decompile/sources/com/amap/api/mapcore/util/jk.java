package com.amap.api.mapcore.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public final class jk extends ji {

    /* renamed from: j  reason: collision with root package name */
    public int f9466j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f9467k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f9468l = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: m  reason: collision with root package name */
    public int f9469m = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: n  reason: collision with root package name */
    public int f9470n = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: o  reason: collision with root package name */
    public int f9471o = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    public jk(boolean z2, boolean z3) {
        super(z2, z3);
    }

    /* renamed from: a */
    public final ji clone() {
        jk jkVar = new jk(this.f9459h, this.f9460i);
        jkVar.a(this);
        jkVar.f9466j = this.f9466j;
        jkVar.f9467k = this.f9467k;
        jkVar.f9468l = this.f9468l;
        jkVar.f9469m = this.f9469m;
        jkVar.f9470n = this.f9470n;
        jkVar.f9471o = this.f9471o;
        return jkVar;
    }

    public final String toString() {
        return "AmapCellGsm{lac=" + this.f9466j + ", cid=" + this.f9467k + ", psc=" + this.f9468l + ", arfcn=" + this.f9469m + ", bsic=" + this.f9470n + ", timingAdvance=" + this.f9471o + '}' + super.toString();
    }
}
