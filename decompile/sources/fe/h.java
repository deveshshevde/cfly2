package fe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BarEntry;
import ey.b;
import ey.c;
import fa.d;
import fb.a;
import fb.e;
import fg.g;
import fg.i;
import fg.j;
import java.util.List;

public class h extends b {

    /* renamed from: l  reason: collision with root package name */
    private RectF f27130l = new RectF();

    public h(a aVar, ex.a aVar2, j jVar) {
        super(aVar, aVar2, jVar);
        this.f27129k.setTextAlign(Paint.Align.LEFT);
    }

    public void a() {
        com.github.mikephil.charting.data.a barData = this.f27100a.getBarData();
        this.f27102c = new c[barData.c()];
        for (int i2 = 0; i2 < this.f27102c.length; i2++) {
            fc.a aVar = (fc.a) barData.a(i2);
            this.f27102c[i2] = new c(aVar.u() * 4 * (aVar.v() ? aVar.A() : 1), barData.c(), aVar.v());
        }
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3, float f4, float f5, g gVar) {
        this.f27101b.set(f3, f2 - f5, f4, f2 + f5);
        gVar.b(this.f27101b, this.f27125g.a());
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
                this.f27130l.top = i6 - a4;
                this.f27130l.bottom = i6 + a4;
                a2.a(this.f27130l);
                if (!this.f27179o.i(this.f27130l.bottom)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f27179o.j(this.f27130l.top)) {
                    break;
                } else {
                    this.f27130l.left = this.f27179o.f();
                    this.f27130l.right = this.f27179o.g();
                    canvas.drawRect(this.f27130l, this.f27103d);
                }
            }
        }
        Canvas canvas3 = canvas;
        b bVar = this.f27102c[i3];
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
            int i7 = i4 + 3;
            if (this.f27179o.i(bVar.f26995b[i7])) {
                int i8 = i4 + 1;
                if (this.f27179o.j(bVar.f26995b[i8])) {
                    if (!z2) {
                        this.f27126h.setColor(aVar2.a(i4 / 4));
                    }
                    int i9 = i4 + 2;
                    canvas.drawRect(bVar.f26995b[i4], bVar.f26995b[i8], bVar.f26995b[i9], bVar.f26995b[i7], this.f27126h);
                    if (z3) {
                        canvas.drawRect(bVar.f26995b[i4], bVar.f26995b[i8], bVar.f26995b[i9], bVar.f26995b[i7], this.f27104e);
                    }
                }
                i4 += 4;
                Canvas canvas4 = canvas;
            } else {
                return;
            }
        }
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    /* access modifiers changed from: protected */
    public void a(d dVar, RectF rectF) {
        dVar.a(rectF.centerY(), rectF.right);
    }

    /* access modifiers changed from: protected */
    public boolean a(e eVar) {
        return ((float) eVar.getData().i()) < ((float) eVar.getMaxVisibleCount()) * this.f27179o.r();
    }

    public void b(Canvas canvas) {
        int i2;
        List list;
        fg.e eVar;
        int i3;
        float[] fArr;
        float[] fArr2;
        int i4;
        float f2;
        float f3;
        float f4;
        BarEntry barEntry;
        int i5;
        float f5;
        int i6;
        List list2;
        ez.d dVar;
        b bVar;
        fg.e eVar2;
        if (a(this.f27100a)) {
            List h2 = this.f27100a.getBarData().h();
            float a2 = i.a(5.0f);
            boolean c2 = this.f27100a.c();
            int i7 = 0;
            while (i7 < this.f27100a.getBarData().c()) {
                fc.a aVar = (fc.a) h2.get(i7);
                if (!a(aVar)) {
                    list = h2;
                    i2 = i7;
                } else {
                    boolean c3 = this.f27100a.c(aVar.t());
                    b((fc.e) aVar);
                    float f6 = 2.0f;
                    float b2 = ((float) i.b(this.f27129k, "10")) / 2.0f;
                    ez.d h3 = aVar.h();
                    b bVar2 = this.f27102c[i7];
                    float a3 = this.f27125g.a();
                    fg.e a4 = fg.e.a(aVar.r());
                    a4.f27222a = i.a(a4.f27222a);
                    a4.f27223b = i.a(a4.f27223b);
                    if (!aVar.v()) {
                        int i8 = 0;
                        while (((float) i8) < ((float) bVar2.f26995b.length) * this.f27125g.b()) {
                            int i9 = i8 + 1;
                            float f7 = (bVar2.f26995b[i9] + bVar2.f26995b[i8 + 3]) / f6;
                            if (!this.f27179o.i(bVar2.f26995b[i9])) {
                                break;
                            }
                            if (this.f27179o.e(bVar2.f26995b[i8]) && this.f27179o.j(bVar2.f26995b[i9])) {
                                BarEntry barEntry2 = (BarEntry) aVar.d(i8 / 4);
                                float b3 = barEntry2.b();
                                String a5 = h3.a(barEntry2);
                                float a6 = (float) i.a(this.f27129k, a5);
                                String str = a5;
                                float f8 = c2 ? a2 : -(a6 + a2);
                                fg.e eVar3 = a4;
                                float f9 = c2 ? -(a6 + a2) : a2;
                                if (c3) {
                                    f8 = (-f8) - a6;
                                    f9 = (-f9) - a6;
                                }
                                float f10 = f8;
                                float f11 = f9;
                                if (aVar.p()) {
                                    float f12 = bVar2.f26995b[i8 + 2];
                                    float f13 = b3 >= 0.0f ? f10 : f11;
                                    int c4 = aVar.c(i8 / 2);
                                    i5 = i8;
                                    String str2 = str;
                                    list2 = h2;
                                    eVar2 = eVar3;
                                    i6 = i7;
                                    bVar = bVar2;
                                    float f14 = f7 + b2;
                                    f5 = b2;
                                    dVar = h3;
                                    a(canvas, str2, f12 + f13, f14, c4);
                                } else {
                                    i5 = i8;
                                    list2 = h2;
                                    f5 = b2;
                                    eVar2 = eVar3;
                                    dVar = h3;
                                    i6 = i7;
                                    bVar = bVar2;
                                }
                                if (barEntry2.g() != null && aVar.q()) {
                                    Drawable g2 = barEntry2.g();
                                    float f15 = bVar.f26995b[i5 + 2];
                                    if (b3 < 0.0f) {
                                        f10 = f11;
                                    }
                                    i.a(canvas, g2, (int) (f15 + f10 + eVar2.f27222a), (int) (f7 + eVar2.f27223b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                }
                            } else {
                                i5 = i8;
                                list2 = h2;
                                i6 = i7;
                                f5 = b2;
                                eVar2 = a4;
                                bVar = bVar2;
                                dVar = h3;
                            }
                            i8 = i5 + 4;
                            a4 = eVar2;
                            bVar2 = bVar;
                            h3 = dVar;
                            h2 = list2;
                            i7 = i6;
                            b2 = f5;
                            f6 = 2.0f;
                        }
                        list = h2;
                        i2 = i7;
                        eVar = a4;
                    } else {
                        list = h2;
                        i2 = i7;
                        float f16 = b2;
                        eVar = a4;
                        b bVar3 = bVar2;
                        ez.d dVar2 = h3;
                        g a7 = this.f27100a.a(aVar.t());
                        int i10 = 0;
                        int i11 = 0;
                        while (((float) i10) < ((float) aVar.u()) * this.f27125g.b()) {
                            BarEntry barEntry3 = (BarEntry) aVar.d(i10);
                            int c5 = aVar.c(i10);
                            float[] a8 = barEntry3.a();
                            if (a8 != null) {
                                BarEntry barEntry4 = barEntry3;
                                i3 = i10;
                                fArr = a8;
                                int length = fArr.length * 2;
                                float[] fArr3 = new float[length];
                                float f17 = -barEntry4.f();
                                int i12 = 0;
                                int i13 = 0;
                                float f18 = 0.0f;
                                while (i12 < length) {
                                    float f19 = fArr[i13];
                                    if (f19 == 0.0f && (f18 == 0.0f || f17 == 0.0f)) {
                                        float f20 = f17;
                                        f17 = f19;
                                        f4 = f20;
                                    } else if (f19 >= 0.0f) {
                                        f18 += f19;
                                        f4 = f17;
                                        f17 = f18;
                                    } else {
                                        f4 = f17 - f19;
                                    }
                                    fArr3[i12] = f17 * a3;
                                    i12 += 2;
                                    i13++;
                                    f17 = f4;
                                }
                                a7.a(fArr3);
                                int i14 = 0;
                                while (true) {
                                    if (i14 >= length) {
                                        break;
                                    }
                                    float f21 = fArr[i14 / 2];
                                    String a9 = dVar2.a(f21, barEntry4);
                                    float a10 = (float) i.a(this.f27129k, a9);
                                    String str3 = a9;
                                    float f22 = c2 ? a2 : -(a10 + a2);
                                    int i15 = length;
                                    float f23 = c2 ? -(a10 + a2) : a2;
                                    if (c3) {
                                        f22 = (-f22) - a10;
                                        f23 = (-f23) - a10;
                                    }
                                    boolean z2 = (f21 == 0.0f && f17 == 0.0f && f18 > 0.0f) || f21 < 0.0f;
                                    float f24 = fArr3[i14];
                                    if (z2) {
                                        f22 = f23;
                                    }
                                    float f25 = f24 + f22;
                                    float f26 = (bVar3.f26995b[i11 + 1] + bVar3.f26995b[i11 + 3]) / 2.0f;
                                    if (!this.f27179o.i(f26)) {
                                        break;
                                    }
                                    if (this.f27179o.e(f25) && this.f27179o.j(f26)) {
                                        if (aVar.p()) {
                                            float f27 = f26 + f16;
                                            f2 = f26;
                                            String str4 = str3;
                                            i4 = i14;
                                            fArr2 = fArr3;
                                            float f28 = f27;
                                            f3 = f25;
                                            a(canvas, str4, f25, f28, c5);
                                        } else {
                                            f2 = f26;
                                            i4 = i14;
                                            fArr2 = fArr3;
                                            f3 = f25;
                                        }
                                        if (barEntry4.g() != null && aVar.q()) {
                                            Drawable g3 = barEntry4.g();
                                            i.a(canvas, g3, (int) (f3 + eVar.f27222a), (int) (f2 + eVar.f27223b), g3.getIntrinsicWidth(), g3.getIntrinsicHeight());
                                        }
                                    } else {
                                        i4 = i14;
                                        fArr2 = fArr3;
                                    }
                                    i14 = i4 + 2;
                                    length = i15;
                                    fArr3 = fArr2;
                                }
                            } else {
                                int i16 = i11 + 1;
                                if (!this.f27179o.i(bVar3.f26995b[i16])) {
                                    break;
                                } else if (this.f27179o.e(bVar3.f26995b[i11]) && this.f27179o.j(bVar3.f26995b[i16])) {
                                    String a11 = dVar2.a(barEntry3);
                                    float a12 = (float) i.a(this.f27129k, a11);
                                    float f29 = c2 ? a2 : -(a12 + a2);
                                    float f30 = c2 ? -(a12 + a2) : a2;
                                    if (c3) {
                                        f29 = (-f29) - a12;
                                        f30 = (-f30) - a12;
                                    }
                                    float f31 = f29;
                                    float f32 = f30;
                                    if (aVar.p()) {
                                        i3 = i10;
                                        fArr = a8;
                                        barEntry = barEntry3;
                                        a(canvas, a11, bVar3.f26995b[i11 + 2] + (barEntry3.b() >= 0.0f ? f31 : f32), bVar3.f26995b[i16] + f16, c5);
                                    } else {
                                        barEntry = barEntry3;
                                        i3 = i10;
                                        fArr = a8;
                                    }
                                    if (barEntry.g() != null && aVar.q()) {
                                        Drawable g4 = barEntry.g();
                                        float f33 = bVar3.f26995b[i11 + 2];
                                        if (barEntry.b() < 0.0f) {
                                            f31 = f32;
                                        }
                                        i.a(canvas, g4, (int) (f33 + f31 + eVar.f27222a), (int) (bVar3.f26995b[i16] + eVar.f27223b), g4.getIntrinsicWidth(), g4.getIntrinsicHeight());
                                    }
                                }
                            }
                            i11 = fArr == null ? i11 + 4 : i11 + (fArr.length * 4);
                            i10 = i3 + 1;
                        }
                    }
                    fg.e.b(eVar);
                }
                i7 = i2 + 1;
                h2 = list;
            }
        }
    }
}
