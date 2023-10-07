package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.f;
import fb.c;
import fe.d;

public class BubbleChart extends BarLineChartBase<f> implements c {
    public BubbleChart(Context context) {
        super(context);
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.O = new d(this, this.R, this.Q);
    }

    public f getBubbleData() {
        return (f) this.C;
    }
}
