package fe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import fg.d;
import fg.g;
import fg.i;
import fg.j;
import java.util.List;

public class u extends t {

    /* renamed from: r  reason: collision with root package name */
    protected Path f27203r = new Path();

    /* renamed from: s  reason: collision with root package name */
    protected Path f27204s = new Path();

    /* renamed from: t  reason: collision with root package name */
    protected float[] f27205t = new float[4];

    public u(j jVar, YAxis yAxis, g gVar) {
        super(jVar, yAxis, gVar);
        this.f27099f.setTextAlign(Paint.Align.LEFT);
    }

    /* access modifiers changed from: protected */
    public Path a(Path path, int i2, float[] fArr) {
        path.moveTo(fArr[i2], this.f27179o.e());
        path.lineTo(fArr[i2], this.f27179o.h());
        return path;
    }

    public void a(float f2, float f3, boolean z2) {
        float f4;
        double d2;
        if (this.f27179o.j() > 10.0f && !this.f27179o.u()) {
            d a2 = this.f27095b.a(this.f27179o.f(), this.f27179o.e());
            d a3 = this.f27095b.a(this.f27179o.g(), this.f27179o.e());
            if (!z2) {
                f4 = (float) a2.f27218a;
                d2 = a3.f27218a;
            } else {
                f4 = (float) a3.f27218a;
                d2 = a2.f27218a;
            }
            d.a(a2);
            d.a(a3);
            f2 = f4;
            f3 = (float) d2;
        }
        a(f2, f3);
    }

