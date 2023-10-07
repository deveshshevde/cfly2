package it.sephiroth.android.library.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import fg.i;

public class c {

    /* renamed from: f  reason: collision with root package name */
    private static float f29349f = 8.0f;

    /* renamed from: g  reason: collision with root package name */
    private static float f29350g = (1.0f / a(1.0f));

    /* renamed from: a  reason: collision with root package name */
    private int f29351a;

    /* renamed from: b  reason: collision with root package name */
    private final a f29352b;

    /* renamed from: c  reason: collision with root package name */
    private final a f29353c;

    /* renamed from: d  reason: collision with root package name */
    private Interpolator f29354d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f29355e;

    static class a {

        /* renamed from: p  reason: collision with root package name */
        private static float f29356p = ((float) (Math.log(0.78d) / Math.log(0.9d)));

        /* renamed from: q  reason: collision with root package name */
        private static final float[] f29357q = new float[101];

        /* renamed from: r  reason: collision with root package name */
        private static final float[] f29358r = new float[101];
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f29359a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f29360b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f29361c;

        /* renamed from: d  reason: collision with root package name */
        private int f29362d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public float f29363e;

        /* renamed from: f  reason: collision with root package name */
        private float f29364f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public long f29365g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f29366h;

        /* renamed from: i  reason: collision with root package name */
        private int f29367i;

        /* renamed from: j  reason: collision with root package name */
        private int f29368j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f29369k = true;

        /* renamed from: l  reason: collision with root package name */
        private int f29370l;

        /* renamed from: m  reason: collision with root package name */
        private float f29371m = ViewConfiguration.getScrollFriction();

        /* renamed from: n  reason: collision with root package name */
        private int f29372n = 0;

        /* renamed from: o  reason: collision with root package name */
        private float f29373o;

