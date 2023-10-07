package fc;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import ez.d;
import fd.a;
import java.util.List;

public interface e<T extends Entry> {
    int a(int i2);

    T a(float f2, float f3, DataSet.Rounding rounding);

    List<T> a(float f2);

    void a(float f2, float f3);

    void a(d dVar);

    int b(T t2);

    T b(float f2, float f3);

    a b(int i2);

    List<Integer> b();

    int c();

    int c(int i2);

    T d(int i2);

    a d();

    List<a> e();

    String f();

    boolean g();

    d h();

    boolean i();

    Typeface j();

    float k();

    Legend.LegendForm l();

    float m();

    float n();

    DashPathEffect o();

    boolean p();

    boolean q();

    fg.e r();

    boolean s();

    YAxis.AxisDependency t();

    int u();

    float w();

    float x();

    float y();

    float z();
}
