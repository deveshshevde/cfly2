package fe;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import fb.b;
import fc.e;
import fg.j;

public abstract class c extends g {

    /* renamed from: f  reason: collision with root package name */
    protected a f27106f = new a();

    protected class a {

        /* renamed from: a  reason: collision with root package name */
        public int f27107a;

        /* renamed from: b  reason: collision with root package name */
        public int f27108b;

        /* renamed from: c  reason: collision with root package name */
        public int f27109c;

        protected a() {
        }

        public void a(b bVar, fc.b bVar2) {
            float max = Math.max(0.0f, Math.min(1.0f, c.this.f27125g.b()));
            float lowestVisibleX = bVar.getLowestVisibleX();
            float highestVisibleX = bVar.getHighestVisibleX();
            Entry a2 = bVar2.a(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            Entry a3 = bVar2.a(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            int i2 = 0;
            this.f27107a = a2 == null ? 0 : bVar2.b(a2);
            if (a3 != null) {
                i2 = bVar2.b(a3);
            }
            this.f27108b = i2;
            this.f27109c = (int) (((float) (i2 - this.f27107a)) * max);
        }
    }

    public c(ex.a aVar, j jVar) {
        super(aVar, jVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(Entry entry, fc.b bVar) {
        if (entry == null) {
            return false;
        }
        return entry != null && ((float) bVar.b(entry)) < ((float) bVar.u()) * this.f27125g.b();
    }

    /* access modifiers changed from: protected */
    public boolean a(e eVar) {
        return eVar.s() && (eVar.p() || eVar.q());
    }
}
