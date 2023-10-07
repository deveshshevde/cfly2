package com.github.mikephil.charting.data;

import fc.i;

public class PieDataSet extends DataSet<PieEntry> implements i {
    private float A;
    private float B;
    private float C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    private float f14984a;

    /* renamed from: t  reason: collision with root package name */
    private boolean f14985t;

    /* renamed from: u  reason: collision with root package name */
    private float f14986u;

    /* renamed from: v  reason: collision with root package name */
    private ValuePosition f14987v;

    /* renamed from: w  reason: collision with root package name */
    private ValuePosition f14988w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f14989x;

    /* renamed from: y  reason: collision with root package name */
    private int f14990y;

    /* renamed from: z  reason: collision with root package name */
    private float f14991z;

    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public boolean A() {
        return this.f14985t;
    }

    public float B() {
        return this.f14986u;
    }

    public ValuePosition C() {
        return this.f14987v;
    }

    public ValuePosition D() {
        return this.f14988w;
    }

    public boolean E() {
        return this.f14989x;
    }

    public int F() {
        return this.f14990y;
    }

    public float G() {
        return this.f14991z;
    }

    public float H() {
        return this.A;
    }

    public float I() {
        return this.B;
    }

    public float J() {
        return this.C;
    }

    public boolean K() {
        return this.D;
    }

    public float a() {
        return this.f14984a;
    }
}
