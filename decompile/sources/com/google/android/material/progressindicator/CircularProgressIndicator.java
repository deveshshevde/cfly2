package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R;

public final class CircularProgressIndicator extends BaseProgressIndicator<CircularProgressIndicatorSpec> {

    /* renamed from: d  reason: collision with root package name */
    public static final int f19435d = R.style.Widget_MaterialComponents_CircularProgressIndicator;

    public CircularProgressIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, f19435d);
        c();
    }

    private void c() {
        setIndeterminateDrawable(i.a(getContext(), (CircularProgressIndicatorSpec) this.f19417b));
        setProgressDrawable(e.a(getContext(), (CircularProgressIndicatorSpec) this.f19417b));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public CircularProgressIndicatorSpec a(Context context, AttributeSet attributeSet) {
        return new CircularProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndicatorDirection() {
        return ((CircularProgressIndicatorSpec) this.f19417b).f19438i;
    }

    public int getIndicatorInset() {
        return ((CircularProgressIndicatorSpec) this.f19417b).f19437h;
    }

    public int getIndicatorSize() {
        return ((CircularProgressIndicatorSpec) this.f19417b).f19436g;
    }

    public void setIndicatorDirection(int i2) {
        ((CircularProgressIndicatorSpec) this.f19417b).f19438i = i2;
        invalidate();
    }

    public void setIndicatorInset(int i2) {
        if (((CircularProgressIndicatorSpec) this.f19417b).f19437h != i2) {
            ((CircularProgressIndicatorSpec) this.f19417b).f19437h = i2;
            invalidate();
        }
    }

    public void setIndicatorSize(int i2) {
        int max = Math.max(i2, getTrackThickness() * 2);
        if (((CircularProgressIndicatorSpec) this.f19417b).f19436g != max) {
            ((CircularProgressIndicatorSpec) this.f19417b).f19436g = max;
            ((CircularProgressIndicatorSpec) this.f19417b).c();
            invalidate();
        }
    }

    public void setTrackThickness(int i2) {
        super.setTrackThickness(i2);
        ((CircularProgressIndicatorSpec) this.f19417b).c();
    }
}
