package ir;

import android.view.animation.Interpolator;
import ir.g;
import java.util.ArrayList;
import java.util.Arrays;

class h {

    /* renamed from: a  reason: collision with root package name */
    int f29113a;

    /* renamed from: b  reason: collision with root package name */
    g f29114b = this.f29117e.get(0);

    /* renamed from: c  reason: collision with root package name */
    g f29115c;

    /* renamed from: d  reason: collision with root package name */
    Interpolator f29116d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<g> f29117e;

    /* renamed from: f  reason: collision with root package name */
    l f29118f;

    public h(g... gVarArr) {
        this.f29113a = gVarArr.length;
        ArrayList<g> arrayList = new ArrayList<>();
        this.f29117e = arrayList;
        arrayList.addAll(Arrays.asList(gVarArr));
        g gVar = this.f29117e.get(this.f29113a - 1);
        this.f29115c = gVar;
        this.f29116d = gVar.d();
    }

    public static h a(float... fArr) {
        int length = fArr.length;
        g.a[] aVarArr = new g.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (g.a) g.a(0.0f);
            aVarArr[1] = (g.a) g.a(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (g.a) g.a(0.0f, fArr[0]);
            for (int i2 = 1; i2 < length; i2++) {
                aVarArr[i2] = (g.a) g.a(((float) i2) / ((float) (length - 1)), fArr[i2]);
            }
        }
        return new e(aVarArr);
    }

    public Object a(float f2) {
        int i2 = this.f29113a;
        if (i2 == 2) {
            Interpolator interpolator = this.f29116d;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f2);
            }
            return this.f29118f.a(f2, this.f29114b.b(), this.f29115c.b());
        }
        int i3 = 1;
        if (f2 <= 0.0f) {
            g gVar = this.f29117e.get(1);
            Interpolator d2 = gVar.d();
            if (d2 != null) {
                f2 = d2.getInterpolation(f2);
            }
            float c2 = this.f29114b.c();
            return this.f29118f.a((f2 - c2) / (gVar.c() - c2), this.f29114b.b(), gVar.b());
        } else if (f2 >= 1.0f) {
            g gVar2 = this.f29117e.get(i2 - 2);
            Interpolator d3 = this.f29115c.d();
            if (d3 != null) {
                f2 = d3.getInterpolation(f2);
            }
            float c3 = gVar2.c();
            return this.f29118f.a((f2 - c3) / (this.f29115c.c() - c3), gVar2.b(), this.f29115c.b());
        } else {
            g gVar3 = this.f29114b;
            while (i3 < this.f29113a) {
                g gVar4 = this.f29117e.get(i3);
                if (f2 < gVar4.c()) {
                    Interpolator d4 = gVar4.d();
                    if (d4 != null) {
                        f2 = d4.getInterpolation(f2);
                    }
                    float c4 = gVar3.c();
                    return this.f29118f.a((f2 - c4) / (gVar4.c() - c4), gVar3.b(), gVar4.b());
                }
                i3++;
                gVar3 = gVar4;
            }
            return this.f29115c.b();
        }
    }

    public void a(l lVar) {
        this.f29118f = lVar;
    }

    /* renamed from: b */
    public h clone() {
        ArrayList<g> arrayList = this.f29117e;
        int size = arrayList.size();
        g[] gVarArr = new g[size];
        for (int i2 = 0; i2 < size; i2++) {
            gVarArr[i2] = arrayList.get(i2).clone();
        }
        return new h(gVarArr);
    }

    public String toString() {
        String str = " ";
        for (int i2 = 0; i2 < this.f29113a; i2++) {
            str = str + this.f29117e.get(i2).b() + "  ";
        }
        return str;
    }
}
