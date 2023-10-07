package com.github.mikephil.charting.components;

import fg.i;

public class XAxis extends a {
    public int C = 1;
    public int D = 1;
    public int E = 1;
    public int F = 1;
    protected float G = 0.0f;
    private boolean H = false;
    private XAxisPosition I = XAxisPosition.TOP;

    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.f14947y = i.a(4.0f);
    }

    public float A() {
        return this.G;
    }

    public boolean B() {
        return this.H;
    }

    public XAxisPosition z() {
        return this.I;
    }
}
