package com.google.android.material.progressindicator;

import aj.b;
import aj.d;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.material.R;
import gn.a;
import java.util.Arrays;

final class l extends h<ObjectAnimator> {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f19510e = {533, 567, 850, 750};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f19511f = {1267, 1000, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 0};

    /* renamed from: n  reason: collision with root package name */
    private static final Property<l, Float> f19512n = new Property<l, Float>(Float.class, "animationFraction") {
        /* renamed from: a */
        public Float get(l lVar) {
            return Float.valueOf(lVar.i());
        }

        /* renamed from: a */
        public void set(l lVar, Float f2) {
            lVar.a(f2.floatValue());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    b.a f19513a = null;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ObjectAnimator f19514g;

    /* renamed from: h  reason: collision with root package name */
    private final Interpolator[] f19515h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final b f19516i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f19517j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f19518k;

    /* renamed from: l  reason: collision with root package name */
    private float f19519l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f19520m;

    public l(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f19516i = linearProgressIndicatorSpec;
        this.f19515h = new Interpolator[]{d.a(context, R.animator.linear_indeterminate_line1_head_interpolator), d.a(context, R.animator.linear_indeterminate_line1_tail_interpolator), d.a(context, R.animator.linear_indeterminate_line2_head_interpolator), d.a(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    private void a(int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.f19495c[i3] = Math.max(0.0f, Math.min(1.0f, this.f19515h[i3].getInterpolation(a(i2, f19511f[i3], f19510e[i3]))));
        }
    }

    private void g() {
        if (this.f19514g == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f19512n, new float[]{0.0f, 1.0f});
            this.f19514g = ofFloat;
            ofFloat.setDuration(1800);
            this.f19514g.setInterpolator((TimeInterpolator) null);
            this.f19514g.setRepeatCount(-1);
            this.f19514g.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (l.this.f19520m) {
                        l.this.f19514g.setRepeatCount(-1);
                        l.this.f19513a.b(l.this.f19494b);
                        boolean unused = l.this.f19520m = false;
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    l lVar = l.this;
                    int unused = lVar.f19517j = (lVar.f19517j + 1) % l.this.f19516i.f19446c.length;
                    boolean unused2 = l.this.f19518k = true;
                }
            });
        }
    }

    private void h() {
        if (this.f19518k) {
            Arrays.fill(this.f19496d, a.b(this.f19516i.f19446c[this.f19517j], this.f19494b.getAlpha()));
            this.f19518k = false;
        }
    }

    /* access modifiers changed from: private */
    public float i() {
        return this.f19519l;
    }

    public void a() {
        g();
        f();
        this.f19514g.start();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.f19519l = f2;
        a((int) (f2 * 1800.0f));
        h();
        this.f19494b.invalidateSelf();
    }

    public void a(b.a aVar) {
        this.f19513a = aVar;
    }

    public void b() {
        ObjectAnimator objectAnimator = this.f19514g;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        if (this.f19494b.isVisible()) {
            this.f19520m = true;
            this.f19514g.setRepeatCount(0);
            return;
        }
        b();
    }

    public void d() {
        f();
    }

    public void e() {
        this.f19513a = null;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        this.f19517j = 0;
        int b2 = a.b(this.f19516i.f19446c[0], this.f19494b.getAlpha());
        this.f19496d[0] = b2;
        this.f19496d[1] = b2;
    }
}
