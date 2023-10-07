package com.transitionseverywhere;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;

public class ArcMotion extends PathMotion {

    /* renamed from: b  reason: collision with root package name */
    private static final float f21764b = ((float) Math.tan(Math.toRadians(35.0d)));

    /* renamed from: c  reason: collision with root package name */
    private float f21765c = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f21766d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f21767e = 70.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f21768f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f21769g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f21770h = f21764b;

    public ArcMotion() {
    }

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcMotion);
        b(obtainStyledAttributes.getFloat(R.styleable.ArcMotion_minimumVerticalAngle, 0.0f));
        a(obtainStyledAttributes.getFloat(R.styleable.ArcMotion_minimumHorizontalAngle, 0.0f));
        c(obtainStyledAttributes.getFloat(R.styleable.ArcMotion_maximumAngle, 70.0f));
        obtainStyledAttributes.recycle();
    }

    private static float d(float f2) {
        if (f2 >= 0.0f && f2 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f2 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public Path a(float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11 = f2;
        float f12 = f3;
        Path path = new Path();
        path.moveTo(f11, f12);
        if (f12 == f5) {
            f7 = (f11 + f4) / 2.0f;
            f6 = ((this.f21768f * Math.abs(f4 - f11)) / 2.0f) + f12;
        } else if (f11 == f4) {
            f7 = ((this.f21769g * Math.abs(f5 - f12)) / 2.0f) + f11;
            f6 = (f12 + f5) / 2.0f;
        } else {
            float f13 = f4 - f11;
            float f14 = f5 - f12;
            float f15 = (f13 * f13) + (f14 * f14);
            float f16 = (f11 + f4) / 2.0f;
            float f17 = (f12 + f5) / 2.0f;
            float f18 = 0.25f * f15;
            boolean z2 = f13 * f14 > 0.0f;
            if (Math.abs(f13) < Math.abs(f14)) {
                float f19 = f15 / (f14 * 2.0f);
                if (z2) {
                    f10 = f12 + f19;
                    f9 = f11;
                } else {
                    f10 = f5 - f19;
                    f9 = f4;
                }
                float f20 = this.f21769g;
                f8 = f18 * f20 * f20;
                float f21 = f9;
                f6 = f10;
                f7 = f21;
            } else {
                float f22 = f15 / (f13 * 2.0f);
                if (z2) {
                    f7 = f4 - f22;
                    f6 = f5;
                } else {
                    f7 = f11 + f22;
                    f6 = f12;
                }
                float f23 = this.f21768f;
                f8 = f18 * f23 * f23;
            }
            float f24 = f16 - f7;
            float f25 = f17 - f6;
            float f26 = (f24 * f24) + (f25 * f25);
            float f27 = this.f21770h;
            float f28 = f18 * f27 * f27;
            if (f26 >= f8) {
                f8 = f26 > f28 ? f28 : 0.0f;
            }
            if (f8 != 0.0f) {
                float sqrt = (float) Math.sqrt((double) (f8 / f26));
                f7 = ((f7 - f16) * sqrt) + f16;
                f6 = f17 + (sqrt * (f6 - f17));
            }
        }
        path.cubicTo((f11 + f7) / 2.0f, (f12 + f6) / 2.0f, (f7 + f4) / 2.0f, (f6 + f5) / 2.0f, f4, f5);
        return path;
    }

    public void a(float f2) {
        this.f21765c = f2;
        this.f21768f = d(f2);
    }

    public void b(float f2) {
        this.f21766d = f2;
        this.f21769g = d(f2);
    }

    public void c(float f2) {
        this.f21767e = f2;
        this.f21770h = d(f2);
    }
}
