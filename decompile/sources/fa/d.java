package fa;

import com.github.mikephil.charting.components.YAxis;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private float f27078a;

    /* renamed from: b  reason: collision with root package name */
    private float f27079b;

    /* renamed from: c  reason: collision with root package name */
    private float f27080c;

    /* renamed from: d  reason: collision with root package name */
    private float f27081d;

    /* renamed from: e  reason: collision with root package name */
    private int f27082e;

    /* renamed from: f  reason: collision with root package name */
    private int f27083f;

    /* renamed from: g  reason: collision with root package name */
    private int f27084g;

    /* renamed from: h  reason: collision with root package name */
    private YAxis.AxisDependency f27085h;

    /* renamed from: i  reason: collision with root package name */
    private float f27086i;

    /* renamed from: j  reason: collision with root package name */
    private float f27087j;

    public d(float f2, float f3, float f4, float f5, int i2, int i3, YAxis.AxisDependency axisDependency) {
        this(f2, f3, f4, f5, i2, axisDependency);
        this.f27084g = i3;
    }

    public d(float f2, float f3, float f4, float f5, int i2, YAxis.AxisDependency axisDependency) {
        this.f27078a = Float.NaN;
        this.f27079b = Float.NaN;
        this.f27082e = -1;
        this.f27084g = -1;
        this.f27078a = f2;
        this.f27079b = f3;
        this.f27080c = f4;
        this.f27081d = f5;
        this.f27083f = i2;
        this.f27085h = axisDependency;
    }

    public float a() {
        return this.f27078a;
    }

    public void a(float f2, float f3) {
        this.f27086i = f2;
        this.f27087j = f3;
    }

    public void a(int i2) {
        this.f27082e = i2;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f27083f == dVar.f27083f && this.f27078a == dVar.f27078a && this.f27084g == dVar.f27084g && this.f27082e == dVar.f27082e;
    }

    public float b() {
        return this.f27079b;
    }

    public float c() {
        return this.f27080c;
    }

    public float d() {
        return this.f27081d;
    }

    public int e() {
        return this.f27082e;
    }

    public int f() {
        return this.f27083f;
    }

    public int g() {
        return this.f27084g;
    }

    public YAxis.AxisDependency h() {
        return this.f27085h;
    }

    public float i() {
        return this.f27086i;
    }

    public float j() {
        return this.f27087j;
    }

    public String toString() {
        return "Highlight, x: " + this.f27078a + ", y: " + this.f27079b + ", dataSetIndex: " + this.f27083f + ", stackIndex (only stacked barentry): " + this.f27084g;
    }
}
