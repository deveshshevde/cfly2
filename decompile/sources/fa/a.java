package fa;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.b;
import fg.d;

public class a extends b<fb.a> {
    public a(fb.a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public float a(float f2, float f3, float f4, float f5) {
        return Math.abs(f2 - f4);
    }

    /* access modifiers changed from: protected */
    public int a(j[] jVarArr, float f2) {
        if (jVarArr == null || jVarArr.length == 0) {
            return 0;
        }
        int i2 = 0;
        for (j a2 : jVarArr) {
            if (a2.a(f2)) {
                return i2;
            }
            i2++;
        }
        int max = Math.max(jVarArr.length - 1, 0);
        if (f2 > jVarArr[max].f27091b) {
            return max;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public b a() {
        return ((fb.a) this.f27075a).getBarData();
    }

    public d a(float f2, float f3) {
        d a2 = super.a(f2, f3);
        if (a2 == null) {
            return null;
        }
        d b2 = b(f2, f3);
        fc.a aVar = (fc.a) ((fb.a) this.f27075a).getBarData().a(a2.f());
        if (aVar.v()) {
            return a(a2, aVar, (float) b2.f27218a, (float) b2.f27219b);
        }
        d.a(b2);
        return a2;
    }

    public d a(d dVar, fc.a aVar, float f2, float f3) {
        BarEntry barEntry = (BarEntry) aVar.b(f2, f3);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.a() == null) {
            return dVar;
        }
        j[] c2 = barEntry.c();
        if (c2.length <= 0) {
            return null;
        }
        int a2 = a(c2, f3);
        d b2 = ((fb.a) this.f27075a).a(aVar.t()).b(dVar.a(), c2[a2].f27091b);
        d dVar2 = new d(barEntry.i(), barEntry.b(), (float) b2.f27218a, (float) b2.f27219b, dVar.f(), a2, dVar.h());
        d.a(b2);
        return dVar2;
    }
}
