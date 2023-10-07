package com.github.mikephil.charting.data;

import android.util.Log;

public class PieEntry extends Entry {

    /* renamed from: a  reason: collision with root package name */
    private String f14995a;

    public String a() {
        return this.f14995a;
    }

    @Deprecated
    public float i() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.i();
    }
}
