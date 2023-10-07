package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;

class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public PDFView f14575a;

    /* renamed from: b  reason: collision with root package name */
    private ValueAnimator f14576b;

    /* renamed from: c  reason: collision with root package name */
    private OverScroller f14577c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14578d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f14579e = false;

    /* renamed from: com.github.barteksc.pdfviewer.a$a  reason: collision with other inner class name */
    class C0105a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        C0105a() {
        }

        public void onAnimationCancel(Animator animator) {
            a.this.f14575a.d();
            boolean unused = a.this.f14579e = false;
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f14575a.d();
            boolean unused = a.this.f14579e = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f14575a.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), a.this.f14575a.getCurrentYOffset());
            a.this.f14575a.f();
        }
    }

    class b extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        public void onAnimationCancel(Animator animator) {
            a.this.f14575a.d();
            boolean unused = a.this.f14579e = false;
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f14575a.d();
            boolean unused = a.this.f14579e = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f14575a.a(a.this.f14575a.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            a.this.f14575a.f();
        }
    }

    class c implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        private final float f14583b;

        /* renamed from: c  reason: collision with root package name */
        private final float f14584c;

        public c(float f2, float f3) {
            this.f14583b = f2;
            this.f14584c = f3;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            a.this.f14575a.d();
            a.this.e();
            a.this.f14575a.g();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f14575a.a(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.f14583b, this.f14584c));
        }
    }

    public a(PDFView pDFView) {
        this.f14575a = pDFView;
        this.f14577c = new OverScroller(pDFView.getContext());
    }

    /* access modifiers changed from: private */
    public void e() {
        if (this.f14575a.getScrollHandle() != null) {
            this.f14575a.getScrollHandle().b();
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f14577c.computeScrollOffset()) {
            this.f14575a.a((float) this.f14577c.getCurrX(), (float) this.f14577c.getCurrY());
            this.f14575a.f();
        } else if (this.f14578d) {
            this.f14578d = false;
            this.f14575a.d();
            e();
            this.f14575a.g();
        }
    }

    public void a(float f2) {
        if (this.f14575a.m()) {
            b(this.f14575a.getCurrentYOffset(), f2);
        } else {
            a(this.f14575a.getCurrentXOffset(), f2);
        }
        this.f14579e = true;
    }

    public void a(float f2, float f3) {
        b();
        this.f14576b = ValueAnimator.ofFloat(new float[]{f2, f3});
        C0105a aVar = new C0105a();
        this.f14576b.setInterpolator(new DecelerateInterpolator());
        this.f14576b.addUpdateListener(aVar);
        this.f14576b.addListener(aVar);
        this.f14576b.setDuration(400);
        this.f14576b.start();
    }

    public void a(float f2, float f3, float f4, float f5) {
        b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f4, f5});
        this.f14576b = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        c cVar = new c(f2, f3);
        this.f14576b.addUpdateListener(cVar);
        this.f14576b.addListener(cVar);
        this.f14576b.setDuration(400);
        this.f14576b.start();
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        b();
        this.f14578d = true;
        this.f14577c.fling(i2, i3, i4, i5, i6, i7, i8, i9);
    }

    public void b() {
        ValueAnimator valueAnimator = this.f14576b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f14576b = null;
        }
        c();
    }

    public void b(float f2, float f3) {
        b();
        this.f14576b = ValueAnimator.ofFloat(new float[]{f2, f3});
        b bVar = new b();
        this.f14576b.setInterpolator(new DecelerateInterpolator());
        this.f14576b.addUpdateListener(bVar);
        this.f14576b.addListener(bVar);
        this.f14576b.setDuration(400);
        this.f14576b.start();
    }

    public void c() {
        this.f14578d = false;
        this.f14577c.forceFinished(true);
    }

    public boolean d() {
        return this.f14578d || this.f14579e;
    }
}
