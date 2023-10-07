package com.amap.api.maps.model.particle;

public abstract class ParticleShapeModule {
    protected final int TYPE_DEFAULT = -1;
    protected final int TYPE_RECT = 1;
    protected final int TYPE_SINGLEPOINT = 0;
    protected boolean isUseRatio = false;
    protected int type = -1;

    public abstract float[] getPoint();

    public boolean isUseRatio() {
        return this.isUseRatio;
    }
}
