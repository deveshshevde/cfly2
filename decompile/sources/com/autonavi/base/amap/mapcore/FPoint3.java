package com.autonavi.base.amap.mapcore;

public class FPoint3 extends FPoint {
    public int colorIndex = -1;

    public FPoint3() {
    }

    public FPoint3(float f2, float f3, int i2) {
        super(f2, f3);
        this.colorIndex = i2;
    }

    public void setColorIndex(int i2) {
        this.colorIndex = i2;
    }
}
