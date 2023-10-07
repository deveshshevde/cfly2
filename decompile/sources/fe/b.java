package fe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import fa.d;
import fb.a;
import fg.e;
import fg.g;
import fg.i;
import fg.j;
import java.util.List;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    protected a f27100a;

    /* renamed from: b  reason: collision with root package name */
    protected RectF f27101b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    protected ey.b[] f27102c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f27103d;

    /* renamed from: e  reason: collision with root package name */
    protected Paint f27104e;

    /* renamed from: l  reason: collision with root package name */
    private RectF f27105l = new RectF();

    public b(a aVar, ex.a aVar2, j jVar) {
        super(aVar2, jVar);
        this.f27100a = aVar;
        this.f27127i = new Paint(1);
        this.f27127i.setStyle(Paint.Style.FILL);
        this.f27127i.setColor(Color.rgb(0, 0, 0));
        this.f27127i.setAlpha(120);
        Paint paint = new Paint(1);
        this.f27103d = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f27104e = paint2;
        paint2.setStyle(Paint.Style.STROKE);
    }

    public void a() {
        com.github.mikephil.charting.data.a barData = this.f27100a.getBarData();
        this.f27102c = new ey.b[barData.c()];
        for (int i2 = 0; i2 < this.f27102c.length; i2++) {
            fc.a aVar = (fc.a) barData.a(i2);
            this.f27102c[i2] = new ey.b(aVar.u() * 4 * (aVar.v() ? aVar.A() : 1), barData.c(), aVar.v());
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3, float f4, float f5, g gVar) {
        this.f27101b.set(f2 - f5, f3, f2 + f5, f4);
        gVar.a(this.f27101b, this.f27125g.a());
    }

    public void a(Canvas canvas) {
        com.github.mikephil.charting.data.a barData = this.f27100a.getBarData();
        for (int i2 = 0; i2 < barData.c(); i2++) {
            fc.a aVar = (fc.a) barData.a(i2);
            if (aVar.s()) {
                a(canvas, aVar, i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, fc.a aVar, int i2) {
        fc.a aVar2 = aVar;
        int i3 = i2;
        g a2 = this.f27100a.a(aVar.t());
        this.f27104e.setColor(aVar.D());
        this.f27104e.setStrokeWidth(i.a(aVar.C()));
        int i4 = 0;
        boolean z2 = true;
        boolean z3 = aVar.C() > 0.0f;
        float b2 = this.f27125g.b();
        float a3 = this.f27125g.a();
        if (this.f27100a.d()) {
            this.f27103d.setColor(aVar.B());
            float a4 = this.f27100a.getBarData().a() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) aVar.u()) * b2)), aVar.u());
            for (int i5 = 0; i5 < min; i5++) {
                float i6 = ((BarEntry) aVar2.d(i5)).i();
                this.f27105l.left = i6 - a4;
                this.f27105l.right = i6 + a4;
                a2.a(this.f27105l);
                if (!this.f27179o.g(this.f27105l.right)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f27179o.h(this.f27105l.left)) {
                    break;
                } else {
                    this.f27105l.top = this.f27179o.e();
                    this.f27105l.bottom = this.f27179o.h();
                    canvas.drawRect(this.f27105l, this.f27103d);
                }
            }
        }
        Canvas canvas3 = canvas;
        ey.b bVar = this.f27102c[i3];
        bVar.a(b2, a3);
        bVar.a(i3);
        bVar.a(this.f27100a.c(aVar.t()));
        bVar.a(this.f27100a.getBarData().a());
        bVar.a(aVar2);
        a2.a(bVar.f26995b);
        if (aVar.b().size() != 1) {
            z2 = false;
        }
        if (z2) {
            this.f27126h.setColor(aVar.c());
        }
        while (i4 < bVar.b()) {
            int i7 = i4 + 2;
            if (this.f27179o.g(bVar.f26995b[i7])) {
                if (this.f27179o.h(bVar.f26995b[i4])) {
                    if (!z2) {
                        this.f27126h.setColor(aVar2.a(i4 / 4));
                    }
                    if (aVar.d() != null) {
                        fd.a d2 = aVar.d();
                        this.f27126h.setShader(new LinearGradient(bVar.f26995b[i4], bVar.f26995b[i4 + 3], bVar.f26995b[i4], bVar.f26995b[i4 + 1], d2.a(), d2.b(), Shader.TileMode.MIRROR));
                    }
                    if (aVar.e() != null) {
                        int i8 = i4 / 4;
                        this.f27126h.setShader(new LinearGradient(bVar.f26995b[i4], bVar.f26995b[i4 + 3], bVar.f26995b[i4], bVar.f26995b[i4 + 1], aVar2.b(i8).a(), aVar2.b(i8).b(), Shader.TileMode.MIRROR));
                    }
                    int i9 = i4 + 1;
                    int i10 = i4 + 3;
                    canvas.drawRect(bVar.f26995b[i4], bVar.f26995b[i9], bVar.f26995b[i7], bVar.f26995b[i10], this.f27126h);
                    if (z3) {
                        canvas.drawRect(bVar.f26995b[i4], bVar.f26995b[i9], bVar.f26995b[i7], bVar.f26995b[i10], this.f27104e);
                    }
                } else {
                    return;
                }
            }
            i4 += 4;
            Canvas canvas4 = canvas;
        }
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    public void a(Canvas canvas, d[] dVarArr) {
        float f2;
        float f3;
        com.github.mikephil.charting.data.a barData = this.f27100a.getBarData();
        for (d dVar : dVarArr) {
            fc.a aVar = (fc.a) barData.a(dVar.f());
            if (aVar != null && aVar.g()) {
                BarEntry barEntry = (BarEntry) aVar.b(dVar.a(), dVar.b());
                if (a(barEntry, aVar)) {
                    g a2 = this.f27100a.a(aVar.t());
                    this.f27127i.setColor(aVar.a());
                    this.f27127i.setAlpha(aVar.E());
                    if (!(dVar.g() >= 0 && barEntry.d())) {
                        f3 = barEntry.b();
                        f2 = 0.0f;
                    } else if (this.f27100a.e()) {
                        float e2 = barEntry.e();
                        f2 = -barEntry.f();
                        f3 = e2;
                    } else {
                        fa.j jVar = barEntry.c()[dVar.g()];
                        f3 = jVar.f27090a;
                        f2 = jVar.f27091b;
                    }
                    a(barEntry.i(), f3, f2, barData.a() / 2.0f, a2);
                    a(dVar, this.f27101b);
                    canvas.drawRect(this.f27101b, this.f27127i);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, RectF rectF) {
        dVar.a(rectF.centerX(), rectF.top);
    }

    public void b(Canvas canvas) {
        boolean z2;
        float f2;
        float f3;
        List list;
        boolean z3;
        e eVar;
        int i2;
        float f4;
        boolean z4;
        g gVar;
        float[] fArr;
        float f5;
        int i3;
        int i4;
        BarEntry barEntry;
        float[] fArr2;
        float f6;
        float f7;
        float f8;
        BarEntry barEntry2;
        List list2;
        int i5;
        ez.d dVar;
        e eVar2;
        float f9;
        BarEntry barEntry3;
        if (a((fb.e) this.f27100a)) {
            List h2 = this.f27100a.getBarData().h();
            float a2 = i.a(4.5f);
            boolean c2 = this.f27100a.c();
            int i6 = 0;
            while (i6 < this.f27100a.getBarData().c()) {
                fc.a aVar = (fc.a) h2.get(i6);
                if (!a(aVar)) {
                    list = h2;
                    f3 = f2;
                    z3 = z2;
                } else {
                    b((fc.e) aVar);
                    boolean c3 = this.f27100a.c(aVar.t());
                    float b2 = (float) i.b(this.f27129k, "8");
                    float f10 = z2 ? -f2 : b2 + f2;
                    float f11 = z2 ? b2 + f2 : -f2;
                    if (c3) {
                        f10 = (-f10) - b2;
                        f11 = (-f11) - b2;
                    }
                    float f12 = f10;
                    float f13 = f11;
                    ey.b bVar = this.f27102c[i6];
                    float a3 = this.f27125g.a();
                    ez.d h3 = aVar.h();
                    e a4 = e.a(aVar.r());
                    a4.f27222a = i.a(a4.f27222a);
                    a4.f27223b = i.a(a4.f27223b);
                    if (!aVar.v()) {
                        int i7 = 0;
                        while (((float) i7) < ((float) bVar.f26995b.length) * this.f27125g.b()) {
                            float f14 = (bVar.f26995b[i7] + bVar.f26995b[i7 + 2]) / 2.0f;
                            if (!this.f27179o.h(f14)) {
                                break;
                            }
                            int i8 = i7 + 1;
                            if (!this.f27179o.f(bVar.f26995b[i8]) || !this.f27179o.g(f14)) {
                                i5 = i7;
                                dVar = h3;
                                list2 = h2;
                                eVar2 = a4;
                            } else {
                                int i9 = i7 / 4;
                                BarEntry barEntry4 = (BarEntry) aVar.d(i9);
                                float b3 = barEntry4.b();
                                if (aVar.p()) {
                                    String a5 = h3.a(barEntry4);
                                    int i10 = (b3 > 0.0f ? 1 : (b3 == 0.0f ? 0 : -1));
                                    float[] fArr3 = bVar.f26995b;
                                    barEntry3 = barEntry4;
                                    f9 = f14;
                                    String str = a5;
                                    i5 = i7;
                                    list2 = h2;
                                    eVar2 = a4;
                                    float f15 = i10 >= 0 ? fArr3[i8] + f12 : fArr3[i7 + 3] + f13;
                                    dVar = h3;
                                    a(canvas, str, f9, f15, aVar.c(i9));
                                } else {
                                    barEntry3 = barEntry4;
                                    f9 = f14;
                                    i5 = i7;
                                    dVar = h3;
                                    list2 = h2;
                                    eVar2 = a4;
                                }
                                if (barEntry3.g() != null && aVar.q()) {
                                    Drawable g2 = barEntry3.g();
                                    i.a(canvas, g2, (int) (f9 + eVar2.f27222a), (int) ((b3 >= 0.0f ? bVar.f26995b[i8] + f12 : bVar.f26995b[i5 + 3] + f13) + eVar2.f27223b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                }
                            }
                            i7 = i5 + 4;
                            a4 = eVar2;
                            h3 = dVar;
                            h2 = list2;
                        }
                        list = h2;
                        eVar = a4;
                    } else {
                        ez.d dVar2 = h3;
                        list = h2;
                        eVar = a4;
                        g a6 = this.f27100a.a(aVar.t());
                        int i11 = 0;
                        int i12 = 0;
                        while (((float) i11) < ((float) aVar.u()) * this.f27125g.b()) {
                            BarEntry barEntry5 = (BarEntry) aVar.d(i11);
                            float[] a7 = barEntry5.a();
                            float f16 = (bVar.f26995b[i12] + bVar.f26995b[i12 + 2]) / 2.0f;
                            int c4 = aVar.c(i11);
                            if (a7 != null) {
                                BarEntry barEntry6 = barEntry5;
                                i2 = i11;
                                f4 = f2;
                                z4 = z2;
                                fArr = a7;
                                gVar = a6;
                                float f17 = f16;
                                int length = fArr.length * 2;
                                float[] fArr4 = new float[length];
                                float f18 = -barEntry6.f();
                                int i13 = 0;
                                int i14 = 0;
                                float f19 = 0.0f;
                                while (i13 < length) {
                                    float f20 = fArr[i14];
                                    if (f20 == 0.0f && (f19 == 0.0f || f18 == 0.0f)) {
                                        float f21 = f18;
                                        f18 = f20;
                                        f7 = f21;
                                    } else if (f20 >= 0.0f) {
                                        f19 += f20;
                                        f7 = f18;
                                        f18 = f19;
                                    } else {
                                        f7 = f18 - f20;
                                    }
                                    fArr4[i13 + 1] = f18 * a3;
                                    i13 += 2;
                                    i14++;
                                    f18 = f7;
                                }
                                gVar.a(fArr4);
                                int i15 = 0;
                                while (i15 < length) {
                                    float f22 = fArr[i15 / 2];
                                    float f23 = fArr4[i15 + 1] + (((f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1)) == 0 && (f18 > 0.0f ? 1 : (f18 == 0.0f ? 0 : -1)) == 0 && (f19 > 0.0f ? 1 : (f19 == 0.0f ? 0 : -1)) > 0) || (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1)) < 0 ? f13 : f12);
                                    int i16 = i15;
                                    if (!this.f27179o.h(f17)) {
                                        break;
                                    }
                                    if (!this.f27179o.f(f23) || !this.f27179o.g(f17)) {
                                        i3 = length;
                                        f5 = f17;
                                        i4 = i16;
                                        barEntry = barEntry6;
                                        fArr2 = fArr4;
                                    } else {
                                        if (aVar.p()) {
                                            BarEntry barEntry7 = barEntry6;
                                            f6 = f23;
                                            i4 = i16;
                                            barEntry = barEntry7;
                                            fArr2 = fArr4;
                                            i3 = length;
                                            f5 = f17;
                                            a(canvas, dVar2.a(f22, barEntry7), f17, f6, c4);
                                        } else {
                                            f6 = f23;
                                            i3 = length;
                                            f5 = f17;
                                            i4 = i16;
                                            barEntry = barEntry6;
                                            fArr2 = fArr4;
                                        }
                                        if (barEntry.g() != null && aVar.q()) {
                                            Drawable g3 = barEntry.g();
                                            i.a(canvas, g3, (int) (f5 + eVar.f27222a), (int) (f6 + eVar.f27223b), g3.getIntrinsicWidth(), g3.getIntrinsicHeight());
                                        }
                                    }
                                    i15 = i4 + 2;
                                    fArr4 = fArr2;
                                    barEntry6 = barEntry;
                                    length = i3;
                                    f17 = f5;
                                }
                            } else if (!this.f27179o.h(f16)) {
                                break;
                            } else {
                                float[] fArr5 = a7;
                                int i17 = i12 + 1;
                                if (!this.f27179o.f(bVar.f26995b[i17]) || !this.f27179o.g(f16)) {
                                    a6 = a6;
                                    z2 = z2;
                                    f2 = f2;
                                    i11 = i11;
                                } else {
                                    if (aVar.p()) {
                                        f8 = f16;
                                        f4 = f2;
                                        fArr = fArr5;
                                        barEntry2 = barEntry5;
                                        i2 = i11;
                                        z4 = z2;
                                        gVar = a6;
                                        a(canvas, dVar2.a(barEntry5), f8, bVar.f26995b[i17] + (barEntry5.b() >= 0.0f ? f12 : f13), c4);
                                    } else {
                                        f8 = f16;
                                        i2 = i11;
                                        f4 = f2;
                                        z4 = z2;
                                        fArr = fArr5;
                                        barEntry2 = barEntry5;
                                        gVar = a6;
                                    }
                                    if (barEntry2.g() != null && aVar.q()) {
                                        Drawable g4 = barEntry2.g();
                                        i.a(canvas, g4, (int) (eVar.f27222a + f8), (int) (bVar.f26995b[i17] + (barEntry2.b() >= 0.0f ? f12 : f13) + eVar.f27223b), g4.getIntrinsicWidth(), g4.getIntrinsicHeight());
                                    }
                                }
                            }
                            i12 = fArr == null ? i12 + 4 : i12 + (fArr.length * 4);
                            i11 = i2 + 1;
                            a6 = gVar;
                            z2 = z4;
                            f2 = f4;
                        }
                    }
                    f3 = f2;
                    z3 = z2;
                    e.b(eVar);
                }
                i6++;
                c2 = z3;
                h2 = list;
                a2 = f3;
            }
        }
    }

    public void c(Canvas canvas) {
    }
}
