package com.amap.api.maps.model.particle;

public abstract class RotationOverLife {
    protected final int TYPE_CONSTANTROTATIONOVERLIFE = 0;
    protected final int TYPE_DEFAULT = -1;
    protected int type = -1;

    public abstract float getRotate();
}
