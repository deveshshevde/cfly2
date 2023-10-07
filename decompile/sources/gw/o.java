package gw;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

public class o {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f13236a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f13237b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f13238c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f13239d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f13240e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f13241f;

    /* renamed from: g  reason: collision with root package name */
    private final List<e> f13242g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<f> f13243h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f13244i;

    static class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final c f13248a;

        public a(c cVar) {
            this.f13248a = cVar;
        }

        public void a(Matrix matrix, gv.a aVar, int i2, Canvas canvas) {
            float a2 = this.f13248a.e();
            float b2 = this.f13248a.f();
            aVar.a(canvas, matrix, new RectF(this.f13248a.a(), this.f13248a.b(), this.f13248a.c(), this.f13248a.d()), i2, a2, b2);
        }
    }

    static class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private final d f13249a;

        /* renamed from: b  reason: collision with root package name */
        private final float f13250b;

        /* renamed from: c  reason: collision with root package name */
        private final float f13251c;

        public b(d dVar, float f2, float f3) {
            this.f13249a = dVar;
            this.f13250b = f2;
            this.f13251c = f3;
        }

        /* access modifiers changed from: package-private */
        public float a() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f13249a.f13260b - this.f13251c) / (this.f13249a.f13259a - this.f13250b))));
        }

        public void a(Matrix matrix, gv.a aVar, int i2, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.f13249a.f13260b - this.f13251c), (double) (this.f13249a.f13259a - this.f13250b)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f13250b, this.f13251c);
            matrix2.preRotate(a());
            aVar.a(canvas, matrix2, rectF, i2);
        }
    }

    public static class c extends e {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f13252h = new RectF();
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public float f13253a;
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f13254b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f13255c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f13256d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f13257e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f13258f;

        public c(float f2, float f3, float f4, float f5) {
            a(f2);
            b(f3);
            c(f4);
            d(f5);
        }

        /* access modifiers changed from: private */
        public float a() {
            return this.f13253a;
        }

        private void a(float f2) {
            this.f13253a = f2;
        }

        /* access modifiers changed from: private */
        public float b() {
            return this.f13254b;
        }

        private void b(float f2) {
            this.f13254b = f2;
        }

        /* access modifiers changed from: private */
        public float c() {
            return this.f13255c;
        }

        private void c(float f2) {
            this.f13255c = f2;
        }

        /* access modifiers changed from: private */
        public float d() {
            return this.f13256d;
        }

        private void d(float f2) {
            this.f13256d = f2;
        }

        /* access modifiers changed from: private */
        public float e() {
            return this.f13257e;
        }

        /* access modifiers changed from: private */
        public void e(float f2) {
            this.f13257e = f2;
        }

        /* access modifiers changed from: private */
        public float f() {
            return this.f13258f;
        }

        /* access modifiers changed from: private */
        public void f(float f2) {
            this.f13258f = f2;
        }

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f13261g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f13252h;
            rectF.set(a(), b(), c(), d());
            path.arcTo(rectF, e(), f(), false);
            path.transform(matrix);
        }
    }

    public static class d extends e {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public float f13259a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f13260b;

        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f13261g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f13259a, this.f13260b);
            path.transform(matrix);
        }
    }

    public static abstract class e {

        /* renamed from: g  reason: collision with root package name */
        protected final Matrix f13261g = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class f {

        /* renamed from: d  reason: collision with root package name */
        static final Matrix f13262d = new Matrix();

        f() {
        }

        public abstract void a(Matrix matrix, gv.a aVar, int i2, Canvas canvas);

        public final void a(gv.a aVar, int i2, Canvas canvas) {
            a(f13262d, aVar, i2, canvas);
        }
    }

    public o() {
        a(0.0f, 0.0f);
    }

    private void a(float f2) {
        if (f() != f2) {
            float f3 = ((f2 - f()) + 360.0f) % 360.0f;
            if (f3 <= 180.0f) {
                c cVar = new c(d(), e(), d(), e());
                cVar.e(f());
                cVar.f(f3);
                this.f13243h.add(new a(cVar));
                f(f2);
            }
        }
    }

    private void a(f fVar, float f2, float f3) {
        a(f2);
        this.f13243h.add(fVar);
        f(f3);
    }

    private void b(float f2) {
        this.f13236a = f2;
    }

    private void c(float f2) {
        this.f13237b = f2;
    }

    private void d(float f2) {
        this.f13238c = f2;
    }

    private void e(float f2) {
        this.f13239d = f2;
    }

    private float f() {
        return this.f13240e;
    }

    private void f(float f2) {
        this.f13240e = f2;
    }

    private float g() {
        return this.f13241f;
    }

    private void g(float f2) {
        this.f13241f = f2;
    }

    /* access modifiers changed from: package-private */
    public f a(Matrix matrix) {
        a(g());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.f13243h);
        return new f() {
            public void a(Matrix matrix, gv.a aVar, int i2, Canvas canvas) {
                for (f a2 : arrayList) {
                    a2.a(matrix2, aVar, i2, canvas);
                }
            }
        };
    }

    public void a(float f2, float f3) {
        a(f2, f3, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5) {
        b(f2);
        c(f3);
        d(f2);
        e(f3);
        f(f4);
        g((f4 + f5) % 360.0f);
        this.f13242g.clear();
        this.f13243h.clear();
        this.f13244i = false;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.e(f6);
        cVar.f(f7);
        this.f13242g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z2 = f7 < 0.0f;
        if (z2) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        a(aVar, f6, z2 ? (180.0f + f8) % 360.0f : f8);
        double d2 = (double) f8;
        d(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))));
        e(((f3 + f5) * 0.5f) + (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.f13242g.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f13242g.get(i2).a(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f13244i;
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f13236a;
    }

    public void b(float f2, float f3) {
        d dVar = new d();
        float unused = dVar.f13259a = f2;
        float unused2 = dVar.f13260b = f3;
        this.f13242g.add(dVar);
        b bVar = new b(dVar, d(), e());
        a(bVar, bVar.a() + 270.0f, bVar.a() + 270.0f);
        d(f2);
        e(f3);
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f13237b;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f13238c;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f13239d;
    }
}
