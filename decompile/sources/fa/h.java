package fa;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

public abstract class h<T extends PieRadarChartBase> implements f {

    /* renamed from: a  reason: collision with root package name */
    protected T f27088a;

    /* renamed from: b  reason: collision with root package name */
    protected List<d> f27089b = new ArrayList();

    public h(T t2) {
        this.f27088a = t2;
    }

    public d a(float f2, float f3) {
        if (this.f27088a.d(f2, f3) > this.f27088a.getRadius()) {
            return null;
        }
        float b2 = this.f27088a.b(f2, f3);
        T t2 = this.f27088a;
        if (t2 instanceof PieChart) {
            b2 /= t2.getAnimator().a();
        }
        int a2 = this.f27088a.a(b2);
        if (a2 < 0 || a2 >= this.f27088a.getData().j().u()) {
            return null;
        }
        return a(a2, f2, f3);
    }

    /* access modifiers changed from: protected */
    public abstract d a(int i2, float f2, float f3);
}
