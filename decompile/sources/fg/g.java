package fg;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import fc.c;
import fc.d;
import fc.f;
import fc.k;

public class g {

    /* renamed from: a  reason: collision with root package name */
    protected Matrix f27233a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    protected Matrix f27234b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    protected j f27235c;

    /* renamed from: d  reason: collision with root package name */
    protected float[] f27236d = new float[1];

    /* renamed from: e  reason: collision with root package name */
    protected float[] f27237e = new float[1];

    /* renamed from: f  reason: collision with root package name */
    protected float[] f27238f = new float[1];

    /* renamed from: g  reason: collision with root package name */
    protected float[] f27239g = new float[1];

    /* renamed from: h  reason: collision with root package name */
    protected Matrix f27240h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    float[] f27241i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private Matrix f27242j = new Matrix();

    /* renamed from: k  reason: collision with root package name */
    private Matrix f27243k = new Matrix();

    public g(j jVar) {
        this.f27235c = jVar;
    }

    public Matrix a() {
        this.f27242j.set(this.f27233a);
        this.f27242j.postConcat(this.f27235c.f27257a);
        this.f27242j.postConcat(this.f27234b);
        return this.f27242j;
    }

    public d a(float f2, float f3) {
        d a2 = d.a(i.f27244a, i.f27244a);
        a(f2, f3, a2);
        return a2;
    }

    public void a(float f2, float f3, float f4, float f5) {
        float i2 = this.f27235c.i() / f3;
        float j2 = this.f27235c.j() / f4;
        if (Float.isInfinite(i2)) {
            i2 = 0.0f;
        }
        if (Float.isInfinite(j2)) {
            j2 = 0.0f;
        }
        this.f27233a.reset();
        this.f27233a.postTranslate(-f2, -f5);
        this.f27233a.postScale(i2, -j2);
    }

    public void a(float f2, float f3, d dVar) {
        float[] fArr = this.f27241i;
        fArr[0] = f2;
        fArr[1] = f3;
        b(fArr);
        dVar.f27218a = (double) this.f27241i[0];
        dVar.f27219b = (double) this.f27241i[1];
    }

    public void a(Path path) {
        path.transform(this.f27233a);
        path.transform(this.f27235c.p());
        path.transform(this.f27234b);
    }

    public void a(RectF rectF) {
        this.f27233a.mapRect(rectF);
        this.f27235c.p().mapRect(rectF);
        this.f27234b.mapRect(rectF);
    }

    public void a(RectF rectF, float f2) {
        rectF.top *= f2;
        rectF.bottom *= f2;
        this.f27233a.mapRect(rectF);
        this.f27235c.p().mapRect(rectF);
        this.f27234b.mapRect(rectF);
    }

    public void a(boolean z2) {
        this.f27234b.reset();
        if (!z2) {
            this.f27234b.postTranslate(this.f27235c.a(), this.f27235c.m() - this.f27235c.d());
            return;
        }
        this.f27234b.setTranslate(this.f27235c.a(), -this.f27235c.c());
        this.f27234b.postScale(1.0f, -1.0f);
    }

    public void a(float[] fArr) {
        this.f27233a.mapPoints(fArr);
        this.f27235c.p().mapPoints(fArr);
        this.f27234b.mapPoints(fArr);
    }

    public float[] a(c cVar, float f2, int i2, int i3) {
        int i4 = ((i3 - i2) + 1) * 2;
        if (this.f27237e.length != i4) {
            this.f27237e = new float[i4];
        }
        float[] fArr = this.f27237e;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry d2 = cVar.d((i5 / 2) + i2);
            if (d2 != null) {
                fArr[i5] = d2.i();
                fArr[i5 + 1] = d2.b() * f2;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }

    public float[] a(d dVar, float f2, float f3, int i2, int i3) {
        int i4 = ((int) ((((float) (i3 - i2)) * f2) + 1.0f)) * 2;
        if (this.f27239g.length != i4) {
            this.f27239g = new float[i4];
        }
        float[] fArr = this.f27239g;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            CandleEntry candleEntry = (CandleEntry) dVar.d((i5 / 2) + i2);
            if (candleEntry != null) {
                fArr[i5] = candleEntry.i();
                fArr[i5 + 1] = candleEntry.a() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }

    public float[] a(f fVar, float f2, float f3, int i2, int i3) {
        int i4 = (((int) (((float) (i3 - i2)) * f2)) + 1) * 2;
        if (this.f27238f.length != i4) {
            this.f27238f = new float[i4];
        }
        float[] fArr = this.f27238f;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry d2 = fVar.d((i5 / 2) + i2);
            if (d2 != null) {
                fArr[i5] = d2.i();
                fArr[i5 + 1] = d2.b() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }

    public float[] a(k kVar, float f2, float f3, int i2, int i3) {
        int i4 = ((int) ((((float) (i3 - i2)) * f2) + 1.0f)) * 2;
        if (this.f27236d.length != i4) {
            this.f27236d = new float[i4];
        }
        float[] fArr = this.f27236d;
        for (int i5 = 0; i5 < i4; i5 += 2) {
            Entry d2 = kVar.d((i5 / 2) + i2);
            if (d2 != null) {
                fArr[i5] = d2.i();
                fArr[i5 + 1] = d2.b() * f3;
            } else {
                fArr[i5] = 0.0f;
                fArr[i5 + 1] = 0.0f;
            }
        }
        a().mapPoints(fArr);
        return fArr;
    }

    public d b(float f2, float f3) {
        float[] fArr = this.f27241i;
        fArr[0] = f2;
        fArr[1] = f3;
        a(fArr);
        float[] fArr2 = this.f27241i;
        return d.a((double) fArr2[0], (double) fArr2[1]);
    }

    public void b(RectF rectF, float f2) {
        rectF.left *= f2;
        rectF.right *= f2;
        this.f27233a.mapRect(rectF);
        this.f27235c.p().mapRect(rectF);
        this.f27234b.mapRect(rectF);
    }

    public void b(float[] fArr) {
        Matrix matrix = this.f27240h;
        matrix.reset();
        this.f27234b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f27235c.p().invert(matrix);
        matrix.mapPoints(fArr);
        this.f27233a.invert(matrix);
        matrix.mapPoints(fArr);
    }
}
