package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.j;
import fb.g;

public class LineChart extends BarLineChartBase<j> implements g {
    public LineChart(Context context) {
        super(context);
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.O = new fe.j(this, this.R, this.Q);
    }

    public j getLineData() {
        return (j) this.C;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (this.O != null && (this.O instanceof fe.j)) {
            ((fe.j) this.O).b();
        }
        super.onDetachedFromWindow();
    }
}
