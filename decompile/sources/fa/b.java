package fa;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import fb.b;
import fc.e;
import fg.d;
import java.util.ArrayList;
import java.util.List;

public class b<T extends fb.b> implements f {

    /* renamed from: a  reason: collision with root package name */
    protected T f27075a;

    /* renamed from: b  reason: collision with root package name */
    protected List<d> f27076b = new ArrayList();

    public b(T t2) {
        this.f27075a = t2;
    }

    /* access modifiers changed from: protected */
    public float a(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f2 - f4), (double) (f3 - f5));
    }

    /* access modifiers changed from: protected */
    public float a(d dVar) {
        return dVar.d();
    }

    /* access modifiers changed from: protected */
    public float a(List<d> list, float f2, YAxis.AxisDependency axisDependency) {
        float f3 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar = list.get(i2);
            if (dVar.h() == axisDependency) {
                float abs = Math.abs(a(dVar) - f2);
                if (abs < f3) {
                    f3 = abs;
                }
            }
        }
        return f3;
    }

    /* access modifiers changed from: protected */
    public com.github.mikephil.charting.data.b a() {
        return this.f27075a.getData();
    }

    public d a(float f2, float f3) {
        d b2 = b(f2, f3);
        d.a(b2);
        return a((float) b2.f27218a, f2, f3);
    }

    /* access modifiers changed from: protected */
    public d a(float f2, float f3, float f4) {
        List<d> b2 = b(f2, f3, f4);
        if (b2.isEmpty()) {
            return null;
        }
        return a(b2, f3, f4, a(b2, f4, YAxis.AxisDependency.LEFT) < a(b2, f4, YAxis.AxisDependency.RIGHT) ? YAxis.AxisDependency.LEFT : YAxis.AxisDependency.RIGHT, this.f27075a.getMaxHighlightDistance());
    }

    public d a(List<d> list, float f2, float f3, YAxis.AxisDependency axisDependency, float f4) {
        d dVar = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            d dVar2 = list.get(i2);
            if (axisDependency == null || dVar2.h() == axisDependency) {
                float a2 = a(f2, f3, dVar2.c(), dVar2.d());
                if (a2 < f4) {
                    dVar = dVar2;
                    f4 = a2;
                }
            }
        }
        return dVar;
    }

    /* access modifiers changed from: protected */
    public List<d> a(e eVar, int i2, float f2, DataSet.Rounding rounding) {
        Entry a2;
        ArrayList arrayList = new ArrayList();
        List<Entry> a3 = eVar.a(f2);
        if (a3.size() == 0 && (a2 = eVar.a(f2, Float.NaN, rounding)) != null) {
            a3 = eVar.a(a2.i());
        }
        if (a3.size() == 0) {
            return arrayList;
        }
        for (Entry entry : a3) {
            d b2 = this.f27075a.a(eVar.t()).b(entry.i(), entry.b());
            arrayList.add(new d(entry.i(), entry.b(), (float) b2.f27218a, (float) b2.f27219b, i2, eVar.t()));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public d b(float f2, float f3) {
        return this.f27075a.a(YAxis.AxisDependency.LEFT).a(f2, f3);
    }

    /* access modifiers changed from: protected */
    public List<d> b(float f2, float f3, float f4) {
        this.f27076b.clear();
        com.github.mikephil.charting.data.b a2 = a();
        if (a2 == null) {
            return this.f27076b;
        }
        int c2 = a2.c();
        for (int i2 = 0; i2 < c2; i2++) {
            e a3 = a2.a(i2);
            if (a3.g()) {
                this.f27076b.addAll(a(a3, i2, f2, DataSet.Rounding.CLOSEST));
            }
        }
        return this.f27076b;
    }
}
