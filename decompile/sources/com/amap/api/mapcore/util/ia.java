package com.amap.api.mapcore.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public abstract class ia {

    /* renamed from: c  reason: collision with root package name */
    ia f9196c;

    public ia() {
    }

    public ia(ia iaVar) {
        this.f9196c = iaVar;
    }

    public int a() {
        ia iaVar = this.f9196c;
        return Math.min(SubsamplingScaleImageView.TILE_SIZE_AUTO, iaVar != null ? iaVar.a() : SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public void a_(int i2) {
        ia iaVar = this.f9196c;
        if (iaVar != null) {
            iaVar.a_(i2);
        }
    }

    public void a_(boolean z2) {
        ia iaVar = this.f9196c;
        if (iaVar != null) {
            iaVar.a_(z2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean c();

    public final boolean d() {
        ia iaVar = this.f9196c;
        if (!(iaVar != null ? iaVar.d() : true)) {
            return false;
        }
        return c();
    }
}
