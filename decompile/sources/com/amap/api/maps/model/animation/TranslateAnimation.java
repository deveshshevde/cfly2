package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;

public class TranslateAnimation extends Animation {

    /* renamed from: x  reason: collision with root package name */
    private double f9769x;

    /* renamed from: y  reason: collision with root package name */
    private double f9770y;

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.f9769x = latLng.latitude;
        this.f9770y = latLng.longitude;
    }

    /* access modifiers changed from: protected */
    public String getAnimationType() {
        return "TranslateAnimation";
    }
}
