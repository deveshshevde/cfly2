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

public class t extends a {

    /* renamed from: g  reason: collision with root package name */
    protected YAxis f27193g;

    /* renamed from: h  reason: collision with root package name */
    protected Paint f27194h;

    /* renamed from: i  reason: collision with root package name */
    protected Path f27195i = new Path();

    /* renamed from: j  reason: collision with root package name */
    protected RectF f27196j = new RectF();

    /* renamed from: k  reason: collision with root package name */
    protected float[] f27197k = new float[2];

    /* renamed from: l  reason: collision with root package name */
    protected Path f27198l = new Path();

    /* renamed from: m  reason: collision with root package name */
    protected RectF f27199m = new RectF();

    /* renamed from: n  reason: collision with root package name */
    protected Path f27200n = new Path();

    /* renamed from: p  reason: collision with root package name */
    protected float[] f27201p = new float[2];

    /* renamed from: q  reason: collision with root package name */
    protected RectF f27202q = new RectF();

    public t(j jVar, YAxis yAxis, g gVar) {
        super(jVar, gVar, yAxis);
        this.f27193g = yAxis;
        if (this.f27179o != null) {
            this.f27097d.setColor(-16777216);
            this.f27097d.setTextSize(i.a(10.0f));
            Paint paint = new Paint(1);
            this.f27194h = paint;
            paint.setColor(-7829368);
            this.f27194h.setStrokeWidth(1.0f);
            this.f27194h.setStyle(Paint.Style.STROKE);
        }
    }

    /* access modifiers changed from: protected */
    public Path a(Path path, int i2, float[] fArr) {
        int i3 = i2 + 1;
        path.moveTo(this.f27179o.a(), fArr[i3]);
        path.lineTo(this.f27179o.g(), fArr[i3]);
        return path;
    }

    public void a(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        if (this.f27193g.y() && this.f27193g.h()) {
            float[] c2 = c();
            this.f27097d.setTypeface(this.f27193g.v());
            this.f27097d.setTextSize(this.f27193g.w());
            this.f27097d.setColor(this.f27193g.x());
            float t2 = this.f27193g.t();
            float b2 = (((float) i.b(this.f27097d, "A")) / 2.5f) + this.f27193g.u();
            YAxis.AxisDependency z2 = this.f27193g.z();
            YAxis.YAxisLabelPosition C = this.f27193g.C();
            if (z2 == YAxis.AxisDependency.LEFT) {
                if (C == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.f27097d.setTextAlign(Paint.Align.RIGHT);
                    f3 = this.f27179o.a();
                    f2 = f3 - t2;
                    a(canvas, f2, c2, b2);
                }
                this.f27097d.setTextAlign(Paint.Align.LEFT);
                f4 = this.f27179o.a();
            } else if (C == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.f27097d.setTextAlign(Paint.Align.LEFT);
                f4 = this.f27179o.g();
            } else {
                this.f27097d.setTextAlign(Paint.Align.RIGHT);
                f3 = this.f27179o.g();
                f2 = f3 - t2;
                a(canvas, f2, c2, b2);
            }
            f2 = f4 + t2;
            a(canvas, f2, c2, b2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float[] fArr, float f3) {
        int i2 = this.f27193g.D() ? this.f27193g.f14926d : this.f27193g.f14926d - 1;
        for (int i3 = !this.f27193g.E(); i3 < i2; i3++) {
            canvas.drawText(this.f27193g.a(i3), f2, fArr[(i3 * 2) + 1] + f3, this.f27097d);
        }
    }

    public RectF b() {
        this.f27196j.set(this.f27179o.k());
        this.f27196j.inset(0.0f, -this.f27094a.f());
        return this.f27196j;
    }

    public void b(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        if (this.f27193g.y() && this.f27193g.b()) {
            this.f27098e.setColor(this.f27193g.g());
            this.f27098e.setStrokeWidth(this.f27193g.e());
            if (this.f27193g.z() == YAxis.AxisDependency.LEFT) {
                f4 = this.f27179o.f();
                f3 = this.f27179o.e();
                f2 = this.f27179o.f();
            } else {
                f4 = this.f27179o.g();
                f3 = this.f27179o.e();
                f2 = this.f27179o.g();
            }
            canvas.drawLine(f4, f3, f2, this.f27179o.h(), this.f27098e);
        }
    }

    public void c(Canvas canvas) {
        if (this.f27193g.y()) {
            if (this.f27193g.a()) {
                int save = canvas.save();
                canvas.clipRect(b());
                float[] c2 = c();
                this.f27096c.setColor(this.f27193g.d());
                this.f27096c.setStrokeWidth(this.f27193g.f());
                this.f27096c.setPathEffect(this.f27193g.r());
                Path path = this.f27195i;
                path.reset();
                for (int i2 = 0; i2 < c2.length; i2 += 2) {
                    canvas.drawPath(a(path, i2, c2), this.f27096c);
                    path.reset();
                }
                canvas.restoreToCount(save);
            }
            if (this.f27193g.I()) {
                d(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public float[] c() {
        if (this.f27197k.length != this.f27193g.f14926d * 2) {
            this.f27197k = new float[(this.f27193g.f14926d * 2)];
        }
        float[] fArr = this.f27197k;
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            fArr[i2 + 1] = this.f27193g.f14924b[i2 / 2];
        }
        this.f27095b.a(fArr);
        return fArr;
    }

    /* access modifiers changed from: protected */
    public void d(Canvas canvas) {
        int save = canvas.save();
        this.f27199m.set(this.f27179o.k());
        this.f27199m.inset(0.0f, -this.f27193g.K());
        canvas.clipRect(this.f27199m);
        d b2 = this.f27095b.b(0.0f, 0.0f);
        this.f27194h.setColor(this.f27193g.J());
        this.f27194h.setStrokeWidth(this.f27193g.K());
        Path path = this.f27198l;
        path.reset();
        path.moveTo(this.f27179o.f(), (float) b2.f27219b);
        path.lineTo(this.f27179o.g(), (float) b2.f27219b);
        canvas.drawPath(path, this.f27194h);
        canvas.restoreToCount(save);
    }

    public void e(Canvas canvas) {
        float a2;
        float f2;
        float f3;
        float f4;
        List<LimitLine> m2 = this.f27193g.m();
        if (m2 != null && m2.size() > 0) {
            float[] fArr = this.f27201p;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            Path path = this.f27200n;
            path.reset();
            for (int i2 = 0; i2 < m2.size(); i2++) {
                LimitLine limitLine = m2.get(i2);
                if (limitLine.y()) {
                    int save = canvas.save();
                    this.f27202q.set(this.f27179o.k());
                    this.f27202q.inset(0.0f, -limitLine.b());
                    canvas.clipRect(this.f27202q);
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
                        this.f27099f.setTypeface(limitLine.v());
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
