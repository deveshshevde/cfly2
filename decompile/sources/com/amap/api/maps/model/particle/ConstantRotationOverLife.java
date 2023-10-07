package com.amap.api.maps.model.particle;

public class ConstantRotationOverLife extends RotationOverLife {
    private float rotate = 0.0f;

    public ConstantRotationOverLife(float f2) {
        this.rotate = f2;
        this.type = 0;
    }

    public float getRotate() {
        return this.rotate;
    }
}
