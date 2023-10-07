package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.o;
import fb.h;
import fe.p;

public class ScatterChart extends BarLineChartBase<o> implements h {
    public ScatterChart(Context context) {
        super(context);
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.O = new p(this, this.R, this.Q);
        getXAxis().a(0.5f);
        getXAxis().b(0.5f);
    }

    public o getScatterData() {
        return (o) this.C;
    }
}
