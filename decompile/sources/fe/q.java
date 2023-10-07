package fe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
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

public class q extends a {

    /* renamed from: g  reason: collision with root package name */
    protected XAxis f27182g;

    /* renamed from: h  reason: collision with root package name */
    protected Path f27183h = new Path();

    /* renamed from: i  reason: collision with root package name */
    protected float[] f27184i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    protected RectF f27185j = new RectF();

    /* renamed from: k  reason: collision with root package name */
    protected float[] f27186k = new float[2];

    /* renamed from: l  reason: collision with root package name */
    protected RectF f27187l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    float[] f27188m = new float[4];

    /* renamed from: n  reason: collision with root package name */
    private Path f27189n = new Path();

    public q(j jVar, XAxis xAxis, g gVar) {
        super(jVar, gVar, xAxis);
        this.f27182g = xAxis;
        this.f27097d.setColor(-16777216);
        this.f27097d.setTextAlign(Paint.Align.CENTER);
        this.f27097d.setTextSize(i.a(10.0f));
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        super.a(f2, f3);
        c();
    }

    public void a(float f2, float f3, boolean z2) {
        float f4;
        double d2;
        if (this.f27179o.i() > 10.0f && !this.f27179o.u()) {
            d a2 = this.f27095b.a(this.f27179o.f(), this.f27179o.e());
            d a3 = this.f27095b.a(this.f27179o.g(), this.f27179o.e());
            if (z2) {
                f4 = (float) a3.f27218a;
                d2 = a2.f27218a;
            } else {
                f4 = (float) a2.f27218a;
                d2 = a3.f27218a;
            }
            d.a(a2);
            d.a(a3);
            f2 = f4;
            f3 = (float) d2;
        }
        a(f2, f3);
    }

    public void a(Canvas canvas) {
        float h2;
        float h3;
        float f2;
        if (this.f27182g.y() && this.f27182g.h()) {
            float u2 = this.f27182g.u();
            this.f27097d.setTypeface(this.f27182g.v());
            this.f27097d.setTextSize(this.f27182g.w());
            this.f27097d.setColor(this.f27182g.x());
            e a2 = e.a(0.0f, 0.0f);
            if (this.f27182g.z() == XAxis.XAxisPosition.TOP) {
                a2.f27222a = 0.5f;
                a2.f27223b = 1.0f;
                h2 = this.f27179o.e();
            } else {
                if (this.f27182g.z() == XAxis.XAxisPosition.TOP_INSIDE) {
                    a2.f27222a = 0.5f;
                    a2.f27223b = 1.0f;
                    h3 = this.f27179o.e() + u2;
                    u2 = (float) this.f27182g.F;
                } else {
                    if (this.f27182g.z() != XAxis.XAxisPosition.BOTTOM) {
                        XAxis.XAxisPosition z2 = this.f27182g.z();
                        XAxis.XAxisPosition xAxisPosition = XAxis.XAxisPosition.BOTTOM_INSIDE;
                        a2.f27222a = 0.5f;
                        if (z2 == xAxisPosition) {
                            a2.f27223b = 0.0f;
                            h2 = this.f27179o.h() - u2;
                            u2 = (float) this.f27182g.F;
                        } else {
                            a2.f27223b = 1.0f;
                            a(canvas, this.f27179o.e() - u2, a2);
                        }
                    }
                    a2.f27222a = 0.5f;
                    a2.f27223b = 0.0f;
                    h3 = this.f27179o.h();
                }
                f2 = h3 + u2;
                a(canvas, f2, a2);
                e.b(a2);
            }
            f2 = h2 - u2;
            a(canvas, f2, a2);
            e.b(a2);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float f3, Path path) {
        path.moveTo(f2, this.f27179o.h());
        path.lineTo(f2, this.f27179o.e());
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
            XAxis xAxis = this.f27182g;
            if (c2) {
                fArr[i3] = xAxis.f14925c[i3 / 2];
            } else {
                fArr[i3] = xAxis.f14924b[i3 / 2];
            }
        }
        this.f27095b.a(fArr);
        for (int i4 = 0; i4 < i2; i4 += 2) {
            float f3 = fArr[i4];
            if (this.f27179o.e(f3)) {
                int i5 = i4 / 2;
                String a2 = this.f27182g.q().a(this.f27182g.f14924b[i5], (a) this.f27182g);
                if (this.f27182g.B()) {
                    if (i5 == this.f27182g.f14926d - 1 && this.f27182g.f14926d > 1) {
                        float a3 = (float) i.a(this.f27097d, a2);
                        if (a3 > this.f27179o.b() * 2.0f && f3 + a3 > this.f27179o.n()) {
                            f3 -= a3 / 2.0f;
                        }
                    } else if (i4 == 0) {
                        f3 += ((float) i.a(this.f27097d, a2)) / 2.0f;
                    }
                }
                a(canvas, a2, f3, f2, eVar, A);
            }
        }
    }

    public void a(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.f27188m;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f27179o.e();
        float[] fArr3 = this.f27188m;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f27179o.h();
        this.f27189n.reset();
        Path path = this.f27189n;
        float[] fArr4 = this.f27188m;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.f27189n;
        float[] fArr5 = this.f27188m;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.f27099f.setStyle(Paint.Style.STROKE);
        this.f27099f.setColor(limitLine.c());
        this.f27099f.setStrokeWidth(limitLine.b());
        this.f27099f.setPathEffect(limitLine.d());
        canvas.drawPath(this.f27189n, this.f27099f);
    }

