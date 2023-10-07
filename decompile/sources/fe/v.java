package fe;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.n;
import fg.e;
import fg.g;
import fg.i;
import fg.j;
import java.util.List;

public class v extends t {

    /* renamed from: r  reason: collision with root package name */
    private RadarChart f27206r;

    /* renamed from: s  reason: collision with root package name */
    private Path f27207s = new Path();

    public v(j jVar, YAxis yAxis, RadarChart radarChart) {
        super(jVar, yAxis, (g) null);
        this.f27206r = radarChart;
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        double d2;
        double d3;
        boolean z2;
        float f4 = f2;
        float f5 = f3;
        int j2 = this.f27094a.j();
        double abs = (double) Math.abs(f5 - f4);
        if (j2 == 0 || abs <= i.f27244a || Double.isInfinite(abs)) {
            this.f27094a.f14924b = new float[0];
            this.f27094a.f14925c = new float[0];
            this.f27094a.f14926d = 0;
            return;
        }
        double d4 = (double) j2;
        Double.isNaN(abs);
        Double.isNaN(d4);
        double a2 = (double) i.a(abs / d4);
        if (this.f27094a.k() && a2 < ((double) this.f27094a.l())) {
            a2 = (double) this.f27094a.l();
        }
        double a3 = (double) i.a(Math.pow(10.0d, (double) ((int) Math.log10(a2))));
        Double.isNaN(a3);
        if (((int) (a2 / a3)) > 5) {
            Double.isNaN(a3);
            a2 = Math.floor(a3 * 10.0d);
        }
        boolean c2 = this.f27094a.c();
        if (this.f27094a.i()) {
            float f6 = ((float) abs) / ((float) (j2 - 1));
            this.f27094a.f14926d = j2;
            if (this.f27094a.f14924b.length < j2) {
                this.f27094a.f14924b = new float[j2];
            }
            for (int i2 = 0; i2 < j2; i2++) {
                this.f27094a.f14924b[i2] = f4;
                f4 += f6;
            }
        } else {
            if (a2 == i.f27244a) {
                d2 = i.f27244a;
            } else {
                double d5 = (double) f4;
                Double.isNaN(d5);
                d2 = Math.ceil(d5 / a2) * a2;
            }
            if (c2) {
                d2 -= a2;
            }
            if (a2 == i.f27244a) {
                d3 = 0.0d;
            } else {
                double d6 = (double) f5;
                Double.isNaN(d6);
                d3 = i.b(Math.floor(d6 / a2) * a2);
            }
            if (a2 != i.f27244a) {
                z2 = c2;
                for (double d7 = d2; d7 <= d3; d7 += a2) {
                    z2++;
                }
            } else {
                z2 = c2;
            }
            int i3 = ((int) z2) + 1;
            this.f27094a.f14926d = i3;
            if (this.f27094a.f14924b.length < i3) {
                this.f27094a.f14924b = new float[i3];
            }
            for (int i4 = 0; i4 < i3; i4++) {
                if (d2 == i.f27244a) {
                    d2 = 0.0d;
                }
                this.f27094a.f14924b[i4] = (float) d2;
                d2 += a2;
            }
            j2 = i3;
        }
        this.f27094a.f14927e = (a2 > 1.0d ? 1 : (a2 == 1.0d ? 0 : -1)) < 0 ? (int) Math.ceil(-Math.log10(a2)) : 0;
        if (c2) {
            if (this.f27094a.f14925c.length < j2) {
                this.f27094a.f14925c = new float[j2];
            }
            float f7 = (this.f27094a.f14924b[1] - this.f27094a.f14924b[0]) / 2.0f;
            for (int i5 = 0; i5 < j2; i5++) {
                this.f27094a.f14925c[i5] = this.f27094a.f14924b[i5] + f7;
            }
        }
        this.f27094a.f14943u = this.f27094a.f14924b[0];
        this.f27094a.f14942t = this.f27094a.f14924b[j2 - 1];
        this.f27094a.f14944v = Math.abs(this.f27094a.f14942t - this.f27094a.f14943u);
    }

    public void a(Canvas canvas) {
        if (this.f27193g.y() && this.f27193g.h()) {
            this.f27097d.setTypeface(this.f27193g.v());
            this.f27097d.setTextSize(this.f27193g.w());
            this.f27097d.setColor(this.f27193g.x());
            e centerOffsets = this.f27206r.getCenterOffsets();
            e a2 = e.a(0.0f, 0.0f);
            float factor = this.f27206r.getFactor();
            int i2 = this.f27193g.D() ? this.f27193g.f14926d : this.f27193g.f14926d - 1;
            for (int i3 = !this.f27193g.E(); i3 < i2; i3++) {
                i.a(centerOffsets, (this.f27193g.f14924b[i3] - this.f27193g.f14943u) * factor, this.f27206r.getRotationAngle(), a2);
                canvas.drawText(this.f27193g.a(i3), a2.f27222a + 10.0f, a2.f27223b, this.f27097d);
            }
            e.b(centerOffsets);
            e.b(a2);
        }
    }

    public void e(Canvas canvas) {
        List<LimitLine> m2 = this.f27193g.m();
        if (m2 != null) {
            float sliceAngle = this.f27206r.getSliceAngle();
            float factor = this.f27206r.getFactor();
            e centerOffsets = this.f27206r.getCenterOffsets();
            e a2 = e.a(0.0f, 0.0f);
            for (int i2 = 0; i2 < m2.size(); i2++) {
                LimitLine limitLine = m2.get(i2);
                if (limitLine.y()) {
                    this.f27099f.setColor(limitLine.c());
                    this.f27099f.setPathEffect(limitLine.d());
                    this.f27099f.setStrokeWidth(limitLine.b());
                    float a3 = (limitLine.a() - this.f27206r.getYChartMin()) * factor;
                    Path path = this.f27207s;
                    path.reset();
                    for (int i3 = 0; i3 < ((fc.j) ((n) this.f27206r.getData()).j()).u(); i3++) {
                        i.a(centerOffsets, a3, (((float) i3) * sliceAngle) + this.f27206r.getRotationAngle(), a2);
                        float f2 = a2.f27222a;
                        float f3 = a2.f27223b;
                        if (i3 == 0) {
                            path.moveTo(f2, f3);
                        } else {
                            path.lineTo(f2, f3);
                        }
                    }
                    path.close();
                    canvas.drawPath(path, this.f27099f);
                }
            }
            e.b(centerOffsets);
            e.b(a2);
        }
    }
}
