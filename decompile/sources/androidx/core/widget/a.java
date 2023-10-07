package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import t.ac;

public abstract class a implements View.OnTouchListener {

    /* renamed from: r  reason: collision with root package name */
    private static final int f3037r = ViewConfiguration.getTapTimeout();

    /* renamed from: a  reason: collision with root package name */
    final C0027a f3038a = new C0027a();

    /* renamed from: b  reason: collision with root package name */
    final View f3039b;

    /* renamed from: c  reason: collision with root package name */
    boolean f3040c;

    /* renamed from: d  reason: collision with root package name */
    boolean f3041d;

    /* renamed from: e  reason: collision with root package name */
    boolean f3042e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator f3043f = new AccelerateInterpolator();

    /* renamed from: g  reason: collision with root package name */
    private Runnable f3044g;

    /* renamed from: h  reason: collision with root package name */
    private float[] f3045h = {0.0f, 0.0f};

    /* renamed from: i  reason: collision with root package name */
    private float[] f3046i = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: j  reason: collision with root package name */
    private int f3047j;

    /* renamed from: k  reason: collision with root package name */
    private int f3048k;

    /* renamed from: l  reason: collision with root package name */
    private float[] f3049l = {0.0f, 0.0f};

    /* renamed from: m  reason: collision with root package name */
    private float[] f3050m = {0.0f, 0.0f};

    /* renamed from: n  reason: collision with root package name */
    private float[] f3051n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: o  reason: collision with root package name */
    private boolean f3052o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3053p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3054q;

    /* renamed from: androidx.core.widget.a$a  reason: collision with other inner class name */
    private static class C0027a {

        /* renamed from: a  reason: collision with root package name */
        private int f3055a;

        /* renamed from: b  reason: collision with root package name */
        private int f3056b;

        /* renamed from: c  reason: collision with root package name */
        private float f3057c;

        /* renamed from: d  reason: collision with root package name */
        private float f3058d;

        /* renamed from: e  reason: collision with root package name */
        private long f3059e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f3060f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f3061g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f3062h = 0;

        /* renamed from: i  reason: collision with root package name */
        private long f3063i = -1;

        /* renamed from: j  reason: collision with root package name */
        private float f3064j;

        /* renamed from: k  reason: collision with root package name */
        private int f3065k;

        C0027a() {
        }

        private float a(float f2) {
            return (-4.0f * f2 * f2) + (f2 * 4.0f);
        }

