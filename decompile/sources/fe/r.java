package fe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.a;
import fg.b;
import fg.d;
import fg.e;
import fg.g;
import fg.i;
import fg.j;
import java.util.List;

public class r extends q {

    /* renamed from: n  reason: collision with root package name */
    protected BarChart f27190n;

    /* renamed from: p  reason: collision with root package name */
    protected Path f27191p = new Path();

    public r(j jVar, XAxis xAxis, g gVar, BarChart barChart) {
        super(jVar, xAxis, gVar);
        this.f27190n = barChart;
    }

    public void a(float f2, float f3, boolean z2) {
        float f4;
        double d2;
        if (this.f27179o.i() > 10.0f && !this.f27179o.t()) {
            d a2 = this.f27095b.a(this.f27179o.f(), this.f27179o.h());
            d a3 = this.f27095b.a(this.f27179o.f(), this.f27179o.e());
            if (z2) {
                f4 = (float) a3.f27219b;
                d2 = a2.f27219b;
            } else {
                f4 = (float) a2.f27219b;
                d2 = a3.f27219b;
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
        float f3;
        float f4;
        if (this.f27182g.y() && this.f27182g.h()) {
            float t2 = this.f27182g.t();
            this.f27097d.setTypeface(this.f27182g.v());
            this.f27097d.setTextSize(this.f27182g.w());
            this.f27097d.setColor(this.f27182g.x());
            e a2 = e.a(0.0f, 0.0f);
            if (this.f27182g.z() == XAxis.XAxisPosition.TOP) {
                a2.f27222a = 0.0f;
                a2.f27223b = 0.5f;
                f2 = this.f27179o.g();
            } else {
                if (this.f27182g.z() == XAxis.XAxisPosition.TOP_INSIDE) {
                    a2.f27222a = 1.0f;
                    a2.f27223b = 0.5f;
                    f3 = this.f27179o.g();
                } else {
                    if (this.f27182g.z() != XAxis.XAxisPosition.BOTTOM) {
                        if (this.f27182g.z() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                            a2.f27222a = 1.0f;
                            a2.f27223b = 0.5f;
                            f2 = this.f27179o.f();
                        } else {
                            a2.f27222a = 0.0f;
                            a2.f27223b = 0.5f;
                            a(canvas, this.f27179o.g() + t2, a2);
                        }
                    }
                    a2.f27222a = 1.0f;
                    a2.f27223b = 0.5f;
                    f3 = this.f27179o.f();
                }
                f4 = f3 - t2;
                a(canvas, f4, a2);
                e.b(a2);
            }
            f4 = f2 + t2;
            a(canvas, f4, a2);
            e.b(a2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float f3, Path path) {
        path.moveTo(this.f27179o.g(), f3);
        path.lineTo(this.f27179o.f(), f3);
        canvas.drawPath(path, this.f27096c);
        path.reset();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, e eVar) {
        float A = this.f27182g.A();
        boolean c2 = this.f27182g.c();
        int i2 = this.f27182g.f14926d * 2;
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i3 + 1;
            XAxis xAxis = this.f27182g;
            if (c2) {
                fArr[i4] = xAxis.f14925c[i3 / 2];
            } else {
                fArr[i4] = xAxis.f14924b[i3 / 2];
            }
        }
        this.f27095b.a(fArr);
        for (int i5 = 0; i5 < i2; i5 += 2) {
            float f3 = fArr[i5 + 1];
            if (this.f27179o.f(f3)) {
                a(canvas, this.f27182g.q().a(this.f27182g.f14924b[i5 / 2], (a) this.f27182g), f2, f3, eVar, A);
            }
        }
    }

    public void b(Canvas canvas) {
        if (this.f27182g.b() && this.f27182g.y()) {
            this.f27098e.setColor(this.f27182g.g());
            this.f27098e.setStrokeWidth(this.f27182g.e());
            if (this.f27182g.z() == XAxis.XAxisPosition.TOP || this.f27182g.z() == XAxis.XAxisPosition.TOP_INSIDE || this.f27182g.z() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f27179o.g(), this.f27179o.e(), this.f27179o.g(), this.f27179o.h(), this.f27098e);
            }
            if (this.f27182g.z() == XAxis.XAxisPosition.BOTTOM || this.f27182g.z() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f27182g.z() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f27179o.f(), this.f27179o.e(), this.f27179o.f(), this.f27179o.h(), this.f27098e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f27097d.setTypeface(this.f27182g.v());
        this.f27097d.setTextSize(this.f27182g.w());
        b c2 = i.c(this.f27097d, this.f27182g.p());
        float f2 = c2.f27216b;
        b a2 = i.a(c2.f27215a, f2, this.f27182g.A());
        this.f27182g.C = Math.round((float) ((int) (c2.f27215a + (this.f27182g.t() * 3.5f))));
        this.f27182g.D = Math.round(f2);
        this.f27182g.E = (int) (a2.f27215a + (this.f27182g.t() * 3.5f));
        this.f27182g.F = Math.round(a2.f27216b);
        b.a(a2);
    }

    public RectF d() {
        this.f27185j.set(this.f27179o.k());
        this.f27185j.inset(0.0f, -this.f27094a.f());
        return this.f27185j;
    }

    public void d(Canvas canvas) {
        float a2;
        float f2;
        float f3;
        float f4;
        List<LimitLine> m2 = this.f27182g.m();
        if (m2 != null && m2.size() > 0) {
            float[] fArr = this.f27186k;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.f27191p;
            path.reset();
            for (int i2 = 0; i2 < m2.size(); i2++) {
                LimitLine limitLine = m2.get(i2);
                if (limitLine.y()) {
                    int save = canvas.save();
                    this.f27187l.set(this.f27179o.k());
                    this.f27187l.inset(0.0f, -limitLine.b());
                    canvas.clipRect(this.f27187l);
                    this.f27099f.setStyle(Paint.Style.STROKE);
                    this.f27099f.setColor(limitLine.c());
                    this.f27099f.setStrokeWidth(limitLine.b());
                    this.f27099f.setPathEffect(limitLine.d());
                    fArr[1] = limitLine.a();
                    this.f27095b.a(fArr);
                    path.moveTo(this.f27179o.f(), fArr[1]);
                    path.lineTo(this.f27179o.g(), fArr[1]);
                    canvas.drawPath(path, this.f27099f);
                    path.reset();
                    String g2 = limitLine.g();
                    if (g2 != null && !g2.equals("")) {
                        this.f27099f.setStyle(limitLine.e());
                        this.f27099f.setPathEffect((PathEffect) null);
                        this.f27099f.setColor(limitLine.x());
                        this.f27099f.setStrokeWidth(0.5f);
                        this.f27099f.setTextSize(limitLine.w());
                        float b2 = (float) i.b(this.f27099f, g2);
                        float a3 = i.a(4.0f) + limitLine.t();
                        float b3 = limitLine.b() + b2 + limitLine.u();
                        LimitLine.LimitLabelPosition f5 = limitLine.f();
                        if (f5 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                            this.f27099f.setTextAlign(Paint.Align.RIGHT);
                            f3 = this.f27179o.g() - a3;
                            f4 = fArr[1];
                        } else {
                            if (f5 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                                this.f27099f.setTextAlign(Paint.Align.RIGHT);
                                a2 = this.f27179o.g() - a3;
                                f2 = fArr[1];
                            } else if (f5 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                                this.f27099f.setTextAlign(Paint.Align.LEFT);
                                f3 = this.f27179o.f() + a3;
                                f4 = fArr[1];
                            } else {
                                this.f27099f.setTextAlign(Paint.Align.LEFT);
                                a2 = this.f27179o.a() + a3;
                                f2 = fArr[1];
                            }
                            canvas.drawText(g2, a2, f2 + b3, this.f27099f);
                        }
                        canvas.drawText(g2, f3, (f4 - b3) + b2, this.f27099f);
                    }
                    canvas.restoreToCount(save);
                }
            }
        }
    }
}
