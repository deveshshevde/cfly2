package ir;

import android.view.animation.Interpolator;

public abstract class g implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    float f29108a;

    /* renamed from: b  reason: collision with root package name */
    Class f29109b;

    /* renamed from: c  reason: collision with root package name */
    boolean f29110c = false;

    /* renamed from: d  reason: collision with root package name */
    private Interpolator f29111d = null;

    static class a extends g {

        /* renamed from: d  reason: collision with root package name */
        float f29112d;

        a(float f2) {
            this.f29108a = f2;
            this.f29109b = Float.TYPE;
        }

        a(float f2, float f3) {
            this.f29108a = f2;
            this.f29112d = f3;
            this.f29109b = Float.TYPE;
            this.f29110c = true;
        }

        public void a(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.f29112d = ((Float) obj).floatValue();
                this.f29110c = true;
            }
        }

        public Object b() {
            return Float.valueOf(this.f29112d);
        }

        public float f() {
            return this.f29112d;
        }

        /* renamed from: g */
        public a e() {
            a aVar = new a(c(), this.f29112d);
            aVar.a(d());
            return aVar;
        }
    }

    public static g a(float f2) {
        return new a(f2);
    }

    public static g a(float f2, float f3) {
        return new a(f2, f3);
    }

    public void a(Interpolator interpolator) {
        this.f29111d = interpolator;
    }

    public abstract void a(Object obj);

    public boolean a() {
        return this.f29110c;
    }

    public abstract Object b();

    public float c() {
        return this.f29108a;
    }

    public Interpolator d() {
        return this.f29111d;
    }

    /* renamed from: e */
    public abstract g clone();
}
