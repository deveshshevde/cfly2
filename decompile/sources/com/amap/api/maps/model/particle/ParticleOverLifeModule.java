package com.amap.api.maps.model.particle;

public class ParticleOverLifeModule {
    private static final int TYPE_COLOR = 3;
    private static final int TYPE_ROTATE = 1;
    private static final int TYPE_SCALE = 2;
    private static final int TYPE_VEL = 0;
    private ColorGenerate colorGenerate;
    private Object colorGenerateObject;
    private boolean isNeedReloadColorGenerate = false;
    private boolean isNeedReloadRotationOverLife = false;
    private boolean isNeedReloadSizeOverLife = false;
    private boolean isNeedReloadVelocityGenerate = false;
    private VelocityGenerate overLife = null;
    private RotationOverLife rotateOverLife;
    private Object rotateOverLifeObject;
    private SizeOverLife sizeOverLife;
    private Object sizeOverLifeObject;
    private VelocityGenerate velocityOverLife = null;
    private Object velocityOverLifeObject;

    public void setColorGenerate(ColorGenerate colorGenerate2) {
        this.colorGenerate = colorGenerate2;
        this.colorGenerateObject = colorGenerate2;
        this.isNeedReloadColorGenerate = true;
    }

    public void setRotateOverLife(RotationOverLife rotationOverLife) {
        this.rotateOverLife = rotationOverLife;
        this.rotateOverLifeObject = rotationOverLife;
        this.isNeedReloadRotationOverLife = true;
    }

    public void setSizeOverLife(SizeOverLife sizeOverLife2) {
        this.sizeOverLife = sizeOverLife2;
        this.sizeOverLifeObject = sizeOverLife2;
        this.isNeedReloadSizeOverLife = true;
    }

    public void setVelocityOverLife(VelocityGenerate velocityGenerate) {
        this.overLife = velocityGenerate;
        this.velocityOverLife = velocityGenerate;
        this.velocityOverLifeObject = velocityGenerate;
        this.isNeedReloadVelocityGenerate = true;
    }
}
