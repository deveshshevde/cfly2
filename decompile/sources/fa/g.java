package fa;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.m;
import fc.i;

public class g extends h<PieChart> {
    public g(PieChart pieChart) {
        super(pieChart);
    }

    /* access modifiers changed from: protected */
    public d a(int i2, float f2, float f3) {
        i a2 = ((m) ((PieChart) this.f27088a).getData()).a();
        return new d((float) i2, a2.d(i2).b(), f2, f3, 0, a2.t());
    }
}
