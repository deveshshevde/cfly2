package fg;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

public class j {

    /* renamed from: a  reason: collision with root package name */
    protected final Matrix f27257a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    protected RectF f27258b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    protected float f27259c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    protected float f27260d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    protected float[] f27261e = new float[9];

    /* renamed from: f  reason: collision with root package name */
    protected Matrix f27262f = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    protected final float[] f27263g = new float[9];

    /* renamed from: h  reason: collision with root package name */
    private float f27264h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f27265i = Float.MAX_VALUE;

    /* renamed from: j  reason: collision with root package name */
    private float f27266j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f27267k = Float.MAX_VALUE;

    /* renamed from: l  reason: collision with root package name */
    private float f27268l = 1.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f27269m = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f27270n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f27271o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    private float f27272p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    private float f27273q = 0.0f;

    public float a() {
        return this.f27258b.left;
    }

    public Matrix a(Matrix matrix, View view, boolean z2) {
        this.f27257a.set(matrix);
        a(this.f27257a, this.f27258b);
        if (z2) {
            view.invalidate();
        }
        matrix.set(this.f27257a);
        return matrix;
    }

    public void a(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        this.f27266j = f2;
        a(this.f27257a, this.f27258b);
    }

    public void a(float f2, float f3) {
        float a2 = a();
        float c2 = c();
        float b2 = b();
        float d2 = d();
        this.f27260d = f3;
        this.f27259c = f2;
        a(a2, c2, b2, d2);
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f27258b.set(f2, f3, this.f27259c - f4, this.f27260d - f5);
    }

    public void a(float f2, float f3, float f4, float f5, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f27257a);
        matrix.postScale(f2, f3, f4, f5);
    }

    public void a(Matrix matrix, RectF rectF) {
        float f2;
        matrix.getValues(this.f27263g);
        float[] fArr = this.f27263g;
        float f3 = fArr[2];
        float f4 = fArr[0];
        float f5 = fArr[5];
        float f6 = fArr[4];
        this.f27268l = Math.min(Math.max(this.f27266j, f4), this.f27267k);
        this.f27269m = Math.min(Math.max(this.f27264h, f6), this.f27265i);
        float f7 = 0.0f;
        if (rectF != null) {
            f7 = rectF.width();
            f2 = rectF.height();
        } else {
            f2 = 0.0f;
        }
        this.f27270n = Math.min(Math.max(f3, ((-f7) * (this.f27268l - 1.0f)) - this.f27272p), this.f27272p);
        float max = Math.max(Math.min(f5, (f2 * (this.f27269m - 1.0f)) + this.f27273q), -this.f27273q);
        this.f27271o = max;
        float[] fArr2 = this.f27263g;
        fArr2[2] = this.f27270n;
        fArr2[0] = this.f27268l;
        fArr2[5] = max;
        fArr2[4] = this.f27269m;
        matrix.setValues(fArr2);
    }

    public void a(float[] fArr, View view) {
        Matrix matrix = this.f27262f;
        matrix.reset();
        matrix.set(this.f27257a);
        matrix.postTranslate(-(fArr[0] - a()), -(fArr[1] - c()));
        a(matrix, view, true);
    }

    public float b() {
        return this.f27259c - this.f27258b.right;
    }

    public void b(float f2) {
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f27267k = f2;
        a(this.f27257a, this.f27258b);
    }

    public boolean b(float f2, float f3) {
        return e(f2) && f(f3);
    }

    public float c() {
        return this.f27258b.top;
    }

    public void c(float f2) {
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        this.f27264h = f2;
        a(this.f27257a, this.f27258b);
    }

    public float d() {
        return this.f27260d - this.f27258b.bottom;
    }

    public void d(float f2) {
        if (f2 == 0.0f) {
            f2 = Float.MAX_VALUE;
        }
        this.f27265i = f2;
        a(this.f27257a, this.f27258b);
    }

    public float e() {
        return this.f27258b.top;
    }

    public boolean e(float f2) {
        return g(f2) && h(f2);
    }

    public float f() {
        return this.f27258b.left;
    }

    public boolean f(float f2) {
        return i(f2) && j(f2);
    }

    public float g() {
        return this.f27258b.right;
    }

    public boolean g(float f2) {
        return this.f27258b.left <= f2 + 1.0f;
    }

    public float h() {
        return this.f27258b.bottom;
    }

    public boolean h(float f2) {
        return this.f27258b.right >= (((float) ((int) (f2 * 100.0f))) / 100.0f) - 1.0f;
    }

    public float i() {
        return this.f27258b.width();
    }

    public boolean i(float f2) {
        return this.f27258b.top <= f2;
    }

    public float j() {
        return this.f27258b.height();
    }

    public boolean j(float f2) {
        return this.f27258b.bottom >= ((float) ((int) (f2 * 100.0f))) / 100.0f;
    }

    public RectF k() {
        return this.f27258b;
    }

    public void k(float f2) {
        this.f27272p = i.a(f2);
    }

    public e l() {
        return e.a(this.f27258b.centerX(), this.f27258b.centerY());
    }

    public void l(float f2) {
        this.f27273q = i.a(f2);
    }

    public float m() {
        return this.f27260d;
    }

    public float n() {
        return this.f27259c;
    }

    public float o() {
        return Math.min(this.f27258b.width(), this.f27258b.height());
    }

    public Matrix p() {
        return this.f27257a;
    }

    public float q() {
        return this.f27268l;
    }

    public float r() {
        return this.f27269m;
    }

    public boolean s() {
        return u() && t();
    }

    public boolean t() {
        float f2 = this.f27269m;
        float f3 = this.f27264h;
        return f2 <= f3 && f3 <= 1.0f;
    }

    public boolean u() {
        float f2 = this.f27268l;
        float f3 = this.f27266j;
        return f2 <= f3 && f3 <= 1.0f;
    }

    public boolean v() {
        return this.f27272p <= 0.0f && this.f27273q <= 0.0f;
    }

    public boolean w() {
        return this.f27268l > this.f27266j;
    }

    public boolean x() {
        return this.f27268l < this.f27267k;
    }

    public boolean y() {
        return this.f27269m > this.f27264h;
    }

    public boolean z() {
        return this.f27269m < this.f27265i;
    }
}
