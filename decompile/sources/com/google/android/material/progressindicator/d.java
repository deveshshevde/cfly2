package com.google.android.material.progressindicator;

import aj.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import gl.c;
import gn.a;

final class d extends h<ObjectAnimator> {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f19454e = {0, 1350, 2700, 4050};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f19455f = {667, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_MARK, 3367, 4717};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f19456g = {1000, 2350, 3700, 5050};

    /* renamed from: o  reason: collision with root package name */
    private static final Property<d, Float> f19457o = new Property<d, Float>(Float.class, "animationFraction") {
        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.h());
        }

        /* renamed from: a */
        public void set(d dVar, Float f2) {
            dVar.a(f2.floatValue());
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private static final Property<d, Float> f19458p = new Property<d, Float>(Float.class, "completeEndFraction") {
        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.i());
        }

        /* renamed from: a */
        public void set(d dVar, Float f2) {
            dVar.b(f2.floatValue());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    b.a f19459a = null;

    /* renamed from: h  reason: collision with root package name */
    private ObjectAnimator f19460h;

    /* renamed from: i  reason: collision with root package name */
    private ObjectAnimator f19461i;

    /* renamed from: j  reason: collision with root package name */
    private final aa.b f19462j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final b f19463k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f19464l = 0;

    /* renamed from: m  reason: collision with root package name */
    private float f19465m;

    /* renamed from: n  reason: collision with root package name */
    private float f19466n;

    public d(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f19463k = circularProgressIndicatorSpec;
        this.f19462j = new aa.b();
    }

    private void a(int i2) {
        this.f19495c[0] = (this.f19465m * 1520.0f) - 0.21875f;
        this.f19495c[1] = this.f19465m * 1520.0f;
        for (int i3 = 0; i3 < 4; i3++) {
            float a2 = a(i2, f19454e[i3], 667);
            float[] fArr = this.f19495c;
            fArr[1] = fArr[1] + (this.f19462j.getInterpolation(a2) * 250.0f);
            float a3 = a(i2, f19455f[i3], 667);
            float[] fArr2 = this.f19495c;
            fArr2[0] = fArr2[0] + (this.f19462j.getInterpolation(a3) * 250.0f);
        }
        float[] fArr3 = this.f19495c;
        fArr3[0] = fArr3[0] + ((this.f19495c[1] - this.f19495c[0]) * this.f19466n);
        float[] fArr4 = this.f19495c;
        fArr4[0] = fArr4[0] / 360.0f;
        float[] fArr5 = this.f19495c;
        fArr5[1] = fArr5[1] / 360.0f;
    }

    /* access modifiers changed from: private */
    public void b(float f2) {
        this.f19466n = f2;
    }

    private void b(int i2) {
        int i3 = 0;
        while (i3 < 4) {
            float a2 = a(i2, f19456g[i3], AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID);
            if (a2 < 0.0f || a2 > 1.0f) {
                i3++;
            } else {
                int length = (i3 + this.f19464l) % this.f19463k.f19446c.length;
                int length2 = (length + 1) % this.f19463k.f19446c.length;
                int b2 = a.b(this.f19463k.f19446c[length], this.f19494b.getAlpha());
                int b3 = a.b(this.f19463k.f19446c[length2], this.f19494b.getAlpha());
                this.f19496d[0] = c.a().evaluate(this.f19462j.getInterpolation(a2), Integer.valueOf(b2), Integer.valueOf(b3)).intValue();
                return;
            }
        }
    }

    private void g() {
        if (this.f19460h == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f19457o, new float[]{0.0f, 1.0f});
            this.f19460h = ofFloat;
            ofFloat.setDuration(5400);
            this.f19460h.setInterpolator((TimeInterpolator) null);
            this.f19460h.setRepeatCount(-1);
            this.f19460h.addListener(new AnimatorListenerAdapter() {
                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    d dVar = d.this;
                    int unused = dVar.f19464l = (dVar.f19464l + 4) % d.this.f19463k.f19446c.length;
                }
            });
        }
        if (this.f19461i == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f19458p, new float[]{0.0f, 1.0f});
            this.f19461i = ofFloat2;
            ofFloat2.setDuration(333);
            this.f19461i.setInterpolator(this.f19462j);
            this.f19461i.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    d.this.b();
                    d.this.f19459a.b(d.this.f19494b);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public float h() {
        return this.f19465m;
    }

    /* access modifiers changed from: private */
    public float i() {
        return this.f19466n;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        g();
        f();
        this.f19460h.start();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.f19465m = f2;
        int i2 = (int) (f2 * 5400.0f);
        a(i2);
        b(i2);
        this.f19494b.invalidateSelf();
    }

    public void a(b.a aVar) {
        this.f19459a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        ObjectAnimator objectAnimator = this.f19460h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!this.f19461i.isRunning()) {
            if (this.f19494b.isVisible()) {
                this.f19461i.start();
            } else {
                b();
            }
        }
    }

    public void d() {
        f();
    }

    public void e() {
        this.f19459a = null;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f19464l = 0;
        this.f19496d[0] = a.b(this.f19463k.f19446c[0], this.f19494b.getAlpha());
        this.f19466n = 0.0f;
    }
}
