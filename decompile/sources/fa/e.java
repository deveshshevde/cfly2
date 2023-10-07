package fa;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import fb.a;
import fg.d;
import java.util.ArrayList;
import java.util.List;

public class e extends a {
    public e(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public float a(float f2, float f3, float f4, float f5) {
        return Math.abs(f3 - f5);
    }

    public d a(float f2, float f3) {
        com.github.mikephil.charting.data.a barData = ((a) this.f27075a).getBarData();
        d b2 = b(f3, f2);
        d a2 = a((float) b2.f27219b, f3, f2);
        if (a2 == null) {
            return null;
        }
        fc.a aVar = (fc.a) barData.a(a2.f());
        if (aVar.v()) {
            return a(a2, aVar, (float) b2.f27219b, (float) b2.f27218a);
        }
        d.a(b2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public List<d> a(fc.e eVar, int i2, float f2, DataSet.Rounding rounding) {
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
            d b2 = ((a) this.f27075a).a(eVar.t()).b(entry.b(), entry.i());
            arrayList.add(new d(entry.i(), entry.b(), (float) b2.f27218a, (float) b2.f27219b, i2, eVar.t()));
        }
        return arrayList;
    }
}
