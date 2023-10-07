package com.transitionseverywhere.utils;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import java.lang.ref.WeakReference;

public abstract class b extends ValueAnimator implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f21947a;

    /* renamed from: b  reason: collision with root package name */
    private final g f21948b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f21949c = new PointF();

    protected b(Object obj, g gVar) {
        this.f21947a = new WeakReference(obj);
        this.f21948b = gVar;
        setFloatValues(new float[]{0.0f, 1.0f});
        addUpdateListener(this);
    }

    /* access modifiers changed from: protected */
    public abstract void a(PointF pointF, float f2);

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        Object obj = this.f21947a.get();
        if (obj == null) {
            cancel();
            return;
        }
        a(this.f21949c, valueAnimator.getAnimatedFraction());
        this.f21948b.set(obj, this.f21949c);
    }
}
