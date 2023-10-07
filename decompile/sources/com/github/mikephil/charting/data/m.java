package com.github.mikephil.charting.data;

import fa.d;
import fc.i;

public class m extends h<i> {
    public Entry a(d dVar) {
        return a().d((int) dVar.a());
    }

    public i a() {
        return (i) this.f15027i.get(0);
    }

    /* renamed from: b */
    public i a(int i2) {
        if (i2 == 0) {
            return a();
        }
        return null;
    }

    public float k() {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < a().u(); i2++) {
            f2 += ((PieEntry) a().d(i2)).b();
        }
        return f2;
    }
}
