package fe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.f;
import ex.a;
import fb.c;
import fb.e;
import fg.g;
import fg.i;
import fg.j;
import java.util.List;

public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    protected c f27111a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f27112b = new float[4];

    /* renamed from: c  reason: collision with root package name */
    private float[] f27113c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    private float[] f27114d = new float[3];

    public d(c cVar, a aVar, j jVar) {
        super(aVar, jVar);
        this.f27111a = cVar;
        this.f27126h.setStyle(Paint.Style.FILL);
        this.f27127i.setStyle(Paint.Style.STROKE);
        this.f27127i.setStrokeWidth(i.a(1.5f));
    }

    /* access modifiers changed from: protected */
    public float a(float f2, float f3, float f4, boolean z2) {
        if (z2) {
            f2 = f3 == 0.0f ? 1.0f : (float) Math.sqrt((double) (f2 / f3));
        }
        return f4 * f2;
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        for (fc.c cVar : this.f27111a.getBubbleData().h()) {
            if (cVar.s()) {
                a(canvas, cVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, fc.c cVar) {
        if (cVar.u() >= 1) {
            g a2 = this.f27111a.a(cVar.t());
            float a3 = this.f27125g.a();
            this.f27106f.a(this.f27111a, cVar);
            float[] fArr = this.f27112b;
            fArr[0] = 0.0f;
            fArr[2] = 1.0f;
            a2.a(fArr);
            boolean A = cVar.A();
            float[] fArr2 = this.f27112b;
            float min = Math.min(Math.abs(this.f27179o.h() - this.f27179o.e()), Math.abs(fArr2[2] - fArr2[0]));
            for (int i2 = this.f27106f.f27107a; i2 <= this.f27106f.f27109c + this.f27106f.f27107a; i2++) {
                BubbleEntry bubbleEntry = (BubbleEntry) cVar.d(i2);
                this.f27113c[0] = bubbleEntry.i();
                this.f27113c[1] = bubbleEntry.b() * a3;
                a2.a(this.f27113c);
                float a4 = a(bubbleEntry.a(), cVar.v(), min, A) / 2.0f;
                if (this.f27179o.i(this.f27113c[1] + a4) && this.f27179o.j(this.f27113c[1] - a4) && this.f27179o.g(this.f27113c[0] + a4)) {
                    if (this.f27179o.h(this.f27113c[0] - a4)) {
                        this.f27126h.setColor(cVar.a((int) bubbleEntry.i()));
                        float[] fArr3 = this.f27113c;
                        canvas.drawCircle(fArr3[0], fArr3[1], a4, this.f27126h);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    public void a(Canvas canvas, fa.d[] dVarArr) {
        f bubbleData = this.f27111a.getBubbleData();
        float a2 = this.f27125g.a();
        for (fa.d dVar : dVarArr) {
            fc.c cVar = (fc.c) bubbleData.a(dVar.f());
            if (cVar != null && cVar.g()) {
                BubbleEntry bubbleEntry = (BubbleEntry) cVar.b(dVar.a(), dVar.b());
                if (bubbleEntry.b() == dVar.b() && a(bubbleEntry, cVar)) {
                    g a3 = this.f27111a.a(cVar.t());
                    float[] fArr = this.f27112b;
                    fArr[0] = 0.0f;
                    fArr[2] = 1.0f;
                    a3.a(fArr);
                    boolean A = cVar.A();
                    float[] fArr2 = this.f27112b;
                    float min = Math.min(Math.abs(this.f27179o.h() - this.f27179o.e()), Math.abs(fArr2[2] - fArr2[0]));
                    this.f27113c[0] = bubbleEntry.i();
                    this.f27113c[1] = bubbleEntry.b() * a2;
                    a3.a(this.f27113c);
                    float[] fArr3 = this.f27113c;
                    dVar.a(fArr3[0], fArr3[1]);
                    float a4 = a(bubbleEntry.a(), cVar.v(), min, A) / 2.0f;
                    if (this.f27179o.i(this.f27113c[1] + a4) && this.f27179o.j(this.f27113c[1] - a4) && this.f27179o.g(this.f27113c[0] + a4)) {
                        if (this.f27179o.h(this.f27113c[0] - a4)) {
                            int a5 = cVar.a((int) bubbleEntry.i());
                            Color.RGBToHSV(Color.red(a5), Color.green(a5), Color.blue(a5), this.f27114d);
                            float[] fArr4 = this.f27114d;
                            fArr4[2] = fArr4[2] * 0.5f;
                            this.f27127i.setColor(Color.HSVToColor(Color.alpha(a5), this.f27114d));
                            this.f27127i.setStrokeWidth(cVar.B());
                            float[] fArr5 = this.f27113c;
                            canvas.drawCircle(fArr5[0], fArr5[1], a4, this.f27127i);
                        } else {
                            return;
                        }
                    }
                }
            }
            Canvas canvas2 = canvas;
        }
    }

    public void b(Canvas canvas) {
        int i2;
        float f2;
        BubbleEntry bubbleEntry;
        float f3;
        f bubbleData = this.f27111a.getBubbleData();
        if (bubbleData != null && a((e) this.f27111a)) {
            List h2 = bubbleData.h();
            float b2 = (float) i.b(this.f27129k, "1");
            for (int i3 = 0; i3 < h2.size(); i3++) {
                fc.c cVar = (fc.c) h2.get(i3);
                if (a(cVar) && cVar.u() >= 1) {
                    b((fc.e) cVar);
                    float max = Math.max(0.0f, Math.min(1.0f, this.f27125g.b()));
                    float a2 = this.f27125g.a();
                    this.f27106f.a(this.f27111a, cVar);
                    float[] a3 = this.f27111a.a(cVar.t()).a(cVar, a2, this.f27106f.f27107a, this.f27106f.f27108b);
                    float f4 = max == 1.0f ? a2 : max;
                    ez.d h3 = cVar.h();
                    fg.e a4 = fg.e.a(cVar.r());
                    a4.f27222a = i.a(a4.f27222a);
                    a4.f27223b = i.a(a4.f27223b);
                    for (int i4 = 0; i4 < a3.length; i4 = i2 + 2) {
                        int i5 = i4 / 2;
                        int c2 = cVar.c(this.f27106f.f27107a + i5);
                        int argb = Color.argb(Math.round(255.0f * f4), Color.red(c2), Color.green(c2), Color.blue(c2));
                        float f5 = a3[i4];
                        float f6 = a3[i4 + 1];
                        if (!this.f27179o.h(f5)) {
                            break;
                        }
                        if (!this.f27179o.g(f5) || !this.f27179o.f(f6)) {
                            i2 = i4;
                        } else {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) cVar.d(i5 + this.f27106f.f27107a);
                            if (cVar.p()) {
                                float f7 = f6 + (0.5f * b2);
                                bubbleEntry = bubbleEntry2;
                                f3 = f6;
                                float f8 = f5;
                                f2 = f5;
                                float f9 = f7;
                                i2 = i4;
                                a(canvas, h3.a(bubbleEntry2), f8, f9, argb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f3 = f6;
                                f2 = f5;
                                i2 = i4;
                            }
                            if (bubbleEntry.g() != null && cVar.q()) {
                                Drawable g2 = bubbleEntry.g();
                                i.a(canvas, g2, (int) (f2 + a4.f27222a), (int) (f3 + a4.f27223b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                            }
                        }
                    }
                    fg.e.b(a4);
                }
            }
        }
    }

    public void c(Canvas canvas) {
    }
}
