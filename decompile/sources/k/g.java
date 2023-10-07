package k;

import androidx.constraintlayout.motion.widget.o;

public class g extends o {

    /* renamed from: a  reason: collision with root package name */
    private float f29931a;

    /* renamed from: b  reason: collision with root package name */
    private float f29932b;

    /* renamed from: c  reason: collision with root package name */
    private float f29933c;

    /* renamed from: d  reason: collision with root package name */
    private float f29934d;

    /* renamed from: e  reason: collision with root package name */
    private float f29935e;

    /* renamed from: f  reason: collision with root package name */
    private float f29936f;

    /* renamed from: g  reason: collision with root package name */
    private float f29937g;

    /* renamed from: h  reason: collision with root package name */
    private float f29938h;

    /* renamed from: i  reason: collision with root package name */
    private float f29939i;

    /* renamed from: j  reason: collision with root package name */
    private int f29940j;

    /* renamed from: k  reason: collision with root package name */
    private String f29941k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f29942l = false;

    /* renamed from: m  reason: collision with root package name */
    private float f29943m;

    /* renamed from: n  reason: collision with root package name */
    private float f29944n;

    private void a(float f2, float f3, float f4, float f5, float f6) {
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.f29931a = f2;
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4));
            if (sqrt < f5) {
                this.f29941k = "backward accelerate, decelerate";
                this.f29940j = 2;
                this.f29931a = f2;
                this.f29932b = sqrt;
                this.f29933c = 0.0f;
                float f9 = (sqrt - f2) / f4;
                this.f29934d = f9;
                this.f29935e = sqrt / f4;
                this.f29937g = ((f2 + sqrt) * f9) / 2.0f;
                this.f29938h = f3;
                this.f29939i = f3;
                return;
            }
            this.f29941k = "backward accelerate cruse decelerate";
            this.f29940j = 3;
            this.f29931a = f2;
            this.f29932b = f5;
            this.f29933c = f5;
            float f10 = (f5 - f2) / f4;
            this.f29934d = f10;
            float f11 = f5 / f4;
            this.f29936f = f11;
            float f12 = ((f2 + f5) * f10) / 2.0f;
            float f13 = (f11 * f5) / 2.0f;
            this.f29935e = ((f3 - f12) - f13) / f5;
            this.f29937g = f12;
            this.f29938h = f3 - f13;
            this.f29939i = f3;
        } else if (f8 >= f3) {
            this.f29941k = "hard stop";
            this.f29940j = 1;
            this.f29931a = f2;
            this.f29932b = 0.0f;
            this.f29937g = f3;
            this.f29934d = (2.0f * f3) / f2;
        } else {
            float f14 = f3 - f8;
            float f15 = f14 / f2;
            if (f15 + f7 < f6) {
                this.f29941k = "cruse decelerate";
                this.f29940j = 2;
                this.f29931a = f2;
                this.f29932b = f2;
                this.f29933c = 0.0f;
                this.f29937g = f14;
                this.f29938h = f3;
                this.f29934d = f15;
                this.f29935e = f7;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f4 * f3) + ((f2 * f2) / 2.0f)));
            float f16 = (sqrt2 - f2) / f4;
            this.f29934d = f16;
            float f17 = sqrt2 / f4;
            this.f29935e = f17;
            if (sqrt2 < f5) {
                this.f29941k = "accelerate decelerate";
                this.f29940j = 2;
                this.f29931a = f2;
                this.f29932b = sqrt2;
                this.f29933c = 0.0f;
                this.f29934d = f16;
                this.f29935e = f17;
                this.f29937g = ((f2 + sqrt2) * f16) / 2.0f;
                this.f29938h = f3;
                return;
            }
            this.f29941k = "accelerate cruse decelerate";
            this.f29940j = 3;
            this.f29931a = f2;
            this.f29932b = f5;
            this.f29933c = f5;
            float f18 = (f5 - f2) / f4;
            this.f29934d = f18;
            float f19 = f5 / f4;
            this.f29936f = f19;
            float f20 = ((f2 + f5) * f18) / 2.0f;
            float f21 = (f19 * f5) / 2.0f;
            this.f29935e = ((f3 - f20) - f21) / f5;
            this.f29937g = f20;
            this.f29938h = f3 - f21;
            this.f29939i = f3;
        }
    }

    private float b(float f2) {
        float f3 = this.f29934d;
        if (f2 <= f3) {
            float f4 = this.f29931a;
            return (f4 * f2) + ((((this.f29932b - f4) * f2) * f2) / (f3 * 2.0f));
        }
        int i2 = this.f29940j;
        if (i2 == 1) {
            return this.f29937g;
        }
        float f5 = f2 - f3;
        float f6 = this.f29935e;
        if (f5 < f6) {
            float f7 = this.f29937g;
            float f8 = this.f29932b;
            return f7 + (f8 * f5) + ((((this.f29933c - f8) * f5) * f5) / (f6 * 2.0f));
        } else if (i2 == 2) {
            return this.f29938h;
        } else {
            float f9 = f5 - f6;
            float f10 = this.f29936f;
            if (f9 >= f10) {
                return this.f29939i;
            }
            float f11 = this.f29938h;
            float f12 = this.f29933c;
            return (f11 + (f12 * f9)) - (((f12 * f9) * f9) / (f10 * 2.0f));
        }
    }

    public float a() {
        return this.f29942l ? -a(this.f29944n) : a(this.f29944n);
    }

    public float a(float f2) {
        float f3 = this.f29934d;
        if (f2 <= f3) {
            float f4 = this.f29931a;
            return f4 + (((this.f29932b - f4) * f2) / f3);
        }
        int i2 = this.f29940j;
        if (i2 == 1) {
            return 0.0f;
        }
        float f5 = f2 - f3;
        float f6 = this.f29935e;
        if (f5 < f6) {
            float f7 = this.f29932b;
            return f7 + (((this.f29933c - f7) * f5) / f6);
        } else if (i2 == 2) {
            return this.f29938h;
        } else {
            float f8 = f5 - f6;
            float f9 = this.f29936f;
            if (f8 >= f9) {
                return this.f29939i;
            }
            float f10 = this.f29933c;
            return f10 - ((f8 * f10) / f9);
        }
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        g gVar;
        this.f29943m = f2;
        boolean z2 = f2 > f3;
        this.f29942l = z2;
        if (z2) {
            f9 = -f4;
            f8 = f2 - f3;
            gVar = this;
        } else {
            f8 = f3 - f2;
            gVar = this;
            f9 = f4;
        }
        gVar.a(f9, f8, f6, f7, f5);
    }

    public float getInterpolation(float f2) {
        float b2 = b(f2);
        this.f29944n = f2;
        return this.f29942l ? this.f29943m - b2 : this.f29943m + b2;
    }
}
