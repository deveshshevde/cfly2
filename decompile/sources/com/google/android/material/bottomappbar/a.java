package com.google.android.material.bottomappbar;

import gw.f;
import gw.o;

public class a extends f implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private float f18594a;

    /* renamed from: b  reason: collision with root package name */
    private float f18595b;

    /* renamed from: c  reason: collision with root package name */
    private float f18596c;

    /* renamed from: d  reason: collision with root package name */
    private float f18597d;

    /* renamed from: e  reason: collision with root package name */
    private float f18598e;

    /* renamed from: f  reason: collision with root package name */
    private float f18599f = -1.0f;

    public a(float f2, float f3, float f4) {
        this.f18595b = f2;
        this.f18594a = f3;
        c(f4);
        this.f18598e = 0.0f;
    }

    public float a() {
        return this.f18596c;
    }

    public void a(float f2) {
        this.f18596c = f2;
    }

    public void a(float f2, float f3, float f4, o oVar) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13 = f2;
        o oVar2 = oVar;
        float f14 = this.f18596c;
        if (f14 == 0.0f) {
            oVar2.b(f13, 0.0f);
            return;
        }
        float f15 = ((this.f18595b * 2.0f) + f14) / 2.0f;
        float f16 = f4 * this.f18594a;
        float f17 = f3 + this.f18598e;
        float f18 = (this.f18597d * f4) + ((1.0f - f4) * f15);
        if (f18 / f15 >= 1.0f) {
            oVar2.b(f13, 0.0f);
            return;
        }
        float f19 = this.f18599f;
        float f20 = f19 * f4;
        boolean z2 = f19 == -1.0f || Math.abs((f19 * 2.0f) - f14) < 0.1f;
        if (!z2) {
            f6 = 1.75f;
            f5 = 0.0f;
        } else {
            f5 = f18;
            f6 = 0.0f;
        }
        float f21 = f15 + f16;
        float f22 = f5 + f16;
        float sqrt = (float) Math.sqrt((double) ((f21 * f21) - (f22 * f22)));
        float f23 = f17 - sqrt;
        float f24 = f17 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f22)));
        float f25 = (90.0f - degrees) + f6;
        oVar2.b(f23, 0.0f);
        float f26 = f16 * 2.0f;
        float f27 = degrees;
        oVar.a(f23 - f16, 0.0f, f23 + f16, f26, 270.0f, degrees);
        if (z2) {
            f12 = f17 - f15;
            f11 = (-f15) - f5;
            f10 = f17 + f15;
            f9 = f15 - f5;
            f8 = 180.0f - f25;
            f7 = (f25 * 2.0f) - 180.0f;
        } else {
            float f28 = this.f18595b;
            float f29 = f20 * 2.0f;
            float f30 = f17 - f15;
            oVar.a(f30, -(f20 + f28), f30 + f28 + f29, f28 + f20, 180.0f - f25, ((f25 * 2.0f) - 180.0f) / 2.0f);
            f10 = f17 + f15;
            float f31 = this.f18595b;
            oVar2.b(f10 - ((f31 / 2.0f) + f20), f31 + f20);
            float f32 = this.f18595b;
            f12 = f10 - (f29 + f32);
            f11 = -(f20 + f32);
            f9 = f32 + f20;
            f8 = 90.0f;
            f7 = f25 - 0.049804688f;
        }
        oVar.a(f12, f11, f10, f9, f8, f7);
        oVar.a(f24 - f16, 0.0f, f24 + f16, f26, 270.0f - f27, f27);
        oVar2.b(f13, 0.0f);
    }

    public float b() {
        return this.f18598e;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        this.f18598e = f2;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f18597d;
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        if (f2 >= 0.0f) {
            this.f18597d = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f18595b;
    }

    /* access modifiers changed from: package-private */
    public void d(float f2) {
        this.f18595b = f2;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        return this.f18594a;
    }

    /* access modifiers changed from: package-private */
    public void e(float f2) {
        this.f18594a = f2;
    }

    public float f() {
        return this.f18599f;
    }

    public void f(float f2) {
        this.f18599f = f2;
    }
}
