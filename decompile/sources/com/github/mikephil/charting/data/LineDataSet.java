package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import ez.c;
import fc.f;
import java.util.List;

public class LineDataSet extends k<Entry> implements f {
    private int A;
    private float B;
    private float C;
    private float D;
    private DashPathEffect E;
    private c F;
    private boolean G;
    private boolean H;

    /* renamed from: y  reason: collision with root package name */
    private Mode f14977y;

    /* renamed from: z  reason: collision with root package name */
    private List<Integer> f14978z;

    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public Mode A() {
        return this.f14977y;
    }

    public float B() {
        return this.D;
    }

    public float C() {
        return this.B;
    }

    public float D() {
        return this.C;
    }

    public boolean E() {
        return this.E != null;
    }

    public DashPathEffect F() {
        return this.E;
    }

    public boolean G() {
        return this.G;
    }

    public int H() {
        return this.f14978z.size();
    }

    public int I() {
        return this.A;
    }

    public boolean J() {
        return this.H;
    }

    public c K() {
        return this.F;
    }

    public int e(int i2) {
        return this.f14978z.get(i2).intValue();
    }
}