    public void a(Canvas canvas) {
        float f2;
        if (this.f27193g.y() && this.f27193g.h()) {
            float[] c2 = c();
            this.f27097d.setTypeface(this.f27193g.v());
            this.f27097d.setTextSize(this.f27193g.w());
            this.f27097d.setColor(this.f27193g.x());
            this.f27097d.setTextAlign(Paint.Align.CENTER);
            float a2 = i.a(2.5f);
            float b2 = (float) i.b(this.f27097d, "Q");
            YAxis.AxisDependency z2 = this.f27193g.z();
            YAxis.YAxisLabelPosition C = this.f27193g.C();
            if (z2 == YAxis.AxisDependency.LEFT) {
                YAxis.YAxisLabelPosition yAxisLabelPosition = YAxis.YAxisLabelPosition.OUTSIDE_CHART;
                f2 = this.f27179o.e() - a2;
            } else {
                YAxis.YAxisLabelPosition yAxisLabelPosition2 = YAxis.YAxisLabelPosition.OUTSIDE_CHART;
                f2 = this.f27179o.h() + b2 + a2;
            }
            a(canvas, f2, c2, this.f27193g.u());
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float[] fArr, float f3) {
        this.f27097d.setTypeface(this.f27193g.v());
        this.f27097d.setTextSize(this.f27193g.w());
        this.f27097d.setColor(this.f27193g.x());
        int i2 = this.f27193g.D() ? this.f27193g.f14926d : this.f27193g.f14926d - 1;
        for (int i3 = !this.f27193g.E(); i3 < i2; i3++) {
            canvas.drawText(this.f27193g.a(i3), fArr[i3 * 2], f2 - f3, this.f27097d);
        }
    }

    public RectF b() {
        this.f27196j.set(this.f27179o.k());
        this.f27196j.inset(-this.f27094a.f(), 0.0f);
        return this.f27196j;
    }

    public void b(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (this.f27193g.y() && this.f27193g.b()) {
            this.f27098e.setColor(this.f27193g.g());
            this.f27098e.setStrokeWidth(this.f27193g.e());
            if (this.f27193g.z() == YAxis.AxisDependency.LEFT) {
                f5 = this.f27179o.f();
                f4 = this.f27179o.e();
                f3 = this.f27179o.g();
                f2 = this.f27179o.e();
            } else {
                f5 = this.f27179o.f();
                f4 = this.f27179o.h();
                f3 = this.f27179o.g();
                f2 = this.f27179o.h();
            }
            canvas.drawLine(f5, f4, f3, f2, this.f27098e);
        }
    }

    /* access modifiers changed from: protected */
    public float[] c() {
        if (this.f27197k.length != this.f27193g.f14926d * 2) {
            this.f27197k = new float[(this.f27193g.f14926d * 2)];
        }
        float[] fArr = this.f27197k;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2] = this.f27193g.f14924b[i2 / 2];
        }
        this.f27095b.a(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public void d(Canvas canvas) {
        int save = canvas.save();
        this.f27199m.set(this.f27179o.k());
        this.f27199m.inset(-this.f27193g.K(), 0.0f);
        canvas.clipRect(this.f27202q);
        d b2 = this.f27095b.b(0.0f, 0.0f);
        this.f27194h.setColor(this.f27193g.J());
        this.f27194h.setStrokeWidth(this.f27193g.K());
        Path path = this.f27203r;
        path.reset();
        path.moveTo(((float) b2.f27218a) - 1.0f, this.f27179o.e());
        path.lineTo(((float) b2.f27218a) - 1.0f, this.f27179o.h());
        canvas.drawPath(path, this.f27194h);
        canvas.restoreToCount(save);
    }

    public void e(Canvas canvas) {
        float f2;
        float b2;
        float f3;
        Canvas canvas2 = canvas;
        List<LimitLine> m2 = this.f27193g.m();
        if (m2 != null && m2.size() > 0) {
            float[] fArr = this.f27205t;
            float f4 = 0.0f;
            fArr[0] = 0.0f;
            char c2 = 1;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            Path path = this.f27204s;
            path.reset();
            int i2 = 0;
            while (i2 < m2.size()) {
                LimitLine limitLine = m2.get(i2);
                if (limitLine.y()) {
                    int save = canvas.save();
                    this.f27202q.set(this.f27179o.k());
                    this.f27202q.inset(-limitLine.b(), f4);
                    canvas2.clipRect(this.f27202q);
                    fArr[0] = limitLine.a();
                    fArr[2] = limitLine.a();
                    this.f27095b.a(fArr);
                    fArr[c2] = this.f27179o.e();
                    fArr[3] = this.f27179o.h();
                    path.moveTo(fArr[0], fArr[c2]);
                    path.lineTo(fArr[2], fArr[3]);
                    this.f27099f.setStyle(Paint.Style.STROKE);
                    this.f27099f.setColor(limitLine.c());
                    this.f27099f.setPathEffect(limitLine.d());
                    this.f27099f.setStrokeWidth(limitLine.b());
                    canvas2.drawPath(path, this.f27099f);
                    path.reset();
                    String g2 = limitLine.g();
                    if (g2 != null && !g2.equals("")) {
                        this.f27099f.setStyle(limitLine.e());
                        this.f27099f.setPathEffect((PathEffect) null);
                        this.f27099f.setColor(limitLine.x());
                        this.f27099f.setTypeface(limitLine.v());
                        this.f27099f.setStrokeWidth(0.5f);
                        this.f27099f.setTextSize(limitLine.w());
                        float b3 = limitLine.b() + limitLine.t();
                        float a2 = i.a(2.0f) + limitLine.u();
                        LimitLine.LimitLabelPosition f5 = limitLine.f();
                        if (f5 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            b2 = (float) i.b(this.f27099f, g2);
                            this.f27099f.setTextAlign(Paint.Align.LEFT);
                            f3 = fArr[0] + b3;
                        } else {
                            if (f5 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                                this.f27099f.setTextAlign(Paint.Align.LEFT);
                                f2 = fArr[0] + b3;
                            } else if (f5 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                                this.f27099f.setTextAlign(Paint.Align.RIGHT);
                                b2 = (float) i.b(this.f27099f, g2);
                                f3 = fArr[0] - b3;
                            } else {
                                this.f27099f.setTextAlign(Paint.Align.RIGHT);
                                f2 = fArr[0] - b3;
                            }
                            canvas2.drawText(g2, f2, this.f27179o.h() - a2, this.f27099f);
                        }
                        canvas2.drawText(g2, f3, this.f27179o.e() + a2 + b2, this.f27099f);
                    }
                    canvas2.restoreToCount(save);
                }
                i2++;
                f4 = 0.0f;
                c2 = 1;
            }
        }
    }
}
