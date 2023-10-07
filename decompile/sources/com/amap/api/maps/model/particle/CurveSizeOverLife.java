package com.amap.api.maps.model.particle;

public class CurveSizeOverLife extends SizeOverLife {

    /* renamed from: x  reason: collision with root package name */
    private float f9771x;

    /* renamed from: y  reason: collision with root package name */
    private float f9772y;

    /* renamed from: z  reason: collision with root package name */
    private float f9773z;

    public CurveSizeOverLife(float f2, float f3, float f4) {
        this.f9771x = f2;
        this.f9772y = f3;
        this.f9773z = f4;
        this.type = 0;
    }

    public float getSizeX(float f2) {
        return 0.0f;
    }

    public float getSizeY(float f2) {
        return 0.0f;
    }

    public float getSizeZ(float f2) {
        return 0.0f;
    }
}
