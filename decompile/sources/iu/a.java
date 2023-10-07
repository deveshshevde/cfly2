package iu;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class a extends Animation {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f29374a = (Integer.valueOf(Build.VERSION.SDK).intValue() < 11);

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<View, a> f29375b = new WeakHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<View> f29376c;

    /* renamed from: d  reason: collision with root package name */
    private final Camera f29377d = new Camera();

    /* renamed from: e  reason: collision with root package name */
    private boolean f29378e;

    /* renamed from: f  reason: collision with root package name */
    private float f29379f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f29380g;

    /* renamed from: h  reason: collision with root package name */
    private float f29381h;

    /* renamed from: i  reason: collision with root package name */
    private float f29382i;

    /* renamed from: j  reason: collision with root package name */
    private float f29383j;

    /* renamed from: k  reason: collision with root package name */
    private float f29384k;

    /* renamed from: l  reason: collision with root package name */
    private float f29385l = 1.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f29386m = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f29387n;

    /* renamed from: o  reason: collision with root package name */
    private float f29388o;

    /* renamed from: p  reason: collision with root package name */
    private final RectF f29389p = new RectF();

    /* renamed from: q  reason: collision with root package name */
    private final RectF f29390q = new RectF();

    /* renamed from: r  reason: collision with root package name */
    private final Matrix f29391r = new Matrix();

    private a(View view) {
        setDuration(0);
        setFillAfter(true);
        view.setAnimation(this);
        this.f29376c = new WeakReference<>(view);
    }

    public static a a(View view) {
        WeakHashMap<View, a> weakHashMap = f29375b;
        a aVar = weakHashMap.get(view);
        if (aVar != null && aVar == view.getAnimation()) {
            return aVar;
        }
        a aVar2 = new a(view);
        weakHashMap.put(view, aVar2);
        return aVar2;
    }

    private void a(Matrix matrix, View view) {
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        boolean z2 = this.f29378e;
        float f2 = z2 ? this.f29380g : width / 2.0f;
        float f3 = z2 ? this.f29381h : height / 2.0f;
        float f4 = this.f29382i;
        float f5 = this.f29383j;
        float f6 = this.f29384k;
        if (!(f4 == 0.0f && f5 == 0.0f && f6 == 0.0f)) {
            Camera camera = this.f29377d;
            camera.save();
            camera.rotateX(f4);
            camera.rotateY(f5);
            camera.rotateZ(-f6);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f2, -f3);
            matrix.postTranslate(f2, f3);
        }
        float f7 = this.f29385l;
        float f8 = this.f29386m;
        if (!(f7 == 1.0f && f8 == 1.0f)) {
            matrix.postScale(f7, f8);
            matrix.postTranslate((-(f2 / width)) * ((f7 * width) - width), (-(f3 / height)) * ((f8 * height) - height));
        }
        matrix.postTranslate(this.f29387n, this.f29388o);
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        Matrix matrix = this.f29391r;
        matrix.reset();
        a(matrix, view);
        this.f29391r.mapRect(rectF);
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        if (rectF.right < rectF.left) {
            float f2 = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f2;
        }
        if (rectF.bottom < rectF.top) {
            float f3 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f3;
        }
    }

    private void o() {
        View view = (View) this.f29376c.get();
        if (view != null) {
            a(this.f29389p, view);
        }
    }

    private void p() {
        View view = (View) this.f29376c.get();
        if (view != null && view.getParent() != null) {
            RectF rectF = this.f29390q;
            a(rectF, view);
            rectF.union(this.f29389p);
            ((View) view.getParent()).invalidate((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
        }
    }

    public float a() {
        return this.f29379f;
    }

    public void a(float f2) {
        if (this.f29379f != f2) {
            this.f29379f = f2;
            View view = (View) this.f29376c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void applyTransformation(float f2, Transformation transformation) {
        View view = (View) this.f29376c.get();
        if (view != null) {
            transformation.setAlpha(this.f29379f);
            a(transformation.getMatrix(), view);
        }
    }

    public float b() {
        return this.f29380g;
    }

    public void b(float f2) {
        if (!this.f29378e || this.f29380g != f2) {
            o();
            this.f29378e = true;
            this.f29380g = f2;
            p();
        }
    }

    public float c() {
        return this.f29381h;
    }

    public void c(float f2) {
        if (!this.f29378e || this.f29381h != f2) {
            o();
            this.f29378e = true;
            this.f29381h = f2;
            p();
        }
    }

    public float d() {
        return this.f29384k;
    }

    public void d(float f2) {
        if (this.f29384k != f2) {
            o();
            this.f29384k = f2;
            p();
        }
    }

    public float e() {
        return this.f29382i;
    }

    public void e(float f2) {
        if (this.f29382i != f2) {
            o();
            this.f29382i = f2;
            p();
        }
    }

    public float f() {
        return this.f29383j;
    }

    public void f(float f2) {
        if (this.f29383j != f2) {
            o();
            this.f29383j = f2;
            p();
        }
    }

    public float g() {
        return this.f29385l;
    }

    public void g(float f2) {
        if (this.f29385l != f2) {
            o();
            this.f29385l = f2;
            p();
        }
    }

    public float h() {
        return this.f29386m;
    }

    public void h(float f2) {
        if (this.f29386m != f2) {
            o();
            this.f29386m = f2;
            p();
        }
    }

    public int i() {
        View view = (View) this.f29376c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public void i(float f2) {
        if (this.f29387n != f2) {
            o();
            this.f29387n = f2;
            p();
        }
    }

    public int j() {
        View view = (View) this.f29376c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public void j(float f2) {
        if (this.f29388o != f2) {
            o();
            this.f29388o = f2;
            p();
        }
    }

    public float k() {
        return this.f29387n;
    }

    public void k(float f2) {
        View view = (View) this.f29376c.get();
        if (view != null) {
            i(f2 - ((float) view.getLeft()));
        }
    }

    public float l() {
        return this.f29388o;
    }

    public void l(float f2) {
        View view = (View) this.f29376c.get();
        if (view != null) {
            j(f2 - ((float) view.getTop()));
        }
    }

    public float m() {
        View view = (View) this.f29376c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getLeft()) + this.f29387n;
    }

    public float n() {
        View view = (View) this.f29376c.get();
        if (view == null) {
            return 0.0f;
        }
        return ((float) view.getTop()) + this.f29388o;
    }
}
