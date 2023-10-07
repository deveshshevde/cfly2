package fe;

import android.graphics.Paint;
import fg.d;
import fg.g;
import fg.i;
import fg.j;

public abstract class a extends o {

    /* renamed from: a  reason: collision with root package name */
    protected com.github.mikephil.charting.components.a f27094a;

    /* renamed from: b  reason: collision with root package name */
    protected g f27095b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f27096c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f27097d;

    /* renamed from: e  reason: collision with root package name */
    protected Paint f27098e;

    /* renamed from: f  reason: collision with root package name */
    protected Paint f27099f;

    public a(j jVar, g gVar, com.github.mikephil.charting.components.a aVar) {
        super(jVar);
        this.f27095b = gVar;
        this.f27094a = aVar;
        if (this.f27179o != null) {
            this.f27097d = new Paint(1);
            Paint paint = new Paint();
            this.f27096c = paint;
            paint.setColor(-7829368);
            this.f27096c.setStrokeWidth(1.0f);
            this.f27096c.setStyle(Paint.Style.STROKE);
            this.f27096c.setAlpha(90);
            Paint paint2 = new Paint();
            this.f27098e = paint2;
            paint2.setColor(-16777216);
            this.f27098e.setStrokeWidth(1.0f);
            this.f27098e.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint(1);
            this.f27099f = paint3;
            paint3.setStyle(Paint.Style.STROKE);
        }
    }

    public Paint a() {
        return this.f27097d;
    }

    /* access modifiers changed from: protected */
    public void a(float f2, float f3) {
        double d2;
        double d3;
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
        int c2 = this.f27094a.c();
        if (this.f27094a.i()) {
            a2 = (double) (((float) abs) / ((float) (j2 - 1)));
            this.f27094a.f14926d = j2;
            if (this.f27094a.f14924b.length < j2) {
                this.f27094a.f14924b = new float[j2];
            }
            for (int i2 = 0; i2 < j2; i2++) {
                this.f27094a.f14924b[i2] = f4;
                double d5 = (double) f4;
                Double.isNaN(d5);
                Double.isNaN(a2);
                f4 = (float) (d5 + a2);
            }
        } else {
            if (a2 == i.f27244a) {
                d2 = i.f27244a;
            } else {
                double d6 = (double) f4;
                Double.isNaN(d6);
                d2 = Math.ceil(d6 / a2) * a2;
            }
            if (this.f27094a.c()) {
                d2 -= a2;
            }
            if (a2 == i.f27244a) {
                d3 = 0.0d;
            } else {
                double d7 = (double) f5;
                Double.isNaN(d7);
                d3 = i.b(Math.floor(d7 / a2) * a2);
            }
            if (a2 != i.f27244a) {
                for (double d8 = d2; d8 <= d3; d8 += a2) {
                    c2++;
                }
            }
            this.f27094a.f14926d = c2;
            if (this.f27094a.f14924b.length < c2) {
                this.f27094a.f14924b = new float[c2];
            }
            for (int i3 = 0; i3 < c2; i3++) {
                if (d2 == i.f27244a) {
                    d2 = 0.0d;
                }
                this.f27094a.f14924b[i3] = (float) d2;
                d2 += a2;
            }
            j2 = c2;
        }
        this.f27094a.f14927e = (a2 > 1.0d ? 1 : (a2 == 1.0d ? 0 : -1)) < 0 ? (int) Math.ceil(-Math.log10(a2)) : 0;
        if (this.f27094a.c()) {
            if (this.f27094a.f14925c.length < j2) {
                this.f27094a.f14925c = new float[j2];
            }
            float f6 = ((float) a2) / 2.0f;
            for (int i4 = 0; i4 < j2; i4++) {
                this.f27094a.f14925c[i4] = this.f27094a.f14924b[i4] + f6;
            }
        }
    }

    public void a(float f2, float f3, boolean z2) {
        float f4;
        double d2;
        if (this.f27179o != null && this.f27179o.i() > 10.0f && !this.f27179o.t()) {
            d a2 = this.f27095b.a(this.f27179o.f(), this.f27179o.e());
            d a3 = this.f27095b.a(this.f27179o.f(), this.f27179o.h());
            if (!z2) {
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
}
