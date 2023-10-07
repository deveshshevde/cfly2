package com.facebook.drawee.generic;

import df.c;
import java.util.Arrays;

public class RoundingParams {

    /* renamed from: a  reason: collision with root package name */
    private RoundingMethod f11257a = RoundingMethod.BITMAP_ONLY;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11258b = false;

    /* renamed from: c  reason: collision with root package name */
    private float[] f11259c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f11260d = 0;

    /* renamed from: e  reason: collision with root package name */
    private float f11261e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    private int f11262f = 0;

    /* renamed from: g  reason: collision with root package name */
    private float f11263g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11264h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11265i = false;

    public enum RoundingMethod {
        OVERLAY_COLOR,
        BITMAP_ONLY
    }

    private float[] j() {
        if (this.f11259c == null) {
            this.f11259c = new float[8];
        }
        return this.f11259c;
    }

    public RoundingParams a(float f2) {
        c.a(f2 >= 0.0f, (Object) "the border width cannot be < 0");
        this.f11261e = f2;
        return this;
    }

    public RoundingParams a(float f2, float f3, float f4, float f5) {
        float[] j2 = j();
        j2[1] = f2;
        j2[0] = f2;
        j2[3] = f3;
        j2[2] = f3;
        j2[5] = f4;
        j2[4] = f4;
        j2[7] = f5;
        j2[6] = f5;
        return this;
    }

    public RoundingParams a(int i2) {
        this.f11260d = i2;
        this.f11257a = RoundingMethod.OVERLAY_COLOR;
        return this;
    }

    public RoundingParams a(boolean z2) {
        this.f11258b = z2;
        return this;
    }

    public boolean a() {
        return this.f11258b;
    }

    public RoundingParams b(float f2) {
        c.a(f2 >= 0.0f, (Object) "the padding cannot be < 0");
        this.f11263g = f2;
        return this;
    }

    public RoundingParams b(int i2) {
        this.f11262f = i2;
        return this;
    }

    public float[] b() {
        return this.f11259c;
    }

    public RoundingMethod c() {
        return this.f11257a;
    }

    public int d() {
        return this.f11260d;
    }

    public float e() {
        return this.f11261e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RoundingParams roundingParams = (RoundingParams) obj;
        if (this.f11258b == roundingParams.f11258b && this.f11260d == roundingParams.f11260d && Float.compare(roundingParams.f11261e, this.f11261e) == 0 && this.f11262f == roundingParams.f11262f && Float.compare(roundingParams.f11263g, this.f11263g) == 0 && this.f11257a == roundingParams.f11257a && this.f11264h == roundingParams.f11264h && this.f11265i == roundingParams.f11265i) {
            return Arrays.equals(this.f11259c, roundingParams.f11259c);
        }
        return false;
    }

    public int f() {
        return this.f11262f;
    }

    public float g() {
        return this.f11263g;
    }

    public boolean h() {
        return this.f11264h;
    }

    public int hashCode() {
        RoundingMethod roundingMethod = this.f11257a;
        int i2 = 0;
        int hashCode = (((roundingMethod != null ? roundingMethod.hashCode() : 0) * 31) + (this.f11258b ? 1 : 0)) * 31;
        float[] fArr = this.f11259c;
        int hashCode2 = (((hashCode + (fArr != null ? Arrays.hashCode(fArr) : 0)) * 31) + this.f11260d) * 31;
        float f2 = this.f11261e;
        int floatToIntBits = (((hashCode2 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + this.f11262f) * 31;
        float f3 = this.f11263g;
        if (f3 != 0.0f) {
            i2 = Float.floatToIntBits(f3);
        }
        return ((((floatToIntBits + i2) * 31) + (this.f11264h ? 1 : 0)) * 31) + (this.f11265i ? 1 : 0);
    }

    public boolean i() {
        return this.f11265i;
    }
}
