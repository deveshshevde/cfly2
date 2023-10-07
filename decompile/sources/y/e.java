package y;

import fg.i;
import y.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    double f34677a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    double f34678b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34679c = false;

    /* renamed from: d  reason: collision with root package name */
    private double f34680d;

    /* renamed from: e  reason: collision with root package name */
    private double f34681e;

    /* renamed from: f  reason: collision with root package name */
    private double f34682f;

    /* renamed from: g  reason: collision with root package name */
    private double f34683g;

    /* renamed from: h  reason: collision with root package name */
    private double f34684h;

    /* renamed from: i  reason: collision with root package name */
    private double f34685i = Double.MAX_VALUE;

    /* renamed from: j  reason: collision with root package name */
    private final b.a f34686j = new b.a();

    public e() {
    }

    public e(float f2) {
        this.f34685i = (double) f2;
    }

    private void b() {
        if (!this.f34679c) {
            if (this.f34685i != Double.MAX_VALUE) {
                double d2 = this.f34678b;
                if (d2 > 1.0d) {
                    double d3 = this.f34677a;
                    this.f34682f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                    double d4 = this.f34678b;
                    double d5 = this.f34677a;
                    this.f34683g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
                } else if (d2 >= i.f27244a && d2 < 1.0d) {
                    this.f34684h = this.f34677a * Math.sqrt(1.0d - (d2 * d2));
                }
                this.f34679c = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    public float a() {
        return (float) this.f34685i;
    }

    /* access modifiers changed from: package-private */
    public b.a a(double d2, double d3, long j2) {
        double d4;
        double d5;
        b();
        double d6 = (double) j2;
        Double.isNaN(d6);
        double d7 = d6 / 1000.0d;
        double d8 = d2 - this.f34685i;
        double d9 = this.f34678b;
        if (d9 > 1.0d) {
            double d10 = this.f34683g;
            double d11 = this.f34682f;
            double d12 = d8 - (((d10 * d8) - d3) / (d10 - d11));
            double d13 = ((d8 * d10) - d3) / (d10 - d11);
            d5 = (Math.pow(2.718281828459045d, d10 * d7) * d12) + (Math.pow(2.718281828459045d, this.f34682f * d7) * d13);
            double d14 = this.f34683g;
            double pow = d12 * d14 * Math.pow(2.718281828459045d, d14 * d7);
            double d15 = this.f34682f;
            d4 = pow + (d13 * d15 * Math.pow(2.718281828459045d, d15 * d7));
        } else if (d9 == 1.0d) {
            double d16 = this.f34677a;
            double d17 = d3 + (d16 * d8);
            double d18 = d8 + (d17 * d7);
            d5 = Math.pow(2.718281828459045d, (-d16) * d7) * d18;
            double pow2 = d18 * Math.pow(2.718281828459045d, (-this.f34677a) * d7);
            double d19 = this.f34677a;
            d4 = (d17 * Math.pow(2.718281828459045d, (-d19) * d7)) + (pow2 * (-d19));
        } else {
            double d20 = 1.0d / this.f34684h;
            double d21 = this.f34677a;
            double d22 = d20 * ((d9 * d21 * d8) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d9) * d21 * d7) * ((Math.cos(this.f34684h * d7) * d8) + (Math.sin(this.f34684h * d7) * d22));
            double d23 = this.f34677a;
            double d24 = this.f34678b;
            double d25 = (-d23) * pow3 * d24;
            double pow4 = Math.pow(2.718281828459045d, (-d24) * d23 * d7);
            double d26 = this.f34684h;
            double d27 = pow3;
            double sin = (-d26) * d8 * Math.sin(d26 * d7);
            double d28 = this.f34684h;
            d4 = d25 + (pow4 * (sin + (d22 * d28 * Math.cos(d28 * d7))));
            d5 = d27;
        }
        this.f34686j.f34671a = (float) (d5 + this.f34685i);
        this.f34686j.f34672b = (float) d4;
        return this.f34686j;
    }

    public e a(float f2) {
        if (f2 > 0.0f) {
            this.f34677a = Math.sqrt((double) f2);
            this.f34679c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void a(double d2) {
        double abs = Math.abs(d2);
        this.f34680d = abs;
        this.f34681e = abs * 62.5d;
    }

    public boolean a(float f2, float f3) {
        return ((double) Math.abs(f3)) < this.f34681e && ((double) Math.abs(f2 - a())) < this.f34680d;
    }

    public e b(float f2) {
        if (f2 >= 0.0f) {
            this.f34678b = (double) f2;
            this.f34679c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public e c(float f2) {
        this.f34685i = (double) f2;
        return this;
    }
}
