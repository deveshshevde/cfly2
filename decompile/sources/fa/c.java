package fa;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.b;
import com.github.mikephil.charting.data.h;
import fb.a;
import fb.f;
import fc.e;
import java.util.List;

public class c extends b<f> implements f {

    /* renamed from: c  reason: collision with root package name */
    protected a f27077c;

    public c(f fVar, a aVar) {
        super(fVar);
        this.f27077c = aVar.getBarData() == null ? null : new a(aVar);
    }

    /* access modifiers changed from: protected */
    public List<d> b(float f2, float f3, float f4) {
        this.f27076b.clear();
        List<b> o2 = ((f) this.f27075a).getCombinedData().o();
        for (int i2 = 0; i2 < o2.size(); i2++) {
            h hVar = o2.get(i2);
            a aVar = this.f27077c;
            if (aVar == null || !(hVar instanceof com.github.mikephil.charting.data.a)) {
                int c2 = hVar.c();
                for (int i3 = 0; i3 < c2; i3++) {
                    e a2 = o2.get(i2).a(i3);
                    if (a2.g()) {
                        for (d next : a(a2, i3, f2, DataSet.Rounding.CLOSEST)) {
                            next.a(i2);
                            this.f27076b.add(next);
                        }
                    }
                }
            } else {
                d a3 = aVar.a(f3, f4);
                if (a3 != null) {
                    a3.a(i2);
                    this.f27076b.add(a3);
                }
            }
        }
        return this.f27076b;
    }
}
