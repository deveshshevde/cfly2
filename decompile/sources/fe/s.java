package fe;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.a;
import com.github.mikephil.charting.data.n;
import fg.e;
import fg.g;
import fg.i;
import fg.j;

public class s extends q {

    /* renamed from: n  reason: collision with root package name */
    private RadarChart f27192n;

    public s(j jVar, XAxis xAxis, RadarChart radarChart) {
        super(jVar, xAxis, (g) null);
        this.f27192n = radarChart;
    }

    public void a(Canvas canvas) {
        if (this.f27182g.y() && this.f27182g.h()) {
            float A = this.f27182g.A();
            e a2 = e.a(0.5f, 0.25f);
            this.f27097d.setTypeface(this.f27182g.v());
            this.f27097d.setTextSize(this.f27182g.w());
            this.f27097d.setColor(this.f27182g.x());
            float sliceAngle = this.f27192n.getSliceAngle();
            float factor = this.f27192n.getFactor();
            e centerOffsets = this.f27192n.getCenterOffsets();
            e a3 = e.a(0.0f, 0.0f);
            for (int i2 = 0; i2 < ((fc.j) ((n) this.f27192n.getData()).j()).u(); i2++) {
                float f2 = (float) i2;
                String a4 = this.f27182g.q().a(f2, (a) this.f27182g);
                i.a(centerOffsets, (this.f27192n.getYRange() * factor) + (((float) this.f27182g.E) / 2.0f), ((f2 * sliceAngle) + this.f27192n.getRotationAngle()) % 360.0f, a3);
                a(canvas, a4, a3.f27222a, a3.f27223b - (((float) this.f27182g.F) / 2.0f), a2, A);
            }
            e.b(centerOffsets);
            e.b(a3);
            e.b(a2);
        }
    }

    public void d(Canvas canvas) {
    }
}
