package net.lucode.hackware.magicindicator;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private SparseBooleanArray f31421a = new SparseBooleanArray();

    /* renamed from: b  reason: collision with root package name */
    private SparseArray<Float> f31422b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private int f31423c;

    /* renamed from: d  reason: collision with root package name */
    private int f31424d;

    /* renamed from: e  reason: collision with root package name */
    private int f31425e;

    /* renamed from: f  reason: collision with root package name */
    private float f31426f;

    /* renamed from: g  reason: collision with root package name */
    private int f31427g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f31428h;

    /* renamed from: i  reason: collision with root package name */
    private a f31429i;

    public interface a {
        void a(int i2, int i3);

        void a(int i2, int i3, float f2, boolean z2);

        void b(int i2, int i3);

        void b(int i2, int i3, float f2, boolean z2);
    }

    private void a(int i2, float f2, boolean z2, boolean z3) {
        if (this.f31428h || i2 == this.f31424d || this.f31427g == 1 || z3) {
            a aVar = this.f31429i;
            if (aVar != null) {
                aVar.a(i2, this.f31423c, f2, z2);
            }
            this.f31422b.put(i2, Float.valueOf(1.0f - f2));
        }
    }

    private void b(int i2, float f2, boolean z2, boolean z3) {
        if (!(this.f31428h || i2 == this.f31425e || this.f31427g == 1)) {
            int i3 = this.f31424d;
            if ((!(i2 == i3 - 1 || i2 == i3 + 1) || this.f31422b.get(i2, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z3) {
                return;
            }
        }
        a aVar = this.f31429i;
        if (aVar != null) {
            aVar.b(i2, this.f31423c, f2, z2);
        }
        this.f31422b.put(i2, Float.valueOf(f2));
    }

    private void d(int i2) {
        a aVar = this.f31429i;
        if (aVar != null) {
            aVar.a(i2, this.f31423c);
        }
        this.f31421a.put(i2, false);
    }

    private void e(int i2) {
        a aVar = this.f31429i;
        if (aVar != null) {
            aVar.b(i2, this.f31423c);
        }
        this.f31421a.put(i2, true);
    }

    public int a() {
        return this.f31423c;
    }

    public void a(int i2) {
        this.f31425e = this.f31424d;
        this.f31424d = i2;
        d(i2);
        for (int i3 = 0; i3 < this.f31423c; i3++) {
            if (i3 != this.f31424d && !this.f31421a.get(i3)) {
                e(i3);
            }
        }
    }

    public void a(int i2, float f2, int i3) {
        boolean z2;
        float f3 = ((float) i2) + f2;
        float f4 = this.f31426f;
        boolean z3 = f4 <= f3;
        if (this.f31427g == 0) {
            for (int i4 = 0; i4 < this.f31423c; i4++) {
                if (i4 != this.f31424d) {
                    if (!this.f31421a.get(i4)) {
                        e(i4);
                    }
                    if (this.f31422b.get(i4, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        b(i4, 1.0f, false, true);
                    }
                }
            }
            a(this.f31424d, 1.0f, false, true);
            d(this.f31424d);
        } else if (f3 != f4) {
            int i5 = i2 + 1;
            if (f2 != 0.0f || !z3) {
                z2 = true;
            } else {
                i5 = i2 - 1;
                z2 = false;
            }
            for (int i6 = 0; i6 < this.f31423c; i6++) {
                if (!(i6 == i2 || i6 == i5 || this.f31422b.get(i6, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                    b(i6, 1.0f, z3, true);
                }
            }
            if (!z2) {
                float f5 = 1.0f - f2;
                b(i5, f5, true, false);
                a(i2, f5, true, false);
            } else if (z3) {
                b(i2, f2, true, false);
                a(i5, f2, true, false);
            } else {
                float f6 = 1.0f - f2;
                b(i5, f6, false, false);
                a(i2, f6, false, false);
            }
        } else {
            return;
        }
        this.f31426f = f3;
    }

    public void a(a aVar) {
        this.f31429i = aVar;
    }

    public void a(boolean z2) {
        this.f31428h = z2;
    }

    public int b() {
        return this.f31424d;
    }

    public void b(int i2) {
        this.f31427g = i2;
    }

    public int c() {
        return this.f31427g;
    }

    public void c(int i2) {
        this.f31423c = i2;
        this.f31421a.clear();
        this.f31422b.clear();
    }
}
