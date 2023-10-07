package com.amap.api.maps.model.particle;

public class RectParticleShape extends ParticleShapeModule {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public RectParticleShape(float f2, float f3, float f4, float f5, boolean z2) {
        this.left = f2;
        this.top = f3;
        this.right = f4;
        this.bottom = f5;
        this.isUseRatio = z2;
        this.type = 1;
    }

    public float[] getPoint() {
        return null;
    }
}
