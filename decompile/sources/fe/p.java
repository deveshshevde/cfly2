package fe;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.o;
import ex.a;
import fa.d;
import fb.e;
import fb.h;
import fc.k;
import fg.g;
import fg.i;
import fg.j;
import java.util.List;

public class p extends l {

    /* renamed from: a  reason: collision with root package name */
    protected h f27180a;

    /* renamed from: b  reason: collision with root package name */
    float[] f27181b = new float[2];

    public p(h hVar, a aVar, j jVar) {
        super(aVar, jVar);
        this.f27180a = hVar;
    }

    public void a() {
    }

    public void a(Canvas canvas) {
        for (k kVar : this.f27180a.getScatterData().h()) {
            if (kVar.s()) {
                a(canvas, kVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, k kVar) {
        int i2;
        k kVar2 = kVar;
        if (kVar.u() >= 1) {
            j jVar = this.f27179o;
            g a2 = this.f27180a.a(kVar.t());
            float a3 = this.f27125g.a();
            ff.a A = kVar.A();
            if (A == null) {
                Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
                return;
            }
            int min = (int) Math.min(Math.ceil((double) (((float) kVar.u()) * this.f27125g.b())), (double) ((float) kVar.u()));
            int i3 = 0;
            while (i3 < min) {
                Entry d2 = kVar2.d(i3);
                this.f27181b[0] = d2.i();
                this.f27181b[1] = d2.b() * a3;
                a2.a(this.f27181b);
                if (jVar.h(this.f27181b[0])) {
                    if (!jVar.g(this.f27181b[0]) || !jVar.f(this.f27181b[1])) {
                        i2 = i3;
                    } else {
                        this.f27126h.setColor(kVar2.a(i3 / 2));
                        j jVar2 = this.f27179o;
                        float[] fArr = this.f27181b;
                        i2 = i3;
                        A.a(canvas, kVar, jVar2, fArr[0], fArr[1], this.f27126h);
                    }
                    i3 = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f27129k.setColor(i2);
        canvas.drawText(str, f2, f3, this.f27129k);
    }

    public void a(Canvas canvas, d[] dVarArr) {
        o scatterData = this.f27180a.getScatterData();
        for (d dVar : dVarArr) {
            k kVar = (k) scatterData.a(dVar.f());
            if (kVar != null && kVar.g()) {
                Entry b2 = kVar.b(dVar.a(), dVar.b());
                if (a(b2, kVar)) {
                    fg.d b3 = this.f27180a.a(kVar.t()).b(b2.i(), b2.b() * this.f27125g.a());
                    dVar.a((float) b3.f27218a, (float) b3.f27219b);
                    a(canvas, (float) b3.f27218a, (float) b3.f27219b, kVar);
                }
            }
        }
    }

    public void b(Canvas canvas) {
        k kVar;
        Entry entry;
        if (a((e) this.f27180a)) {
            List h2 = this.f27180a.getScatterData().h();
            for (int i2 = 0; i2 < this.f27180a.getScatterData().c(); i2++) {
                k kVar2 = (k) h2.get(i2);
                if (a(kVar2) && kVar2.u() >= 1) {
                    b((fc.e) kVar2);
                    this.f27106f.a(this.f27180a, kVar2);
                    float[] a2 = this.f27180a.a(kVar2.t()).a(kVar2, this.f27125g.b(), this.f27125g.a(), this.f27106f.f27107a, this.f27106f.f27108b);
                    float a3 = i.a(kVar2.v());
                    ez.d h3 = kVar2.h();
                    fg.e a4 = fg.e.a(kVar2.r());
                    a4.f27222a = i.a(a4.f27222a);
                    a4.f27223b = i.a(a4.f27223b);
                    int i3 = 0;
                    while (i3 < a2.length && this.f27179o.h(a2[i3])) {
                        if (this.f27179o.g(a2[i3])) {
                            int i4 = i3 + 1;
                            if (this.f27179o.f(a2[i4])) {
                                int i5 = i3 / 2;
                                Entry d2 = kVar2.d(this.f27106f.f27107a + i5);
                                if (kVar2.p()) {
                                    String a5 = h3.a(d2);
                                    float f2 = a2[i3];
                                    float f3 = a2[i4] - a3;
                                    entry = d2;
                                    float f4 = f3;
                                    kVar = kVar2;
                                    a(canvas, a5, f2, f4, kVar2.c(i5 + this.f27106f.f27107a));
                                } else {
                                    entry = d2;
                                    kVar = kVar2;
                                }
                                if (entry.g() != null && kVar.q()) {
                                    Drawable g2 = entry.g();
                                    i.a(canvas, g2, (int) (a2[i3] + a4.f27222a), (int) (a2[i4] + a4.f27223b), g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                }
                                i3 += 2;
                                kVar2 = kVar;
                            }
                        }
                        kVar = kVar2;
                        i3 += 2;
                        kVar2 = kVar;
                    }
                    fg.e.b(a4);
                }
            }
        }
    }

    public void c(Canvas canvas) {
    }
}
