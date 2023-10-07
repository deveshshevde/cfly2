package com.amap.api.maps.model.particle;

public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f2, float f3, float f4) {
        this(f2, f3, f4, false);
    }

    public SinglePointParticleShape(float f2, float f3, float f4, boolean z2) {
        float[] fArr = new float[3];
        this.point_3 = fArr;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        this.isUseRatio = z2;
        this.type = 0;
    }

    public float[] getPoint() {
        return this.point_3;
    }
}
