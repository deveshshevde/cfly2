package fe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarEntry;
import ex.a;
import fa.d;
import fg.e;
import fg.i;
import fg.j;

public class n extends k {

    /* renamed from: a  reason: collision with root package name */
    protected RadarChart f27174a;

    /* renamed from: b  reason: collision with root package name */
    protected Paint f27175b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f27176c;

    /* renamed from: d  reason: collision with root package name */
    protected Path f27177d = new Path();

    /* renamed from: e  reason: collision with root package name */
    protected Path f27178e = new Path();

    public n(RadarChart radarChart, a aVar, j jVar) {
        super(aVar, jVar);
        this.f27174a = radarChart;
        this.f27127i = new Paint(1);
        this.f27127i.setStyle(Paint.Style.STROKE);
        this.f27127i.setStrokeWidth(2.0f);
        this.f27127i.setColor(Color.rgb(255, 187, 115));
        Paint paint = new Paint(1);
        this.f27175b = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f27176c = new Paint(1);
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        com.github.mikephil.charting.data.n nVar = (com.github.mikephil.charting.data.n) this.f27174a.getData();
        int u2 = ((fc.j) nVar.j()).u();
        for (fc.j jVar : nVar.h()) {
            if (jVar.s()) {
                a(canvas, jVar, u2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, fc.j jVar, int i2) {
        float b2 = this.f27125g.b();
        float a2 = this.f27125g.a();
        float sliceAngle = this.f27174a.getSliceAngle();
        float factor = this.f27174a.getFactor();
        e centerOffsets = this.f27174a.getCenterOffsets();
        e a3 = e.a(0.0f, 0.0f);
        Path path = this.f27177d;
        path.reset();
        boolean z2 = false;
        for (int i3 = 0; i3 < jVar.u(); i3++) {
            this.f27126h.setColor(jVar.a(i3));
            i.a(centerOffsets, (((RadarEntry) jVar.d(i3)).b() - this.f27174a.getYChartMin()) * factor * a2, (((float) i3) * sliceAngle * b2) + this.f27174a.getRotationAngle(), a3);
            if (!Float.isNaN(a3.f27222a)) {
                if (!z2) {
                    path.moveTo(a3.f27222a, a3.f27223b);
                    z2 = true;
                } else {
                    path.lineTo(a3.f27222a, a3.f27223b);
                }
            }
        }
        if (jVar.u() > i2) {
            path.lineTo(centerOffsets.f27222a, centerOffsets.f27223b);
        }
        path.close();
        if (jVar.P()) {
            Drawable M = jVar.M();
            if (M != null) {
                a(canvas, path, M);
            } else {
                a(canvas, path, jVar.L(), jVar.N());
            }
        }
        this.f27126h.setStrokeWidth(jVar.O());
        this.f27126h.setStyle(Paint.Style.STROKE);
        if (!jVar.P() || jVar.N() < 255) {
            canvas.drawPath(path, this.f27126h);
        }
        e.b(centerOffsets);
        e.b(a3);
    }

    public void a(Canvas canvas, e eVar, float f2, float f3, int i2, int i3, float f4) {
        canvas.save();
        float a2 = i.a(f3);
        float a3 = i.a(f2);
        if (i2 != 1122867) {
            Path path = this.f27178e;
            path.reset();
            path.addCircle(eVar.f27222a, eVar.f27223b, a2, Path.Direction.CW);
            if (a3 > 0.0f) {
                path.addCircle(eVar.f27222a, eVar.f27223b, a3, Path.Direction.CCW);
            }
            this.f27176c.setColor(i2);
            this.f27176c.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.f27176c);
        }
        if (i3 != 1122867) {
            this.f27176c.setColor(i3);
            this.f27176c.setStyle(Paint.Style.STROKE);
            this.f27176c.setStrokeWidth(i.a(f4));
            canvas.drawCircle(eVar.f27222a, eVar.f27223b, a2, this.f27176c);
        }
        canvas.restore();
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    public void a(Canvas canvas, d[] dVarArr) {
        int i2;
        d[] dVarArr2 = dVarArr;
        float sliceAngle = this.f27174a.getSliceAngle();
        float factor = this.f27174a.getFactor();
        e centerOffsets = this.f27174a.getCenterOffsets();
        e a2 = e.a(0.0f, 0.0f);
        com.github.mikephil.charting.data.n nVar = (com.github.mikephil.charting.data.n) this.f27174a.getData();
        int length = dVarArr2.length;
        int i3 = 0;
        int i4 = 0;
        while (i4 < length) {
            d dVar = dVarArr2[i4];
            fc.j jVar = (fc.j) nVar.a(dVar.f());
            if (jVar != null && jVar.g()) {
                RadarEntry radarEntry = (RadarEntry) jVar.d((int) dVar.a());
                if (a(radarEntry, jVar)) {
                    i.a(centerOffsets, (radarEntry.b() - this.f27174a.getYChartMin()) * factor * this.f27125g.a(), (dVar.a() * sliceAngle * this.f27125g.b()) + this.f27174a.getRotationAngle(), a2);
                    dVar.a(a2.f27222a, a2.f27223b);
                    a(canvas, a2.f27222a, a2.f27223b, jVar);
                    if (jVar.v() && !Float.isNaN(a2.f27222a) && !Float.isNaN(a2.f27223b)) {
                        int B = jVar.B();
                        if (B == 1122867) {
                            B = jVar.a(i3);
                        }
                        if (jVar.C() < 255) {
                            B = fg.a.a(B, jVar.C());
                        }
                        float D = jVar.D();
                        float E = jVar.E();
                        int A = jVar.A();
                        int i5 = A;
                        i2 = i4;
                        a(canvas, a2, D, E, i5, B, jVar.F());
                        i4 = i2 + 1;
                        i3 = 0;
                    }
                }
            }
            i2 = i4;
            i4 = i2 + 1;
            i3 = 0;
        }
        e.b(centerOffsets);
        e.b(a2);
    }

    public void b(Canvas canvas) {
        float f2;
        int i2;
        float f3;
        int i3;
        int i4;
        RadarEntry radarEntry;
        ez.d dVar;
        fc.j jVar;
        e eVar;
        float b2 = this.f27125g.b();
        float a2 = this.f27125g.a();
        float sliceAngle = this.f27174a.getSliceAngle();
        float factor = this.f27174a.getFactor();
        e centerOffsets = this.f27174a.getCenterOffsets();
        e a3 = e.a(0.0f, 0.0f);
        e a4 = e.a(0.0f, 0.0f);
        float a5 = i.a(5.0f);
        int i5 = 0;
        while (i5 < ((com.github.mikephil.charting.data.n) this.f27174a.getData()).c()) {
            fc.j jVar2 = (fc.j) ((com.github.mikephil.charting.data.n) this.f27174a.getData()).a(i5);
            if (!a(jVar2)) {
                i2 = i5;
                f2 = b2;
            } else {
                b((fc.e) jVar2);
                ez.d h2 = jVar2.h();
                e a6 = e.a(jVar2.r());
                a6.f27222a = i.a(a6.f27222a);
                a6.f27223b = i.a(a6.f27223b);
                int i6 = 0;
                while (i6 < jVar2.u()) {
                    RadarEntry radarEntry2 = (RadarEntry) jVar2.d(i6);
                    e eVar2 = a6;
                    float f4 = ((float) i6) * sliceAngle * b2;
                    i.a(centerOffsets, (radarEntry2.b() - this.f27174a.getYChartMin()) * factor * a2, f4 + this.f27174a.getRotationAngle(), a3);
                    if (jVar2.p()) {
                        String a7 = h2.a(radarEntry2);
                        float f5 = a3.f27222a;
                        radarEntry = radarEntry2;
                        float f6 = a3.f27223b - a5;
                        int c2 = jVar2.c(i6);
                        i3 = i6;
                        f3 = b2;
                        eVar = eVar2;
                        dVar = h2;
                        float f7 = f5;
                        jVar = jVar2;
                        float f8 = f6;
                        i4 = i5;
                        a(canvas, a7, f7, f8, c2);
                    } else {
                        radarEntry = radarEntry2;
                        i3 = i6;
                        jVar = jVar2;
                        i4 = i5;
                        f3 = b2;
                        eVar = eVar2;
                        dVar = h2;
                    }
                    if (radarEntry.g() != null && jVar.q()) {
                        Drawable g2 = radarEntry.g();
                        i.a(centerOffsets, (radarEntry.b() * factor * a2) + eVar.f27223b, f4 + this.f27174a.getRotationAngle(), a4);
                        a4.f27223b += eVar.f27222a;
                        i.a(canvas, g2, (int) a4.f27222a, (int) a4.f27223b, g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                    }
                    i6 = i3 + 1;
                    a6 = eVar;
                    jVar2 = jVar;
                    h2 = dVar;
                    i5 = i4;
                    b2 = f3;
                }
                i2 = i5;
                f2 = b2;
                e.b(a6);
            }
            i5 = i2 + 1;
            b2 = f2;
        }
        e.b(centerOffsets);
        e.b(a3);
        e.b(a4);
    }

    public void c(Canvas canvas) {
        d(canvas);
    }

    /* access modifiers changed from: protected */
    public void d(Canvas canvas) {
        float sliceAngle = this.f27174a.getSliceAngle();
        float factor = this.f27174a.getFactor();
        float rotationAngle = this.f27174a.getRotationAngle();
        e centerOffsets = this.f27174a.getCenterOffsets();
        this.f27175b.setStrokeWidth(this.f27174a.getWebLineWidth());
        this.f27175b.setColor(this.f27174a.getWebColor());
        this.f27175b.setAlpha(this.f27174a.getWebAlpha());
        int skipWebLineCount = this.f27174a.getSkipWebLineCount() + 1;
        int u2 = ((fc.j) ((com.github.mikephil.charting.data.n) this.f27174a.getData()).j()).u();
        e a2 = e.a(0.0f, 0.0f);
        for (int i2 = 0; i2 < u2; i2 += skipWebLineCount) {
            i.a(centerOffsets, this.f27174a.getYRange() * factor, (((float) i2) * sliceAngle) + rotationAngle, a2);
            canvas.drawLine(centerOffsets.f27222a, centerOffsets.f27223b, a2.f27222a, a2.f27223b, this.f27175b);
        }
        e.b(a2);
        this.f27175b.setStrokeWidth(this.f27174a.getWebLineWidthInner());
        this.f27175b.setColor(this.f27174a.getWebColorInner());
        this.f27175b.setAlpha(this.f27174a.getWebAlpha());
        int i3 = this.f27174a.getYAxis().f14926d;
        e a3 = e.a(0.0f, 0.0f);
        e a4 = e.a(0.0f, 0.0f);
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            while (i5 < ((com.github.mikephil.charting.data.n) this.f27174a.getData()).i()) {
                float yChartMin = (this.f27174a.getYAxis().f14924b[i4] - this.f27174a.getYChartMin()) * factor;
                i.a(centerOffsets, yChartMin, (((float) i5) * sliceAngle) + rotationAngle, a3);
                i5++;
                i.a(centerOffsets, yChartMin, (((float) i5) * sliceAngle) + rotationAngle, a4);
                canvas.drawLine(a3.f27222a, a3.f27223b, a4.f27222a, a4.f27223b, this.f27175b);
            }
        }
        e.b(a3);
        e.b(a4);
    }
}
