package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.g;
import fb.d;
import fe.e;

public class CandleStickChart extends BarLineChartBase<g> implements d {
    public CandleStickChart(Context context) {
        super(context);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.O = new e(this, this.R, this.Q);
        getXAxis().a(0.5f);
        getXAxis().b(0.5f);
    }

    public g getCandleData() {
        return (g) this.C;
    }
}
