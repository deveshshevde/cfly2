package com.amap.api.maps.model.particle;

public abstract class SizeOverLife {
    public final int DEFAULT_SIZE = 0;
    protected final int TYPE_CURVESIZEOVERLIFE = 0;
    protected final int TYPE_DEFAULT = -1;
    protected int type = -1;

    public abstract float getSizeX(float f2);

    public abstract float getSizeY(float f2);

    public abstract float getSizeZ(float f2);
}
