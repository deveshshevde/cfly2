package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;
import fg.i;

public class GLTranslateAnimation extends GLAnimation {
    public double mCurXDelta = i.f27244a;
    public double mCurYDelta = i.f27244a;
    public double mFromXDelta = i.f27244a;
    public double mFromYDelta = i.f27244a;
    public double mToXDelta = i.f27244a;
    public double mToYDelta = i.f27244a;

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        double d2 = this.mFromXDelta;
        this.mCurXDelta = d2;
        double d3 = this.mFromYDelta;
        this.mCurYDelta = d3;
        double d4 = this.mToXDelta;
        if (d2 != d4) {
            double d5 = (double) f2;
            Double.isNaN(d5);
            this.mCurXDelta = d2 + ((d4 - d2) * d5);
        }
        double d6 = this.mToYDelta;
        if (d3 != d6) {
            double d7 = (double) f2;
            Double.isNaN(d7);
            this.mCurYDelta = d3 + ((d6 - d3) * d7);
        }
        gLTransformation.f10011x = this.mCurXDelta;
        gLTransformation.f10012y = this.mCurYDelta;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }
}
