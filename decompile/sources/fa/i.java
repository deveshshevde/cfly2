package fa;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.n;
import fg.e;
import java.util.List;

public class i extends h<RadarChart> {
    public i(RadarChart radarChart) {
        super(radarChart);
    }

    /* access modifiers changed from: protected */
    public d a(int i2, float f2, float f3) {
        List<d> a2 = a(i2);
        float d2 = ((RadarChart) this.f27088a).d(f2, f3) / ((RadarChart) this.f27088a).getFactor();
        d dVar = null;
        float f4 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < a2.size(); i3++) {
            d dVar2 = a2.get(i3);
            float abs = Math.abs(dVar2.b() - d2);
            if (abs < f4) {
                dVar = dVar2;
                f4 = abs;
            }
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public List<d> a(int i2) {
        int i3 = i2;
        this.f27089b.clear();
        float b2 = ((RadarChart) this.f27088a).getAnimator().b();
        float a2 = ((RadarChart) this.f27088a).getAnimator().a();
        float sliceAngle = ((RadarChart) this.f27088a).getSliceAngle();
        float factor = ((RadarChart) this.f27088a).getFactor();
        e a3 = e.a(0.0f, 0.0f);
        int i4 = 0;
        while (i4 < ((n) ((RadarChart) this.f27088a).getData()).c()) {
            fc.e a4 = ((n) ((RadarChart) this.f27088a).getData()).a(i4);
            Entry d2 = a4.d(i3);
            float f2 = (float) i3;
            fg.i.a(((RadarChart) this.f27088a).getCenterOffsets(), (d2.b() - ((RadarChart) this.f27088a).getYChartMin()) * factor * a2, (sliceAngle * f2 * b2) + ((RadarChart) this.f27088a).getRotationAngle(), a3);
            List list = this.f27089b;
            d dVar = r8;
            d dVar2 = new d(f2, d2.b(), a3.f27222a, a3.f27223b, i4, a4.t());
            list.add(dVar);
            i4++;
            i3 = i2;
        }
        return this.f27089b;
    }
}
