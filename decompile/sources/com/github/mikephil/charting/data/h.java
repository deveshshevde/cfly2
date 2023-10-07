package com.github.mikephil.charting.data;

import com.github.mikephil.charting.components.YAxis;
import fa.d;
import fc.e;
import java.util.ArrayList;
import java.util.List;

public abstract class h<T extends e<? extends Entry>> {

    /* renamed from: a  reason: collision with root package name */
    protected float f15019a = -3.4028235E38f;

    /* renamed from: b  reason: collision with root package name */
    protected float f15020b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    protected float f15021c = -3.4028235E38f;

    /* renamed from: d  reason: collision with root package name */
    protected float f15022d = Float.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    protected float f15023e = -3.4028235E38f;

    /* renamed from: f  reason: collision with root package name */
    protected float f15024f = Float.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    protected float f15025g = -3.4028235E38f;

    /* renamed from: h  reason: collision with root package name */
    protected float f15026h = Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    protected List<T> f15027i = new ArrayList();

    public float a(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f2 = this.f15024f;
            return f2 == Float.MAX_VALUE ? this.f15026h : f2;
        }
        float f3 = this.f15026h;
        return f3 == Float.MAX_VALUE ? this.f15024f : f3;
    }

    public Entry a(d dVar) {
        if (dVar.f() >= this.f15027i.size()) {
            return null;
        }
        return ((e) this.f15027i.get(dVar.f())).b(dVar.a(), dVar.b());
    }

    public T a(int i2) {
        List<T> list = this.f15027i;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return (e) this.f15027i.get(i2);
    }

    /* access modifiers changed from: protected */
    public T a(List<T> list) {
        for (T t2 : list) {
            if (t2.t() == YAxis.AxisDependency.LEFT) {
                return t2;
            }
        }
        return null;
    }

    public void a(float f2, float f3) {
        for (T a2 : this.f15027i) {
            a2.a(f2, f3);
        }
        b();
    }

    /* access modifiers changed from: protected */
    public void a(T t2) {
        if (this.f15019a < t2.x()) {
            this.f15019a = t2.x();
        }
        if (this.f15020b > t2.w()) {
            this.f15020b = t2.w();
        }
        if (this.f15021c < t2.z()) {
            this.f15021c = t2.z();
        }
        if (this.f15022d > t2.y()) {
            this.f15022d = t2.y();
        }
        if (t2.t() == YAxis.AxisDependency.LEFT) {
            if (this.f15023e < t2.x()) {
                this.f15023e = t2.x();
            }
            if (this.f15024f > t2.w()) {
                this.f15024f = t2.w();
                return;
            }
            return;
        }
        if (this.f15025g < t2.x()) {
            this.f15025g = t2.x();
        }
        if (this.f15026h > t2.w()) {
            this.f15026h = t2.w();
        }
    }

    public float b(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f2 = this.f15023e;
            return f2 == -3.4028235E38f ? this.f15025g : f2;
        }
        float f3 = this.f15025g;
        return f3 == -3.4028235E38f ? this.f15023e : f3;
    }

    public T b(List<T> list) {
        for (T t2 : list) {
            if (t2.t() == YAxis.AxisDependency.RIGHT) {
                return t2;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void b() {
        List<T> list = this.f15027i;
        if (list != null) {
            this.f15019a = -3.4028235E38f;
            this.f15020b = Float.MAX_VALUE;
            this.f15021c = -3.4028235E38f;
            this.f15022d = Float.MAX_VALUE;
            for (T a2 : list) {
                a(a2);
            }
            this.f15023e = -3.4028235E38f;
            this.f15024f = Float.MAX_VALUE;
            this.f15025g = -3.4028235E38f;
            this.f15026h = Float.MAX_VALUE;
            e a3 = a(this.f15027i);
            if (a3 != null) {
                this.f15023e = a3.x();
                this.f15024f = a3.w();
                for (T t2 : this.f15027i) {
                    if (t2.t() == YAxis.AxisDependency.LEFT) {
                        if (t2.w() < this.f15024f) {
                            this.f15024f = t2.w();
                        }
                        if (t2.x() > this.f15023e) {
                            this.f15023e = t2.x();
                        }
                    }
                }
            }
            e b2 = b(this.f15027i);
            if (b2 != null) {
                this.f15025g = b2.x();
                this.f15026h = b2.w();
                for (T t3 : this.f15027i) {
                    if (t3.t() == YAxis.AxisDependency.RIGHT) {
                        if (t3.w() < this.f15026h) {
                            this.f15026h = t3.w();
                        }
                        if (t3.x() > this.f15025g) {
                            this.f15025g = t3.x();
                        }
                    }
                }
            }
        }
    }

    public int c() {
        List<T> list = this.f15027i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public float d() {
        return this.f15020b;
    }

    public float e() {
        return this.f15019a;
    }

    public float f() {
        return this.f15022d;
    }

    public float g() {
        return this.f15021c;
    }

    public List<T> h() {
        return this.f15027i;
    }

    public int i() {
        int i2 = 0;
        for (T u2 : this.f15027i) {
            i2 += u2.u();
        }
        return i2;
    }

    public T j() {
        List<T> list = this.f15027i;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t2 = (e) this.f15027i.get(0);
        for (T t3 : this.f15027i) {
            if (t3.u() > t2.u()) {
                t2 = t3;
            }
        }
        return t2;
    }
}
