package com.google.android.material.progressindicator;

import aa.b;
import aj.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import gn.a;
import java.util.Arrays;

final class k extends h<ObjectAnimator> {

    /* renamed from: j  reason: collision with root package name */
    private static final Property<k, Float> f19502j = new Property<k, Float>(Float.class, "animationFraction") {
        /* renamed from: a */
        public Float get(k kVar) {
            return Float.valueOf(kVar.i());
        }

        /* renamed from: a */
        public void set(k kVar, Float f2) {
            kVar.a(f2.floatValue());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private ObjectAnimator f19503a;

    /* renamed from: e  reason: collision with root package name */
    private b f19504e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final b f19505f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f19506g = 1;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f19507h;

    /* renamed from: i  reason: collision with root package name */
    private float f19508i;

    public k(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f19505f = linearProgressIndicatorSpec;
        this.f19504e = new b();
    }

    private void a(int i2) {
        this.f19495c[0] = 0.0f;
        float a2 = a(i2, 0, 667);
        float[] fArr = this.f19495c;
        float[] fArr2 = this.f19495c;
        float interpolation = this.f19504e.getInterpolation(a2);
        fArr2[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr3 = this.f19495c;
        float[] fArr4 = this.f19495c;
        float interpolation2 = this.f19504e.getInterpolation(a2 + 0.49925038f);
        fArr4[4] = interpolation2;
        fArr3[3] = interpolation2;
        this.f19495c[5] = 1.0f;
    }

    private void g() {
        if (this.f19503a == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f19502j, new float[]{0.0f, 1.0f});
            this.f19503a = ofFloat;
            ofFloat.setDuration(333);
            this.f19503a.setInterpolator((TimeInterpolator) null);
            this.f19503a.setRepeatCount(-1);
            this.f19503a.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    k kVar = k.this;
                    int unused = kVar.f19506g = (kVar.f19506g + 1) % k.this.f19505f.f19446c.length;
                    boolean unused2 = k.this.f19507h = true;
                }
            });
        }
    }

    private void h() {
        if (this.f19507h && this.f19495c[3] < 1.0f) {
            this.f19496d[2] = this.f19496d[1];
            this.f19496d[1] = this.f19496d[0];
            this.f19496d[0] = a.b(this.f19505f.f19446c[this.f19506g], this.f19494b.getAlpha());
            this.f19507h = false;
        }
    }

    /* access modifiers changed from: private */
    public float i() {
        return this.f19508i;
    }

    public void a() {
        g();
        f();
        this.f19503a.start();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.f19508i = f2;
        a((int) (f2 * 333.0f));
        h();
        this.f19494b.invalidateSelf();
    }

    public void a(b.a aVar) {
    }

    public void b() {
        ObjectAnimator objectAnimator = this.f19503a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
    }

    public void d() {
        f();
    }

    public void e() {
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f19507h = true;
        this.f19506g = 1;
        Arrays.fill(this.f19496d, a.b(this.f19505f.f19446c[0], this.f19494b.getAlpha()));
    }
}
