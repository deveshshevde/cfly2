package ir;

import android.view.animation.Interpolator;
import ir.g;
import java.util.ArrayList;

class e extends h {

    /* renamed from: g  reason: collision with root package name */
    private float f29104g;

    /* renamed from: h  reason: collision with root package name */
    private float f29105h;

    /* renamed from: i  reason: collision with root package name */
    private float f29106i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f29107j = true;

    public e(g.a... aVarArr) {
        super(aVarArr);
    }

    /* renamed from: a */
    public e clone() {
        ArrayList arrayList = this.f29117e;
        int size = this.f29117e.size();
        g.a[] aVarArr = new g.a[size];
        for (int i2 = 0; i2 < size; i2++) {
            aVarArr[i2] = (g.a) ((g) arrayList.get(i2)).clone();
        }
        return new e(aVarArr);
    }

    public Object a(float f2) {
        return Float.valueOf(b(f2));
    }

    public float b(float f2) {
        Object b2;
        if (this.f29113a == 2) {
            if (this.f29107j) {
                this.f29107j = false;
                this.f29104g = ((g.a) this.f29117e.get(0)).f();
                float f3 = ((g.a) this.f29117e.get(1)).f();
                this.f29105h = f3;
                this.f29106i = f3 - this.f29104g;
            }
            if (this.f29116d != null) {
                f2 = this.f29116d.getInterpolation(f2);
            }
            if (this.f29118f == null) {
                return this.f29104g + (f2 * this.f29106i);
            }
            b2 = this.f29118f.a(f2, Float.valueOf(this.f29104g), Float.valueOf(this.f29105h));
        } else if (f2 <= 0.0f) {
            g.a aVar = (g.a) this.f29117e.get(0);
            g.a aVar2 = (g.a) this.f29117e.get(1);
            float f4 = aVar.f();
            float f5 = aVar2.f();
            float c2 = aVar.c();
            float c3 = aVar2.c();
            Interpolator d2 = aVar2.d();
            if (d2 != null) {
                f2 = d2.getInterpolation(f2);
            }
            float f6 = (f2 - c2) / (c3 - c2);
            return this.f29118f == null ? f4 + (f6 * (f5 - f4)) : ((Number) this.f29118f.a(f6, Float.valueOf(f4), Float.valueOf(f5))).floatValue();
        } else if (f2 >= 1.0f) {
            g.a aVar3 = (g.a) this.f29117e.get(this.f29113a - 2);
            g.a aVar4 = (g.a) this.f29117e.get(this.f29113a - 1);
            float f7 = aVar3.f();
            float f8 = aVar4.f();
            float c4 = aVar3.c();
            float c5 = aVar4.c();
            Interpolator d3 = aVar4.d();
            if (d3 != null) {
                f2 = d3.getInterpolation(f2);
            }
            float f9 = (f2 - c4) / (c5 - c4);
            return this.f29118f == null ? f7 + (f9 * (f8 - f7)) : ((Number) this.f29118f.a(f9, Float.valueOf(f7), Float.valueOf(f8))).floatValue();
        } else {
            g.a aVar5 = (g.a) this.f29117e.get(0);
            int i2 = 1;
            while (i2 < this.f29113a) {
                g.a aVar6 = (g.a) this.f29117e.get(i2);
                if (f2 < aVar6.c()) {
                    Interpolator d4 = aVar6.d();
                    if (d4 != null) {
                        f2 = d4.getInterpolation(f2);
                    }
                    float c6 = (f2 - aVar5.c()) / (aVar6.c() - aVar5.c());
                    float f10 = aVar5.f();
                    float f11 = aVar6.f();
                    return this.f29118f == null ? f10 + (c6 * (f11 - f10)) : ((Number) this.f29118f.a(c6, Float.valueOf(f10), Float.valueOf(f11))).floatValue();
                }
                i2++;
                aVar5 = aVar6;
            }
            b2 = ((g) this.f29117e.get(this.f29113a - 1)).b();
        }
        return ((Number) b2).floatValue();
    }
}
