package com.amap.api.maps;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

public final class CameraUpdate {

    /* renamed from: a  reason: collision with root package name */
    AbstractCameraUpdateMessage f9719a;

    CameraUpdate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        this.f9719a = abstractCameraUpdateMessage;
    }

    public final AbstractCameraUpdateMessage getCameraUpdateFactoryDelegate() {
        return this.f9719a;
    }
}
