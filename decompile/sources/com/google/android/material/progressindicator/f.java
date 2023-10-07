package com.google.android.material.progressindicator;

import aj.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import gl.a;
import java.util.ArrayList;
import java.util.List;

abstract class f extends Drawable implements b {

    /* renamed from: o  reason: collision with root package name */
    private static final Property<f, Float> f19475o = new Property<f, Float>(Float.class, "growFraction") {
        /* renamed from: a */
        public Float get(f fVar) {
            return Float.valueOf(fVar.e());
        }

        /* renamed from: a */
        public void set(f fVar, Float f2) {
            fVar.b(f2.floatValue());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final Context f19476a;

    /* renamed from: b  reason: collision with root package name */
    final b f19477b;

    /* renamed from: c  reason: collision with root package name */
    a f19478c;

    /* renamed from: d  reason: collision with root package name */
    final Paint f19479d = new Paint();

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f19480e;

    /* renamed from: f  reason: collision with root package name */
    private ValueAnimator f19481f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19482g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19483h;

    /* renamed from: i  reason: collision with root package name */
    private float f19484i;

    /* renamed from: j  reason: collision with root package name */
    private List<b.a> f19485j;

    /* renamed from: k  reason: collision with root package name */
    private b.a f19486k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f19487l;

    /* renamed from: m  reason: collision with root package name */
    private float f19488m;

    /* renamed from: n  reason: collision with root package name */
    private int f19489n;

    f(Context context, b bVar) {
        this.f19476a = context;
        this.f19477b = bVar;
        this.f19478c = new a();
        setAlpha(255);
    }

    private void a() {
        if (this.f19480e == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f19475o, new float[]{0.0f, 1.0f});
            this.f19480e = ofFloat;
            ofFloat.setDuration(500);
            this.f19480e.setInterpolator(a.f28536b);
            a(this.f19480e);
        }
        if (this.f19481f == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f19475o, new float[]{1.0f, 0.0f});
            this.f19481f = ofFloat2;
            ofFloat2.setDuration(500);
            this.f19481f.setInterpolator(a.f28536b);
            b(this.f19481f);
        }
    }

    private void a(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f19480e;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.f19480e = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    f.this.f();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    private void a(ValueAnimator... valueAnimatorArr) {
        boolean z2 = this.f19487l;
        this.f19487l = true;
        for (ValueAnimator end : valueAnimatorArr) {
            end.end();
        }
        this.f19487l = z2;
    }

    private void b(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f19481f;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            this.f19481f = valueAnimator;
            valueAnimator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    boolean unused = f.super.setVisible(false, false);
                    f.this.g();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    /* access modifiers changed from: private */
    public void f() {
        b.a aVar = this.f19486k;
        if (aVar != null) {
            aVar.a(this);
        }
        List<b.a> list = this.f19485j;
        if (list != null && !this.f19487l) {
            for (b.a a2 : list) {
                a2.a(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        b.a aVar = this.f19486k;
        if (aVar != null) {
            aVar.b(this);
        }
        List<b.a> list = this.f19485j;
        if (list != null && !this.f19487l) {
            for (b.a b2 : list) {
                b2.b(this);
            }
        }
    }

    public boolean a(b.a aVar) {
        List<b.a> list = this.f19485j;
        if (list == null || !list.contains(aVar)) {
            return false;
        }
        this.f19485j.remove(aVar);
        if (!this.f19485j.isEmpty()) {
            return true;
        }
        this.f19485j = null;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z2, boolean z3, boolean z4) {
        a();
        if (!isVisible() && !z2) {
            return false;
        }
        ValueAnimator valueAnimator = z2 ? this.f19480e : this.f19481f;
        if (!z4) {
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                a(valueAnimator);
            }
            return super.setVisible(z2, false);
        } else if (z4 && valueAnimator.isRunning()) {
            return false;
        } else {
            boolean z5 = !z2 || super.setVisible(z2, false);
            if (!(z2 ? this.f19477b.a() : this.f19477b.b())) {
                a(valueAnimator);
                return z5;
            }
            if (z3 || Build.VERSION.SDK_INT < 19 || !valueAnimator.isPaused()) {
                valueAnimator.start();
            } else {
                valueAnimator.resume();
            }
            return z5;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        if (this.f19488m != f2) {
            this.f19488m = f2;
            invalidateSelf();
        }
    }

    public void b(b.a aVar) {
        if (this.f19485j == null) {
            this.f19485j = new ArrayList();
        }
        if (!this.f19485j.contains(aVar)) {
            this.f19485j.add(aVar);
        }
    }

    public boolean b() {
        return b(false, false, false);
    }

    public boolean b(boolean z2, boolean z3, boolean z4) {
        return a(z2, z3, z4 && this.f19478c.a(this.f19476a.getContentResolver()) > 0.0f);
    }

    public boolean c() {
        ValueAnimator valueAnimator = this.f19481f;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f19483h;
    }

    public boolean d() {
        ValueAnimator valueAnimator = this.f19480e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f19482g;
    }

    /* access modifiers changed from: package-private */
    public float e() {
        if (this.f19477b.a() || this.f19477b.b()) {
            return (this.f19483h || this.f19482g) ? this.f19484i : this.f19488m;
        }
        return 1.0f;
    }

    public int getAlpha() {
        return this.f19489n;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return d() || c();
    }

    public void setAlpha(int i2) {
        this.f19489n = i2;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f19479d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean setVisible(boolean z2, boolean z3) {
        return b(z2, z3, true);
    }

    public void start() {
        a(true, true, false);
    }

    public void stop() {
        a(false, true, false);
    }
}