    public void a(Canvas canvas, LimitLine limitLine, float[] fArr, float f2) {
        float f3;
        float b2;
        float f4;
        String g2 = limitLine.g();
        if (g2 != null && !g2.equals("")) {
            this.f27099f.setStyle(limitLine.e());
            this.f27099f.setPathEffect((PathEffect) null);
            this.f27099f.setColor(limitLine.x());
            this.f27099f.setStrokeWidth(0.5f);
            this.f27099f.setTextSize(limitLine.w());
            float b3 = limitLine.b() + limitLine.t();
            LimitLine.LimitLabelPosition f5 = limitLine.f();
            if (f5 == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                b2 = (float) i.b(this.f27099f, g2);
                this.f27099f.setTextAlign(Paint.Align.LEFT);
                f4 = fArr[0] + b3;
            } else {
                if (f5 == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                    this.f27099f.setTextAlign(Paint.Align.LEFT);
                    f3 = fArr[0] + b3;
                } else if (f5 == LimitLine.LimitLabelPosition.LEFT_TOP) {
                    this.f27099f.setTextAlign(Paint.Align.RIGHT);
                    b2 = (float) i.b(this.f27099f, g2);
                    f4 = fArr[0] - b3;
                } else {
                    this.f27099f.setTextAlign(Paint.Align.RIGHT);
                    f3 = fArr[0] - b3;
                }
                canvas.drawText(g2, f3, this.f27179o.h() - f2, this.f27099f);
                return;
            }
            canvas.drawText(g2, f4, this.f27179o.e() + f2 + b2, this.f27099f);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, String str, float f2, float f3, e eVar, float f4) {
        i.a(canvas, str, f2, f3, this.f27097d, eVar, f4);
    }

    /* access modifiers changed from: protected */
    public void b() {
        this.f27096c.setColor(this.f27182g.d());
        this.f27096c.setStrokeWidth(this.f27182g.f());
        this.f27096c.setPathEffect(this.f27182g.r());
    }

    public void b(Canvas canvas) {
        if (this.f27182g.b() && this.f27182g.y()) {
            this.f27098e.setColor(this.f27182g.g());
            this.f27098e.setStrokeWidth(this.f27182g.e());
            this.f27098e.setPathEffect(this.f27182g.s());
            if (this.f27182g.z() == XAxis.XAxisPosition.TOP || this.f27182g.z() == XAxis.XAxisPosition.TOP_INSIDE || this.f27182g.z() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f27179o.f(), this.f27179o.e(), this.f27179o.g(), this.f27179o.e(), this.f27098e);
            }
            if (this.f27182g.z() == XAxis.XAxisPosition.BOTTOM || this.f27182g.z() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f27182g.z() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas.drawLine(this.f27179o.f(), this.f27179o.h(), this.f27179o.g(), this.f27179o.h(), this.f27098e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        String p2 = this.f27182g.p();
        this.f27097d.setTypeface(this.f27182g.v());
        this.f27097d.setTextSize(this.f27182g.w());
        b c2 = i.c(this.f27097d, p2);
        float f2 = c2.f27215a;
        float b2 = (float) i.b(this.f27097d, "Q");
        b a2 = i.a(f2, b2, this.f27182g.A());
        this.f27182g.C = Math.round(f2);
        this.f27182g.D = Math.round(b2);
        this.f27182g.E = Math.round(a2.f27215a);
        this.f27182g.F = Math.round(a2.f27216b);
        b.a(a2);
        b.a(c2);
    }

    public void c(Canvas canvas) {
        if (this.f27182g.a() && this.f27182g.y()) {
            int save = canvas.save();
            canvas.clipRect(d());
            if (this.f27184i.length != this.f27094a.f14926d * 2) {
                this.f27184i = new float[(this.f27182g.f14926d * 2)];
            }
            float[] fArr = this.f27184i;
            for (int i2 = 0; i2 < fArr.length; i2 += 2) {
                int i3 = i2 / 2;
                fArr[i2] = this.f27182g.f14924b[i3];
                fArr[i2 + 1] = this.f27182g.f14924b[i3];
            }
            this.f27095b.a(fArr);
            b();
            Path path = this.f27183h;
            path.reset();
            for (int i4 = 0; i4 < fArr.length; i4 += 2) {
                a(canvas, fArr[i4], fArr[i4 + 1], path);
            }
            canvas.restoreToCount(save);
        }
    }

    public RectF d() {
        this.f27185j.set(this.f27179o.k());
        this.f27185j.inset(-this.f27094a.f(), 0.0f);
        return this.f27185j;
    }

    public void d(Canvas canvas) {
        List<LimitLine> m2 = this.f27182g.m();
        if (m2 != null && m2.size() > 0) {
            float[] fArr = this.f27186k;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            for (int i2 = 0; i2 < m2.size(); i2++) {
                LimitLine limitLine = m2.get(i2);
                if (limitLine.y()) {
                    int save = canvas.save();
                    this.f27187l.set(this.f27179o.k());
                    this.f27187l.inset(-limitLine.b(), 0.0f);
                    canvas.clipRect(this.f27187l);
                    fArr[0] = limitLine.a();
                    fArr[1] = 0.0f;
                    this.f27095b.a(fArr);
                    a(canvas, limitLine, fArr);
                    a(canvas, limitLine, fArr, limitLine.u() + 2.0f);
                    canvas.restoreToCount(save);
                }
            }
        }
    }
}
