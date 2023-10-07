package y;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import java.util.ArrayList;
import t.ac;
import y.a;
import y.b;

public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public static final d f34645a = new d("translationX") {
        public float a(View view) {
            return view.getTranslationX();
        }

        public void a(View view, float f2) {
            view.setTranslationX(f2);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final d f34646b = new d("translationY") {
        public float a(View view) {
            return view.getTranslationY();
        }

        public void a(View view, float f2) {
            view.setTranslationY(f2);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final d f34647c = new d("translationZ") {
        public float a(View view) {
            return ac.t(view);
        }

        public void a(View view, float f2) {
            ac.e(view, f2);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final d f34648d = new d("scaleX") {
        public float a(View view) {
            return view.getScaleX();
        }

        public void a(View view, float f2) {
            view.setScaleX(f2);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final d f34649e = new d("scaleY") {
        public float a(View view) {
            return view.getScaleY();
        }

        public void a(View view, float f2) {
            view.setScaleY(f2);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static final d f34650f = new d("rotation") {
        public float a(View view) {
            return view.getRotation();
        }

        public void a(View view, float f2) {
            view.setRotation(f2);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final d f34651g = new d("rotationX") {
        public float a(View view) {
            return view.getRotationX();
        }

        public void a(View view, float f2) {
            view.setRotationX(f2);
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public static final d f34652h = new d("rotationY") {
        public float a(View view) {
            return view.getRotationY();
        }

        public void a(View view, float f2) {
            view.setRotationY(f2);
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final d f34653i = new d("x") {
        public float a(View view) {
            return view.getX();
        }

        public void a(View view, float f2) {
            view.setX(f2);
        }
    };

    /* renamed from: j  reason: collision with root package name */
    public static final d f34654j = new d("y") {
        public float a(View view) {
            return view.getY();
        }

        public void a(View view, float f2) {
            view.setY(f2);
        }
    };

    /* renamed from: k  reason: collision with root package name */
    public static final d f34655k = new d("z") {
        public float a(View view) {
            return ac.H(view);
        }

        public void a(View view, float f2) {
            ac.f(view, f2);
        }
    };

    /* renamed from: l  reason: collision with root package name */
    public static final d f34656l = new d("alpha") {
        public float a(View view) {
            return view.getAlpha();
        }

        public void a(View view, float f2) {
            view.setAlpha(f2);
        }
    };

    /* renamed from: m  reason: collision with root package name */
    public static final d f34657m = new d("scrollX") {
        public float a(View view) {
            return (float) view.getScrollX();
        }

        public void a(View view, float f2) {
            view.setScrollX((int) f2);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    public static final d f34658n = new d("scrollY") {
        public float a(View view) {
            return (float) view.getScrollY();
        }

        public void a(View view, float f2) {
            view.setScrollY((int) f2);
        }
    };

    /* renamed from: o  reason: collision with root package name */
    float f34659o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    float f34660p = Float.MAX_VALUE;

    /* renamed from: q  reason: collision with root package name */
    boolean f34661q = false;

    /* renamed from: r  reason: collision with root package name */
    final Object f34662r;

    /* renamed from: s  reason: collision with root package name */
    final c f34663s;

    /* renamed from: t  reason: collision with root package name */
    boolean f34664t = false;

    /* renamed from: u  reason: collision with root package name */
    float f34665u = Float.MAX_VALUE;

    /* renamed from: v  reason: collision with root package name */
    float f34666v = (-Float.MAX_VALUE);

    /* renamed from: w  reason: collision with root package name */
    private long f34667w = 0;

    /* renamed from: x  reason: collision with root package name */
    private float f34668x;

    /* renamed from: y  reason: collision with root package name */
    private final ArrayList<C0266b> f34669y = new ArrayList<>();

    /* renamed from: z  reason: collision with root package name */
    private final ArrayList<c> f34670z = new ArrayList<>();

    static class a {

        /* renamed from: a  reason: collision with root package name */
        float f34671a;

        /* renamed from: b  reason: collision with root package name */
        float f34672b;

        a() {
        }
    }

    /* renamed from: y.b$b  reason: collision with other inner class name */
    public interface C0266b {
        void a(b bVar, boolean z2, float f2, float f3);
    }

    public interface c {
        void a(b bVar, float f2, float f3);
    }

    public static abstract class d extends c<View> {
        private d(String str) {
            super(str);
        }
    }

    <K> b(K k2, c<K> cVar) {
        float f2;
        this.f34662r = k2;
        this.f34663s = cVar;
        if (cVar == f34650f || cVar == f34651g || cVar == f34652h) {
            f2 = 0.1f;
        } else if (cVar == f34656l || cVar == f34648d || cVar == f34649e) {
            this.f34668x = 0.00390625f;
            return;
        } else {
            f2 = 1.0f;
        }
        this.f34668x = f2;
    }

    private static <T> void a(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void a(boolean z2) {
        this.f34664t = false;
        a.a().a((a.b) this);
        this.f34667w = 0;
        this.f34661q = false;
        for (int i2 = 0; i2 < this.f34669y.size(); i2++) {
            if (this.f34669y.get(i2) != null) {
                this.f34669y.get(i2).a(this, z2, this.f34660p, this.f34659o);
            }
        }
        a(this.f34669y);
    }

    private void e() {
        if (!this.f34664t) {
            this.f34664t = true;
            if (!this.f34661q) {
                this.f34660p = f();
            }
            float f2 = this.f34660p;
            if (f2 > this.f34665u || f2 < this.f34666v) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            a.a().a(this, 0);
        }
    }

    private float f() {
        return this.f34663s.a(this.f34662r);
    }

    public T a(float f2) {
        this.f34660p = f2;
        this.f34661q = true;
        return this;
    }

    public void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f34664t) {
            e();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean a(float f2, float f3);

    public boolean a(long j2) {
        long j3 = this.f34667w;
        if (j3 == 0) {
            this.f34667w = j2;
            b(this.f34660p);
            return false;
        }
        this.f34667w = j2;
        boolean b2 = b(j2 - j3);
        float min = Math.min(this.f34660p, this.f34665u);
        this.f34660p = min;
        float max = Math.max(min, this.f34666v);
        this.f34660p = max;
        b(max);
        if (b2) {
            a(false);
        }
        return b2;
    }

    public void b() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be canceled on the main thread");
        } else if (this.f34664t) {
            a(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        this.f34663s.a(this.f34662r, f2);
        for (int i2 = 0; i2 < this.f34670z.size(); i2++) {
            if (this.f34670z.get(i2) != null) {
                this.f34670z.get(i2).a(this, this.f34660p, this.f34659o);
            }
        }
        a(this.f34670z);
    }

    /* access modifiers changed from: package-private */
    public abstract boolean b(long j2);

    public boolean c() {
        return this.f34664t;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f34668x * 0.75f;
    }
}
