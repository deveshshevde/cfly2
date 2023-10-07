package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import fc.g;

public abstract class k<T extends Entry> extends l<T> implements g<T> {
    private float A;
    private boolean B;

    /* renamed from: t  reason: collision with root package name */
    protected Drawable f15033t;

    /* renamed from: y  reason: collision with root package name */
    private int f15034y;

    /* renamed from: z  reason: collision with root package name */
    private int f15035z;

    public int L() {
        return this.f15034y;
    }

    public Drawable M() {
        return this.f15033t;
    }

    public int N() {
        return this.f15035z;
    }

    public float O() {
        return this.A;
    }

    public boolean P() {
        return this.B;
    }
}
