package gw;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final o[] f13218a = new o[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f13219b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f13220c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f13221d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f13222e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f13223f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final o f13224g = new o();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f13225h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f13226i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f13227j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f13228k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f13229l = true;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final n f13230a = new n();
    }

    public interface b {
        void a(o oVar, Matrix matrix, int i2);

        void b(o oVar, Matrix matrix, int i2);
    }

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final m f13231a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f13232b;

        /* renamed from: c  reason: collision with root package name */
        public final RectF f13233c;

        /* renamed from: d  reason: collision with root package name */
        public final b f13234d;

        /* renamed from: e  reason: collision with root package name */
        public final float f13235e;

        c(m mVar, float f2, RectF rectF, b bVar, Path path) {
            this.f13234d = bVar;
            this.f13231a = mVar;
            this.f13235e = f2;
            this.f13233c = rectF;
            this.f13232b = path;
        }
    }

    public n() {
        for (int i2 = 0; i2 < 4; i2++) {
            this.f13218a[i2] = new o();
            this.f13219b[i2] = new Matrix();
            this.f13220c[i2] = new Matrix();
        }
    }

    private float a(RectF rectF, int i2) {
        float centerX;
        float f2;
        this.f13225h[0] = this.f13218a[i2].f13238c;
        this.f13225h[1] = this.f13218a[i2].f13239d;
        this.f13219b[i2].mapPoints(this.f13225h);
        if (i2 == 1 || i2 == 3) {
            centerX = rectF.centerX();
            f2 = this.f13225h[0];
        } else {
            centerX = rectF.centerY();
            f2 = this.f13225h[1];
        }
        return Math.abs(centerX - f2);
    }

    private d a(int i2, m mVar) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? mVar.c() : mVar.b() : mVar.e() : mVar.d();
    }

    public static n a() {
        return a.f13230a;
    }

    private void a(int i2) {
        this.f13225h[0] = this.f13218a[i2].d();
        this.f13225h[1] = this.f13218a[i2].e();
        this.f13219b[i2].mapPoints(this.f13225h);
        float b2 = b(i2);
        this.f13220c[i2].reset();
        Matrix matrix = this.f13220c[i2];
        float[] fArr = this.f13225h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f13220c[i2].preRotate(b2);
    }

    private void a(int i2, RectF rectF, PointF pointF) {
        float f2;
        float f3;
        float f4;
        if (i2 == 1) {
            f4 = rectF.right;
            f3 = rectF.bottom;
        } else if (i2 != 2) {
            f2 = i2 != 3 ? rectF.right : rectF.left;
            f3 = rectF.top;
        } else {
            f4 = rectF.left;
            f3 = rectF.bottom;
        }
        pointF.set(f2, f3);
    }

    private void a(c cVar, int i2) {
        a(i2, cVar.f13231a).a(this.f13218a[i2], 90.0f, cVar.f13235e, cVar.f13233c, b(i2, cVar.f13231a));
        float b2 = b(i2);
        this.f13219b[i2].reset();
        a(i2, cVar.f13233c, this.f13221d);
        this.f13219b[i2].setTranslate(this.f13221d.x, this.f13221d.y);
        this.f13219b[i2].preRotate(b2);
    }

    private boolean a(Path path, int i2) {
        this.f13228k.reset();
        this.f13218a[i2].a(this.f13219b[i2], this.f13228k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f13228k.computeBounds(rectF, true);
        path.op(this.f13228k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    private float b(int i2) {
        return (float) ((i2 + 1) * 90);
    }

    private c b(int i2, m mVar) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? mVar.g() : mVar.f() : mVar.i() : mVar.h();
    }

    private void b(c cVar, int i2) {
        this.f13225h[0] = this.f13218a[i2].b();
        this.f13225h[1] = this.f13218a[i2].c();
        this.f13219b[i2].mapPoints(this.f13225h);
        Path path = cVar.f13232b;
        float[] fArr = this.f13225h;
        if (i2 == 0) {
            path.moveTo(fArr[0], fArr[1]);
        } else {
            path.lineTo(fArr[0], fArr[1]);
        }
        this.f13218a[i2].a(this.f13219b[i2], cVar.f13232b);
        if (cVar.f13234d != null) {
            cVar.f13234d.a(this.f13218a[i2], this.f13219b[i2], i2);
        }
    }

    private f c(int i2, m mVar) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? mVar.l() : mVar.k() : mVar.j() : mVar.m();
    }

    private void c(c cVar, int i2) {
        Path path;
        Matrix matrix;
        o oVar;
        int i3 = (i2 + 1) % 4;
        this.f13225h[0] = this.f13218a[i2].d();
        this.f13225h[1] = this.f13218a[i2].e();
        this.f13219b[i2].mapPoints(this.f13225h);
        this.f13226i[0] = this.f13218a[i3].b();
        this.f13226i[1] = this.f13218a[i3].c();
        this.f13219b[i3].mapPoints(this.f13226i);
        float[] fArr = this.f13225h;
        float f2 = fArr[0];
        float[] fArr2 = this.f13226i;
        float max = Math.max(((float) Math.hypot((double) (f2 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float a2 = a(cVar.f13233c, i2);
        this.f13224g.a(0.0f, 0.0f);
        f c2 = c(i2, cVar.f13231a);
        c2.a(max, a2, cVar.f13235e, this.f13224g);
        this.f13227j.reset();
        this.f13224g.a(this.f13220c[i2], this.f13227j);
        if (!this.f13229l || Build.VERSION.SDK_INT < 19 || (!c2.g() && !a(this.f13227j, i2) && !a(this.f13227j, i3))) {
            oVar = this.f13224g;
            matrix = this.f13220c[i2];
            path = cVar.f13232b;
        } else {
            Path path2 = this.f13227j;
            path2.op(path2, this.f13223f, Path.Op.DIFFERENCE);
            this.f13225h[0] = this.f13224g.b();
            this.f13225h[1] = this.f13224g.c();
            this.f13220c[i2].mapPoints(this.f13225h);
            Path path3 = this.f13222e;
            float[] fArr3 = this.f13225h;
            path3.moveTo(fArr3[0], fArr3[1]);
            oVar = this.f13224g;
            matrix = this.f13220c[i2];
            path = this.f13222e;
        }
        oVar.a(matrix, path);
        if (cVar.f13234d != null) {
            cVar.f13234d.b(this.f13224g, this.f13220c[i2], i2);
        }
    }

    public void a(m mVar, float f2, RectF rectF, Path path) {
        a(mVar, f2, rectF, (b) null, path);
    }

    public void a(m mVar, float f2, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f13222e.rewind();
        this.f13223f.rewind();
        this.f13223f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(mVar, f2, rectF, bVar, path);
        for (int i2 = 0; i2 < 4; i2++) {
            a(cVar, i2);
            a(i2);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            b(cVar, i3);
            c(cVar, i3);
        }
        path.close();
        this.f13222e.close();
        if (Build.VERSION.SDK_INT >= 19 && !this.f13222e.isEmpty()) {
            path.op(this.f13222e, Path.Op.UNION);
        }
    }
}