        private float a(long j2) {
            long j3 = this.f3059e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.f3063i;
            if (j4 < 0 || j2 < j4) {
                return a.a(((float) (j2 - j3)) / ((float) this.f3055a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f3064j;
            return (1.0f - f2) + (f2 * a.a(((float) (j2 - j4)) / ((float) this.f3065k), 0.0f, 1.0f));
        }

        public void a() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f3059e = currentAnimationTimeMillis;
            this.f3063i = -1;
            this.f3060f = currentAnimationTimeMillis;
            this.f3064j = 0.5f;
            this.f3061g = 0;
            this.f3062h = 0;
        }

        public void a(float f2, float f3) {
            this.f3057c = f2;
            this.f3058d = f3;
        }

        public void a(int i2) {
            this.f3055a = i2;
        }

        public void b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f3065k = a.a((int) (currentAnimationTimeMillis - this.f3059e), 0, this.f3056b);
            this.f3064j = a(currentAnimationTimeMillis);
            this.f3063i = currentAnimationTimeMillis;
        }

        public void b(int i2) {
            this.f3056b = i2;
        }

        public boolean c() {
            return this.f3063i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f3063i + ((long) this.f3065k);
        }

        public void d() {
            if (this.f3060f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a2 = a(a(currentAnimationTimeMillis));
                this.f3060f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f3060f)) * a2;
                this.f3061g = (int) (this.f3057c * f2);
                this.f3062h = (int) (f2 * this.f3058d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int e() {
            float f2 = this.f3057c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f3058d;
            return (int) (f2 / Math.abs(f2));
        }

        public int g() {
            return this.f3061g;
        }

        public int h() {
            return this.f3062h;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            if (a.this.f3042e) {
                if (a.this.f3040c) {
                    a.this.f3040c = false;
                    a.this.f3038a.a();
                }
                C0027a aVar = a.this.f3038a;
                if (aVar.c() || !a.this.a()) {
                    a.this.f3042e = false;
                    return;
                }
                if (a.this.f3041d) {
                    a.this.f3041d = false;
                    a.this.b();
                }
                aVar.d();
                a.this.a(aVar.g(), aVar.h());
                ac.a(a.this.f3039b, (Runnable) this);
            }
        }
    }

    public a(View view) {
        this.f3039b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float f2 = (float) ((int) ((displayMetrics.density * 1575.0f) + 0.5f));
        a(f2, f2);
        float f3 = (float) ((int) ((displayMetrics.density * 315.0f) + 0.5f));
        b(f3, f3);
        a(1);
        e(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        c(1.0f, 1.0f);
        b(f3037r);
        c(500);
        d(500);
    }

    static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6;
        float a2 = a(f2 * f3, 0.0f, f4);
        float f7 = f(f3 - f5, a2) - f(f5, a2);
        if (f7 < 0.0f) {
            f6 = -this.f3043f.getInterpolation(-f7);
        } else if (f7 <= 0.0f) {
            return 0.0f;
        } else {
            f6 = this.f3043f.getInterpolation(f7);
        }
        return a(f6, -1.0f, 1.0f);
    }

    private float a(int i2, float f2, float f3, float f4) {
        float a2 = a(this.f3045h[i2], f3, this.f3046i[i2], f2);
        if (a2 == 0.0f) {
            return 0.0f;
        }
        float f5 = this.f3049l[i2];
        float f6 = this.f3050m[i2];
        float f7 = this.f3051n[i2];
        float f8 = f5 * f4;
        return a2 > 0.0f ? a(a2 * f8, f6, f7) : -a((-a2) * f8, f6, f7);
    }

    static int a(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private void c() {
        int i2;
        if (this.f3044g == null) {
            this.f3044g = new b();
        }
        this.f3042e = true;
        this.f3040c = true;
        if (this.f3052o || (i2 = this.f3048k) <= 0) {
            this.f3044g.run();
        } else {
            ac.a(this.f3039b, this.f3044g, (long) i2);
        }
        this.f3052o = true;
    }

    private void d() {
        if (this.f3040c) {
            this.f3042e = false;
        } else {
            this.f3038a.b();
        }
    }

    private float f(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f3047j;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                return f2 >= 0.0f ? 1.0f - (f2 / f3) : (!this.f3042e || i2 != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    public a a(float f2, float f3) {
        float[] fArr = this.f3051n;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a a(int i2) {
        this.f3047j = i2;
        return this;
    }

    public a a(boolean z2) {
        if (this.f3053p && !z2) {
            d();
        }
        this.f3053p = z2;
        return this;
    }

    public abstract void a(int i2, int i3);

    /* access modifiers changed from: package-private */
    public boolean a() {
        C0027a aVar = this.f3038a;
        int f2 = aVar.f();
        int e2 = aVar.e();
        return (f2 != 0 && f(f2)) || (e2 != 0 && e(e2));
    }

    public a b(float f2, float f3) {
        float[] fArr = this.f3050m;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a b(int i2) {
        this.f3048k = i2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f3039b.onTouchEvent(obtain);
        obtain.recycle();
    }

    public a c(float f2, float f3) {
        float[] fArr = this.f3049l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a c(int i2) {
        this.f3038a.a(i2);
        return this;
    }

    public a d(float f2, float f3) {
        float[] fArr = this.f3045h;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public a d(int i2) {
        this.f3038a.b(i2);
        return this;
    }

    public a e(float f2, float f3) {
        float[] fArr = this.f3046i;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public abstract boolean e(int i2);

    public abstract boolean f(int i2);

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f3053p
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.d()
            goto L_0x0058
        L_0x001a:
            r5.f3041d = r2
            r5.f3052o = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f3039b
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a((int) r1, (float) r0, (float) r3, (float) r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f3039b
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a((int) r2, (float) r7, (float) r6, (float) r3)
            androidx.core.widget.a$a r7 = r5.f3038a
            r7.a(r0, r6)
            boolean r6 = r5.f3042e
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.a()
            if (r6 == 0) goto L_0x0058
            r5.c()
        L_0x0058:
            boolean r6 = r5.f3054q
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f3042e
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