        static {
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (int i2 = 0; i2 < 100; i2++) {
                float f14 = ((float) i2) / 100.0f;
                float f15 = 1.0f;
                while (true) {
                    f2 = 2.0f;
                    f3 = ((f15 - f12) / 2.0f) + f12;
                    f4 = 3.0f;
                    f5 = 1.0f - f3;
                    f6 = f3 * 3.0f * f5;
                    f7 = f3 * f3 * f3;
                    float f16 = (((f5 * 0.175f) + (f3 * 0.35000002f)) * f6) + f7;
                    float f17 = f16;
                    if (((double) Math.abs(f16 - f14)) < 1.0E-5d) {
                        break;
                    } else if (f17 > f14) {
                        f15 = f3;
                    } else {
                        f12 = f3;
                    }
                }
                f29357q[i2] = (f6 * ((f5 * 0.5f) + f3)) + f7;
                float f18 = 1.0f;
                while (true) {
                    f8 = ((f18 - f13) / f2) + f13;
                    f9 = 1.0f - f8;
                    f10 = f8 * f4 * f9;
                    f11 = f8 * f8 * f8;
                    float f19 = (((f9 * 0.5f) + f8) * f10) + f11;
                    if (((double) Math.abs(f19 - f14)) < 1.0E-5d) {
                        break;
                    }
                    if (f19 > f14) {
                        f18 = f8;
                    } else {
                        f13 = f8;
                    }
                    f2 = 2.0f;
                    f4 = 3.0f;
                }
                f29358r[i2] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
            }
            float[] fArr = f29357q;
            f29358r[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        a(Context context) {
            this.f29373o = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private static float a(int i2) {
            return i2 > 0 ? -2000.0f : 2000.0f;
        }

        private void a(int i2, int i3, int i4, int i5) {
            int i6 = i2;
            int i7 = i4;
            int i8 = i5;
            boolean z2 = true;
            int i9 = i3;
            if (i6 <= i9 || i6 >= i7) {
                boolean z3 = i6 > i7;
                int i10 = z3 ? i7 : i9;
                int i11 = i6 - i10;
                if (i11 * i8 < 0) {
                    z2 = false;
                }
                if (z2) {
                    g(i2, i10, i8);
                } else if (c(i8) > ((double) Math.abs(i11))) {
                    a(i2, i5, z3 ? i9 : i6, z3 ? i6 : i7, this.f29370l);
                } else {
                    e(i2, i10, i8);
                }
            } else {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.f29369k = true;
            }
        }

        private double b(int i2) {
            return Math.log((double) ((((float) Math.abs(i2)) * 0.35f) / (this.f29371m * this.f29373o)));
        }

        private double c(int i2) {
            double b2 = b(i2);
            float f2 = f29356p;
            double d2 = (double) f2;
            Double.isNaN(d2);
            double d3 = (double) (this.f29371m * this.f29373o);
            double d4 = (double) f2;
            Double.isNaN(d4);
            double exp = Math.exp((d4 / (d2 - 1.0d)) * b2);
            Double.isNaN(d3);
            return d3 * exp;
        }

        private int d(int i2) {
            double b2 = b(i2);
            double d2 = (double) f29356p;
            Double.isNaN(d2);
            return (int) (Math.exp(b2 / (d2 - 1.0d)) * 1000.0d);
        }

        private void d() {
            int i2 = this.f29362d;
            float abs = ((float) (i2 * i2)) / (Math.abs(this.f29364f) * 2.0f);
            float signum = Math.signum((float) this.f29362d);
            int i3 = this.f29370l;
            if (abs > ((float) i3)) {
                float f2 = -signum;
                int i4 = this.f29362d;
                this.f29364f = ((f2 * ((float) i4)) * ((float) i4)) / (((float) i3) * 2.0f);
                abs = (float) i3;
            }
            this.f29370l = (int) abs;
            this.f29372n = 2;
            int i5 = this.f29359a;
            int i6 = this.f29362d;
            if (i6 <= 0) {
                abs = -abs;
            }
            this.f29361c = i5 + ((int) abs);
            this.f29366h = -((int) ((((float) i6) * 1000.0f) / this.f29364f));
        }

        private void d(int i2, int i3, int i4) {
            float abs = Math.abs(((float) (i4 - i2)) / ((float) (i3 - i2)));
            int i5 = (int) (abs * 100.0f);
            if (i5 < 100) {
                float f2 = ((float) i5) / 100.0f;
                int i6 = i5 + 1;
                float[] fArr = f29358r;
                float f3 = fArr[i5];
                this.f29366h = (int) (((float) this.f29366h) * (f3 + (((abs - f2) / ((((float) i6) / 100.0f) - f2)) * (fArr[i6] - f3))));
            }
        }

        private void e(int i2, int i3, int i4) {
            this.f29369k = false;
            this.f29372n = 1;
            this.f29359a = i2;
            this.f29361c = i3;
            int i5 = i2 - i3;
            this.f29364f = a(i5);
            this.f29362d = -i5;
            this.f29370l = Math.abs(i5);
            double d2 = (double) i5;
            Double.isNaN(d2);
            double d3 = (double) this.f29364f;
            Double.isNaN(d3);
            this.f29366h = (int) (Math.sqrt((d2 * -2.0d) / d3) * 1000.0d);
        }

        private void f(int i2, int i3, int i4) {
            float f2 = this.f29364f;
            float f3 = ((float) (-i4)) / f2;
            double abs = (double) (((((float) (i4 * i4)) / 2.0f) / Math.abs(f2)) + ((float) Math.abs(i3 - i2)));
            Double.isNaN(abs);
            double abs2 = (double) Math.abs(this.f29364f);
            Double.isNaN(abs2);
            float sqrt = (float) Math.sqrt((abs * 2.0d) / abs2);
            this.f29365g -= (long) ((int) ((sqrt - f3) * 1000.0f));
            this.f29359a = i3;
            this.f29362d = (int) ((-this.f29364f) * sqrt);
        }

        private void g(int i2, int i3, int i4) {
            this.f29364f = a(i4 == 0 ? i2 - i3 : i4);
            f(i2, i3, i4);
            d();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f29360b = this.f29361c;
            this.f29369k = true;
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.f29371m = f2;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, int i4) {
            this.f29369k = false;
            this.f29359a = i2;
            this.f29361c = i2 + i3;
            this.f29365g = AnimationUtils.currentAnimationTimeMillis();
            this.f29366h = i4;
            this.f29364f = 0.0f;
            this.f29362d = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, int i4, int i5, int i6) {
            this.f29370l = i6;
            this.f29369k = false;
            this.f29362d = i3;
            float f2 = (float) i3;
            this.f29363e = f2;
            this.f29367i = 0;
            this.f29366h = 0;
            this.f29365g = AnimationUtils.currentAnimationTimeMillis();
            this.f29359a = i2;
            this.f29360b = i2;
            if (i2 > i5 || i2 < i4) {
                a(i2, i4, i5, i3);
                return;
            }
            this.f29372n = 0;
            double d2 = i.f27244a;
            if (i3 != 0) {
                int d3 = d(i3);
                this.f29367i = d3;
                this.f29366h = d3;
                d2 = c(i3);
            }
            double signum = (double) Math.signum(f2);
            Double.isNaN(signum);
            int i7 = (int) (d2 * signum);
            this.f29368j = i7;
            int i8 = i2 + i7;
            this.f29361c = i8;
            if (i8 < i4) {
                d(this.f29359a, i8, i4);
                this.f29361c = i4;
            }
            int i9 = this.f29361c;
            if (i9 > i5) {
                d(this.f29359a, i9, i5);
                this.f29361c = i5;
            }
        }

        /* access modifiers changed from: package-private */
        public void b(float f2) {
            int i2 = this.f29359a;
            this.f29360b = i2 + Math.round(f2 * ((float) (this.f29361c - i2)));
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            int i2 = this.f29372n;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                if (i2 == 2) {
                    this.f29365g += (long) this.f29366h;
                    e(this.f29361c, this.f29359a, 0);
                }
            } else if (this.f29366h >= this.f29367i) {
                return false;
            } else {
                this.f29359a = this.f29361c;
                int i3 = (int) this.f29363e;
                this.f29362d = i3;
                this.f29364f = a(i3);
                this.f29365g += (long) this.f29366h;
                d();
            }
            c();
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2, int i3, int i4) {
            this.f29369k = true;
            this.f29361c = i2;
            this.f29359a = i2;
            this.f29362d = 0;
            this.f29365g = AnimationUtils.currentAnimationTimeMillis();
            this.f29366h = 0;
            if (i2 < i3) {
                e(i2, i3, 0);
            } else if (i2 > i4) {
                e(i2, i4, 0);
            }
            return !this.f29369k;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3, int i4) {
            if (this.f29372n == 0) {
                this.f29370l = i4;
                this.f29365g = AnimationUtils.currentAnimationTimeMillis();
                a(i2, i3, i3, (int) this.f29363e);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f29365g;
            int i2 = this.f29366h;
            if (currentAnimationTimeMillis > ((long) i2)) {
                return false;
            }
            double d2 = i.f27244a;
            int i3 = this.f29372n;
            if (i3 == 0) {
                int i4 = this.f29367i;
                float f2 = ((float) currentAnimationTimeMillis) / ((float) i4);
                int i5 = (int) (f2 * 100.0f);
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (i5 < 100) {
                    float f5 = ((float) i5) / 100.0f;
                    int i6 = i5 + 1;
                    float[] fArr = f29357q;
                    float f6 = fArr[i5];
                    f4 = (fArr[i6] - f6) / ((((float) i6) / 100.0f) - f5);
                    f3 = f6 + ((f2 - f5) * f4);
                }
                int i7 = this.f29368j;
                d2 = (double) (f3 * ((float) i7));
                this.f29363e = ((f4 * ((float) i7)) / ((float) i4)) * 1000.0f;
            } else if (i3 == 1) {
                float f7 = ((float) currentAnimationTimeMillis) / ((float) i2);
                float f8 = f7 * f7;
                float signum = Math.signum((float) this.f29362d);
                int i8 = this.f29370l;
                this.f29363e = signum * ((float) i8) * 6.0f * ((-f7) + f8);
                d2 = (double) (((float) i8) * signum * ((3.0f * f8) - ((2.0f * f7) * f8)));
            } else if (i3 == 2) {
                float f9 = ((float) currentAnimationTimeMillis) / 1000.0f;
                int i9 = this.f29362d;
                float f10 = this.f29364f;
                this.f29363e = ((float) i9) + (f10 * f9);
                d2 = (double) ((((float) i9) * f9) + (((f10 * f9) * f9) / 2.0f));
            }
            this.f29360b = this.f29359a + ((int) Math.round(d2));
            return true;
        }
    }

    public c(Context context) {
        this(context, (Interpolator) null);
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z2) {
        this.f29354d = interpolator;
        this.f29355e = z2;
        this.f29352b = new a(context);
        this.f29353c = new a(context);
    }

    public static float a(float f2) {
        float f3 = f2 * f29349f;
        return (f3 < 1.0f ? f3 - (1.0f - ((float) Math.exp((double) (-f3)))) : ((1.0f - ((float) Math.exp((double) (1.0f - f3)))) * 0.63212055f) + 0.36787945f) * f29350g;
    }

    public void a(int i2, int i3, int i4) {
        this.f29352b.c(i2, i3, i4);
    }

    public void a(int i2, int i3, int i4, int i5, int i6) {
        this.f29351a = 0;
        this.f29352b.a(i2, i4, i6);
        this.f29353c.a(i3, i5, i6);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        a(i2, i3, i4, i5, i6, i7, i8, i9, 0, 0);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        if (!this.f29355e || a()) {
            i15 = i4;
        } else {
            float c2 = this.f29352b.f29363e;
            float c3 = this.f29353c.f29363e;
            i15 = i4;
            float f2 = (float) i15;
            if (Math.signum(f2) == Math.signum(c2)) {
                i14 = i5;
                float f3 = (float) i14;
                if (Math.signum(f3) == Math.signum(c3)) {
                    i13 = (int) (f3 + c3);
                    i12 = (int) (f2 + c2);
                    this.f29351a = 1;
                    this.f29352b.a(i2, i12, i6, i7, i10);
                    this.f29353c.a(i3, i13, i8, i9, i11);
                }
                i13 = i14;
                i12 = i15;
                this.f29351a = 1;
                this.f29352b.a(i2, i12, i6, i7, i10);
                this.f29353c.a(i3, i13, i8, i9, i11);
            }
        }
        i14 = i5;
        i13 = i14;
        i12 = i15;
        this.f29351a = 1;
        this.f29352b.a(i2, i12, i6, i7, i10);
        this.f29353c.a(i3, i13, i8, i9, i11);
    }

    /* access modifiers changed from: package-private */
    public void a(Interpolator interpolator) {
        this.f29354d = interpolator;
    }

    public final boolean a() {
        return this.f29352b.f29369k && this.f29353c.f29369k;
    }

    public boolean a(float f2, float f3) {
        return !a() && Math.signum(f2) == Math.signum((float) (this.f29352b.f29361c - this.f29352b.f29359a)) && Math.signum(f3) == Math.signum((float) (this.f29353c.f29361c - this.f29353c.f29359a));
    }

    public boolean a(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f29351a = 1;
        return this.f29352b.b(i2, i4, i5) || this.f29353c.b(i3, i6, i7);
    }

    public final int b() {
        return this.f29352b.f29360b;
    }

    public final void b(float f2) {
        this.f29352b.a(f2);
        this.f29353c.a(f2);
    }

    public float c() {
        return (float) Math.sqrt((double) ((this.f29352b.f29363e * this.f29352b.f29363e) + (this.f29353c.f29363e * this.f29353c.f29363e)));
    }

    public boolean d() {
        if (a()) {
            return false;
        }
        int i2 = this.f29351a;
        if (i2 == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f29352b.f29365g;
            int f2 = this.f29352b.f29366h;
            if (currentAnimationTimeMillis < ((long) f2)) {
                float f3 = ((float) currentAnimationTimeMillis) / ((float) f2);
                Interpolator interpolator = this.f29354d;
                float a2 = interpolator == null ? a(f3) : interpolator.getInterpolation(f3);
                this.f29352b.b(a2);
                this.f29353c.b(a2);
            } else {
                e();
            }
        } else if (i2 == 1) {
            if (!this.f29352b.f29369k && !this.f29352b.c() && !this.f29352b.b()) {
                this.f29352b.a();
            }
            if (!this.f29353c.f29369k && !this.f29353c.c() && !this.f29353c.b()) {
                this.f29353c.a();
            }
        }
        return true;
    }

    public void e() {
        this.f29352b.a();
        this.f29353c.a();
    }
}
