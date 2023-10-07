package com.autonavi.base.ae.gmap.glyph;

public class FontMetrics {
    public boolean bSuccess;
    public float fAscent;
    public float fDescent;
    public float fHeight;
    public float fLeading;

    public FontMetrics() {
        this.bSuccess = false;
        this.fAscent = 0.0f;
        this.fDescent = 0.0f;
        this.fLeading = 0.0f;
        this.fHeight = 0.0f;
    }

    public FontMetrics(float f2, float f3, float f4, float f5) {
        this.bSuccess = false;
        this.fAscent = f2;
        this.fDescent = f3;
        this.fLeading = f4;
        this.fHeight = f5;
    }
}
